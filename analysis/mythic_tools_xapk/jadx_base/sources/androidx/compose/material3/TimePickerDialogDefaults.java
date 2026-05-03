package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TimePickerDialogDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeightForTimePicker", "Landroidx/compose/ui/unit/Dp;", "getMinHeightForTimePicker-D9Ej5fM", "()F", "F", "DisplayModeToggle", "", "onDisplayModeChange", "Lkotlin/Function0;", "displayMode", "Landroidx/compose/material3/TimePickerDisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "DisplayModeToggle-S7Bxtbk", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Title", "Title-pK_nZyw", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogDefaults {
    public static final int $stable = 0;
    public static final TimePickerDialogDefaults INSTANCE = new TimePickerDialogDefaults();
    private static final float MinHeightForTimePicker = Dp.m9114constructorimpl(300.0f);

    private TimePickerDialogDefaults() {
    }

    static final Unit DisplayModeToggle_S7Bxtbk$lambda$0(TimePickerDialogDefaults timePickerDialogDefaults, Function0 function0, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m4314DisplayModeToggleS7Bxtbk(function0, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit Title_pK_nZyw$lambda$1(TimePickerDialogDefaults timePickerDialogDefaults, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m4315TitlepK_nZyw(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DisplayModeToggle-S7Bxtbk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4314DisplayModeToggleS7Bxtbk(final Function0<Unit> function0, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        Function0<Unit> function02;
        int i4;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1283607635);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplayModeToggle)N(onDisplayModeChange,displayMode:c#material3.TimePickerDisplayMode,modifier)265@11164L645,265@11101L708:TimePickerDialog.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i5 = i3 & 4;
        if (i5 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 147) == 146, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1283607635, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle (TimePickerDialog.kt:264)");
                }
                IconButtonKt.IconButton(function02, modifier4, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-698026161, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerDialogDefaults$DisplayModeToggle$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        int iM4597constructorimpl;
                        ComposerKt.sourceInformation(composer2, "C276@11499L285,273@11400L399:TimePickerDialog.kt#uh7d8r");
                        if (!composer2.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-698026161, i6, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle.<anonymous> (TimePickerDialog.kt:266)");
                        }
                        ImageVector keyboard = TimePickerDisplayMode.m4322equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4327getPickerONbchU()) ? Icons.Outlined.INSTANCE.getKeyboard() : Icons.Outlined.INSTANCE.getSchedule();
                        if (TimePickerDisplayMode.m4322equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4327getPickerONbchU())) {
                            Strings.Companion companion = Strings.INSTANCE;
                            iM4597constructorimpl = Strings.m4597constructorimpl(R.string.m3c_time_picker_toggle_touch);
                        } else {
                            Strings.Companion companion2 = Strings.INSTANCE;
                            iM4597constructorimpl = Strings.m4597constructorimpl(R.string.m3c_time_picker_toggle_keyboard);
                        }
                        IconKt.m3736Iconww6aTOc(keyboard, Strings_androidKt.m4676getString2EP1pXo(iM4597constructorimpl, composer2, 0), (Modifier) null, 0L, composer2, 0, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | 1572864 | ((i4 >> 3) & 112), 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$0(this.f$0, function0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i4 & 147) == 146, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Title-pK_nZyw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4315TitlepK_nZyw(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM4597constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1546564986);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Title)N(displayMode:c#material3.TimePickerDisplayMode,modifier)297@12224L10,299@12283L257,295@12127L424:TimePickerDialog.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(i) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 19) == 18, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1546564986, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.Title (TimePickerDialog.kt:294)");
                }
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(modifier4, 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(20.0f), 7, null);
                Modifier modifier5 = modifier4;
                TextStyle labelMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelMedium();
                if (TimePickerDisplayMode.m4322equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4327getPickerONbchU())) {
                    Strings.Companion companion = Strings.INSTANCE;
                    iM4597constructorimpl = Strings.m4597constructorimpl(R.string.m3c_time_picker_dialog_title);
                } else {
                    Strings.Companion companion2 = Strings.INSTANCE;
                    iM4597constructorimpl = Strings.m4597constructorimpl(R.string.m3c_time_input_dialog_title);
                }
                composer2 = composerStartRestartGroup;
                TextKt.m4288TextNvy7gAk(Strings_androidKt.m4676getString2EP1pXo(iM4597constructorimpl, composerStartRestartGroup, 0), modifierM2041paddingqDBjuR0$default, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, labelMedium, composer2, 0, 0, 131068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogDefaults.Title_pK_nZyw$lambda$1(this.f$0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i4 & 19) == 18, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -443775449, "C(<get-containerColor>)242@10289L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-443775449, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-containerColor> (TimePickerDialog.kt:242)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeightForTimePicker-D9Ej5fM, reason: not valid java name */
    public final float m4316getMinHeightForTimePickerD9Ej5fM() {
        return MinHeightForTimePicker;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1241096723, "C(<get-shape>)246@10412L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1241096723, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-shape> (TimePickerDialog.kt:246)");
        }
        Shape value = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
