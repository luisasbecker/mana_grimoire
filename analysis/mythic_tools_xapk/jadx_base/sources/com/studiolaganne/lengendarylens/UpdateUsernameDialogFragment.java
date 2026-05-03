package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UpdateUsernameDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR,\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/UpdateUsernameDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "processing", "", "getProcessing", "()Z", "setProcessing", "(Z)V", Constants.GP_IAP_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "getUser", "()Lcom/studiolaganne/lengendarylens/MTUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTUser;)V", "editTextValue", "getEditTextValue", "setEditTextValue", "editFirstName", "getEditFirstName", "setEditFirstName", "positiveButtonCallback", "Lkotlin/Function2;", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function2;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function2;)V", "negativeButtonCallback", "Lkotlin/Function1;", "getNegativeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setNegativeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "onStart", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateUsernameDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean editFirstName;
    public String editTextValue;
    public Function1<? super UpdateUsernameDialogFragment, Unit> negativeButtonCallback;
    public Function2<? super String, ? super UpdateUsernameDialogFragment, Unit> positiveButtonCallback;
    private boolean processing;
    public String title;
    public MTUser user;

    /* JADX INFO: compiled from: UpdateUsernameDialogFragment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ \u0010\u0016\u001a\u00020\u00002\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001a\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u0019\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/UpdateUsernameDialogFragment$Builder;", "", "<init>", "()V", Constants.GP_IAP_TITLE, "", "editTextValue", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "editFirstName", "", "positiveButtonCallback", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/UpdateUsernameDialogFragment;", "", "negativeButtonCallback", "Lkotlin/Function1;", "setTitle", "setEditTextValue", "value", "setEditFirstName", "setUser", "setPositiveButtonCallback", "callback", "setNegativeButtonCallback", "build", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean editFirstName;
        private String title = "";
        private String editTextValue = "";
        private MTUser user = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
        private Function2<? super String, ? super UpdateUsernameDialogFragment, Unit> positiveButtonCallback = new Function2() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UpdateUsernameDialogFragment.Builder.positiveButtonCallback$lambda$0((String) obj, (UpdateUsernameDialogFragment) obj2);
            }
        };
        private Function1<? super UpdateUsernameDialogFragment, Unit> negativeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdateUsernameDialogFragment.Builder.negativeButtonCallback$lambda$0((UpdateUsernameDialogFragment) obj);
            }
        };

        static final Unit negativeButtonCallback$lambda$0(UpdateUsernameDialogFragment updateUsernameDialogFragment) {
            Intrinsics.checkNotNullParameter(updateUsernameDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit positiveButtonCallback$lambda$0(String str, UpdateUsernameDialogFragment updateUsernameDialogFragment) {
            Intrinsics.checkNotNullParameter(str, "<unused var>");
            Intrinsics.checkNotNullParameter(updateUsernameDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final UpdateUsernameDialogFragment build() {
            UpdateUsernameDialogFragment updateUsernameDialogFragment = new UpdateUsernameDialogFragment();
            updateUsernameDialogFragment.setTitle(this.title);
            updateUsernameDialogFragment.setEditTextValue(this.editTextValue);
            updateUsernameDialogFragment.setUser(this.user);
            updateUsernameDialogFragment.setEditFirstName(this.editFirstName);
            updateUsernameDialogFragment.setPositiveButtonCallback(this.positiveButtonCallback);
            updateUsernameDialogFragment.setNegativeButtonCallback(this.negativeButtonCallback);
            return updateUsernameDialogFragment;
        }

        public final Builder setEditFirstName() {
            this.editFirstName = true;
            return this;
        }

        public final Builder setEditTextValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.editTextValue = value;
            return this;
        }

        public final Builder setNegativeButtonCallback(Function1<? super UpdateUsernameDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.negativeButtonCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonCallback(Function2<? super String, ? super UpdateUsernameDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.positiveButtonCallback = callback;
            return this;
        }

        public final Builder setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            return this;
        }

        public final Builder setUser(MTUser user) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.user = user;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(final UpdateUsernameDialogFragment updateUsernameDialogFragment, EditText editText, final View view) {
        if (updateUsernameDialogFragment.processing) {
            return Unit.INSTANCE;
        }
        final String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (string.length() <= 0 || Intrinsics.areEqual(string, updateUsernameDialogFragment.getEditTextValue())) {
            updateUsernameDialogFragment.dismiss();
        } else {
            if (updateUsernameDialogFragment.getContext() == null) {
                return Unit.INSTANCE;
            }
            updateUsernameDialogFragment.processing = true;
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loadingAnimationView);
            final TextView textView = (TextView) view.findViewById(R.id.updateButtonText);
            lottieAnimationView.setVisibility(0);
            textView.setTextColor(ContextCompat.getColor(updateUsernameDialogFragment.requireContext(), R.color.text_color));
            if (updateUsernameDialogFragment.editFirstName) {
                MTApiKt.getMtApi().updateFirstname(updateUsernameDialogFragment.getUser().getId(), new MTFirstnameBody(string)).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$onCreateView$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.getContext() == null) {
                            return;
                        }
                        TextView textView2 = (TextView) view.findViewById(R.id.error_text_view);
                        textView2.setVisibility(0);
                        lottieAnimationView.setVisibility(4);
                        textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.almost_white));
                        textView2.setText(this.this$0.getString(R.string.error_update_username));
                        this.this$0.setProcessing(false);
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        boolean zIsSuccessful = response.isSuccessful();
                        UpdateUsernameDialogFragment updateUsernameDialogFragment2 = this.this$0;
                        if (zIsSuccessful) {
                            if (updateUsernameDialogFragment2.getContext() == null) {
                                return;
                            }
                            this.this$0.getPositiveButtonCallback().invoke(string, this.this$0);
                            this.this$0.dismiss();
                            return;
                        }
                        if (updateUsernameDialogFragment2.getContext() == null) {
                            return;
                        }
                        TextView textView2 = (TextView) view.findViewById(R.id.error_text_view);
                        textView2.setVisibility(0);
                        lottieAnimationView.setVisibility(4);
                        textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.almost_white));
                        textView2.setText(this.this$0.getString(R.string.error_update_username));
                        this.this$0.setProcessing(false);
                    }
                });
            } else {
                MTApiKt.getMtApi().updateUsername(updateUsernameDialogFragment.getUser().getId(), new MTUsernameBody(string)).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$onCreateView$1$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.getContext() == null) {
                            return;
                        }
                        TextView textView2 = (TextView) view.findViewById(R.id.error_text_view);
                        textView2.setVisibility(0);
                        lottieAnimationView.setVisibility(4);
                        textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.almost_white));
                        textView2.setText(this.this$0.getString(R.string.error_update_username));
                        this.this$0.setProcessing(false);
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        boolean zIsSuccessful = response.isSuccessful();
                        UpdateUsernameDialogFragment updateUsernameDialogFragment2 = this.this$0;
                        if (zIsSuccessful) {
                            if (updateUsernameDialogFragment2.getContext() == null) {
                                return;
                            }
                            this.this$0.getPositiveButtonCallback().invoke(string, this.this$0);
                            this.this$0.dismiss();
                            return;
                        }
                        if (updateUsernameDialogFragment2.getContext() == null) {
                            return;
                        }
                        int iCode = response.code();
                        View view2 = view;
                        if (iCode == 304) {
                            TextView textView2 = (TextView) view2.findViewById(R.id.error_text_view);
                            textView2.setVisibility(0);
                            lottieAnimationView.setVisibility(4);
                            textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.almost_white));
                            textView2.setText(this.this$0.getString(R.string.error_username_exists));
                            this.this$0.setProcessing(false);
                            return;
                        }
                        TextView textView3 = (TextView) view2.findViewById(R.id.error_text_view);
                        textView3.setVisibility(0);
                        lottieAnimationView.setVisibility(4);
                        textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.almost_white));
                        textView3.setText(this.this$0.getString(R.string.error_update_username));
                        this.this$0.setProcessing(false);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(UpdateUsernameDialogFragment updateUsernameDialogFragment) {
        updateUsernameDialogFragment.getNegativeButtonCallback().invoke(updateUsernameDialogFragment);
        updateUsernameDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final void onResume$lambda$0(EditText editText, UpdateUsernameDialogFragment updateUsernameDialogFragment) {
        Window window;
        if (editText != null) {
            editText.requestFocus();
        }
        FragmentActivity activity = updateUsernameDialogFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        Dialog dialog = updateUsernameDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(4);
    }

    public final boolean getEditFirstName() {
        return this.editFirstName;
    }

    public final String getEditTextValue() {
        String str = this.editTextValue;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editTextValue");
        return null;
    }

    public final Function1<UpdateUsernameDialogFragment, Unit> getNegativeButtonCallback() {
        Function1 function1 = this.negativeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeButtonCallback");
        return null;
    }

    public final Function2<String, UpdateUsernameDialogFragment, Unit> getPositiveButtonCallback() {
        Function2 function2 = this.positiveButtonCallback;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
    }

    public final boolean getProcessing() {
        return this.processing;
    }

    public final String getTitle() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Constants.GP_IAP_TITLE);
        return null;
    }

    public final MTUser getUser() {
        MTUser mTUser = this.user;
        if (mTUser != null) {
            return mTUser;
        }
        Intrinsics.throwUninitializedPropertyAccessException("user");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.dialog_update_username, container, false);
        ((TextView) viewInflate.findViewById(R.id.dialog_title)).setText(getTitle());
        final EditText editText = (EditText) viewInflate.findViewById(R.id.username_edit_text);
        editText.setText(getEditTextValue());
        editText.requestFocus();
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.updateButtonLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateUsernameDialogFragment.onCreateView$lambda$0(this.f$0, editText, viewInflate);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateUsernameDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.username_edit_text) : null;
        if (editText != null) {
            editText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateUsernameDialogFragment.onResume$lambda$0(editText, this);
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

    public final void setEditFirstName(boolean z) {
        this.editFirstName = z;
    }

    public final void setEditTextValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.editTextValue = str;
    }

    public final void setNegativeButtonCallback(Function1<? super UpdateUsernameDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.negativeButtonCallback = function1;
    }

    public final void setPositiveButtonCallback(Function2<? super String, ? super UpdateUsernameDialogFragment, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.positiveButtonCallback = function2;
    }

    public final void setProcessing(boolean z) {
        this.processing = z;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUser(MTUser mTUser) {
        Intrinsics.checkNotNullParameter(mTUser, "<set-?>");
        this.user = mTUser;
    }
}
