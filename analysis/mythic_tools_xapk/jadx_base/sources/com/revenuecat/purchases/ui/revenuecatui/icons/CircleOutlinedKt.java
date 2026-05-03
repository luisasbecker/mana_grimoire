package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircleOutlined.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"CircleOutlined", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getCircleOutlined", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_circleOutlined", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CircleOutlinedKt {
    private static ImageVector _circleOutlined;

    public static final ImageVector getCircleOutlined() {
        ImageVector imageVector = _circleOutlined;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Circle", Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
        int iM6699getButtKaPHkGw = StrokeCap.INSTANCE.m6699getButtKaPHkGw();
        int iM6709getBevelLxFBmk8 = StrokeJoin.INSTANCE.m6709getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.curveTo(2.0f, 17.52f, 6.48f, 22.0f, 12.0f, 22.0f);
        pathBuilder.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
        pathBuilder.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 20.0f);
        pathBuilder.curveTo(7.58f, 20.0f, 4.0f, 16.42f, 4.0f, 12.0f);
        pathBuilder.curveTo(4.0f, 7.58f, 7.58f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveTo(16.42f, 4.0f, 20.0f, 7.58f, 20.0f, 12.0f);
        pathBuilder.curveTo(20.0f, 16.42f, 16.42f, 20.0f, 12.0f, 20.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m7056addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM6699getButtKaPHkGw, iM6709getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _circleOutlined = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
