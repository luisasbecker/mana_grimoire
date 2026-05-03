package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImageUris;", "Landroid/os/Parcelable;", "small", "", "normal", "large", "png", "border_crop", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSmall", "()Ljava/lang/String;", "getNormal", "getLarge", "getPng", "getBorder_crop", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageUris implements Parcelable {
    private final String border_crop;
    private final String large;
    private final String normal;
    private final String png;
    private final String small;
    public static final Parcelable.Creator<ImageUris> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageUris> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageUris createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageUris(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageUris[] newArray(int i) {
            return new ImageUris[i];
        }
    }

    public ImageUris() {
        this(null, null, null, null, null, 31, null);
    }

    public ImageUris(String small, String normal, String large, String png, String border_crop) {
        Intrinsics.checkNotNullParameter(small, "small");
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(large, "large");
        Intrinsics.checkNotNullParameter(png, "png");
        Intrinsics.checkNotNullParameter(border_crop, "border_crop");
        this.small = small;
        this.normal = normal;
        this.large = large;
        this.png = png;
        this.border_crop = border_crop;
    }

    public /* synthetic */ ImageUris(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    public static /* synthetic */ ImageUris copy$default(ImageUris imageUris, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageUris.small;
        }
        if ((i & 2) != 0) {
            str2 = imageUris.normal;
        }
        if ((i & 4) != 0) {
            str3 = imageUris.large;
        }
        if ((i & 8) != 0) {
            str4 = imageUris.png;
        }
        if ((i & 16) != 0) {
            str5 = imageUris.border_crop;
        }
        String str6 = str5;
        String str7 = str3;
        return imageUris.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSmall() {
        return this.small;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNormal() {
        return this.normal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLarge() {
        return this.large;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPng() {
        return this.png;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBorder_crop() {
        return this.border_crop;
    }

    public final ImageUris copy(String small, String normal, String large, String png, String border_crop) {
        Intrinsics.checkNotNullParameter(small, "small");
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(large, "large");
        Intrinsics.checkNotNullParameter(png, "png");
        Intrinsics.checkNotNullParameter(border_crop, "border_crop");
        return new ImageUris(small, normal, large, png, border_crop);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageUris)) {
            return false;
        }
        ImageUris imageUris = (ImageUris) other;
        return Intrinsics.areEqual(this.small, imageUris.small) && Intrinsics.areEqual(this.normal, imageUris.normal) && Intrinsics.areEqual(this.large, imageUris.large) && Intrinsics.areEqual(this.png, imageUris.png) && Intrinsics.areEqual(this.border_crop, imageUris.border_crop);
    }

    public final String getBorder_crop() {
        return this.border_crop;
    }

    public final String getLarge() {
        return this.large;
    }

    public final String getNormal() {
        return this.normal;
    }

    public final String getPng() {
        return this.png;
    }

    public final String getSmall() {
        return this.small;
    }

    public int hashCode() {
        return (((((((this.small.hashCode() * 31) + this.normal.hashCode()) * 31) + this.large.hashCode()) * 31) + this.png.hashCode()) * 31) + this.border_crop.hashCode();
    }

    public String toString() {
        return "ImageUris(small=" + this.small + ", normal=" + this.normal + ", large=" + this.large + ", png=" + this.png + ", border_crop=" + this.border_crop + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.small);
        dest.writeString(this.normal);
        dest.writeString(this.large);
        dest.writeString(this.png);
        dest.writeString(this.border_crop);
    }
}
