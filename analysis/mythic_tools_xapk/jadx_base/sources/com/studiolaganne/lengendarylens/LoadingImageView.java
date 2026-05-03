package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.LoadingImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadingImageView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\b\u0010$\u001a\u00020 H\u0014J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0007J\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020(J\u000e\u0010+\u001a\u00020 2\u0006\u0010*\u001a\u00020(J*\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001a2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020 0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020 0/J\u000e\u00101\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001aJ\b\u00101\u001a\u00020 H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/LoadingImageView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "isAlpha", "setAlpha", "skipMemoryCache", "getSkipMemoryCache", "setSkipMemoryCache", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "imageView", "Landroid/widget/ImageView;", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "setImageColorDimmed", "", "dimmed", "reset", "loadNetworkErr", "onAttachedToWindow", "setImageResource", "resId", "getDrawable", "Landroid/graphics/drawable/Drawable;", "setImageDrawable", "drawable", "setImageDrawableWithoutClear", "loadImageWithCallback", "url", "onSuccess", "Lkotlin/Function0;", "onFailure", "loadImage", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoadingImageView extends CardView {
    public static final int $stable = 8;
    private boolean autoLoad;
    private String imageUrl;
    private final ImageView imageView;
    private boolean isAlpha;
    private final LottieAnimationView lottieView;
    private boolean skipMemoryCache;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LoadingImageView$loadImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoadingImageView.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J:\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/studiolaganne/lengendarylens/LoadingImageView$loadImage$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", AndroidContextPlugin.DEVICE_MODEL_KEY, "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements RequestListener<Drawable> {
        AnonymousClass1() {
        }

        static final void onLoadFailed$lambda$0(LoadingImageView loadingImageView) {
            if (loadingImageView.getWidth() > 0) {
                if (loadingImageView.getIsAlpha()) {
                    float width = loadingImageView.getWidth() * 0.07f;
                    loadingImageView.setRadius(width);
                    loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
                    loadingImageView.imageView.setClipToOutline(true);
                    return;
                }
                float width2 = loadingImageView.getWidth() * 0.06f;
                loadingImageView.setRadius(width2);
                loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
                loadingImageView.imageView.setClipToOutline(true);
            }
        }

        static final void onResourceReady$lambda$1(LoadingImageView loadingImageView) {
            if (loadingImageView.getWidth() > 0) {
                if (loadingImageView.getIsAlpha()) {
                    float width = loadingImageView.getWidth() * 0.07f;
                    loadingImageView.setRadius(width);
                    loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
                    loadingImageView.imageView.setClipToOutline(true);
                    return;
                }
                float width2 = loadingImageView.getWidth() * 0.06f;
                loadingImageView.setRadius(width2);
                loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
                loadingImageView.imageView.setClipToOutline(true);
            }
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(target, "target");
            LoadingImageView.this.imageView.setImageResource(R.drawable.card_back_small_err);
            LoadingImageView.this.lottieView.setVisibility(4);
            LoadingImageView.this.imageView.setVisibility(0);
            ImageView imageView = LoadingImageView.this.imageView;
            final LoadingImageView loadingImageView = LoadingImageView.this;
            imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.LoadingImageView$loadImage$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoadingImageView.AnonymousClass1.onLoadFailed$lambda$0(loadingImageView);
                }
            });
            return true;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            LoadingImageView.this.lottieView.setVisibility(4);
            LoadingImageView.this.imageView.setVisibility(0);
            ImageView imageView = LoadingImageView.this.imageView;
            final LoadingImageView loadingImageView = LoadingImageView.this;
            imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.LoadingImageView$loadImage$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LoadingImageView.AnonymousClass1.onResourceReady$lambda$1(loadingImageView);
                }
            });
            return false;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LoadingImageView$loadImageWithCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadingImageView.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J:\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/studiolaganne/lengendarylens/LoadingImageView$loadImageWithCallback$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", AndroidContextPlugin.DEVICE_MODEL_KEY, "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12001 implements RequestListener<Drawable> {
        final /* synthetic */ Function0<Unit> $onFailure;
        final /* synthetic */ Function0<Unit> $onSuccess;

        C12001(Function0<Unit> function0, Function0<Unit> function02) {
            this.$onFailure = function0;
            this.$onSuccess = function02;
        }

        static final void onResourceReady$lambda$0(LoadingImageView loadingImageView) {
            if (loadingImageView.getWidth() == 0) {
                return;
            }
            if (loadingImageView.getIsAlpha()) {
                float width = loadingImageView.getWidth() * 0.07f;
                loadingImageView.setRadius(width);
                loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
                loadingImageView.imageView.setClipToOutline(true);
                return;
            }
            float width2 = loadingImageView.getWidth() * 0.06f;
            loadingImageView.setRadius(width2);
            loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
            loadingImageView.imageView.setClipToOutline(true);
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(target, "target");
            LoadingImageView.this.imageView.setImageResource(R.drawable.card_back_small_err);
            LoadingImageView.this.lottieView.setVisibility(4);
            LoadingImageView.this.imageView.setVisibility(0);
            this.$onFailure.invoke();
            return true;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            LoadingImageView.this.lottieView.setVisibility(4);
            LoadingImageView.this.imageView.setVisibility(0);
            this.$onSuccess.invoke();
            ImageView imageView = LoadingImageView.this.imageView;
            final LoadingImageView loadingImageView = LoadingImageView.this;
            imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.LoadingImageView$loadImageWithCallback$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoadingImageView.C12001.onResourceReady$lambda$0(loadingImageView);
                }
            });
            return false;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LoadingImageView$onAttachedToWindow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadingImageView.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/studiolaganne/lengendarylens/LoadingImageView$onAttachedToWindow$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ViewTreeObserverOnGlobalLayoutListenerC12011 implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC12011() {
        }

        static final void onGlobalLayout$lambda$0(LoadingImageView loadingImageView) {
            if (loadingImageView.getAutoLoad()) {
                loadingImageView.loadImage();
                if (loadingImageView.getIsAlpha()) {
                    float width = loadingImageView.getWidth() * 0.07f;
                    loadingImageView.setRadius(width);
                    loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
                    loadingImageView.imageView.setClipToOutline(true);
                    return;
                }
                float width2 = loadingImageView.getWidth() * 0.06f;
                loadingImageView.setRadius(width2);
                loadingImageView.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
                loadingImageView.imageView.setClipToOutline(true);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LoadingImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ImageView imageView = LoadingImageView.this.imageView;
            final LoadingImageView loadingImageView = LoadingImageView.this;
            imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.LoadingImageView$onAttachedToWindow$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoadingImageView.ViewTreeObserverOnGlobalLayoutListenerC12011.onGlobalLayout$lambda$0(loadingImageView);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoLoad = true;
        this.imageUrl = "";
        CardView.inflate(context, R.layout.loading_image_view, this);
        View viewFindViewById = findViewById(R.id.animationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lottieView = (LottieAnimationView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.imageView = (ImageView) viewFindViewById2;
    }

    public /* synthetic */ LoadingImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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
            if (activity == null || !activity.isDestroyed()) {
                this.imageView.setImageDrawable(null);
                Glide.with(getContext()).clear(this.imageView);
                if (getWidth() > 0) {
                    if (this.isAlpha) {
                        float width = getWidth() * 0.07f;
                        setRadius(width);
                        this.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
                        this.imageView.setClipToOutline(true);
                    } else {
                        float width2 = getWidth() * 0.06f;
                        setRadius(width2);
                        this.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
                        this.imageView.setClipToOutline(true);
                    }
                }
                Breadcrumbs.INSTANCE.leaveBreadcrumb("loading_image_view_load");
                Glide.with(this).load(this.imageUrl).placeholder(R.drawable.card_back).skipMemoryCache(this.skipMemoryCache).addListener(new AnonymousClass1()).into(this.imageView);
            }
        }
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

    public final boolean getSkipMemoryCache() {
        return this.skipMemoryCache;
    }

    /* JADX INFO: renamed from: isAlpha, reason: from getter */
    public final boolean getIsAlpha() {
        return this.isAlpha;
    }

    public final void loadImage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.imageUrl = url;
        loadImage();
    }

    public final void loadImageWithCallback(String url, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.imageUrl = url;
        if (isInEditMode()) {
            onFailure.invoke();
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if ((activity != null && activity.isFinishing()) || (activity != null && activity.isDestroyed())) {
            onFailure.invoke();
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("loading_image_view_load_with_callback");
        this.imageView.setImageDrawable(null);
        Glide.with(getContext()).clear(this.imageView);
        if (this.isAlpha) {
            float width = getWidth() * 0.07f;
            setRadius(width);
            this.imageView.setOutlineProvider(new RoundedOutlineProvider(width));
            this.imageView.setClipToOutline(true);
        } else {
            float width2 = getWidth() * 0.06f;
            setRadius(width2);
            this.imageView.setOutlineProvider(new RoundedOutlineProvider(width2));
            this.imageView.setClipToOutline(true);
        }
        Glide.with(this).load(this.imageUrl).placeholder(R.drawable.card_back).skipMemoryCache(this.skipMemoryCache).addListener(new C12001(onFailure, onSuccess)).into(this.imageView);
    }

    public final void loadNetworkErr() {
        this.imageView.setImageResource(R.drawable.card_back_small_err);
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC12011());
    }

    public final void reset() {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("loading_image_view_reset");
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isFinishing()) {
            if (activity == null || !activity.isDestroyed()) {
                this.imageView.setImageDrawable(null);
                Glide.with(getContext()).clear(this.imageView);
                this.imageView.setImageResource(R.drawable.card_back_small);
                this.lottieView.setVisibility(0);
                this.imageView.setVisibility(0);
            }
        }
    }

    public final void setAlpha(boolean z) {
        this.isAlpha = z;
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final void setImageColorDimmed(boolean dimmed) {
        if (!dimmed) {
            this.imageView.setColorFilter((ColorFilter) null);
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public final void setImageDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.imageView.setImageDrawable(drawable);
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }

    public final void setImageDrawableWithoutClear(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.imageView.setImageDrawable(drawable);
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }

    public final void setImageResource(int resId) {
        this.imageView.setImageResource(resId);
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }

    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setSkipMemoryCache(boolean z) {
        this.skipMemoryCache = z;
    }
}
