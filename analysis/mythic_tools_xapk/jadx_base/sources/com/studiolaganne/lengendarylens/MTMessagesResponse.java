package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMessagesResponse;", "", "messages", "", "Lcom/studiolaganne/lengendarylens/MTMessage;", "lastRead", "", "<init>", "(Ljava/util/List;I)V", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "getLastRead", "()I", "setLastRead", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMessagesResponse {
    public static final int $stable = 8;
    private int lastRead;
    private List<MTMessage> messages;

    /* JADX WARN: Multi-variable type inference failed */
    public MTMessagesResponse() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public MTMessagesResponse(List<MTMessage> messages, int i) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messages = messages;
        this.lastRead = i;
    }

    public /* synthetic */ MTMessagesResponse(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTMessagesResponse copy$default(MTMessagesResponse mTMessagesResponse, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = mTMessagesResponse.messages;
        }
        if ((i2 & 2) != 0) {
            i = mTMessagesResponse.lastRead;
        }
        return mTMessagesResponse.copy(list, i);
    }

    public final List<MTMessage> component1() {
        return this.messages;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLastRead() {
        return this.lastRead;
    }

    public final MTMessagesResponse copy(List<MTMessage> messages, int lastRead) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new MTMessagesResponse(messages, lastRead);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMessagesResponse)) {
            return false;
        }
        MTMessagesResponse mTMessagesResponse = (MTMessagesResponse) other;
        return Intrinsics.areEqual(this.messages, mTMessagesResponse.messages) && this.lastRead == mTMessagesResponse.lastRead;
    }

    public final int getLastRead() {
        return this.lastRead;
    }

    public final List<MTMessage> getMessages() {
        return this.messages;
    }

    public int hashCode() {
        return (this.messages.hashCode() * 31) + Integer.hashCode(this.lastRead);
    }

    public final void setLastRead(int i) {
        this.lastRead = i;
    }

    public final void setMessages(List<MTMessage> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.messages = list;
    }

    public String toString() {
        return "MTMessagesResponse(messages=" + this.messages + ", lastRead=" + this.lastRead + ")";
    }
}
