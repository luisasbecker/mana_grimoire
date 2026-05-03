package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.SendCardDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020\u0015H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/SendCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "cardImageURL", "getCardImageURL", "setCardImageURL", "positiveButtonRed", "", "getPositiveButtonRed", "()Z", "setPositiveButtonRed", "(Z)V", "positiveButtonCallback", "Lkotlin/Function1;", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "negativeButtonCallback", "getNegativeButtonCallback", "setNegativeButtonCallback", "outsideTouchCallback", "getOutsideTouchCallback", "setOutsideTouchCallback", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SendCardDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    public String cardImageURL;
    public Function1<? super SendCardDialogFragment, Unit> negativeButtonCallback;
    public Function1<? super SendCardDialogFragment, Unit> outsideTouchCallback;
    public Function1<? super SendCardDialogFragment, Unit> positiveButtonCallback;
    private boolean positiveButtonRed;
    public String title;

    /* JADX INFO: compiled from: SendCardDialogFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0000J\u001a\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u001a\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u001a\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SendCardDialogFragment$Builder;", "", "<init>", "()V", Constants.GP_IAP_TITLE, "", "cardImageURL", "positiveButtonRed", "", "positiveButtonCallback", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/SendCardDialogFragment;", "", "negativeButtonCallback", "outsideTouchCallback", "setTitle", "setCardImageURL", "setPositiveButtonRed", "setPositiveButtonCallback", "callback", "setNegativeButtonCallback", "setOutsideTouchCallback", "build", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean positiveButtonRed;
        private String title = "";
        private String cardImageURL = "";
        private Function1<? super SendCardDialogFragment, Unit> positiveButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.SendCardDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SendCardDialogFragment.Builder.positiveButtonCallback$lambda$0((SendCardDialogFragment) obj);
            }
        };
        private Function1<? super SendCardDialogFragment, Unit> negativeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.SendCardDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SendCardDialogFragment.Builder.negativeButtonCallback$lambda$0((SendCardDialogFragment) obj);
            }
        };
        private Function1<? super SendCardDialogFragment, Unit> outsideTouchCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.SendCardDialogFragment$Builder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SendCardDialogFragment.Builder.outsideTouchCallback$lambda$0((SendCardDialogFragment) obj);
            }
        };

        static final Unit negativeButtonCallback$lambda$0(SendCardDialogFragment sendCardDialogFragment) {
            Intrinsics.checkNotNullParameter(sendCardDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit outsideTouchCallback$lambda$0(SendCardDialogFragment sendCardDialogFragment) {
            Intrinsics.checkNotNullParameter(sendCardDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit positiveButtonCallback$lambda$0(SendCardDialogFragment sendCardDialogFragment) {
            Intrinsics.checkNotNullParameter(sendCardDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final SendCardDialogFragment build() {
            SendCardDialogFragment sendCardDialogFragment = new SendCardDialogFragment();
            sendCardDialogFragment.setTitle(this.title);
            sendCardDialogFragment.setCardImageURL(this.cardImageURL);
            sendCardDialogFragment.setPositiveButtonRed(this.positiveButtonRed);
            sendCardDialogFragment.setPositiveButtonCallback(this.positiveButtonCallback);
            sendCardDialogFragment.setNegativeButtonCallback(this.negativeButtonCallback);
            sendCardDialogFragment.setOutsideTouchCallback(this.outsideTouchCallback);
            return sendCardDialogFragment;
        }

        public final Builder setCardImageURL(String cardImageURL) {
            Intrinsics.checkNotNullParameter(cardImageURL, "cardImageURL");
            this.cardImageURL = cardImageURL;
            return this;
        }

        public final Builder setNegativeButtonCallback(Function1<? super SendCardDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.negativeButtonCallback = callback;
            return this;
        }

        public final Builder setOutsideTouchCallback(Function1<? super SendCardDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.outsideTouchCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonCallback(Function1<? super SendCardDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.positiveButtonCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonRed() {
            this.positiveButtonRed = true;
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

    static final Unit onCreateView$lambda$0(SendCardDialogFragment sendCardDialogFragment) {
        sendCardDialogFragment.getPositiveButtonCallback().invoke(sendCardDialogFragment);
        sendCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(SendCardDialogFragment sendCardDialogFragment) {
        sendCardDialogFragment.getNegativeButtonCallback().invoke(sendCardDialogFragment);
        sendCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    public final String getCardImageURL() {
        String str = this.cardImageURL;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardImageURL");
        return null;
    }

    public final Function1<SendCardDialogFragment, Unit> getNegativeButtonCallback() {
        Function1 function1 = this.negativeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeButtonCallback");
        return null;
    }

    public final Function1<SendCardDialogFragment, Unit> getOutsideTouchCallback() {
        Function1 function1 = this.outsideTouchCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("outsideTouchCallback");
        return null;
    }

    public final Function1<SendCardDialogFragment, Unit> getPositiveButtonCallback() {
        Function1 function1 = this.positiveButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
    }

    public final boolean getPositiveButtonRed() {
        return this.positiveButtonRed;
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
        View viewInflate = inflater.inflate(R.layout.dialog_send_card_image, container, false);
        ((TextView) viewInflate.findViewById(R.id.dialog_title)).setText(getTitle());
        View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        loadingImageView.setAutoLoad(false);
        loadingImageView.reset();
        loadingImageView.loadImage(getCardImageURL());
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        if (this.positiveButtonRed) {
            materialButton.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background));
        }
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.SendCardDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SendCardDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.SendCardDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SendCardDialogFragment.onCreateView$lambda$1(this.f$0);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.85d), -2);
    }

    public final void setCardImageURL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardImageURL = str;
    }

    public final void setNegativeButtonCallback(Function1<? super SendCardDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.negativeButtonCallback = function1;
    }

    public final void setOutsideTouchCallback(Function1<? super SendCardDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.outsideTouchCallback = function1;
    }

    public final void setPositiveButtonCallback(Function1<? super SendCardDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.positiveButtonCallback = function1;
    }

    public final void setPositiveButtonRed(boolean z) {
        this.positiveButtonRed = z;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
