package video.api.java.sdk.domain.analytics;

import video.api.java.sdk.domain.QueryParams;
import video.api.java.sdk.domain.exception.ResponseException;


public interface VideoSessionClient {
    Iterable<PlayerSession> list(String videoId) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String videoId, String period) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String videoId, String period, QueryParams queryParams) throws ResponseException, IllegalArgumentException;
}
