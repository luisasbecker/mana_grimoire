package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TextContextMenuToolbarHandlerModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Be\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u001e\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0005J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\tH\u0016J\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\tJ\u0017\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rH\u0016¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R4\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "onShow", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRequester", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setRequester", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "getOnShow", "()Lkotlin/jvm/functions/Function1;", "setOnShow", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "getOnHide", "setOnHide", "getComputeContentBounds", "setComputeContentBounds", "textToolbarJob", "Lkotlinx/coroutines/Job;", "derivedData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "getDerivedData", "()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "derivedData$delegate", "Landroidx/compose/runtime/State;", "previousContentBounds", "update", "toolbarRequester", "onAttach", "onDetach", "show", "hide", "position", "Landroidx/compose/ui/geometry/Offset;", "destinationCoordinates", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, TextContextMenuDataProvider {
    public static final int $stable = 8;
    private Function1<? super LayoutCoordinates, Rect> computeContentBounds;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onHide;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onShow;
    private ToolbarRequester requester;
    private Job textToolbarJob;

    /* JADX INFO: renamed from: derivedData$delegate, reason: from kotlin metadata */
    private final State derivedData = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextContextMenuToolbarHandlerNode.derivedData_delegate$lambda$0(this.f$0);
        }
    });
    private Rect previousContentBounds = Rect.INSTANCE.getZero();

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextContextMenuToolbarHandlerModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1", f = "TextContextMenuToolbarHandlerModifier.kt", i = {}, l = {MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 206, 208, 208}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextContextMenuProvider $provider;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextContextMenuProvider textContextMenuProvider, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$provider = textContextMenuProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextContextMenuToolbarHandlerNode.this.new AnonymousClass1(this.$provider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        
            if (r7.invoke(r6) == r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            Function1<Continuation<? super Unit>, Object> onHide;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Throwable th2) {
                Function1<Continuation<? super Unit>, Object> onHide2 = TextContextMenuToolbarHandlerNode.this.getOnHide();
                if (onHide2 == null) {
                    throw th2;
                }
                this.L$0 = th2;
                this.label = 4;
                if (onHide2.invoke(this) != coroutine_suspended) {
                    th = th2;
                }
                return coroutine_suspended;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> onShow = TextContextMenuToolbarHandlerNode.this.getOnShow();
                if (onShow != null) {
                    this.label = 1;
                    if (onShow.invoke(this) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        onHide = TextContextMenuToolbarHandlerNode.this.getOnHide();
                        if (onHide != null) {
                            this.label = 3;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (this.$provider.showTextContextMenu(TextContextMenuToolbarHandlerNode.this, this) != coroutine_suspended) {
                onHide = TextContextMenuToolbarHandlerNode.this.getOnHide();
                if (onHide != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    public TextContextMenuToolbarHandlerNode(ToolbarRequester toolbarRequester, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Function1<? super LayoutCoordinates, Rect> function13) {
        this.requester = toolbarRequester;
        this.onShow = function1;
        this.onHide = function12;
        this.computeContentBounds = function13;
    }

    static final TextContextMenuData derivedData_delegate$lambda$0(TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode) {
        return textContextMenuToolbarHandlerNode.getIsAttached() ? TextContextMenuModifierKt.collectTextContextMenuData(textContextMenuToolbarHandlerNode) : TextContextMenuData.INSTANCE.getEmpty();
    }

    private final TextContextMenuData getDerivedData() {
        return (TextContextMenuData) this.derivedData.getValue();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public Rect contentBounds(LayoutCoordinates destinationCoordinates) {
        Rect rectInvoke;
        if (getIsAttached() && (rectInvoke = this.computeContentBounds.invoke(destinationCoordinates)) != null) {
            this.previousContentBounds = rectInvoke;
            return rectInvoke;
        }
        return this.previousContentBounds;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public TextContextMenuData data() {
        return getDerivedData();
    }

    public final Function1<LayoutCoordinates, Rect> getComputeContentBounds() {
        return this.computeContentBounds;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnHide() {
        return this.onHide;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnShow() {
        return this.onShow;
    }

    public final ToolbarRequester getRequester() {
        return this.requester;
    }

    public final void hide() {
        Job job = this.textToolbarJob;
        if (job == null) {
            return;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        this.textToolbarJob = null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.requester.setToolbarHandlerState$foundation(ToolbarHandlerState.Attached);
        this.requester.setToolbarHandlerNode$foundation(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.requester.setToolbarHandlerState$foundation(ToolbarHandlerState.Detached);
        this.requester.setToolbarHandlerNode$foundation(null);
        super.onDetach();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    /* JADX INFO: renamed from: position-tuRUvjQ */
    public long mo2538positiontuRUvjQ(LayoutCoordinates destinationCoordinates) {
        return contentBounds(destinationCoordinates).m6115getTopLeftF1C5BW0();
    }

    public final void setComputeContentBounds(Function1<? super LayoutCoordinates, Rect> function1) {
        this.computeContentBounds = function1;
    }

    public final void setOnHide(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        this.onHide = function1;
    }

    public final void setOnShow(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        this.onShow = function1;
    }

    public final void setRequester(ToolbarRequester toolbarRequester) {
        this.requester = toolbarRequester;
    }

    public final void show() {
        TextContextMenuProvider textContextMenuProvider;
        if (getIsAttached()) {
            Job job = this.textToolbarJob;
            if ((job == null || !job.isActive()) && (textContextMenuProvider = (TextContextMenuProvider) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider())) != null) {
                this.textToolbarJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(textContextMenuProvider, null), 1, null);
            }
        }
    }

    public final void update(ToolbarRequester toolbarRequester) {
        this.requester.setToolbarHandlerNode$foundation(null);
        this.requester = toolbarRequester;
        toolbarRequester.setToolbarHandlerNode$foundation(this);
        this.requester.setToolbarHandlerState$foundation(getIsAttached() ? ToolbarHandlerState.Attached : ToolbarHandlerState.Detached);
    }
}
