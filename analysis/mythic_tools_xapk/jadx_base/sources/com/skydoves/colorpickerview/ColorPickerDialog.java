package com.skydoves.colorpickerview;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import com.skydoves.colorpickerview.databinding.ColorpickerviewDialogColorpickerBinding;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.listeners.ColorPickerViewListener;
import com.skydoves.colorpickerview.preference.ColorPickerPreferenceManager;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* JADX INFO: loaded from: classes6.dex */
public class ColorPickerDialog extends AlertDialog {
    private ColorPickerView colorPickerView;

    public static class Builder extends AlertDialog.Builder {
        private int bottomSpace;
        private ColorPickerView colorPickerView;
        private ColorpickerviewDialogColorpickerBinding dialogBinding;
        private boolean shouldAttachAlphaSlideBar;
        private boolean shouldAttachBrightnessSlideBar;

        public Builder(Context context) {
            super(context);
            this.shouldAttachAlphaSlideBar = true;
            this.shouldAttachBrightnessSlideBar = true;
            this.bottomSpace = SizeUtils.dp2Px(getContext(), 10);
            onCreate();
        }

        public Builder(Context context, int i) {
            super(context, i);
            this.shouldAttachAlphaSlideBar = true;
            this.shouldAttachBrightnessSlideBar = true;
            this.bottomSpace = SizeUtils.dp2Px(getContext(), 10);
            onCreate();
        }

        private DialogInterface.OnClickListener getOnClickListener(final ColorPickerViewListener colorPickerViewListener) {
            return new DialogInterface.OnClickListener() { // from class: com.skydoves.colorpickerview.ColorPickerDialog.Builder.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ColorPickerViewListener colorPickerViewListener2 = colorPickerViewListener;
                    if (colorPickerViewListener2 instanceof ColorListener) {
                        ((ColorListener) colorPickerViewListener2).onColorSelected(Builder.this.getColorPickerView().getColor(), true);
                    } else if (colorPickerViewListener2 instanceof ColorEnvelopeListener) {
                        ((ColorEnvelopeListener) colorPickerViewListener2).onColorSelected(Builder.this.getColorPickerView().getColorEnvelope(), true);
                    }
                    if (Builder.this.getColorPickerView() != null) {
                        ColorPickerPreferenceManager.getInstance(Builder.this.getContext()).saveColorPickerData(Builder.this.getColorPickerView());
                    }
                }
            };
        }

        private void onCreate() {
            ColorpickerviewDialogColorpickerBinding colorpickerviewDialogColorpickerBindingInflate = ColorpickerviewDialogColorpickerBinding.inflate(LayoutInflater.from(getContext()), null, false);
            this.dialogBinding = colorpickerviewDialogColorpickerBindingInflate;
            ColorPickerView colorPickerView = colorpickerviewDialogColorpickerBindingInflate.colorPickerView;
            this.colorPickerView = colorPickerView;
            colorPickerView.attachAlphaSlider(this.dialogBinding.alphaSlideBar);
            this.colorPickerView.attachBrightnessSlider(this.dialogBinding.brightnessSlideBar);
            this.colorPickerView.setColorListener(new ColorEnvelopeListener() { // from class: com.skydoves.colorpickerview.ColorPickerDialog.Builder.1
                @Override // com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
                public void onColorSelected(ColorEnvelope colorEnvelope, boolean z) {
                }
            });
            super.setView((View) this.dialogBinding.getRoot());
        }

        public Builder attachAlphaSlideBar(boolean z) {
            this.shouldAttachAlphaSlideBar = z;
            return this;
        }

