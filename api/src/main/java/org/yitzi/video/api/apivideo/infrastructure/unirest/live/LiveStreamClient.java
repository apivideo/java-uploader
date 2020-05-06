package org.yitzi.video.api.apivideo.infrastructure.unirest.live;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.QueryParams;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.live.LiveStream;
import org.yitzi.video.api.apivideo.domain.live.LiveStreamInput;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.infrastructure.pagination.IteratorIterable;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageIterator;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.pagination.UriPageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

import java.io.File;
import java.io.IOException;

import static kong.unirest.HttpMethod.*;

public class LiveStreamClient implements org.yitzi.video.api.apivideo.domain.live.LiveStreamClient {

    private final RequestBuilderFactory           requestBuilderFactory;
    private final JsonSerializer<LiveStreamInput> serializer;
    private final JsonDeserializer<LiveStream>    deserializer;
    private final RequestExecutor                 requestExecutor;

    public LiveStreamClient(RequestBuilderFactory requestBuilderFactory, JsonSerializer<LiveStreamInput> serializer, JsonDeserializer<LiveStream> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.serializer            = serializer;
        this.deserializer          = deserializer;
        this.requestExecutor       = requestExecutor;
    }

    public LiveStream get(String liveStreamId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(GET, "/live-streams/" + liveStreamId);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public LiveStream create(LiveStreamInput liveStreamInput) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/live-streams")
                .withJson(serializer.serialize(liveStreamInput));

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public LiveStream uploadThumbnail(String liveStreamId, File file) throws ResponseException, IOException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/live-streams/" + liveStreamId + "/thumbnail")
                .withFile(file);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public LiveStream update(LiveStream liveStream) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(PATCH, "/live-streams/" + liveStream.liveStreamId)
                .withJson(serializer.serialize(liveStream));

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public void delete(String liveStreamId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(DELETE, "/live-streams/" + liveStreamId);

        requestExecutor.executeJson(request);
    }

    public Iterable<LiveStream> list() throws ResponseException, IllegalArgumentException {
        return list(new QueryParams());
    }

    public Iterable<LiveStream> list(QueryParams queryParams) throws ResponseException, IllegalArgumentException {
        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                requestBuilderFactory.create(GET, "/live-streams"),
                requestExecutor,
                deserializer
        ), new PageQuery()));
    }

}

