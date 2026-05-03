package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.LayoutReference;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$contentDelegate$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ MutableState $start;
    final /* synthetic */ PaywallState.Loaded.Components $state$inlined;
    final /* synthetic */ TimelineComponentState $timelineState$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, TimelineComponentState timelineComponentState, PaywallState.Loaded.Components components) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$timelineState$inlined = timelineComponentState;
        this.$state$inlined = components;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(Composer composer, int i) {
        int i2;
        float fM9114constructorimpl;
        float f;
        Iterator it;
        PaddingValues paddingValuesM2030PaddingValues0680j_4;
        ArrayList arrayList;
        int i3;
        int i4;
        PaddingValues margin;
        IconComponentStyle icon;
        Size size;
        SizeConstraint height;
        Dp dpDpOrNull;
        ConstrainedLayoutReference constrainedLayoutReference;
        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor;
        ConstrainedLayoutReference constrainedLayoutReference2;
        ComposerKt.sourceInformation(composer, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        int i5 = 2;
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
        }
        this.$contentTracker.setValue(Unit.INSTANCE);
        if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
            this.$compositionSource.setValue(CompositionSource.Content);
        }
        this.$scope.reset();
        ConstraintLayoutScope constraintLayoutScope = this.$scope;
        composer.startReplaceGroup(-425492318);
        ComposerKt.sourceInformation(composer, "C83@4232L174:TimelineComponentView.kt#1cibm8");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        composer.startReplaceGroup(-290820944);
        ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1(this.$timelineState$inlined));
            composer.updateRememberedValue(objRememberedValue);
        }
        State state = (State) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-290812056);
        ComposerKt.sourceInformation(composer, "*102@5037L80,100@4907L225,108@5208L699,107@5146L987,133@6291L679,130@6147L838");
        Iterator it2 = this.$timelineState$inlined.getItems().iterator();
        while (true) {
            i2 = 1;
            if (!it2.hasNext()) {
                break;
            }
            TimelineComponentState.ItemState itemState = (TimelineComponentState.ItemState) it2.next();
            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope.createRefs();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
            LayoutReference[] layoutReferenceArr = new LayoutReference[3];
            layoutReferenceArr[0] = constrainedLayoutReferenceComponent1;
            layoutReferenceArr[1] = constrainedLayoutReferenceComponent2;
            layoutReferenceArr[i5] = constrainedLayoutReferenceComponent3;
            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorM9405createBottomBarrier3ABfNKs$default = ConstraintLayoutBaseScope.m9405createBottomBarrier3ABfNKs$default(constraintLayoutScope2, layoutReferenceArr, 0.0f, i5, null);
            ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor = constraintLayoutScope.m9422createEndBarrier3ABfNKs(new LayoutReference[]{constrainedLayoutReferenceComponent1}, Dp.m9114constructorimpl(this.$timelineState$inlined.getColumnGutter()));
            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2 = (ConstraintLayoutBaseScope.HorizontalAnchor) CollectionsKt.lastOrNull((List) arrayList2);
            arrayList3.add(constrainedLayoutReferenceComponent1);
            arrayList2.add(ConstraintLayoutBaseScope.m9405createBottomBarrier3ABfNKs$default(constraintLayoutScope2, new LayoutReference[]{constrainedLayoutReferenceComponent4}, 0.0f, i5, null));
            Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(this.$timelineState$inlined.getItemSpacing()));
            composer.startReplaceGroup(-290795278);
            ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
            boolean zChanged = composer.changed(horizontalAnchorM9405createBottomBarrier3ABfNKs$default);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$1$1(horizontalAnchorM9405createBottomBarrier3ABfNKs$default);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceGroup();
            SpacerKt.Spacer(constraintLayoutScope.constrainAs(modifierM2069height3ABfNKs, constrainedLayoutReferenceComponent4, (Function1) objRememberedValue2), composer, 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            composer.startReplaceGroup(-290789187);
            ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
            boolean zChanged2 = composer.changed(this.$timelineState$inlined) | composer.changed(horizontalAnchor2) | composer.changed(constrainedLayoutReferenceComponent2) | composer.changed(constrainedLayoutReferenceComponent3);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                constrainedLayoutReference = constrainedLayoutReferenceComponent1;
                horizontalAnchor = horizontalAnchor2;
                constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                objRememberedValue3 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$2$1(this.$timelineState$inlined, horizontalAnchor, constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent3, state);
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                horizontalAnchor = horizontalAnchor2;
                constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                constrainedLayoutReference = constrainedLayoutReferenceComponent1;
            }
            composer.endReplaceGroup();
            Modifier modifierConstrainAs = constraintLayoutScope.constrainAs(companion, constrainedLayoutReference, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierConstrainAs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ConstrainedLayoutReference constrainedLayoutReference3 = constrainedLayoutReference;
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 341317904, "C123@5941L178:TimelineComponentView.kt#1cibm8");
            IconComponentViewKt.IconComponentView(itemState.getIcon(), this.$state$inlined, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextComponentStyle title = itemState.getTitle();
            PaywallState.Loaded.Components components = this.$state$inlined;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            composer.startReplaceGroup(-290754551);
            ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
            boolean zChanged3 = composer.changed(this.$timelineState$inlined) | composer.changed(constrainedLayoutReference3) | composer.changed(horizontalAnchor) | composer.changed(verticalAnchor);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$4$1(this.$timelineState$inlined, constrainedLayoutReference3, horizontalAnchor, verticalAnchor);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceGroup();
            TextComponentViewKt.TextComponentView(title, components, constraintLayoutScope.constrainAs(companion2, constrainedLayoutReferenceComponent2, (Function1) objRememberedValue4), composer, 0, 0);
            TextComponentStyle description = itemState.getDescription();
            composer.startReplaceGroup(-290731404);
            ComposerKt.sourceInformation(composer, "*154@7193L385,151@7039L558");
            if (description != null) {
                PaywallState.Loaded.Components components2 = this.$state$inlined;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                composer.startReplaceGroup(149597858);
                ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged4 = composer.changed(constrainedLayoutReferenceComponent2) | composer.changed(this.$timelineState$inlined);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$5$1$1(constrainedLayoutReferenceComponent2, this.$timelineState$inlined);
                    composer.updateRememberedValue(objRememberedValue5);
                }
                composer.endReplaceGroup();
                TextComponentViewKt.TextComponentView(description, components2, constraintLayoutScope.constrainAs(companion3, constrainedLayoutReference2, (Function1) objRememberedValue5), composer, 0, 0);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            composer.endReplaceGroup();
            i5 = 2;
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-290709150);
        ComposerKt.sourceInformation(composer, "");
        Iterator it3 = this.$timelineState$inlined.getItems().iterator();
        int i6 = 0;
        while (it3.hasNext()) {
            int i7 = i6 + 1;
            TimelineComponentState.ItemState itemState2 = (TimelineComponentState.ItemState) it3.next();
            boolean z = i6 == this.$timelineState$inlined.getItems().size() - i2 ? i2 : 0;
            ConstrainedLayoutReference constrainedLayoutReference4 = (ConstrainedLayoutReference) arrayList3.get(i6);
            ConstrainedLayoutReference constrainedLayoutReference5 = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList3, i7);
            TimelineComponentStyle.ConnectorStyle connector = itemState2.getConnector();
            composer.startReplaceGroup(-290701069);
            ComposerKt.sourceInformation(composer, "*173@8015L548,192@9042L843,205@9935L15,187@8777L1193");
            if (connector == null) {
                it = it3;
                i3 = i7;
                i4 = i2;
                arrayList = arrayList3;
            } else {
                ConstrainedLayoutReference constrainedLayoutReferenceCreateRef = constraintLayoutScope.createRef();
                Object size2 = itemState2.getIcon().getSize();
                composer.startReplaceGroup(149624325);
                ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged5 = composer.changed(size2) | composer.changed(constrainedLayoutReferenceCreateRef);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    SizeConstraint height2 = itemState2.getIcon().getSize().getHeight();
                    float fM9114constructorimpl2 = (height2 instanceof SizeConstraint.Fixed ? (SizeConstraint.Fixed) height2 : null) != null ? Dp.m9114constructorimpl(Dp.m9114constructorimpl(r14.getValue()) / 2.0f) : Dp.m9114constructorimpl(0.0f);
                    Dp dpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(state);
                    if (dpTimelineComponentView$lambda$13$lambda$1 != null) {
                        int iM9128unboximpl = (int) dpTimelineComponentView$lambda$13$lambda$1.m9128unboximpl();
                        fM9114constructorimpl = Dp.m9114constructorimpl(Dp.m9114constructorimpl(iM9128unboximpl - (itemState2.getConnector() != null ? r19.getWidth() : 0)) / 2.0f);
                    } else {
                        fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                    }
                    objRememberedValue6 = TuplesKt.to(Dp.m9112boximpl(fM9114constructorimpl), Dp.m9112boximpl(fM9114constructorimpl2));
                    composer.updateRememberedValue(objRememberedValue6);
                }
                Pair pair = (Pair) objRememberedValue6;
                composer.endReplaceGroup();
                TimelineComponentState.ItemState itemState3 = (TimelineComponentState.ItemState) CollectionsKt.getOrNull(this.$timelineState$inlined.getItems(), i7);
                float fM9114constructorimpl3 = Dp.m9114constructorimpl(((itemState3 == null || (icon = itemState3.getIcon()) == null || (size = icon.getSize()) == null || (height = size.getHeight()) == null || (dpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(height)) == null) ? Dp.m9114constructorimpl(0.0f) : dpDpOrNull.m9128unboximpl()) / 2.0f);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                TimelineComponentStyle.ConnectorStyle connector2 = itemState2.getConnector();
                if (connector2 == null || (margin = connector2.getMargin()) == null) {
                    f = 0.0f;
                    it = it3;
                    paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
                } else {
                    it = it3;
                    paddingValuesM2030PaddingValues0680j_4 = margin;
                    f = 0.0f;
                }
                float f2 = f;
                arrayList = arrayList3;
                i3 = i7;
                i4 = 1;
                Modifier modifierZIndex = ZIndexModifierKt.zIndex(OffsetKt.m1997offsetVpY3zN4$default(PaddingKt.padding(companion4, paddingValuesM2030PaddingValues0680j_4), f2, ((Dp) pair.getSecond()).m9128unboximpl(), 1, null), -1.0f);
                composer.startReplaceGroup(149657484);
                ComposerKt.sourceInformation(composer, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged6 = composer.changed(pair) | composer.changed(itemState2) | composer.changed(constrainedLayoutReference4) | composer.changed(z) | composer.changed(constrainedLayoutReference5) | composer.changed(fM9114constructorimpl3);
                Object objRememberedValue7 = composer.rememberedValue();
                if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$6$1$1(pair, itemState2, constrainedLayoutReference4, z, constrainedLayoutReference5, fM9114constructorimpl3);
                    composer.updateRememberedValue(objRememberedValue7);
                }
                composer.endReplaceGroup();
                BoxKt.Box(OverlayKt.overlay$default(constraintLayoutScope.constrainAs(modifierZIndex, constrainedLayoutReferenceCreateRef, (Function1) objRememberedValue7), ColorStyleKt.getForCurrentTheme(connector.getColor(), composer, 0), null, 2, null), composer, 0);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            composer.endReplaceGroup();
            i2 = i4;
            arrayList3 = arrayList;
            i6 = i3;
            it3 = it;
        }
        composer.endReplaceGroup();
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(this.$scope) | composer.changedInstance(this.$channel);
        final ConstraintLayoutScope constraintLayoutScope3 = this.$scope;
        final MutableState mutableState = this.$start;
        final MutableState mutableState2 = this.$end;
        final Channel channel = this.$channel;
        Object objRememberedValue8 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope3.getContainerObject().mo9592clone());
                    if (mutableState.getValue() != null && mutableState2.getValue() != null) {
                        channel.mo12955trySendJP2dKIU(rawConstraintSet);
                    } else {
                        mutableState.setValue(rawConstraintSet);
                        mutableState2.setValue(mutableState.getValue());
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) objRememberedValue8, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
