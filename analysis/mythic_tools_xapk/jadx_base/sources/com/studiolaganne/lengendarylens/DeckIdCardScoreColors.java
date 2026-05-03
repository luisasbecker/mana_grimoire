package com.studiolaganne.lengendarylens;

import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.ui.ColorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckIdCardScoreColors.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIdCardScoreColors;", "", "<init>", "()V", "MYTHIC_BLUE", "", "powerLevelColor", FirebaseAnalytics.Param.SCORE, "healthBandColor", "parseApiColor", "hex", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIdCardScoreColors {
    public static final int $stable = 0;
    public static final DeckIdCardScoreColors INSTANCE = new DeckIdCardScoreColors();
    public static final int MYTHIC_BLUE = -11031827;

    private DeckIdCardScoreColors() {
    }

    public final int healthBandColor(int score) {
        int iCoerceIn = RangesKt.coerceIn(score, 0, 100);
        if (iCoerceIn >= 75) {
            return -13781648;
        }
        return iCoerceIn >= 50 ? -1205673 : -1550248;
    }

    public final Integer parseApiColor(String hex) {
        String string;
        if (hex == null || (string = StringsKt.trim((CharSequence) hex).toString()) == null) {
            return null;
        }
        if (string.length() <= 0) {
            string = null;
        }
        if (string == null) {
            return null;
        }
        if (!StringsKt.startsWith$default(string, ColorKt.HEX_PREFIX, false, 2, (Object) null)) {
            string = ColorKt.HEX_PREFIX + string;
        }
        try {
            return Integer.valueOf(Color.parseColor(string));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int powerLevelColor(int score) {
        int iCoerceIn = RangesKt.coerceIn(score, 0, 100);
        if (iCoerceIn >= 75) {
            return -8622112;
        }
        if (iCoerceIn >= 50) {
            return -10777105;
        }
        return iCoerceIn >= 25 ? -1205673 : -7631989;
    }
}
