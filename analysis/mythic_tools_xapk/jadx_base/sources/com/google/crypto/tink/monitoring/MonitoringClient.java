package com.google.crypto.tink.monitoring;

/* JADX INFO: loaded from: classes5.dex */
public interface MonitoringClient {

    public interface Logger {
        void log(int i, long j);

        void logFailure();
    }

    Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2);
}
