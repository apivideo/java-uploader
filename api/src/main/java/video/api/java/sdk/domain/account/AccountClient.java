package video.api.java.sdk.domain.account;

import video.api.java.sdk.domain.exception.ResponseException;

public interface AccountClient {
    Account get() throws ResponseException;
}
