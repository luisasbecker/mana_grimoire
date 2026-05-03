package com.google.crypto.tink.subtle.prf;

import com.google.errorprone.annotations.Immutable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface StreamingPrf {
    InputStream computePrf(byte[] bArr);
}
