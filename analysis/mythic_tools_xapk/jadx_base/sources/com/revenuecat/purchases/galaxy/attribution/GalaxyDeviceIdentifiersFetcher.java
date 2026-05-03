package com.revenuecat.purchases.galaxy.attribution;

import android.app.Application;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalaxyDeviceIdentifiersFetcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062-\u0010\u0007\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/galaxy/attribution/GalaxyDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "()V", "getDeviceIdentifiers", "", "applicationContext", "Landroid/app/Application;", "completion", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalaxyDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(Application applicationContext, Function1<? super Map<String, String>, Unit> completion) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        completion.invoke(MapsKt.emptyMap());
    }
}
