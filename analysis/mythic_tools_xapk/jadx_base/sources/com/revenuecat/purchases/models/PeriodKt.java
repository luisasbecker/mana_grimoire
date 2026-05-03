package com.revenuecat.purchases.models;

import androidx.camera.video.AudioStats;
import com.revenuecat.purchases.models.Period;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Period.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"toPeriod", "Lkotlin/Pair;", "", "Lcom/revenuecat/purchases/models/Period$Unit;", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PeriodKt {

    /* JADX INFO: compiled from: Period.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Period.Unit> toPeriod(String str) {
        double d;
        double d2;
        double d3;
        MatchResult matchResultMatchEntire = new Regex("^P(?!$)(\\d+(?:\\.\\d+)?Y)?(\\d+(?:\\.\\d+)?M)?(\\d+(?:\\.\\d+)?W)?(\\d+(?:\\.\\d+)?D)?$").matchEntire(str);
        if (matchResultMatchEntire == null) {
            return new Pair<>(0, Period.Unit.UNKNOWN);
        }
        PeriodKt$toPeriod$1$toInt$1 periodKt$toPeriod$1$toInt$1 = new Function1<String, Integer>() { // from class: com.revenuecat.purchases.models.PeriodKt$toPeriod$1$toInt$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(String part) {
                Intrinsics.checkNotNullParameter(part, "part");
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.dropLast(part, 1));
                return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
            }
        };
        MatchResult.Destructured destructured = matchResultMatchEntire.getDestructured();
        String str2 = destructured.getMatch().getGroupValues().get(1);
        String str3 = destructured.getMatch().getGroupValues().get(2);
        String str4 = destructured.getMatch().getGroupValues().get(3);
        String str5 = destructured.getMatch().getGroupValues().get(4);
        int iIntValue = periodKt$toPeriod$1$toInt$1.invoke(str2).intValue();
        int iIntValue2 = periodKt$toPeriod$1$toInt$1.invoke(str3).intValue();
        int iIntValue3 = periodKt$toPeriod$1$toInt$1.invoke(str4).intValue();
        int iIntValue4 = periodKt$toPeriod$1$toInt$1.invoke(str5).intValue();
        Period.Unit unit = iIntValue4 > 0 ? Period.Unit.DAY : iIntValue3 > 0 ? Period.Unit.WEEK : iIntValue2 > 0 ? Period.Unit.MONTH : iIntValue > 0 ? Period.Unit.YEAR : Period.Unit.UNKNOWN;
        int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i != 1) {
            if (i == 2) {
                d2 = ((double) iIntValue) * 12.0d;
                d3 = iIntValue2;
            } else if (i == 3) {
                d2 = (((double) iIntValue) * 52.142857142857146d) + (((double) iIntValue2) * 4.345238095238096d);
                d3 = iIntValue3;
            } else if (i == 4) {
                d2 = (((double) iIntValue) * 365.0d) + (((double) iIntValue2) * 30.0d) + (((double) iIntValue3) * 7.0d);
                d3 = iIntValue4;
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            d = d2 + d3;
        } else {
            d = iIntValue;
        }
        return new Pair<>(Integer.valueOf(MathKt.roundToInt(d)), unit);
    }
}
