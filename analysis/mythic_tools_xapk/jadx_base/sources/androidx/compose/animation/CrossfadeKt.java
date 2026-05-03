package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f2&\u0010\u000b\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Crossfade", "", ExifInterface.GPS_DIRECTION_TRUE, "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", Constants.ScionAnalytics.PARAM_LABEL, "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CrossfadeKt {
    /* JADX WARN: Removed duplicated region for block: B:133:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
        int i4;
        Function1<? super T, ? extends Object> function12;
        final Function1<? super T, ? extends Object> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super T, ? extends Object> function14;
        SnapshotStateList snapshotStateList;
        final Transition<T> transition2 = transition;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1877370462);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3!1,2)100@4602L6,103@4692L64,104@4778L61,134@6037L111:Crossfade.kt#xbi5r1");
        int i5 = (i & 6) == 0 ? (composerStartRestartGroup.changed(transition2) ? 4 : 2) | i : i;
        int i6 = i2 & 1;
        if (i6 != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i3 = i2 & 2;
            if (i3 == 0) {
                i5 |= 384;
            } else {
                if ((i & 384) == 0) {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                    i5 |= composerStartRestartGroup.changedInstance(finiteAnimationSpecTween$default) ? 256 : 128;
                }
                i4 = i2 & 4;
                if (i4 == 0) {
                    if ((i & 3072) == 0) {
                        function12 = function1;
                        i5 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    if ((i & 24576) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 9363) == 9362, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function13 = function12;
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i3 != 0) {
                            finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                            CrossfadeKt$Crossfade$3$1 crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final T invoke(T t) {
                                        return t;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                            }
                            function14 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function14 = function12;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1877370462, i5, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        Object obj = objRememberedValue;
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                            snapshotStateListMutableStateListOf.add(transition2.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                            obj = snapshotStateListMutableStateListOf;
                        }
                        SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        MutableScatterMap mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                            composerStartRestartGroup.startReplaceGroup(321145192);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (snapshotStateList2.size() == 1 && Intrinsics.areEqual(snapshotStateList2.get(0), transition2.getTargetState())) {
                                composerStartRestartGroup.startReplaceGroup(316295552);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(321279546);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                                SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                                boolean z = (i5 & 14) == 4;
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(T t) {
                                            return Boolean.valueOf(!Intrinsics.areEqual(t, transition2.getTargetState()));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                CollectionsKt.removeAll((List) snapshotStateList3, (Function1) objRememberedValue3);
                                mutableScatterMap.clear();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(316295552);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (mutableScatterMap.contains(transition2.getTargetState())) {
                            snapshotStateList = snapshotStateList2;
                            composerStartRestartGroup.startReplaceGroup(316295552);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321536443);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                            SnapshotStateList snapshotStateList4 = snapshotStateList2;
                            Iterator<T> it = snapshotStateList4.iterator();
                            int i7 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i7 = -1;
                                    break;
                                } else if (Intrinsics.areEqual(function14.invoke(it.next()), function14.invoke(transition2.getTargetState()))) {
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (i7 == -1) {
                                snapshotStateList2.add(transition2.getTargetState());
                            } else {
                                snapshotStateList2.set(i7, transition2.getTargetState());
                            }
                            mutableScatterMap.clear();
                            int size = snapshotStateList4.size();
                            int i8 = 0;
                            while (i8 < size) {
                                T t = snapshotStateList4.get(i8);
                                mutableScatterMap.set(t, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t, function3), composerStartRestartGroup, 54));
                                i8++;
                                transition2 = transition;
                                snapshotStateList2 = snapshotStateList2;
                            }
                            snapshotStateList = snapshotStateList2;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                        Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                        composerStartRestartGroup.startReplaceGroup(-1312707512);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        SnapshotStateList snapshotStateList5 = snapshotStateList;
                        int size2 = snapshotStateList5.size();
                        for (int i9 = 0; i9 < size2; i9++) {
                            T t2 = snapshotStateList5.get(i9);
                            composerStartRestartGroup.startMovableGroup(1171574969, function14.invoke(t2));
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            Function2 function2 = (Function2) mutableScatterMap.get(t2);
                            if (function2 == null) {
                                composerStartRestartGroup.startReplaceGroup(1959122128);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1171576145);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                                function2.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endMovableGroup();
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
                        function13 = function14;
                    }
                    final FiniteAnimationSpec<Float> finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
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

                            public final void invoke(Composer composer2, int i10) {
                                CrossfadeKt.Crossfade(transition, modifier3, finiteAnimationSpec2, function13, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 3072;
                function12 = function1;
                if ((i & 24576) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 9363) == 9362, i5 & 1)) {
                }
                final FiniteAnimationSpec<Float> finiteAnimationSpec22 = finiteAnimationSpecTween$default;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            finiteAnimationSpecTween$default = finiteAnimationSpec;
            i4 = i2 & 4;
            if (i4 == 0) {
            }
            function12 = function1;
            if ((i & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 9363) == 9362, i5 & 1)) {
            }
            final FiniteAnimationSpec<Float> finiteAnimationSpec222 = finiteAnimationSpecTween$default;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i3 = i2 & 2;
        if (i3 == 0) {
        }
        finiteAnimationSpecTween$default = finiteAnimationSpec;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function12 = function1;
        if ((i & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 9363) == 9362, i5 & 1)) {
        }
        final FiniteAnimationSpec<Float> finiteAnimationSpec2222 = finiteAnimationSpecTween$default;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String str, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i5;
        final Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513216493);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(4,3!1,2)56@2427L36,57@2479L53:Crossfade.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(t) : composerStartRestartGroup.changedInstance(t) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
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
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    i3 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
                    }
                    if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        finiteAnimationSpec3 = finiteAnimationSpec2;
                        str2 = str;
                    } else {
                        if (i7 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i6 = i5;
                        } else {
                            i6 = i5;
                            modifier4 = modifier2;
                        }
                        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = i4 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec2;
                        String str3 = i6 != 0 ? "Crossfade" : str;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                        }
                        Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
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

                            public final void invoke(Composer composer2, int i8) {
                                CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            finiteAnimationSpec2 = finiteAnimationSpec;
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
        finiteAnimationSpec2 = finiteAnimationSpec;
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

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        final Function3 function32;
        final FiniteAnimationSpec finiteAnimationSpec2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-160948176);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3,2)69@2888L29,70@2933L53:Crossfade.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(obj) : composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160948176, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:68)");
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(obj, (String) null, composerStartRestartGroup, i3 & 14, 2), modifier3, (FiniteAnimationSpec<Float>) finiteAnimationSpec3, (Function1) null, function3, composerStartRestartGroup, (i3 & PointerIconCompat.TYPE_TEXT) | ((i3 << 3) & 57344), 4);
            function32 = function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpec3;
        } else {
            function32 = function3;
            composerStartRestartGroup.skipToGroupEnd();
            finiteAnimationSpec2 = finiteAnimationSpec;
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
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

                public final void invoke(Composer composer2, int i6) {
                    CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec2, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
