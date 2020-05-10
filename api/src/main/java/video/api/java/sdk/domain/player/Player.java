package video.api.java.sdk.domain.player;

public class Player extends PlayerInput {
    public static class Assets {
        public final String link;
        public final String logo;

        public Assets(String link, String logo) {
            this.link = link;
            this.logo = logo;
        }
    }

    public final String playerId;
    public final Assets assets;

    public Player(String playerId, Assets assets) {
        this.playerId = playerId;
        this.assets   = assets;
    }
}
