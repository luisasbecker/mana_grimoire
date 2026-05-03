package com.segment.analytics.kotlin.core.platform.plugins.logger;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;", "", "(Ljava/lang/String;I)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "ERROR", "WARNING", "DEBUG", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum LogKind {
    ERROR,
    WARNING,
    DEBUG;

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogKind.values().length];
            try {
                iArr[LogKind.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogKind.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogKind.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "ERROR";
        }
        if (i == 2) {
            return HttpHeaders.WARNING;
        }
        if (i == 3) {
            return "Debug";
        }
        throw new NoWhenBranchMatchedException();
    }
}
