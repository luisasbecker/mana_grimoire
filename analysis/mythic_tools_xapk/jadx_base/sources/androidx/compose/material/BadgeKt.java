package androidx.compose.material;

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
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001aS\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015\"\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b\"\u0016\u0010\u001c\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015\"\u0016\u0010 \u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015¨\u0006\""}, d2 = {"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeRadius", "Landroidx/compose/ui/unit/Dp;", "getBadgeRadius", "()F", "F", "BadgeWithContentRadius", "getBadgeWithContentRadius", "BadgeContentFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeHorizontalOffset", "getBadgeHorizontalOffset", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt {
    private static final float BadgeRadius = Dp.m9114constructorimpl(4.0f);
    private static final float BadgeWithContentRadius = Dp.m9114constructorimpl(8.0f);
    private static final long BadgeContentFontSize = TextUnitKt.getSp(10);
    private static final float BadgeWithContentHorizontalPadding = Dp.m9114constructorimpl(4.0f);
    private static final float BadgeWithContentHorizontalOffset = Dp.m9114constructorimpl(-Dp.m9114constructorimpl(6.0f));
    private static final float BadgeHorizontalOffset = Dp.m9114constructorimpl(-Dp.m9114constructorimpl(4.0f));

    /* JADX WARN: Removed duplicated region for block: B:101:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0224  */
    /* JADX INFO: renamed from: Badge-eopBjH0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2926BadgeeopBjH0(Modifier modifier, long j, long j2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM2977getError0d7_KjU;
        long jM3001contentColorForek8zF_U;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1356170301);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Badge)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)134@5510L722:Badge.kt#jmzs0o");
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
            jM2977getError0d7_KjU = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM2977getError0d7_KjU)) ? 32 : 16;
        } else {
            jM2977getError0d7_KjU = j;
        }
        if ((i & 384) == 0) {
            jM3001contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM3001contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM3001contentColorForek8zF_U = j2;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                function32 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function32) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "126@5221L6,127@5261L32");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        jM2977getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2977getError0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2977getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
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
                    ComposerKt.traceEventStart(-1356170301, i3, -1, "androidx.compose.material.Badge (Badge.kt:129)");
                }
                float f = function32 != null ? BadgeWithContentRadius : BadgeRadius;
                RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(f);
                float f2 = f * 2.0f;
                RoundedCornerShape roundedCornerShape = roundedCornerShapeM2345RoundedCornerShape0680j_4;
                Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(ClipKt.clip(BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2067defaultMinSizeVpY3zN4(companion, Dp.m9114constructorimpl(f2), Dp.m9114constructorimpl(f2)), jM2977getError0d7_KjU, roundedCornerShape), roundedCornerShape), BadgeWithContentHorizontalPadding, 0.0f, 2, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 749620787, "C:Badge.kt#jmzs0o");
                if (function32 != null) {
                    composerStartRestartGroup.startReplaceGroup(749640967);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "145@6030L186,145@5964L252");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(jM3001contentColorForek8zF_U)), ComposableLambdaKt.rememberComposableLambda(1185347010, true, new Function2() { // from class: androidx.compose.material.BadgeKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BadgeKt.Badge_eopBjH0$lambda$0$0(function32, rowScopeInstance, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                } else {
                    composerStartRestartGroup.startReplaceGroup(743729019);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            final long j3 = jM3001contentColorForek8zF_U;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j4 = jM2977getError0d7_KjU;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BadgeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.Badge_eopBjH0$lambda$1(modifier3, j4, j3, function33, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        final long j32 = jM3001contentColorForek8zF_U;
        final Function3 function332 = function32;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Badge_eopBjH0$lambda$0$0(final Function3 function3, final RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@6074L10,147@6188L13,147@6146L56:Badge.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1185347010, i, -1, "androidx.compose.material.Badge.<anonymous>.<anonymous> (Badge.kt:146)");
            }
            TextKt.ProvideTextStyle(TextStyle.m8569copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), 0L, BadgeContentFontSize, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), ComposableLambdaKt.rememberComposableLambda(-2001396045, true, new Function2() { // from class: androidx.compose.material.BadgeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BadgeKt.Badge_eopBjH0$lambda$0$0$0(function3, rowScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Badge_eopBjH0$lambda$0$0$0(Function3 function3, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@6190L9:Badge.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2001396045, i, -1, "androidx.compose.material.Badge.<anonymous>.<anonymous>.<anonymous> (Badge.kt:147)");
            }
            function3.invoke(rowScope, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Badge_eopBjH0$lambda$1(Modifier modifier, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2926BadgeeopBjH0(modifier, j, j2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(898422008);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BadgedBox)N(badge,modifier,content)72@2860L1679,62@2549L1990:Badge.kt#jmzs0o");
        if ((i & 6) == 0) {
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
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function32) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(898422008, i3, -1, "androidx.compose.material.BadgedBox (Badge.kt:61)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95139559, "CC(remember):Badge.kt#9igjgp");
                BadgeKt$BadgedBox$2$1 badgeKt$BadgedBox$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (badgeKt$BadgedBox$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    badgeKt$BadgedBox$2$1RememberedValue = BadgeKt$BadgedBox$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(badgeKt$BadgedBox$2$1RememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) badgeKt$BadgedBox$2$1RememberedValue;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 434732938, "C64@2579L162,69@2754L59:Badge.kt#jmzs0o");
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BadgeKt$$ExternalSyntheticLambda0
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
        if ((i & 384) == 0) {
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

    public static final float getBadgeHorizontalOffset() {
        return BadgeHorizontalOffset;
    }

    public static final float getBadgeRadius() {
        return BadgeRadius;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeWithContentRadius;
    }
}
