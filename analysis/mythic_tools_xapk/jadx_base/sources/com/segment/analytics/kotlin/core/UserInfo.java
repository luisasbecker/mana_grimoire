package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.core.Storage;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import sovran.kotlin.Action;
import sovran.kotlin.State;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0006\u001d\u001e\u001f !\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006#"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo;", "Lsovran/kotlin/State;", "anonymousId", "", "userId", "traits", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "(Ljava/lang/String;)V", "getTraits", "()Lkotlinx/serialization/json/JsonObject;", "setTraits", "(Lkotlinx/serialization/json/JsonObject;)V", "getUserId", "setUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "ResetAction", "SetAnonymousIdAction", "SetTraitsAction", "SetUserIdAction", "SetUserIdAndTraitsAction", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserInfo implements State {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String anonymousId;
    private JsonObject traits;
    private String userId;

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$Companion;", "", "()V", "defaultState", "Lcom/segment/analytics/kotlin/core/UserInfo;", "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserInfo defaultState(Storage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            String str = storage.read(Storage.Constants.UserId);
            Json.Companion companion = Json.INSTANCE;
            String str2 = storage.read(Storage.Constants.Traits);
            if (str2 == null) {
                str2 = "{}";
            }
            companion.getSerializersModule();
            JsonObject jsonObject = (JsonObject) companion.decodeFromString(BuiltinSerializersKt.getNullable(JsonObject.INSTANCE.serializer()), str2);
            String string = storage.read(Storage.Constants.AnonymousId);
            if (string == null) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            }
            return new UserInfo(string, str, jsonObject);
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$ResetAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/UserInfo;", "anonymousId", "", "(Ljava/lang/String;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResetAction implements Action<UserInfo> {
        private String anonymousId;

        /* JADX WARN: Multi-variable type inference failed */
        public ResetAction() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ResetAction(String anonymousId) {
            Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
            this.anonymousId = anonymousId;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ResetAction(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            this(str);
        }

        public final String getAnonymousId() {
            return this.anonymousId;
        }

        @Override // sovran.kotlin.Action
        public UserInfo reduce(UserInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new UserInfo(this.anonymousId, null, null);
        }

        public final void setAnonymousId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.anonymousId = str;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$SetAnonymousIdAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/UserInfo;", "anonymousId", "", "(Ljava/lang/String;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SetAnonymousIdAction implements Action<UserInfo> {
        private String anonymousId;

        public SetAnonymousIdAction(String anonymousId) {
            Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
            this.anonymousId = anonymousId;
        }

        public final String getAnonymousId() {
            return this.anonymousId;
        }

        @Override // sovran.kotlin.Action
        public UserInfo reduce(UserInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new UserInfo(this.anonymousId, state.getUserId(), state.getTraits());
        }

        public final void setAnonymousId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.anonymousId = str;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$SetTraitsAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/UserInfo;", "traits", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/JsonObject;)V", "getTraits", "()Lkotlinx/serialization/json/JsonObject;", "setTraits", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SetTraitsAction implements Action<UserInfo> {
        private JsonObject traits;

        public SetTraitsAction(JsonObject traits) {
            Intrinsics.checkNotNullParameter(traits, "traits");
            this.traits = traits;
        }

        public final JsonObject getTraits() {
            return this.traits;
        }

        @Override // sovran.kotlin.Action
        public UserInfo reduce(UserInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new UserInfo(state.getAnonymousId(), state.getUserId(), this.traits);
        }

        public final void setTraits(JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
            this.traits = jsonObject;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$SetUserIdAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/UserInfo;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SetUserIdAction implements Action<UserInfo> {
        private String userId;

        public SetUserIdAction(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // sovran.kotlin.Action
        public UserInfo reduce(UserInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new UserInfo(state.getAnonymousId(), this.userId, state.getTraits());
        }

        public final void setUserId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userId = str;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/segment/analytics/kotlin/core/UserInfo$SetUserIdAndTraitsAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/UserInfo;", "userId", "", "traits", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)V", "getTraits", "()Lkotlinx/serialization/json/JsonObject;", "setTraits", "(Lkotlinx/serialization/json/JsonObject;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SetUserIdAndTraitsAction implements Action<UserInfo> {
        private JsonObject traits;
        private String userId;

        public SetUserIdAndTraitsAction(String userId, JsonObject traits) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(traits, "traits");
            this.userId = userId;
            this.traits = traits;
        }

        public final JsonObject getTraits() {
            return this.traits;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // sovran.kotlin.Action
        public UserInfo reduce(UserInfo state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new UserInfo(state.getAnonymousId(), this.userId, this.traits);
        }

        public final void setTraits(JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
            this.traits = jsonObject;
        }

        public final void setUserId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userId = str;
        }
    }

    public UserInfo(String anonymousId, String str, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
        this.anonymousId = anonymousId;
        this.userId = str;
        this.traits = jsonObject;
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.anonymousId;
        }
        if ((i & 2) != 0) {
            str2 = userInfo.userId;
        }
        if ((i & 4) != 0) {
            jsonObject = userInfo.traits;
        }
        return userInfo.copy(str, str2, jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnonymousId() {
        return this.anonymousId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonObject getTraits() {
        return this.traits;
    }

    public final UserInfo copy(String anonymousId, String userId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
        return new UserInfo(anonymousId, userId, traits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.anonymousId, userInfo.anonymousId) && Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.traits, userInfo.traits);
    }

    public final String getAnonymousId() {
        return this.anonymousId;
    }

    public final JsonObject getTraits() {
        return this.traits;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iHashCode = this.anonymousId.hashCode() * 31;
        String str = this.userId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonObject jsonObject = this.traits;
        return iHashCode2 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public final void setAnonymousId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anonymousId = str;
    }

    public final void setTraits(JsonObject jsonObject) {
        this.traits = jsonObject;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "UserInfo(anonymousId=" + this.anonymousId + ", userId=" + this.userId + ", traits=" + this.traits + ')';
    }
}
