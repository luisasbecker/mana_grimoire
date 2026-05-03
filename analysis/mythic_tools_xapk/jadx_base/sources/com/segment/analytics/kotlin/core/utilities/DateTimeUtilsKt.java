package com.segment.analytics.kotlin.core.utilities;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: DateTimeUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"dateTimeNowString", "", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateTimeUtilsKt {
    @Deprecated(message = "Please use SegmentInstant.now() instead", replaceWith = @ReplaceWith(expression = "SegmentInstant.now()", imports = {}))
    public static final String dateTimeNowString() {
        return SegmentInstant.INSTANCE.now();
    }
}
