package androidx.compose.ui.layout;

import androidx.collection.IntList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutPausableCompositionException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "operations", "Landroidx/collection/IntList;", "slotId", "", "cause", "", "<init>", "(Landroidx/collection/IntList;Ljava/lang/Object;Ljava/lang/Throwable;)V", "operationsList", "", "", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SubcomposeLayoutPausableCompositionException extends IllegalStateException {
    private final IntList operations;
    private final Object slotId;

    public SubcomposeLayoutPausableCompositionException(IntList intList, Object obj, Throwable th) {
        super(th);
        this.operations = intList;
        this.slotId = obj;
    }

    public static /* synthetic */ void getMessage$annotations() {
    }

    private final List<String> operationsList() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (int i = this.operations._size - 1; i >= 0; i--) {
            int i2 = this.operations.get(i);
            int iM7852constructorimpl = SLOperation.m7852constructorimpl(i2);
            listCreateListBuilder.add(i + ": " + (SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7859getCancelPausedPrecompositionNjRlDlw()) ? "CancelPausedPrecomposition" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7865getReuseForceSyncDeactivationNjRlDlw()) ? "ReuseForceSyncDeactivation" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7866getReuseScheduleOutOfFrameDeactivationNjRlDlw()) ? "ReuseScheduleOutOfFrameDeactivation" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7867getReuseSyncDeactivationNjRlDlw()) ? "ReuseSyncDeactivation" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7864getReuseDeactivationViaHostNjRlDlw()) ? "ReuseDeactivationViaHost" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7875getTookFromPrecomposeMapNjRlDlw()) ? "TookFromPrecomposeMap" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7871getSubcomposeNjRlDlw()) ? "Subcompose" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7873getSubcomposeNewNjRlDlw()) ? "SubcomposeNew" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7874getSubcomposePausableNjRlDlw()) ? "SubcomposePausable" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7872getSubcomposeForceReuseNjRlDlw()) ? "SubcomposeForceReuse" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7860getDeactivateOutOfFrameNjRlDlw()) ? "DeactivateOutOfFrame" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7861getDeactivateOutOfFrameCancelledNjRlDlw()) ? "DeactivateOutOfFrameCancelled" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7869getSlotToReusedFromOnDeactivateNjRlDlw()) ? "SlotToReusedFromOnDeactivate" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7870getSlotToReusedFromOnReuseNjRlDlw()) ? "SlotToReusedFromOnReuse" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7868getReusedNjRlDlw()) ? "Reused" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7863getResumePausedNjRlDlw()) ? "ResumePaused" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7862getPausePausedNjRlDlw()) ? "PausePaused" : SLOperation.m7854equalsimpl0(iM7852constructorimpl, SLOperation.INSTANCE.m7858getApplyPausedNjRlDlw()) ? "ApplyPaused" : "Unexpected " + i2));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringsKt.trimMargin$default("\n            |slotid=" + this.slotId + ". Last operations:\n            |" + CollectionsKt.joinToString$default(operationsList(), "\n", null, null, 0, null, null, 62, null) + "\n            ", null, 1, null);
    }
}
