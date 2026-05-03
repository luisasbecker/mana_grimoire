package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckData;", "", "deckImageURL", "", "isArtCrop", "", "hasColors", "colors", "", "<init>", "(Ljava/lang/String;ZZLjava/util/List;)V", "getDeckImageURL", "()Ljava/lang/String;", "setDeckImageURL", "(Ljava/lang/String;)V", "()Z", "setArtCrop", "(Z)V", "getHasColors", "setHasColors", "getColors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckData {
    public static final int $stable = 8;
    private final List<String> colors;
    private String deckImageURL;
    private boolean hasColors;
    private boolean isArtCrop;

    public MTDeckData(String deckImageURL, boolean z, boolean z2, List<String> colors) {
        Intrinsics.checkNotNullParameter(deckImageURL, "deckImageURL");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.deckImageURL = deckImageURL;
        this.isArtCrop = z;
        this.hasColors = z2;
        this.colors = colors;
    }

    public /* synthetic */ MTDeckData(String str, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckData copy$default(MTDeckData mTDeckData, String str, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTDeckData.deckImageURL;
        }
        if ((i & 2) != 0) {
            z = mTDeckData.isArtCrop;
        }
        if ((i & 4) != 0) {
            z2 = mTDeckData.hasColors;
        }
        if ((i & 8) != 0) {
            list = mTDeckData.colors;
        }
        return mTDeckData.copy(str, z, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeckImageURL() {
        return this.deckImageURL;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsArtCrop() {
        return this.isArtCrop;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasColors() {
        return this.hasColors;
    }

    public final List<String> component4() {
        return this.colors;
    }

    public final MTDeckData copy(String deckImageURL, boolean isArtCrop, boolean hasColors, List<String> colors) {
        Intrinsics.checkNotNullParameter(deckImageURL, "deckImageURL");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new MTDeckData(deckImageURL, isArtCrop, hasColors, colors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckData)) {
            return false;
        }
        MTDeckData mTDeckData = (MTDeckData) other;
        return Intrinsics.areEqual(this.deckImageURL, mTDeckData.deckImageURL) && this.isArtCrop == mTDeckData.isArtCrop && this.hasColors == mTDeckData.hasColors && Intrinsics.areEqual(this.colors, mTDeckData.colors);
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getDeckImageURL() {
        return this.deckImageURL;
    }

    public final boolean getHasColors() {
        return this.hasColors;
    }

    public int hashCode() {
        return (((((this.deckImageURL.hashCode() * 31) + Boolean.hashCode(this.isArtCrop)) * 31) + Boolean.hashCode(this.hasColors)) * 31) + this.colors.hashCode();
    }

    public final boolean isArtCrop() {
        return this.isArtCrop;
    }

    public final void setArtCrop(boolean z) {
        this.isArtCrop = z;
    }

    public final void setDeckImageURL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deckImageURL = str;
    }

    public final void setHasColors(boolean z) {
        this.hasColors = z;
    }

    public String toString() {
        return "MTDeckData(deckImageURL=" + this.deckImageURL + ", isArtCrop=" + this.isArtCrop + ", hasColors=" + this.hasColors + ", colors=" + this.colors + ")";
    }
}
