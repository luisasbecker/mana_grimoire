package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.facebook.internal.ServerProtocol;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u0011J\r\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u0011J\r\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J'\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0007¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.JU\u0010(\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020&H\u0007¢\u0006\u0002\u00100JK\u00101\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.R\u0018\u0010\u0012\u001a\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u00102\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u00107\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b8\u00105R\u0013\u00109\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b:\u00105R\u0013\u0010;\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b<\u00105R\u0013\u0010=\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b>\u00105R\u0013\u0010?\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b@\u00105R\u0013\u0010A\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bB\u00105R\u0013\u0010C\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bD\u00105R\u0013\u0010E\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bF\u00105¨\u0006G"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "<init>", "()V", "topAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "topAppBarColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "centerAlignedTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "enterAlwaysScrollBehavior", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "reverseLayout", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "TopAppBarExpandedHeight", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithoutSubtitleExpandedHeight", "getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithSubtitleExpandedHeight", "getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithoutSubtitleExpandedHeight", "getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithSubtitleExpandedHeight", "getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();
    private static final float TopAppBarExpandedHeight = AppBarSmallTokens.INSTANCE.m4706getContainerHeightD9Ej5fM();
    private static final float MediumAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m4706getContainerHeightD9Ej5fM();
    private static final float MediumAppBarExpandedHeight = AppBarMediumTokens.INSTANCE.m4705getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m4703getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m4704getLargeContainerHeightD9Ej5fM();
    private static final float LargeAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m4706getContainerHeightD9Ej5fM();
    private static final float LargeAppBarExpandedHeight = AppBarLargeTokens.INSTANCE.m4702getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m4700getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m4701getLargeContainerHeightD9Ej5fM();

    private TopAppBarDefaults() {
    }

    static final boolean enterAlwaysScrollBehavior$lambda$5$lambda$4() {
        return true;
    }

    static final boolean enterAlwaysScrollBehavior$lambda$7$lambda$6() {
        return true;
    }

    static final boolean exitUntilCollapsedScrollBehavior$lambda$10$lambda$9() {
        return true;
    }

    static final boolean pinnedScrollBehavior$lambda$2$lambda$1() {
        return true;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors centerAlignedTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 513940029, "C(centerAlignedTopAppBarColors)1540@76486L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(513940029, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1540)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: centerAlignedTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4491centerAlignedTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1896017784, "C(centerAlignedTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1570@77887L11:AppBar.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1570)");
        }
        TopAppBarColors topAppBarColorsM4482copytNS2XkQ$default = TopAppBarColors.m4482copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4482copytNS2XkQ$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Composer composer, int i, int i2) {
        Function0 function02;
        ComposerKt.sourceInformationMarkerStart(composer, 959086674, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1718@84505L24,1719@84566L8,1721@84740L7,1722@84806L26,1724@84882L237:AppBar.kt#uh7d8r");
        TopAppBarState topAppBarStateRememberTopAppBarState = (i2 & 1) != 0 ? AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7) : topAppBarState;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1735666662, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$5$lambda$4());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function02 = (Function0) objRememberedValue;
        } else {
            function02 = function0;
        }
        FiniteAnimationSpec finiteAnimationSpecValue = (i2 & 4) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec decayAnimationSpecRememberSplineBasedDecay = (i2 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1723)");
        }
        TopAppBarScrollBehavior topAppBarScrollBehaviorEnterAlwaysScrollBehavior = enterAlwaysScrollBehavior(topAppBarStateRememberTopAppBarState, function02, finiteAnimationSpecValue, decayAnimationSpecRememberSplineBasedDecay, false, composer, (i & 14) | 24576 | (i & 112) | (i & 896) | (i & 7168) | ((i << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarScrollBehaviorEnterAlwaysScrollBehavior;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, boolean z, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 53729710, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1755@86491L24,1756@86552L8,1758@86726L7,1759@86792L26,1762@86901L374:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 94649206, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$7$lambda$6());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(53729710, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1762)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 94660740, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec) | ((((57344 & i) ^ 24576) > 16384 && composer2.changed(z)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            boolean z2 = z;
            EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0, z2);
            composer2.updateRememberedValue(enterAlwaysScrollBehavior);
            objRememberedValue2 = enterAlwaysScrollBehavior;
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior2 = (EnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return enterAlwaysScrollBehavior2;
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1757023234, "C(exitUntilCollapsedScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1795@88631L24,1796@88692L8,1798@88866L7,1799@88932L26,1801@89001L319:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -577174874, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.exitUntilCollapsedScrollBehavior$lambda$10$lambda$9());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1801)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -577164675, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = (ExitUntilCollapsedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return exitUntilCollapsedScrollBehavior;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme colorScheme) {
        TopAppBarColors defaultTopAppBarColorsCached = colorScheme.getDefaultTopAppBarColorsCached();
        if (defaultTopAppBarColorsCached != null) {
            return defaultTopAppBarColorsCached;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getOnScrollContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTitleColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getSubtitleColor()), null);
        colorScheme.setDefaultTopAppBarColorsCached$material3(topAppBarColors);
        return topAppBarColors;
    }

    /* JADX INFO: renamed from: getLargeAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4492getLargeAppBarCollapsedHeightD9Ej5fM() {
        return LargeAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4493getLargeAppBarExpandedHeightD9Ej5fM() {
        return LargeAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4494getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4495getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4496getMediumAppBarCollapsedHeightD9Ej5fM() {
        return MediumAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4497getMediumAppBarExpandedHeightD9Ej5fM() {
        return MediumAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4498getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4499getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getTopAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4500getTopAppBarExpandedHeightD9Ej5fM() {
        return TopAppBarExpandedHeight;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2143182847, "C(<get-windowInsets>)1526@75942L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1526)");
        }
        WindowInsets windowInsetsM2110onlybOOhFvg = WindowInsetsKt.m2110onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m2122plusgK_yJZ4(WindowInsetsSides.INSTANCE.m2132getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM2110onlybOOhFvg;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors largeTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1744932393, "C(largeTopAppBarColors)1639@80652L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1744932393, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1639)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: largeTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4501largeTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1471507700, "C(largeTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1670@82075L11:AppBar.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1670)");
        }
        TopAppBarColors topAppBarColorsM4482copytNS2XkQ$default = TopAppBarColors.m4482copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4482copytNS2XkQ$default;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors mediumTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1268886463, "C(mediumTopAppBarColors)1589@78558L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1268886463, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1589)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: mediumTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4502mediumTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -582474442, "C(mediumTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1620@79983L11:AppBar.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1620)");
        }
        TopAppBarColors topAppBarColorsM4482copytNS2XkQ$default = TopAppBarColors.m4482copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4482copytNS2XkQ$default;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 286497075, "C(pinnedScrollBehavior)N(state,canScroll)1692@83005L24,1693@83066L8,1695@83117L89:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 445787419, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$2$lambda$1());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1695)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 445789132, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new PinnedScrollBehavior(topAppBarState, function0);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        PinnedScrollBehavior pinnedScrollBehavior = (PinnedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return pinnedScrollBehavior;
    }

    public final TopAppBarColors topAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1388520854, "C(topAppBarColors)1444@72002L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388520854, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1444)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public final TopAppBarColors m4503topAppBarColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        ComposerKt.sourceInformationMarkerStart(composer, -1325733438, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color)1467@73186L11:AppBar.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        long jM6361getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            j7 = jM6361getUnspecified0d7_KjU;
            ComposerKt.traceEventStart(-1325733438, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1467)");
        } else {
            j7 = jM6361getUnspecified0d7_KjU;
        }
        TopAppBarColors topAppBarColorsM4484copytNS2XkQ = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4484copytNS2XkQ(j7, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, jM6361getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4484copytNS2XkQ;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility in favor of topAppBarColors with subtitleContentColor")
    /* JADX INFO: renamed from: topAppBarColors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ TopAppBarColors m4504topAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2142919275, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1499@74610L367:AppBar.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2142919275, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1499)");
        }
        TopAppBarColors topAppBarColorsM4503topAppBarColors5tl4gsc = m4503topAppBarColors5tl4gsc(jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, jM6361getUnspecified0d7_KjU4, composer, (65534 & i) | ((i << 6) & 458752) | ((i << 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4503topAppBarColors5tl4gsc;
    }
}
