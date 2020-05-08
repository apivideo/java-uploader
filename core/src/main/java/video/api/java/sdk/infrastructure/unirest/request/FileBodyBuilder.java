package video.api.java.sdk.infrastructure.unirest.request;

import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.MultipartBody;
import video.api.java.sdk.domain.video.UploadProgressListener;

import java.io.File;

public class FileBodyBuilder implements BodyBuilder {
    private final File                   file;
    private       String                 link;
    private       UploadProgressListener progressListener;

    public FileBodyBuilder(File file, String link, UploadProgressListener progressListener) {
        this.file             = file;
        this.link             = link;
        this.progressListener = progressListener;
    }

    @Override
    public HttpRequest build(HttpRequestWithBody request) {
        MultipartBody body = request.field("file", file);

        if (progressListener != null) {
            body.uploadMonitor(
                    (field, fileName, bytesWritten, totalBytes) -> progressListener.onProgress(bytesWritten, totalBytes, 1, 0)
            );
        }

        if (link != null) {
            body = body.field("link", link);
        }

        return body;
    }
}
