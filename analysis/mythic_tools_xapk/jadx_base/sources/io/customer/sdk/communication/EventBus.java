package io.customer.sdk.communication;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import io.customer.base.internal.InternalCustomerIOApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: EventBus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\bH'JI\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&¢\u0006\u0002\u0010\u0013R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lio/customer/sdk/communication/EventBus;", "", "flow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/customer/sdk/communication/Event;", "getFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "publish", "", NotificationCompat.CATEGORY_EVENT, "removeAllSubscriptions", "subscribe", "Lkotlinx/coroutines/Job;", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lkotlin/reflect/KClass;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface EventBus {
    SharedFlow<Event> getFlow();

    void publish(Event event);

    @InternalCustomerIOApi
    void removeAllSubscriptions();

    <T extends Event> Job subscribe(KClass<T> type, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action);
}
