package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final class CharsetEncoders {
    private CharsetEncoders() {
    }

    public static CharsetEncoder toCharsetEncoder(CharsetEncoder charsetEncoder) {
        return toCharsetEncoder(charsetEncoder, new Supplier() { // from class: org.apache.commons.io.charset.CharsetEncoders$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Charset.defaultCharset().newEncoder();
            }
        });
    }

    public static CharsetEncoder toCharsetEncoder(CharsetEncoder charsetEncoder, Supplier<CharsetEncoder> supplier) {
        return charsetEncoder != null ? charsetEncoder : supplier.get();
    }
}
