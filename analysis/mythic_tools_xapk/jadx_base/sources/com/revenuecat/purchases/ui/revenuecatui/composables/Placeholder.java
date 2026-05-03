package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\u0016\u0010\u001f\u001a\u00020\u0005HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\t\u0010\"\u001a\u00020\u0007HÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÂ\u0003J\u0015\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÂ\u0003J\u0015\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÂ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\u0010\u0010-\u001a\u00020.H\u0080@¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020.H\u0080@¢\u0006\u0004\b2\u00100J\t\u00103\u001a\u000204HÖ\u0001J\u0011\u00105\u001a\u00020.*\u000206H\u0000¢\u0006\u0002\b7R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "", "visible", "", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "highlight", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;", "placeholderFadeTransitionSpec", "Lkotlin/Function0;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "contentFadeTransitionSpec", "(ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "contentAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "highlightProgress", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "paint", "Landroidx/compose/ui/graphics/Paint;", "placeholderAlpha", "component1", "component2", "component2-0d7_KjU", "()J", "component3", "component4", "component5", "component6", "copy", "copy-3IgeMak", "(ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "equals", "other", "hashCode", "", "startAnimation", "", "startAnimation$revenuecatui_defaultsBc8Release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAnimation", "stopAnimation$revenuecatui_defaultsBc8Release", InAppPurchaseConstants.METHOD_TO_STRING, "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Placeholder {
    public static final int $stable = 0;
    private final long color;
    private final Animatable<Float, AnimationVector1D> contentAlpha;
    private final Function0<FiniteAnimationSpec<Float>> contentFadeTransitionSpec;
    private final PlaceholderHighlight highlight;
    private final Animatable<Float, AnimationVector1D> highlightProgress;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;
    private final Paint paint;
    private final Animatable<Float, AnimationVector1D> placeholderAlpha;
    private final Function0<FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec;
    private final Shape shape;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    private Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec, Function0<? extends FiniteAnimationSpec<Float>> contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        this.visible = z;
        this.color = j;
        this.shape = shape;
        this.highlight = placeholderHighlight;
        this.placeholderFadeTransitionSpec = placeholderFadeTransitionSpec;
        this.contentFadeTransitionSpec = contentFadeTransitionSpec;
        this.placeholderAlpha = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
        this.contentAlpha = AnimatableKt.Animatable$default(z ? 0.0f : 1.0f, 0.0f, 2, null);
        this.highlightProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.setAntiAlias(true);
        Paint.mo6205setStylek9PVt8s(PaintingStyle.INSTANCE.m6606getFillTiuSbCo());
        Paint.mo6200setBlendModes9anfk8(Paint.get_blendMode());
        this.paint = Paint;
    }

    public /* synthetic */ Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, (i & 4) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i & 8) != 0 ? null : placeholderHighlight, (i & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function0, (i & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function02, null);
    }

    public /* synthetic */ Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, shape, placeholderHighlight, function0, function02);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    private final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final PlaceholderHighlight getHighlight() {
        return this.highlight;
    }

    private final Function0<FiniteAnimationSpec<Float>> component5() {
        return this.placeholderFadeTransitionSpec;
    }

    private final Function0<FiniteAnimationSpec<Float>> component6() {
        return this.contentFadeTransitionSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-3IgeMak$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m10657copy3IgeMak$default(Placeholder placeholder, boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            z = placeholder.visible;
        }
        if ((i & 2) != 0) {
            j = placeholder.color;
        }
        if ((i & 4) != 0) {
            shape = placeholder.shape;
        }
        if ((i & 8) != 0) {
            placeholderHighlight = placeholder.highlight;
        }
        if ((i & 16) != 0) {
            function0 = placeholder.placeholderFadeTransitionSpec;
        }
        if ((i & 32) != 0) {
            function02 = placeholder.contentFadeTransitionSpec;
        }
        return placeholder.m10658copy3IgeMak(z, j, shape, placeholderHighlight, function0, function02);
    }

    /* JADX INFO: renamed from: copy-3IgeMak, reason: not valid java name */
    public final Placeholder m10658copy3IgeMak(boolean visible, long color, Shape shape, PlaceholderHighlight highlight, Function0<? extends FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec, Function0<? extends FiniteAnimationSpec<Float>> contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        return new Placeholder(visible, color, shape, highlight, placeholderFadeTransitionSpec, contentFadeTransitionSpec, null);
    }

    public final void draw$revenuecatui_defaultsBc8Release(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float fFloatValue = this.placeholderAlpha.getValue().floatValue();
        float fFloatValue2 = this.contentAlpha.getValue().floatValue();
        if (fFloatValue2 > 0.01f) {
            this.paint.setAlpha(fFloatValue2);
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            Paint paint = this.paint;
            Canvas canvas = contentDrawScope2.getDrawContext().getCanvas();
            canvas.saveLayer(SizeKt.m6170toRectuvyYCjk(contentDrawScope2.mo6899getSizeNHjbRc()), paint);
            contentDrawScope.drawContent();
            canvas.restore();
        }
        if (fFloatValue > 0.01f) {
            this.paint.setAlpha(fFloatValue);
            ContentDrawScope contentDrawScope3 = contentDrawScope;
            Paint paint2 = this.paint;
            Canvas canvas2 = contentDrawScope3.getDrawContext().getCanvas();
            canvas2.saveLayer(SizeKt.m6170toRectuvyYCjk(contentDrawScope3.mo6899getSizeNHjbRc()), paint2);
            this.lastOutline = PlaceholderKt.m10660drawPlaceholderhpmOzss(contentDrawScope3, this.shape, this.color, this.highlight, this.highlightProgress.getValue().floatValue(), this.lastOutline, this.lastLayoutDirection, this.lastSize);
            canvas2.restore();
        }
        this.lastSize = Size.m6137boximpl(contentDrawScope.mo6899getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) other;
        return this.visible == placeholder.visible && Color.m6326equalsimpl0(this.color, placeholder.color) && Intrinsics.areEqual(this.shape, placeholder.shape) && Intrinsics.areEqual(this.highlight, placeholder.highlight) && Intrinsics.areEqual(this.placeholderFadeTransitionSpec, placeholder.placeholderFadeTransitionSpec) && Intrinsics.areEqual(this.contentFadeTransitionSpec, placeholder.contentFadeTransitionSpec);
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.visible) * 31) + Color.m6332hashCodeimpl(this.color)) * 31) + this.shape.hashCode()) * 31;
        PlaceholderHighlight placeholderHighlight = this.highlight;
        return ((((iHashCode + (placeholderHighlight == null ? 0 : placeholderHighlight.hashCode())) * 31) + this.placeholderFadeTransitionSpec.hashCode()) * 31) + this.contentFadeTransitionSpec.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x010b, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r4, r1, null, null, r8, 12, null) == r2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011f, code lost:
    
        if (r0.snapTo(r1, r8) == r2) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startAnimation$revenuecatui_defaultsBc8Release(Continuation<? super Unit> continuation) {
        Placeholder$startAnimation$1 placeholder$startAnimation$1;
        int i;
        Placeholder placeholder;
        Animatable<Float, AnimationVector1D> animatable;
        int i2;
        Placeholder placeholder2 = this;
        if (continuation instanceof Placeholder$startAnimation$1) {
            placeholder$startAnimation$1 = (Placeholder$startAnimation$1) continuation;
            if ((placeholder$startAnimation$1.label & Integer.MIN_VALUE) != 0) {
                placeholder$startAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                placeholder$startAnimation$1 = new Placeholder$startAnimation$1(placeholder2, continuation);
            }
        }
        Placeholder$startAnimation$1 placeholder$startAnimation$12 = placeholder$startAnimation$1;
        Object obj = placeholder$startAnimation$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = placeholder$startAnimation$12.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable2 = placeholder2.placeholderAlpha;
            Float fBoxFloat = Boxing.boxFloat(placeholder2.visible ? 1.0f : 0.0f);
            FiniteAnimationSpec<Float> finiteAnimationSpecInvoke = placeholder2.placeholderFadeTransitionSpec.invoke();
            placeholder$startAnimation$12.L$0 = placeholder2;
            placeholder$startAnimation$12.label = 1;
            i = 1;
            if (Animatable.animateTo$default(animatable2, fBoxFloat, finiteAnimationSpecInvoke, null, null, placeholder$startAnimation$12, 12, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                placeholder2 = (Placeholder) placeholder$startAnimation$12.L$0;
                ResultKt.throwOnFailure(obj);
                i = 1;
                placeholder = placeholder2;
                if (placeholder.visible) {
                    PlaceholderHighlight placeholderHighlight = placeholder.highlight;
                    int i4 = (placeholderHighlight != null ? placeholderHighlight.getAnimationSpec() : null) != null ? i : 0;
                    animatable = placeholder.highlightProgress;
                    placeholder$startAnimation$12.L$0 = placeholder;
                    placeholder$startAnimation$12.I$0 = i4;
                    placeholder$startAnimation$12.label = 3;
                    if (animatable.stop(placeholder$startAnimation$12) != coroutine_suspended) {
                        i2 = i4;
                        if (i2 == 0) {
                        }
                    }
                    return coroutine_suspended;
                }
                animatable = placeholder.highlightProgress;
                placeholder$startAnimation$12.L$0 = placeholder;
                placeholder$startAnimation$12.I$0 = i4;
                placeholder$startAnimation$12.label = 3;
                if (animatable.stop(placeholder$startAnimation$12) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i2 = placeholder$startAnimation$12.I$0;
            placeholder = (Placeholder) placeholder$startAnimation$12.L$0;
            ResultKt.throwOnFailure(obj);
            if (i2 == 0) {
                Animatable<Float, AnimationVector1D> animatable3 = placeholder.highlightProgress;
                Float fBoxFloat2 = Boxing.boxFloat(1.0f);
                PlaceholderHighlight placeholderHighlight2 = placeholder.highlight;
                Intrinsics.checkNotNull(placeholderHighlight2);
                InfiniteRepeatableSpec<Float> animationSpec = placeholderHighlight2.getAnimationSpec();
                Intrinsics.checkNotNull(animationSpec);
                placeholder$startAnimation$12.L$0 = null;
                placeholder$startAnimation$12.label = 4;
            } else {
                Animatable<Float, AnimationVector1D> animatable4 = placeholder.highlightProgress;
                Float fBoxFloat3 = Boxing.boxFloat(0.0f);
                placeholder$startAnimation$12.L$0 = null;
                placeholder$startAnimation$12.label = 5;
            }
            return coroutine_suspended;
        }
        placeholder2 = (Placeholder) placeholder$startAnimation$12.L$0;
        ResultKt.throwOnFailure(obj);
        i = 1;
        Animatable<Float, AnimationVector1D> animatable5 = placeholder2.contentAlpha;
        Float fBoxFloat4 = Boxing.boxFloat(placeholder2.visible ? 0.0f : 1.0f);
        FiniteAnimationSpec<Float> finiteAnimationSpecInvoke2 = placeholder2.contentFadeTransitionSpec.invoke();
        placeholder$startAnimation$12.L$0 = placeholder2;
        placeholder$startAnimation$12.label = 2;
        if (Animatable.animateTo$default(animatable5, fBoxFloat4, finiteAnimationSpecInvoke2, null, null, placeholder$startAnimation$12, 12, null) != coroutine_suspended) {
            placeholder = placeholder2;
            if (placeholder.visible) {
            }
            animatable = placeholder.highlightProgress;
            placeholder$startAnimation$12.L$0 = placeholder;
            placeholder$startAnimation$12.I$0 = i4;
            placeholder$startAnimation$12.label = 3;
            if (animatable.stop(placeholder$startAnimation$12) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r6.stop(r0) != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopAnimation$revenuecatui_defaultsBc8Release(Continuation<? super Unit> continuation) {
        Placeholder$stopAnimation$1 placeholder$stopAnimation$1;
        if (continuation instanceof Placeholder$stopAnimation$1) {
            placeholder$stopAnimation$1 = (Placeholder$stopAnimation$1) continuation;
            if ((placeholder$stopAnimation$1.label & Integer.MIN_VALUE) != 0) {
                placeholder$stopAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                placeholder$stopAnimation$1 = new Placeholder$stopAnimation$1(this, continuation);
            }
        }
        Object obj = placeholder$stopAnimation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = placeholder$stopAnimation$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.placeholderAlpha;
            placeholder$stopAnimation$1.L$0 = this;
            placeholder$stopAnimation$1.label = 1;
            if (animatable.stop(placeholder$stopAnimation$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            this = (Placeholder) placeholder$stopAnimation$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            this = (Placeholder) placeholder$stopAnimation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable2 = this.highlightProgress;
            placeholder$stopAnimation$1.L$0 = null;
            placeholder$stopAnimation$1.label = 3;
        }
        Animatable<Float, AnimationVector1D> animatable3 = this.contentAlpha;
        placeholder$stopAnimation$1.L$0 = this;
        placeholder$stopAnimation$1.label = 2;
        if (animatable3.stop(placeholder$stopAnimation$1) != coroutine_suspended) {
            Animatable<Float, AnimationVector1D> animatable22 = this.highlightProgress;
            placeholder$stopAnimation$1.L$0 = null;
            placeholder$stopAnimation$1.label = 3;
        }
        return coroutine_suspended;
    }

    public String toString() {
        return "Placeholder(visible=" + this.visible + ", color=" + ((Object) Color.m6333toStringimpl(this.color)) + ", shape=" + this.shape + ", highlight=" + this.highlight + ", placeholderFadeTransitionSpec=" + this.placeholderFadeTransitionSpec + ", contentFadeTransitionSpec=" + this.contentFadeTransitionSpec + ')';
    }
}
