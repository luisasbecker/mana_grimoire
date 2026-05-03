package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(RawJwt rawJwt, Optional<String> optional) throws GeneralSecurityException;

    VerifiedJwt verifyMacAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException;
}
