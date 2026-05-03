package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u007f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a7\u0010!\u001a\u00020\u00012\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002\u001aD\u0010)\u001a\u00020\u0001*\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0002\"\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u000e\u00105\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0010\u0010>\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006?²\u0006\n\u0010@\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"Tab", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "TabFadeInAnimationDuration", "TabFadeInAnimationDelay", "TabFadeOutAnimationDuration", "HorizontalTextPadding", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material", "color"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = Dp.m9114constructorimpl(48.0f);
    private static final float LargeTabHeight = Dp.m9114constructorimpl(72.0f);
    private static final float HorizontalTextPadding = Dp.m9114constructorimpl(16.0f);
    private static final float SingleLineTextBaselineWithIcon = Dp.m9114constructorimpl(14.0f);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m9114constructorimpl(6.0f);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m9114constructorimpl(8.0f);

    /* JADX WARN: Removed duplicated region for block: B:121:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX INFO: renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3187LeadingIconTab0nDMI0(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        int i6;
        Composer composer2;
        final long j3;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6335unboximpl;
        long jM6324copywmQWz5c$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-524682663);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LeadingIconTab)N(selected,onClick,text,icon,modifier,enabled,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)165@7275L921,165@7205L991:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function23 = function22;
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
        } else {
            function23 = function22;
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 == 0) {
                    if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((12582912 & i) != 0) {
                        i6 = i3 | (((i2 & 128) == 0 && composerStartRestartGroup.changed(j)) ? 8388608 : 4194304);
                    } else {
                        i6 = i3;
                    }
                    if ((i & 100663296) == 0) {
                        i6 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j2)) ? 67108864 : 33554432;
                    }
                    if (composerStartRestartGroup.shouldExecute((38347923 & i6) == 38347922, i6 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j3 = j;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j4 = j2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i5 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i6 &= -29360129;
                                jM6335unboximpl = ((Color) objConsume).m6335unboximpl();
                            } else {
                                jM6335unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(jM6335unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i6 &= -234881025;
                            }
                            final boolean z5 = z3;
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-524682663, i6, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                            }
                            final IndicationNodeFactory indicationNodeFactoryM3125rippleH2RKhps$default = RippleKt.m3125rippleH2RKhps$default(true, 0.0f, jM6335unboximpl, 2, null);
                            final Modifier modifier4 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            int i8 = i6 >> 21;
                            long j5 = jM6335unboximpl;
                            m3190TabTransitionKlgxPg(j5, jM6324copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier4, z, mutableInteractionSource4, indicationNodeFactoryM3125rippleH2RKhps$default, z5, function0, function24, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 << 6) & 896) | (i8 & 112) | (i8 & 14) | 3072);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            z4 = z5;
                            j4 = jM6324copywmQWz5c$default;
                            j3 = jM6335unboximpl;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            jM6335unboximpl = j;
                        }
                        jM6324copywmQWz5c$default = j2;
                        final boolean z52 = z3;
                        final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final IndicationNodeFactory indicationNodeFactoryM3125rippleH2RKhps$default2 = RippleKt.m3125rippleH2RKhps$default(true, 0.0f, jM6335unboximpl, 2, null);
                        final Modifier modifier42 = modifier2;
                        final Function2 function242 = function23;
                        int i82 = i6 >> 21;
                        long j52 = jM6335unboximpl;
                        m3190TabTransitionKlgxPg(j52, jM6324copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier42, z, mutableInteractionSource42, indicationNodeFactoryM3125rippleH2RKhps$default2, z52, function0, function242, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 << 6) & 896) | (i82 & 112) | (i82 & 14) | 3072);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        z4 = z52;
                        j4 = jM6324copywmQWz5c$default;
                        j3 = jM6335unboximpl;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function22, modifier3, z4, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((12582912 & i) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((38347923 & i6) == 38347922, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 64;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i6) == 38347922, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i6) == 38347922, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit LeadingIconTab_0nD_MI0$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function2 function2, Function2 function22, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C166@7285L905:Tab.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415722219, i, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:166)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m2039paddingVpY3zN4$default(SelectableKt.m2307selectableO2vRcR0(SizeKt.m2069height3ABfNKs(modifier, SmallTabHeight), z, mutableInteractionSource, indicationNodeFactory, z2, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function0), HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 322948405, "C183@7959L6,184@7978L59,185@8076L10,186@8141L39:Tab.kt#jmzs0o");
            function2.invoke(composer, 0);
            SpacerKt.Spacer(SizeKt.m2080requiredWidth3ABfNKs(Modifier.INSTANCE, TextDistanceFromLeadingIcon), composer, 6);
            TextKt.ProvideTextStyle(TextStyle.m8569copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8992getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function22, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit LeadingIconTab_0nD_MI0$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function22, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3187LeadingIconTab0nDMI0(z, function0, function2, function22, modifier, z2, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    /* JADX INFO: renamed from: Tab-0nD-MI0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3188Tab0nDMI0(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6335unboximpl;
        long j5;
        long jM6324copywmQWz5c$default;
        MutableInteractionSource mutableInteractionSource3;
        int i11;
        int i12;
        boolean z5;
        final ComposableLambda composableLambdaRememberComposableLambda;
        long j6;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-610760526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,text,icon,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)113@4852L65,105@4682L235:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function23 = function2;
                        i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 != 0) {
                        if ((196608 & i) == 0) {
                            function24 = function22;
                            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0) {
                                i13 = i3;
                                i9 = i14;
                                int i15 = composerStartRestartGroup.changed(j) ? 8388608 : 4194304;
                                i8 = i13 | i15;
                            } else {
                                i13 = i3;
                                i9 = i14;
                            }
                            i8 = i13 | i15;
                        } else {
                            i8 = i3;
                            i9 = i14;
                        }
                        if ((i & 100663296) == 0) {
                            i8 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j2)) ? 67108864 : 33554432;
                        }
                        i10 = i8;
                        if (composerStartRestartGroup.shouldExecute((i10 & 38347923) != 38347922, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                }
                                if (i5 != 0) {
                                    function23 = null;
                                }
                                if (i6 != 0) {
                                    function24 = null;
                                }
                                MutableInteractionSource mutableInteractionSource4 = i7 != 0 ? null : mutableInteractionSource;
                                if ((i2 & 128) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6335unboximpl = ((Color) objConsume).m6335unboximpl();
                                    i10 &= -29360129;
                                } else {
                                    jM6335unboximpl = j;
                                }
                                if ((i2 & 256) != 0) {
                                    long j7 = jM6335unboximpl;
                                    j5 = j7;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    i12 = i10 & (-234881025);
                                    i11 = 12582912;
                                    jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(j7, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                } else {
                                    j5 = jM6335unboximpl;
                                    jM6324copywmQWz5c$default = j2;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    i11 = 12582912;
                                    i12 = i10;
                                }
                                z5 = z3;
                                composableLambdaRememberComposableLambda = null;
                                j6 = j5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i12 = (i2 & 128) != 0 ? i10 & (-29360129) : i10;
                                if ((i2 & 256) != 0) {
                                    i12 &= -234881025;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                jM6324copywmQWz5c$default = j2;
                                i11 = 12582912;
                                z5 = z3;
                                composableLambdaRememberComposableLambda = null;
                                j6 = j;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-610760526, i12, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                            }
                            if (function23 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1684876703);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1684876702);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_0nD_MI0$lambda$0$0(function23, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i16 = (i12 & 14) | i11 | (i12 & 112) | (i12 & 896) | (i12 & 7168);
                            int i17 = i12 >> 6;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier4 = modifier2;
                            m3189TabEVJuX4I(z, function0, modifier4, z5, mutableInteractionSource3, j6, jM6324copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function24, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (57344 & i17) | i16 | (458752 & i17) | (i17 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function25 = function23;
                            function26 = function24;
                            modifier3 = modifier4;
                            z4 = z5;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            j3 = j6;
                            j4 = jM6324copywmQWz5c$default;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z4 = z3;
                            function25 = function23;
                            function26 = function24;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z4, function25, function26, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function24 = function22;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    i10 = i8;
                    if (composerStartRestartGroup.shouldExecute((i10 & 38347923) != 38347922, i10 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function23 = function2;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                function24 = function22;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i10 = i8;
                if (composerStartRestartGroup.shouldExecute((i10 & 38347923) != 38347922, i10 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function2;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            function24 = function22;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i10 = i8;
            if (composerStartRestartGroup.shouldExecute((i10 & 38347923) != 38347922, i10 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function2;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        function24 = function22;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i10 = i8;
        if (composerStartRestartGroup.shouldExecute((i10 & 38347923) != 38347922, i10 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f1  */
    /* JADX INFO: renamed from: Tab-EVJuX4I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3189TabEVJuX4I(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        long jM6335unboximpl;
        long j3;
        int i6;
        final Modifier modifier3;
        Composer composer2;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        long j6;
        final Modifier modifier4;
        final boolean z5;
        long jM6324copywmQWz5c$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1847932236);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,content)235@10460L602,235@10390L672:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            jM6335unboximpl = j;
                            int i9 = composerStartRestartGroup.changed(jM6335unboximpl) ? 131072 : 65536;
                            i3 |= i9;
                        } else {
                            jM6335unboximpl = j;
                        }
                        i3 |= i9;
                    } else {
                        jM6335unboximpl = j;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            j3 = j2;
                            int i10 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                            i3 |= i10;
                        } else {
                            j3 = j2;
                        }
                        i3 |= i10;
                    } else {
                        j3 = j2;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    }
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i6 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        z4 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j4 = jM6335unboximpl;
                        j5 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i5 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 32) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6335unboximpl = ((Color) objConsume).m6335unboximpl();
                                i7 = i6 & (-458753);
                            } else {
                                i7 = i6;
                            }
                            j6 = jM6335unboximpl;
                            if ((i2 & 64) != 0) {
                                i7 &= -3670017;
                                modifier4 = modifier2;
                                jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                z5 = z3;
                                final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1847932236, i7, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                                }
                                long j7 = j6;
                                final IndicationNodeFactory indicationNodeFactoryM3125rippleH2RKhps$default = RippleKt.m3125rippleH2RKhps$default(true, 0.0f, j7, 2, null);
                                int i11 = i7 >> 15;
                                m3190TabTransitionKlgxPg(j7, jM6324copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource4, indicationNodeFactoryM3125rippleH2RKhps$default, z5, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i7 << 6) & 896) | (i11 & 112) | (i11 & 14) | 3072);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                j4 = j7;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                j5 = jM6324copywmQWz5c$default;
                                modifier3 = modifier4;
                                z4 = z5;
                            } else {
                                modifier4 = modifier2;
                                z5 = z3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i7 = (i2 & 32) != 0 ? i6 & (-458753) : i6;
                            if ((i2 & 64) != 0) {
                                i7 &= -3670017;
                            }
                            z5 = z3;
                            j6 = jM6335unboximpl;
                            modifier4 = modifier2;
                        }
                        jM6324copywmQWz5c$default = j3;
                        final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        long j72 = j6;
                        final IndicationNodeFactory indicationNodeFactoryM3125rippleH2RKhps$default2 = RippleKt.m3125rippleH2RKhps$default(true, 0.0f, j72, 2, null);
                        int i112 = i7 >> 15;
                        m3190TabTransitionKlgxPg(j72, jM6324copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource42, indicationNodeFactoryM3125rippleH2RKhps$default2, z5, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i7 << 6) & 896) | (i112 & 112) | (i112 & 14) | 3072);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        j4 = j72;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        j5 = jM6324copywmQWz5c$default;
                        modifier3 = modifier4;
                        z4 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z4, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1466813041);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabBaselineLayout)N(text,icon)305@12918L1803,298@12674L2047:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1466813041, i2, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:297)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 858071932, "CC(remember):Tab.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            TabKt$TabBaselineLayout$2$1 tabKt$TabBaselineLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || tabKt$TabBaselineLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                tabKt$TabBaselineLayout$2$1RememberedValue = new TabKt$TabBaselineLayout$2$1(function2, function22);
                composerStartRestartGroup.updateRememberedValue(tabKt$TabBaselineLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) tabKt$TabBaselineLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044963090, "C:Tab.kt#jmzs0o");
            if (function2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1044948645);
                ComposerKt.sourceInformation(composerStartRestartGroup, "300@12723L85");
                Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022846780, "C300@12800L6:Tab.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1057560344);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-1044815097);
                ComposerKt.sourceInformation(composerStartRestartGroup, "303@12859L41");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1180634875, "C303@12892L6:Tab.kt#jmzs0o");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1057560344);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.TabBaselineLayout$lambda$2(function2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TabBaselineLayout$lambda$2(Function2 function2, Function2 function22, int i, Composer composer, int i2) {
        TabBaselineLayout(function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    private static final void m3190TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1841653376);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)267@11494L26,269@11557L549,284@12111L165:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1841653376, i2, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
            }
            int i3 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, composerStartRestartGroup, i3 & 14, 2);
            Function3 function3 = new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j3 = zBooleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            ColorSpace colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j4 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6315boximpl = Color.m6315boximpl(j4);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j5 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl, Color.m6315boximpl(j5), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(Color.m6324copywmQWz5c$default(TabTransition_Klgx_Pg$lambda$2(stateCreateTransitionAnimation), 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(TabTransition_Klgx_Pg$lambda$2(stateCreateTransitionAnimation))))}, function2, composerStartRestartGroup, ProvidedValue.$stable | (i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$3(j, j2, z2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final FiniteAnimationSpec TabTransition_Klgx_Pg$lambda$0(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(297582231);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(297582231, i, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:271)");
        }
        TweenSpec tweenSpecTween = segment.isTransitioningTo(false, true) ? AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing()) : AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween;
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    static final Unit TabTransition_Klgx_Pg$lambda$3(long j, long j2, boolean z, Function2 function2, int i, Composer composer, int i2) {
        m3190TabTransitionKlgxPg(j, j2, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_0nD_MI0$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@4545L10,102@4614L39:Tab.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1101313667, i, -1, "androidx.compose.material.Tab.<anonymous>.<anonymous> (Tab.kt:101)");
            }
            TextKt.ProvideTextStyle(TextStyle.m8569copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8992getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Tab_0nD_MI0$lambda$1(Function2 function2, Function2 function22, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@4862L49:Tab.kt#jmzs0o");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1088373601, i, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:114)");
            }
            TabBaselineLayout(function2, function22, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Tab_0nD_MI0$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, Function2 function2, Function2 function22, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3188Tab0nDMI0(z, function0, modifier, z2, function2, function22, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Tab_EVJuX4I$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C236@10470L586:Tab.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652402312, i, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:236)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m2307selectableO2vRcR0(modifier, z, mutableInteractionSource, indicationNodeFactory, z2, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function0), 0.0f, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Tab_EVJuX4I$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3189TabEVJuX4I(z, function0, modifier, z2, mutableInteractionSource, j, j2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        int iMo1618roundToPx0680j_4 = density.mo1618roundToPx0680j_4(i3 == i4 ? SingleLineTextBaselineWithIcon : DoubleLineTextBaselineWithIcon) + density.mo1618roundToPx0680j_4(TabRowDefaults.INSTANCE.m3197getIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo1617roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - iMo1618roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }
}
