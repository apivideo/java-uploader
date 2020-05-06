package org.yitzi.video.api.apivideo.infrastructure.unirest.analytics;

import org.yitzi.video.api.apivideo.domain.QueryParams;
import org.yitzi.video.api.apivideo.domain.analytics.PlayerSession;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.infrastructure.pagination.IteratorIterable;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageIterator;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.pagination.UriPageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

import static kong.unirest.HttpMethod.GET;

public class LiveStreamSessionClient implements org.yitzi.video.api.apivideo.domain.analytics.LiveStreamSessionClient {
    private final RequestBuilderFactory           requestBuilderFactory;
    private final JsonDeserializer<PlayerSession> serializer;
    private final RequestExecutor                 requestExecutor;

    public LiveStreamSessionClient(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<PlayerSession> serializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.serializer            = serializer;
        this.requestExecutor       = requestExecutor;
    }

    public Iterable<PlayerSession> list(String videoId) throws ResponseException, IllegalArgumentException {
        return list(videoId, null, new QueryParams());
    }

    public Iterable<PlayerSession> list(String videoId, String period) throws ResponseException, IllegalArgumentException {
        return list(videoId, period, new QueryParams());
    }

    public Iterable<PlayerSession> list(String liveStreamId, String period, QueryParams queryParams) throws ResponseException, IllegalArgumentException {
        queryParams.period = period;

        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                requestBuilderFactory
                        .create(GET, "/analytics/live-streams/" + liveStreamId)
                        .withQueryParams(queryParams.toMap()),
                requestExecutor,
                serializer
        ), new PageQuery()));
    }
}
