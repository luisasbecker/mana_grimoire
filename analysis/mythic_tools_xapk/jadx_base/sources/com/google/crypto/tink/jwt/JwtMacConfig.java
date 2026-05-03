package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtMacConfig {
    public static final String JWT_HMAC_TYPE_URL = new JwtHmacKeyManager().getKeyType();

    private JwtMacConfig() {
    }

    public static void register() throws GeneralSecurityException {
        JwtHmacKeyManager.register(true);
        JwtMacWrapper.register();
    }
}
