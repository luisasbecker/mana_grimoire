package com.vanniktech.emoji.traits;

import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.internal.EmojiSearchPopup;
import com.vanniktech.emoji.search.NoSearchEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchInPlaceTrait.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/vanniktech/emoji/traits/SearchInPlaceTrait;", "Lcom/vanniktech/emoji/traits/EmojiTraitable;", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "<init>", "(Lcom/vanniktech/emoji/EmojiPopup;)V", "install", "Lcom/vanniktech/emoji/traits/EmojiTrait;", "editText", "Landroid/widget/EditText;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchInPlaceTrait implements EmojiTraitable {
    private final EmojiPopup emojiPopup;

    public SearchInPlaceTrait(EmojiPopup emojiPopup) {
        Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
        this.emojiPopup = emojiPopup;
    }

    @Override // com.vanniktech.emoji.traits.EmojiTraitable
    public EmojiTrait install(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        if (this.emojiPopup.getSearchEmoji() instanceof NoSearchEmoji) {
            return EmptyEmojiTrait.INSTANCE;
        }
        final EmojiSearchPopup emojiSearchPopup = new EmojiSearchPopup(this.emojiPopup.getRootView(), editText, this.emojiPopup.getTheming());
        final SearchInPlaceTrait$install$watcher$1 searchInPlaceTrait$install$watcher$1 = new SearchInPlaceTrait$install$watcher$1(new Handler(Looper.getMainLooper()), emojiSearchPopup, this, editText);
        editText.addTextChangedListener(searchInPlaceTrait$install$watcher$1);
        return new EmojiTrait() { // from class: com.vanniktech.emoji.traits.SearchInPlaceTrait.install.1
            @Override // com.vanniktech.emoji.traits.EmojiTrait
            public void uninstall() {
                emojiSearchPopup.dismiss$emoji_release();
                editText.removeTextChangedListener(searchInPlaceTrait$install$watcher$1);
            }
        };
    }
}
