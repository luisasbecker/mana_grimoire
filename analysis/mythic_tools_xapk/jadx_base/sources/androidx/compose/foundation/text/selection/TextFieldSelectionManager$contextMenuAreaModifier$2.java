package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRange;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$2", f = "TextFieldSelectionManager.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 243}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextFieldSelectionManager$contextMenuAreaModifier$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$contextMenuAreaModifier$2(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$contextMenuAreaModifier$2> continuation) {
        super(1, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TextFieldSelectionManager$contextMenuAreaModifier$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$contextMenuAreaModifier$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r8.mo2810onShowSelectionToolbarSbBc2M(r4, r5, r7) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.updateClipboardEntry$foundation(this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setTextToolbarShownViaProvider$foundation(true);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Pair contextTextAndSelection = this.this$0.getContextTextAndSelection();
        if (contextTextAndSelection != null) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            String str = (String) contextTextAndSelection.component1();
            long packedValue = ((TextRange) contextTextAndSelection.component2()).getPackedValue();
            PlatformSelectionBehaviors platformSelectionBehaviors = textFieldSelectionManager.getPlatformSelectionBehaviors();
            if (platformSelectionBehaviors != null) {
                this.label = 2;
            }
        }
        this.this$0.setTextToolbarShownViaProvider$foundation(true);
        return Unit.INSTANCE;
    }
}
