package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.core.content.res.FontResourcesParserCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"GoogleFont", "Landroidx/compose/ui/text/googlefonts/GoogleFont;", "context", "Landroid/content/Context;", "fontXml", "", "ui-text-google-fonts"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class XmlLoaderKt {
    public static final GoogleFont GoogleFont(Context context, int i) {
        Resources resources = context.getResources();
        try {
            FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry = FontResourcesParserCompat.parse(resources.getXml(i), resources);
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry ? (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry : null;
            if (providerResourceEntry == null) {
                throw new IllegalArgumentException(("Unable to load XML fontRes " + resources.getResourceName(i)).toString());
            }
            Uri uri = Uri.parse("?" + providerResourceEntry.getRequest().getQuery());
            String queryParameter = uri.getQueryParameter("name");
            if (queryParameter == null) {
                throw new IllegalArgumentException("No google font name provided in fontRes: " + resources.getResourceName(i));
            }
            String queryParameter2 = uri.getQueryParameter("besteffort");
            if (queryParameter2 == null) {
                queryParameter2 = "true";
            }
            return new GoogleFont(queryParameter, Intrinsics.areEqual(queryParameter2, "true"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to load XML fontRes " + resources.getResourceName(i), e);
        }
    }
}
