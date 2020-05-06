package org.yitzi.video.api.apivideo.domain.exception;

import kong.unirest.JsonNode;

public class ClientException extends ResponseException {

    public ClientException(String message, JsonNode responseBody, int status) {
        super(message, responseBody, status);
    }
}
