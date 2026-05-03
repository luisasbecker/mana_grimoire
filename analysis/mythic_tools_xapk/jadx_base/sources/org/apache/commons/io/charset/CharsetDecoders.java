package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes7.dex */
public final class CharsetDecoders {
    private CharsetDecoders() {
    }

    public static CharsetDecoder toCharsetDecoder(CharsetDecoder charsetDecoder) {
        return charsetDecoder != null ? charsetDecoder : Charset.defaultCharset().newDecoder();
    }
}
