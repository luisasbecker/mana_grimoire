package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.palette.graphics.Palette;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: LoadingImageViewPlaymat.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020>2\u0018\u0010G\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0004\u0012\u00020E0HH\u0002J.\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020>2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020J0I2\u0006\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0006\u0010S\u001a\u00020EJ\u0006\u0010T\u001a\u00020EJ\u0006\u0010U\u001a\u00020EJ\u0006\u0010V\u001a\u00020EJ\b\u0010W\u001a\u00020EH\u0014J\u0006\u0010X\u001a\u00020EJ\u0006\u0010Y\u001a\u00020EJ\u0016\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u0012J\u0016\u0010Z\u001a\u00020E2\u0006\u0010F\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u0012J\u0006\u0010]\u001a\u00020EJ\u0006\u0010^\u001a\u00020EJ\b\u0010_\u001a\u00020EH\u0002J\u0018\u0010`\u001a\u00020>2\u0006\u0010F\u001a\u00020>2\u0006\u0010a\u001a\u00020\tH\u0002J\u0010\u0010b\u001a\u00020>2\u0006\u0010F\u001a\u00020>H\u0002J\u0010\u0010c\u001a\u00020>2\u0006\u0010F\u001a\u00020>H\u0002J\u0010\u0010d\u001a\u00020>2\u0006\u0010F\u001a\u00020>H\u0002J\u0010\u0010e\u001a\u00020>2\u0006\u0010F\u001a\u00020>H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\rR\u001a\u0010+\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010\rR\u001a\u0010-\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u00100\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001a\u00103\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u001a\u00106\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR\u001a\u00109\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/studiolaganne/lengendarylens/LoadingImageViewPlaymat;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "forceFullscreenPlaymats", "getForceFullscreenPlaymats", "setForceFullscreenPlaymats", Key.ROTATION, "", "getRotation", "()I", "setRotation", "(I)V", "imageResourceId", "", "getImageResourceId", "()Ljava/lang/String;", "setImageResourceId", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "photoUri", "getPhotoUri", "setPhotoUri", "scryfallId", "getScryfallId", "setScryfallId", "rightSolidColor", "getRightSolidColor", "setRightSolidColor", "isRightArtCrop", "setRightArtCrop", "isLeftArtCrop", "setLeftArtCrop", "leftImageResourceId", "getLeftImageResourceId", "setLeftImageResourceId", "leftImageUrl", "getLeftImageUrl", "setLeftImageUrl", "leftPhotoUri", "getLeftPhotoUri", "setLeftPhotoUri", "leftScryfallId", "getLeftScryfallId", "setLeftScryfallId", "leftSolidColor", "getLeftSolidColor", "setLeftSolidColor", "needsTwoBitmaps", "rightBitmap", "Landroid/graphics/Bitmap;", "leftBitmap", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "imageView", "Lcom/studiolaganne/lengendarylens/RightFocusedImageView;", "detectFacesInBitmap", "", "bitmap", "callback", "Lkotlin/Function1;", "", "Lcom/google/mlkit/vision/face/Face;", "overlayStickerOnBitmap", "original", "faces", "sticker", "accessory", "Lcom/studiolaganne/lengendarylens/Accessory;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "setGrayScale", "removeGrayScale", "removeBackgroundColor", "reset", "onAttachedToWindow", "loadDefault", "showLoading", "loadSingleImage", "url", "imageRotation", "adjustFocusBasedOnAspectRatio", "loadImages", "checkAndCombineImages", "cropCardImage", "isLeft", "fadeBitmapOnLeft", "fadeBitmapOnRightFlipped", "combineBitmapOnRightWithBackground", "combineBitmapOnLeftWithBackground", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoadingImageViewPlaymat extends FrameLayout {
    public static final int $stable = 8;
    private boolean autoLoad;
    private boolean forceFullscreenPlaymats;
    private String imageResourceId;
    private String imageUrl;
    private final RightFocusedImageView imageView;
    private boolean isLeftArtCrop;
    private boolean isRightArtCrop;
    private Bitmap leftBitmap;
    private String leftImageResourceId;
    private String leftImageUrl;
    private String leftPhotoUri;
    private String leftScryfallId;
    private int leftSolidColor;
    private final LottieAnimationView lottieView;
    private boolean needsTwoBitmaps;
    private String photoUri;
    private Bitmap rightBitmap;
    private int rightSolidColor;
    private int rotation;
    private String scryfallId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoadingImageViewPlaymat(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingImageViewPlaymat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoLoad = true;
        this.imageResourceId = "";
        this.imageUrl = "";
        this.photoUri = "";
        this.scryfallId = "";
        this.leftImageResourceId = "";
        this.leftImageUrl = "";
        this.leftPhotoUri = "";
        this.leftScryfallId = "";
        FrameLayout.inflate(context, R.layout.loading_image_view_cropped, this);
        View viewFindViewById = findViewById(R.id.animationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lottieView = (LottieAnimationView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.imageView = (RightFocusedImageView) viewFindViewById2;
    }

    public /* synthetic */ LoadingImageViewPlaymat(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [T, android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v32, types: [T, android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v39, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v55, types: [T, android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, android.graphics.Bitmap] */
    public final void checkAndCombineImages() {
        final Accessory accessory;
        List<Accessory> accessories;
        List<Accessory> accessories2;
        boolean z;
        float height;
        int height2;
        List<Accessory> accessories3;
        List<Accessory> accessories4;
        boolean z2 = this.needsTwoBitmaps;
        Bitmap bitmapCropCardImage = this.rightBitmap;
        if (!z2) {
            if (bitmapCropCardImage != null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r2 = this.rightBitmap;
                Intrinsics.checkNotNull(r2);
                objectRef.element = r2;
                if ((this.imageUrl.length() > 0 || this.scryfallId.length() > 0) && !this.isRightArtCrop) {
                    objectRef.element = cropCardImage((Bitmap) objectRef.element, false);
                }
                SkinManager companion = SkinManager.INSTANCE.getInstance();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(context);
                boolean z3 = (currentSkinDefinition == null || (accessories2 = currentSkinDefinition.getAccessories()) == null) ? false : !accessories2.isEmpty();
                if (currentSkinDefinition == null || !z3) {
                    if (((Bitmap) objectRef.element).getHeight() > 1000) {
                        ?? CreateScaledBitmap = Bitmap.createScaledBitmap((Bitmap) objectRef.element, (int) ((1000.0f / ((Bitmap) objectRef.element).getHeight()) * ((Bitmap) objectRef.element).getWidth()), 1000, true);
                        Intrinsics.checkNotNullExpressionValue(CreateScaledBitmap, "createScaledBitmap(...)");
                        objectRef.element = CreateScaledBitmap;
                    }
                    if (this.forceFullscreenPlaymats) {
                        this.imageView.setImageBitmap(TransformationUtils.rotateImage((Bitmap) objectRef.element, this.rotation));
                    } else {
                        this.imageView.setImageBitmap(TransformationUtils.rotateImage(combineBitmapOnRightWithBackground(fadeBitmapOnLeft((Bitmap) objectRef.element)), this.rotation));
                    }
                    this.lottieView.setVisibility(4);
                    this.imageView.setVisibility(0);
                    return;
                }
                List<Accessory> accessories5 = currentSkinDefinition.getAccessories();
                accessory = accessories5 != null ? (Accessory) CollectionsKt.random(accessories5, Random.INSTANCE) : null;
                if (accessory != null) {
                    SkinManager companion2 = SkinManager.INSTANCE.getInstance();
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    final String currentSkinCode = companion2.getCurrentSkinCode(context2);
                    detectFacesInBitmap((Bitmap) objectRef.element, new Function1() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LoadingImageViewPlaymat.checkAndCombineImages$lambda$2$0(this.f$0, currentSkinCode, accessory, objectRef, (List) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (this.leftBitmap != null) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                ?? r22 = this.leftBitmap;
                Intrinsics.checkNotNull(r22);
                objectRef2.element = r22;
                if ((this.leftImageUrl.length() > 0 || this.leftScryfallId.length() > 0) && !this.isLeftArtCrop) {
                    objectRef2.element = cropCardImage((Bitmap) objectRef2.element, true);
                }
                SkinManager companion3 = SkinManager.INSTANCE.getInstance();
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                SkinDefinition currentSkinDefinition2 = companion3.getCurrentSkinDefinition(context3);
                boolean z4 = (currentSkinDefinition2 == null || (accessories = currentSkinDefinition2.getAccessories()) == null) ? false : !accessories.isEmpty();
                if (currentSkinDefinition2 == null || !z4) {
                    if (((Bitmap) objectRef2.element).getHeight() > 1000) {
                        ?? CreateScaledBitmap2 = Bitmap.createScaledBitmap((Bitmap) objectRef2.element, (int) ((1000.0f / ((Bitmap) objectRef2.element).getHeight()) * ((Bitmap) objectRef2.element).getWidth()), 1000, true);
                        Intrinsics.checkNotNullExpressionValue(CreateScaledBitmap2, "createScaledBitmap(...)");
                        objectRef2.element = CreateScaledBitmap2;
                    }
                    this.imageView.setImageBitmap(TransformationUtils.rotateImage(combineBitmapOnLeftWithBackground(fadeBitmapOnRightFlipped((Bitmap) objectRef2.element)), this.rotation));
                    this.lottieView.setVisibility(4);
                    this.imageView.setVisibility(0);
                    return;
                }
                List<Accessory> accessories6 = currentSkinDefinition2.getAccessories();
                accessory = accessories6 != null ? (Accessory) CollectionsKt.random(accessories6, Random.INSTANCE) : null;
                if (accessory != null) {
                    SkinManager companion4 = SkinManager.INSTANCE.getInstance();
                    Context context4 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                    final String currentSkinCode2 = companion4.getCurrentSkinCode(context4);
                    detectFacesInBitmap((Bitmap) objectRef2.element, new Function1() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LoadingImageViewPlaymat.checkAndCombineImages$lambda$3$0(this.f$0, currentSkinCode2, accessory, objectRef2, (List) obj);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (bitmapCropCardImage == null || this.leftBitmap == null) {
            return;
        }
        Intrinsics.checkNotNull(bitmapCropCardImage);
        if ((this.imageUrl.length() > 0 || this.scryfallId.length() > 0) && !this.isRightArtCrop) {
            bitmapCropCardImage = cropCardImage(bitmapCropCardImage, false);
        }
        Bitmap bitmapCropCardImage2 = this.leftBitmap;
        Intrinsics.checkNotNull(bitmapCropCardImage2);
        if ((this.leftImageUrl.length() > 0 || this.leftScryfallId.length() > 0) && !this.isLeftArtCrop) {
            bitmapCropCardImage2 = cropCardImage(bitmapCropCardImage2, true);
        }
        if (bitmapCropCardImage.getHeight() > 1000) {
            bitmapCropCardImage = Bitmap.createScaledBitmap(bitmapCropCardImage, (int) ((1000.0f / bitmapCropCardImage.getHeight()) * bitmapCropCardImage.getWidth()), 1000, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCropCardImage, "createScaledBitmap(...)");
        }
        if (bitmapCropCardImage2.getHeight() > 1000) {
            bitmapCropCardImage2 = Bitmap.createScaledBitmap(bitmapCropCardImage2, (int) ((1000.0f / bitmapCropCardImage2.getHeight()) * bitmapCropCardImage2.getWidth()), 1000, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCropCardImage2, "createScaledBitmap(...)");
        }
        Bitmap bitmapFadeBitmapOnRightFlipped = fadeBitmapOnRightFlipped(bitmapCropCardImage2);
        Bitmap bitmapFadeBitmapOnLeft = fadeBitmapOnLeft(bitmapCropCardImage);
        int height3 = bitmapFadeBitmapOnRightFlipped.getHeight();
        if (bitmapFadeBitmapOnLeft.getHeight() > height3) {
            height3 = bitmapFadeBitmapOnLeft.getHeight();
            z = false;
        } else {
            z = true;
        }
        if (z) {
            height = bitmapFadeBitmapOnRightFlipped.getHeight();
            height2 = bitmapFadeBitmapOnLeft.getHeight();
        } else {
            height = bitmapFadeBitmapOnLeft.getHeight();
            height2 = bitmapFadeBitmapOnRightFlipped.getHeight();
        }
        float f = height / height2;
        if (z) {
            int width = (int) (bitmapFadeBitmapOnLeft.getWidth() * f);
            int width2 = (int) (((bitmapFadeBitmapOnRightFlipped.getWidth() + width) * 3.0f) / 4.0f);
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height3, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapFadeBitmapOnRightFlipped, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmapFadeBitmapOnLeft, new Rect(0, 0, bitmapFadeBitmapOnLeft.getWidth(), bitmapFadeBitmapOnLeft.getHeight()), new Rect(width2 - width, 0, width2, height3), (Paint) null);
            SkinManager companion5 = SkinManager.INSTANCE.getInstance();
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            SkinDefinition currentSkinDefinition3 = companion5.getCurrentSkinDefinition(context5);
            boolean z5 = (currentSkinDefinition3 == null || (accessories4 = currentSkinDefinition3.getAccessories()) == null) ? false : !accessories4.isEmpty();
            if (currentSkinDefinition3 == null || !z5) {
                this.imageView.setImageBitmap(TransformationUtils.rotateImage(bitmapCreateBitmap, this.rotation));
                this.lottieView.setVisibility(4);
                this.imageView.setVisibility(0);
                return;
            }
            List<Accessory> accessories7 = currentSkinDefinition3.getAccessories();
            accessory = accessories7 != null ? (Accessory) CollectionsKt.random(accessories7, Random.INSTANCE) : null;
            if (accessory != null) {
                SkinManager companion6 = SkinManager.INSTANCE.getInstance();
                Context context6 = getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                final String currentSkinCode3 = companion6.getCurrentSkinCode(context6);
                detectFacesInBitmap(bitmapCreateBitmap, new Function1() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LoadingImageViewPlaymat.checkAndCombineImages$lambda$0$0(this.f$0, currentSkinCode3, accessory, bitmapCreateBitmap, (List) obj);
                    }
                });
                return;
            }
            return;
        }
        int width3 = (int) (bitmapFadeBitmapOnRightFlipped.getWidth() * f);
        int width4 = (int) (((bitmapFadeBitmapOnLeft.getWidth() + width3) * 3.0f) / 4.0f);
        final Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width4, height3, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        canvas2.drawBitmap(bitmapFadeBitmapOnRightFlipped, new Rect(0, 0, bitmapFadeBitmapOnRightFlipped.getWidth(), bitmapFadeBitmapOnRightFlipped.getHeight()), new Rect(0, 0, width3, height3), (Paint) null);
        canvas2.drawBitmap(bitmapFadeBitmapOnLeft, width4 - bitmapFadeBitmapOnLeft.getWidth(), 0.0f, (Paint) null);
        SkinManager companion7 = SkinManager.INSTANCE.getInstance();
        Context context7 = getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
        SkinDefinition currentSkinDefinition4 = companion7.getCurrentSkinDefinition(context7);
        boolean z6 = (currentSkinDefinition4 == null || (accessories3 = currentSkinDefinition4.getAccessories()) == null) ? false : !accessories3.isEmpty();
        if (currentSkinDefinition4 == null || !z6) {
            this.imageView.setImageBitmap(TransformationUtils.rotateImage(bitmapCreateBitmap2, this.rotation));
            this.lottieView.setVisibility(4);
            this.imageView.setVisibility(0);
            return;
        }
        List<Accessory> accessories8 = currentSkinDefinition4.getAccessories();
        accessory = accessories8 != null ? (Accessory) CollectionsKt.random(accessories8, Random.INSTANCE) : null;
        if (accessory != null) {
            SkinManager companion8 = SkinManager.INSTANCE.getInstance();
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            final String currentSkinCode4 = companion8.getCurrentSkinCode(context8);
            detectFacesInBitmap(bitmapCreateBitmap2, new Function1() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoadingImageViewPlaymat.checkAndCombineImages$lambda$1$0(this.f$0, currentSkinCode4, accessory, bitmapCreateBitmap2, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkAndCombineImages$lambda$0$0(LoadingImageViewPlaymat loadingImageViewPlaymat, String str, Accessory accessory, Bitmap bitmap, List faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context context = loadingImageViewPlaymat.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Bitmap imageFromSkin = companion.getImageFromSkin(context, str, accessory.getFile());
        if (faces.isEmpty() || imageFromSkin == null) {
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(bitmap, loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        } else {
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.overlayStickerOnBitmap(bitmap, faces, imageFromSkin, accessory), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkAndCombineImages$lambda$1$0(LoadingImageViewPlaymat loadingImageViewPlaymat, String str, Accessory accessory, Bitmap bitmap, List faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context context = loadingImageViewPlaymat.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Bitmap imageFromSkin = companion.getImageFromSkin(context, str, accessory.getFile());
        if (faces.isEmpty() || imageFromSkin == null) {
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(bitmap, loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        } else {
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.overlayStickerOnBitmap(bitmap, faces, imageFromSkin, accessory), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, android.graphics.Bitmap, java.lang.Object] */
    public static final Unit checkAndCombineImages$lambda$2$0(LoadingImageViewPlaymat loadingImageViewPlaymat, String str, Accessory accessory, Ref.ObjectRef objectRef, List faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context context = loadingImageViewPlaymat.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Bitmap imageFromSkin = companion.getImageFromSkin(context, str, accessory.getFile());
        if (faces.isEmpty() || imageFromSkin == null) {
            if (((Bitmap) objectRef.element).getHeight() > 1000) {
                ?? CreateScaledBitmap = Bitmap.createScaledBitmap((Bitmap) objectRef.element, (int) ((1000.0f / ((Bitmap) objectRef.element).getHeight()) * ((Bitmap) objectRef.element).getWidth()), 1000, true);
                Intrinsics.checkNotNullExpressionValue(CreateScaledBitmap, "createScaledBitmap(...)");
                objectRef.element = CreateScaledBitmap;
            }
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.combineBitmapOnRightWithBackground(loadingImageViewPlaymat.fadeBitmapOnLeft((Bitmap) objectRef.element)), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        } else {
            Bitmap bitmapOverlayStickerOnBitmap = loadingImageViewPlaymat.overlayStickerOnBitmap((Bitmap) objectRef.element, faces, imageFromSkin, accessory);
            if (bitmapOverlayStickerOnBitmap.getHeight() > 1000) {
                bitmapOverlayStickerOnBitmap = Bitmap.createScaledBitmap(bitmapOverlayStickerOnBitmap, (int) ((1000.0f / bitmapOverlayStickerOnBitmap.getHeight()) * bitmapOverlayStickerOnBitmap.getWidth()), 1000, true);
                Intrinsics.checkNotNullExpressionValue(bitmapOverlayStickerOnBitmap, "createScaledBitmap(...)");
            }
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.combineBitmapOnRightWithBackground(loadingImageViewPlaymat.fadeBitmapOnLeft(bitmapOverlayStickerOnBitmap)), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, android.graphics.Bitmap, java.lang.Object] */
    public static final Unit checkAndCombineImages$lambda$3$0(LoadingImageViewPlaymat loadingImageViewPlaymat, String str, Accessory accessory, Ref.ObjectRef objectRef, List faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context context = loadingImageViewPlaymat.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Bitmap imageFromSkin = companion.getImageFromSkin(context, str, accessory.getFile());
        if (faces.isEmpty() || imageFromSkin == null) {
            if (((Bitmap) objectRef.element).getHeight() > 1000) {
                ?? CreateScaledBitmap = Bitmap.createScaledBitmap((Bitmap) objectRef.element, (int) ((1000.0f / ((Bitmap) objectRef.element).getHeight()) * ((Bitmap) objectRef.element).getWidth()), 1000, true);
                Intrinsics.checkNotNullExpressionValue(CreateScaledBitmap, "createScaledBitmap(...)");
                objectRef.element = CreateScaledBitmap;
            }
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.combineBitmapOnLeftWithBackground(loadingImageViewPlaymat.fadeBitmapOnRightFlipped((Bitmap) objectRef.element)), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        } else {
            Bitmap bitmapOverlayStickerOnBitmap = loadingImageViewPlaymat.overlayStickerOnBitmap((Bitmap) objectRef.element, faces, imageFromSkin, accessory);
            if (bitmapOverlayStickerOnBitmap.getHeight() > 1000) {
                bitmapOverlayStickerOnBitmap = Bitmap.createScaledBitmap(bitmapOverlayStickerOnBitmap, (int) ((1000.0f / bitmapOverlayStickerOnBitmap.getHeight()) * bitmapOverlayStickerOnBitmap.getWidth()), 1000, true);
                Intrinsics.checkNotNullExpressionValue(bitmapOverlayStickerOnBitmap, "createScaledBitmap(...)");
            }
            loadingImageViewPlaymat.imageView.setImageBitmap(TransformationUtils.rotateImage(loadingImageViewPlaymat.combineBitmapOnLeftWithBackground(loadingImageViewPlaymat.fadeBitmapOnRightFlipped(bitmapOverlayStickerOnBitmap)), loadingImageViewPlaymat.rotation));
            loadingImageViewPlaymat.lottieView.setVisibility(4);
            loadingImageViewPlaymat.imageView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    private final Bitmap combineBitmapOnLeftWithBackground(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (int) (0.8f * f), 0, (int) (f * 0.15f), height);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Palette paletteGenerate = Palette.from(bitmapCreateBitmap).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        int dominantColor = paletteGenerate.getDominantColor(-16777216);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        int iAdjustOpacity = companion.adjustOpacity(companion.adjustBrightness(dominantColor, 0.35f));
        int iAdjustOpacity2 = companion.adjustOpacity(companion.adjustBrightness(iAdjustOpacity, 0.2f));
        int iAdjustOpacity3 = companion.adjustOpacity(-16777216);
        int i = (int) (((double) width) * 1.5d);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        ImageSingleton imageSingleton = ImageSingleton.INSTANCE;
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        canvas.drawBitmap(imageSingleton.getBackgroundImage(resources), (Rect) null, new Rect(0, 0, i, height), (Paint) null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        float f2 = i;
        float f3 = f2 / 3.0f;
        paint.setShader(new LinearGradient(f3, 0.0f, f2, 0.0f, new int[]{iAdjustOpacity3, iAdjustOpacity2, iAdjustOpacity}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
        canvas.drawRect(f3, 0.0f, f2, height, paint);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap2;
    }

    private final Bitmap combineBitmapOnRightWithBackground(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) (width * 0.15f), height);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Palette paletteGenerate = Palette.from(bitmapCreateBitmap).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        int dominantColor = paletteGenerate.getDominantColor(-16777216);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        int iAdjustOpacity = companion.adjustOpacity(companion.adjustBrightness(dominantColor, 0.35f));
        int iAdjustOpacity2 = companion.adjustOpacity(companion.adjustBrightness(iAdjustOpacity, 0.2f));
        int iAdjustOpacity3 = companion.adjustOpacity(-16777216);
        int i = (int) (((double) width) * 1.5d);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        ImageSingleton imageSingleton = ImageSingleton.INSTANCE;
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        canvas.drawBitmap(imageSingleton.getBackgroundImage(resources), (Rect) null, new Rect(0, 0, i, height), (Paint) null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        float f = i;
        float f2 = (2.0f * f) / 3.0f;
        paint.setShader(new LinearGradient(0.0f, 0.0f, f2, 0.0f, new int[]{iAdjustOpacity, iAdjustOpacity2, iAdjustOpacity3}, new float[]{0.0f, 0.4f, 1.0f}, Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, f2, height, paint);
        canvas.drawBitmap(bitmap, f / 3.0f, 0.0f, paint);
        return bitmapCreateBitmap2;
    }

    private final Bitmap cropCardImage(Bitmap bitmap, boolean isLeft) {
        int width = bitmap.getWidth();
        int i = (int) (((double) width) * 0.8d);
        double height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - i) / 2, (int) (height * 0.135d), i, (int) (0.4d * height));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    private final void detectFacesInBitmap(Bitmap bitmap, final Function1<? super List<? extends Face>, Unit> callback) {
        InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
        FaceDetectorOptions faceDetectorOptionsBuild = new FaceDetectorOptions.Builder().setPerformanceMode(2).setLandmarkMode(1).setClassificationMode(1).build();
        Intrinsics.checkNotNullExpressionValue(faceDetectorOptionsBuild, "build(...)");
        FaceDetector client = FaceDetection.getClient(faceDetectorOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        Task<List<Face>> taskProcess = client.process(inputImageFromBitmap);
        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoadingImageViewPlaymat.detectFacesInBitmap$lambda$0(callback, (List) obj);
            }
        };
        taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LoadingImageViewPlaymat.detectFacesInBitmap$lambda$2(callback, exc);
            }
        });
    }

    static final Unit detectFacesInBitmap$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        function1.invoke(list);
        return Unit.INSTANCE;
    }

    static final void detectFacesInBitmap$lambda$2(Function1 function1, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        function1.invoke(CollectionsKt.emptyList());
    }

    private final Bitmap fadeBitmapOnLeft(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f = width;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f, 0.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.05f, 0.65f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, 0.0f, f, height, paint);
        return bitmapCreateBitmap;
    }

    private final Bitmap fadeBitmapOnRightFlipped(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        float f = width;
        matrix.postTranslate(f, 0.0f);
        canvas.drawBitmap(bitmap, matrix, null);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f, 0.0f, new int[]{-16777216, -16777216, 0, 0}, new float[]{0.0f, 0.35f, 0.95f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, 0.0f, f, height, paint);
        return bitmapCreateBitmap;
    }

    private final Bitmap overlayStickerOnBitmap(Bitmap original, List<? extends Face> faces, Bitmap sticker, Accessory accessory) {
        Bitmap bitmapCopy = original.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapCopy);
        for (Face face : faces) {
            Intrinsics.checkNotNullExpressionValue(face.getBoundingBox(), "getBoundingBox(...)");
            face.getHeadEulerAngleX();
            float headEulerAngleY = face.getHeadEulerAngleY();
            float headEulerAngleZ = face.getHeadEulerAngleZ();
            Matrix matrix = new Matrix();
            Float scale = accessory.getScale();
            float fFloatValue = scale != null ? scale.floatValue() : 1.0f;
            if (Intrinsics.areEqual(accessory.getType(), "hat")) {
                if (Math.abs(headEulerAngleY) >= 5.0f) {
                    fFloatValue += ((Math.abs(headEulerAngleY) - 5.0f) / 30.0f) * 0.2f;
                }
                float fWidth = r1.width() * fFloatValue;
                float height = (sticker.getHeight() * fWidth) / sticker.getWidth();
                matrix.postScale(fWidth / sticker.getWidth(), height / sticker.getHeight());
                float fSignum = Math.abs(headEulerAngleZ) >= 5.0f ? Math.signum(headEulerAngleZ) * ((Math.abs(headEulerAngleZ) - 5.0f) / 10.0f) * 0.1f * fWidth : 0.0f;
                Float xOffset = accessory.getXOffset();
                float fFloatValue2 = xOffset != null ? xOffset.floatValue() : 0.0f;
                Float yOffset = accessory.getYOffset();
                float f = (fFloatValue2 * fWidth) - fSignum;
                float f2 = fWidth / 2.0f;
                float fCenterX = (r1.centerX() - f2) + f;
                float fFloatValue3 = (r1.top - (0.8f * height)) + ((yOffset != null ? yOffset.floatValue() : 0.0f) * height);
                matrix.postTranslate(fCenterX, fFloatValue3);
                matrix.postRotate(-headEulerAngleZ, fCenterX + f2, fFloatValue3 + (height / 2.0f));
                canvas.drawBitmap(sticker, matrix, null);
            }
        }
        Intrinsics.checkNotNull(bitmapCopy);
        return bitmapCopy;
    }

    public final void adjustFocusBasedOnAspectRatio() {
        this.imageView.adjustFocusBasedOnAspectRatio(this.rotation);
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

    public final boolean getForceFullscreenPlaymats() {
        return this.forceFullscreenPlaymats;
    }

    public final String getImageResourceId() {
        return this.imageResourceId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getLeftImageResourceId() {
        return this.leftImageResourceId;
    }

    public final String getLeftImageUrl() {
        return this.leftImageUrl;
    }

    public final String getLeftPhotoUri() {
        return this.leftPhotoUri;
    }

    public final String getLeftScryfallId() {
        return this.leftScryfallId;
    }

    public final int getLeftSolidColor() {
        return this.leftSolidColor;
    }

    public final String getPhotoUri() {
        return this.photoUri;
    }

    public final int getRightSolidColor() {
        return this.rightSolidColor;
    }

    @Override // android.view.View
    public final int getRotation() {
        return this.rotation;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: isLeftArtCrop, reason: from getter */
    public final boolean getIsLeftArtCrop() {
        return this.isLeftArtCrop;
    }

    /* JADX INFO: renamed from: isRightArtCrop, reason: from getter */
    public final boolean getIsRightArtCrop() {
        return this.isRightArtCrop;
    }

    public final void loadDefault() {
        RightFocusedImageView rightFocusedImageView = this.imageView;
        ImageSingleton imageSingleton = ImageSingleton.INSTANCE;
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        rightFocusedImageView.setImageBitmap(imageSingleton.getBackgroundImage(resources));
        this.lottieView.setVisibility(4);
        this.imageView.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v8, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, java.lang.Object] */
    public final void loadImages() {
        int identifier;
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        final Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isFinishing()) {
            if (activity == null || !activity.isDestroyed()) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("loading_image_view_cropped_load");
                boolean z = this.leftImageUrl.length() > 0 || this.leftImageResourceId.length() > 0 || this.leftPhotoUri.length() > 0 || this.leftScryfallId.length() > 0 || this.leftSolidColor != 0;
                boolean z2 = this.imageUrl.length() > 0 || this.imageResourceId.length() > 0 || this.photoUri.length() > 0 || this.scryfallId.length() > 0 || this.rightSolidColor != 0;
                this.needsTwoBitmaps = false;
                if (z2 && z) {
                    this.needsTwoBitmaps = true;
                }
                if (this.forceFullscreenPlaymats) {
                    this.needsTwoBitmaps = false;
                    z2 = true;
                    z = false;
                }
                if (z) {
                    if (this.leftSolidColor != 0) {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                        new Canvas(bitmapCreateBitmap).drawColor(this.leftSolidColor);
                        this.leftBitmap = bitmapCreateBitmap;
                        checkAndCombineImages();
                    } else if (this.leftImageResourceId.length() > 0 && (identifier = getContext().getResources().getIdentifier(this.leftImageResourceId, "drawable", getContext().getPackageName())) != 0) {
                        Glide.with(this).asBitmap().load(Integer.valueOf(identifier)).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.1
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                LoadingImageViewPlaymat.this.leftBitmap = resource;
                                LoadingImageViewPlaymat.this.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        });
                    }
                    if (this.leftImageUrl.length() > 0) {
                        Glide.with(this).asBitmap().load(this.leftImageUrl).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.2
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                LoadingImageViewPlaymat.this.leftBitmap = resource;
                                LoadingImageViewPlaymat.this.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        });
                    }
                    if (this.leftScryfallId.length() > 0) {
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = this.leftScryfallId;
                        final Ref.IntRef intRef = new Ref.IntRef();
                        if (StringsKt.contains$default((CharSequence) objectRef.element, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            List listSplit$default = StringsKt.split$default((CharSequence) objectRef.element, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                            objectRef.element = listSplit$default.get(0);
                            intRef.element = Integer.parseInt((String) listSplit$default.get(1));
                        }
                        CardImageCache cardImageCache = CardImageCache.INSTANCE;
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        String imageUrl = cardImageCache.getImageUrl(context2, (String) objectRef.element, intRef.element);
                        if (imageUrl == null || ((LoadingImageViewPlaymat$loadImages$3$1) Glide.with(this).asBitmap().load(imageUrl).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$3$1
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                this.this$0.lottieView.setVisibility(4);
                                this.this$0.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                this.this$0.leftBitmap = resource;
                                this.this$0.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        })) == null) {
                            MTApiKt.getMtApi().getCardByScryfallId((String) objectRef.element).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$4$1
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                }

                                @Override // retrofit2.Callback
                                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                                    String imageUrl2;
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (response.isSuccessful()) {
                                        MTCardResponse mTCardResponseBody = response.body();
                                        MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                                        if (card == null || (imageUrl2 = card.getImageUrl(intRef.element)) == null) {
                                            imageUrl2 = "";
                                        }
                                        if (imageUrl2.length() > 0) {
                                            CardImageCache cardImageCache2 = CardImageCache.INSTANCE;
                                            Context context3 = this.getContext();
                                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                                            cardImageCache2.saveImageUrl(context3, objectRef.element, imageUrl2, intRef.element);
                                            RequestBuilder<Bitmap> requestBuilderLoad = Glide.with(this).asBitmap().load(imageUrl2);
                                            final LoadingImageViewPlaymat loadingImageViewPlaymat = this;
                                            final LoadingImageViewPlaymat loadingImageViewPlaymat2 = this;
                                            requestBuilderLoad.into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$4$1$onResponse$1
                                                @Override // com.bumptech.glide.request.target.Target
                                                public void onLoadCleared(Drawable placeholder) {
                                                }

                                                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                                                public void onLoadFailed(Drawable errorDrawable) {
                                                    loadingImageViewPlaymat2.lottieView.setVisibility(4);
                                                    loadingImageViewPlaymat2.imageView.setVisibility(0);
                                                }

                                                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                                    Intrinsics.checkNotNullParameter(resource, "resource");
                                                    loadingImageViewPlaymat.leftBitmap = resource;
                                                    loadingImageViewPlaymat.checkAndCombineImages();
                                                }

                                                @Override // com.bumptech.glide.request.target.Target
                                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                                }
                                            });
                                        }
                                    }
                                }
                            });
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (this.leftPhotoUri.length() > 0) {
                        Glide.with(this).asBitmap().load(this.leftPhotoUri).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.5
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                LoadingImageViewPlaymat.this.leftBitmap = resource;
                                LoadingImageViewPlaymat.this.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        });
                    }
                }
                if (z2) {
                    if (this.rightSolidColor != 0) {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
                        new Canvas(bitmapCreateBitmap2).drawColor(this.rightSolidColor);
                        this.rightBitmap = bitmapCreateBitmap2;
                        checkAndCombineImages();
                    } else if (this.imageResourceId.length() > 0) {
                        if (StringsKt.contains$default((CharSequence) this.imageResourceId, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            List listSplit$default2 = StringsKt.split$default((CharSequence) this.imageResourceId, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                            String str = (String) listSplit$default2.get(0);
                            String str2 = (String) listSplit$default2.get(1);
                            SkinManager companion = SkinManager.INSTANCE.getInstance();
                            Context context3 = getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            Bitmap imageFromSkin = companion.getImageFromSkin(context3, str, str2);
                            if (imageFromSkin != null) {
                                this.rightBitmap = imageFromSkin;
                                this.forceFullscreenPlaymats = true;
                                checkAndCombineImages();
                                return;
                            }
                            return;
                        }
                        int identifier2 = getContext().getResources().getIdentifier(this.imageResourceId, "drawable", getContext().getPackageName());
                        if (identifier2 != 0) {
                            Glide.with(this).asBitmap().load(Integer.valueOf(identifier2)).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.7
                                @Override // com.bumptech.glide.request.target.Target
                                public void onLoadCleared(Drawable placeholder) {
                                }

                                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                                public void onLoadFailed(Drawable errorDrawable) {
                                    LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                    LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                                }

                                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                    Intrinsics.checkNotNullParameter(resource, "resource");
                                    LoadingImageViewPlaymat.this.rightBitmap = resource;
                                    LoadingImageViewPlaymat.this.checkAndCombineImages();
                                }

                                @Override // com.bumptech.glide.request.target.Target
                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                }
                            });
                        }
                    }
                    if (this.imageUrl.length() > 0) {
                        Glide.with(this).asBitmap().load(this.imageUrl).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.8
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                LoadingImageViewPlaymat.this.rightBitmap = resource;
                                LoadingImageViewPlaymat.this.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        });
                    }
                    if (this.scryfallId.length() > 0) {
                        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = this.scryfallId;
                        final Ref.IntRef intRef2 = new Ref.IntRef();
                        if (StringsKt.contains$default((CharSequence) objectRef2.element, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            List listSplit$default3 = StringsKt.split$default((CharSequence) objectRef2.element, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                            objectRef2.element = listSplit$default3.get(0);
                            intRef2.element = Integer.parseInt((String) listSplit$default3.get(1));
                        }
                        CardImageCache cardImageCache2 = CardImageCache.INSTANCE;
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        String imageUrl2 = cardImageCache2.getImageUrl(context4, (String) objectRef2.element, intRef2.element);
                        if (imageUrl2 == null || ((LoadingImageViewPlaymat$loadImages$9$1) Glide.with(this).asBitmap().load(imageUrl2).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$9$1
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                this.this$0.lottieView.setVisibility(4);
                                this.this$0.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                this.this$0.rightBitmap = resource;
                                this.this$0.checkAndCombineImages();
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }
                        })) == null) {
                            MTApiKt.getMtApi().getCardByScryfallId((String) objectRef2.element).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$10$1
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                    Log.d("LoadingImageViewPlaymat", "Failed to fetch card data for Scryfall ID: " + ((Object) objectRef2.element), t);
                                }

                                @Override // retrofit2.Callback
                                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                                    String imageUrl3;
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (response.isSuccessful()) {
                                        MTCardResponse mTCardResponseBody = response.body();
                                        MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                                        if (card == null || (imageUrl3 = card.getImageUrl(intRef2.element)) == null) {
                                            imageUrl3 = "";
                                        }
                                        if (imageUrl3.length() > 0) {
                                            CardImageCache cardImageCache3 = CardImageCache.INSTANCE;
                                            Context context5 = this.getContext();
                                            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                                            cardImageCache3.saveImageUrl(context5, objectRef2.element, imageUrl3, intRef2.element);
                                            Activity activity2 = activity;
                                            if (activity2 == null || !activity2.isFinishing()) {
                                                Activity activity3 = activity;
                                                if (activity3 == null || !activity3.isDestroyed()) {
                                                    RequestBuilder<Bitmap> requestBuilderLoad = Glide.with(this).asBitmap().load(imageUrl3);
                                                    final LoadingImageViewPlaymat loadingImageViewPlaymat = this;
                                                    final LoadingImageViewPlaymat loadingImageViewPlaymat2 = this;
                                                    requestBuilderLoad.into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat$loadImages$10$1$onResponse$1
                                                        @Override // com.bumptech.glide.request.target.Target
                                                        public void onLoadCleared(Drawable placeholder) {
                                                        }

                                                        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                                                        public void onLoadFailed(Drawable errorDrawable) {
                                                            loadingImageViewPlaymat2.lottieView.setVisibility(4);
                                                            loadingImageViewPlaymat2.imageView.setVisibility(0);
                                                        }

                                                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                                            Intrinsics.checkNotNullParameter(resource, "resource");
                                                            loadingImageViewPlaymat.rightBitmap = resource;
                                                            loadingImageViewPlaymat.checkAndCombineImages();
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
                                }
                            });
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    if (this.photoUri.length() > 0) {
                        Glide.with(this).asBitmap().load(this.photoUri).into(new CustomTarget<Bitmap>() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.loadImages.11
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                            public void onLoadFailed(Drawable errorDrawable) {
                                LoadingImageViewPlaymat.this.lottieView.setVisibility(4);
                                LoadingImageViewPlaymat.this.imageView.setVisibility(0);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                LoadingImageViewPlaymat.this.rightBitmap = resource;
                                LoadingImageViewPlaymat.this.checkAndCombineImages();
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
    }

    public final void loadSingleImage(Bitmap bitmap, int imageRotation) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.rotation = imageRotation;
        this.rightBitmap = bitmap;
        if (this.autoLoad) {
            return;
        }
        checkAndCombineImages();
    }

    public final void loadSingleImage(String url, int imageRotation) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.rotation = imageRotation;
        this.imageUrl = url;
        if (this.autoLoad) {
            return;
        }
        loadImages();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.LoadingImageViewPlaymat.onAttachedToWindow.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LoadingImageViewPlaymat.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (LoadingImageViewPlaymat.this.getAutoLoad()) {
                    LoadingImageViewPlaymat.this.loadImages();
                }
            }
        });
    }

    public final void removeBackgroundColor() {
        setBackgroundColor(0);
        this.imageView.setBackgroundColor(0);
    }

    public final void removeGrayScale() {
        this.imageView.setColorFilter((ColorFilter) null);
    }

    public final void reset() {
        this.rightBitmap = null;
        this.leftBitmap = null;
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final void setForceFullscreenPlaymats(boolean z) {
        this.forceFullscreenPlaymats = z;
    }

    public final void setGrayScale() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public final void setImageResourceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageResourceId = str;
    }

    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setLeftArtCrop(boolean z) {
        this.isLeftArtCrop = z;
    }

    public final void setLeftImageResourceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftImageResourceId = str;
    }

    public final void setLeftImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftImageUrl = str;
    }

    public final void setLeftPhotoUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftPhotoUri = str;
    }

    public final void setLeftScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftScryfallId = str;
    }

    public final void setLeftSolidColor(int i) {
        this.leftSolidColor = i;
    }

    public final void setPhotoUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoUri = str;
    }

    public final void setRightArtCrop(boolean z) {
        this.isRightArtCrop = z;
    }

    public final void setRightSolidColor(int i) {
        this.rightSolidColor = i;
    }

    public final void setRotation(int i) {
        this.rotation = i;
    }

    public final void setScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfallId = str;
    }

    public final void showLoading() {
        this.lottieView.setVisibility(0);
        this.imageView.setVisibility(4);
    }
}
