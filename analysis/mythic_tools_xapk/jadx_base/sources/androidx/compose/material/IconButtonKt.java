package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\\\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconButtonKt {
    private static final float RippleRadius = Dp.m9114constructorimpl(24.0f);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        final Modifier modifier3;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float disabled;
        Composer composerStartRestartGroup = composer.startRestartGroup(1316660641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButton)N(onClick,modifier,enabled,interactionSource,content)61@2713L645:IconButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
                    }
                    if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z4 = i4 != 0 ? true : z2;
                        MutableInteractionSource mutableInteractionSource3 = i5 != 0 ? null : mutableInteractionSource;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1316660641, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:60)");
                        }
                        Modifier modifierM1514clickableO2vRcR0$default = ClickableKt.m1514clickableO2vRcR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), mutableInteractionSource3, RippleKt.m3125rippleH2RKhps$default(false, RippleRadius, 0L, 4, null), z4, null, Role.m8320boximpl(Role.INSTANCE.m8327getButtono7Vup1c()), function0, 8, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1514clickableO2vRcR0$default);
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
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2013881207, "C75@3268L84:IconButton.kt#jmzs0o");
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(-1874697310);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "74@3225L7");
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContentAlpha);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            disabled = ((Number) objConsume).floatValue();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1874696477);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "74@3251L8");
                            disabled = ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled)), function2, composerStartRestartGroup, ((i3 >> 9) & 112) | ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z3 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.IconButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return IconButtonKt.IconButton$lambda$1(function0, modifier3, z3, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                if ((i & 24576) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit IconButton$lambda$1(Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconButton(function0, modifier, z, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        final Modifier.Companion companion;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float disabled;
        Composer composerStartRestartGroup = composer.startRestartGroup(1097147314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconToggleButton)N(checked,onCheckedChange,modifier,enabled,interactionSource,content)105@4645L699:IconButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
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
                    if ((196608 & i) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                        z4 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z5 = i4 != 0 ? true : z3;
                        MutableInteractionSource mutableInteractionSource4 = i5 != 0 ? null : mutableInteractionSource2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1097147314, i3, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:104)");
                        }
                        Modifier modifierM2314toggleableO2vRcR0 = ToggleableKt.m2314toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), z, mutableInteractionSource4, RippleKt.m3125rippleH2RKhps$default(false, RippleRadius, 0L, 4, null), z5, Role.m8320boximpl(Role.INSTANCE.m8329getCheckboxo7Vup1c()), function1);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2314toggleableO2vRcR0);
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
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 386825542, "C120@5254L84:IconButton.kt#jmzs0o");
                        if (z5) {
                            composerStartRestartGroup.startReplaceGroup(1952142323);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "119@5211L7");
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContentAlpha);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            disabled = ((Number) objConsume).floatValue();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1952143156);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "119@5237L8");
                            disabled = ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled)), function2, composerStartRestartGroup, ((i3 >> 12) & 112) | ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource4;
                        z4 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.IconButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return IconButtonKt.IconToggleButton$lambda$1(z, function1, companion, z4, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit IconToggleButton$lambda$1(boolean z, Function1 function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconToggleButton(z, function1, modifier, z2, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
