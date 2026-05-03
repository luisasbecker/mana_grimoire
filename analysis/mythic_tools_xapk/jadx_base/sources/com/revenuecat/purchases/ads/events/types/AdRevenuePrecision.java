package com.revenuecat.purchases.ads.events.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdRevenuePrecision.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRevenuePrecision;", "", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class AdRevenuePrecision {
    private final String value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXACT = m10319constructorimpl("exact");
    private static final String PUBLISHER_DEFINED = m10319constructorimpl("publisher_defined");
    private static final String ESTIMATED = m10319constructorimpl("estimated");
    private static final String UNKNOWN = m10319constructorimpl("unknown");

    /* JADX INFO: compiled from: AdRevenuePrecision.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRevenuePrecision$Companion;", "", "()V", "ESTIMATED", "Lcom/revenuecat/purchases/ads/events/types/AdRevenuePrecision;", "getESTIMATED-rAcPn4k", "()Ljava/lang/String;", "Ljava/lang/String;", "EXACT", "getEXACT-rAcPn4k", "PUBLISHER_DEFINED", "getPUBLISHER_DEFINED-rAcPn4k", "UNKNOWN", "getUNKNOWN-rAcPn4k", "fromString", "value", "", "fromString-QAIqrgA", "(Ljava/lang/String;)Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX INFO: renamed from: fromString-QAIqrgA, reason: not valid java name */
        public final String m10325fromStringQAIqrgA(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) lowerCase).toString();
            switch (string.hashCode()) {
                case -623607748:
                    if (string.equals("estimated")) {
                        return m10326getESTIMATEDrAcPn4k();
                    }
                    break;
                case -284840886:
                    if (string.equals("unknown")) {
                        return m10329getUNKNOWNrAcPn4k();
                    }
                    break;
                case 96946943:
                    if (string.equals("exact")) {
                        return m10327getEXACTrAcPn4k();
                    }
                    break;
                case 655944390:
                    if (string.equals("publisher_defined")) {
                        return m10328getPUBLISHER_DEFINEDrAcPn4k();
                    }
                    break;
            }
            return AdRevenuePrecision.m10319constructorimpl(value);
        }

        /* JADX INFO: renamed from: getESTIMATED-rAcPn4k, reason: not valid java name */
        public final String m10326getESTIMATEDrAcPn4k() {
            return AdRevenuePrecision.ESTIMATED;
        }

        /* JADX INFO: renamed from: getEXACT-rAcPn4k, reason: not valid java name */
        public final String m10327getEXACTrAcPn4k() {
            return AdRevenuePrecision.EXACT;
        }

        /* JADX INFO: renamed from: getPUBLISHER_DEFINED-rAcPn4k, reason: not valid java name */
        public final String m10328getPUBLISHER_DEFINEDrAcPn4k() {
            return AdRevenuePrecision.PUBLISHER_DEFINED;
        }

        /* JADX INFO: renamed from: getUNKNOWN-rAcPn4k, reason: not valid java name */
        public final String m10329getUNKNOWNrAcPn4k() {
            return AdRevenuePrecision.UNKNOWN;
        }
    }

    private /* synthetic */ AdRevenuePrecision(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdRevenuePrecision m10318boximpl(String str) {
        return new AdRevenuePrecision(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m10319constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m10320equalsimpl(String str, Object obj) {
        return (obj instanceof AdRevenuePrecision) && Intrinsics.areEqual(str, ((AdRevenuePrecision) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m10321equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m10322hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m10323toStringimpl(String str) {
        return "AdRevenuePrecision(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m10320equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m10322hashCodeimpl(this.value);
    }

    public String toString() {
        return m10323toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ String getValue() {
        return this.value;
    }
}
