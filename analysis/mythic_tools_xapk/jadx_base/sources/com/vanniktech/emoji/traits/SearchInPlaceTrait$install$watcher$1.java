package com.vanniktech.emoji.traits;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.internal.EmojiSearchDelegate;
import com.vanniktech.emoji.internal.EmojiSearchPopup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchInPlaceTrait.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/vanniktech/emoji/traits/SearchInPlaceTrait$install$watcher$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchInPlaceTrait$install$watcher$1 implements TextWatcher {
    final /* synthetic */ EditText $editText;
    final /* synthetic */ Handler $handler;
    final /* synthetic */ EmojiSearchPopup $popup;
    final /* synthetic */ SearchInPlaceTrait this$0;

    SearchInPlaceTrait$install$watcher$1(Handler handler, EmojiSearchPopup emojiSearchPopup, SearchInPlaceTrait searchInPlaceTrait, EditText editText) {
        this.$handler = handler;
        this.$popup = emojiSearchPopup;
        this.this$0 = searchInPlaceTrait;
        this.$editText = editText;
    }

    static final void afterTextChanged$lambda$0(final Editable editable, EmojiSearchPopup emojiSearchPopup, SearchInPlaceTrait searchInPlaceTrait, final EditText editText) {
        Editable editable2 = editable;
        final int i = -1;
        int length = editable2.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (editable2.charAt(length) == ':') {
                    i = length;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length = i2;
                }
            }
        }
        if (i < 0) {
            emojiSearchPopup.dismiss$emoji_release();
            return;
        }
        String string = StringsKt.drop(editable2, i + 1).toString();
        String str = string;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                emojiSearchPopup.dismiss$emoji_release();
                return;
            }
        }
        emojiSearchPopup.show$emoji_release(searchInPlaceTrait.emojiPopup.getSearchEmoji().search(string), new EmojiSearchDelegate() { // from class: com.vanniktech.emoji.traits.SearchInPlaceTrait$install$watcher$1$$ExternalSyntheticLambda0
            @Override // com.vanniktech.emoji.internal.EmojiSearchDelegate
            public final void onEmojiClicked(Emoji emoji) {
                SearchInPlaceTrait$install$watcher$1.afterTextChanged$lambda$0$2(editText, i, editable, emoji);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterTextChanged$lambda$0$2(EditText editText, int i, Editable editable, Emoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = it.getUnicode() + " ";
        editText.getText().replace(i, editable.length(), str, 0, str.length());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(final Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.$handler.removeCallbacksAndMessages(null);
        Handler handler = this.$handler;
        final EmojiSearchPopup emojiSearchPopup = this.$popup;
        final SearchInPlaceTrait searchInPlaceTrait = this.this$0;
        final EditText editText = this.$editText;
        handler.postDelayed(new Runnable() { // from class: com.vanniktech.emoji.traits.SearchInPlaceTrait$install$watcher$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SearchInPlaceTrait$install$watcher$1.afterTextChanged$lambda$0(s, emojiSearchPopup, searchInPlaceTrait, editText);
            }
        }, 300L);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}
