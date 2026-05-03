package io.customer.sdk.data.store;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.google.android.gms.stats.CodePackage;
import io.customer.sdk.core.util.Logger;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: PreferenceCrypto.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u000bH\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0007J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/customer/sdk/data/store/PreferenceCrypto;", "", "keyAlias", "", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Ljava/lang/String;Lio/customer/sdk/core/util/Logger;)V", "isKeystoreAvailable", "", "cachedKey", "Ljavax/crypto/SecretKey;", "getOrCreateKey", "encrypt", "plaintext", "decrypt", "encoded", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreferenceCrypto {
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 128;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private volatile SecretKey cachedKey;
    private final boolean isKeystoreAvailable;
    private final String keyAlias;
    private final Logger logger;

    public PreferenceCrypto(String keyAlias, Logger logger) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.keyAlias = keyAlias;
        this.logger = logger;
        this.isKeystoreAvailable = true;
    }

    private final synchronized SecretKey getOrCreateKey() {
        SecretKey secretKey = this.cachedKey;
        if (secretKey != null) {
            return secretKey;
        }
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry(this.keyAlias, null);
        KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
        if (secretKeyEntry != null) {
            this.cachedKey = secretKeyEntry.getSecretKey();
            SecretKey secretKey2 = secretKeyEntry.getSecretKey();
            Intrinsics.checkNotNullExpressionValue(secretKey2, "getSecretKey(...)");
            return secretKey2;
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(this.keyAlias, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", KEYSTORE_PROVIDER);
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        this.cachedKey = secretKeyGenerateKey;
        Intrinsics.checkNotNull(secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    public final String decrypt(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        if (this.isKeystoreAvailable) {
            try {
                byte[] bArrDecode = Base64.decode(encoded, 2);
                if (bArrDecode.length > 12) {
                    Intrinsics.checkNotNull(bArrDecode);
                    byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArrDecode, 0, 12);
                    byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bArrDecode, 12, bArrDecode.length);
                    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                    cipher.init(2, getOrCreateKey(), new GCMParameterSpec(128, bArrCopyOfRange));
                    byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    return new String(bArrDoFinal, Charsets.UTF_8);
                }
            } catch (Exception unused) {
            }
        }
        return encoded;
    }

    public final String encrypt(String plaintext) {
        Intrinsics.checkNotNullParameter(plaintext, "plaintext");
        if (!this.isKeystoreAvailable) {
            return plaintext;
        }
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, getOrCreateKey());
            byte[] bytes = plaintext.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            byte[] iv = cipher.getIV();
            Intrinsics.checkNotNullExpressionValue(iv, "getIV(...)");
            Intrinsics.checkNotNull(bArrDoFinal);
            String strEncodeToString = Base64.encodeToString(ArraysKt.plus(iv, bArrDoFinal), 2);
            Intrinsics.checkNotNull(strEncodeToString);
            return strEncodeToString;
        } catch (Exception e) {
            Logger.DefaultImpls.debug$default(this.logger, "Keystore encryption unavailable, storing without encryption: " + e.getMessage(), null, 2, null);
            return plaintext;
        }
    }
}
