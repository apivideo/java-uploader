package org.yitzi.video.api.apivideo.infrastructure.pagination;

import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.pagination.Page;
import org.yitzi.video.api.apivideo.domain.pagination.PageQuery;


public interface PageLoader<T> {
    Page<T> load(PageQuery pageQuery) throws ResponseException;
}
