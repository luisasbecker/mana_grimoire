package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PrivacyPopupMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrivacyPopupMenu;", "", "context", "Landroid/content/Context;", "currentType", "", "privacyContext", "Lcom/studiolaganne/lengendarylens/PrivacyContext;", "onPrivacySelected", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/PrivacyContext;Lkotlin/jvm/functions/Function1;)V", "entityName", "entityPronoun", "levels", "", "Lcom/studiolaganne/lengendarylens/PrivacyPopupMenu$PrivacyLevel;", "show", "anchor", "Landroid/view/View;", "alignEnd", "", "PrivacyLevel", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrivacyPopupMenu {
    public static final int $stable = 8;
    private final Context context;
    private final String currentType;
    private final String entityName;
    private final String entityPronoun;
    private final List<PrivacyLevel> levels;
    private final Function1<String, Unit> onPrivacySelected;
    private final PrivacyContext privacyContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PrivacyPopupMenu.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrivacyPopupMenu$PrivacyLevel;", "", "type", "", "labelRes", "", "descriptionRes", "colorRes", "<init>", "(Ljava/lang/String;III)V", "getType", "()Ljava/lang/String;", "getLabelRes", "()I", "getDescriptionRes", "getColorRes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class PrivacyLevel {
        private final int colorRes;
        private final int descriptionRes;
        private final int labelRes;
        private final String type;

        public PrivacyLevel(String type, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.labelRes = i;
            this.descriptionRes = i2;
            this.colorRes = i3;
        }

        public static /* synthetic */ PrivacyLevel copy$default(PrivacyLevel privacyLevel, String str, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = privacyLevel.type;
            }
            if ((i4 & 2) != 0) {
                i = privacyLevel.labelRes;
            }
            if ((i4 & 4) != 0) {
                i2 = privacyLevel.descriptionRes;
            }
            if ((i4 & 8) != 0) {
                i3 = privacyLevel.colorRes;
            }
            return privacyLevel.copy(str, i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLabelRes() {
            return this.labelRes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getDescriptionRes() {
            return this.descriptionRes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getColorRes() {
            return this.colorRes;
        }

        public final PrivacyLevel copy(String type, int labelRes, int descriptionRes, int colorRes) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new PrivacyLevel(type, labelRes, descriptionRes, colorRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivacyLevel)) {
                return false;
            }
            PrivacyLevel privacyLevel = (PrivacyLevel) other;
            return Intrinsics.areEqual(this.type, privacyLevel.type) && this.labelRes == privacyLevel.labelRes && this.descriptionRes == privacyLevel.descriptionRes && this.colorRes == privacyLevel.colorRes;
        }

        public final int getColorRes() {
            return this.colorRes;
        }

        public final int getDescriptionRes() {
            return this.descriptionRes;
        }

        public final int getLabelRes() {
            return this.labelRes;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + Integer.hashCode(this.labelRes)) * 31) + Integer.hashCode(this.descriptionRes)) * 31) + Integer.hashCode(this.colorRes);
        }

        public String toString() {
            return "PrivacyLevel(type=" + this.type + ", labelRes=" + this.labelRes + ", descriptionRes=" + this.descriptionRes + ", colorRes=" + this.colorRes + ")";
        }
    }

    /* JADX INFO: compiled from: PrivacyPopupMenu.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrivacyContext.values().length];
            try {
                iArr[PrivacyContext.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivacyContext.DECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrivacyContext.PROFILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyPopupMenu(Context context, String currentType, PrivacyContext privacyContext, Function1<? super String, Unit> onPrivacySelected) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(currentType, "currentType");
        Intrinsics.checkNotNullParameter(privacyContext, "privacyContext");
        Intrinsics.checkNotNullParameter(onPrivacySelected, "onPrivacySelected");
        this.context = context;
        this.currentType = currentType;
        this.privacyContext = privacyContext;
        this.onPrivacySelected = onPrivacySelected;
        int i = WhenMappings.$EnumSwitchMapping$0[privacyContext.ordinal()];
        if (i == 1) {
            string = context.getString(R.string.privacy_entity_list);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else if (i == 2) {
            string = context.getString(R.string.privacy_entity_deck);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            string = context.getString(R.string.privacy_entity_profile);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        this.entityName = string;
        int i2 = WhenMappings.$EnumSwitchMapping$0[privacyContext.ordinal()];
        if (i2 == 1) {
            string2 = context.getString(R.string.privacy_entity_list_pronoun);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        } else if (i2 == 2) {
            string2 = context.getString(R.string.privacy_entity_deck_pronoun);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            string2 = context.getString(R.string.privacy_entity_profile_pronoun);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        this.entityPronoun = string2;
        this.levels = CollectionsKt.listOf((Object[]) new PrivacyLevel[]{new PrivacyLevel(MTApiKt.PRIVACY_TYPE_PRIVATE, R.string.privacy_private_label, R.string.privacy_private_description_generic, R.color.privacy_private), new PrivacyLevel(MTApiKt.PRIVACY_TYPE_SHARED, R.string.privacy_shared_label, R.string.privacy_shared_description_generic, R.color.privacy_shared), new PrivacyLevel(MTApiKt.PRIVACY_TYPE_UNLISTED, R.string.privacy_unlisted_label, R.string.privacy_unlisted_description_generic, R.color.privacy_unlisted), new PrivacyLevel(MTApiKt.PRIVACY_TYPE_PUBLIC, R.string.privacy_public_label, R.string.privacy_public_description_generic, R.color.privacy_public)});
    }

    public /* synthetic */ PrivacyPopupMenu(Context context, String str, PrivacyContext privacyContext, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? PrivacyContext.LIST : privacyContext, function1);
    }

    public static /* synthetic */ void show$default(PrivacyPopupMenu privacyPopupMenu, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        privacyPopupMenu.show(view, z);
    }

    static final int show$lambda$0(PrivacyPopupMenu privacyPopupMenu, float f) {
        return (int) TypedValue.applyDimension(1, f, privacyPopupMenu.context.getResources().getDisplayMetrics());
    }

    static final void show$lambda$8(PrivacyPopupMenu privacyPopupMenu, PrivacyLevel privacyLevel, PopupWindow popupWindow, View view) {
        privacyPopupMenu.onPrivacySelected.invoke(privacyLevel.getType());
        popupWindow.dismiss();
    }

    public final void show(View anchor, boolean alignEnd) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.PrivacyPopupMenu$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(PrivacyPopupMenu.show$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        };
        Typeface font = ResourcesCompat.getFont(this.context, R.font.be_vietnam_pro_semibold);
        int color = ContextCompat.getColor(this.context, R.color.text_color_opaque);
        int color2 = ContextCompat.getColor(this.context, R.color.text_color);
        int iIntValue = ((Number) function1.invoke(Float.valueOf(300.0f))).intValue();
        Float fValueOf = Float.valueOf(10.0f);
        int iIntValue2 = ((Number) function1.invoke(fValueOf)).intValue();
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setClipChildren(true);
        linearLayout.setClipToOutline(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(linearLayout.getContext(), R.color.background_color));
        Float fValueOf2 = Float.valueOf(20.0f);
        gradientDrawable.setCornerRadius(((Number) function1.invoke(fValueOf2)).intValue());
        gradientDrawable.setStroke(2, ContextCompat.getColor(linearLayout.getContext(), R.color.text_color_very_transparent));
        linearLayout.setBackground(gradientDrawable);
        Float fValueOf3 = Float.valueOf(0.0f);
        linearLayout.setPadding(0, ((Number) function1.invoke(fValueOf3)).intValue(), 0, ((Number) function1.invoke(fValueOf3)).intValue());
        Float fValueOf4 = Float.valueOf(8.0f);
        linearLayout.setElevation(((Number) function1.invoke(fValueOf4)).intValue());
        final PopupWindow popupWindow = new PopupWindow(this.context);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(((Number) function1.invoke(fValueOf4)).intValue());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        Iterator<PrivacyLevel> it = this.levels.iterator();
        while (it.hasNext()) {
            final PrivacyLevel next = it.next();
            int i = color;
            boolean zAreEqual = Intrinsics.areEqual(next.getType(), this.currentType);
            int color3 = ContextCompat.getColor(this.context, next.getColorRes());
            Iterator<PrivacyLevel> it2 = it;
            LinearLayout linearLayout2 = new LinearLayout(this.context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(48);
            Float f = fValueOf2;
            Float f2 = fValueOf;
            linearLayout2.setPadding(((Number) function1.invoke(Float.valueOf(16.0f))).intValue(), ((Number) function1.invoke(fValueOf)).intValue(), ((Number) function1.invoke(fValueOf2)).intValue(), ((Number) function1.invoke(fValueOf)).intValue());
            if (zAreEqual) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(ContextCompat.getColor(linearLayout2.getContext(), R.color.overlay_white));
                linearLayout2.setBackground(gradientDrawable2);
            }
            TypedArray typedArrayObtainStyledAttributes = linearLayout2.getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            linearLayout2.setForeground(typedArrayObtainStyledAttributes.getDrawable(0));
            typedArrayObtainStyledAttributes.recycle();
            linearLayout2.setClickable(true);
            linearLayout2.setFocusable(true);
            View view = new View(this.context);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(1);
            gradientDrawable3.setColor(color3);
            view.setBackground(gradientDrawable3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iIntValue2, iIntValue2);
            layoutParams.setMarginEnd(((Number) function1.invoke(Float.valueOf(12.0f))).intValue());
            layoutParams.topMargin = ((Number) function1.invoke(fValueOf4)).intValue();
            view.setLayoutParams(layoutParams);
            linearLayout2.addView(view);
            LinearLayout linearLayout3 = new LinearLayout(this.context);
            linearLayout3.setOrientation(1);
            linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView = new TextView(this.context);
            textView.setText(textView.getContext().getString(next.getLabelRes()));
            textView.setTextColor(zAreEqual ? color3 : i);
            textView.setTextSize(15.0f);
            textView.setTypeface(font);
            linearLayout3.addView(textView);
            TextView textView2 = new TextView(this.context);
            textView2.setText(textView2.getContext().getString(next.getDescriptionRes(), this.entityName, this.entityPronoun));
            textView2.setTextColor(color2);
            textView2.setTextSize(12.0f);
            textView2.setPadding(0, ((Number) function1.invoke(Float.valueOf(2.0f))).intValue(), 0, 0);
            linearLayout3.addView(textView2);
            linearLayout2.addView(linearLayout3);
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PrivacyPopupMenu$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PrivacyPopupMenu.show$lambda$8(this.f$0, next, popupWindow, view2);
                }
            });
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            color = i;
            font = font;
            it = it2;
            fValueOf2 = f;
            fValueOf = f2;
        }
        popupWindow.setContentView(linearLayout);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(iIntValue, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = linearLayout.getMeasuredHeight();
        popupWindow.setWidth(measuredWidth);
        popupWindow.setHeight(measuredHeight);
        int[] iArr = new int[2];
        anchor.getLocationInWindow(iArr);
        int i2 = iArr[1];
        int i3 = this.context.getResources().getDisplayMetrics().heightPixels;
        int i4 = this.context.getResources().getDisplayMetrics().widthPixels;
        int iIntValue3 = ((Number) function1.invoke(fValueOf4)).intValue();
        int i5 = measuredHeight + iIntValue3;
        popupWindow.showAtLocation(anchor, 0, alignEnd ? RangesKt.coerceIn((iArr[0] + anchor.getWidth()) - measuredWidth, iIntValue3, (i4 - measuredWidth) - iIntValue3) : (i4 - measuredWidth) / 2, i3 - (anchor.getHeight() + i2) >= i5 ? i2 + anchor.getHeight() : i2 >= i5 ? i2 - measuredHeight : (i3 - measuredHeight) - iIntValue3);
    }
}
