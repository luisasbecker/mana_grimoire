package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessagesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessageItemHolder;", "", "type", "", "message", "Lcom/studiolaganne/lengendarylens/MTMessage;", "separator", "", "<init>", "(ILcom/studiolaganne/lengendarylens/MTMessage;Ljava/lang/String;)V", "getType", "()I", "getMessage", "()Lcom/studiolaganne/lengendarylens/MTMessage;", "setMessage", "(Lcom/studiolaganne/lengendarylens/MTMessage;)V", "getSeparator", "()Ljava/lang/String;", "setSeparator", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MessageItemHolder {
    public static final int $stable = 8;
    private MTMessage message;
    private String separator;
    private final int type;

    public MessageItemHolder() {
        this(0, null, null, 7, null);
    }

    public MessageItemHolder(int i, MTMessage mTMessage, String str) {
        this.type = i;
        this.message = mTMessage;
        this.separator = str;
    }

    public /* synthetic */ MessageItemHolder(int i, MTMessage mTMessage, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : mTMessage, (i2 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ MessageItemHolder copy$default(MessageItemHolder messageItemHolder, int i, MTMessage mTMessage, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messageItemHolder.type;
        }
        if ((i2 & 2) != 0) {
            mTMessage = messageItemHolder.message;
        }
        if ((i2 & 4) != 0) {
            str = messageItemHolder.separator;
        }
        return messageItemHolder.copy(i, mTMessage, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTMessage getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeparator() {
        return this.separator;
    }

    public final MessageItemHolder copy(int type, MTMessage message, String separator) {
        return new MessageItemHolder(type, message, separator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageItemHolder)) {
            return false;
        }
        MessageItemHolder messageItemHolder = (MessageItemHolder) other;
        return this.type == messageItemHolder.type && Intrinsics.areEqual(this.message, messageItemHolder.message) && Intrinsics.areEqual(this.separator, messageItemHolder.separator);
    }

    public final MTMessage getMessage() {
        return this.message;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        MTMessage mTMessage = this.message;
        int iHashCode2 = (iHashCode + (mTMessage == null ? 0 : mTMessage.hashCode())) * 31;
        String str = this.separator;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setMessage(MTMessage mTMessage) {
        this.message = mTMessage;
    }

    public final void setSeparator(String str) {
        this.separator = str;
    }

    public String toString() {
        return "MessageItemHolder(type=" + this.type + ", message=" + this.message + ", separator=" + this.separator + ")";
    }
}
