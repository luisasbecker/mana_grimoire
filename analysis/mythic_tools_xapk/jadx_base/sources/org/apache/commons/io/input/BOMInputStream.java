package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOIntConsumer;
import org.apache.commons.io.input.ProxyInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class BOMInputStream extends ProxyInputStream {
    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = Comparator.comparing(new Function() { // from class: org.apache.commons.io.input.BOMInputStream$$ExternalSyntheticLambda1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(((ByteOrderMark) obj).length());
        }
    }).reversed();
    private final List<ByteOrderMark> bomList;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    public static class Builder extends ProxyInputStream.AbstractBuilder<BOMInputStream, Builder> {
        private static final ByteOrderMark[] DEFAULT = {ByteOrderMark.UTF_8};
        private ByteOrderMark[] byteOrderMarks = DEFAULT;
        private boolean include;

        static ByteOrderMark getDefaultByteOrderMark() {
            return DEFAULT[0];
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public BOMInputStream get() throws IOException {
            return new BOMInputStream(this);
        }

        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ IOIntConsumer getAfterRead() {
            return super.getAfterRead();
        }

        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ AbstractStreamBuilder setAfterRead(IOIntConsumer iOIntConsumer) {
            return super.setAfterRead(iOIntConsumer);
        }

        public Builder setByteOrderMarks(ByteOrderMark... byteOrderMarkArr) {
            this.byteOrderMarks = byteOrderMarkArr != null ? (ByteOrderMark[]) byteOrderMarkArr.clone() : DEFAULT;
            return this;
        }

        public Builder setInclude(boolean z) {
            this.include = z;
            return this;
        }
    }

    @Deprecated
    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, Builder.DEFAULT);
    }

    @Deprecated
    public BOMInputStream(InputStream inputStream, boolean z) {
        this(inputStream, z, Builder.DEFAULT);
    }

    @Deprecated
    public BOMInputStream(InputStream inputStream, boolean z, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (IOUtils.length(byteOrderMarkArr) == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = z;
        List<ByteOrderMark> listAsList = Arrays.asList(byteOrderMarkArr);
        listAsList.sort(ByteOrderMarkLengthComparator);
        this.bomList = listAsList;
    }

    @Deprecated
    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    private BOMInputStream(Builder builder) throws IOException {
        super(builder);
        if (IOUtils.length(builder.byteOrderMarks) == 0) {
            throw new IllegalArgumentException("No ByteOrderMark specified.");
        }
        this.include = builder.include;
        List<ByteOrderMark> listAsList = Arrays.asList(builder.byteOrderMarks);
        listAsList.sort(ByteOrderMarkLengthComparator);
        this.bomList = listAsList;
    }

    public static Builder builder() {
        return new Builder();
    }

    private ByteOrderMark find() {
        return this.bomList.stream().filter(new Predicate() { // from class: org.apache.commons.io.input.BOMInputStream$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.matches((ByteOrderMark) obj);
            }
        }).findFirst().orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matches(ByteOrderMark byteOrderMark) {
        return byteOrderMark.matches(this.firstBytes);
    }

    private ByteOrderMark readBom() throws IOException {
        int length = this.bomList.get(0).length();
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = this.in.read();
            iArr[i2] = i3;
            afterRead(i3);
            i++;
            if (iArr[i2] < 0) {
                break;
            }
        }
        this.firstBytes = Arrays.copyOf(iArr, i);
        ByteOrderMark byteOrderMarkFind = find();
        if (byteOrderMarkFind != null && !this.include) {
            if (byteOrderMarkFind.length() < this.firstBytes.length) {
                this.fbIndex = byteOrderMarkFind.length();
                return byteOrderMarkFind;
            }
            this.firstBytes = new int[0];
        }
        return byteOrderMarkFind;
    }

    private int readFirstBytes() throws IOException {
        getBOM();
        int i = this.fbIndex;
        int[] iArr = this.firstBytes;
        if (i >= iArr.length) {
            return -1;
        }
        this.fbIndex = i + 1;
        return iArr[i];
    }

    public ByteOrderMark getBOM() throws IOException {
        if (this.firstBytes == null) {
            this.byteOrderMark = readBom();
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        ByteOrderMark byteOrderMark = this.byteOrderMark;
        if (byteOrderMark == null) {
            return null;
        }
        return byteOrderMark.getCharsetName();
    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) throws IOException {
        if (this.bomList.contains(byteOrderMark)) {
            return Objects.equals(getBOM(), byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configured to detect " + byteOrderMark);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.markFbIndex = this.fbIndex;
        this.markedAtStart = this.firstBytes == null;
        this.in.mark(i);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        checkOpen();
        int firstBytes = readFirstBytes();
        return firstBytes >= 0 ? firstBytes : this.in.read();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int firstBytes = 0;
        int i3 = 0;
        while (i2 > 0 && firstBytes >= 0) {
            firstBytes = readFirstBytes();
            if (firstBytes >= 0) {
                bArr[i] = (byte) (firstBytes & 255);
                i2--;
                i3++;
                i++;
            }
        }
        int i4 = this.in.read(bArr, i, i2);
        afterRead(i4);
        if (i4 >= 0) {
            return i3 + i4;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        this.in.reset();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        int i = 0;
        while (true) {
            j2 = i;
            if (j <= j2 || readFirstBytes() < 0) {
                break;
            }
            i++;
        }
        return this.in.skip(j - j2) + j2;
    }
}
