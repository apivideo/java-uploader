package video.api.java.sdk.domain.pagination;

import java.util.HashMap;
import java.util.Map;

public class PageQuery {
    public int currentPage = 1;
    public int pageSize    = 25;

    public Map<String, Object> toMap() {
        return new HashMap<String, Object>() {{
            put("currentPage", currentPage);
            put("pageSize", pageSize);
        }};
    }
}
