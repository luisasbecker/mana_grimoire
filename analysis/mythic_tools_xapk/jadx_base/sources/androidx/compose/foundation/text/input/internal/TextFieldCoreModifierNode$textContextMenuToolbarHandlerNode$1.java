package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextFieldCoreModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1", f = "TextFieldCoreModifier.kt", i = {}, l = {209, 210}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1> continuation) {
        super(1, continuation);
        this.this$0 = textFieldCoreModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r8.mo2810onShowSelectionToolbarSbBc2M(r7.this$0.textFieldSelectionState.getTextFieldState().getVisualText().getText(), r7.this$0.textFieldSelectionState.getTextFieldState().getVisualText().getSelection(), r7) == r0) goto L17;
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
            if (this.this$0.textFieldSelectionState.updateClipboardEntry(this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.textFieldSelectionState.setTextToolbarShown$foundation(true);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        PlatformSelectionBehaviors platformSelectionBehaviors = this.this$0.platformSelectionBehaviors;
        if (platformSelectionBehaviors != null) {
            this.label = 2;
        }
        this.this$0.textFieldSelectionState.setTextToolbarShown$foundation(true);
        return Unit.INSTANCE;
    }
}
