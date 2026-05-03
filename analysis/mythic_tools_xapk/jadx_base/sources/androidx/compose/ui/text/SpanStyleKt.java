package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpanStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001a\u0002H\u00112\u0006\u0010\u000b\u001a\u0002H\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0000\u001a½\u0001\u0010\u001c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00192\b\u00109\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0019*\u00020\u00152\b\u0010>\u001a\u0004\u0018\u00010\u0019H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", "a", "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpanStyleKt {
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.INSTANCE.m6360getTransparent0d7_KjU();

    static {
        long jM6351getBlack0d7_KjU = Color.INSTANCE.m6351getBlack0d7_KjU();
        DefaultColor = jM6351getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.INSTANCE.m9019from8_81llA(jM6351getBlack0d7_KjU);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a A[PHI: r11
      0x003a: PHI (r11v7 long) = 
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v8 long)
     binds: [B:42:0x00ac, B:54:0x00de, B:51:0x00d2, B:48:0x00c6, B:45:0x00ba, B:40:0x009e, B:35:0x008f, B:28:0x0076, B:25:0x006e, B:22:0x0062, B:19:0x0056, B:9:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017b  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle m8502fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        long fontSize;
        TextGeometricTransform textGeometricTransform2;
        long background;
        DrawStyle drawStyle2;
        String fontFeatureSettings = str;
        BaselineShift baselineShift2 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (!(TextUnit.m9306getRawTypeimpl(j2) == 0)) {
            fontSize = j2;
            if (!TextUnit.m9305equalsimpl0(fontSize, spanStyle.getFontSize())) {
                textGeometricTransform2 = textGeometricTransform;
                background = j4;
                drawStyle2 = drawStyle;
            }
            TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle().merge(brush == null ? TextForegroundStyle.INSTANCE.from(brush, f) : TextForegroundStyle.INSTANCE.m9019from8_81llA(j));
            FontFamily fontFamily2 = fontFamily != null ? spanStyle.getFontFamily() : fontFamily;
            if (TextUnit.m9306getRawTypeimpl(fontSize) == 0) {
                fontSize = spanStyle.getFontSize();
            }
            FontWeight fontWeight2 = fontWeight != null ? spanStyle.getFontWeight() : fontWeight;
            FontStyle fontStyle2 = fontStyle != null ? spanStyle.getFontStyle() : fontStyle;
            FontSynthesis fontSynthesis2 = fontSynthesis != null ? spanStyle.getFontSynthesis() : fontSynthesis;
            if (fontFeatureSettings == null) {
                fontFeatureSettings = spanStyle.getFontFeatureSettings();
            }
            long letterSpacing = TextUnit.m9306getRawTypeimpl(j3) != 0 ? spanStyle.getLetterSpacing() : j3;
            if (baselineShift2 == null) {
                baselineShift2 = spanStyle.getBaselineShift();
            }
            if (textGeometricTransform2 == null) {
                textGeometricTransform2 = spanStyle.getTextGeometricTransform();
            }
            LocaleList localeList2 = localeList != null ? spanStyle.getLocaleList() : localeList;
            if (background == 16) {
                background = spanStyle.getBackground();
            }
            if (textDecoration2 == null) {
                textDecoration2 = spanStyle.getTextDecoration();
            }
            if (shadow2 == null) {
                shadow2 = spanStyle.getShadow();
            }
            return new SpanStyle(textForegroundStyleMerge, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 != null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
        }
        fontSize = j2;
        if ((brush != null || j == 16 || Color.m6326equalsimpl0(j, spanStyle.getTextForegroundStyle().mo8872getColor0d7_KjU())) && ((fontStyle == null || Intrinsics.areEqual(fontStyle, spanStyle.getFontStyle())) && ((fontWeight == null || Intrinsics.areEqual(fontWeight, spanStyle.getFontWeight())) && (fontFamily == null || fontFamily == spanStyle.getFontFamily())))) {
            if ((TextUnit.m9306getRawTypeimpl(j3) == 0) || TextUnit.m9305equalsimpl0(j3, spanStyle.getLetterSpacing())) {
                if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.getFontSynthesis())) && ((fontFeatureSettings == null || Intrinsics.areEqual(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.getBaselineShift())))))) {
                    if (textGeometricTransform != null) {
                        textGeometricTransform2 = textGeometricTransform;
                        if (Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) {
                        }
                    } else {
                        textGeometricTransform2 = textGeometricTransform;
                    }
                    if (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList())) {
                        if (j4 != 16) {
                            background = j4;
                            if (Color.m6326equalsimpl0(background, spanStyle.getBackground())) {
                            }
                        } else {
                            background = j4;
                        }
                        if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                            drawStyle2 = drawStyle;
                            if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                                return spanStyle;
                            }
                        }
                    }
                    drawStyle2 = drawStyle;
                }
                background = j4;
                drawStyle2 = drawStyle;
            }
        }
        TextForegroundStyle textForegroundStyleMerge2 = spanStyle.getTextForegroundStyle().merge(brush == null ? TextForegroundStyle.INSTANCE.from(brush, f) : TextForegroundStyle.INSTANCE.m9019from8_81llA(j));
        if (fontFamily != null) {
        }
        if (TextUnit.m9306getRawTypeimpl(fontSize) == 0) {
        }
        if (fontWeight != null) {
        }
        if (fontStyle != null) {
        }
        if (fontSynthesis != null) {
        }
        if (fontFeatureSettings == null) {
        }
        if (TextUnit.m9306getRawTypeimpl(j3) != 0) {
        }
        if (baselineShift2 == null) {
        }
        if (textGeometricTransform2 == null) {
        }
        if (localeList != null) {
        }
        if (background == 16) {
        }
        if (textDecoration2 == null) {
        }
        if (shadow2 == null) {
        }
        return new SpanStyle(textForegroundStyleMerge2, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 != null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM8503lerpTextUnitInheritableC3pnCVY = m8503lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM8503lerpTextUnitInheritableC3pnCVY2 = m8503lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM8860unboximpl = baselineShift != null ? baselineShift.m8860unboximpl() : BaselineShift.m8855constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float fM8870lerpjWV1Mfo = BaselineShiftKt.m8870lerpjWV1Mfo(fM8860unboximpl, baselineShift2 != null ? baselineShift2.m8860unboximpl() : BaselineShift.m8855constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM6376lerpjxsXWHM = ColorKt.m6376lerpjxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM8503lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM8503lerpTextUnitInheritableC3pnCVY2, BaselineShift.m8854boximpl(fM8870lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM6376lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m8503lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        return (TextUnit.m9306getRawTypeimpl(j) == 0 || TextUnit.m9306getRawTypeimpl(j2) == 0) ? ((TextUnit) lerpDiscrete(TextUnit.m9298boximpl(j), TextUnit.m9298boximpl(j2), f)).getPackedValue() : TextUnitKt.m9328lerpC3pnCVY(j, j2, f);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        return spanStyle.getPlatformStyle() == null ? platformSpanStyle : platformSpanStyle == null ? spanStyle.getPlatformStyle() : spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SpanStyleKt.DefaultColorForegroundStyle;
            }
        });
        long fontSize = TextUnit.m9306getRawTypeimpl(spanStyle.getFontSize()) == 0 ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM8665boximpl = FontStyle.m8665boximpl(fontStyle != null ? fontStyle.m8671unboximpl() : FontStyle.INSTANCE.m8675getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis fontSynthesisM8676boximpl = FontSynthesis.m8676boximpl(fontSynthesis != null ? fontSynthesis.m8684unboximpl() : FontSynthesis.INSTANCE.m8685getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long letterSpacing = TextUnit.m9306getRawTypeimpl(spanStyle.getLetterSpacing()) == 0 ? DefaultLetterSpacing : spanStyle.getLetterSpacing();
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM8860unboximpl = baselineShift != null ? baselineShift.m8860unboximpl() : BaselineShift.INSTANCE.m8865getNoney9eOQZs();
        if (Float.isNaN(fM8860unboximpl)) {
            fM8860unboximpl = BaselineShift.INSTANCE.m8865getNoney9eOQZs();
        }
        BaselineShift baselineShiftM8854boximpl = BaselineShift.m8854boximpl(fM8860unboximpl);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        if (background == 16) {
            background = DefaultBackgroundColor;
        }
        long j = background;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, fontSize, fontWeight2, fontStyleM8665boximpl, fontSynthesisM8676boximpl, fontFamily2, str, letterSpacing, baselineShiftM8854boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
