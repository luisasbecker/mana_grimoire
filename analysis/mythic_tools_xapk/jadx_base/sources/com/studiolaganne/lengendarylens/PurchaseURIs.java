package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/PurchaseURIs;", "Landroid/os/Parcelable;", "tcgplayer", "", "cardmarket", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTcgplayer", "()Ljava/lang/String;", "getCardmarket", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PurchaseURIs implements Parcelable {
    private final String cardmarket;
    private final String tcgplayer;
    public static final Parcelable.Creator<PurchaseURIs> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PurchaseURIs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchaseURIs createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurchaseURIs(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchaseURIs[] newArray(int i) {
            return new PurchaseURIs[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchaseURIs() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PurchaseURIs(String str, String str2) {
        this.tcgplayer = str;
        this.cardmarket = str2;
    }

    public /* synthetic */ PurchaseURIs(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ PurchaseURIs copy$default(PurchaseURIs purchaseURIs, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = purchaseURIs.tcgplayer;
        }
        if ((i & 2) != 0) {
            str2 = purchaseURIs.cardmarket;
        }
        return purchaseURIs.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTcgplayer() {
        return this.tcgplayer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCardmarket() {
        return this.cardmarket;
    }

    public final PurchaseURIs copy(String tcgplayer, String cardmarket) {
        return new PurchaseURIs(tcgplayer, cardmarket);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseURIs)) {
            return false;
        }
        PurchaseURIs purchaseURIs = (PurchaseURIs) other;
        return Intrinsics.areEqual(this.tcgplayer, purchaseURIs.tcgplayer) && Intrinsics.areEqual(this.cardmarket, purchaseURIs.cardmarket);
    }

    public final String getCardmarket() {
        return this.cardmarket;
    }

    public final String getTcgplayer() {
        return this.tcgplayer;
    }

    public int hashCode() {
        String str = this.tcgplayer;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardmarket;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PurchaseURIs(tcgplayer=" + this.tcgplayer + ", cardmarket=" + this.cardmarket + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.tcgplayer);
        dest.writeString(this.cardmarket);
    }
}
