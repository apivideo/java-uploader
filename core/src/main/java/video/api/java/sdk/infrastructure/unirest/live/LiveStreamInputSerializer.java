package video.api.java.sdk.infrastructure.unirest.live;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import video.api.java.sdk.domain.asset.Assets;
import video.api.java.sdk.domain.live.LiveStream;
import video.api.java.sdk.domain.live.LiveStreamInput;
import video.api.java.sdk.infrastructure.unirest.serializer.JsonSerializer;

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
