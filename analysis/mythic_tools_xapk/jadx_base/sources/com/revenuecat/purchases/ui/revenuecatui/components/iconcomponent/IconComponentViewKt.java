package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u008a\u0084\u0002"}, d2 = {"IconComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IconComponentView_Margin_Preview", "(Landroidx/compose/runtime/Composer;I)V", "IconComponentView_Preview", "revenuecatui_defaultsBc8Release", "composeShape", "Landroidx/compose/ui/graphics/Shape;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class IconComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:114:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void IconComponentView(final IconComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final IconComponentState iconComponentStateRememberUpdatedIconComponentState;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(1519361895);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconComponentView)P(2,1)46@2436L93,57@2769L82,60@3007L186,67@3199L620:IconComponentView.kt#vnlbzp");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1519361895, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentView (IconComponentView.kt:45)");
                }
                iconComponentStateRememberUpdatedIconComponentState = IconComponentStateKt.rememberUpdatedIconComponentState(style, state, composerStartRestartGroup, i3 & 126);
                if (iconComponentStateRememberUpdatedIconComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier5 = modifier4;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i5) {
                                IconComponentViewKt.IconComponentView(style, state, modifier5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                BorderStyles border = iconComponentStateRememberUpdatedIconComponentState.getBorder();
                composerStartRestartGroup.startReplaceGroup(237806200);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2629L32");
                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow = iconComponentStateRememberUpdatedIconComponentState.getShadow();
                composerStartRestartGroup.startReplaceGroup(237808792);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*56@2710L32");
                ShadowStyle shadowStyleRememberShadowStyle = shadow == null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                Shape shape = iconComponentStateRememberUpdatedIconComponentState.getShape();
                composerStartRestartGroup.startReplaceGroup(237810914);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(shape);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt$IconComponentView$composeShape$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Shape invoke() {
                            Shape shape2 = iconComponentStateRememberUpdatedIconComponentState.getShape();
                            return shape2 == null ? RectangleShapeKt.getRectangleShape() : shape2;
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final State state2 = (State) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                ColorStyles backgroundColorStyles = iconComponentStateRememberUpdatedIconComponentState.getBackgroundColorStyles();
                composerStartRestartGroup.startReplaceGroup(237815391);
                ComposerKt.sourceInformation(composerStartRestartGroup, "58@2911L15");
                ColorStyle forCurrentTheme = backgroundColorStyles == null ? null : ColorStyleKt.getForCurrentTheme(backgroundColorStyles, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                ColorStyles tintColor = iconComponentStateRememberUpdatedIconComponentState.getTintColor();
                composerStartRestartGroup.startReplaceGroup(237817215);
                ComposerKt.sourceInformation(composerStartRestartGroup, "59@2968L15");
                final ColorStyle forCurrentTheme2 = tintColor != null ? ColorStyleKt.getForCurrentTheme(tintColor, composerStartRestartGroup, 0) : null;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(237818634);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconComponentView.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(forCurrentTheme2);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<ColorFilter>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt$IconComponentView$colorFilter$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ColorFilter invoke() {
                            ColorStyle colorStyle = forCurrentTheme2;
                            ColorStyle.Solid solid = colorStyle instanceof ColorStyle.Solid ? (ColorStyle.Solid) colorStyle : null;
                            if (solid != null) {
                                return ColorFilter.Companion.m6366tintxETnrds$default(ColorFilter.INSTANCE, solid.m10538unboximpl(), 0, 2, null);
                            }
                            return null;
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                State state3 = (State) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier6 = modifier4;
                Modifier modifierPadding = PaddingKt.padding(SizeKt.size$default(modifier4, iconComponentStateRememberUpdatedIconComponentState.getSizePlusMargin(), null, null, 6, null), iconComponentStateRememberUpdatedIconComponentState.getMargin());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324301517, "C76@3499L28,77@3577L32,79@3691L28,72@3332L481:IconComponentView.kt#vnlbzp");
                String url = iconComponentStateRememberUpdatedIconComponentState.getUrl();
                Modifier modifierSize$default = SizeKt.size$default(Modifier.INSTANCE, iconComponentStateRememberUpdatedIconComponentState.getSize(), null, null, 6, null);
                composerStartRestartGroup.startReplaceGroup(-181261845);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconComponentView.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(state2);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt$IconComponentView$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ShadowKt.shadow(applyIfNotNull, it, IconComponentViewKt.IconComponentView$lambda$3(state2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierSize$default, shadowStyleRememberShadowStyle, (Function2) objRememberedValue3);
                composerStartRestartGroup.startReplaceGroup(-181259345);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconComponentView.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(state2);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt$IconComponentView$2$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background(applyIfNotNull, it, IconComponentViewKt.IconComponentView$lambda$3(state2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, forCurrentTheme, (Function2) objRememberedValue4), IconComponentView$lambda$3(state2));
                composerStartRestartGroup.startReplaceGroup(-181255701);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconComponentView.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(state2);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt$IconComponentView$2$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BorderKt.border(applyIfNotNull, it, IconComponentViewKt.IconComponentView$lambda$3(state2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceGroup();
                RemoteImageKt.RemoteImage(url, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue5), iconComponentStateRememberUpdatedIconComponentState.getPadding()), null, null, null, null, 0.0f, IconComponentView$lambda$5(state3), composerStartRestartGroup, 0, 124);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        IconComponentViewKt.IconComponentView(style, state, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            iconComponentStateRememberUpdatedIconComponentState = IconComponentStateKt.rememberUpdatedIconComponentState(style, state, composerStartRestartGroup, i3 & 126);
            if (iconComponentStateRememberUpdatedIconComponentState.getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape IconComponentView$lambda$3(State<? extends Shape> state) {
        return state.getValue();
    }

    private static final ColorFilter IconComponentView$lambda$5(State<? extends ColorFilter> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void IconComponentView_Margin_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-178260139);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconComponentView_Margin_Preview)108@4500L20,108@4474L576:IconComponentView.kt#vnlbzp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-178260139, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentView_Margin_Preview (IconComponentView.kt:107)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$IconComponentViewKt.INSTANCE.m10475getLambda2$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView_Margin_Preview.1
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
                    IconComponentViewKt.IconComponentView_Margin_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IconComponentView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1522961854);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconComponentView_Preview)89@3916L20,89@3890L465:IconComponentView.kt#vnlbzp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522961854, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentView_Preview (IconComponentView.kt:88)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$IconComponentViewKt.INSTANCE.m10474getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView_Preview.1
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
                    IconComponentViewKt.IconComponentView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
