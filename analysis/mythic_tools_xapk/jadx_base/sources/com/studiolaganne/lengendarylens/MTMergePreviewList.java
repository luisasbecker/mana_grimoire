package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003JH\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMergePreviewList;", "", "id", "", "name", "", "type", "color", "facecard", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSimpleCard;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColor", "setColor", "getFacecard", "()Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "setFacecard", "(Lcom/studiolaganne/lengendarylens/MTSimpleCard;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSimpleCard;)Lcom/studiolaganne/lengendarylens/MTMergePreviewList;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMergePreviewList {
    public static final int $stable = 8;
    private String color;
    private MTSimpleCard facecard;
    private int id;
    private String name;
    private Integer type;

    public MTMergePreviewList() {
        this(0, null, null, null, null, 31, null);
    }

    public MTMergePreviewList(int i, String str, Integer num, String str2, MTSimpleCard mTSimpleCard) {
        this.id = i;
        this.name = str;
        this.type = num;
        this.color = str2;
        this.facecard = mTSimpleCard;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTMergePreviewList(int r2, java.lang.String r3, java.lang.Integer r4, java.lang.String r5, com.studiolaganne.lengendarylens.MTSimpleCard r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L5
            r2 = -1
        L5:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lb
            r3 = r0
        Lb:
            r8 = r7 & 4
            if (r8 == 0) goto L10
            r4 = r0
        L10:
            r8 = r7 & 8
            if (r8 == 0) goto L15
            r5 = r0
        L15:
            r7 = r7 & 16
            if (r7 == 0) goto L20
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L26
        L20:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L26:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTMergePreviewList.<init>(int, java.lang.String, java.lang.Integer, java.lang.String, com.studiolaganne.lengendarylens.MTSimpleCard, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTMergePreviewList copy$default(MTMergePreviewList mTMergePreviewList, int i, String str, Integer num, String str2, MTSimpleCard mTSimpleCard, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTMergePreviewList.id;
        }
        if ((i2 & 2) != 0) {
            str = mTMergePreviewList.name;
        }
        if ((i2 & 4) != 0) {
            num = mTMergePreviewList.type;
        }
        if ((i2 & 8) != 0) {
            str2 = mTMergePreviewList.color;
        }
        if ((i2 & 16) != 0) {
            mTSimpleCard = mTMergePreviewList.facecard;
        }
        MTSimpleCard mTSimpleCard2 = mTSimpleCard;
        Integer num2 = num;
        return mTMergePreviewList.copy(i, str, num2, str2, mTSimpleCard2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTSimpleCard getFacecard() {
        return this.facecard;
    }

    public final MTMergePreviewList copy(int id, String name, Integer type, String color, MTSimpleCard facecard) {
        return new MTMergePreviewList(id, name, type, color, facecard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMergePreviewList)) {
            return false;
        }
        MTMergePreviewList mTMergePreviewList = (MTMergePreviewList) other;
        return this.id == mTMergePreviewList.id && Intrinsics.areEqual(this.name, mTMergePreviewList.name) && Intrinsics.areEqual(this.type, mTMergePreviewList.type) && Intrinsics.areEqual(this.color, mTMergePreviewList.color) && Intrinsics.areEqual(this.facecard, mTMergePreviewList.facecard);
    }

    public final String getColor() {
        return this.color;
    }

    public final MTSimpleCard getFacecard() {
        return this.facecard;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.type;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.color;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTSimpleCard mTSimpleCard = this.facecard;
        return iHashCode4 + (mTSimpleCard != null ? mTSimpleCard.hashCode() : 0);
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setFacecard(MTSimpleCard mTSimpleCard) {
        this.facecard = mTSimpleCard;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "MTMergePreviewList(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", color=" + this.color + ", facecard=" + this.facecard + ")";
    }
}
