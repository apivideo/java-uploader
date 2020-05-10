package org.yitzi.video.api.util;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.yitzi.video.core.util.DatetimeConverter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

public final class UtcDateTypeAdapter extends TypeAdapter<Date> {

    private final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");

    @Override
    public void write(JsonWriter out, Date date) throws IOException {
        if (date == null) {
            out.nullValue();
        }
        else {
            String value = DatetimeConverter.format(date, true, UTC_TIME_ZONE);
            out.value(value);
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        try {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    // Instead of using iso8601Format.parse(value), we use Jackson's date parsing
                    // This is because Android doesn't support XXX because it is JDK 1.6
                    return DatetimeConverter.parse(date);
            }
        }
        catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}
