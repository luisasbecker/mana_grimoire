package com.vanniktech.emoji.internal;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.vanniktech.emoji.EmojiAndroidProvider;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\u00048À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"DONT_UPDATE_FLAG", "", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "Landroid/content/Context;", "getInputMethodManager", "(Landroid/content/Context;)Landroid/view/inputmethod/InputMethodManager;", "showKeyboardAndFocus", "", "Landroid/widget/EditText;", "hideKeyboardAndFocus", "emojiDrawableProvider", "Lcom/vanniktech/emoji/EmojiAndroidProvider;", "Lcom/vanniktech/emoji/EmojiManager;", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    private static final int DONT_UPDATE_FLAG = -1;

    public static final EmojiAndroidProvider emojiDrawableProvider(EmojiManager emojiManager) {
        Intrinsics.checkNotNullParameter(emojiManager, "<this>");
        EmojiProvider emojiProviderEmojiProvider$emoji_release = emojiManager.emojiProvider$emoji_release();
        if (emojiProviderEmojiProvider$emoji_release instanceof EmojiAndroidProvider) {
            return (EmojiAndroidProvider) emojiProviderEmojiProvider$emoji_release;
        }
        throw new IllegalArgumentException("Your provider needs to implement EmojiDrawableProvider".toString());
    }

    public static final InputMethodManager getInputMethodManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    public static final void hideKeyboardAndFocus(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.post(new Runnable() { // from class: com.vanniktech.emoji.internal.UtilsKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UtilsKt.hideKeyboardAndFocus$lambda$0(editText);
            }
        });
    }

    static final void hideKeyboardAndFocus$lambda$0(EditText editText) {
        editText.clearFocus();
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static final void showKeyboardAndFocus(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.post(new Runnable() { // from class: com.vanniktech.emoji.internal.UtilsKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                UtilsKt.showKeyboardAndFocus$lambda$0(editText);
            }
        });
    }

    static final void showKeyboardAndFocus$lambda$0(EditText editText) {
        editText.requestFocus();
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }
}
