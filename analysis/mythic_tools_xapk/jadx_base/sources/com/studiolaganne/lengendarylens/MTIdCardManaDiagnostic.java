package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaDiagnostic;", "", "type", "", "severity", SubscriberAttributeKt.JSON_NAME_KEY, "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getSeverity", "getKey", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaDiagnostic {
    public static final int $stable = 0;
    private final String key;
    private final String message;
    private final String severity;
    private final String type;

    public MTIdCardManaDiagnostic() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardManaDiagnostic(String str, String str2, String str3, String str4) {
        this.type = str;
        this.severity = str2;
        this.key = str3;
        this.message = str4;
    }

    public /* synthetic */ MTIdCardManaDiagnostic(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public static /* synthetic */ MTIdCardManaDiagnostic copy$default(MTIdCardManaDiagnostic mTIdCardManaDiagnostic, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardManaDiagnostic.type;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardManaDiagnostic.severity;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardManaDiagnostic.key;
        }
        if ((i & 8) != 0) {
            str4 = mTIdCardManaDiagnostic.message;
        }
        return mTIdCardManaDiagnostic.copy(str, str2, str3, str4);
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
    public final String getMessage() {
        return this.message;
    }

    public final MTIdCardManaDiagnostic copy(String type, String severity, String key, String message) {
        return new MTIdCardManaDiagnostic(type, severity, key, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaDiagnostic)) {
            return false;
        }
        MTIdCardManaDiagnostic mTIdCardManaDiagnostic = (MTIdCardManaDiagnostic) other;
        return Intrinsics.areEqual(this.type, mTIdCardManaDiagnostic.type) && Intrinsics.areEqual(this.severity, mTIdCardManaDiagnostic.severity) && Intrinsics.areEqual(this.key, mTIdCardManaDiagnostic.key) && Intrinsics.areEqual(this.message, mTIdCardManaDiagnostic.message);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMessage() {
        return this.message;
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
        String str4 = this.message;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardManaDiagnostic(type=" + this.type + ", severity=" + this.severity + ", key=" + this.key + ", message=" + this.message + ")";
    }
}
