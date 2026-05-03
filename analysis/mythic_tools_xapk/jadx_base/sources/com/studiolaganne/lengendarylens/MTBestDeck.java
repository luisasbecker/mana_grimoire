package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBestDeck;", "", "id", "", "formatid", "format", "", "name", "wins", "<init>", "(IILjava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "setId", "(I)V", "getFormatid", "setFormatid", "getFormat", "()Ljava/lang/String;", "setFormat", "(Ljava/lang/String;)V", "getName", "setName", "getWins", "setWins", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBestDeck {
    public static final int $stable = 8;
    private String format;
    private int formatid;
    private int id;
    private String name;
    private int wins;

    public MTBestDeck() {
        this(0, 0, null, null, 0, 31, null);
    }

    public MTBestDeck(int i, int i2, String format, String name, int i3) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.formatid = i2;
        this.format = format;
        this.name = name;
        this.wins = i3;
    }

    public /* synthetic */ MTBestDeck(int i, int i2, String str, String str2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? -1 : i2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? 0 : i3);
    }

    public static /* synthetic */ MTBestDeck copy$default(MTBestDeck mTBestDeck, int i, int i2, String str, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mTBestDeck.id;
        }
        if ((i4 & 2) != 0) {
            i2 = mTBestDeck.formatid;
        }
        if ((i4 & 4) != 0) {
            str = mTBestDeck.format;
        }
        if ((i4 & 8) != 0) {
            str2 = mTBestDeck.name;
        }
        if ((i4 & 16) != 0) {
            i3 = mTBestDeck.wins;
        }
        int i5 = i3;
        String str3 = str;
        return mTBestDeck.copy(i, i2, str3, str2, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFormatid() {
        return this.formatid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWins() {
        return this.wins;
    }

    public final MTBestDeck copy(int id, int formatid, String format, String name, int wins) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTBestDeck(id, formatid, format, name, wins);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTBestDeck)) {
            return false;
        }
        MTBestDeck mTBestDeck = (MTBestDeck) other;
        return this.id == mTBestDeck.id && this.formatid == mTBestDeck.formatid && Intrinsics.areEqual(this.format, mTBestDeck.format) && Intrinsics.areEqual(this.name, mTBestDeck.name) && this.wins == mTBestDeck.wins;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getFormatid() {
        return this.formatid;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.formatid)) * 31) + this.format.hashCode()) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.wins);
    }

    public final void setFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.format = str;
    }

    public final void setFormatid(int i) {
        this.formatid = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setWins(int i) {
        this.wins = i;
    }

    public String toString() {
        return "MTBestDeck(id=" + this.id + ", formatid=" + this.formatid + ", format=" + this.format + ", name=" + this.name + ", wins=" + this.wins + ")";
    }
}
