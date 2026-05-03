package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalRuler;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010%\u001a\u00020\b*\u00020\bH\u0000\"\u0016\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015\"\u0016\u0010\u0019\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015\"\u0016\u0010\u001b\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeWithContentHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getBadgeWithContentHorizontalPadding", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "BadgeOffset", "getBadgeOffset", "BadgeTopRuler", "Landroidx/compose/ui/layout/HorizontalRuler;", "getBadgeTopRuler", "()Landroidx/compose/ui/layout/HorizontalRuler;", "BadgeEndRuler", "Landroidx/compose/ui/layout/VerticalRuler;", "getBadgeEndRuler", "()Landroidx/compose/ui/layout/VerticalRuler;", "badgeBounds", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt {
    private static final float BadgeWithContentHorizontalPadding = Dp.m9114constructorimpl(4.0f);
    private static final float BadgeWithContentHorizontalOffset = Dp.m9114constructorimpl(12.0f);
    private static final float BadgeWithContentVerticalOffset = Dp.m9114constructorimpl(14.0f);
    private static final float BadgeOffset = Dp.m9114constructorimpl(6.0f);
    private static final HorizontalRuler BadgeTopRuler = new HorizontalRuler();
    private static final VerticalRuler BadgeEndRuler = new VerticalRuler();

    /* JADX WARN: Removed duplicated region for block: B:107:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX INFO: renamed from: Badge-eopBjH0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3320BadgeeopBjH0(Modifier modifier, long j, long j2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3479contentColorForek8zF_U;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape value;
        Composer composerStartRestartGroup = composer.startRestartGroup(1428256508);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Badge)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)165@6561L876:Badge.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            containerColor = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(containerColor)) ? 32 : 16;
        } else {
            containerColor = j;
        }
        if ((i & 384) == 0) {
            jM3479contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM3479contentColorForek8zF_U = j2;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                function32 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function32) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@6161L14,153@6203L31");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        containerColor = BadgeDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i5 != 0) {
                        function32 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1428256508, i3, -1, "androidx.compose.material3.Badge (Badge.kt:155)");
                }
                BadgeTokens badgeTokens = BadgeTokens.INSTANCE;
                float fM4724getLargeSizeD9Ej5fM = function32 != null ? badgeTokens.m4724getLargeSizeD9Ej5fM() : badgeTokens.m4725getSizeD9Ej5fM();
                if (function32 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1051012910);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6458L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1050955529);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@6511L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierThen = BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2067defaultMinSizeVpY3zN4(companion, fM4724getLargeSizeD9Ej5fM, fM4724getLargeSizeD9Ej5fM), containerColor, value).then(function32 != null ? PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null) : Modifier.INSTANCE);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1345794914, "C:Badge.kt#uh7d8r");
                if (function32 != null) {
                    composerStartRestartGroup.startReplaceGroup(1345815094);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "180@7239L5,184@7393L13,181@7257L164");
                    ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(jM3479contentColorForek8zF_U, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(541712501, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i6) {
                            ComposerKt.sourceInformation(composer3, "C184@7395L9:Badge.kt#uh7d8r");
                            if (!composer3.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(541712501, i6, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:184)");
                            }
                            function32.invoke(rowScopeInstance, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1346141834);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            final long j3 = containerColor;
            final long j4 = jM3479contentColorForek8zF_U;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.Badge_eopBjH0$lambda$4(modifier3, j3, j4, function33, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        function32 = function3;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        final long j32 = containerColor;
        final long j42 = jM3479contentColorForek8zF_U;
        final Function3 function332 = function32;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit Badge_eopBjH0$lambda$4(Modifier modifier, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3320BadgeeopBjH0(modifier, j, j2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1693825945);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BadgedBox)N(badge,modifier,content)78@3019L2193,68@2698L2514:Badge.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function32) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1693825945, i3, -1, "androidx.compose.material3.BadgedBox (Badge.kt:67)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 25889624, "CC(remember):Badge.kt#9igjgp");
                BadgeKt$BadgedBox$1$1 badgeKt$BadgedBox$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (badgeKt$BadgedBox$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    badgeKt$BadgedBox$1$1RememberedValue = BadgeKt$BadgedBox$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(badgeKt$BadgedBox$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) badgeKt$BadgedBox$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 174143753, "C71@2767L162,76@2942L59:Badge.kt#uh7d8r");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "anchor");
                Alignment center = Alignment.INSTANCE.getCenter();
                int i5 = ((i3 << 3) & 7168) | 54;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
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
                function32.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "badge");
                int i6 = ((i3 << 9) & 7168) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.BadgedBox$lambda$2(function3, modifier3, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit BadgedBox$lambda$2(Function3 function3, Modifier modifier, Function3 function32, int i, int i2, Composer composer, int i3) {
        BadgedBox(function3, modifier, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Modifier badgeBounds(Modifier modifier) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BadgeKt.badgeBounds$lambda$7((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult badgeBounds$lambda$7(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BadgeKt.badgeBounds$lambda$7$lambda$5((RulerScope) obj);
            }
        }, new Function1() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BadgeKt.badgeBounds$lambda$7$lambda$6(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit badgeBounds$lambda$7$lambda$5(RulerScope rulerScope) {
        rulerScope.provides(BadgeEndRuler, (int) (rulerScope.getCoordinates().mo7777getSizeYbymL2g() >> 32));
        rulerScope.provides(BadgeTopRuler, 0.0f);
        return Unit.INSTANCE;
    }

    static final Unit badgeBounds$lambda$7$lambda$6(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final VerticalRuler getBadgeEndRuler() {
        return BadgeEndRuler;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }

    public static final HorizontalRuler getBadgeTopRuler() {
        return BadgeTopRuler;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }
}
