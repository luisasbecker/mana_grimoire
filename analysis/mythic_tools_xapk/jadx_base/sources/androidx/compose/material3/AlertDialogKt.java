package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aB\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aB\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aÄ\u0001\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a£\u0001\u0010\u001d\u001a\u00020\u00012\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0001¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0001¢\u0006\u0004\b%\u0010&\"\u0016\u0010'\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)\"\u0016\u0010+\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)\"\u0010\u0010-\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u0010\u0010.\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"BasicAlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialog", "AlertDialogImpl", "confirmButton", "dismissButton", "icon", Constants.GP_IAP_TITLE, "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "buttonContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DialogMinWidth", "getDialogMinWidth", "()F", "F", "DialogMaxWidth", "getDialogMaxWidth", "ButtonsMainAxisSpacing", "ButtonsCrossAxisSpacing", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TitlePadding", "TextPadding", "LocalBasicAlertDialogOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "getLocalBasicAlertDialogOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt {
    private static final float DialogMinWidth = Dp.m9114constructorimpl(280.0f);
    private static final float DialogMaxWidth = Dp.m9114constructorimpl(560.0f);
    private static final float ButtonsMainAxisSpacing = Dp.m9114constructorimpl(8.0f);
    private static final float ButtonsCrossAxisSpacing = Dp.m9114constructorimpl(12.0f);
    private static final PaddingValues DialogPadding = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(24.0f));
    private static final PaddingValues IconPadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null);
    private static final PaddingValues TitlePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null);
    private static final PaddingValues TextPadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(24.0f), 7, null);
    private static final ProvidableCompositionLocal<BasicAlertDialogOverride> LocalBasicAlertDialogOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultBasicAlertDialogOverride.INSTANCE;
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final DialogProperties dialogProperties2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(402506956);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,modifier,properties,content)215@9651L65:AlertDialog.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    i3 |= composerStartRestartGroup.changed(dialogProperties) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                    function22 = function2;
                } else {
                    function22 = function2;
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    }
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    DialogProperties dialogProperties3 = i4 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402506956, i3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:215)");
                    }
                    BasicAlertDialog(function02, modifier4, dialogProperties3, function22, composerStartRestartGroup, i3 & 8190, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    dialogProperties2 = dialogProperties;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialog$lambda$2(function0, modifier3, dialogProperties2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            if ((i2 & 8) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit AlertDialog$lambda$2(Function0 function0, Modifier modifier, DialogProperties dialogProperties, Function2 function2, int i, int i2, Composer composer, int i3) {
        AlertDialog(function0, modifier, dialogProperties, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3275AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final long j, final float f, final long j2, final long j3, final long j4, final long j5, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j6;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1378716401);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)N(buttons,modifier,icon,title,text,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,buttonContentColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color)314@12992L2065,309@12852L2205:AlertDialog.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= 384;
                function25 = function22;
            } else {
                function25 = function22;
                if ((i & 384) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function25) ? 256 : 128;
                }
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function26 = function23;
                    i4 |= composerStartRestartGroup.changedInstance(function26) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function27 = function24;
                        i4 |= composerStartRestartGroup.changedInstance(function27) ? 16384 : 8192;
                    }
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(shape) ? 131072 : 65536;
                        }
                        if ((i3 & 64) != 0) {
                            i4 |= 1572864;
                            j6 = j;
                        } else {
                            j6 = j;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(j6) ? 1048576 : 524288;
                            }
                        }
                        if ((i3 & 128) != 0) {
                            i4 |= 12582912;
                        } else {
                            if ((i & 12582912) == 0) {
                                i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                            }
                            if ((i3 & 256) == 0) {
                                i4 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changed(j2) ? 67108864 : 33554432;
                            }
                            if ((i3 & 512) == 0) {
                                i4 |= 805306368;
                            } else if ((i & 805306368) == 0) {
                                i4 |= composerStartRestartGroup.changed(j3) ? 536870912 : 268435456;
                            }
                            if ((i3 & 1024) == 0) {
                                i5 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i5 = i2 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                            } else {
                                i5 = i2;
                            }
                            if ((i3 & 2048) != 0) {
                                if ((i2 & 48) == 0) {
                                    i5 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
                                    Modifier modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1378716401, i4, i5, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:308)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                    int i7 = i4 >> 12;
                                    SurfaceKt.m4145SurfaceT9BRK9s(modifier4, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-652798794, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i8) {
                                            int i9;
                                            String str;
                                            Function2<Composer, Integer, Unit> function210;
                                            int i10;
                                            ComposerKt.sourceInformation(composer2, "C315@13002L2049:AlertDialog.kt#uh7d8r");
                                            if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-652798794, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:315)");
                                            }
                                            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.DialogPadding);
                                            final Function2<Composer, Integer, Unit> function211 = function25;
                                            final Function2<Composer, Integer, Unit> function212 = function28;
                                            final Function2<Composer, Integer, Unit> function213 = function29;
                                            long j7 = j3;
                                            long j8 = j4;
                                            long j9 = j5;
                                            long j10 = j2;
                                            Function2<Composer, Integer, Unit> function214 = function2;
                                            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer2.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer2.startReusableNode();
                                            if (composer2.getInserting()) {
                                                composer2.createNode(constructor);
                                            } else {
                                                composer2.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 346139169, "C358@14708L333:AlertDialog.kt#uh7d8r");
                                            if (function211 == null) {
                                                composer2.startReplaceGroup(346092326);
                                                composer2.endReplaceGroup();
                                                i9 = -1323940314;
                                            } else {
                                                composer2.startReplaceGroup(346092327);
                                                ComposerKt.sourceInformation(composer2, "*317@13165L165,317@13095L235");
                                                ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j7));
                                                i9 = -1323940314;
                                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1128150638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i11) {
                                                        ComposerKt.sourceInformation(composer3, "C318@13187L125:AlertDialog.kt#uh7d8r");
                                                        if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1128150638, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:318)");
                                                        }
                                                        Modifier modifierAlign = columnScopeInstance.align(PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.IconPadding), Alignment.INSTANCE.getCenterHorizontally());
                                                        Function2<Composer, Integer, Unit> function215 = function211;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierAlign);
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1288652187, "C319@13284L6:AlertDialog.kt#uh7d8r");
                                                        function215.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                                composer2.endReplaceGroup();
                                            }
                                            if (function212 == null) {
                                                composer2.startReplaceGroup(346396529);
                                                composer2.endReplaceGroup();
                                                function210 = function214;
                                                i10 = 54;
                                                str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                                            } else {
                                                composer2.startReplaceGroup(346396530);
                                                ComposerKt.sourceInformation(composer2, "*326@13528L5,327@13553L569,324@13386L736");
                                                str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                                                function210 = function214;
                                                i10 = 54;
                                                ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j8, TypographyKt.getValue(DialogTokens.INSTANCE.getHeadlineFont(), composer2, 6), ComposableLambdaKt.rememberComposableLambda(71284337, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i11) {
                                                        ComposerKt.sourceInformation(composer3, "C328@13575L529:AlertDialog.kt#uh7d8r");
                                                        if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(71284337, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:328)");
                                                        }
                                                        Modifier modifierAlign = columnScopeInstance.align(PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.TitlePadding), function211 == null ? Alignment.INSTANCE.getStart() : Alignment.INSTANCE.getCenterHorizontally());
                                                        Function2<Composer, Integer, Unit> function215 = function212;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierAlign);
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 1971616197, "C339@14075L7:AlertDialog.kt#uh7d8r");
                                                        function215.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 384);
                                                composer2.endReplaceGroup();
                                            }
                                            if (function213 == null) {
                                                composer2.startReplaceGroup(347174009);
                                            } else {
                                                composer2.startReplaceGroup(347174010);
                                                ComposerKt.sourceInformation(composer2, "*344@14225L5,348@14391L290,345@14247L434");
                                                ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j9, TypographyKt.getValue(DialogTokens.INSTANCE.getSupportingTextFont(), composer2, 6), ComposableLambdaKt.rememberComposableLambda(705583346, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i11) {
                                                        ComposerKt.sourceInformation(composer3, "C349@14413L250:AlertDialog.kt#uh7d8r");
                                                        if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(705583346, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:349)");
                                                        }
                                                        ColumnScope columnScope = columnScopeInstance;
                                                        Modifier modifierAlign = columnScope.align(PaddingKt.padding(columnScope.weight(Modifier.INSTANCE, 1.0f, false), AlertDialogKt.TextPadding), Alignment.INSTANCE.getStart());
                                                        Function2<Composer, Integer, Unit> function215 = function213;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierAlign);
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 517290885, "C354@14635L6:AlertDialog.kt#uh7d8r");
                                                        function215.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, i10), composer2, 384);
                                            }
                                            composer2.endReplaceGroup();
                                            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer2, i9, str);
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierAlign);
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer2.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer2.startReusableNode();
                                            if (composer2.getInserting()) {
                                                composer2.createNode(constructor2);
                                            } else {
                                                composer2.useNode();
                                            }
                                            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 200047666, "C359@14821L5,360@14843L184:AlertDialog.kt#uh7d8r");
                                            ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer2, 6), function210, composer2, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            composer2.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            composer2.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i7 & 112) | (i7 & 896) | ((i4 >> 9) & 57344), 104);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier2;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$4(function2, modifier3, function22, function23, function24, shape, j, f, j2, j3, j4, j5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 |= 48;
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        if ((i3 & 256) == 0) {
                        }
                        if ((i3 & 512) == 0) {
                        }
                        if ((i3 & 1024) == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) == 0) {
                    }
                    if ((i3 & 512) == 0) {
                    }
                    if ((i3 & 1024) == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function27 = function24;
                if ((i3 & 32) == 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function26 = function23;
            if ((i3 & 16) != 0) {
            }
            function27 = function24;
            if ((i3 & 32) == 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        function26 = function23;
        if ((i3 & 16) != 0) {
        }
        function27 = function24;
        if ((i3 & 32) == 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit AlertDialogContent_4hvqGtA$lambda$4(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function2 function24, Shape shape, long j, float f, long j2, long j3, long j4, long j5, int i, int i2, int i3, Composer composer, int i4) {
        m3275AlertDialogContent4hvqGtA(function2, modifier, function22, function23, function24, shape, j, f, j2, j3, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m3276AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-917637668);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogFlowRow)N(mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)380@15332L3365,380@15316L3381:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-917637668, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:379)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1381494879, "CC(remember):AlertDialog.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            AlertDialogKt$AlertDialogFlowRow$1$1 alertDialogKt$AlertDialogFlowRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || alertDialogKt$AlertDialogFlowRow$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                alertDialogKt$AlertDialogFlowRow$1$1RememberedValue = new AlertDialogKt$AlertDialogFlowRow$1$1(f, f2);
                composerStartRestartGroup.updateRememberedValue(alertDialogKt$AlertDialogFlowRow$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) alertDialogKt$AlertDialogFlowRow$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((i3 << 6) & 896) | 6;
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogFlowRow_ixp7dh8$lambda$6(f, f2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AlertDialogFlowRow_ixp7dh8$lambda$6(float f, float f2, Function2 function2, int i, Composer composer, int i2) {
        m3276AlertDialogFlowRowixp7dh8(f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m3277AlertDialogImplwrnwzgE(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Shape shape, final long j, final long j2, final long j3, final long j4, final float f, final DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i4;
        float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-867616355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)265@11313L1110,261@11182L1241:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function26 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function27 = function22;
            i3 |= composerStartRestartGroup.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function22;
        }
        if ((i & 24576) == 0) {
            function28 = function23;
            i3 |= composerStartRestartGroup.changedInstance(function28) ? 16384 : 8192;
        } else {
            function28 = function23;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(j3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            f2 = f;
            i4 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-867616355, i3, i5, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:260)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final float f3 = f2;
            final Function2<? super Composer, ? super Integer, Unit> function211 = function28;
            BasicAlertDialog(function0, modifier, dialogProperties, ComposableLambdaKt.rememberComposableLambda(527420759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C267@11365L295,286@12252L5,266@11323L1094:AlertDialog.kt#uh7d8r");
                    if (!composer2.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(527420759, i6, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous> (AlertDialog.kt:266)");
                    }
                    final Function2<Composer, Integer, Unit> function212 = function210;
                    final Function2<Composer, Integer, Unit> function213 = function29;
                    AlertDialogKt.m3275AlertDialogContent4hvqGtA(ComposableLambdaKt.rememberComposableLambda(1367541877, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i7) {
                            ComposerKt.sourceInformation(composer3, "C271@11547L99,268@11383L263:AlertDialog.kt#uh7d8r");
                            if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1367541877, i7, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous> (AlertDialog.kt:268)");
                            }
                            float f4 = AlertDialogKt.ButtonsMainAxisSpacing;
                            float f5 = AlertDialogKt.ButtonsCrossAxisSpacing;
                            final Function2<Composer, Integer, Unit> function214 = function212;
                            final Function2<Composer, Integer, Unit> function215 = function213;
                            AlertDialogKt.m3276AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.rememberComposableLambda(-459506658, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt.AlertDialogImpl.1.1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i8) {
                                    ComposerKt.sourceInformation(composer4, "C273@11613L15:AlertDialog.kt#uh7d8r");
                                    if (!composer4.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-459506658, i8, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:272)");
                                    }
                                    Function2<Composer, Integer, Unit> function216 = function214;
                                    if (function216 == null) {
                                        composer4.startReplaceGroup(-1102039173);
                                    } else {
                                        composer4.startReplaceGroup(795734342);
                                        ComposerKt.sourceInformation(composer4, "272@11584L8");
                                        function216.invoke(composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    function215.invoke(composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 438);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), null, function211, function24, function25, shape, j, f3, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j2, j3, j4, composer2, 6, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 3072 | ((i3 >> 3) & 112) | ((i5 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogImpl_wrnwzgE$lambda$3(function0, function2, modifier, function22, function23, function24, function25, shape, j, j2, j3, j4, f, dialogProperties, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AlertDialogImpl_wrnwzgE$lambda$3(Function0 function0, Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m3277AlertDialogImplwrnwzgE(function0, function2, modifier, function22, function23, function24, function25, shape, j, j2, j3, j4, f, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(24925658);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicAlertDialog)N(onDismissRequest,modifier,properties,content)144@6884L7,*151@7127L18:AlertDialog.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    dialogProperties2 = dialogProperties;
                    i3 |= composerStartRestartGroup.changed(dialogProperties2) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(24925658, i3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
                    }
                    ProvidableCompositionLocal<BasicAlertDialogOverride> providableCompositionLocal = LocalBasicAlertDialogOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((BasicAlertDialogOverride) objConsume).BasicAlertDialog(new BasicAlertDialogOverrideScope(function0, companion, dialogProperties2, function2), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                }
                final DialogProperties dialogProperties3 = dialogProperties2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.BasicAlertDialog$lambda$1(function0, modifier3, dialogProperties3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            final DialogProperties dialogProperties32 = dialogProperties2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        final DialogProperties dialogProperties322 = dialogProperties2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit BasicAlertDialog$lambda$1(Function0 function0, Modifier modifier, DialogProperties dialogProperties, Function2 function2, int i, int i2, Composer composer, int i3) {
        BasicAlertDialog(function0, modifier, dialogProperties, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final ProvidableCompositionLocal<BasicAlertDialogOverride> getLocalBasicAlertDialogOverride() {
        return LocalBasicAlertDialogOverride;
    }
}
