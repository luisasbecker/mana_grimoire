package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileSystem;
import org.apache.commons.io.StandardLineSeparator;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOIterable;
import org.apache.commons.io.function.IOIterator;

/* JADX INFO: loaded from: classes7.dex */
public class ReversedLinesFileReader implements Closeable, IOIterable<String> {
    private static final int DEFAULT_BLOCK_SIZE = FileSystem.getCurrent().getBlockSize();
    private static final String EMPTY_STRING = "";
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private final SeekableByteChannel channel;
    private final Charset charset;
    private FilePart currentFilePart;
    private final byte[][] newLineSequences;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    public static class Builder extends AbstractStreamBuilder<ReversedLinesFileReader, Builder> {
        public Builder() {
            setBufferSizeDefault(ReversedLinesFileReader.DEFAULT_BLOCK_SIZE);
            setBufferSize(ReversedLinesFileReader.DEFAULT_BLOCK_SIZE);
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public ReversedLinesFileReader get() throws IOException {
            return new ReversedLinesFileReader(this);
        }
    }

    private final class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long partNumber;

        private FilePart(long j, int i, byte[] bArr) throws IOException {
            this.partNumber = j;
            byte[] bArr2 = new byte[(bArr != null ? bArr.length : 0) + i];
            this.data = bArr2;
            long j2 = (j - 1) * ((long) ReversedLinesFileReader.this.blockSize);
            if (j > 0) {
                ReversedLinesFileReader.this.channel.position(j2);
                if (ReversedLinesFileReader.this.channel.read(ByteBuffer.wrap(bArr2, 0, i)) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                this.leftOver = Arrays.copyOf(this.data, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr2.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
        
            r5 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        
            if (r0 == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
        
            if (r7.leftOver == null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        
            r0 = new java.lang.String(r7.leftOver, r7.this$0.charset);
            r7.leftOver = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
        
            return r5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String readLine() {
            boolean z = this.partNumber == 1;
            int i = this.currentLastBytePos;
            while (true) {
                if (i > -1) {
                    if (!z && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount > 0) {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 < 0) {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                        String str = new String(Arrays.copyOfRange(this.data, i2, i3 + i2), ReversedLinesFileReader.this.charset);
                        this.currentLastBytePos = i - newLineMatchByteCount;
                    } else {
                        i -= ReversedLinesFileReader.this.byteDecrement;
                        if (i < 0) {
                            createLeftOver();
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            long j = this.partNumber;
            if (j > 1) {
                ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                return reversedLinesFileReader.new FilePart(j - 1, reversedLinesFileReader.blockSize, this.leftOver);
            }
            if (this.leftOver == null) {
                return null;
            }
            throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=".concat(new String(this.leftOver, ReversedLinesFileReader.this.charset)));
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) throws IOException {
        this(file, DEFAULT_BLOCK_SIZE, Charset.defaultCharset());
    }

    @Deprecated
    public ReversedLinesFileReader(File file, int i, String str) throws IOException {
        this(file.toPath(), i, str);
    }

    @Deprecated
    public ReversedLinesFileReader(File file, int i, Charset charset) throws IOException {
        this(file.toPath(), i, charset);
    }

    @Deprecated
    public ReversedLinesFileReader(File file, Charset charset) throws IOException {
        this(file.toPath(), charset);
    }

    @Deprecated
    public ReversedLinesFileReader(Path path, int i, String str) throws IOException {
        this(path, i, Charsets.toCharset(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public ReversedLinesFileReader(Path path, int i, Charset charset) throws IOException {
        this(((Builder) builder().setPath(path)).setBufferSize(i).setCharset(charset));
    }

    @Deprecated
    public ReversedLinesFileReader(Path path, Charset charset) throws IOException {
        this(path, DEFAULT_BLOCK_SIZE, charset);
    }

    private ReversedLinesFileReader(Builder builder) throws IOException {
        int i;
        int bufferSize = builder.getBufferSize();
        this.blockSize = bufferSize;
        Charset charset = Charsets.toCharset(builder.getCharset());
        this.charset = charset;
        if (charset.newEncoder().maxBytesPerChar() == 1.0f || charset == StandardCharsets.UTF_8 || charset == Charset.forName("Shift_JIS") || charset == Charset.forName("windows-31j") || charset == Charset.forName("x-windows-949") || charset == Charset.forName("gbk") || charset == Charset.forName("x-windows-950")) {
            this.byteDecrement = 1;
        } else {
            if (charset != StandardCharsets.UTF_16BE && charset != StandardCharsets.UTF_16LE) {
                if (charset != StandardCharsets.UTF_16) {
                    throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
                }
                throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
            }
            this.byteDecrement = 2;
        }
        byte[][] bArr = {StandardLineSeparator.CRLF.getBytes(charset), StandardLineSeparator.LF.getBytes(charset), StandardLineSeparator.CR.getBytes(charset)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        SeekableByteChannel seekableByteChannelNewByteChannel = Files.newByteChannel(builder.getPath(), StandardOpenOption.READ);
        this.channel = seekableByteChannelNewByteChannel;
        long size = seekableByteChannelNewByteChannel.size();
        this.totalByteLength = size;
        int i2 = (int) (size % ((long) bufferSize));
        if (i2 <= 0) {
            this.totalBlockCount = size / ((long) bufferSize);
            i = size > 0 ? bufferSize : i;
            this.currentFilePart = new FilePart(this.totalBlockCount, i, null);
        }
        this.totalBlockCount = (size / ((long) bufferSize)) + 1;
        i = i2;
        this.currentFilePart = new FilePart(this.totalBlockCount, i, null);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    @Override // org.apache.commons.io.function.IOIterable
    public IOIterator<String> iterator() {
        return new IOIterator<String>() { // from class: org.apache.commons.io.input.ReversedLinesFileReader.1
            private String next;

            @Override // org.apache.commons.io.function.IOIterator
            public boolean hasNext() throws IOException {
                if (this.next == null) {
                    this.next = ReversedLinesFileReader.this.readLine();
                }
                return this.next != null;
            }

            @Override // org.apache.commons.io.function.IOIterator
            public String next() throws IOException {
                if (this.next == null) {
                    this.next = ReversedLinesFileReader.this.readLine();
                }
                String str = this.next;
                this.next = null;
                return str;
            }

            @Override // org.apache.commons.io.function.IOIterator
            public Iterator<String> unwrap() {
                return null;
            }
        };
    }

    public String readLine() throws IOException {
        String line = this.currentFilePart.readLine();
        while (line == null) {
            FilePart filePartRollOver = this.currentFilePart.rollOver();
            this.currentFilePart = filePartRollOver;
            if (filePartRollOver == null) {
                break;
            }
            line = filePartRollOver.readLine();
        }
        if (!"".equals(line) || this.trailingNewlineOfFileSkipped) {
            return line;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    public List<String> readLines(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("lineCount < 0");
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            String line = readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        return arrayList;
    }

    public String toString(int i) throws IOException {
        List<String> lines = readLines(i);
        Collections.reverse(lines);
        return lines.isEmpty() ? "" : String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }

    @Override // org.apache.commons.io.function.IOIterable
    public Iterable<String> unwrap() {
        return null;
    }
}
