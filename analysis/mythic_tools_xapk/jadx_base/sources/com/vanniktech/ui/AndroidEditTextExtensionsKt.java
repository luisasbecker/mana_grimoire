package com.vanniktech.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidEditTextExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\n\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "Landroid/content/Context;", "getInputMethodManager", "(Landroid/content/Context;)Landroid/view/inputmethod/InputMethodManager;", "showKeyboardAndFocus", "", "Landroid/widget/EditText;", "hideKeyboardAndFocus", "hideKeyboard", "Landroid/app/Activity;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "cursorAtEnd", "cursorAtEndWithText", "text", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidEditTextExtensionsKt {
    public static final void cursorAtEnd(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setSelection(editText.getText().length());
    }

    public static final void cursorAtEndWithText(EditText editText, String str) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setText(str);
        cursorAtEnd(editText);
    }

    private static final InputMethodManager getInputMethodManager(Context context) {
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    public static final void hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            hideKeyboard(activity, currentFocus);
        }
    }

    public static final void hideKeyboard(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        getInputMethodManager(context).hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public static final void hideKeyboardAndFocus(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.post(new Runnable() { // from class: com.vanniktech.ui.AndroidEditTextExtensionsKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidEditTextExtensionsKt.hideKeyboardAndFocus$lambda$1(editText);
            }
        });
    }

    static final void hideKeyboardAndFocus$lambda$1(EditText this_hideKeyboardAndFocus) {
        Intrinsics.checkNotNullParameter(this_hideKeyboardAndFocus, "$this_hideKeyboardAndFocus");
        this_hideKeyboardAndFocus.clearFocus();
        Context context = this_hideKeyboardAndFocus.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        getInputMethodManager(context).hideSoftInputFromWindow(this_hideKeyboardAndFocus.getWindowToken(), 0);
    }

    public static final void showKeyboardAndFocus(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.post(new Runnable() { // from class: com.vanniktech.ui.AndroidEditTextExtensionsKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AndroidEditTextExtensionsKt.showKeyboardAndFocus$lambda$0(editText);
            }
        });
    }

    static final void showKeyboardAndFocus$lambda$0(EditText this_showKeyboardAndFocus) {
        Intrinsics.checkNotNullParameter(this_showKeyboardAndFocus, "$this_showKeyboardAndFocus");
        this_showKeyboardAndFocus.requestFocus();
        Context context = this_showKeyboardAndFocus.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        getInputMethodManager(context).showSoftInput(this_showKeyboardAndFocus, 0);
    }
}
