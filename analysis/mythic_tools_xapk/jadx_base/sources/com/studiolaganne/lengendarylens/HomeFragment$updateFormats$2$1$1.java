package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateFormats$2$1$1", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HomeFragment$updateFormats$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MTFormat> $formats;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$updateFormats$2$1$1(HomeFragment homeFragment, List<MTFormat> list, Continuation<? super HomeFragment$updateFormats$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
        this.$formats = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$updateFormats$2$1$1(this.this$0, this.$formats, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$updateFormats$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DecksDBHelper companion2 = companion.getInstance(contextRequireContext);
        companion2.clearFormats();
        companion2.clearSubformats();
        companion2.addFormats(this.$formats);
        for (MTFormat mTFormat : this.$formats) {
            List<MTSubformat> subformats = mTFormat.getSubformats();
            if (subformats != null) {
                Iterator<T> it = subformats.iterator();
                while (it.hasNext()) {
                    companion2.addSubformat((MTSubformat) it.next(), mTFormat);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
