package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "googleFont", "Landroidx/compose/ui/text/googlefonts/GoogleFont;", "fontProvider", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "Font-wCLgNak", "(Landroidx/compose/ui/text/googlefonts/GoogleFont;Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "isAvailableOnDevice", "", "context", "Landroid/content/Context;", "reasonToString", "", "reasonCode", "", "ui-text-google-fonts"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GoogleFontKt {
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m8720FontwCLgNak(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i) {
        return new GoogleFontImpl(googleFont.getName(), provider, fontWeight, i, googleFont.getBestEffort(), null);
    }

    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m8721FontwCLgNak$default(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getW400();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.INSTANCE.m8675getNormal_LCdwA();
        }
        return m8720FontwCLgNak(googleFont, provider, fontWeight, i);
    }

    public static final boolean isAvailableOnDevice(GoogleFont.Provider provider, Context context) {
        return FontProviderHelperKt.checkAvailable(provider, context.getPackageManager(), context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String reasonToString(int i) {
        return i != -4 ? i != -3 ? i != -2 ? i != -1 ? i != 1 ? i != 2 ? i != 3 ? "Unknown error code" : "The given query was not supported by this provider." : "The provider found the queried font, but it is currently unavailable." : "Font not found, please check availability on GoogleFont.Provider.AllFontsList: https://fonts.gstatic.com/s/a/directory.xml" : "The requested provider was not found on this device." : "The given provider cannot be authenticated with the certificates given." : "Generic error loading font, for example variation settings were not parsable" : "Font was not loaded due to security issues. This usually means the font was attempted to load in a restricted context";
    }
}
