package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000bJ*\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/googlefonts/GoogleFontTypefaceLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "<init>", "()V", "loadBlocking", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "awaitLoad", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loader", "Landroidx/compose/ui/text/googlefonts/FontsContractCompatLoader;", "awaitLoad$ui_text_google_fonts", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Landroidx/compose/ui/text/googlefonts/FontsContractCompatLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asyncHandlerForCurrentThreadOrMainIfNoLooper", "Landroid/os/Handler;", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GoogleFontTypefaceLoader implements AndroidFont.TypefaceLoader {
    public static final int $stable = 0;
    public static final GoogleFontTypefaceLoader INSTANCE = new GoogleFontTypefaceLoader();

    private GoogleFontTypefaceLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler asyncHandlerForCurrentThreadOrMainIfNoLooper() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return HandlerHelper.INSTANCE.createAsync(looperMyLooper);
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Object awaitLoad(Context context, AndroidFont androidFont, Continuation<? super Typeface> continuation) {
        return awaitLoad$ui_text_google_fonts(context, androidFont, DefaultFontsContractCompatLoader.INSTANCE, continuation);
    }

    public final Object awaitLoad$ui_text_google_fonts(Context context, final AndroidFont androidFont, FontsContractCompatLoader fontsContractCompatLoader, Continuation<? super Typeface> continuation) {
        if (!(androidFont instanceof GoogleFontImpl)) {
            throw new IllegalArgumentException(("Only GoogleFontImpl supported (actual " + androidFont + ')').toString());
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) androidFont;
        FontRequest fontRequest = googleFontImpl.toFontRequest();
        int typefaceStyle = googleFontImpl.toTypefaceStyle();
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        fontsContractCompatLoader.requestFont(context, fontRequest, typefaceStyle, INSTANCE.asyncHandlerForCurrentThreadOrMainIfNoLooper(), new FontsContractCompat.FontRequestCallback() { // from class: androidx.compose.ui.text.googlefonts.GoogleFontTypefaceLoader$awaitLoad$4$callback$1
            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void onTypefaceRequestFailed(int reason) {
                cancellableContinuationImpl2.cancel(new IllegalStateException("Failed to load " + androidFont + " (reason=" + reason + ", " + GoogleFontKt.reasonToString(reason) + ')'));
            }

            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void onTypefaceRetrieved(Typeface typeface) {
                CancellableContinuation<Typeface> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m11445constructorimpl(typeface));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Typeface loadBlocking(Context context, AndroidFont font) {
        throw new IllegalStateException(("GoogleFont only support async loading: " + font).toString());
    }
}
