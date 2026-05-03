package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDescriptionBody;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDescriptionBody {
    public static final int $stable = 8;
    private String description;

    public MTDescriptionBody(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
    }

    public static /* synthetic */ MTDescriptionBody copy$default(MTDescriptionBody mTDescriptionBody, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTDescriptionBody.description;
        }
        return mTDescriptionBody.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MTDescriptionBody copy(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new MTDescriptionBody(description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTDescriptionBody) && Intrinsics.areEqual(this.description, ((MTDescriptionBody) other).description);
    }

    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return this.description.hashCode();
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public String toString() {
        return "MTDescriptionBody(description=" + this.description + ")";
    }
}
