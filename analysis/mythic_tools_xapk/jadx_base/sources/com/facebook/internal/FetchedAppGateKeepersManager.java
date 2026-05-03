package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FetchedAppGateKeepersManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u001fH\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0017\u0010%\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0012H\u0007J\u001f\u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b,J\b\u0010-\u001a\u00020(H\u0002J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001fH\u0007J\b\u00100\u001a\u00020(H\u0007J\u0018\u00101\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0015H\u0002J\u001a\u00103\u001a\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\u0006\u00104\u001a\u000205H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00067"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "()V", "APPLICATION_FIELDS", "", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_GATEKEEPERS_PREFS_STORE", "APP_PLATFORM", "TAG", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "fetchedAppGateKeepers", "", "Lorg/json/JSONObject;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", DiagnosticsEntry.TIMESTAMP_KEY, "Ljava/lang/Long;", "getAppGateKeepersQueryResponse", "applicationId", "getGateKeeperForKey", "", "name", "defaultValue", "getGateKeepersForAppId", "getGateKeepersForApplication", "", "isTimestampValid", "(Ljava/lang/Long;)Z", "loadAppGateKeepersAsync", "", "callback", "parseAppGateKeepersFromJSON", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "pollCallbacks", "queryAppGateKeepers", "forceRequery", "resetRuntimeGateKeeperCache", "setGateKeepersForAppId", "json", "setRuntimeGateKeeper", "gateKeeper", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = "FetchedAppGateKeepersManager";
    private static volatile GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static volatile Long timestamp;
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    /* JADX INFO: compiled from: FetchedAppGateKeepersManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final JSONObject getAppGateKeepersQueryResponse(String applicationId) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.INSTANCE;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        GraphRequest graphRequestNewGraphPathRequest = companion.newGraphPathRequest(null, str, null);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = graphRequestNewGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    @JvmStatic
    public static final boolean getGateKeeperForKey(String name, String applicationId, boolean defaultValue) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(applicationId);
        return (gateKeepersForApplication.containsKey(name) && (bool = gateKeepersForApplication.get(name)) != null) ? bool.booleanValue() : defaultValue;
    }

    private final synchronized JSONObject getGateKeepersForAppId(String applicationId) {
        return fetchedAppGateKeepers.get(applicationId);
    }

    private final boolean isTimestampValid(Long timestamp2) {
        return timestamp2 != null && System.currentTimeMillis() - timestamp2.longValue() < 3600000;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0018, B:10:0x001e, B:13:0x0023, B:17:0x0041, B:19:0x0053, B:24:0x0064, B:25:0x0067, B:29:0x006f, B:33:0x0079, B:22:0x005b), top: B:39:0x0005, inners: #1 }] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        final String applicationId;
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager;
        final Context applicationContext;
        if (callback != null) {
            callbacks.add(callback);
            applicationId = FacebookSdk.getApplicationId();
            fetchedAppGateKeepersManager = INSTANCE;
            if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp) && fetchedAppGateKeepersManager.getGateKeepersForAppId(applicationId) != null) {
                fetchedAppGateKeepersManager.pollCallbacks();
                return;
            }
            applicationContext = FacebookSdk.getApplicationContext();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            if (applicationContext != null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(str, null);
            if (!Utility.isNullOrEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility.logd(Utility.LOG_TAG, e);
                }
                if (jSONObject != null) {
                    parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                }
            }
            Executor executor = FacebookSdk.getExecutor();
            if (executor == null) {
                return;
            }
            if (isLoading.compareAndSet(false, true)) {
                executor.execute(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FetchedAppGateKeepersManager.loadAppGateKeepersAsync$lambda$0(applicationId, applicationContext, str);
                    }
                });
                return;
            }
            return;
        }
        applicationId = FacebookSdk.getApplicationId();
        fetchedAppGateKeepersManager = INSTANCE;
        if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp)) {
        }
        applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        final String str2 = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        if (applicationContext != null) {
        }
    }

    static final void loadAppGateKeepersAsync$lambda$0(String applicationId, Context context, String gateKeepersKey) {
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(gateKeepersKey, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        JSONObject appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(gateKeepersKey, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    @JvmStatic
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String applicationId, JSONObject gateKeepersJSON) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        JSONObject gateKeepersForAppId = INSTANCE.getGateKeepersForAppId(applicationId);
        jSONObject = gateKeepersForAppId != null ? new JSONObject(gateKeepersForAppId.toString()) : new JSONObject();
        JSONObject jSONObjectOptJSONObject = (gateKeepersJSON == null || (jSONArrayOptJSONArray = gateKeepersJSON.optJSONArray("data")) == null) ? null : jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        int length = jSONArrayOptJSONArray2.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i);
                jSONObject.put(jSONObject2.getString(SubscriberAttributeKt.JSON_NAME_KEY), jSONObject2.getBoolean("value"));
            } catch (JSONException e) {
                Utility.logd(Utility.LOG_TAG, e);
            }
        }
        INSTANCE.setGateKeepersForAppId(applicationId, jSONObject);
        return jSONObject;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final Callback callbackPoll = concurrentLinkedQueue.poll();
            if (callbackPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        callbackPoll.onCompleted();
                    }
                });
            }
        }
    }

    @JvmStatic
    public static final JSONObject queryAppGateKeepers(String applicationId, boolean forceRequery) {
        JSONObject gateKeepersForAppId;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!forceRequery && (gateKeepersForAppId = INSTANCE.getGateKeepersForAppId(applicationId)) != null) {
            return gateKeepersForAppId;
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(applicationId);
        Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
    }

    @JvmStatic
    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, null, 1, null);
        }
    }

    private final synchronized void setGateKeepersForAppId(String applicationId, JSONObject json) {
        fetchedAppGateKeepers.put(applicationId, json);
    }

    @JvmStatic
    public static final void setRuntimeGateKeeper(String applicationId, GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if ((gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.getGateKeeper(applicationId, gateKeeper.getName()) : null) == null) {
            Log.w(TAG, "Missing gatekeeper runtime cache");
            return;
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 != null) {
            gateKeeperRuntimeCache3.setGateKeeper(applicationId, gateKeeper);
        }
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String applicationId) {
        loadAppGateKeepersAsync();
        if (applicationId == null || getGateKeepersForAppId(applicationId) == null) {
            return new HashMap();
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        List<GateKeeper> listDumpGateKeepers = gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.dumpGateKeepers(applicationId) : null;
        if (listDumpGateKeepers != null) {
            HashMap map = new HashMap();
            for (GateKeeper gateKeeper : listDumpGateKeepers) {
                map.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
            }
            return map;
        }
        HashMap map2 = new HashMap();
        JSONObject gateKeepersForAppId = getGateKeepersForAppId(applicationId);
        if (gateKeepersForAppId == null) {
            gateKeepersForAppId = new JSONObject();
        }
        Iterator<String> itKeys = gateKeepersForAppId.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            map2.put(key, Boolean.valueOf(gateKeepersForAppId.optBoolean(key)));
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 == null) {
            gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
        }
        ArrayList arrayList = new ArrayList(map2.size());
        for (Map.Entry entry : map2.entrySet()) {
            arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
        }
        gateKeeperRuntimeCache3.setGateKeepers(applicationId, arrayList);
        gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
        return map2;
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }
}
