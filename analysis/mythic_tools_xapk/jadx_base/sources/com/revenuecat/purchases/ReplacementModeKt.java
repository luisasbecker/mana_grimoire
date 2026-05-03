package com.revenuecat.purchases;

import com.revenuecat.purchases.models.GalaxyReplacementMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReplacementMode.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"asLegacyProrationMode", "Lcom/revenuecat/purchases/LegacyProrationMode;", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getAsLegacyProrationMode", "(Lcom/revenuecat/purchases/models/GoogleReplacementMode;)Lcom/revenuecat/purchases/LegacyProrationMode;", "backendName", "", "Lcom/revenuecat/purchases/ReplacementMode;", "getBackendName$annotations", "(Lcom/revenuecat/purchases/ReplacementMode;)V", "getBackendName", "(Lcom/revenuecat/purchases/ReplacementMode;)Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReplacementModeKt {

    /* JADX INFO: compiled from: ReplacementMode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GoogleReplacementMode.values().length];
            try {
                iArr[GoogleReplacementMode.WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GoogleReplacementMode.WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GoogleReplacementMode.DEFERRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final LegacyProrationMode getAsLegacyProrationMode(GoogleReplacementMode googleReplacementMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[googleReplacementMode.ordinal()];
        if (i == 1) {
            return LegacyProrationMode.IMMEDIATE_WITHOUT_PRORATION;
        }
        if (i == 2) {
            return LegacyProrationMode.IMMEDIATE_WITH_TIME_PRORATION;
        }
        if (i == 3) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE;
        }
        if (i == 4) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE;
        }
        if (i == 5) {
            return LegacyProrationMode.DEFERRED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getBackendName(ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(replacementMode, "<this>");
        return replacementMode instanceof GoogleReplacementMode ? getAsLegacyProrationMode((GoogleReplacementMode) replacementMode).name() : replacementMode instanceof GalaxyReplacementMode ? replacementMode.getName() : replacementMode.getName();
    }

    public static /* synthetic */ void getBackendName$annotations(ReplacementMode replacementMode) {
    }
}
