package com.vanniktech.ui.theming;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.vanniktech.ui.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: ThemingColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00060\u0002j\u0002`\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\tJ$\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eR\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006)"}, d2 = {"Lcom/vanniktech/ui/theming/ThemingColor;", "Lcom/vanniktech/ui/UiParcelable;", "Landroid/os/Parcelable;", "light", "Lcom/vanniktech/ui/Color;", "dark", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLight-oEAH0UE", "()I", "I", "getDark-oEAH0UE", "with", "alpha", "", "mapped", "isNight", "", "mapped-3BSO9UY", "(Z)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "component1", "component1-oEAH0UE", "component2", "component2-oEAH0UE", "copy", "copy-NnySmFY", "(II)Lcom/vanniktech/ui/theming/ThemingColor;", "describeContents", "", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable(with = ThemingColorSerializer.class)
public final /* data */ class ThemingColor implements Parcelable {
    private final int dark;
    private final int light;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ThemingColor> CREATOR = new Creator();

    /* JADX INFO: compiled from: ThemingColor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¨\u0006\f"}, d2 = {"Lcom/vanniktech/ui/theming/ThemingColor$Companion;", "", "<init>", "()V", "single", "Lcom/vanniktech/ui/theming/ThemingColor;", "color", "Lcom/vanniktech/ui/Color;", "single-XxRhnUA", "(I)Lcom/vanniktech/ui/theming/ThemingColor;", "serializer", "Lkotlinx/serialization/KSerializer;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ThemingColor> serializer() {
            return ThemingColorSerializer.INSTANCE;
        }

        /* JADX INFO: renamed from: single-XxRhnUA, reason: not valid java name */
        public final ThemingColor m11409singleXxRhnUA(int color) {
            return new ThemingColor(color, color, null);
        }
    }

    /* JADX INFO: compiled from: ThemingColor.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ThemingColor> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThemingColor createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ThemingColor(Color.CREATOR.createFromParcel(parcel).m11388unboximpl(), Color.CREATOR.createFromParcel(parcel).m11388unboximpl(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThemingColor[] newArray(int i) {
            return new ThemingColor[i];
        }
    }

    private ThemingColor(int i, int i2) {
        this.light = i;
        this.dark = i2;
    }

    public /* synthetic */ ThemingColor(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    /* JADX INFO: renamed from: copy-NnySmFY$default, reason: not valid java name */
    public static /* synthetic */ ThemingColor m11402copyNnySmFY$default(ThemingColor themingColor, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = themingColor.light;
        }
        if ((i3 & 2) != 0) {
            i2 = themingColor.dark;
        }
        return themingColor.m11405copyNnySmFY(i, i2);
    }

    /* JADX INFO: renamed from: component1-oEAH0UE, reason: not valid java name and from getter */
    public final int getLight() {
        return this.light;
    }

    /* JADX INFO: renamed from: component2-oEAH0UE, reason: not valid java name and from getter */
    public final int getDark() {
        return this.dark;
    }

    /* JADX INFO: renamed from: copy-NnySmFY, reason: not valid java name */
    public final ThemingColor m11405copyNnySmFY(int light, int dark) {
        return new ThemingColor(light, dark, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemingColor)) {
            return false;
        }
        ThemingColor themingColor = (ThemingColor) other;
        return Color.m11379equalsimpl0(this.light, themingColor.light) && Color.m11379equalsimpl0(this.dark, themingColor.dark);
    }

    /* JADX INFO: renamed from: getDark-oEAH0UE, reason: not valid java name */
    public final int m11406getDarkoEAH0UE() {
        return this.dark;
    }

    /* JADX INFO: renamed from: getLight-oEAH0UE, reason: not valid java name */
    public final int m11407getLightoEAH0UE() {
        return this.light;
    }

    public int hashCode() {
        return (Color.m11381hashCodeimpl(this.light) * 31) + Color.m11381hashCodeimpl(this.dark);
    }

    /* JADX INFO: renamed from: mapped-3BSO9UY, reason: not valid java name */
    public final int m11408mapped3BSO9UY(boolean isNight) {
        return isNight ? this.dark : this.light;
    }

    public String toString() {
        return "Light: " + Color.m11386toStringimpl(this.light) + ", Dark: " + Color.m11386toStringimpl(this.dark);
    }

    public final ThemingColor with(float alpha) {
        return new ThemingColor(Color.m11375copyONg3jNY$default(this.light, alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m11375copyONg3jNY$default(this.dark, alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Color.m11387writeToParcelimpl(this.light, dest, flags);
        Color.m11387writeToParcelimpl(this.dark, dest, flags);
    }
}
