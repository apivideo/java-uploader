package video.api.java.sdk.domain.analytics;

import video.api.java.sdk.domain.exception.ResponseException;


public interface PlayerSessionEventClient {
    Iterable<PlayerSessionEvent> list(String sessionId) throws ResponseException;
}
