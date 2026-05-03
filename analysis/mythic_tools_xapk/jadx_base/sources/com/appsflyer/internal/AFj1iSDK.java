package com.appsflyer.internal;

import com.android.billingclient.BuildConfig;
import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1iSDK implements AFj1gSDK {
    @Override // com.appsflyer.internal.AFj1gSDK
    public final String getRevenue() {
        Object objM11445constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AFj1iSDK aFj1iSDK = this;
            Field declaredField = BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Intrinsics.checkNotNull(obj, "");
            objM11445constructorimpl = Result.m11445constructorimpl((String) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m11451isFailureimpl(objM11445constructorimpl) ? "" : objM11445constructorimpl);
    }
}
