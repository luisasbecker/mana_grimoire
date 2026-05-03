package io.customer.tracking.migration.request;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: MigrationTask.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0006\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask;", "", DiagnosticsEntry.TIMESTAMP_KEY, "", "getTimestamp", "()J", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "IdentifyProfile", "TrackEvent", "TrackPushMetric", "TrackDeliveryEvent", "RegisterDeviceToken", "DeletePushToken", "Lio/customer/tracking/migration/request/MigrationTask$DeletePushToken;", "Lio/customer/tracking/migration/request/MigrationTask$IdentifyProfile;", "Lio/customer/tracking/migration/request/MigrationTask$RegisterDeviceToken;", "Lio/customer/tracking/migration/request/MigrationTask$TrackDeliveryEvent;", "Lio/customer/tracking/migration/request/MigrationTask$TrackEvent;", "Lio/customer/tracking/migration/request/MigrationTask$TrackPushMetric;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MigrationTask {

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$DeletePushToken;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", "token", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DeletePushToken implements MigrationTask {
        private final String identifier;
        private final long timestamp;
        private final String token;

        public DeletePushToken(long j, String identifier, String token) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(token, "token");
            this.timestamp = j;
            this.identifier = identifier;
            this.token = token;
        }

        public static /* synthetic */ DeletePushToken copy$default(DeletePushToken deletePushToken, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = deletePushToken.timestamp;
            }
            if ((i & 2) != 0) {
                str = deletePushToken.identifier;
            }
            if ((i & 4) != 0) {
                str2 = deletePushToken.token;
            }
            return deletePushToken.copy(j, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final DeletePushToken copy(long timestamp, String identifier, String token) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(token, "token");
            return new DeletePushToken(timestamp, identifier, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeletePushToken)) {
                return false;
            }
            DeletePushToken deletePushToken = (DeletePushToken) other;
            return this.timestamp == deletePushToken.timestamp && Intrinsics.areEqual(this.identifier, deletePushToken.identifier) && Intrinsics.areEqual(this.token, deletePushToken.token);
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return (((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.token.hashCode();
        }

        public String toString() {
            return "DeletePushToken(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", token=" + this.token + ")";
        }
    }

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$IdentifyProfile;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", "attributes", "Lorg/json/JSONObject;", "<init>", "(JLjava/lang/String;Lorg/json/JSONObject;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getAttributes", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class IdentifyProfile implements MigrationTask {
        private final JSONObject attributes;
        private final String identifier;
        private final long timestamp;

        public IdentifyProfile(long j, String identifier, JSONObject attributes) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.timestamp = j;
            this.identifier = identifier;
            this.attributes = attributes;
        }

        public static /* synthetic */ IdentifyProfile copy$default(IdentifyProfile identifyProfile, long j, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                j = identifyProfile.timestamp;
            }
            if ((i & 2) != 0) {
                str = identifyProfile.identifier;
            }
            if ((i & 4) != 0) {
                jSONObject = identifyProfile.attributes;
            }
            return identifyProfile.copy(j, str, jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JSONObject getAttributes() {
            return this.attributes;
        }

        public final IdentifyProfile copy(long timestamp, String identifier, JSONObject attributes) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new IdentifyProfile(timestamp, identifier, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdentifyProfile)) {
                return false;
            }
            IdentifyProfile identifyProfile = (IdentifyProfile) other;
            return this.timestamp == identifyProfile.timestamp && Intrinsics.areEqual(this.identifier, identifyProfile.identifier) && Intrinsics.areEqual(this.attributes, identifyProfile.attributes);
        }

        public final JSONObject getAttributes() {
            return this.attributes;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.attributes.hashCode();
        }

        public String toString() {
            return "IdentifyProfile(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", attributes=" + this.attributes + ")";
        }
    }

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$RegisterDeviceToken;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", "token", "platform", "lastUsed", "attributes", "Lorg/json/JSONObject;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLorg/json/JSONObject;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getToken", "getPlatform", "getLastUsed", "getAttributes", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class RegisterDeviceToken implements MigrationTask {
        private final JSONObject attributes;
        private final String identifier;
        private final long lastUsed;
        private final String platform;
        private final long timestamp;
        private final String token;

        public RegisterDeviceToken(long j, String identifier, String token, String platform, long j2, JSONObject attributes) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(platform, "platform");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.timestamp = j;
            this.identifier = identifier;
            this.token = token;
            this.platform = platform;
            this.lastUsed = j2;
            this.attributes = attributes;
        }

        public static /* synthetic */ RegisterDeviceToken copy$default(RegisterDeviceToken registerDeviceToken, long j, String str, String str2, String str3, long j2, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                j = registerDeviceToken.timestamp;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = registerDeviceToken.identifier;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = registerDeviceToken.token;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = registerDeviceToken.platform;
            }
            return registerDeviceToken.copy(j3, str4, str5, str3, (i & 16) != 0 ? registerDeviceToken.lastUsed : j2, (i & 32) != 0 ? registerDeviceToken.attributes : jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPlatform() {
            return this.platform;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getLastUsed() {
            return this.lastUsed;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final JSONObject getAttributes() {
            return this.attributes;
        }

        public final RegisterDeviceToken copy(long timestamp, String identifier, String token, String platform, long lastUsed, JSONObject attributes) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(platform, "platform");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new RegisterDeviceToken(timestamp, identifier, token, platform, lastUsed, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegisterDeviceToken)) {
                return false;
            }
            RegisterDeviceToken registerDeviceToken = (RegisterDeviceToken) other;
            return this.timestamp == registerDeviceToken.timestamp && Intrinsics.areEqual(this.identifier, registerDeviceToken.identifier) && Intrinsics.areEqual(this.token, registerDeviceToken.token) && Intrinsics.areEqual(this.platform, registerDeviceToken.platform) && this.lastUsed == registerDeviceToken.lastUsed && Intrinsics.areEqual(this.attributes, registerDeviceToken.attributes);
        }

        public final JSONObject getAttributes() {
            return this.attributes;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        public final long getLastUsed() {
            return this.lastUsed;
        }

        public final String getPlatform() {
            return this.platform;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.token.hashCode()) * 31) + this.platform.hashCode()) * 31) + Long.hashCode(this.lastUsed)) * 31) + this.attributes.hashCode();
        }

        public String toString() {
            return "RegisterDeviceToken(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", token=" + this.token + ", platform=" + this.platform + ", lastUsed=" + this.lastUsed + ", attributes=" + this.attributes + ")";
        }
    }

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$TrackDeliveryEvent;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", "deliveryType", "deliveryId", NotificationCompat.CATEGORY_EVENT, "metadata", "Lorg/json/JSONObject;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getDeliveryType", "getDeliveryId", "getEvent", "getMetadata", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TrackDeliveryEvent implements MigrationTask {
        private final String deliveryId;
        private final String deliveryType;
        private final String event;
        private final String identifier;
        private final JSONObject metadata;
        private final long timestamp;

        public TrackDeliveryEvent(long j, String identifier, String deliveryType, String deliveryId, String event, JSONObject metadata) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.timestamp = j;
            this.identifier = identifier;
            this.deliveryType = deliveryType;
            this.deliveryId = deliveryId;
            this.event = event;
            this.metadata = metadata;
        }

        public static /* synthetic */ TrackDeliveryEvent copy$default(TrackDeliveryEvent trackDeliveryEvent, long j, String str, String str2, String str3, String str4, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                j = trackDeliveryEvent.timestamp;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = trackDeliveryEvent.identifier;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = trackDeliveryEvent.deliveryType;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = trackDeliveryEvent.deliveryId;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = trackDeliveryEvent.event;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                jSONObject = trackDeliveryEvent.metadata;
            }
            return trackDeliveryEvent.copy(j2, str5, str6, str7, str8, jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDeliveryType() {
            return this.deliveryType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDeliveryId() {
            return this.deliveryId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final JSONObject getMetadata() {
            return this.metadata;
        }

        public final TrackDeliveryEvent copy(long timestamp, String identifier, String deliveryType, String deliveryId, String event, JSONObject metadata) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new TrackDeliveryEvent(timestamp, identifier, deliveryType, deliveryId, event, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackDeliveryEvent)) {
                return false;
            }
            TrackDeliveryEvent trackDeliveryEvent = (TrackDeliveryEvent) other;
            return this.timestamp == trackDeliveryEvent.timestamp && Intrinsics.areEqual(this.identifier, trackDeliveryEvent.identifier) && Intrinsics.areEqual(this.deliveryType, trackDeliveryEvent.deliveryType) && Intrinsics.areEqual(this.deliveryId, trackDeliveryEvent.deliveryId) && Intrinsics.areEqual(this.event, trackDeliveryEvent.event) && Intrinsics.areEqual(this.metadata, trackDeliveryEvent.metadata);
        }

        public final String getDeliveryId() {
            return this.deliveryId;
        }

        public final String getDeliveryType() {
            return this.deliveryType;
        }

        public final String getEvent() {
            return this.event;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        public final JSONObject getMetadata() {
            return this.metadata;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.deliveryType.hashCode()) * 31) + this.deliveryId.hashCode()) * 31) + this.event.hashCode()) * 31) + this.metadata.hashCode();
        }

        public String toString() {
            return "TrackDeliveryEvent(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", deliveryType=" + this.deliveryType + ", deliveryId=" + this.deliveryId + ", event=" + this.event + ", metadata=" + this.metadata + ")";
        }
    }

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$TrackEvent;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", NotificationCompat.CATEGORY_EVENT, "type", DiagnosticsEntry.PROPERTIES_KEY, "Lorg/json/JSONObject;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getEvent", "getType", "getProperties", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TrackEvent implements MigrationTask {
        private final String event;
        private final String identifier;
        private final JSONObject properties;
        private final long timestamp;
        private final String type;

        public TrackEvent(long j, String identifier, String event, String type, JSONObject properties) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.timestamp = j;
            this.identifier = identifier;
            this.event = event;
            this.type = type;
            this.properties = properties;
        }

        public static /* synthetic */ TrackEvent copy$default(TrackEvent trackEvent, long j, String str, String str2, String str3, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                j = trackEvent.timestamp;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = trackEvent.identifier;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = trackEvent.event;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = trackEvent.type;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                jSONObject = trackEvent.properties;
            }
            return trackEvent.copy(j2, str4, str5, str6, jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final JSONObject getProperties() {
            return this.properties;
        }

        public final TrackEvent copy(long timestamp, String identifier, String event, String type, JSONObject properties) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            return new TrackEvent(timestamp, identifier, event, type, properties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackEvent)) {
                return false;
            }
            TrackEvent trackEvent = (TrackEvent) other;
            return this.timestamp == trackEvent.timestamp && Intrinsics.areEqual(this.identifier, trackEvent.identifier) && Intrinsics.areEqual(this.event, trackEvent.event) && Intrinsics.areEqual(this.type, trackEvent.type) && Intrinsics.areEqual(this.properties, trackEvent.properties);
        }

        public final String getEvent() {
            return this.event;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        public final JSONObject getProperties() {
            return this.properties;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.event.hashCode()) * 31) + this.type.hashCode()) * 31) + this.properties.hashCode();
        }

        public String toString() {
            return "TrackEvent(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", event=" + this.event + ", type=" + this.type + ", properties=" + this.properties + ")";
        }
    }

    /* JADX INFO: compiled from: MigrationTask.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lio/customer/tracking/migration/request/MigrationTask$TrackPushMetric;", "Lio/customer/tracking/migration/request/MigrationTask;", DiagnosticsEntry.TIMESTAMP_KEY, "", "identifier", "", "deliveryId", "deviceToken", NotificationCompat.CATEGORY_EVENT, "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTimestamp", "()J", "getIdentifier", "()Ljava/lang/String;", "getDeliveryId", "getDeviceToken", "getEvent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TrackPushMetric implements MigrationTask {
        private final String deliveryId;
        private final String deviceToken;
        private final String event;
        private final String identifier;
        private final long timestamp;

        public TrackPushMetric(long j, String identifier, String deliveryId, String deviceToken, String event) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            Intrinsics.checkNotNullParameter(event, "event");
            this.timestamp = j;
            this.identifier = identifier;
            this.deliveryId = deliveryId;
            this.deviceToken = deviceToken;
            this.event = event;
        }

        public static /* synthetic */ TrackPushMetric copy$default(TrackPushMetric trackPushMetric, long j, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                j = trackPushMetric.timestamp;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = trackPushMetric.identifier;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = trackPushMetric.deliveryId;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = trackPushMetric.deviceToken;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = trackPushMetric.event;
            }
            return trackPushMetric.copy(j2, str5, str6, str7, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDeliveryId() {
            return this.deliveryId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDeviceToken() {
            return this.deviceToken;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        public final TrackPushMetric copy(long timestamp, String identifier, String deliveryId, String deviceToken, String event) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            Intrinsics.checkNotNullParameter(event, "event");
            return new TrackPushMetric(timestamp, identifier, deliveryId, deviceToken, event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackPushMetric)) {
                return false;
            }
            TrackPushMetric trackPushMetric = (TrackPushMetric) other;
            return this.timestamp == trackPushMetric.timestamp && Intrinsics.areEqual(this.identifier, trackPushMetric.identifier) && Intrinsics.areEqual(this.deliveryId, trackPushMetric.deliveryId) && Intrinsics.areEqual(this.deviceToken, trackPushMetric.deviceToken) && Intrinsics.areEqual(this.event, trackPushMetric.event);
        }

        public final String getDeliveryId() {
            return this.deliveryId;
        }

        public final String getDeviceToken() {
            return this.deviceToken;
        }

        public final String getEvent() {
            return this.event;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // io.customer.tracking.migration.request.MigrationTask
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.timestamp) * 31) + this.identifier.hashCode()) * 31) + this.deliveryId.hashCode()) * 31) + this.deviceToken.hashCode()) * 31) + this.event.hashCode();
        }

        public String toString() {
            return "TrackPushMetric(timestamp=" + this.timestamp + ", identifier=" + this.identifier + ", deliveryId=" + this.deliveryId + ", deviceToken=" + this.deviceToken + ", event=" + this.event + ")";
        }
    }

    String getIdentifier();

    long getTimestamp();
}
