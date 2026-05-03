package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.PointerIconCompat;
import androidx.media3.muxer.WebmConstants;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.WithOptionalBackgroundOverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.ScrollableKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
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
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: StackComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\u008b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u001f¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0003¢\u0006\u0002\u0010#\u001aU\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010'\u001a\r\u0010(\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010*\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010+\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\u0017\u0010,\u001a\u00020\r2\b\b\u0001\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010/\u001a\u0017\u00100\u001a\u00020\r2\b\b\u0001\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010/\u001a\u0017\u00101\u001a\u00020\r2\b\b\u0001\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010/\u001a\u0017\u00102\u001a\u00020\r2\b\b\u0001\u00103\u001a\u00020\u0002H\u0003¢\u0006\u0002\u00104\u001a\r\u00105\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u00106\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u00107\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\u0017\u00108\u001a\u00020\r2\b\b\u0001\u00103\u001a\u00020\u0002H\u0003¢\u0006\u0002\u00104\u001a\u0017\u00109\u001a\u00020\r2\b\b\u0001\u00103\u001a\u00020\u0002H\u0003¢\u0006\u0002\u00104\u001a\u0017\u0010:\u001a\u00020\r2\b\b\u0001\u00103\u001a\u00020\u0002H\u0003¢\u0006\u0002\u00104\u001a\r\u0010;\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010<\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010=\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010>\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010?\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001a\r\u0010@\u001a\u00020\rH\u0003¢\u0006\u0002\u0010)\u001ac\u0010A\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\u00012\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010D\u001ac\u0010E\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010B\u001a\u00020&2\u0006\u00103\u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010F\u001ac\u0010G\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010B\u001a\u00020&2\u0006\u00103\u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010F\u001a\"\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\u0006\u00103\u001a\u00020\u00022\b\b\u0002\u0010K\u001a\u00020\u0018H\u0002\u001a4\u0010L\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020M2\u0006\u00103\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020QH\u0002\u001a\u0013\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0003¢\u0006\u0002\u0010V\u001a=\u0010W\u001a\u00020\r*\u00020 2\u0006\u0010B\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00022\b\u0010K\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010X\u001a\u001c\u0010Y\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020IH\u0002\u001a&\u0010[\u001a\u00020\\*\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0002ø\u0001\u0000¢\u0006\u0004\ba\u0010b\u001a\u001c\u0010[\u001a\u00020\\*\u00020\\2\u0006\u0010c\u001a\u00020d2\u0006\u0010_\u001a\u00020`H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e²\u0006\n\u0010f\u001a\u00020gX\u008a\u0084\u0002²\u0006\n\u0010f\u001a\u00020gX\u008a\u0084\u0002"}, d2 = {"isTop", "", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "(Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;)Z", "shouldIgnoreTopWindowInsets", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getShouldIgnoreTopWindowInsets", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;)Z", "usesAllAvailableSpace", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "getUsesAllAvailableSpace", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;)Z", "MainStackComponent", "", "stackState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "contentAlpha", "", "modifier", "Landroidx/compose/ui/Modifier;", "nestedBadge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "shouldApplyShadow", "overlay", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;FLandroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "StackComponentView", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "StackComponentView_Preview_Children_Extend_Over_Parent", "(Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_ContentAlpha", "StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children", "StackComponentView_Preview_Distribution_With_Spacing", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "(Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_Distribution_Without_Spacing", "StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size", "StackComponentView_Preview_EdgeToEdge_Badge", "alignment", "(Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_Horizontal", "StackComponentView_Preview_HorizontalChildrenFillWidth", "StackComponentView_Preview_HorizontalDivider", "StackComponentView_Preview_Nested_Badge", "StackComponentView_Preview_Overlay_Badge", "StackComponentView_Preview_Pill_EdgeToEdge_Badge", "StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll", "StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll", "StackComponentView_Preview_Vertical", "StackComponentView_Preview_VerticalChildrenFillHeight", "StackComponentView_Preview_VerticalDivider", "StackComponentView_Preview_ZLayer", "StackWithLongEdgeToEdgeBadge", "badgeStack", "topBadge", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;ZLkotlin/jvm/functions/Function2;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StackWithOverlaidBadge", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Lkotlin/jvm/functions/Function2;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StackWithShortEdgeToEdgeBadge", "getOverlaidBadgeOffsetY", "", "height", "mainStackBorderWidthPx", "previewBadge", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "previewChildren", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "OverlaidBadge", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Ljava/lang/Float;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "headerOrInsetsTopPadding", "fallbackInsetPx", "makeAbsolute", "Landroidx/compose/foundation/shape/CornerSize;", "shapeSize", "Landroidx/compose/ui/geometry/Size;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "makeAbsolute-12SF9DM", "(Landroidx/compose/foundation/shape/CornerSize;JLandroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/shape/CornerSize;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "revenuecatui_defaultsBc8Release", "composeShape", "Landroidx/compose/ui/graphics/Shape;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class StackComponentViewKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07711 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07711(Continuation<? super C07711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07711) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07741 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07741(Continuation<? super C07741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07741) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07761 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07761(Continuation<? super C07761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07761) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07781 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07781(Continuation<? super C07781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07781) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07801 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07801(Continuation<? super C07801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07801) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07821 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07821(Continuation<? super C07821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07821) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07861 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07861(Continuation<? super C07861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07861) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1", f = "StackComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07951 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07951(Continuation<? super C07951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07951(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07951) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TwoDimensionalAlignment.values().length];
            try {
                iArr[TwoDimensionalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_LEADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_TRAILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_LEADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_TRAILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TwoDimensionalAlignment.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TwoDimensionalAlignment.LEADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TwoDimensionalAlignment.TRAILING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Badge.Style.values().length];
            try {
                iArr2[Badge.Style.Overlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Badge.Style.EdgeToEdge.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Badge.Style.Nested.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FlexDistribution.values().length];
            try {
                iArr3[FlexDistribution.SPACE_AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[FlexDistribution.SPACE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[FlexDistribution.SPACE_EVENLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[FlexDistribution.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[FlexDistribution.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[FlexDistribution.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MainStackComponent(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final float f, Modifier modifier, BadgeStyle badgeStyle, boolean z, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final PaywallState.Loaded.Components components2;
        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        final float f2;
        int i4;
        Modifier modifier2;
        int i5;
        BadgeStyle badgeStyle2;
        int i6;
        boolean z2;
        int i7;
        final Modifier modifier3;
        BackgroundStyle backgroundStyleRememberBackgroundStyle;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        BorderStyle borderStyleRememberBorderStyle;
        ShadowStyle shadowStyleRememberShadowStyle;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        Modifier modifier4;
        Composer composer2;
        Composer composer3;
        final Modifier modifier5;
        final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32;
        Composer composer4;
        ShadowStyles shadow;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-681636436);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainStackComponent)P(6,7!4,5)488@21746L11,491@21878L6386,611@28388L76,619@28724L251,626@29002L195,634@29228L99:StackComponentView.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(stackComponentState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                components2 = components;
                i3 |= composerStartRestartGroup.changed(components2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function22 = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
                    }
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
                    if (i5 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            badgeStyle2 = badgeStyle;
                            i3 |= composerStartRestartGroup.changed(badgeStyle2) ? 131072 : 65536;
                        }
                        i6 = i2 & 64;
                        if (i6 == 0) {
                            if ((1572864 & i) == 0) {
                                z2 = z;
                                i3 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
                            }
                            i7 = i2 & 128;
                            if (i7 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                            }
                            if ((i3 & 4793491) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                                Modifier modifier6 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    badgeStyle2 = null;
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function33 = i7 == 0 ? null : function3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-681636436, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent (StackComponentView.kt:487)");
                                }
                                final WindowInsets safeDrawing = WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6);
                                int i8 = i3;
                                modifier3 = modifier6;
                                final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-586909421, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier7, Composer composer5, Integer num) {
                                        invoke(modifier7, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier rootModifier, Composer composer5, int i9) {
                                        final int top;
                                        Composer composer6 = composer5;
                                        Intrinsics.checkNotNullParameter(rootModifier, "rootModifier");
                                        ComposerKt.sourceInformation(composer6, "C:StackComponentView.kt#280jdz");
                                        int i10 = (i9 & 6) == 0 ? i9 | (composer6.changed(rootModifier) ? 4 : 2) : i9;
                                        if ((i10 & 19) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-586909421, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:492)");
                                        }
                                        Orientation scrollOrientation = stackComponentState.getScrollOrientation();
                                        composer6.startReplaceGroup(-958141281);
                                        ComposerKt.sourceInformation(composer6, "*492@21958L21");
                                        ScrollState scrollStateRememberScrollState = scrollOrientation == null ? null : ScrollKt.rememberScrollState(0, composer6, 0, 1);
                                        composer6.endReplaceGroup();
                                        if (stackComponentState.getChildren().isEmpty()) {
                                            composer6.startReplaceGroup(362679198);
                                            ComposerKt.sourceInformation(composer6, "497@22252L138");
                                            BoxKt.Box(SizeKt.size$default(modifier3, stackComponentState.getSize(), null, null, 6, null).then(rootModifier), composer6, 0);
                                            composer6.endReplaceGroup();
                                        } else {
                                            composer6.startReplaceGroup(363022244);
                                            ComposerKt.sourceInformation(composer6, "");
                                            Dimension dimension = stackComponentState.getDimension();
                                            if (dimension instanceof Dimension.Horizontal) {
                                                composer6.startReplaceGroup(-958122178);
                                                ComposerKt.sourceInformation(composer6, "514@23060L757,504@22509L1308");
                                                Size size = stackComponentState.getSize();
                                                Dimension.Horizontal horizontal = (Dimension.Horizontal) dimension;
                                                float fM10564getSpacingD9Ej5fM = stackComponentState.m10564getSpacingD9Ej5fM();
                                                Modifier modifierThen = ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier3, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                        Intrinsics.checkNotNullParameter(state2, "state");
                                                        Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                        return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                    }
                                                }).then(rootModifier);
                                                composer6.startReplaceGroup(-958105097);
                                                ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged5 = composer6.changed(stackComponentState) | composer6.changed(components2) | composer6.changedInstance(function22) | composer6.changed(safeDrawing) | composer6.changed(f2);
                                                final StackComponentState stackComponentState2 = stackComponentState;
                                                final PaywallState.Loaded.Components components3 = components2;
                                                final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function22;
                                                final WindowInsets windowInsets = safeDrawing;
                                                final float f3 = f2;
                                                Object objRememberedValue5 = composer6.rememberedValue();
                                                if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue5 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                            invoke2(horizontalStackScope);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                            Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                            List children = stackComponentState2.getChildren();
                                                            final PaywallState.Loaded.Components components4 = components3;
                                                            final Function2<PaywallAction, Continuation<? super Unit>, Object> function24 = function23;
                                                            final StackComponentState stackComponentState3 = stackComponentState2;
                                                            final WindowInsets windowInsets2 = windowInsets;
                                                            final float f4 = f3;
                                                            HorizontalStack.items(children, ComposableLambdaKt.composableLambdaInstance(1342922659, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(5);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function5
                                                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer7, Integer num2) {
                                                                    invoke(rowScope, num.intValue(), componentStyle, composer7, num2.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(final RowScope items, int i11, ComponentStyle child, Composer composer7, int i12) {
                                                                    int i13;
                                                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                    Intrinsics.checkNotNullParameter(child, "child");
                                                                    ComposerKt.sourceInformation(composer7, "C521@23419L23,522@23559L138,516@23147L630:StackComponentView.kt#280jdz");
                                                                    if ((i12 & 6) == 0) {
                                                                        i13 = (composer7.changed(items) ? 4 : 2) | i12;
                                                                    } else {
                                                                        i13 = i12;
                                                                    }
                                                                    if ((i12 & 384) == 0) {
                                                                        i13 |= composer7.changed(child) ? 256 : 128;
                                                                    }
                                                                    if ((i13 & 1155) == 1154 && composer7.getSkipping()) {
                                                                        composer7.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1342922659, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:516)");
                                                                    }
                                                                    PaywallState.Loaded.Components components5 = components4;
                                                                    Function2<PaywallAction, Continuation<? super Unit>, Object> function25 = function24;
                                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                                    boolean zAreEqual = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE);
                                                                    composer7.startReplaceGroup(-1700561546);
                                                                    ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                    boolean z3 = (i13 & 14) == 4;
                                                                    Object objRememberedValue6 = composer7.rememberedValue();
                                                                    if (z3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                        objRememberedValue6 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1$1$1$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Modifier invoke(Modifier conditional) {
                                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                            }
                                                                        };
                                                                        composer7.updateRememberedValue(objRememberedValue6);
                                                                    }
                                                                    composer7.endReplaceGroup();
                                                                    Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, zAreEqual, (Function1) objRememberedValue6);
                                                                    boolean z4 = stackComponentState3.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                    composer7.startReplaceGroup(-1700556951);
                                                                    ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                    boolean zChanged6 = composer7.changed(windowInsets2);
                                                                    final WindowInsets windowInsets3 = windowInsets2;
                                                                    Object objRememberedValue7 = composer7.rememberedValue();
                                                                    if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                                        objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1$1$2$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Modifier invoke(Modifier conditional) {
                                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets3, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                                            }
                                                                        };
                                                                        composer7.updateRememberedValue(objRememberedValue7);
                                                                    }
                                                                    composer7.endReplaceGroup();
                                                                    ComponentViewKt.ComponentView(child, components5, function25, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional, z4, (Function1) objRememberedValue7), f4), composer7, (i13 >> 6) & 14, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }));
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(objRememberedValue5);
                                                }
                                                composer6.endReplaceGroup();
                                                HorizontalStackKt.m10563HorizontalStackTN_CM5M(size, horizontal, fM10564getSpacingD9Ej5fM, modifierThen, (Function1) objRememberedValue5, composer6, 0, 0);
                                                composer6.endReplaceGroup();
                                            } else if (dimension instanceof Dimension.Vertical) {
                                                composer6.startReplaceGroup(-958078546);
                                                ComposerKt.sourceInformation(composer6, "540@24411L1157,530@23860L1708");
                                                Size size2 = stackComponentState.getSize();
                                                Dimension.Vertical vertical = (Dimension.Vertical) dimension;
                                                float fM10564getSpacingD9Ej5fM2 = stackComponentState.m10564getSpacingD9Ej5fM();
                                                Modifier modifierThen2 = ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier3, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.3
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                        Intrinsics.checkNotNullParameter(state2, "state");
                                                        Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                        return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                    }
                                                }).then(rootModifier);
                                                composer6.startReplaceGroup(-958061465);
                                                ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged6 = composer6.changed(stackComponentState) | composer6.changed(components2) | composer6.changedInstance(function22) | composer6.changed(safeDrawing) | composer6.changed(f2);
                                                final StackComponentState stackComponentState3 = stackComponentState;
                                                final PaywallState.Loaded.Components components4 = components2;
                                                final Function2<PaywallAction, Continuation<? super Unit>, Object> function24 = function22;
                                                final WindowInsets windowInsets2 = safeDrawing;
                                                final float f4 = f2;
                                                Object objRememberedValue6 = composer6.rememberedValue();
                                                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue6 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                            invoke2(verticalStackScope);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(VerticalStackScope VerticalStack) {
                                                            Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                            List children = stackComponentState3.getChildren();
                                                            final PaywallState.Loaded.Components components5 = components4;
                                                            final Function2<PaywallAction, Continuation<? super Unit>, Object> function25 = function24;
                                                            final StackComponentState stackComponentState4 = stackComponentState3;
                                                            final WindowInsets windowInsets3 = windowInsets2;
                                                            final float f5 = f4;
                                                            VerticalStack.items(children, ComposableLambdaKt.composableLambdaInstance(1477849382, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(5);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function5
                                                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer7, Integer num2) {
                                                                    invoke(columnScope, num.intValue(), componentStyle, composer7, num2.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(final ColumnScope items, int i11, ComponentStyle child, Composer composer7, int i12) {
                                                                    int i13;
                                                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                    Intrinsics.checkNotNullParameter(child, "child");
                                                                    ComposerKt.sourceInformation(composer7, "CP(1)547@24775L23,554@25310L138,542@24502L1026:StackComponentView.kt#280jdz");
                                                                    if ((i12 & 6) == 0) {
                                                                        i13 = (composer7.changed(items) ? 4 : 2) | i12;
                                                                    } else {
                                                                        i13 = i12;
                                                                    }
                                                                    if ((i12 & 48) == 0) {
                                                                        i13 |= composer7.changed(i11) ? 32 : 16;
                                                                    }
                                                                    if ((i12 & 384) == 0) {
                                                                        i13 |= composer7.changed(child) ? 256 : 128;
                                                                    }
                                                                    if ((i13 & 1171) == 1170 && composer7.getSkipping()) {
                                                                        composer7.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1477849382, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:542)");
                                                                    }
                                                                    PaywallState.Loaded.Components components6 = components5;
                                                                    Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function25;
                                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                                    boolean zAreEqual = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE);
                                                                    composer7.startReplaceGroup(-1700518154);
                                                                    ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                    boolean z3 = (i13 & 14) == 4;
                                                                    Object objRememberedValue7 = composer7.rememberedValue();
                                                                    if (z3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                                        objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1$1$1$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Modifier invoke(Modifier conditional) {
                                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                            }
                                                                        };
                                                                        composer7.updateRememberedValue(objRememberedValue7);
                                                                    }
                                                                    composer7.endReplaceGroup();
                                                                    Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, zAreEqual, (Function1) objRememberedValue7);
                                                                    boolean z4 = stackComponentState4.getApplyTopWindowInsets() && i11 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                    composer7.startReplaceGroup(-1700500919);
                                                                    ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                    boolean zChanged7 = composer7.changed(windowInsets3);
                                                                    final WindowInsets windowInsets4 = windowInsets3;
                                                                    Object objRememberedValue8 = composer7.rememberedValue();
                                                                    if (zChanged7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                                        objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1$1$2$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Modifier invoke(Modifier conditional) {
                                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                                            }
                                                                        };
                                                                        composer7.updateRememberedValue(objRememberedValue8);
                                                                    }
                                                                    composer7.endReplaceGroup();
                                                                    ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional, z4, (Function1) objRememberedValue8), f5), composer7, (i13 >> 6) & 14, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }));
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(objRememberedValue6);
                                                }
                                                composer6.endReplaceGroup();
                                                VerticalStackKt.m10570VerticalStackTN_CM5M(size2, vertical, fM10564getSpacingD9Ej5fM2, modifierThen2, (Function1) objRememberedValue6, composer6, 0, 0);
                                                composer6.endReplaceGroup();
                                            } else if (dimension instanceof Dimension.ZLayer) {
                                                composer6.startReplaceGroup(366099583);
                                                ComposerKt.sourceInformation(composer6, "571@26148L2068");
                                                composer6.startReplaceGroup(-958014530);
                                                ComposerKt.sourceInformation(composer6, "567@26042L7");
                                                if (!stackComponentState.getApplyTopWindowInsets() || stackComponentState.getIgnoreHeaderHeight()) {
                                                    top = 0;
                                                } else {
                                                    WindowInsets windowInsets3 = safeDrawing;
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer6.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    top = windowInsets3.getTop((Density) objConsume);
                                                }
                                                composer6.endReplaceGroup();
                                                Dimension.ZLayer zLayer = (Dimension.ZLayer) dimension;
                                                Modifier modifierThen3 = ModifierExtensionsKt.applyIfNotNull(SizeKt.size(modifier3, stackComponentState.getSize(), AlignmentKt.toHorizontalAlignmentOrNull(zLayer.getAlignment()), AlignmentKt.toVerticalAlignmentOrNull(zLayer.getAlignment())), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.5
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                        Intrinsics.checkNotNullParameter(state2, "state");
                                                        Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                        return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                    }
                                                }).then(rootModifier);
                                                Alignment alignment = AlignmentKt.toAlignment(zLayer.getAlignment());
                                                StackComponentState stackComponentState4 = stackComponentState;
                                                final PaywallState.Loaded.Components components5 = components2;
                                                Function2<PaywallAction, Continuation<? super Unit>, Object> function25 = function22;
                                                final WindowInsets windowInsets4 = safeDrawing;
                                                float f5 = f2;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer6, modifierThen3);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer6.startReusableNode();
                                                if (composer6.getInserting()) {
                                                    composer6.createNode(constructor);
                                                } else {
                                                    composer6.useNode();
                                                }
                                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer6);
                                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer6, -97353193, "C:StackComponentView.kt#280jdz");
                                                composer6.startReplaceGroup(1797975512);
                                                ComposerKt.sourceInformation(composer6, "*592@27437L398,598@27934L146,587@27121L1047");
                                                for (ComponentStyle componentStyle : stackComponentState4.getChildren()) {
                                                    boolean z3 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(componentStyle);
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    boolean z4 = z3 && !stackComponentState4.getIgnoreHeaderHeight();
                                                    composer6.startReplaceGroup(193868590);
                                                    ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                    boolean zChanged7 = composer6.changed(components5) | composer6.changed(top);
                                                    Object objRememberedValue7 = composer6.rememberedValue();
                                                    if (zChanged7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Modifier invoke(Modifier conditional) {
                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                return StackComponentViewKt.headerOrInsetsTopPadding(conditional, components5, top);
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(objRememberedValue7);
                                                    }
                                                    composer6.endReplaceGroup();
                                                    Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, z4, (Function1) objRememberedValue7);
                                                    boolean z5 = z3 && stackComponentState4.getIgnoreHeaderHeight();
                                                    composer6.startReplaceGroup(193884242);
                                                    ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                    boolean zChanged8 = composer6.changed(windowInsets4);
                                                    Object objRememberedValue8 = composer6.rememberedValue();
                                                    if (zChanged8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$2$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Modifier invoke(Modifier conditional) {
                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(objRememberedValue8);
                                                    }
                                                    composer6.endReplaceGroup();
                                                    Modifier modifierAlpha = AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional, z5, (Function1) objRememberedValue8), f5);
                                                    Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function25;
                                                    PaywallState.Loaded.Components components6 = components5;
                                                    ComponentViewKt.ComponentView(componentStyle, components6, function26, modifierAlpha, composer5, 0, 0);
                                                    function25 = function26;
                                                    composer6 = composer5;
                                                    components5 = components6;
                                                }
                                                composer6.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                composer6.endReplaceGroup();
                                            } else {
                                                composer6.startReplaceGroup(368636096);
                                                composer6.endReplaceGroup();
                                            }
                                            composer6.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54);
                                BackgroundStyles background = stackComponentState.getBackground();
                                composerStartRestartGroup.startReplaceGroup(1233859219);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*610@28321L40");
                                backgroundStyleRememberBackgroundStyle = background != null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                Shape shape = stackComponentState.getShape();
                                composerStartRestartGroup.startReplaceGroup(1233861583);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(shape);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$composeShape$2$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final androidx.compose.ui.graphics.Shape invoke() {
                                            return ShapeKt.toShape(stackComponentState.getShape());
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                state = (State) objRememberedValue;
                                composerStartRestartGroup.endReplaceGroup();
                                BorderStyles border = stackComponentState.getBorder();
                                composerStartRestartGroup.startReplaceGroup(1233865323);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*612@28512L32");
                                borderStyleRememberBorderStyle = border != null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1233867423);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*614@28627L32");
                                shadowStyleRememberShadowStyle = (z2 || (shadow = stackComponentState.getShadow()) == null) ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1233872510);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChanged2 = composerStartRestartGroup.changed(backgroundStyleRememberBackgroundStyle) | composerStartRestartGroup.changed(shadowStyleRememberShadowStyle);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), shadowStyleRememberShadowStyle, new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state));
                                        }
                                    }), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return BackgroundKt.background(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state));
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                Modifier modifier7 = (Modifier) objRememberedValue2;
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1233881350);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                int i9 = i8 & 14;
                                zChanged3 = (i9 != 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$borderModifier$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return PaddingKt.m2037padding3ABfNKs(BorderKt.border(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state)), it.m10519getWidthD9Ej5fM());
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                final Modifier modifier8 = (Modifier) objRememberedValue3;
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1233888486);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChanged4 = composerStartRestartGroup.changed(borderStyleRememberBorderStyle) | (i9 != 4);
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getPadding());
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                final Modifier modifier9 = (Modifier) objRememberedValue4;
                                composerStartRestartGroup.endReplaceGroup();
                                if (badgeStyle2 == null || function33 != null) {
                                    BackgroundStyle backgroundStyle = backgroundStyleRememberBackgroundStyle;
                                    modifier4 = modifier3;
                                    if (badgeStyle2 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-402354335);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "677@31046L558");
                                        Modifier modifierThen = ClipKt.clip(modifier4.then(modifier7), MainStackComponent$lambda$10(state)).then(modifier8);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 371599759, "C683@31291L72,683@31224L139,687@31377L217:StackComponentView.kt#280jdz");
                                        composer2 = composerStartRestartGroup;
                                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(-971846699, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$4$1
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

                                            public final void invoke(Composer composer5, int i10) {
                                                ComposerKt.sourceInformation(composer5, "C684@31309L40:StackComponentView.kt#280jdz");
                                                if ((i10 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-971846699, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous> (StackComponentView.kt:684)");
                                                }
                                                composableLambdaRememberComposableLambda.invoke(Modifier.INSTANCE.then(modifier9), composer5, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54), composer2, ((i8 >> 3) & 14) | 24576, 12);
                                        StackComponentView(badgeStyle2.getStackStyle(), components, new StackComponentViewKt$MainStackComponent$4$2(null), boxScopeInstance.align(Modifier.INSTANCE, AlignmentKt.toAlignment(badgeStyle2.getAlignment())), 0.0f, composer2, (i8 & 112) | 384, 16);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceGroup();
                                    } else if (function33 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-401765614);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "696@31647L317");
                                        Modifier modifierClip = ClipKt.clip(modifier4.then(modifier7), MainStackComponent$lambda$10(state));
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
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
                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 372151962, "C701@31854L78,701@31787L145,704@31945L9:StackComponentView.kt#280jdz");
                                        composer2 = composerStartRestartGroup;
                                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(-848942762, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$5$1
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

                                            public final void invoke(Composer composer5, int i10) {
                                                ComposerKt.sourceInformation(composer5, "C702@31872L46:StackComponentView.kt#280jdz");
                                                if ((i10 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-848942762, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous> (StackComponentView.kt:702)");
                                                }
                                                composableLambdaRememberComposableLambda.invoke(modifier8.then(modifier9), composer5, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54), composer2, ((i8 >> 3) & 14) | 24576, 12);
                                        function33.invoke(boxScopeInstance2, composer2, Integer.valueOf(((i8 >> 18) & 112) | 6));
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceGroup();
                                    } else {
                                        composer2 = composerStartRestartGroup;
                                        composer2.startReplaceGroup(-401445601);
                                        composer2.endReplaceGroup();
                                    }
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-403967389);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                    if (backgroundStyleRememberBackgroundStyle instanceof BackgroundStyle.Video) {
                                        composerStartRestartGroup.startReplaceGroup(-403930995);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "651@29891L542,642@29523L910");
                                        modifier4 = modifier3;
                                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyleRememberBackgroundStyle, ClipKt.clip(SizeKt.size$default(modifier3, stackComponentState.getSize(), null, null, 6, null).then(modifier7), MainStackComponent$lambda$10(state)).then(modifier8), MainStackComponent$lambda$10(state), ComposableLambdaKt.rememberComposableLambda(-2041007063, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.MainStackComponent.1
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

                                            public final void invoke(Composer composer5, int i10) {
                                                ComposerKt.sourceInformation(composer5, "C655@30068L125,658@30271L129,652@29909L510:StackComponentView.kt#280jdz");
                                                if ((i10 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2041007063, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:652)");
                                                }
                                                Function3<Modifier, Composer, Integer, Unit> function34 = composableLambdaRememberComposableLambda;
                                                Modifier modifierThen2 = Modifier.INSTANCE.then(modifier9);
                                                boolean applyBottomWindowInsets = stackComponentState.getApplyBottomWindowInsets();
                                                composer5.startReplaceGroup(-957881473);
                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged5 = composer5.changed(safeDrawing);
                                                final WindowInsets windowInsets = safeDrawing;
                                                Object objRememberedValue5 = composer5.rememberedValue();
                                                if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue5 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$1$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets, WindowInsetsSides.INSTANCE.m2130getBottomJoeWqyM()));
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(objRememberedValue5);
                                                }
                                                composer5.endReplaceGroup();
                                                Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierThen2, applyBottomWindowInsets, (Function1) objRememberedValue5);
                                                boolean applyHorizontalWindowInsets = stackComponentState.getApplyHorizontalWindowInsets();
                                                composer5.startReplaceGroup(-957874973);
                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged6 = composer5.changed(safeDrawing);
                                                final WindowInsets windowInsets2 = safeDrawing;
                                                Object objRememberedValue6 = composer5.rememberedValue();
                                                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue6 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$1$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets2, WindowInsetsSides.INSTANCE.m2132getHorizontalJoeWqyM()));
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(objRememberedValue6);
                                                }
                                                composer5.endReplaceGroup();
                                                function34.invoke(ModifierExtensionsKt.conditional(modifierConditional, applyHorizontalWindowInsets, (Function1) objRememberedValue6), composer5, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 >> 3) & 14) | 24576, 0);
                                        composer4 = composerStartRestartGroup;
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4 = composerStartRestartGroup;
                                        modifier4 = modifier3;
                                        composer4.startReplaceGroup(-402937383);
                                        ComposerKt.sourceInformation(composer4, "668@30662L117,671@30853L121,664@30463L526");
                                        Modifier modifierThen2 = modifier7.then(modifier8).then(modifier9);
                                        boolean applyBottomWindowInsets = stackComponentState.getApplyBottomWindowInsets();
                                        composer4.startReplaceGroup(1233934392);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                        boolean zChanged5 = composer4.changed(safeDrawing);
                                        Object objRememberedValue5 = composer4.rememberedValue();
                                        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue5 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2130getBottomJoeWqyM()));
                                                }
                                            };
                                            composer4.updateRememberedValue(objRememberedValue5);
                                        }
                                        composer4.endReplaceGroup();
                                        Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierThen2, applyBottomWindowInsets, (Function1) objRememberedValue5);
                                        boolean applyHorizontalWindowInsets = stackComponentState.getApplyHorizontalWindowInsets();
                                        composer4.startReplaceGroup(1233940508);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                        boolean zChanged6 = composer4.changed(safeDrawing);
                                        Object objRememberedValue6 = composer4.rememberedValue();
                                        if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$3$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2132getHorizontalJoeWqyM()));
                                                }
                                            };
                                            composer4.updateRememberedValue(objRememberedValue6);
                                        }
                                        composer4.endReplaceGroup();
                                        composableLambdaRememberComposableLambda.invoke(ModifierExtensionsKt.conditional(modifierConditional, applyHorizontalWindowInsets, (Function1) objRememberedValue6), composer4, 48);
                                        composer4.endReplaceGroup();
                                    }
                                    composer4.endReplaceGroup();
                                    composer2 = composer4;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3 = composer2;
                                modifier5 = modifier4;
                                function32 = function33;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                function32 = function3;
                                composer3 = composerStartRestartGroup;
                                modifier5 = modifier2;
                            }
                            final BadgeStyle badgeStyle3 = badgeStyle2;
                            final boolean z3 = z2;
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.MainStackComponent.6
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

                                    public final void invoke(Composer composer5, int i10) {
                                        StackComponentViewKt.MainStackComponent(stackComponentState, components, function2, f, modifier5, badgeStyle3, z3, function32, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 1572864;
                        z2 = z;
                        i7 = i2 & 128;
                        if (i7 == 0) {
                        }
                        if ((i3 & 4793491) == 4793490) {
                            if (i4 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final WindowInsets safeDrawing2 = WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6);
                            int i82 = i3;
                            modifier3 = modifier6;
                            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-586909421, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier72, Composer composer5, Integer num) {
                                    invoke(modifier72, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier rootModifier, Composer composer5, int i92) {
                                    final int top;
                                    Composer composer6 = composer5;
                                    Intrinsics.checkNotNullParameter(rootModifier, "rootModifier");
                                    ComposerKt.sourceInformation(composer6, "C:StackComponentView.kt#280jdz");
                                    int i10 = (i92 & 6) == 0 ? i92 | (composer6.changed(rootModifier) ? 4 : 2) : i92;
                                    if ((i10 & 19) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-586909421, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:492)");
                                    }
                                    Orientation scrollOrientation = stackComponentState.getScrollOrientation();
                                    composer6.startReplaceGroup(-958141281);
                                    ComposerKt.sourceInformation(composer6, "*492@21958L21");
                                    ScrollState scrollStateRememberScrollState = scrollOrientation == null ? null : ScrollKt.rememberScrollState(0, composer6, 0, 1);
                                    composer6.endReplaceGroup();
                                    if (stackComponentState.getChildren().isEmpty()) {
                                        composer6.startReplaceGroup(362679198);
                                        ComposerKt.sourceInformation(composer6, "497@22252L138");
                                        BoxKt.Box(SizeKt.size$default(modifier3, stackComponentState.getSize(), null, null, 6, null).then(rootModifier), composer6, 0);
                                        composer6.endReplaceGroup();
                                    } else {
                                        composer6.startReplaceGroup(363022244);
                                        ComposerKt.sourceInformation(composer6, "");
                                        Dimension dimension = stackComponentState.getDimension();
                                        if (dimension instanceof Dimension.Horizontal) {
                                            composer6.startReplaceGroup(-958122178);
                                            ComposerKt.sourceInformation(composer6, "514@23060L757,504@22509L1308");
                                            Size size = stackComponentState.getSize();
                                            Dimension.Horizontal horizontal = (Dimension.Horizontal) dimension;
                                            float fM10564getSpacingD9Ej5fM = stackComponentState.m10564getSpacingD9Ej5fM();
                                            Modifier modifierThen3 = ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier3, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                    Intrinsics.checkNotNullParameter(state2, "state");
                                                    Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                    return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                }
                                            }).then(rootModifier);
                                            composer6.startReplaceGroup(-958105097);
                                            ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                            boolean zChanged52 = composer6.changed(stackComponentState) | composer6.changed(components2) | composer6.changedInstance(function22) | composer6.changed(safeDrawing2) | composer6.changed(f2);
                                            final StackComponentState stackComponentState2 = stackComponentState;
                                            final PaywallState.Loaded.Components components3 = components2;
                                            final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function22;
                                            final WindowInsets windowInsets = safeDrawing2;
                                            final float f3 = f2;
                                            Object objRememberedValue52 = composer6.rememberedValue();
                                            if (zChanged52 || objRememberedValue52 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue52 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                        invoke2(horizontalStackScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                        Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                        List children = stackComponentState2.getChildren();
                                                        final PaywallState.Loaded.Components components4 = components3;
                                                        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function24 = function23;
                                                        final StackComponentState stackComponentState3 = stackComponentState2;
                                                        final WindowInsets windowInsets2 = windowInsets;
                                                        final float f4 = f3;
                                                        HorizontalStack.items(children, ComposableLambdaKt.composableLambdaInstance(1342922659, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(5);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function5
                                                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer7, Integer num2) {
                                                                invoke(rowScope, num.intValue(), componentStyle, composer7, num2.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(final RowScope items, int i11, ComponentStyle child, Composer composer7, int i12) {
                                                                int i13;
                                                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                Intrinsics.checkNotNullParameter(child, "child");
                                                                ComposerKt.sourceInformation(composer7, "C521@23419L23,522@23559L138,516@23147L630:StackComponentView.kt#280jdz");
                                                                if ((i12 & 6) == 0) {
                                                                    i13 = (composer7.changed(items) ? 4 : 2) | i12;
                                                                } else {
                                                                    i13 = i12;
                                                                }
                                                                if ((i12 & 384) == 0) {
                                                                    i13 |= composer7.changed(child) ? 256 : 128;
                                                                }
                                                                if ((i13 & 1155) == 1154 && composer7.getSkipping()) {
                                                                    composer7.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1342922659, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:516)");
                                                                }
                                                                PaywallState.Loaded.Components components5 = components4;
                                                                Function2<PaywallAction, Continuation<? super Unit>, Object> function25 = function24;
                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                boolean zAreEqual = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE);
                                                                composer7.startReplaceGroup(-1700561546);
                                                                ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                boolean z32 = (i13 & 14) == 4;
                                                                Object objRememberedValue62 = composer7.rememberedValue();
                                                                if (z32 || objRememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                                                    objRememberedValue62 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1$1$1$1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Modifier invoke(Modifier conditional) {
                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                            return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                        }
                                                                    };
                                                                    composer7.updateRememberedValue(objRememberedValue62);
                                                                }
                                                                composer7.endReplaceGroup();
                                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(companion, zAreEqual, (Function1) objRememberedValue62);
                                                                boolean z4 = stackComponentState3.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                composer7.startReplaceGroup(-1700556951);
                                                                ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                boolean zChanged62 = composer7.changed(windowInsets2);
                                                                final WindowInsets windowInsets3 = windowInsets2;
                                                                Object objRememberedValue7 = composer7.rememberedValue();
                                                                if (zChanged62 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                                    objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1$1$2$1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Modifier invoke(Modifier conditional) {
                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets3, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                                        }
                                                                    };
                                                                    composer7.updateRememberedValue(objRememberedValue7);
                                                                }
                                                                composer7.endReplaceGroup();
                                                                ComponentViewKt.ComponentView(child, components5, function25, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional2, z4, (Function1) objRememberedValue7), f4), composer7, (i13 >> 6) & 14, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                    }
                                                };
                                                composer6.updateRememberedValue(objRememberedValue52);
                                            }
                                            composer6.endReplaceGroup();
                                            HorizontalStackKt.m10563HorizontalStackTN_CM5M(size, horizontal, fM10564getSpacingD9Ej5fM, modifierThen3, (Function1) objRememberedValue52, composer6, 0, 0);
                                            composer6.endReplaceGroup();
                                        } else if (dimension instanceof Dimension.Vertical) {
                                            composer6.startReplaceGroup(-958078546);
                                            ComposerKt.sourceInformation(composer6, "540@24411L1157,530@23860L1708");
                                            Size size2 = stackComponentState.getSize();
                                            Dimension.Vertical vertical = (Dimension.Vertical) dimension;
                                            float fM10564getSpacingD9Ej5fM2 = stackComponentState.m10564getSpacingD9Ej5fM();
                                            Modifier modifierThen22 = ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier3, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.3
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                    Intrinsics.checkNotNullParameter(state2, "state");
                                                    Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                    return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                }
                                            }).then(rootModifier);
                                            composer6.startReplaceGroup(-958061465);
                                            ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                            boolean zChanged62 = composer6.changed(stackComponentState) | composer6.changed(components2) | composer6.changedInstance(function22) | composer6.changed(safeDrawing2) | composer6.changed(f2);
                                            final StackComponentState stackComponentState3 = stackComponentState;
                                            final PaywallState.Loaded.Components components4 = components2;
                                            final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function24 = function22;
                                            final WindowInsets windowInsets2 = safeDrawing2;
                                            final float f4 = f2;
                                            Object objRememberedValue62 = composer6.rememberedValue();
                                            if (zChanged62 || objRememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue62 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                        invoke2(verticalStackScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(VerticalStackScope VerticalStack) {
                                                        Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                        List children = stackComponentState3.getChildren();
                                                        final PaywallState.Loaded.Components components5 = components4;
                                                        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function25 = function24;
                                                        final StackComponentState stackComponentState4 = stackComponentState3;
                                                        final WindowInsets windowInsets3 = windowInsets2;
                                                        final float f5 = f4;
                                                        VerticalStack.items(children, ComposableLambdaKt.composableLambdaInstance(1477849382, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(5);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function5
                                                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer7, Integer num2) {
                                                                invoke(columnScope, num.intValue(), componentStyle, composer7, num2.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(final ColumnScope items, int i11, ComponentStyle child, Composer composer7, int i12) {
                                                                int i13;
                                                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                Intrinsics.checkNotNullParameter(child, "child");
                                                                ComposerKt.sourceInformation(composer7, "CP(1)547@24775L23,554@25310L138,542@24502L1026:StackComponentView.kt#280jdz");
                                                                if ((i12 & 6) == 0) {
                                                                    i13 = (composer7.changed(items) ? 4 : 2) | i12;
                                                                } else {
                                                                    i13 = i12;
                                                                }
                                                                if ((i12 & 48) == 0) {
                                                                    i13 |= composer7.changed(i11) ? 32 : 16;
                                                                }
                                                                if ((i12 & 384) == 0) {
                                                                    i13 |= composer7.changed(child) ? 256 : 128;
                                                                }
                                                                if ((i13 & 1171) == 1170 && composer7.getSkipping()) {
                                                                    composer7.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1477849382, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:542)");
                                                                }
                                                                PaywallState.Loaded.Components components6 = components5;
                                                                Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function25;
                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                boolean zAreEqual = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE);
                                                                composer7.startReplaceGroup(-1700518154);
                                                                ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                boolean z32 = (i13 & 14) == 4;
                                                                Object objRememberedValue7 = composer7.rememberedValue();
                                                                if (z32 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                                    objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1$1$1$1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Modifier invoke(Modifier conditional) {
                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                            return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                        }
                                                                    };
                                                                    composer7.updateRememberedValue(objRememberedValue7);
                                                                }
                                                                composer7.endReplaceGroup();
                                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(companion, zAreEqual, (Function1) objRememberedValue7);
                                                                boolean z4 = stackComponentState4.getApplyTopWindowInsets() && i11 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                composer7.startReplaceGroup(-1700500919);
                                                                ComposerKt.sourceInformation(composer7, "CC(remember):StackComponentView.kt#9igjgp");
                                                                boolean zChanged7 = composer7.changed(windowInsets3);
                                                                final WindowInsets windowInsets4 = windowInsets3;
                                                                Object objRememberedValue8 = composer7.rememberedValue();
                                                                if (zChanged7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                                    objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$4$1$1$2$1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Modifier invoke(Modifier conditional) {
                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                                        }
                                                                    };
                                                                    composer7.updateRememberedValue(objRememberedValue8);
                                                                }
                                                                composer7.endReplaceGroup();
                                                                ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional2, z4, (Function1) objRememberedValue8), f5), composer7, (i13 >> 6) & 14, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                    }
                                                };
                                                composer6.updateRememberedValue(objRememberedValue62);
                                            }
                                            composer6.endReplaceGroup();
                                            VerticalStackKt.m10570VerticalStackTN_CM5M(size2, vertical, fM10564getSpacingD9Ej5fM2, modifierThen22, (Function1) objRememberedValue62, composer6, 0, 0);
                                            composer6.endReplaceGroup();
                                        } else if (dimension instanceof Dimension.ZLayer) {
                                            composer6.startReplaceGroup(366099583);
                                            ComposerKt.sourceInformation(composer6, "571@26148L2068");
                                            composer6.startReplaceGroup(-958014530);
                                            ComposerKt.sourceInformation(composer6, "567@26042L7");
                                            if (!stackComponentState.getApplyTopWindowInsets() || stackComponentState.getIgnoreHeaderHeight()) {
                                                top = 0;
                                            } else {
                                                WindowInsets windowInsets3 = safeDrawing2;
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer6.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                top = windowInsets3.getTop((Density) objConsume);
                                            }
                                            composer6.endReplaceGroup();
                                            Dimension.ZLayer zLayer = (Dimension.ZLayer) dimension;
                                            Modifier modifierThen32 = ModifierExtensionsKt.applyIfNotNull(SizeKt.size(modifier3, stackComponentState.getSize(), AlignmentKt.toHorizontalAlignmentOrNull(zLayer.getAlignment()), AlignmentKt.toVerticalAlignmentOrNull(zLayer.getAlignment())), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.5
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                    Intrinsics.checkNotNullParameter(state2, "state");
                                                    Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                    return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                }
                                            }).then(rootModifier);
                                            Alignment alignment = AlignmentKt.toAlignment(zLayer.getAlignment());
                                            StackComponentState stackComponentState4 = stackComponentState;
                                            final PaywallState.Loaded.Components components5 = components2;
                                            Function2<PaywallAction, Continuation<? super Unit>, Object> function25 = function22;
                                            final WindowInsets windowInsets4 = safeDrawing2;
                                            float f5 = f2;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer6.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer6, modifierThen32);
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor3);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer6);
                                            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, -97353193, "C:StackComponentView.kt#280jdz");
                                            composer6.startReplaceGroup(1797975512);
                                            ComposerKt.sourceInformation(composer6, "*592@27437L398,598@27934L146,587@27121L1047");
                                            for (ComponentStyle componentStyle : stackComponentState4.getChildren()) {
                                                boolean z32 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(componentStyle);
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                boolean z4 = z32 && !stackComponentState4.getIgnoreHeaderHeight();
                                                composer6.startReplaceGroup(193868590);
                                                ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged7 = composer6.changed(components5) | composer6.changed(top);
                                                Object objRememberedValue7 = composer6.rememberedValue();
                                                if (zChanged7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return StackComponentViewKt.headerOrInsetsTopPadding(conditional, components5, top);
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(objRememberedValue7);
                                                }
                                                composer6.endReplaceGroup();
                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(companion, z4, (Function1) objRememberedValue7);
                                                boolean z5 = z32 && stackComponentState4.getIgnoreHeaderHeight();
                                                composer6.startReplaceGroup(193884242);
                                                ComposerKt.sourceInformation(composer6, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged8 = composer6.changed(windowInsets4);
                                                Object objRememberedValue8 = composer6.rememberedValue();
                                                if (zChanged8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2110onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(objRememberedValue8);
                                                }
                                                composer6.endReplaceGroup();
                                                Modifier modifierAlpha = AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional2, z5, (Function1) objRememberedValue8), f5);
                                                Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function25;
                                                PaywallState.Loaded.Components components6 = components5;
                                                ComponentViewKt.ComponentView(componentStyle, components6, function26, modifierAlpha, composer5, 0, 0);
                                                function25 = function26;
                                                composer6 = composer5;
                                                components5 = components6;
                                            }
                                            composer6.endReplaceGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            composer6.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            composer6.endReplaceGroup();
                                        } else {
                                            composer6.startReplaceGroup(368636096);
                                            composer6.endReplaceGroup();
                                        }
                                        composer6.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54);
                            BackgroundStyles background2 = stackComponentState.getBackground();
                            composerStartRestartGroup.startReplaceGroup(1233859219);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*610@28321L40");
                            if (background2 != null) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Shape shape2 = stackComponentState.getShape();
                            composerStartRestartGroup.startReplaceGroup(1233861583);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(shape2);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$composeShape$2$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final androidx.compose.ui.graphics.Shape invoke() {
                                        return ShapeKt.toShape(stackComponentState.getShape());
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                state = (State) objRememberedValue;
                                composerStartRestartGroup.endReplaceGroup();
                                BorderStyles border2 = stackComponentState.getBorder();
                                composerStartRestartGroup.startReplaceGroup(1233865323);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*612@28512L32");
                                if (border2 != null) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1233867423);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*614@28627L32");
                                if (z2) {
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1233872510);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    zChanged2 = composerStartRestartGroup.changed(backgroundStyleRememberBackgroundStyle) | composerStartRestartGroup.changed(shadowStyleRememberShadowStyle);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged2) {
                                        objRememberedValue2 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), shadowStyleRememberShadowStyle, new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state));
                                            }
                                        }), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                return BackgroundKt.background(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state));
                                            }
                                        });
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        Modifier modifier72 = (Modifier) objRememberedValue2;
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.startReplaceGroup(1233881350);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                        int i92 = i82 & 14;
                                        zChanged3 = (i92 != 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged3) {
                                            objRememberedValue3 = ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$borderModifier$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    return PaddingKt.m2037padding3ABfNKs(BorderKt.border(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$10(state)), it.m10519getWidthD9Ej5fM());
                                                }
                                            });
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                            final Modifier modifier82 = (Modifier) objRememberedValue3;
                                            composerStartRestartGroup.endReplaceGroup();
                                            composerStartRestartGroup.startReplaceGroup(1233888486);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                            zChanged4 = composerStartRestartGroup.changed(borderStyleRememberBorderStyle) | (i92 != 4);
                                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                            if (!zChanged4) {
                                                objRememberedValue4 = PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getPadding());
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                final Modifier modifier92 = (Modifier) objRememberedValue4;
                                                composerStartRestartGroup.endReplaceGroup();
                                                if (badgeStyle2 == null) {
                                                    BackgroundStyle backgroundStyle2 = backgroundStyleRememberBackgroundStyle;
                                                    modifier4 = modifier3;
                                                    if (badgeStyle2 == null) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    composer3 = composer2;
                                                    modifier5 = modifier4;
                                                    function32 = function33;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        final BadgeStyle badgeStyle32 = badgeStyle2;
                        final boolean z32 = z2;
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    badgeStyle2 = badgeStyle;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                    }
                    z2 = z;
                    i7 = i2 & 128;
                    if (i7 == 0) {
                    }
                    if ((i3 & 4793491) == 4793490) {
                    }
                    final BadgeStyle badgeStyle322 = badgeStyle2;
                    final boolean z322 = z2;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 32;
                if (i5 == 0) {
                }
                badgeStyle2 = badgeStyle;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                z2 = z;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                if ((i3 & 4793491) == 4793490) {
                }
                final BadgeStyle badgeStyle3222 = badgeStyle2;
                final boolean z3222 = z2;
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function22 = function2;
            if ((i2 & 8) != 0) {
            }
            i4 = i2 & 16;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            badgeStyle2 = badgeStyle;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            z2 = z;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            if ((i3 & 4793491) == 4793490) {
            }
            final BadgeStyle badgeStyle32222 = badgeStyle2;
            final boolean z32222 = z2;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        components2 = components;
        if ((i2 & 4) == 0) {
        }
        function22 = function2;
        if ((i2 & 8) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        badgeStyle2 = badgeStyle;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        if ((i3 & 4793491) == 4793490) {
        }
        final BadgeStyle badgeStyle322222 = badgeStyle2;
        final boolean z322222 = z2;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.graphics.Shape MainStackComponent$lambda$10(State<? extends androidx.compose.ui.graphics.Shape> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OverlaidBadge(final BoxScope boxScope, final StackComponentStyle stackComponentStyle, final PaywallState.Loaded.Components components, final TwoDimensionalAlignment twoDimensionalAlignment, final Float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        StackComponentStyle stackComponentStyle2;
        PaywallState.Loaded.Components components2;
        Modifier modifier2;
        boolean z;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(40404352);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OverlaidBadge)P(1,4)464@20857L394,458@20698L560:StackComponentView.kt#280jdz");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
            stackComponentStyle2 = stackComponentStyle;
        } else {
            stackComponentStyle2 = stackComponentStyle;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 32 : 16;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
            components2 = components;
        } else {
            components2 = components;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(components2) ? 256 : 128;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(twoDimensionalAlignment) ? 2048 : 1024;
        }
        if ((i2 & 8) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(40404352, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.OverlaidBadge (StackComponentView.kt:457)");
                }
                C07711 c07711 = new C07711(null);
                Modifier modifierAlign = boxScope.align(companion, AlignmentKt.toAlignment(twoDimensionalAlignment));
                composerStartRestartGroup.startReplaceGroup(-827874156);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                z = ((i3 & 7168) != 2048) | ((57344 & i3) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                            return m10567invoke3p2s80s(measureScope, measurable, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m10567invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Intrinsics.checkNotNullParameter(measurable, "measurable");
                            final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
                            int width = placeableMo7769measureBRTryo0.getWidth();
                            int height = placeableMo7769measureBRTryo0.getHeight();
                            final TwoDimensionalAlignment twoDimensionalAlignment2 = twoDimensionalAlignment;
                            final Float f2 = f;
                            return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2$1.1
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
                                public final void invoke2(Placeable.PlacementScope layout2) {
                                    Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                    Placeable placeable = placeableMo7769measureBRTryo0;
                                    int height2 = placeable.getHeight();
                                    TwoDimensionalAlignment twoDimensionalAlignment3 = twoDimensionalAlignment2;
                                    Float f3 = f2;
                                    Placeable.PlacementScope.placeRelative$default(layout2, placeable, 0, StackComponentViewKt.getOverlaidBadgeOffsetY(height2, twoDimensionalAlignment3, f3 != null ? f3.floatValue() : 0.0f), 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i5 = i3 >> 3;
                StackComponentView(stackComponentStyle2, components2, c07711, LayoutModifierKt.layout(modifierAlign, (Function3) objRememberedValue), 0.0f, composerStartRestartGroup, (i5 & 14) | 384 | (i5 & 112), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.OverlaidBadge.3
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
                        StackComponentViewKt.OverlaidBadge(boxScope, stackComponentStyle, components, twoDimensionalAlignment, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            C07711 c077112 = new C07711(null);
            Modifier modifierAlign2 = boxScope.align(companion, AlignmentKt.toAlignment(twoDimensionalAlignment));
            composerStartRestartGroup.startReplaceGroup(-827874156);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
            z = ((i3 & 7168) != 2048) | ((57344 & i3) == 16384);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m10567invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m10567invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        Intrinsics.checkNotNullParameter(measurable, "measurable");
                        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
                        int width = placeableMo7769measureBRTryo0.getWidth();
                        int height = placeableMo7769measureBRTryo0.getHeight();
                        final TwoDimensionalAlignment twoDimensionalAlignment2 = twoDimensionalAlignment;
                        final Float f2 = f;
                        return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2$1.1
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
                            public final void invoke2(Placeable.PlacementScope layout2) {
                                Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                Placeable placeable = placeableMo7769measureBRTryo0;
                                int height2 = placeable.getHeight();
                                TwoDimensionalAlignment twoDimensionalAlignment3 = twoDimensionalAlignment2;
                                Float f3 = f2;
                                Placeable.PlacementScope.placeRelative$default(layout2, placeable, 0, StackComponentViewKt.getOverlaidBadgeOffsetY(height2, twoDimensionalAlignment3, f3 != null ? f3.floatValue() : 0.0f), 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
                int i52 = i3 >> 3;
                StackComponentView(stackComponentStyle2, components2, c077112, LayoutModifierKt.layout(modifierAlign2, (Function3) objRememberedValue), 0.0f, composerStartRestartGroup, (i52 & 14) | 384 | (i52 & 112), 16);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = companion;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackComponentView(final StackComponentStyle style, final PaywallState.Loaded.Components state, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float f2;
        final float f3;
        StackComponentState stackComponentStateRememberUpdatedStackComponentState;
        final Modifier modifier3;
        Composer composer2;
        Composer composer3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-550450443);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView)P(4,3!1,2)108@6451L94:StackComponentView.kt#280jdz");
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
        if (i5 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    f2 = f;
                    i3 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                    composer2 = composerStartRestartGroup;
                } else {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    f3 = i4 == 0 ? 1.0f : f2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-550450443, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView (StackComponentView.kt:106)");
                    }
                    int i6 = i3 & 112;
                    stackComponentStateRememberUpdatedStackComponentState = StackComponentStateKt.rememberUpdatedStackComponentState(style, state, composerStartRestartGroup, i3 & 126);
                    if (stackComponentStateRememberUpdatedStackComponentState.getVisible()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            final Modifier modifier4 = modifier2;
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView.1
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

                                public final void invoke(Composer composer4, int i7) {
                                    StackComponentViewKt.StackComponentView(style, state, clickHandler, modifier4, f3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    modifier3 = modifier2;
                    BadgeStyle badge = stackComponentStateRememberUpdatedStackComponentState.getBadge();
                    if (badge != null) {
                        composerStartRestartGroup.startReplaceGroup(1455721972);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        int i7 = WhenMappings.$EnumSwitchMapping$1[badge.getStyle().ordinal()];
                        if (i7 != 1) {
                            if (i7 == 2) {
                                composerStartRestartGroup.startReplaceGroup(1456112293);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                int i8 = WhenMappings.$EnumSwitchMapping$0[badge.getAlignment().ordinal()];
                                if (i8 == 1 || i8 == 2) {
                                    int i9 = i3;
                                    composerStartRestartGroup.startReplaceGroup(878260140);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "136@7234L317");
                                    StackWithLongEdgeToEdgeBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), isTop(badge.getAlignment()), clickHandler, f3, modifier3, composerStartRestartGroup, i6 | (57344 & (i9 << 6)) | ((i9 << 3) & 458752) | ((i9 << 9) & 3670016), 0);
                                    modifier3 = modifier3;
                                    composer3 = composerStartRestartGroup;
                                    composer3.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(878271879);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@7601L312");
                                    int i10 = i3;
                                    StackWithShortEdgeToEdgeBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), badge.getAlignment(), clickHandler, f3, modifier3, composerStartRestartGroup, i6 | (57344 & (i10 << 6)) | ((i10 << 3) & 458752) | ((i10 << 9) & 3670016), 0);
                                    modifier3 = modifier3;
                                    composer3 = composerStartRestartGroup;
                                    composer3.endReplaceGroup();
                                }
                                composer3.endReplaceGroup();
                            } else if (i7 != 3) {
                                composerStartRestartGroup.startReplaceGroup(1457098899);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(878284321);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "160@7997L82");
                                composer3 = composerStartRestartGroup;
                                float f4 = f3;
                                MainStackComponent(stackComponentStateRememberUpdatedStackComponentState, state, clickHandler, f4, modifier3, badge, false, null, composer3, (i3 & PointerIconCompat.TYPE_TEXT) | ((i3 >> 3) & 7168) | ((i3 << 3) & 57344), 192);
                                f3 = f4;
                                composer3.endReplaceGroup();
                            }
                            composerStartRestartGroup = composer3;
                        } else {
                            int i11 = i3;
                            composerStartRestartGroup.startReplaceGroup(1455752290);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "121@6740L273");
                            composerStartRestartGroup = composerStartRestartGroup;
                            StackWithOverlaidBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), badge.getAlignment(), clickHandler, f3, modifier3, composerStartRestartGroup, i6 | (57344 & (i11 << 6)) | ((i11 << 3) & 458752) | ((i11 << 9) & 3670016), 0);
                            modifier3 = modifier3;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                    } else {
                        int i12 = i3;
                        composerStartRestartGroup.startReplaceGroup(1457113624);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "163@8111L75");
                        float f5 = f3;
                        composer2 = composerStartRestartGroup;
                        MainStackComponent(stackComponentStateRememberUpdatedStackComponentState, state, clickHandler, f5, modifier3, null, false, null, composer2, (i12 & PointerIconCompat.TYPE_TEXT) | ((i12 >> 3) & 7168) | ((i12 << 3) & 57344), WebmConstants.MkvEbmlElement.VIDEO);
                        f3 = f5;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView.2
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

                        public final void invoke(Composer composer4, int i13) {
                            StackComponentViewKt.StackComponentView(style, state, clickHandler, modifier3, f3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            f2 = f;
            if ((i3 & 9363) == 9362) {
                if (i5 != 0) {
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i62 = i3 & 112;
                stackComponentStateRememberUpdatedStackComponentState = StackComponentStateKt.rememberUpdatedStackComponentState(style, state, composerStartRestartGroup, i3 & 126);
                if (stackComponentStateRememberUpdatedStackComponentState.getVisible()) {
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        f2 = f;
        if ((i3 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Children_Extend_Over_Parent(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849301685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Children_Extend_Over_Parent)1142@47929L2053:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849301685, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Children_Extend_Over_Parent (StackComponentView.kt:1141)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f)), Color.INSTANCE.m6355getGray0d7_KjU(), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897727660, "C1151@48228L17,1191@49914L19,1147@48049L1927:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.Overlay, TwoDimensionalAlignment.TOP_TRAILING, new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null)), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Children_Extend_Over_Parent$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent.2
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
                    StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ContentAlpha(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1355314342);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_ContentAlpha)1696@69671L17,1698@69717L19,1694@69584L215:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1355314342, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ContentAlpha (StackComponentView.kt:1693)");
            }
            StackComponentView(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07741(null), null, 0.6f, composerStartRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ContentAlpha.2
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
                    StackComponentViewKt.StackComponentView_Preview_ContentAlpha(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2040912590);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children)1567@64849L19,1526@63042L1861:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040912590, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children (StackComponentView.kt:1525)");
            }
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("SPACE_AROUND", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.SPACE_AROUND), true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.m9114constructorimpl(8.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07761(null), null, 0.0f, composerStartRestartGroup, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children.2
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
                    StackComponentViewKt.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_With_Spacing(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2060177158);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_With_Spacing)1620@66952L19,1582@65273L1733:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2060177158, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_With_Spacing (StackComponentView.kt:1576)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C07781(null), null, 0.0f, composer2, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing.2
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
                    StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1146712254);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_Without_Spacing)1518@62872L19,1480@61194L1732:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1146712254, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing (StackComponentView.kt:1474)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.m9114constructorimpl(0.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C07801(null), null, 0.0f, composer2, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing.2
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
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(585047730);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size)1465@60767L19,1427@59105L1716:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585047730, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size (StackComponentView.kt:1421)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null);
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(0.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C07821(null), null, 0.0f, composer2, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size.2
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
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_EdgeToEdge_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1687690690);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_EdgeToEdge_Badge)967@41302L705:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1687690690, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_EdgeToEdge_Badge (StackComponentView.kt:966)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 81518704, "C975@41573L17,984@41939L19,973@41478L523:StackComponentView.kt#280jdz");
            StackComponentView(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_EdgeToEdge_Badge$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Horizontal(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(537558075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Horizontal)1096@46111L1640:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537558075, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Horizontal (StackComponentView.kt:1095)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1124150914, "C1101@46270L17,1133@47683L19,1099@46182L1563:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(30.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Horizontal$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Horizontal.2
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
                    StackComponentViewKt.StackComponentView_Preview_Horizontal(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalChildrenFillWidth(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(94466939);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_HorizontalChildrenFillWidth)1357@56558L19,1322@55101L1511:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(94466939, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalChildrenFillWidth (StackComponentView.kt:1321)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64894, null)});
            Dimension.Horizontal horizontal = new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE);
            float fM9114constructorimpl = Dp.m9114constructorimpl(16.0f);
            ColorStyles colorStylesM10510constructorimpl = BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null));
            StackComponentView(new StackComponentStyle(listListOf, horizontal, true, size, fM9114constructorimpl, BackgroundStyles.Color.m10509boximpl(colorStylesM10510constructorimpl), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07861(null), null, 0.0f, composerStartRestartGroup, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth.2
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
                    StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalDivider(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1466582790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_HorizontalDivider)1628@67096L1082:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1466582790, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalDivider (StackComponentView.kt:1627)");
            }
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1832030991, "C1631@67175L50,1649@68051L19,1632@67234L879,1652@68122L50:StackComponentView.kt#280jdz");
            TextKt.m4286Text4IGK_g("There should be a divider below this text.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 6, 0, 131070);
            List listEmptyList = CollectionsKt.emptyList();
            Size size = new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(1, null));
            StackComponentView(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(listEmptyList, (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : size, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : Dp.m9114constructorimpl(0.0f), (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.Color$default(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : PaddingKt.m2032PaddingValuesYgX7TsA$default(0.0f, Dp.m9114constructorimpl(40.0f), 1, null), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_HorizontalDivider$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
            composer2 = composerStartRestartGroup;
            TextKt.m4286Text4IGK_g("There should be a divider above this text.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 131070);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_HorizontalDivider(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Nested_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1890270268);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Nested_Badge)1042@43968L1894:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890270268, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Nested_Badge (StackComponentView.kt:1041)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 530945769, "C1055@44383L17,1086@45794L19,1053@44295L1561:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(20.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(10.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), previewBadge$default(Badge.Style.Nested, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Nested_Badge$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Nested_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Nested_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Overlay_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1927454081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Overlay_Badge)907@39087L2036:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1927454081, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Overlay_Badge (StackComponentView.kt:906)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485810000, "C920@39502L17,956@41055L19,918@39414L1703:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(12.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(12.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(10.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), previewBadge$default(Badge.Style.Overlay, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), null, PaddingKt.m2032PaddingValuesYgX7TsA$default(Dp.m9114constructorimpl(8.0f), 0.0f, 2, null), 8, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Overlay_Badge$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Overlay_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Overlay_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Pill_EdgeToEdge_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1484368524);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Pill_EdgeToEdge_Badge)995@42191L1602:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1484368524, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Pill_EdgeToEdge_Badge (StackComponentView.kt:994)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95163511, "C1000@42350L17,1031@43725L19,998@42262L1525:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), Shape.Pill.INSTANCE, new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, Shape.Pill.INSTANCE, null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Pill_EdgeToEdge_Badge$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-889520099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll)1212@50514L1649:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889520099, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll (StackComponentView.kt:1200)");
            }
            IntRange intRange = new IntRange(0, 10);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle$default("Hello " + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63614, null));
            }
            ArrayList arrayList2 = arrayList;
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1566593705, "C1249@52095L19,1215@50585L1572:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(arrayList2, new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(5.0f), null), null, Orientation.Horizontal, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll.2
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
                    StackComponentViewKt.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-99980615);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll)848@36853L1646:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99980615, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll (StackComponentView.kt:836)");
            }
            IntRange intRange = new IntRange(0, 30);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle$default("Hello " + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63614, null));
            }
            ArrayList arrayList2 = arrayList;
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443459336, "C885@38432L19,851@36924L1569:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(arrayList2, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null), null, Orientation.Vertical, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll.2
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
                    StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Vertical(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1372631849);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Vertical)790@34686L1639:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372631849, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Vertical (StackComponentView.kt:789)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1576686125, "C795@34845L17,827@36258L19,793@34757L1562:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Vertical$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Vertical.2
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
                    StackComponentViewKt.StackComponentView_Preview_Vertical(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalChildrenFillHeight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(89883392);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_VerticalChildrenFillHeight)1400@58154L19,1365@56711L1497:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(89883392, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalChildrenFillHeight (StackComponentView.kt:1364)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE), null, null, null, null, null, null, 64894, null)});
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(SizeConstraint.Fit.INSTANCE, new SizeConstraint.Fixed(200, null));
            float fM9114constructorimpl = Dp.m9114constructorimpl(16.0f);
            ColorStyles colorStylesM10510constructorimpl = BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null));
            StackComponentView(new StackComponentStyle(listListOf, vertical, true, size, fM9114constructorimpl, BackgroundStyles.Color.m10509boximpl(colorStylesM10510constructorimpl), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07951(null), null, 0.0f, composerStartRestartGroup, 384, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight.2
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
                    StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalDivider(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-843904936);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_VerticalDivider)1659@68266L1233:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843904936, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalDivider (StackComponentView.kt:1658)");
            }
            Modifier modifierM2069height3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f));
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2069height3ABfNKs);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1659233783, "C1663@68388L134,1681@69289L19,1667@68531L820,1684@69360L133:StackComponentView.kt#280jdz");
            TextKt.m4286Text4IGK_g("There should be a divider to the right of this text.", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 6, 0, 131068);
            List listEmptyList = CollectionsKt.emptyList();
            Size size = new Size(new SizeConstraint.Fixed(1, null), SizeConstraint.Fill.INSTANCE);
            StackComponentView(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(listEmptyList, (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : size, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : Dp.m9114constructorimpl(0.0f), (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.Color$default(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : PaddingKt.m2032PaddingValuesYgX7TsA$default(Dp.m9114constructorimpl(40.0f), 0.0f, 2, null), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
            composer2 = composerStartRestartGroup;
            TextKt.m4286Text4IGK_g("There should be a divider to the left of this text.", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 131068);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_VerticalDivider(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ZLayer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(665263624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_ZLayer)1260@52432L2569:StackComponentView.kt#280jdz");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(665263624, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ZLayer (StackComponentView.kt:1259)");
            }
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(32.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 163086122, "C1313@54933L19,1263@52503L2492:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU()))), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, 24.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 24.0d), null, null, null, null, 61822, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null)}), new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM_TRAILING), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU()))))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(20.0f), Dp.m9114constructorimpl(5.0f), Dp.m9114constructorimpl(5.0f), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_ZLayer$1$1(null), null, 0.0f, composerStartRestartGroup, 384, 24);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ZLayer.2
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
                    StackComponentViewKt.StackComponentView_Preview_ZLayer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithLongEdgeToEdgeBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final boolean z, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        PaywallState.Loaded.Components components2;
        StackComponentStyle stackComponentStyle2;
        boolean z2;
        float f2;
        int i4;
        Modifier modifier2;
        Modifier.Companion companion;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChangedInstance;
        Object objRememberedValue3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(770835511);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithLongEdgeToEdgeBadge)P(4,5!1,6)208@9561L76,212@9730L28,213@9766L7274,210@9643L7397:StackComponentView.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(stackComponentState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                components2 = components;
                i3 |= composerStartRestartGroup.changed(components2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    stackComponentStyle2 = stackComponentStyle;
                    i3 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) != 0) {
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            f2 = f;
                            i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                        i4 = i2 & 64;
                        if (i4 != 0) {
                            i3 |= 1572864;
                            modifier2 = modifier;
                        } else {
                            modifier2 = modifier;
                            if ((i & 1572864) == 0) {
                                i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
                            }
                        }
                        if ((i3 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            companion = modifier2;
                        } else {
                            companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(770835511, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge (StackComponentView.kt:206)");
                            }
                            ShadowStyles shadow = stackComponentState.getShadow();
                            composerStartRestartGroup.startReplaceGroup(-2045176255);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9502L32");
                            ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            Shape shape = stackComponentState.getShape();
                            composerStartRestartGroup.startReplaceGroup(-2045174139);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(shape);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$composeShape$2$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final androidx.compose.ui.graphics.Shape invoke() {
                                        return ShapeKt.toShape(stackComponentState.getShape());
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            state = (State) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2045168779);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.StackWithLongEdgeToEdgeBadge$lambda$4(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(companion, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                            composerStartRestartGroup.startReplaceGroup(-2045160381);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChangedInstance = ((i3 & 14) != 4) | ((i3 & 112) != 32) | composerStartRestartGroup.changedInstance(function2) | ((458752 & i3) != 131072) | ((i3 & 896) != 256) | ((i3 & 7168) == 2048);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                final PaywallState.Loaded.Components components3 = components2;
                                final StackComponentStyle stackComponentStyle3 = stackComponentStyle2;
                                final boolean z3 = z2;
                                final float f3 = f2;
                                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m10568invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m10568invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long j) {
                                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                        final StackComponentState stackComponentState2 = stackComponentState;
                                        final PaywallState.Loaded.Components components4 = components3;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function22 = function2;
                                        final float f4 = f3;
                                        final Placeable placeableMo7769measureBRTryo0 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("stack", ComposableLambdaKt.composableLambdaInstance(-1349600991, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$stackMeasurable$1
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
                                                ComposerKt.sourceInformation(composer2, "C216@9891L187:StackComponentView.kt#280jdz");
                                                if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1349600991, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:216)");
                                                }
                                                StackComponentViewKt.MainStackComponent(stackComponentState2, components4, function22, f4, null, null, false, null, composer2, 1572864, WebmConstants.MkvEbmlElement.PIXEL_WIDTH);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        })))).mo7769measureBRTryo0(j);
                                        final StackComponentStyle stackComponentStyle4 = stackComponentStyle3;
                                        final PaywallState.Loaded.Components components5 = components3;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function2;
                                        final Placeable placeableMo7769measureBRTryo02 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("badge", ComposableLambdaKt.composableLambdaInstance(1484438374, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$badgeMeasurable$1
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
                                                ComposerKt.sourceInformation(composer2, "C228@10272L560:StackComponentView.kt#280jdz");
                                                if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1484438374, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:228)");
                                                }
                                                StackComponentViewKt.StackComponentView(StackComponentStyle.m10589copyh6c5tkY$default(stackComponentStyle4, null, null, false, new Size(SizeConstraint.Fill.INSTANCE, stackComponentStyle4.getSize().getHeight()), 0.0f, null, null, PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776535, null), components5, function23, null, 0.0f, composer2, 0, 24);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        })))).mo7769measureBRTryo0(j);
                                        int height = placeableMo7769measureBRTryo02.getHeight();
                                        int width = placeableMo7769measureBRTryo0.getWidth();
                                        int height2 = placeableMo7769measureBRTryo0.getHeight() + height;
                                        final StackComponentStyle stackComponentStyle5 = stackComponentStyle3;
                                        final StackComponentState stackComponentState3 = stackComponentState;
                                        final boolean z4 = z3;
                                        final Placeable placeableMo7769measureBRTryo03 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("background", ComposableLambdaKt.composableLambdaInstance(-1688443959, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1
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
                                                RoundedCornerShape roundedCornerShape;
                                                androidx.compose.ui.graphics.Shape rectangleShape;
                                                final RoundedCornerShape rectangleShape2;
                                                RoundedCornerShape roundedCornerShape2;
                                                ComposerKt.sourceInformation(composer2, "C318@15563L399,326@15976L136:StackComponentView.kt#280jdz");
                                                if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1688443959, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:250)");
                                                }
                                                BackgroundStyles background = stackComponentStyle5.getBackground();
                                                composer2.startReplaceGroup(-712011994);
                                                ComposerKt.sourceInformation(composer2, "*250@11285L40");
                                                BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composer2, 0);
                                                composer2.endReplaceGroup();
                                                BorderStyles border = stackComponentStyle5.getBorder();
                                                composer2.startReplaceGroup(-712008866);
                                                ComposerKt.sourceInformation(composer2, "*251@11383L32");
                                                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composer2, 0);
                                                composer2.endReplaceGroup();
                                                ShadowStyles shadow2 = stackComponentStyle5.getShadow();
                                                composer2.startReplaceGroup(-712005986);
                                                ComposerKt.sourceInformation(composer2, "*252@11473L32");
                                                ShadowStyle shadowStyleRememberShadowStyle2 = shadow2 == null ? null : ShadowStyleKt.rememberShadowStyle(shadow2, composer2, 0);
                                                composer2.endReplaceGroup();
                                                CornerRadiuses cornerRadiuses = stackComponentStyle5.getShape().getCornerRadiuses();
                                                if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
                                                    composer2.startReplaceGroup(-597140764);
                                                    ComposerKt.sourceInformation(composer2, "*257@11901L7,258@12010L7,259@12125L7,260@12244L7");
                                                    androidx.compose.ui.graphics.Shape shape2 = ShapeKt.toShape(stackComponentStyle5.getShape());
                                                    RoundedCornerShape roundedCornerShape3 = shape2 instanceof RoundedCornerShape ? (RoundedCornerShape) shape2 : null;
                                                    if (roundedCornerShape3 == null) {
                                                        roundedCornerShape2 = null;
                                                    } else {
                                                        Placeable placeable = placeableMo7769measureBRTryo0;
                                                        CornerSize topStart = roundedCornerShape3.getTopStart();
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer2.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        CornerSize cornerSizeMakeAbsolute = StackComponentViewKt.makeAbsolute(topStart, placeable, (Density) objConsume);
                                                        CornerSize topEnd = roundedCornerShape3.getTopEnd();
                                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer2.consume(localDensity2);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        CornerSize cornerSizeMakeAbsolute2 = StackComponentViewKt.makeAbsolute(topEnd, placeable, (Density) objConsume2);
                                                        CornerSize bottomEnd = roundedCornerShape3.getBottomEnd();
                                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer2.consume(localDensity3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        CornerSize cornerSizeMakeAbsolute3 = StackComponentViewKt.makeAbsolute(bottomEnd, placeable, (Density) objConsume3);
                                                        CornerSize bottomStart = roundedCornerShape3.getBottomStart();
                                                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object objConsume4 = composer2.consume(localDensity4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        roundedCornerShape2 = new RoundedCornerShape(cornerSizeMakeAbsolute, cornerSizeMakeAbsolute2, cornerSizeMakeAbsolute3, StackComponentViewKt.makeAbsolute(bottomStart, placeable, (Density) objConsume4));
                                                    }
                                                    rectangleShape2 = roundedCornerShape2 != null ? roundedCornerShape2 : RectangleShapeKt.getRectangleShape();
                                                    composer2.endReplaceGroup();
                                                } else {
                                                    if (!(cornerRadiuses instanceof CornerRadiuses.Dp)) {
                                                        composer2.startReplaceGroup(-712373002);
                                                        composer2.endReplaceGroup();
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    composer2.startReplaceGroup(-596348559);
                                                    ComposerKt.sourceInformation(composer2, "");
                                                    CornerRadiuses cornerRadiuses2 = stackComponentState3.getShape().getCornerRadiuses();
                                                    if (cornerRadiuses2 instanceof CornerRadiuses.Dp) {
                                                        if (z4) {
                                                            CornerRadiuses.Dp dp = (CornerRadiuses.Dp) cornerRadiuses;
                                                            CornerRadiuses.Dp dp2 = (CornerRadiuses.Dp) cornerRadiuses2;
                                                            rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.Dp(dp.getTopLeading(), dp.getTopTrailing(), dp2.getBottomLeading(), dp2.getBottomTrailing())));
                                                        } else {
                                                            CornerRadiuses.Dp dp3 = (CornerRadiuses.Dp) cornerRadiuses2;
                                                            CornerRadiuses.Dp dp4 = (CornerRadiuses.Dp) cornerRadiuses;
                                                            rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.Dp(dp3.getTopLeading(), dp3.getTopTrailing(), dp4.getBottomLeading(), dp4.getBottomTrailing())));
                                                        }
                                                    } else {
                                                        if (!(cornerRadiuses2 instanceof CornerRadiuses.Percentage)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        androidx.compose.ui.graphics.Shape shape3 = ShapeKt.toShape(stackComponentState3.getShape());
                                                        RoundedCornerShape roundedCornerShape4 = shape3 instanceof RoundedCornerShape ? (RoundedCornerShape) shape3 : null;
                                                        if (roundedCornerShape4 == null) {
                                                            roundedCornerShape = null;
                                                        } else {
                                                            boolean z5 = z4;
                                                            Placeable placeable2 = placeableMo7769measureBRTryo0;
                                                            if (z5) {
                                                                composer2.startReplaceGroup(-15494559);
                                                                ComposerKt.sourceInformation(composer2, "295@14318L7,299@14580L7");
                                                                CornerRadiuses.Dp dp5 = (CornerRadiuses.Dp) cornerRadiuses;
                                                                CornerSize cornerSizeM2337CornerSize0680j_4 = CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp5.getTopLeading()));
                                                                CornerSize cornerSizeM2337CornerSize0680j_42 = CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp5.getTopTrailing()));
                                                                CornerSize bottomEnd2 = roundedCornerShape4.getBottomEnd();
                                                                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                Object objConsume5 = composer2.consume(localDensity5);
                                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                CornerSize cornerSizeMakeAbsolute4 = StackComponentViewKt.makeAbsolute(bottomEnd2, placeable2, (Density) objConsume5);
                                                                CornerSize bottomStart2 = roundedCornerShape4.getBottomStart();
                                                                ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                Object objConsume6 = composer2.consume(localDensity6);
                                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                roundedCornerShape = new RoundedCornerShape(cornerSizeM2337CornerSize0680j_4, cornerSizeM2337CornerSize0680j_42, cornerSizeMakeAbsolute4, StackComponentViewKt.makeAbsolute(bottomStart2, placeable2, (Density) objConsume6));
                                                                composer2.endReplaceGroup();
                                                            } else {
                                                                composer2.startReplaceGroup(-14655420);
                                                                ComposerKt.sourceInformation(composer2, "306@14971L7,308@15134L7");
                                                                CornerSize topStart2 = roundedCornerShape4.getTopStart();
                                                                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                Object objConsume7 = composer2.consume(localDensity7);
                                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                CornerSize cornerSizeMakeAbsolute5 = StackComponentViewKt.makeAbsolute(topStart2, placeable2, (Density) objConsume7);
                                                                CornerSize topEnd2 = roundedCornerShape4.getTopEnd();
                                                                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                Object objConsume8 = composer2.consume(localDensity8);
                                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                CornerRadiuses.Dp dp6 = (CornerRadiuses.Dp) cornerRadiuses;
                                                                roundedCornerShape = new RoundedCornerShape(cornerSizeMakeAbsolute5, StackComponentViewKt.makeAbsolute(topEnd2, placeable2, (Density) objConsume8), CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp6.getBottomTrailing())), CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp6.getBottomLeading())));
                                                                composer2.endReplaceGroup();
                                                            }
                                                        }
                                                        if (roundedCornerShape != null) {
                                                            rectangleShape2 = roundedCornerShape;
                                                            composer2.endReplaceGroup();
                                                        } else {
                                                            rectangleShape = RectangleShapeKt.getRectangleShape();
                                                        }
                                                    }
                                                    rectangleShape2 = rectangleShape;
                                                    composer2.endReplaceGroup();
                                                }
                                                composer2.startReplaceGroup(-711874555);
                                                ComposerKt.sourceInformation(composer2, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged3 = composer2.changed(shadowStyleRememberShadowStyle2) | composer2.changed(stackComponentStyle5) | composer2.changed(backgroundStyleRememberBackgroundStyle) | composer2.changed(borderStyleRememberBorderStyle);
                                                final StackComponentStyle stackComponentStyle6 = stackComponentStyle5;
                                                Object objRememberedValue4 = composer2.rememberedValue();
                                                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue4 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentStyle6.getMargin()), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$1
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(it, "it");
                                                            return BackgroundKt.background(applyIfNotNull, it, rectangleShape2);
                                                        }
                                                    }), rectangleShape2, new Function2<Modifier, androidx.compose.ui.graphics.Shape, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$2
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Modifier invoke(Modifier applyIfNotNull, androidx.compose.ui.graphics.Shape it) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(it, "it");
                                                            return ClipKt.clip(applyIfNotNull, it);
                                                        }
                                                    }), borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$3
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(it, "it");
                                                            return BorderKt.border(applyIfNotNull, it, ShapeKt.toShape(stackComponentStyle6.getShape()));
                                                        }
                                                    });
                                                    composer2.updateRememberedValue(objRememberedValue4);
                                                }
                                                composer2.endReplaceGroup();
                                                BoxKt.Box(androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then((Modifier) objRememberedValue4), composer2, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        })))).mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(width, height2));
                                        final boolean z5 = z3;
                                        return MeasureScope.layout$default(SubcomposeLayout, width, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1.1
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
                                            public final void invoke2(Placeable.PlacementScope layout) {
                                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo03, 0, 0, 0.0f, 4, null);
                                                if (z5) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo02, 0, 0, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo0, 0, placeableMo7769measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                    placeableMo7769measureBRTryo0.getHeight();
                                                    return;
                                                }
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo0, 0, 0, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo02, 0, placeableMo7769measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                placeableMo7769measureBRTryo02.getHeight();
                                            }
                                        }, 4, null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            SubcomposeLayoutKt.SubcomposeLayout(modifierApplyIfNotNull, (Function2) objRememberedValue3, composerStartRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = companion;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithLongEdgeToEdgeBadge.3
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
                                    StackComponentViewKt.StackWithLongEdgeToEdgeBadge(stackComponentState, components, stackComponentStyle, z, function2, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                    i4 = i2 & 64;
                    if (i4 != 0) {
                    }
                    if ((i3 & 599187) == 599186) {
                        if (i4 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ShadowStyles shadow2 = stackComponentState.getShadow();
                        composerStartRestartGroup.startReplaceGroup(-2045176255);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9502L32");
                        if (shadow2 != null) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Shape shape2 = stackComponentState.getShape();
                        composerStartRestartGroup.startReplaceGroup(-2045174139);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(shape2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$composeShape$2$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final androidx.compose.ui.graphics.Shape invoke() {
                                    return ShapeKt.toShape(stackComponentState.getShape());
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            state = (State) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2045168779);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.StackWithLongEdgeToEdgeBadge$lambda$4(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceGroup();
                                Modifier modifierApplyIfNotNull2 = ModifierExtensionsKt.applyIfNotNull(companion, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                                composerStartRestartGroup.startReplaceGroup(-2045160381);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChangedInstance = ((i3 & 14) != 4) | ((i3 & 112) != 32) | composerStartRestartGroup.changedInstance(function2) | ((458752 & i3) != 131072) | ((i3 & 896) != 256) | ((i3 & 7168) == 2048);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance) {
                                    final PaywallState.Loaded.Components components32 = components2;
                                    final StackComponentStyle stackComponentStyle32 = stackComponentStyle2;
                                    final boolean z32 = z2;
                                    final float f32 = f2;
                                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m10568invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m10568invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long j) {
                                            Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                            final StackComponentState stackComponentState2 = stackComponentState;
                                            final PaywallState.Loaded.Components components4 = components32;
                                            final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22 = function2;
                                            final float f4 = f32;
                                            final Placeable placeableMo7769measureBRTryo0 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("stack", ComposableLambdaKt.composableLambdaInstance(-1349600991, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$stackMeasurable$1
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
                                                    ComposerKt.sourceInformation(composer2, "C216@9891L187:StackComponentView.kt#280jdz");
                                                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1349600991, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:216)");
                                                    }
                                                    StackComponentViewKt.MainStackComponent(stackComponentState2, components4, function22, f4, null, null, false, null, composer2, 1572864, WebmConstants.MkvEbmlElement.PIXEL_WIDTH);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            })))).mo7769measureBRTryo0(j);
                                            final StackComponentStyle stackComponentStyle4 = stackComponentStyle32;
                                            final PaywallState.Loaded.Components components5 = components32;
                                            final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function2;
                                            final Placeable placeableMo7769measureBRTryo02 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("badge", ComposableLambdaKt.composableLambdaInstance(1484438374, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$badgeMeasurable$1
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
                                                    ComposerKt.sourceInformation(composer2, "C228@10272L560:StackComponentView.kt#280jdz");
                                                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1484438374, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:228)");
                                                    }
                                                    StackComponentViewKt.StackComponentView(StackComponentStyle.m10589copyh6c5tkY$default(stackComponentStyle4, null, null, false, new Size(SizeConstraint.Fill.INSTANCE, stackComponentStyle4.getSize().getHeight()), 0.0f, null, null, PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776535, null), components5, function23, null, 0.0f, composer2, 0, 24);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            })))).mo7769measureBRTryo0(j);
                                            int height = placeableMo7769measureBRTryo02.getHeight();
                                            int width = placeableMo7769measureBRTryo0.getWidth();
                                            int height2 = placeableMo7769measureBRTryo0.getHeight() + height;
                                            final StackComponentStyle stackComponentStyle5 = stackComponentStyle32;
                                            final StackComponentState stackComponentState3 = stackComponentState;
                                            final boolean z4 = z32;
                                            final Placeable placeableMo7769measureBRTryo03 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("background", ComposableLambdaKt.composableLambdaInstance(-1688443959, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1
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
                                                    RoundedCornerShape roundedCornerShape;
                                                    androidx.compose.ui.graphics.Shape rectangleShape;
                                                    final androidx.compose.ui.graphics.Shape rectangleShape2;
                                                    RoundedCornerShape roundedCornerShape2;
                                                    ComposerKt.sourceInformation(composer2, "C318@15563L399,326@15976L136:StackComponentView.kt#280jdz");
                                                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1688443959, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:250)");
                                                    }
                                                    BackgroundStyles background = stackComponentStyle5.getBackground();
                                                    composer2.startReplaceGroup(-712011994);
                                                    ComposerKt.sourceInformation(composer2, "*250@11285L40");
                                                    BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composer2, 0);
                                                    composer2.endReplaceGroup();
                                                    BorderStyles border = stackComponentStyle5.getBorder();
                                                    composer2.startReplaceGroup(-712008866);
                                                    ComposerKt.sourceInformation(composer2, "*251@11383L32");
                                                    BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composer2, 0);
                                                    composer2.endReplaceGroup();
                                                    ShadowStyles shadow22 = stackComponentStyle5.getShadow();
                                                    composer2.startReplaceGroup(-712005986);
                                                    ComposerKt.sourceInformation(composer2, "*252@11473L32");
                                                    ShadowStyle shadowStyleRememberShadowStyle2 = shadow22 == null ? null : ShadowStyleKt.rememberShadowStyle(shadow22, composer2, 0);
                                                    composer2.endReplaceGroup();
                                                    CornerRadiuses cornerRadiuses = stackComponentStyle5.getShape().getCornerRadiuses();
                                                    if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
                                                        composer2.startReplaceGroup(-597140764);
                                                        ComposerKt.sourceInformation(composer2, "*257@11901L7,258@12010L7,259@12125L7,260@12244L7");
                                                        androidx.compose.ui.graphics.Shape shape22 = ShapeKt.toShape(stackComponentStyle5.getShape());
                                                        RoundedCornerShape roundedCornerShape3 = shape22 instanceof RoundedCornerShape ? (RoundedCornerShape) shape22 : null;
                                                        if (roundedCornerShape3 == null) {
                                                            roundedCornerShape2 = null;
                                                        } else {
                                                            Placeable placeable = placeableMo7769measureBRTryo0;
                                                            CornerSize topStart = roundedCornerShape3.getTopStart();
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer2.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                                            CornerSize cornerSizeMakeAbsolute = StackComponentViewKt.makeAbsolute(topStart, placeable, (Density) objConsume);
                                                            CornerSize topEnd = roundedCornerShape3.getTopEnd();
                                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer2.consume(localDensity2);
                                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                                            CornerSize cornerSizeMakeAbsolute2 = StackComponentViewKt.makeAbsolute(topEnd, placeable, (Density) objConsume2);
                                                            CornerSize bottomEnd = roundedCornerShape3.getBottomEnd();
                                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer2.consume(localDensity3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                                            CornerSize cornerSizeMakeAbsolute3 = StackComponentViewKt.makeAbsolute(bottomEnd, placeable, (Density) objConsume3);
                                                            CornerSize bottomStart = roundedCornerShape3.getBottomStart();
                                                            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume4 = composer2.consume(localDensity4);
                                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                                            roundedCornerShape2 = new RoundedCornerShape(cornerSizeMakeAbsolute, cornerSizeMakeAbsolute2, cornerSizeMakeAbsolute3, StackComponentViewKt.makeAbsolute(bottomStart, placeable, (Density) objConsume4));
                                                        }
                                                        rectangleShape2 = roundedCornerShape2 != null ? roundedCornerShape2 : RectangleShapeKt.getRectangleShape();
                                                        composer2.endReplaceGroup();
                                                    } else {
                                                        if (!(cornerRadiuses instanceof CornerRadiuses.Dp)) {
                                                            composer2.startReplaceGroup(-712373002);
                                                            composer2.endReplaceGroup();
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        composer2.startReplaceGroup(-596348559);
                                                        ComposerKt.sourceInformation(composer2, "");
                                                        CornerRadiuses cornerRadiuses2 = stackComponentState3.getShape().getCornerRadiuses();
                                                        if (cornerRadiuses2 instanceof CornerRadiuses.Dp) {
                                                            if (z4) {
                                                                CornerRadiuses.Dp dp = (CornerRadiuses.Dp) cornerRadiuses;
                                                                CornerRadiuses.Dp dp2 = (CornerRadiuses.Dp) cornerRadiuses2;
                                                                rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.Dp(dp.getTopLeading(), dp.getTopTrailing(), dp2.getBottomLeading(), dp2.getBottomTrailing())));
                                                            } else {
                                                                CornerRadiuses.Dp dp3 = (CornerRadiuses.Dp) cornerRadiuses2;
                                                                CornerRadiuses.Dp dp4 = (CornerRadiuses.Dp) cornerRadiuses;
                                                                rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.Dp(dp3.getTopLeading(), dp3.getTopTrailing(), dp4.getBottomLeading(), dp4.getBottomTrailing())));
                                                            }
                                                        } else {
                                                            if (!(cornerRadiuses2 instanceof CornerRadiuses.Percentage)) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            androidx.compose.ui.graphics.Shape shape3 = ShapeKt.toShape(stackComponentState3.getShape());
                                                            RoundedCornerShape roundedCornerShape4 = shape3 instanceof RoundedCornerShape ? (RoundedCornerShape) shape3 : null;
                                                            if (roundedCornerShape4 == null) {
                                                                roundedCornerShape = null;
                                                            } else {
                                                                boolean z5 = z4;
                                                                Placeable placeable2 = placeableMo7769measureBRTryo0;
                                                                if (z5) {
                                                                    composer2.startReplaceGroup(-15494559);
                                                                    ComposerKt.sourceInformation(composer2, "295@14318L7,299@14580L7");
                                                                    CornerRadiuses.Dp dp5 = (CornerRadiuses.Dp) cornerRadiuses;
                                                                    CornerSize cornerSizeM2337CornerSize0680j_4 = CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp5.getTopLeading()));
                                                                    CornerSize cornerSizeM2337CornerSize0680j_42 = CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp5.getTopTrailing()));
                                                                    CornerSize bottomEnd2 = roundedCornerShape4.getBottomEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume5 = composer2.consume(localDensity5);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                    CornerSize cornerSizeMakeAbsolute4 = StackComponentViewKt.makeAbsolute(bottomEnd2, placeable2, (Density) objConsume5);
                                                                    CornerSize bottomStart2 = roundedCornerShape4.getBottomStart();
                                                                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume6 = composer2.consume(localDensity6);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                    roundedCornerShape = new RoundedCornerShape(cornerSizeM2337CornerSize0680j_4, cornerSizeM2337CornerSize0680j_42, cornerSizeMakeAbsolute4, StackComponentViewKt.makeAbsolute(bottomStart2, placeable2, (Density) objConsume6));
                                                                    composer2.endReplaceGroup();
                                                                } else {
                                                                    composer2.startReplaceGroup(-14655420);
                                                                    ComposerKt.sourceInformation(composer2, "306@14971L7,308@15134L7");
                                                                    CornerSize topStart2 = roundedCornerShape4.getTopStart();
                                                                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume7 = composer2.consume(localDensity7);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                    CornerSize cornerSizeMakeAbsolute5 = StackComponentViewKt.makeAbsolute(topStart2, placeable2, (Density) objConsume7);
                                                                    CornerSize topEnd2 = roundedCornerShape4.getTopEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume8 = composer2.consume(localDensity8);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                                                    CornerRadiuses.Dp dp6 = (CornerRadiuses.Dp) cornerRadiuses;
                                                                    roundedCornerShape = new RoundedCornerShape(cornerSizeMakeAbsolute5, StackComponentViewKt.makeAbsolute(topEnd2, placeable2, (Density) objConsume8), CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp6.getBottomTrailing())), CornerSizeKt.m2337CornerSize0680j_4(Dp.m9114constructorimpl((float) dp6.getBottomLeading())));
                                                                    composer2.endReplaceGroup();
                                                                }
                                                            }
                                                            if (roundedCornerShape != null) {
                                                                rectangleShape2 = roundedCornerShape;
                                                                composer2.endReplaceGroup();
                                                            } else {
                                                                rectangleShape = RectangleShapeKt.getRectangleShape();
                                                            }
                                                        }
                                                        rectangleShape2 = rectangleShape;
                                                        composer2.endReplaceGroup();
                                                    }
                                                    composer2.startReplaceGroup(-711874555);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):StackComponentView.kt#9igjgp");
                                                    boolean zChanged3 = composer2.changed(shadowStyleRememberShadowStyle2) | composer2.changed(stackComponentStyle5) | composer2.changed(backgroundStyleRememberBackgroundStyle) | composer2.changed(borderStyleRememberBorderStyle);
                                                    final StackComponentStyle stackComponentStyle6 = stackComponentStyle5;
                                                    Object objRememberedValue4 = composer2.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue4 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentStyle6.getMargin()), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$1
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return BackgroundKt.background(applyIfNotNull, it, rectangleShape2);
                                                            }
                                                        }), rectangleShape2, new Function2<Modifier, androidx.compose.ui.graphics.Shape, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$2
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, androidx.compose.ui.graphics.Shape it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return ClipKt.clip(applyIfNotNull, it);
                                                            }
                                                        }), borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$3
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return BorderKt.border(applyIfNotNull, it, ShapeKt.toShape(stackComponentStyle6.getShape()));
                                                            }
                                                        });
                                                        composer2.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    composer2.endReplaceGroup();
                                                    BoxKt.Box(androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then((Modifier) objRememberedValue4), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            })))).mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(width, height2));
                                            final boolean z5 = z32;
                                            return MeasureScope.layout$default(SubcomposeLayout, width, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1.1
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
                                                public final void invoke2(Placeable.PlacementScope layout) {
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo03, 0, 0, 0.0f, 4, null);
                                                    if (z5) {
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo02, 0, 0, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo0, 0, placeableMo7769measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                        placeableMo7769measureBRTryo0.getHeight();
                                                        return;
                                                    }
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo0, 0, 0, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo02, 0, placeableMo7769measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                    placeableMo7769measureBRTryo02.getHeight();
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    composerStartRestartGroup.endReplaceGroup();
                                    SubcomposeLayoutKt.SubcomposeLayout(modifierApplyIfNotNull2, (Function2) objRememberedValue3, composerStartRestartGroup, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                f2 = f;
                i4 = i2 & 64;
                if (i4 != 0) {
                }
                if ((i3 & 599187) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            stackComponentStyle2 = stackComponentStyle;
            if ((i2 & 8) != 0) {
            }
            z2 = z;
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            f2 = f;
            i4 = i2 & 64;
            if (i4 != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        components2 = components;
        if ((i2 & 4) == 0) {
        }
        stackComponentStyle2 = stackComponentStyle;
        if ((i2 & 8) != 0) {
        }
        z2 = z;
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        f2 = f;
        i4 = i2 & 64;
        if (i4 != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.graphics.Shape StackWithLongEdgeToEdgeBadge$lambda$4(State<? extends androidx.compose.ui.graphics.Shape> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithOverlaidBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final TwoDimensionalAlignment twoDimensionalAlignment, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        StackComponentState stackComponentState2;
        int i3;
        PaywallState.Loaded.Components components2;
        StackComponentStyle stackComponentStyle2;
        TwoDimensionalAlignment twoDimensionalAlignment2;
        Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        float f2;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(72931104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithOverlaidBadge)P(5,6,1)178@8551L422:StackComponentView.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            stackComponentState2 = stackComponentState;
        } else {
            stackComponentState2 = stackComponentState;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(stackComponentState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            components2 = components;
        } else {
            components2 = components;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(components2) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            stackComponentStyle2 = stackComponentStyle;
        } else {
            stackComponentStyle2 = stackComponentStyle;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            twoDimensionalAlignment2 = twoDimensionalAlignment;
        } else {
            twoDimensionalAlignment2 = twoDimensionalAlignment;
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(twoDimensionalAlignment2) ? 2048 : 1024;
            }
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
            function22 = function2;
        } else {
            function22 = function2;
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
        } else {
            f2 = f;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
            }
        }
        int i4 = i2 & 64;
        if (i4 == 0) {
            if ((1572864 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
            if ((599187 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(72931104, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithOverlaidBadge (StackComponentView.kt:177)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier4 = companion;
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2121111263, "C179@8586L65,*180@8707L7,183@8781L186:StackComponentView.kt#280jdz");
                int i5 = i3 >> 6;
                MainStackComponent(stackComponentState2, components2, function22, f2, null, null, false, null, composerStartRestartGroup, (i3 & 126) | (i5 & 896) | (i5 & 7168), 240);
                composerStartRestartGroup = composerStartRestartGroup;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                BorderStyles border = stackComponentState.getBorder();
                OverlaidBadge(boxScopeInstance, stackComponentStyle2, components, twoDimensionalAlignment2, border == null ? Float.valueOf(density.mo1624toPx0680j_4(border.m10523getWidthD9Ej5fM())) : null, PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), composerStartRestartGroup, ((i3 >> 3) & 112) | 6 | ((i3 << 3) & 896) | (i3 & 7168), 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithOverlaidBadge.2
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
                        StackComponentViewKt.StackWithOverlaidBadge(stackComponentState, components, stackComponentStyle, twoDimensionalAlignment, function2, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 1572864;
        modifier2 = modifier;
        if ((599187 & i3) == 599186) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier42 = companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2121111263, "C179@8586L65,*180@8707L7,183@8781L186:StackComponentView.kt#280jdz");
                int i52 = i3 >> 6;
                MainStackComponent(stackComponentState2, components2, function22, f2, null, null, false, null, composerStartRestartGroup, (i3 & 126) | (i52 & 896) | (i52 & 7168), 240);
                composerStartRestartGroup = composerStartRestartGroup;
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density2 = (Density) objConsume2;
                BorderStyles border2 = stackComponentState.getBorder();
                OverlaidBadge(boxScopeInstance2, stackComponentStyle2, components, twoDimensionalAlignment2, border2 == null ? Float.valueOf(density2.mo1624toPx0680j_4(border2.m10523getWidthD9Ej5fM())) : null, PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), composerStartRestartGroup, ((i3 >> 3) & 112) | 6 | ((i3 << 3) & 896) | (i3 & 7168), 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithShortEdgeToEdgeBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final TwoDimensionalAlignment twoDimensionalAlignment, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        StackComponentState stackComponentState2;
        int i3;
        final StackComponentStyle stackComponentStyle2;
        final TwoDimensionalAlignment twoDimensionalAlignment2;
        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        float f2;
        Modifier modifier2;
        CornerRadiuses cornerRadiuses;
        int i4;
        CornerRadiuses.Dp dp;
        CornerRadiuses.Dp dp2;
        Composer composer2;
        final Modifier modifier3;
        CornerRadiuses.Percentage percentage;
        CornerRadiuses.Percentage percentage2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2026122355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithShortEdgeToEdgeBadge)P(5,6,1)440@20215L232,440@20139L308:StackComponentView.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            stackComponentState2 = stackComponentState;
        } else {
            stackComponentState2 = stackComponentState;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(stackComponentState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(components) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            stackComponentStyle2 = stackComponentStyle;
        } else {
            stackComponentStyle2 = stackComponentStyle;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            twoDimensionalAlignment2 = twoDimensionalAlignment;
        } else {
            twoDimensionalAlignment2 = twoDimensionalAlignment;
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(twoDimensionalAlignment2) ? 2048 : 1024;
            }
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
            function22 = function2;
        } else {
            function22 = function2;
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
        } else {
            f2 = f;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
            }
        }
        int i5 = i2 & 64;
        if (i5 == 0) {
            if ((1572864 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
            if ((599187 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2026122355, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge (StackComponentView.kt:370)");
                }
                cornerRadiuses = stackComponentStyle2.getShape().getCornerRadiuses();
                if (!(cornerRadiuses instanceof CornerRadiuses.Percentage)) {
                    int i6 = WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment2.ordinal()];
                    if (i6 == 3) {
                        percentage = new CornerRadiuses.Percentage(0, 0, 0, ((CornerRadiuses.Percentage) cornerRadiuses).getBottomTrailing());
                    } else if (i6 == 4) {
                        percentage = new CornerRadiuses.Percentage(0, 0, ((CornerRadiuses.Percentage) cornerRadiuses).getBottomLeading(), 0);
                    } else if (i6 == 5) {
                        percentage = new CornerRadiuses.Percentage(0, ((CornerRadiuses.Percentage) cornerRadiuses).getTopTrailing(), 0, 0);
                    } else if (i6 != 6) {
                        percentage2 = new CornerRadiuses.Percentage(0);
                        dp2 = percentage2;
                        i4 = 6;
                    } else {
                        percentage = new CornerRadiuses.Percentage(((CornerRadiuses.Percentage) cornerRadiuses).getTopLeading(), 0, 0, 0);
                    }
                    percentage2 = percentage;
                    dp2 = percentage2;
                    i4 = 6;
                } else {
                    if (!(cornerRadiuses instanceof CornerRadiuses.Dp)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    int i7 = WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment2.ordinal()];
                    if (i7 == 3) {
                        i4 = 6;
                        dp = new CornerRadiuses.Dp(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, ((CornerRadiuses.Dp) cornerRadiuses).getBottomTrailing());
                    } else if (i7 == 4) {
                        i4 = 6;
                        dp = new CornerRadiuses.Dp(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, ((CornerRadiuses.Dp) cornerRadiuses).getBottomLeading(), AudioStats.AUDIO_AMPLITUDE_NONE);
                    } else if (i7 != 5) {
                        i4 = 6;
                        dp = i7 != 6 ? new CornerRadiuses.Dp(AudioStats.AUDIO_AMPLITUDE_NONE) : new CornerRadiuses.Dp(((CornerRadiuses.Dp) cornerRadiuses).getTopLeading(), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
                    } else {
                        i4 = 6;
                        dp = new CornerRadiuses.Dp(AudioStats.AUDIO_AMPLITUDE_NONE, ((CornerRadiuses.Dp) cornerRadiuses).getTopTrailing(), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
                    }
                    dp2 = dp;
                }
                final CornerRadiuses cornerRadiuses2 = dp2;
                int i8 = (i3 & 14) | 12582912 | (i3 & 112);
                int i9 = i3 >> i4;
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = companion;
                MainStackComponent(stackComponentState2, components, function2, f2, modifier4, null, false, ComposableLambdaKt.rememberComposableLambda(-1023039340, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                        invoke(boxScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxScope MainStackComponent, Composer composer3, int i10) {
                        int i11;
                        Intrinsics.checkNotNullParameter(MainStackComponent, "$this$MainStackComponent");
                        ComposerKt.sourceInformation(composer3, "C441@20225L216:StackComponentView.kt#280jdz");
                        if ((i10 & 6) == 0) {
                            i11 = i10 | (composer3.changed(MainStackComponent) ? 4 : 2);
                        } else {
                            i11 = i10;
                        }
                        if ((i11 & 19) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1023039340, i11, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge.<anonymous> (StackComponentView.kt:441)");
                        }
                        StackComponentViewKt.StackComponentView(StackComponentStyle.m10589copyh6c5tkY$default(stackComponentStyle2, null, null, false, null, 0.0f, null, null, null, new Shape.Rectangle(cornerRadiuses2), null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776959, null), components, function22, MainStackComponent.align(Modifier.INSTANCE, AlignmentKt.toAlignment(twoDimensionalAlignment2)), 0.0f, composer3, 0, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, i8 | (i9 & 896) | (i9 & 7168) | (i9 & 57344), 96);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.2
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

                    public final void invoke(Composer composer3, int i10) {
                        StackComponentViewKt.StackWithShortEdgeToEdgeBadge(stackComponentState, components, stackComponentStyle, twoDimensionalAlignment, function2, f, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 1572864;
        modifier2 = modifier;
        if ((599187 & i3) == 599186) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            cornerRadiuses = stackComponentStyle2.getShape().getCornerRadiuses();
            if (!(cornerRadiuses instanceof CornerRadiuses.Percentage)) {
            }
            final CornerRadiuses cornerRadiuses22 = dp2;
            int i82 = (i3 & 14) | 12582912 | (i3 & 112);
            int i92 = i3 >> i4;
            composer2 = composerStartRestartGroup;
            Modifier modifier42 = companion;
            MainStackComponent(stackComponentState2, components, function2, f2, modifier42, null, false, ComposableLambdaKt.rememberComposableLambda(-1023039340, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                    invoke(boxScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope MainStackComponent, Composer composer3, int i10) {
                    int i11;
                    Intrinsics.checkNotNullParameter(MainStackComponent, "$this$MainStackComponent");
                    ComposerKt.sourceInformation(composer3, "C441@20225L216:StackComponentView.kt#280jdz");
                    if ((i10 & 6) == 0) {
                        i11 = i10 | (composer3.changed(MainStackComponent) ? 4 : 2);
                    } else {
                        i11 = i10;
                    }
                    if ((i11 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1023039340, i11, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge.<anonymous> (StackComponentView.kt:441)");
                    }
                    StackComponentViewKt.StackComponentView(StackComponentStyle.m10589copyh6c5tkY$default(stackComponentStyle2, null, null, false, null, 0.0f, null, null, null, new Shape.Rectangle(cornerRadiuses22), null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776959, null), components, function22, MainStackComponent.align(Modifier.INSTANCE, AlignmentKt.toAlignment(twoDimensionalAlignment2)), 0.0f, composer3, 0, 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, i82 | (i92 & 896) | (i92 & 7168) | (i92 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOverlaidBadgeOffsetY(int i, TwoDimensionalAlignment twoDimensionalAlignment, float f) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return MathKt.roundToInt(-((i - f) / 2.0f));
            case 2:
            case 5:
            case 6:
                return MathKt.roundToInt((i - f) / 2.0f);
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ int getOverlaidBadgeOffsetY$default(int i, TwoDimensionalAlignment twoDimensionalAlignment, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        return getOverlaidBadgeOffsetY(i, twoDimensionalAlignment, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShouldIgnoreTopWindowInsets(ComponentStyle componentStyle) {
        if (componentStyle instanceof ImageComponentStyle) {
            return ((ImageComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        if (componentStyle instanceof VideoComponentStyle) {
            return ((VideoComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        return false;
    }

    public static final boolean getUsesAllAvailableSpace(FlexDistribution flexDistribution) {
        Intrinsics.checkNotNullParameter(flexDistribution, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[flexDistribution.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier headerOrInsetsTopPadding(Modifier modifier, final PaywallState.Loaded.Components components, final int i) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m10569invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m10569invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = components.getHeaderHeightPx() > 0 ? components.getHeaderHeightPx() : i;
                final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(ConstraintsKt.m9087offsetNN6EwU$default(j, 0, -headerHeightPx, 1, null));
                return MeasureScope.layout$default(layout, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1.1
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
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.place$default(layout2, placeableMo7769measureBRTryo0, 0, headerHeightPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    private static final boolean isTop(TwoDimensionalAlignment twoDimensionalAlignment) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return true;
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CornerSize makeAbsolute(CornerSize cornerSize, Placeable placeable, Density density) {
        return m10566makeAbsolute12SF9DM(cornerSize, androidx.compose.ui.geometry.SizeKt.Size(placeable.getWidth(), placeable.getHeight()), density);
    }

    /* JADX INFO: renamed from: makeAbsolute-12SF9DM, reason: not valid java name */
    private static final CornerSize m10566makeAbsolute12SF9DM(CornerSize cornerSize, long j, Density density) {
        return CornerSizeKt.CornerSize(cornerSize.mo2336toPxTmRCtEA(j, density));
    }

    private static final BadgeStyle previewBadge(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2) {
        return new BadgeStyle(new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Badge", null, 0, null, null, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63998, null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(0.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(45.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6356getGreen0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6363getYellow0d7_KjU()), 80.0f)}))), null, 2, null))), paddingValues, paddingValues2, shape, null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), style, twoDimensionalAlignment);
    }

    static /* synthetic */ BadgeStyle previewBadge$default(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2, int i, Object obj) {
        if ((i & 8) != 0) {
            paddingValues = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
        }
        if ((i & 16) != 0) {
            paddingValues2 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
        }
        return previewBadge(style, twoDimensionalAlignment, shape, paddingValues, paddingValues2);
    }

    private static final List<TextComponentStyle> previewChildren(Composer composer, int i) {
        composer.startReplaceGroup(-407337990);
        ComposerKt.sourceInformation(composer, "C(previewChildren):StackComponentView.kt#280jdz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-407337990, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.previewChildren (StackComponentView.kt:1705)");
        }
        List<TextComponentStyle> listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null)});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return listListOf;
    }
}
