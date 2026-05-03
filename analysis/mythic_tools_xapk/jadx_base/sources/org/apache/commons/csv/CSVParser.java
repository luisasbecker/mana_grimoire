package org.apache.commons.csv;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.Token;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOSupplier;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes7.dex */
public final class CSVParser implements Iterable<CSVRecord>, Closeable {
    private final long characterOffset;
    private final CSVRecordIterator csvRecordIterator;
    private final CSVFormat format;
    private String headerComment;
    private final Headers headers;
    private final Lexer lexer;
    private final List<String> recordList;
    private long recordNumber;
    private final Token reusableToken;
    private String trailerComment;

    /* JADX INFO: renamed from: org.apache.commons.csv.CSVParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$Token$Type;

        static {
            int[] iArr = new int[Token.Type.values().length];
            $SwitchMap$org$apache$commons$csv$Token$Type = iArr;
            try {
                iArr[Token.Type.TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EORECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EOF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Builder extends AbstractStreamBuilder<CSVParser, Builder> {
        private long characterOffset;
        private CSVFormat format;
        private long recordNumber = 1;
        private boolean trackBytes;

        protected Builder() {
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public CSVParser get() throws IOException {
            Reader reader = getReader();
            CSVFormat cSVFormat = this.format;
            if (cSVFormat == null) {
                cSVFormat = CSVFormat.DEFAULT;
            }
            return new CSVParser(reader, cSVFormat, this.characterOffset, this.recordNumber, getCharset(), this.trackBytes, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setCharacterOffset(long j) {
            this.characterOffset = j;
            return (Builder) asThis();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setFormat(CSVFormat cSVFormat) {
            this.format = CSVFormat.copy(cSVFormat);
            return (Builder) asThis();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setRecordNumber(long j) {
            this.recordNumber = j;
            return (Builder) asThis();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setTrackBytes(boolean z) {
            this.trackBytes = z;
            return (Builder) asThis();
        }
    }

    final class CSVRecordIterator implements Iterator<CSVRecord> {
        private CSVRecord current;

        CSVRecordIterator() {
        }

        private CSVRecord getNextRecord() {
            if (!CSVParser.this.format.useRow(CSVParser.this.recordNumber + 1)) {
                return null;
            }
            final CSVParser cSVParser = CSVParser.this;
            return (CSVRecord) Uncheck.get(new IOSupplier() { // from class: org.apache.commons.csv.CSVParser$CSVRecordIterator$$ExternalSyntheticLambda0
                @Override // org.apache.commons.io.function.IOSupplier
                public final Object get() {
                    return cSVParser.nextRecord();
                }
            });
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (CSVParser.this.isClosed()) {
                return false;
            }
            if (this.current == null) {
                this.current = getNextRecord();
            }
            return this.current != null;
        }

        @Override // java.util.Iterator
        public CSVRecord next() {
            if (CSVParser.this.isClosed()) {
                throw new NoSuchElementException("CSVParser has been closed");
            }
            CSVRecord cSVRecord = this.current;
            this.current = null;
            if (cSVRecord != null) {
                return cSVRecord;
            }
            CSVRecord nextRecord = getNextRecord();
            if (nextRecord != null) {
                return nextRecord;
            }
            throw new NoSuchElementException("No more CSV records available");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Headers {
        final Map<String, Integer> headerMap;
        final List<String> headerNames;

        Headers(Map<String, Integer> map, List<String> list) {
            this.headerMap = map;
            this.headerNames = list;
        }
    }

    @Deprecated
    public CSVParser(Reader reader, CSVFormat cSVFormat) throws IOException {
        this(reader, cSVFormat, 0L, 1L);
    }

    @Deprecated
    public CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2) throws IOException {
        this(reader, cSVFormat, j, j2, null, false);
    }

    private CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2, Charset charset, boolean z) throws IOException {
        this.recordList = new ArrayList();
        this.reusableToken = new Token();
        Objects.requireNonNull(reader, "reader");
        Objects.requireNonNull(cSVFormat, "format");
        this.format = cSVFormat.copy();
        this.lexer = new Lexer(cSVFormat, new ExtendedBufferedReader(reader, charset, z));
        this.csvRecordIterator = new CSVRecordIterator();
        this.headers = createHeaders();
        this.characterOffset = j;
        this.recordNumber = j2 - 1;
    }

    /* synthetic */ CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2, Charset charset, boolean z, AnonymousClass1 anonymousClass1) throws IOException {
        this(reader, cSVFormat, j, j2, charset, z);
    }

    private void addRecordValue(boolean z) {
        String strTrim = this.format.trim(this.reusableToken.content.toString());
        if (z && strTrim.isEmpty() && this.format.getTrailingDelimiter()) {
            return;
        }
        this.recordList.add(handleNull(strTrim));
    }

    public static Builder builder() {
        return new Builder();
    }

    private Map<String, Integer> createEmptyHeaderMap() {
        return this.format.getIgnoreHeaderCase() ? new TreeMap(String.CASE_INSENSITIVE_ORDER) : new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Headers createHeaders() throws IOException {
        ArrayList arrayList;
        CSVRecord cSVRecordNextRecord;
        String[] header = this.format.getHeader();
        Map<String, Integer> map = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        if (header != null) {
            Map<String, Integer> mapCreateEmptyHeaderMap = createEmptyHeaderMap();
            if (header.length == 0) {
                CSVRecord cSVRecordNextRecord2 = nextRecord();
                if (cSVRecordNextRecord2 != null) {
                    String[] strArrValues = cSVRecordNextRecord2.values();
                    this.headerComment = cSVRecordNextRecord2.getComment();
                    header = strArrValues;
                } else {
                    header = null;
                }
            } else if (this.format.getSkipHeaderRecord() && (cSVRecordNextRecord = nextRecord()) != null) {
                this.headerComment = cSVRecordNextRecord.getComment();
            }
            if (header != null) {
                boolean z = false;
                for (int i = 0; i < header.length; i++) {
                    String str = header[i];
                    boolean zIsBlank = CSVFormat.isBlank(str);
                    if (zIsBlank && !this.format.getAllowMissingColumnNames()) {
                        throw new IllegalArgumentException("A header name is missing in " + Arrays.toString(header));
                    }
                    boolean zContainsKey = zIsBlank ? z : mapCreateEmptyHeaderMap.containsKey(str);
                    DuplicateHeaderMode duplicateHeaderMode = this.format.getDuplicateHeaderMode();
                    Object[] objArr = duplicateHeaderMode == DuplicateHeaderMode.ALLOW_ALL;
                    boolean z2 = duplicateHeaderMode == DuplicateHeaderMode.ALLOW_EMPTY;
                    if (zContainsKey && objArr != true && (!zIsBlank || !z2)) {
                        throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.Builder.setDuplicateHeaderMode().", str, Arrays.toString(header)));
                    }
                    z |= zIsBlank;
                    if (str != null) {
                        mapCreateEmptyHeaderMap.put(str, Integer.valueOf(i));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList(header.length);
                        }
                        arrayList2.add(str);
                    }
                }
            }
            arrayList = arrayList2;
            map = mapCreateEmptyHeaderMap;
        } else {
            arrayList = null;
        }
        return new Headers(map, arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList));
    }

    private String handleNull(String str) {
        boolean z = this.reusableToken.isQuoted;
        String nullString = this.format.getNullString();
        boolean zIsStrictQuoteMode = isStrictQuoteMode();
        if (str.equals(nullString)) {
            if (!zIsStrictQuoteMode || !z) {
                return null;
            }
        } else if (zIsStrictQuoteMode && nullString == null && str.isEmpty() && !z) {
            return null;
        }
        return str;
    }

    private boolean isStrictQuoteMode() {
        return this.format.getQuoteMode() == QuoteMode.ALL_NON_NULL || this.format.getQuoteMode() == QuoteMode.NON_NUMERIC;
    }

    public static CSVParser parse(File file, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(file, "file");
        return parse(file.toPath(), charset, cSVFormat);
    }

    public static CSVParser parse(InputStream inputStream, Charset charset, CSVFormat cSVFormat) throws IOException {
        return parse(new InputStreamReader(inputStream, Charsets.toCharset(charset)), cSVFormat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CSVParser parse(Reader reader, CSVFormat cSVFormat) throws IOException {
        return ((Builder) builder().setReader(reader)).setFormat(cSVFormat).get();
    }

    public static CSVParser parse(String str, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(str, TypedValues.Custom.S_STRING);
        return parse(new StringReader(str), cSVFormat);
    }

    public static CSVParser parse(URL url, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(url, "url");
        return parse(url.openStream(), charset, cSVFormat);
    }

    public static CSVParser parse(Path path, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(path, "path");
        return parse(Files.newInputStream(path, new OpenOption[0]), charset, cSVFormat);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.lexer.close();
    }

    public long getCurrentLineNumber() {
        return this.lexer.getCurrentLineNumber();
    }

    public String getFirstEndOfLine() {
        return this.lexer.getFirstEol();
    }

    public String getHeaderComment() {
        return this.headerComment;
    }

    public Map<String, Integer> getHeaderMap() {
        if (this.headers.headerMap == null) {
            return null;
        }
        Map<String, Integer> mapCreateEmptyHeaderMap = createEmptyHeaderMap();
        mapCreateEmptyHeaderMap.putAll(this.headers.headerMap);
        return mapCreateEmptyHeaderMap;
    }

    Map<String, Integer> getHeaderMapRaw() {
        return this.headers.headerMap;
    }

    public List<String> getHeaderNames() {
        return Collections.unmodifiableList(this.headers.headerNames);
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public List<CSVRecord> getRecords() {
        return (List) stream().collect(Collectors.toList());
    }

    public String getTrailerComment() {
        return this.trailerComment;
    }

    public boolean hasHeaderComment() {
        return this.headerComment != null;
    }

    public boolean hasTrailerComment() {
        return this.trailerComment != null;
    }

    public boolean isClosed() {
        return this.lexer.isClosed();
    }

    @Override // java.lang.Iterable
    public Iterator<CSVRecord> iterator() {
        return this.csvRecordIterator;
    }

    CSVRecord nextRecord() throws IOException {
        this.recordList.clear();
        long characterPosition = this.lexer.getCharacterPosition() + this.characterOffset;
        long bytesRead = this.lexer.getBytesRead() + this.characterOffset;
        StringBuilder sb = null;
        do {
            this.reusableToken.reset();
            this.lexer.nextToken(this.reusableToken);
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$csv$Token$Type[this.reusableToken.type.ordinal()];
            if (i == 1) {
                addRecordValue(false);
            } else if (i == 2) {
                addRecordValue(true);
            } else if (i != 3) {
                if (i == 4) {
                    throw new CSVException("(line %,d) invalid parse sequence", Long.valueOf(getCurrentLineNumber()));
                }
                if (i != 5) {
                    throw new CSVException("Unexpected Token type: %s", this.reusableToken.type);
                }
                if (sb == null) {
                    sb = new StringBuilder();
                } else {
                    sb.append('\n');
                }
                sb.append((CharSequence) this.reusableToken.content);
                this.reusableToken.type = Token.Type.TOKEN;
            } else if (this.reusableToken.isReady) {
                addRecordValue(true);
            } else if (sb != null) {
                this.trailerComment = sb.toString();
            }
        } while (this.reusableToken.type == Token.Type.TOKEN);
        if (this.recordList.isEmpty()) {
            return null;
        }
        this.recordNumber++;
        return new CSVRecord(this, (String[]) this.recordList.toArray(Constants.EMPTY_STRING_ARRAY), Objects.toString(sb, null), this.recordNumber, characterPosition, bytesRead);
    }

    public Stream<CSVRecord> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), 16), false);
    }
}
