package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = seekableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        this.plaintextPosition = 0L;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long size = seekableByteChannel.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(bArr, bArr.length);
        this.isopen = seekableByteChannel.isOpen();
        int i = (int) (size / ((long) ciphertextSegmentSize));
        int i2 = (int) (size % ((long) ciphertextSegmentSize));
        int ciphertextOverhead = nonceBasedStreamingAead.getCiphertextOverhead();
        if (i2 > 0) {
            this.numberOfSegments = i + 1;
            if (i2 < ciphertextOverhead) {
                throw new IOException("Invalid ciphertext size");
            }
            this.lastCiphertextSegmentSize = i2;
        } else {
            this.numberOfSegments = i;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = nonceBasedStreamingAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - nonceBasedStreamingAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j = (((long) this.numberOfSegments) * ((long) ciphertextOverhead)) + ((long) ciphertextOffset);
        if (j > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.plaintextSize = size - j;
    }

    private int getSegmentNr(long j) {
        return (int) ((j + ((long) this.ciphertextOffset)) / ((long) this.plaintextSegmentSize));
    }

    private boolean reachedEnd() {
        return this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    private boolean tryLoadSegment(int i) throws IOException {
        int i2;
        if (i < 0 || i >= (i2 = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        boolean z = i == i2 - 1;
        if (i != this.currentSegmentNr) {
            int i3 = this.ciphertextSegmentSize;
            long j = ((long) i) * ((long) i3);
            if (z) {
                i3 = this.lastCiphertextSegmentSize;
            }
            if (i == 0) {
                int i4 = this.ciphertextOffset;
                i3 -= i4;
                j = i4;
            }
            this.ciphertextChannel.position(j);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i3);
            this.currentSegmentNr = i;
            this.isCurrentSegmentDecrypted = false;
        } else if (this.isCurrentSegmentDecrypted) {
            return true;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, i, z, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e);
        }
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.isopen;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.plaintextPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j) {
        this.plaintextPosition = j;
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (!this.isopen) {
            throw new ClosedChannelException();
        }
        if (!this.headerRead && !tryReadHeader()) {
            return 0;
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.remaining() > 0) {
            long j = this.plaintextPosition;
            if (j >= this.plaintextSize) {
                break;
            }
            int segmentNr = getSegmentNr(j);
            long j2 = this.plaintextPosition;
            if (segmentNr != 0) {
                j2 = (j2 + ((long) this.ciphertextOffset)) % ((long) this.plaintextSegmentSize);
            }
            int i = (int) j2;
            if (!tryLoadSegment(segmentNr)) {
                break;
            }
            this.plaintextSegment.position(i);
            if (this.plaintextSegment.remaining() <= byteBuffer.remaining()) {
                this.plaintextPosition += (long) this.plaintextSegment.remaining();
                byteBuffer.put(this.plaintextSegment);
            } else {
                int iRemaining = byteBuffer.remaining();
                ByteBuffer byteBufferDuplicate = this.plaintextSegment.duplicate();
                byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                byteBuffer.put(byteBufferDuplicate);
                this.plaintextPosition += (long) iRemaining;
                ByteBuffer byteBuffer2 = this.plaintextSegment;
                byteBuffer2.position(byteBuffer2.position() + iRemaining);
            }
        }
        int iPosition2 = byteBuffer.position() - iPosition;
        if (iPosition2 == 0 && reachedEnd()) {
            return -1;
        }
        return iPosition2;
    }

    public synchronized int read(ByteBuffer byteBuffer, long j) throws IOException {
        long jPosition = position();
        try {
            position(j);
        } finally {
            position(jPosition);
        }
        return read(byteBuffer);
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder();
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append("StreamingAeadSeekableDecryptingChannel\nciphertextChannel").append(str).append("\nciphertextChannelSize:").append(this.ciphertextChannelSize).append("\nplaintextSize:").append(this.plaintextSize).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nnumberOfSegments:").append(this.numberOfSegments).append("\nheaderRead:").append(this.headerRead).append("\nplaintextPosition:").append(this.plaintextPosition).append("\nHeader position:").append(this.header.position()).append(" limit:").append(this.header.position()).append("\ncurrentSegmentNr:").append(this.currentSegmentNr).append("\nciphertextSgement position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nisCurrentSegmentDecrypted:").append(this.isCurrentSegmentDecrypted).append("\nplaintextSegment position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    public synchronized long verifiedSize() throws IOException {
        if (!tryLoadSegment(this.numberOfSegments - 1)) {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }
}
