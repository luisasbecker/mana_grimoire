package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "", "version", "", "id", "name", "droppedAfterRound", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "getDroppedAfterRound", "()I", "setDroppedAfterRound", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TournamentPlayer {
    public static final int $stable = 8;
    private int droppedAfterRound;
    private String id;
    private String name;
    private String version;

    public TournamentPlayer() {
        this(null, null, null, 0, 15, null);
    }

    public TournamentPlayer(String version, String id, String name, int i) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.version = version;
        this.id = id;
        this.name = name;
        this.droppedAfterRound = i;
    }

    public /* synthetic */ TournamentPlayer(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "v2" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? -1 : i);
    }

    public static /* synthetic */ TournamentPlayer copy$default(TournamentPlayer tournamentPlayer, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tournamentPlayer.version;
        }
        if ((i2 & 2) != 0) {
            str2 = tournamentPlayer.id;
        }
        if ((i2 & 4) != 0) {
            str3 = tournamentPlayer.name;
        }
        if ((i2 & 8) != 0) {
            i = tournamentPlayer.droppedAfterRound;
        }
        return tournamentPlayer.copy(str, str2, str3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDroppedAfterRound() {
        return this.droppedAfterRound;
    }

    public final TournamentPlayer copy(String version, String id, String name, int droppedAfterRound) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new TournamentPlayer(version, id, name, droppedAfterRound);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TournamentPlayer)) {
            return false;
        }
        TournamentPlayer tournamentPlayer = (TournamentPlayer) other;
        return Intrinsics.areEqual(this.version, tournamentPlayer.version) && Intrinsics.areEqual(this.id, tournamentPlayer.id) && Intrinsics.areEqual(this.name, tournamentPlayer.name) && this.droppedAfterRound == tournamentPlayer.droppedAfterRound;
    }

    public final int getDroppedAfterRound() {
        return this.droppedAfterRound;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.version.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.droppedAfterRound);
    }

    public final void setDroppedAfterRound(int i) {
        this.droppedAfterRound = i;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "TournamentPlayer(version=" + this.version + ", id=" + this.id + ", name=" + this.name + ", droppedAfterRound=" + this.droppedAfterRound + ")";
    }
}
