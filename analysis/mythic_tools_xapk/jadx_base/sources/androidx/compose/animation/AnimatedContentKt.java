package androidx.compose.animation;

import ai.onnxruntime.BuildConfig;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a\u0015\u0010!\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0087\u0004\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010)\"\u0010\u0010&\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006*"}, d2 = {"AnimatedContent", "", ExifInterface.LATITUDE_SOUTH, "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", Constants.ScionAnalytics.PARAM_LABEL, "", "contentKey", "Lkotlin/ParameterName;", "name", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "UnspecifiedSize", "J", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimatedContentKt {
    private static final long UnspecifiedSize = IntSize.m9280constructorimpl(-9223372034707292160L);

    /* JADX WARN: Removed duplicated region for block: B:182:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i4;
        Alignment topStart;
        int i5;
        Function1<? super S, ? extends Object> function14;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        final Modifier modifier3;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        SnapshotStateList snapshotStateList;
        MutableScatterMap mutableScatterMap;
        final Transition<S> transition2 = transition;
        Composer composerStartRestartGroup = composer.startRestartGroup(511725103);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedContent)P(3,4,1,2)765@38134L226,771@38459L6,774@38592L7,776@38628L114,780@38830L51,781@38903L69,867@43438L58,868@43530L45,874@43785L52,869@43580L264:AnimatedContent.kt#xbi5r1");
        int i6 = (i & 6) == 0 ? (composerStartRestartGroup.changed(transition2) ? 4 : 2) | i : i;
        int i7 = i2 & 1;
        if (i7 != 0) {
            i6 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i3 = i2 & 2;
            if (i3 == 0) {
                i6 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function13 = function1;
                    i6 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
                }
                i4 = i2 & 4;
                if (i4 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        topStart = alignment;
                        i6 |= composerStartRestartGroup.changed(topStart) ? 2048 : 1024;
                    }
                    i5 = i2 & 8;
                    if (i5 != 0) {
                        if ((i & 24576) == 0) {
                            function14 = function12;
                            i6 |= composerStartRestartGroup.changedInstance(function14) ? 16384 : 8192;
                        }
                        if ((196608 & i) == 0) {
                            function42 = function4;
                            i6 |= composerStartRestartGroup.changedInstance(function42) ? 131072 : 65536;
                        } else {
                            function42 = function4;
                        }
                        if (composerStartRestartGroup.shouldExecute((74899 & i6) != 74898, i6 & 1)) {
                            Modifier modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            String str2 = "CC(remember):AnimatedContent.kt#9igjgp";
                            if (i3 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141557361, "CC(remember):AnimatedContent.kt#9igjgp");
                                AnimatedContentKt$AnimatedContent$4$1 animatedContentKt$AnimatedContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (animatedContentKt$AnimatedContent$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    animatedContentKt$AnimatedContent$4$1RememberedValue = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m1305scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(animatedContentKt$AnimatedContent$4$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function13 = (Function1) animatedContentKt$AnimatedContent$4$1RememberedValue;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141567541, "CC(remember):AnimatedContent.kt#9igjgp");
                                AnimatedContentKt$AnimatedContent$5$1 animatedContentKt$AnimatedContent$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (animatedContentKt$AnimatedContent$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    animatedContentKt$AnimatedContent$5$1RememberedValue = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final S invoke(S s) {
                                            return s;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(animatedContentKt$AnimatedContent$5$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function14 = (Function1) animatedContentKt$AnimatedContent$5$1RememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(511725103, i6, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:773)");
                            }
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141573057, "CC(remember):AnimatedContent.kt#9igjgp");
                            int i8 = i6 & 14;
                            boolean z = i8 == 4;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition2, topStart, layoutDirection);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141579458, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean z2 = i8 == 4;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition2.getCurrentState());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141581812, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean z3 = i8 == 4;
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            MutableScatterMap mutableScatterMap2 = (MutableScatterMap) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (!snapshotStateList2.contains(transition2.getCurrentState())) {
                                snapshotStateList2.clear();
                                snapshotStateList2.add(transition2.getCurrentState());
                            }
                            if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                                if (snapshotStateList2.size() != 1 || !Intrinsics.areEqual(snapshotStateList2.get(0), transition2.getCurrentState())) {
                                    snapshotStateList2.clear();
                                    snapshotStateList2.add(transition2.getCurrentState());
                                }
                                if (mutableScatterMap2.get_size() != 1 || mutableScatterMap2.containsKey(transition2.getCurrentState())) {
                                    mutableScatterMap2.clear();
                                }
                                animatedContentTransitionScopeImpl2.setContentAlignment(topStart);
                                animatedContentTransitionScopeImpl2.setLayoutDirection$animation(layoutDirection);
                            }
                            if (!Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState()) && !snapshotStateList2.contains(transition2.getTargetState())) {
                                Iterator<T> it = snapshotStateList2.iterator();
                                int i9 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        i9 = -1;
                                        break;
                                    } else if (Intrinsics.areEqual(function14.invoke((Object) it.next()), function14.invoke(transition2.getTargetState()))) {
                                        break;
                                    } else {
                                        i9++;
                                    }
                                }
                                if (i9 == -1) {
                                    snapshotStateList2.add(transition2.getTargetState());
                                } else {
                                    snapshotStateList2.set(i9, transition2.getTargetState());
                                }
                            }
                            if (mutableScatterMap2.containsKey(transition2.getTargetState()) && mutableScatterMap2.containsKey(transition2.getCurrentState())) {
                                composerStartRestartGroup.startReplaceGroup(1925931827);
                                composerStartRestartGroup.endReplaceGroup();
                                str = "CC(remember):AnimatedContent.kt#9igjgp";
                                function15 = function13;
                                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                                snapshotStateList = snapshotStateList2;
                                mutableScatterMap = mutableScatterMap2;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1966410449);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*817@40849L2545");
                                mutableScatterMap2.clear();
                                SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                int size = snapshotStateList3.size();
                                int i10 = 0;
                                while (i10 < size) {
                                    MutableScatterMap mutableScatterMap3 = mutableScatterMap2;
                                    final T t = snapshotStateList3.get(i10);
                                    int i11 = i10;
                                    final SnapshotStateList snapshotStateList4 = snapshotStateList2;
                                    int i12 = size;
                                    final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                                    final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function43 = function42;
                                    String str3 = str2;
                                    final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function16 = function13;
                                    mutableScatterMap3.set(t, ComposableLambdaKt.rememberComposableLambda(-23915175, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                                        /* JADX WARN: Multi-variable type inference failed */
                                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                         */
                                        public final void invoke(Composer composer2, int i13) {
                                            ComposerKt.sourceInformation(composer2, "C818@40885L38,822@41099L323,829@41455L125,840@42023L348,836@41832L25,847@42511L233,852@42764L616,834@41763L1617:AnimatedContent.kt#xbi5r1");
                                            if (!composer2.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-23915175, i13, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:818)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507645505, "CC(remember):AnimatedContent.kt#9igjgp");
                                            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function17 = function16;
                                            Object obj = animatedContentTransitionScopeImpl3;
                                            ContentTransform contentTransformRememberedValue = composer2.rememberedValue();
                                            if (contentTransformRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                contentTransformRememberedValue = function17.invoke(obj);
                                                composer2.updateRememberedValue(contentTransformRememberedValue);
                                            }
                                            final ContentTransform contentTransform = (ContentTransform) contentTransformRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            boolean zAreEqual = Intrinsics.areEqual(transition2.getSegment().getTargetState(), t);
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507638372, "CC(remember):AnimatedContent.kt#9igjgp");
                                            boolean zChanged = composer2.changed(zAreEqual);
                                            Transition<S> transition3 = transition2;
                                            S s = t;
                                            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function18 = function16;
                                            Object obj2 = animatedContentTransitionScopeImpl3;
                                            Object objRememberedValue4 = composer2.rememberedValue();
                                            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue4 = Intrinsics.areEqual(transition3.getSegment().getTargetState(), s) ? ExitTransition.INSTANCE.getNone() : function18.invoke(obj2).getInitialContentExit();
                                                composer2.updateRememberedValue(objRememberedValue4);
                                            }
                                            final ExitTransition exitTransition = (ExitTransition) objRememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507627178, "CC(remember):AnimatedContent.kt#9igjgp");
                                            S s2 = t;
                                            Transition<S> transition4 = transition2;
                                            Object objRememberedValue5 = composer2.rememberedValue();
                                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue5 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s2, transition4.getTargetState()));
                                                composer2.updateRememberedValue(objRememberedValue5);
                                            }
                                            AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) objRememberedValue5;
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507608779, "CC(remember):AnimatedContent.kt#9igjgp");
                                            boolean zChangedInstance = composer2.changedInstance(contentTransform);
                                            Object objRememberedValue6 = composer2.rememberedValue();
                                            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                                        return m1258invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                                    }

                                                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                                    public final MeasureResult m1258invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                                        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
                                                        int width = placeableMo7769measureBRTryo0.getWidth();
                                                        int height = placeableMo7769measureBRTryo0.getHeight();
                                                        final ContentTransform contentTransform2 = contentTransform;
                                                        return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                invoke2(placementScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                placementScope.place(placeableMo7769measureBRTryo0, 0, 0, contentTransform2.getTargetContentZIndex());
                                                            }
                                                        }, 4, null);
                                                    }
                                                };
                                                composer2.updateRememberedValue(objRememberedValue6);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue6);
                                            childData.setTarget(Intrinsics.areEqual(t, transition2.getTargetState()));
                                            Modifier modifierThen = modifierLayout.then(childData);
                                            Transition<S> transition5 = transition2;
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507615214, "CC(remember):AnimatedContent.kt#9igjgp");
                                            boolean zChangedInstance2 = composer2.changedInstance(t);
                                            final S s3 = t;
                                            Object objRememberedValue7 = composer2.rememberedValue();
                                            if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue7 = (Function1) new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(S s4) {
                                                        return Boolean.valueOf(Intrinsics.areEqual(s4, s3));
                                                    }
                                                };
                                                composer2.updateRememberedValue(objRememberedValue7);
                                            }
                                            Function1 function19 = (Function1) objRememberedValue7;
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            ComposerKt.sourceInformationMarkerStart(composer2, -1507593278, "CC(remember):AnimatedContent.kt#9igjgp");
                                            boolean zChanged2 = composer2.changed(exitTransition);
                                            Object objRememberedValue8 = composer2.rememberedValue();
                                            if (zChanged2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue8 = (Function2) new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                                                        return Boolean.valueOf(enterExitState == EnterExitState.PostExit && enterExitState2 == EnterExitState.PostExit && !exitTransition.getData().getHold());
                                                    }
                                                };
                                                composer2.updateRememberedValue(objRememberedValue8);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            final SnapshotStateList<S> snapshotStateList5 = snapshotStateList4;
                                            final S s4 = t;
                                            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl3;
                                            final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function44 = function43;
                                            AnimatedVisibilityKt.AnimatedEnterExitImpl(transition5, function19, modifierThen, targetContentEnter, exitTransition, (Function2) objRememberedValue8, null, ComposableLambdaKt.rememberComposableLambda(-143346359, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                                 */
                                                /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
                                                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v11 boolean
                                                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                                                    */
                                                public final void invoke(androidx.compose.animation.AnimatedVisibilityScope r8, androidx.compose.runtime.Composer r9, int r10) {
                                                    /*
                                                        Method dump skipped, instruction units count: 209
                                                        To view this dump add '--comments-level debug' option
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.AnonymousClass5.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):void");
                                                }
                                            }, composer2, 54), composer2, 12582912, 64);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54));
                                    transition2 = transition;
                                    function13 = function16;
                                    mutableScatterMap2 = mutableScatterMap3;
                                    str2 = str3;
                                    function42 = function4;
                                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl3;
                                    size = i12;
                                    snapshotStateList2 = snapshotStateList4;
                                    i10 = i11 + 1;
                                    snapshotStateList3 = snapshotStateList3;
                                }
                                str = str2;
                                function15 = function13;
                                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                                snapshotStateList = snapshotStateList2;
                                mutableScatterMap = mutableScatterMap2;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Transition.Segment<S> segment = transition.getSegment();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141726921, str);
                            boolean zChanged = composerStartRestartGroup.changed(segment) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                            ContentTransform contentTransformRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || contentTransformRememberedValue == Composer.INSTANCE.getEmpty()) {
                                contentTransformRememberedValue = function15.invoke(animatedContentTransitionScopeImpl);
                                composerStartRestartGroup.updateRememberedValue(contentTransformRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierThen = modifier4.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation((ContentTransform) contentTransformRememberedValue, composerStartRestartGroup, 0));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2141738019, str);
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
                            Updater.m5603setimpl(composerM5595constructorimpl, animatedContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -895590996, "C:AnimatedContent.kt#xbi5r1");
                            composerStartRestartGroup.startReplaceGroup(-860173498);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            SnapshotStateList snapshotStateList5 = snapshotStateList;
                            int size2 = snapshotStateList5.size();
                            for (int i13 = 0; i13 < size2; i13++) {
                                BuildConfig buildConfig = (Object) snapshotStateList5.get(i13);
                                composerStartRestartGroup.startMovableGroup(-2026002954, function14.invoke(buildConfig));
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                Function2 function2 = (Function2) mutableScatterMap.get(buildConfig);
                                if (function2 == null) {
                                    composerStartRestartGroup.startReplaceGroup(1618454323);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-2026001778);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "872@43737L8");
                                    function2.invoke(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endMovableGroup();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            function15 = function13;
                        }
                        final Alignment alignment2 = topStart;
                        final Function1<? super S, ? extends Object> function17 = function14;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.9
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

                                public final void invoke(Composer composer2, int i14) {
                                    AnimatedContentKt.AnimatedContent(transition, modifier3, function15, alignment2, function17, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    function14 = function12;
                    if ((196608 & i) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i6) != 74898, i6 & 1)) {
                    }
                    final Alignment alignment22 = topStart;
                    final Function1<? super S, ? extends Object> function172 = function14;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                topStart = alignment;
                i5 = i2 & 8;
                if (i5 != 0) {
                }
                function14 = function12;
                if ((196608 & i) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i6) != 74898, i6 & 1)) {
                }
                final Alignment alignment222 = topStart;
                final Function1<? super S, ? extends Object> function1722 = function14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function13 = function1;
            i4 = i2 & 4;
            if (i4 != 0) {
            }
            topStart = alignment;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function14 = function12;
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i6) != 74898, i6 & 1)) {
            }
            final Alignment alignment2222 = topStart;
            final Function1<? super S, ? extends Object> function17222 = function14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i3 = i2 & 2;
        if (i3 == 0) {
        }
        function13 = function1;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        topStart = alignment;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function14 = function12;
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i6) != 74898, i6 & 1)) {
        }
        final Alignment alignment22222 = topStart;
        final Function1<? super S, ? extends Object> function172222 = function14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, String str, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i5;
        Alignment alignment2;
        int i6;
        int i7;
        Function1<? super S, ? extends Object> function14;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        final Modifier modifier2;
        final String str2;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        final Alignment alignment3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Modifier modifier3;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function16;
        int i9;
        Alignment topStart;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501828832);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedContent)P(5,4,6,1,3,2)131@7139L226,138@7503L6,141@7610L58,142@7684L137:AnimatedContent.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(s) : composerStartRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function13 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        alignment2 = alignment;
                        i3 |= composerStartRestartGroup.changed(alignment2) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            i3 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 == 0) {
                            if ((196608 & i) == 0) {
                                function14 = function12;
                                i3 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
                            }
                            if ((1572864 & i) != 0) {
                                function42 = function4;
                                i3 |= composerStartRestartGroup.changedInstance(function42) ? 1048576 : 524288;
                            } else {
                                function42 = function4;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                str2 = str;
                                function15 = function13;
                                alignment3 = alignment2;
                            } else {
                                if (i10 != 0) {
                                    modifier3 = Modifier.INSTANCE;
                                    i8 = i6;
                                } else {
                                    i8 = i6;
                                    modifier3 = modifier;
                                }
                                if (i4 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 148501410, "CC(remember):AnimatedContent.kt#9igjgp");
                                    AnimatedContentKt$AnimatedContent$1$1 animatedContentKt$AnimatedContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (animatedContentKt$AnimatedContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        animatedContentKt$AnimatedContent$1$1RememberedValue = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                                return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m1305scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(animatedContentKt$AnimatedContent$1$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function16 = (Function1) animatedContentKt$AnimatedContent$1$1RememberedValue;
                                } else {
                                    function16 = function13;
                                }
                                if (i5 != 0) {
                                    topStart = Alignment.INSTANCE.getTopStart();
                                    i9 = i7;
                                } else {
                                    i9 = i7;
                                    topStart = alignment2;
                                }
                                String str3 = i8 != 0 ? "AnimatedContent" : str;
                                if (i9 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 148512838, "CC(remember):AnimatedContent.kt#9igjgp");
                                    AnimatedContentKt$AnimatedContent$2$1 animatedContentKt$AnimatedContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (animatedContentKt$AnimatedContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        animatedContentKt$AnimatedContent$2$1RememberedValue = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final S invoke(S s2) {
                                                return s2;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(animatedContentKt$AnimatedContent$2$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function14 = (Function1) animatedContentKt$AnimatedContent$2$1RememberedValue;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1501828832, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                                }
                                Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(s, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                                int i11 = i3 & 8176;
                                int i12 = i3 >> 3;
                                AnimatedContent(transitionUpdateTransition, modifier3, function16, topStart, function14, function42, composerStartRestartGroup, i11 | (57344 & i12) | (i12 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str2 = str3;
                                modifier2 = modifier3;
                                function15 = function16;
                                alignment3 = topStart;
                            }
                            final Function1<? super S, ? extends Object> function17 = function14;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
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

                                    public final void invoke(Composer composer2, int i13) {
                                        AnimatedContentKt.AnimatedContent(s, modifier2, function15, alignment3, str2, function17, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function14 = function12;
                        if ((1572864 & i) != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        }
                        final Function1<? super S, ? extends Object> function172 = function14;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                    }
                    function14 = function12;
                    if ((1572864 & i) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                    }
                    final Function1<? super S, ? extends Object> function1722 = function14;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                alignment2 = alignment;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                function14 = function12;
                if ((1572864 & i) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                final Function1<? super S, ? extends Object> function17222 = function14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function13 = function1;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            alignment2 = alignment;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            function14 = function12;
            if ((1572864 & i) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            final Function1<? super S, ? extends Object> function172222 = function14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function13 = function1;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        alignment2 = alignment;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        function14 = function12;
        if ((1572864 & i) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        final Function1<? super S, ? extends Object> function1722222 = function14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt.SizeTransform.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m1259invokeTemP2vQ(intSize.m9289unboximpl(), intSize2.m9289unboximpl());
                }

                /* JADX INFO: renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m1259invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m9277boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }
}
