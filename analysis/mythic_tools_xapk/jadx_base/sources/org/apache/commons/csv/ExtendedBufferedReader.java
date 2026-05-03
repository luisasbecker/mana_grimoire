package org.apache.commons.csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.input.UnsynchronizedBufferedReader;

/* JADX INFO: loaded from: classes7.dex */
final class ExtendedBufferedReader extends UnsynchronizedBufferedReader {
    private long bytesRead;
    private long bytesReadMark;
    private final CharsetEncoder encoder;
    private int lastChar;
    private int lastCharMark;
    private long lineNumber;
    private long lineNumberMark;
    private long position;
    private long positionMark;

    ExtendedBufferedReader(Reader reader) {
        this(reader, null, false);
    }

    ExtendedBufferedReader(Reader reader, Charset charset, boolean z) {
        super(reader);
        this.lastChar = -2;
        this.lastCharMark = -2;
        this.encoder = (charset == null || !z) ? null : charset.newEncoder();
    }

    private int getEncodedCharLength(int i) throws CharacterCodingException {
        char c = (char) i;
        char c2 = (char) this.lastChar;
        if (!Character.isSurrogate(c)) {
            return this.encoder.encode(CharBuffer.wrap(new char[]{c})).limit();
        }
        if (Character.isHighSurrogate(c)) {
            return 0;
        }
        if (Character.isSurrogatePair(c2, c)) {
            return this.encoder.encode(CharBuffer.wrap(new char[]{c2, c})).limit();
        }
        throw new CharacterCodingException();
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader, org.apache.commons.io.input.UnsynchronizedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.lastChar = -1;
        super.close();
    }

    long getBytesRead() {
        return this.bytesRead;
    }

    int getLastChar() {
        return this.lastChar;
    }

    long getLineNumber() {
        int i = this.lastChar;
        return (i == 13 || i == 10 || i == -2 || i == -1) ? this.lineNumber : this.lineNumber + 1;
    }

    long getPosition() {
        return this.position;
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader, java.io.Reader
    public void mark(int i) throws IOException {
        this.lineNumberMark = this.lineNumber;
        this.lastCharMark = this.lastChar;
        this.positionMark = this.position;
        this.bytesReadMark = this.bytesRead;
        super.mark(i);
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader, java.io.Reader
    public int read() throws IOException {
        int i;
        int i2 = super.read();
        if (i2 == 13 || ((i2 == 10 && this.lastChar != 13) || (i2 == -1 && (i = this.lastChar) != 13 && i != 10 && i != -1))) {
            this.lineNumber++;
        }
        if (this.encoder != null) {
            this.bytesRead += (long) getEncodedCharLength(i2);
        }
        this.lastChar = i2;
        this.position++;
        return i2;
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        int i4 = super.read(cArr, i, i2);
        if (i4 > 0) {
            int i5 = i;
            while (true) {
                i3 = i + i4;
                if (i5 >= i3) {
                    break;
                }
                char c = cArr[i5];
                if (c == '\n') {
                    if (13 != (i5 > i ? cArr[i5 - 1] : this.lastChar)) {
                        this.lineNumber++;
                    }
                } else if (c == '\r') {
                    this.lineNumber++;
                }
                i5++;
            }
            this.lastChar = cArr[i3 - 1];
        } else if (i4 == -1) {
            this.lastChar = -1;
        }
        this.position += (long) i4;
        return i4;
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader
    public String readLine() throws IOException {
        if (peek() == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = read();
            if (i == 13 && peek() == 10) {
                read();
            }
            if (i == -1 || i == 10 || i == 13) {
                break;
            }
            sb.append((char) i);
        }
        return sb.toString();
    }

    @Override // org.apache.commons.io.input.UnsynchronizedBufferedReader, java.io.Reader
    public void reset() throws IOException {
        this.lineNumber = this.lineNumberMark;
        this.lastChar = this.lastCharMark;
        this.position = this.positionMark;
        this.bytesRead = this.bytesReadMark;
        super.reset();
    }
}
