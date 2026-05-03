package com.vanniktech.emoji;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Emoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/Emoji;", "", "base", "getBase", "()Lcom/vanniktech/emoji/Emoji;", "unicode", "", "getUnicode", "()Ljava/lang/String;", "shortcodes", "", "getShortcodes", "()Ljava/util/List;", "variants", "getVariants", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Emoji {
    Emoji getBase();

    List<String> getShortcodes();

    String getUnicode();

    List<Emoji> getVariants();
}
