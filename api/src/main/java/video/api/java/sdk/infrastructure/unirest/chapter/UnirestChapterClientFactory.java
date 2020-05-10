package video.api.java.sdk.infrastructure.unirest.chapter;

import video.api.java.sdk.domain.chapter.Chapter;
import video.api.java.sdk.domain.chapter.ChapterClient;
import video.api.java.sdk.infrastructure.unirest.RequestExecutor;
import video.api.java.sdk.infrastructure.unirest.request.RequestBuilderFactory;
import video.api.java.sdk.infrastructure.unirest.serializer.JsonDeserializer;

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
