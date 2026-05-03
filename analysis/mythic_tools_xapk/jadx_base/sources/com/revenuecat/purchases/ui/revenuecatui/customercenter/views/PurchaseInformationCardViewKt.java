package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.ExpirationOrRenewal;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.KeyboardArrowRightKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseInformationCardView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0019"}, d2 = {"PurchaseInformationCardView", "", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "modifier", "Landroidx/compose/ui/Modifier;", "position", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/ButtonPosition;", "isDetailedView", "", "onCardClick", "Lkotlin/Function0;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/ButtonPosition;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PurchaseInformationCardView_Preview", "details", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Landroidx/compose/runtime/Composer;I)V", "PurchaseInformationCardView_Preview_Scale2", "getPrice", "", "getStoreText", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "getSubtitle", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseInformationCardViewKt {

    /* JADX INFO: compiled from: PurchaseInformationCardView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ButtonPosition.values().length];
            try {
                iArr[ButtonPosition.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonPosition.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonPosition.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonPosition.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Store.values().length];
            try {
                iArr2[Store.APP_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Store.MAC_APP_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Store.PLAY_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Store.AMAZON.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Store.GALAXY.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Store.PROMOTIONAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Store.STRIPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Store.EXTERNAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Store.PADDLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[Store.RC_BILLING.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[Store.UNKNOWN_STORE.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[Store.TEST_STORE.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PurchaseInformationCardView(final PurchaseInformation purchaseInformation, final CustomerCenterConfigData.Localization localization, Modifier modifier, ButtonPosition buttonPosition, boolean z, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        ButtonPosition buttonPosition2;
        int i5;
        boolean z2;
        int i6;
        RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4;
        Composer composer2;
        final ButtonPosition buttonPosition3;
        final Modifier modifier3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Composer composerStartRestartGroup = composer.startRestartGroup(-101507274);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseInformationCardView)P(5,1,2,4)64@3314L11,65@3394L11,66@3423L2507,61@3223L2707:PurchaseInformationCardView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(purchaseInformation) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
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
                    buttonPosition2 = buttonPosition;
                    i3 |= composerStartRestartGroup.changed(buttonPosition2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
                    }
                    if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        ButtonPosition buttonPosition4 = i4 == 0 ? ButtonPosition.SINGLE : buttonPosition2;
                        final boolean z4 = i5 == 0 ? false : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-101507274, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView (PurchaseInformationCardView.kt:43)");
                        }
                        i6 = WhenMappings.$EnumSwitchMapping$0[buttonPosition4.ordinal()];
                        if (i6 != 1) {
                            roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM());
                        } else if (i6 == 2) {
                            roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM());
                        } else if (i6 == 3) {
                            roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM());
                        } else {
                            if (i6 != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM());
                        }
                        Modifier modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                        boolean z5 = z4;
                        SurfaceKt.m4145SurfaceT9BRK9s(modifier4, roundedCornerShapeM2345RoundedCornerShape0680j_4, ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-63636015, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i8) {
                                PurchaseInformation purchaseInformation2;
                                CustomerCenterConfigData.Localization localization2;
                                PurchaseInformation purchaseInformation3;
                                CustomerCenterConfigData.Localization localization3;
                                ComposerKt.sourceInformation(composer3, "C69@3518L39,67@3433L2491:PurchaseInformationCardView.kt#870w7w");
                                if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-63636015, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView.<anonymous> (PurchaseInformationCardView.kt:67)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Function0<Unit> function02 = function0;
                                composer3.startReplaceGroup(672812244);
                                ComposerKt.sourceInformation(composer3, "CC(remember):PurchaseInformationCardView.kt#9igjgp");
                                boolean zChanged = composer3.changed(function0);
                                final Function0<Unit> function03 = function0;
                                Object objRememberedValue = composer3.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = (Function2) new Function2<Modifier, Function0<? extends Unit>, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt$PurchaseInformationCardView$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final Modifier invoke2(Modifier applyIfNotNull, Function0<Unit> it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            final Function0<Unit> function04 = function03;
                                            return ClickableKt.m1516clickableXHw0xAI$default(applyIfNotNull, false, null, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt$PurchaseInformationCardView$1$1$1.1
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
                                                    Function0<Unit> function05 = function04;
                                                    if (function05 != null) {
                                                        function05.invoke();
                                                    }
                                                }
                                            }, 7, null);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier5, Function0<? extends Unit> function04) {
                                            return invoke2(modifier5, (Function0<Unit>) function04);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                composer3.endReplaceGroup();
                                Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(ModifierExtensionsKt.applyIfNotNull(companion, function02, (Function2) objRememberedValue), CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM());
                                PurchaseInformation purchaseInformation4 = purchaseInformation;
                                CustomerCenterConfigData.Localization localization4 = localization;
                                boolean z6 = z4;
                                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2037padding3ABfNKs);
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
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1765992384, "C72@3651L1663,120@5798L10,121@5859L11,118@5676L238:PurchaseInformationCardView.kt#870w7w");
                                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                Alignment.Vertical top = Alignment.INSTANCE.getTop();
                                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, CustomerCenterConstants.Card.INSTANCE.m10694getTITLE_ROW_BOTTOM_PADDINGD9Ej5fM(), 7, null);
                                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composer3, 54);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -579350905, "C81@4117L10,82@4183L11,79@3971L304:PurchaseInformationCardView.kt#870w7w");
                                String title = purchaseInformation4.getTitle();
                                if (title == null) {
                                    StoreProduct product = purchaseInformation4.getProduct();
                                    String title2 = product != null ? product.getTitle() : null;
                                    title = title2 == null ? "" : title2;
                                }
                                TextKt.m4286Text4IGK_g(title, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 0, 0, 65528);
                                Composer composer4 = composer3;
                                if (purchaseInformation4.isSubscription() || z6) {
                                    purchaseInformation2 = purchaseInformation4;
                                    localization2 = localization4;
                                    composer4.startReplaceGroup(-1127028447);
                                    ComposerKt.sourceInformation(composer4, "103@5228L54");
                                    PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation2, localization2, composer4, 0);
                                    composer4.endReplaceGroup();
                                } else {
                                    composer4.startReplaceGroup(-578963871);
                                    ComposerKt.sourceInformation(composer4, "87@4403L774");
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(CustomerCenterConstants.Card.INSTANCE.m10689getBADGE_HORIZONTAL_PADDINGD9Ej5fM());
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically, composer4, 54);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, companion2);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor3);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer4);
                                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 722836374, "C99@5099L11,96@4915L236:PurchaseInformationCardView.kt#870w7w");
                                    composer4.startReplaceGroup(-1362156284);
                                    ComposerKt.sourceInformation(composer4, "94@4802L54");
                                    purchaseInformation2 = purchaseInformation4;
                                    localization2 = localization4;
                                    if (purchaseInformation4.isLifetime()) {
                                        PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation2, localization2, composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    IconKt.m3736Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), composer4, 48, 4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                String subtitle = PurchaseInformationCardViewKt.getSubtitle(purchaseInformation2, localization2);
                                composer4.startReplaceGroup(-1189903813);
                                ComposerKt.sourceInformation(composer4, "*113@5524L10,114@5589L11,111@5445L203");
                                if (subtitle == null) {
                                    purchaseInformation3 = purchaseInformation2;
                                    localization3 = localization2;
                                } else {
                                    purchaseInformation3 = purchaseInformation2;
                                    localization3 = localization2;
                                    TextKt.m4286Text4IGK_g(subtitle, (Modifier) null, Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer3, 0, 0, 65530);
                                    composer4 = composer3;
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                composer4.endReplaceGroup();
                                TextKt.m4286Text4IGK_g(PurchaseInformationCardViewKt.getStoreText(purchaseInformation3.getStore(), localization3), (Modifier) null, Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer3, 0, 0, 65530);
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
                        }, composerStartRestartGroup, 54), composer2, ((i3 >> 6) & 14) | 12582912, 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        buttonPosition3 = buttonPosition4;
                        modifier3 = modifier4;
                        z3 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        buttonPosition3 = buttonPosition2;
                        z3 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i8) {
                                PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, localization, modifier3, buttonPosition3, z3, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                z2 = z;
                if ((i2 & 32) == 0) {
                }
                if ((74899 & i3) == 74898) {
                    if (i7 != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[buttonPosition4.ordinal()];
                    if (i6 != 1) {
                    }
                    Modifier modifier42 = modifier2;
                    composer2 = composerStartRestartGroup;
                    boolean z52 = z4;
                    SurfaceKt.m4145SurfaceT9BRK9s(modifier42, roundedCornerShapeM2345RoundedCornerShape0680j_4, ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-63636015, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            PurchaseInformation purchaseInformation2;
                            CustomerCenterConfigData.Localization localization2;
                            PurchaseInformation purchaseInformation3;
                            CustomerCenterConfigData.Localization localization3;
                            ComposerKt.sourceInformation(composer3, "C69@3518L39,67@3433L2491:PurchaseInformationCardView.kt#870w7w");
                            if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-63636015, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView.<anonymous> (PurchaseInformationCardView.kt:67)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Function0<Unit> function02 = function0;
                            composer3.startReplaceGroup(672812244);
                            ComposerKt.sourceInformation(composer3, "CC(remember):PurchaseInformationCardView.kt#9igjgp");
                            boolean zChanged = composer3.changed(function0);
                            final Function0<Unit> function03 = function0;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = (Function2) new Function2<Modifier, Function0<? extends Unit>, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt$PurchaseInformationCardView$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final Modifier invoke2(Modifier applyIfNotNull, Function0<Unit> it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        final Function0<Unit> function04 = function03;
                                        return ClickableKt.m1516clickableXHw0xAI$default(applyIfNotNull, false, null, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt$PurchaseInformationCardView$1$1$1.1
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
                                                Function0<Unit> function05 = function04;
                                                if (function05 != null) {
                                                    function05.invoke();
                                                }
                                            }
                                        }, 7, null);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier5, Function0<? extends Unit> function04) {
                                        return invoke2(modifier5, (Function0<Unit>) function04);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            composer3.endReplaceGroup();
                            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(ModifierExtensionsKt.applyIfNotNull(companion, function02, (Function2) objRememberedValue), CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM());
                            PurchaseInformation purchaseInformation4 = purchaseInformation;
                            CustomerCenterConfigData.Localization localization4 = localization;
                            boolean z6 = z4;
                            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2037padding3ABfNKs);
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
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1765992384, "C72@3651L1663,120@5798L10,121@5859L11,118@5676L238:PurchaseInformationCardView.kt#870w7w");
                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            Alignment.Vertical top = Alignment.INSTANCE.getTop();
                            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, CustomerCenterConstants.Card.INSTANCE.m10694getTITLE_ROW_BOTTOM_PADDINGD9Ej5fM(), 7, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composer3, 54);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -579350905, "C81@4117L10,82@4183L11,79@3971L304:PurchaseInformationCardView.kt#870w7w");
                            String title = purchaseInformation4.getTitle();
                            if (title == null) {
                                StoreProduct product = purchaseInformation4.getProduct();
                                String title2 = product != null ? product.getTitle() : null;
                                title = title2 == null ? "" : title2;
                            }
                            TextKt.m4286Text4IGK_g(title, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 0, 0, 65528);
                            Composer composer4 = composer3;
                            if (purchaseInformation4.isSubscription() || z6) {
                                purchaseInformation2 = purchaseInformation4;
                                localization2 = localization4;
                                composer4.startReplaceGroup(-1127028447);
                                ComposerKt.sourceInformation(composer4, "103@5228L54");
                                PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation2, localization2, composer4, 0);
                                composer4.endReplaceGroup();
                            } else {
                                composer4.startReplaceGroup(-578963871);
                                ComposerKt.sourceInformation(composer4, "87@4403L774");
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(CustomerCenterConstants.Card.INSTANCE.m10689getBADGE_HORIZONTAL_PADDINGD9Ej5fM());
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically, composer4, 54);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, companion2);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 722836374, "C99@5099L11,96@4915L236:PurchaseInformationCardView.kt#870w7w");
                                composer4.startReplaceGroup(-1362156284);
                                ComposerKt.sourceInformation(composer4, "94@4802L54");
                                purchaseInformation2 = purchaseInformation4;
                                localization2 = localization4;
                                if (purchaseInformation4.isLifetime()) {
                                    PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation2, localization2, composer4, 0);
                                }
                                composer4.endReplaceGroup();
                                IconKt.m3736Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), composer4, 48, 4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            String subtitle = PurchaseInformationCardViewKt.getSubtitle(purchaseInformation2, localization2);
                            composer4.startReplaceGroup(-1189903813);
                            ComposerKt.sourceInformation(composer4, "*113@5524L10,114@5589L11,111@5445L203");
                            if (subtitle == null) {
                                purchaseInformation3 = purchaseInformation2;
                                localization3 = localization2;
                            } else {
                                purchaseInformation3 = purchaseInformation2;
                                localization3 = localization2;
                                TextKt.m4286Text4IGK_g(subtitle, (Modifier) null, Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer3, 0, 0, 65530);
                                composer4 = composer3;
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer4.endReplaceGroup();
                            TextKt.m4286Text4IGK_g(PurchaseInformationCardViewKt.getStoreText(purchaseInformation3.getStore(), localization3), (Modifier) null, Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer3, 0, 0, 65530);
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
                    }, composerStartRestartGroup, 54), composer2, ((i3 >> 6) & 14) | 12582912, 112);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    buttonPosition3 = buttonPosition4;
                    modifier3 = modifier42;
                    z3 = z52;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            buttonPosition2 = buttonPosition;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            z2 = z;
            if ((i2 & 32) == 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        buttonPosition2 = buttonPosition;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseInformationCardView_Preview(@PreviewParameter(provider = PurchaseInformationProvider.class) final PurchaseInformation purchaseInformation, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1729898988);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseInformationCardView_Preview)202@9425L284,202@9398L311:PurchaseInformationCardView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(purchaseInformation) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1729898988, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview (PurchaseInformationCardView.kt:201)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(832472595, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C203@9435L268:PurchaseInformationCardView.kt#870w7w");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(832472595, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview.<anonymous> (PurchaseInformationCardView.kt:203)");
                    }
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 2, null).getLocalization(), null, null, false, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    }, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.2
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
                    PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview(purchaseInformation, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseInformationCardView_Preview_Scale2(@PreviewParameter(provider = PurchaseInformationProvider.class) final PurchaseInformation purchaseInformation, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1576933981);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseInformationCardView_Preview_Scale2)219@10038L284,219@10011L311:PurchaseInformationCardView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(purchaseInformation) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576933981, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview_Scale2 (PurchaseInformationCardView.kt:218)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(184551620, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C220@10048L268:PurchaseInformationCardView.kt#870w7w");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(184551620, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview_Scale2.<anonymous> (PurchaseInformationCardView.kt:220)");
                    }
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 2, null).getLocalization(), null, null, false, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    }, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.2
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
                    PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2(purchaseInformation, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final String getPrice(PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        PriceDetails pricePaid = purchaseInformation.getPricePaid();
        if (pricePaid instanceof PriceDetails.Paid) {
            return ((PriceDetails.Paid) purchaseInformation.getPricePaid()).getPrice();
        }
        if (Intrinsics.areEqual(pricePaid, PriceDetails.Free.INSTANCE)) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE);
        }
        if (Intrinsics.areEqual(pricePaid, PriceDetails.Unknown.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getStoreText(Store store, CustomerCenterConfigData.Localization localization) {
        CustomerCenterConfigData.Localization.CommonLocalizedString commonLocalizedString;
        switch (WhenMappings.$EnumSwitchMapping$1[store.ordinal()]) {
            case 1:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.APP_STORE;
                break;
            case 2:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.MAC_APP_STORE;
                break;
            case 3:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.GOOGLE_PLAY_STORE;
                break;
            case 4:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.AMAZON_STORE;
                break;
            case 5:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.GALAXY_STORE;
                break;
            case 6:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.CARD_STORE_PROMOTIONAL;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.WEB_STORE;
                break;
            case 11:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.UNKNOWN_STORE;
                break;
            case 12:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.TEST_STORE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return localization.commonLocalizedString(commonLocalizedString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSubtitle(PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        ExpirationOrRenewal expirationOrRenewal = purchaseInformation.getExpirationOrRenewal();
        if (expirationOrRenewal instanceof ExpirationOrRenewal.Expiration) {
            return purchaseInformation.expirationString(((ExpirationOrRenewal.Expiration) purchaseInformation.getExpirationOrRenewal()).getDate(), localization);
        }
        if (expirationOrRenewal instanceof ExpirationOrRenewal.Renewal) {
            return purchaseInformation.renewalString(((ExpirationOrRenewal.Renewal) purchaseInformation.getExpirationOrRenewal()).getDate(), localization);
        }
        if (expirationOrRenewal == null) {
            return getPrice(purchaseInformation, localization);
        }
        throw new NoWhenBranchMatchedException();
    }
}
