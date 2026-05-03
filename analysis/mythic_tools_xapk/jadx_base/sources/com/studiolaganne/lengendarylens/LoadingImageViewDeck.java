package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadingImageViewDeck.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "isArtCrop", "setArtCrop", "bitmap", "Landroid/graphics/Bitmap;", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "imageView", "Landroid/widget/ImageView;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "onAttachedToWindow", "", "loadSingleImage", "url", "loadImages", "checkAndCombineImages", "cropCardImage", "fadeBitmapOnRightFlipped", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoadingImageViewDeck extends CardView {
    public static final int $stable = 8;
    private boolean autoLoad;
    private Bitmap bitmap;
    private String imageUrl;
    private final ImageView imageView;
    private boolean isArtCrop;
    private final LottieAnimationView lottieView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoadingImageViewDeck(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingImageViewDeck(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoLoad = true;
        this.imageUrl = "";
        CardView.inflate(context, R.layout.loading_image_view_deck, this);
        View viewFindViewById = findViewById(R.id.animationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lottieView = (LottieAnimationView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        this.imageView = imageView;
        imageView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
    }

    public /* synthetic */ LoadingImageViewDeck(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndCombineImages() {
        Bitmap bitmapCreateScaledBitmap = this.bitmap;
        if (bitmapCreateScaledBitmap != null) {
            Intrinsics.checkNotNull(bitmapCreateScaledBitmap);
            if (this.imageUrl.length() > 0 && !this.isArtCrop) {
                bitmapCreateScaledBitmap = cropCardImage(bitmapCreateScaledBitmap);
            }
            if (bitmapCreateScaledBitmap.getHeight() > 1000) {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, (int) ((1000.0f / bitmapCreateScaledBitmap.getHeight()) * bitmapCreateScaledBitmap.getWidth()), 1000, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            }
            this.imageView.setImageBitmap(fadeBitmapOnRightFlipped(bitmapCreateScaledBitmap));
            this.lottieView.setVisibility(8);
            this.imageView.setVisibility(0);
        }
    }

    private final Bitmap cropCardImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int i = (int) (((double) width) * 0.8d);
        double height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - i) / 2, (int) (height * 0.135d), i, (int) (0.4d * height));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    private final Bitmap fadeBitmapOnRightFlipped(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        float f = width;
        matrix.postTranslate(f, 0.0f);
        canvas.drawBitmap(bitmap, matrix, null);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f, 0.0f, new int[]{-16777216, -16777216, 0}, new float[]{0.0f, 0.33333334f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, 0.0f, f, height, paint);
        return bitmapCreateBitmap;
    }

    public final boolean getAutoLoad() {
        return this.autoLoad;
    }

    public final Drawable getDrawable() {
        Drawable drawable = this.imageView.getDrawable();
        if (drawable == null) {
            return null;
        }
        return drawable;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: isArtCrop, reason: from getter */
    public final boolean getIsArtCrop() {
        return this.isArtCrop;
    }

    public final void loadImages() {
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isFinishing()) {
            if (activity == null || !activity.isDestroyed()) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("loading_image_view_deck_load");
                if (this.imageUrl.length() > 0) {
                    Glide.with(this).asBitmap().load(this.imageUrl).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewDeck.loadImages.1
                        @Override // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable placeholder) {
                        }

                        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                        public void onLoadFailed(Drawable errorDrawable) {
                            LoadingImageViewDeck.this.lottieView.setVisibility(8);
                            LoadingImageViewDeck.this.imageView.setVisibility(0);
                        }

                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            Intrinsics.checkNotNullParameter(resource, "resource");
                            LoadingImageViewDeck.this.bitmap = resource;
                            LoadingImageViewDeck.this.checkAndCombineImages();
                        }

                        @Override // com.bumptech.glide.request.target.Target
                        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                        }
                    });
                }
            }
        }
    }

    public final void loadSingleImage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.imageUrl = url;
        if (this.autoLoad) {
            return;
        }
        loadImages();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewDeck.onAttachedToWindow.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LoadingImageViewDeck.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (LoadingImageViewDeck.this.getAutoLoad()) {
                    LoadingImageViewDeck.this.loadImages();
                }
            }
        });
    }

    public final void setArtCrop(boolean z) {
        this.isArtCrop = z;
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }
}
