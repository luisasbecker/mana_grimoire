package com.vanniktech.emoji.variant;

import com.vanniktech.emoji.Emoji;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoVariantEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/vanniktech/emoji/variant/NoVariantEmoji;", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "<init>", "()V", "getVariant", "Lcom/vanniktech/emoji/Emoji;", "desiredEmoji", "getVariants", "", "emoji", "addVariant", "", "newVariant", "persist", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoVariantEmoji implements VariantEmoji {
    public static final NoVariantEmoji INSTANCE = new NoVariantEmoji();

    private NoVariantEmoji() {
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public void addVariant(Emoji newVariant) {
        Intrinsics.checkNotNullParameter(newVariant, "newVariant");
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public Emoji getVariant(Emoji desiredEmoji) {
        Intrinsics.checkNotNullParameter(desiredEmoji, "desiredEmoji");
        return desiredEmoji;
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public List<Emoji> getVariants(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        return CollectionsKt.emptyList();
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public void persist() {
    }
}
