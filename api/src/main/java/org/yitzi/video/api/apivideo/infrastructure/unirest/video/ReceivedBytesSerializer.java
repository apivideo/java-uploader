package org.yitzi.video.api.apivideo.infrastructure.unirest.video;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.video.ReceivedBytes;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class ReceivedBytesSerializer implements JsonDeserializer<ReceivedBytes> {

    public ReceivedBytes deserialize(JSONObject data) throws JSONException {
        return new ReceivedBytes(
                data.getInt("to"),
                data.getInt("from"),
                data.getInt("total")
        );
    }
}
