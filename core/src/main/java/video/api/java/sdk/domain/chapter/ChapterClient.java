package video.api.java.sdk.domain.chapter;

import video.api.java.sdk.domain.exception.ResponseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ChapterClient {
    Chapter get(String language) throws ResponseException;

    Iterable<Chapter> list() throws ResponseException;

    Chapter upload(String language, File file) throws ResponseException, IOException;

    void delete(String language) throws ResponseException;
}
