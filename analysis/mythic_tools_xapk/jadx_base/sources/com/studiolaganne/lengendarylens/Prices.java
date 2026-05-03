package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/Prices;", "Landroid/os/Parcelable;", "usd", "", "usd_foil", "eur", "eur_foil", "tix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUsd", "()Ljava/lang/String;", "getUsd_foil", "getEur", "getEur_foil", "getTix", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Prices implements Parcelable {
    private final String eur;
    private final String eur_foil;
    private final String tix;
    private final String usd;
    private final String usd_foil;
    public static final Parcelable.Creator<Prices> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Prices> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Prices createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Prices(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Prices[] newArray(int i) {
            return new Prices[i];
        }
    }

    public Prices() {
        this(null, null, null, null, null, 31, null);
    }

    public Prices(String str, String str2, String str3, String str4, String str5) {
        this.usd = str;
        this.usd_foil = str2;
        this.eur = str3;
        this.eur_foil = str4;
        this.tix = str5;
    }

    public /* synthetic */ Prices(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ Prices copy$default(Prices prices, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prices.usd;
        }
        if ((i & 2) != 0) {
            str2 = prices.usd_foil;
        }
        if ((i & 4) != 0) {
            str3 = prices.eur;
        }
        if ((i & 8) != 0) {
            str4 = prices.eur_foil;
        }
        if ((i & 16) != 0) {
            str5 = prices.tix;
        }
        String str6 = str5;
        String str7 = str3;
        return prices.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsd() {
        return this.usd;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsd_foil() {
        return this.usd_foil;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEur() {
        return this.eur;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEur_foil() {
        return this.eur_foil;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTix() {
        return this.tix;
    }

    public final Prices copy(String usd, String usd_foil, String eur, String eur_foil, String tix) {
        return new Prices(usd, usd_foil, eur, eur_foil, tix);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Prices)) {
            return false;
        }
        Prices prices = (Prices) other;
        return Intrinsics.areEqual(this.usd, prices.usd) && Intrinsics.areEqual(this.usd_foil, prices.usd_foil) && Intrinsics.areEqual(this.eur, prices.eur) && Intrinsics.areEqual(this.eur_foil, prices.eur_foil) && Intrinsics.areEqual(this.tix, prices.tix);
    }

    public final String getEur() {
        return this.eur;
    }

    public final String getEur_foil() {
        return this.eur_foil;
    }

    public final String getTix() {
        return this.tix;
    }

    public final String getUsd() {
        return this.usd;
    }

    public final String getUsd_foil() {
        return this.usd_foil;
    }

    public int hashCode() {
        String str = this.usd;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.usd_foil;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.eur;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.eur_foil;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tix;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "Prices(usd=" + this.usd + ", usd_foil=" + this.usd_foil + ", eur=" + this.eur + ", eur_foil=" + this.eur_foil + ", tix=" + this.tix + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.usd);
        dest.writeString(this.usd_foil);
        dest.writeString(this.eur);
        dest.writeString(this.eur_foil);
        dest.writeString(this.tix);
    }
}
