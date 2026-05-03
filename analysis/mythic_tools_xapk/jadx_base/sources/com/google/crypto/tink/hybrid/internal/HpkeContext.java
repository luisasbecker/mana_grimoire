package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, HpkeAead hpkeAead) {
        this.encapsulatedKey = bArr;
        this.key = bArr2;
        this.baseNonce = bArr3;
        this.maxSequenceNumber = bigInteger;
        this.aead = hpkeAead;
    }

    private byte[] computeNonce() throws GeneralSecurityException {
        return Bytes.xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() throws GeneralSecurityException {
        byte[] bArrComputeNonce;
        bArrComputeNonce = computeNonce();
        incrementSequenceNumber();
        return bArrComputeNonce;
    }

    static HpkeContext createContext(byte[] bArr, byte[] bArr2, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrHpkeSuiteId = HpkeUtil.hpkeSuiteId(hpkeKem.getKemId(), hpkeKdf.getKdfId(), hpkeAead.getAeadId());
        byte[] bArr4 = HpkeUtil.EMPTY_SALT;
        byte[] bArr5 = EMPTY_IKM;
        byte[] bArrConcat = Bytes.concat(HpkeUtil.BASE_MODE, hpkeKdf.labeledExtract(bArr4, bArr5, "psk_id_hash", bArrHpkeSuiteId), hpkeKdf.labeledExtract(HpkeUtil.EMPTY_SALT, bArr3, "info_hash", bArrHpkeSuiteId));
        byte[] bArrLabeledExtract = hpkeKdf.labeledExtract(bArr2, bArr5, "secret", bArrHpkeSuiteId);
        return new HpkeContext(bArr, hpkeKdf.labeledExpand(bArrLabeledExtract, bArrConcat, SubscriberAttributeKt.JSON_NAME_KEY, bArrHpkeSuiteId, hpkeAead.getKeyLength()), hpkeKdf.labeledExpand(bArrLabeledExtract, bArrConcat, "base_nonce", bArrHpkeSuiteId, hpkeAead.getNonceLength()), maxSequenceNumber(hpkeAead.getNonceLength()), hpkeAead);
    }

    static HpkeContext createRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2) throws GeneralSecurityException {
        return createContext(bArr, hpkeKem.decapsulate(bArr, hpkeKemPrivateKey), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    static HpkeContext createSenderContext(HpkePublicKey hpkePublicKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr) throws GeneralSecurityException {
        HpkeKemEncapOutput hpkeKemEncapOutputEncapsulate = hpkeKem.encapsulate(hpkePublicKey.getPublicKey().toByteArray());
        return createContext(hpkeKemEncapOutputEncapsulate.getEncapsulatedKey(), hpkeKemEncapOutputEncapsulate.getSharedSecret(), hpkeKem, hpkeKdf, hpkeAead, bArr);
    }

    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
    }

    private static BigInteger maxSequenceNumber(int i) {
        return BigInteger.ONE.shiftLeft(i * 8).subtract(BigInteger.ONE);
    }

    byte[] getBaseNonce() {
        return this.baseNonce;
    }

    byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    byte[] getKey() {
        return this.key;
    }

    byte[] open(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.open(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }

    byte[] seal(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }
}
