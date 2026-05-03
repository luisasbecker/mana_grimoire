package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DefaultPaywallView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$1$1", f = "DefaultPaywallView.kt", i = {}, l = {100, 104}, m = "invokeSuspend", n = {}, s = {})
final class DefaultPaywallViewKt$DefaultPaywallView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Bitmap> $appIconBitmap$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<Color>> $prominentColors$delegate;
    final /* synthetic */ List<Color> $providedProminentColors;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultPaywallViewKt$DefaultPaywallView$1$1(List<Color> list, MutableState<Bitmap> mutableState, MutableState<List<Color>> mutableState2, Context context, Continuation<? super DefaultPaywallViewKt$DefaultPaywallView$1$1> continuation) {
        super(2, continuation);
        this.$providedProminentColors = list;
        this.$appIconBitmap$delegate = mutableState;
        this.$prominentColors$delegate = mutableState2;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultPaywallViewKt$DefaultPaywallView$1$1(this.$providedProminentColors, this.$appIconBitmap$delegate, this.$prominentColors$delegate, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultPaywallViewKt$DefaultPaywallView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r12 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r12 == r0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableState<List<Color>> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$providedProminentColors != null) {
                if (DefaultPaywallViewKt.DefaultPaywallView$lambda$3(this.$appIconBitmap$delegate) == null) {
                    this.L$0 = null;
                    this.label = 2;
                    obj = BuildersKt.withContext(Dispatchers.getDefault(), new DefaultPaywallViewKt$DefaultPaywallView$1$1$bitmap$1(this.$context, null), this);
                }
                return Unit.INSTANCE;
            }
            mutableState = this.$prominentColors$delegate;
            this.L$0 = mutableState;
            this.label = 1;
            obj = AppStyleExtractor.getProminentColorsFromBitmap$default(AppStyleExtractor.INSTANCE, DefaultPaywallViewKt.DefaultPaywallView$lambda$3(this.$appIconBitmap$delegate), 2, null, this, 4, null);
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$appIconBitmap$delegate.setValue((Bitmap) obj);
            return Unit.INSTANCE;
        }
        mutableState = (MutableState) this.L$0;
        ResultKt.throwOnFailure(obj);
        mutableState.setValue((List) obj);
        if (DefaultPaywallViewKt.DefaultPaywallView$lambda$3(this.$appIconBitmap$delegate) == null) {
        }
        return Unit.INSTANCE;
    }
}
