package video.api.java.sdk.domain.pagination;

import java.util.List;

public class Page<T> {
    public final  List<T> items;
    public final  int     total;
    private final int     current;

    public Page(List<T> items, int total, int current) {
        this.items   = items;
        this.total   = total;
        this.current = current;
    }
}
