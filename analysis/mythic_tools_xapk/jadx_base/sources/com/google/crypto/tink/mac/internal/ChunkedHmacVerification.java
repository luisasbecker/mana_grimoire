package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
final class ChunkedHmacVerification implements ChunkedMacVerification {
    private final ChunkedHmacComputation hmacComputation;
    private final Bytes tag;

    ChunkedHmacVerification(HmacKey hmacKey, byte[] bArr) throws GeneralSecurityException {
        this.hmacComputation = new ChunkedHmacComputation(hmacKey);
        this.tag = Bytes.copyFrom(bArr);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void update(ByteBuffer byteBuffer) {
        this.hmacComputation.update(byteBuffer);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void verifyMac() throws GeneralSecurityException {
        if (!this.tag.equals(Bytes.copyFrom(this.hmacComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
