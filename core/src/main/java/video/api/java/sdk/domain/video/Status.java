package video.api.java.sdk.domain.video;

import java.util.List;
import java.util.Map;

public class Status {
    public static class Ingest {
        public final String              status;
        public final int                 filesize;
        public final List<ReceivedBytes> receivedBytes;

        public Ingest(String status, int filesize, List<ReceivedBytes> receivedBytes) {
            this.status        = status;
            this.filesize      = filesize;
            this.receivedBytes = receivedBytes;
        }
    }

    public static class Encoding {
        public final boolean             playable;
        public final List<Object>        qualities;
        public final Map<String, Object> metadata;

        public Encoding(boolean playable, List<Object> qualities, Map<String, Object> metadata) {
            this.playable  = playable;
            this.qualities = qualities;
            this.metadata  = metadata;
        }
    }

    public final Ingest   ingest;
    public final Encoding encoding;

    public Status(Ingest ingest, Encoding encoding) {
        this.ingest   = ingest;
        this.encoding = encoding;
    }
}
