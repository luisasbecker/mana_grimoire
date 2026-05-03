package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ^\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTrophy;", "", "id", "", "name", "", "description", "image_url", "localization", "Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;", "current_value", "next_level_value", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getImage_url", "setImage_url", "getLocalization", "()Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;", "setLocalization", "(Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;)V", "getCurrent_value", "()Ljava/lang/Integer;", "setCurrent_value", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNext_level_value", "setNext_level_value", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTTrophy;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTrophy {
    public static final int $stable = 8;
    private Integer current_value;
    private String description;
    private int id;
    private String image_url;
    private MTTrophyLocalization localization;
    private String name;
    private Integer next_level_value;

    public MTTrophy() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public MTTrophy(int i, String name, String str, String str2, MTTrophyLocalization mTTrophyLocalization, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.description = str;
        this.image_url = str2;
        this.localization = mTTrophyLocalization;
        this.current_value = num;
        this.next_level_value = num2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTTrophy(int r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, com.studiolaganne.lengendarylens.MTTrophyLocalization r6, java.lang.Integer r7, java.lang.Integer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r2 = -1
        L5:
            r10 = r9 & 2
            if (r10 == 0) goto Lb
            java.lang.String r3 = ""
        Lb:
            r10 = r9 & 4
            r0 = 0
            if (r10 == 0) goto L11
            r4 = r0
        L11:
            r10 = r9 & 8
            if (r10 == 0) goto L16
            r5 = r0
        L16:
            r10 = r9 & 16
            if (r10 == 0) goto L1b
            r6 = r0
        L1b:
            r10 = r9 & 32
            if (r10 == 0) goto L20
            r7 = r0
        L20:
            r9 = r9 & 64
            if (r9 == 0) goto L2d
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L35
        L2d:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L35:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTTrophy.<init>(int, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTTrophyLocalization, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTTrophy copy$default(MTTrophy mTTrophy, int i, String str, String str2, String str3, MTTrophyLocalization mTTrophyLocalization, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTTrophy.id;
        }
        if ((i2 & 2) != 0) {
            str = mTTrophy.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTTrophy.description;
        }
        if ((i2 & 8) != 0) {
            str3 = mTTrophy.image_url;
        }
        if ((i2 & 16) != 0) {
            mTTrophyLocalization = mTTrophy.localization;
        }
        if ((i2 & 32) != 0) {
            num = mTTrophy.current_value;
        }
        if ((i2 & 64) != 0) {
            num2 = mTTrophy.next_level_value;
        }
        Integer num3 = num;
        Integer num4 = num2;
        MTTrophyLocalization mTTrophyLocalization2 = mTTrophyLocalization;
        String str4 = str2;
        return mTTrophy.copy(i, str, str4, str3, mTTrophyLocalization2, num3, num4);
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
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage_url() {
        return this.image_url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTTrophyLocalization getLocalization() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getCurrent_value() {
        return this.current_value;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getNext_level_value() {
        return this.next_level_value;
    }

    public final MTTrophy copy(int id, String name, String description, String image_url, MTTrophyLocalization localization, Integer current_value, Integer next_level_value) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTTrophy(id, name, description, image_url, localization, current_value, next_level_value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTrophy)) {
            return false;
        }
        MTTrophy mTTrophy = (MTTrophy) other;
        return this.id == mTTrophy.id && Intrinsics.areEqual(this.name, mTTrophy.name) && Intrinsics.areEqual(this.description, mTTrophy.description) && Intrinsics.areEqual(this.image_url, mTTrophy.image_url) && Intrinsics.areEqual(this.localization, mTTrophy.localization) && Intrinsics.areEqual(this.current_value, mTTrophy.current_value) && Intrinsics.areEqual(this.next_level_value, mTTrophy.next_level_value);
    }

    public final Integer getCurrent_value() {
        return this.current_value;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final MTTrophyLocalization getLocalization() {
        return this.localization;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getNext_level_value() {
        return this.next_level_value;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.image_url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTTrophyLocalization mTTrophyLocalization = this.localization;
        int iHashCode4 = (iHashCode3 + (mTTrophyLocalization == null ? 0 : mTTrophyLocalization.hashCode())) * 31;
        Integer num = this.current_value;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.next_level_value;
        return iHashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCurrent_value(Integer num) {
        this.current_value = num;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImage_url(String str) {
        this.image_url = str;
    }

    public final void setLocalization(MTTrophyLocalization mTTrophyLocalization) {
        this.localization = mTTrophyLocalization;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setNext_level_value(Integer num) {
        this.next_level_value = num;
    }

    public String toString() {
        return "MTTrophy(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", image_url=" + this.image_url + ", localization=" + this.localization + ", current_value=" + this.current_value + ", next_level_value=" + this.next_level_value + ")";
    }
}
