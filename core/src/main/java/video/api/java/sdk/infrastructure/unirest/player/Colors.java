package video.api.java.sdk.infrastructure.unirest.player;

import java.awt.*;

public class Colors {
    public static String colorToString(Color color) {
        float alpha = (float) ((int) (1 + ((((float) color.getAlpha()) / 256) * 100))) / 100;
        if (color.getAlpha() == 192) {
            alpha = (float) 0.75;
        }
        if (color.getAlpha() == 128) {
            alpha = (float) 0.50;
        }
        if (color.getAlpha() == 64) {
            alpha = (float) 0.25;
        }
        int alphaInt = (int) (alpha * 100);

        return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", ." + alphaInt + ")";
    }

}
