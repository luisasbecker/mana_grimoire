package com.vanniktech.emoji.inputfilters;

import android.text.InputFilter;
import android.text.Spanned;
import com.vanniktech.emoji.Emojis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaximalNumberOfEmojisInputFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vanniktech/emoji/inputfilters/MaximalNumberOfEmojisInputFilter;", "Landroid/text/InputFilter;", "maxCount", "", "<init>", "(I)V", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MaximalNumberOfEmojisInputFilter implements InputFilter {
    private final int maxCount;

    public MaximalNumberOfEmojisInputFilter(int i) {
        this.maxCount = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (Emojis.emojiInformation(dest.subSequence(0, dest.length())).getEmojiCount() >= this.maxCount) {
            return "";
        }
        return null;
    }
}
