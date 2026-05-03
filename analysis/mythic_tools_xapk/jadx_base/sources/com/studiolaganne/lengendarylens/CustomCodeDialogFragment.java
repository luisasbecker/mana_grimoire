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
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomCodeDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomCodeDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomCodeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "positiveButtonCallback", "Lkotlin/Function2;", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function2;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function2;)V", "negativeButtonCallback", "Lkotlin/Function1;", "getNegativeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setNegativeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "outsideTouchCallback", "getOutsideTouchCallback", "setOutsideTouchCallback", "onStart", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomCodeDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    public Function1<? super CustomCodeDialogFragment, Unit> negativeButtonCallback;
    public Function1<? super CustomCodeDialogFragment, Unit> outsideTouchCallback;
    public Function2<? super String, ? super CustomCodeDialogFragment, Unit> positiveButtonCallback;
    public String title;

    /* JADX INFO: compiled from: CustomCodeDialogFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010\u000e\u001a\u00020\u00002\u001a\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bJ\u001a\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomCodeDialogFragment$Builder;", "", "<init>", "()V", Constants.GP_IAP_TITLE, "", "positiveButtonCallback", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/CustomCodeDialogFragment;", "", "negativeButtonCallback", "Lkotlin/Function1;", "outsideTouchCallback", "setTitle", "setPositiveButtonCallback", "callback", "setNegativeButtonCallback", "setOutsideTouchCallback", "build", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String title = "";
        private Function2<? super String, ? super CustomCodeDialogFragment, Unit> positiveButtonCallback = new Function2() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CustomCodeDialogFragment.Builder.positiveButtonCallback$lambda$0((String) obj, (CustomCodeDialogFragment) obj2);
            }
        };
        private Function1<? super CustomCodeDialogFragment, Unit> negativeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCodeDialogFragment.Builder.negativeButtonCallback$lambda$0((CustomCodeDialogFragment) obj);
            }
        };
        private Function1<? super CustomCodeDialogFragment, Unit> outsideTouchCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$Builder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCodeDialogFragment.Builder.outsideTouchCallback$lambda$0((CustomCodeDialogFragment) obj);
            }
        };

        static final Unit negativeButtonCallback$lambda$0(CustomCodeDialogFragment customCodeDialogFragment) {
            Intrinsics.checkNotNullParameter(customCodeDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit outsideTouchCallback$lambda$0(CustomCodeDialogFragment customCodeDialogFragment) {
            Intrinsics.checkNotNullParameter(customCodeDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit positiveButtonCallback$lambda$0(String str, CustomCodeDialogFragment customCodeDialogFragment) {
            Intrinsics.checkNotNullParameter(customCodeDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final CustomCodeDialogFragment build() {
            CustomCodeDialogFragment customCodeDialogFragment = new CustomCodeDialogFragment();
            customCodeDialogFragment.setTitle(this.title);
            customCodeDialogFragment.setPositiveButtonCallback(this.positiveButtonCallback);
            customCodeDialogFragment.setNegativeButtonCallback(this.negativeButtonCallback);
            customCodeDialogFragment.setOutsideTouchCallback(this.outsideTouchCallback);
            return customCodeDialogFragment;
        }

        public final Builder setNegativeButtonCallback(Function1<? super CustomCodeDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.negativeButtonCallback = callback;
            return this;
        }

        public final Builder setOutsideTouchCallback(Function1<? super CustomCodeDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.outsideTouchCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonCallback(Function2<? super String, ? super CustomCodeDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.positiveButtonCallback = callback;
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

    static final Unit onCreateView$lambda$0(EditText editText, CustomCodeDialogFragment customCodeDialogFragment) {
        customCodeDialogFragment.getPositiveButtonCallback().invoke(editText.getText().toString(), customCodeDialogFragment);
        customCodeDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(CustomCodeDialogFragment customCodeDialogFragment) {
        customCodeDialogFragment.getNegativeButtonCallback().invoke(customCodeDialogFragment);
        customCodeDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final void onResume$lambda$0(EditText editText, CustomCodeDialogFragment customCodeDialogFragment) {
        Window window;
        if (editText != null) {
            editText.requestFocus();
        }
        FragmentActivity activity = customCodeDialogFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        Dialog dialog = customCodeDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(4);
    }

    public final Function1<CustomCodeDialogFragment, Unit> getNegativeButtonCallback() {
        Function1 function1 = this.negativeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeButtonCallback");
        return null;
    }

    public final Function1<CustomCodeDialogFragment, Unit> getOutsideTouchCallback() {
        Function1 function1 = this.outsideTouchCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("outsideTouchCallback");
        return null;
    }

    public final Function2<String, CustomCodeDialogFragment, Unit> getPositiveButtonCallback() {
        Function2 function2 = this.positiveButtonCallback;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
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
        View viewInflate = inflater.inflate(R.layout.dialog_custom_code, container, false);
        ((TextView) viewInflate.findViewById(R.id.dialog_title)).setText(getTitle());
        final EditText editText = (EditText) viewInflate.findViewById(R.id.custom_code_edit_text);
        editText.requestFocus();
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCodeDialogFragment.onCreateView$lambda$0(editText, this);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCodeDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
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
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.custom_code_edit_text) : null;
        if (editText != null) {
            editText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.CustomCodeDialogFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CustomCodeDialogFragment.onResume$lambda$0(editText, this);
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

    public final void setNegativeButtonCallback(Function1<? super CustomCodeDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.negativeButtonCallback = function1;
    }

    public final void setOutsideTouchCallback(Function1<? super CustomCodeDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.outsideTouchCallback = function1;
    }

    public final void setPositiveButtonCallback(Function2<? super String, ? super CustomCodeDialogFragment, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.positiveButtonCallback = function2;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
