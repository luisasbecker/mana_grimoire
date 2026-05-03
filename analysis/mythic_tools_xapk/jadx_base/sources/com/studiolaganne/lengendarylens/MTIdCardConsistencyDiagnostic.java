package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnostic;", "", "type", "", "severity", SubscriberAttributeKt.JSON_NAME_KEY, NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnosticParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnosticParams;)V", "getType", "()Ljava/lang/String;", "getSeverity", "getKey", "getParams", "()Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnosticParams;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardConsistencyDiagnostic {
    public static final int $stable = 0;
    private final String key;
    private final MTIdCardConsistencyDiagnosticParams params;
    private final String severity;
    private final String type;

    public MTIdCardConsistencyDiagnostic() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardConsistencyDiagnostic(String str, String str2, String str3, MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams) {
        this.type = str;
        this.severity = str2;
        this.key = str3;
        this.params = mTIdCardConsistencyDiagnosticParams;
    }

    public /* synthetic */ MTIdCardConsistencyDiagnostic(String str, String str2, String str3, MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : mTIdCardConsistencyDiagnosticParams);
    }

    public static /* synthetic */ MTIdCardConsistencyDiagnostic copy$default(MTIdCardConsistencyDiagnostic mTIdCardConsistencyDiagnostic, String str, String str2, String str3, MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardConsistencyDiagnostic.type;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardConsistencyDiagnostic.severity;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardConsistencyDiagnostic.key;
        }
        if ((i & 8) != 0) {
            mTIdCardConsistencyDiagnosticParams = mTIdCardConsistencyDiagnostic.params;
        }
        return mTIdCardConsistencyDiagnostic.copy(str, str2, str3, mTIdCardConsistencyDiagnosticParams);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSeverity() {
        return this.severity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTIdCardConsistencyDiagnosticParams getParams() {
        return this.params;
    }

    public final MTIdCardConsistencyDiagnostic copy(String type, String severity, String key, MTIdCardConsistencyDiagnosticParams params) {
        return new MTIdCardConsistencyDiagnostic(type, severity, key, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardConsistencyDiagnostic)) {
            return false;
        }
        MTIdCardConsistencyDiagnostic mTIdCardConsistencyDiagnostic = (MTIdCardConsistencyDiagnostic) other;
        return Intrinsics.areEqual(this.type, mTIdCardConsistencyDiagnostic.type) && Intrinsics.areEqual(this.severity, mTIdCardConsistencyDiagnostic.severity) && Intrinsics.areEqual(this.key, mTIdCardConsistencyDiagnostic.key) && Intrinsics.areEqual(this.params, mTIdCardConsistencyDiagnostic.params);
    }

    public final String getKey() {
        return this.key;
    }

    public final MTIdCardConsistencyDiagnosticParams getParams() {
        return this.params;
    }

    public final String getSeverity() {
        return this.severity;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.severity;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams = this.params;
        return iHashCode3 + (mTIdCardConsistencyDiagnosticParams != null ? mTIdCardConsistencyDiagnosticParams.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardConsistencyDiagnostic(type=" + this.type + ", severity=" + this.severity + ", key=" + this.key + ", params=" + this.params + ")";
    }
}
