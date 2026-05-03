package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0094\u0080\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m12909overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m12836toStringimpl(duration)) + FilenameUtils.EXTENSION_SEPARATOR);
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m12910plusAssignLRDsOJo(long duration) {
        long jM12835toLongimpl = Duration.m12835toLongimpl(duration, getUnit());
        if (((jM12835toLongimpl - 1) | 1) != Long.MAX_VALUE) {
            long j = this.reading;
            long j2 = j + jM12835toLongimpl;
            if ((jM12835toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m12909overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM12799divUwyO8pc = Duration.m12799divUwyO8pc(duration, 2);
        if ((1 | (Duration.m12835toLongimpl(jM12799divUwyO8pc, getUnit()) - 1)) == Long.MAX_VALUE) {
            m12909overflowLRDsOJo(duration);
            return;
        }
        long j3 = this.reading;
        try {
            m12910plusAssignLRDsOJo(jM12799divUwyO8pc);
            m12910plusAssignLRDsOJo(Duration.m12824minusLRDsOJo(duration, jM12799divUwyO8pc));
        } catch (IllegalStateException e) {
            this.reading = j3;
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }
}
