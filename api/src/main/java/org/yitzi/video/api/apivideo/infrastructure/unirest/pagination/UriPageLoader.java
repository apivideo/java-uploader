package org.yitzi.video.api.apivideo.infrastructure.unirest.pagination;

import kong.unirest.JsonNode;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.Page;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.pagination.PageLoader;
import org.yitzi.video.api.apivideo.infrastructure.unirest.RequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilder;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class UriPageLoader<T> implements PageLoader<T> {
    private final RequestBuilder      requestBuilder;
    private final RequestExecutor     requestExecutor;
    private final JsonDeserializer<T> deserializer;

    public UriPageLoader(RequestBuilder requestBuilder, RequestExecutor requestExecutor, JsonDeserializer<T> deserializer) {
        this.requestBuilder  = requestBuilder;
        this.requestExecutor = requestExecutor;
        this.deserializer    = deserializer;
    }

    @Override
    public Page<T> load(PageQuery pageQuery) throws ResponseException {
        RequestBuilder request = requestBuilder
                .withQueryParams(pageQuery.toMap());

        JsonNode responseBody = requestExecutor.executeJson(request);

        return new PageDeserializer<>(deserializer).deserialize(responseBody.getObject());
    }
}
