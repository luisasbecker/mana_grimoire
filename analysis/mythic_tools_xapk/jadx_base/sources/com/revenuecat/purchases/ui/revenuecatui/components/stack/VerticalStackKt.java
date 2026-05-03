package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.DistributionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerticalStack.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010²\u0006\u001b\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rX\u008a\u0084\u0002"}, d2 = {"VerticalStack", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/VerticalStackScope;", "Lkotlin/ExtensionFunctionType;", "VerticalStack-TN_CM5M", "(Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "latestContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class VerticalStackKt {
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: VerticalStack-TN_CM5M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10570VerticalStackTN_CM5M(final Size size, final Dimension.Vertical dimension, final float f, Modifier modifier, final Function1<? super VerticalStackScope, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final ComposableLambda composableLambdaRememberComposableLambda;
        State stateRememberUpdatedState;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1469174248);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalStack)P(3,1,4:c#ui.unit.Dp,2)35@1530L1243:VerticalStack.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(size) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(dimension) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1469174248, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStack (VerticalStack.kt:34)");
                }
                Arrangement.Vertical verticalM10482toVerticalArrangement3ABfNKs = DistributionKt.m10482toVerticalArrangement3ABfNKs(dimension.getDistribution(), f);
                Alignment.Horizontal alignment = AlignmentKt.toAlignment(dimension.getAlignment());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM10482toVerticalArrangement3ABfNKs, alignment, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 492028798, "C42@1829L76,45@1935L29,46@1985L318,55@2350L324,66@2684L20,67@2719L19,68@2747L20:VerticalStack.kt#280jdz");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(482752801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackKt$VerticalStack$1$fillSpaceSpacer$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C43@1853L42:VerticalStack.kt#280jdz");
                        if ((i5 & 6) == 0) {
                            i5 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i5 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(482752801, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStack.<anonymous>.<anonymous> (VerticalStack.kt:43)");
                        }
                        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, f2, false, 2, null), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composerStartRestartGroup, (i3 >> 12) & 14);
                FlexDistribution distribution = dimension.getDistribution();
                Function1<VerticalStackScope, Unit> function1VerticalStack_TN_CM5M$lambda$2$lambda$0 = VerticalStack_TN_CM5M$lambda$2$lambda$0(stateRememberUpdatedState);
                composerStartRestartGroup.startReplaceGroup(431520218);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VerticalStack.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(distribution) | ((i3 & 896) != 256) | composerStartRestartGroup.changed(function1VerticalStack_TN_CM5M$lambda$2$lambda$0);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    VerticalStackScopeImpl verticalStackScopeImpl = new VerticalStackScopeImpl(dimension.getDistribution(), f, composableLambdaRememberComposableLambda, size.getHeight(), null);
                    VerticalStack_TN_CM5M$lambda$2$lambda$0(stateRememberUpdatedState).invoke(verticalStackScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(verticalStackScopeImpl);
                    objRememberedValue = verticalStackScopeImpl;
                }
                final VerticalStackScopeImpl verticalStackScopeImpl2 = (VerticalStackScopeImpl) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-535287235, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackKt$VerticalStack$1$edgeSpacerIfNeeded$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C62@2631L19:VerticalStack.kt#280jdz");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-535287235, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStack.<anonymous>.<anonymous> (VerticalStack.kt:56)");
                        }
                        if (verticalStackScopeImpl2.getShouldApplyFillSpacers() && (dimension.getDistribution() == FlexDistribution.SPACE_AROUND || dimension.getDistribution() == FlexDistribution.SPACE_EVENLY)) {
                            composableLambdaRememberComposableLambda.invoke(Float.valueOf(1.0f), composer2, 54);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                composableLambdaRememberComposableLambda2.invoke(composerStartRestartGroup, 6);
                verticalStackScopeImpl2.getColumnContent().invoke(columnScopeInstance, composerStartRestartGroup, 6);
                composableLambdaRememberComposableLambda2.invoke(composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackKt$VerticalStack$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        VerticalStackKt.m10570VerticalStackTN_CM5M(size, dimension, f, modifier3, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Arrangement.Vertical verticalM10482toVerticalArrangement3ABfNKs2 = DistributionKt.m10482toVerticalArrangement3ABfNKs(dimension.getDistribution(), f);
            Alignment.Horizontal alignment2 = AlignmentKt.toAlignment(dimension.getAlignment());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM10482toVerticalArrangement3ABfNKs2, alignment2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                final ColumnScope columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 492028798, "C42@1829L76,45@1935L29,46@1985L318,55@2350L324,66@2684L20,67@2719L19,68@2747L20:VerticalStack.kt#280jdz");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(482752801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackKt$VerticalStack$1$fillSpaceSpacer$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C43@1853L42:VerticalStack.kt#280jdz");
                        if ((i5 & 6) == 0) {
                            i5 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i5 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(482752801, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStack.<anonymous>.<anonymous> (VerticalStack.kt:43)");
                        }
                        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, f2, false, 2, null), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composerStartRestartGroup, (i3 >> 12) & 14);
                FlexDistribution distribution2 = dimension.getDistribution();
                Function1<VerticalStackScope, Unit> function1VerticalStack_TN_CM5M$lambda$2$lambda$02 = VerticalStack_TN_CM5M$lambda$2$lambda$0(stateRememberUpdatedState);
                composerStartRestartGroup.startReplaceGroup(431520218);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VerticalStack.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(distribution2) | ((i3 & 896) != 256) | composerStartRestartGroup.changed(function1VerticalStack_TN_CM5M$lambda$2$lambda$02);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    VerticalStackScopeImpl verticalStackScopeImpl3 = new VerticalStackScopeImpl(dimension.getDistribution(), f, composableLambdaRememberComposableLambda, size.getHeight(), null);
                    VerticalStack_TN_CM5M$lambda$2$lambda$0(stateRememberUpdatedState).invoke(verticalStackScopeImpl3);
                    composerStartRestartGroup.updateRememberedValue(verticalStackScopeImpl3);
                    objRememberedValue = verticalStackScopeImpl3;
                    final VerticalStackScopeImpl verticalStackScopeImpl22 = (VerticalStackScopeImpl) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    ComposableLambda composableLambdaRememberComposableLambda22 = ComposableLambdaKt.rememberComposableLambda(-535287235, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStackKt$VerticalStack$1$edgeSpacerIfNeeded$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            ComposerKt.sourceInformation(composer2, "C62@2631L19:VerticalStack.kt#280jdz");
                            if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-535287235, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.VerticalStack.<anonymous>.<anonymous> (VerticalStack.kt:56)");
                            }
                            if (verticalStackScopeImpl22.getShouldApplyFillSpacers() && (dimension.getDistribution() == FlexDistribution.SPACE_AROUND || dimension.getDistribution() == FlexDistribution.SPACE_EVENLY)) {
                                composableLambdaRememberComposableLambda.invoke(Float.valueOf(1.0f), composer2, 54);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54);
                    composableLambdaRememberComposableLambda22.invoke(composerStartRestartGroup, 6);
                    verticalStackScopeImpl22.getColumnContent().invoke(columnScopeInstance2, composerStartRestartGroup, 6);
                    composableLambdaRememberComposableLambda22.invoke(composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final Function1<VerticalStackScope, Unit> VerticalStack_TN_CM5M$lambda$2$lambda$0(State<? extends Function1<? super VerticalStackScope, Unit>> state) {
        return (Function1) state.getValue();
    }
}
