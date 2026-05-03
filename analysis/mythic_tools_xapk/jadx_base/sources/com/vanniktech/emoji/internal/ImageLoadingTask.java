package com.vanniktech.emoji.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiManager;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoadingTask.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000f\"\u00020\u0002H\u0015¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0015J\u0006\u0010\u0014\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vanniktech/emoji/internal/ImageLoadingTask;", "Landroid/os/AsyncTask;", "Lcom/vanniktech/emoji/Emoji;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "imageView", "Landroid/widget/ImageView;", "<init>", "(Landroid/widget/ImageView;)V", "imageViewReference", "Ljava/lang/ref/WeakReference;", "contextReference", "Landroid/content/Context;", "doInBackground", "emoji", "", "([Lcom/vanniktech/emoji/Emoji;)Landroid/graphics/drawable/Drawable;", "onPostExecute", "", "drawable", "cancel", "start", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ImageLoadingTask extends AsyncTask<Emoji, Void, Drawable> {
    private final WeakReference<Context> contextReference;
    private final WeakReference<ImageView> imageViewReference;

    public ImageLoadingTask(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.imageViewReference = new WeakReference<>(imageView);
        this.contextReference = new WeakReference<>(imageView.getContext());
    }

    public final void cancel() {
        cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Deprecated(message = "Deprecated in Java")
    public Drawable doInBackground(Emoji... emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Context context = this.contextReference.get();
        if (context == null || isCancelled()) {
            return null;
        }
        return UtilsKt.emojiDrawableProvider(EmojiManager.INSTANCE).getDrawable(emoji[0], context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Deprecated(message = "Deprecated in Java")
    public void onPostExecute(Drawable drawable) {
        ImageView imageView;
        if (isCancelled() || drawable == null || (imageView = this.imageViewReference.get()) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void start(Emoji emoji) {
        execute(emoji);
    }
}
