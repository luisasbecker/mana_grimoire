package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingMessage;", "", "game", "Lcom/studiolaganne/lengendarylens/GameStreamingData;", "<init>", "(Lcom/studiolaganne/lengendarylens/GameStreamingData;)V", "getGame", "()Lcom/studiolaganne/lengendarylens/GameStreamingData;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class StreamingMessage {
    public static final int $stable = 8;

    @SerializedName("game")
    private final GameStreamingData game;

    public StreamingMessage(GameStreamingData game) {
        Intrinsics.checkNotNullParameter(game, "game");
        this.game = game;
    }

    public static /* synthetic */ StreamingMessage copy$default(StreamingMessage streamingMessage, GameStreamingData gameStreamingData, int i, Object obj) {
        if ((i & 1) != 0) {
            gameStreamingData = streamingMessage.game;
        }
        return streamingMessage.copy(gameStreamingData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GameStreamingData getGame() {
        return this.game;
    }

    public final StreamingMessage copy(GameStreamingData game) {
        Intrinsics.checkNotNullParameter(game, "game");
        return new StreamingMessage(game);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StreamingMessage) && Intrinsics.areEqual(this.game, ((StreamingMessage) other).game);
    }

    public final GameStreamingData getGame() {
        return this.game;
    }

    public int hashCode() {
        return this.game.hashCode();
    }

    public String toString() {
        return "StreamingMessage(game=" + this.game + ")";
    }
}
