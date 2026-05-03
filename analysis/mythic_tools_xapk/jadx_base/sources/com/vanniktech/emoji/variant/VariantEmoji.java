package com.vanniktech.emoji.variant;

import com.vanniktech.emoji.Emoji;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: VariantEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\tH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/variant/VariantEmoji;", "", "getVariant", "Lcom/vanniktech/emoji/Emoji;", "desiredEmoji", "getVariants", "", "emoji", "addVariant", "", "newVariant", "persist", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface VariantEmoji {
    void addVariant(Emoji newVariant);

    Emoji getVariant(Emoji desiredEmoji);

    List<Emoji> getVariants(Emoji emoji);

    void persist();
}
