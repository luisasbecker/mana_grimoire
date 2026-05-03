package io.customer.datapipelines.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SegmentInstantFormatter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/customer/datapipelines/util/SegmentInstantFormatter;", "", "<init>", "()V", "Companion", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SegmentInstantFormatter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SegmentInstantFormatter$Companion$formatters$1 formatters = new ThreadLocal<SimpleDateFormat>() { // from class: io.customer.datapipelines.util.SegmentInstantFormatter$Companion$formatters$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSSzzz", Locale.ROOT);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    /* JADX INFO: compiled from: SegmentInstantFormatter.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/customer/datapipelines/util/SegmentInstantFormatter$Companion;", "", "<init>", "()V", "formatters", "io/customer/datapipelines/util/SegmentInstantFormatter$Companion$formatters$1", "Lio/customer/datapipelines/util/SegmentInstantFormatter$Companion$formatters$1;", "from", "", "unixTimestamp", "", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String from(long unixTimestamp) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                SimpleDateFormat simpleDateFormat = SegmentInstantFormatter.formatters.get();
                if (simpleDateFormat == null) {
                    return null;
                }
                Date date = new Date();
                date.setTime(TimeUnit.SECONDS.toMillis(unixTimestamp));
                String str = simpleDateFormat.format(date);
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return StringsKt.replace$default(str, "UTC", "Z", false, 4, (Object) null);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                Object objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
                return (String) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
            }
        }
    }
}
