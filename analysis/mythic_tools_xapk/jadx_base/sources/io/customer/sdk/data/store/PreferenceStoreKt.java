package io.customer.sdk.data.store;

import android.content.SharedPreferences;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0019\u0010\u0003\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"read", "Value", "Landroid/content/SharedPreferences;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PreferenceStoreKt {
    public static final <Value> Value read(SharedPreferences sharedPreferences, Function1<? super SharedPreferences, ? extends Value> action) {
        Value value;
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            Result.Companion companion = Result.INSTANCE;
            value = (Value) Result.m11445constructorimpl(action.invoke(sharedPreferences));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            value = (Value) Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m11451isFailureimpl(value)) {
            return null;
        }
        return value;
    }
}
