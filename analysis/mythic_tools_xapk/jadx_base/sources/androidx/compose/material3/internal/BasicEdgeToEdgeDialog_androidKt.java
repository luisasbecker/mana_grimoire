package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BasicEdgeToEdgeDialog.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\t*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0000¨\u0006\u0013²\u0006\u001b\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eX\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"BasicEdgeToEdgeDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", "lightStatusBars", "", "lightNavigationBars", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/material3/internal/PredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3", "currentContent", "currentOnDismissRequest", "currentDismissOnBackPress"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicEdgeToEdgeDialog_androidKt {

    /* JADX INFO: compiled from: BasicEdgeToEdgeDialog.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicEdgeToEdgeDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, final Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        boolean z3;
        boolean z4;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i5;
        DialogProperties dialogProperties4;
        DialogProperties dialogProperties5;
        int i6;
        boolean z5;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(814581409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicEdgeToEdgeDialog)N(onDismissRequest,modifier,properties,lightStatusBars,lightNavigationBars,content)91@3820L7,92@3859L7,93@3914L7,94@3944L28,95@4009L21,95@3992L38,97@4058L29,98@4123L38,99@4199L51,102@4277L1031,128@5339L129,128@5314L154,137@5485L285,137@5474L296:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
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
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    dialogProperties2 = dialogProperties;
                    i3 |= composerStartRestartGroup.changed(dialogProperties2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        z3 = z;
                        int i8 = composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        z3 = z;
                    }
                    i3 |= i8;
                } else {
                    z3 = z;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        z4 = z2;
                        int i9 = composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        z4 = z2;
                    }
                    i3 |= i9;
                } else {
                    z4 = z2;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "37@1426L7,39@1507L7");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        DialogProperties dialogProperties6 = i4 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties2;
                        if ((i2 & 8) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -7169;
                            z3 = ColorKt.m6377luminance8_81llA(((Color) objConsume).m6335unboximpl()) < 0.5f;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -57345;
                            modifier4 = companion;
                            z4 = ColorKt.m6377luminance8_81llA(((Color) objConsume2).m6335unboximpl()) < 0.5f;
                        } else {
                            modifier4 = companion;
                        }
                        i5 = i3;
                        dialogProperties4 = dialogProperties6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i5 = i3;
                        modifier4 = modifier2;
                        dialogProperties4 = dialogProperties2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(814581409, i5, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
                    }
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    View view = (View) objConsume3;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density = (Density) objConsume4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final LayoutDirection layoutDirection = (LayoutDirection) objConsume5;
                    CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128701718, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    DialogProperties dialogProperties7 = dialogProperties4;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                    State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i5 >> 15) & 14);
                    int i10 = i5 & 14;
                    State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i10);
                    State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties7.getDismissOnBackPress()), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128711304, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        dialogProperties5 = dialogProperties7;
                        i6 = i5;
                        DialogWrapper dialogWrapper = new DialogWrapper(function0, dialogProperties5, view, layoutDirection, density, uuid, z3, z4);
                        z5 = true;
                        dialogWrapper.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$dialog$1$1$1(modifier4, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState)));
                        composerStartRestartGroup.updateRememberedValue(dialogWrapper);
                        obj = dialogWrapper;
                    } else {
                        dialogProperties5 = dialogProperties7;
                        i6 = i5;
                        z5 = true;
                        obj = objRememberedValue2;
                    }
                    final DialogWrapper dialogWrapper2 = (DialogWrapper) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128744386, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper2);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$9$lambda$8(dialogWrapper2, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(dialogWrapper2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128749214, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    int i11 = i6;
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(dialogWrapper2) | (i10 == 4 ? z5 : false) | ((i11 & 896) == 256 ? z5 : false) | composerStartRestartGroup.changed(layoutDirection.ordinal()) | (((((i11 & 7168) ^ 3072) <= 2048 || !composerStartRestartGroup.changed(z3)) && (i11 & 3072) != 2048) ? false : z5) | (((((57344 & i11) ^ 24576) <= 16384 || !composerStartRestartGroup.changed(z4)) && (i11 & 24576) != 16384) ? false : z5);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        final DialogProperties dialogProperties8 = dialogProperties5;
                        final boolean z6 = z3;
                        final boolean z7 = z4;
                        Function0 function02 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$11$lambda$10(dialogWrapper2, function0, dialogProperties8, layoutDirection, z6, z7);
                            }
                        };
                        dialogProperties5 = dialogProperties8;
                        composerStartRestartGroup.updateRememberedValue(function02);
                        objRememberedValue4 = function02;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                final boolean z8 = z3;
                final boolean z9 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$12(function0, modifier3, dialogProperties3, z8, z9, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            dialogProperties2 = dialogProperties;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
            }
            final boolean z82 = z3;
            final boolean z92 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
        }
        final boolean z822 = z3;
        final boolean z922 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit BasicEdgeToEdgeDialog$lambda$11$lambda$10(DialogWrapper dialogWrapper, Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection, boolean z, boolean z2) {
        dialogWrapper.updateParameters(function0, dialogProperties, layoutDirection, z, z2);
        return Unit.INSTANCE;
    }

    static final Unit BasicEdgeToEdgeDialog$lambda$12(Function0 function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, Function3 function3, int i, int i2, Composer composer, int i3) {
        BasicEdgeToEdgeDialog(function0, modifier, dialogProperties, z, z2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<PredictiveBackState, Composer, Integer, Unit> BasicEdgeToEdgeDialog$lambda$2(State<? extends Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit>> state) {
        return (Function3) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> BasicEdgeToEdgeDialog$lambda$3(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BasicEdgeToEdgeDialog$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final DisposableEffectResult BasicEdgeToEdgeDialog$lambda$9$lambda$8(final DialogWrapper dialogWrapper, DisposableEffectScope disposableEffectScope) {
        dialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$lambda$9$lambda$8$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                dialogWrapper.dismiss();
                dialogWrapper.disposeComposition();
            }
        };
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }
}
