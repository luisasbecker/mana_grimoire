package com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestorePurchasesDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0007\u001a#\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\t\u001aI\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"PurchasesNotFoundDialog", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "onDismiss", "Lkotlin/Function0;", "onContactSupport", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PurchasesRecoveredDialog", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RestorePurchasesDialog", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/dialogs/RestorePurchasesState;", "onRestore", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/dialogs/RestorePurchasesState;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RestorePurchasesDialogNotFoundPreview", "(Landroidx/compose/runtime/Composer;I)V", "RestorePurchasesDialogRecoveredPreview", "RestorePurchasesDialogRestoringPreview", "RestoringDialog", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class RestorePurchasesDialogKt {

    /* JADX INFO: compiled from: RestorePurchasesDialog.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RestorePurchasesState.values().length];
            try {
                iArr[RestorePurchasesState.PURCHASES_RECOVERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RestorePurchasesState.PURCHASES_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RestorePurchasesState.RESTORING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PurchasesNotFoundDialog(final CustomerCenterConfigData.Localization localization, final Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function03;
        Composer composer2;
        final Function0<Unit> function04;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1538154097);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchasesNotFoundDialog)P(!1,2)133@4248L365,144@4639L264,117@3671L267,125@3955L267,115@3604L1306:RestorePurchasesDialog.kt#ayavkp");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(localization) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                function03 = function02;
                i3 |= composerStartRestartGroup.changedInstance(function03) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                final Function0<Unit> function05 = i4 == 0 ? null : function03;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1538154097, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog (RestorePurchasesDialog.kt:114)");
                }
                int i5 = ((i3 >> 3) & 14) | 1772592;
                composer2 = composerStartRestartGroup;
                Function0<Unit> function06 = function05;
                AndroidAlertDialog_androidKt.m3282AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(2084079289, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C135@4349L240,135@4310L279:RestorePurchasesDialog.kt#ayavkp");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2084079289, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:134)");
                        }
                        Function0<Unit> function07 = function05;
                        if (function07 != null) {
                            final CustomerCenterConfigData.Localization localization2 = localization;
                            ButtonKt.TextButton(function07, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1149789201, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.1.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                    invoke(rowScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope TextButton, Composer composer4, int i7) {
                                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                    ComposerKt.sourceInformation(composer4, "C136@4371L200:RestorePurchasesDialog.kt#ayavkp");
                                    if ((i7 & 17) == 16 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1149789201, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:136)");
                                    }
                                    TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CONTACT_SUPPORT), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 805306368, 510);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1053355717, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C145@4685L208,145@4653L240:RestorePurchasesDialog.kt#ayavkp");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1053355717, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:145)");
                        }
                        Function0<Unit> function07 = function0;
                        final CustomerCenterConfigData.Localization localization2 = localization;
                        ButtonKt.TextButton(function07, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-221760264, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.2.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                invoke(rowScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TextButton, Composer composer4, int i7) {
                                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                ComposerKt.sourceInformation(composer4, "C146@4703L176:RestorePurchasesDialog.kt#ayavkp");
                                if ((i7 & 17) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-221760264, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:146)");
                                }
                                TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DISMISS), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(104176573, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C122@3889L10,118@3685L243:RestorePurchasesDialog.kt#ayavkp");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(104176573, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:118)");
                        }
                        TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_NOT_FOUND), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getHeadlineSmall(), composer3, 0, 0, 65534);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(682942718, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C130@4177L10,126@3969L243:RestorePurchasesDialog.kt#ayavkp");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(682942718, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:126)");
                        }
                        TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_NOT_RECOVERED), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer3, 0, 0, 65534);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, i5, 0, 16276);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function04 = function06;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                function04 = function03;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        RestorePurchasesDialogKt.PurchasesNotFoundDialog(localization, function0, function04, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        function03 = function02;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i52 = ((i3 >> 3) & 14) | 1772592;
            composer2 = composerStartRestartGroup;
            Function0<Unit> function062 = function05;
            AndroidAlertDialog_androidKt.m3282AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(2084079289, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C135@4349L240,135@4310L279:RestorePurchasesDialog.kt#ayavkp");
                    if ((i6 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2084079289, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:134)");
                    }
                    Function0<Unit> function07 = function05;
                    if (function07 != null) {
                        final CustomerCenterConfigData.Localization localization2 = localization;
                        ButtonKt.TextButton(function07, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1149789201, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                invoke(rowScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TextButton, Composer composer4, int i7) {
                                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                ComposerKt.sourceInformation(composer4, "C136@4371L200:RestorePurchasesDialog.kt#ayavkp");
                                if ((i7 & 17) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1149789201, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:136)");
                                }
                                TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CONTACT_SUPPORT), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 805306368, 510);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1053355717, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C145@4685L208,145@4653L240:RestorePurchasesDialog.kt#ayavkp");
                    if ((i6 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1053355717, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:145)");
                    }
                    Function0<Unit> function07 = function0;
                    final CustomerCenterConfigData.Localization localization2 = localization;
                    ButtonKt.TextButton(function07, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-221760264, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.2.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TextButton, Composer composer4, int i7) {
                            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                            ComposerKt.sourceInformation(composer4, "C146@4703L176:RestorePurchasesDialog.kt#ayavkp");
                            if ((i7 & 17) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-221760264, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:146)");
                            }
                            TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DISMISS), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(104176573, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C122@3889L10,118@3685L243:RestorePurchasesDialog.kt#ayavkp");
                    if ((i6 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(104176573, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:118)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_NOT_FOUND), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getHeadlineSmall(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(682942718, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C130@4177L10,126@3969L243:RestorePurchasesDialog.kt#ayavkp");
                    if ((i6 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(682942718, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesNotFoundDialog.<anonymous> (RestorePurchasesDialog.kt:126)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_NOT_RECOVERED), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, i52, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
            }
            function04 = function062;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchasesRecoveredDialog(final CustomerCenterConfigData.Localization localization, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1735282777);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchasesRecoveredDialog)97@3172L261,81@2601L260,89@2878L268,79@2534L906:RestorePurchasesDialog.kt#ayavkp");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(localization) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735282777, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog (RestorePurchasesDialog.kt:78)");
            }
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m3282AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1752184593, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C98@3218L205,98@3186L237:RestorePurchasesDialog.kt#ayavkp");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1752184593, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:98)");
                    }
                    Function0<Unit> function02 = function0;
                    final CustomerCenterConfigData.Localization localization2 = localization;
                    ButtonKt.TextButton(function02, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1528989004, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TextButton, Composer composer4, int i4) {
                            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                            ComposerKt.sourceInformation(composer4, "C99@3236L173:RestorePurchasesDialog.kt#ayavkp");
                            if ((i4 & 17) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1528989004, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:99)");
                            }
                            TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DONE), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, null, null, ComposableLambdaKt.rememberComposableLambda(90877325, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C86@2812L10,82@2615L236:RestorePurchasesDialog.kt#ayavkp");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(90877325, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:82)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RECOVERED), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getHeadlineSmall(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-324449492, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C94@3101L10,90@2892L244:RestorePurchasesDialog.kt#ayavkp");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-324449492, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:90)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RECOVERED_EXPLANATION), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i2 >> 3) & 14) | 1769520, 0, 16284);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    RestorePurchasesDialogKt.PurchasesRecoveredDialog(localization, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final /* synthetic */ void RestorePurchasesDialog(final RestorePurchasesState state, CustomerCenterConfigData.Localization localization, Function0 onDismiss, final Function0 onRestore, Function0 function0, Composer composer, final int i) {
        int i2;
        Function0 function02;
        final CustomerCenterConfigData.Localization localization2;
        Function0 function03;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onRestore, "onRestore");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1558153315);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RestorePurchasesDialog)P(4!1,2,3):RestorePurchasesDialog.kt#ayavkp");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRestore) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function02 = onDismiss;
            localization2 = localization;
            function03 = function0;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1558153315, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialog (RestorePurchasesDialog.kt:28)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i3 == 1) {
                function02 = onDismiss;
                localization2 = localization;
                function03 = function0;
                composerStartRestartGroup.startReplaceGroup(-583327083);
                ComposerKt.sourceInformation(composerStartRestartGroup, "30@1201L84");
                PurchasesRecoveredDialog(localization2, function02, composerStartRestartGroup, (i2 >> 3) & 126);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 != 2) {
                if (i3 != 3) {
                    composerStartRestartGroup.startReplaceGroup(-902851391);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-583314999);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*39@1527L52");
                    RestoringDialog(localization, composerStartRestartGroup, (i2 >> 3) & 14);
                    Unit unit = Unit.INSTANCE;
                    onRestore.invoke();
                    composerStartRestartGroup.endReplaceGroup();
                }
                function02 = onDismiss;
                localization2 = localization;
                function03 = function0;
            } else {
                composerStartRestartGroup.startReplaceGroup(-583322607);
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1339L144");
                function02 = onDismiss;
                PurchasesNotFoundDialog(localization, function02, function0, composerStartRestartGroup, ((i2 >> 3) & 126) | ((i2 >> 6) & 896), 0);
                localization2 = localization;
                function03 = function0;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0 function04 = function03;
            final Function0 function05 = function02;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialog.2
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
                    RestorePurchasesDialogKt.RestorePurchasesDialog(state, localization2, function05, onRestore, function04, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = true)
    public static final void RestorePurchasesDialogNotFoundPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-789679044);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RestorePurchasesDialogNotFoundPreview)186@5839L254:RestorePurchasesDialog.kt#ayavkp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-789679044, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogNotFoundPreview (RestorePurchasesDialog.kt:185)");
            }
            RestorePurchasesDialog(RestorePurchasesState.PURCHASES_NOT_FOUND, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, composerStartRestartGroup, 28038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = true)
    public static final void RestorePurchasesDialogRecoveredPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1527727452);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RestorePurchasesDialogRecoveredPreview)173@5442L254:RestorePurchasesDialog.kt#ayavkp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1527727452, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogRecoveredPreview (RestorePurchasesDialog.kt:172)");
            }
            RestorePurchasesDialog(RestorePurchasesState.PURCHASES_RECOVERED, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, composerStartRestartGroup, 28038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = true)
    public static final void RestorePurchasesDialogRestoringPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2037934116);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RestorePurchasesDialogRestoringPreview)160@5054L244:RestorePurchasesDialog.kt#ayavkp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2037934116, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogRestoringPreview (RestorePurchasesDialog.kt:159)");
            }
            RestorePurchasesDialog(RestorePurchasesState.RESTORING, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, composerStartRestartGroup, 28038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RestoringDialog(final CustomerCenterConfigData.Localization localization, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1621839505);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RestoringDialog)53@1810L267,51@1711L702:RestorePurchasesDialog.kt#ayavkp");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(localization) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1621839505, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestoringDialog (RestorePurchasesDialog.kt:50)");
            }
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m3282AlertDialogOix01E0(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, ComposableSingletons$RestorePurchasesDialogKt.INSTANCE.m10717getLambda1$revenuecatui_defaultsBc8Release(), null, null, null, ComposableLambdaKt.rememberComposableLambda(1131714747, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C58@2028L10,54@1824L243:RestorePurchasesDialog.kt#ayavkp");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1131714747, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestoringDialog.<anonymous> (RestorePurchasesDialog.kt:54)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RESTORING), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getHeadlineSmall(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableSingletons$RestorePurchasesDialogKt.INSTANCE.m10718getLambda2$revenuecatui_defaultsBc8Release(), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1769526, 0, 16284);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    RestorePurchasesDialogKt.RestoringDialog(localization, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
