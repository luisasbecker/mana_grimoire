package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public class AFk1pSDK {
    public static void getCurrencyIso4217Code(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
