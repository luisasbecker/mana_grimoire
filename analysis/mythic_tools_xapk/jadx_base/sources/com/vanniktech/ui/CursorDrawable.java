package com.vanniktech.ui;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidThemingHacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/vanniktech/ui/CursorDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "color", "Lcom/vanniktech/ui/Color;", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "setTint", "", "tintColor", "", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CursorDrawable extends GradientDrawable {
    private CursorDrawable(int i) {
        super(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, i});
    }

    public /* synthetic */ CursorDrawable(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int tintColor) {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
    }
}
