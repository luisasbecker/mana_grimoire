package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.window.PopupPositionProvider;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Label.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Label", "", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPersistent", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HandleInteractions", "enabled", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/TooltipState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LabelKt {
    private static final void HandleInteractions(final boolean z, final TooltipState tooltipState, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-627258109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HandleInteractions)N(enabled,state,interactionSource):Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        boolean z2 = false;
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627258109, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(756598818);
                ComposerKt.sourceInformation(composerStartRestartGroup, "110@4434L587,110@4400L621");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499612882, "CC(remember):Label.kt#9igjgp");
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) {
                    z2 = true;
                }
                boolean z4 = z3 | z2;
                LabelKt$HandleInteractions$1$1 labelKt$HandleInteractions$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || labelKt$HandleInteractions$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    labelKt$HandleInteractions$1$1RememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, tooltipState, null);
                    composerStartRestartGroup.updateRememberedValue(labelKt$HandleInteractions$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) labelKt$HandleInteractions$1$1RememberedValue, composerStartRestartGroup, (i2 >> 6) & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(757210975);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.HandleInteractions$lambda$7(z, tooltipState, mutableInteractionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HandleInteractions$lambda$7(boolean z, TooltipState tooltipState, MutableInteractionSource mutableInteractionSource, int i, Composer composer, int i2) {
        HandleInteractions(z, tooltipState, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020a  */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, androidx.compose.runtime.MutableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Label(final Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z2;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MutableInteractionSource mutableInteractionSource4;
        PopupPositionProvider popupPositionProvider;
        LabelStateImpl labelStateImplRememberBasicTooltipState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-458575864);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Label)N(label,modifier,interactionSource,isPersistent,content)74@3260L60,79@3521L33,80@3571L71,82@3693L103,88@3882L17,86@3802L250,95@4057L128:Label.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
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
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z3 = z2;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        MutableInteractionSource mutableInteractionSource5 = i4 != 0 ? null : mutableInteractionSource2;
                        boolean z4 = i5 != 0 ? false : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                        }
                        if (mutableInteractionSource5 == null) {
                            composerStartRestartGroup.startReplaceGroup(857748595);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690237295, "CC(remember):Label.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1690236644);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource5;
                        }
                        PopupPositionProvider popupPositionProviderM4467rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4467rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4454getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(857995293);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690245253, "CC(remember):Label.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new LabelStateImpl(false, false, 3, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue2;
                            popupPositionProvider = popupPositionProviderM4467rememberTooltipPositionProviderHu5FAss;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1690246656);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                            popupPositionProvider = popupPositionProviderM4467rememberTooltipPositionProviderHu5FAss;
                            labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        TooltipState tooltipState = labelStateImplRememberBasicTooltipState;
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250313, "CC(remember):Label.kt#9igjgp");
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        objectRef.element = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690251951, "CC(remember):Label.kt#9igjgp");
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LabelKt.Label$lambda$4$lambda$3(objectRef);
                                }
                            }, popupPositionProvider);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.Label.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i7) {
                                ComposerKt.sourceInformation(composer2, "C88@3890L7:Label.kt#uh7d8r");
                                if (!composer2.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1572484206, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
                                }
                                function3.invoke(tooltipScopeImpl, composer2, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), tooltipState, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new LabelKt$Label$wrappedContent$1(objectRef, function2), composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, 144);
                        composerStartRestartGroup = composerStartRestartGroup;
                        HandleInteractions(!z4, tooltipState, mutableInteractionSource4, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        z3 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LabelKt.Label$lambda$5(function3, modifier3, mutableInteractionSource3, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                z2 = z;
                if ((i2 & 16) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            z2 = z;
            if ((i2 & 16) == 0) {
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
        mutableInteractionSource2 = mutableInteractionSource;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 16) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final LayoutCoordinates Label$lambda$4$lambda$3(Ref.ObjectRef objectRef) {
        return (LayoutCoordinates) ((MutableState) objectRef.element).getValue();
    }

    static final Unit Label$lambda$5(Function3 function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        Label(function3, modifier, mutableInteractionSource, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
