package org.yitzi.video.api.apivideo.infrastructure.unirest.analytics;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.analytics.PlayerSessionEvent;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class SessionEventJsonSerializer implements JsonDeserializer<PlayerSessionEvent> {
    public PlayerSessionEvent deserialize(JSONObject data) throws JSONException {
        return new PlayerSessionEvent(
                data.getString("type"),
                deserializeDateTime(data.getString("emittedAt")),
                data.has("at") ? data.getInt("at") : null,
                data.has("from") ? data.getInt("from") : null,
                data.has("to") ? data.getInt("to") : null
        );
    }
}
