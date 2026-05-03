package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarMonth.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"CalendarMonth", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getCalendarMonth", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_Calendar_month", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CalendarMonthKt {
    private static ImageVector _Calendar_month;

    public static final ImageVector getCalendarMonth() {
        ImageVector imageVector = _Calendar_month;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("CalendarMonth", Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(24.0f), 960.0f, 960.0f, 0L, 0, false, WebmConstants.MkvEbmlElement.VIDEO, null);
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
        int iM6699getButtKaPHkGw = StrokeCap.INSTANCE.m6699getButtKaPHkGw();
        int iM6710getMiterLxFBmk8 = StrokeJoin.INSTANCE.m6710getMiterLxFBmk8();
        int iM6622getNonZeroRgk1Os = PathFillType.INSTANCE.m6622getNonZeroRgk1Os();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(200.0f, 880.0f);
        pathBuilder.quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f);
        pathBuilder.reflectiveQuadTo(120.0f, 800.0f);
        pathBuilder.verticalLineToRelative(-560.0f);
        pathBuilder.quadToRelative(0.0f, -33.0f, 23.5f, -56.5f);
        pathBuilder.reflectiveQuadTo(200.0f, 160.0f);
        pathBuilder.horizontalLineToRelative(40.0f);
        pathBuilder.verticalLineToRelative(-80.0f);
        pathBuilder.horizontalLineToRelative(80.0f);
        pathBuilder.verticalLineToRelative(80.0f);
        pathBuilder.horizontalLineToRelative(320.0f);
        pathBuilder.verticalLineToRelative(-80.0f);
        pathBuilder.horizontalLineToRelative(80.0f);
        pathBuilder.verticalLineToRelative(80.0f);
        pathBuilder.horizontalLineToRelative(40.0f);
        pathBuilder.quadToRelative(33.0f, 0.0f, 56.5f, 23.5f);
        pathBuilder.reflectiveQuadTo(840.0f, 240.0f);
        pathBuilder.verticalLineToRelative(560.0f);
        pathBuilder.quadToRelative(0.0f, 33.0f, -23.5f, 56.5f);
        pathBuilder.reflectiveQuadTo(760.0f, 880.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(0.0f, -80.0f);
        pathBuilder.horizontalLineToRelative(560.0f);
        pathBuilder.verticalLineToRelative(-400.0f);
        pathBuilder.horizontalLineTo(200.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(0.0f, -480.0f);
        pathBuilder.horizontalLineToRelative(560.0f);
        pathBuilder.verticalLineToRelative(-80.0f);
        pathBuilder.horizontalLineTo(200.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(0.0f, 0.0f);
        pathBuilder.verticalLineToRelative(-80.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(280.0f, 240.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(440.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 480.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(520.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 560.0f);
        pathBuilder.moveToRelative(-160.0f, 0.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(280.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(320.0f, 480.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(360.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(320.0f, 560.0f);
        pathBuilder.moveToRelative(320.0f, 0.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(600.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(640.0f, 480.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(680.0f, 520.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(640.0f, 560.0f);
        pathBuilder.moveTo(480.0f, 720.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(440.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 640.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(520.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 720.0f);
        pathBuilder.moveToRelative(-160.0f, 0.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(280.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(320.0f, 640.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(360.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(320.0f, 720.0f);
        pathBuilder.moveToRelative(320.0f, 0.0f);
        pathBuilder.quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.reflectiveQuadTo(600.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(11.5f, -28.5f);
        pathBuilder.reflectiveQuadTo(640.0f, 640.0f);
        pathBuilder.reflectiveQuadToRelative(28.5f, 11.5f);
        pathBuilder.reflectiveQuadTo(680.0f, 680.0f);
        pathBuilder.reflectiveQuadToRelative(-11.5f, 28.5f);
        pathBuilder.reflectiveQuadTo(640.0f, 720.0f);
        ImageVector.Builder.m7056addPathoIyEayM$default(builder, pathBuilder.getNodes(), iM6622getNonZeroRgk1Os, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM6699getButtKaPHkGw, iM6710getMiterLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        ImageVector imageVectorBuild = builder.build();
        _Calendar_month = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
