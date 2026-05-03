package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes7.dex */
public class UnsynchronizedBufferedReader extends UnsynchronizedReader {
    private static final char NUL = 0;
    private char[] buf;
    private int end;
    private final Reader in;
    private int mark;
    private int markLimit;
    private int pos;

    public UnsynchronizedBufferedReader(Reader reader) {
        this(reader, 8192);
    }

    public UnsynchronizedBufferedReader(Reader reader, int i) {
        this.mark = -1;
        this.markLimit = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.in = reader;
        this.buf = new char[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fillBuf() throws IOException {
        int i = this.mark;
        if (i != -1) {
            int i2 = this.pos - i;
            int i3 = this.markLimit;
            if (i2 < i3) {
                if (i == 0) {
                    char[] cArr = this.buf;
                    if (i3 > cArr.length) {
                        int length = cArr.length * 2;
                        if (length <= i3) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.buf = cArr2;
                    } else if (i > 0) {
                        char[] cArr3 = this.buf;
                        System.arraycopy(cArr3, i, cArr3, 0, cArr3.length - i);
                        int i4 = this.pos;
                        int i5 = this.mark;
                        this.pos = i4 - i5;
                        this.end -= i5;
                        this.mark = 0;
                    }
                }
                Reader reader = this.in;
                char[] cArr4 = this.buf;
                int i6 = this.pos;
                int i7 = reader.read(cArr4, i6, cArr4.length - i6);
                if (i7 != -1) {
                    this.end += i7;
                }
                return i7;
            }
        }
        Reader reader2 = this.in;
        char[] cArr5 = this.buf;
        int i8 = reader2.read(cArr5, 0, cArr5.length);
        if (i8 > 0) {
            this.mark = -1;
            this.pos = 0;
            this.end = i8;
        }
        return i8;
    }

    final void chompNewline() throws IOException {
        if (this.pos == this.end && fillBuf() == -1) {
            return;
        }
        char[] cArr = this.buf;
        int i = this.pos;
        if (cArr[i] == '\n') {
            this.pos = i + 1;
        }
    }

    @Override // org.apache.commons.io.input.UnsynchronizedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isClosed()) {
            return;
        }
        this.in.close();
        this.buf = null;
        super.close();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        checkOpen();
        this.markLimit = i;
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    public int peek() throws IOException {
        mark(1);
        int i = read();
        reset();
        return i;
    }

    public int peek(char[] cArr) throws IOException {
        int length = cArr.length;
        mark(length);
        int i = read(cArr, 0, length);
        reset();
        return i;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        checkOpen();
        if (this.pos >= this.end && fillBuf() == -1) {
            return -1;
        }
        char[] cArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        return cArr[i];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        checkOpen();
        if (i < 0 || i > cArr.length - i2 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            int i4 = this.end;
            int i5 = this.pos;
            int i6 = i4 - i5;
            if (i6 > 0) {
                if (i6 >= i3) {
                    i6 = i3;
                }
                System.arraycopy(this.buf, i5, cArr, i, i6);
                this.pos += i6;
                i += i6;
                i3 -= i6;
            }
            if (i3 == 0 || (i3 < i2 && !this.in.ready())) {
                break;
            }
            int i7 = this.mark;
            if ((i7 == -1 || this.pos - i7 >= this.markLimit) && i3 >= this.buf.length) {
                int i8 = this.in.read(cArr, i, i3);
                if (i8 > 0) {
                    i3 -= i8;
                    this.mark = -1;
                }
            } else if (fillBuf() == -1) {
                break;
            }
        }
        int i9 = i2 - i3;
        if (i9 > 0 || i9 == i2) {
            return i9;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ca, code lost:
    
        r4 = r9.buf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cc, code lost:
    
        if (r1 != 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
    
        r8 = r9.pos;
        r0.append(r4, r8, r7 - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
    
        r0.append(r4, r9.pos, (r7 - r8) - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readLine() throws IOException {
        checkOpen();
        if (this.pos != this.end || fillBuf() != -1) {
            int i = this.pos;
            while (true) {
                int i2 = this.end;
                char[] cArr = this.buf;
                if (i >= i2) {
                    StringBuilder sb = new StringBuilder(80);
                    int i3 = this.pos;
                    sb.append(cArr, i3, this.end - i3);
                    char c = 0;
                    while (true) {
                        this.pos = this.end;
                        if (c != '\n') {
                            if (fillBuf() != -1) {
                                int i4 = this.pos;
                                while (true) {
                                    int i5 = this.end;
                                    if (i4 >= i5) {
                                        break;
                                    }
                                    char[] cArr2 = this.buf;
                                    char c2 = cArr2[i4];
                                    if (c != 0) {
                                        if (c == '\r' && c2 == '\n') {
                                            int i6 = this.pos;
                                            if (i4 > i6) {
                                                sb.append(cArr2, i6, (i4 - i6) - 1);
                                            }
                                            this.pos = i4 + 1;
                                        } else {
                                            int i7 = this.pos;
                                            if (i4 > i7) {
                                                sb.append(cArr2, i7, (i4 - i7) - 1);
                                            }
                                            this.pos = i4;
                                        }
                                        return sb.toString();
                                    }
                                    if (c2 == '\n' || c2 == '\r') {
                                        c = c2;
                                    }
                                    i4++;
                                }
                            } else {
                                if (sb.length() > 0 || c != 0) {
                                    return sb.toString();
                                }
                                return null;
                            }
                        } else {
                            return sb.toString();
                        }
                    }
                } else {
                    char c3 = cArr[i];
                    if (c3 <= '\r') {
                        if (c3 == '\n') {
                            char[] cArr3 = this.buf;
                            int i8 = this.pos;
                            String str = new String(cArr3, i8, i - i8);
                            this.pos = i + 1;
                            return str;
                        }
                        if (c3 == '\r') {
                            char[] cArr4 = this.buf;
                            int i9 = this.pos;
                            String str2 = new String(cArr4, i9, i - i9);
                            int i10 = i + 1;
                            this.pos = i10;
                            if (i10 < this.end || fillBuf() != -1) {
                                char[] cArr5 = this.buf;
                                int i11 = this.pos;
                                if (cArr5[i11] == '\n') {
                                    this.pos = i11 + 1;
                                }
                            }
                            return str2;
                        }
                    }
                    i++;
                }
            }
        } else {
            return null;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        checkOpen();
        return this.end - this.pos > 0 || this.in.ready();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        checkOpen();
        int i = this.mark;
        if (i == -1) {
            throw new IOException("mark == -1");
        }
        this.pos = i;
    }

    @Override // org.apache.commons.io.input.UnsynchronizedReader, java.io.Reader
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        checkOpen();
        if (j < 1) {
            return 0L;
        }
        int i = this.end;
        int i2 = this.pos;
        if (i - i2 >= j) {
            this.pos = i2 + Math.toIntExact(j);
            return j;
        }
        long j2 = i - i2;
        this.pos = i;
        while (j2 < j) {
            if (fillBuf() == -1) {
                return j2;
            }
            int i3 = this.end;
            int i4 = this.pos;
            long j3 = j - j2;
            if (i3 - i4 >= j3) {
                this.pos = i4 + Math.toIntExact(j3);
                return j;
            }
            j2 += (long) (i3 - i4);
            this.pos = i3;
        }
        return j;
    }
}
