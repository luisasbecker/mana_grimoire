package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardRoleBreakdown;", "", "role", "", "actual", "", "recommended", "delta", "status", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getActual", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecommended", "getDelta", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardRoleBreakdown;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardRoleBreakdown {
    public static final int $stable = 0;
    private final Integer actual;
    private final Integer delta;
    private final Integer recommended;
    private final String role;
    private final String status;

    public MTIdCardRoleBreakdown() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardRoleBreakdown(String str, Integer num, Integer num2, Integer num3, String str2) {
        this.role = str;
        this.actual = num;
        this.recommended = num2;
        this.delta = num3;
        this.status = str2;
    }

    public /* synthetic */ MTIdCardRoleBreakdown(String str, Integer num, Integer num2, Integer num3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str2);
    }

    public static /* synthetic */ MTIdCardRoleBreakdown copy$default(MTIdCardRoleBreakdown mTIdCardRoleBreakdown, String str, Integer num, Integer num2, Integer num3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardRoleBreakdown.role;
        }
        if ((i & 2) != 0) {
            num = mTIdCardRoleBreakdown.actual;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardRoleBreakdown.recommended;
        }
        if ((i & 8) != 0) {
            num3 = mTIdCardRoleBreakdown.delta;
        }
        if ((i & 16) != 0) {
            str2 = mTIdCardRoleBreakdown.status;
        }
        String str3 = str2;
        Integer num4 = num2;
        return mTIdCardRoleBreakdown.copy(str, num, num4, num3, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getActual() {
        return this.actual;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getRecommended() {
        return this.recommended;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getDelta() {
        return this.delta;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MTIdCardRoleBreakdown copy(String role, Integer actual, Integer recommended, Integer delta, String status) {
        return new MTIdCardRoleBreakdown(role, actual, recommended, delta, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardRoleBreakdown)) {
            return false;
        }
        MTIdCardRoleBreakdown mTIdCardRoleBreakdown = (MTIdCardRoleBreakdown) other;
        return Intrinsics.areEqual(this.role, mTIdCardRoleBreakdown.role) && Intrinsics.areEqual(this.actual, mTIdCardRoleBreakdown.actual) && Intrinsics.areEqual(this.recommended, mTIdCardRoleBreakdown.recommended) && Intrinsics.areEqual(this.delta, mTIdCardRoleBreakdown.delta) && Intrinsics.areEqual(this.status, mTIdCardRoleBreakdown.status);
    }

    public final Integer getActual() {
        return this.actual;
    }

    public final Integer getDelta() {
        return this.delta;
    }

    public final Integer getRecommended() {
        return this.recommended;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.role;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.actual;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.recommended;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.delta;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.status;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardRoleBreakdown(role=" + this.role + ", actual=" + this.actual + ", recommended=" + this.recommended + ", delta=" + this.delta + ", status=" + this.status + ")";
    }
}
