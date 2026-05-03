package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
final class ChunkedAesCmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};
    private final Cipher aes;
    private boolean finalized = false;
    private final AesCmacKey key;
    private final ByteBuffer localStash;
    private final byte[] subKey1;
    private final byte[] subKey2;
    private final ByteBuffer x;
    private final ByteBuffer y;

    ChunkedAesCmacComputation(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        this.key = aesCmacKey;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        this.aes = engineFactory;
        engineFactory.init(1, new SecretKeySpec(aesCmacKey.getAesKey().toByteArray(InsecureSecretKeyAccess.get()), "AES"));
        byte[] bArrDbl = AesUtil.dbl(engineFactory.doFinal(new byte[16]));
        this.subKey1 = bArrDbl;
        this.subKey2 = AesUtil.dbl(bArrDbl);
        this.localStash = ByteBuffer.allocate(16);
        this.x = ByteBuffer.allocate(16);
        this.y = ByteBuffer.allocate(16);
    }

    private void munch(ByteBuffer byteBuffer) throws GeneralSecurityException {
        this.y.rewind();
        this.x.rewind();
        Bytes.xor(this.y, this.x, byteBuffer, 16);
        this.y.rewind();
        this.x.rewind();
        this.aes.doFinal(this.y, this.x);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public byte[] computeMac() throws GeneralSecurityException {
        if (this.finalized) {
            throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
        }
        if (this.key.getParameters().getVariant() == AesCmacParameters.Variant.LEGACY) {
            update(ByteBuffer.wrap(FORMAT_VERSION));
        }
        this.finalized = true;
        int iRemaining = this.localStash.remaining();
        ByteBuffer byteBuffer = this.localStash;
        return Bytes.concat(this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.aes.doFinal(Bytes.xor(iRemaining > 0 ? Bytes.xor(AesUtil.cmacPad(Arrays.copyOf(byteBuffer.array(), this.localStash.position())), this.subKey2) : Bytes.xor(byteBuffer.array(), 0, this.subKey1, 0, 16), this.x.array())), this.key.getParameters().getCryptographicTagSizeBytes()));
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public void update(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (this.finalized) {
            throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
        }
        if (this.localStash.remaining() != 16) {
            int iMin = Math.min(this.localStash.remaining(), byteBuffer.remaining());
            for (int i = 0; i < iMin; i++) {
                this.localStash.put(byteBuffer.get());
            }
        }
        if (this.localStash.remaining() == 0 && byteBuffer.remaining() > 0) {
            this.localStash.rewind();
            munch(this.localStash);
            this.localStash.rewind();
        }
        while (byteBuffer.remaining() > 16) {
            munch(byteBuffer);
        }
        this.localStash.put(byteBuffer);
    }
}
