package org.yitzi.video.api.apivideo.domain.analytics;

import org.yitzi.video.api.apivideo.domain.QueryParams;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;


public interface VideoSessionClient {
    Iterable<PlayerSession> list(String videoId) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String videoId, String period) throws ResponseException, IllegalArgumentException;

    Iterable<PlayerSession> list(String videoId, String period, QueryParams queryParams) throws ResponseException, IllegalArgumentException;
}
