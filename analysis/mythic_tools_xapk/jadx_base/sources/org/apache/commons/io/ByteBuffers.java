package org.apache.commons.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes7.dex */
public final class ByteBuffers {
    private ByteBuffers() {
    }

    public static ByteBuffer littleEndian(int i) {
        return littleEndian(ByteBuffer.allocate(i));
    }

    public static ByteBuffer littleEndian(ByteBuffer byteBuffer) {
        return byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static ByteBuffer littleEndian(byte[] bArr) {
        return littleEndian(ByteBuffer.wrap(bArr));
    }
}
