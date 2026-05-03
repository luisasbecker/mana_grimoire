package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationBarHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aT\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0081\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\"\u0016\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+\"\u0016\u0010-\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+\"\u0016\u0010/\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b0\u0010+\"\u0016\u00101\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+\"\u0016\u00103\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b4\u0010+\"\u0016\u00105\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+\"\u0016\u00107\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b8\u0010+¨\u00069"}, d2 = {"ShortNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ShortNavigationBar-kQ6Tpik", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShortNavigationBarItem", "selected", "", "onClick", "icon", Constants.ScionAnalytics.PARAM_LABEL, "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ShortNavigationBarItem-6ZDA4I0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LocalShortNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "getLocalShortNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "TopIconItemVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTopIconItemVerticalPadding", "()F", "F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarKt {
    private static final ProvidableCompositionLocal<ShortNavigationBarOverride> LocalShortNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultShortNavigationBarOverride.INSTANCE;
        }
    }, 1, null);
    private static final float TopIconItemVerticalPadding = NavigationBarVerticalItemTokens.INSTANCE.m5132getContainerBetweenSpaceD9Ej5fM();
    private static final float TopIconIndicatorVerticalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5130getActiveIndicatorHeightD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5133getIconSizeD9Ej5fM()) / 2.0f);
    private static final float TopIconIndicatorHorizontalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5131getActiveIndicatorWidthD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5133getIconSizeD9Ej5fM()) / 2.0f);
    private static final float StartIconIndicatorVerticalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationBarHorizontalItemTokens.INSTANCE.m5121getActiveIndicatorHeightD9Ej5fM() - NavigationBarHorizontalItemTokens.INSTANCE.m5124getIconSizeD9Ej5fM()) / 2.0f);
    private static final float TopIconIndicatorToLabelPadding = Dp.m9114constructorimpl(4.0f);
    private static final float StartIconIndicatorHorizontalPadding = NavigationBarHorizontalItemTokens.INSTANCE.m5122getActiveIndicatorLeadingSpaceD9Ej5fM();
    private static final float StartIconToLabelPadding = NavigationBarTokens.INSTANCE.m5127getItemActiveIndicatorIconLabelSpaceD9Ej5fM();

    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX INFO: renamed from: ShortNavigationBar-kQ6Tpik, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4066ShortNavigationBarkQ6Tpik(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long containerColor;
        long contentColor;
        WindowInsets windowInsets2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Modifier modifier3;
        final long j3;
        final long j4;
        final WindowInsets windowInsets3;
        final int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM4064getArrangementLnnQw40;
        long j5;
        WindowInsets windowInsets4;
        Composer composerStartRestartGroup = composer.startRestartGroup(552087412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,windowInsets,arrangement:c#material3.ShortNavigationBarArrangement,content)102@4884L7,*111@5217L20:ShortNavigationBar.kt#uh7d8r");
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                containerColor = j;
                int i8 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i4 |= i8;
            } else {
                containerColor = j;
            }
            i4 |= i8;
        } else {
            containerColor = j;
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                contentColor = j2;
                int i9 = composerStartRestartGroup.changed(contentColor) ? 256 : 128;
                i4 |= i9;
            } else {
                contentColor = j2;
            }
            i4 |= i9;
        } else {
            contentColor = j2;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                windowInsets2 = windowInsets;
                int i10 = composerStartRestartGroup.changed(windowInsets2) ? 2048 : 1024;
                i4 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            i4 |= i10;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                i5 = i;
                int i11 = composerStartRestartGroup.changed(i5) ? 16384 : 8192;
                i4 |= i11;
            } else {
                i5 = i;
            }
            i4 |= i11;
        } else {
            i5 = i;
        }
        if ((i3 & 32) == 0) {
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                function22 = function2;
                i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = containerColor;
                j4 = contentColor;
                windowInsets3 = windowInsets2;
                i6 = i5;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@4556L14,97@4625L12,98@4699L12");
                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 2) != 0) {
                        containerColor = ShortNavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        contentColor = ShortNavigationBarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                        windowInsets2 = ShortNavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        modifier3 = companion;
                        iM4064getArrangementLnnQw40 = ShortNavigationBarDefaults.INSTANCE.m4064getArrangementLnnQw40();
                        j5 = contentColor;
                        windowInsets4 = windowInsets2;
                        long j6 = containerColor;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(552087412, i4, -1, "androidx.compose.material3.ShortNavigationBar (ShortNavigationBar.kt:101)");
                        }
                        ProvidableCompositionLocal<ShortNavigationBarOverride> providableCompositionLocal = LocalShortNavigationBarOverride;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ((ShortNavigationBarOverride) objConsume).ShortNavigationBar(new ShortNavigationBarOverrideScope(modifier3, j6, j5, windowInsets4, iM4064getArrangementLnnQw40, function22, null), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = j6;
                        j4 = j5;
                        windowInsets3 = windowInsets4;
                        i6 = iM4064getArrangementLnnQw40;
                    } else {
                        modifier3 = companion;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    modifier3 = modifier2;
                }
                j5 = contentColor;
                windowInsets4 = windowInsets2;
                iM4064getArrangementLnnQw40 = i5;
                long j62 = containerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<ShortNavigationBarOverride> providableCompositionLocal2 = LocalShortNavigationBarOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ShortNavigationBarOverride) objConsume2).ShortNavigationBar(new ShortNavigationBarOverrideScope(modifier3, j62, j5, windowInsets4, iM4064getArrangementLnnQw40, function22, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = j62;
                j4 = j5;
                windowInsets3 = windowInsets4;
                i6 = iM4064getArrangementLnnQw40;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ShortNavigationBarKt.ShortNavigationBar_kQ6Tpik$lambda$1(modifier4, j3, j4, windowInsets3, i6, function2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function22 = function2;
        if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f8  */
    /* JADX INFO: renamed from: ShortNavigationBarItem-6ZDA4I0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4067ShortNavigationBarItem6ZDA4I0(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z2, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        boolean z3;
        int i4;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        final Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int iM3886getTopxw1Ddg;
        NavigationItemColors navigationItemColorsColors;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final boolean z5;
        final int i10;
        final NavigationItemColors navigationItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean z6;
        NavigationItemColors navigationItemColors3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1164996656);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBarItem)N(selected,onClick,icon,label,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)241@10566L5,242@10643L5,237@10414L842:ShortNavigationBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i2 & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
            }
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
            function24 = function22;
        } else {
            function24 = function22;
            if ((i2 & 3072) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
            }
        }
        int i12 = i3 & 16;
        if (i12 != 0) {
            i4 |= 24576;
        } else {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((1572864 & i2) == 0) {
                        iM3886getTopxw1Ddg = i;
                        i4 |= composerStartRestartGroup.changed(iM3886getTopxw1Ddg) ? 1048576 : 524288;
                    }
                    if ((12582912 & i2) != 0) {
                        if ((i3 & 128) == 0) {
                            navigationItemColorsColors = navigationItemColors;
                            int i13 = composerStartRestartGroup.changed(navigationItemColorsColors) ? 8388608 : 4194304;
                            i4 |= i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        i4 |= i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    i7 = i3 & 256;
                    if (i7 != 0) {
                        if ((i2 & 100663296) == 0) {
                            i8 = i7;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        i9 = i4;
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "217@9765L8");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    iM3886getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg();
                                }
                                if ((i3 & 128) != 0) {
                                    i11 = i9 & (-29360129);
                                    navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                } else {
                                    i11 = i9;
                                }
                                mutableInteractionSource3 = i8 != 0 ? null : mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i11 = i9 & (-29360129);
                                    modifier3 = modifier2;
                                    z6 = z4;
                                    navigationItemColors3 = navigationItemColorsColors;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1164996656, i11, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:219)");
                                    }
                                    if (mutableInteractionSource3 != null) {
                                        composerStartRestartGroup.startReplaceGroup(1215858123);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "221@9917L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694551, "CC(remember):ShortNavigationBar.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1424693900);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    boolean zM3881equalsimpl0 = NavigationItemIconPosition.m3881equalsimpl0(iM3886getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg());
                                    float f = !zM3881equalsimpl0 ? TopIconIndicatorHorizontalPadding : StartIconIndicatorHorizontalPadding;
                                    float f2 = !zM3881equalsimpl0 ? TopIconIndicatorVerticalPadding : StartIconIndicatorVerticalPadding;
                                    int i14 = i11 >> 6;
                                    composer2 = composerStartRestartGroup;
                                    int i15 = iM3886getTopxw1Ddg;
                                    NavigationItemKt.m3890NavigationItem8Df7sds(z3, function02, function23, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5131getActiveIndicatorWidthD9Ej5fM(), f, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function24, i15, mutableInteractionSource4, composer2, (i11 & 14) | 906166272 | (i11 & 112) | (i11 & 896), 6 | ((i11 >> 18) & 112) | (i14 & 896) | (i14 & 7168) | ((i11 << 3) & 57344) | ((i11 >> 3) & 458752));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    navigationItemColors2 = navigationItemColors3;
                                    modifier2 = modifier3;
                                    z5 = z6;
                                    i10 = i15;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i11 = i9;
                                }
                            }
                            modifier3 = modifier2;
                            z6 = z4;
                            navigationItemColors3 = navigationItemColorsColors;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (mutableInteractionSource3 != null) {
                            }
                            boolean zM3881equalsimpl02 = NavigationItemIconPosition.m3881equalsimpl0(iM3886getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg());
                            float f3 = !zM3881equalsimpl02 ? TopIconIndicatorHorizontalPadding : StartIconIndicatorHorizontalPadding;
                            if (!zM3881equalsimpl02) {
                            }
                            int i142 = i11 >> 6;
                            composer2 = composerStartRestartGroup;
                            int i152 = iM3886getTopxw1Ddg;
                            NavigationItemKt.m3890NavigationItem8Df7sds(z3, function02, function23, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5131getActiveIndicatorWidthD9Ej5fM(), f3, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function24, i152, mutableInteractionSource4, composer2, (i11 & 14) | 906166272 | (i11 & 112) | (i11 & 896), 6 | ((i11 >> 18) & 112) | (i142 & 896) | (i142 & 7168) | ((i11 << 3) & 57344) | ((i11 >> 3) & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationItemColors2 = navigationItemColors3;
                            modifier2 = modifier3;
                            z5 = z6;
                            i10 = i152;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z5 = z4;
                            i10 = iM3886getTopxw1Ddg;
                            navigationItemColors2 = navigationItemColorsColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$3(z, function0, function2, function22, modifier2, z5, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    i8 = i7;
                    i9 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                iM3886getTopxw1Ddg = i;
                if ((12582912 & i2) != 0) {
                }
                i7 = i3 & 256;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            iM3886getTopxw1Ddg = i;
            if ((12582912 & i2) != 0) {
            }
            i7 = i3 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        iM3886getTopxw1Ddg = i;
        if ((12582912 & i2) != 0) {
        }
        i7 = i3 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ShortNavigationBarItem_6ZDA4I0$lambda$3(boolean z, Function0 function0, Function2 function2, Function2 function22, Modifier modifier, boolean z2, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m4067ShortNavigationBarItem6ZDA4I0(z, function0, function2, function22, modifier, z2, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit ShortNavigationBar_kQ6Tpik$lambda$1(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, Function2 function2, int i2, int i3, Composer composer, int i4) {
        m4066ShortNavigationBarkQ6Tpik(modifier, j, j2, windowInsets, i, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i2) {
        if (i > 6) {
            return 0;
        }
        return MathKt.roundToInt((((100 - ((i + 3) * 10)) / 2.0f) / 100.0f) * i2);
    }

    public static final ProvidableCompositionLocal<ShortNavigationBarOverride> getLocalShortNavigationBarOverride() {
        return LocalShortNavigationBarOverride;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }
}
