package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AndroidOverscroll.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u0018\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u001a\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u001c\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J3\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002¢\u0006\u0004\b$\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/foundation/GlowOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Landroidx/compose/foundation/layout/PaddingValues;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawLeftGlow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawTopGlow", ViewHierarchyConstants.DIMENSION_TOP_KEY, "drawRightGlow", "right", "drawBottomGlow", "bottom", "drawWithRotationAndOffset", "rotationDegrees", "", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "edgeEffect", "drawWithRotationAndOffset-ubNVwUQ", "(FJLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GlowOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final PaddingValues glowDrawPadding;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public GlowOverscrollNode(DelegatableNode delegatableNode, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, PaddingValues paddingValues) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.glowDrawPadding = paddingValues;
        delegate(delegatableNode);
    }

    private final boolean drawBottomGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float f = drawScope.mo1624toPx0680j_4(this.glowDrawPadding.getBottom());
        float f2 = -Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32));
        float f3 = (-Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) + f;
        return m1538drawWithRotationAndOffsetubNVwUQ(180.0f, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), edgeEffect, canvas);
    }

    private final boolean drawLeftGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float f = -Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float f2 = drawScope.mo1624toPx0680j_4(this.glowDrawPadding.mo1987calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection()));
        return m1538drawWithRotationAndOffsetubNVwUQ(270.0f, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(f2)))), edgeEffect, canvas);
    }

    private final boolean drawRightGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m1538drawWithRotationAndOffsetubNVwUQ(90.0f, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((-MathKt.roundToInt(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) + drawScope.mo1624toPx0680j_4(this.glowDrawPadding.mo1988calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection())))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(0.0f) << 32)), edgeEffect, canvas);
    }

    private final boolean drawTopGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float f = drawScope.mo1624toPx0680j_4(this.glowDrawPadding.getTop());
        return m1538drawWithRotationAndOffsetubNVwUQ(0.0f, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), edgeEffect, canvas);
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    private final boolean m1538drawWithRotationAndOffsetubNVwUQ(float rotationDegrees, long offset, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(rotationDegrees);
        canvas.translate(Float.intBitsToFloat((int) (offset >> 32)), Float.intBitsToFloat((int) (offset & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        this.overscrollEffect.m1463updateSizeuvyYCjk$foundation(contentDrawScope.mo6899getSizeNHjbRc());
        if (Size.m6151isEmptyimpl(contentDrawScope.mo6899getSizeNHjbRc())) {
            contentDrawScope.drawContent();
            return;
        }
        contentDrawScope.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation().getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean zDrawLeftGlow = edgeEffectWrapper.isLeftAnimating() ? drawLeftGlow(contentDrawScope, edgeEffectWrapper.getOrCreateLeftEffect(), nativeCanvas) : false;
        if (edgeEffectWrapper.isTopAnimating()) {
            zDrawLeftGlow = drawTopGlow(contentDrawScope, edgeEffectWrapper.getOrCreateTopEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            zDrawLeftGlow = drawRightGlow(contentDrawScope, edgeEffectWrapper.getOrCreateRightEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            zDrawLeftGlow = drawBottomGlow(contentDrawScope, edgeEffectWrapper.getOrCreateBottomEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (zDrawLeftGlow) {
            this.overscrollEffect.invalidateOverscroll$foundation();
        }
    }
}
