package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0018\u001a\u00020\bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSet;", "Landroid/os/Parcelable;", "name", "", "icon_svg_uri", "code", "released_at", "card_count", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getIcon_svg_uri", "getCode", "getReleased_at", "getCard_count", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardSet implements Parcelable {
    private final int card_count;
    private final String code;
    private final String icon_svg_uri;
    private final String name;
    private final String released_at;
    public static final Parcelable.Creator<CardSet> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CardSet> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardSet createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CardSet(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardSet[] newArray(int i) {
            return new CardSet[i];
        }
    }

    public CardSet(String name, String icon_svg_uri, String code, String released_at, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon_svg_uri, "icon_svg_uri");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(released_at, "released_at");
        this.name = name;
        this.icon_svg_uri = icon_svg_uri;
        this.code = code;
        this.released_at = released_at;
        this.card_count = i;
    }

    public static /* synthetic */ CardSet copy$default(CardSet cardSet, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cardSet.name;
        }
        if ((i2 & 2) != 0) {
            str2 = cardSet.icon_svg_uri;
        }
        if ((i2 & 4) != 0) {
            str3 = cardSet.code;
        }
        if ((i2 & 8) != 0) {
            str4 = cardSet.released_at;
        }
        if ((i2 & 16) != 0) {
            i = cardSet.card_count;
        }
        int i3 = i;
        String str5 = str3;
        return cardSet.copy(str, str2, str5, str4, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIcon_svg_uri() {
        return this.icon_svg_uri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getReleased_at() {
        return this.released_at;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCard_count() {
        return this.card_count;
    }

    public final CardSet copy(String name, String icon_svg_uri, String code, String released_at, int card_count) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon_svg_uri, "icon_svg_uri");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(released_at, "released_at");
        return new CardSet(name, icon_svg_uri, code, released_at, card_count);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardSet)) {
            return false;
        }
        CardSet cardSet = (CardSet) other;
        return Intrinsics.areEqual(this.name, cardSet.name) && Intrinsics.areEqual(this.icon_svg_uri, cardSet.icon_svg_uri) && Intrinsics.areEqual(this.code, cardSet.code) && Intrinsics.areEqual(this.released_at, cardSet.released_at) && this.card_count == cardSet.card_count;
    }

    public final int getCard_count() {
        return this.card_count;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getIcon_svg_uri() {
        return this.icon_svg_uri;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReleased_at() {
        return this.released_at;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.icon_svg_uri.hashCode()) * 31) + this.code.hashCode()) * 31) + this.released_at.hashCode()) * 31) + Integer.hashCode(this.card_count);
    }

    public String toString() {
        return "CardSet(name=" + this.name + ", icon_svg_uri=" + this.icon_svg_uri + ", code=" + this.code + ", released_at=" + this.released_at + ", card_count=" + this.card_count + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.icon_svg_uri);
        dest.writeString(this.code);
        dest.writeString(this.released_at);
        dest.writeInt(this.card_count);
    }
}
