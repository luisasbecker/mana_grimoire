package io.customer.sdk.core.di;

import android.app.Application;
import android.content.Context;
import androidx.media3.common.MimeTypes;
import io.customer.sdk.core.extensions.ContextExtensionsKt;
import io.customer.sdk.data.store.ApplicationStore;
import io.customer.sdk.data.store.ApplicationStoreImpl;
import io.customer.sdk.data.store.BuildStore;
import io.customer.sdk.data.store.BuildStoreImpl;
import io.customer.sdk.data.store.Client;
import io.customer.sdk.data.store.DeviceStore;
import io.customer.sdk.data.store.DeviceStoreImpl;
import io.customer.sdk.data.store.GlobalPreferenceStore;
import io.customer.sdk.data.store.GlobalPreferenceStoreImpl;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidSDKComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/customer/sdk/core/di/AndroidSDKComponentImpl;", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "client", "Lio/customer/sdk/data/store/Client;", "getClient", "()Lio/customer/sdk/data/store/Client;", "applicationContext", "getApplicationContext", "()Landroid/content/Context;", "buildStore", "Lio/customer/sdk/data/store/BuildStore;", "getBuildStore", "()Lio/customer/sdk/data/store/BuildStore;", "applicationStore", "Lio/customer/sdk/data/store/ApplicationStore;", "getApplicationStore", "()Lio/customer/sdk/data/store/ApplicationStore;", "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "getDeviceStore", "()Lio/customer/sdk/data/store/DeviceStore;", "globalPreferenceStore", "Lio/customer/sdk/data/store/GlobalPreferenceStore;", "getGlobalPreferenceStore", "()Lio/customer/sdk/data/store/GlobalPreferenceStore;", "reset", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidSDKComponentImpl extends AndroidSDKComponent {
    private final Context context;

    public AndroidSDKComponentImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        SDKComponent.INSTANCE.getActivityLifecycleCallbacks().register(getApplication());
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public Application getApplication() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = Application.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof Application)) {
            obj = null;
        }
        Application application = (Application) obj;
        if (application != null) {
            return application;
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public Context getApplicationContext() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = Context.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof Context)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context != null) {
            return context;
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public ApplicationStore getApplicationStore() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = ApplicationStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof ApplicationStore)) {
            obj = null;
        }
        ApplicationStore applicationStore = (ApplicationStore) obj;
        return applicationStore == null ? new ApplicationStoreImpl(getApplicationContext()) : applicationStore;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public BuildStore getBuildStore() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = BuildStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof BuildStore)) {
            obj = null;
        }
        BuildStore buildStore = (BuildStore) obj;
        return buildStore == null ? new BuildStoreImpl() : buildStore;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public Client getClient() {
        Client client;
        AndroidSDKComponentImpl androidSDKComponentImpl = this;
        ConcurrentHashMap<String, Object> overrides = androidSDKComponentImpl.getOverrides();
        String name = Client.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof Client)) {
            obj = null;
        }
        Client client2 = (Client) obj;
        if (client2 != null) {
            return client2;
        }
        synchronized (androidSDKComponentImpl.getSingletons()) {
            String name2 = Client.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = androidSDKComponentImpl.getSingletons();
            Object obj2 = singletons.get(name2);
            if (obj2 == null) {
                Client clientFromMetadata = Client.INSTANCE.fromMetadata(ContextExtensionsKt.applicationMetaData(this.context));
                Object objPutIfAbsent = singletons.putIfAbsent(name2, clientFromMetadata);
                obj2 = objPutIfAbsent == null ? clientFromMetadata : objPutIfAbsent;
            }
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.data.store.Client");
            }
            client = (Client) obj2;
        }
        return client;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public DeviceStore getDeviceStore() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = DeviceStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof DeviceStore)) {
            obj = null;
        }
        DeviceStore deviceStore = (DeviceStore) obj;
        return deviceStore == null ? new DeviceStoreImpl(getBuildStore(), getApplicationStore(), getClient(), null, 8, null) : deviceStore;
    }

    @Override // io.customer.sdk.core.di.AndroidSDKComponent
    public GlobalPreferenceStore getGlobalPreferenceStore() {
        GlobalPreferenceStore globalPreferenceStore;
        Object objPutIfAbsent;
        AndroidSDKComponentImpl androidSDKComponentImpl = this;
        ConcurrentHashMap<String, Object> overrides = androidSDKComponentImpl.getOverrides();
        String name = GlobalPreferenceStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof GlobalPreferenceStore)) {
            obj = null;
        }
        GlobalPreferenceStore globalPreferenceStore2 = (GlobalPreferenceStore) obj;
        if (globalPreferenceStore2 != null) {
            return globalPreferenceStore2;
        }
        synchronized (androidSDKComponentImpl.getSingletons()) {
            String name2 = GlobalPreferenceStore.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = androidSDKComponentImpl.getSingletons();
            GlobalPreferenceStoreImpl globalPreferenceStoreImpl = singletons.get(name2);
            if (globalPreferenceStoreImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (globalPreferenceStoreImpl = new GlobalPreferenceStoreImpl(getApplicationContext())))) != null) {
                globalPreferenceStoreImpl = objPutIfAbsent;
            }
            if (globalPreferenceStoreImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.data.store.GlobalPreferenceStore");
            }
            globalPreferenceStore = (GlobalPreferenceStore) globalPreferenceStoreImpl;
        }
        return globalPreferenceStore;
    }

    @Override // io.customer.sdk.core.di.DiGraph
    public void reset() {
        super.reset();
        SDKComponent.INSTANCE.getActivityLifecycleCallbacks().unregister(getApplication());
    }
}
