package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ArrayPools.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object objM11445constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objM11445constructorimpl = Result.m11445constructorimpl(property != null ? StringsKt.toIntOrNull(property) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        Integer num = (Integer) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
