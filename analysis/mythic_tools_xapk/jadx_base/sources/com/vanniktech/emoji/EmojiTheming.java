package com.vanniktech.emoji;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.vanniktech.emoji.internal.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiTheming.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0003J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/vanniktech/emoji/EmojiTheming;", "Landroid/os/Parcelable;", "backgroundColor", "", "primaryColor", "secondaryColor", "dividerColor", "textColor", "textSecondaryColor", "<init>", "(IIIIII)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EmojiTheming implements Parcelable {
    public final int backgroundColor;
    public final int dividerColor;
    public final int primaryColor;
    public final int secondaryColor;
    public final int textColor;
    public final int textSecondaryColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<EmojiTheming> CREATOR = new Creator();

    /* JADX INFO: compiled from: EmojiTheming.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/vanniktech/emoji/EmojiTheming$Companion;", "", "<init>", "()V", "from", "Lcom/vanniktech/emoji/EmojiTheming;", "context", "Landroid/content/Context;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EmojiTheming from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new EmojiTheming(Utils.INSTANCE.resolveColor$emoji_release(context, R.attr.emojiBackgroundColor, R.color.emoji_background_color), Utils.INSTANCE.resolveColor$emoji_release(context, android.R.attr.colorPrimary, R.color.emoji_primary_color), Utils.INSTANCE.resolveColor$emoji_release(context, android.R.attr.colorAccent, R.color.emoji_secondary_color), Utils.INSTANCE.resolveColor$emoji_release(context, R.attr.emojiDividerColor, R.color.emoji_divider_color), Utils.INSTANCE.resolveColor$emoji_release(context, R.attr.emojiTextColor, R.color.emoji_text_color), Utils.INSTANCE.resolveColor$emoji_release(context, R.attr.emojiTextSecondaryColor, R.color.emoji_text_secondary_color));
        }
    }

    /* JADX INFO: compiled from: EmojiTheming.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmojiTheming> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EmojiTheming createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EmojiTheming(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EmojiTheming[] newArray(int i) {
            return new EmojiTheming[i];
        }
    }

    public EmojiTheming(int i, int i2, int i3, int i4, int i5, int i6) {
        this.backgroundColor = i;
        this.primaryColor = i2;
        this.secondaryColor = i3;
        this.dividerColor = i4;
        this.textColor = i5;
        this.textSecondaryColor = i6;
    }

    public static /* synthetic */ EmojiTheming copy$default(EmojiTheming emojiTheming, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = emojiTheming.backgroundColor;
        }
        if ((i7 & 2) != 0) {
            i2 = emojiTheming.primaryColor;
        }
        if ((i7 & 4) != 0) {
            i3 = emojiTheming.secondaryColor;
        }
        if ((i7 & 8) != 0) {
            i4 = emojiTheming.dividerColor;
        }
        if ((i7 & 16) != 0) {
            i5 = emojiTheming.textColor;
        }
        if ((i7 & 32) != 0) {
            i6 = emojiTheming.textSecondaryColor;
        }
        int i8 = i5;
        int i9 = i6;
        return emojiTheming.copy(i, i2, i3, i4, i8, i9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPrimaryColor() {
        return this.primaryColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSecondaryColor() {
        return this.secondaryColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDividerColor() {
        return this.dividerColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTextSecondaryColor() {
        return this.textSecondaryColor;
    }

    public final EmojiTheming copy(int backgroundColor, int primaryColor, int secondaryColor, int dividerColor, int textColor, int textSecondaryColor) {
        return new EmojiTheming(backgroundColor, primaryColor, secondaryColor, dividerColor, textColor, textSecondaryColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiTheming)) {
            return false;
        }
        EmojiTheming emojiTheming = (EmojiTheming) other;
        return this.backgroundColor == emojiTheming.backgroundColor && this.primaryColor == emojiTheming.primaryColor && this.secondaryColor == emojiTheming.secondaryColor && this.dividerColor == emojiTheming.dividerColor && this.textColor == emojiTheming.textColor && this.textSecondaryColor == emojiTheming.textSecondaryColor;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.backgroundColor) * 31) + Integer.hashCode(this.primaryColor)) * 31) + Integer.hashCode(this.secondaryColor)) * 31) + Integer.hashCode(this.dividerColor)) * 31) + Integer.hashCode(this.textColor)) * 31) + Integer.hashCode(this.textSecondaryColor);
    }

    public String toString() {
        return "EmojiTheming(backgroundColor=" + this.backgroundColor + ", primaryColor=" + this.primaryColor + ", secondaryColor=" + this.secondaryColor + ", dividerColor=" + this.dividerColor + ", textColor=" + this.textColor + ", textSecondaryColor=" + this.textSecondaryColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.primaryColor);
        dest.writeInt(this.secondaryColor);
        dest.writeInt(this.dividerColor);
        dest.writeInt(this.textColor);
        dest.writeInt(this.textSecondaryColor);
    }
}
