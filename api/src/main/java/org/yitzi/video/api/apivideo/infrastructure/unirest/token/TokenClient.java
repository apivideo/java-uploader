package org.yitzi.video.api.apivideo.infrastructure.unirest.token;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.infrastructure.unirest.AuthRequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;

import static kong.unirest.HttpMethod.POST;

public class TokenClient {
    private final RequestBuilderFactory requestBuilderFactory;
    private final AuthRequestExecutor   requestExecutor;

    public TokenClient(RequestBuilderFactory requestBuilderFactory, AuthRequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.requestExecutor       = requestExecutor;
    }

    public String get() throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/tokens");

        JsonNode responseBody = requestExecutor.executeJson(request);

        // TODO use serializer
        return responseBody.getObject().getString("token");
    }
}
