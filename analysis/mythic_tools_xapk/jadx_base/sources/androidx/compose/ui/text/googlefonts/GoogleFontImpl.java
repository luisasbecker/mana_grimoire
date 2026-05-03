package androidx.compose.ui.text.googlefonts;

import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.core.provider.FontRequest;
import androidx.credentials.provider.CredentialEntry;
import com.bumptech.glide.load.Key;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0013\u0010\u001a\u001a\u00020\u001b*\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001e\u001a\n \u001f*\u0004\u0018\u00010\u00030\u0003*\u00020\u0003H\u0002J\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\u0003H\u0016J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001bH\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÂ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u0010\u0010)\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b*\u0010\u0013J\t\u0010+\u001a\u00020\u000bHÆ\u0003JB\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/compose/ui/text/googlefonts/GoogleFontImpl;", "Landroidx/compose/ui/text/font/AndroidFont;", "name", "", "fontProvider", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "bestEffort", "", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;Landroidx/compose/ui/text/font/FontWeight;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "()I", "I", "getBestEffort", "()Z", "toFontRequest", "Landroidx/core/provider/FontRequest;", "bestEffortQueryParam", "toQueryParam", "", "toQueryParam-nzbMABs", "(I)I", "encode", "kotlin.jvm.PlatformType", "toTypefaceStyle", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component4-_-LCdwA", "component5", "copy", "copy-MuC2MFs", "(Ljava/lang/String;Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;Landroidx/compose/ui/text/font/FontWeight;IZ)Landroidx/compose/ui/text/googlefonts/GoogleFontImpl;", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class GoogleFontImpl extends AndroidFont {
    public static final int $stable = 0;
    private final boolean bestEffort;
    private final GoogleFont.Provider fontProvider;
    private final String name;
    private final int style;
    private final FontWeight weight;

    private GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i, boolean z) {
        super(FontLoadingStrategy.INSTANCE.m8659getAsyncPKNRLFQ(), GoogleFontTypefaceLoader.INSTANCE, new FontVariation.Settings(new FontVariation.Setting[0]), null);
        this.name = str;
        this.fontProvider = provider;
        this.weight = fontWeight;
        this.style = i;
        this.bestEffort = z;
    }

    public /* synthetic */ GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, provider, fontWeight, i, z);
    }

    private final String bestEffortQueryParam() {
        return this.bestEffort ? "true" : CredentialEntry.FALSE_STRING;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final GoogleFont.Provider getFontProvider() {
        return this.fontProvider;
    }

    /* JADX INFO: renamed from: copy-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ GoogleFontImpl m8716copyMuC2MFs$default(GoogleFontImpl googleFontImpl, String str, GoogleFont.Provider provider, FontWeight fontWeight, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = googleFontImpl.name;
        }
        if ((i2 & 2) != 0) {
            provider = googleFontImpl.fontProvider;
        }
        if ((i2 & 4) != 0) {
            fontWeight = googleFontImpl.weight;
        }
        if ((i2 & 8) != 0) {
            i = googleFontImpl.style;
        }
        if ((i2 & 16) != 0) {
            z = googleFontImpl.bestEffort;
        }
        boolean z2 = z;
        FontWeight fontWeight2 = fontWeight;
        return googleFontImpl.m8719copyMuC2MFs(str, provider, fontWeight2, i, z2);
    }

    private final String encode(String str) {
        return URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
    }

    /* JADX INFO: renamed from: toQueryParam-nzbMABs, reason: not valid java name */
    private final int m8717toQueryParamnzbMABs(int i) {
        return FontStyle.m8668equalsimpl0(i, FontStyle.INSTANCE.m8674getItalic_LCdwA()) ? 1 : 0;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontWeight getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component4-_-LCdwA, reason: not valid java name and from getter */
    public final int getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getBestEffort() {
        return this.bestEffort;
    }

    /* JADX INFO: renamed from: copy-MuC2MFs, reason: not valid java name */
    public final GoogleFontImpl m8719copyMuC2MFs(String name, GoogleFont.Provider fontProvider, FontWeight weight, int style, boolean bestEffort) {
        return new GoogleFontImpl(name, fontProvider, weight, style, bestEffort, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleFontImpl)) {
            return false;
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) other;
        return Intrinsics.areEqual(this.name, googleFontImpl.name) && Intrinsics.areEqual(this.fontProvider, googleFontImpl.fontProvider) && Intrinsics.areEqual(getWeight(), googleFontImpl.getWeight()) && FontStyle.m8668equalsimpl0(getStyle(), googleFontImpl.getStyle()) && this.bestEffort == googleFontImpl.bestEffort;
    }

    public final boolean getBestEffort() {
        return this.bestEffort;
    }

    public final String getName() {
        return this.name;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int getStyle() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.fontProvider.hashCode()) * 31) + getWeight().hashCode()) * 31) + FontStyle.m8669hashCodeimpl(getStyle())) * 31) + Boolean.hashCode(this.bestEffort);
    }

    public final FontRequest toFontRequest() {
        String str = "name=" + this.name + "&weight=" + getWeight().getWeight() + "&italic=" + m8717toQueryParamnzbMABs(getStyle()) + "&besteffort=" + bestEffortQueryParam();
        List<List<byte[]>> certificates$ui_text_google_fonts = this.fontProvider.getCertificates$ui_text_google_fonts();
        return certificates$ui_text_google_fonts != null ? new FontRequest(this.fontProvider.getProviderAuthority(), this.fontProvider.getProviderPackage(), str, certificates$ui_text_google_fonts) : new FontRequest(this.fontProvider.getProviderAuthority(), this.fontProvider.getProviderPackage(), str, this.fontProvider.getCertificatesRes());
    }

    public String toString() {
        return "Font(GoogleFont(\"" + this.name + "\", bestEffort=" + this.bestEffort + "), weight=" + getWeight() + ", style=" + ((Object) FontStyle.m8670toStringimpl(getStyle())) + ')';
    }

    public final int toTypefaceStyle() {
        boolean zM8668equalsimpl0 = FontStyle.m8668equalsimpl0(getStyle(), FontStyle.INSTANCE.m8674getItalic_LCdwA());
        boolean z = getWeight().compareTo(FontWeight.INSTANCE.getBold()) >= 0;
        if (zM8668equalsimpl0 && z) {
            return 3;
        }
        if (zM8668equalsimpl0) {
            return 2;
        }
        return z ? 1 : 0;
    }
}
