package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFb1vSDK;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.samsung.android.game.cloudgame.dev.sdk.CloudDevCallback;
import com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0003¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\r\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\r\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\r\u0010\u0015J\u000f\u0010\u000e\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u000e\u0010\u0017J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u000e\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u001b*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u000b\u0010\u001cR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u000b\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0019\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u000e\u001a\u00020\u00078CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\tR\u001b\u0010\r\u001a\u00020\u00078CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u001d\u0010\tR\u0014\u0010#\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0015\u0010*\u001a\u00020\u00148BX\u0083\u0084\u0002¢\u0006\u0006\n\u0004\b*\u0010&"}, d2 = {"Lcom/appsflyer/internal/AFe1jSDK;", "Lcom/appsflyer/internal/AFe1uSDK;", "Lcom/appsflyer/internal/AFh1rSDK;", "Lcom/appsflyer/internal/AFd1zSDK;", "p0", "<init>", "(Lcom/appsflyer/internal/AFd1zSDK;)V", "", "copy", "()Z", "", "getMonetizationNetwork", "(I)Z", "getRevenue", "getMediationNetwork", "Landroid/content/Context;", "Lcom/appsflyer/internal/AFe1jSDK$AFa1vSDK;", "p1", "(Landroid/content/Context;Lcom/appsflyer/internal/AFe1jSDK$AFa1vSDK;)Z", "getCurrencyIso4217Code", "", "()J", "Lcom/appsflyer/internal/AFe1rSDK;", "()Lcom/appsflyer/internal/AFe1rSDK;", "(Landroid/content/Context;)I", "AFAdRevenueData", "", "", "(Lcom/appsflyer/internal/AFh1rSDK;Ljava/lang/String;)V", "areAllFieldsValid", "Lcom/appsflyer/internal/AFh1rSDK;", "Lcom/appsflyer/internal/AFc1fSDK;", "component2", "Lcom/appsflyer/internal/AFc1fSDK;", "Lcom/appsflyer/internal/AFc1kSDK;", "component1", "Lcom/appsflyer/internal/AFc1kSDK;", InAppPurchaseConstants.METHOD_TO_STRING, "Lkotlin/Lazy;", "Lcom/appsflyer/internal/AFc1gSDK;", "component3", "Lcom/appsflyer/internal/AFc1gSDK;", "component4", "AFa1uSDK", "AFa1vSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFe1jSDK extends AFe1uSDK<AFh1rSDK> {

    /* JADX INFO: renamed from: areAllFieldsValid, reason: from kotlin metadata */
    private final AFh1rSDK getCurrencyIso4217Code;

    /* JADX INFO: renamed from: component1, reason: from kotlin metadata */
    private final AFc1kSDK AFAdRevenueData;

    /* JADX INFO: renamed from: component2, reason: from kotlin metadata */
    private final AFc1fSDK getMonetizationNetwork;

    /* JADX INFO: renamed from: component3, reason: from kotlin metadata */
    private final AFc1gSDK component1;
    private final Lazy component4;

    /* JADX INFO: renamed from: toString, reason: from kotlin metadata */
    private final Lazy getRevenue;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¨\u0006\t"}, d2 = {"com/appsflyer/internal/components/queue/tasks/FetchAdvertisingIdTask$fetchGaidUsingSamsungSdk$1", "Lcom/samsung/android/game/cloudgame/dev/sdk/CloudDevCallback;", "onError", "", "reason", "", "onSuccess", "kinds", "", "SDK_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1tSDK implements CloudDevCallback {
        final /* synthetic */ AFa1vSDK $fetchGaidData;
        final /* synthetic */ CountDownLatch $latch;

        AFa1tSDK(AFa1vSDK aFa1vSDK, CountDownLatch countDownLatch) {
            this.$fetchGaidData = aFa1vSDK;
            this.$latch = countDownLatch;
        }

        public final void onError(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            AFg1hSDK.w$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Could not fetch GAID using CloudDevSdk: " + reason, false, 4, null);
            this.$fetchGaidData.getGaidError().append(reason).append(" |");
            this.$latch.countDown();
        }

        public final void onSuccess(Map<String, String> kinds) {
            Intrinsics.checkNotNullParameter(kinds, "kinds");
            AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "CloudDevCallback received onSuccess", false, 4, null);
            this.$fetchGaidData.setAdvertisingId(kinds.get("gaid"));
            this.$latch.countDown();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\f\b\u0002\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0012\u001a\u00060\u0007j\u0002`\bHÇ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J@\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\b\u0002\u0010\t\u001a\u00060\u0007j\u0002`\bHÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001c\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010 R\"\u0010\u0006\u001a\u00020\u00048\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010$R\u001e\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010\u0013R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b(\u0010)"}, d2 = {"Lcom/appsflyer/internal/AFe1jSDK$AFa1vSDK;", "", "", "advertisingId", "", "isLimitAdTrackingEnabled", "advertisingIdWithGps", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "gaidError", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/StringBuilder;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Boolean;", "component3", "()Z", "component4", "()Ljava/lang/StringBuilder;", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/StringBuilder;)Lcom/appsflyer/internal/AFe1jSDK$AFa1vSDK;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "Ljava/lang/String;", "getAdvertisingId", "setAdvertisingId", "(Ljava/lang/String;)V", "Z", "getAdvertisingIdWithGps", "setAdvertisingIdWithGps", "(Z)V", "Ljava/lang/StringBuilder;", "getGaidError", "Ljava/lang/Boolean;", "setLimitAdTrackingEnabled", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class AFa1vSDK {
        private String advertisingId;
        private boolean advertisingIdWithGps;
        private final StringBuilder gaidError;
        private Boolean isLimitAdTrackingEnabled;

        public AFa1vSDK() {
            this(null, null, false, null, 15, null);
        }

        public AFa1vSDK(String str, Boolean bool, boolean z, StringBuilder gaidError) {
            Intrinsics.checkNotNullParameter(gaidError, "gaidError");
            this.advertisingId = str;
            this.isLimitAdTrackingEnabled = bool;
            this.advertisingIdWithGps = z;
            this.gaidError = gaidError;
        }

        public /* synthetic */ AFa1vSDK(String str, Boolean bool, boolean z, StringBuilder sb, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new StringBuilder() : sb);
        }

        public static /* synthetic */ AFa1vSDK copy$default(AFa1vSDK aFa1vSDK, String str, Boolean bool, boolean z, StringBuilder sb, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aFa1vSDK.advertisingId;
            }
            if ((i & 2) != 0) {
                bool = aFa1vSDK.isLimitAdTrackingEnabled;
            }
            if ((i & 4) != 0) {
                z = aFa1vSDK.advertisingIdWithGps;
            }
            if ((i & 8) != 0) {
                sb = aFa1vSDK.gaidError;
            }
            return aFa1vSDK.copy(str, bool, z, sb);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAdvertisingId() {
            return this.advertisingId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsLimitAdTrackingEnabled() {
            return this.isLimitAdTrackingEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAdvertisingIdWithGps() {
            return this.advertisingIdWithGps;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StringBuilder getGaidError() {
            return this.gaidError;
        }

        public final AFa1vSDK copy(String advertisingId, Boolean isLimitAdTrackingEnabled, boolean advertisingIdWithGps, StringBuilder gaidError) {
            Intrinsics.checkNotNullParameter(gaidError, "gaidError");
            return new AFa1vSDK(advertisingId, isLimitAdTrackingEnabled, advertisingIdWithGps, gaidError);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AFa1vSDK)) {
                return false;
            }
            AFa1vSDK aFa1vSDK = (AFa1vSDK) other;
            return Intrinsics.areEqual(this.advertisingId, aFa1vSDK.advertisingId) && Intrinsics.areEqual(this.isLimitAdTrackingEnabled, aFa1vSDK.isLimitAdTrackingEnabled) && this.advertisingIdWithGps == aFa1vSDK.advertisingIdWithGps && Intrinsics.areEqual(this.gaidError, aFa1vSDK.gaidError);
        }

        public final String getAdvertisingId() {
            return this.advertisingId;
        }

        public final boolean getAdvertisingIdWithGps() {
            return this.advertisingIdWithGps;
        }

        public final StringBuilder getGaidError() {
            return this.gaidError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            String str = this.advertisingId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.isLimitAdTrackingEnabled;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            boolean z = this.advertisingIdWithGps;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode2 + r1) * 31) + this.gaidError.hashCode();
        }

        public final Boolean isLimitAdTrackingEnabled() {
            return this.isLimitAdTrackingEnabled;
        }

        public final void setAdvertisingId(String str) {
            this.advertisingId = str;
        }

        public final void setAdvertisingIdWithGps(boolean z) {
            this.advertisingIdWithGps = z;
        }

        public final void setLimitAdTrackingEnabled(Boolean bool) {
            this.isLimitAdTrackingEnabled = bool;
        }

        public final String toString() {
            return "FetchGaidData(advertisingId=" + this.advertisingId + ", isLimitAdTrackingEnabled=" + this.isLimitAdTrackingEnabled + ", advertisingIdWithGps=" + this.advertisingIdWithGps + ", gaidError=" + ((Object) this.gaidError) + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1jSDK(AFd1zSDK aFd1zSDK) {
        super(AFe1lSDK.FETCH_ADVERTISING_ID, new AFe1lSDK[0], "FetchAdvertisingIdTask");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        AFc1fSDK aFc1fSDKRegisterClient = aFd1zSDK.registerClient();
        Intrinsics.checkNotNullExpressionValue(aFc1fSDKRegisterClient, "");
        this.getMonetizationNetwork = aFc1fSDKRegisterClient;
        AFc1kSDK aFc1kSDKAFAdRevenueData = aFd1zSDK.AFAdRevenueData();
        Intrinsics.checkNotNullExpressionValue(aFc1kSDKAFAdRevenueData, "");
        this.AFAdRevenueData = aFc1kSDKAFAdRevenueData;
        AFc1gSDK aFc1gSDKE = aFd1zSDK.e();
        Intrinsics.checkNotNullExpressionValue(aFc1gSDKE, "");
        this.component1 = aFc1gSDKE;
        this.getCurrencyIso4217Code = new AFh1rSDK(null, null, null, null, null, null, null, null, 255, null);
        this.component4 = LazyKt.lazy(new Function0<Long>() { // from class: com.appsflyer.internal.AFe1jSDK.3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Long longOrNull;
                String monetizationNetwork = AFe1jSDK.this.AFAdRevenueData.getMonetizationNetwork("com.appsflyer.fetch_ids.timeout");
                return Long.valueOf((monetizationNetwork == null || (longOrNull = StringsKt.toLongOrNull(monetizationNetwork)) == null) ? 1000L : longOrNull.longValue());
            }
        });
        this.getRevenue = LazyKt.lazy(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFe1jSDK.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(Boolean.parseBoolean(AFe1jSDK.this.AFAdRevenueData.getMonetizationNetwork("com.appsflyer.enable_instant_plays")));
            }
        });
    }

    private final boolean areAllFieldsValid() {
        return ((Boolean) this.getRevenue.getValue()).booleanValue();
    }

    private static boolean component1() {
        String str;
        try {
            Class.forName("com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk");
            return true;
        } catch (Throwable th) {
            if (th instanceof ClassNotFoundException) {
                str = "CloudDevSdk not found";
            } else {
                str = "Unexpected exception while checking if running in cloud environment: " + th.getMessage();
            }
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, str, th, true, false, false, false, 112, null);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[LOOP:0: B:3:0x0003->B:15:0x004b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[EDGE_INSN: B:19:0x004e->B:16:0x004e BREAK  A[LOOP:0: B:3:0x0003->B:15:0x004b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean copy() {
        boolean z = false;
        for (int i = 2; i > 0; i--) {
            if (areAllFieldsValid() && getMediationNetwork(i)) {
                AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "GAID fetched using Samsung Cloud dev SDK", false, 4, null);
            } else if (!getMonetizationNetwork(i)) {
                AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Failed to fetch GAID", false, 4, null);
                z = false;
                if (!z) {
                    break;
                }
            } else {
                AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "GAID fetched using GMS", false, 4, null);
            }
            z = true;
            if (!z) {
            }
        }
        this.component1.component2 = this.getCurrencyIso4217Code;
        return z;
    }

    private final boolean getCurrencyIso4217Code(Context p0, AFa1vSDK p1) throws IllegalStateException {
        Unit unit;
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(p0);
            if (advertisingIdInfo != null) {
                p1.setAdvertisingId(advertisingIdInfo.getId());
                p1.setLimitAdTrackingEnabled(Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
                p1.setAdvertisingIdWithGps(true);
                String advertisingId = p1.getAdvertisingId();
                if (advertisingId == null || advertisingId.length() == 0) {
                    p1.getGaidError().append("emptyOrNull |");
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return true;
            }
            AFe1jSDK aFe1jSDK = this;
            p1.getGaidError().append("gpsAdInfo-null |");
            throw new IllegalStateException("GpsAdIndo is null".toString());
        } catch (Throwable th) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Google Play Services is missing " + th.getMessage(), th, false, false, false, false, 88, null);
            p1.getGaidError().append(th.getClass().getSimpleName()).append(" |");
            AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "WARNING: Google Play Services is missing.", false, 4, null);
            return false;
        }
    }

    private static int getMediationNetwork(Context p0) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(p0);
        } catch (Throwable th) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "isGooglePlayServicesAvailable error", th, false, false, false, false, 96, null);
            return -1;
        }
    }

    private final boolean getMediationNetwork(int p0) {
        return getRevenue(p0);
    }

    private static void getMonetizationNetwork(AFh1rSDK aFh1rSDK, String str) {
        String str2;
        if (str == null) {
            return;
        }
        String str3 = aFh1rSDK.getCurrencyIso4217Code;
        if (str3 != null && (str2 = str3 + " | " + str) != null) {
            str = str2;
        }
        aFh1rSDK.getCurrencyIso4217Code = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean getMonetizationNetwork(int p0) {
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Trying to fetch GAID...", false, 4, null);
        AFa1vSDK aFa1vSDK = new AFa1vSDK(null, null, false, null, 15, null);
        Context context = this.getMonetizationNetwork.getCurrencyIso4217Code;
        Intrinsics.checkNotNull(context);
        int mediationNetwork = getMediationNetwork(context);
        Context context2 = this.getMonetizationNetwork.getCurrencyIso4217Code;
        Intrinsics.checkNotNull(context2);
        if (!getCurrencyIso4217Code(context2, aFa1vSDK)) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, true)) {
                Context context3 = this.getMonetizationNetwork.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context3);
                boolean z = getRevenue(context3, aFa1vSDK);
                String string = aFa1vSDK.getGaidError().toString();
                String str = string;
                if (str != null && !StringsKt.isBlank(str)) {
                    string = mediationNetwork + ": " + StringsKt.trim((CharSequence) str).toString();
                }
                getMonetizationNetwork(this.getCurrencyIso4217Code, string);
                if (!z) {
                    return false;
                }
            }
        }
        AFh1rSDK aFh1rSDK = this.getCurrencyIso4217Code;
        aFh1rSDK.AFAdRevenueData = aFa1vSDK.getAdvertisingId();
        aFh1rSDK.component4 = aFa1vSDK.isLimitAdTrackingEnabled();
        aFh1rSDK.getMediationNetwork = aFa1vSDK.isLimitAdTrackingEnabled() != null ? Boolean.valueOf(!r0.booleanValue()) : null;
        aFh1rSDK.getMonetizationNetwork = Boolean.valueOf(aFa1vSDK.getAdvertisingIdWithGps());
        aFh1rSDK.getRevenue = Boolean.FALSE;
        aFh1rSDK.component2 = Boolean.valueOf(p0 != 2);
        return true;
    }

    private final boolean getRevenue(int p0) {
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Trying to fetch GAID using Samsung Cloud Dev...", false, 4, null);
        if (component1()) {
            CloudDevSdk cloudDevSdk = CloudDevSdk.INSTANCE;
            Context context = this.getMonetizationNetwork.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context);
            if (cloudDevSdk.isCloudEnvironment(context)) {
                AFa1vSDK aFa1vSDK = new AFa1vSDK(null, null, false, null, 15, null);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    CloudDevSdk cloudDevSdk2 = CloudDevSdk.INSTANCE;
                    Context context2 = this.getMonetizationNetwork.getCurrencyIso4217Code;
                    Intrinsics.checkNotNull(context2);
                    cloudDevSdk2.request(context2, CollectionsKt.listOf("gaid"), new AFa1tSDK(aFa1vSDK, countDownLatch));
                    countDownLatch.await(((Number) this.component4.getValue()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    try {
                        AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, th instanceof InterruptedException ? "Fetch GAID using Samsung Cloud Dev interrupted or reached to timeout" : th instanceof ClassNotFoundException ? "CloudDevSdk not found" : "Unexpected exception while fetching GAID using Samsung Cloud Dev " + th.getMessage(), th, true, false, false, false, 112, null);
                        aFa1vSDK.getGaidError().append(th.getClass().getSimpleName()).append(" |");
                        if (aFa1vSDK.getGaidError().length() > 0) {
                        }
                    } finally {
                        if (aFa1vSDK.getGaidError().length() > 0) {
                            getMonetizationNetwork(this.getCurrencyIso4217Code, aFa1vSDK.getGaidError().toString());
                        }
                    }
                }
                String advertisingId = aFa1vSDK.getAdvertisingId();
                if (advertisingId == null || advertisingId.length() == 0) {
                    return false;
                }
                AFh1rSDK aFh1rSDK = this.getCurrencyIso4217Code;
                aFh1rSDK.AFAdRevenueData = aFa1vSDK.getAdvertisingId();
                aFh1rSDK.component4 = Boolean.FALSE;
                aFh1rSDK.getMediationNetwork = Boolean.TRUE;
                aFh1rSDK.getMonetizationNetwork = Boolean.FALSE;
                aFh1rSDK.getRevenue = Boolean.TRUE;
                aFh1rSDK.component2 = Boolean.valueOf(p0 != 2);
                return true;
            }
        }
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Not running in Samsung Cloud Environment. Try using GMS...", false, 4, null);
        return false;
    }

    private final boolean getRevenue(Context p0, AFa1vSDK p1) throws IllegalStateException {
        try {
            AFb1vSDK.AFa1vSDK mediationNetwork = AFb1vSDK.getMediationNetwork(p0);
            p1.setAdvertisingId(mediationNetwork.getCurrencyIso4217Code);
            p1.setLimitAdTrackingEnabled(Boolean.valueOf(mediationNetwork.AFAdRevenueData()));
            String advertisingId = p1.getAdvertisingId();
            if (advertisingId == null || advertisingId.length() == 0) {
                p1.getGaidError().append("emptyOrNull (bypass) |");
            }
            if (Unit.INSTANCE != null) {
                return true;
            }
            AFe1jSDK aFe1jSDK = this;
            p1.getGaidError().append("gpsAdInfo-null (bypass) |");
            throw new IllegalStateException("GpsAdInfo is null (bypass)".toString());
        } catch (Throwable th) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "Failed to fetch GAID: " + th.getMessage(), th, true, false, false, false, 64, null);
            p1.getGaidError().append(th.getClass().getSimpleName()).append(" |");
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = th.toString();
            }
            AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, localizedMessage, false, 4, null);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final AFe1rSDK getMediationNetwork() {
        if (this.component1.AFAdRevenueData()) {
            AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "QUEUE: Advertising ID collection is disabled. Skipping fetching... ", false, 4, null);
            return AFe1rSDK.FAILURE;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AFe1rSDK aFe1rSDK = CollectionsKt.listOf((Object[]) new Boolean[]{Boolean.valueOf(copy()), Boolean.FALSE, Boolean.FALSE}).contains(Boolean.TRUE) ? AFe1rSDK.SUCCESS : AFe1rSDK.FAILURE;
        AFc1gSDK aFc1gSDK = this.component1;
        AFd1dSDK aFd1dSDK = new AFd1dSDK(System.currentTimeMillis() - jCurrentTimeMillis);
        AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "QUEUE: FetchAdvertisingIdTask: took " + aFd1dSDK.AFAdRevenueData + "ms", false, 4, null);
        aFc1gSDK.getRevenue(aFd1dSDK);
        return aFe1rSDK;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return ((Number) this.component4.getValue()).longValue();
    }
}
