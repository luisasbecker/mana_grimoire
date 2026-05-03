package sovran.kotlin;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import sovran.kotlin.State;

/* JADX INFO: compiled from: Action.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lsovran/kotlin/Action;", "StateT", "Lsovran/kotlin/State;", "", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "(Lsovran/kotlin/State;)Lsovran/kotlin/State;", "lib"}, k = 1, mv = {1, 4, 3})
public interface Action<StateT extends State> {
    StateT reduce(StateT state);
}
