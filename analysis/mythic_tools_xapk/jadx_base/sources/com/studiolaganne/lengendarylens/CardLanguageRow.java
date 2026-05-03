package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardLanguageRow;", "", "lang", "", Constants.GP_IAP_TITLE, "scryfallId", "oracleId", "typeLine", "oracleText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getTitle", "getScryfallId", "getOracleId", "getTypeLine", "getOracleText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardLanguageRow {
    public static final int $stable = 0;
    private final String lang;
    private final String oracleId;
    private final String oracleText;
    private final String scryfallId;
    private final String title;
    private final String typeLine;

    public CardLanguageRow() {
        this(null, null, null, null, null, null, 63, null);
    }

    public CardLanguageRow(String lang, String title, String scryfallId, String oracleId, String typeLine, String oracleText) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(typeLine, "typeLine");
        Intrinsics.checkNotNullParameter(oracleText, "oracleText");
        this.lang = lang;
        this.title = title;
        this.scryfallId = scryfallId;
        this.oracleId = oracleId;
        this.typeLine = typeLine;
        this.oracleText = oracleText;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ CardLanguageRow(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = "en"
        L6:
            r9 = r8 & 2
            java.lang.String r0 = ""
            if (r9 == 0) goto Ld
            r3 = r0
        Ld:
            r9 = r8 & 4
            if (r9 == 0) goto L12
            r4 = r0
        L12:
            r9 = r8 & 8
            if (r9 == 0) goto L17
            r5 = r0
        L17:
            r9 = r8 & 16
            if (r9 == 0) goto L1c
            r6 = r0
        L1c:
            r8 = r8 & 32
            if (r8 == 0) goto L28
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2f
        L28:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2f:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.CardLanguageRow.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ CardLanguageRow copy$default(CardLanguageRow cardLanguageRow, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardLanguageRow.lang;
        }
        if ((i & 2) != 0) {
            str2 = cardLanguageRow.title;
        }
        if ((i & 4) != 0) {
            str3 = cardLanguageRow.scryfallId;
        }
        if ((i & 8) != 0) {
            str4 = cardLanguageRow.oracleId;
        }
        if ((i & 16) != 0) {
            str5 = cardLanguageRow.typeLine;
        }
        if ((i & 32) != 0) {
            str6 = cardLanguageRow.oracleText;
        }
        String str7 = str5;
        String str8 = str6;
        return cardLanguageRow.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTypeLine() {
        return this.typeLine;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOracleText() {
        return this.oracleText;
    }

    public final CardLanguageRow copy(String lang, String title, String scryfallId, String oracleId, String typeLine, String oracleText) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(typeLine, "typeLine");
        Intrinsics.checkNotNullParameter(oracleText, "oracleText");
        return new CardLanguageRow(lang, title, scryfallId, oracleId, typeLine, oracleText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardLanguageRow)) {
            return false;
        }
        CardLanguageRow cardLanguageRow = (CardLanguageRow) other;
        return Intrinsics.areEqual(this.lang, cardLanguageRow.lang) && Intrinsics.areEqual(this.title, cardLanguageRow.title) && Intrinsics.areEqual(this.scryfallId, cardLanguageRow.scryfallId) && Intrinsics.areEqual(this.oracleId, cardLanguageRow.oracleId) && Intrinsics.areEqual(this.typeLine, cardLanguageRow.typeLine) && Intrinsics.areEqual(this.oracleText, cardLanguageRow.oracleText);
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final String getOracleText() {
        return this.oracleText;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTypeLine() {
        return this.typeLine;
    }

    public int hashCode() {
        return (((((((((this.lang.hashCode() * 31) + this.title.hashCode()) * 31) + this.scryfallId.hashCode()) * 31) + this.oracleId.hashCode()) * 31) + this.typeLine.hashCode()) * 31) + this.oracleText.hashCode();
    }

    public String toString() {
        return "CardLanguageRow(lang=" + this.lang + ", title=" + this.title + ", scryfallId=" + this.scryfallId + ", oracleId=" + this.oracleId + ", typeLine=" + this.typeLine + ", oracleText=" + this.oracleText + ")";
    }
}
