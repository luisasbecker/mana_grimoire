package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\u008a\u0004¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\u008a\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0019\u001a/\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001c\u001a\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0082\u0080\u0004\u001a\u000e\u0010\u001f\u001a\u00020\u0014*\u00020\u0006H\u0083\u0088\u0004\u001a\u000e\u0010 \u001a\u00020\u0014*\u00020\u0006H\u0083\u0088\u0004\u001a\u001a\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0083\u0088\u0004\u001a&\u0010$\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u0016\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a!\u0010'\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u0012H\u0083\u0088\u0004¢\u0006\u0002\u0010)\u001a'\u0010*\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,H\u0082\u0088\u0004¢\u0006\u0004\b-\u0010.\u001a\u0018\u0010/\u001a\u0004\u0018\u00010\u0004*\u00020\u00122\u0006\u00100\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0018\u00101\u001a\u0004\u0018\u00010\u0004*\u00020\u00122\u0006\u00100\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u000e\u0010=\u001a\u00020\u0006*\u00020\u0006H\u0083\u0088\u0004\u001a\u000e\u0010=\u001a\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004\u001a\u0012\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0082\u0080\u0004\u001a\u0012\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0006H\u0082\u0080\u0004\u001a\u0017\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001a\u0017\u0010Q\u001a\u00020\u00012\u0006\u0010R\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001a\u001f\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010V\u001a\u0017\u0010W\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001a\u0017\u0010X\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\"\u001f\u00102\u001a\u00020\b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0019\u00107\u001a\u00020\u0006*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0019\u0010:\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b;\u0010<\"\u000f\u0010>\u001a\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010?\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010@\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010A\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010B\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010C\u001a\u00020\u0006X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010D\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010E\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010F\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010G\u001a\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010H\u001a\u00020\u0012X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010I\u001a\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", TypedValues.TransitionType.S_DURATION, "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", "other", "isInfiniteMillis", "isFiniteMillis", "sameSign", "a", "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lkotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", "start", "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DurationKt {
    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* JADX INFO: compiled from: Duration.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long addMillisWithoutOverflow(long j, long j2) {
        return (j == 4611686018427387903L || j == -4611686018427387903L) ? ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) ? Duration.INVALID_RAW_VALUE : j : (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : RangesKt.coerceIn(j + j2, -4611686018427387903L, 4611686018427387903L);
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        char cCharAt2 = i < StringsKt.getLastIndex(str) ? str.charAt(i + 1) : (char) 0;
        if (cCharAt == 'd') {
            return DurationUnit.DAYS;
        }
        if (cCharAt == 'h') {
            return DurationUnit.HOURS;
        }
        if (cCharAt == 's') {
            return DurationUnit.SECONDS;
        }
        if (cCharAt == 'u') {
            if (cCharAt2 == 's') {
                return DurationUnit.MICROSECONDS;
            }
            return null;
        }
        if (cCharAt == 'm') {
            return cCharAt2 == 's' ? DurationUnit.MILLISECONDS : DurationUnit.MINUTES;
        }
        if (cCharAt == 'n' && cCharAt2 == 's') {
            return DurationUnit.NANOSECONDS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j, int i) {
        return Duration.INSTANCE.m12887fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j) {
        return Duration.INSTANCE.m12887fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L)) : durationOfNanos(millisToNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j) {
        return Duration.INSTANCE.m12887fromRawValueUwyO8pc$kotlin_stdlib(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j) {
        return (-4611686018426999999L > j || j >= 4611686018427000000L) ? durationOfMillis(nanosToMillis(j)) : durationOfNanos(j);
    }

    private static final long fractionDigitsToNanos(long j, DurationUnit durationUnit) {
        return MathKt.roundToLong(j * getFractionMultiplier(durationUnit));
    }

    private static final long getFallbackFractionMultiplier(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i == 5) {
            return 60000000000L;
        }
        if (i == 6) {
            return 3600000000000L;
        }
        if (i == 7) {
            return 86400000000000L;
        }
        throw new IllegalStateException(("Invalid unit: " + durationUnit + " for fallback fraction multiplier").toString());
    }

    private static final double getFractionMultiplier(DurationUnit durationUnit) {
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case 7:
                return 0.0864d;
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }

    private static /* synthetic */ void getFractionMultiplier$annotations(DurationUnit durationUnit) {
    }

    private static final int getShortNameLength(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? 2 : 1;
    }

    private static final long handleError(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
    }

    static /* synthetic */ long handleError$default(boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
    }

    private static final boolean isFiniteMillis(long j) {
        return -4611686018427387903L < j && j < 4611686018427387903L;
    }

    private static final boolean isInfiniteMillis(long j) {
        return j == 4611686018427387903L || j == -4611686018427387903L;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'D') {
            return DurationUnit.DAYS;
        }
        if (cCharAt == 'H') {
            return DurationUnit.HOURS;
        }
        if (cCharAt == 'M') {
            return DurationUnit.MINUTES;
        }
        if (cCharAt != 'S') {
            return null;
        }
        return DurationUnit.SECONDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    private static final int multiplyBy10(int i) {
        return (i << 3) + (i << 1);
    }

    private static final long multiplyBy10(long j) {
        return (j << 3) + (j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j) {
        return j / 1000000;
    }

    /* JADX INFO: renamed from: onInvalid-ge6A_vg, reason: not valid java name */
    private static final Duration m12896onInvalidge6A_vg(long j, Function0<Duration> function0) {
        return Duration.m12801equalsimpl0(j, Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib()) ? function0.invoke() : Duration.m12794boximpl(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x018e, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0191, code lost:
    
        if (r10 == r4) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0193, code lost:
    
        if (r10 != r1) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0196, code lost:
    
        r2 = (((long) r14) * androidx.media3.common.C.NANOS_PER_SECOND) + ((long) r12);
        r4 = r13;
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a0, code lost:
    
        if (r28 != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01a8, code lost:
    
        return kotlin.time.Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01ae, code lost:
    
        throw new java.lang.IllegalArgumentException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01af, code lost:
    
        r22 = r2;
        r4 = -1;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b5, code lost:
    
        r10 = defaultDurationUnitByShortNameOrNull(r25, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01b9, code lost:
    
        if (r10 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01bb, code lost:
    
        r0 = "Unknown duration unit short name: " + r25.charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ce, code lost:
    
        if (r28 != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d6, code lost:
    
        return kotlin.time.Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01dc, code lost:
    
        throw new java.lang.IllegalArgumentException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01dd, code lost:
    
        if (r7 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01e6, code lost:
    
        if (r7.compareTo(r10) > 0) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01e8, code lost:
    
        if (r28 != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01f0, code lost:
    
        return kotlin.time.Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01f8, code lost:
    
        throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01f9, code lost:
    
        r7 = kotlin.time.DurationKt.WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0203, code lost:
    
        if (r7 == 1) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0206, code lost:
    
        if (r7 == 2) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0208, code lost:
    
        r8 = addMillisWithoutOverflow(r8, kotlin.time.DurationUnitKt.convertDurationUnitToMilliseconds(r5, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0212, code lost:
    
        r8 = r8 + (r5 / 1000000);
        r5 = r19 + (r5 % 1000000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x021c, code lost:
    
        r19 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x021f, code lost:
    
        r8 = r8 + (r5 / 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x022c, code lost:
    
        if (r8 > kotlin.time.DurationKt.MAX_NANOS_IN_MILLIS) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x022e, code lost:
    
        r5 = (r5 % 1000) * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0231, code lost:
    
        r5 = getShortNameLength(r10) + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0236, code lost:
    
        if (r22 == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0238, code lost:
    
        if (r5 >= r1) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x023a, code lost:
    
        if (r28 != false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0242, code lost:
    
        return kotlin.time.Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x024a, code lost:
    
        throw new java.lang.IllegalArgumentException("Fractional component must be last");
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0253, code lost:
    
        if (r10.compareTo(kotlin.time.DurationUnit.MINUTES) < 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0259, code lost:
    
        if ((r5 - r4) <= 15) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x025b, code lost:
    
        r2 = parseFractionFallback(r25, r4, r5 - getShortNameLength(r10), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0266, code lost:
    
        r2 = fractionDigitsToNanos(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x026a, code lost:
    
        r7 = r10;
        r4 = r18;
        r12 = false;
        r10 = r19 + r2;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0274, code lost:
    
        r2 = r5;
        r7 = r10;
        r4 = r18;
        r10 = r19;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x027d, code lost:
    
        if (r28 != false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0285, code lost:
    
        return kotlin.time.Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x028b, code lost:
    
        throw new java.lang.IllegalArgumentException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f0, code lost:
    
        r19 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f2, code lost:
    
        if (r13 == r2) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f4, code lost:
    
        if (r13 == r1) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fc, code lost:
    
        if (r25.charAt(r13) != '.') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fe, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0101, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0102, code lost:
    
        if (r2 == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0104, code lost:
    
        r4 = r13 + 1;
        r10 = kotlin.time.FractionalParser.INSTANCE;
        r10 = java.lang.Math.min(r13 + 7, r25.length());
        r11 = r4;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0114, code lost:
    
        if (r11 >= r10) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0116, code lost:
    
        r12 = r25.charAt(r11);
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x011e, code lost:
    
        if ('0' > r12) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0120, code lost:
    
        if (r12 >= ':') goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0122, code lost:
    
        r14 = ((r14 << 3) + (r14 << 1)) + (r12 - '0');
        r11 = r11 + 1;
        r2 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0130, code lost:
    
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0132, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0137, code lost:
    
        if (r10 >= (6 - (r11 - r4))) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0139, code lost:
    
        r14 = (r14 << 1) + (r14 << 3);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0141, code lost:
    
        r2 = java.lang.Math.min(r11 + 9, r25.length());
        r10 = r11;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x014d, code lost:
    
        if (r10 >= r2) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014f, code lost:
    
        r23 = r2;
        r2 = r25.charAt(r10);
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0159, code lost:
    
        if ('0' > r2) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x015b, code lost:
    
        if (r2 >= ':') goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
    
        r12 = ((r12 << 3) + (r12 << 1)) + (r2 - '0');
        r10 = r24 + 1;
        r2 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x016b, code lost:
    
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x016d, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0172, code lost:
    
        if (r10 >= (9 - (r24 - r11))) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0174, code lost:
    
        r12 = (r12 << 1) + (r12 << 3);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x017c, code lost:
    
        r10 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0182, code lost:
    
        if (r10 >= r25.length()) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0184, code lost:
    
        r2 = r25.charAt(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x018a, code lost:
    
        if ('0' > r2) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x018c, code lost:
    
        if (r2 >= ':') goto L199;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseDefaultStringFormat(String str, int i, boolean z, boolean z2) {
        boolean z3;
        int i2;
        boolean z4;
        char cCharAt;
        char cCharAt2;
        int length = str.length();
        boolean z5 = !z;
        if (z && str.charAt(i) == '(' && str.charAt(length - 1) == ')') {
            i2 = i + 1;
            length--;
            if (i2 == length) {
                if (z2) {
                    throw new IllegalArgumentException("No components");
                }
                return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
            }
            z3 = true;
        } else {
            z3 = z5;
            i2 = i;
        }
        DurationUnit durationUnit = null;
        long jAddMillisWithoutOverflow = 0;
        long j = 0;
        boolean z6 = true;
        loop0: while (i2 < length) {
            if (!z6 && z3) {
                while (i2 < str.length() && str.charAt(i2) == ' ') {
                    i2++;
                }
            }
            LongParser longParser = LongParser.INSTANCE.getDefault();
            int i3 = (longParser.allowSign && ((cCharAt2 = str.charAt(i2)) == '+' || cCharAt2 == '-')) ? i2 + 1 : i2;
            while (i3 < str.length() && str.charAt(i3) == '0') {
                i3++;
            }
            long j2 = 0;
            while (true) {
                if (i3 >= str.length()) {
                    z4 = z3;
                    break;
                }
                char cCharAt3 = str.charAt(i3);
                z4 = z3;
                if ('0' <= cCharAt3 && cCharAt3 < ':') {
                    int i4 = cCharAt3 - '0';
                    if (j2 > longParser.overflowThreshold) {
                        break loop0;
                    }
                    long j3 = j;
                    if (j2 == longParser.overflowThreshold && i4 > longParser.lastDigitMax) {
                        break loop0;
                    }
                    j2 = ((long) i4) + (j2 << 3) + (j2 << 1);
                    i3++;
                    z3 = z4;
                    j = j3;
                } else {
                    break;
                }
            }
            while (i3 < str.length() && '0' <= (cCharAt = str.charAt(i3)) && cCharAt < ':') {
                i3++;
            }
            if (z2) {
                throw new IllegalArgumentException("");
            }
            return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
        }
        return Duration.m12825plusLRDsOJo(toDuration(jAddMillisWithoutOverflow, DurationUnit.MILLISECONDS), toDuration(j, DurationUnit.NANOSECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseDuration(String str, boolean z, boolean z2) {
        int i;
        int i2;
        long jM12888getINFINITEUwyO8pc;
        if (str.length() == 0) {
            if (z2) {
                throw new IllegalArgumentException("The string is empty");
            }
            return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '+') {
            i = cCharAt != '-' ? 0 : 1;
            i2 = i;
        } else {
            i = 0;
            i2 = 1;
        }
        boolean z3 = i2 > 0;
        if (str.length() <= i2) {
            if (z2) {
                throw new IllegalArgumentException("No components");
            }
            return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
        }
        if (str.charAt(i2) == 'P') {
            jM12888getINFINITEUwyO8pc = parseIsoStringFormat(str, i2 + 1, z2);
        } else {
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException("");
                }
                return Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib();
            }
            jM12888getINFINITEUwyO8pc = StringsKt.regionMatches(str, i2, INFINITY_STRING, 0, Math.max(str.length() - i2, 8), true) ? Duration.INSTANCE.m12888getINFINITEUwyO8pc() : parseDefaultStringFormat(str, i2, z3, z2);
        }
        return (i == 0 || Duration.m12801equalsimpl0(jM12888getINFINITEUwyO8pc, Duration.INSTANCE.m12889getINVALIDUwyO8pc$kotlin_stdlib())) ? jM12888getINFINITEUwyO8pc : Duration.m12840unaryMinusUwyO8pc(jM12888getINFINITEUwyO8pc);
    }

    static /* synthetic */ long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    private static final long parseFractionFallback(String str, int i, int i2, DurationUnit durationUnit) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return MathKt.roundToLong(Double.parseDouble(strSubstring) * getFallbackFractionMultiplier(durationUnit));
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0138  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:42:0x008a
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseIsoStringFormat(java.lang.String r23, int r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseIsoStringFormat(java.lang.String, int, boolean):long");
    }

    private static final boolean sameSign(long j, long j2) {
        return (j ^ j2) >= 0;
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m12897timeskIfJnKk(double d, long j) {
        return Duration.m12826timesUwyO8pc(j, d);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m12898timesmvk6XK0(int i, long j) {
        return Duration.m12827timesUwyO8pc(j, i);
    }

    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double dConvertDurationUnit = DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(dConvertDurationUnit)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jRoundToLong = MathKt.roundToLong(dConvertDurationUnit);
        return (-4611686018426999999L > jRoundToLong || jRoundToLong >= 4611686018427000000L) ? durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS))) : durationOfNanos(jRoundToLong);
    }

    public static final long toDuration(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(DurationUnit.SECONDS) <= 0 ? durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS)) : toDuration(i, unit);
    }

    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jConvertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        return ((-jConvertDurationUnitOverflow) > j || j > jConvertDurationUnitOverflow) ? unit.compareTo(DurationUnit.MILLISECONDS) >= 0 ? durationOfMillis(((long) MathKt.getSign(j)) * DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(j, C.TIME_UNSET)), unit)) : durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L)) : durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, unit, DurationUnit.NANOSECONDS));
    }
}
