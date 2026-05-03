package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "clickLocation", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$1", f = "TextFieldSelectionManager.kt", i = {0}, l = {228, 230}, m = "invokeSuspend", n = {"clickLocation"}, s = {"J$0"}, v = 1)
final class TextFieldSelectionManager$contextMenuAreaModifier$1 extends SuspendLambda implements Function2<Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$contextMenuAreaModifier$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$contextMenuAreaModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextFieldSelectionManager$contextMenuAreaModifier$1 textFieldSelectionManager$contextMenuAreaModifier$1 = new TextFieldSelectionManager$contextMenuAreaModifier$1(this.this$0, continuation);
        textFieldSelectionManager$contextMenuAreaModifier$1.J$0 = ((Offset) obj).m6090unboximpl();
        return textFieldSelectionManager$contextMenuAreaModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Unit> continuation) {
        return m2887invoke3MmeM6k(offset.m6090unboximpl(), continuation);
    }

    /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m2887invoke3MmeM6k(long j, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$contextMenuAreaModifier$1) create(Offset.m6069boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r6.mo2809onShowContextMenu_2OEclM(r5, r8, r10, r12) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j2 = this.J$0;
            this.J$0 = j2;
            this.label = 1;
            if (this.this$0.updateClipboardEntry$foundation(this) != coroutine_suspended) {
                j = j2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        j = this.J$0;
        ResultKt.throwOnFailure(obj);
        Pair contextTextAndSelection = this.this$0.getContextTextAndSelection();
        if (contextTextAndSelection != null) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            String str = (String) contextTextAndSelection.component1();
            long packedValue = ((TextRange) contextTextAndSelection.component2()).getPackedValue();
            PlatformSelectionBehaviors platformSelectionBehaviors = textFieldSelectionManager.getPlatformSelectionBehaviors();
            if (platformSelectionBehaviors != null) {
                Offset offsetM6069boximpl = Offset.m6069boximpl(j);
                this.label = 2;
            }
        }
        return Unit.INSTANCE;
    }
}
