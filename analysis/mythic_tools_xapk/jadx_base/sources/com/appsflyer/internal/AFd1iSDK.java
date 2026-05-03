package com.appsflyer.internal;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.appsflyer.AppsFlyerLib;
import com.google.common.net.HttpHeaders;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rBE\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFd1iSDK;", "Lcom/appsflyer/internal/AFd1cSDK;", "", "p0", "", "p1", "", "p2", "p3", "", "p4", "<init>", "(Ljava/lang/String;Ljava/util/Map;[BLjava/lang/String;Z)V", "AFa1zSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFd1iSDK extends AFd1cSDK {

    /* JADX INFO: renamed from: AFa1zSDK, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.appsflyer.internal.AFd1iSDK$AFa1zSDK, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\u0006*\u00020\u00040\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/appsflyer/internal/AFd1iSDK$AFa1zSDK;", "", "<init>", "()V", "", "p0", "p1", "p2", "p3", "p4", "getMediationNetwork", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getCurrencyIso4217Code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static String getCurrencyIso4217Code(String p0, String p1, String p2) {
            return String.format(AFd1mSDK.getRevenue, AppsFlyerLib.getInstance().getHostPrefix(), AFa1tSDK.getMediationNetwork().getHostName()) + p0 + p2 + "?device_id=" + p1;
        }

        public static String getMediationNetwork(String p0, String p1, String p2, String p3, String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            return AFj1jSDK.getCurrencyIso4217Code(TextUtils.join("\u2063", new String[]{p4, p2, p0 + p1}), p3);
        }
    }

    private AFd1iSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z) {
        super(str, bArr, str2, map, z);
    }

    /* synthetic */ AFd1iSDK(String str, Map map, byte[] bArr, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? null : bArr, (i & 8) != 0 ? ShareTarget.METHOD_GET : str2, (i & 16) != 0 ? false : z);
    }

    @JvmStatic
    public static final AFd1iSDK getMonetizationNetwork(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String currencyIso4217Code = Companion.getCurrencyIso4217Code(str, str2, str3);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        AFd1iSDK aFd1iSDK = new AFd1iSDK(currencyIso4217Code, MapsKt.mapOf(TuplesKt.to(HttpHeaders.CONNECTION, "close"), TuplesKt.to("af_request_epoch_ms", strValueOf), TuplesKt.to("af_sig", Companion.getMediationNetwork(str, str3, str2, str4, strValueOf))), null, null, false, 28, null);
        aFd1iSDK.areAllFieldsValid = 10000;
        return aFd1iSDK;
    }
}
