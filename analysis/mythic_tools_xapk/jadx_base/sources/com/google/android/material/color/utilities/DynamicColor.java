package com.google.android.material.color.utilities;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve, Function<DynamicScheme, ToneDeltaPair> function5) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve, Function<DynamicScheme, ToneDeltaPair> function5, Function<DynamicScheme, Double> function6) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double foregroundTone(double d, double d2) {
        double dLighterUnsafe = Contrast.lighterUnsafe(d, d2);
        double dDarkerUnsafe = Contrast.darkerUnsafe(d, d2);
        double dRatioOfTones = Contrast.ratioOfTones(dLighterUnsafe, d);
        double dRatioOfTones2 = Contrast.ratioOfTones(dDarkerUnsafe, d);
        if (tonePrefersLightForeground(d)) {
            return (dRatioOfTones >= d2 || dRatioOfTones >= dRatioOfTones2 || ((Math.abs(dRatioOfTones - dRatioOfTones2) > 0.1d ? 1 : (Math.abs(dRatioOfTones - dRatioOfTones2) == 0.1d ? 0 : -1)) < 0 && (dRatioOfTones > d2 ? 1 : (dRatioOfTones == d2 ? 0 : -1)) < 0 && (dRatioOfTones2 > d2 ? 1 : (dRatioOfTones2 == d2 ? 0 : -1)) < 0)) ? dLighterUnsafe : dDarkerUnsafe;
        }
        if (dRatioOfTones2 >= d2 || dRatioOfTones2 >= dRatioOfTones) {
        }
    }

    public static DynamicColor fromArgb(String str, int i) {
        final Hct hctFromInt = Hct.fromInt(i);
        final TonalPalette tonalPaletteFromInt = TonalPalette.fromInt(i);
        return fromPalette(str, new Function() { // from class: com.google.android.material.color.utilities.DynamicColor$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$0(tonalPaletteFromInt, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.DynamicColor$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(hctFromInt.getTone());
            }
        });
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z) {
        return new DynamicColor(str, function, function2, z, null, null, null, null);
    }

    static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    public static boolean toneAllowsLightForeground(double d) {
        return Math.round(d) <= 49;
    }

    public static boolean tonePrefersLightForeground(double d) {
        return Math.round(d) < 60;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (16777215 & i);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    public double getTone(DynamicScheme dynamicScheme) {
        double dMin;
        boolean z = true;
        boolean z2 = dynamicScheme.contrastLevel < AudioStats.AUDIO_AMPLITUDE_NONE;
        Function<DynamicScheme, ToneDeltaPair> function = this.toneDeltaPair;
        double dMax = 49.0d;
        if (function == null) {
            double dDoubleValue = this.tone.apply(dynamicScheme).doubleValue();
            Function<DynamicScheme, DynamicColor> function2 = this.background;
            if (function2 == null) {
                return dDoubleValue;
            }
            double tone = function2.apply(dynamicScheme).getTone(dynamicScheme);
            double d = this.contrastCurve.get(dynamicScheme.contrastLevel);
            if (Contrast.ratioOfTones(tone, dDoubleValue) < d) {
                dDoubleValue = foregroundTone(tone, d);
            }
            if (z2) {
                dDoubleValue = foregroundTone(tone, d);
            }
            if (!this.isBackground || 50.0d > dDoubleValue || dDoubleValue >= 60.0d) {
                dMax = dDoubleValue;
            } else if (Contrast.ratioOfTones(49.0d, tone) < d) {
                dMax = 60.0d;
            }
            if (this.secondBackground != null) {
                double tone2 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
                double tone3 = this.secondBackground.apply(dynamicScheme).getTone(dynamicScheme);
                double dMax2 = Math.max(tone2, tone3);
                double dMin2 = Math.min(tone2, tone3);
                if (Contrast.ratioOfTones(dMax2, dMax) < d || Contrast.ratioOfTones(dMin2, dMax) < d) {
                    double dLighter = Contrast.lighter(dMax2, d);
                    double dDarker = Contrast.darker(dMin2, d);
                    ArrayList arrayList = new ArrayList();
                    if (dLighter != -1.0d) {
                        arrayList.add(Double.valueOf(dLighter));
                    }
                    if (dDarker != -1.0d) {
                        arrayList.add(Double.valueOf(dDarker));
                    }
                    if (!tonePrefersLightForeground(tone2) && !tonePrefersLightForeground(tone3)) {
                        return arrayList.size() == 1 ? ((Double) arrayList.get(0)).doubleValue() : dDarker == -1.0d ? AudioStats.AUDIO_AMPLITUDE_NONE : dDarker;
                    }
                    if (dLighter == -1.0d) {
                        return 100.0d;
                    }
                    return dLighter;
                }
            }
            return dMax;
        }
        ToneDeltaPair toneDeltaPairApply = function.apply(dynamicScheme);
        DynamicColor roleA = toneDeltaPairApply.getRoleA();
        DynamicColor roleB = toneDeltaPairApply.getRoleB();
        double delta = toneDeltaPairApply.getDelta();
        TonePolarity polarity = toneDeltaPairApply.getPolarity();
        boolean stayTogether = toneDeltaPairApply.getStayTogether();
        double tone4 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
        if (polarity != TonePolarity.NEARER && ((polarity != TonePolarity.LIGHTER || dynamicScheme.isDark) && (polarity != TonePolarity.DARKER || !dynamicScheme.isDark))) {
            z = false;
        }
        DynamicColor dynamicColor = z ? roleA : roleB;
        DynamicColor dynamicColor2 = z ? roleB : roleA;
        boolean zEquals = this.name.equals(dynamicColor.name);
        double d2 = dynamicScheme.isDark ? 1.0d : -1.0d;
        double d3 = dynamicColor.contrastCurve.get(dynamicScheme.contrastLevel);
        double d4 = dynamicColor2.contrastCurve.get(dynamicScheme.contrastLevel);
        double dDoubleValue2 = dynamicColor.tone.apply(dynamicScheme).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue2) < d3) {
            dDoubleValue2 = foregroundTone(tone4, d3);
        }
        double dDoubleValue3 = dynamicColor2.tone.apply(dynamicScheme).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue3) < d4) {
            dDoubleValue3 = foregroundTone(tone4, d4);
        }
        if (z2) {
            dDoubleValue2 = foregroundTone(tone4, d3);
            dDoubleValue3 = foregroundTone(tone4, d4);
        }
        if ((dDoubleValue3 - dDoubleValue2) * d2 < delta) {
            double d5 = delta * d2;
            dDoubleValue3 = MathUtils.clampDouble(AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d, dDoubleValue2 + d5);
            if ((dDoubleValue3 - dDoubleValue2) * d2 < delta) {
                dDoubleValue2 = MathUtils.clampDouble(AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d, dDoubleValue3 - d5);
            }
        }
        if (50.0d > dDoubleValue2 || dDoubleValue2 >= 60.0d) {
            if (50.0d > dDoubleValue3 || dDoubleValue3 >= 60.0d) {
                dMax = dDoubleValue3;
            } else if (stayTogether) {
                if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    dMax = Math.max(dDoubleValue3, (delta * d2) + 60.0d);
                    dDoubleValue2 = 60.0d;
                } else {
                    dMin = Math.min(dDoubleValue3, (delta * d2) + 49.0d);
                    dDoubleValue2 = 49.0d;
                    dMax = dMin;
                }
            } else if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                dMax = 60.0d;
            }
        } else if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
            dMax = Math.max(dDoubleValue3, (delta * d2) + 60.0d);
            dDoubleValue2 = 60.0d;
        } else {
            dMin = Math.min(dDoubleValue3, (delta * d2) + 49.0d);
            dDoubleValue2 = 49.0d;
            dMax = dMin;
        }
        return zEquals ? dDoubleValue2 : dMax;
    }
}
