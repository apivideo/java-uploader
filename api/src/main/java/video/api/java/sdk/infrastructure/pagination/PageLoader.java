package video.api.java.sdk.infrastructure.pagination;

import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.domain.pagination.Page;
import video.api.java.sdk.domain.pagination.PageQuery;


public interface PageLoader<T> {
    Page<T> load(PageQuery pageQuery) throws ResponseException;
}
