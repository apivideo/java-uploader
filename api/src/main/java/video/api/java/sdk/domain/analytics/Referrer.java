package video.api.java.sdk.domain.analytics;

public class Referrer {
    public final String url;
    public final String medium;
    public final String source;
    public final String search_term;

    public Referrer(String url, String medium, String source, String search_term) {
        this.url         = url;
        this.medium      = medium;
        this.source      = source;
        this.search_term = search_term;
    }
}
