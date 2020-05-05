package org.yitzi.video.www.web.site;


import org.yitzi.video.www.application.WebsiteView;

public class UploadPageContent extends WebsiteView {

    private String uniqueURL;

    UploadPageContent() {
        super("web/site/upload.ftl");
    }

    public String getUniqueURL() {
        return uniqueURL;
    }

    public void setUniqueURL(String uniqueURL) {
        this.uniqueURL = uniqueURL;
    }
}
