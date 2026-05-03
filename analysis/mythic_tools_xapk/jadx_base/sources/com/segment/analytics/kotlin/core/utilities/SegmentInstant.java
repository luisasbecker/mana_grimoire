package com.segment.analytics.kotlin.core.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DateTimeUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/SegmentInstant;", "", "()V", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentInstant {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SegmentInstant$Companion$formatters$1 formatters = new ThreadLocal<SimpleDateFormat>() { // from class: com.segment.analytics.kotlin.core.utilities.SegmentInstant$Companion$formatters$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSSzzz", Locale.ROOT);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    /* JADX INFO: compiled from: DateTimeUtils.kt */
    @Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0006\u0010\u000b\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/SegmentInstant$Companion;", "", "()V", "formatters", "com/segment/analytics/kotlin/core/utilities/SegmentInstant$Companion$formatters$1", "Lcom/segment/analytics/kotlin/core/utilities/SegmentInstant$Companion$formatters$1;", "from", "", "date", "Ljava/util/Date;", "from$core", "now", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String from$core(Date date) {
            Intrinsics.checkNotNullParameter(date, "date");
            String str = SegmentInstant.formatters.get().format(date);
            Intrinsics.checkNotNullExpressionValue(str, "formatters.get().format(date)");
            return StringsKt.replace$default(str, "UTC", "Z", false, 4, (Object) null);
        }

        public final String now() {
            return from$core(new Date());
        }
    }
}
