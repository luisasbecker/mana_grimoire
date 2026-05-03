package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001aP\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(MaterialThemeKt.LocalUsingExpressiveTheme$lambda$3());
        }
    });
    private static final ProvidableCompositionLocal<MotionScheme> _localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MotionScheme.INSTANCE.standard$material3();
        }
    });

    static final boolean LocalUsingExpressiveTheme$lambda$3() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        ColorScheme colorScheme2;
        int i3;
        MotionScheme motionScheme2;
        int i4;
        Shapes shapes2;
        int i5;
        Typography typography2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final ColorScheme colorScheme3;
        final MotionScheme motionScheme3;
        final Shapes shapes3;
        final Typography typography3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final ColorScheme colorScheme4;
        ColorScheme colorScheme5;
        MotionScheme motionScheme4;
        Typography typography4;
        Shapes shapes4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1317329884);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialExpressiveTheme)N(colorScheme,motionScheme,shapes,typography,content)191@8447L7:MaterialTheme.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            colorScheme2 = colorScheme;
        } else if ((i & 6) == 0) {
            colorScheme2 = colorScheme;
            i3 = (composerStartRestartGroup.changed(colorScheme2) ? 4 : 2) | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                motionScheme2 = motionScheme;
                i3 |= composerStartRestartGroup.changed(motionScheme2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    shapes2 = shapes;
                    i3 |= composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        typography2 = typography;
                        i3 |= composerStartRestartGroup.changed(typography2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) != 0) {
                        if ((i & 24576) == 0) {
                            function22 = function2;
                            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                            if (i6 != 0) {
                                colorScheme2 = null;
                            }
                            final MotionScheme motionScheme5 = i7 != 0 ? null : motionScheme2;
                            final Shapes shapes5 = i4 != 0 ? null : shapes2;
                            final Typography typography5 = i5 != 0 ? null : typography2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:190)");
                            }
                            ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalUsingExpressiveTheme;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (((Boolean) objConsume).booleanValue()) {
                                composerStartRestartGroup.startReplaceGroup(1458674654);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "192@8466L312");
                                if (colorScheme2 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1061322393);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "193@8536L11");
                                    ColorScheme colorScheme6 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorScheme5 = colorScheme6;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1061323292);
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorScheme5 = colorScheme2;
                                }
                                if (motionScheme5 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1061320152);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "194@8606L12");
                                    MotionScheme motionScheme6 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                    motionScheme4 = motionScheme6;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1061321082);
                                    composerStartRestartGroup.endReplaceGroup();
                                    motionScheme4 = motionScheme5;
                                }
                                if (typography5 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1061318010);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8673L10");
                                    Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                    typography4 = typography6;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1061318878);
                                    composerStartRestartGroup.endReplaceGroup();
                                    typography4 = typography5;
                                }
                                if (shapes5 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1061316190);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "196@8730L6");
                                    Shapes shapes6 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                    shapes4 = shapes6;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1061316934);
                                    composerStartRestartGroup.endReplaceGroup();
                                    shapes4 = shapes5;
                                }
                                MaterialTheme(colorScheme5, motionScheme4, shapes4, typography4, function22, composerStartRestartGroup, i3 & 57344, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                colorScheme4 = colorScheme2;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1459011221);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "200@8866L415,200@8800L481");
                                colorScheme4 = colorScheme2;
                                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialExpressiveTheme.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i8) {
                                        ComposerKt.sourceInformation(composer2, "C201@8880L391:MaterialTheme.kt#uh7d8r");
                                        if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1535649272, i8, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:201)");
                                        }
                                        ColorScheme colorSchemeExpressiveLightColorScheme = colorScheme4;
                                        if (colorSchemeExpressiveLightColorScheme == null) {
                                            colorSchemeExpressiveLightColorScheme = ColorSchemeKt.expressiveLightColorScheme();
                                        }
                                        MotionScheme motionSchemeExpressive$material3 = motionScheme5;
                                        if (motionSchemeExpressive$material3 == null) {
                                            motionSchemeExpressive$material3 = MotionScheme.INSTANCE.expressive$material3();
                                        }
                                        Shapes shapes7 = shapes5;
                                        if (shapes7 == null) {
                                            shapes7 = new Shapes(null, null, null, null, null, 31, null);
                                        }
                                        Typography typography7 = typography5;
                                        if (typography7 == null) {
                                            typography7 = new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
                                        }
                                        MaterialThemeKt.MaterialTheme(colorSchemeExpressiveLightColorScheme, motionSchemeExpressive$material3, shapes7, typography7, function2, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorScheme3 = colorScheme4;
                            motionScheme3 = motionScheme5;
                            shapes3 = shapes5;
                            typography3 = typography5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            colorScheme3 = colorScheme2;
                            motionScheme3 = motionScheme2;
                            shapes3 = shapes2;
                            typography3 = typography2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MaterialThemeKt.MaterialExpressiveTheme$lambda$2(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    function22 = function2;
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                typography2 = typography;
                if ((i2 & 16) != 0) {
                }
                function22 = function2;
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            shapes2 = shapes;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            typography2 = typography;
            if ((i2 & 16) != 0) {
            }
            function22 = function2;
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        motionScheme2 = motionScheme;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        shapes2 = shapes;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        typography2 = typography;
        if ((i2 & 16) != 0) {
        }
        function22 = function2;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit MaterialExpressiveTheme$lambda$2(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialExpressiveTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        ColorScheme colorScheme2;
        int i3;
        MotionScheme motionScheme2;
        Shapes shapes2;
        final Typography typography2;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(904511636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)N(colorScheme,motionScheme,shapes,typography,content)97@4480L40,105@4846L81,98@4525L402:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                if (composerStartRestartGroup.changed(colorScheme2)) {
                    i4 = 4;
                }
                i3 = i4 | i;
            } else {
                colorScheme2 = colorScheme;
            }
            i4 = 2;
            i3 = i4 | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                motionScheme2 = motionScheme;
                int i5 = composerStartRestartGroup.changed(motionScheme2) ? 32 : 16;
                i3 |= i5;
            } else {
                motionScheme2 = motionScheme;
            }
            i3 |= i5;
        } else {
            motionScheme2 = motionScheme;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                int i6 = composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                i3 |= i6;
            } else {
                shapes2 = shapes;
            }
            i3 |= i6;
        } else {
            shapes2 = shapes;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                typography2 = typography;
                int i7 = composerStartRestartGroup.changed(typography2) ? 2048 : 1024;
                i3 |= i7;
            } else {
                typography2 = typography;
            }
            i3 |= i7;
        } else {
            typography2 = typography;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4205L11,91@4265L12,92@4314L6,93@4365L10");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    motionScheme2 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(904511636, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:95)");
                }
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), _localMotionScheme.provides(motionScheme2), IndicationKt.getLocalIndication().provides(RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme2, composerStartRestartGroup, i3 & 14)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        ComposerKt.sourceInformation(composer2, "C106@4856L65:MaterialTheme.kt#uh7d8r");
                        if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1750539308, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:106)");
                        }
                        TextKt.ProvideTextStyle(typography2.getBodyLarge(), function2, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), _localMotionScheme.provides(motionScheme2), IndicationKt.getLocalIndication().provides(RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme2, composerStartRestartGroup, i3 & 14)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        ComposerKt.sourceInformation(composer2, "C106@4856L65:MaterialTheme.kt#uh7d8r");
                        if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1750539308, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:106)");
                        }
                        TextKt.ProvideTextStyle(typography2.getBodyLarge(), function2, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Shapes shapes3 = shapes2;
        final Typography typography3 = typography2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ColorScheme colorScheme3 = colorScheme2;
            final MotionScheme motionScheme3 = motionScheme2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Typography typography2;
        final Shapes shapes2;
        final ColorScheme colorScheme2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-449719819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)N(colorScheme,shapes,typography,content)61@2821L12,59@2734L191:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(colorScheme)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(shapes)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(typography)) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "54@2578L11,55@2626L6,56@2677L10");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                ColorScheme colorScheme3 = colorScheme;
                Shapes shapes3 = shapes;
                Typography typography3 = typography;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-449719819, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:59)");
                }
                int i4 = i3 << 3;
                MaterialTheme(colorScheme3, MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6), shapes3, typography3, function2, composerStartRestartGroup, (i3 & 14) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
                function22 = function2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme2 = colorScheme3;
                shapes2 = shapes3;
                typography2 = typography3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                ColorScheme colorScheme32 = colorScheme;
                Shapes shapes32 = shapes;
                Typography typography32 = typography;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i42 = i3 << 3;
                MaterialTheme(colorScheme32, MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6), shapes32, typography32, function2, composerStartRestartGroup, (i3 & 14) | (i42 & 896) | (i42 & 7168) | (i42 & 57344), 0);
                function22 = function2;
                if (ComposerKt.isTraceInProgress()) {
                }
                colorScheme2 = colorScheme32;
                shapes2 = shapes32;
                typography2 = typography32;
            }
        } else {
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
            typography2 = typography;
            shapes2 = shapes;
            colorScheme2 = colorScheme;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$0(colorScheme2, shapes2, typography2, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MaterialTheme$lambda$0(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit MaterialTheme$lambda$1(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    private static /* synthetic */ void get_localMotionScheme$annotations() {
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1866455512, "C(rememberTextSelectionColors)N(colorScheme)219@9547L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:217)");
        }
        long primary = colorScheme.getPrimary();
        ComposerKt.sourceInformationMarkerStart(composer, -1632576770, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(primary, Color.m6324copywmQWz5c$default(primary, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }
}
