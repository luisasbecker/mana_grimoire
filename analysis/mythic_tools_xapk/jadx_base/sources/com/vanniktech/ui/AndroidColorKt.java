package com.vanniktech.ui;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: AndroidColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0018*\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 \u001a%\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010\u000f\u001a\u00020'*\u00020'2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010(\u001a\u0012\u0010)\u001a\u00020\u0001*\u00020\b2\u0006\u0010*\u001a\u00020+\u001a#\u0010,\u001a\u00020\u0001*\u00020-2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020/¢\u0006\u0004\b0\u00101¨\u00062"}, d2 = {"setBackgroundColor", "", "Landroid/view/View;", "color", "Lcom/vanniktech/ui/Color;", "setBackgroundColor-xAbW3D8", "(Landroid/view/View;I)V", "setTextColor", "Landroid/widget/TextView;", "setTextColor-xAbW3D8", "(Landroid/widget/TextView;I)V", "setCardBackgroundColor", "Landroidx/cardview/widget/CardView;", "setCardBackgroundColor-xAbW3D8", "(Landroidx/cardview/widget/CardView;I)V", "setColor", "Landroid/graphics/Paint;", "setColor-xAbW3D8", "(Landroid/graphics/Paint;I)V", "ColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "ColorDrawable-XxRhnUA", "(I)Landroid/graphics/drawable/ColorDrawable;", "colorStateList", "Landroid/content/res/ColorStateList;", "colorStateList-XxRhnUA", "(I)Landroid/content/res/ColorStateList;", "coloredText", "Landroid/text/SpannableString;", "text", "", "coloredText-yAn5-nI", "(ILjava/lang/CharSequence;)Landroid/text/SpannableString;", ServerProtocol.DIALOG_PARAM_STATE, "", DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF, "colorStateList-FUHGC9k", "(III)Landroid/content/res/ColorStateList;", "Landroidx/core/app/NotificationCompat$Builder;", "(Landroidx/core/app/NotificationCompat$Builder;I)Landroidx/core/app/NotificationCompat$Builder;", "setTextSizeSp", "sp", "", "tintIcon", "Landroid/widget/ImageView;", "mode", "Landroid/graphics/PorterDuff$Mode;", "tintIcon-EFWIcRY", "(Landroid/widget/ImageView;ILandroid/graphics/PorterDuff$Mode;)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidColorKt {
    /* JADX INFO: renamed from: ColorDrawable-XxRhnUA, reason: not valid java name */
    public static final ColorDrawable m11317ColorDrawableXxRhnUA(int i) {
        return new ColorDrawable(i);
    }

    /* JADX INFO: renamed from: colorStateList-FUHGC9k, reason: not valid java name */
    public static final ColorStateList m11318colorStateListFUHGC9k(int i, int i2, int i3) {
        return new ColorStateList(new int[][]{new int[]{i}, new int[]{-i}}, new int[]{i2, i3});
    }

    /* JADX INFO: renamed from: colorStateList-XxRhnUA, reason: not valid java name */
    public static final ColorStateList m11319colorStateListXxRhnUA(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    /* JADX INFO: renamed from: coloredText-yAn5-nI, reason: not valid java name */
    public static final SpannableString m11320coloredTextyAn5nI(int i, CharSequence charSequence) {
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, charSequence.length(), 18);
        return spannableString;
    }

    /* JADX INFO: renamed from: setBackgroundColor-xAbW3D8, reason: not valid java name */
    public static final void m11321setBackgroundColorxAbW3D8(View setBackgroundColor, int i) {
        Intrinsics.checkNotNullParameter(setBackgroundColor, "$this$setBackgroundColor");
        setBackgroundColor.setBackgroundColor(i);
    }

    /* JADX INFO: renamed from: setCardBackgroundColor-xAbW3D8, reason: not valid java name */
    public static final void m11322setCardBackgroundColorxAbW3D8(CardView setCardBackgroundColor, int i) {
        Intrinsics.checkNotNullParameter(setCardBackgroundColor, "$this$setCardBackgroundColor");
        setCardBackgroundColor.setCardBackgroundColor(i);
    }

    /* JADX INFO: renamed from: setColor-xAbW3D8, reason: not valid java name */
    public static final NotificationCompat.Builder m11323setColorxAbW3D8(NotificationCompat.Builder setColor, int i) {
        Intrinsics.checkNotNullParameter(setColor, "$this$setColor");
        NotificationCompat.Builder color = setColor.setColor(i);
        Intrinsics.checkNotNullExpressionValue(color, "setColor(...)");
        return color;
    }

    /* JADX INFO: renamed from: setColor-xAbW3D8, reason: not valid java name */
    public static final void m11324setColorxAbW3D8(Paint setColor, int i) {
        Intrinsics.checkNotNullParameter(setColor, "$this$setColor");
        setColor.setColor(i);
    }

    /* JADX INFO: renamed from: setTextColor-xAbW3D8, reason: not valid java name */
    public static final void m11325setTextColorxAbW3D8(TextView setTextColor, int i) {
        Intrinsics.checkNotNullParameter(setTextColor, "$this$setTextColor");
        setTextColor.setTextColor(i);
    }

    public static final void setTextSizeSp(TextView textView, float f) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextSize(2, f);
    }

    /* JADX INFO: renamed from: tintIcon-EFWIcRY, reason: not valid java name */
    public static final void m11326tintIconEFWIcRY(ImageView tintIcon, int i, PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(tintIcon, "$this$tintIcon");
        Intrinsics.checkNotNullParameter(mode, "mode");
        tintIcon.setColorFilter(i, mode);
    }

    /* JADX INFO: renamed from: tintIcon-EFWIcRY$default, reason: not valid java name */
    public static /* synthetic */ void m11327tintIconEFWIcRY$default(ImageView imageView, int i, PorterDuff.Mode mode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        m11326tintIconEFWIcRY(imageView, i, mode);
    }
}
