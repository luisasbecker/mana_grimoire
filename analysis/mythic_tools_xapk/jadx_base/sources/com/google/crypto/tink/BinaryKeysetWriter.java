package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class BinaryKeysetWriter implements KeysetWriter {
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Deprecated
    public static KeysetWriter withFile(File file) throws IOException {
        return withOutputStream(new FileOutputStream(file));
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new BinaryKeysetWriter(outputStream);
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            encryptedKeyset.writeTo(this.outputStream);
        } finally {
            this.outputStream.close();
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            keyset.writeTo(this.outputStream);
        } finally {
            this.outputStream.close();
        }
    }
}
