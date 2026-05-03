package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTListError;", "", "type", "", "message", "values", "", "severity", "problematic_cards", "", "cards", "Lcom/studiolaganne/lengendarylens/MTCardError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getMessage", "getValues", "()Ljava/util/Map;", "getSeverity", "setSeverity", "(Ljava/lang/String;)V", "getProblematic_cards", "()Ljava/util/List;", "setProblematic_cards", "(Ljava/util/List;)V", "getCards", "setCards", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTListError {
    public static final int $stable = 8;
    private List<MTCardError> cards;
    private final String message;
    private List<String> problematic_cards;
    private String severity;
    private final String type;
    private final Map<String, Object> values;

    public MTListError() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTListError(String type, String str, Map<String, ? extends Object> map, String severity, List<String> list, List<MTCardError> list2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(severity, "severity");
        this.type = type;
        this.message = str;
        this.values = map;
        this.severity = severity;
        this.problematic_cards = list;
        this.cards = list2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTListError(java.lang.String r2, java.lang.String r3, java.util.Map r4, java.lang.String r5, java.util.List r6, java.util.List r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = r0
        L11:
            r9 = r8 & 8
            if (r9 == 0) goto L17
            java.lang.String r5 = "error"
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
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTListError.<init>(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTListError copy$default(MTListError mTListError, String str, String str2, Map map, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTListError.type;
        }
        if ((i & 2) != 0) {
            str2 = mTListError.message;
        }
        if ((i & 4) != 0) {
            map = mTListError.values;
        }
        if ((i & 8) != 0) {
            str3 = mTListError.severity;
        }
        if ((i & 16) != 0) {
            list = mTListError.problematic_cards;
        }
        if ((i & 32) != 0) {
            list2 = mTListError.cards;
        }
        List list3 = list;
        List list4 = list2;
        return mTListError.copy(str, str2, map, str3, list3, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> component3() {
        return this.values;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSeverity() {
        return this.severity;
    }

    public final List<String> component5() {
        return this.problematic_cards;
    }

    public final List<MTCardError> component6() {
        return this.cards;
    }

    public final MTListError copy(String type, String message, Map<String, ? extends Object> values, String severity, List<String> problematic_cards, List<MTCardError> cards) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(severity, "severity");
        return new MTListError(type, message, values, severity, problematic_cards, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTListError)) {
            return false;
        }
        MTListError mTListError = (MTListError) other;
        return Intrinsics.areEqual(this.type, mTListError.type) && Intrinsics.areEqual(this.message, mTListError.message) && Intrinsics.areEqual(this.values, mTListError.values) && Intrinsics.areEqual(this.severity, mTListError.severity) && Intrinsics.areEqual(this.problematic_cards, mTListError.problematic_cards) && Intrinsics.areEqual(this.cards, mTListError.cards);
    }

    public final List<MTCardError> getCards() {
        return this.cards;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getProblematic_cards() {
        return this.problematic_cards;
    }

    public final String getSeverity() {
        return this.severity;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<String, Object> getValues() {
        return this.values;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.values;
        int iHashCode3 = (((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + this.severity.hashCode()) * 31;
        List<String> list = this.problematic_cards;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<MTCardError> list2 = this.cards;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setCards(List<MTCardError> list) {
        this.cards = list;
    }

    public final void setProblematic_cards(List<String> list) {
        this.problematic_cards = list;
    }

    public final void setSeverity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.severity = str;
    }

    public String toString() {
        return "MTListError(type=" + this.type + ", message=" + this.message + ", values=" + this.values + ", severity=" + this.severity + ", problematic_cards=" + this.problematic_cards + ", cards=" + this.cards + ")";
    }
}
