package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MediaPlayerThreadOwner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010*\u0001\u0019\b\u0000\u0018\u0000 W2\u00020\u0001:\u0003WXYB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020!2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\rJ\u0012\u0010'\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J8\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u0002H.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H.02H\u0082\b¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\u0005J\u0010\u00105\u001a\u00020#2\u0006\u00104\u001a\u00020\u0005H\u0002J\u0006\u00106\u001a\u00020!J\u0016\u00107\u001a\u00020!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020!0\u0007H\u0002J~\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020;26\u0010<\u001a2\u0012\u0013\u0012\u00110*¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110*¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020!0=26\u0010B\u001a2\u0012\u0013\u0012\u00110*¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110*¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020!0=J\u0012\u0010C\u001a\u00020!2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\rJ\u0012\u0010D\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002J3\u0010E\u001a\u00020!2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020!0\u00072\u001a\b\u0002\u0010G\u001a\u0014\u0012\b\u0012\u00060Hj\u0002`I\u0012\u0006\u0012\u0004\u0018\u00010J02H\u0082\bJ\u000e\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020*J\u000e\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020\u0005J\u0010\u0010O\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010\rJ\u0012\u0010Q\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010R\u001a\u00020!J\b\u0010S\u001a\u00020!H\u0002J\b\u0010T\u001a\u00020!H\u0002J\u001d\u0010U\u001a\u00020!2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001602H\u0082\bR\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner;", "", "context", "Landroid/content/Context;", "muteAudio", "", "playerFactory", "Lkotlin/Function0;", "Landroid/media/MediaPlayer;", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function0;)V", "appContext", "kotlin.jvm.PlatformType", "currentSurface", "Landroid/view/Surface;", "looping", "mainHandler", "Landroid/os/Handler;", "pendingPlaybackState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$PendingPlaybackState;", "playbackCommandId", "Ljava/util/concurrent/atomic/AtomicLong;", "playbackSnapshot", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$PlaybackSnapshot;", "player", "positionTicker", "com/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$positionTicker$1", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$positionTicker$1;", "positionTickerScheduled", "released", "workerHandler", "workerThread", "Landroid/os/HandlerThread;", "clearPendingPlaybackState", "", "commandId", "", "(Ljava/lang/Long;)V", "clearSurfaceBlocking", "surfaceToRelease", "detachAndReleaseSurface", "ensurePlayer", "getAudioSessionId", "", "getCurrentPosition", "getDuration", "getPlayerValue", ExifInterface.GPS_DIRECTION_TRUE, "mediaPlayer", "fallback", "valueProvider", "Lkotlin/Function1;", "(Landroid/media/MediaPlayer;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isPlaying", "markPendingPlaybackState", "pause", "post", "operation", "prepare", "uri", "Landroid/net/Uri;", "onPrepared", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "videoWidth", "videoHeight", "onVideoSizeChanged", "release", "releaseSurface", "safely", "execute", "failureMessage", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "seekTo", "positionMs", "setLooping", "loop", "setSurface", "surface", "setSurfaceInternal", "start", "startPositionTicker", "stopPositionTicker", "updatePlaybackSnapshot", "transform", "Companion", "PendingPlaybackState", "PlaybackSnapshot", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaPlayerThreadOwner {

    @Deprecated
    public static final long DETACH_SURFACE_AWAIT_TIMEOUT_MS = 1000;

    @Deprecated
    public static final long POSITION_POLL_INTERVAL_MS = 250;
    private final Context appContext;
    private Surface currentSurface;
    private boolean looping;
    private final Handler mainHandler;
    private final boolean muteAudio;
    private volatile PendingPlaybackState pendingPlaybackState;
    private final AtomicLong playbackCommandId;
    private volatile PlaybackSnapshot playbackSnapshot;
    private MediaPlayer player;
    private final Function0<MediaPlayer> playerFactory;
    private final MediaPlayerThreadOwner$positionTicker$1 positionTicker;
    private boolean positionTickerScheduled;
    private volatile boolean released;
    private final Handler workerHandler;
    private final HandlerThread workerThread;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MediaPlayerThreadOwner.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$Companion;", "", "()V", "DETACH_SURFACE_AWAIT_TIMEOUT_MS", "", "POSITION_POLL_INTERVAL_MS", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MediaPlayerThreadOwner.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$PendingPlaybackState;", "", "isPlaying", "", "commandId", "", "(ZJ)V", "getCommandId", "()J", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class PendingPlaybackState {
        private final long commandId;
        private final boolean isPlaying;

        public PendingPlaybackState(boolean z, long j) {
            this.isPlaying = z;
            this.commandId = j;
        }

        public static /* synthetic */ PendingPlaybackState copy$default(PendingPlaybackState pendingPlaybackState, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pendingPlaybackState.isPlaying;
            }
            if ((i & 2) != 0) {
                j = pendingPlaybackState.commandId;
            }
            return pendingPlaybackState.copy(z, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsPlaying() {
            return this.isPlaying;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getCommandId() {
            return this.commandId;
        }

        public final PendingPlaybackState copy(boolean isPlaying, long commandId) {
            return new PendingPlaybackState(isPlaying, commandId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingPlaybackState)) {
                return false;
            }
            PendingPlaybackState pendingPlaybackState = (PendingPlaybackState) other;
            return this.isPlaying == pendingPlaybackState.isPlaying && this.commandId == pendingPlaybackState.commandId;
        }

        public final long getCommandId() {
            return this.commandId;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isPlaying) * 31) + Long.hashCode(this.commandId);
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }

        public String toString() {
            return "PendingPlaybackState(isPlaying=" + this.isPlaying + ", commandId=" + this.commandId + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MediaPlayerThreadOwner.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner$PlaybackSnapshot;", "", "prepared", "", "durationMs", "", "currentPositionMs", "isPlaying", "audioSessionId", "(ZIIZI)V", "getAudioSessionId", "()I", "getCurrentPositionMs", "getDurationMs", "()Z", "getPrepared", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class PlaybackSnapshot {
        private final int audioSessionId;
        private final int currentPositionMs;
        private final int durationMs;
        private final boolean isPlaying;
        private final boolean prepared;

        public PlaybackSnapshot() {
            this(false, 0, 0, false, 0, 31, null);
        }

        public PlaybackSnapshot(boolean z, int i, int i2, boolean z2, int i3) {
            this.prepared = z;
            this.durationMs = i;
            this.currentPositionMs = i2;
            this.isPlaying = z2;
            this.audioSessionId = i3;
        }

        public /* synthetic */ PlaybackSnapshot(boolean z, int i, int i2, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? 0 : i3);
        }

        public static /* synthetic */ PlaybackSnapshot copy$default(PlaybackSnapshot playbackSnapshot, boolean z, int i, int i2, boolean z2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z = playbackSnapshot.prepared;
            }
            if ((i4 & 2) != 0) {
                i = playbackSnapshot.durationMs;
            }
            if ((i4 & 4) != 0) {
                i2 = playbackSnapshot.currentPositionMs;
            }
            if ((i4 & 8) != 0) {
                z2 = playbackSnapshot.isPlaying;
            }
            if ((i4 & 16) != 0) {
                i3 = playbackSnapshot.audioSessionId;
            }
            int i5 = i3;
            int i6 = i2;
            return playbackSnapshot.copy(z, i, i6, z2, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getPrepared() {
            return this.prepared;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDurationMs() {
            return this.durationMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCurrentPositionMs() {
            return this.currentPositionMs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPlaying() {
            return this.isPlaying;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getAudioSessionId() {
            return this.audioSessionId;
        }

        public final PlaybackSnapshot copy(boolean prepared, int durationMs, int currentPositionMs, boolean isPlaying, int audioSessionId) {
            return new PlaybackSnapshot(prepared, durationMs, currentPositionMs, isPlaying, audioSessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaybackSnapshot)) {
                return false;
            }
            PlaybackSnapshot playbackSnapshot = (PlaybackSnapshot) other;
            return this.prepared == playbackSnapshot.prepared && this.durationMs == playbackSnapshot.durationMs && this.currentPositionMs == playbackSnapshot.currentPositionMs && this.isPlaying == playbackSnapshot.isPlaying && this.audioSessionId == playbackSnapshot.audioSessionId;
        }

        public final int getAudioSessionId() {
            return this.audioSessionId;
        }

        public final int getCurrentPositionMs() {
            return this.currentPositionMs;
        }

        public final int getDurationMs() {
            return this.durationMs;
        }

        public final boolean getPrepared() {
            return this.prepared;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.prepared) * 31) + Integer.hashCode(this.durationMs)) * 31) + Integer.hashCode(this.currentPositionMs)) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Integer.hashCode(this.audioSessionId);
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }

        public String toString() {
            return "PlaybackSnapshot(prepared=" + this.prepared + ", durationMs=" + this.durationMs + ", currentPositionMs=" + this.currentPositionMs + ", isPlaying=" + this.isPlaying + ", audioSessionId=" + this.audioSessionId + ')';
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaPlayerThreadOwner.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C08361 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function2<Integer, Integer, Unit> $onPrepared;
        final /* synthetic */ Function2<Integer, Integer, Unit> $onVideoSizeChanged;
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08361(Uri uri, Function2<? super Integer, ? super Integer, Unit> function2, Function2<? super Integer, ? super Integer, Unit> function22) {
            super(0);
            this.$uri = uri;
            this.$onPrepared = function2;
            this.$onVideoSizeChanged = function22;
        }

        static final void invoke$lambda$14$lambda$10(final MediaPlayerThreadOwner mediaPlayerThreadOwner, final Function2 function2, MediaPlayer mediaPlayer, final int i, final int i2) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            mediaPlayerThreadOwner.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPlayerThreadOwner.C08361.invoke$lambda$14$lambda$10$lambda$9(mediaPlayerThreadOwner, function2, i, i2);
                }
            });
        }

        static final void invoke$lambda$14$lambda$10$lambda$9(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function2 function2, int i, int i2) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        }

        static final void invoke$lambda$14$lambda$13(MediaPlayerThreadOwner mediaPlayerThreadOwner, MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return;
            }
            PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
            int durationMs = playbackSnapshot.getDurationMs();
            try {
                durationMs = mediaPlayer.getCurrentPosition();
            } catch (Exception unused) {
            }
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, durationMs, false, 0, 19, null);
            MediaPlayerThreadOwner.clearPendingPlaybackState$default(mediaPlayerThreadOwner, null, 1, null);
            mediaPlayerThreadOwner.stopPositionTicker();
        }

        static final void invoke$lambda$14$lambda$8(final MediaPlayerThreadOwner mediaPlayerThreadOwner, final Function2 function2, MediaPlayer mediaPlayer) {
            final int videoWidth;
            final int videoHeight;
            int duration;
            if (mediaPlayerThreadOwner.released || mediaPlayer == null) {
                return;
            }
            int currentPosition = 0;
            try {
                videoWidth = mediaPlayer.getVideoWidth();
            } catch (Exception unused) {
                videoWidth = 0;
            }
            try {
                videoHeight = mediaPlayer.getVideoHeight();
            } catch (Exception unused2) {
                videoHeight = 0;
            }
            PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
            try {
                duration = mediaPlayer.getDuration();
            } catch (Exception unused3) {
                duration = 0;
            }
            try {
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (Exception unused4) {
            }
            int i = currentPosition;
            int audioSessionId = playbackSnapshot.getAudioSessionId();
            try {
                audioSessionId = mediaPlayer.getAudioSessionId();
            } catch (Exception unused5) {
            }
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, true, duration, i, false, audioSessionId, 8, null);
            mediaPlayerThreadOwner.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPlayerThreadOwner.C08361.invoke$lambda$14$lambda$8$lambda$7(mediaPlayerThreadOwner, function2, videoWidth, videoHeight);
                }
            });
        }

        static final void invoke$lambda$14$lambda$8$lambda$7(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function2 function2, int i, int i2) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MediaPlayerThreadOwner.clearPendingPlaybackState$default(MediaPlayerThreadOwner.this, null, 1, null);
            MediaPlayer mediaPlayerEnsurePlayer = MediaPlayerThreadOwner.this.ensurePlayer();
            MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, 0, false, 0, 16, null);
            MediaPlayerThreadOwner.this.stopPositionTicker();
            final MediaPlayerThreadOwner mediaPlayerThreadOwner2 = MediaPlayerThreadOwner.this;
            Uri uri = this.$uri;
            final Function2<Integer, Integer, Unit> function2 = this.$onPrepared;
            final Function2<Integer, Integer, Unit> function22 = this.$onVideoSizeChanged;
            try {
                mediaPlayerEnsurePlayer.reset();
                Surface surface = mediaPlayerThreadOwner2.currentSurface;
                if (surface != null) {
                    mediaPlayerEnsurePlayer.setSurface(surface);
                } else {
                    Logger.INSTANCE.w("TextureVideoView: Preparing media player without a surface.Audio may play before video is attached.");
                }
                mediaPlayerEnsurePlayer.setLooping(mediaPlayerThreadOwner2.looping);
                if (mediaPlayerThreadOwner2.muteAudio) {
                    mediaPlayerEnsurePlayer.setVolume(0.0f, 0.0f);
                }
                mediaPlayerEnsurePlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1$$ExternalSyntheticLambda2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        MediaPlayerThreadOwner.C08361.invoke$lambda$14$lambda$8(mediaPlayerThreadOwner2, function2, mediaPlayer);
                    }
                });
                mediaPlayerEnsurePlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1$$ExternalSyntheticLambda3
                    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                        MediaPlayerThreadOwner.C08361.invoke$lambda$14$lambda$10(mediaPlayerThreadOwner2, function22, mediaPlayer, i, i2);
                    }
                });
                mediaPlayerEnsurePlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1$$ExternalSyntheticLambda4
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        MediaPlayerThreadOwner.C08361.invoke$lambda$14$lambda$13(mediaPlayerThreadOwner2, mediaPlayer);
                    }
                });
                mediaPlayerEnsurePlayer.setDataSource(mediaPlayerThreadOwner2.appContext, uri);
                mediaPlayerEnsurePlayer.prepareAsync();
            } catch (Exception e) {
                String str = "Could not prepare media player: " + e.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$positionTicker$1] */
    public MediaPlayerThreadOwner(Context context, boolean z, Function0<? extends MediaPlayer> playerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerFactory, "playerFactory");
        this.muteAudio = z;
        this.playerFactory = playerFactory;
        this.appContext = context.getApplicationContext();
        this.mainHandler = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("RC-TextureVideoViewPlayer");
        handlerThread.start();
        this.workerThread = handlerThread;
        this.workerHandler = new Handler(handlerThread.getLooper());
        this.playbackSnapshot = new PlaybackSnapshot(false, 0, 0, false, 0, 31, null);
        this.playbackCommandId = new AtomicLong(0L);
        this.positionTicker = new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$positionTicker$1
            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPlaying;
                boolean z2 = this.this$0.released;
                MediaPlayerThreadOwner mediaPlayerThreadOwner = this.this$0;
                if (z2) {
                    mediaPlayerThreadOwner.positionTickerScheduled = false;
                    return;
                }
                MediaPlayer mediaPlayer = mediaPlayerThreadOwner.player;
                if (mediaPlayer == null || !this.this$0.playbackSnapshot.getPrepared()) {
                    this.this$0.positionTickerScheduled = false;
                    return;
                }
                try {
                    zIsPlaying = mediaPlayer.isPlaying();
                } catch (Exception unused) {
                    zIsPlaying = false;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner2 = this.this$0;
                MediaPlayerThreadOwner.PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner2.playbackSnapshot;
                int currentPositionMs = playbackSnapshot.getCurrentPositionMs();
                try {
                    currentPositionMs = mediaPlayer.getCurrentPosition();
                } catch (Exception unused2) {
                }
                mediaPlayerThreadOwner2.playbackSnapshot = MediaPlayerThreadOwner.PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, currentPositionMs, zIsPlaying, 0, 19, null);
                MediaPlayerThreadOwner mediaPlayerThreadOwner3 = this.this$0;
                if (zIsPlaying) {
                    mediaPlayerThreadOwner3.workerHandler.postDelayed(this, 250L);
                } else {
                    mediaPlayerThreadOwner3.positionTickerScheduled = false;
                }
            }
        };
    }

    public /* synthetic */ MediaPlayerThreadOwner(Context context, boolean z, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, (i & 4) != 0 ? new Function0<MediaPlayer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MediaPlayer invoke() {
                return new MediaPlayer();
            }
        } : anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPendingPlaybackState(Long commandId) {
        PendingPlaybackState pendingPlaybackState = this.pendingPlaybackState;
        if (pendingPlaybackState == null) {
            return;
        }
        if (commandId == null || pendingPlaybackState.getCommandId() == commandId.longValue()) {
            this.pendingPlaybackState = null;
        }
    }

    static /* synthetic */ void clearPendingPlaybackState$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        mediaPlayerThreadOwner.clearPendingPlaybackState(l);
    }

    public static /* synthetic */ void clearSurfaceBlocking$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, int i, Object obj) {
        if ((i & 1) != 0) {
            surface = null;
        }
        mediaPlayerThreadOwner.clearSurfaceBlocking(surface);
    }

    static final void clearSurfaceBlocking$lambda$1(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, CountDownLatch countDownLatch) {
        try {
            mediaPlayerThreadOwner.detachAndReleaseSurface(surface);
        } finally {
            countDownLatch.countDown();
        }
    }

    private final void detachAndReleaseSurface(Surface surfaceToRelease) {
        setSurfaceInternal(null);
        releaseSurface(surfaceToRelease);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaPlayer ensurePlayer() {
        int audioSessionId;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer;
        }
        MediaPlayer mediaPlayerInvoke = this.playerFactory.invoke();
        this.player = mediaPlayerInvoke;
        PlaybackSnapshot playbackSnapshot = this.playbackSnapshot;
        try {
            audioSessionId = mediaPlayerInvoke.getAudioSessionId();
        } catch (Exception unused) {
            audioSessionId = 0;
        }
        this.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, 0, false, audioSessionId, 15, null);
        Surface surface = this.currentSurface;
        if (surface != null) {
            try {
                mediaPlayerInvoke.setSurface(surface);
            } catch (Exception e) {
                String str = "Could not attach media surface: " + e.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e);
                }
            }
        }
        return mediaPlayerInvoke;
    }

    private final <T> T getPlayerValue(MediaPlayer mediaPlayer, T fallback, Function1<? super MediaPlayer, ? extends T> valueProvider) {
        try {
            return valueProvider.invoke(mediaPlayer);
        } catch (Exception unused) {
            return fallback;
        }
    }

    private final long markPendingPlaybackState(boolean isPlaying) {
        long jIncrementAndGet = this.playbackCommandId.incrementAndGet();
        this.pendingPlaybackState = new PendingPlaybackState(isPlaying, jIncrementAndGet);
        return jIncrementAndGet;
    }

    private final void post(final Function0<Unit> operation) {
        if (this.released) {
            return;
        }
        this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.post$lambda$17(this.f$0, operation);
            }
        });
    }

    static final void post$lambda$17(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function0 function0) {
        if (mediaPlayerThreadOwner.released) {
            return;
        }
        function0.invoke();
    }

    public static /* synthetic */ void release$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, int i, Object obj) {
        if ((i & 1) != 0) {
            surface = null;
        }
        mediaPlayerThreadOwner.release(surface);
    }

    static final void release$lambda$6(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface) {
        try {
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, 0, false, 0, 22, null);
            MediaPlayer mediaPlayer = mediaPlayerThreadOwner.player;
            mediaPlayerThreadOwner.player = null;
            mediaPlayerThreadOwner.currentSurface = null;
            mediaPlayerThreadOwner.stopPositionTicker();
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setSurface(null);
                } catch (Exception unused) {
                }
            }
            mediaPlayerThreadOwner.releaseSurface(surface);
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception e) {
                    String str = "Could not release media player: " + e.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e);
                    }
                }
            }
        } finally {
            mediaPlayerThreadOwner.workerThread.quitSafely();
        }
    }

    private final void releaseSurface(Surface surfaceToRelease) {
        if (surfaceToRelease != null) {
            try {
                surfaceToRelease.release();
            } catch (Exception e) {
                String str = "Could not release media surface: " + e.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e);
                }
            }
        }
    }

    private final void safely(Function0<Unit> execute, Function1<? super Exception, String> failureMessage) {
        try {
            execute.invoke();
        } catch (Exception e) {
            String strInvoke = failureMessage.invoke(e);
            if (strInvoke != null) {
                Logger.INSTANCE.e("TextureVideoView: " + strInvoke, e);
            }
        }
    }

    static /* synthetic */ void safely$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.safely.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Exception it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        try {
            function0.invoke();
        } catch (Exception e) {
            String str = (String) function1.invoke(e);
            if (str != null) {
                Logger.INSTANCE.e("TextureVideoView: " + str, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSurfaceInternal(Surface surface) {
        this.currentSurface = surface;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setSurface(surface);
        } catch (Exception e) {
            String str = "Could not set media surface: " + e.getMessage();
            if (str != null) {
                Logger.INSTANCE.e("TextureVideoView: " + str, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPositionTicker() {
        if (this.positionTickerScheduled) {
            return;
        }
        this.positionTickerScheduled = true;
        this.workerHandler.post(this.positionTicker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopPositionTicker() {
        this.positionTickerScheduled = false;
        this.workerHandler.removeCallbacks(this.positionTicker);
    }

    private final void updatePlaybackSnapshot(Function1<? super PlaybackSnapshot, PlaybackSnapshot> transform) {
        this.playbackSnapshot = transform.invoke(this.playbackSnapshot);
    }

    public final void clearSurfaceBlocking(final Surface surfaceToRelease) {
        if (Intrinsics.areEqual(Looper.myLooper(), this.workerThread.getLooper())) {
            detachAndReleaseSurface(surfaceToRelease);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.clearSurfaceBlocking$lambda$1(this.f$0, surfaceToRelease, countDownLatch);
            }
        })) {
            releaseSurface(surfaceToRelease);
            Logger.INSTANCE.w("TextureVideoView: Could not post surface detach to worker thread. Released provided surface locally.");
            return;
        }
        try {
            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            Logger.INSTANCE.w("TextureVideoView: Timed out waiting for surface detach on worker thread. Surface release will complete asynchronously on the worker thread.");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Logger.INSTANCE.w("TextureVideoView: Interrupted while waiting for surface detach. Surface release will complete asynchronously on the worker thread.");
        }
    }

    public final int getAudioSessionId() {
        return this.playbackSnapshot.getAudioSessionId();
    }

    public final int getCurrentPosition() {
        return this.playbackSnapshot.getCurrentPositionMs();
    }

    public final int getDuration() {
        return this.playbackSnapshot.getDurationMs();
    }

    public final boolean isPlaying() {
        PendingPlaybackState pendingPlaybackState = this.pendingPlaybackState;
        return pendingPlaybackState != null ? pendingPlaybackState.isPlaying() : this.playbackSnapshot.isPlaying();
    }

    public final void pause() {
        if (this.released || !this.playbackSnapshot.getPrepared()) {
            return;
        }
        final long jMarkPendingPlaybackState = markPendingPlaybackState(false);
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.pause.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean prepared = MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared();
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                if (!prepared) {
                    mediaPlayerThreadOwner.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayer mediaPlayer = mediaPlayerThreadOwner.player;
                MediaPlayerThreadOwner mediaPlayerThreadOwner2 = MediaPlayerThreadOwner.this;
                if (mediaPlayer == null) {
                    mediaPlayerThreadOwner2.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                try {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                    PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner2.playbackSnapshot;
                    int currentPositionMs = playbackSnapshot.getCurrentPositionMs();
                    try {
                        currentPositionMs = mediaPlayer.getCurrentPosition();
                    } catch (Exception unused) {
                    }
                    mediaPlayerThreadOwner2.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, currentPositionMs, false, 0, 19, null);
                    mediaPlayerThreadOwner2.stopPositionTicker();
                } catch (Exception e) {
                    String str = "Could not pause media player: " + e.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e);
                    }
                }
                MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
            }
        });
    }

    public final void prepare(Uri uri, Function2<? super Integer, ? super Integer, Unit> onPrepared, Function2<? super Integer, ? super Integer, Unit> onVideoSizeChanged) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(onPrepared, "onPrepared");
        Intrinsics.checkNotNullParameter(onVideoSizeChanged, "onVideoSizeChanged");
        post(new C08361(uri, onPrepared, onVideoSizeChanged));
    }

    public final void release(final Surface surfaceToRelease) {
        if (this.released) {
            releaseSurface(surfaceToRelease);
            return;
        }
        this.released = true;
        clearPendingPlaybackState$default(this, null, 1, null);
        this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.release$lambda$6(this.f$0, surfaceToRelease);
            }
        });
    }

    public final void seekTo(final int positionMs) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.seekTo.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaPlayer mediaPlayer;
                if (!MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared() || positionMs < 0 || (mediaPlayer = MediaPlayerThreadOwner.this.player) == null) {
                    return;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                int i = positionMs;
                try {
                    mediaPlayer.seekTo(i);
                    mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, i, false, 0, 27, null);
                } catch (Exception e) {
                    String str = "Could not seek media player: " + e.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e);
                    }
                }
            }
        });
    }

    public final void setLooping(final boolean loop) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.setLooping.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Unit unit;
                MediaPlayerThreadOwner.this.looping = loop;
                MediaPlayer mediaPlayer = MediaPlayerThreadOwner.this.player;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.setLooping(loop);
                    } catch (Exception e) {
                        String str = "Could not set looping mode: " + e.getMessage();
                        if (str != null) {
                            Logger.INSTANCE.e("TextureVideoView: " + str, e);
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Logger.INSTANCE.w("TextureVideoView: Looping was set before media player initialization. Value cached for prepare.");
                }
            }
        });
    }

    public final void setSurface(final Surface surface) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.setSurface.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaPlayerThreadOwner.this.setSurfaceInternal(surface);
            }
        });
    }

    public final void start() {
        if (this.released || !this.playbackSnapshot.getPrepared()) {
            return;
        }
        final long jMarkPendingPlaybackState = markPendingPlaybackState(true);
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.start.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean prepared = MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared();
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                if (!prepared) {
                    mediaPlayerThreadOwner.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayer mediaPlayer = mediaPlayerThreadOwner.player;
                MediaPlayerThreadOwner mediaPlayerThreadOwner2 = MediaPlayerThreadOwner.this;
                if (mediaPlayer == null) {
                    mediaPlayerThreadOwner2.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                try {
                    mediaPlayer.start();
                    mediaPlayerThreadOwner2.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner2.playbackSnapshot, false, 0, 0, true, 0, 23, null);
                    mediaPlayerThreadOwner2.startPositionTicker();
                } catch (Exception e) {
                    String str = "Could not start media player: " + e.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e);
                    }
                }
                MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
            }
        });
    }
}
