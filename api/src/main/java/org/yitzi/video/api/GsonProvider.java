package org.yitzi.video.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yitzi.video.api.util.UtcDateTypeAdapter;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

    private final String UTF8 = "UTF-8";

    private Gson gson;

    @Override
    public boolean isReadable(
            Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(
            Class<Object> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException, WebApplicationException {

        try (InputStreamReader streamReader = new InputStreamReader(entityStream, UTF8)) {
            Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            }
            else {
                jsonType = genericType;
            }

            return getGson().fromJson(streamReader, jsonType);
        }
    }

    @Override
    public boolean isWriteable(
            Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(
            Object o,
            Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(
            Object o,
            Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException, WebApplicationException {

        try (OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF8)) {
            Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            }
            else {
                jsonType = genericType;
            }

            getGson().toJson(o, jsonType, writer);
        }
    }

    private Gson getGson() {
        if (null == gson) {
            final GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new UtcDateTypeAdapter());
            gson = gsonBuilder.create();
        }

        return gson;
    }
}

