package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WithOptionalBackgroundOverlay.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"WithOptionalBackgroundOverlay", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WithOptionalBackgroundOverlayKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WithOptionalBackgroundOverlay(final PaywallState.Loaded.Components state, final BackgroundStyle backgroundStyle, Modifier modifier, Shape shape, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125981124);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WithOptionalBackgroundOverlay)P(4!1,2,3):WithOptionalBackgroundOverlay.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(backgroundStyle) : composerStartRestartGroup.changedInstance(backgroundStyle) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    rectangleShape = shape;
                    i3 |= composerStartRestartGroup.changed(rectangleShape) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                } else {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1125981124, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WithOptionalBackgroundOverlay (WithOptionalBackgroundOverlay.kt:18)");
                    }
                    if (backgroundStyle instanceof BackgroundStyle.Video) {
                        modifier3 = companion;
                        if (backgroundStyle instanceof BackgroundStyle.Image) {
                            BackgroundStyle.Image image = (BackgroundStyle.Image) backgroundStyle;
                            if (image.getColorOverlay() != null) {
                                composerStartRestartGroup.startReplaceGroup(-842877946);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1391L362");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -851540913, "C36@1539L174,41@1730L9:WithOptionalBackgroundOverlay.kt#dnqhhd");
                                BoxKt.Box(BackgroundKt.background(boxScopeInstance.matchParentSize(Modifier.INSTANCE), image.getColorOverlay(), rectangleShape), composerStartRestartGroup, 0);
                                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-842261356);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1794L9");
                                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-843214079);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "26@1006L41,21@827L220");
                        modifier3 = companion;
                        ViewWithVideoBackgroundKt.ViewWithVideoBackground(state, backgroundStyle, modifier3, rectangleShape, ComposableLambdaKt.rememberComposableLambda(340035564, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                                invoke(boxScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxScope ViewWithVideoBackground, Composer composer2, int i6) {
                                Intrinsics.checkNotNullParameter(ViewWithVideoBackground, "$this$ViewWithVideoBackground");
                                ComposerKt.sourceInformation(composer2, "C27@1024L9:WithOptionalBackgroundOverlay.kt#dnqhhd");
                                if ((i6 & 17) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(340035564, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WithOptionalBackgroundOverlay.<anonymous> (WithOptionalBackgroundOverlay.kt:27)");
                                }
                                content.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                final Shape shape2 = rectangleShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay.3
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
                            WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(state, backgroundStyle, modifier4, shape2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            rectangleShape = shape;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
                if (i5 == 0) {
                }
                if (i4 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (backgroundStyle instanceof BackgroundStyle.Video) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
            }
            final Shape shape22 = rectangleShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        rectangleShape = shape;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        final Shape shape222 = rectangleShape;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
