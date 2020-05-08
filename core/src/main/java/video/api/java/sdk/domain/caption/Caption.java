package video.api.java.sdk.domain.caption;

public class Caption extends CaptionInput {
    public final String uri;
    public final String src;

    public Caption(String language, String uri, String src) {
        super(language);
        this.uri = uri;
        this.src = src;
    }
}
