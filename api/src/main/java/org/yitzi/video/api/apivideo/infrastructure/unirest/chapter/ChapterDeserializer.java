package org.yitzi.video.api.apivideo.infrastructure.unirest.chapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.chapter.Chapter;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class ChapterDeserializer implements JsonDeserializer<Chapter> {

    @Override
    public Chapter deserialize(JSONObject data) throws JSONException {
        return new Chapter(
                data.getString("language"),
                data.getString("uri"),
                data.getString("src")
        );
    }
}
