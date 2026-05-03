package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
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
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: CarouselComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a-\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002\u001aÀ\u0001\u0010$\u001a\u00020\u00032\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010(\u001a\u00020\u001a2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010<\u001a\u00020\u00182\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a*\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020A2\u0006\u00101\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u0012\u0010F\u001a\u00020\u001f2\b\b\u0002\u0010G\u001a\u00020HH\u0002\u001a\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002\u001a3\u0010J\u001a\u00020\u0001*\u00020K2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010L\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020OX\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020QX\u008a\u0084\u0002²\u0006\n\u0010R\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010T\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010B\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020/X\u008a\u0084\u0002"}, d2 = {"CarouselComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CarouselComponentView_Loop_Preview", "(Landroidx/compose/runtime/Composer;I)V", "CarouselComponentView_Preview", "CarouselComponentView_Top_Preview", "EnableAutoAdvance", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "shouldLoop", "", "pageCount", "", "(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Landroidx/compose/foundation/pager/PagerState;ZILandroidx/compose/runtime/Composer;I)V", "Indicator", "pageIndex", "pageControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "(Landroidx/compose/foundation/pager/PagerState;IILcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;Landroidx/compose/runtime/Composer;I)V", "getInitialPage", "carouselState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/carousel/CarouselComponentState;", "previewCarouselComponentStyle", "pages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "initialPageIndex", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "visible", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "sidePagePeek", "Landroidx/compose/ui/unit/Dp;", "spacing", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "borderStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadowStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "loop", "previewCarouselComponentStyle-2XaYeUA", "(Ljava/util/List;ILandroidx/compose/ui/Alignment$Vertical;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FFJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ZLcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "previewPage", "pageText", "", "height", "Lkotlin/UInt;", "previewPage-ecKwGiE", "(Ljava/lang/String;JI)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "previewPageControl", "position", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "previewPages", "PagerIndicator", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ILandroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "composeShape", "Landroidx/compose/ui/graphics/Shape;", "progress", "", "targetWidth", "targetHeight", "targetStrokeWidth", "width", "strokeWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class CarouselComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:132:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void CarouselComponentView(final CarouselComponentStyle style, final PaywallState.Loaded.Components state, final Function2 clickHandler, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final CarouselComponentState carouselComponentStateRememberUpdatedCarouselComponentState;
        final int i4;
        Modifier modifier3;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1375939683);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView)P(3,2)76@4197L97,93@4774L116,93@4728L162,108@5157L35,109@5243L39,111@5363L102,105@5037L1696:CarouselComponentView.kt#zahkep");
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
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1375939683, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView (CarouselComponentView.kt:75)");
                }
                carouselComponentStateRememberUpdatedCarouselComponentState = CarouselComponentStateKt.rememberUpdatedCarouselComponentState(style, state, composerStartRestartGroup, i3 & 126);
                if (carouselComponentStateRememberUpdatedCarouselComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i6) {
                                CarouselComponentViewKt.CarouselComponentView(style, state, clickHandler, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                Modifier modifier5 = companion;
                BackgroundStyles background = carouselComponentStateRememberUpdatedCarouselComponentState.getBackground();
                composerStartRestartGroup.startReplaceGroup(481623526);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*85@4415L27");
                BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border = carouselComponentStateRememberUpdatedCarouselComponentState.getBorder();
                composerStartRestartGroup.startReplaceGroup(481626091);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*86@4495L32");
                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow = carouselComponentStateRememberUpdatedCarouselComponentState.getShadow();
                composerStartRestartGroup.startReplaceGroup(481628811);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*87@4580L32");
                ShadowStyle shadowStyleRememberShadowStyle = shadow == null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                final int size = style.getPages().size();
                ShadowStyle shadowStyle = shadowStyleRememberShadowStyle;
                int initialPage = getInitialPage(carouselComponentStateRememberUpdatedCarouselComponentState);
                composerStartRestartGroup.startReplaceGroup(481635287);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(carouselComponentStateRememberUpdatedCarouselComponentState) | composerStartRestartGroup.changed(size);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$pagerState$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            return Integer.valueOf(carouselComponentStateRememberUpdatedCarouselComponentState.getLoop() ? Integer.MAX_VALUE : size);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Composer composer3 = composerStartRestartGroup;
                final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(initialPage, 0.0f, (Function0) objRememberedValue, composer3, 0, 2);
                CarouselComponent.AutoAdvancePages autoAdvance = carouselComponentStateRememberUpdatedCarouselComponentState.getAutoAdvance();
                composer3.startReplaceGroup(481640047);
                ComposerKt.sourceInformation(composer3, "*102@4952L73");
                if (autoAdvance == null) {
                    i4 = size;
                } else {
                    EnableAutoAdvance(autoAdvance, pagerStateRememberPagerState, carouselComponentStateRememberUpdatedCarouselComponentState.getLoop(), size, composer3, 0);
                    i4 = size;
                    composer3 = composer3;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer3.endReplaceGroup();
                Modifier modifierPadding = PaddingKt.padding(modifier5, carouselComponentStateRememberUpdatedCarouselComponentState.getMargin());
                composer3.startReplaceGroup(481647462);
                ComposerKt.sourceInformation(composer3, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged2 = composer3.changed(carouselComponentStateRememberUpdatedCarouselComponentState);
                Object objRememberedValue2 = composer3.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$3$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ShadowKt.shadow(applyIfNotNull, it, carouselComponentStateRememberUpdatedCarouselComponentState.getShape());
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                composer3.endReplaceGroup();
                Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyle, (Function2) objRememberedValue2);
                composer3.startReplaceGroup(481650218);
                ComposerKt.sourceInformation(composer3, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged3 = composer3.changed(carouselComponentStateRememberUpdatedCarouselComponentState);
                Object objRememberedValue3 = composer3.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background(applyIfNotNull, it, carouselComponentStateRememberUpdatedCarouselComponentState.getShape());
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                composer3.endReplaceGroup();
                Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, backgroundStyleRememberBackgroundStyle, (Function2) objRememberedValue3), carouselComponentStateRememberUpdatedCarouselComponentState.getShape());
                composer3.startReplaceGroup(481654121);
                ComposerKt.sourceInformation(composer3, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged4 = composer3.changed(carouselComponentStateRememberUpdatedCarouselComponentState);
                Object objRememberedValue4 = composer3.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$5$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return PaddingKt.m2037padding3ABfNKs(BorderKt.border(applyIfNotNull, it, carouselComponentStateRememberUpdatedCarouselComponentState.getShape()), it.m10519getWidthD9Ej5fM());
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                composer3.endReplaceGroup();
                Modifier modifierPadding2 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), carouselComponentStateRememberUpdatedCarouselComponentState.getPadding());
                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierPadding2);
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
                final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 585335441, "C138@6386L204,131@5947L643:CarouselComponentView.kt#zahkep");
                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$6$pageControl$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        return invoke(composer4, num.intValue());
                    }

                    public final Unit invoke(Composer composer4, int i6) {
                        Composer composer5;
                        Unit unit3;
                        composer4.startReplaceGroup(1379076393);
                        ComposerKt.sourceInformation(composer4, "C*119@5620L159:CarouselComponentView.kt#zahkep");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1379076393, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView.<anonymous>.<anonymous> (CarouselComponentView.kt:118)");
                        }
                        CarouselComponentStyle.PageControlStyles pageControl = carouselComponentStateRememberUpdatedCarouselComponentState.getPageControl();
                        if (pageControl == null) {
                            unit3 = null;
                            composer5 = composer4;
                        } else {
                            composer5 = composer4;
                            CarouselComponentViewKt.PagerIndicator(columnScopeInstance, pageControl, i4, pagerStateRememberPagerState, null, composer5, 0, 8);
                            unit3 = Unit.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer5.endReplaceGroup();
                        return unit3;
                    }
                };
                composer3.startReplaceGroup(1820005182);
                ComposerKt.sourceInformation(composer3, "128@5914L13");
                CarouselComponentStyle.PageControlStyles pageControl = carouselComponentStateRememberUpdatedCarouselComponentState.getPageControl();
                if ((pageControl != null ? pageControl.getPosition() : null) == CarouselComponent.PageControl.Position.TOP) {
                    function2.invoke(composer3, 0);
                }
                composer3.endReplaceGroup();
                Composer composer4 = composer3;
                modifier3 = modifier5;
                PagerKt.m2292HorizontalPageroI3XNZo(pagerStateRememberPagerState, null, PaddingKt.m2032PaddingValuesYgX7TsA$default(Dp.m9114constructorimpl(carouselComponentStateRememberUpdatedCarouselComponentState.m10464getPagePeekD9Ej5fM() + carouselComponentStateRememberUpdatedCarouselComponentState.m10465getPageSpacingD9Ej5fM()), 0.0f, 2, null), null, i4, carouselComponentStateRememberUpdatedCarouselComponentState.m10465getPageSpacingD9Ej5fM(), carouselComponentStateRememberUpdatedCarouselComponentState.getPageAlignment(), null, false, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(755613877, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer5, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer5, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope HorizontalPager, int i6, Composer composer5, int i7) {
                        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                        ComposerKt.sourceInformation(composer5, "C139@6408L172:CarouselComponentView.kt#zahkep");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(755613877, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView.<anonymous>.<anonymous> (CarouselComponentView.kt:139)");
                        }
                        StackComponentViewKt.StackComponentView((StackComponentStyle) carouselComponentStateRememberUpdatedCarouselComponentState.getPages().get(i6 % i4), state, clickHandler, null, 0.0f, composer5, 0, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54), composer4, 0, 3072, 8074);
                composer2 = composer4;
                composer2.startReplaceGroup(1820030369);
                ComposerKt.sourceInformation(composer2, "147@6704L13");
                CarouselComponentStyle.PageControlStyles pageControl2 = carouselComponentStateRememberUpdatedCarouselComponentState.getPageControl();
                if ((pageControl2 != null ? pageControl2.getPosition() : null) == CarouselComponent.PageControl.Position.BOTTOM) {
                    function2.invoke(composer2, 0);
                }
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
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier6 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                        invoke(composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i6) {
                        CarouselComponentViewKt.CarouselComponentView(style, state, clickHandler, modifier6, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            carouselComponentStateRememberUpdatedCarouselComponentState = CarouselComponentStateKt.rememberUpdatedCarouselComponentState(style, state, composerStartRestartGroup, i3 & 126);
            if (carouselComponentStateRememberUpdatedCarouselComponentState.getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Loop_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-172536871);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Loop_Preview)355@13462L528:CarouselComponentView.kt#zahkep");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-172536871, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Loop_Preview (CarouselComponentView.kt:354)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -927652820, "C365@13923L19,356@13521L463:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m10469previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, true, new CarouselComponent.AutoAdvancePages(1000, 500, CarouselComponent.AutoAdvancePages.TransitionType.FADE), 16383, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Loop_Preview$1$1(null), null, composerStartRestartGroup, 384, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Loop_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Loop_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(697064564);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Preview)329@12752L222:CarouselComponentView.kt#zahkep");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(697064564, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Preview (CarouselComponentView.kt:328)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1693427909, "C332@12907L19,330@12811L157:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m10469previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, false, null, 65535, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Preview$1$1(null), null, composerStartRestartGroup, 384, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Top_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(897820094);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Top_Preview)341@13053L329:CarouselComponentView.kt#zahkep");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897820094, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Top_Preview (CarouselComponentView.kt:340)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2110680794, "C346@13315L19,342@13112L264:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m10469previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, previewPageControl(CarouselComponent.PageControl.Position.TOP), false, null, 57343, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Top_Preview$1$1(null), null, composerStartRestartGroup, 384, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Top_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Top_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnableAutoAdvance(final CarouselComponent.AutoAdvancePages autoAdvancePages, final PagerState pagerState, final boolean z, final int i, Composer composer, final int i2) {
        int i3;
        boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-845596149);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EnableAutoAdvance)P(!1,2,3)290@11416L707,290@11395L728:CarouselComponentView.kt#zahkep");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(autoAdvancePages) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(pagerState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-845596149, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.EnableAutoAdvance (CarouselComponentView.kt:289)");
            }
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(906902516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(autoAdvancePages) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048);
            CarouselComponentViewKt$EnableAutoAdvance$1$1 carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue = new CarouselComponentViewKt$EnableAutoAdvance$1$1(autoAdvancePages, pagerState, z2, i, null);
                composerStartRestartGroup.updateRememberedValue(carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.EnableAutoAdvance.2
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
                    CarouselComponentViewKt.EnableAutoAdvance(autoAdvancePages, pagerState, z, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Indicator(final PagerState pagerState, final int i, final int i2, final CarouselComponentStyle.PageControlStyles pageControlStyles, Composer composer, final int i3) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532758904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)P(3,2,1)194@8286L871,216@9182L198,225@9405L200,235@9636L226,245@9881L58,248@9958L59,253@10076L15,254@10177L15,267@10770L64,277@11097L110,271@10840L374:CarouselComponentView.kt#zahkep");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(pageControlStyles) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532758904, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.Indicator (CarouselComponentView.kt:193)");
            }
            composerStartRestartGroup.startReplaceGroup(-106660265);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$progress$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        int currentPage = pagerState.getCurrentPage() % i2;
                        int i5 = i;
                        float currentPageOffsetFraction = 0.0f;
                        if (i5 == currentPage) {
                            float currentPageOffsetFraction2 = pagerState.getCurrentPageOffsetFraction();
                            PagerState pagerState2 = pagerState;
                            currentPageOffsetFraction = currentPageOffsetFraction2 >= 0.0f ? 1.0f - pagerState2.getCurrentPageOffsetFraction() : pagerState2.getCurrentPageOffsetFraction() + 1.0f;
                        } else if (i5 == currentPage + 1 && pagerState.getCurrentPageOffsetFraction() >= 0.0f) {
                            currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
                        } else if (i == currentPage - 1 && pagerState.getCurrentPageOffsetFraction() < 0.0f) {
                            currentPageOffsetFraction = -pagerState.getCurrentPageOffsetFraction();
                        }
                        return Float.valueOf(currentPageOffsetFraction);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final State state = (State) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106632266);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Dp invoke() {
                        return Dp.m9112boximpl(m10473invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m10473invokeD9Ej5fM() {
                        return DpKt.m9157lerpMdfbLM(pageControlStyles.getDefault().m10584getWidthD9Ej5fM(), pageControlStyles.getActive().m10584getWidthD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$19(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state2 = (State) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106625128);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetHeight$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Dp invoke() {
                        return Dp.m9112boximpl(m10471invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m10471invokeD9Ej5fM() {
                        return DpKt.m9157lerpMdfbLM(pageControlStyles.getDefault().m10582getHeightD9Ej5fM(), pageControlStyles.getActive().m10582getHeightD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$19(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state3 = (State) objRememberedValue3;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106617710);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetStrokeWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Dp invoke() {
                        return Dp.m9112boximpl(m10472invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m10472invokeD9Ej5fM() {
                        Dp dpM10583getStrokeWidthlTKBWiU = pageControlStyles.getDefault().m10583getStrokeWidthlTKBWiU();
                        float fM9128unboximpl = dpM10583getStrokeWidthlTKBWiU != null ? dpM10583getStrokeWidthlTKBWiU.m9128unboximpl() : Dp.m9114constructorimpl(0.0f);
                        Dp dpM10583getStrokeWidthlTKBWiU2 = pageControlStyles.getActive().m10583getStrokeWidthlTKBWiU();
                        return DpKt.m9157lerpMdfbLM(fM9128unboximpl, dpM10583getStrokeWidthlTKBWiU2 != null ? dpM10583getStrokeWidthlTKBWiU2.m9128unboximpl() : Dp.m9114constructorimpl(0.0f), CarouselComponentViewKt.Indicator$lambda$19(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            State state4 = (State) objRememberedValue4;
            composerStartRestartGroup.endReplaceGroup();
            State<Dp> stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(Indicator$lambda$21(state2), null, null, null, composerStartRestartGroup, 0, 14);
            State<Dp> stateM1380animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(Indicator$lambda$23(state3), null, null, null, composerStartRestartGroup, 0, 14);
            ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(pageControlStyles.getDefault().getColor(), composerStartRestartGroup, 0);
            ColorStyle.Solid solid = forCurrentTheme instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme : null;
            long jM10538unboximpl = solid != null ? solid.m10538unboximpl() : Color.INSTANCE.m6360getTransparent0d7_KjU();
            ColorStyle forCurrentTheme2 = ColorStyleKt.getForCurrentTheme(pageControlStyles.getActive().getColor(), composerStartRestartGroup, 0);
            ColorStyle.Solid solid2 = forCurrentTheme2 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme2 : null;
            long jM6376lerpjxsXWHM = ColorKt.m6376lerpjxsXWHM(jM10538unboximpl, solid2 != null ? solid2.m10538unboximpl() : Color.INSTANCE.m6360getTransparent0d7_KjU(), Indicator$lambda$19(state));
            boolean z = ((pageControlStyles.getDefault().getStrokeColor() == null && pageControlStyles.getActive().getStrokeColor() == null) || (pageControlStyles.getDefault().m10583getStrokeWidthlTKBWiU() == null && pageControlStyles.getActive().m10583getStrokeWidthlTKBWiU() == null)) ? false : true;
            ColorStyles strokeColor = pageControlStyles.getDefault().getStrokeColor();
            composerStartRestartGroup.startReplaceGroup(-106588769);
            ComposerKt.sourceInformation(composerStartRestartGroup, "262@10547L15");
            ColorStyle forCurrentTheme3 = strokeColor == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            ColorStyle.Solid solid3 = forCurrentTheme3 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme3 : null;
            long jM10538unboximpl2 = solid3 != null ? solid3.m10538unboximpl() : Color.INSTANCE.m6360getTransparent0d7_KjU();
            ColorStyles strokeColor2 = pageControlStyles.getActive().getStrokeColor();
            composerStartRestartGroup.startReplaceGroup(-106585313);
            ComposerKt.sourceInformation(composerStartRestartGroup, "263@10655L15");
            ColorStyle forCurrentTheme4 = strokeColor2 == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            ColorStyle.Solid solid4 = forCurrentTheme4 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme4 : null;
            final long jM6376lerpjxsXWHM2 = ColorKt.m6376lerpjxsXWHM(jM10538unboximpl2, solid4 != null ? solid4.m10538unboximpl() : Color.INSTANCE.m6360getTransparent0d7_KjU(), Indicator$lambda$19(state));
            final State<Dp> stateM1380animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(Indicator$lambda$25(state4), null, null, null, composerStartRestartGroup, 0, 14);
            Modifier modifierM2085sizeVpY3zN4 = SizeKt.m2085sizeVpY3zN4(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9114constructorimpl(pageControlStyles.m10588getSpacingD9Ej5fM() / 2.0f), 0.0f, 2, null), ShapeKt.toShape(Shape.Pill.INSTANCE)), jM6376lerpjxsXWHM, null, 2, null), Indicator$lambda$26(stateM1380animateDpAsStateAjpBEmI), Indicator$lambda$27(stateM1380animateDpAsStateAjpBEmI2));
            composerStartRestartGroup.startReplaceGroup(-106571074);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateM1380animateDpAsStateAjpBEmI3) | composerStartRestartGroup.changed(jM6376lerpjxsXWHM2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return androidx.compose.foundation.BorderKt.m1494borderxT4_qwU(conditional, CarouselComponentViewKt.Indicator$lambda$28(stateM1380animateDpAsStateAjpBEmI3), jM6376lerpjxsXWHM2, ShapeKt.toShape(Shape.Pill.INSTANCE));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceGroup();
            BoxKt.Box(ModifierExtensionsKt.conditional(modifierM2085sizeVpY3zN4, z, (Function1) objRememberedValue5), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.Indicator.2
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
                    CarouselComponentViewKt.Indicator(pagerState, i, i2, pageControlStyles, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$19(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Indicator$lambda$21(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    private static final float Indicator$lambda$23(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    private static final float Indicator$lambda$25(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    private static final float Indicator$lambda$26(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    private static final float Indicator$lambda$27(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$28(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a7 A[LOOP:0: B:112:0x02a5->B:113:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PagerIndicator(final ColumnScope columnScope, final CarouselComponentStyle.PageControlStyles pageControlStyles, final int i, final PagerState pagerState, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        PagerState pagerState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        int i7;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final CarouselComponentStyle.PageControlStyles pageControlStyles2 = pageControlStyles;
        int i8 = i;
        Composer composerStartRestartGroup = composer.startRestartGroup(736305479);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PagerIndicator)P(1,2,3)162@7201L78,168@7449L28,169@7528L32,170@7602L28,164@7285L760:CarouselComponentView.kt#zahkep");
        if ((i3 & Integer.MIN_VALUE) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(pageControlStyles2) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i8) ? 256 : 128;
        }
        if ((i3 & 4) != 0) {
            i4 |= 3072;
        } else {
            if ((i2 & 3072) == 0) {
                pagerState2 = pagerState;
                i4 |= composerStartRestartGroup.changed(pagerState2) ? 2048 : 1024;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                }
                i6 = i4;
                if ((i6 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(736305479, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.PagerIndicator (CarouselComponentView.kt:158)");
                    }
                    ColorStyles backgroundColor = pageControlStyles2.getBackgroundColor();
                    composerStartRestartGroup.startReplaceGroup(740859066);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6995L15");
                    ColorStyle forCurrentTheme = backgroundColor != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    BorderStyles border = pageControlStyles2.getBorder();
                    composerStartRestartGroup.startReplaceGroup(740860947);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*160@7059L32");
                    BorderStyle borderStyleRememberBorderStyle = border != null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    ShadowStyles shadow = pageControlStyles2.getShadow();
                    composerStartRestartGroup.startReplaceGroup(740863603);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*161@7142L32");
                    ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0) : null;
                    composerStartRestartGroup.endReplaceGroup();
                    Shape shape = pageControlStyles2.getShape();
                    composerStartRestartGroup.startReplaceGroup(740865721);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(shape);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$composeShape$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final androidx.compose.ui.graphics.Shape invoke() {
                                return ShapeKt.toShape(pageControlStyles2.getShape());
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    state = (State) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding = PaddingKt.padding(columnScope.align(modifier2, Alignment.INSTANCE.getCenterHorizontally()), pageControlStyles2.getMargin());
                    composerStartRestartGroup.startReplaceGroup(740873607);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return ShadowKt.shadow(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                    composerStartRestartGroup.startReplaceGroup(740876139);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(state);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function2) new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return BackgroundKt.background(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierApplyIfNotNull2 = ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, forCurrentTheme, (Function2) objRememberedValue3);
                    composerStartRestartGroup.startReplaceGroup(740878503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(state);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return BorderKt.border(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding2 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull2, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), pageControlStyles2.getPadding());
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    i7 = 0;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding2);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1292583912, "C:CarouselComponentView.kt#zahkep");
                    composerStartRestartGroup.startReplaceGroup(-96851077);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*176@7843L186");
                    while (i7 < i8) {
                        int i9 = i8;
                        int i10 = i7;
                        Indicator(pagerState2, i10, i9, pageControlStyles2, composerStartRestartGroup, ((i6 >> 9) & 14) | (i6 & 896) | ((i6 << 6) & 7168));
                        i7 = i10 + 1;
                        pageControlStyles2 = pageControlStyles;
                        i8 = i;
                        pagerState2 = pagerState;
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
                }
                final Modifier modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.PagerIndicator.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CarouselComponentViewKt.PagerIndicator(columnScope, pageControlStyles, i, pagerState, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            modifier2 = modifier;
            i6 = i4;
            if ((i6 & 9363) == 9362) {
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ColorStyles backgroundColor2 = pageControlStyles2.getBackgroundColor();
                composerStartRestartGroup.startReplaceGroup(740859066);
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@6995L15");
                if (backgroundColor2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border2 = pageControlStyles2.getBorder();
                composerStartRestartGroup.startReplaceGroup(740860947);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*160@7059L32");
                if (border2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow2 = pageControlStyles2.getShadow();
                composerStartRestartGroup.startReplaceGroup(740863603);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*161@7142L32");
                if (shadow2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Shape shape2 = pageControlStyles2.getShape();
                composerStartRestartGroup.startReplaceGroup(740865721);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(shape2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$composeShape$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final androidx.compose.ui.graphics.Shape invoke() {
                            return ShapeKt.toShape(pageControlStyles2.getShape());
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    state = (State) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding3 = PaddingKt.padding(columnScope.align(modifier2, Alignment.INSTANCE.getCenterHorizontally()), pageControlStyles2.getMargin());
                    composerStartRestartGroup.startReplaceGroup(740873607);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return ShadowKt.shadow(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierApplyIfNotNull3 = ModifierExtensionsKt.applyIfNotNull(modifierPadding3, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                        composerStartRestartGroup.startReplaceGroup(740876139);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(state);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = (Function2) new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return BackgroundKt.background(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierApplyIfNotNull22 = ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull3, forCurrentTheme, (Function2) objRememberedValue3);
                            composerStartRestartGroup.startReplaceGroup(740878503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(state);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4) {
                                objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return BorderKt.border(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$12(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                composerStartRestartGroup.endReplaceGroup();
                                Modifier modifierPadding22 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull22, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), pageControlStyles2.getPadding());
                                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                i7 = 0;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding22);
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
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1292583912, "C:CarouselComponentView.kt#zahkep");
                                    composerStartRestartGroup.startReplaceGroup(-96851077);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*176@7843L186");
                                    while (i7 < i8) {
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
                                }
                            }
                        }
                    }
                }
            }
            final Modifier modifier32 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        pagerState2 = pagerState;
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i4;
        if ((i6 & 9363) == 9362) {
        }
        final Modifier modifier322 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.graphics.Shape PagerIndicator$lambda$12(State<? extends androidx.compose.ui.graphics.Shape> state) {
        return state.getValue();
    }

    private static final int getInitialPage(CarouselComponentState carouselComponentState) {
        if (!carouselComponentState.getLoop()) {
            return carouselComponentState.getInitialPageIndex();
        }
        int i = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        while (i % carouselComponentState.getPages().size() != carouselComponentState.getInitialPageIndex()) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA, reason: not valid java name */
    private static final CarouselComponentStyle m10468previewCarouselComponentStyle2XaYeUA(List<StackComponentStyle> list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, long j, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        return new CarouselComponentStyle(list, i, vertical, z, size, f, f2, BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(j)), null, 2, null))), paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z2, autoAdvancePages, null, null, null, null, CollectionsKt.emptyList(), 655360, null);
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA$default, reason: not valid java name */
    static /* synthetic */ CarouselComponentStyle m10469previewCarouselComponentStyle2XaYeUA$default(List list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, long j, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, int i2, Object obj) {
        List list2;
        int i3;
        Shape shape2;
        BorderStyles borderStyles2;
        CarouselComponent.AutoAdvancePages autoAdvancePages2;
        CarouselComponentStyle.PageControlStyles pageControlStylesPreviewPageControl$default;
        List listPreviewPages = (i2 & 1) != 0 ? previewPages() : list;
        int i4 = (i2 & 2) != 0 ? 0 : i;
        Alignment.Vertical centerVertically = (i2 & 4) != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
        boolean z3 = (i2 & 8) != 0 ? true : z;
        Size size2 = (i2 & 16) != 0 ? new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE) : size;
        float fM9114constructorimpl = (i2 & 32) != 0 ? Dp.m9114constructorimpl(20.0f) : f;
        float fM9114constructorimpl2 = (i2 & 64) != 0 ? Dp.m9114constructorimpl(8.0f) : f2;
        long jM6357getLightGray0d7_KjU = (i2 & 128) != 0 ? Color.INSTANCE.m6357getLightGray0d7_KjU() : j;
        PaddingValues paddingValuesM2030PaddingValues0680j_4 = (i2 & 256) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
        PaddingValues paddingValuesM2032PaddingValuesYgX7TsA$default = (i2 & 512) != 0 ? PaddingKt.m2032PaddingValuesYgX7TsA$default(0.0f, Dp.m9114constructorimpl(16.0f), 1, null) : paddingValues2;
        Shape.Rectangle rectangle = (i2 & 1024) != 0 ? new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null) : shape;
        if ((i2 & 2048) != 0) {
            list2 = listPreviewPages;
            i3 = i4;
            shape2 = rectangle;
            borderStyles2 = new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null);
        } else {
            list2 = listPreviewPages;
            i3 = i4;
            shape2 = rectangle;
            borderStyles2 = borderStyles;
        }
        ShadowStyles shadowStyles2 = (i2 & 4096) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(5.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null) : shadowStyles;
        if ((i2 & 8192) != 0) {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = previewPageControl$default(null, 1, null);
        } else {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = pageControlStyles;
        }
        boolean z4 = (i2 & 16384) != 0 ? false : z2;
        if ((i2 & 32768) != 0) {
            autoAdvancePages = autoAdvancePages2;
        }
        return m10468previewCarouselComponentStyle2XaYeUA(list2, i3, centerVertically, z3, size2, fM9114constructorimpl, fM9114constructorimpl2, jM6357getLightGray0d7_KjU, paddingValuesM2030PaddingValues0680j_4, paddingValuesM2032PaddingValuesYgX7TsA$default, shape2, borderStyles2, shadowStyles2, pageControlStylesPreviewPageControl$default, z4, autoAdvancePages);
    }

    /* JADX INFO: renamed from: previewPage-ecKwGiE, reason: not valid java name */
    private static final StackComponentStyle m10470previewPageecKwGiE(String str, long j, int i) {
        return new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), true, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(i, null)), Dp.m9114constructorimpl(8.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(j)), null, 2, null))), PaddingKt.m2032PaddingValuesYgX7TsA$default(0.0f, Dp.m9114constructorimpl(16.0f), 1, null), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final CarouselComponentStyle.PageControlStyles previewPageControl(CarouselComponent.PageControl.Position position) {
        return new CarouselComponentStyle.PageControlStyles(position, Dp.m9114constructorimpl(4.0f), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(8.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(8.0f)), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), null, 2, null), Shape.Pill.INSTANCE, new BorderStyles(Dp.m9114constructorimpl(4.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(8.0f), Dp.m9114constructorimpl(8.0f), null), new CarouselComponentStyle.IndicatorStyles(Dp.m9114constructorimpl(14.0f), Dp.m9114constructorimpl(10.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null), Dp.m9112boximpl(Dp.m9114constructorimpl(2.0f)), null), new CarouselComponentStyle.IndicatorStyles(Dp.m9114constructorimpl(8.0f), Dp.m9114constructorimpl(8.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6355getGray0d7_KjU())), null, 2, null), null, 0 == true ? 1 : 0, null), null);
    }

    static /* synthetic */ CarouselComponentStyle.PageControlStyles previewPageControl$default(CarouselComponent.PageControl.Position position, int i, Object obj) {
        if ((i & 1) != 0) {
            position = CarouselComponent.PageControl.Position.BOTTOM;
        }
        return previewPageControl(position);
    }

    private static final List<StackComponentStyle> previewPages() {
        return CollectionsKt.listOf((Object[]) new StackComponentStyle[]{m10470previewPageecKwGiE("Page 1", Color.INSTANCE.m6359getRed0d7_KjU(), 200), m10470previewPageecKwGiE("Page 2", Color.INSTANCE.m6356getGreen0d7_KjU(), 100), m10470previewPageecKwGiE("Page 3", Color.INSTANCE.m6352getBlue0d7_KjU(), 300), m10470previewPageecKwGiE("Page 4", Color.INSTANCE.m6363getYellow0d7_KjU(), 200)});
    }
}
