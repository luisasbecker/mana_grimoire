package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ColorsFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template2TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: Footer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0003¢\u0006\u0002\u0010\u000e\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001aB\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000b2\f\b\u0001\u0010\u001d\u001a\u00020\u001e\"\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010#\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Footer", "", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "configuration", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "childModifier", "Landroidx/compose/ui/Modifier;", "allPlansTapped", "Lkotlin/Function0;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "templateConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FooterPreview", "(Landroidx/compose/runtime/Composer;I)V", "openURL", "context", "Landroid/content/Context;", "url", "Ljava/net/URL;", "Button", "Landroidx/compose/foundation/layout/RowScope;", "color", "Landroidx/compose/ui/graphics/Color;", "texts", "", "", NativeProtocol.WEB_DIALOG_ACTION, "Button-sW7UJKQ", "(Landroidx/compose/foundation/layout/RowScope;JLandroidx/compose/ui/Modifier;[ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Separator", "Separator-RPmYEkk", "(Landroidx/compose/foundation/layout/RowScope;JLandroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FooterKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button-sW7UJKQ, reason: not valid java name */
    public static final void m10628ButtonsW7UJKQ(final RowScope rowScope, final long j, final Modifier modifier, final int[] iArr, final Function0<Unit> function0, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-806477784);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)P(2:c#ui.graphics.Color,1,3)197@7016L29,199@7051L1961:Footer.kt#51odh9");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        composerStartRestartGroup.startMovableGroup(2066969951, Integer.valueOf(iArr.length));
        for (int i3 : iArr) {
            i2 |= composerStartRestartGroup.changed(i3) ? 2048 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i2 & 7168) == 0) {
            i2 |= 1024;
        }
        int i4 = i2;
        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806477784, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button (Footer.kt:192)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(ArraysKt.first(iArr), composerStartRestartGroup, 0);
            Modifier modifierAlign = rowScope.align(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -522055366, "C205@7209L14,209@7402L141,213@7555L1451,204@7175L1831:Footer.kt#51odh9");
            composerStartRestartGroup.startReplaceGroup(814442768);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
            boolean z = (57344 & i4) == 16384;
            FooterKt$Button$1$1$1 footerKt$Button$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || footerKt$Button$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                footerKt$Button$1$1$1RememberedValue = new FooterKt$Button$1$1$1(function0);
                composerStartRestartGroup.updateRememberedValue(footerKt$Button$1$1$1RememberedValue);
            }
            KFunction kFunction = (KFunction) footerKt$Button$1$1$1RememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            PaddingValues paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(4.0f));
            Modifier modifierAlign2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
            composerStartRestartGroup.startReplaceGroup(814449071);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setText(semantics, new AnnotatedString(strStringResource, null, null, 6, null));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            ButtonKt.TextButton((Function0) kFunction, SemanticsModifierKt.semantics(modifierAlign2, true, (Function1) objRememberedValue), false, null, null, null, null, paddingValuesM2030PaddingValues0680j_4, null, ComposableLambdaKt.rememberComposableLambda(365963733, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer3, Integer num) {
                    invoke(rowScope2, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer3, int i5) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation(composer3, "C216@7730L1266:Footer.kt#51odh9");
                    int i6 = (i5 & 6) == 0 ? i5 | (composer3.changed(TextButton) ? 4 : 2) : i5;
                    if ((i6 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(365963733, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous> (Footer.kt:216)");
                    }
                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    });
                    composer3.startReplaceGroup(-1033616621);
                    ComposerKt.sourceInformation(composer3, "*221@7951L478");
                    int[] iArr2 = iArr;
                    final Modifier modifier2 = modifier;
                    final long j2 = j;
                    ArrayList arrayList = new ArrayList(iArr2.length);
                    for (final int i7 : iArr2) {
                        arrayList.add(ComposableLambdaKt.rememberComposableLambda(-1943754282, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i8) {
                                ComposerKt.sourceInformation(composer4, "C223@8026L18,226@8211L7,222@7981L422:Footer.kt#51odh9");
                                if ((i8 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1943754282, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:222)");
                                }
                                String strStringResource2 = StringResources_androidKt.stringResource(i7, composer4, 0);
                                int iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                                TextKt.m4286Text4IGK_g(strStringResource2, modifier2, j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(iM8992getCentere0LSkKk), 0L, 0, false, 1, 0, (Function1) null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, 3456, 52728);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54));
                    }
                    ArrayList arrayList2 = arrayList;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1033598812);
                    ComposerKt.sourceInformation(composer3, "*234@8509L431");
                    int[] iArr3 = iArr;
                    final Modifier modifier3 = modifier;
                    final long j3 = j;
                    ArrayList arrayList3 = new ArrayList(iArr3.length);
                    for (final int i8 : iArr3) {
                        arrayList3.add(ComposableLambdaKt.rememberComposableLambda(1301841013, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i9) {
                                ComposerKt.sourceInformation(composer4, "C236@8584L18,239@8769L7,235@8539L375:Footer.kt#51odh9");
                                if ((i9 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1301841013, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:235)");
                                }
                                String strStringResource2 = StringResources_androidKt.stringResource(i8, composer4, 0);
                                int iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                                TextKt.m4286Text4IGK_g(strStringResource2, modifier3, j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(iM8992getCentere0LSkKk), 0L, 0, true, 0, 0, (Function1) null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, 384, 60920);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54));
                    }
                    composer3.endReplaceGroup();
                    AdaptiveComposableKt.AdaptiveComposable(TextButton, modifierClearAndSetSemantics, FooterKt.Button_sW7UJKQ$merge(arrayList2, arrayList3), composer3, i6 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, 817889280, 380);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    RowScope rowScope2 = rowScope;
                    long j2 = j;
                    Modifier modifier2 = modifier;
                    int[] iArr2 = iArr;
                    FooterKt.m10628ButtonsW7UJKQ(rowScope2, j2, modifier2, Arrays.copyOf(iArr2, iArr2.length), function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<T> Button_sW7UJKQ$merge(List<? extends T> list, List<? extends T> list2) {
        return CollectionsKt.plus((Collection) list, (Iterable) list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Footer(final PaywallMode paywallMode, final PaywallData.Configuration configuration, TemplateConfiguration.Colors colors, final PaywallViewModel paywallViewModel, Modifier modifier, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        PaywallData.Configuration configuration2;
        TemplateConfiguration.Colors colors2;
        int i4;
        Modifier modifier2;
        int i5;
        Function0<Unit> function02;
        Function0<Unit> function03;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Modifier modifier3;
        boolean z;
        Modifier modifier4;
        Function0<Unit> function04;
        boolean z2;
        int i6;
        boolean z3;
        String str;
        final URL termsOfServiceURL;
        final URL privacyURL;
        final Function0<Unit> function05;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(603087565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Footer)P(4,3,2,5,1)86@3748L7,97@4197L2111:Footer.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(paywallMode) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                configuration2 = configuration;
                i3 |= composerStartRestartGroup.changedInstance(configuration2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    colors2 = colors;
                    i3 |= composerStartRestartGroup.changed(colors2) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
                }
                i4 = i2 & 16;
                if (i4 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i5 = i2 & 32;
                    if (i5 != 0) {
                        if ((196608 & i) == 0) {
                            function02 = function0;
                            i3 |= composerStartRestartGroup.changedInstance(function02) ? 131072 : 65536;
                        }
                        if ((74899 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function05 = function02;
                        } else {
                            if (i4 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            function03 = i5 == 0 ? null : function02;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(603087565, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Footer (Footer.kt:84)");
                            }
                            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localView);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Context context = ((View) objConsume).getContext();
                            boolean z4 = (paywallMode == PaywallMode.FOOTER_CONDENSED || function03 == null) ? false : true;
                            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), (z4 && !configuration2.getDisplayRestorePurchases() && configuration2.getTermsOfServiceURL() == null && configuration2.getPrivacyURL() == null) ? Dp.m9114constructorimpl(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM() * 2.0f) : Dp.m9114constructorimpl(0.0f), 2, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
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
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 10827219, "C:Footer.kt#51odh9");
                            modifier3 = modifier2;
                            z = z4;
                            long jM10781getText10d7_KjU = colors2.m10781getText10d7_KjU();
                            composerStartRestartGroup.startReplaceGroup(-1108029477);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4740L176,123@5115L24");
                            if (z || function03 == null) {
                                modifier4 = modifier3;
                                function04 = function03;
                                z2 = false;
                                i6 = 2048;
                                z3 = true;
                            } else {
                                modifier4 = modifier3;
                                z2 = false;
                                i6 = 2048;
                                z3 = true;
                                m10628ButtonsW7UJKQ(rowScopeInstance, jM10781getText10d7_KjU, modifier4, new int[]{R.string.all_plans}, function03, composerStartRestartGroup, ((i3 >> 6) & 896) | 6 | ((i3 >> 3) & 57344));
                                function04 = function03;
                                if (configuration.getDisplayRestorePurchases() || configuration.getTermsOfServiceURL() != null || configuration.getPrivacyURL() != null) {
                                    m10629SeparatorRPmYEkk(rowScopeInstance, jM10781getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-1108013353);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "133@5408L32,128@5230L210,136@5553L24");
                            if (configuration.getDisplayRestorePurchases()) {
                                str = "CC(remember):Footer.kt#9igjgp";
                            } else {
                                int[] iArr = {R.string.restore_purchases, R.string.restore};
                                composerStartRestartGroup.startReplaceGroup(-1108006229);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
                                if ((i3 & 7168) != i6) {
                                    z3 = z2;
                                }
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$1$1
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
                                            paywallViewModel.restorePurchases();
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                str = "CC(remember):Footer.kt#9igjgp";
                                m10628ButtonsW7UJKQ(rowScopeInstance, jM10781getText10d7_KjU, modifier4, iArr, (Function0) objRememberedValue, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                if (configuration.getTermsOfServiceURL() != null || configuration.getPrivacyURL() != null) {
                                    m10629SeparatorRPmYEkk(rowScopeInstance, jM10781getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            termsOfServiceURL = configuration.getTermsOfServiceURL();
                            composerStartRestartGroup.startReplaceGroup(-1107998342);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*146@5841L52,141@5662L231");
                            if (termsOfServiceURL != null) {
                                int[] iArr2 = {R.string.terms_and_conditions, R.string.terms};
                                composerStartRestartGroup.startReplaceGroup(-546690466);
                                ComposerKt.sourceInformation(composerStartRestartGroup, str);
                                boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(termsOfServiceURL);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$2$1$1
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
                                            Context context2 = context;
                                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                                            FooterKt.openURL(context2, termsOfServiceURL);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                m10628ButtonsW7UJKQ(rowScopeInstance, jM10781getText10d7_KjU, modifier4, iArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                composerStartRestartGroup.startReplaceGroup(-1107990199);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "151@5963L24");
                                if (configuration.getPrivacyURL() != null) {
                                    m10629SeparatorRPmYEkk(rowScopeInstance, jM10781getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            privacyURL = configuration.getPrivacyURL();
                            composerStartRestartGroup.startReplaceGroup(-1107985558);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*161@6240L52,156@6065L227");
                            if (privacyURL != null) {
                                int[] iArr3 = {R.string.privacy_policy, R.string.privacy};
                                composerStartRestartGroup.startReplaceGroup(-546677698);
                                ComposerKt.sourceInformation(composerStartRestartGroup, str);
                                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(privacyURL);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$3$1$1
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
                                            Context context2 = context;
                                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                                            FooterKt.openURL(context2, privacyURL);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                m10628ButtonsW7UJKQ(rowScopeInstance, jM10781getText10d7_KjU, modifier4, iArr3, (Function0) objRememberedValue3, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
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
                            modifier2 = modifier4;
                            function05 = function04;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final TemplateConfiguration.Colors colors3 = colors2;
                            final Modifier modifier5 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i7) {
                                    FooterKt.Footer(paywallMode, configuration, colors3, paywallViewModel, modifier5, function05, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function02 = function0;
                    if ((74899 & i3) == 74898) {
                        if (i4 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localView2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Context context2 = ((View) objConsume2).getContext();
                        if (paywallMode == PaywallMode.FOOTER_CONDENSED) {
                            if (z4) {
                                Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), (z4 && !configuration2.getDisplayRestorePurchases() && configuration2.getTermsOfServiceURL() == null && configuration2.getPrivacyURL() == null) ? Dp.m9114constructorimpl(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM() * 2.0f) : Dp.m9114constructorimpl(0.0f), 2, null);
                                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM5595constructorimpl.getInserting()) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 10827219, "C:Footer.kt#51odh9");
                                    modifier3 = modifier2;
                                    z = z4;
                                    long jM10781getText10d7_KjU2 = colors2.m10781getText10d7_KjU();
                                    composerStartRestartGroup.startReplaceGroup(-1108029477);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@4740L176,123@5115L24");
                                    if (z) {
                                        modifier4 = modifier3;
                                        function04 = function03;
                                        z2 = false;
                                        i6 = 2048;
                                        z3 = true;
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.startReplaceGroup(-1108013353);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "133@5408L32,128@5230L210,136@5553L24");
                                        if (configuration.getDisplayRestorePurchases()) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        termsOfServiceURL = configuration.getTermsOfServiceURL();
                                        composerStartRestartGroup.startReplaceGroup(-1107998342);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "*146@5841L52,141@5662L231");
                                        if (termsOfServiceURL != null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        privacyURL = configuration.getPrivacyURL();
                                        composerStartRestartGroup.startReplaceGroup(-1107985558);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "*161@6240L52,156@6065L227");
                                        if (privacyURL != null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        modifier2 = modifier4;
                                        function05 = function04;
                                    }
                                }
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 32;
                if (i5 != 0) {
                }
                function02 = function0;
                if ((74899 & i3) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            colors2 = colors;
            if ((i2 & 8) != 0) {
            }
            i4 = i2 & 16;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function02 = function0;
            if ((74899 & i3) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        configuration2 = configuration;
        if ((i2 & 4) == 0) {
        }
        colors2 = colors;
        if ((i2 & 8) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function02 = function0;
        if ((74899 & i3) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Footer(final TemplateConfiguration templateConfiguration, final PaywallViewModel viewModel, Modifier modifier, TemplateConfiguration.Colors colors, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TemplateConfiguration.Colors colors2;
        int i4;
        Function0<Unit> function02;
        TemplateConfiguration.Colors currentColors;
        int i5;
        final TemplateConfiguration.Colors colors3;
        Function0<Unit> function03;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Function0<Unit> function04;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1570484492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Footer)P(3,4,1,2)62@2961L331:Footer.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(templateConfiguration) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    colors2 = colors;
                    int i7 = composerStartRestartGroup.changed(colors2) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    colors2 = colors;
                }
                i3 |= i7;
            } else {
                colors2 = colors;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function02 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    colors3 = colors2;
                    function04 = function02;
                } else {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2891L18");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 8) == 0) {
                            currentColors = templateConfiguration.getCurrentColors(composerStartRestartGroup, i3 & 14);
                            i3 &= -7169;
                        } else {
                            currentColors = colors2;
                        }
                        if (i4 == 0) {
                            function03 = null;
                            Modifier modifier3 = companion;
                            i5 = i3;
                            colors3 = currentColors;
                            modifier2 = modifier3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1570484492, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Footer (Footer.kt:61)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 9143268, "C63@2978L281,71@3268L18:Footer.kt#51odh9");
                            int i8 = i5 << 6;
                            Footer(templateConfiguration.getMode(), templateConfiguration.getConfiguration(), colors3, viewModel, modifier2, function03, composerStartRestartGroup, ((i5 >> 3) & 896) | (i8 & 7168) | (i8 & 57344) | ((i5 << 3) & 458752), 0);
                            InsetSpacersKt.SystemBarsSpacer(composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function04 = function03;
                        } else {
                            Modifier modifier4 = companion;
                            i5 = i3;
                            colors3 = currentColors;
                            modifier2 = modifier4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        i5 = i3;
                        colors3 = colors2;
                    }
                    function03 = function02;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion22);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 9143268, "C63@2978L281,71@3268L18:Footer.kt#51odh9");
                        int i82 = i5 << 6;
                        Footer(templateConfiguration.getMode(), templateConfiguration.getConfiguration(), colors3, viewModel, modifier2, function03, composerStartRestartGroup, ((i5 >> 3) & 896) | (i82 & 7168) | (i82 & 57344) | ((i5 << 3) & 458752), 0);
                        InsetSpacersKt.SystemBarsSpacer(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function04 = function03;
                    }
                }
                final Modifier modifier5 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            FooterKt.Footer(templateConfiguration, viewModel, modifier5, colors3, function04, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            function02 = function0;
            if ((i3 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "59@2891L18");
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if (i4 == 0) {
                    }
                }
            }
            final Modifier modifier52 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        function02 = function0;
        if ((i3 & 9363) == 9362) {
        }
        final Modifier modifier522 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1861228911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FooterPreview)271@9648L703:Footer.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1861228911, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.FooterPreview (Footer.kt:270)");
            }
            Footer(PaywallMode.FULL_SCREEN, new PaywallData.Configuration(CollectionsKt.emptyList(), (String) null, new PaywallData.Configuration.Images((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null), (Map) null, Template2TestDataKt.getTemplate2(TestData.INSTANCE).getConfig().getColors(), (Map) null, (List) null, false, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), 104, (DefaultConstructorMarker) null), ColorsFactory.INSTANCE.create(Template2TestDataKt.getTemplate2(TestData.INSTANCE).getConfig().getColors().getLight()), new MockViewModel(PaywallMode.FULL_SCREEN, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 28, null), null, null, composerStartRestartGroup, 6, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.FooterPreview.1
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
                    FooterKt.FooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Separator-RPmYEkk, reason: not valid java name */
    public static final void m10629SeparatorRPmYEkk(final RowScope rowScope, final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1035469312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Separator)P(0:c#ui.graphics.Color)170@6375L368:Footer.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035469312, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Separator (Footer.kt:169)");
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenter(), false, 2, null), 0.5f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611385380, "C176@6533L204:Footer.kt#51odh9");
            BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(5.0f)), RoundedCornerShapeKt.getCircleShape()), j, null, 2, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Separator$2
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
                    FooterKt.m10629SeparatorRPmYEkk(rowScope, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL(final Context context, URL url) {
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        UrisKt.openUriOrElse(context, string, new Function1<Exception, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.openURL.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                boolean z = exception instanceof ActivityNotFoundException;
                Context context2 = context;
                String string2 = z ? context2.getString(R.string.no_browser_cannot_open_link) : context2.getString(R.string.cannot_open_link);
                Intrinsics.checkNotNullExpressionValue(string2, "if (exception is Activit…nnot_open_link)\n        }");
                Toast.makeText(context, string2, 0).show();
                Logger.INSTANCE.w(string2);
            }
        });
    }
}
