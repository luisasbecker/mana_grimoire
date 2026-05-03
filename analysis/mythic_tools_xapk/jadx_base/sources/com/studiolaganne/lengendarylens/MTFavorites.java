package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFavorites;", "", "formats", "", "Lcom/studiolaganne/lengendarylens/MTFavoriteFormat;", "setups", "Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFormats", "()Ljava/util/List;", "setFormats", "(Ljava/util/List;)V", "getSetups", "setSetups", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFavorites {
    public static final int $stable = 8;
    private List<MTFavoriteFormat> formats;
    private List<MTFavoriteSetup> setups;

    /* JADX WARN: Multi-variable type inference failed */
    public MTFavorites() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTFavorites(List<MTFavoriteFormat> list, List<MTFavoriteSetup> list2) {
        this.formats = list;
        this.setups = list2;
    }

    public /* synthetic */ MTFavorites(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTFavorites copy$default(MTFavorites mTFavorites, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTFavorites.formats;
        }
        if ((i & 2) != 0) {
            list2 = mTFavorites.setups;
        }
        return mTFavorites.copy(list, list2);
    }

    public final List<MTFavoriteFormat> component1() {
        return this.formats;
    }

    public final List<MTFavoriteSetup> component2() {
        return this.setups;
    }

    public final MTFavorites copy(List<MTFavoriteFormat> formats, List<MTFavoriteSetup> setups) {
        return new MTFavorites(formats, setups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFavorites)) {
            return false;
        }
        MTFavorites mTFavorites = (MTFavorites) other;
        return Intrinsics.areEqual(this.formats, mTFavorites.formats) && Intrinsics.areEqual(this.setups, mTFavorites.setups);
    }

    public final List<MTFavoriteFormat> getFormats() {
        return this.formats;
    }

    public final List<MTFavoriteSetup> getSetups() {
        return this.setups;
    }

    public int hashCode() {
        List<MTFavoriteFormat> list = this.formats;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTFavoriteSetup> list2 = this.setups;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setFormats(List<MTFavoriteFormat> list) {
        this.formats = list;
    }

    public final void setSetups(List<MTFavoriteSetup> list) {
        this.setups = list;
    }

    public String toString() {
        return "MTFavorites(formats=" + this.formats + ", setups=" + this.setups + ")";
    }
}
