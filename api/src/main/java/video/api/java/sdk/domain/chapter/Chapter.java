package video.api.java.sdk.domain.chapter;

public class Chapter extends ChapterInput {
    public final String uri;
    public final String src;

    public Chapter(String language, String uri, String src) {
        super(language);
        this.uri = uri;
        this.src = src;
    }
}
