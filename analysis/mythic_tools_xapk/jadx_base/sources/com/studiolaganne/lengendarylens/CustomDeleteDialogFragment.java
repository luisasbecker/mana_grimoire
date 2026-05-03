package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CustomDeleteDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000208H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR2\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001a\u0010&\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDeleteDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "body", "getBody", "setBody", "positiveButtonCallback", "Lkotlin/Function3;", "", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function3;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function3;)V", "negativeButtonCallback", "Lkotlin/Function1;", "getNegativeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setNegativeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "outsideTouchCallback", "getOutsideTouchCallback", "setOutsideTouchCallback", "showRestoreCheckBox", "getShowRestoreCheckBox", "()Z", "setShowRestoreCheckBox", "(Z)V", "checkBoxLabel", "getCheckBoxLabel", "setCheckBoxLabel", "checkBoxDefaultChecked", "getCheckBoxDefaultChecked", "setCheckBoxDefaultChecked", "restoreCards", "getRestoreCards", "setRestoreCards", "onStart", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomDeleteDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    public String body;
    private String checkBoxLabel;
    public Function1<? super CustomDeleteDialogFragment, Unit> negativeButtonCallback;
    public Function1<? super CustomDeleteDialogFragment, Unit> outsideTouchCallback;
    public Function3<? super String, ? super Boolean, ? super CustomDeleteDialogFragment, Unit> positiveButtonCallback;
    private boolean showRestoreCheckBox;
    public String title;
    private boolean checkBoxDefaultChecked = true;
    private boolean restoreCards = true;

    /* JADX INFO: compiled from: CustomDeleteDialogFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tJ&\u0010\u001a\u001a\u00020\u00002\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bJ\u001a\u0010\u001c\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\rJ\u0006\u0010\u001e\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDeleteDialogFragment$Builder;", "", "<init>", "()V", Constants.GP_IAP_TITLE, "", "body", "positiveButtonCallback", "Lkotlin/Function3;", "", "Lcom/studiolaganne/lengendarylens/CustomDeleteDialogFragment;", "", "negativeButtonCallback", "Lkotlin/Function1;", "outsideTouchCallback", "showRestoreCheckBox", "checkBoxLabel", "checkBoxDefaultChecked", "setTitle", "setBody", "setShowRestoreCheckBox", "show", "setCheckBoxLabel", "text", "setCheckBoxDefaultChecked", "checked", "setPositiveButtonCallback", "callback", "setNegativeButtonCallback", "setOutsideTouchCallback", "build", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String checkBoxLabel;
        private boolean showRestoreCheckBox;
        private String title = "";
        private String body = "";
        private Function3<? super String, ? super Boolean, ? super CustomDeleteDialogFragment, Unit> positiveButtonCallback = new Function3() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CustomDeleteDialogFragment.Builder.positiveButtonCallback$lambda$0((String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        };
        private Function1<? super CustomDeleteDialogFragment, Unit> negativeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomDeleteDialogFragment.Builder.negativeButtonCallback$lambda$0((CustomDeleteDialogFragment) obj);
            }
        };
        private Function1<? super CustomDeleteDialogFragment, Unit> outsideTouchCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$Builder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomDeleteDialogFragment.Builder.outsideTouchCallback$lambda$0((CustomDeleteDialogFragment) obj);
            }
        };
        private boolean checkBoxDefaultChecked = true;

        static final Unit negativeButtonCallback$lambda$0(CustomDeleteDialogFragment customDeleteDialogFragment) {
            Intrinsics.checkNotNullParameter(customDeleteDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit outsideTouchCallback$lambda$0(CustomDeleteDialogFragment customDeleteDialogFragment) {
            Intrinsics.checkNotNullParameter(customDeleteDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit positiveButtonCallback$lambda$0(String str, boolean z, CustomDeleteDialogFragment customDeleteDialogFragment) {
            Intrinsics.checkNotNullParameter(str, "<unused var>");
            Intrinsics.checkNotNullParameter(customDeleteDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final CustomDeleteDialogFragment build() {
            CustomDeleteDialogFragment customDeleteDialogFragment = new CustomDeleteDialogFragment();
            customDeleteDialogFragment.setTitle(this.title);
            customDeleteDialogFragment.setBody(this.body);
            customDeleteDialogFragment.setShowRestoreCheckBox(this.showRestoreCheckBox);
            customDeleteDialogFragment.setCheckBoxLabel(this.checkBoxLabel);
            customDeleteDialogFragment.setCheckBoxDefaultChecked(this.checkBoxDefaultChecked);
            customDeleteDialogFragment.setPositiveButtonCallback(this.positiveButtonCallback);
            customDeleteDialogFragment.setNegativeButtonCallback(this.negativeButtonCallback);
            customDeleteDialogFragment.setOutsideTouchCallback(this.outsideTouchCallback);
            return customDeleteDialogFragment;
        }

        public final Builder setBody(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
            return this;
        }

        public final Builder setCheckBoxDefaultChecked(boolean checked) {
            this.checkBoxDefaultChecked = checked;
            return this;
        }

        public final Builder setCheckBoxLabel(String text) {
            this.checkBoxLabel = text;
            return this;
        }

        public final Builder setNegativeButtonCallback(Function1<? super CustomDeleteDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.negativeButtonCallback = callback;
            return this;
        }

        public final Builder setOutsideTouchCallback(Function1<? super CustomDeleteDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.outsideTouchCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonCallback(Function3<? super String, ? super Boolean, ? super CustomDeleteDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.positiveButtonCallback = callback;
            return this;
        }

        public final Builder setShowRestoreCheckBox(boolean show) {
            this.showRestoreCheckBox = show;
            return this;
        }

        public final Builder setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(EditText editText, CustomDeleteDialogFragment customDeleteDialogFragment) {
        String string = editText.getText().toString();
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(StringsKt.trim((CharSequence) lowerCase).toString(), customDeleteDialogFragment.getResources().getString(R.string.delete_word))) {
            customDeleteDialogFragment.getPositiveButtonCallback().invoke(string, Boolean.valueOf(customDeleteDialogFragment.restoreCards), customDeleteDialogFragment);
            customDeleteDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(CustomDeleteDialogFragment customDeleteDialogFragment) {
        customDeleteDialogFragment.getNegativeButtonCallback().invoke(customDeleteDialogFragment);
        customDeleteDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$2(CustomDeleteDialogFragment customDeleteDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        customDeleteDialogFragment.restoreCards = z;
    }

    static final void onCreateView$lambda$3(CustomDeleteDialogFragment customDeleteDialogFragment, TextView textView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        customDeleteDialogFragment.restoreCards = z;
        if (z) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    static final void onResume$lambda$0(EditText editText, CustomDeleteDialogFragment customDeleteDialogFragment) {
        Window window;
        if (editText != null) {
            editText.requestFocus();
        }
        FragmentActivity activity = customDeleteDialogFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        Dialog dialog = customDeleteDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(4);
    }

    public final String getBody() {
        String str = this.body;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("body");
        return null;
    }

    public final boolean getCheckBoxDefaultChecked() {
        return this.checkBoxDefaultChecked;
    }

    public final String getCheckBoxLabel() {
        return this.checkBoxLabel;
    }

    public final Function1<CustomDeleteDialogFragment, Unit> getNegativeButtonCallback() {
        Function1 function1 = this.negativeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeButtonCallback");
        return null;
    }

    public final Function1<CustomDeleteDialogFragment, Unit> getOutsideTouchCallback() {
        Function1 function1 = this.outsideTouchCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("outsideTouchCallback");
        return null;
    }

    public final Function3<String, Boolean, CustomDeleteDialogFragment, Unit> getPositiveButtonCallback() {
        Function3 function3 = this.positiveButtonCallback;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
    }

    public final boolean getRestoreCards() {
        return this.restoreCards;
    }

    public final boolean getShowRestoreCheckBox() {
        return this.showRestoreCheckBox;
    }

    public final String getTitle() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Constants.GP_IAP_TITLE);
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_custom_delete, container, false);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(getTitle());
        ((TextView) viewInflate.findViewById(R.id.body)).setText(getBody());
        final EditText editText = (EditText) viewInflate.findViewById(R.id.custom_life_edit_text);
        editText.requestFocus();
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDeleteDialogFragment.onCreateView$lambda$0(editText, this);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDeleteDialogFragment.onCreateView$lambda$1(this.f$0);
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
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        CustomDeleteDialogFragment.onCreateView$lambda$2(this.f$0, compoundButton, z);
                    }
                });
            } else {
                checkBox.setChecked(true);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$$ExternalSyntheticLambda4
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        CustomDeleteDialogFragment.onCreateView$lambda$3(this.f$0, textView, compoundButton, z);
                    }
                });
            }
        }
        setCancelable(false);
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
        getOutsideTouchCallback().invoke(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.custom_life_edit_text) : null;
        if (editText != null) {
            editText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.CustomDeleteDialogFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CustomDeleteDialogFragment.onResume$lambda$0(editText, this);
                }
            }, 100L);
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

    public final void setBody(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.body = str;
    }

    public final void setCheckBoxDefaultChecked(boolean z) {
        this.checkBoxDefaultChecked = z;
    }

    public final void setCheckBoxLabel(String str) {
        this.checkBoxLabel = str;
    }

    public final void setNegativeButtonCallback(Function1<? super CustomDeleteDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.negativeButtonCallback = function1;
    }

    public final void setOutsideTouchCallback(Function1<? super CustomDeleteDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.outsideTouchCallback = function1;
    }

    public final void setPositiveButtonCallback(Function3<? super String, ? super Boolean, ? super CustomDeleteDialogFragment, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.positiveButtonCallback = function3;
    }

    public final void setRestoreCards(boolean z) {
        this.restoreCards = z;
    }

    public final void setShowRestoreCheckBox(boolean z) {
        this.showRestoreCheckBox = z;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
