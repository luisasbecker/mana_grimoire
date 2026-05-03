package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "body", "positiveButtonText", "negativeButtonText", "destructiveButtonText", "positiveButtonListener", "Lkotlin/Function2;", "", "", "negativeButtonListener", "Lkotlin/Function1;", "destructiveButtonListener", "onDismiss", "Lkotlin/Function0;", "positiveButtonRed", Key.ROTATION, "", "showRestoreCheckBox", "getShowRestoreCheckBox", "()Z", "setShowRestoreCheckBox", "(Z)V", "restoreCards", "getRestoreCards", "setRestoreCards", "checkBoxLabel", "getCheckBoxLabel", "()Ljava/lang/String;", "setCheckBoxLabel", "(Ljava/lang/String;)V", "checkBoxDefaultChecked", "getCheckBoxDefaultChecked", "setCheckBoxDefaultChecked", "onStart", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private String checkBoxLabel;
    private Function1<? super CustomDialogFragment, Unit> destructiveButtonListener;
    private Function1<? super CustomDialogFragment, Unit> negativeButtonListener;
    private Function0<Unit> onDismiss;
    private Function2<? super Boolean, ? super CustomDialogFragment, Unit> positiveButtonListener;
    private boolean positiveButtonRed;
    private int rotation;
    private boolean showRestoreCheckBox;
    private String title = "";
    private String body = "";
    private String positiveButtonText = "";
    private String negativeButtonText = "";
    private String destructiveButtonText = "";
    private boolean restoreCards = true;
    private boolean checkBoxDefaultChecked = true;

    /* JADX INFO: compiled from: CustomDialogFragment.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010J(\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017J\u0006\u0010\u0019\u001a\u00020\u0000J\"\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001bJ\"\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001bJ\u0014\u0010\u001d\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/CustomDialogFragment;", "setTitle", Constants.GP_IAP_TITLE, "", "setRotation", Key.ROTATION, "", "setBody", "body", "setShowRestoreCheckBox", "show", "", "setCheckBoxLabel", "text", "setCheckBoxDefaultChecked", "checked", "setPositiveButton", "onClick", "Lkotlin/Function2;", "", "setPositiveButtonRed", "setNegativeButton", "Lkotlin/Function1;", "setDestructiveButton", "setOnDismissListener", "onDismiss", "Lkotlin/Function0;", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CustomDialogFragment dialogFragment = new CustomDialogFragment();

        public final Builder setBody(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.dialogFragment.body = body;
            return this;
        }

        public final Builder setCheckBoxDefaultChecked(boolean checked) {
            this.dialogFragment.setCheckBoxDefaultChecked(checked);
            return this;
        }

        public final Builder setCheckBoxLabel(String text) {
            this.dialogFragment.setCheckBoxLabel(text);
            return this;
        }

        public final Builder setDestructiveButton(String text, Function1<? super CustomDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.destructiveButtonText = text;
            this.dialogFragment.destructiveButtonListener = onClick;
            return this;
        }

        public final Builder setNegativeButton(String text, Function1<? super CustomDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.negativeButtonText = text;
            this.dialogFragment.negativeButtonListener = onClick;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            this.dialogFragment.onDismiss = onDismiss;
            return this;
        }

        public final Builder setPositiveButton(String text, Function2<? super Boolean, ? super CustomDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.positiveButtonText = text;
            this.dialogFragment.positiveButtonListener = onClick;
            return this;
        }

        public final Builder setPositiveButtonRed() {
            this.dialogFragment.positiveButtonRed = true;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.dialogFragment.rotation = rotation;
            return this;
        }

        public final Builder setShowRestoreCheckBox(boolean show) {
            this.dialogFragment.setShowRestoreCheckBox(show);
            return this;
        }

        public final Builder setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.dialogFragment.title = title;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    static final void onCreateView$lambda$10(CustomDialogFragment customDialogFragment, TextView textView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        customDialogFragment.restoreCards = z;
        if (z) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    static final Unit onCreateView$lambda$6(CustomDialogFragment customDialogFragment) {
        Function2<? super Boolean, ? super CustomDialogFragment, Unit> function2 = customDialogFragment.positiveButtonListener;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(customDialogFragment.restoreCards), customDialogFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(CustomDialogFragment customDialogFragment) {
        Function1<? super CustomDialogFragment, Unit> function1 = customDialogFragment.negativeButtonListener;
        if (function1 != null) {
            function1.invoke(customDialogFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(CustomDialogFragment customDialogFragment) {
        Function1<? super CustomDialogFragment, Unit> function1 = customDialogFragment.destructiveButtonListener;
        if (function1 != null) {
            function1.invoke(customDialogFragment);
        }
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$9(CustomDialogFragment customDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        customDialogFragment.restoreCards = z;
    }

    public final boolean getCheckBoxDefaultChecked() {
        return this.checkBoxDefaultChecked;
    }

    public final String getCheckBoxLabel() {
        return this.checkBoxLabel;
    }

    public final boolean getRestoreCards() {
        return this.restoreCards;
    }

    public final boolean getShowRestoreCheckBox() {
        return this.showRestoreCheckBox;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_custom, container, false);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.title);
        ((TextView) viewInflate.findViewById(R.id.body)).setText(this.body);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.destructive_button);
        materialButton.setText(this.positiveButtonText);
        materialButton2.setText(this.negativeButtonText);
        materialButton3.setText(this.destructiveButtonText);
        ((RelativeLayout) viewInflate.findViewById(R.id.dialog_root)).setRotation(this.rotation);
        if (this.positiveButtonRed) {
            materialButton.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background));
        }
        if (this.positiveButtonListener != null) {
            materialButton.setVisibility(0);
        } else {
            materialButton.setVisibility(4);
        }
        if (this.negativeButtonListener != null) {
            materialButton2.setVisibility(0);
        } else {
            materialButton2.setVisibility(4);
        }
        if (this.destructiveButtonListener != null) {
            materialButton3.setVisibility(0);
        } else {
            materialButton3.setVisibility(4);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.destructive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragment.onCreateView$lambda$8(this.f$0);
            }
        });
        if (this.showRestoreCheckBox) {
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.restoreCardsCheckBox);
            final TextView textView = (TextView) viewInflate.findViewById(R.id.warningText);
            checkBox.setVisibility(0);
            String str = this.checkBoxLabel;
            if (str != null) {
                checkBox.setText(str);
                checkBox.setChecked(this.checkBoxDefaultChecked);
                this.restoreCards = this.checkBoxDefaultChecked;
                textView.setVisibility(8);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        CustomDialogFragment.onCreateView$lambda$9(this.f$0, compoundButton, z);
                    }
                });
            } else {
                checkBox.setChecked(true);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragment$$ExternalSyntheticLambda4
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        CustomDialogFragment.onCreateView$lambda$10(this.f$0, textView, compoundButton, z);
                    }
                });
            }
        }
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    public final void setCheckBoxDefaultChecked(boolean z) {
        this.checkBoxDefaultChecked = z;
    }

    public final void setCheckBoxLabel(String str) {
        this.checkBoxLabel = str;
    }

    public final void setRestoreCards(boolean z) {
        this.restoreCards = z;
    }

    public final void setShowRestoreCheckBox(boolean z) {
        this.showRestoreCheckBox = z;
    }
}
