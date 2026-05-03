package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CachedImageView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0017H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CachedImageView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "imageView", "Landroid/widget/ImageView;", "imageUrl", "", "clearBackground", "", "reset", "onAttachedToWindow", "loadImage", "url", "setFromBase64", "base64String", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CachedImageView extends CardView {
    public static final int $stable = 8;
    private boolean autoLoad;
    private String imageUrl;
    private final ImageView imageView;
    private final LottieAnimationView lottieView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoLoad = true;
        this.imageUrl = "";
        CardView.inflate(context, R.layout.cached_image_view, this);
        View viewFindViewById = findViewById(R.id.animationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lottieView = (LottieAnimationView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.imageView = (ImageView) viewFindViewById2;
    }

    public /* synthetic */ CachedImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadImage() {
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isFinishing()) {
            if ((activity == null || !activity.isDestroyed()) && this.imageUrl.length() != 0) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("cached_image_view_load");
                Glide.with(this).load(this.imageUrl).transition(DrawableTransitionOptions.withCrossFade(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build())).addListener(new RequestListener<Drawable>() { // from class: com.studiolaganne.lengendarylens.CachedImageView.loadImage.1
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(target, "target");
                        CachedImageView.this.lottieView.setVisibility(4);
                        CachedImageView.this.imageView.setVisibility(0);
                        return true;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        Intrinsics.checkNotNullParameter(model, "model");
                        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                        CachedImageView.this.lottieView.setVisibility(4);
                        CachedImageView.this.imageView.setVisibility(0);
                        return false;
                    }
                }).into(this.imageView);
            }
        }
    }

    public final void clearBackground() {
        setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent, null));
        setCardBackgroundColor(getContext().getResources().getColor(android.R.color.transparent, null));
    }

    public final boolean getAutoLoad() {
        return this.autoLoad;
    }

    public final void loadImage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.imageUrl = url;
        if (this.autoLoad) {
            return;
        }
        loadImage();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.CachedImageView.onAttachedToWindow.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                CachedImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (CachedImageView.this.getAutoLoad()) {
                    CachedImageView.this.loadImage();
                }
            }
        });
    }

    public final void reset() {
        this.lottieView.setVisibility(0);
        this.imageView.setVisibility(4);
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final void setFromBase64(String base64String) {
        Intrinsics.checkNotNullParameter(base64String, "base64String");
        byte[] bArrDecode = Base64.decode(StringsKt.substringAfter$default(base64String, ",", (String) null, 2, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        this.imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }
}