        public Builder attachBrightnessSlideBar(boolean z) {
            this.shouldAttachBrightnessSlideBar = z;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public AlertDialog create() {
            if (getColorPickerView() != null) {
                this.dialogBinding.colorPickerViewFrame.removeAllViews();
                this.dialogBinding.colorPickerViewFrame.addView(getColorPickerView());
                AlphaSlideBar alphaSlideBar = getColorPickerView().getAlphaSlideBar();
                boolean z = this.shouldAttachAlphaSlideBar;
                if (z && alphaSlideBar != null) {
                    this.dialogBinding.alphaSlideBarFrame.removeAllViews();
                    this.dialogBinding.alphaSlideBarFrame.addView(alphaSlideBar);
                    getColorPickerView().attachAlphaSlider(alphaSlideBar);
                } else if (!z) {
                    this.dialogBinding.alphaSlideBarFrame.removeAllViews();
                }
                BrightnessSlideBar brightnessSlider = getColorPickerView().getBrightnessSlider();
                boolean z2 = this.shouldAttachBrightnessSlideBar;
                if (z2 && brightnessSlider != null) {
                    this.dialogBinding.brightnessSlideBarFrame.removeAllViews();
                    this.dialogBinding.brightnessSlideBarFrame.addView(brightnessSlider);
                    getColorPickerView().attachBrightnessSlider(brightnessSlider);
                } else if (!z2) {
                    this.dialogBinding.brightnessSlideBarFrame.removeAllViews();
                }
                if (this.shouldAttachAlphaSlideBar || this.shouldAttachBrightnessSlideBar) {
                    this.dialogBinding.spaceBottom.setVisibility(0);
                    this.dialogBinding.spaceBottom.getLayoutParams().height = this.bottomSpace;
                } else {
                    this.dialogBinding.spaceBottom.setVisibility(8);
                }
            }
            super.setView((View) this.dialogBinding.getRoot());
            return super.create();
        }

        public ColorPickerView getColorPickerView() {
            return this.colorPickerView;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            super.setAdapter(listAdapter, onClickListener);
            return this;
        }

        public Builder setBottomSpace(int i) {
            this.bottomSpace = SizeUtils.dp2Px(getContext(), i);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setCancelable(boolean z) {
            super.setCancelable(z);
            return this;
        }

        public Builder setColorPickerView(ColorPickerView colorPickerView) {
            this.dialogBinding.colorPickerViewFrame.removeAllViews();
            this.dialogBinding.colorPickerViewFrame.addView(colorPickerView);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            super.setCursor(cursor, onClickListener, str);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setCustomTitle(View view) {
            super.setCustomTitle(view);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setIcon(int i) {
            super.setIcon(i);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setIcon(Drawable drawable) {
            super.setIcon(drawable);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setIconAttribute(int i) {
            super.setIconAttribute(i);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            super.setItems(i, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            super.setItems(charSequenceArr, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setMessage(int i) {
            super.setMessage((CharSequence) getContext().getString(i));
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setMessage(CharSequence charSequence) {
            super.setMessage(charSequence);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            super.setNegativeButton(i, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            super.setNegativeButton(charSequence, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            super.setNeutralButton(i, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            super.setNeutralButton(charSequence, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            super.setOnCancelListener(onCancelListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            super.setOnDismissListener(onDismissListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            super.setOnItemSelectedListener(onItemSelectedListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            super.setOnKeyListener(onKeyListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            super.setPositiveButton(i, onClickListener);
            return this;
        }

        public Builder setPositiveButton(int i, ColorPickerViewListener colorPickerViewListener) {
            super.setPositiveButton(i, getOnClickListener(colorPickerViewListener));
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            super.setPositiveButton(charSequence, onClickListener);
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, ColorPickerViewListener colorPickerViewListener) {
            super.setPositiveButton(charSequence, getOnClickListener(colorPickerViewListener));
            return this;
        }

        public Builder setPreferenceName(String str) {
            if (getColorPickerView() != null) {
                getColorPickerView().setPreferenceName(str);
            }
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            super.setSingleChoiceItems(i, i2, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            super.setSingleChoiceItems(cursor, i, str, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            super.setSingleChoiceItems(listAdapter, i, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setTitle(int i) {
            super.setTitle(i);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setTitle(CharSequence charSequence) {
            super.setTitle(charSequence);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setView(int i) {
            super.setView(i);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.Builder
        public Builder setView(View view) {
            super.setView(view);
            return this;
        }
    }

    public ColorPickerDialog(Context context) {
        super(context);
    }
}
