package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.LayoutReference;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a&\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002\u001a:\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a3\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\u001e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010+\u001a3\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020,2\u0006\u0010(\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020\u001e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020%0/2\b\b\u0002\u00100\u001a\u00020\u001aH\u0003¢\u0006\u0002\u00101\u001am\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u00182\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u001a2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020%0/H\u0003¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\f\u0010>\u001a\u0004\u0018\u00010?X\u008a\u0084\u0002"}, d2 = {"TimelineComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TimelineComponentView_Align_TitleAndDescription_Preview", "(Landroidx/compose/runtime/Composer;I)V", "TimelineComponentView_Align_Title_Preview", "TimelineComponentView_Connector_Margin_Preview", "TimelineComponentView_Size_Preview", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "(Lcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/runtime/Composer;I)V", "TimelineComponentView_TextSize_Preview", "textWidth", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Landroidx/compose/runtime/Composer;I)V", "previewConnectorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "width", "", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "previewIcon", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "paddingValues", "previewIcon-6xbWgXg", "(JJLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "previewItem", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", Constants.GP_IAP_TITLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "description", "icon", "connector", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "previewItems", "", "connectorMargins", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Ljava/util/List;", "previewStyle", "itemSpacing", "textSpacing", "columnGutter", "iconAlignment", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "visible", "", "padding", FirebaseAnalytics.Param.ITEMS, "(IIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Ljava/util/List;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "revenuecatui_defaultsBc8Release", "biggestIconWidth", "Landroidx/compose/ui/unit/Dp;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class TimelineComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TimelineComponentView(final TimelineComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final TimelineComponentState timelineComponentStateRememberUpdatedTimelineComponentState;
        Object obj;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(2108618390);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView)P(2,1)66@3728L97,75@3887L6113:TimelineComponentView.kt#1cibm8");
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
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2108618390, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView (TimelineComponentView.kt:65)");
                }
                timelineComponentStateRememberUpdatedTimelineComponentState = TimelineComponentStateKt.rememberUpdatedTimelineComponentState(style, state, composerStartRestartGroup, i3 & 126);
                if (timelineComponentStateRememberUpdatedTimelineComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView.1
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
                                TimelineComponentViewKt.TimelineComponentView(style, state, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                Modifier modifierPadding = PaddingKt.padding(PaddingKt.padding(SizeKt.size$default(modifier2, timelineComponentStateRememberUpdatedTimelineComponentState.getSize(), null, null, 6, null), timelineComponentStateRememberUpdatedTimelineComponentState.getMargin()), timelineComponentStateRememberUpdatedTimelineComponentState.getPadding());
                composerStartRestartGroup.startReplaceGroup(-1003410150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                composerStartRestartGroup.startReplaceGroup(212064437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Measurer(density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final Measurer measurer = (Measurer) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new ConstraintLayoutScope();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                final int i5 = 257;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = null;
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                            mutableState2.getValue();
                            long jM9511performMeasure2eBlSMk = measurer.m9511performMeasure2eBlSMk(j, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i5);
                            mutableState.getValue();
                            int iM9285getWidthimpl = IntSize.m9285getWidthimpl(jM9511performMeasure2eBlSMk);
                            int iM9284getHeightimpl = IntSize.m9284getHeightimpl(jM9511performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9285getWidthimpl, iM9284getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    obj = null;
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$3
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
                            mutableState.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                            constraintSetForInlineDsl.setKnownDirty(true);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final Function0 function0 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierPadding, false, (Function1) objRememberedValue7, 1, obj), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$5
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
                        float fM9114constructorimpl;
                        float f;
                        Iterator it;
                        PaddingValues paddingValuesM2030PaddingValues0680j_4;
                        int i7;
                        PaddingValues margin;
                        IconComponentStyle icon;
                        Size size;
                        SizeConstraint height;
                        Dp dpDpOrNull;
                        ConstrainedLayoutReference constrainedLayoutReference;
                        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor;
                        ConstrainedLayoutReference constrainedLayoutReference2;
                        ConstrainedLayoutReference constrainedLayoutReference3;
                        ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                        int i8 = 2;
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1200550679, i6, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                        }
                        mutableState2.setValue(Unit.INSTANCE);
                        int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                        constraintLayoutScope.reset();
                        ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                        composer3.startReplaceGroup(-425492318);
                        ComposerKt.sourceInformation(composer3, "C83@4232L174:TimelineComponentView.kt#1cibm8");
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        composer3.startReplaceGroup(-290820944);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                        Object objRememberedValue8 = composer3.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = SnapshotStateKt.derivedStateOf(new TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1(timelineComponentStateRememberUpdatedTimelineComponentState));
                            composer3.updateRememberedValue(objRememberedValue8);
                        }
                        State state2 = (State) objRememberedValue8;
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(-290812056);
                        ComposerKt.sourceInformation(composer3, "*102@5037L80,100@4907L225,108@5208L699,107@5146L987,133@6291L679,130@6147L838");
                        for (TimelineComponentState.ItemState itemState : timelineComponentStateRememberUpdatedTimelineComponentState.getItems()) {
                            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
                            ConstraintLayoutScope constraintLayoutScope3 = constraintLayoutScope2;
                            LayoutReference[] layoutReferenceArr = new LayoutReference[3];
                            layoutReferenceArr[0] = constrainedLayoutReferenceComponent1;
                            layoutReferenceArr[1] = constrainedLayoutReferenceComponent2;
                            layoutReferenceArr[i8] = constrainedLayoutReferenceComponent3;
                            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorM9405createBottomBarrier3ABfNKs$default = ConstraintLayoutBaseScope.m9405createBottomBarrier3ABfNKs$default(constraintLayoutScope3, layoutReferenceArr, 0.0f, i8, null);
                            ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor = constraintLayoutScope2.m9422createEndBarrier3ABfNKs(new LayoutReference[]{constrainedLayoutReferenceComponent1}, Dp.m9114constructorimpl(timelineComponentStateRememberUpdatedTimelineComponentState.getColumnGutter()));
                            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2 = (ConstraintLayoutBaseScope.HorizontalAnchor) CollectionsKt.lastOrNull((List) arrayList);
                            arrayList2.add(constrainedLayoutReferenceComponent1);
                            int i9 = helpersHashCode;
                            ArrayList arrayList3 = arrayList2;
                            arrayList.add(ConstraintLayoutBaseScope.m9405createBottomBarrier3ABfNKs$default(constraintLayoutScope3, new LayoutReference[]{constrainedLayoutReferenceComponent4}, 0.0f, 2, null));
                            Modifier modifierM2069height3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(timelineComponentStateRememberUpdatedTimelineComponentState.getItemSpacing()));
                            composer3.startReplaceGroup(-290795278);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                            boolean zChanged = composer3.changed(horizontalAnchorM9405createBottomBarrier3ABfNKs$default);
                            Object objRememberedValue9 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue9 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$1$1(horizontalAnchorM9405createBottomBarrier3ABfNKs$default);
                                composer3.updateRememberedValue(objRememberedValue9);
                            }
                            composer3.endReplaceGroup();
                            SpacerKt.Spacer(constraintLayoutScope2.constrainAs(modifierM2069height3ABfNKs, constrainedLayoutReferenceComponent4, (Function1) objRememberedValue9), composer3, 0);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            composer3.startReplaceGroup(-290789187);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(timelineComponentStateRememberUpdatedTimelineComponentState) | composer3.changed(horizontalAnchor2) | composer3.changed(constrainedLayoutReferenceComponent2) | composer3.changed(constrainedLayoutReferenceComponent3);
                            Object objRememberedValue10 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                constrainedLayoutReference = constrainedLayoutReferenceComponent1;
                                horizontalAnchor = horizontalAnchor2;
                                constrainedLayoutReference2 = constrainedLayoutReferenceComponent2;
                                constrainedLayoutReference3 = constrainedLayoutReferenceComponent3;
                                objRememberedValue10 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$2$1(timelineComponentStateRememberUpdatedTimelineComponentState, horizontalAnchor, constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent3, state2);
                                composer3.updateRememberedValue(objRememberedValue10);
                            } else {
                                constrainedLayoutReference2 = constrainedLayoutReferenceComponent2;
                                constrainedLayoutReference3 = constrainedLayoutReferenceComponent3;
                                constrainedLayoutReference = constrainedLayoutReferenceComponent1;
                                horizontalAnchor = horizontalAnchor2;
                            }
                            composer3.endReplaceGroup();
                            Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(companion, constrainedLayoutReference, (Function1) objRememberedValue10);
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierConstrainAs);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 341317904, "C123@5941L178:TimelineComponentView.kt#1cibm8");
                            IconComponentViewKt.IconComponentView(itemState.getIcon(), state, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composer3, 0, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            TextComponentStyle title = itemState.getTitle();
                            PaywallState.Loaded.Components components = state;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            composer3.startReplaceGroup(-290754551);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                            boolean zChanged3 = composer3.changed(timelineComponentStateRememberUpdatedTimelineComponentState) | composer3.changed(constrainedLayoutReference) | composer3.changed(horizontalAnchor) | composer3.changed(verticalAnchor);
                            Object objRememberedValue11 = composer3.rememberedValue();
                            if (zChanged3 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue11 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$4$1(timelineComponentStateRememberUpdatedTimelineComponentState, constrainedLayoutReference, horizontalAnchor, verticalAnchor);
                                composer3.updateRememberedValue(objRememberedValue11);
                            }
                            composer3.endReplaceGroup();
                            TextComponentViewKt.TextComponentView(title, components, constraintLayoutScope2.constrainAs(companion2, constrainedLayoutReference2, (Function1) objRememberedValue11), composer3, 0, 0);
                            TextComponentStyle description = itemState.getDescription();
                            composer3.startReplaceGroup(-290731404);
                            ComposerKt.sourceInformation(composer3, "*154@7193L385,151@7039L558");
                            if (description != null) {
                                PaywallState.Loaded.Components components2 = state;
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                composer3.startReplaceGroup(149597858);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged4 = composer3.changed(constrainedLayoutReference2) | composer3.changed(timelineComponentStateRememberUpdatedTimelineComponentState);
                                Object objRememberedValue12 = composer3.rememberedValue();
                                if (zChanged4 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue12 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$5$1$1(constrainedLayoutReference2, timelineComponentStateRememberUpdatedTimelineComponentState);
                                    composer3.updateRememberedValue(objRememberedValue12);
                                }
                                composer3.endReplaceGroup();
                                TextComponentViewKt.TextComponentView(description, components2, constraintLayoutScope2.constrainAs(companion3, constrainedLayoutReference3, (Function1) objRememberedValue12), composer3, 0, 0);
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer3.endReplaceGroup();
                            helpersHashCode = i9;
                            arrayList2 = arrayList3;
                            i8 = 2;
                        }
                        int i10 = helpersHashCode;
                        ArrayList arrayList4 = arrayList2;
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(-290709150);
                        ComposerKt.sourceInformation(composer3, "");
                        Iterator it2 = timelineComponentStateRememberUpdatedTimelineComponentState.getItems().iterator();
                        int i11 = 0;
                        while (it2.hasNext()) {
                            int i12 = i11 + 1;
                            TimelineComponentState.ItemState itemState2 = (TimelineComponentState.ItemState) it2.next();
                            boolean z = i11 == timelineComponentStateRememberUpdatedTimelineComponentState.getItems().size() + (-1);
                            ArrayList arrayList5 = arrayList4;
                            ConstrainedLayoutReference constrainedLayoutReference4 = (ConstrainedLayoutReference) arrayList5.get(i11);
                            ConstrainedLayoutReference constrainedLayoutReference5 = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList5, i12);
                            TimelineComponentStyle.ConnectorStyle connector = itemState2.getConnector();
                            composer3.startReplaceGroup(-290701069);
                            ComposerKt.sourceInformation(composer3, "*173@8015L548,192@9042L843,205@9935L15,187@8777L1193");
                            if (connector == null) {
                                it = it2;
                                i7 = i12;
                                arrayList4 = arrayList5;
                            } else {
                                ConstrainedLayoutReference constrainedLayoutReferenceCreateRef = constraintLayoutScope2.createRef();
                                Object size2 = itemState2.getIcon().getSize();
                                composer3.startReplaceGroup(149624325);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged5 = composer3.changed(size2) | composer3.changed(constrainedLayoutReferenceCreateRef);
                                Object objRememberedValue13 = composer3.rememberedValue();
                                if (zChanged5 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                    SizeConstraint height2 = itemState2.getIcon().getSize().getHeight();
                                    float fM9114constructorimpl2 = (height2 instanceof SizeConstraint.Fixed ? (SizeConstraint.Fixed) height2 : null) != null ? Dp.m9114constructorimpl(Dp.m9114constructorimpl(r13.getValue()) / 2.0f) : Dp.m9114constructorimpl(0.0f);
                                    Dp dpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(state2);
                                    if (dpTimelineComponentView$lambda$13$lambda$1 != null) {
                                        int iM9128unboximpl = (int) dpTimelineComponentView$lambda$13$lambda$1.m9128unboximpl();
                                        fM9114constructorimpl = Dp.m9114constructorimpl(Dp.m9114constructorimpl(iM9128unboximpl - (itemState2.getConnector() != null ? r19.getWidth() : 0)) / 2.0f);
                                    } else {
                                        fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                                    }
                                    objRememberedValue13 = TuplesKt.to(Dp.m9112boximpl(fM9114constructorimpl), Dp.m9112boximpl(fM9114constructorimpl2));
                                    composer3.updateRememberedValue(objRememberedValue13);
                                }
                                Pair pair = (Pair) objRememberedValue13;
                                composer3.endReplaceGroup();
                                TimelineComponentState.ItemState itemState3 = (TimelineComponentState.ItemState) CollectionsKt.getOrNull(timelineComponentStateRememberUpdatedTimelineComponentState.getItems(), i12);
                                float fM9114constructorimpl3 = Dp.m9114constructorimpl(((itemState3 == null || (icon = itemState3.getIcon()) == null || (size = icon.getSize()) == null || (height = size.getHeight()) == null || (dpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(height)) == null) ? Dp.m9114constructorimpl(0.0f) : dpDpOrNull.m9128unboximpl()) / 2.0f);
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                TimelineComponentStyle.ConnectorStyle connector2 = itemState2.getConnector();
                                if (connector2 == null || (margin = connector2.getMargin()) == null) {
                                    f = 0.0f;
                                    it = it2;
                                    paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
                                } else {
                                    it = it2;
                                    paddingValuesM2030PaddingValues0680j_4 = margin;
                                    f = 0.0f;
                                }
                                i7 = i12;
                                arrayList4 = arrayList5;
                                Modifier modifierZIndex = ZIndexModifierKt.zIndex(OffsetKt.m1997offsetVpY3zN4$default(PaddingKt.padding(companion4, paddingValuesM2030PaddingValues0680j_4), f, ((Dp) pair.getSecond()).m9128unboximpl(), 1, null), -1.0f);
                                composer3.startReplaceGroup(149657484);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged6 = composer3.changed(pair) | composer3.changed(itemState2) | composer3.changed(constrainedLayoutReference4) | composer3.changed(z) | composer3.changed(constrainedLayoutReference5) | composer3.changed(fM9114constructorimpl3);
                                Object objRememberedValue14 = composer3.rememberedValue();
                                if (zChanged6 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue14 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$6$1$1(pair, itemState2, constrainedLayoutReference4, z, constrainedLayoutReference5, fM9114constructorimpl3);
                                    composer3.updateRememberedValue(objRememberedValue14);
                                }
                                composer3.endReplaceGroup();
                                BoxKt.Box(OverlayKt.overlay$default(constraintLayoutScope2.constrainAs(modifierZIndex, constrainedLayoutReferenceCreateRef, (Function1) objRememberedValue14), ColorStyleKt.getForCurrentTheme(connector.getColor(), composer3, 0), null, 2, null), composer3, 0);
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            composer3.endReplaceGroup();
                            i11 = i7;
                            it2 = it;
                        }
                        composer3.endReplaceGroup();
                        composer3.endReplaceGroup();
                        if (constraintLayoutScope.getHelpersHashCode() != i10) {
                            EffectsKt.SideEffect(function0, composer3, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), measurePolicy, composer2, 48, 0);
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
            }
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView.3
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
                        TimelineComponentViewKt.TimelineComponentView(style, state, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            timelineComponentStateRememberUpdatedTimelineComponentState = TimelineComponentStateKt.rememberUpdatedTimelineComponentState(style, state, composerStartRestartGroup, i3 & 126);
            if (timelineComponentStateRememberUpdatedTimelineComponentState.getVisible()) {
            }
        }
        final Modifier modifier42 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp TimelineComponentView$lambda$13$lambda$1(State<Dp> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_TitleAndDescription_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1930279475);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Align_TitleAndDescription_Preview)228@10540L20,228@10514L340:TimelineComponentView.kt#1cibm8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1930279475, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_TitleAndDescription_Preview (TimelineComponentView.kt:227)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m10609getLambda2$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_Title_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(747423832);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Align_Title_Preview)215@10113L20,215@10087L326:TimelineComponentView.kt#1cibm8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747423832, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_Title_Preview (TimelineComponentView.kt:214)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m10608getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Connector_Margin_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(475255038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Connector_Margin_Preview)241@10972L20,241@10946L481:TimelineComponentView.kt#1cibm8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(475255038, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Connector_Margin_Preview (TimelineComponentView.kt:240)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m10610getLambda3$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Size_Preview(@PreviewParameter(provider = SizeParameterProvider.class) final Size size, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(74978622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Size_Preview)271@12055L20,271@12077L792,271@12029L840:TimelineComponentView.kt#1cibm8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(size) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(74978622, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview (TimelineComponentView.kt:270)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-111498279, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C272@12087L776:TimelineComponentView.kt#1cibm8");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111498279, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview.<anonymous> (TimelineComponentView.kt:272)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null);
                    Size size2 = size;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1440805600, "C274@12197L64,277@12287L19,273@12150L171,280@12335L518:TimelineComponentView.kt#1cibm8");
                    TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size2, null, null, null, composer2, 0, Videoio.CAP_PROP_XI_CC_MATRIX_00), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                    String str = "timeline = w:" + size2.getWidth().getClass().getSimpleName() + " x h:" + size2.getHeight().getClass().getSimpleName();
                    Modifier modifierAlign = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                    float fM9114constructorimpl = Dp.m9114constructorimpl(16.0f);
                    TextKt.m4286Text4IGK_g(str, PaddingKt.m2037padding3ABfNKs(BorderKt.m1494borderxT4_qwU(BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5922shadows4CzXII(modifierAlign, fM9114constructorimpl, (28 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.RoundedCornerShape(50), (28 & 4) != 0 ? Dp.m9113compareTo0680j_4(fM9114constructorimpl, Dp.m9114constructorimpl(0.0f)) > 0 : false, (28 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (28 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L), Color.INSTANCE.m6362getWhite0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m9114constructorimpl(2.0f), Color.INSTANCE.m6351getBlack0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m9114constructorimpl(16.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131068);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_Size_Preview(size, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_TextSize_Preview(@PreviewParameter(provider = SizeConstraintParameterProvider.class) final SizeConstraint sizeConstraint, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(774105102);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_TextSize_Preview)306@13326L20,306@13348L4683,306@13300L4731:TimelineComponentView.kt#1cibm8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(sizeConstraint) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(774105102, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview (TimelineComponentView.kt:305)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-408857751, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Failed to inline method: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
                /* JADX WARN: Not passed register '(r4v7 float)' in method call: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C307@13358L4667:TimelineComponentView.kt#1cibm8");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-408857751, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview.<anonymous> (TimelineComponentView.kt:307)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null);
                    SizeConstraint sizeConstraint2 = sizeConstraint;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 752025408, "C313@13680L233,312@13632L1284,333@14990L233,332@14942L1202,352@16218L233,351@16170L1250,309@13468L3994,373@17488L19,308@13421L4101,376@17536L479:TimelineComponentView.kt#1cibm8");
                    Size size = new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE);
                    IconComponentStyle iconComponentStyleM10612previewIcon6xbWgXg = TimelineComponentViewKt.m10612previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(8.0f)), composer2, 3456, 3);
                    TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size, null, null, CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Today", null, 0, com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("Description of what you get today if you subscribe with multiple lines to check wrapping", null, 0, null, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64926, null), iconComponentStyleM10612previewIcon6xbWgXg, (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Day X", null, 0, com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("We'll remind you that your trial is ending soon", null, 0, null, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64926, null), TimelineComponentViewKt.m10612previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(8.0f)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Day Y", null, 0, com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("You'll be charged. You can cancel anytime before.", null, 0, null, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, new Size(sizeConstraint2, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64926, null), TimelineComponentViewKt.m10612previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(8.0f)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 3072, 0)}), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 223), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                    TextKt.m4286Text4IGK_g("text = w:" + sizeConstraint2.getClass().getSimpleName() + " x h:Fit", PaddingKt.m2037padding3ABfNKs(BorderKt.m1494borderxT4_qwU(BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5923shadows4CzXII$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m9114constructorimpl(16.0f), RoundedCornerShapeKt.RoundedCornerShape(50), false, 0L, 0L, 28, null), Color.INSTANCE.m6362getWhite0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m9114constructorimpl(2.0f), Color.INSTANCE.m6351getBlack0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m9114constructorimpl(16.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131068);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_TextSize_Preview(sizeConstraint, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final TimelineComponentStyle.ConnectorStyle previewConnectorStyle(int i, PaddingValues paddingValues, ColorStyle colorStyle) {
        return new TimelineComponentStyle.ConnectorStyle(i, paddingValues, new ColorStyles(colorStyle, null, 2, null));
    }

    static /* synthetic */ TimelineComponentStyle.ConnectorStyle previewConnectorStyle$default(int i, PaddingValues paddingValues, ColorStyle colorStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        if ((i2 & 2) != 0) {
            paddingValues = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
        }
        if ((i2 & 4) != 0) {
            colorStyle = ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.Color(4290561265L)));
        }
        return previewConnectorStyle(i, paddingValues, colorStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: previewIcon-6xbWgXg, reason: not valid java name */
    public static final IconComponentStyle m10612previewIcon6xbWgXg(long j, long j2, Size size, PaddingValues paddingValues, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-254474895);
        ComposerKt.sourceInformation(composer, "C(previewIcon)P(1:c#ui.graphics.Color,0:c#ui.graphics.Color,3)503@22071L372:TimelineComponentView.kt#1cibm8");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6362getWhite0d7_KjU();
        }
        if ((i2 & 2) != 0) {
            j2 = ColorKt.Color(4283919579L);
        }
        Size size2 = (i2 & 4) != 0 ? new Size(new SizeConstraint.Fixed(20, null), new SizeConstraint.Fixed(20, null)) : size;
        PaddingValues paddingValuesM2030PaddingValues0680j_4 = (i2 & 8) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(4.0f)) : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-254474895, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewIcon (TimelineComponentView.kt:502)");
        }
        IconComponentStyle iconComponentStylePreviewIconComponentStyle = PreviewHelpersKt.previewIconComponentStyle(size2, false, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(j)), null, 2, null), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(j2)), null, 2, null), paddingValuesM2030PaddingValues0680j_4, PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), null, null, null, composer, ((i >> 6) & 14) | 14352384 | ((i << 3) & 57344), Imgcodecs.IMWRITE_TIFF_YDPI);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconComponentStylePreviewIconComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle.ItemStyle previewItem(TextComponentStyle textComponentStyle, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1551417669);
        ComposerKt.sourceInformation(composer, "C(previewItem)P(3,1,2)457@20645L13:TimelineComponentView.kt#1cibm8");
        IconComponentStyle iconComponentStyleM10612previewIcon6xbWgXg = (i2 & 4) != 0 ? m10612previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i2 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1551417669, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:459)");
        }
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(textComponentStyle, true, textComponentStyle2, iconComponentStyleM10612previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return itemStyle;
    }

    private static final TimelineComponentStyle.ItemStyle previewItem(String str, String str2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i, int i2) {
        composer.startReplaceGroup(66138427);
        ComposerKt.sourceInformation(composer, "C(previewItem)P(3,1,2)474@21080L13:TimelineComponentView.kt#1cibm8");
        IconComponentStyle iconComponentStyleM10612previewIcon6xbWgXg = (i2 & 4) != 0 ? m10612previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i2 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(66138427, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:476)");
        }
        boolean z = true;
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, com.revenuecat.purchases.paywalls.components.properties.FontWeight.BOLD, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, null, null, null, null, null, null, null, 65430, null), z, PreviewHelpersKt.previewTextComponentStyle$default(str2, null, 0, null, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, null, false, null, null, null, null, null, null, null, 65438, null), iconComponentStyleM10612previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return itemStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<TimelineComponentStyle.ItemStyle> previewItems(PaddingValues paddingValues, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-2140988222);
        ComposerKt.sourceInformation(composer, "C(previewItems)424@19196L243,432@19587L95,429@19449L318,438@19917L77,435@19777L721:TimelineComponentView.kt#1cibm8");
        PaddingValues paddingValuesM2030PaddingValues0680j_4 = (i2 & 1) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2140988222, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItems (TimelineComponentView.kt:422)");
        }
        List<TimelineComponentStyle.ItemStyle> listListOf = CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{previewItem("Today", "Description of what you get today if you subscribe with multiple lines to check wrapping", (IconComponentStyle) null, previewConnectorStyle$default(0, paddingValuesM2030PaddingValues0680j_4, null, 5, null), composer, 54, 4), previewItem("Day X", "We'll remind you that your trial is ending soon", m10612previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(30, null), new SizeConstraint.Fixed(30, null)), null, composer, 384, 11), previewConnectorStyle$default(0, paddingValuesM2030PaddingValues0680j_4, null, 5, null), composer, 54, 0), previewItem("Day Y", "You'll be charged. You can cancel anytime before.", m10612previewIcon6xbWgXg(Color.INSTANCE.m6351getBlack0d7_KjU(), ColorKt.Color(4279227523L), null, null, composer, 54, 12), previewConnectorStyle$default(0, paddingValuesM2030PaddingValues0680j_4, ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(0.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(1037443)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4279227523L)), 100.0f)}))), 1, null), composer, 54, 0)});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle previewStyle(int i, int i2, int i3, TimelineComponent.IconAlignment iconAlignment, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, List<TimelineComponentStyle.ItemStyle> list, Composer composer, int i4, int i5) {
        composer.startReplaceGroup(-1453577113);
        ComposerKt.sourceInformation(composer, "C(previewStyle)P(2,7!2,8,6,5,4)400@18563L14:TimelineComponentView.kt#1cibm8");
        int i6 = (i5 & 1) != 0 ? 24 : i;
        int i7 = (i5 & 2) != 0 ? 4 : i2;
        int i8 = (i5 & 4) != 0 ? 8 : i3;
        TimelineComponent.IconAlignment iconAlignment2 = (i5 & 8) != 0 ? TimelineComponent.IconAlignment.TitleAndDescription : iconAlignment;
        boolean z2 = (i5 & 16) != 0 ? true : z;
        Size size2 = (i5 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size;
        PaddingValues paddingValuesM2030PaddingValues0680j_4 = (i5 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(5.0f)) : paddingValues;
        PaddingValues paddingValuesM2030PaddingValues0680j_42 = (i5 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(5.0f)) : paddingValues2;
        List<TimelineComponentStyle.ItemStyle> listPreviewItems = (i5 & 256) != 0 ? previewItems(null, composer, 0, 1) : list;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1453577113, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewStyle (TimelineComponentView.kt:401)");
        }
        TimelineComponentStyle timelineComponentStyle = new TimelineComponentStyle(i6, i7, i8, iconAlignment2, z2, size2, paddingValuesM2030PaddingValues0680j_4, paddingValuesM2030PaddingValues0680j_42, listPreviewItems, null, null, null, null, CollectionsKt.emptyList(), 5120, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return timelineComponentStyle;
    }
}
