package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jg\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010!\u001a\u00020\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/CardFace;", "Landroid/os/Parcelable;", "name", "", "printed_name", "mana_cost", "type_line", "printed_type_line", "oracle_text", "printed_text", "image_uris", "Lcom/studiolaganne/lengendarylens/ImageUris;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/ImageUris;)V", "getName", "()Ljava/lang/String;", "getPrinted_name", "getMana_cost", "getType_line", "getPrinted_type_line", "getOracle_text", "getPrinted_text", "getImage_uris", "()Lcom/studiolaganne/lengendarylens/ImageUris;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardFace implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CardFace> CREATOR = new Creator();
    private final ImageUris image_uris;
    private final String mana_cost;
    private final String name;
    private final String oracle_text;
    private final String printed_name;
    private final String printed_text;
    private final String printed_type_line;
    private final String type_line;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CardFace> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardFace createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CardFace(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : ImageUris.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardFace[] newArray(int i) {
            return new CardFace[i];
        }
    }

    public CardFace() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public CardFace(String name, String str, String str2, String str3, String str4, String str5, String str6, ImageUris imageUris) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.printed_name = str;
        this.mana_cost = str2;
        this.type_line = str3;
        this.printed_type_line = str4;
        this.oracle_text = str5;
        this.printed_text = str6;
        this.image_uris = imageUris;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ CardFace(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, com.studiolaganne.lengendarylens.ImageUris r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto Lc
            r3 = r0
        Lc:
            r11 = r10 & 4
            if (r11 == 0) goto L11
            r4 = r0
        L11:
            r11 = r10 & 8
            if (r11 == 0) goto L16
            r5 = r0
        L16:
            r11 = r10 & 16
            if (r11 == 0) goto L1b
            r6 = r0
        L1b:
            r11 = r10 & 32
            if (r11 == 0) goto L20
            r7 = r0
        L20:
            r11 = r10 & 64
            if (r11 == 0) goto L25
            r8 = r0
        L25:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L33
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L3c
        L33:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L3c:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.CardFace.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.ImageUris, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ CardFace copy$default(CardFace cardFace, String str, String str2, String str3, String str4, String str5, String str6, String str7, ImageUris imageUris, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardFace.name;
        }
        if ((i & 2) != 0) {
            str2 = cardFace.printed_name;
        }
        if ((i & 4) != 0) {
            str3 = cardFace.mana_cost;
        }
        if ((i & 8) != 0) {
            str4 = cardFace.type_line;
        }
        if ((i & 16) != 0) {
            str5 = cardFace.printed_type_line;
        }
        if ((i & 32) != 0) {
            str6 = cardFace.oracle_text;
        }
        if ((i & 64) != 0) {
            str7 = cardFace.printed_text;
        }
        if ((i & 128) != 0) {
            imageUris = cardFace.image_uris;
        }
        String str8 = str7;
        ImageUris imageUris2 = imageUris;
        String str9 = str5;
        String str10 = str6;
        return cardFace.copy(str, str2, str3, str4, str9, str10, str8, imageUris2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMana_cost() {
        return this.mana_cost;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPrinted_text() {
        return this.printed_text;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ImageUris getImage_uris() {
        return this.image_uris;
    }

    public final CardFace copy(String name, String printed_name, String mana_cost, String type_line, String printed_type_line, String oracle_text, String printed_text, ImageUris image_uris) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CardFace(name, printed_name, mana_cost, type_line, printed_type_line, oracle_text, printed_text, image_uris);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardFace)) {
            return false;
        }
        CardFace cardFace = (CardFace) other;
        return Intrinsics.areEqual(this.name, cardFace.name) && Intrinsics.areEqual(this.printed_name, cardFace.printed_name) && Intrinsics.areEqual(this.mana_cost, cardFace.mana_cost) && Intrinsics.areEqual(this.type_line, cardFace.type_line) && Intrinsics.areEqual(this.printed_type_line, cardFace.printed_type_line) && Intrinsics.areEqual(this.oracle_text, cardFace.oracle_text) && Intrinsics.areEqual(this.printed_text, cardFace.printed_text) && Intrinsics.areEqual(this.image_uris, cardFace.image_uris);
    }

    public final ImageUris getImage_uris() {
        return this.image_uris;
    }

    public final String getMana_cost() {
        return this.mana_cost;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final String getPrinted_name() {
        return this.printed_name;
    }

    public final String getPrinted_text() {
        return this.printed_text;
    }

    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.printed_name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mana_cost;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type_line;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.printed_type_line;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.oracle_text;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.printed_text;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageUris imageUris = this.image_uris;
        return iHashCode7 + (imageUris != null ? imageUris.hashCode() : 0);
    }

    public String toString() {
        return "CardFace(name=" + this.name + ", printed_name=" + this.printed_name + ", mana_cost=" + this.mana_cost + ", type_line=" + this.type_line + ", printed_type_line=" + this.printed_type_line + ", oracle_text=" + this.oracle_text + ", printed_text=" + this.printed_text + ", image_uris=" + this.image_uris + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.printed_name);
        dest.writeString(this.mana_cost);
        dest.writeString(this.type_line);
        dest.writeString(this.printed_type_line);
        dest.writeString(this.oracle_text);
        dest.writeString(this.printed_text);
        ImageUris imageUris = this.image_uris;
        if (imageUris == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            imageUris.writeToParcel(dest, flags);
        }
    }
}
