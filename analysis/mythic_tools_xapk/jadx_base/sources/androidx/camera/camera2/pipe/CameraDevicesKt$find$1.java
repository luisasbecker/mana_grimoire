package androidx.camera.camera2.pipe;

import androidx.media3.muxer.WebmConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CameraDevices.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/camera/camera2/pipe/CameraMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.CameraDevicesKt$find$1", f = "CameraDevices.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4}, l = {197, 203, 206, WebmConstants.MkvEbmlElement.TRACK_NUMBER, 221}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "visited", "emitted", "$this$flow", "visited", "emitted", "$this$flow", "visited", "physicalId", "$this$flow", "visited"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$4", "L$0", "L$1"}, v = 1)
final class CameraDevicesKt$find$1 extends SuspendLambda implements Function2<FlowCollector<? super CameraMetadata>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cameraBackendId;
    final /* synthetic */ boolean $includePhysicalCameraMetadata;
    final /* synthetic */ CameraDevices $this_find;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraDevicesKt$find$1(CameraDevices cameraDevices, String str, boolean z, Continuation<? super CameraDevicesKt$find$1> continuation) {
        super(2, continuation);
        this.$this_find = cameraDevices;
        this.$cameraBackendId = str;
        this.$includePhysicalCameraMetadata = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraDevicesKt$find$1 cameraDevicesKt$find$1 = new CameraDevicesKt$find$1(this.$this_find, this.$cameraBackendId, this.$includePhysicalCameraMetadata, continuation);
        cameraDevicesKt$find$1.L$0 = obj;
        return cameraDevicesKt$find$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CameraMetadata> flowCollector, Continuation<? super Unit> continuation) {
        return ((CameraDevicesKt$find$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
    
        if (r15 == r0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010b, code lost:
    
        if (r9.emit(r15, r14) == r0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0148, code lost:
    
        r14.L$0 = r1;
        r14.L$1 = r7;
        r14.L$2 = r15;
        r14.L$3 = r4;
        r14.L$4 = r5;
        r14.label = 4;
        r8 = r14.$this_find.mo286getCameraMetadata_mltaTw(r5, r14.$cameraBackendId, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x015f, code lost:
    
        if (r8 != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0162, code lost:
    
        r5 = r15;
        r15 = r8;
        r8 = r1;
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0192, code lost:
    
        if (r8.emit(r15, r14) == r0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f5 -> B:37:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x010b -> B:37:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0120 -> B:44:0x012e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0195 -> B:44:0x012e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        LinkedHashSet linkedHashSet;
        LinkedHashSet linkedHashSet2;
        Iterator it;
        FlowCollector flowCollector2;
        Iterator it2;
        CameraMetadata cameraMetadata;
        Iterator it3;
        Iterator<CameraId> it4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = CameraDevices.m272getCameraIdsiAq86To$default(this.$this_find, null, this, 1, null);
        } else {
            if (i != 1) {
                if (i == 2) {
                    it2 = (Iterator) this.L$3;
                    Set set = (Set) this.L$2;
                    Set set2 = (Set) this.L$1;
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    linkedHashSet2 = set;
                    linkedHashSet = set2;
                    cameraMetadata = (CameraMetadata) obj;
                    if (cameraMetadata != null) {
                    }
                    it = it2;
                    flowCollector = flowCollector2;
                    while (it.hasNext()) {
                    }
                    if (this.$includePhysicalCameraMetadata) {
                    }
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    it2 = (Iterator) this.L$3;
                    Set set3 = (Set) this.L$2;
                    Set set4 = (Set) this.L$1;
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    linkedHashSet2 = set3;
                    linkedHashSet = set4;
                    it = it2;
                    flowCollector = flowCollector2;
                    while (it.hasNext()) {
                        String strM386unboximpl = ((CameraId) it.next()).m386unboximpl();
                        if (linkedHashSet.add(CameraId.m379boximpl(strM386unboximpl))) {
                            this.L$0 = flowCollector;
                            this.L$1 = linkedHashSet;
                            this.L$2 = linkedHashSet2;
                            this.L$3 = it;
                            this.label = 2;
                            Object objMo286getCameraMetadata_mltaTw = this.$this_find.mo286getCameraMetadata_mltaTw(strM386unboximpl, this.$cameraBackendId, this);
                            if (objMo286getCameraMetadata_mltaTw != coroutine_suspended) {
                                FlowCollector flowCollector3 = flowCollector;
                                it2 = it;
                                obj = objMo286getCameraMetadata_mltaTw;
                                flowCollector2 = flowCollector3;
                                cameraMetadata = (CameraMetadata) obj;
                                if (cameraMetadata != null) {
                                    linkedHashSet2.add(cameraMetadata);
                                    this.L$0 = flowCollector2;
                                    this.L$1 = linkedHashSet;
                                    this.L$2 = linkedHashSet2;
                                    this.L$3 = it2;
                                    this.label = 3;
                                }
                                it = it2;
                                flowCollector = flowCollector2;
                                while (it.hasNext()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                    }
                    if (this.$includePhysicalCameraMetadata) {
                        it3 = linkedHashSet2.iterator();
                        if (it3.hasNext()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Iterator<CameraId> it5 = (Iterator) this.L$3;
                    Iterator it6 = (Iterator) this.L$2;
                    Set set5 = (Set) this.L$1;
                    FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    it3 = it6;
                    it4 = it5;
                    flowCollector = flowCollector4;
                    linkedHashSet = set5;
                    while (it4.hasNext()) {
                        String strM386unboximpl2 = it4.next().m386unboximpl();
                        if (!linkedHashSet.contains(CameraId.m379boximpl(strM386unboximpl2))) {
                            break;
                        }
                    }
                    if (it3.hasNext()) {
                        it4 = ((CameraMetadata) it3.next()).getPhysicalCameraIds().iterator();
                        while (it4.hasNext()) {
                        }
                        if (it3.hasNext()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                String str = (String) this.L$4;
                it4 = (Iterator) this.L$3;
                Iterator it7 = (Iterator) this.L$2;
                linkedHashSet = (Set) this.L$1;
                FlowCollector flowCollector5 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                CameraMetadata cameraMetadata2 = (CameraMetadata) obj;
                if (cameraMetadata2 != null && CameraId.m382equalsimpl0(cameraMetadata2.mo398getCameraDz_R5H8(), str) && linkedHashSet.add(CameraId.m379boximpl(str))) {
                    this.L$0 = flowCollector5;
                    this.L$1 = linkedHashSet;
                    this.L$2 = it7;
                    this.L$3 = it4;
                    this.L$4 = null;
                    this.label = 5;
                }
                it3 = it7;
                flowCollector = flowCollector5;
                while (it4.hasNext()) {
                }
                if (it3.hasNext()) {
                }
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list == null) {
            return Unit.INSTANCE;
        }
        linkedHashSet = new LinkedHashSet();
        linkedHashSet2 = new LinkedHashSet();
        it = list.iterator();
        while (it.hasNext()) {
        }
        if (this.$includePhysicalCameraMetadata) {
        }
        return Unit.INSTANCE;
    }
}
