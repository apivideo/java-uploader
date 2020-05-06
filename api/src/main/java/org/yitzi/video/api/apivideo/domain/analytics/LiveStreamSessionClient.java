package org.yitzi.video.api.apivideo.domain.analytics;

import org.yitzi.video.api.apivideo.domain.QueryParams;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;


public interface LiveStreamSessionClient {
    Iterable<PlayerSession> list(String liveStreamId) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String liveStreamId, String period) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String liveStreamId, String period, QueryParams queryParams) throws Exception;
}
