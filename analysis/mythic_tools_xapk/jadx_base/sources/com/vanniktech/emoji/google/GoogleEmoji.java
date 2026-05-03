package com.vanniktech.emoji.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.vanniktech.emoji.Emoji;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004J\n\u0010\u001e\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020\u0003H\u0096\u0080\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/vanniktech/emoji/google/GoogleEmoji;", "Lcom/vanniktech/emoji/Emoji;", "unicode", "", "shortcodes", "", "x", "", "y", "variants", "parent", "<init>", "(Ljava/lang/String;Ljava/util/List;IILjava/util/List;Lcom/vanniktech/emoji/google/GoogleEmoji;)V", "getUnicode", "()Ljava/lang/String;", "getShortcodes", "()Ljava/util/List;", "getX$emoji_google_release", "()I", "getY$emoji_google_release", "getVariants", "base", "getBase", "()Lcom/vanniktech/emoji/google/GoogleEmoji;", "base$delegate", "Lkotlin/Lazy;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "emoji-google_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleEmoji implements Emoji {

    /* JADX INFO: renamed from: base$delegate, reason: from kotlin metadata */
    private final Lazy base;
    private GoogleEmoji parent;
    private final List<String> shortcodes;
    private final String unicode;
    private final List<GoogleEmoji> variants;
    private final int x;
    private final int y;

    public GoogleEmoji(String unicode, List<String> shortcodes, int i, int i2, List<GoogleEmoji> variants, GoogleEmoji googleEmoji) {
        Intrinsics.checkNotNullParameter(unicode, "unicode");
        Intrinsics.checkNotNullParameter(shortcodes, "shortcodes");
        Intrinsics.checkNotNullParameter(variants, "variants");
        this.unicode = unicode;
        this.shortcodes = shortcodes;
        this.x = i;
        this.y = i2;
        this.variants = variants;
        this.parent = googleEmoji;
        this.base = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.vanniktech.emoji.google.GoogleEmoji$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleEmoji.base_delegate$lambda$0(this.f$0);
            }
        });
        Iterator<GoogleEmoji> it = getVariants().iterator();
        while (it.hasNext()) {
            it.next().parent = this;
        }
    }

    public /* synthetic */ GoogleEmoji(String str, List list, int i, int i2, List list2, GoogleEmoji googleEmoji, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i, i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 32) != 0 ? null : googleEmoji);
    }

    static final GoogleEmoji base_delegate$lambda$0(GoogleEmoji googleEmoji) {
        while (true) {
            GoogleEmoji googleEmoji2 = googleEmoji.parent;
            if (googleEmoji2 == null) {
                return googleEmoji;
            }
            Intrinsics.checkNotNull(googleEmoji2);
            googleEmoji = googleEmoji2;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GoogleEmoji googleEmoji = (GoogleEmoji) other;
        return Intrinsics.areEqual(getUnicode(), googleEmoji.getUnicode()) && Intrinsics.areEqual(getShortcodes(), googleEmoji.getShortcodes()) && this.x == googleEmoji.x && this.y == googleEmoji.y && Intrinsics.areEqual(getVariants(), googleEmoji.getVariants());
    }

    @Override // com.vanniktech.emoji.Emoji
    public GoogleEmoji getBase() {
        return (GoogleEmoji) this.base.getValue();
    }

    @Override // com.vanniktech.emoji.Emoji
    public List<String> getShortcodes() {
        return this.shortcodes;
    }

    @Override // com.vanniktech.emoji.Emoji
    public String getUnicode() {
        return this.unicode;
    }

    @Override // com.vanniktech.emoji.Emoji
    public List<GoogleEmoji> getVariants() {
        return this.variants;
    }

    /* JADX INFO: renamed from: getX$emoji_google_release, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: getY$emoji_google_release, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((getUnicode().hashCode() * 31) + getShortcodes().hashCode()) * 31) + this.x) * 31) + this.y) * 31) + getVariants().hashCode();
    }

    public String toString() {
        return "GoogleEmoji(unicode='" + getUnicode() + "', shortcodes=" + getShortcodes() + ", x=" + this.x + ", y=" + this.y + ", variants=" + getVariants() + ")";
    }
}
