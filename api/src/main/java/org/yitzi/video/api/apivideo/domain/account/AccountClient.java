package org.yitzi.video.api.apivideo.domain.account;

import org.yitzi.video.api.apivideo.domain.exception.ResponseException;

public interface AccountClient {
    Account get() throws ResponseException;
}
