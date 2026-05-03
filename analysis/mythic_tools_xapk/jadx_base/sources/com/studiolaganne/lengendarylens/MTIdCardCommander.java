package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCommander;", "", "name", "", "printedName", "imageUris", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getPrintedName", "getImageUris", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCommander {
    public static final int $stable = 8;

    @SerializedName("image_uris")
    private final Map<String, String> imageUris;
    private final String name;

    @SerializedName("printed_name")
    private final String printedName;

    public MTIdCardCommander() {
        this(null, null, null, 7, null);
    }

    public MTIdCardCommander(String str, String str2, Map<String, String> map) {
        this.name = str;
        this.printedName = str2;
        this.imageUris = map;
    }

    public /* synthetic */ MTIdCardCommander(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardCommander copy$default(MTIdCardCommander mTIdCardCommander, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardCommander.name;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardCommander.printedName;
        }
        if ((i & 4) != 0) {
            map = mTIdCardCommander.imageUris;
        }
        return mTIdCardCommander.copy(str, str2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrintedName() {
        return this.printedName;
    }

    public final Map<String, String> component3() {
        return this.imageUris;
    }

    public final MTIdCardCommander copy(String name, String printedName, Map<String, String> imageUris) {
        return new MTIdCardCommander(name, printedName, imageUris);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCommander)) {
            return false;
        }
        MTIdCardCommander mTIdCardCommander = (MTIdCardCommander) other;
        return Intrinsics.areEqual(this.name, mTIdCardCommander.name) && Intrinsics.areEqual(this.printedName, mTIdCardCommander.printedName) && Intrinsics.areEqual(this.imageUris, mTIdCardCommander.imageUris);
    }

    public final Map<String, String> getImageUris() {
        return this.imageUris;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrintedName() {
        return this.printedName;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.printedName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.imageUris;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardCommander(name=" + this.name + ", printedName=" + this.printedName + ", imageUris=" + this.imageUris + ")";
    }
}
