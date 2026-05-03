package com.google.crypto.tink.jwt;

/* JADX INFO: loaded from: classes5.dex */
final class JwtNames {
    static final String CLAIM_AUDIENCE = "aud";
    static final String CLAIM_EXPIRATION = "exp";
    static final String CLAIM_ISSUED_AT = "iat";
    static final String CLAIM_ISSUER = "iss";
    static final String CLAIM_JWT_ID = "jti";
    static final String CLAIM_NOT_BEFORE = "nbf";
    static final String CLAIM_SUBJECT = "sub";
    static final String HEADER_ALGORITHM = "alg";
    static final String HEADER_CRITICAL = "crit";
    static final String HEADER_KEY_ID = "kid";
    static final String HEADER_TYPE = "typ";

    private JwtNames() {
    }

    static boolean isRegisteredName(String str) {
        return str.equals("iss") || str.equals("sub") || str.equals("aud") || str.equals("exp") || str.equals(CLAIM_NOT_BEFORE) || str.equals("iat") || str.equals("jti");
    }

    static void validate(String str) {
        if (isRegisteredName(str)) {
            throw new IllegalArgumentException(String.format("claim '%s' is invalid because it's a registered name; use the corresponding setter method.", str));
        }
    }
}
