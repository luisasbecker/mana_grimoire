package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\b\u001a\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u000e\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\u0088\u0004¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m12902checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m12821isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.INSTANCE.m12890getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m12888getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m12903saturatingAddNuflL3o(long j, DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM12835toLongimpl = Duration.m12835toLongimpl(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m12902checkInfiniteSumDefinedPjuGub4(j, j2, jM12835toLongimpl);
        }
        if (((jM12835toLongimpl - 1) | 1) == Long.MAX_VALUE) {
            return m12904saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + jM12835toLongimpl;
        return ((j ^ j3) & (jM12835toLongimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m12904saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM12799divUwyO8pc = Duration.m12799divUwyO8pc(j2, 2);
        long jM12835toLongimpl = Duration.m12835toLongimpl(jM12799divUwyO8pc, durationUnit);
        return (1 | (jM12835toLongimpl - 1)) == Long.MAX_VALUE ? jM12835toLongimpl : m12903saturatingAddNuflL3o(m12903saturatingAddNuflL3o(j, durationUnit, jM12799divUwyO8pc), durationUnit, Duration.m12824minusLRDsOJo(j2, jM12799divUwyO8pc));
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (1 | (j2 - 1)) == Long.MAX_VALUE ? Duration.m12840unaryMinusUwyO8pc(infinityOfSign(j2)) : saturatingFiniteDiff(j, j2, unit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            return DurationKt.toDuration(j3, durationUnit);
        }
        if (durationUnit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return Duration.m12840unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        long jConvertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, durationUnit);
        long j4 = (j / jConvertDurationUnit) - (j2 / jConvertDurationUnit);
        long j5 = (j % jConvertDurationUnit) - (j2 % jConvertDurationUnit);
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m12825plusLRDsOJo(DurationKt.toDuration(j4, DurationUnit.MILLISECONDS), DurationKt.toDuration(j5, durationUnit));
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return ((j2 - 1) | 1) == Long.MAX_VALUE ? j == j2 ? Duration.INSTANCE.m12891getZEROUwyO8pc() : Duration.m12840unaryMinusUwyO8pc(infinityOfSign(j2)) : (1 | (j - 1)) == Long.MAX_VALUE ? infinityOfSign(j) : saturatingFiniteDiff(j, j2, unit);
    }
}
