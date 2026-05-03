package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "loadBlocking", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFontLoader.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", i = {1}, l = {55, 57}, m = "awaitLoad", n = {"font"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r7 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super android.graphics.Typeface> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objLoadAsync = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadAsync);
            if (font instanceof AndroidFont) {
                AndroidFont androidFont = (AndroidFont) font;
                AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                Context context = this.context;
                anonymousClass1.label = 1;
                Object objAwaitLoad = typefaceLoader.awaitLoad(context, androidFont, anonymousClass1);
                if (objAwaitLoad != coroutine_suspended) {
                    return objAwaitLoad;
                }
            } else {
                if (!(font instanceof ResourceFont)) {
                    throw new IllegalArgumentException("Unknown font type: " + font);
                }
                Context context2 = this.context;
                anonymousClass1.L$0 = font;
                anonymousClass1.label = 2;
                objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, anonymousClass1);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objLoadAsync);
            return objLoadAsync;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        font = (Font) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objLoadAsync);
        return PlatformTypefaces_androidKt.setFontVariationSettings((android.graphics.Typeface) objLoadAsync, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) {
        Object objM11445constructorimpl;
        android.graphics.Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        ResourceFont resourceFont = (ResourceFont) font;
        int loadingStrategy = resourceFont.getLoadingStrategy();
        if (FontLoadingStrategy.m8655equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8660getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load(resourceFont, this.context);
        } else {
            if (!FontLoadingStrategy.m8655equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8661getOptionalLocalPKNRLFQ())) {
                if (FontLoadingStrategy.m8655equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8659getAsyncPKNRLFQ())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m8657toStringimpl(resourceFont.getLoadingStrategy())));
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader androidFontLoader = this;
                objM11445constructorimpl = Result.m11445constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (android.graphics.Typeface) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, resourceFont.getVariationSettings(), this.context);
    }
}
