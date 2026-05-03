package com.vanniktech.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.vanniktech.ui.AndroidColorKt;
import com.vanniktech.ui.AndroidEditTextExtensionsKt;
import com.vanniktech.ui.AndroidViewKt;
import com.vanniktech.ui.Color;
import com.vanniktech.ui.ColorKt;
import com.vanniktech.ui.R;
import com.vanniktech.ui.databinding.UiViewColorComponentBinding;
import com.vanniktech.ui.theming.UiTheming;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0015\u0018\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ&\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000fJ-\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006,"}, d2 = {"Lcom/vanniktech/ui/view/ColorComponentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/vanniktech/ui/databinding/UiViewColorComponentBinding;", "height", "", "radius", "", "delegate", "Lcom/vanniktech/ui/view/ColorComponentDelegate;", "getDelegate$ui_release", "()Lcom/vanniktech/ui/view/ColorComponentDelegate;", "setDelegate$ui_release", "(Lcom/vanniktech/ui/view/ColorComponentDelegate;)V", "textWatcher", "com/vanniktech/ui/view/ColorComponentView$textWatcher$1", "Lcom/vanniktech/ui/view/ColorComponentView$textWatcher$1;", "seekBarChangeListener", "com/vanniktech/ui/view/ColorComponentView$seekBarChangeListener$1", "Lcom/vanniktech/ui/view/ColorComponentView$seekBarChangeListener$1;", "hideKeyboardAndFocus", "", "setUp", "header", "", "initialValue", "theming", "Lcom/vanniktech/ui/theming/UiTheming;", "changeBackground", "from", "Lcom/vanniktech/ui/Color;", TypedValues.TransitionType.S_TO, "thumbColor", "Landroid/content/res/ColorStateList;", "value", "changeBackground-6YK843c", "(IILandroid/content/res/ColorStateList;I)V", "updateValue", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorComponentView extends LinearLayout {
    private final UiViewColorComponentBinding binding;
    public ColorComponentDelegate delegate;
    private final int height;
    private final float radius;
    private final ColorComponentView$seekBarChangeListener$1 seekBarChangeListener;
    private final ColorComponentView$textWatcher$1 textWatcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ColorComponentView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.vanniktech.ui.view.ColorComponentView$textWatcher$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.vanniktech.ui.view.ColorComponentView$seekBarChangeListener$1] */
    public ColorComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        UiViewColorComponentBinding uiViewColorComponentBindingInflate = UiViewColorComponentBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(uiViewColorComponentBindingInflate, "inflate(...)");
        this.binding = uiViewColorComponentBindingInflate;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ui_color_component_seekbar_height);
        this.height = dimensionPixelSize;
        this.radius = dimensionPixelSize / 2.0f;
        this.textWatcher = new TextWatcher() { // from class: com.vanniktech.ui.view.ColorComponentView$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                Integer intOrNull;
                int iCoerceIn = (s == null || (string = s.toString()) == null || (intOrNull = StringsKt.toIntOrNull(string)) == null) ? 0 : RangesKt.coerceIn(intOrNull.intValue(), (ClosedRange<Integer>) ColorKt.getCOLOR_COMPONENT_RANGE());
                this.this$0.binding.seekBar.setProgress(iCoerceIn);
                this.this$0.getDelegate$ui_release().onComponentChanged(new ColorComponentChange(this.this$0, iCoerceIn));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        this.seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.vanniktech.ui.view.ColorComponentView$seekBarChangeListener$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    EditText editText = this.this$0.binding.editText;
                    Intrinsics.checkNotNullExpressionValue(editText, "editText");
                    AndroidEditTextExtensionsKt.cursorAtEndWithText(editText, String.valueOf(progress));
                    this.this$0.getDelegate$ui_release().hideKeyboardAndFocus();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };
        setOrientation(1);
    }

    public /* synthetic */ ColorComponentView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void updateValue(int value) {
        this.binding.editText.removeTextChangedListener(this.textWatcher);
        this.binding.seekBar.setOnSeekBarChangeListener(null);
        EditText editText = this.binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        AndroidEditTextExtensionsKt.cursorAtEndWithText(editText, String.valueOf(value));
        this.binding.seekBar.setProgress(value);
        this.binding.editText.addTextChangedListener(this.textWatcher);
        this.binding.seekBar.setOnSeekBarChangeListener(this.seekBarChangeListener);
    }

    /* JADX INFO: renamed from: changeBackground-6YK843c, reason: not valid java name */
    public final void m11426changeBackground6YK843c(int from, int to, ColorStateList thumbColor, int value) {
        Intrinsics.checkNotNullParameter(thumbColor, "thumbColor");
        this.binding.seekBar.setThumbTintList(thumbColor);
        SeekBar seekBar = this.binding.seekBar;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(AndroidColorKt.m11319colorStateListXxRhnUA(Color.INSTANCE.m11392getTRANSPARENToEAH0UE()));
        gradientDrawable.setCornerRadius(this.radius);
        int i = this.height;
        gradientDrawable.setSize(i, i);
        gradientDrawable.setStroke(getResources().getDimensionPixelSize(R.dimen.ui_color_component_seekbar_thumb_stroke_width), thumbColor);
        seekBar.setThumb(gradientDrawable);
        SeekBar seekBar2 = this.binding.seekBar;
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{from, to});
        float f = this.radius;
        gradientDrawable2.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        seekBar2.setBackground(gradientDrawable2);
        updateValue(value);
    }

    public final ColorComponentDelegate getDelegate$ui_release() {
        ColorComponentDelegate colorComponentDelegate = this.delegate;
        if (colorComponentDelegate != null) {
            return colorComponentDelegate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    }

    public final void hideKeyboardAndFocus() {
        EditText editText = this.binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        AndroidEditTextExtensionsKt.hideKeyboardAndFocus(editText);
    }

    public final void setDelegate$ui_release(ColorComponentDelegate colorComponentDelegate) {
        Intrinsics.checkNotNullParameter(colorComponentDelegate, "<set-?>");
        this.delegate = colorComponentDelegate;
    }

    public final void setUp(String header, int initialValue, UiTheming theming, ColorComponentDelegate delegate) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        setDelegate$ui_release(delegate);
        this.binding.header.setText(header);
        TextView header2 = this.binding.header;
        Intrinsics.checkNotNullExpressionValue(header2, "header");
        AndroidViewKt.m11351themeTextViewCoujqA8(header2, theming.m11420colorSecondaryoEAH0UE(), theming.m11422colorTextPrimaryoEAH0UE(), theming.m11423colorTextSecondaryoEAH0UE());
        SeekBar seekBar = this.binding.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "seekBar");
        AndroidViewKt.m11346themeSeekBarxAbW3D8(seekBar, Color.INSTANCE.m11394getWHITEoEAH0UE());
        SeekBar seekBar2 = this.binding.seekBar;
        int i = this.height;
        seekBar2.setPadding(i / 2, 0, i / 2, 0);
        this.binding.seekBar.setProgressDrawable(AndroidColorKt.m11317ColorDrawableXxRhnUA(Color.INSTANCE.m11392getTRANSPARENToEAH0UE()));
        this.binding.seekBar.setMax(ColorKt.getCOLOR_COMPONENT_RANGE().getLast());
        this.binding.seekBar.setProgress(initialValue);
        EditText editText = this.binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        AndroidViewKt.m11338themeEditTextCoujqA8(editText, theming.m11420colorSecondaryoEAH0UE(), theming.m11422colorTextPrimaryoEAH0UE(), theming.m11423colorTextSecondaryoEAH0UE());
        EditText editText2 = this.binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText2, "editText");
        AndroidEditTextExtensionsKt.cursorAtEndWithText(editText2, String.valueOf(initialValue));
        this.binding.editText.setFilters(new ColorComponentInputFilter[]{ColorComponentInputFilter.INSTANCE});
    }
}
