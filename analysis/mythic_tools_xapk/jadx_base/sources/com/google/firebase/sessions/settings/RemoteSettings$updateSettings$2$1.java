package com.google.firebase.sessions.settings;

import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemoteSettings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws JSONException {
        Boolean bool;
        Double d;
        Integer num;
        SettingsCache settingsCache;
        int iIntValue;
        long seconds;
        Integer num2;
        Double d2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = (JSONObject) this.L$0;
            Log.d(FirebaseSessions.TAG, "Fetched settings: " + jSONObject);
            Integer num3 = 0;
            Integer num4 = null;
            Boolean bool2 = null;
            if (jSONObject.has("app_quality")) {
                Object obj3 = jSONObject.get("app_quality");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj3;
                try {
                    Boolean bool3 = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                    try {
                        d2 = jSONObject2.has("sampling_rate") ? (Double) jSONObject2.get("sampling_rate") : null;
                        try {
                            num2 = jSONObject2.has("session_timeout_seconds") ? (Integer) jSONObject2.get("session_timeout_seconds") : null;
                        } catch (JSONException e) {
                            e = e;
                            num2 = null;
                            bool2 = bool3;
                            obj2 = null;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        num2 = null;
                        d2 = null;
                        bool2 = bool3;
                        obj2 = d2;
                        Boxing.boxInt(Log.e(FirebaseSessions.TAG, "Error parsing the configs remotely fetched: ", e));
                        num = num2;
                        d = d2;
                        bool = bool2;
                        num3 = obj2;
                        settingsCache = this.this$0.settingsCache;
                        if (num3 == 0) {
                        }
                        seconds = this.this$0.timeProvider.currentTime().getSeconds();
                        this.label = 1;
                        if (settingsCache.updateConfigs(new SessionConfigs(bool, d, num, Boxing.boxInt(iIntValue), Boxing.boxLong(seconds)), this) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    try {
                        num4 = jSONObject2.has("cache_duration") ? (Integer) jSONObject2.get("cache_duration") : null;
                        Unit unit = Unit.INSTANCE;
                        num = num2;
                        d = d2;
                        bool = bool3;
                        num3 = num4;
                    } catch (JSONException e3) {
                        e = e3;
                        Integer num5 = num4;
                        bool2 = bool3;
                        obj2 = num5;
                        Boxing.boxInt(Log.e(FirebaseSessions.TAG, "Error parsing the configs remotely fetched: ", e));
                        num = num2;
                        d = d2;
                        bool = bool2;
                        num3 = obj2;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    num2 = null;
                    d2 = null;
                }
            } else {
                bool = null;
                d = null;
                num = null;
            }
            settingsCache = this.this$0.settingsCache;
            iIntValue = num3 == 0 ? num3.intValue() : RemoteSettings.Companion.getDefaultCacheDuration();
            seconds = this.this$0.timeProvider.currentTime().getSeconds();
            this.label = 1;
            if (settingsCache.updateConfigs(new SessionConfigs(bool, d, num, Boxing.boxInt(iIntValue), Boxing.boxLong(seconds)), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
