package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import android.graphics.BlurMaskFilter;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a&\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001\u001a:\u0010\u0015\u001a\u00020\t*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Shadow_Preview_Circle", "", "(Landroidx/compose/runtime/Composer;I)V", "Shadow_Preview_CircleAlpha", "Shadow_Preview_Gradient_CustomShape", "Shadow_Preview_Margin", "Shadow_Preview_Square", "Shadow_Preview_SquareAlpha", "addOutline", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "addOutline-0AR0LA0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Outline;J)V", "shadow", "Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyle;", "shape", "Landroidx/compose/ui/graphics/Shape;", "toPath", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "toPath-Xbl9iGQ", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/geometry/Offset;)Landroidx/compose/ui/graphics/Path;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ShadowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Circle(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1888265500);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_Circle)98@3815L587:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1888265500, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Circle (Shadow.kt:96)");
            }
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            Modifier modifierM2075requiredSize3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2075requiredSize3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 749773730, "C103@3944L452:Shadow.kt#pifk6e");
            Modifier modifierM2075requiredSize3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f));
            long jM10532constructorimpl = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl = Dp.m9114constructorimpl(5.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(5.0f);
            RoundedCornerShape roundedCornerShape = circleShape;
            BoxKt.Box(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2075requiredSize3ABfNKs2, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl), Dp.m9114constructorimpl(0.0f), fM9114constructorimpl, fM9114constructorimpl2, null), roundedCornerShape), Color.INSTANCE.m6359getRed0d7_KjU(), roundedCornerShape), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Circle.2
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
                    ShadowKt.Shadow_Preview_Circle(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_CircleAlpha(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(524710378);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_CircleAlpha)151@5224L606:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(524710378, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_CircleAlpha (Shadow.kt:149)");
            }
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            Modifier modifierM2075requiredSize3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2075requiredSize3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 520916493, "C156@5353L471:Shadow.kt#pifk6e");
            Modifier modifierM2075requiredSize3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f));
            long jM10532constructorimpl = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl = Dp.m9114constructorimpl(5.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(5.0f);
            RoundedCornerShape roundedCornerShape = circleShape;
            BoxKt.Box(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2075requiredSize3ABfNKs2, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl), Dp.m9114constructorimpl(0.0f), fM9114constructorimpl, fM9114constructorimpl2, null), roundedCornerShape), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6359getRed0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), roundedCornerShape), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_CircleAlpha.2
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
                    ShadowKt.Shadow_Preview_CircleAlpha(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Gradient_CustomShape(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2006972301);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_Gradient_CustomShape)205@6735L1531:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2006972301, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Gradient_CustomShape (Shadow.kt:203)");
            }
            RoundedCornerShape RoundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape(50);
            Modifier modifierM2075requiredSize3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2075requiredSize3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -357515743, "C241@8228L10,210@6864L1396:Shadow.kt#pifk6e");
            RoundedCornerShape roundedCornerShape = RoundedCornerShape;
            composer2 = composerStartRestartGroup;
            TextKt.m4286Text4IGK_g("GET UNLIMITED RGB", PaddingKt.m2038paddingVpY3zN4(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(Modifier.INSTANCE, new ShadowStyle(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6359getRed0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6356getGreen0d7_KjU()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6352getBlue0d7_KjU()), 90.0f)}))), Dp.m9114constructorimpl(9.5f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(6.0f), null), roundedCornerShape), Color.INSTANCE.m6351getBlack0d7_KjU(), roundedCornerShape), Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(16.0f)), Color.INSTANCE.m6362getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall(), composer2, 390, 0, 65528);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Gradient_CustomShape.2
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
                    ShadowKt.Shadow_Preview_Gradient_CustomShape(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Margin(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1769512070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_Margin)252@8485L1430:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1769512070, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Margin (Shadow.kt:249)");
            }
            PaddingValues paddingValuesM2033PaddingValuesa9UjIt4 = PaddingKt.m2033PaddingValuesa9UjIt4(Dp.m9114constructorimpl(8.0f), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(4.0f), Dp.m9114constructorimpl(24.0f));
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            Modifier modifierM2077requiredSizeVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m2077requiredSizeVpY3zN4(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f), Dp.m9114constructorimpl(200.0f));
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2077requiredSizeVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2085533302, "C258@8707L596,276@9313L596:Shadow.kt#pifk6e");
            Modifier modifierM2077requiredSizeVpY3zN42 = androidx.compose.foundation.layout.SizeKt.m2077requiredSizeVpY3zN4(PaddingKt.padding(Modifier.INSTANCE, paddingValuesM2033PaddingValuesa9UjIt4), Dp.m9114constructorimpl(50.0f), Dp.m9114constructorimpl(50.0f));
            long jM10532constructorimpl = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(5.0f);
            BoxKt.Box(PaddingKt.m2037padding3ABfNKs(androidx.compose.foundation.BorderKt.m1494borderxT4_qwU(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2077requiredSizeVpY3zN42, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl), Dp.m9114constructorimpl(20.0f), fM9114constructorimpl, fM9114constructorimpl2, null), rectangleShape), Color.INSTANCE.m6359getRed0d7_KjU(), rectangleShape), Dp.m9114constructorimpl(2.0f), Color.INSTANCE.m6352getBlue0d7_KjU(), rectangleShape), Dp.m9114constructorimpl(16.0f)), composerStartRestartGroup, 0);
            Modifier modifierM2077requiredSizeVpY3zN43 = androidx.compose.foundation.layout.SizeKt.m2077requiredSizeVpY3zN4(PaddingKt.padding(Modifier.INSTANCE, paddingValuesM2033PaddingValuesa9UjIt4), Dp.m9114constructorimpl(50.0f), Dp.m9114constructorimpl(50.0f));
            long jM10532constructorimpl2 = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl3 = Dp.m9114constructorimpl(0.0f);
            float fM9114constructorimpl4 = Dp.m9114constructorimpl(5.0f);
            BoxKt.Box(PaddingKt.m2037padding3ABfNKs(androidx.compose.foundation.BorderKt.m1494borderxT4_qwU(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2077requiredSizeVpY3zN43, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl2), Dp.m9114constructorimpl(20.0f), fM9114constructorimpl3, fM9114constructorimpl4, null), rectangleShape), Color.INSTANCE.m6359getRed0d7_KjU(), rectangleShape), Dp.m9114constructorimpl(2.0f), Color.INSTANCE.m6352getBlue0d7_KjU(), rectangleShape), Dp.m9114constructorimpl(16.0f)), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Margin.2
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
                    ShadowKt.Shadow_Preview_Margin(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Square(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1204850263);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_Square)125@4535L589:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1204850263, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Square (Shadow.kt:123)");
            }
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            Modifier modifierM2075requiredSize3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2075requiredSize3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -147838477, "C130@4664L454:Shadow.kt#pifk6e");
            Modifier modifierM2075requiredSize3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f));
            long jM10532constructorimpl = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl = Dp.m9114constructorimpl(10.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(5.0f);
            BoxKt.Box(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2075requiredSize3ABfNKs2, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl), Dp.m9114constructorimpl(20.0f), fM9114constructorimpl, fM9114constructorimpl2, null), rectangleShape), Color.INSTANCE.m6359getRed0d7_KjU(), rectangleShape), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Square.2
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
                    ShadowKt.Shadow_Preview_Square(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_SquareAlpha(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1511945597);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Shadow_Preview_SquareAlpha)178@5958L608:Shadow.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1511945597, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_SquareAlpha (Shadow.kt:176)");
            }
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            Modifier modifierM2075requiredSize3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2075requiredSize3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -453829032, "C183@6087L473:Shadow.kt#pifk6e");
            Modifier modifierM2075requiredSize3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f));
            long jM10532constructorimpl = ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU());
            float fM9114constructorimpl = Dp.m9114constructorimpl(10.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(5.0f);
            BoxKt.Box(androidx.compose.foundation.BackgroundKt.m1482backgroundbw27NRU(shadow(modifierM2075requiredSize3ABfNKs2, new ShadowStyle(ColorStyle.Solid.m10531boximpl(jM10532constructorimpl), Dp.m9114constructorimpl(20.0f), fM9114constructorimpl, fM9114constructorimpl2, null), rectangleShape), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6359getRed0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), rectangleShape), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_SquareAlpha.2
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
                    ShadowKt.Shadow_Preview_SquareAlpha(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: addOutline-0AR0LA0, reason: not valid java name */
    private static final void m10499addOutline0AR0LA0(Path path, Outline outline, long j) {
        if (outline instanceof Outline.Rectangle) {
            Path.addRect$default(path, ((Outline.Rectangle) outline).getRect().m6117translatek4lQ0M(j), null, 2, null);
        } else if (outline instanceof Outline.Rounded) {
            Path.addRoundRect$default(path, RoundRectKt.m6136translateUv8p0NA(((Outline.Rounded) outline).getRoundRect(), j), null, 2, null);
        } else if (outline instanceof Outline.Generic) {
            path.mo6212addPathUv8p0NA(((Outline.Generic) outline).getPath(), j);
        }
    }

    public static final /* synthetic */ Modifier shadow(Modifier modifier, final ShadowStyle shadow, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.drawBehind(modifier, new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.shadow.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                DrawScope drawScope = drawBehind;
                Path pathM10500toPathXbl9iGQ = ShadowKt.m10500toPathXbl9iGQ(shape, drawBehind.mo6899getSizeNHjbRc(), drawBehind.getLayoutDirection(), drawScope, Offset.m6069boximpl(OffsetKt.Offset(drawBehind.mo1624toPx0680j_4(shadow.m10551getXD9Ej5fM()), drawBehind.mo1624toPx0680j_4(shadow.m10552getYD9Ej5fM()))));
                Paint Paint = AndroidPaint_androidKt.Paint();
                ShadowStyle shadowStyle = shadow;
                ColorStyle color = shadowStyle.getColor();
                if (color instanceof ColorStyle.Solid) {
                    Paint.mo6201setColor8_81llA(((ColorStyle.Solid) shadowStyle.getColor()).m10538unboximpl());
                } else if (color instanceof ColorStyle.Gradient) {
                    ((ColorStyle.Gradient) shadowStyle.getColor()).m10530unboximpl().mo6270applyToPq9zytI(drawBehind.mo6899getSizeNHjbRc(), Paint, 1.0f);
                }
                if (!Dp.m9119equalsimpl0(shadowStyle.m10550getRadiusD9Ej5fM(), Dp.m9114constructorimpl(0.0f))) {
                    Paint.getInternalPaint().setMaskFilter(new BlurMaskFilter(drawBehind.mo1624toPx0680j_4(shadowStyle.m10550getRadiusD9Ej5fM()), BlurMaskFilter.Blur.NORMAL));
                }
                Shape shape2 = shape;
                Canvas canvas = drawBehind.getDrawContext().getCanvas();
                canvas.save();
                canvas.mo6174clipPathmtrdDE(ShadowKt.m10501toPathXbl9iGQ$default(shape2, drawBehind.mo6899getSizeNHjbRc(), drawBehind.getLayoutDirection(), drawScope, null, 8, null), ClipOp.INSTANCE.m6313getDifferencertfAjoo());
                canvas.drawPath(pathM10500toPathXbl9iGQ, Paint);
                canvas.restore();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toPath-Xbl9iGQ, reason: not valid java name */
    public static final Path m10500toPathXbl9iGQ(Shape shape, long j, LayoutDirection layoutDirection, Density density, Offset offset) {
        Outline outlineMo1539createOutlinePq9zytI = shape.mo1539createOutlinePq9zytI(j, layoutDirection, density);
        if (offset == null) {
            Path Path = AndroidPath_androidKt.Path();
            OutlineKt.addOutline(Path, outlineMo1539createOutlinePq9zytI);
            return Path;
        }
        Path Path2 = AndroidPath_androidKt.Path();
        m10499addOutline0AR0LA0(Path2, outlineMo1539createOutlinePq9zytI, offset.m6090unboximpl());
        return Path2;
    }

    /* JADX INFO: renamed from: toPath-Xbl9iGQ$default, reason: not valid java name */
    static /* synthetic */ Path m10501toPathXbl9iGQ$default(Shape shape, long j, LayoutDirection layoutDirection, Density density, Offset offset, int i, Object obj) {
        if ((i & 8) != 0) {
            offset = null;
        }
        return m10500toPathXbl9iGQ(shape, j, layoutDirection, density, offset);
    }
}
