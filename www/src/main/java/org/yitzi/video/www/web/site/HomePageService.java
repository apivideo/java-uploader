package org.yitzi.video.www.web.site;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("")
@Produces(MediaType.TEXT_HTML)
public class HomePageService {

    @Context
    private HttpHeaders headers;

    @GET
    public String showHomePage() {
        HomePageContent homePageContent = new HomePageContent();
        return homePageContent.render();
    }
}
