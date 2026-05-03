package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBracket;", "", "user", "", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "type", "", "needs_recalc", "", "metrics", "Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/MTBracketMetrics;)V", "getUser", "()Ljava/lang/Integer;", "setUser", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAuto", "setAuto", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getNeeds_recalc", "()Ljava/lang/Boolean;", "setNeeds_recalc", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMetrics", "()Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "setMetrics", "(Lcom/studiolaganne/lengendarylens/MTBracketMetrics;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/MTBracketMetrics;)Lcom/studiolaganne/lengendarylens/MTBracket;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBracket {
    public static final int $stable = 8;
    private Integer auto;
    private MTBracketMetrics metrics;
    private Boolean needs_recalc;
    private String type;
    private Integer user;

    public MTBracket() {
        this(null, null, null, null, null, 31, null);
    }

    public MTBracket(Integer num, Integer num2, String str, Boolean bool, MTBracketMetrics mTBracketMetrics) {
        this.user = num;
        this.auto = num2;
        this.type = str;
        this.needs_recalc = bool;
        this.metrics = mTBracketMetrics;
    }

    public /* synthetic */ MTBracket(Integer num, Integer num2, String str, Boolean bool, MTBracketMetrics mTBracketMetrics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : mTBracketMetrics);
    }

    public static /* synthetic */ MTBracket copy$default(MTBracket mTBracket, Integer num, Integer num2, String str, Boolean bool, MTBracketMetrics mTBracketMetrics, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTBracket.user;
        }
        if ((i & 2) != 0) {
            num2 = mTBracket.auto;
        }
        if ((i & 4) != 0) {
            str = mTBracket.type;
        }
        if ((i & 8) != 0) {
            bool = mTBracket.needs_recalc;
        }
        if ((i & 16) != 0) {
            mTBracketMetrics = mTBracket.metrics;
        }
        MTBracketMetrics mTBracketMetrics2 = mTBracketMetrics;
        String str2 = str;
        return mTBracket.copy(num, num2, str2, bool, mTBracketMetrics2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAuto() {
        return this.auto;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getNeeds_recalc() {
        return this.needs_recalc;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTBracketMetrics getMetrics() {
        return this.metrics;
    }

    public final MTBracket copy(Integer user, Integer auto, String type, Boolean needs_recalc, MTBracketMetrics metrics) {
        return new MTBracket(user, auto, type, needs_recalc, metrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTBracket)) {
            return false;
        }
        MTBracket mTBracket = (MTBracket) other;
        return Intrinsics.areEqual(this.user, mTBracket.user) && Intrinsics.areEqual(this.auto, mTBracket.auto) && Intrinsics.areEqual(this.type, mTBracket.type) && Intrinsics.areEqual(this.needs_recalc, mTBracket.needs_recalc) && Intrinsics.areEqual(this.metrics, mTBracket.metrics);
    }

    public final Integer getAuto() {
        return this.auto;
    }

    public final MTBracketMetrics getMetrics() {
        return this.metrics;
    }

    public final Boolean getNeeds_recalc() {
        return this.needs_recalc;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getUser() {
        return this.user;
    }

    public int hashCode() {
        Integer num = this.user;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.auto;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.type;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.needs_recalc;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        MTBracketMetrics mTBracketMetrics = this.metrics;
        return iHashCode4 + (mTBracketMetrics != null ? mTBracketMetrics.hashCode() : 0);
    }

    public final void setAuto(Integer num) {
        this.auto = num;
    }

    public final void setMetrics(MTBracketMetrics mTBracketMetrics) {
        this.metrics = mTBracketMetrics;
    }

    public final void setNeeds_recalc(Boolean bool) {
        this.needs_recalc = bool;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUser(Integer num) {
        this.user = num;
    }

    public String toString() {
        return "MTBracket(user=" + this.user + ", auto=" + this.auto + ", type=" + this.type + ", needs_recalc=" + this.needs_recalc + ", metrics=" + this.metrics + ")";
    }
}
