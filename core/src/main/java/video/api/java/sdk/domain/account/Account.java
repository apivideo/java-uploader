package video.api.java.sdk.domain.account;

import java.util.List;

public class Account {
    public static class Quota {
        public final Integer quotaUsed;
        public final Integer quotaRemaining;
        public final Integer quotaTotal;

        public Quota(Integer quotaUsed, Integer quotaRemaining, Integer quotaTotal) {
            this.quotaUsed      = quotaUsed;
            this.quotaRemaining = quotaRemaining;
            this.quotaTotal     = quotaTotal;
        }
    }

    public final Quota quota;

    public final List<String> features;

    public Account(Quota quota, List<String> features) {
        this.quota    = quota;
        this.features = features;
    }
}
