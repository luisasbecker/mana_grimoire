package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class AeadFactory {
    private AeadFactory() {
    }

    @Deprecated
    public static Aead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        AeadWrapper.register();
        return (Aead) keysetHandle.getPrimitive(Aead.class);
    }
}
