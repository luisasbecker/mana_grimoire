package androidx.compose.material3;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u008b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b\"\u0010#J$\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+J+\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b5\u00106J=\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bC\u0010DR\u0018\u0010$\u001a\u00020\u0005*\u00020%8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u00020J¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0011\u0010N\u001a\u00020O8G¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "DatePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "DatePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DatePickerHeadline", "selectedDateMillis", "", "DatePickerHeadline-ISIPfiY", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "YearMonthSkeleton", "YearAbbrMonthDaySkeleton", "YearMonthWeekdayDaySkeleton", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(Videoio.CAP_FFMPEG, Videoio.CAP_ARAVIS);
    private static final float TonalElevation = ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM();
    private static final SelectableDates AllDates = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
    };

    private DatePickerDefaults() {
    }

    static final Unit DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8345setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8319getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerHeadline_ISIPfiY$lambda$4(DatePickerDefaults datePickerDefaults, Long l, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m3559DatePickerHeadlineISIPfiY(l, i, datePickerFormatter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerTitle_FNtVw6o$lambda$1(DatePickerDefaults datePickerDefaults, int i, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m3560DatePickerTitleFNtVw6o(i, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cb  */
    /* JADX INFO: renamed from: DatePickerHeadline-ISIPfiY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3559DatePickerHeadlineISIPfiY(Long l, final int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long headlineContentColor;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        long j3;
        Modifier modifier4;
        final Long l2 = l;
        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        Composer composerStartRestartGroup = composer.startRestartGroup(1913724796);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerHeadline)N(selectedDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color)685@33220L15,721@34641L135,718@34544L303:DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? composerStartRestartGroup.changed(datePickerFormatter2) : composerStartRestartGroup.changedInstance(datePickerFormatter2) ? 256 : 128;
        }
        int i6 = i3 & 8;
        if (i6 == 0) {
            if ((i2 & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    headlineContentColor = j;
                    int i7 = composerStartRestartGroup.changed(headlineContentColor) ? 16384 : 8192;
                    i4 |= i7;
                } else {
                    headlineContentColor = j;
                }
                i4 |= i7;
            } else {
                headlineContentColor = j;
            }
            if ((i3 & 32) == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = headlineContentColor;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "683@33160L8");
                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 16) != 0) {
                        headlineContentColor = colors(composerStartRestartGroup, (i4 >> 15) & 14).getHeadlineContentColor();
                        i4 &= -57345;
                    }
                    i5 = i4;
                    j3 = headlineContentColor;
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    i5 = i4;
                    j3 = headlineContentColor;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1913724796, i5, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:684)");
                }
                Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0);
                String date$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, localeDefaultLocale, false, 4, null);
                datePickerFormatter2 = datePickerFormatter;
                l2 = l2;
                String date = datePickerFormatter2.formatDate(l2, localeDefaultLocale, true);
                String strM4676getString2EP1pXo = "";
                if (date == null) {
                    composerStartRestartGroup.startReplaceGroup(380185931);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843549871);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "695@33650L51");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        date = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843552842);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "696@33743L46");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        date = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(380407362);
                        composerStartRestartGroup.endReplaceGroup();
                        date = "";
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(843542258);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (date$default == null) {
                    composerStartRestartGroup.startReplaceGroup(380507587);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843560257);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "703@33975L37");
                        Strings.Companion companion4 = Strings.INSTANCE;
                        date$default = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_headline), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843562784);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "704@34054L36");
                        Strings.Companion companion5 = Strings.INSTANCE;
                        date$default = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_input_headline), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(380705954);
                        composerStartRestartGroup.endReplaceGroup();
                        date$default = "";
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(843557408);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843570444);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "711@34293L48");
                    Strings.Companion companion6 = Strings.INSTANCE;
                    strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_headline_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843573323);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "712@34383L47");
                    Strings.Companion companion7 = Strings.INSTANCE;
                    strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_input_headline_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(381043234);
                    composerStartRestartGroup.endReplaceGroup();
                }
                final String str = String.format(strM4676getString2EP1pXo, Arrays.copyOf(new Object[]{date}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 843581667, "CC(remember):DatePicker.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(str);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                Modifier modifier5 = modifier4;
                TextKt.m4288TextNvy7gAk(date$default, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer2, (i5 >> 6) & 896, 24576, 245752);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j2 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$4(this.f$0, l2, i, datePickerFormatter2, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 3072;
        modifier2 = modifier;
        if ((i2 & 24576) != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DatePickerTitle-FNtVw6o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3560DatePickerTitleFNtVw6o(final int i, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j2;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j4;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-390880814);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerTitle)N(displayMode:c#material3.DisplayMode,modifier,contentColor:c#ui.graphics.Color):DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i4 |= i6;
                } else {
                    j2 = j;
                }
                i4 |= i6;
            } else {
                j2 = j;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "648@31804L8");
                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 4) != 0) {
                        long titleContentColor = colors(composerStartRestartGroup, (i4 >> 9) & 14).getTitleContentColor();
                        i4 &= -897;
                        j4 = titleContentColor;
                    } else {
                        j4 = j2;
                    }
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    j4 = j2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-390880814, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:649)");
                }
                if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(-1974299164);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "653@31952L43,652@31919L178");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    TextKt.m4288TextNvy7gAk(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_title), composerStartRestartGroup, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i4 & PointerIconCompat.TYPE_TEXT, 0, 262136);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (DisplayMode.m3607equalsimpl0(i, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                        composer2.startReplaceGroup(-1974291869);
                        ComposerKt.sourceInformation(composer2, "659@32180L42,658@32147L177");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        TextKt.m4288TextNvy7gAk(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_input_title), composer2, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i4 & PointerIconCompat.TYPE_TEXT, 0, 262136);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-1073325776);
                        composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDefaults.DatePickerTitle_FNtVw6o$lambda$1(this.f$0, i, modifier3, j3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public final DatePickerColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -275219611, "C(colors)447@19770L11,447@19782L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:447)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColors;
    }

    /* JADX INFO: renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m3561colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        TextFieldColors textFieldColors2;
        long j25;
        ComposerKt.sourceInformationMarkerStart(composer, 1991626358, "C(colors)N(containerColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,weekdayContentColor:c#ui.graphics.Color,subheadContentColor:c#ui.graphics.Color,navigationContentColor:c#ui.graphics.Color,yearContentColor:c#ui.graphics.Color,disabledYearContentColor:c#ui.graphics.Color,currentYearContentColor:c#ui.graphics.Color,selectedYearContentColor:c#ui.graphics.Color,disabledSelectedYearContentColor:c#ui.graphics.Color,selectedYearContainerColor:c#ui.graphics.Color,disabledSelectedYearContainerColor:c#ui.graphics.Color,dayContentColor:c#ui.graphics.Color,disabledDayContentColor:c#ui.graphics.Color,selectedDayContentColor:c#ui.graphics.Color,disabledSelectedDayContentColor:c#ui.graphics.Color,selectedDayContainerColor:c#ui.graphics.Color,disabledSelectedDayContainerColor:c#ui.graphics.Color,todayContentColor:c#ui.graphics.Color,todayDateBorderColor:c#ui.graphics.Color,dayInSelectionRangeContentColor:c#ui.graphics.Color,dayInSelectionRangeContainerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,dateTextFieldColors)516@24067L11,516@24079L23:DatePicker.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        long jM6361getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j6;
        long jM6361getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j7;
        long jM6361getUnspecified0d7_KjU8 = (i4 & 128) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j8;
        long jM6361getUnspecified0d7_KjU9 = (i4 & 256) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j9;
        long jM6361getUnspecified0d7_KjU10 = (i4 & 512) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j10;
        long jM6361getUnspecified0d7_KjU11 = (i4 & 1024) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j11;
        long jM6361getUnspecified0d7_KjU12 = (i4 & 2048) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j12;
        long jM6361getUnspecified0d7_KjU13 = (i4 & 4096) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j13;
        long jM6361getUnspecified0d7_KjU14 = (i4 & 8192) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j14;
        long jM6361getUnspecified0d7_KjU15 = (i4 & 16384) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j15;
        long jM6361getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j16;
        long jM6361getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j17;
        long jM6361getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j18;
        long jM6361getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j19;
        long jM6361getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j20;
        long jM6361getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j21;
        long jM6361getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j22;
        long jM6361getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j23;
        long jM6361getUnspecified0d7_KjU24 = (8388608 & i4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors3 = (i4 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            textFieldColors2 = textFieldColors3;
            j25 = jM6361getUnspecified0d7_KjU;
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:516)");
        } else {
            textFieldColors2 = textFieldColors3;
            j25 = jM6361getUnspecified0d7_KjU;
        }
        DatePickerColors datePickerColorsM3534copytNwlRmA = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i3 >> 12) & 112).m3534copytNwlRmA(j25, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, jM6361getUnspecified0d7_KjU6, jM6361getUnspecified0d7_KjU7, jM6361getUnspecified0d7_KjU8, jM6361getUnspecified0d7_KjU9, jM6361getUnspecified0d7_KjU10, jM6361getUnspecified0d7_KjU11, jM6361getUnspecified0d7_KjU12, jM6361getUnspecified0d7_KjU13, jM6361getUnspecified0d7_KjU14, jM6361getUnspecified0d7_KjU15, jM6361getUnspecified0d7_KjU16, jM6361getUnspecified0d7_KjU17, jM6361getUnspecified0d7_KjU18, jM6361getUnspecified0d7_KjU19, jM6361getUnspecified0d7_KjU20, jM6361getUnspecified0d7_KjU21, jM6361getUnspecified0d7_KjU23, jM6361getUnspecified0d7_KjU22, jM6361getUnspecified0d7_KjU24, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerColorsM3534copytNwlRmA;
    }

    public final DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        return new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1180555308, "C(<get-defaultDatePickerColors>):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:546)");
        }
        DatePickerColors defaultDatePickerColorsCached = colorScheme.getDefaultDatePickerColorsCached();
        if (defaultDatePickerColorsCached == null) {
            composer.startReplaceGroup(642416503);
            ComposerKt.sourceInformation(composer, "604@29806L30");
            DatePickerColors datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme.getOnSurfaceVariant(), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, (i & 14) | 48), null);
            colorScheme.setDefaultDatePickerColorsCached$material3(datePickerColors);
            composer.endReplaceGroup();
            defaultDatePickerColorsCached = datePickerColors;
        } else {
            composer.startReplaceGroup(642290457);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColorsCached;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 700927667, "C(<get-shape>)770@36532L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:770)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m3562getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2036003494, "C(rememberSnapFlingBehavior)N(lazyListState,decayAnimationSpec)743@35490L7,744@35513L639:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:741)");
        }
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, 1905742201, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) | composer.changed(decayAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final SnapLayoutInfoProvider snapLayoutInfoProviderSnapLayoutInfoProvider$default = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(lazyListState, null, 2, null);
            objRememberedValue = SnapFlingBehaviorKt.snapFlingBehavior(new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateApproachOffset(float velocity, float decayOffset) {
                    return 0.0f;
                }

                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateSnapOffset(float velocity) {
                    return snapLayoutInfoProviderSnapLayoutInfoProvider$default.calculateSnapOffset(velocity);
                }
            }, decayAnimationSpec, finiteAnimationSpecValue);
            composer.updateRememberedValue(objRememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehavior;
    }
}
