package org.yitzi.video.api.apivideo.infrastructure.unirest.caption;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.caption.Caption;
import org.yitzi.video.api.apivideo.domain.caption.CaptionInput;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static kong.unirest.HttpMethod.*;

public class CaptionClient implements org.yitzi.video.api.apivideo.domain.caption.CaptionClient {
    private final RequestBuilderFactory        requestBuilderFactory;
    private final JsonSerializer<CaptionInput> serializer;
    private final JsonDeserializer<Caption>    deserializer;
    private final RequestExecutor              requestExecutor;

    public CaptionClient(RequestBuilderFactory requestBuilderFactory, JsonSerializer<CaptionInput> serializer, JsonDeserializer<Caption> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.serializer            = serializer;
        this.deserializer          = deserializer;
        this.requestExecutor       = requestExecutor;
    }

    public Caption get(String videoId, String lang) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(GET, "/videos/" + videoId + "/captions/" + lang);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public List<Caption> list(String videoId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(GET, "/videos/" + videoId + "/captions");

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getArray());
    }

    public Caption upload(String videoId, File file, String language) throws ResponseException, IOException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/videos/" + videoId + "/captions/" + language)
                .withFile(file);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public Caption update(String videoId, CaptionInput captionInput) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(PATCH, "/videos/" + videoId + "/captions/" + captionInput.language)
                .withJson(serializer.serialize(captionInput));

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public void delete(String videoId, String language) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(DELETE, "/videos/" + videoId + "/captions/" + language);

        requestExecutor.executeJson(request);
    }
}
