package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aX\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ah\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a.\u0010 \u001a\u00020!*\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0%¢\u0006\u0002\b&H\u0082\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"rememberPlaceholder", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "visible", "", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "highlight", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;", "placeholderFadeTransitionSpec", "Lkotlin/Function0;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "contentFadeTransitionSpec", "rememberPlaceholder-OadGlvw", "(ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "drawPlaceholder", "Landroidx/compose/ui/graphics/Outline;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "progress", "lastOutline", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "drawPlaceholder-hpmOzss", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Shape;JLcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;FLandroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Size;)Landroidx/compose/ui/graphics/Outline;", "placeholder", "Landroidx/compose/ui/Modifier;", "placeholder-TgFrcIs", "(Landroidx/compose/ui/Modifier;ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "withLayer", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawPlaceholder-hpmOzss, reason: not valid java name */
    public static final Outline m10660drawPlaceholderhpmOzss(DrawScope drawScope, Shape shape, long j, PlaceholderHighlight placeholderHighlight, float f, Outline outline, LayoutDirection layoutDirection, Size size) {
        Outline outlineMo1539createOutlinePq9zytI = null;
        if (shape == RectangleShapeKt.getRectangleShape()) {
            DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
            if (placeholderHighlight != null) {
                DrawScope.m6892drawRectAsUm42w$default(drawScope, placeholderHighlight.mo10626brushd16Qtg0(f, drawScope.mo6899getSizeNHjbRc()), 0L, 0L, placeholderHighlight.alpha(f), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
            }
            return null;
        }
        if (Size.m6144equalsimpl(drawScope.mo6899getSizeNHjbRc(), size) && drawScope.getLayoutDirection() == layoutDirection) {
            outlineMo1539createOutlinePq9zytI = outline;
        }
        if (outlineMo1539createOutlinePq9zytI == null) {
            outlineMo1539createOutlinePq9zytI = shape.mo1539createOutlinePq9zytI(drawScope.mo6899getSizeNHjbRc(), drawScope.getLayoutDirection(), drawScope);
        }
        Outline outline2 = outlineMo1539createOutlinePq9zytI;
        OutlineKt.m6598drawOutlinewDX37Ww$default(drawScope, outline2, j, 0.0f, null, null, 0, 60, null);
        if (placeholderHighlight != null) {
            OutlineKt.m6596drawOutlinehn5TExg$default(drawScope, outline2, placeholderHighlight.mo10626brushd16Qtg0(f, drawScope.mo6899getSizeNHjbRc()), placeholderHighlight.alpha(f), null, null, 0, 56, null);
        }
        return outline2;
    }

    /* JADX INFO: renamed from: placeholder-TgFrcIs, reason: not valid java name */
    public static final Modifier m10661placeholderTgFrcIs(Modifier placeholder, boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> function0, Function0<? extends FiniteAnimationSpec<Float>> function02, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(placeholder, "$this$placeholder");
        composer.startReplaceGroup(828411458);
        ComposerKt.sourceInformation(composer, "C(placeholder)P(5,0:c#ui.graphics.Color,4,2,3)69@3041L264:Placeholder.kt#51odh9");
        if ((i2 & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        Shape shape2 = shape;
        PlaceholderHighlight placeholderHighlight2 = (i2 & 8) != 0 ? null : placeholderHighlight;
        Function0<? extends FiniteAnimationSpec<Float>> function03 = (i2 & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$placeholder$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function0;
        Function0<? extends FiniteAnimationSpec<Float>> function04 = (i2 & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$placeholder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function02;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(828411458, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.placeholder (Placeholder.kt:68)");
        }
        Modifier modifierThen = placeholder.then(new PlaceholderElement(m10662rememberPlaceholderOadGlvw(z, j, shape2, placeholderHighlight2, function03, function04, composer, (i >> 3) & 524286, 0)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: renamed from: rememberPlaceholder-OadGlvw, reason: not valid java name */
    public static final Placeholder m10662rememberPlaceholderOadGlvw(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> function0, Function0<? extends FiniteAnimationSpec<Float>> function02, Composer composer, int i, int i2) {
        composer.startReplaceGroup(1627318888);
        ComposerKt.sourceInformation(composer, "C(rememberPlaceholder)P(5,0:c#ui.graphics.Color,4,2,3)103@4498L432,116@4956L17,117@5013L156,117@4978L191:Placeholder.kt#51odh9");
        Shape rectangleShape = (i2 & 4) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        PlaceholderHighlight placeholderHighlight2 = (i2 & 8) != 0 ? null : placeholderHighlight;
        Function0<? extends FiniteAnimationSpec<Float>> function03 = (i2 & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function0;
        Function0<? extends FiniteAnimationSpec<Float>> function04 = (i2 & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function02;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1627318888, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.rememberPlaceholder (Placeholder.kt:102)");
        }
        Object[] objArr = {Boolean.valueOf(z), Color.m6315boximpl(j), rectangleShape, placeholderHighlight2, function03, function04};
        ComposerKt.sourceInformationMarkerStart(composer, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i3 = 0; i3 < 6; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Placeholder(z, j, rectangleShape, placeholderHighlight2, function03, function04, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Placeholder placeholder = (Placeholder) objRememberedValue;
        boolean zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composer, 0);
        composer.startReplaceGroup(653949553);
        ComposerKt.sourceInformation(composer, "CC(remember):Placeholder.kt#9igjgp");
        boolean zChanged2 = ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4) | composer.changed(zIsInPreviewMode) | composer.changed(placeholder);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new PlaceholderKt$rememberPlaceholder$3$1(z, zIsInPreviewMode, placeholder, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(placeholder, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return placeholder;
    }

    private static final void withLayer(DrawScope drawScope, Paint paint, Function1<? super DrawScope, Unit> function1) {
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        canvas.saveLayer(SizeKt.m6170toRectuvyYCjk(drawScope.mo6899getSizeNHjbRc()), paint);
        function1.invoke(drawScope);
        canvas.restore();
    }
}
