package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u0007*\u00020\u0007H\u0017¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u001a\u0010\u0012\u001a\u00020\u00178\u0017X\u0097D¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\r\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001b"}, d2 = {"Lcom/appsflyer/internal/AFd1nSDK;", "Lcom/appsflyer/internal/AFc1dSDK;", "Lcom/appsflyer/internal/AFc1kSDK;", "p0", "", "p1", "", "", "p2", "", "p3", "<init>", "(Lcom/appsflyer/internal/AFc1kSDK;[BLjava/util/Map;I)V", "getMediationNetwork", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/appsflyer/internal/AFd1hSDK;", "component4", "Lcom/appsflyer/internal/AFd1hSDK;", "AFAdRevenueData", "()Lcom/appsflyer/internal/AFd1hSDK;", "getRevenue", "Lcom/appsflyer/internal/AFc1kSDK;", "getMonetizationNetwork", "", "Z", "getCurrencyIso4217Code", "()Z", "()Ljava/lang/String;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFd1nSDK extends AFc1dSDK {

    /* JADX INFO: renamed from: AFAdRevenueData, reason: from kotlin metadata */
    public AFc1kSDK getMonetizationNetwork;

    /* JADX INFO: renamed from: component4, reason: from kotlin metadata */
    private final AFd1hSDK getRevenue;

    /* JADX INFO: renamed from: getRevenue, reason: from kotlin metadata */
    private final boolean AFAdRevenueData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AFd1nSDK(AFc1kSDK aFc1kSDK, byte[] bArr) {
        this(aFc1kSDK, bArr, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(bArr, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AFd1nSDK(AFc1kSDK aFc1kSDK, byte[] bArr, Map<String, String> map, int i) {
        super(bArr, map, i);
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        this.getMonetizationNetwork = aFc1kSDK;
        this.getRevenue = AFd1hSDK.OCTET_STREAM;
    }

    public /* synthetic */ AFd1nSDK(AFc1kSDK aFc1kSDK, byte[] bArr, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1kSDK, bArr, (i2 & 4) != 0 ? null : map, (i2 & 8) != 0 ? 2000 : i);
    }

    @Override // com.appsflyer.internal.AFc1dSDK
    /* JADX INFO: renamed from: AFAdRevenueData, reason: from getter */
    public final AFd1hSDK getGetRevenue() {
        return this.getRevenue;
    }

    @Override // com.appsflyer.internal.AFc1dSDK
    /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: from getter */
    public final boolean getAFAdRevenueData() {
        return this.AFAdRevenueData;
    }

    @Override // com.appsflyer.internal.AFc1dSDK
    public final String getMediationNetwork(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return "[RD]: " + str;
    }

    @Override // com.appsflyer.internal.AFc1dSDK
    public final String getMonetizationNetwork() {
        AFj1kSDK aFj1kSDK = new AFj1kSDK(this.getMonetizationNetwork, null, 2, null);
        return aFj1kSDK.AFAdRevenueData(aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.areAllFieldsValid));
    }
}
