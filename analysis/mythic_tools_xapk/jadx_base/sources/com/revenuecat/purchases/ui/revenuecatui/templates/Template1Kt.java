package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.content.res.Configuration;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Template1.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u0018\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"CircleMask", "", "landscapeLayout", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "CircleMaskPreview", "(Landroidx/compose/runtime/Composer;I)V", "HeaderImage", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;ZLandroidx/compose/runtime/Composer;I)V", "Template1", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)V", "Template1CondensedFooterPaywallPreview", "Template1FooterPaywallPreview", "Template1NoFooterPaywallPreview", "Template1PaywallPreview", "Template1MainContent", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template1Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircleMask(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1244949301);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircleMask)P(1)193@7609L74:Template1.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-1244949301, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CircleMask (Template1.kt:159)");
            }
            final float f = z ? 8.0f : 3.0f;
            Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, new Shape() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$CircleMask$clipShape$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo1539createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Matrix matrix = new Matrix();
                    float f2 = f;
                    matrix.preScale(f2, f2);
                    matrix.postTranslate(Template1Kt.CircleMask$circleOffsetX(f, size), Template1Kt.CircleMask$circleOffsetY(f, size));
                    Path Path = AndroidPath_androidKt.Path();
                    Path.addOval$default(Path, RectKt.m6120Recttz77jQw(Offset.INSTANCE.m6096getZeroF1C5BW0(), size), null, 2, null);
                    if (!(Path instanceof AndroidPath)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((AndroidPath) Path).getInternalPath().transform(matrix);
                    return new Outline.Generic(Path);
                }
            });
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1622594623, "C194@7668L9:Template1.kt#mf3l5c");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.CircleMask.2
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
                    Template1Kt.CircleMask(z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircleMask$circleOffsetX(float f, long j) {
        return (((Size.m6149getWidthimpl(j) * f) - Size.m6149getWidthimpl(j)) / 2.0f) * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircleMask$circleOffsetY(float f, long j) {
        return ((Size.m6146getHeightimpl(j) * f) - Size.m6146getHeightimpl(j)) * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircleMaskPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-414705569);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircleMaskPreview)251@9422L409:Template1.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-414705569, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CircleMaskPreview (Template1.kt:250)");
            }
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -977761583, "C252@9436L125,257@9570L255:Template1.kt#mf3l5c");
            BoxKt.Box(SizeKt.fillMaxSize$default(BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), 0.0f, 1, null), composerStartRestartGroup, 6);
            CircleMask(false, ComposableSingletons$Template1Kt.INSTANCE.m10849getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 54);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.CircleMaskPreview.2
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
                    Template1Kt.CircleMaskPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderImage(final Uri uri, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2030386997);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HeaderImage)P(1)*141@6029L521,141@5983L567:Template1.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2030386997, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage (Template1.kt:139)");
            }
            if (uri != null) {
                CircleMask(z, ComposableLambdaKt.rememberComposableLambda(1134746342, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1
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
                        ComposerKt.sourceInformation(composer2, "C142@6081L7,149@6384L91,143@6116L424:Template1.kt#mf3l5c");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1134746342, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage.<anonymous>.<anonymous> (Template1.kt:142)");
                        }
                        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        final int i4 = ((Configuration) objConsume).screenHeightDp;
                        String string = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                        Modifier modifierConditional = ModifierExtensionsKt.conditional(Modifier.INSTANCE, !z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return AspectRatioKt.aspectRatio$default(conditional, 1.2f, false, 2, null);
                            }
                        });
                        boolean z2 = z;
                        composer2.startReplaceGroup(-910575415);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Template1.kt#9igjgp");
                        boolean zChanged = composer2.changed(i4);
                        Object objRememberedValue = composer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Modifier invoke(Modifier conditional) {
                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                    return SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(conditional, 0.0f, 1, null), Dp.m9114constructorimpl(Dp.m9114constructorimpl(i4) / 2.0f));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceGroup();
                        RemoteImageKt.RemoteImage(string, ModifierExtensionsKt.conditional(modifierConditional, z2, (Function1) objRememberedValue), null, ContentScale.INSTANCE.getCrop(), null, null, 0.0f, null, composer2, 3072, 244);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 48);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.HeaderImage.2
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
                    Template1Kt.HeaderImage(uri, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void Template1(final PaywallState.Loaded.Legacy state, PaywallViewModel viewModel, Composer composer, final int i) {
        int i2;
        final PaywallViewModel paywallViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(1499444075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1)61@3159L306:Template1.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            paywallViewModel = viewModel;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499444075, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1 (Template1.kt:60)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720758292, "C66@3300L27,67@3336L32,68@3377L82:Template1.kt#mf3l5c");
            Template1MainContent(columnScopeInstance, state, composerStartRestartGroup, ((i2 << 3) & 112) | 6);
            paywallViewModel = viewModel;
            PurchaseButtonKt.m10664PurchaseButtonhGBTI10(state, paywallViewModel, null, 0.0f, null, composerStartRestartGroup, i2 & 126, 28);
            FooterKt.Footer(state.getTemplateConfiguration(), paywallViewModel, null, null, null, composerStartRestartGroup, i2 & 112, 28);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1.2
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
                    Template1Kt.Template1(state, paywallViewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1CondensedFooterPaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-527429650);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1CondensedFooterPaywallPreview)242@9108L204:Template1.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-527429650, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1CondensedFooterPaywallPreview (Template1.kt:241)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1CondensedFooterPaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1CondensedFooterPaywallPreview.2
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
                    Template1Kt.Template1CondensedFooterPaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1FooterPaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1625504547);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1FooterPaywallPreview)233@8786L194:Template1.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1625504547, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1FooterPaywallPreview (Template1.kt:232)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1FooterPaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1FooterPaywallPreview.2
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
                    Template1Kt.Template1FooterPaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1MainContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, Composer composer, final int i) {
        int i2;
        int i3;
        TemplateConfiguration.Colors colors;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1400671009);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1MainContent)76@3671L13,135@5862L19:Template1.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(legacy) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1400671009, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1MainContent (Template1.kt:74)");
            }
            ProcessedLocalizedConfiguration selectedLocalization = PaywallStateKt.getSelectedLocalization(legacy);
            int i5 = (i2 >> 3) & 14;
            TemplateConfiguration.Colors currentColors = PaywallStateKt.getCurrentColors(legacy, composerStartRestartGroup, i5);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                composerStartRestartGroup.startReplaceGroup(908514334);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3758L26,84@3898L21,81@3794L1965");
                boolean zShouldUseLandscapeLayout = WindowHelperKt.shouldUseLandscapeLayout(legacy, composerStartRestartGroup, i5);
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, SizeKt.fillMaxHeight$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 1.0f, false, 2, null);
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -126987547, "C90@4125L92,92@4231L38,96@4377L10,94@4283L587,109@4884L813,129@5711L38:Template1.kt#mf3l5c");
                HeaderImage(legacy.getTemplateConfiguration().getImages().getHeaderUri(), zShouldUseLandscapeLayout, composerStartRestartGroup, 0);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                i3 = i5;
                colors = null;
                i4 = 2;
                MarkdownKt.m10642MarkdownDkhmgE0(selectedLocalization.getTitle(), PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()), currentColors.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getDisplaySmall(), 0L, FontWeight.INSTANCE.getBlack(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, true, false, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 54, 720);
                Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1955246424, "C115@5148L10,113@5037L646:Template1.kt#mf3l5c");
                String subtitle = selectedLocalization.getSubtitle();
                if (subtitle == null) {
                    subtitle = "";
                }
                MarkdownKt.m10642MarkdownDkhmgE0(subtitle, PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()), currentColors.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, FontWeight.INSTANCE.getNormal(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, true, false, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 54, 720);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 2.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i3 = i5;
                colors = null;
                i4 = 2;
                composerStartRestartGroup.startReplaceGroup(910488166);
                ComposerKt.sourceInformation(composerStartRestartGroup, "132@5781L69");
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            OfferDetailsKt.OfferDetails(legacy, colors, composerStartRestartGroup, i3, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1MainContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    Template1Kt.Template1MainContent(columnScope, legacy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1NoFooterPaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(363342818);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1NoFooterPaywallPreview)224@8495L175:Template1.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(363342818, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1NoFooterPaywallPreview (Template1.kt:223)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1NoFooterPaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate1OfferingNoFooter(), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1NoFooterPaywallPreview.2
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
                    Template1Kt.Template1NoFooterPaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1PaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(854103102);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template1PaywallPreview)215@8205L167:Template1.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(854103102, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1PaywallPreview (Template1.kt:214)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1PaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1PaywallPreview.2
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
                    Template1Kt.Template1PaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
