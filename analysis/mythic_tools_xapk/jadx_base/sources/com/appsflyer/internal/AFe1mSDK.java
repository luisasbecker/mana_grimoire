package com.appsflyer.internal;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public final class AFe1mSDK extends TimerTask {
    private final Thread getCurrencyIso4217Code;

    public AFe1mSDK(Thread thread) {
        this.getCurrencyIso4217Code = thread;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.getCurrencyIso4217Code.interrupt();
    }
}
