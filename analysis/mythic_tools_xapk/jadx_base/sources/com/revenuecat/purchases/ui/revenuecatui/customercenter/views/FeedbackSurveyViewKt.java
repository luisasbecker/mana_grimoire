package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeedbackSurveyView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\f\u0010\u0007\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002"}, d2 = {"FeedbackSurveyButtonsView", "", "options", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "onAnswerSubmit", "Lkotlin/Function1;", "loadingOption", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FeedbackSurveyPreview", "(Landroidx/compose/runtime/Composer;I)V", "FeedbackSurveyView", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class FeedbackSurveyViewKt {
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void FeedbackSurveyButtonsView(final List options, final Function1 onAnswerSubmit, final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Iterator it;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onAnswerSubmit, "onAnswerSubmit");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1555638088);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeedbackSurveyButtonsView)P(3,2)52@1887L480:FeedbackSurveyView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = 32;
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAnswerSubmit) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555638088, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyButtonsView (FeedbackSurveyView.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                boolean z = false;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -383512101, "C:FeedbackSurveyView.kt#870w7w");
                composerStartRestartGroup.startReplaceGroup(-1952033760);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@1999L26,58@2156L195,54@1965L386");
                it = options.iterator();
                while (it.hasNext()) {
                    final CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option) it.next();
                    boolean z2 = str == null ? true : z;
                    Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(8.0f));
                    composerStartRestartGroup.startReplaceGroup(1224801997);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):FeedbackSurveyView.kt#9igjgp");
                    boolean zChangedInstance = ((i3 & 112) == i4 ? true : z) | composerStartRestartGroup.changedInstance(option);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt$FeedbackSurveyButtonsView$1$1$1$1
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
                                onAnswerSubmit.invoke(option);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Composer composer3 = composerStartRestartGroup;
                    ButtonKt.Button((Function0) objRememberedValue, modifierM2037padding3ABfNKs, z2, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-611882050, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt$FeedbackSurveyButtonsView$1$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope Button, Composer composer4, int i6) {
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            ComposerKt.sourceInformation(composer4, "C:FeedbackSurveyView.kt#870w7w");
                            if ((i6 & 17) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-611882050, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyButtonsView.<anonymous>.<anonymous>.<anonymous> (FeedbackSurveyView.kt:59)");
                            }
                            if (Intrinsics.areEqual(str, option.getId())) {
                                composer4.startReplaceGroup(1330910285);
                                ComposerKt.sourceInformation(composer4, "60@2228L27");
                                ProgressIndicatorKt.m3947CircularProgressIndicatorLxG7B9w(null, 0L, 0.0f, 0L, 0, composer4, 0, 31);
                                composer4.endReplaceGroup();
                            } else {
                                composer4.startReplaceGroup(1330982422);
                                ComposerKt.sourceInformation(composer4, "62@2301L18");
                                TextKt.m4286Text4IGK_g(option.getTitle(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 131070);
                                composer4.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composer3, 805306416, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    i3 = i3;
                    composerStartRestartGroup = composer3;
                    companion = companion;
                    i4 = 32;
                    z = z;
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = companion;
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyButtonsView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i6) {
                        FeedbackSurveyViewKt.FeedbackSurveyButtonsView(options, onAnswerSubmit, str, modifier3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            boolean z3 = false;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -383512101, "C:FeedbackSurveyView.kt#870w7w");
                composerStartRestartGroup.startReplaceGroup(-1952033760);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@1999L26,58@2156L195,54@1965L386");
                it = options.iterator();
                while (it.hasNext()) {
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier42 = companion;
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final /* synthetic */ void FeedbackSurveyPreview(Composer composer, final int i) {
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1976778683);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeedbackSurveyPreview)73@2472L340:FeedbackSurveyView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1976778683, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyPreview (FeedbackSurveyView.kt:72)");
            }
            helpPath = null;
            CustomerCenterConfigData.Screen managementScreen = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getManagementScreen();
            if (managementScreen != null && (paths = managementScreen.getPaths()) != null) {
                for (CustomerCenterConfigData.HelpPath helpPath : paths) {
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Intrinsics.checkNotNull(helpPath);
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = helpPath.getFeedbackSurvey();
            Intrinsics.checkNotNull(feedbackSurvey);
            FeedbackSurveyView(new FeedbackSurveyData(feedbackSurvey, new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyPreview.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                }
            }), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyPreview.3
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
                    FeedbackSurveyViewKt.FeedbackSurveyPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final /* synthetic */ void FeedbackSurveyView(final FeedbackSurveyData data, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1091362999);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeedbackSurveyView)28@1141L42,31@1234L327:FeedbackSurveyView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(data) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091362999, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyView (FeedbackSurveyView.kt:27)");
            }
            composerStartRestartGroup.startReplaceGroup(125160704);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):FeedbackSurveyView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = data.getFeedbackSurvey();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 832180379, "C34@1350L151,32@1248L307:FeedbackSurveyView.kt#870w7w");
            List<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option> options = feedbackSurvey.getOptions();
            composerStartRestartGroup.startReplaceGroup(-250247028);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):FeedbackSurveyView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(data);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt$FeedbackSurveyView$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                        invoke2(option);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                        Intrinsics.checkNotNullParameter(option, "option");
                        mutableState.setValue(option.getId());
                        data.getOnAnswerSubmitted().invoke(option);
                        mutableState.setValue(null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            FeedbackSurveyButtonsView(options, (Function1) objRememberedValue2, FeedbackSurveyView$lambda$1(mutableState), null, composerStartRestartGroup, 0, 8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyView.2
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
                    FeedbackSurveyViewKt.FeedbackSurveyView(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final String FeedbackSurveyView$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}
