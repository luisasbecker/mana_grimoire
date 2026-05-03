package io.customer.sdk.core.di;

import android.app.Application;
import android.content.Context;
import androidx.media3.common.MimeTypes;
import io.customer.sdk.data.store.ApplicationStore;
import io.customer.sdk.data.store.BuildStore;
import io.customer.sdk.data.store.Client;
import io.customer.sdk.data.store.DeviceStore;
import io.customer.sdk.data.store.GlobalPreferenceStore;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidSDKComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/customer/sdk/core/di/AndroidSDKComponent;", "Lio/customer/sdk/core/di/DiGraph;", "<init>", "()V", "client", "Lio/customer/sdk/data/store/Client;", "getClient", "()Lio/customer/sdk/data/store/Client;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "buildStore", "Lio/customer/sdk/data/store/BuildStore;", "getBuildStore", "()Lio/customer/sdk/data/store/BuildStore;", "applicationStore", "Lio/customer/sdk/data/store/ApplicationStore;", "getApplicationStore", "()Lio/customer/sdk/data/store/ApplicationStore;", "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "getDeviceStore", "()Lio/customer/sdk/data/store/DeviceStore;", "globalPreferenceStore", "Lio/customer/sdk/data/store/GlobalPreferenceStore;", "getGlobalPreferenceStore", "()Lio/customer/sdk/data/store/GlobalPreferenceStore;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AndroidSDKComponent extends DiGraph {
    public abstract Application getApplication();

    public abstract Context getApplicationContext();

    public abstract ApplicationStore getApplicationStore();

    public abstract BuildStore getBuildStore();

    public abstract Client getClient();

    public abstract DeviceStore getDeviceStore();

    public abstract GlobalPreferenceStore getGlobalPreferenceStore();
}
