package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.facebook.bolts.AppLinks;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFi1kSDK implements AFi1lSDK {
    private PluginInfo getMonetizationNetwork = new PluginInfo(Plugin.NATIVE, "6.18.0", null, 4, null);

    @Override // com.appsflyer.internal.AFi1lSDK
    public final Map<String, Object> getRevenue() {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("platform", this.getMonetizationNetwork.getPlugin().getPluginName()), TuplesKt.to("version", this.getMonetizationNetwork.getVersion()));
        if (!this.getMonetizationNetwork.getAdditionalParams().isEmpty()) {
            mapMutableMapOf.put(AppLinks.KEY_NAME_EXTRAS, this.getMonetizationNetwork.getAdditionalParams());
        }
        return mapMutableMapOf;
    }

    @Override // com.appsflyer.internal.AFi1lSDK
    public final void getRevenue(PluginInfo pluginInfo) {
        Intrinsics.checkNotNullParameter(pluginInfo, "");
        this.getMonetizationNetwork = pluginInfo;
    }
}
