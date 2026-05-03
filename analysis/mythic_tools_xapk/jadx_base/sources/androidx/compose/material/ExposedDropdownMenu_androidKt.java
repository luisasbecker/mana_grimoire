package androidx.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expandable", "Lkotlin/Function0;", "menuLabel", "", "updateHeight", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "material", "width", "menuHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:113:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object obj;
        final WindowBoundsCalculator windowBoundsCalculator;
        final int i4;
        MutableIntState mutableIntState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1337700255);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuBox)N(expanded,onExpandedChange,modifier,content)95@4064L7,96@4105L32,97@4155L33,98@4211L33,100@4345L37,103@4408L536,116@4970L29,120@5061L414,132@5536L31,133@5597L38,118@5005L727,140@5749L47,140@5738L58,142@5831L273,142@5802L302:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1337700255, i3, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:94)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Density density = (Density) objConsume;
                final WindowBoundsCalculator windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_android.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334713342, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334711550, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableIntState mutableIntState3 = (MutableIntState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final int iMo1618roundToPx0680j_4 = density.mo1618roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334707258, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final Ref ref = (Ref) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int iExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenuBox$lambda$4(mutableIntState3);
                int iExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenuBox$lambda$1(mutableIntState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334704743, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$4) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$1);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier3, boolean z2) {
                            Density density2 = density;
                            MutableIntState mutableIntState4 = mutableIntState3;
                            MutableIntState mutableIntState5 = mutableIntState2;
                            Modifier modifierM2071heightInVpY3zN4$default = SizeKt.m2071heightInVpY3zN4$default(modifier3, 0.0f, density2.mo1621toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState4)), 1, null);
                            return z2 ? SizeKt.m2088width3ABfNKs(modifierM2071heightInVpY3zN4$default, density2.mo1621toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState5))) : modifierM2071heightInVpY3zN4$default;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334687266, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final FocusRequester focusRequester = (FocusRequester) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334683969, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(iMo1618roundToPx0680j_4);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    obj = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0(ref, windowBoundsCalculatorPlatformWindowBoundsCalculator, iMo1618roundToPx0680j_4, mutableIntState2, mutableIntState3, (LayoutCoordinates) obj2);
                        }
                    };
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    i4 = iMo1618roundToPx0680j_4;
                    mutableIntState = mutableIntState3;
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    mutableIntState = mutableIntState3;
                    obj = objRememberedValue6;
                    i4 = iMo1618roundToPx0680j_4;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334669152, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                int i6 = i3 & 14;
                int i7 = i3;
                boolean z2 = (i6 == 4) | ((i3 & 112) == 32);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$11$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned, (Function0) objRememberedValue7, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3166getExposedDropdownMenuUdPEhr4(), composerStartRestartGroup, 6)), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Modifier modifier3 = modifier2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                final MutableIntState mutableIntState4 = mutableIntState;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 527294489, "C137@5717L9:ExposedDropdownMenu.kt#jmzs0o");
                function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334662320, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                boolean z3 = i6 == 4;
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$13$0(z, focusRequester);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334659470, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changed(i4);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator, ref, i4, mutableIntState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ExposedDropdownMenu_android.OnPlatformWindowBoundsChange((Function0) objRememberedValue9, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier4 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$15(z, function1, modifier4, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$10$0(Ref ref, WindowBoundsCalculator windowBoundsCalculator, int i, MutableIntState mutableIntState, final MutableIntState mutableIntState2, LayoutCoordinates layoutCoordinates) {
        mutableIntState.setIntValue((int) (layoutCoordinates.mo7777getSizeYbymL2g() >> 32));
        ref.setValue(layoutCoordinates);
        updateHeight(windowBoundsCalculator.getVisibleWindowBounds(), (LayoutCoordinates) ref.getValue(), i, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0$0(mutableIntState2, ((Integer) obj).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$10$0$0(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$11$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$13$0(boolean z, FocusRequester focusRequester) {
        if (z) {
            FocusRequester.m5985requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$14$0(WindowBoundsCalculator windowBoundsCalculator, Ref ref, int i, final MutableIntState mutableIntState) {
        updateHeight(windowBoundsCalculator.getVisibleWindowBounds(), (LayoutCoordinates) ref.getValue(), i, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0$0(mutableIntState, ((Integer) obj).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$14$0$0(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$15(boolean z, Function1 function1, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuBox(z, function1, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final Modifier expandable(Modifier modifier, final Function0<Unit> function0, final String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new PointerInputEventHandler() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt.expandable.1

            /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {Videoio.CAP_PROP_XI_WB_KB, Videoio.CAP_PROP_XI_WIDTH}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
            static final class C00571 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00571(Function0<Unit> function0, Continuation<? super C00571> continuation) {
                    super(2, continuation);
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00571 c00571 = new C00571(this.$onExpandedChange, continuation);
                    c00571.L$0 = obj;
                    return c00571;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00571) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
                
                    if (r11 == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, PointerEventPass.Initial, this, 1, null) != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (((PointerInputChange) obj) != null) {
                            this.$onExpandedChange.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.label = 2;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, PointerEventPass.Initial, this);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00571(function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        }), false, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.expandable$lambda$0(str, function0, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    static final Unit expandable$lambda$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExposedDropdownMenu_androidKt.expandable$lambda$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean expandable$lambda$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    private static final void updateHeight(IntRect intRect, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates, true).getTop() - intRect.getTop(), (intRect.getBottom() - intRect.getTop()) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates, true).getBottom())) - i));
    }
}
