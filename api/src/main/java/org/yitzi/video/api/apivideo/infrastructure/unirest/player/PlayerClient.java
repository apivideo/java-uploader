package org.yitzi.video.api.apivideo.infrastructure.unirest.player;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.*;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.domain.player.Player;
import org.yitzi.video.api.apivideo.domain.player.PlayerInput;
import org.yitzi.video.api.apivideo.infrastructure.pagination.IteratorIterable;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageIterator;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.pagination.UriPageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonSerializer;

import java.io.File;
import java.io.IOException;

import static kong.unirest.HttpMethod.*;

public class PlayerClient implements org.yitzi.video.api.apivideo.domain.player.PlayerClient {

    private final RequestBuilderFactory requestBuilderFactory;
    private final JsonSerializer<PlayerInput> serializer;
    private final JsonDeserializer<Player> deserializer;
    private final RequestExecutor requestExecutor;

    public PlayerClient(RequestBuilderFactory requestBuilderFactory, JsonSerializer<PlayerInput> serializer, JsonDeserializer<Player> deserializer, RequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.requestExecutor = requestExecutor;
    }

    public Player get(String playerId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(GET, "/players/" + playerId);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public Player create(PlayerInput player) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/players")
                .withJson(serializer.serialize(player));

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public Player update(Player player) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(PATCH, "/players/" + player.playerId)
                .withJson(serializer.serialize(player));

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public Player uploadLogo(String playerId, File file, String link) throws ResponseException, IOException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/players/" + playerId + "/logo")
                .withFile(file, link);

        JsonNode responseBody = requestExecutor.executeJson(request);

        return deserializer.deserialize(responseBody.getObject());
    }

    public void deleteLogo(String playerId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(DELETE, "/players/" + playerId + "/logo");

        requestExecutor.executeJson(request);
    }

    public void delete(String playerId) throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(DELETE, "/players/" + playerId);

        requestExecutor.executeJson(request);
    }

    public Iterable<Player> list() throws ResponseException, IllegalArgumentException {
        return list(new QueryParams());
    }

    public Iterable<Player> list(QueryParams queryParams) throws ResponseException, IllegalArgumentException {
        return new IteratorIterable<>(new PageIterator<>(new UriPageLoader<>(
                requestBuilderFactory.create(GET, "/players"),
                requestExecutor,
                deserializer
        ), new PageQuery()));
    }
}
