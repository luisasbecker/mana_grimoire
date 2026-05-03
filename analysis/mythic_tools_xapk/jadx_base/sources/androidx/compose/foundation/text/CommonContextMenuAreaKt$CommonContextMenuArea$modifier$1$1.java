package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: CommonContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "clickLocation", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1", f = "CommonContextMenuArea.kt", i = {0}, l = {Imgproc.COLOR_BGR2YUV, Imgproc.COLOR_RGB2YUV}, m = "invokeSuspend", n = {"clickLocation"}, s = {"J$0"}, v = 1)
final class CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 extends SuspendLambda implements Function2<Offset, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    /* synthetic */ long J$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1> continuation) {
        super(2, continuation);
        this.$selectionState = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 = new CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(this.$selectionState, continuation);
        commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1.J$0 = ((Offset) obj).m6090unboximpl();
        return commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Unit> continuation) {
        return m2384invoke3MmeM6k(offset.m6090unboximpl(), continuation);
    }

    /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m2384invoke3MmeM6k(long j, Continuation<? super Unit> continuation) {
        return ((CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1) create(Offset.m6069boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        if (r5.mo2809onShowContextMenu_2OEclM(r11.$selectionState.getTextFieldState().getVisualText().getText(), r11.$selectionState.getTextFieldState().getVisualText().getSelection(), androidx.compose.ui.geometry.Offset.m6069boximpl(r3), r11) == r0) goto L18;
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
            if (this.$selectionState.updateClipboardEntry(this) != coroutine_suspended) {
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
        PlatformSelectionBehaviors platformSelectionBehaviors = this.$selectionState.getPlatformSelectionBehaviors();
        if (platformSelectionBehaviors != null) {
            this.label = 2;
        }
        return Unit.INSTANCE;
    }
}
