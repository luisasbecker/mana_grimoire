package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {
    private WritableByteChannel ciphertextChannel;
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open = true;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        this.ciphertextChannel = writableByteChannel;
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(plaintextSegmentSize);
        this.ptBuffer = byteBufferAllocate;
        byteBufferAllocate.limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        this.ctBuffer = byteBufferAllocate2;
        byteBufferAllocate2.put(this.encrypter.getHeader());
        this.ctBuffer.flip();
        writableByteChannel.write(this.ctBuffer);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        WritableByteChannel writableByteChannel;
        if (this.open) {
            while (this.ctBuffer.remaining() > 0) {
                if (this.ciphertextChannel.write(this.ctBuffer) <= 0) {
                    throw new IOException("Failed to write ciphertext before closing");
                }
            }
            try {
                this.ctBuffer.clear();
                this.ptBuffer.flip();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                do {
                    int iRemaining = this.ctBuffer.remaining();
                    writableByteChannel = this.ciphertextChannel;
                    if (iRemaining <= 0) {
                        writableByteChannel.close();
                        this.open = false;
                        return;
                    }
                } while (writableByteChannel.write(this.ctBuffer) > 0);
                throw new IOException("Failed to write ciphertext before closing");
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.open;
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.open) {
            throw new ClosedChannelException();
        }
        if (this.ctBuffer.remaining() > 0) {
            this.ciphertextChannel.write(this.ctBuffer);
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.remaining() > this.ptBuffer.remaining()) {
            if (this.ctBuffer.remaining() > 0) {
                return byteBuffer.position() - iPosition;
            }
            int iRemaining = this.ptBuffer.remaining();
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.limit(iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                int iRemaining2 = byteBufferSlice.remaining();
                StreamSegmentEncrypter streamSegmentEncrypter = this.encrypter;
                if (iRemaining2 != 0) {
                    streamSegmentEncrypter.encryptSegment(this.ptBuffer, byteBufferSlice, false, this.ctBuffer);
                } else {
                    streamSegmentEncrypter.encryptSegment(this.ptBuffer, false, this.ctBuffer);
                }
                this.ctBuffer.flip();
                this.ciphertextChannel.write(this.ctBuffer);
                this.ptBuffer.clear();
                this.ptBuffer.limit(this.plaintextSegmentSize);
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
        this.ptBuffer.put(byteBuffer);
        return byteBuffer.position() - iPosition;
    }
}
