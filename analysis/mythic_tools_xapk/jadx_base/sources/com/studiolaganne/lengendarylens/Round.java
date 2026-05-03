package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/Round;", "", "version", "", "final", "", "pairings", "", "Lcom/studiolaganne/lengendarylens/Pairing;", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getFinal", "()Z", "setFinal", "(Z)V", "getPairings", "()Ljava/util/List;", "setPairings", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Round {
    public static final int $stable = 8;
    private boolean final;
    private List<Pairing> pairings;
    private String version;

    public Round() {
        this(null, false, null, 7, null);
    }

    public Round(String version, boolean z, List<Pairing> pairings) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(pairings, "pairings");
        this.version = version;
        this.final = z;
        this.pairings = pairings;
    }

    public /* synthetic */ Round(String str, boolean z, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "v2" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Round copy$default(Round round, String str, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = round.version;
        }
        if ((i & 2) != 0) {
            z = round.final;
        }
        if ((i & 4) != 0) {
            list = round.pairings;
        }
        return round.copy(str, z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFinal() {
        return this.final;
    }

    public final List<Pairing> component3() {
        return this.pairings;
    }

    public final Round copy(String version, boolean z, List<Pairing> pairings) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(pairings, "pairings");
        return new Round(version, z, pairings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Round)) {
            return false;
        }
        Round round = (Round) other;
        return Intrinsics.areEqual(this.version, round.version) && this.final == round.final && Intrinsics.areEqual(this.pairings, round.pairings);
    }

    public final boolean getFinal() {
        return this.final;
    }

    public final List<Pairing> getPairings() {
        return this.pairings;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.version.hashCode() * 31) + Boolean.hashCode(this.final)) * 31) + this.pairings.hashCode();
    }

    public final void setFinal(boolean z) {
        this.final = z;
    }

    public final void setPairings(List<Pairing> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pairings = list;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "Round(version=" + this.version + ", final=" + this.final + ", pairings=" + this.pairings + ")";
    }
}
