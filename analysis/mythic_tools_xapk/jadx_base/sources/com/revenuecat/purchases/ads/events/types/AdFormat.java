package com.revenuecat.purchases.ads.events.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdFormat.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class AdFormat {
    private final String value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String OTHER = m10287constructorimpl("other");
    private static final String BANNER = m10287constructorimpl("banner");
    private static final String INTERSTITIAL = m10287constructorimpl("interstitial");
    private static final String REWARDED = m10287constructorimpl("rewarded");
    private static final String REWARDED_INTERSTITIAL = m10287constructorimpl("rewarded_interstitial");
    private static final String NATIVE = m10287constructorimpl(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    private static final String APP_OPEN = m10287constructorimpl(FirebaseAnalytics.Event.APP_OPEN);

    /* JADX INFO: compiled from: AdFormat.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdFormat$Companion;", "", "()V", "APP_OPEN", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "getAPP_OPEN-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "BANNER", "getBANNER-y0COY5Q", "INTERSTITIAL", "getINTERSTITIAL-y0COY5Q", "NATIVE", "getNATIVE-y0COY5Q", "OTHER", "getOTHER-y0COY5Q", "REWARDED", "getREWARDED-y0COY5Q", "REWARDED_INTERSTITIAL", "getREWARDED_INTERSTITIAL-y0COY5Q", "fromString", "value", "", "fromString-XxFlno4", "(Ljava/lang/String;)Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX INFO: renamed from: fromString-XxFlno4, reason: not valid java name */
        public final String m10293fromStringXxFlno4(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String string = StringsKt.trim((CharSequence) value).toString();
            switch (string.hashCode()) {
                case -1396342996:
                    if (string.equals("banner")) {
                        return m10295getBANNERy0COY5Q();
                    }
                    break;
                case -1052618729:
                    if (string.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                        return m10297getNATIVEy0COY5Q();
                    }
                    break;
                case -239580146:
                    if (string.equals("rewarded")) {
                        return m10299getREWARDEDy0COY5Q();
                    }
                    break;
                case 106069776:
                    if (string.equals("other")) {
                        return m10298getOTHERy0COY5Q();
                    }
                    break;
                case 604727084:
                    if (string.equals("interstitial")) {
                        return m10296getINTERSTITIALy0COY5Q();
                    }
                    break;
                case 1167692200:
                    if (string.equals(FirebaseAnalytics.Event.APP_OPEN)) {
                        return m10294getAPP_OPENy0COY5Q();
                    }
                    break;
                case 1911491517:
                    if (string.equals("rewarded_interstitial")) {
                        return m10300getREWARDED_INTERSTITIALy0COY5Q();
                    }
                    break;
            }
            return AdFormat.m10287constructorimpl(value);
        }

        /* JADX INFO: renamed from: getAPP_OPEN-y0COY5Q, reason: not valid java name */
        public final String m10294getAPP_OPENy0COY5Q() {
            return AdFormat.APP_OPEN;
        }

        /* JADX INFO: renamed from: getBANNER-y0COY5Q, reason: not valid java name */
        public final String m10295getBANNERy0COY5Q() {
            return AdFormat.BANNER;
        }

        /* JADX INFO: renamed from: getINTERSTITIAL-y0COY5Q, reason: not valid java name */
        public final String m10296getINTERSTITIALy0COY5Q() {
            return AdFormat.INTERSTITIAL;
        }

        /* JADX INFO: renamed from: getNATIVE-y0COY5Q, reason: not valid java name */
        public final String m10297getNATIVEy0COY5Q() {
            return AdFormat.NATIVE;
        }

        /* JADX INFO: renamed from: getOTHER-y0COY5Q, reason: not valid java name */
        public final String m10298getOTHERy0COY5Q() {
            return AdFormat.OTHER;
        }

        /* JADX INFO: renamed from: getREWARDED-y0COY5Q, reason: not valid java name */
        public final String m10299getREWARDEDy0COY5Q() {
            return AdFormat.REWARDED;
        }

        /* JADX INFO: renamed from: getREWARDED_INTERSTITIAL-y0COY5Q, reason: not valid java name */
        public final String m10300getREWARDED_INTERSTITIALy0COY5Q() {
            return AdFormat.REWARDED_INTERSTITIAL;
        }
    }

    private /* synthetic */ AdFormat(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdFormat m10286boximpl(String str) {
        return new AdFormat(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m10287constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m10288equalsimpl(String str, Object obj) {
        return (obj instanceof AdFormat) && Intrinsics.areEqual(str, ((AdFormat) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m10289equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m10290hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m10291toStringimpl(String str) {
        return "AdFormat(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m10288equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m10290hashCodeimpl(this.value);
    }

    public String toString() {
        return m10291toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ String getValue() {
        return this.value;
    }
}
