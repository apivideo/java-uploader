package org.yitzi.video.api.apivideo.domain.analytics;

import org.yitzi.video.api.apivideo.domain.exception.ResponseException;


public interface PlayerSessionEventClient {
    Iterable<PlayerSessionEvent> list(String sessionId) throws ResponseException;
}
