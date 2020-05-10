package video.api.java.sdk.domain.player;

import java.awt.*;

public class PlayerInput {

    public int     shapeMargin           = 10;
    public int     shapeRadius           = 3;
    public String  shapeAspect           = "flat";
    public Color   shapeBackgroundTop    = new Color(150, 150, 150, (int) (.7 * 256));
    public Color   shapeBackgroundBottom = new Color(150, 150, 150, (int) (.8 * 256));
    public Color   text                  = new Color(155, 155, 155, (int) (.95 * 256));
    public Color   link                  = new Color(155, 0, 0, (int) (.95 * 256));
    public Color   linkHover             = new Color(155, 155, 155, (int) (.75 * 256));
    public Color   linkActive            = new Color(25, 0, 0, (int) (.75 * 256));
    public Color   trackPlayed           = new Color(25, 25, 25, (int) (.95 * 256));
    public Color   trackUnplayed         = new Color(25, 25, 55, (int) (.1 * 256));
    public Color   backgroundText        = new Color(25, 25, 25, (int) (.95 * 256));
    public Color   trackBackground       = new Color(10, 10, 10, (int) (.10 * 256));
    public Color   backgroundTop         = new Color(172, 14, 145, (int) (.1 * 256));
    public Color   backgroundBottom      = new Color(194, 195, 189, (int) (.11 * 256));
    public boolean enableApi             = true;
    public boolean enableControls        = true;
    public boolean forceAutoplay         = false;
    public boolean hideTitle             = false;
    public boolean forceLoop             = false;


}