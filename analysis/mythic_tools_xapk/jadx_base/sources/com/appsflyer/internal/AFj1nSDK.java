package com.appsflyer.internal;

import android.content.Intent;
import android.os.Parcelable;
import com.appsflyer.AFLogger;
import java.util.ConcurrentModificationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1nSDK {
    final Intent getMediationNetwork;

    public AFj1nSDK(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.getMediationNetwork = intent;
    }

    private final <T> T getCurrencyIso4217Code(Function0<? extends T> function0, String str, T t, boolean z) {
        Object objM11445constructorimpl;
        Object objM11445constructorimpl2;
        Object currencyIso4217Code;
        synchronized (this.getMediationNetwork) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AFj1nSDK aFj1nSDK = this;
                objM11445constructorimpl = Result.m11445constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
            }
            KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(ConcurrentModificationException.class), Reflection.getOrCreateKotlinClass(ArrayIndexOutOfBoundsException.class)};
            Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
            if (thM11448exceptionOrNullimpl != null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM11445constructorimpl2 = Result.m11445constructorimpl(ResultKt.createFailure(th2));
                }
                if (!ArraysKt.contains(kClassArr, Reflection.getOrCreateKotlinClass(thM11448exceptionOrNullimpl.getClass()))) {
                    throw thM11448exceptionOrNullimpl;
                }
                if (z) {
                    currencyIso4217Code = getCurrencyIso4217Code(function0, str, t, false);
                } else {
                    AFLogger.afErrorLog(str, thM11448exceptionOrNullimpl, false, false);
                    currencyIso4217Code = t;
                }
                objM11445constructorimpl2 = Result.m11445constructorimpl(currencyIso4217Code);
                objM11445constructorimpl = objM11445constructorimpl2;
            }
            Throwable thM11448exceptionOrNullimpl2 = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
            if (thM11448exceptionOrNullimpl2 == null) {
                t = (T) objM11445constructorimpl;
            } else {
                AFLogger.afErrorLog(str, thM11448exceptionOrNullimpl2, false, false);
            }
        }
        return t;
    }

    public final boolean AFAdRevenueData(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Boolean bool = (Boolean) getCurrencyIso4217Code(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFj1nSDK.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(AFj1nSDK.this.getMediationNetwork.hasExtra(str));
            }
        }, "Error while trying to check presence of " + str + " extra from intent", Boolean.TRUE, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final <T extends Parcelable> T H_(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (T) getCurrencyIso4217Code(new Function0<T>() { // from class: com.appsflyer.internal.AFj1nSDK.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: J_, reason: merged with bridge method [inline-methods] */
            public final Parcelable invoke() {
                return AFj1nSDK.this.getMediationNetwork.getParcelableExtra(str);
            }
        }, "Error while trying to read " + str + " extra from intent", null, true);
    }

    public final Intent I_(final String str, final long j) {
        Intrinsics.checkNotNullParameter(str, "");
        return (Intent) getCurrencyIso4217Code(new Function0<Intent>() { // from class: com.appsflyer.internal.AFj1nSDK.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: K_, reason: merged with bridge method [inline-methods] */
            public final Intent invoke() {
                return AFj1nSDK.this.getMediationNetwork.putExtra(str, j);
            }
        }, "Error while trying to write " + str + " extra to intent", null, true);
    }

    public final String getMediationNetwork(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (String) getCurrencyIso4217Code(new Function0<String>() { // from class: com.appsflyer.internal.AFj1nSDK.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return AFj1nSDK.this.getMediationNetwork.getStringExtra(str);
            }
        }, "Error while trying to read " + str + " extra from intent", null, true);
    }
}
