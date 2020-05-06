package org.yitzi.video.api.apivideo.infrastructure.unirest.caption;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.caption.CaptionInput;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

public class CaptionInputSerializer implements JsonSerializer<CaptionInput> {

    public JSONObject serialize(CaptionInput object) throws JSONException {
        JSONObject data = new JSONObject();

        data.put("default", object.isDefault);

        return data;
    }

}
