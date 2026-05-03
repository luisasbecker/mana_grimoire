package androidx.compose.ui.text.googlefonts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

/* JADX INFO: compiled from: HandlerHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/googlefonts/HandlerHelper;", "", "<init>", "()V", "createAsync", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "Handler28Impl", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HandlerHelper {
    public static final int $stable = 0;
    public static final HandlerHelper INSTANCE = new HandlerHelper();

    /* JADX INFO: compiled from: HandlerHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/googlefonts/HandlerHelper$Handler28Impl;", "", "<init>", "()V", "createAsync", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Handler28Impl {
        public static final int $stable = 0;
        public static final Handler28Impl INSTANCE = new Handler28Impl();

        private Handler28Impl() {
        }

        public final Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private HandlerHelper() {
    }

    public final Handler createAsync(Looper looper) {
        return Build.VERSION.SDK_INT >= 28 ? Handler28Impl.INSTANCE.createAsync(looper) : new Handler(looper);
    }
}
