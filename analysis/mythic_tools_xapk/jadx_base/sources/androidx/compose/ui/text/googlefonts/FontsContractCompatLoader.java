package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/googlefonts/FontsContractCompatLoader;", "", "requestFont", "", "context", "Landroid/content/Context;", "fontRequest", "Landroidx/core/provider/FontRequest;", "typefaceStyle", "", "handler", "Landroid/os/Handler;", "callback", "Landroidx/core/provider/FontsContractCompat$FontRequestCallback;", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FontsContractCompatLoader {
    void requestFont(Context context, FontRequest fontRequest, int typefaceStyle, Handler handler, FontsContractCompat.FontRequestCallback callback);
}
