package io.customer.sdk.communication;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: EventBus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0014\b\b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"subscribe", "Lkotlinx/coroutines/Job;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/customer/sdk/communication/Event;", "Lio/customer/sdk/communication/EventBus;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EventBusKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.customer.sdk.communication.EventBusKt$subscribe$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventBus.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public /* synthetic */ class AnonymousClass1<T> extends FunctionReferenceImpl implements Function2<T, Continuation<? super Unit>, Object>, SuspendFunction {
        public AnonymousClass1(Object obj) {
            super(2, obj, Intrinsics.Kotlin.class, "suspendConversion0", "subscribe$suspendConversion0(Lkotlin/jvm/functions/Function1;Lio/customer/sdk/communication/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
        public final Object invoke(Event event, Continuation continuation) {
            return EventBusKt.subscribe$suspendConversion0((Function1) this.receiver, event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return invoke((Event) obj, (Continuation) continuation);
        }
    }

    public static final /* synthetic */ <T extends Event> Job subscribe(EventBus eventBus, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(eventBus, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass<T> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Event.class);
        Intrinsics.needClassReification();
        return eventBus.subscribe(orCreateKotlinClass, new AnonymousClass1(action));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object subscribe$suspendConversion0(Function1 function1, Event event, Continuation continuation) {
        function1.invoke(event);
        return Unit.INSTANCE;
    }
}
