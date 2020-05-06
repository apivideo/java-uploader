package org.yitzi.video.api.apivideo.infrastructure.unirest;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;

public interface RequestExecutor {
    JsonNode executeJson(RequestBuilder requestBuilder) throws ResponseException;
}
