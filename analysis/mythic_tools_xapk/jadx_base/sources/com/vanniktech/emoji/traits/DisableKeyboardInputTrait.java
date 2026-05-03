package com.vanniktech.emoji.traits;

import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vanniktech.emoji.EmojiPopup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisableKeyboardInputTrait.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vanniktech/emoji/traits/DisableKeyboardInputTrait;", "Lcom/vanniktech/emoji/traits/EmojiTraitable;", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "<init>", "(Lcom/vanniktech/emoji/EmojiPopup;)V", "install", "Lcom/vanniktech/emoji/traits/EmojiTrait;", "editText", "Landroid/widget/EditText;", "ForceEmojisOnlyFocusChangeListener", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DisableKeyboardInputTrait implements EmojiTraitable {
    private final EmojiPopup emojiPopup;

    /* JADX INFO: compiled from: DisableKeyboardInputTrait.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0010R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vanniktech/emoji/traits/DisableKeyboardInputTrait$ForceEmojisOnlyFocusChangeListener;", "Landroid/view/View$OnFocusChangeListener;", "delegate", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "<init>", "(Landroid/view/View$OnFocusChangeListener;Lcom/vanniktech/emoji/EmojiPopup;)V", "getDelegate$emoji_release", "()Landroid/view/View$OnFocusChangeListener;", "onFocusChange", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "hasFocus", "", "focus", "focus$emoji_release", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ForceEmojisOnlyFocusChangeListener implements View.OnFocusChangeListener {
        private final View.OnFocusChangeListener delegate;
        private final EmojiPopup emojiPopup;

        public ForceEmojisOnlyFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener, EmojiPopup emojiPopup) {
            Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
            this.delegate = onFocusChangeListener;
            this.emojiPopup = emojiPopup;
        }

        public final void focus$emoji_release() {
            if (this.emojiPopup.isShowing()) {
                return;
            }
            this.emojiPopup.start$emoji_release();
            this.emojiPopup.show();
        }

        /* JADX INFO: renamed from: getDelegate$emoji_release, reason: from getter */
        public final View.OnFocusChangeListener getDelegate() {
            return this.delegate;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean hasFocus) {
            Intrinsics.checkNotNullParameter(view, "view");
            EmojiPopup emojiPopup = this.emojiPopup;
            if (hasFocus) {
                emojiPopup.start$emoji_release();
                this.emojiPopup.show();
            } else {
                emojiPopup.dismiss();
            }
            View.OnFocusChangeListener onFocusChangeListener = this.delegate;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, hasFocus);
            }
        }
    }

    public DisableKeyboardInputTrait(EmojiPopup emojiPopup) {
        Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
        this.emojiPopup = emojiPopup;
    }

    @Override // com.vanniktech.emoji.traits.EmojiTraitable
    public EmojiTrait install(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        final ForceEmojisOnlyFocusChangeListener forceEmojisOnlyFocusChangeListener = new ForceEmojisOnlyFocusChangeListener(editText.getOnFocusChangeListener(), this.emojiPopup);
        editText.setOnFocusChangeListener(forceEmojisOnlyFocusChangeListener);
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(editText.getRootView());
        boolean z = false;
        if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            z = true;
        }
        if (editText.hasFocus() || z) {
            forceEmojisOnlyFocusChangeListener.focus$emoji_release();
        }
        return new EmojiTrait() { // from class: com.vanniktech.emoji.traits.DisableKeyboardInputTrait.install.1
            @Override // com.vanniktech.emoji.traits.EmojiTrait
            public void uninstall() {
                editText.setOnFocusChangeListener(forceEmojisOnlyFocusChangeListener.getDelegate());
            }
        };
    }
}
