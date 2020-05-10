package video.api.java.sdk.domain.caption;

import video.api.java.sdk.domain.exception.ResponseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CaptionClient {

    Caption get(String videoId, String lang) throws ResponseException;

    List<Caption> list(String videoId) throws ResponseException;

    Caption upload(String videoId, File file, String language) throws ResponseException, IOException;

    Caption update(String videoId, CaptionInput captionInput) throws ResponseException;

    void delete(String videoId, String language) throws ResponseException;

}
