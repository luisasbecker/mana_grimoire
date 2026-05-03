package com.vanniktech.emoji.variant;

import android.content.Context;
import android.content.SharedPreferences;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.Emojis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VariantEmojiManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vanniktech/emoji/variant/VariantEmojiManager;", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "variantsList", "", "Lcom/vanniktech/emoji/Emoji;", "getVariant", "desiredEmoji", "getVariants", "", "emoji", "addVariant", "", "newVariant", "persist", "initFromSharedPreferences", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VariantEmojiManager implements VariantEmoji {
    private static final String EMOJI_DELIMITER = "~";
    private static final int EMOJI_GUESS_SIZE = 5;
    private static final String PREFERENCE_NAME = "variant-emoji-manager";
    private static final String VARIANT_EMOJIS = "variant-emojis";
    private final SharedPreferences preferences;
    private List<Emoji> variantsList;

    public VariantEmojiManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, 0);
        this.variantsList = new ArrayList();
    }

    private final void initFromSharedPreferences() {
        String string = this.preferences.getString(VARIANT_EMOJIS, "");
        String str = string != null ? string : "";
        if (str.length() > 0) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{EMOJI_DELIMITER}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                Emoji emojiFindEmoji$emoji_release = EmojiManager.INSTANCE.findEmoji$emoji_release((String) it.next());
                if (emojiFindEmoji$emoji_release != null) {
                    arrayList.add(emojiFindEmoji$emoji_release);
                }
            }
            this.variantsList = CollectionsKt.toMutableList((Collection) arrayList);
        }
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public void addVariant(Emoji newVariant) {
        Intrinsics.checkNotNullParameter(newVariant, "newVariant");
        Emoji base = newVariant.getBase();
        int size = this.variantsList.size();
        int i = 0;
        while (true) {
            List<Emoji> list = this.variantsList;
            if (i >= size) {
                list.add(newVariant);
                return;
            }
            Emoji emoji = list.get(i);
            if (Intrinsics.areEqual(emoji.getBase(), base)) {
                if (Intrinsics.areEqual(emoji, newVariant)) {
                    return;
                }
                this.variantsList.remove(i);
                this.variantsList.add(newVariant);
                return;
            }
            i++;
        }
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public Emoji getVariant(Emoji desiredEmoji) {
        Object next;
        Intrinsics.checkNotNullParameter(desiredEmoji, "desiredEmoji");
        if (this.variantsList.isEmpty()) {
            initFromSharedPreferences();
        }
        Emoji base = desiredEmoji.getBase();
        Iterator<T> it = this.variantsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Emoji) next).getBase(), base)) {
                break;
            }
        }
        Emoji emoji = (Emoji) next;
        return emoji == null ? desiredEmoji : emoji;
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public List<Emoji> getVariants(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        return Emojis.isVariantSelector16(emoji) ? CollectionsKt.emptyList() : emoji.getVariants();
    }

    @Override // com.vanniktech.emoji.variant.VariantEmoji
    public void persist() {
        if (this.variantsList.isEmpty()) {
            SharedPreferences preferences = this.preferences;
            Intrinsics.checkNotNullExpressionValue(preferences, "preferences");
            SharedPreferences.Editor editorEdit = preferences.edit();
            editorEdit.remove(VARIANT_EMOJIS);
            editorEdit.apply();
            return;
        }
        StringBuilder sb = new StringBuilder(this.variantsList.size() * 5);
        int size = this.variantsList.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.variantsList.get(i).getUnicode()).append(EMOJI_DELIMITER);
        }
        sb.setLength(sb.length() - 1);
        SharedPreferences preferences2 = this.preferences;
        Intrinsics.checkNotNullExpressionValue(preferences2, "preferences");
        SharedPreferences.Editor editorEdit2 = preferences2.edit();
        editorEdit2.putString(VARIANT_EMOJIS, sb.toString());
        editorEdit2.apply();
    }
}
