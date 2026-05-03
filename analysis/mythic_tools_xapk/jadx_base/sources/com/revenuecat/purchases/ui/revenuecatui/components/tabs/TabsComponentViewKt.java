package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.camera.video.AudioStats;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TabsComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0011\u001a\u0094\u0001\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"DURATION_MS_CROSS_FADE", "", "TabsComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TabsComponentView_Preview", "(Landroidx/compose/runtime/Composer;I)V", "previewStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "children", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "spacing", "Landroidx/compose/ui/unit/Dp;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "tabIndex", "previewStackComponentStyle-gNPyAyM", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Ljava/lang/Integer;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class TabsComponentViewKt {
    private static final int DURATION_MS_CROSS_FADE = 220;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TabsComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1", f = "TabsComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08171 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C08171(Continuation<? super C08171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C08171) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TabsComponentView(final TabsComponentStyle style, final PaywallState.Loaded.Components state, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final TabsComponentState tabsComponentStateRememberUpdatedTabsComponentState;
        final PaywallState.Loaded.Components components;
        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-284405731);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabsComponentView)P(3,2)75@4650L93,89@5202L31,90@5279L35,92@5391L49,98@5695L318,85@5031L982:TabsComponentView.kt#fyu6fh");
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
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                final Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-284405731, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView (TabsComponentView.kt:73)");
                }
                tabsComponentStateRememberUpdatedTabsComponentState = TabsComponentStateKt.rememberUpdatedTabsComponentState(style, state, composerStartRestartGroup, i3 & 126);
                if (tabsComponentStateRememberUpdatedTabsComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.1
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

                            public final void invoke(Composer composer2, int i5) {
                                TabsComponentViewKt.TabsComponentView(style, state, clickHandler, companion, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                components = state;
                function2 = clickHandler;
                Modifier modifier4 = companion;
                BackgroundStyles background = tabsComponentStateRememberUpdatedTabsComponentState.getBackground();
                composerStartRestartGroup.startReplaceGroup(-390025338);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*81@4834L27");
                BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border = tabsComponentStateRememberUpdatedTabsComponentState.getBorder();
                composerStartRestartGroup.startReplaceGroup(-390022901);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*82@4910L32");
                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow = tabsComponentStateRememberUpdatedTabsComponentState.getShadow();
                composerStartRestartGroup.startReplaceGroup(-390020309);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*83@4991L32");
                ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0) : null;
                composerStartRestartGroup.endReplaceGroup();
                Integer numValueOf = Integer.valueOf(components.getSelectedTabIndex());
                Modifier modifierPadding = PaddingKt.padding(modifier4, tabsComponentStateRememberUpdatedTabsComponentState.getMargin());
                composerStartRestartGroup.startReplaceGroup(-390013374);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(tabsComponentStateRememberUpdatedTabsComponentState);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$2$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ShadowKt.shadow(applyIfNotNull, it, tabsComponentStateRememberUpdatedTabsComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyleRememberShadowStyle, (Function2) objRememberedValue);
                composerStartRestartGroup.startReplaceGroup(-390010906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(tabsComponentStateRememberUpdatedTabsComponentState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function2) new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$3$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background(applyIfNotNull, it, tabsComponentStateRememberUpdatedTabsComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, backgroundStyleRememberBackgroundStyle, (Function2) objRememberedValue2), tabsComponentStateRememberUpdatedTabsComponentState.getShape());
                composerStartRestartGroup.startReplaceGroup(-390007308);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(tabsComponentStateRememberUpdatedTabsComponentState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$4$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return PaddingKt.m2037padding3ABfNKs(BorderKt.border(applyIfNotNull, it, tabsComponentStateRememberUpdatedTabsComponentState.getShape()), it.m10519getWidthD9Ej5fM());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                AnimatedContentKt.AnimatedContent(numValueOf, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue3), tabsComponentStateRememberUpdatedTabsComponentState.getPadding()), new Function1<AnimatedContentTransitionScope<Integer>, ContentTransform>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.5
                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<Integer> AnimatedContent) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TabsComponentViewKt.DURATION_MS_CROSS_FADE, 0, null, 4, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TabsComponentViewKt.DURATION_MS_CROSS_FADE, 0, null, 6, null), 0.0f, 2, null));
                    }
                }, null, null, null, ComposableLambdaKt.rememberComposableLambda(1188428519, true, new Function4<AnimatedContentScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Integer num, Composer composer2, Integer num2) {
                        invoke(animatedContentScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope AnimatedContent, int i5, Composer composer2, int i6) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        ComposerKt.sourceInformation(composer2, "C101@5879L128:TabsComponentView.kt#fyu6fh");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1188428519, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView.<anonymous> (TabsComponentView.kt:100)");
                        }
                        StackComponentViewKt.StackComponentView(((TabsComponentStyle.Tab) tabsComponentStateRememberUpdatedTabsComponentState.getTabs().get(RangesKt.coerceIn(i5, (ClosedRange<Integer>) new IntRange(0, CollectionsKt.getLastIndex(tabsComponentStateRememberUpdatedTabsComponentState.getTabs()))))).getStack(), components, function2, null, 0.0f, composer2, 0, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1573248, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                components = state;
                function2 = clickHandler;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final PaywallState.Loaded.Components components2 = components;
                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22 = function2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.7
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

                    public final void invoke(Composer composer2, int i5) {
                        TabsComponentViewKt.TabsComponentView(style, components2, function22, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            tabsComponentStateRememberUpdatedTabsComponentState = TabsComponentStateKt.rememberUpdatedTabsComponentState(style, state, composerStartRestartGroup, i3 & 126);
            if (tabsComponentStateRememberUpdatedTabsComponentState.getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabsComponentView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1844948686);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabsComponentView_Preview)254@11971L19,178@8774L3251:TabsComponentView.kt#fyu6fh");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844948686, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView_Preview (TabsComponentView.kt:113)");
            }
            PresentedOverride presentedOverride = new PresentedOverride(CollectionsKt.listOf(ComponentOverride.Condition.Selected.INSTANCE), (PresentedPartial) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(LocalizedTextPartial.INSTANCE.invoke(new PartialTextComponent((Boolean) null, (String) null, (ColorScheme) null, (ColorScheme) null, (String) null, FontWeight.EXTRA_BOLD, (Integer) null, (Integer) null, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, 4063, (DefaultConstructorMarker) null), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("dummy")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("dummy"))), new Pair[0])), new Pair[0]), MapsKt.emptyMap(), MapsKt.emptyMap())));
            StackComponentStyle stackComponentStyleM10600previewStackComponentStylegNPyAyM$default = m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf((Object[]) new TabControlButtonComponentStyle[]{new TabControlButtonComponentStyle(0, m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 1", null, 0, null, null, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, 0, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), 0.0f, null, null, null, null, null, null, null, 4086, null)), new TabControlButtonComponentStyle(1, m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 2", null, 0, null, null, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, 1, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), 0.0f, null, null, null, null, null, null, null, 4086, null)), new TabControlButtonComponentStyle(2, m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 3", null, 0, null, null, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, 2, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), 0.0f, null, null, null, null, null, null, null, 4086, null))}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.CENTER), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(8.0f), null, null, null, null, null, null, null, 4068, null);
            TabsComponentView(new TabsComponentStyle(true, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6357getLightGray0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6354getDarkGray0d7_KjU()))))), new Shape.Rectangle(new CornerRadiuses.Dp(16.0d)), new BorderStyles(Dp.m9114constructorimpl(8.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU()))), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU()))), Dp.m9114constructorimpl(6.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(10.0f), null), new TabControlStyle.Buttons(m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.emptyList(), null, false, null, 0.0f, null, null, null, null, null, null, null, 4094, null)), NonEmptyListKt.nonEmptyListOf(new TabsComponentStyle.Tab(m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM10600previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 1 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab(m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM10600previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 2 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab(m10600previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM10600previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 3 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU()))))), null, null, null, null, null, null, 4062, null))), CollectionsKt.emptyList()), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C08171(null), null, composerStartRestartGroup, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView_Preview.2
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
                    TabsComponentViewKt.TabsComponentView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM, reason: not valid java name */
    private static final StackComponentStyle m10599previewStackComponentStylegNPyAyM(List<? extends ComponentStyle> list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num) {
        return new StackComponentStyle(list, dimension, z, size, f, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, null, null, null, null, num, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM$default, reason: not valid java name */
    static /* synthetic */ StackComponentStyle m10600previewStackComponentStylegNPyAyM$default(List list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER);
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return m10599previewStackComponentStylegNPyAyM(list, dimension, z, (i & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE) : size, (i & 16) != 0 ? Dp.m9114constructorimpl(0.0f) : f, (i & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6360getTransparent0d7_KjU())), null, 2, null))) : backgroundStyles, (i & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues, (i & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2, (i & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(AudioStats.AUDIO_AMPLITUDE_NONE)) : shape, (i & 512) != 0 ? null : borderStyles, (i & 1024) != 0 ? null : shadowStyles, (i & 2048) != 0 ? null : num);
    }
}
