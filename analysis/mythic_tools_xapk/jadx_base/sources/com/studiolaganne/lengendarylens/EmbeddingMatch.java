package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedAnalyzer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003Jw\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\tHÆ\u0001J\u0013\u00107\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0007HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010(R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010(¨\u0006;"}, d2 = {"Lcom/studiolaganne/lengendarylens/EmbeddingMatch;", "", "cardRecord", "Lcom/studiolaganne/lengendarylens/CardRecord;", "scryfallId", "", OptionalModuleUtils.FACE, "", "similarity", "", "oracleId", "setSymbolHashFromImage", "", "setSymbolHashFromDB", "hasPListStamp", "", "borderColor", "Lcom/studiolaganne/lengendarylens/BorderColor;", "setSymbolSimilarity", "combinedScore", "<init>", "(Lcom/studiolaganne/lengendarylens/CardRecord;Ljava/lang/String;IDLjava/lang/String;JLjava/lang/String;ZLcom/studiolaganne/lengendarylens/BorderColor;DD)V", "getCardRecord", "()Lcom/studiolaganne/lengendarylens/CardRecord;", "getScryfallId", "()Ljava/lang/String;", "getFace", "()I", "getSimilarity", "()D", "getOracleId", "getSetSymbolHashFromImage", "()J", "getSetSymbolHashFromDB", "getHasPListStamp", "()Z", "getBorderColor", "()Lcom/studiolaganne/lengendarylens/BorderColor;", "getSetSymbolSimilarity", "setSetSymbolSimilarity", "(D)V", "getCombinedScore", "setCombinedScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EmbeddingMatch {
    public static final int $stable = 8;
    private final BorderColor borderColor;
    private final CardRecord cardRecord;
    private double combinedScore;
    private final int face;
    private final boolean hasPListStamp;
    private final String oracleId;
    private final String scryfallId;
    private final String setSymbolHashFromDB;
    private final long setSymbolHashFromImage;
    private double setSymbolSimilarity;
    private final double similarity;

    public EmbeddingMatch(CardRecord cardRecord, String scryfallId, int i, double d, String oracleId, long j, String setSymbolHashFromDB, boolean z, BorderColor borderColor, double d2, double d3) {
        Intrinsics.checkNotNullParameter(cardRecord, "cardRecord");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(setSymbolHashFromDB, "setSymbolHashFromDB");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        this.cardRecord = cardRecord;
        this.scryfallId = scryfallId;
        this.face = i;
        this.similarity = d;
        this.oracleId = oracleId;
        this.setSymbolHashFromImage = j;
        this.setSymbolHashFromDB = setSymbolHashFromDB;
        this.hasPListStamp = z;
        this.borderColor = borderColor;
        this.setSymbolSimilarity = d2;
        this.combinedScore = d3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ EmbeddingMatch(com.studiolaganne.lengendarylens.CardRecord r19, java.lang.String r20, int r21, double r22, java.lang.String r24, long r25, java.lang.String r27, boolean r28, com.studiolaganne.lengendarylens.BorderColor r29, double r30, double r32, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L9
            r1 = 0
            r12 = r1
            goto Lb
        L9:
            r12 = r28
        Lb:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L13
            com.studiolaganne.lengendarylens.BorderColor r1 = com.studiolaganne.lengendarylens.BorderColor.UNKNOWN
            r13 = r1
            goto L15
        L13:
            r13 = r29
        L15:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 0
            if (r1 == 0) goto L1d
            r14 = r2
            goto L1f
        L1d:
            r14 = r30
        L1f:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L36
            r16 = r2
            r4 = r20
            r5 = r21
            r6 = r22
            r8 = r24
            r9 = r25
            r11 = r27
            r2 = r18
            r3 = r19
            goto L48
        L36:
            r16 = r32
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r8 = r24
            r9 = r25
            r11 = r27
        L48:
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r12, r13, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.EmbeddingMatch.<init>(com.studiolaganne.lengendarylens.CardRecord, java.lang.String, int, double, java.lang.String, long, java.lang.String, boolean, com.studiolaganne.lengendarylens.BorderColor, double, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ EmbeddingMatch copy$default(EmbeddingMatch embeddingMatch, CardRecord cardRecord, String str, int i, double d, String str2, long j, String str3, boolean z, BorderColor borderColor, double d2, double d3, int i2, Object obj) {
        double d4;
        CardRecord cardRecord2;
        EmbeddingMatch embeddingMatch2;
        String str4;
        int i3;
        double d5;
        String str5;
        long j2;
        String str6;
        boolean z2;
        BorderColor borderColor2;
        double d6;
        CardRecord cardRecord3 = (i2 & 1) != 0 ? embeddingMatch.cardRecord : cardRecord;
        String str7 = (i2 & 2) != 0 ? embeddingMatch.scryfallId : str;
        int i4 = (i2 & 4) != 0 ? embeddingMatch.face : i;
        double d7 = (i2 & 8) != 0 ? embeddingMatch.similarity : d;
        String str8 = (i2 & 16) != 0 ? embeddingMatch.oracleId : str2;
        long j3 = (i2 & 32) != 0 ? embeddingMatch.setSymbolHashFromImage : j;
        String str9 = (i2 & 64) != 0 ? embeddingMatch.setSymbolHashFromDB : str3;
        boolean z3 = (i2 & 128) != 0 ? embeddingMatch.hasPListStamp : z;
        BorderColor borderColor3 = (i2 & 256) != 0 ? embeddingMatch.borderColor : borderColor;
        double d8 = (i2 & 512) != 0 ? embeddingMatch.setSymbolSimilarity : d2;
        if ((i2 & 1024) != 0) {
            cardRecord2 = cardRecord3;
            d4 = embeddingMatch.combinedScore;
            str4 = str7;
            i3 = i4;
            d5 = d7;
            str5 = str8;
            j2 = j3;
            str6 = str9;
            z2 = z3;
            borderColor2 = borderColor3;
            d6 = d8;
            embeddingMatch2 = embeddingMatch;
        } else {
            d4 = d3;
            cardRecord2 = cardRecord3;
            embeddingMatch2 = embeddingMatch;
            str4 = str7;
            i3 = i4;
            d5 = d7;
            str5 = str8;
            j2 = j3;
            str6 = str9;
            z2 = z3;
            borderColor2 = borderColor3;
            d6 = d8;
        }
        return embeddingMatch2.copy(cardRecord2, str4, i3, d5, str5, j2, str6, z2, borderColor2, d6, d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CardRecord getCardRecord() {
        return this.cardRecord;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final double getSetSymbolSimilarity() {
        return this.setSymbolSimilarity;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final double getCombinedScore() {
        return this.combinedScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getSimilarity() {
        return this.similarity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSetSymbolHashFromImage() {
        return this.setSymbolHashFromImage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSetSymbolHashFromDB() {
        return this.setSymbolHashFromDB;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHasPListStamp() {
        return this.hasPListStamp;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final BorderColor getBorderColor() {
        return this.borderColor;
    }

    public final EmbeddingMatch copy(CardRecord cardRecord, String scryfallId, int face, double similarity, String oracleId, long setSymbolHashFromImage, String setSymbolHashFromDB, boolean hasPListStamp, BorderColor borderColor, double setSymbolSimilarity, double combinedScore) {
        Intrinsics.checkNotNullParameter(cardRecord, "cardRecord");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(setSymbolHashFromDB, "setSymbolHashFromDB");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        return new EmbeddingMatch(cardRecord, scryfallId, face, similarity, oracleId, setSymbolHashFromImage, setSymbolHashFromDB, hasPListStamp, borderColor, setSymbolSimilarity, combinedScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddingMatch)) {
            return false;
        }
        EmbeddingMatch embeddingMatch = (EmbeddingMatch) other;
        return Intrinsics.areEqual(this.cardRecord, embeddingMatch.cardRecord) && Intrinsics.areEqual(this.scryfallId, embeddingMatch.scryfallId) && this.face == embeddingMatch.face && Double.compare(this.similarity, embeddingMatch.similarity) == 0 && Intrinsics.areEqual(this.oracleId, embeddingMatch.oracleId) && this.setSymbolHashFromImage == embeddingMatch.setSymbolHashFromImage && Intrinsics.areEqual(this.setSymbolHashFromDB, embeddingMatch.setSymbolHashFromDB) && this.hasPListStamp == embeddingMatch.hasPListStamp && this.borderColor == embeddingMatch.borderColor && Double.compare(this.setSymbolSimilarity, embeddingMatch.setSymbolSimilarity) == 0 && Double.compare(this.combinedScore, embeddingMatch.combinedScore) == 0;
    }

    public final BorderColor getBorderColor() {
        return this.borderColor;
    }

    public final CardRecord getCardRecord() {
        return this.cardRecord;
    }

    public final double getCombinedScore() {
        return this.combinedScore;
    }

    public final int getFace() {
        return this.face;
    }

    public final boolean getHasPListStamp() {
        return this.hasPListStamp;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final String getSetSymbolHashFromDB() {
        return this.setSymbolHashFromDB;
    }

    public final long getSetSymbolHashFromImage() {
        return this.setSymbolHashFromImage;
    }

    public final double getSetSymbolSimilarity() {
        return this.setSymbolSimilarity;
    }

    public final double getSimilarity() {
        return this.similarity;
    }

    public int hashCode() {
        return (((((((((((((((((((this.cardRecord.hashCode() * 31) + this.scryfallId.hashCode()) * 31) + Integer.hashCode(this.face)) * 31) + Double.hashCode(this.similarity)) * 31) + this.oracleId.hashCode()) * 31) + Long.hashCode(this.setSymbolHashFromImage)) * 31) + this.setSymbolHashFromDB.hashCode()) * 31) + Boolean.hashCode(this.hasPListStamp)) * 31) + this.borderColor.hashCode()) * 31) + Double.hashCode(this.setSymbolSimilarity)) * 31) + Double.hashCode(this.combinedScore);
    }

    public final void setCombinedScore(double d) {
        this.combinedScore = d;
    }

    public final void setSetSymbolSimilarity(double d) {
        this.setSymbolSimilarity = d;
    }

    public String toString() {
        return "EmbeddingMatch(cardRecord=" + this.cardRecord + ", scryfallId=" + this.scryfallId + ", face=" + this.face + ", similarity=" + this.similarity + ", oracleId=" + this.oracleId + ", setSymbolHashFromImage=" + this.setSymbolHashFromImage + ", setSymbolHashFromDB=" + this.setSymbolHashFromDB + ", hasPListStamp=" + this.hasPListStamp + ", borderColor=" + this.borderColor + ", setSymbolSimilarity=" + this.setSymbolSimilarity + ", combinedScore=" + this.combinedScore + ")";
    }
}
