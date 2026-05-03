package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "cacheable", "", "getCacheable$ui_text", "()Z", "setCacheable$ui_text", "(Z)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;

    /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncFontListLoader$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0, 0, 1, 1}, l = {281, 295}, m = "load", n = {"$this$fastForEach$iv", "font", "index$iv", "$this$fastForEach$iv", "index$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsyncFontListLoader.this.load(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader) {
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
    }

    private void setValue(Object obj) {
        this.value.setValue(obj);
    }

    /* JADX INFO: renamed from: getCacheable$ui_text, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
    
        if (kotlinx.coroutines.YieldKt.yield(r15) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0109, blocks: (B:13:0x0034, B:31:0x00a0, B:34:0x00d4, B:18:0x004d, B:21:0x0057), top: B:46:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0109, blocks: (B:13:0x0034, B:31:0x00a0, B:34:0x00d4, B:18:0x004d, B:21:0x0057), top: B:46:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:38:0x00e8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00e2 -> B:37:0x00e5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        List<Font> list;
        int size;
        AnonymousClass1 anonymousClass12;
        int i;
        Font font;
        List<Font> list2;
        int i2;
        Font font2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass13 = anonymousClass1;
        Object obj = anonymousClass13.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass13.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.fontList;
            size = list.size();
            anonymousClass12 = anonymousClass13;
            i = 0;
            if (i < size) {
            }
        } else {
            if (i3 == 1) {
                size = anonymousClass13.I$1;
                i2 = anonymousClass13.I$0;
                Font font3 = (Font) anonymousClass13.L$1;
                List<Font> list3 = (List) anonymousClass13.L$0;
                ResultKt.throwOnFailure(obj);
                font = font3;
                list2 = list3;
                if (obj == null) {
                }
                boolean zIsActive = JobKt.isActive(anonymousClass13.get$context());
                this.cacheable = false;
                this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), zIsActive));
                throw th;
            }
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = anonymousClass13.I$1;
            i2 = anonymousClass13.I$0;
            list2 = (List) anonymousClass13.L$0;
            ResultKt.throwOnFailure(obj);
            anonymousClass12 = anonymousClass13;
            i = i2;
            list = list2;
            i++;
            if (i < size) {
                try {
                    font2 = list.get(i);
                } catch (Throwable th2) {
                    th = th2;
                    anonymousClass13 = anonymousClass12;
                }
                if (FontLoadingStrategy.m8655equalsimpl0(font2.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m8659getAsyncPKNRLFQ())) {
                    AsyncTypefaceCache asyncTypefaceCache = this.asyncTypefaceCache;
                    PlatformFontLoader platformFontLoader = this.platformFontLoader;
                    AsyncFontListLoader$load$2$typeface$1 asyncFontListLoader$load$2$typeface$1 = new AsyncFontListLoader$load$2$typeface$1(this, font2, null);
                    anonymousClass12.L$0 = list;
                    anonymousClass12.L$1 = font2;
                    anonymousClass12.I$0 = i;
                    anonymousClass12.I$1 = size;
                    anonymousClass12.label = 1;
                    Object objRunCached = asyncTypefaceCache.runCached(font2, platformFontLoader, false, asyncFontListLoader$load$2$typeface$1, anonymousClass12);
                    if (objRunCached != coroutine_suspended) {
                        font = font2;
                        list2 = list;
                        obj = objRunCached;
                        i2 = i;
                        anonymousClass13 = anonymousClass12;
                        if (obj == null) {
                            setValue(FontSynthesis_androidKt.m8690synthesizeTypefaceFxwP2eA(this.typefaceRequest.m8715getFontSynthesisGVVA2EU(), obj, font, this.typefaceRequest.getFontWeight(), this.typefaceRequest.m8714getFontStyle_LCdwA()));
                            Unit unit = Unit.INSTANCE;
                            boolean zIsActive2 = JobKt.isActive(anonymousClass13.get$context());
                            this.cacheable = false;
                            this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), zIsActive2));
                            return unit;
                        }
                        anonymousClass13.L$0 = list2;
                        anonymousClass13.L$1 = null;
                        anonymousClass13.I$0 = i2;
                        anonymousClass13.I$1 = size;
                        anonymousClass13.label = 2;
                        boolean zIsActive3 = JobKt.isActive(anonymousClass13.get$context());
                        this.cacheable = false;
                        this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), zIsActive3));
                        throw th;
                    }
                    return coroutine_suspended;
                }
                i++;
                if (i < size) {
                    boolean zIsActive4 = JobKt.isActive(anonymousClass12.get$context());
                    this.cacheable = false;
                    this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), zIsActive4));
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text(Font font, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
            asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
            if ((asyncFontListLoader$loadWithTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$loadWithTimeoutOrNull$1.label -= Integer.MIN_VALUE;
            } else {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
            }
        }
        Object obj = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, font, null);
            asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = font;
            asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$1);
            return objWithTimeoutOrNull == coroutine_suspended ? coroutine_suspended : objWithTimeoutOrNull;
        } catch (CancellationException e) {
            if (!JobKt.isActive(asyncFontListLoader$loadWithTimeoutOrNull$1.get$context())) {
                throw e;
            }
            return null;
        } catch (Exception e2) {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) asyncFontListLoader$loadWithTimeoutOrNull$1.get$context().get(CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(asyncFontListLoader$loadWithTimeoutOrNull$1.get$context(), new IllegalStateException("Unable to load font " + font, e2));
            }
            return null;
        }
    }

    public final void setCacheable$ui_text(boolean z) {
        this.cacheable = z;
    }
}
