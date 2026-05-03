package io.customer.sdk;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.utilities.AnySerializerKt;
import io.customer.datapipelines.extensions.JsonExtensionsKt;
import io.customer.sdk.events.TrackMetric;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: DataPipelineInstance.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0082\b¢\u0006\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\rH&J&\u0010\u0014\u001a\u00020\u0012\"\u0006\b\u0000\u0010\u0015\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\u0015H\u0087\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0019H\u0007J(\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0007J1\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0007¢\u0006\u0002\u0010\u001cJ1\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH$¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0019H\u0007J(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000b2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0007J1\u0010\u001e\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0007¢\u0006\u0002\u0010\u001cJ1\u0010!\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u001bH$¢\u0006\u0002\u0010\u001cJ&\u0010\u001e\u001a\u00020\u0012\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u0005H\u0087\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0019H\u0007J(\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u000b2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0007J1\u0010\"\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00052\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0007¢\u0006\u0002\u0010\u001cJ1\u0010$\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00052\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u001bH$¢\u0006\u0002\u0010\u001cJ&\u0010\"\u001a\u00020\u0012\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u0002H\u0005H\u0087\b¢\u0006\u0002\u0010\u0018J\u0006\u0010%\u001a\u00020\u0012J\b\u0010&\u001a\u00020\u0012H$J\u000e\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H$J \u00104\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\rH&J\u000e\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u000bJ\u0010\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u000bH$J\u0006\u00108\u001a\u00020\u0012J\b\u00109\u001a\u00020\u0012H$R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010+\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010-R*\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010\u0010¨\u0006:"}, d2 = {"Lio/customer/sdk/DataPipelineInstance;", "Lio/customer/sdk/CustomerIOInstance;", "<init>", "()V", "synchronized", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileAttributes", "", "", "", "Lio/customer/sdk/data/model/CustomAttributes;", "getProfileAttributes$annotations", "getProfileAttributes", "()Ljava/util/Map;", "setProfileAttributes", "", "attributes", "identify", "Traits", "userId", "traits", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlinx/serialization/json/JsonObject;", "serializationStrategy", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "identifyImpl", "track", "name", DiagnosticsEntry.PROPERTIES_KEY, "trackImpl", AndroidContextPlugin.SCREEN_KEY, Constants.GP_IAP_TITLE, "screenImpl", "clearIdentify", "clearIdentifyImpl", "trackMetric", NotificationCompat.CATEGORY_EVENT, "Lio/customer/sdk/events/TrackMetric;", "trackMetricImpl", "registeredDeviceToken", "getRegisteredDeviceToken", "()Ljava/lang/String;", "anonymousId", "getAnonymousId", "getUserId", "deviceAttributes", "getDeviceAttributes$annotations", "getDeviceAttributes", "setDeviceAttributes", "registerDeviceToken", "deviceToken", "registerDeviceTokenImpl", "deleteDeviceToken", "deleteDeviceTokenImpl", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DataPipelineInstance implements CustomerIOInstance {
    @Deprecated(message = "Use setDeviceAttributes() function instead")
    public static /* synthetic */ void getDeviceAttributes$annotations() {
    }

    @Deprecated(message = "Use setProfileAttributes() function instead")
    public static /* synthetic */ void getProfileAttributes$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(DataPipelineInstance dataPipelineInstance, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        dataPipelineInstance.identify(str, (Map<String, ? extends Object>) map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void screen$default(DataPipelineInstance dataPipelineInstance, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: screen");
        }
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        dataPipelineInstance.screen(str, (Map<String, ? extends Object>) map);
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    private final <T> T m11436synchronized(Function0<? extends T> block) {
        T tInvoke;
        synchronized (this) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(DataPipelineInstance dataPipelineInstance, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        dataPipelineInstance.track(str, (Map<String, ? extends Object>) map);
    }

    public final void clearIdentify() {
        synchronized (this) {
            clearIdentifyImpl();
            Unit unit = Unit.INSTANCE;
        }
    }

    protected abstract void clearIdentifyImpl();

    public final void deleteDeviceToken() {
        synchronized (this) {
            deleteDeviceTokenImpl();
            Unit unit = Unit.INSTANCE;
        }
    }

    protected abstract void deleteDeviceTokenImpl();

    public abstract String getAnonymousId();

    public abstract Map<String, Object> getDeviceAttributes();

    public abstract Map<String, Object> getProfileAttributes();

    public abstract String getRegisteredDeviceToken();

    public abstract String getUserId();

    public final void identify(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        identify$default(this, userId, null, 2, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use identify(userId: String, traits: Map<String, Any?>) instead")
    public final /* synthetic */ <Traits> void identify(String userId, Traits traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "Traits");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        identify(userId, traits, SerializersKt.serializer(serializersModule, (KType) null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use identify(userId: String, traits: Map<String, Any?>) instead")
    public final <Traits> void identify(String userId, Traits traits, SerializationStrategy<? super Traits> serializationStrategy) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        synchronized (this) {
            identifyImpl(userId, traits, serializationStrategy);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void identify(String userId, Map<String, ? extends Object> traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        identify(userId, JsonExtensionsKt.sanitizeForJson$default(traits, null, 1, null), new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)))));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use identify(userId: String, traits: Map<String, Any?>) instead")
    public final void identify(String userId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        identify(userId, traits, JsonObject.INSTANCE.serializer());
    }

    protected abstract <Traits> void identifyImpl(String userId, Traits traits, SerializationStrategy<? super Traits> serializationStrategy);

    public final void registerDeviceToken(String deviceToken) {
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        synchronized (this) {
            registerDeviceTokenImpl(deviceToken);
            Unit unit = Unit.INSTANCE;
        }
    }

    protected abstract void registerDeviceTokenImpl(String deviceToken);

    public final void screen(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        screen$default(this, title, null, 2, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use screen(title: String, properties: Map<String, Any?>) instead")
    public final /* synthetic */ <T> void screen(String title, T properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        screen(title, properties, SerializersKt.serializer(serializersModule, (KType) null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use screen(title: String, properties: Map<String, Any?>) instead")
    public final <T> void screen(String title, T properties, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        synchronized (this) {
            screenImpl(title, properties, serializationStrategy);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void screen(String title, Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        screen(title, JsonExtensionsKt.sanitizeForJson$default(properties, null, 1, null), new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)))));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use screen(title: String, properties: Map<String, Any?>) instead")
    public final void screen(String title, JsonObject properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        screen(title, properties, JsonObject.INSTANCE.serializer());
    }

    protected abstract <T> void screenImpl(String title, T properties, SerializationStrategy<? super T> serializationStrategy);

    public abstract void setDeviceAttributes(Map<String, ? extends Object> attributes);

    public abstract void setProfileAttributes(Map<String, ? extends Object> attributes);

    public final void track(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        track$default(this, name, null, 2, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use track(name: String, properties: Map<String, Any?>) instead")
    public final /* synthetic */ <T> void track(String name, T properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        track(name, properties, SerializersKt.serializer(serializersModule, (KType) null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use track(name: String, properties: Map<String, Any?>) instead")
    public final <T> void track(String name, T properties, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        synchronized (this) {
            trackImpl(name, properties, serializationStrategy);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void track(String name, Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        track(name, JsonExtensionsKt.sanitizeForJson$default(properties, null, 1, null), new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)))));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use track(name: String, properties: Map<String, Any?>) instead")
    public final void track(String name, JsonObject properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        track(name, properties, JsonObject.INSTANCE.serializer());
    }

    protected abstract <T> void trackImpl(String name, T properties, SerializationStrategy<? super T> serializationStrategy);

    public final void trackMetric(TrackMetric event) {
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (this) {
            trackMetricImpl(event);
            Unit unit = Unit.INSTANCE;
        }
    }

    protected abstract void trackMetricImpl(TrackMetric event);
}
