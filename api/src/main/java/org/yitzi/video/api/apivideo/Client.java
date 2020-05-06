package org.yitzi.video.api.apivideo;

import org.yitzi.video.api.apivideo.domain.account.AccountClient;
import org.yitzi.video.api.apivideo.domain.analytics.LiveStreamSessionClient;
import org.yitzi.video.api.apivideo.domain.analytics.PlayerSessionEventClient;
import org.yitzi.video.api.apivideo.domain.analytics.VideoSessionClient;
import org.yitzi.video.api.apivideo.domain.caption.CaptionClient;
import org.yitzi.video.api.apivideo.domain.chapter.ChapterClient;
import org.yitzi.video.api.apivideo.domain.live.LiveStreamClient;
import org.yitzi.video.api.apivideo.domain.player.PlayerClient;
import org.yitzi.video.api.apivideo.domain.video.VideoClient;
import org.yitzi.video.api.apivideo.infrastructure.unirest.chapter.UnirestChapterClientFactory;

public class Client {
    public final  AccountClient               account;
    public final  CaptionClient               captions;
    public final  LiveStreamClient            liveStreams;
    public final  LiveStreamSessionClient     liveStreamAnalytics;
    public final  PlayerClient                players;
    public final  PlayerSessionEventClient    playerSessionEvents;
    public final  VideoClient                 videos;
    public final  VideoSessionClient          videoAnalytics;
    private final UnirestChapterClientFactory chapterClientFactory;

    public Client(
            AccountClient account,
            CaptionClient captions,
            LiveStreamClient liveStreams,
            LiveStreamSessionClient liveStreamAnalytics,
            PlayerClient players,
            PlayerSessionEventClient playerSessionEvents,
            VideoClient videos,
            VideoSessionClient videoAnalytics,
            UnirestChapterClientFactory chapterClientFactory) {
        this.account              = account;
        this.captions             = captions;
        this.liveStreams          = liveStreams;
        this.liveStreamAnalytics  = liveStreamAnalytics;
        this.players              = players;
        this.playerSessionEvents  = playerSessionEvents;
        this.videos               = videos;
        this.videoAnalytics       = videoAnalytics;
        this.chapterClientFactory = chapterClientFactory;
    }

    public ChapterClient chapters(String videoId) {
        return chapterClientFactory.create(videoId);
    }
}
