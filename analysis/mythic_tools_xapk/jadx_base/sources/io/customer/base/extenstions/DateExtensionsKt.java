package io.customer.base.extenstions;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\u001a\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"getUnixTimestamp", "", "Ljava/util/Date;", "unixTimeToDate", "add", "unit", "", "type", "Ljava/util/concurrent/TimeUnit;", "subtract", "", "hasPassed", "", "isOlderThan", "otherDate", "base"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DateExtensionsKt {
    public static final Date add(Date date, int i, TimeUnit type) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return add(date, i, type);
    }

    public static final Date add(Date date, long j, TimeUnit type) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Date(date.getTime() + type.toMillis(j));
    }

    public static final long getUnixTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
    }

    public static final boolean hasPassed(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return date.getTime() < new Date().getTime();
    }

    public static final boolean isOlderThan(Date date, Date otherDate) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(otherDate, "otherDate");
        return date.getTime() < otherDate.getTime();
    }

    public static final Date subtract(Date date, double d, TimeUnit type) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return subtract(date, (long) d, type);
    }

    public static final Date subtract(Date date, int i, TimeUnit type) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return subtract(date, i, type);
    }

    public static final Date subtract(Date date, long j, TimeUnit type) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Date(date.getTime() - type.toMillis(j));
    }

    public static final Date unixTimeToDate(long j) {
        return new Date(TimeUnit.SECONDS.toMillis(j));
    }
}
