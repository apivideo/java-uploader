package org.yitzi.video.api.apivideo.domain.video;

public interface UploadProgressListener {

    void onProgress(Long bytesWritten, Long totalBytes, int chunkCount, int chunkNum);

}
