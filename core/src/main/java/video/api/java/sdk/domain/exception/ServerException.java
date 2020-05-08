package video.api.java.sdk.domain.exception;

import kong.unirest.JsonNode;

public class ServerException extends ResponseException {
    public ServerException(String message, JsonNode responseBody, int status) {
        super(message, responseBody, status);
    }
}
