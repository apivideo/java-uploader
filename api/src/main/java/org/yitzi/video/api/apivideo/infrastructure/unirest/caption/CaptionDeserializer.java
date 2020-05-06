package org.yitzi.video.api.apivideo.infrastructure.unirest.caption;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.caption.Caption;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class CaptionDeserializer implements JsonDeserializer<Caption> {

    @Override
    public Caption deserialize(JSONObject data) throws JSONException {
        Caption caption = new Caption(
                data.getString("srclang"),
                data.getString("uri"),
                data.getString("src")
        );

        if (data.has("default")) {
            caption.isDefault = data.getBoolean("default");
        }

        return caption;
    }

    public JSONObject serialize(Caption object) throws JSONException {
        JSONObject data = new JSONObject();

        data.put("default", object.isDefault);

        return data;
    }

}
