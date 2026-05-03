package com.revenuecat.purchases.ui.revenuecatui;

import android.os.Build;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PaywallDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a3\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a.\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001aH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\r2 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0002\u001a\r\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\f\u0010 \u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\f\u0010!\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002"}, d2 = {"PaywallDialog", "", "paywallDialogOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Landroidx/compose/runtime/Composer;I)V", "PaywallDialogContent", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "onDismissRequest", "Lkotlin/Function1;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PaywallDialogScaffold", "handleCloseRequest", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "buildPaywallOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "dismissRequest", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getDialogMaxHeightPercentage", "", "(Landroidx/compose/runtime/Composer;I)F", "shouldUsePlatformDefaultWidth", "", "(Landroidx/compose/runtime/Composer;I)Z", "revenuecatui_defaultsBc8Release", "shouldDisplayDialog", "currentDialogOffering", "pendingExitOffering"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallDialogKt {
    public static final void PaywallDialog(final PaywallDialogOptions paywallDialogOptions, Composer composer, final int i) {
        int i2;
        String str;
        final MutableState mutableState;
        PaywallDialogKt$PaywallDialog$3$1 paywallDialogKt$PaywallDialog$3$1;
        Intrinsics.checkNotNullParameter(paywallDialogOptions, "paywallDialogOptions");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772149319);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialog)50@2325L46,50@2308L63,59@2621L157,64@2810L53,66@2905L160,66@2869L196,72@3103L134,79@3419L571,79@3360L630,*100@4215L258,97@4054L430:PaywallDialog.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772149319, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialog (PaywallDialog.kt:48)");
            }
            final Function1<CustomerInfo, Boolean> shouldDisplayBlock = paywallDialogOptions.getShouldDisplayBlock();
            Object[] objArr = new Object[0];
            composerStartRestartGroup.startReplaceGroup(751319359);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(shouldDisplayBlock);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$shouldDisplayDialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<Boolean> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(shouldDisplayBlock == null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.m5765rememberSaveable(objArr, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 6);
            composerStartRestartGroup.startReplaceGroup(751321155);
            ComposerKt.sourceInformation(composerStartRestartGroup, "52@2455L125,52@2418L162");
            if (shouldDisplayBlock != null) {
                composerStartRestartGroup.startReplaceGroup(751323598);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(shouldDisplayBlock);
                PaywallDialogKt$PaywallDialog$1$1 paywallDialogKt$PaywallDialog$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || paywallDialogKt$PaywallDialog$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    paywallDialogKt$PaywallDialog$1$1RememberedValue = new PaywallDialogKt$PaywallDialog$1$1(shouldDisplayBlock, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$1$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(paywallDialogOptions, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialog$1$1RememberedValue, composerStartRestartGroup, i2 & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751328942);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PaywallDialog$lambda$1(mutableState2) ? paywallDialogOptions.getOfferingSelection$revenuecatui_defaultsBc8Release() : null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751334886);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue3;
            composerStartRestartGroup.endReplaceGroup();
            Boolean boolValueOf = Boolean.valueOf(PaywallDialog$lambda$1(mutableState2));
            composerStartRestartGroup.startReplaceGroup(751338033);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState2) | (i3 == 4);
            PaywallDialogKt$PaywallDialog$2$1 paywallDialogKt$PaywallDialog$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || paywallDialogKt$PaywallDialog$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialog$2$1RememberedValue = new PaywallDialogKt$PaywallDialog$2$1(paywallDialogOptions, mutableState2, mutableState3, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialog$2$1RememberedValue, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(751344343);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(mutableState2) | (i3 == 4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$dismissDialog$1$1
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
                        mutableState3.setValue(null);
                        PaywallDialogKt.PaywallDialog$lambda$2(mutableState2, false);
                        Function0<Unit> dismissRequest = paywallDialogOptions.getDismissRequest();
                        if (dismissRequest != null) {
                            dismissRequest.invoke();
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final Function0 function0 = (Function0) objRememberedValue4;
            composerStartRestartGroup.endReplaceGroup();
            OfferingSelection offeringSelectionPaywallDialog$lambda$5 = PaywallDialog$lambda$5(mutableState3);
            OfferingSelection offeringSelectionPaywallDialog$lambda$8 = PaywallDialog$lambda$8(mutableState4);
            composerStartRestartGroup.startReplaceGroup(751354892);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(shouldDisplayBlock) | composerStartRestartGroup.changed(function0);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):PaywallDialog.kt#9igjgp";
                mutableState = mutableState4;
                paywallDialogKt$PaywallDialog$3$1 = new PaywallDialogKt$PaywallDialog$3$1(shouldDisplayBlock, function0, mutableState3, mutableState4, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$3$1);
            } else {
                paywallDialogKt$PaywallDialog$3$1 = objRememberedValue5;
                str = "CC(remember):PaywallDialog.kt#9igjgp";
                mutableState = mutableState4;
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(offeringSelectionPaywallDialog$lambda$5, offeringSelectionPaywallDialog$lambda$8, (Function2) paywallDialogKt$PaywallDialog$3$1, composerStartRestartGroup, 0);
            OfferingSelection offeringSelectionPaywallDialog$lambda$52 = PaywallDialog$lambda$5(mutableState3);
            if (offeringSelectionPaywallDialog$lambda$52 != null) {
                composerStartRestartGroup.startReplaceGroup(714557138);
                ComposerKt.sourceInformation(composerStartRestartGroup, str);
                boolean zChanged6 = composerStartRestartGroup.changed(function0);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function1) new Function1<OfferingSelection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(OfferingSelection offeringSelection) {
                            invoke2(offeringSelection);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(OfferingSelection offeringSelection) {
                            if (offeringSelection == null) {
                                function0.invoke();
                            } else {
                                mutableState.setValue(offeringSelection);
                                mutableState3.setValue(null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceGroup();
                PaywallDialogContent(paywallDialogOptions, offeringSelectionPaywallDialog$lambda$52, (Function1) objRememberedValue6, composerStartRestartGroup, i3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallDialogKt.PaywallDialog(paywallDialogOptions, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PaywallDialog$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialog$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$5(MutableState<OfferingSelection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$8(MutableState<OfferingSelection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialogContent(final PaywallDialogOptions paywallDialogOptions, final OfferingSelection offeringSelection, final Function1<? super OfferingSelection, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(217055693);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialogContent)P(2)118@4711L433,129@5166L130,134@5323L47,134@5302L68,139@5428L23,140@5459L58,138@5376L141:PaywallDialog.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(offeringSelection) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217055693, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent (PaywallDialog.kt:117)");
            }
            composerStartRestartGroup.startReplaceGroup(-926326503);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = buildPaywallOptions(paywallDialogOptions, offeringSelection, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function1.invoke(null);
                    }
                }, new Function2<Offering, PaywallResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Offering offering, PaywallResult paywallResult) {
                        invoke2(offering, paywallResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Offering offering, PaywallResult paywallResult) {
                        function1.invoke(offering != null ? new OfferingSelection.OfferingType(offering) : null);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PaywallOptions paywallOptions = (PaywallOptions) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            final PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptions, paywallDialogOptions.getShouldDisplayBlock(), composerStartRestartGroup, 0, 0);
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-926307305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(paywallViewModel);
            PaywallDialogKt$PaywallDialogContent$1$1 paywallDialogKt$PaywallDialogContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || paywallDialogKt$PaywallDialogContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialogContent$1$1RememberedValue = new PaywallDialogKt$PaywallDialogContent$1$1(paywallViewModel, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialogContent$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallDialogKt$PaywallDialogContent$1$1RememberedValue, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(-926303969);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallDialog.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(paywallViewModel);
            PaywallDialogKt$PaywallDialogContent$2$1 paywallDialogKt$PaywallDialogContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || paywallDialogKt$PaywallDialogContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallDialogKt$PaywallDialogContent$2$1RememberedValue = new PaywallDialogKt$PaywallDialogContent$2$1(paywallViewModel);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialogContent$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            PaywallDialogScaffold((Function0) paywallDialogKt$PaywallDialogContent$2$1RememberedValue, ComposableLambdaKt.rememberComposableLambda(-1280632207, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C141@5469L42:PaywallDialog.kt#ao8ymz");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280632207, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent.<anonymous> (PaywallDialog.kt:141)");
                    }
                    InternalPaywallKt.InternalPaywall(paywallOptions, paywallViewModel, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.4
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

                public final void invoke(Composer composer2, int i3) {
                    PaywallDialogKt.PaywallDialogContent(paywallDialogOptions, offeringSelection, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialogScaffold(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(255737381);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialogScaffold)P(1)157@5937L40,162@6115L31,165@6265L1283,159@5983L1565:PaywallDialog.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(255737381, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogScaffold (PaywallDialog.kt:149)");
            }
            composerStartRestartGroup.startReplaceGroup(2017075815);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*151@5764L14,151@5779L17,152@5849L10,152@5860L17");
            final float fM9114constructorimpl = Build.VERSION.SDK_INT > 34 ? Dp.m9114constructorimpl(WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getBottom() + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop()) : Dp.m9114constructorimpl(0.0f);
            composerStartRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, function0, composerStartRestartGroup, (i2 << 3) & 112, 1);
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, null, shouldUsePlatformDefaultWidth(composerStartRestartGroup, 0), Build.VERSION.SDK_INT <= 34, 7, null), ComposableLambdaKt.rememberComposableLambda(515988412, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogScaffold.1
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

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C169@6380L30,175@6935L607,166@6275L1267:PaywallDialog.kt#ao8ymz");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(515988412, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogScaffold.<anonymous> (PaywallDialog.kt:166)");
                    }
                    Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PaywallDialogKt.getDialogMaxHeightPercentage(composer2, 0));
                    long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    final float f = fM9114constructorimpl;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    ScaffoldKt.m3981ScaffoldTvnljyQ(modifierFillMaxHeight, null, null, null, null, 0, jM6324copywmQWz5c$default, 0L, null, ComposableLambdaKt.rememberComposableLambda(790409931, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogScaffold.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                            invoke(paddingValues, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final PaddingValues paddingValues, Composer composer3, int i4) {
                            int i5;
                            Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                            ComposerKt.sourceInformation(composer3, "C183@7344L26,178@7125L407:PaywallDialog.kt#ao8ymz");
                            if ((i4 & 6) == 0) {
                                i5 = i4 | (composer3.changed(paddingValues) ? 4 : 2);
                            } else {
                                i5 = i4;
                            }
                            if ((i5 & 19) == 18 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(790409931, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogScaffold.<anonymous>.<anonymous> (PaywallDialog.kt:176)");
                            }
                            boolean z = Dp.m9119equalsimpl0(paddingValues.getBottom(), Dp.m9114constructorimpl(0.0f)) && Dp.m9119equalsimpl0(paddingValues.getTop(), Dp.m9114constructorimpl(0.0f));
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            boolean z2 = Build.VERSION.SDK_INT <= 34;
                            composer3.startReplaceGroup(196446879);
                            ComposerKt.sourceInformation(composer3, "CC(remember):PaywallDialog.kt#9igjgp");
                            boolean z3 = (i5 & 14) == 4;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogScaffold$1$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Modifier invoke(Modifier conditional) {
                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                        return PaddingKt.padding(conditional, paddingValues);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            composer3.endReplaceGroup();
                            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(ModifierExtensionsKt.conditional(modifierFillMaxSize$default, z2, (Function1) objRememberedValue), 0.0f, 0.0f, 0.0f, z ? f : Dp.m9114constructorimpl(0.0f), 7, null);
                            Function2<Composer, Integer, Unit> function23 = function22;
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1342501878, "C186@7509L9:PaywallDialog.kt#ao8ymz");
                            function23.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 806879232, 446);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogScaffold.2
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

                public final void invoke(Composer composer2, int i3) {
                    PaywallDialogKt.PaywallDialogScaffold(function0, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final PaywallOptions buildPaywallOptions(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0<Unit> function0, Function2<? super Offering, ? super PaywallResult, Unit> function2) {
        return new PaywallOptions.Builder(function0).setOfferingSelection$revenuecatui_defaultsBc8Release(offeringSelection).setShouldDisplayDismissButton(paywallDialogOptions.getShouldDisplayDismissButton()).setFontProvider(paywallDialogOptions.getFontProvider()).setListener(paywallDialogOptions.getListener()).setPurchaseLogic(paywallDialogOptions.getPurchaseLogic()).setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(function2).setCustomVariables(paywallDialogOptions.getCustomVariables()).build();
    }

    static /* synthetic */ PaywallOptions buildPaywallOptions$default(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0 function0, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        return buildPaywallOptions(paywallDialogOptions, offeringSelection, function0, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getDialogMaxHeightPercentage(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1571840626, "C(getDialogMaxHeightPercentage)212@8441L19,215@8560L21:PaywallDialog.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1571840626, i, -1, "com.revenuecat.purchases.ui.revenuecatui.getDialogMaxHeightPercentage (PaywallDialog.kt:211)");
        }
        if (HelperFunctionsKt.windowAspectRatio(composer, 0) < 1.25f) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return 1.0f;
        }
        float f = WindowHelperKt.hasCompactDimension(composer, 0) ? 1.0f : 0.85f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }

    private static final boolean shouldUsePlatformDefaultWidth(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2082657643, "C(shouldUsePlatformDefaultWidth)221@8740L21:PaywallDialog.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2082657643, i, -1, "com.revenuecat.purchases.ui.revenuecatui.shouldUsePlatformDefaultWidth (PaywallDialog.kt:220)");
        }
        boolean z = !WindowHelperKt.hasCompactDimension(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }
}
