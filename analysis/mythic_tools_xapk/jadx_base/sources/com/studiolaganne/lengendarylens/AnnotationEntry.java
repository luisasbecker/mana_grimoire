package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MimeTypes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/AnnotationEntry;", "Landroid/os/Parcelable;", MimeTypes.BASE_TYPE_IMAGE, "", "annotations", "", "Lcom/studiolaganne/lengendarylens/Annotation;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getImage", "()Ljava/lang/String;", "getAnnotations", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationEntry implements Parcelable {
    private final List<Annotation> annotations;
    private final String image;
    public static final Parcelable.Creator<AnnotationEntry> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AnnotationEntry> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnnotationEntry createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Annotation.CREATOR.createFromParcel(parcel));
            }
            return new AnnotationEntry(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnnotationEntry[] newArray(int i) {
            return new AnnotationEntry[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationEntry() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public AnnotationEntry(String image, List<Annotation> annotations) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.image = image;
        this.annotations = annotations;
    }

    public /* synthetic */ AnnotationEntry(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationEntry copy$default(AnnotationEntry annotationEntry, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annotationEntry.image;
        }
        if ((i & 2) != 0) {
            list = annotationEntry.annotations;
        }
        return annotationEntry.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final List<Annotation> component2() {
        return this.annotations;
    }

    public final AnnotationEntry copy(String image, List<Annotation> annotations) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return new AnnotationEntry(image, annotations);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationEntry)) {
            return false;
        }
        AnnotationEntry annotationEntry = (AnnotationEntry) other;
        return Intrinsics.areEqual(this.image, annotationEntry.image) && Intrinsics.areEqual(this.annotations, annotationEntry.annotations);
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public final String getImage() {
        return this.image;
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + this.annotations.hashCode();
    }

    public String toString() {
        return "AnnotationEntry(image=" + this.image + ", annotations=" + this.annotations + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.image);
        List<Annotation> list = this.annotations;
        dest.writeInt(list.size());
        Iterator<Annotation> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
