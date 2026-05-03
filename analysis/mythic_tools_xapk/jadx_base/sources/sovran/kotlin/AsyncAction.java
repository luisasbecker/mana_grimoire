package sovran.kotlin;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import sovran.kotlin.State;

/* JADX INFO: compiled from: Action.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002$\u0010\b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH&ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u000eø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lsovran/kotlin/AsyncAction;", "StateT", "Lsovran/kotlin/State;", "ResultT", "", "operation", "", ServerProtocol.DIALOG_PARAM_STATE, "completion", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lsovran/kotlin/State;Lkotlin/jvm/functions/Function2;)V", "reduce", "operationResult", "(Lsovran/kotlin/State;Ljava/lang/Object;)Lsovran/kotlin/State;", "lib"}, k = 1, mv = {1, 4, 3})
public interface AsyncAction<StateT extends State, ResultT> {
    void operation(StateT state, Function2<? super ResultT, ? super Continuation<? super Unit>, ? extends Object> completion);

    StateT reduce(StateT state, ResultT operationResult);
}
