package org.yitzi.video.api.apivideo.infrastructure.unirest.chapter;

import kong.unirest.HttpMethod;
import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.chapter.Chapter;
import org.yitzi.video.api.apivideo.domain.chapter.ChapterClient;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.infrastructure.pagination.IteratorIterable;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageIterator;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.pagination.UriPageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

import java.io.File;
import java.io.IOException;

import static kong.unirest.HttpMethod.*;

public class UnirestChapterClient implements ChapterClient {

    private final RequestBuilderFactory requestBuilderFactory;
    private final JsonDeserializer<Chapter> deserializer;
    private final RequestExecutor requestExecutor;
    private final String videoId;

    public UnirestChapterClient(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<Chapter> deserializer, RequestExecutor requestExecutor, String videoId) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.deserializer = deserializer;
        this.requestExecutor = requestExecutor;
        this.videoId = videoId;
    }

    @Override
    public Chapter get(String language) throws ResponseException {
        JsonNode response = execute(
                request(GET, "/videos/" + videoId + "/chapters/" + language)
        );

        return deserializer.deserialize(response.getObject());
    }

    @Override
    public Iterable<Chapter> list() throws ResponseException {
        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                request(GET, "/videos/" + videoId + "/chapters"),
                requestExecutor,
                deserializer
        ), new PageQuery()));
    }

    @Override
    public Chapter upload(String language, File file) throws ResponseException, IOException {
        JsonNode response = execute(
                request(POST, "/videos/" + videoId + "/chapters/" + language)
                        .withFile(file)
        );

        return deserializer.deserialize(response.getObject());
    }

    @Override
    public void delete(String language) throws ResponseException {
        execute(
                request(DELETE, "/videos/" + videoId + "/chapters/" + language)
        );
    }

    private RequestBuilder request(HttpMethod method, String relativePath) {
        return requestBuilderFactory.create(method, relativePath);
    }

    private JsonNode execute(RequestBuilder request) throws ResponseException {
        return requestExecutor.executeJson(request);
    }
}
