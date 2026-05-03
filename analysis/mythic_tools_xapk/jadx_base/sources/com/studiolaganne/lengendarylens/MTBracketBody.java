package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBracketBody;", "", "bracket", "", "<init>", "(Ljava/lang/Integer;)V", "getBracket", "()Ljava/lang/Integer;", "setBracket", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTBracketBody;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBracketBody {
    public static final int $stable = 8;
    private Integer bracket;

    /* JADX WARN: Multi-variable type inference failed */
    public MTBracketBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTBracketBody(Integer num) {
        this.bracket = num;
    }

    public /* synthetic */ MTBracketBody(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public static /* synthetic */ MTBracketBody copy$default(MTBracketBody mTBracketBody, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTBracketBody.bracket;
        }
        return mTBracketBody.copy(num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getBracket() {
        return this.bracket;
    }

    public final MTBracketBody copy(Integer bracket) {
        return new MTBracketBody(bracket);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTBracketBody) && Intrinsics.areEqual(this.bracket, ((MTBracketBody) other).bracket);
    }

    public final Integer getBracket() {
        return this.bracket;
    }

    public int hashCode() {
        Integer num = this.bracket;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setBracket(Integer num) {
        this.bracket = num;
    }

    public String toString() {
        return "MTBracketBody(bracket=" + this.bracket + ")";
    }
}
