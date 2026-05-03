package com.appsflyer.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1eSDK<T> {
    public final Function0<T> getMonetizationNetwork;

    /* JADX WARN: Multi-variable type inference failed */
    public AFc1eSDK(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.getMonetizationNetwork = function0;
    }
}
