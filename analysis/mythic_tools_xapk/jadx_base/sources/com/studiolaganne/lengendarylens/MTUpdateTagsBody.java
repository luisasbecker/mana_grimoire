package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUpdateTagsBody;", "", "tags", "Lcom/studiolaganne/lengendarylens/MTUpdateTagsInnerBody;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTUpdateTagsInnerBody;)V", "getTags", "()Lcom/studiolaganne/lengendarylens/MTUpdateTagsInnerBody;", "setTags", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUpdateTagsBody {
    public static final int $stable = 8;
    private MTUpdateTagsInnerBody tags;

    /* JADX WARN: Multi-variable type inference failed */
    public MTUpdateTagsBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTUpdateTagsBody(MTUpdateTagsInnerBody tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.tags = tags;
    }

    public /* synthetic */ MTUpdateTagsBody(MTUpdateTagsInnerBody mTUpdateTagsInnerBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MTUpdateTagsInnerBody(null, null, 3, null) : mTUpdateTagsInnerBody);
    }

    public static /* synthetic */ MTUpdateTagsBody copy$default(MTUpdateTagsBody mTUpdateTagsBody, MTUpdateTagsInnerBody mTUpdateTagsInnerBody, int i, Object obj) {
        if ((i & 1) != 0) {
            mTUpdateTagsInnerBody = mTUpdateTagsBody.tags;
        }
        return mTUpdateTagsBody.copy(mTUpdateTagsInnerBody);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTUpdateTagsInnerBody getTags() {
        return this.tags;
    }

    public final MTUpdateTagsBody copy(MTUpdateTagsInnerBody tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new MTUpdateTagsBody(tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTUpdateTagsBody) && Intrinsics.areEqual(this.tags, ((MTUpdateTagsBody) other).tags);
    }

    public final MTUpdateTagsInnerBody getTags() {
        return this.tags;
    }

    public int hashCode() {
        return this.tags.hashCode();
    }

    public final void setTags(MTUpdateTagsInnerBody mTUpdateTagsInnerBody) {
        Intrinsics.checkNotNullParameter(mTUpdateTagsInnerBody, "<set-?>");
        this.tags = mTUpdateTagsInnerBody;
    }

    public String toString() {
        return "MTUpdateTagsBody(tags=" + this.tags + ")";
    }
}
