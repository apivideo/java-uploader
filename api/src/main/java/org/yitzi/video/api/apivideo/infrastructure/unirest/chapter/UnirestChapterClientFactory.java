package org.yitzi.video.api.apivideo.infrastructure.unirest.chapter;

import org.yitzi.video.api.apivideo.domain.chapter.Chapter;
import org.yitzi.video.api.apivideo.domain.chapter.ChapterClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class UnirestChapterClientFactory {
    private final RequestBuilderFactory requestBuilderFactory;
    private final JsonDeserializer<Chapter> deserializer;
    private final RequestExecutor requestExecutor;

    public UnirestChapterClientFactory(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<Chapter> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.deserializer = deserializer;
        this.requestExecutor = requestExecutor;
    }

    public ChapterClient create(String videoId) {
        return new UnirestChapterClient(requestBuilderFactory, deserializer, requestExecutor, videoId);
    }

}
