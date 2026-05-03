package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/Pairing;", "", "version", "", "firstPlayerId", "secondPlayerId", "firstPlayerScore", "", "secondPlayerScore", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getFirstPlayerId", "setFirstPlayerId", "getSecondPlayerId", "setSecondPlayerId", "getFirstPlayerScore", "()I", "setFirstPlayerScore", "(I)V", "getSecondPlayerScore", "setSecondPlayerScore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Pairing {
    public static final int $stable = 8;
    private String firstPlayerId;
    private int firstPlayerScore;
    private String secondPlayerId;
    private int secondPlayerScore;
    private String version;

    public Pairing() {
        this(null, null, null, 0, 0, 31, null);
    }

    public Pairing(String version, String firstPlayerId, String secondPlayerId, int i, int i2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(firstPlayerId, "firstPlayerId");
        Intrinsics.checkNotNullParameter(secondPlayerId, "secondPlayerId");
        this.version = version;
        this.firstPlayerId = firstPlayerId;
        this.secondPlayerId = secondPlayerId;
        this.firstPlayerScore = i;
        this.secondPlayerScore = i2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ Pairing(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5, int r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L7
            java.lang.String r2 = "v1"
        L7:
            r8 = r7 & 2
            java.lang.String r0 = ""
            if (r8 == 0) goto Le
            r3 = r0
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L13
            r4 = r0
        L13:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L19
            r5 = r0
        L19:
            r7 = r7 & 16
            if (r7 == 0) goto L24
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2a
        L24:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2a:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.Pairing.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ Pairing copy$default(Pairing pairing, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pairing.version;
        }
        if ((i3 & 2) != 0) {
            str2 = pairing.firstPlayerId;
        }
        if ((i3 & 4) != 0) {
            str3 = pairing.secondPlayerId;
        }
        if ((i3 & 8) != 0) {
            i = pairing.firstPlayerScore;
        }
        if ((i3 & 16) != 0) {
            i2 = pairing.secondPlayerScore;
        }
        int i4 = i2;
        String str4 = str3;
        return pairing.copy(str, str2, str4, i, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstPlayerId() {
        return this.firstPlayerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSecondPlayerId() {
        return this.secondPlayerId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFirstPlayerScore() {
        return this.firstPlayerScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSecondPlayerScore() {
        return this.secondPlayerScore;
    }

    public final Pairing copy(String version, String firstPlayerId, String secondPlayerId, int firstPlayerScore, int secondPlayerScore) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(firstPlayerId, "firstPlayerId");
        Intrinsics.checkNotNullParameter(secondPlayerId, "secondPlayerId");
        return new Pairing(version, firstPlayerId, secondPlayerId, firstPlayerScore, secondPlayerScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pairing)) {
            return false;
        }
        Pairing pairing = (Pairing) other;
        return Intrinsics.areEqual(this.version, pairing.version) && Intrinsics.areEqual(this.firstPlayerId, pairing.firstPlayerId) && Intrinsics.areEqual(this.secondPlayerId, pairing.secondPlayerId) && this.firstPlayerScore == pairing.firstPlayerScore && this.secondPlayerScore == pairing.secondPlayerScore;
    }

    public final String getFirstPlayerId() {
        return this.firstPlayerId;
    }

    public final int getFirstPlayerScore() {
        return this.firstPlayerScore;
    }

    public final String getSecondPlayerId() {
        return this.secondPlayerId;
    }

    public final int getSecondPlayerScore() {
        return this.secondPlayerScore;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((this.version.hashCode() * 31) + this.firstPlayerId.hashCode()) * 31) + this.secondPlayerId.hashCode()) * 31) + Integer.hashCode(this.firstPlayerScore)) * 31) + Integer.hashCode(this.secondPlayerScore);
    }

    public final void setFirstPlayerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstPlayerId = str;
    }

    public final void setFirstPlayerScore(int i) {
        this.firstPlayerScore = i;
    }

    public final void setSecondPlayerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondPlayerId = str;
    }

    public final void setSecondPlayerScore(int i) {
        this.secondPlayerScore = i;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "Pairing(version=" + this.version + ", firstPlayerId=" + this.firstPlayerId + ", secondPlayerId=" + this.secondPlayerId + ", firstPlayerScore=" + this.firstPlayerScore + ", secondPlayerScore=" + this.secondPlayerScore + ")";
    }
}
