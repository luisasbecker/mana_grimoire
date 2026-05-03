package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaymatSet;", "", "name", "", "playmats", "", "Lcom/studiolaganne/lengendarylens/Playmat;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPlaymats", "()Ljava/util/List;", "setPlaymats", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PlaymatSet {
    public static final int $stable = 8;
    private String name;
    private List<Playmat> playmats;

    /* JADX WARN: Multi-variable type inference failed */
    public PlaymatSet() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PlaymatSet(String name, List<Playmat> playmats) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(playmats, "playmats");
        this.name = name;
        this.playmats = playmats;
    }

    public /* synthetic */ PlaymatSet(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaymatSet copy$default(PlaymatSet playmatSet, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playmatSet.name;
        }
        if ((i & 2) != 0) {
            list = playmatSet.playmats;
        }
        return playmatSet.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Playmat> component2() {
        return this.playmats;
    }

    public final PlaymatSet copy(String name, List<Playmat> playmats) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(playmats, "playmats");
        return new PlaymatSet(name, playmats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaymatSet)) {
            return false;
        }
        PlaymatSet playmatSet = (PlaymatSet) other;
        return Intrinsics.areEqual(this.name, playmatSet.name) && Intrinsics.areEqual(this.playmats, playmatSet.playmats);
    }

    public final String getName() {
        return this.name;
    }

    public final List<Playmat> getPlaymats() {
        return this.playmats;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.playmats.hashCode();
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPlaymats(List<Playmat> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playmats = list;
    }

    public String toString() {
        return "PlaymatSet(name=" + this.name + ", playmats=" + this.playmats + ")";
    }
}
