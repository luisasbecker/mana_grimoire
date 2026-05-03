package com.segment.analytics.kotlin.android;

import android.util.Log;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogKind;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogMessage;
import com.segment.analytics.kotlin.core.platform.plugins.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAnalytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/segment/analytics/kotlin/android/AndroidLogger;", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/Logger;", "()V", "parseLog", "", "log", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogMessage;", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLogger implements Logger {

    /* JADX INFO: compiled from: AndroidAnalytics.kt */
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

    @Override // com.segment.analytics.kotlin.core.platform.plugins.logger.Logger
    public void parseLog(LogMessage log) {
        Intrinsics.checkNotNullParameter(log, "log");
        int i = WhenMappings.$EnumSwitchMapping$0[log.getKind().ordinal()];
        if (i == 1) {
            Log.e("AndroidLog", "message=" + log.getMessage());
        } else if (i == 2) {
            Log.w("AndroidLog", "message=" + log.getMessage());
        } else {
            if (i != 3) {
                return;
            }
            Log.d("AndroidLog", "message=" + log.getMessage());
        }
    }
}
