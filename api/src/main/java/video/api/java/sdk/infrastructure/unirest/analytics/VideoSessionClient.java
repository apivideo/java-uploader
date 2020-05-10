package video.api.java.sdk.infrastructure.unirest.analytics;

import video.api.java.sdk.domain.QueryParams;
import video.api.java.sdk.domain.analytics.PlayerSession;
import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.domain.pagination.PageQuery;
import video.api.java.sdk.infrastructure.pagination.IteratorIterable;
import video.api.java.sdk.infrastructure.pagination.PageIterator;
import video.api.java.sdk.infrastructure.unirest.RequestExecutor;
import video.api.java.sdk.infrastructure.unirest.pagination.UriPageLoader;
import video.api.java.sdk.infrastructure.unirest.request.RequestBuilderFactory;
import video.api.java.sdk.infrastructure.unirest.serializer.JsonDeserializer;

import static kong.unirest.HttpMethod.GET;

public class VideoSessionClient implements video.api.java.sdk.domain.analytics.VideoSessionClient {
    private final RequestBuilderFactory           requestBuilderFactory;
    private final JsonDeserializer<PlayerSession> deserializer;
    private final RequestExecutor                 requestExecutor;

    public VideoSessionClient(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<PlayerSession> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.deserializer          = deserializer;
        this.requestExecutor       = requestExecutor;
    }

    public Iterable<PlayerSession> list(String videoId) throws ResponseException, IllegalArgumentException {
        return list(videoId, null, new QueryParams());
    }

    public Iterable<PlayerSession> list(String videoId, String period) throws ResponseException, IllegalArgumentException {
        return list(videoId, period, new QueryParams());
    }

    public Iterable<PlayerSession> list(String videoId, String period, QueryParams queryParams) throws ResponseException, IllegalArgumentException {
        queryParams.period = period;

        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                requestBuilderFactory.create(GET, "/analytics/videos/" + videoId)
                        .withQueryParams(queryParams.toMap()),
                requestExecutor,
                deserializer
        ), new PageQuery()));
    }
}
