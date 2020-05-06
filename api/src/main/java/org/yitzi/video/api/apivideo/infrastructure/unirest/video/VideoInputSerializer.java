package org.yitzi.video.api.apivideo.infrastructure.unirest.video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.video.VideoInput;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

public class VideoInputSerializer implements JsonSerializer<VideoInput> {
    @Override
    public JSONObject serialize(VideoInput object) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("description", object.description);
        data.put("isPublic", object.isPublic);
        if (!object.metadata.isEmpty()) {
            data.put("metadata", convertMapToKeyValueJson(object.metadata));
        }
        data.put("playerId", object.playerId);
        data.put("tags", new JSONArray(object.tags));
        data.put("title", object.title);

        return data;
    }
}
