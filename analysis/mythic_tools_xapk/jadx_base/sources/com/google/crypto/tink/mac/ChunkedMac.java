package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface ChunkedMac {
    ChunkedMacComputation createComputation() throws GeneralSecurityException;

    ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException;
}
