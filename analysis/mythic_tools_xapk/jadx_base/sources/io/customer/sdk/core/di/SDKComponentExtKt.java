package io.customer.sdk.core.di;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SDKComponentExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setupAndroidComponent", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "Lio/customer/sdk/core/di/SDKComponent;", "context", "Landroid/content/Context;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SDKComponentExtKt {
    public static final AndroidSDKComponent setupAndroidComponent(SDKComponent sDKComponent, Context context) {
        AndroidSDKComponent androidSDKComponent;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(sDKComponent, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        SDKComponent sDKComponent2 = sDKComponent;
        synchronized (sDKComponent2.getSingletons()) {
            String name = AndroidSDKComponent.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent2.getSingletons();
            AndroidSDKComponentImpl androidSDKComponentImpl = singletons.get(name);
            if (androidSDKComponentImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name, (androidSDKComponentImpl = new AndroidSDKComponentImpl(context)))) != null) {
                androidSDKComponentImpl = objPutIfAbsent;
            }
            if (androidSDKComponentImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.core.di.AndroidSDKComponent");
            }
            androidSDKComponent = (AndroidSDKComponent) androidSDKComponentImpl;
        }
        return androidSDKComponent;
    }
}
