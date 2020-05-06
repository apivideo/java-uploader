package org.yitzi.video.api.apivideo.domain.exception;

import kong.unirest.JsonNode;

public class ServerException extends ResponseException {
    public ServerException(String message, JsonNode responseBody, int status) {
        super(message, responseBody, status);
    }
}
