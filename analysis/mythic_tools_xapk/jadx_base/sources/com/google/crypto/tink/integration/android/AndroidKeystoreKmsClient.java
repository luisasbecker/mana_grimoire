package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 40;
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = "AndroidKeystoreKmsClient";
    private static final Object keyCreationLock = new Object();
    private KeyStore keyStore;
    private final String keyUri;

    public static final class Builder {
        KeyStore keyStore;
        String keyUri = null;

        public Builder() {
            this.keyStore = null;
            if (!AndroidKeystoreKmsClient.isAtLeastM()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this);
        }

        public Builder setKeyStore(KeyStore keyStore) {
            if (keyStore == null) {
                throw new IllegalArgumentException("val cannot be null");
            }
            this.keyStore = keyStore;
            return this;
        }

        public Builder setKeyUri(String str) {
            if (str == null || !str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.keyUri = str;
            return this;
        }
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String str) {
        this(new Builder().setKeyUri(str));
    }

    static boolean generateKeyIfNotExist(String str) throws GeneralSecurityException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            if (androidKeystoreKmsClient.hasKey(str)) {
                return false;
            }
            generateNewAesGcmKeyWithoutExistenceCheck(str);
            return true;
        }
    }

    public static void generateNewAeadKey(String str) throws GeneralSecurityException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            if (androidKeystoreKmsClient.hasKey(str)) {
                throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
            }
            generateNewAesGcmKeyWithoutExistenceCheck(str);
        }
    }

    static void generateNewAesGcmKeyWithoutExistenceCheck(String str) throws GeneralSecurityException {
        String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strValidateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    public static Aead getOrGenerateNewAeadKey(String str) throws GeneralSecurityException, IOException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            if (!androidKeystoreKmsClient.hasKey(str)) {
                generateNewAesGcmKeyWithoutExistenceCheck(str);
            }
        }
        return androidKeystoreKmsClient.getAead(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    private static void sleepRandomAmount() {
        try {
            Thread.sleep((int) (Math.random() * 40.0d));
        } catch (InterruptedException unused) {
        }
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] bArrRandBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrRandBytes, aead.decrypt(aead.encrypt(bArrRandBytes, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    public synchronized void deleteKey(String str) throws GeneralSecurityException {
        this.keyStore.deleteEntry(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    @Override // com.google.crypto.tink.KmsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean doesSupport(String str) {
        boolean z;
        String str2 = this.keyUri;
        if (str2 != null && str2.equals(str)) {
            return true;
        }
        if (this.keyUri == null) {
            z = str.toLowerCase(Locale.US).startsWith(PREFIX);
        }
        return z;
    }

    @Override // com.google.crypto.tink.KmsClient
    public synchronized Aead getAead(String str) throws GeneralSecurityException {
        String str2 = this.keyUri;
        if (str2 != null && !str2.equals(str)) {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.keyUri, str));
        }
        return validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str), this.keyStore));
    }

    synchronized boolean hasKey(String str) throws GeneralSecurityException {
        String strValidateKmsKeyUriAndRemovePrefix;
        strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        try {
        } catch (NullPointerException unused) {
            Log.w(TAG, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                sleepRandomAmount();
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
                return this.keyStore.containsAlias(strValidateKmsKeyUriAndRemovePrefix);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        }
        return this.keyStore.containsAlias(strValidateKmsKeyUriAndRemovePrefix);
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withCredentials(String str) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }
}
