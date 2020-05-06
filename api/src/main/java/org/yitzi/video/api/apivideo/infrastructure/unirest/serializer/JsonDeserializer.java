package org.yitzi.video.api.apivideo.infrastructure.unirest.serializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.*;
import java.util.stream.Collectors;

public interface JsonDeserializer<T> {
    T deserialize(JSONObject data) throws JSONException;

    default List<T> deserialize(JSONArray data) throws JSONException {
        List<T> list = new ArrayList<>();

        for (Object item : data) {
            list.add(deserialize((JSONObject) item));
        }

        return list;
    }

    default Map<String, String> convertKeyValueJsonArrayToMap(JSONArray array) {
        Map<String, String> map = new HashMap<>();

        for (Object object : array) {
            JSONObject jsonObject = (JSONObject) object;

            String value;
            try {
                value = jsonObject.getString("value");
            } catch (JSONException e) {
                value = null;
            }

            map.put(jsonObject.getString("key"), value);
        }

        return map;
    }

    default List<String> convertJsonArrayToStringList(JSONArray array) {
        return array.toList()
                .stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
    }

    default Map<String, String> convertJsonMapToStringMap(JSONObject map) {
        return map.toMap().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (String) e.getValue()));
    }

    default Calendar deserializeDateTime(String dateTime) {
        try {
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(dateTime)
                    .toGregorianCalendar();
        } catch (DatatypeConfigurationException e) {
            throw new JSONException(e);
        }
    }
}
