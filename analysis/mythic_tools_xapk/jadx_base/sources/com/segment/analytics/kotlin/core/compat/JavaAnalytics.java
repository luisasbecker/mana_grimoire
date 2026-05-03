package com.segment.analytics.kotlin.core.compat;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.EventsKt;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.AnySerializerKt;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: JavaAnalytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u001a\u0010'\u001a\u00020#2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#0)J\u0016\u0010'\u001a\u00020#2\u000e\u0010(\u001a\n\u0012\u0006\b\u0000\u0012\u00020!0*J%\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H,0-¢\u0006\u0002\u0010.J\u0010\u0010+\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020%J$\u00101\u001a\b\u0012\u0004\u0012\u0002H,02\"\b\b\u0000\u0010,*\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H,0-J\u0006\u00103\u001a\u00020#J\u0016\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207J\"\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020%2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000109J\u001a\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020%2\b\b\u0002\u00108\u001a\u00020:H\u0007J\u000e\u0010;\u001a\u00020#2\u0006\u00106\u001a\u000207J\u0016\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020%2\u0006\u00106\u001a\u000207J\"\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020%2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000109J\u001a\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020%2\b\b\u0002\u00108\u001a\u00020:H\u0007J\u001a\u0010;\u001a\u00020#2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000109J\u0012\u0010;\u001a\u00020#2\b\b\u0002\u00108\u001a\u00020:H\u0007J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020%02J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020#J\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020%J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u000e\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020#J \u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020%2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010J\u001a\u00020%J.\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020%2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0001092\b\b\u0002\u0010J\u001a\u00020%H\u0007J$\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020%2\b\b\u0002\u0010K\u001a\u00020:2\b\b\u0002\u0010J\u001a\u00020%H\u0007J\b\u0010L\u001a\u0004\u0018\u00010MJ\u0010\u0010N\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020%2\u0006\u00106\u001a\u000207J\"\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020%2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000109J\u001a\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020%2\b\b\u0002\u0010K\u001a\u00020:H\u0007J\b\u00108\u001a\u0004\u0018\u00010:J\b\u0010<\u001a\u0004\u0018\u00010%J\u0006\u0010Q\u001a\u00020%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016*\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u001b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006R"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/JavaAnalytics;", "", "configuration", "Lcom/segment/analytics/kotlin/core/Configuration;", "(Lcom/segment/analytics/kotlin/core/Configuration;)V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "<set-?>", "Lkotlinx/coroutines/CoroutineScope;", "analyticsScope", "getAnalyticsScope", "()Lkotlinx/coroutines/CoroutineScope;", "", "enabled", "getEnabled$delegate", "(Lcom/segment/analytics/kotlin/core/compat/JavaAnalytics;)Ljava/lang/Object;", "getEnabled", "()Z", "setEnabled", "(Z)V", "Lcom/segment/analytics/kotlin/core/Storage;", "storage", "getStorage", "()Lcom/segment/analytics/kotlin/core/Storage;", "Lsovran/kotlin/Store;", ProductResponseJsonKeys.STORE, "getStore", "()Lsovran/kotlin/Store;", "add", "plugin", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "alias", "", "newId", "", "anonymousId", "applyClosureToPlugins", "closure", "Lkotlin/Function1;", "Ljava/util/function/Consumer;", "find", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/segment/analytics/kotlin/core/platform/Plugin;", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", "destinationKey", "findAll", "", "flush", "group", "groupId", "serializable", "Lcom/segment/analytics/kotlin/core/compat/JsonSerializable;", "traits", "", "Lkotlinx/serialization/json/JsonObject;", "identify", "userId", "pendingUploads", "process", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "purgeStorage", "filePath", "remove", "reportInternalError", "error", "", "reset", AndroidContextPlugin.SCREEN_KEY, Constants.GP_IAP_TITLE, "category", DiagnosticsEntry.PROPERTIES_KEY, "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "setup", "track", "name", "version", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JavaAnalytics {
    private final Analytics analytics;
    private CoroutineScope analyticsScope;
    private Storage storage;
    private Store store;

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.compat.JavaAnalytics$applyClosureToPlugins$1, reason: invalid class name */
    /* JADX INFO: compiled from: JavaAnalytics.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Plugin, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, Consumer.class, "accept", "accept(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
            invoke2(plugin);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Plugin p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((Consumer) this.receiver).accept(p0);
        }
    }

    public JavaAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
        setup(analytics);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaAnalytics(Configuration configuration) {
        this(new Analytics(configuration));
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    public static /* synthetic */ void group$default(JavaAnalytics javaAnalytics, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        javaAnalytics.group(str, jsonObject);
    }

    public static /* synthetic */ void identify$default(JavaAnalytics javaAnalytics, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        javaAnalytics.identify(str, jsonObject);
    }

    public static /* synthetic */ void identify$default(JavaAnalytics javaAnalytics, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        javaAnalytics.identify(jsonObject);
    }

    public static /* synthetic */ void screen$default(JavaAnalytics javaAnalytics, String str, JsonSerializable jsonSerializable, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        javaAnalytics.screen(str, jsonSerializable, str2);
    }

    public static /* synthetic */ void screen$default(JavaAnalytics javaAnalytics, String str, Map map, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        javaAnalytics.screen(str, (Map<String, ? extends Object>) map, str2);
    }

    public static /* synthetic */ void screen$default(JavaAnalytics javaAnalytics, String str, JsonObject jsonObject, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        javaAnalytics.screen(str, jsonObject, str2);
    }

    private final void setup(Analytics analytics) {
        this.store = analytics.getStore();
        this.storage = analytics.getStorage();
        this.analyticsScope = analytics.getAnalyticsScope();
    }

    public static /* synthetic */ void track$default(JavaAnalytics javaAnalytics, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        javaAnalytics.track(str, jsonObject);
    }

    public final JavaAnalytics add(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.analytics.add(plugin);
        return this;
    }

    public final void alias(String newId) {
        Intrinsics.checkNotNullParameter(newId, "newId");
        Analytics.alias$default(this.analytics, newId, null, 2, null);
    }

    public final String anonymousId() {
        return this.analytics.anonymousId();
    }

    public final void applyClosureToPlugins(Consumer<? super Plugin> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        this.analytics.applyClosureToPlugins(new AnonymousClass1(closure));
    }

    public final void applyClosureToPlugins(Function1<? super Plugin, Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        this.analytics.applyClosureToPlugins(closure);
    }

    public final DestinationPlugin find(String destinationKey) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        return this.analytics.find(destinationKey);
    }

    public final <T extends Plugin> T find(Class<T> plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return (T) this.analytics.find(JvmClassMappingKt.getKotlinClass(plugin));
    }

    public final <T extends Plugin> List<T> findAll(Class<T> plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return this.analytics.findAll(JvmClassMappingKt.getKotlinClass(plugin));
    }

    public final void flush() {
        this.analytics.flush();
    }

    public final Analytics getAnalytics() {
        return this.analytics;
    }

    public final CoroutineScope getAnalyticsScope() {
        CoroutineScope coroutineScope = this.analyticsScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analyticsScope");
        return null;
    }

    public final boolean getEnabled() {
        return this.analytics.getEnabled();
    }

    public final Storage getStorage() {
        Storage storage = this.storage;
        if (storage != null) {
            return storage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final Store getStore() {
        Store store = this.store;
        if (store != null) {
            return store;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ProductResponseJsonKeys.STORE);
        return null;
    }

    public final void group(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        group$default(this, groupId, null, 2, null);
    }

    public final void group(String groupId, JsonSerializable serializable) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        Analytics.group$default(this.analytics, groupId, serializable.serialize(), (Function1) null, 4, (Object) null);
    }

    public final void group(String groupId, Map<String, ? extends Object> traits) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.analytics.group(groupId, traits, new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class))), null);
    }

    public final void group(String groupId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        Analytics.group$default(this.analytics, groupId, traits, (Function1) null, 4, (Object) null);
    }

    public final void identify() {
        identify$default(this, null, 1, null);
    }

    public final void identify(JsonSerializable serializable) {
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        Analytics.identify$default(this.analytics, serializable.serialize(), (Function1) null, 2, (Object) null);
    }

    public final void identify(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        identify$default(this, userId, null, 2, null);
    }

    public final void identify(String userId, JsonSerializable serializable) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        Analytics.identify$default(this.analytics, userId, serializable.serialize(), (Function1) null, 4, (Object) null);
    }

    public final void identify(String userId, Map<String, ? extends Object> traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.analytics.identify(userId, traits, new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class))), null);
    }

    public final void identify(String userId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        Analytics.identify$default(this.analytics, userId, traits, (Function1) null, 4, (Object) null);
    }

    public final void identify(Map<String, ? extends Object> traits) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.analytics.identify(traits, new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class))), (Function1<? super BaseEvent, ? extends BaseEvent>) null);
    }

    public final void identify(JsonObject traits) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        Analytics.identify$default(this.analytics, traits, (Function1) null, 2, (Object) null);
    }

    public final List<String> pendingUploads() {
        return this.analytics.pendingUploads();
    }

    public final void process(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Analytics.process$default(this.analytics, event, null, 2, null);
    }

    public final void purgeStorage() {
        this.analytics.purgeStorage();
    }

    public final void purgeStorage(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.analytics.purgeStorage(filePath);
    }

    public final JavaAnalytics remove(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.analytics.remove(plugin);
        return this;
    }

    public final void reportInternalError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        ErrorsKt.reportInternalError(this.analytics, error);
    }

    public final void reset() {
        this.analytics.reset();
    }

    public final void screen(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        screen$default(this, title, (JsonObject) null, (String) null, 6, (Object) null);
    }

    public final void screen(String title, JsonSerializable serializable, String category) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        Intrinsics.checkNotNullParameter(category, "category");
        Analytics.screen$default(this.analytics, title, serializable.serialize(), category, (Function1) null, 8, (Object) null);
    }

    public final void screen(String title, Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        screen$default(this, title, properties, (String) null, 4, (Object) null);
    }

    public final void screen(String title, Map<String, ? extends Object> properties, String category) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(category, "category");
        this.analytics.screen(title, properties, new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class))), category, null);
    }

    public final void screen(String title, JsonObject properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        screen$default(this, title, properties, (String) null, 4, (Object) null);
    }

    public final void screen(String title, JsonObject properties, String category) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(category, "category");
        Analytics.screen$default(this.analytics, title, properties, category, (Function1) null, 8, (Object) null);
    }

    public final void setEnabled(boolean z) {
        this.analytics.setEnabled(z);
    }

    public final Settings settings() {
        return this.analytics.settings();
    }

    public final void track(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        track$default(this, name, null, 2, null);
    }

    public final void track(String name, JsonSerializable serializable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        Analytics.track$default(this.analytics, name, serializable.serialize(), (Function1) null, 4, (Object) null);
    }

    public final void track(String name, Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.analytics.track(name, properties, new LinkedHashMapSerializer(StringSerializer.INSTANCE, SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class))), null);
    }

    public final void track(String name, JsonObject properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Analytics.track$default(this.analytics, name, properties, (Function1) null, 4, (Object) null);
    }

    public final JsonObject traits() {
        return this.analytics.traits();
    }

    public final String userId() {
        return this.analytics.userId();
    }

    public final String version() {
        return this.analytics.version();
    }
}
