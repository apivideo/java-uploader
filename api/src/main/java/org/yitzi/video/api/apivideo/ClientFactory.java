package org.yitzi.video.api.apivideo;

import org.yitzi.video.api.apivideo.infrastructure.unirest.AuthRequestExecutor;
import org.yitzi.video.api.apivideo.infrastructure.unirest.account.AccountClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.account.AccountDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.analytics.*;
import org.yitzi.video.api.apivideo.infrastructure.unirest.caption.CaptionClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.caption.CaptionDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.caption.CaptionInputSerializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.chapter.ChapterDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.chapter.UnirestChapterClientFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.live.LiveStreamClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.live.LiveStreamDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.live.LiveStreamInputSerializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.player.PlayerClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.player.PlayerDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.player.PlayerInputSerializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.request.RequestBuilderFactory;
import org.yitzi.video.api.apivideo.infrastructure.unirest.video.UnirestVideoClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.video.VideoDeserializer;
import org.yitzi.video.api.apivideo.infrastructure.unirest.video.VideoInputSerializer;

public class ClientFactory {

    public Client create(String apiKey) {
        return create(apiKey, "https://ws.api.video");
    }

    public Client createSandbox(String apiKey) {
        return create(apiKey, "https://sandbox.api.video");
    }

    protected Client create(String apiKey, String baseUri) {
        RequestBuilderFactory requestBuilderFactory = new RequestBuilderFactory(baseUri);
        AuthRequestExecutor requestExecutor = new AuthRequestExecutor(requestBuilderFactory, apiKey);

        return new Client(
                new AccountClient(requestBuilderFactory, new AccountDeserializer(), requestExecutor),
                new CaptionClient(requestBuilderFactory, new CaptionInputSerializer(), new CaptionDeserializer(), requestExecutor),
                new LiveStreamClient(requestBuilderFactory, new LiveStreamInputSerializer(), new LiveStreamDeserializer(), requestExecutor),
                new LiveStreamSessionClient(requestBuilderFactory, new PlayerSessionDeserializer(), requestExecutor),
                new PlayerClient(requestBuilderFactory, new PlayerInputSerializer(), new PlayerDeserializer(), requestExecutor),
                new PlayerSessionEventClient(requestBuilderFactory, new SessionEventJsonSerializer(), requestExecutor),
                new UnirestVideoClient(requestBuilderFactory, new VideoInputSerializer(), new VideoDeserializer(), requestExecutor),
                new VideoSessionClient(requestBuilderFactory, new PlayerSessionDeserializer(), requestExecutor),
                new UnirestChapterClientFactory(requestBuilderFactory, new ChapterDeserializer(), requestExecutor)
        );
    }
}
