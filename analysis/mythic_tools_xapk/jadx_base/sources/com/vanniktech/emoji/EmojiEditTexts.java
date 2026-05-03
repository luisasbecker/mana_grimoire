package com.vanniktech.emoji;

import android.view.KeyEvent;
import android.widget.EditText;
import com.vanniktech.emoji.traits.DisableKeyboardInputTrait;
import com.vanniktech.emoji.traits.EmojiTrait;
import com.vanniktech.emoji.traits.ForceSingleEmojiTrait;
import com.vanniktech.emoji.traits.SearchInPlaceTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiEditTexts.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"backspace", "", "Landroid/widget/EditText;", "input", "emoji", "Lcom/vanniktech/emoji/Emoji;", "addWhitespace", "", "installDisableKeyboardInput", "Lcom/vanniktech/emoji/traits/EmojiTrait;", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "installForceSingleEmoji", "installSearchInPlace", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EmojiEditTexts {
    public static final void backspace(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }

    public static final void input(EditText editText, Emoji emoji, boolean z) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        String str = emoji.getUnicode() + (z ? " " : "");
        if (selectionStart < 0) {
            editText.append(str);
        } else {
            editText.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), str, 0, str.length());
        }
    }

    public static /* synthetic */ void input$default(EditText editText, Emoji emoji, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        input(editText, emoji, z);
    }

    public static final EmojiTrait installDisableKeyboardInput(EditText editText, EmojiPopup emojiPopup) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
        return new DisableKeyboardInputTrait(emojiPopup).install(editText);
    }

    public static final EmojiTrait installForceSingleEmoji(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        return new ForceSingleEmojiTrait().install(editText);
    }

    public static final EmojiTrait installSearchInPlace(EditText editText, EmojiPopup emojiPopup) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
        return new SearchInPlaceTrait(emojiPopup).install(editText);
    }
}
