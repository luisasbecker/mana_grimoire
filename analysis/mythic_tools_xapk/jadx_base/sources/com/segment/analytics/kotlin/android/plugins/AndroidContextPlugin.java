package com.segment.analytics.kotlin.android.plugins;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.EventsKt;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: AndroidContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/segment/analytics/kotlin/android/plugins/AndroidContextPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", AndroidContextPlugin.APP_KEY, "Lkotlinx/serialization/json/JsonObject;", "context", "Landroid/content/Context;", AndroidContextPlugin.DEVICE_KEY, AndroidContextPlugin.OS_KEY, AndroidContextPlugin.SCREEN_KEY, "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "applyContextData", "", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "execute", "getDeviceId", "", "collectDeviceId", "", "fallbackDeviceId", "getDeviceId$android_release", "loadDeviceId", "setup", "Companion", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidContextPlugin implements Plugin {
    public static final String APP_BUILD_KEY = "build";
    public static final String APP_KEY = "app";
    public static final String APP_NAMESPACE_KEY = "namespace";
    public static final String APP_NAME_KEY = "name";
    public static final String APP_VERSION_KEY = "version";
    public static final String DEVICE_ID_KEY = "id";
    public static final String DEVICE_KEY = "device";
    public static final String DEVICE_MANUFACTURER_KEY = "manufacturer";
    public static final String DEVICE_MODEL_KEY = "model";
    public static final String DEVICE_NAME_KEY = "name";
    public static final String DEVICE_TYPE_KEY = "type";
    public static final String LOCALE_KEY = "locale";
    public static final String NETWORK_BLUETOOTH_KEY = "bluetooth";
    public static final String NETWORK_CELLULAR_KEY = "cellular";
    public static final String NETWORK_KEY = "network";
    public static final String NETWORK_WIFI_KEY = "wifi";
    public static final String OS_KEY = "os";
    public static final String OS_NAME_KEY = "name";
    public static final String OS_VERSION_KEY = "version";
    public static final String SCREEN_DENSITY_KEY = "density";
    public static final String SCREEN_HEIGHT_KEY = "height";
    public static final String SCREEN_KEY = "screen";
    public static final String SCREEN_WIDTH_KEY = "width";
    public static final String TIMEZONE_KEY = "timezone";
    public static final String USER_AGENT_KEY = "userAgent";
    public Analytics analytics;
    private JsonObject app;
    private Context context;
    private JsonObject device;
    private JsonObject os;
    private JsonObject screen;
    private Storage storage;
    private final Plugin.Type type = Plugin.Type.Before;

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin$loadDeviceId$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidContextPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin$loadDeviceId$1", f = "AndroidContextPlugin.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP, 168}, m = "invokeSuspend", n = {"deviceId"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $collectDeviceId;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin$loadDeviceId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AndroidContextPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin$loadDeviceId$1$1", f = "AndroidContextPlugin.kt", i = {}, l = {WebmConstants.MkvEbmlElement.BLOCK}, m = "invokeSuspend", n = {}, s = {})
        static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $deviceId;
            final /* synthetic */ Deferred<String> $task;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01891(Ref.ObjectRef<String> objectRef, Deferred<String> deferred, Continuation<? super C01891> continuation) {
                super(2, continuation);
                this.$deviceId = objectRef;
                this.$task = deferred;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01891(this.$deviceId, this.$task, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                T t;
                Ref.ObjectRef<String> objectRef;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef<String> objectRef2 = this.$deviceId;
                    this.L$0 = objectRef2;
                    this.label = 1;
                    Object objAwait = this.$task.await(this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t = objAwait;
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$collectDeviceId = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidContextPlugin.this.new AnonymousClass1(this.$collectDeviceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
        
            if (r13.write(com.segment.analytics.kotlin.core.Storage.Constants.DeviceId, (java.lang.String) r1.element, r12) == r0) goto L21;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, java.lang.Object, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            final Ref.ObjectRef objectRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ?? string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                objectRef = new Ref.ObjectRef();
                objectRef.element = string;
                this.L$0 = objectRef;
                this.label = 1;
                if (TimeoutKt.withTimeoutOrNull(2000L, new C01891(objectRef, BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, null, new AndroidContextPlugin$loadDeviceId$1$task$1(AndroidContextPlugin.this, this.$collectDeviceId, string, null), 3, null), null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            AndroidContextPlugin androidContextPlugin = AndroidContextPlugin.this;
            JsonObject jsonObject = androidContextPlugin.device;
            if (jsonObject == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AndroidContextPlugin.DEVICE_KEY);
                jsonObject = null;
            }
            androidContextPlugin.device = JsonUtils.updateJsonObject(jsonObject, new Function1<Map<String, JsonElement>, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin.loadDeviceId.1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, JsonElement> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, JsonElement> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    JsonUtils.set(it, "id", objectRef.element);
                }
            });
            Storage storage = AndroidContextPlugin.this.storage;
            if (storage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storage");
                storage = null;
            }
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void applyContextData(BaseEvent event) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, event.getContext());
        JsonObject jsonObject = this.app;
        Context context = null;
        if (jsonObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException(APP_KEY);
            jsonObject = null;
        }
        jsonObjectBuilder.put(APP_KEY, jsonObject);
        JsonObject jsonObject2 = this.device;
        if (jsonObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DEVICE_KEY);
            jsonObject2 = null;
        }
        jsonObjectBuilder.put(DEVICE_KEY, jsonObject2);
        JsonObject jsonObject3 = this.os;
        if (jsonObject3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(OS_KEY);
            jsonObject3 = null;
        }
        jsonObjectBuilder.put(OS_KEY, jsonObject3);
        JsonObject jsonObject4 = this.screen;
        if (jsonObject4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCREEN_KEY);
            jsonObject4 = null;
        }
        jsonObjectBuilder.put(SCREEN_KEY, jsonObject4);
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        if (AndroidContextPluginKt.hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE")) {
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context3;
            }
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(allNetworks, "connectivityManager.allNetworks");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (z) {
                    z = true;
                } else if (!(networkCapabilities != null ? networkCapabilities.hasTransport(1) : false)) {
                    z = false;
                }
                if (z3) {
                    z3 = true;
                } else if (!(networkCapabilities != null ? networkCapabilities.hasTransport(0) : false)) {
                    z3 = false;
                }
                if (z2) {
                    z2 = true;
                } else if (!(networkCapabilities != null ? networkCapabilities.hasTransport(2) : false)) {
                    z2 = false;
                }
            }
            JsonElementBuildersKt.put(jsonObjectBuilder2, NETWORK_WIFI_KEY, Boolean.valueOf(z));
            JsonElementBuildersKt.put(jsonObjectBuilder2, NETWORK_BLUETOOTH_KEY, Boolean.valueOf(z2));
            JsonElementBuildersKt.put(jsonObjectBuilder2, NETWORK_CELLULAR_KEY, Boolean.valueOf(z3));
        }
        jsonObjectBuilder.put(NETWORK_KEY, jsonObjectBuilder2.build());
        JsonElementBuildersKt.put(jsonObjectBuilder, LOCALE_KEY, Locale.getDefault().getLanguage() + Soundex.SILENT_MARKER + Locale.getDefault().getCountry());
        JsonUtils.putUndefinedIfNull(jsonObjectBuilder, USER_AGENT_KEY, System.getProperty("http.agent"));
        JsonUtils.putUndefinedIfNull(jsonObjectBuilder, TIMEZONE_KEY, TimeZone.getDefault().getID());
        event.setContext(jsonObjectBuilder.build());
    }

    private final void loadDeviceId(boolean collectDeviceId) {
        BuildersKt__Builders_commonKt.launch$default(getAnalytics().getAnalyticsScope(), getAnalytics().getAnalyticsDispatcher(), null, new AnonymousClass1(collectDeviceId, null), 2, null);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        applyContextData(event);
        return event;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final String getDeviceId$android_release(boolean collectDeviceId, String fallbackDeviceId) throws Throwable {
        Intrinsics.checkNotNullParameter(fallbackDeviceId, "fallbackDeviceId");
        if (collectDeviceId) {
            String uniqueID = AndroidContextPluginKt.getUniqueID();
            String str = uniqueID;
            return (str == null || str.length() == 0) ? fallbackDeviceId : uniqueID;
        }
        Storage storage = this.storage;
        if (storage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            storage = null;
        }
        String str2 = storage.read(Storage.Constants.AnonymousId);
        return str2 == null ? fallbackDeviceId : str2;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Plugin.Type getType() {
        return this.type;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        JsonObject emptyJsonObject;
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Plugin.DefaultImpls.setup(this, analytics);
        Object application = analytics.getConfiguration().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type android.content.Context");
        this.context = (Context) application;
        this.storage = analytics.getStorage();
        boolean collectDeviceId = analytics.getConfiguration().getCollectDeviceId();
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, "name", "Android");
        JsonElementBuildersKt.put(jsonObjectBuilder, "version", Build.VERSION.RELEASE);
        this.os = jsonObjectBuilder.build();
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        Context context = this.context;
        Storage storage = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        JsonElementBuildersKt.put(jsonObjectBuilder2, SCREEN_DENSITY_KEY, Float.valueOf(displayMetrics.density));
        JsonElementBuildersKt.put(jsonObjectBuilder2, "height", Integer.valueOf(displayMetrics.heightPixels));
        JsonElementBuildersKt.put(jsonObjectBuilder2, "width", Integer.valueOf(displayMetrics.widthPixels));
        this.screen = jsonObjectBuilder2.build();
        try {
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            PackageManager packageManager = context2.getPackageManager();
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(context3.getPackageName(), 0);
            JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
            JsonUtils.putUndefinedIfNull(jsonObjectBuilder3, "name", packageInfo.applicationInfo.loadLabel(packageManager));
            JsonUtils.putUndefinedIfNull(jsonObjectBuilder3, "version", packageInfo.versionName);
            JsonUtils.putUndefinedIfNull(jsonObjectBuilder3, APP_NAMESPACE_KEY, packageInfo.packageName);
            JsonElementBuildersKt.put(jsonObjectBuilder3, "build", Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode));
            emptyJsonObject = jsonObjectBuilder3.build();
        } catch (PackageManager.NameNotFoundException unused) {
            emptyJsonObject = EventsKt.getEmptyJsonObject();
        }
        this.app = emptyJsonObject;
        Storage storage2 = this.storage;
        if (storage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
        } else {
            storage = storage2;
        }
        String str = storage.read(Storage.Constants.DeviceId);
        if (str == null) {
            str = "";
        }
        JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder4, "id", str);
        JsonElementBuildersKt.put(jsonObjectBuilder4, DEVICE_MANUFACTURER_KEY, Build.MANUFACTURER);
        JsonElementBuildersKt.put(jsonObjectBuilder4, DEVICE_MODEL_KEY, Build.MODEL);
        JsonElementBuildersKt.put(jsonObjectBuilder4, "name", Build.DEVICE);
        JsonElementBuildersKt.put(jsonObjectBuilder4, "type", Constants.PLATFORM);
        this.device = jsonObjectBuilder4.build();
        if (str.length() == 0) {
            loadDeviceId(collectDeviceId);
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
