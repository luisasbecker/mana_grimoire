package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/Annotation;", "Landroid/os/Parcelable;", Constants.ScionAnalytics.PARAM_LABEL, "", "coordinates", "Lcom/studiolaganne/lengendarylens/Coordinates;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/Coordinates;)V", "getLabel", "()Ljava/lang/String;", "getCoordinates", "()Lcom/studiolaganne/lengendarylens/Coordinates;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Annotation implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<Annotation> CREATOR = new Creator();
    private final Coordinates coordinates;
    private final String label;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Annotation> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Annotation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Annotation(parcel.readString(), parcel.readInt() == 0 ? null : Coordinates.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Annotation[] newArray(int i) {
            return new Annotation[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Annotation() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Annotation(String label, Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.coordinates = coordinates;
    }

    public /* synthetic */ Annotation(String str, Coordinates coordinates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : coordinates);
    }

    public static /* synthetic */ Annotation copy$default(Annotation annotation, String str, Coordinates coordinates, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annotation.label;
        }
        if ((i & 2) != 0) {
            coordinates = annotation.coordinates;
        }
        return annotation.copy(str, coordinates);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final Annotation copy(String label, Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new Annotation(label, coordinates);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) other;
        return Intrinsics.areEqual(this.label, annotation.label) && Intrinsics.areEqual(this.coordinates, annotation.coordinates);
    }

    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        Coordinates coordinates = this.coordinates;
        return iHashCode + (coordinates == null ? 0 : coordinates.hashCode());
    }

    public String toString() {
        return "Annotation(label=" + this.label + ", coordinates=" + this.coordinates + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.label);
        Coordinates coordinates = this.coordinates;
        if (coordinates == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            coordinates.writeToParcel(dest, flags);
        }
    }
}
