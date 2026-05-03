package com.google.crypto.tink.subtle;

import com.google.crypto.tink.hybrid.subtle.AeadOrDaead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public interface EciesAeadHkdfDemHelper {
    AeadOrDaead getAeadOrDaead(byte[] bArr) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}
