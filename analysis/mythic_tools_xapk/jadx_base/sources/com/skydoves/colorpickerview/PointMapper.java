package com.skydoves.colorpickerview;

import android.graphics.Color;
import android.graphics.Point;

/* JADX INFO: loaded from: classes6.dex */
class PointMapper {
    private PointMapper() {
    }

    private static Point approximatedPoint(ColorPickerView colorPickerView, Point point, Point point2) {
        if (getDistance(point, point2) <= 3) {
            return point2;
        }
        Point centerPoint = getCenterPoint(point, point2);
        return Color.alpha(colorPickerView.getColorFromBitmap((float) centerPoint.x, (float) centerPoint.y)) == 0 ? approximatedPoint(colorPickerView, centerPoint, point2) : approximatedPoint(colorPickerView, point, centerPoint);
    }

    private static Point getCenterPoint(Point point, Point point2) {
        return new Point((point2.x + point.x) / 2, (point2.y + point.y) / 2);
    }

    protected static Point getColorPoint(ColorPickerView colorPickerView, Point point) {
        return colorPickerView.isHuePalette() ? getHuePoint(colorPickerView, point) : !colorPickerView.isSelectorPointValidationEnabled() ? point : approximatedPoint(colorPickerView, point, new Point(colorPickerView.getWidth() / 2, colorPickerView.getMeasuredHeight() / 2));
    }

    private static int getDistance(Point point, Point point2) {
        return (int) Math.sqrt((Math.abs(point2.x - point.x) * Math.abs(point2.x - point.x)) + (Math.abs(point2.y - point.y) * Math.abs(point2.y - point.y)));
    }

    private static Point getHuePoint(ColorPickerView colorPickerView, Point point) {
        float width = colorPickerView.getWidth() * 0.5f;
        float height = colorPickerView.getHeight() * 0.5f;
        float f = point.x - width;
        float f2 = point.y - height;
        float fMin = Math.min(width, height);
        double dSqrt = Math.sqrt((f * f) + (f2 * f2));
        double d = fMin;
        if (dSqrt > d) {
            double d2 = d / dSqrt;
            f = (float) (((double) f) * d2);
            f2 = (float) (((double) f2) * d2);
        }
        return new Point((int) (f + width), (int) (f2 + height));
    }
}
