package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJT\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPagination;", "", "page", "", "limit", "total", "total_pages", "has_next", "", "has_previous", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getPage", "()I", "setPage", "(I)V", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotal", "setTotal", "getTotal_pages", "setTotal_pages", "getHas_next", "()Ljava/lang/Boolean;", "setHas_next", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHas_previous", "setHas_previous", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTPagination;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPagination {
    public static final int $stable = 8;
    private Boolean has_next;
    private Boolean has_previous;
    private Integer limit;
    private int page;
    private Integer total;
    private Integer total_pages;

    public MTPagination() {
        this(0, null, null, null, null, null, 63, null);
    }

    public MTPagination(int i, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2) {
        this.page = i;
        this.limit = num;
        this.total = num2;
        this.total_pages = num3;
        this.has_next = bool;
        this.has_previous = bool2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTPagination(int r2, java.lang.Integer r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.Boolean r6, java.lang.Boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 1
        L5:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = r0
        L15:
            r9 = r8 & 16
            if (r9 == 0) goto L1a
            r6 = r0
        L1a:
            r8 = r8 & 32
            if (r8 == 0) goto L26
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L26:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTPagination.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTPagination copy$default(MTPagination mTPagination, int i, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTPagination.page;
        }
        if ((i2 & 2) != 0) {
            num = mTPagination.limit;
        }
        if ((i2 & 4) != 0) {
            num2 = mTPagination.total;
        }
        if ((i2 & 8) != 0) {
            num3 = mTPagination.total_pages;
        }
        if ((i2 & 16) != 0) {
            bool = mTPagination.has_next;
        }
        if ((i2 & 32) != 0) {
            bool2 = mTPagination.has_previous;
        }
        Boolean bool3 = bool;
        Boolean bool4 = bool2;
        return mTPagination.copy(i, num, num2, num3, bool3, bool4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTotal_pages() {
        return this.total_pages;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getHas_next() {
        return this.has_next;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getHas_previous() {
        return this.has_previous;
    }

    public final MTPagination copy(int page, Integer limit, Integer total, Integer total_pages, Boolean has_next, Boolean has_previous) {
        return new MTPagination(page, limit, total, total_pages, has_next, has_previous);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPagination)) {
            return false;
        }
        MTPagination mTPagination = (MTPagination) other;
        return this.page == mTPagination.page && Intrinsics.areEqual(this.limit, mTPagination.limit) && Intrinsics.areEqual(this.total, mTPagination.total) && Intrinsics.areEqual(this.total_pages, mTPagination.total_pages) && Intrinsics.areEqual(this.has_next, mTPagination.has_next) && Intrinsics.areEqual(this.has_previous, mTPagination.has_previous);
    }

    public final Boolean getHas_next() {
        return this.has_next;
    }

    public final Boolean getHas_previous() {
        return this.has_previous;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final int getPage() {
        return this.page;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public final Integer getTotal_pages() {
        return this.total_pages;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.page) * 31;
        Integer num = this.limit;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.total;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.total_pages;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.has_next;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.has_previous;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setHas_next(Boolean bool) {
        this.has_next = bool;
    }

    public final void setHas_previous(Boolean bool) {
        this.has_previous = bool;
    }

    public final void setLimit(Integer num) {
        this.limit = num;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final void setTotal(Integer num) {
        this.total = num;
    }

    public final void setTotal_pages(Integer num) {
        this.total_pages = num;
    }

    public String toString() {
        return "MTPagination(page=" + this.page + ", limit=" + this.limit + ", total=" + this.total + ", total_pages=" + this.total_pages + ", has_next=" + this.has_next + ", has_previous=" + this.has_previous + ")";
    }
}
