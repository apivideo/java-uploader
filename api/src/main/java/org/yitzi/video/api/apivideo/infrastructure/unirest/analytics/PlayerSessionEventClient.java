package org.yitzi.video.api.apivideo.infrastructure.unirest.analytics;

import org.yitzi.video.api.apivideo.domain.analytics.PlayerSessionEvent;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.infrastructure.pagination.IteratorIterable;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageIterator;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.pagination.UriPageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

import static kong.unirest.HttpMethod.GET;

public class PlayerSessionEventClient implements org.yitzi.video.api.apivideo.domain.analytics.PlayerSessionEventClient {
    private final RequestBuilderFactory                requestBuilderFactory;
    private final JsonDeserializer<PlayerSessionEvent> deserializer;
    private final RequestExecutor                      requestExecutor;

    public PlayerSessionEventClient(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<PlayerSessionEvent> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.deserializer          = deserializer;
        this.requestExecutor       = requestExecutor;
    }

    public Iterable<PlayerSessionEvent> list(String sessionId) throws ResponseException, IllegalArgumentException {
        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                requestBuilderFactory.create(GET, "/analytics/sessions/" + sessionId + "/events"),
                requestExecutor,
                deserializer
        ), new PageQuery()));
    }
}
