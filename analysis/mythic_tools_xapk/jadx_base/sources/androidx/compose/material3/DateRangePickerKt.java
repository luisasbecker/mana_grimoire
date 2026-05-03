package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.DateRangePickerKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a[\u0010 \u001a\u00020\u00032\n\u0010!\u001a\u00060\"j\u0002`#2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%\u001aÄ\u0001\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001b2:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b6\u00107\u001a°\u0001\u00108\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u00109\u001a°\u0001\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010=\u001ae\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00152\b\u0010A\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,H\u0002¢\u0006\u0002\u0010B\u001a#\u0010G\u001a\u00020\u0001*\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0000¢\u0006\u0004\bM\u0010N\u001a.\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0P2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0002\"\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F\"\u000e\u0010W\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[¨\u0006\\"}, d2 = {"DateRangePicker", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", Constants.GP_IAP_TITLE, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "selectedStartDateMillis", "selectedEndDateMillis", "displayedMonthMillis", "displayMode", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-eVtQiho", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "DateRangePickerTitlePadding", "DateRangePickerHeadlinePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(20.0f), 0.0f, Dp.m9114constructorimpl(8.0f), 4, null);
    private static final PaddingValues DateRangePickerTitlePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(Dp.m9114constructorimpl(64.0f), 0.0f, Dp.m9114constructorimpl(12.0f), 0.0f, 10, null);
    private static final PaddingValues DateRangePickerHeadlinePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(Dp.m9114constructorimpl(64.0f), 0.0f, Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(12.0f), 2, null);
    private static final float HeaderHeightOffset = Dp.m9114constructorimpl(60.0f);

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5, reason: invalid class name */
    /* JADX INFO: compiled from: DateRangePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DateRangePickerState $state;

        AnonymousClass5(DateRangePickerState dateRangePickerState, DatePickerColors datePickerColors) {
            this.$state = dateRangePickerState;
            this.$colors = datePickerColors;
        }

        static final Unit invoke$lambda$1$lambda$0(DateRangePickerState dateRangePickerState, DisplayMode displayMode) {
            dateRangePickerState.mo3592setDisplayModevCnGnXg(displayMode.getValue());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C142@6483L50,139@6273L324:DateRangePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1343236786, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:139)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
            int iMo3591getDisplayModejFl4v0 = this.$state.mo3591getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, -1934597276, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(this.$state);
            final DateRangePickerState dateRangePickerState = this.$state;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.AnonymousClass5.invoke$lambda$1$lambda$0(dateRangePickerState, (DisplayMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.m3568DisplayModeToggleButtoniUJLfQg(modifierPadding, iMo3591getDisplayModejFl4v0, (Function1) objRememberedValue, this.$colors, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6, reason: invalid class name */
    /* JADX INFO: compiled from: DateRangePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass6 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ FocusRequester $focusRequester;
        final /* synthetic */ DateRangePickerState $state;

        AnonymousClass6(DateRangePickerState dateRangePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, FocusRequester focusRequester) {
            this.$state = dateRangePickerState;
            this.$calendarModel = calendarModel;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$focusRequester = focusRequester;
        }

        static final Unit invoke$lambda$1$lambda$0(DateRangePickerState dateRangePickerState, Long l, Long l2) {
            try {
                dateRangePickerState.setSelection(l, l2);
            } catch (IllegalArgumentException unused) {
            }
            return Unit.INSTANCE;
        }

        static final Unit invoke$lambda$3$lambda$2(DateRangePickerState dateRangePickerState, long j) {
            dateRangePickerState.setDisplayedMonthMillis(j);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C159@7229L468,170@7736L91,154@6922L1170:DateRangePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684885105, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:154)");
            }
            Long selectedStartDateMillis = this.$state.getSelectedStartDateMillis();
            Long selectedEndDateMillis = this.$state.getSelectedEndDateMillis();
            long displayedMonthMillis = this.$state.getDisplayedMonthMillis();
            int iMo3591getDisplayModejFl4v0 = this.$state.mo3591getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, 1044600229, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(this.$state);
            final DateRangePickerState dateRangePickerState = this.$state;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.AnonymousClass6.invoke$lambda$1$lambda$0(dateRangePickerState, (Long) obj, (Long) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1044616076, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(this.$state);
            final DateRangePickerState dateRangePickerState2 = this.$state;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.AnonymousClass6.invoke$lambda$3$lambda$2(dateRangePickerState2, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DateRangePickerKt.m3586SwitchableDateEntryContenteVtQiho(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, iMo3591getDisplayModejFl4v0, function2, (Function1) objRememberedValue2, this.$calendarModel, this.$state.getYearRange(), this.$dateFormatter, this.$state.getSelectableDates(), this.$colors, this.$focusRequester, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1, reason: invalid class name */
    /* JADX INFO: compiled from: DateRangePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ Long $selectedEndDateMillis;
        final /* synthetic */ Long $selectedStartDateMillis;
        final /* synthetic */ CalendarDate $today;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2, LazyListState lazyListState, IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, CalendarDate calendarDate, SelectableDates selectableDates) {
            this.$selectedStartDateMillis = l;
            this.$selectedEndDateMillis = l2;
            this.$onDatesSelectionChange = function2;
            this.$lazyListState = lazyListState;
            this.$yearRange = intRange;
            this.$calendarModel = calendarModel;
            this.$firstMonth = calendarMonth;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$today = calendarDate;
            this.$selectableDates = selectableDates;
        }

        static final Unit invoke$lambda$1$lambda$0(Long l, Long l2, Function2 function2, long j) {
            DateRangePickerKt.updateDateSelection(j, l, l2, function2);
            return Unit.INSTANCE;
        }

        static final Unit invoke$lambda$5$lambda$4(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(DateRangePickerKt.AnonymousClass1.invoke$lambda$5$lambda$4$lambda$2());
                }
            }, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(DateRangePickerKt.AnonymousClass1.invoke$lambda$5$lambda$4$lambda$3());
                }
            }, false, 4, null));
            return Unit.INSTANCE;
        }

        static final float invoke$lambda$5$lambda$4$lambda$2() {
            return 0.0f;
        }

        static final float invoke$lambda$5$lambda$4$lambda$3() {
            return 0.0f;
        }

        static final Unit invoke$lambda$7$lambda$6(IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final Long l, final Long l2, final Function1 function1, final CalendarDate calendarDate, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final List list, LazyListScope lazyListScope) {
            LazyListScope.items$default(lazyListScope, DatePickerKt.numberOfMonthsInRange(intRange), null, null, ComposableLambdaKt.composableLambdaInstance(682334170, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    SelectedRangeInfo selectedRangeInfo;
                    ComposerKt.sourceInformation(composer, "CN(it)856@38171L2213:DateRangePicker.kt#uh7d8r");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(682334170, i3, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:855)");
                    }
                    CalendarMonth calendarMonthPlusMonths = calendarModel.plusMonths(calendarMonth, i);
                    Modifier modifierFillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                    Long l3 = l;
                    Long l4 = l2;
                    Function1<Long, Unit> function12 = function1;
                    CalendarDate calendarDate2 = calendarDate;
                    DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    SelectableDates selectableDates2 = selectableDates;
                    DatePickerColors datePickerColors2 = datePickerColors;
                    CalendarModel calendarModel2 = calendarModel;
                    List<CustomAccessibilityAction> list2 = list;
                    ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillParentMaxWidth$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, 185122771, "C857@38312L5,857@38319L653,857@38242L730,883@39764L602:DateRangePicker.kt#uh7d8r");
                    TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont(), composer, 6), ComposableLambdaKt.rememberComposableLambda(-577031469, true, new DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1(datePickerFormatter2, calendarMonthPlusMonths, calendarModel2, list2, datePickerColors2), composer, 54), composer, 48);
                    if (l3 == null || l4 == null) {
                        composer.startReplaceGroup(186488258);
                        composer.endReplaceGroup();
                        selectedRangeInfo = null;
                    } else {
                        composer.startReplaceGroup(185956701);
                        ComposerKt.sourceInformation(composer, "872@39162L489");
                        ComposerKt.sourceInformationMarkerStart(composer, 1945662157, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean zChanged = composer.changed(l3) | composer.changed(l4);
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SelectedRangeInfo.INSTANCE.calculateRangeInfo(calendarMonthPlusMonths, calendarModel2.getCanonicalDate(l3.longValue()), calendarModel2.getCanonicalDate(l4.longValue()));
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        selectedRangeInfo = (SelectedRangeInfo) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    }
                    DatePickerKt.Month(calendarMonthPlusMonths, function12, calendarDate2.getUtcTimeMillis(), l3, l4, selectedRangeInfo, datePickerFormatter2, selectableDates2, datePickerColors2, calendarModel2.getLocale(), composer, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 6, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C822@36607L24,823@36673L59,824@36770L55,828@37006L318,849@37841L116,853@38004L2404,845@37628L2780:DateRangePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1090773432, i, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:822)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Strings.Companion companion = Strings.INSTANCE;
            String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_range_picker_scroll_to_previous_month), composer, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String strM4676getString2EP1pXo2 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_range_picker_scroll_to_next_month), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 261262006, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(this.$selectedStartDateMillis) | composer.changed(this.$selectedEndDateMillis) | composer.changed(this.$onDatesSelectionChange);
            final Long l = this.$selectedStartDateMillis;
            final Long l2 = this.$selectedEndDateMillis;
            final Function2<Long, Long, Unit> function2 = this.$onDatesSelectionChange;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.AnonymousClass1.invoke$lambda$1$lambda$0(l, l2, function2, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            final Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            final List listCustomScrollActions = DateRangePickerKt.customScrollActions(this.$lazyListState, coroutineScope, strM4676getString2EP1pXo, strM4676getString2EP1pXo2);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 261288524, "CC(remember):DateRangePicker.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.AnonymousClass1.invoke$lambda$5$lambda$4((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue3, 1, null);
            LazyListState lazyListState = this.$lazyListState;
            ComposerKt.sourceInformationMarkerStart(composer, 261296028, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$yearRange) | composer.changedInstance(this.$calendarModel) | composer.changed(this.$firstMonth) | composer.changedInstance(this.$dateFormatter) | composer.changedInstance(listCustomScrollActions) | composer.changed(this.$colors) | composer.changed(this.$selectedStartDateMillis) | composer.changed(this.$selectedEndDateMillis) | composer.changed(function1) | composer.changed(this.$today) | composer.changed(this.$selectableDates);
            final IntRange intRange = this.$yearRange;
            final CalendarModel calendarModel = this.$calendarModel;
            final CalendarMonth calendarMonth = this.$firstMonth;
            final Long l3 = this.$selectedStartDateMillis;
            final Long l4 = this.$selectedEndDateMillis;
            final CalendarDate calendarDate = this.$today;
            final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            final SelectableDates selectableDates = this.$selectableDates;
            final DatePickerColors datePickerColors = this.$colors;
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.AnonymousClass1.invoke$lambda$7$lambda$6(intRange, calendarModel, calendarMonth, l3, l4, function1, calendarDate, datePickerFormatter, selectableDates, datePickerColors, listCustomScrollActions, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composer, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DateRangePicker(final DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, FocusRequester focusRequester, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DatePickerColors datePickerColors2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda2;
        int i6;
        boolean z2;
        int i7;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter2;
        final FocusRequester focusRequester2;
        final Modifier modifier3;
        final DatePickerColors datePickerColors3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final DatePickerFormatter datePickerFormatter3;
        final DatePickerColors datePickerColorsColors;
        int i8;
        boolean z4;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean z5;
        DatePickerColors datePickerColors4;
        Modifier modifier4;
        int i10;
        FocusRequester focusRequester3;
        DatePickerFormatter datePickerFormatter4;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1969726368);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)125@5861L207,149@6756L5,153@6912L1186,132@6073L2025:DateRangePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i11 = 128;
                    i3 |= i11;
                } else {
                    if ((i & 512) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter)) {
                        i11 = 256;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    datePickerColors2 = datePickerColors;
                    int i13 = composerStartRestartGroup.changed(datePickerColors2) ? 2048 : 1024;
                    i3 |= i13;
                } else {
                    datePickerColors2 = datePickerColors;
                }
                i3 |= i13;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    function2RememberComposableLambda = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function2RememberComposableLambda) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        function2RememberComposableLambda2 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function2RememberComposableLambda2) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            i3 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(focusRequester) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533297, "CC(remember):DateRangePicker.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter3 = datePickerFormatter;
                                }
                                if ((i2 & 8) != 0) {
                                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    datePickerColorsColors = datePickerColors2;
                                }
                                if (i4 != 0) {
                                    i8 = i3;
                                    z4 = true;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C105@5060L199:DateRangePicker.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-803011924, i14, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:105)");
                                            }
                                            DateRangePickerDefaults.INSTANCE.m3583DateRangePickerTitleFNtVw6o(dateRangePickerState.mo3591getDisplayModejFl4v0(), PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.DateRangePickerTitlePadding), datePickerColorsColors.getTitleContentColor(), composer3, 3120, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    i9 = 54;
                                } else {
                                    i8 = i3;
                                    z4 = true;
                                    i9 = 54;
                                }
                                if (i5 != 0) {
                                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C112@5343L369:DateRangePicker.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-331385278, i14, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:112)");
                                            }
                                            DateRangePickerDefaults.INSTANCE.m3582DateRangePickerHeadlineqS89cEg(dateRangePickerState.getSelectedStartDateMillis(), dateRangePickerState.getSelectedEndDateMillis(), dateRangePickerState.mo3591getDisplayModejFl4v0(), datePickerFormatter3, PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.DateRangePickerHeadlinePadding), datePickerColorsColors.getHeadlineContentColor(), composer3, 1597440, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, i9);
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if (i7 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504003, "CC(remember):DateRangePicker.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new FocusRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    DatePickerColors datePickerColors5 = datePickerColorsColors;
                                    focusRequester3 = (FocusRequester) objRememberedValue2;
                                    z5 = z2;
                                    datePickerColors4 = datePickerColors5;
                                    function24 = function2RememberComposableLambda;
                                    modifier4 = modifier2;
                                    i10 = i8;
                                } else {
                                    function24 = function2RememberComposableLambda;
                                    z5 = z2;
                                    datePickerColors4 = datePickerColorsColors;
                                    modifier4 = modifier2;
                                    i10 = i8;
                                    focusRequester3 = focusRequester;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                datePickerFormatter3 = datePickerFormatter;
                                focusRequester3 = focusRequester;
                                function24 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i10 = i3;
                                z5 = z2;
                                datePickerColors4 = datePickerColors2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1969726368, i10, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                            }
                            Locale locale = dateRangePickerState.getLocale();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173501681, "CC(remember):DateRangePicker.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(locale);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = dateRangePickerState instanceof BaseDatePickerStateImpl ? ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel() : CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            CalendarModel calendarModel = (CalendarModel) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z5) {
                                composerStartRestartGroup.startReplaceGroup(-2018438858);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                                datePickerFormatter4 = datePickerFormatter3;
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new AnonymousClass5(dateRangePickerState, datePickerColors4), composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                datePickerFormatter4 = datePickerFormatter3;
                                composerStartRestartGroup.startReplaceGroup(-2018051234);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            }
                            FocusRequester focusRequester4 = focusRequester3;
                            DatePickerFormatter datePickerFormatter5 = datePickerFormatter4;
                            int i14 = i10 >> 9;
                            composer2 = composerStartRestartGroup;
                            DatePickerKt.m3564DateEntryContainerau3_HiA(modifier4, function24, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6), Dp.m9114constructorimpl(DatePickerModalTokens.INSTANCE.m4912getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.rememberComposableLambda(684885105, true, new AnonymousClass6(dateRangePickerState, calendarModel, datePickerFormatter4, datePickerColors4, focusRequester4), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 14155776 | (i14 & 112) | (i14 & 896) | (57344 & (i10 << 3)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            datePickerFormatter2 = datePickerFormatter5;
                            focusRequester2 = focusRequester4;
                            z3 = z5;
                            modifier3 = modifier4;
                            function23 = function24;
                            datePickerColors3 = datePickerColors4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            datePickerFormatter2 = datePickerFormatter;
                            focusRequester2 = focusRequester;
                            modifier3 = modifier2;
                            datePickerColors3 = datePickerColors2;
                            function23 = function2RememberComposableLambda;
                            z3 = z2;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function2RememberComposableLambda2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$3(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function23, function25, z3, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    z2 = z;
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    final Function2 function252 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function2RememberComposableLambda2 = function22;
                i6 = i2 & 64;
                if (i6 != 0) {
                }
                z2 = z;
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                final Function2 function2522 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function2RememberComposableLambda = function2;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function2RememberComposableLambda2 = function22;
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            z2 = z;
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            final Function2 function25222 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function2RememberComposableLambda = function2;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function2RememberComposableLambda2 = function22;
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        z2 = z;
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        final Function2 function252222 = function2RememberComposableLambda2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit DateRangePicker$lambda$3(DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2 function2, Function2 function22, boolean z, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        DateRangePicker(dateRangePickerState, modifier, datePickerFormatter, datePickerColors, function2, function22, z, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateRangePickerContent(final Long l, final Long l2, final long j, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        SelectableDates selectableDates2;
        Object obj;
        DateRangePickerKt$DateRangePickerContent$1$1 dateRangePickerKt$DateRangePickerContent$1$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)767@34501L64,770@34655L309,770@34628L336,778@34970L649:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l2;
            i2 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function22 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i & 24576) == 0) {
            function12 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= composerStartRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:764)");
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(calendarModel.getMonth(j).indexIn(intRange), 0);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(iCoerceAtLeast, 0, composerStartRestartGroup, 0, 2);
            Integer numValueOf = Integer.valueOf(iCoerceAtLeast);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -453965044, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(iCoerceAtLeast);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = null;
                dateRangePickerKt$DateRangePickerContent$1$1 = new DateRangePickerKt$DateRangePickerContent$1$1(lazyListStateRememberLazyListState, iCoerceAtLeast, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$DateRangePickerContent$1$1);
            } else {
                dateRangePickerKt$DateRangePickerContent$1$1 = objRememberedValue;
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$DateRangePickerContent$1$1, composerStartRestartGroup, 0);
            Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1922743819, "C779@35058L31,780@35098L515:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors, calendarModel, composerStartRestartGroup, ((i2 >> 27) & 14) | ((i2 >> 12) & 112));
            VerticalMonthsList(lazyListStateRememberLazyListState, l, l3, function22, function12, calendarModel, intRange, datePickerFormatter, selectableDates2, datePickerColors, composerStartRestartGroup, ((i2 << 3) & PointerIconCompat.TYPE_TEXT) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DateRangePickerKt.DateRangePickerContent$lambda$12(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    static final Unit DateRangePickerContent$lambda$12(Long l, Long l2, long j, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        DateRangePickerContent(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m3584DateRangePickerStateHVP43zI(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m3585DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.INSTANCE.m3612getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m3584DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchableDateEntryContent-eVtQiho, reason: not valid java name */
    public static final void m3586SwitchableDateEntryContenteVtQiho(final Long l, final Long l2, final long j, final int i, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(621028059);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchableDateEntryContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)714@32363L7,716@32422L91,720@32521L1304,712@32259L1566:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            l3 = l2;
            i4 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            function22 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if ((196608 & i2) == 0) {
            function12 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function12) ? 131072 : 65536;
        } else {
            function12 = function1;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(calendarModel) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(intRange) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= (i2 & 134217728) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(selectableDates) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        int i6 = i5;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(621028059, i4, i6, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:708)");
            }
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -192456874, "CC(remember):DateRangePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.SwitchableDateEntryContent_eVtQiho$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Long l4 = l3;
            final Function2<? super Long, ? super Long, Unit> function23 = function22;
            final Function1<? super Long, Unit> function13 = function12;
            composer2 = composerStartRestartGroup;
            CrossfadeKt.Crossfade(DisplayMode.m3604boximpl(i), SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), (FiniteAnimationSpec<Float>) finiteAnimationSpecValue, (String) null, ComposableLambdaKt.rememberComposableLambda(-773828161, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode, Composer composer3, Integer num) {
                    m3590invokeQujVXRc(displayMode.getValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m3590invokeQujVXRc(int i7, Composer composer3, int i8) {
                    int i9;
                    ComposerKt.sourceInformation(composer3, "CN(mode:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
                    if ((i8 & 6) == 0) {
                        i9 = i8 | (composer3.changed(i7) ? 4 : 2);
                    } else {
                        i9 = i8;
                    }
                    if (!composer3.shouldExecute((i9 & 19) != 18, i9 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-773828161, i9, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:721)");
                    }
                    if (DisplayMode.m3607equalsimpl0(i7, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                        composer3.startReplaceGroup(-619517270);
                        ComposerKt.sourceInformation(composer3, "723@32603L619");
                        DateRangePickerKt.DateRangePickerContent(l, l4, j, function23, function13, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (DisplayMode.m3607equalsimpl0(i7, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                        composer3.startReplaceGroup(-619495944);
                        ComposerKt.sourceInformation(composer3, "736@33272L537");
                        DateRangeInputKt.DateRangeInputContent(l, l4, function23, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-2023979101);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i4 >> 9) & 14) | 24576, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.SwitchableDateEntryContent_eVtQiho$lambda$9(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SwitchableDateEntryContent_eVtQiho$lambda$8$lambda$7(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    static final Unit SwitchableDateEntryContent_eVtQiho$lambda$9(Long l, Long l2, long j, int i, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m3586SwitchableDateEntryContenteVtQiho(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    private static final void VerticalMonthsList(LazyListState lazyListState, final Long l, final Long l2, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Long l4;
        Function2<? super Long, ? super Long, Unit> function22;
        Object month;
        DateRangePickerKt$VerticalMonthsList$2$1 dateRangePickerKt$VerticalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(1257365001);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalMonthsList)N(lazyListState,selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)815@36348L159,821@36569L5,821@36576L3838,821@36512L3902,899@40449L229,899@40419L259:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l;
            i2 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l;
        }
        if ((i & 384) == 0) {
            l4 = l2;
            i2 |= composerStartRestartGroup.changed(l4) ? 256 : 128;
        } else {
            l4 = l2;
        }
        if ((i & 3072) == 0) {
            function22 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, i2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:812)");
            }
            CalendarDate today = calendarModel.getToday();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1441974088, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(intRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                month = calendarModel.getMonth(intRange.getFirst(), 1);
                composerStartRestartGroup.updateRememberedValue(month);
            } else {
                month = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new AnonymousClass1(l3, l4, function22, lazyListState2, intRange, calendarModel, (CalendarMonth) month, datePickerFormatter, datePickerColors, today, selectableDates), composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1442105390, "CC(remember):DateRangePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean zChangedInstance = (i4 == 4) | ((i3 & 57344) == 16384) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(intRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                dateRangePickerKt$VerticalMonthsList$2$1 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, function1, calendarModel, intRange, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$VerticalMonthsList$2$1);
            } else {
                dateRangePickerKt$VerticalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$VerticalMonthsList$2$1, composerStartRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.VerticalMonthsList$lambda$15(lazyListState2, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit VerticalMonthsList$lambda$15(LazyListState lazyListState, Long l, Long l2, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        VerticalMonthsList(lazyListState, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState lazyListState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DateRangePickerKt.customScrollActions$lambda$16(lazyListState, coroutineScope));
            }
        }), new CustomAccessibilityAction(str2, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DateRangePickerKt.customScrollActions$lambda$17(lazyListState, coroutineScope));
            }
        })});
    }

    static final boolean customScrollActions$lambda$16(LazyListState lazyListState, CoroutineScope coroutineScope) {
        if (!lazyListState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DateRangePickerKt$customScrollActions$scrollUpAction$1$1(lazyListState, null), 3, null);
        return true;
    }

    static final boolean customScrollActions$lambda$17(LazyListState lazyListState, CoroutineScope coroutineScope) {
        if (!lazyListState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DateRangePickerKt$customScrollActions$scrollDownAction$1$1(lazyListState, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m3588drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        float f = contentDrawScope.mo1624toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f2 = contentDrawScope.mo1624toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f3 = contentDrawScope.mo1624toPx0680j_4(DatePickerModalTokens.INSTANCE.m4905getDateStateLayerHeightD9Ej5fM());
        float f4 = (f2 - f3) / 2.0f;
        char c = ' ';
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - (7.0f * f)) / 7.0f;
        long gridStartCoordinates = selectedRangeInfo.getGridStartCoordinates();
        int iM9242getXimpl = IntOffset.m9242getXimpl(gridStartCoordinates);
        int iM9243getYimpl = IntOffset.m9243getYimpl(gridStartCoordinates);
        long gridEndCoordinates = selectedRangeInfo.getGridEndCoordinates();
        int iM9242getXimpl2 = IntOffset.m9242getXimpl(gridEndCoordinates);
        int iM9243getYimpl2 = IntOffset.m9243getYimpl(gridEndCoordinates);
        float f5 = f + fIntBitsToFloat;
        float f6 = fIntBitsToFloat / 2.0f;
        float fIntBitsToFloat2 = (iM9242getXimpl * f5) + (selectedRangeInfo.getFirstIsSelectionStart() ? f / 2.0f : 0.0f) + f6;
        float f7 = (iM9243getYimpl * f2) + f4;
        float f8 = iM9242getXimpl2 * f5;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            f /= 2.0f;
        }
        float fIntBitsToFloat3 = f8 + f + f6;
        float f9 = (iM9243getYimpl2 * f2) + f4;
        boolean z = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - fIntBitsToFloat2;
            fIntBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - fIntBitsToFloat3;
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m6893drawRectnJ9OG0$default(contentDrawScope2, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(f7)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(iM9243getYimpl == iM9243getYimpl2 ? fIntBitsToFloat3 - fIntBitsToFloat2 : z ? -fIntBitsToFloat2 : Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, null, null, 0, 120, null);
        if (iM9243getYimpl != iM9243getYimpl2) {
            int i = (iM9243getYimpl2 - iM9243getYimpl) - 1;
            while (i > 0) {
                char c2 = c;
                DrawScope.m6893drawRectnJ9OG0$default(contentDrawScope2, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << c2) | (((long) Float.floatToRawIntBits((i * f2) + f7)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> c2)))) << c2) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, null, null, 0, 120, null);
                i--;
                c = c2;
            }
            char c3 = c;
            long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f9)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(contentDrawScope.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> c3)))) << c3));
            if (z) {
                fIntBitsToFloat3 -= Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> c3));
            }
            DrawScope.m6893drawRectnJ9OG0$default(contentDrawScope2, j, jM6072constructorimpl, Size.m6140constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << c3) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, null, null, 0, 120, null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m3589rememberDateRangePickerStateIlFM19s(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2012087461, "C(rememberDateRangePickerState)N(initialSelectedStartDateMillis,initialSelectedEndDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)284@12718L15,285@12827L476,285@12745L558:DateRangePicker.kt#uh7d8r");
        final Long l4 = (i3 & 1) != 0 ? null : l;
        final Long l5 = (i3 & 2) != 0 ? null : l2;
        final Long l6 = (i3 & 4) != 0 ? l4 : l3;
        final IntRange yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int iM3612getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.INSTANCE.m3612getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:283)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.INSTANCE.Saver(allDates, localeDefaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer, -880746409, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean z = true;
        boolean zChangedInstance = ((((i2 & 112) ^ 48) > 32 && composer.changed(l5)) || (i2 & 48) == 32) | ((((i2 & 14) ^ 6) > 4 && composer.changed(l4)) || (i2 & 6) == 4) | ((((i2 & 896) ^ 384) > 256 && composer.changed(l6)) || (i2 & 384) == 256) | composer.changedInstance(yearRange) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(iM3612getPickerjFl4v0)) || (i2 & 24576) == 16384);
        if ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 || !composer.changed(allDates)) && (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            z = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DateRangePickerKt.rememberDateRangePickerState_IlFM19s$lambda$5$lambda$4(l4, l5, l6, yearRange, iM3612getPickerjFl4v0, allDates, localeDefaultLocale);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        dateRangePickerStateImpl.setSelectableDates(allDates);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dateRangePickerStateImpl;
    }

    static final DateRangePickerStateImpl rememberDateRangePickerState_IlFM19s$lambda$5$lambda$4(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(long j, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        if ((l == null && l2 == null) || (l != null && l2 != null)) {
            function2.invoke(Long.valueOf(j), null);
        } else if (l == null || j < l.longValue()) {
            function2.invoke(Long.valueOf(j), null);
        } else {
            function2.invoke(l, Long.valueOf(j));
        }
    }
}
