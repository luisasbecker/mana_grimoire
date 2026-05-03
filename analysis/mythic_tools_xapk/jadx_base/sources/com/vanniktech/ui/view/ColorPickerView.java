package com.vanniktech.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.vanniktech.ui.AndroidColorKt;
import com.vanniktech.ui.AndroidEditTextExtensionsKt;
import com.vanniktech.ui.AndroidGoodiesKt;
import com.vanniktech.ui.AndroidViewKt;
import com.vanniktech.ui.Color;
import com.vanniktech.ui.ColorKt;
import com.vanniktech.ui.R;
import com.vanniktech.ui.databinding.UiViewColorPickerBinding;
import com.vanniktech.ui.theming.UiTheming;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorPickerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0010\u0018\u00002\u00020\u0001:\u0001,B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00060\u0016j\u0002`\u0015H\u0014¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0015H\u0014¢\u0006\u0002\u0010\u001bJ%\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000eH\u0000¢\u0006\u0004\b*\u0010+R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u001c\u001a\u00020\u000b*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/vanniktech/ui/view/ColorPickerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/vanniktech/ui/databinding/UiViewColorPickerBinding;", "color", "Lcom/vanniktech/ui/Color;", "I", "supportsAlpha", "", "hexEditTextWatcher", "com/vanniktech/ui/view/ColorPickerView$hexEditTextWatcher$1", "Lcom/vanniktech/ui/view/ColorPickerView$hexEditTextWatcher$1;", "color-oEAH0UE", "()I", "onSaveInstanceState", "Lcom/vanniktech/ui/UiParcelable;", "Landroid/os/Parcelable;", "()Landroid/os/Parcelable;", "onRestoreInstanceState", "", ServerProtocol.DIALOG_PARAM_STATE, "(Landroid/os/Parcelable;)V", "unified", "getUnified-ftSNO6c$ui_release", "(I)I", "setUp", "theming", "Lcom/vanniktech/ui/theming/UiTheming;", "strings", "Lcom/vanniktech/ui/view/ColorPickerStrings;", "selectedColor", "setUp-R8KKfwI", "(Lcom/vanniktech/ui/theming/UiTheming;Lcom/vanniktech/ui/view/ColorPickerStrings;I)V", "updateColor", "updated", "updateHexEditText", "updateColor-yAn5-nI$ui_release", "(IZ)V", "ColorPickerColorComponentDelegate", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorPickerView extends LinearLayout {
    private final UiViewColorPickerBinding binding;
    private int color;
    private final ColorPickerView$hexEditTextWatcher$1 hexEditTextWatcher;
    private boolean supportsAlpha;

    /* JADX INFO: compiled from: ColorPickerView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vanniktech/ui/view/ColorPickerView$ColorPickerColorComponentDelegate;", "Lcom/vanniktech/ui/view/ColorComponentDelegate;", "colorPickerView", "Lcom/vanniktech/ui/view/ColorPickerView;", "<init>", "(Lcom/vanniktech/ui/view/ColorPickerView;)V", "onComponentChanged", "", "componentChange", "Lcom/vanniktech/ui/view/ColorComponentChange;", "hideKeyboardAndFocus", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ColorPickerColorComponentDelegate implements ColorComponentDelegate {
        private final ColorPickerView colorPickerView;

        public ColorPickerColorComponentDelegate(ColorPickerView colorPickerView) {
            Intrinsics.checkNotNullParameter(colorPickerView, "colorPickerView");
            this.colorPickerView = colorPickerView;
        }

        @Override // com.vanniktech.ui.view.ColorComponentDelegate
        public void hideKeyboardAndFocus() {
            EditText hexEditText = this.colorPickerView.binding.hexEditText;
            Intrinsics.checkNotNullExpressionValue(hexEditText, "hexEditText");
            AndroidEditTextExtensionsKt.hideKeyboardAndFocus(hexEditText);
            this.colorPickerView.binding.red.hideKeyboardAndFocus();
            this.colorPickerView.binding.green.hideKeyboardAndFocus();
            this.colorPickerView.binding.blue.hideKeyboardAndFocus();
        }

        @Override // com.vanniktech.ui.view.ColorComponentDelegate
        public void onComponentChanged(ColorComponentChange componentChange) {
            int iM11376copyONg3jNY$default;
            Intrinsics.checkNotNullParameter(componentChange, "componentChange");
            ColorComponentView origin = componentChange.getOrigin();
            boolean zAreEqual = Intrinsics.areEqual(origin, this.colorPickerView.binding.alpha);
            ColorPickerView colorPickerView = this.colorPickerView;
            if (zAreEqual) {
                iM11376copyONg3jNY$default = Color.m11376copyONg3jNY$default(colorPickerView.color, componentChange.getValue(), 0, 0, 0, 14, (Object) null);
            } else {
                boolean zAreEqual2 = Intrinsics.areEqual(origin, colorPickerView.binding.red);
                ColorPickerView colorPickerView2 = this.colorPickerView;
                if (zAreEqual2) {
                    iM11376copyONg3jNY$default = Color.m11376copyONg3jNY$default(colorPickerView2.color, 0, componentChange.getValue(), 0, 0, 13, (Object) null);
                } else {
                    boolean zAreEqual3 = Intrinsics.areEqual(origin, colorPickerView2.binding.green);
                    ColorPickerView colorPickerView3 = this.colorPickerView;
                    if (zAreEqual3) {
                        iM11376copyONg3jNY$default = Color.m11376copyONg3jNY$default(colorPickerView3.color, 0, 0, componentChange.getValue(), 0, 11, (Object) null);
                    } else {
                        if (!Intrinsics.areEqual(origin, colorPickerView3.binding.blue)) {
                            throw new IllegalStateException(("Should never happen " + origin).toString());
                        }
                        iM11376copyONg3jNY$default = Color.m11376copyONg3jNY$default(this.colorPickerView.color, 0, 0, 0, componentChange.getValue(), 7, (Object) null);
                    }
                }
            }
            ColorPickerView.m11427updateColoryAn5nI$ui_release$default(this.colorPickerView, iM11376copyONg3jNY$default, false, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ColorPickerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.vanniktech.ui.view.ColorPickerView$hexEditTextWatcher$1] */
    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        UiViewColorPickerBinding uiViewColorPickerBindingInflate = UiViewColorPickerBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(uiViewColorPickerBindingInflate, "inflate(...)");
        this.binding = uiViewColorPickerBindingInflate;
        this.color = Color.INSTANCE.m11393getUNTINTEDoEAH0UE();
        this.hexEditTextWatcher = new TextWatcher() { // from class: com.vanniktech.ui.view.ColorPickerView$hexEditTextWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                String string2 = (s == null || (string = s.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
                if (string2 == null) {
                    string2 = "";
                }
                Color colorInferColor = ColorHexInputFilterKt.inferColor(string2, this.this$0.supportsAlpha);
                if (colorInferColor != null) {
                    this.this$0.m11431updateColoryAn5nI$ui_release(colorInferColor.m11388unboximpl(), false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Color colorM11390fromHexOrNullTUbRjns;
                Intrinsics.checkNotNullParameter(s, "s");
                if (s.length() <= 0 || s.length() != count || before > count || (colorM11390fromHexOrNullTUbRjns = Color.INSTANCE.m11390fromHexOrNullTUbRjns(s.subSequence(before, count).toString())) == null) {
                    return;
                }
                ColorPickerView colorPickerView = this.this$0;
                colorPickerView.m11431updateColoryAn5nI$ui_release(colorPickerView.m11429getUnifiedftSNO6c$ui_release(colorM11390fromHexOrNullTUbRjns.m11388unboximpl()), false);
            }
        };
        setOrientation(1);
    }

    public /* synthetic */ ColorPickerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: renamed from: updateColor-yAn5-nI$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m11427updateColoryAn5nI$ui_release$default(ColorPickerView colorPickerView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        colorPickerView.m11431updateColoryAn5nI$ui_release(i, z);
    }

    /* JADX INFO: renamed from: color-oEAH0UE, reason: not valid java name and from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getUnified-ftSNO6c$ui_release, reason: not valid java name */
    public final int m11429getUnifiedftSNO6c$ui_release(int i) {
        return this.supportsAlpha ? i : Color.m11375copyONg3jNY$default(i, ColorKt.getFLOAT_VALUE() / ColorKt.getFLOAT_VALUE(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Parcelable superSavedState;
        ColorPickerViewState colorPickerViewState = state instanceof ColorPickerViewState ? (ColorPickerViewState) state : null;
        if (colorPickerViewState != null && (superSavedState = colorPickerViewState.getSuperSavedState()) != null) {
            state = superSavedState;
        }
        super.onRestoreInstanceState(state);
        this.color = colorPickerViewState != null ? colorPickerViewState.getColor() : Color.INSTANCE.m11393getUNTINTEDoEAH0UE();
        this.supportsAlpha = colorPickerViewState != null ? colorPickerViewState.getSupportsAlpha() : false;
        m11427updateColoryAn5nI$ui_release$default(this, this.color, false, 2, null);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new ColorPickerViewState(super.onSaveInstanceState(), this.color, this.supportsAlpha, null);
    }

    /* JADX INFO: renamed from: setUp-R8KKfwI, reason: not valid java name */
    public final void m11430setUpR8KKfwI(UiTheming theming, ColorPickerStrings strings, int selectedColor) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(strings, "strings");
        boolean z = strings instanceof ColorPickerStringsHardcoded;
        if (z) {
            string = ((ColorPickerStringsHardcoded) strings).getAlpha();
        } else {
            if (!(strings instanceof ColorPickerStringsAndroid)) {
                throw new NoWhenBranchMatchedException();
            }
            ColorPickerStringsAndroid colorPickerStringsAndroid = (ColorPickerStringsAndroid) strings;
            string = colorPickerStringsAndroid.getAlpha() != 0 ? getContext().getString(colorPickerStringsAndroid.getAlpha()) : null;
        }
        this.supportsAlpha = string != null;
        m11427updateColoryAn5nI$ui_release$default(this, m11429getUnifiedftSNO6c$ui_release(selectedColor), false, 2, null);
        ColorComponentView alpha = this.binding.alpha;
        Intrinsics.checkNotNullExpressionValue(alpha, "alpha");
        AndroidGoodiesKt.visibleGone(alpha, this.supportsAlpha);
        if (string != null) {
            this.binding.alpha.setUp(string, Color.m11368alphaimpl$ui_release(this.color), theming, new ColorPickerColorComponentDelegate(this));
        }
        ColorComponentView colorComponentView = this.binding.red;
        if (z) {
            string2 = ((ColorPickerStringsHardcoded) strings).getRed();
        } else {
            if (!(strings instanceof ColorPickerStringsAndroid)) {
                throw new NoWhenBranchMatchedException();
            }
            string2 = getContext().getString(((ColorPickerStringsAndroid) strings).getRed());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        colorComponentView.setUp(string2, Color.m11384redimpl$ui_release(this.color), theming, new ColorPickerColorComponentDelegate(this));
        ColorComponentView colorComponentView2 = this.binding.green;
        if (z) {
            string3 = ((ColorPickerStringsHardcoded) strings).getGreen();
        } else {
            if (!(strings instanceof ColorPickerStringsAndroid)) {
                throw new NoWhenBranchMatchedException();
            }
            string3 = getContext().getString(((ColorPickerStringsAndroid) strings).getGreen());
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        }
        colorComponentView2.setUp(string3, Color.m11380greenimpl$ui_release(this.color), theming, new ColorPickerColorComponentDelegate(this));
        ColorComponentView colorComponentView3 = this.binding.blue;
        if (z) {
            string4 = ((ColorPickerStringsHardcoded) strings).getBlue();
        } else {
            if (!(strings instanceof ColorPickerStringsAndroid)) {
                throw new NoWhenBranchMatchedException();
            }
            string4 = getContext().getString(((ColorPickerStringsAndroid) strings).getBlue());
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        }
        colorComponentView3.setUp(string4, Color.m11369blueimpl$ui_release(this.color), theming, new ColorPickerColorComponentDelegate(this));
        TextView textView = this.binding.hexHeader;
        if (z) {
            string5 = ((ColorPickerStringsHardcoded) strings).getHex();
        } else {
            if (!(strings instanceof ColorPickerStringsAndroid)) {
                throw new NoWhenBranchMatchedException();
            }
            string5 = getContext().getString(((ColorPickerStringsAndroid) strings).getHex());
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        }
        textView.setText(string5);
        TextView hexHeader = this.binding.hexHeader;
        Intrinsics.checkNotNullExpressionValue(hexHeader, "hexHeader");
        AndroidViewKt.m11351themeTextViewCoujqA8(hexHeader, theming.m11420colorSecondaryoEAH0UE(), theming.m11422colorTextPrimaryoEAH0UE(), theming.m11423colorTextSecondaryoEAH0UE());
        this.binding.hexEditText.setFilters(new ColorHexInputFilter[]{new ColorHexInputFilter(this.supportsAlpha)});
        EditText hexEditText = this.binding.hexEditText;
        Intrinsics.checkNotNullExpressionValue(hexEditText, "hexEditText");
        AndroidViewKt.m11338themeEditTextCoujqA8(hexEditText, theming.m11420colorSecondaryoEAH0UE(), theming.m11422colorTextPrimaryoEAH0UE(), theming.m11423colorTextSecondaryoEAH0UE());
    }

    /* JADX INFO: renamed from: updateColor-yAn5-nI$ui_release, reason: not valid java name */
    public final void m11431updateColoryAn5nI$ui_release(int updated, boolean updateHexEditText) {
        this.color = updated;
        ColorStateList colorStateListM11319colorStateListXxRhnUA = AndroidColorKt.m11319colorStateListXxRhnUA(Color.m11385shouldUseBlackFontimpl(updated) ? Color.INSTANCE.m11391getBLACKoEAH0UE() : Color.INSTANCE.m11394getWHITEoEAH0UE());
        View view = this.binding.preview;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AndroidColorKt.m11319colorStateListXxRhnUA(updated));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelSize(R.dimen.ui_color_picker_preview_height) / 8.0f);
        gradientDrawable.setStroke(getResources().getDimensionPixelSize(R.dimen.ui_color_picker_preview_stroke_width), colorStateListM11319colorStateListXxRhnUA);
        view.setBackground(gradientDrawable);
        this.binding.red.m11426changeBackground6YK843c(Color.m11376copyONg3jNY$default(updated, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getFirst(), 0, 0, 13, (Object) null), Color.m11376copyONg3jNY$default(updated, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getLast(), 0, 0, 13, (Object) null), colorStateListM11319colorStateListXxRhnUA, Color.m11384redimpl$ui_release(updated));
        this.binding.green.m11426changeBackground6YK843c(Color.m11376copyONg3jNY$default(updated, 0, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getFirst(), 0, 11, (Object) null), Color.m11376copyONg3jNY$default(updated, 0, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getLast(), 0, 11, (Object) null), colorStateListM11319colorStateListXxRhnUA, Color.m11380greenimpl$ui_release(updated));
        this.binding.blue.m11426changeBackground6YK843c(Color.m11376copyONg3jNY$default(updated, 0, 0, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getFirst(), 7, (Object) null), Color.m11376copyONg3jNY$default(updated, 0, 0, 0, ColorKt.getCOLOR_COMPONENT_RANGE().getLast(), 7, (Object) null), colorStateListM11319colorStateListXxRhnUA, Color.m11369blueimpl$ui_release(updated));
        if (this.supportsAlpha) {
            this.binding.alpha.m11426changeBackground6YK843c(Color.m11376copyONg3jNY$default(updated, ColorKt.getCOLOR_COMPONENT_RANGE().getFirst(), 0, 0, 0, 14, (Object) null), Color.m11376copyONg3jNY$default(updated, ColorKt.getCOLOR_COMPONENT_RANGE().getLast(), 0, 0, 0, 14, (Object) null), colorStateListM11319colorStateListXxRhnUA, Color.m11368alphaimpl$ui_release(updated));
        }
        if (updateHexEditText) {
            this.binding.hexEditText.removeTextChangedListener(this.hexEditTextWatcher);
            EditText hexEditText = this.binding.hexEditText;
            Intrinsics.checkNotNullExpressionValue(hexEditText, "hexEditText");
            AndroidEditTextExtensionsKt.cursorAtEndWithText(hexEditText, StringsKt.removePrefix(Color.m11386toStringimpl(updated), (CharSequence) ColorKt.HEX_PREFIX));
            this.binding.hexEditText.addTextChangedListener(this.hexEditTextWatcher);
        }
    }
}
