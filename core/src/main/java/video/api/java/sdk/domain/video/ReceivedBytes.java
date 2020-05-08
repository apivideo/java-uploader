package video.api.java.sdk.domain.video;


public class ReceivedBytes {
    public final int to;
    public final int from;
    public final int total;

    public ReceivedBytes(int to, int from, int total) {
        this.to    = to;
        this.from  = from;
        this.total = total;
    }
}
