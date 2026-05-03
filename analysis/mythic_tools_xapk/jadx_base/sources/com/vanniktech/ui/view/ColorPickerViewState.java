package com.vanniktech.ui.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.vanniktech.ui.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorPickerViewState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00060\u0003j\u0002`\u0002B'\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001b\u0010\u0004\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/vanniktech/ui/view/ColorPickerViewState;", "Landroid/view/View$BaseSavedState;", "Lcom/vanniktech/ui/UiParcelable;", "Landroid/os/Parcelable;", "superSavedState", "color", "Lcom/vanniktech/ui/Color;", "supportsAlpha", "", "<init>", "(Landroid/os/Parcelable;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSuperSavedState", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "getColor-oEAH0UE", "()I", "I", "getSupportsAlpha", "()Z", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorPickerViewState extends View.BaseSavedState implements Parcelable {
    public static final Parcelable.Creator<ColorPickerViewState> CREATOR = new Creator();
    private final int color;
    private final Parcelable superSavedState;
    private final boolean supportsAlpha;

    /* JADX INFO: compiled from: ColorPickerViewState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ColorPickerViewState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ColorPickerViewState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ColorPickerViewState(parcel.readParcelable(ColorPickerViewState.class.getClassLoader()), Color.CREATOR.createFromParcel(parcel).m11388unboximpl(), parcel.readInt() != 0, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ColorPickerViewState[] newArray(int i) {
            return new ColorPickerViewState[i];
        }
    }

    private ColorPickerViewState(Parcelable parcelable, int i, boolean z) {
        super(parcelable);
        this.superSavedState = parcelable;
        this.color = i;
        this.supportsAlpha = z;
    }

    public /* synthetic */ ColorPickerViewState(Parcelable parcelable, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcelable, i, z);
    }

    /* JADX INFO: renamed from: getColor-oEAH0UE, reason: not valid java name and from getter */
    public final int getColor() {
        return this.color;
    }

    public final Parcelable getSuperSavedState() {
        return this.superSavedState;
    }

    public final boolean getSupportsAlpha() {
        return this.supportsAlpha;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.superSavedState, flags);
        Color.m11387writeToParcelimpl(this.color, dest, flags);
        dest.writeInt(this.supportsAlpha ? 1 : 0);
    }
}
