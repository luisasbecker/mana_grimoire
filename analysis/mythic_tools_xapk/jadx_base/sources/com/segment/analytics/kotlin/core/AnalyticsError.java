package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0013\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError;", "", "()V", "BatchUploadFail", "EnrichmentError", "JsonUnableToDeserialize", "JsonUnableToSerialize", "JsonUnknown", "NetworkInvalidData", "NetworkServerLimited", "NetworkServerRejected", "NetworkUnexpectedHTTPCode", "NetworkUnknown", "PluginError", "SettingsFail", "StorageInvalid", "StorageUnableToClose", "StorageUnableToCreate", "StorageUnableToOpen", "StorageUnableToRename", "StorageUnableToWrite", "StorageUnknown", "Lcom/segment/analytics/kotlin/core/AnalyticsError$BatchUploadFail;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$EnrichmentError;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnableToDeserialize;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnableToSerialize;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnknown;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkInvalidData;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkServerLimited;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkServerRejected;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkUnexpectedHTTPCode;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkUnknown;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$PluginError;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$SettingsFail;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageInvalid;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToClose;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToCreate;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToOpen;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToRename;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToWrite;", "Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnknown;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AnalyticsError extends Throwable {

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$BatchUploadFail;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "(Lcom/segment/analytics/kotlin/core/AnalyticsError;)V", "getCause", "()Lcom/segment/analytics/kotlin/core/AnalyticsError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class BatchUploadFail extends AnalyticsError {
        private final AnalyticsError cause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BatchUploadFail(AnalyticsError cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public static /* synthetic */ BatchUploadFail copy$default(BatchUploadFail batchUploadFail, AnalyticsError analyticsError, int i, Object obj) {
            if ((i & 1) != 0) {
                analyticsError = batchUploadFail.getCause();
            }
            return batchUploadFail.copy(analyticsError);
        }

        public final AnalyticsError component1() {
            return getCause();
        }

        public final BatchUploadFail copy(AnalyticsError cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new BatchUploadFail(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BatchUploadFail) && Intrinsics.areEqual(getCause(), ((BatchUploadFail) other).getCause());
        }

        @Override // java.lang.Throwable
        public AnalyticsError getCause() {
            return this.cause;
        }

        public int hashCode() {
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "BatchUploadFail(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$EnrichmentError;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class EnrichmentError extends AnalyticsError {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnrichmentError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ EnrichmentError copy$default(EnrichmentError enrichmentError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enrichmentError.getMessage();
            }
            return enrichmentError.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final EnrichmentError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new EnrichmentError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EnrichmentError) && Intrinsics.areEqual(getMessage(), ((EnrichmentError) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "EnrichmentError(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnableToDeserialize;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class JsonUnableToDeserialize extends AnalyticsError {
        private final Throwable cause;

        public JsonUnableToDeserialize(Throwable th) {
            super(null);
            this.cause = th;
        }

        public static /* synthetic */ JsonUnableToDeserialize copy$default(JsonUnableToDeserialize jsonUnableToDeserialize, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = jsonUnableToDeserialize.getCause();
            }
            return jsonUnableToDeserialize.copy(th);
        }

        public final Throwable component1() {
            return getCause();
        }

        public final JsonUnableToDeserialize copy(Throwable cause) {
            return new JsonUnableToDeserialize(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JsonUnableToDeserialize) && Intrinsics.areEqual(getCause(), ((JsonUnableToDeserialize) other).getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            if (getCause() == null) {
                return 0;
            }
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "JsonUnableToDeserialize(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnableToSerialize;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class JsonUnableToSerialize extends AnalyticsError {
        private final Throwable cause;

        public JsonUnableToSerialize(Throwable th) {
            super(null);
            this.cause = th;
        }

        public static /* synthetic */ JsonUnableToSerialize copy$default(JsonUnableToSerialize jsonUnableToSerialize, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = jsonUnableToSerialize.getCause();
            }
            return jsonUnableToSerialize.copy(th);
        }

        public final Throwable component1() {
            return getCause();
        }

        public final JsonUnableToSerialize copy(Throwable cause) {
            return new JsonUnableToSerialize(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JsonUnableToSerialize) && Intrinsics.areEqual(getCause(), ((JsonUnableToSerialize) other).getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            if (getCause() == null) {
                return 0;
            }
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "JsonUnableToSerialize(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$JsonUnknown;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class JsonUnknown extends AnalyticsError {
        private final Throwable cause;

        public JsonUnknown(Throwable th) {
            super(null);
            this.cause = th;
        }

        public static /* synthetic */ JsonUnknown copy$default(JsonUnknown jsonUnknown, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = jsonUnknown.getCause();
            }
            return jsonUnknown.copy(th);
        }

        public final Throwable component1() {
            return getCause();
        }

        public final JsonUnknown copy(Throwable cause) {
            return new JsonUnknown(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JsonUnknown) && Intrinsics.areEqual(getCause(), ((JsonUnknown) other).getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            if (getCause() == null) {
                return 0;
            }
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "JsonUnknown(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkInvalidData;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NetworkInvalidData extends AnalyticsError {
        private final String message;

        public NetworkInvalidData(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ NetworkInvalidData copy$default(NetworkInvalidData networkInvalidData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = networkInvalidData.getMessage();
            }
            return networkInvalidData.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final NetworkInvalidData copy(String message) {
            return new NetworkInvalidData(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NetworkInvalidData) && Intrinsics.areEqual(getMessage(), ((NetworkInvalidData) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkInvalidData(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkServerLimited;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "uri", "Ljava/net/URL;", "code", "", "(Ljava/net/URL;I)V", "getCode", "()I", "getUri", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NetworkServerLimited extends AnalyticsError {
        private final int code;
        private final URL uri;

        public NetworkServerLimited(URL url, int i) {
            super(null);
            this.uri = url;
            this.code = i;
        }

        public static /* synthetic */ NetworkServerLimited copy$default(NetworkServerLimited networkServerLimited, URL url, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                url = networkServerLimited.uri;
            }
            if ((i2 & 2) != 0) {
                i = networkServerLimited.code;
            }
            return networkServerLimited.copy(url, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final URL getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final NetworkServerLimited copy(URL uri, int code) {
            return new NetworkServerLimited(uri, code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkServerLimited)) {
                return false;
            }
            NetworkServerLimited networkServerLimited = (NetworkServerLimited) other;
            return Intrinsics.areEqual(this.uri, networkServerLimited.uri) && this.code == networkServerLimited.code;
        }

        public final int getCode() {
            return this.code;
        }

        public final URL getUri() {
            return this.uri;
        }

        public int hashCode() {
            URL url = this.uri;
            return ((url == null ? 0 : url.hashCode()) * 31) + Integer.hashCode(this.code);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkServerLimited(uri=" + this.uri + ", code=" + this.code + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkServerRejected;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "uri", "Ljava/net/URL;", "code", "", "(Ljava/net/URL;I)V", "getCode", "()I", "getUri", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NetworkServerRejected extends AnalyticsError {
        private final int code;
        private final URL uri;

        public NetworkServerRejected(URL url, int i) {
            super(null);
            this.uri = url;
            this.code = i;
        }

        public static /* synthetic */ NetworkServerRejected copy$default(NetworkServerRejected networkServerRejected, URL url, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                url = networkServerRejected.uri;
            }
            if ((i2 & 2) != 0) {
                i = networkServerRejected.code;
            }
            return networkServerRejected.copy(url, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final URL getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final NetworkServerRejected copy(URL uri, int code) {
            return new NetworkServerRejected(uri, code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkServerRejected)) {
                return false;
            }
            NetworkServerRejected networkServerRejected = (NetworkServerRejected) other;
            return Intrinsics.areEqual(this.uri, networkServerRejected.uri) && this.code == networkServerRejected.code;
        }

        public final int getCode() {
            return this.code;
        }

        public final URL getUri() {
            return this.uri;
        }

        public int hashCode() {
            URL url = this.uri;
            return ((url == null ? 0 : url.hashCode()) * 31) + Integer.hashCode(this.code);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkServerRejected(uri=" + this.uri + ", code=" + this.code + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkUnexpectedHTTPCode;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "uri", "Ljava/net/URL;", "code", "", "(Ljava/net/URL;I)V", "getCode", "()I", "getUri", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NetworkUnexpectedHTTPCode extends AnalyticsError {
        private final int code;
        private final URL uri;

        public NetworkUnexpectedHTTPCode(URL url, int i) {
            super(null);
            this.uri = url;
            this.code = i;
        }

        public static /* synthetic */ NetworkUnexpectedHTTPCode copy$default(NetworkUnexpectedHTTPCode networkUnexpectedHTTPCode, URL url, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                url = networkUnexpectedHTTPCode.uri;
            }
            if ((i2 & 2) != 0) {
                i = networkUnexpectedHTTPCode.code;
            }
            return networkUnexpectedHTTPCode.copy(url, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final URL getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final NetworkUnexpectedHTTPCode copy(URL uri, int code) {
            return new NetworkUnexpectedHTTPCode(uri, code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkUnexpectedHTTPCode)) {
                return false;
            }
            NetworkUnexpectedHTTPCode networkUnexpectedHTTPCode = (NetworkUnexpectedHTTPCode) other;
            return Intrinsics.areEqual(this.uri, networkUnexpectedHTTPCode.uri) && this.code == networkUnexpectedHTTPCode.code;
        }

        public final int getCode() {
            return this.code;
        }

        public final URL getUri() {
            return this.uri;
        }

        public int hashCode() {
            URL url = this.uri;
            return ((url == null ? 0 : url.hashCode()) * 31) + Integer.hashCode(this.code);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkUnexpectedHTTPCode(uri=" + this.uri + ", code=" + this.code + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$NetworkUnknown;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "uri", "Ljava/net/URL;", "cause", "", "(Ljava/net/URL;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getUri", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NetworkUnknown extends AnalyticsError {
        private final Throwable cause;
        private final URL uri;

        public NetworkUnknown(URL url, Throwable th) {
            super(null);
            this.uri = url;
            this.cause = th;
        }

        public static /* synthetic */ NetworkUnknown copy$default(NetworkUnknown networkUnknown, URL url, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                url = networkUnknown.uri;
            }
            if ((i & 2) != 0) {
                th = networkUnknown.getCause();
            }
            return networkUnknown.copy(url, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final URL getUri() {
            return this.uri;
        }

        public final Throwable component2() {
            return getCause();
        }

        public final NetworkUnknown copy(URL uri, Throwable cause) {
            return new NetworkUnknown(uri, cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkUnknown)) {
                return false;
            }
            NetworkUnknown networkUnknown = (NetworkUnknown) other;
            return Intrinsics.areEqual(this.uri, networkUnknown.uri) && Intrinsics.areEqual(getCause(), networkUnknown.getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public final URL getUri() {
            return this.uri;
        }

        public int hashCode() {
            URL url = this.uri;
            return ((url == null ? 0 : url.hashCode()) * 31) + (getCause() != null ? getCause().hashCode() : 0);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkUnknown(uri=" + this.uri + ", cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$PluginError;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PluginError extends AnalyticsError {
        private final Throwable cause;

        public PluginError(Throwable th) {
            super(null);
            this.cause = th;
        }

        public static /* synthetic */ PluginError copy$default(PluginError pluginError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = pluginError.getCause();
            }
            return pluginError.copy(th);
        }

        public final Throwable component1() {
            return getCause();
        }

        public final PluginError copy(Throwable cause) {
            return new PluginError(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PluginError) && Intrinsics.areEqual(getCause(), ((PluginError) other).getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            if (getCause() == null) {
                return 0;
            }
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "PluginError(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$SettingsFail;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "(Lcom/segment/analytics/kotlin/core/AnalyticsError;)V", "getCause", "()Lcom/segment/analytics/kotlin/core/AnalyticsError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SettingsFail extends AnalyticsError {
        private final AnalyticsError cause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SettingsFail(AnalyticsError cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public static /* synthetic */ SettingsFail copy$default(SettingsFail settingsFail, AnalyticsError analyticsError, int i, Object obj) {
            if ((i & 1) != 0) {
                analyticsError = settingsFail.getCause();
            }
            return settingsFail.copy(analyticsError);
        }

        public final AnalyticsError component1() {
            return getCause();
        }

        public final SettingsFail copy(AnalyticsError cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new SettingsFail(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SettingsFail) && Intrinsics.areEqual(getCause(), ((SettingsFail) other).getCause());
        }

        @Override // java.lang.Throwable
        public AnalyticsError getCause() {
            return this.cause;
        }

        public int hashCode() {
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "SettingsFail(cause=" + getCause() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageInvalid;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageInvalid extends AnalyticsError {
        private final String message;

        public StorageInvalid(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageInvalid copy$default(StorageInvalid storageInvalid, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageInvalid.getMessage();
            }
            return storageInvalid.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageInvalid copy(String message) {
            return new StorageInvalid(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageInvalid) && Intrinsics.areEqual(getMessage(), ((StorageInvalid) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageInvalid(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToClose;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnableToClose extends AnalyticsError {
        private final String message;

        public StorageUnableToClose(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageUnableToClose copy$default(StorageUnableToClose storageUnableToClose, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageUnableToClose.getMessage();
            }
            return storageUnableToClose.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageUnableToClose copy(String message) {
            return new StorageUnableToClose(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnableToClose) && Intrinsics.areEqual(getMessage(), ((StorageUnableToClose) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnableToClose(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToCreate;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnableToCreate extends AnalyticsError {
        private final String message;

        public StorageUnableToCreate(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageUnableToCreate copy$default(StorageUnableToCreate storageUnableToCreate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageUnableToCreate.getMessage();
            }
            return storageUnableToCreate.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageUnableToCreate copy(String message) {
            return new StorageUnableToCreate(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnableToCreate) && Intrinsics.areEqual(getMessage(), ((StorageUnableToCreate) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnableToCreate(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToOpen;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnableToOpen extends AnalyticsError {
        private final String message;

        public StorageUnableToOpen(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageUnableToOpen copy$default(StorageUnableToOpen storageUnableToOpen, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageUnableToOpen.getMessage();
            }
            return storageUnableToOpen.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageUnableToOpen copy(String message) {
            return new StorageUnableToOpen(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnableToOpen) && Intrinsics.areEqual(getMessage(), ((StorageUnableToOpen) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnableToOpen(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToRename;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnableToRename extends AnalyticsError {
        private final String message;

        public StorageUnableToRename(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageUnableToRename copy$default(StorageUnableToRename storageUnableToRename, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageUnableToRename.getMessage();
            }
            return storageUnableToRename.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageUnableToRename copy(String message) {
            return new StorageUnableToRename(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnableToRename) && Intrinsics.areEqual(getMessage(), ((StorageUnableToRename) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnableToRename(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnableToWrite;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnableToWrite extends AnalyticsError {
        private final String message;

        public StorageUnableToWrite(String str) {
            super(null);
            this.message = str;
        }

        public static /* synthetic */ StorageUnableToWrite copy$default(StorageUnableToWrite storageUnableToWrite, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageUnableToWrite.getMessage();
            }
            return storageUnableToWrite.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final StorageUnableToWrite copy(String message) {
            return new StorageUnableToWrite(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnableToWrite) && Intrinsics.areEqual(getMessage(), ((StorageUnableToWrite) other).getMessage());
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnableToWrite(message=" + getMessage() + ')';
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/AnalyticsError$StorageUnknown;", "Lcom/segment/analytics/kotlin/core/AnalyticsError;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StorageUnknown extends AnalyticsError {
        private final Throwable cause;

        public StorageUnknown(Throwable th) {
            super(null);
            this.cause = th;
        }

        public static /* synthetic */ StorageUnknown copy$default(StorageUnknown storageUnknown, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = storageUnknown.getCause();
            }
            return storageUnknown.copy(th);
        }

        public final Throwable component1() {
            return getCause();
        }

        public final StorageUnknown copy(Throwable cause) {
            return new StorageUnknown(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StorageUnknown) && Intrinsics.areEqual(getCause(), ((StorageUnknown) other).getCause());
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            if (getCause() == null) {
                return 0;
            }
            return getCause().hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "StorageUnknown(cause=" + getCause() + ')';
        }
    }

    private AnalyticsError() {
    }

    public /* synthetic */ AnalyticsError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
