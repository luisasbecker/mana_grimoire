package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003JT\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0004\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCircle;", "", "id", "", "is_auto_created", "", "auto_update_type", "", "name", "description", "members", "Lcom/studiolaganne/lengendarylens/MTCircleMembers;", "<init>", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCircleMembers;)V", "getId", "()I", "setId", "(I)V", "()Ljava/lang/Boolean;", "set_auto_created", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAuto_update_type", "()Ljava/lang/String;", "setAuto_update_type", "(Ljava/lang/String;)V", "getName", "setName", "getDescription", "setDescription", "getMembers", "()Lcom/studiolaganne/lengendarylens/MTCircleMembers;", "setMembers", "(Lcom/studiolaganne/lengendarylens/MTCircleMembers;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCircleMembers;)Lcom/studiolaganne/lengendarylens/MTCircle;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCircle {
    public static final int $stable = 8;
    private String auto_update_type;
    private String description;
    private int id;
    private Boolean is_auto_created;
    private MTCircleMembers members;
    private String name;

    public MTCircle() {
        this(0, null, null, null, null, null, 63, null);
    }

    public MTCircle(int i, Boolean bool, String str, String str2, String str3, MTCircleMembers mTCircleMembers) {
        this.id = i;
        this.is_auto_created = bool;
        this.auto_update_type = str;
        this.name = str2;
        this.description = str3;
        this.members = mTCircleMembers;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTCircle(int r2, java.lang.Boolean r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, com.studiolaganne.lengendarylens.MTCircleMembers r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = -1
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
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTCircle.<init>(int, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTCircleMembers, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTCircle copy$default(MTCircle mTCircle, int i, Boolean bool, String str, String str2, String str3, MTCircleMembers mTCircleMembers, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCircle.id;
        }
        if ((i2 & 2) != 0) {
            bool = mTCircle.is_auto_created;
        }
        if ((i2 & 4) != 0) {
            str = mTCircle.auto_update_type;
        }
        if ((i2 & 8) != 0) {
            str2 = mTCircle.name;
        }
        if ((i2 & 16) != 0) {
            str3 = mTCircle.description;
        }
        if ((i2 & 32) != 0) {
            mTCircleMembers = mTCircle.members;
        }
        String str4 = str3;
        MTCircleMembers mTCircleMembers2 = mTCircleMembers;
        return mTCircle.copy(i, bool, str, str2, str4, mTCircleMembers2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIs_auto_created() {
        return this.is_auto_created;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuto_update_type() {
        return this.auto_update_type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTCircleMembers getMembers() {
        return this.members;
    }

    public final MTCircle copy(int id, Boolean is_auto_created, String auto_update_type, String name, String description, MTCircleMembers members) {
        return new MTCircle(id, is_auto_created, auto_update_type, name, description, members);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCircle)) {
            return false;
        }
        MTCircle mTCircle = (MTCircle) other;
        return this.id == mTCircle.id && Intrinsics.areEqual(this.is_auto_created, mTCircle.is_auto_created) && Intrinsics.areEqual(this.auto_update_type, mTCircle.auto_update_type) && Intrinsics.areEqual(this.name, mTCircle.name) && Intrinsics.areEqual(this.description, mTCircle.description) && Intrinsics.areEqual(this.members, mTCircle.members);
    }

    public final String getAuto_update_type() {
        return this.auto_update_type;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    public final MTCircleMembers getMembers() {
        return this.members;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        Boolean bool = this.is_auto_created;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.auto_update_type;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MTCircleMembers mTCircleMembers = this.members;
        return iHashCode5 + (mTCircleMembers != null ? mTCircleMembers.hashCode() : 0);
    }

    public final Boolean is_auto_created() {
        return this.is_auto_created;
    }

    public final void setAuto_update_type(String str) {
        this.auto_update_type = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setMembers(MTCircleMembers mTCircleMembers) {
        this.members = mTCircleMembers;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void set_auto_created(Boolean bool) {
        this.is_auto_created = bool;
    }

    public String toString() {
        return "MTCircle(id=" + this.id + ", is_auto_created=" + this.is_auto_created + ", auto_update_type=" + this.auto_update_type + ", name=" + this.name + ", description=" + this.description + ", members=" + this.members + ")";
    }
}
