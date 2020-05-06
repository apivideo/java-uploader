package org.yitzi.video.api.apivideo.infrastructure.unirest.live;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.asset.Assets;
import org.yitzi.video.api.apivideo.domain.live.LiveStream;
import org.yitzi.video.api.apivideo.domain.live.LiveStreamInput;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LiveStreamInputSerializer implements JsonSerializer<LiveStreamInput> {
    @Override
    public JSONObject serialize(LiveStreamInput object) throws JSONException {
        JSONObject data = new JSONObject();
        if (object.name != null) {
            data.put("name", object.name);
        }
        data.put("record", object.record);

        if (object.playerId != null) {
            data.put("playerId", object.playerId);
        }

        return data;
    }
}
