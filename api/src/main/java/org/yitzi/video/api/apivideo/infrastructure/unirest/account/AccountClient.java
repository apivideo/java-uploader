package org.yitzi.video.api.apivideo.infrastructure.unirest.account;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.account.Account;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

import static kong.unirest.HttpMethod.GET;

public class AccountClient implements org.yitzi.video.api.apivideo.domain.account.AccountClient {
    private final RequestBuilderFactory     requestBuilderFactory;
    private final JsonDeserializer<Account> deserializer;
    private final RequestExecutor           requestExecutor;

    public AccountClient(RequestBuilderFactory requestBuilderFactory, JsonDeserializer<Account> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.deserializer          = deserializer;
        this.requestExecutor       = requestExecutor;
    }

    public Account get() throws ResponseException {
        JsonNode responseBody = requestExecutor.executeJson(
                requestBuilderFactory.create(GET, "/account")
        );

        return deserializer.deserialize(responseBody.getObject());
    }

}