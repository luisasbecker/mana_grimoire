package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.DrawableKt;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullscreenImageDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J:\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/studiolaganne/lengendarylens/FullscreenImageURLDialog$3$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", AndroidContextPlugin.DEVICE_MODEL_KEY, "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FullscreenImageURLDialog$3$1 implements RequestListener<Drawable> {
    final /* synthetic */ FullscreenImageURLDialog this$0;

    FullscreenImageURLDialog$3$1(FullscreenImageURLDialog fullscreenImageURLDialog) {
        this.this$0 = fullscreenImageURLDialog;
    }

    static final void onResourceReady$lambda$0(Drawable drawable, FullscreenImageURLDialog fullscreenImageURLDialog) {
        Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        fullscreenImageURLDialog.viewWidth = fullscreenImageURLDialog.imageView.getWidth();
        fullscreenImageURLDialog.viewHeight = (fullscreenImageURLDialog.imageView.getWidth() * 7.0f) / 5.0f;
        fullscreenImageURLDialog.imageWidth = bitmap$default.getWidth();
        fullscreenImageURLDialog.imageHeight = bitmap$default.getHeight();
        fullscreenImageURLDialog.centerImage();
        fullscreenImageURLDialog.imageView.setClipToOutline(true);
        fullscreenImageURLDialog.imageView.setOutlineProvider(new RoundedOutlineProvider(fullscreenImageURLDialog.imageView.getWidth() * 0.065f));
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.this$0.imageView.setImageResource(R.drawable.card_back_small_err);
        this.this$0.imageView.setVisibility(0);
        return true;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(final Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.this$0.imageView.setVisibility(0);
        ImageView imageView = this.this$0.imageView;
        final FullscreenImageURLDialog fullscreenImageURLDialog = this.this$0;
        imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.FullscreenImageURLDialog$3$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FullscreenImageURLDialog$3$1.onResourceReady$lambda$0(resource, fullscreenImageURLDialog);
            }
        });
        return false;
    }
}
