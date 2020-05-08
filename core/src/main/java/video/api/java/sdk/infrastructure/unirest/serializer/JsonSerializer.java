package video.api.java.sdk.infrastructure.unirest.serializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public interface JsonSerializer<T> {
    JSONObject serialize(T object) throws JSONException;

    default JSONArray convertMapToKeyValueJson(Map<String, String> map) {
        JSONArray array = new JSONArray();

        for (Map.Entry<String, String> e : map.entrySet()) {
            array.put(
                    new JSONObject()
                            .put("key", e.getKey())
                            .put("value", e.getValue())
            );
        }

        return array;
    }
}
