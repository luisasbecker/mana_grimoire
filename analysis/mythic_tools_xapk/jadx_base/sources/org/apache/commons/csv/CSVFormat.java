package org.apache.commons.csv;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import kotlin.text.Typography;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.function.IOSupplier;
import org.apache.commons.io.function.Uncheck;
import org.apache.commons.io.output.AppendableOutputStream;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes7.dex */
public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT;
    public static final CSVFormat EXCEL;
    public static final CSVFormat INFORMIX_UNLOAD;
    public static final CSVFormat INFORMIX_UNLOAD_CSV;
    public static final CSVFormat MONGODB_CSV;
    public static final CSVFormat MONGODB_TSV;
    public static final CSVFormat MYSQL;
    public static final CSVFormat ORACLE;
    public static final CSVFormat POSTGRESQL_CSV;
    public static final CSVFormat POSTGRESQL_TEXT;
    public static final CSVFormat RFC4180;
    public static final CSVFormat TDF;
    private static final long serialVersionUID = 2;
    private final boolean allowMissingColumnNames;
    private final boolean autoFlush;
    private final Character commentMarker;
    private final String delimiter;
    private final DuplicateHeaderMode duplicateHeaderMode;
    private final Character escapeCharacter;
    private final String[] headerComments;
    private final String[] headers;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreHeaderCase;
    private final boolean ignoreSurroundingSpaces;
    private final boolean lenientEof;
    private final long maxRows;
    private final String nullString;
    private final Character quoteCharacter;
    private final QuoteMode quoteMode;
    private final String quotedNullString;
    private final String recordSeparator;
    private final boolean skipHeaderRecord;
    private final boolean trailingData;
    private final boolean trailingDelimiter;
    private final boolean trim;

    /* JADX INFO: renamed from: org.apache.commons.csv.CSVFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode;

        static {
            int[] iArr = new int[QuoteMode.values().length];
            $SwitchMap$org$apache$commons$csv$QuoteMode = iArr;
            try {
                iArr[QuoteMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.ALL_NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NON_NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.MINIMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Builder implements Supplier<CSVFormat> {
        private boolean allowMissingColumnNames;
        private boolean autoFlush;
        private Character commentMarker;
        private String delimiter;
        private DuplicateHeaderMode duplicateHeaderMode;
        private Character escapeCharacter;
        private String[] headerComments;
        private String[] headers;
        private boolean ignoreEmptyLines;
        private boolean ignoreHeaderCase;
        private boolean ignoreSurroundingSpaces;
        private boolean lenientEof;
        private long maxRows;
        private String nullString;
        private Character quoteCharacter;
        private QuoteMode quoteMode;
        private String quotedNullString;
        private String recordSeparator;
        private boolean skipHeaderRecord;
        private boolean trailingData;
        private boolean trailingDelimiter;
        private boolean trim;

        private Builder() {
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder(CSVFormat cSVFormat) {
            this.allowMissingColumnNames = cSVFormat.allowMissingColumnNames;
            this.autoFlush = cSVFormat.autoFlush;
            this.commentMarker = cSVFormat.commentMarker;
            this.delimiter = cSVFormat.delimiter;
            this.duplicateHeaderMode = cSVFormat.duplicateHeaderMode;
            this.escapeCharacter = cSVFormat.escapeCharacter;
            this.headerComments = cSVFormat.headerComments;
            this.headers = cSVFormat.headers;
            this.ignoreEmptyLines = cSVFormat.ignoreEmptyLines;
            this.ignoreHeaderCase = cSVFormat.ignoreHeaderCase;
            this.ignoreSurroundingSpaces = cSVFormat.ignoreSurroundingSpaces;
            this.lenientEof = cSVFormat.lenientEof;
            this.maxRows = cSVFormat.maxRows;
            this.nullString = cSVFormat.nullString;
            this.quoteCharacter = cSVFormat.quoteCharacter;
            this.quoteMode = cSVFormat.quoteMode;
            this.quotedNullString = cSVFormat.quotedNullString;
            this.recordSeparator = cSVFormat.recordSeparator;
            this.skipHeaderRecord = cSVFormat.skipHeaderRecord;
            this.trailingData = cSVFormat.trailingData;
            this.trailingDelimiter = cSVFormat.trailingDelimiter;
            this.trim = cSVFormat.trim;
        }

        public static Builder create() {
            return new Builder().setDelimiter(",").setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator("\r\n").setIgnoreEmptyLines(true).setDuplicateHeaderMode(DuplicateHeaderMode.ALLOW_ALL);
        }

        public static Builder create(CSVFormat cSVFormat) {
            return new Builder(cSVFormat);
        }

        @Deprecated
        public CSVFormat build() {
            return get();
        }

        @Override // java.util.function.Supplier
        public CSVFormat get() {
            return new CSVFormat(this, null);
        }

        @Deprecated
        public Builder setAllowDuplicateHeaderNames(boolean z) {
            setDuplicateHeaderMode(z ? DuplicateHeaderMode.ALLOW_ALL : DuplicateHeaderMode.ALLOW_EMPTY);
            return this;
        }

        public Builder setAllowMissingColumnNames(boolean z) {
            this.allowMissingColumnNames = z;
            return this;
        }

        public Builder setAutoFlush(boolean z) {
            this.autoFlush = z;
            return this;
        }

        public Builder setCommentMarker(char c) {
            setCommentMarker(Character.valueOf(c));
            return this;
        }

        public Builder setCommentMarker(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The comment start marker character cannot be a line break");
            }
            this.commentMarker = ch;
            return this;
        }

        public Builder setDelimiter(char c) {
            return setDelimiter(String.valueOf(c));
        }

        public Builder setDelimiter(String str) {
            if (CSVFormat.containsLineBreak(str)) {
                throw new IllegalArgumentException("The delimiter cannot be a line break");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The delimiter cannot be empty");
            }
            this.delimiter = str;
            return this;
        }

        public Builder setDuplicateHeaderMode(DuplicateHeaderMode duplicateHeaderMode) {
            this.duplicateHeaderMode = (DuplicateHeaderMode) Objects.requireNonNull(duplicateHeaderMode, "duplicateHeaderMode");
            return this;
        }

        public Builder setEscape(char c) {
            setEscape(Character.valueOf(c));
            return this;
        }

        public Builder setEscape(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The escape character cannot be a line break");
            }
            this.escapeCharacter = ch;
            return this;
        }

        public Builder setHeader(Class<? extends Enum<?>> cls) {
            String[] strArr;
            if (cls != null) {
                final Enum[] enumArr = (Enum[]) cls.getEnumConstants();
                strArr = new String[enumArr.length];
                Arrays.setAll(strArr, new IntFunction() { // from class: org.apache.commons.csv.CSVFormat$Builder$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return enumArr[i].name();
                    }
                });
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeader(ResultSet resultSet) throws SQLException {
            return setHeader(resultSet != null ? resultSet.getMetaData() : null);
        }

        public Builder setHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
            String[] strArr;
            if (resultSetMetaData != null) {
                int columnCount = resultSetMetaData.getColumnCount();
                strArr = new String[columnCount];
                int i = 0;
                while (i < columnCount) {
                    int i2 = i + 1;
                    strArr[i] = resultSetMetaData.getColumnLabel(i2);
                    i = i2;
                }
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeader(String... strArr) {
            this.headers = (String[]) CSVFormat.clone(strArr);
            return this;
        }

        public Builder setHeaderComments(Object... objArr) {
            this.headerComments = (String[]) CSVFormat.clone(CSVFormat.toStringArray(objArr));
            return this;
        }

        public Builder setHeaderComments(String... strArr) {
            this.headerComments = (String[]) CSVFormat.clone(strArr);
            return this;
        }

        public Builder setIgnoreEmptyLines(boolean z) {
            this.ignoreEmptyLines = z;
            return this;
        }

        public Builder setIgnoreHeaderCase(boolean z) {
            this.ignoreHeaderCase = z;
            return this;
        }

        public Builder setIgnoreSurroundingSpaces(boolean z) {
            this.ignoreSurroundingSpaces = z;
            return this;
        }

        public Builder setLenientEof(boolean z) {
            this.lenientEof = z;
            return this;
        }

        public Builder setMaxRows(long j) {
            this.maxRows = j;
            return this;
        }

        public Builder setNullString(String str) {
            this.nullString = str;
            this.quotedNullString = this.quoteCharacter + str + this.quoteCharacter;
            return this;
        }

        public Builder setQuote(char c) {
            setQuote(Character.valueOf(c));
            return this;
        }

        public Builder setQuote(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The quoteCharacter cannot be a line break");
            }
            this.quoteCharacter = ch;
            return this;
        }

        public Builder setQuoteMode(QuoteMode quoteMode) {
            this.quoteMode = quoteMode;
            return this;
        }

        public Builder setRecordSeparator(char c) {
            this.recordSeparator = String.valueOf(c);
            return this;
        }

        public Builder setRecordSeparator(String str) {
            this.recordSeparator = str;
            return this;
        }

        public Builder setSkipHeaderRecord(boolean z) {
            this.skipHeaderRecord = z;
            return this;
        }

        public Builder setTrailingData(boolean z) {
            this.trailingData = z;
            return this;
        }

        public Builder setTrailingDelimiter(boolean z) {
            this.trailingDelimiter = z;
            return this;
        }

        public Builder setTrim(boolean z) {
            this.trim = z;
            return this;
        }
    }

    public enum Predefined {
        Default(CSVFormat.DEFAULT),
        Excel(CSVFormat.EXCEL),
        InformixUnload(CSVFormat.INFORMIX_UNLOAD),
        InformixUnloadCsv(CSVFormat.INFORMIX_UNLOAD_CSV),
        MongoDBCsv(CSVFormat.MONGODB_CSV),
        MongoDBTsv(CSVFormat.MONGODB_TSV),
        MySQL(CSVFormat.MYSQL),
        Oracle(CSVFormat.ORACLE),
        PostgreSQLCsv(CSVFormat.POSTGRESQL_CSV),
        PostgreSQLText(CSVFormat.POSTGRESQL_TEXT),
        RFC4180(CSVFormat.RFC4180),
        TDF(CSVFormat.TDF);

        private final CSVFormat format;

        Predefined(CSVFormat cSVFormat) {
            this.format = cSVFormat;
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        CSVFormat cSVFormat = new CSVFormat(Builder.create());
        DEFAULT = cSVFormat;
        EXCEL = cSVFormat.builder().setIgnoreEmptyLines(false).setAllowMissingColumnNames(true).setTrailingData(true).setLenientEof(true).get();
        INFORMIX_UNLOAD = cSVFormat.builder().setDelimiter('|').setEscape('\\').setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').get();
        INFORMIX_UNLOAD_CSV = cSVFormat.builder().setDelimiter(",").setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').get();
        MONGODB_CSV = cSVFormat.builder().setDelimiter(",").setEscape(Constants.DOUBLE_QUOTE_CHAR).setQuote(Constants.DOUBLE_QUOTE_CHAR).setQuoteMode(QuoteMode.MINIMAL).get();
        MONGODB_TSV = cSVFormat.builder().setDelimiter('\t').setEscape(Constants.DOUBLE_QUOTE_CHAR).setQuote(Constants.DOUBLE_QUOTE_CHAR).setQuoteMode(QuoteMode.MINIMAL).setSkipHeaderRecord(false).get();
        MYSQL = cSVFormat.builder().setDelimiter('\t').setEscape('\\').setIgnoreEmptyLines(false).setQuote((Character) null).setRecordSeparator('\n').setNullString("\\N").setQuoteMode(QuoteMode.ALL_NON_NULL).get();
        ORACLE = cSVFormat.builder().setDelimiter(",").setEscape('\\').setIgnoreEmptyLines(false).setQuote(Constants.DOUBLE_QUOTE_CHAR).setNullString("\\N").setTrim(true).setRecordSeparator(System.lineSeparator()).setQuoteMode(QuoteMode.MINIMAL).get();
        POSTGRESQL_CSV = cSVFormat.builder().setDelimiter(",").setEscape((Character) null).setIgnoreEmptyLines(false).setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').setNullString("").setQuoteMode(QuoteMode.ALL_NON_NULL).get();
        POSTGRESQL_TEXT = cSVFormat.builder().setDelimiter('\t').setEscape('\\').setIgnoreEmptyLines(false).setQuote((Character) null).setRecordSeparator('\n').setNullString("\\N").setQuoteMode(QuoteMode.ALL_NON_NULL).get();
        RFC4180 = cSVFormat.builder().setIgnoreEmptyLines(false).get();
        TDF = cSVFormat.builder().setDelimiter('\t').setIgnoreSurroundingSpaces(true).get();
    }

    private CSVFormat(Builder builder) {
        this.allowMissingColumnNames = builder.allowMissingColumnNames;
        this.autoFlush = builder.autoFlush;
        this.commentMarker = builder.commentMarker;
        this.delimiter = builder.delimiter;
        this.duplicateHeaderMode = builder.duplicateHeaderMode;
        this.escapeCharacter = builder.escapeCharacter;
        this.headerComments = builder.headerComments;
        this.headers = builder.headers;
        this.ignoreEmptyLines = builder.ignoreEmptyLines;
        this.ignoreHeaderCase = builder.ignoreHeaderCase;
        this.ignoreSurroundingSpaces = builder.ignoreSurroundingSpaces;
        this.lenientEof = builder.lenientEof;
        this.maxRows = builder.maxRows;
        this.nullString = builder.nullString;
        this.quoteCharacter = builder.quoteCharacter;
        this.quoteMode = builder.quoteMode;
        this.quotedNullString = builder.quotedNullString;
        this.recordSeparator = builder.recordSeparator;
        this.skipHeaderRecord = builder.skipHeaderRecord;
        this.trailingData = builder.trailingData;
        this.trailingDelimiter = builder.trailingDelimiter;
        this.trim = builder.trim;
        validate();
    }

    /* synthetic */ CSVFormat(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void append(char c, Appendable appendable) throws IOException {
        appendable.append(c);
    }

    private void append(CharSequence charSequence, Appendable appendable) throws IOException {
        appendable.append(charSequence);
    }

    @SafeVarargs
    static <T> T[] clone(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    private static boolean contains(String str, char c) {
        return ((String) Objects.requireNonNull(str, "source")).indexOf(c) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsLineBreak(String str) {
        return contains(str, '\r') || contains(str, '\n');
    }

    static CSVFormat copy(CSVFormat cSVFormat) {
        if (cSVFormat != null) {
            return cSVFormat.copy();
        }
        return null;
    }

    private void escape(char c, Appendable appendable) throws IOException {
        append(this.escapeCharacter.charValue(), appendable);
        append(c, appendable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: format_, reason: merged with bridge method [inline-methods] */
    public String m13235lambda$format$1$orgapachecommonscsvCSVFormat(Object... objArr) throws IOException {
        StringWriter stringWriter = new StringWriter();
        CSVPrinter cSVPrinter = new CSVPrinter(stringWriter, this);
        try {
            cSVPrinter.printRecord(objArr);
            String string = stringWriter.toString();
            String strSubstring = string.substring(0, this.recordSeparator != null ? string.length() - this.recordSeparator.length() : string.length());
            cSVPrinter.close();
            return strSubstring;
        } catch (Throwable th) {
            try {
                cSVPrinter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    private boolean isDelimiter(char c, CharSequence charSequence, int i, char[] cArr, int i2) {
        if (c != cArr[0] || i + i2 > charSequence.length()) {
            return false;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            if (charSequence.charAt(i + i3) != cArr[i3]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLineBreak(char c) {
        return c == '\n' || c == '\r';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLineBreak(Character ch) {
        return ch != null && isLineBreak(ch.charValue());
    }

    private static boolean isTrimChar(char c) {
        return c <= ' ';
    }

    private static boolean isTrimChar(CharSequence charSequence, int i) {
        return isTrimChar(charSequence.charAt(i));
    }

    public static CSVFormat newFormat(char c) {
        return new CSVFormat(new Builder((AnonymousClass1) null).setDelimiter(c));
    }

    private void print(InputStream inputStream, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            append(getDelimiterString(), appendable);
        }
        boolean zIsQuoteCharacterSet = isQuoteCharacterSet();
        if (zIsQuoteCharacterSet) {
            append(getQuoteCharacter().charValue(), appendable);
        }
        Base64OutputStream base64OutputStream = new Base64OutputStream(new AppendableOutputStream(appendable));
        try {
            IOUtils.copy(inputStream, base64OutputStream);
            base64OutputStream.close();
            if (zIsQuoteCharacterSet) {
                append(getQuoteCharacter().charValue(), appendable);
            }
        } catch (Throwable th) {
            try {
                base64OutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void print(Reader reader, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            append(getDelimiterString(), appendable);
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(reader, appendable);
            return;
        }
        if (isEscapeCharacterSet()) {
            printWithEscapes(reader, appendable);
        } else if (appendable instanceof Writer) {
            IOUtils.copyLarge(reader, (Writer) appendable);
        } else {
            IOUtils.copy(reader, appendable);
        }
    }

    private synchronized void print(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        int length = charSequence.length();
        if (!z) {
            appendable.append(getDelimiterString());
        }
        if (obj == null) {
            appendable.append(charSequence);
        } else if (isQuoteCharacterSet()) {
            printWithQuotes(obj, charSequence, appendable, z);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(charSequence, appendable);
        } else {
            appendable.append(charSequence, 0, length);
        }
    }

    private void printWithEscapes(Reader reader, Appendable appendable) throws IOException {
        ExtendedBufferedReader extendedBufferedReader = new ExtendedBufferedReader(reader);
        char[] delimiterCharArray = getDelimiterCharArray();
        int length = delimiterCharArray.length;
        char escapeChar = getEscapeChar();
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[length - 1];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = extendedBufferedReader.read();
            if (-1 == i3) {
                break;
            }
            char c = (char) i3;
            sb.append(c);
            Arrays.fill(cArr, (char) 0);
            extendedBufferedReader.peek(cArr);
            boolean zIsDelimiter = isDelimiter(c, sb.toString() + new String(cArr), i, delimiterCharArray, length);
            boolean z = i3 == 13;
            boolean z2 = i3 == 10;
            if (z || z2 || i3 == escapeChar || zIsDelimiter) {
                if (i > i2) {
                    append(sb.substring(i2, i), appendable);
                    sb.setLength(0);
                    i = -1;
                }
                if (z2) {
                    i3 = Videoio.CAP_PROP_OPENNI2_SYNC;
                } else if (z) {
                    i3 = 114;
                }
                escape((char) i3, appendable);
                if (zIsDelimiter) {
                    for (int i4 = 1; i4 < length; i4++) {
                        escape((char) extendedBufferedReader.read(), appendable);
                    }
                }
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(sb, i2, i);
        }
    }

    private void printWithEscapes(CharSequence charSequence, Appendable appendable) throws IOException {
        int length = charSequence.length();
        char[] delimiterCharArray = getDelimiterCharArray();
        int length2 = delimiterCharArray.length;
        char escapeChar = getEscapeChar();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            CSVFormat cSVFormat = this;
            CharSequence charSequence2 = charSequence;
            boolean zIsDelimiter = cSVFormat.isDelimiter(cCharAt, charSequence2, i, delimiterCharArray, length2);
            boolean z = cCharAt == '\r';
            boolean z2 = cCharAt == '\n';
            if (z || z2 || cCharAt == escapeChar || zIsDelimiter) {
                if (i > i2) {
                    appendable.append(charSequence2, i2, i);
                }
                if (z2) {
                    cCharAt = 'n';
                } else if (z) {
                    cCharAt = 'r';
                }
                cSVFormat.escape(cCharAt, appendable);
                if (zIsDelimiter) {
                    for (int i3 = 1; i3 < length2; i3++) {
                        i++;
                        cSVFormat.escape(charSequence2.charAt(i), appendable);
                    }
                }
                i2 = i + 1;
            }
            i++;
            this = cSVFormat;
            charSequence = charSequence2;
        }
        CharSequence charSequence3 = charSequence;
        if (i > i2) {
            appendable.append(charSequence3, i2, i);
        }
    }

    private void printWithQuotes(Reader reader, Appendable appendable) throws IOException {
        if (getQuoteMode() == QuoteMode.NONE) {
            printWithEscapes(reader, appendable);
            return;
        }
        char cCharValue = getQuoteCharacter().charValue();
        append(cCharValue, appendable);
        while (true) {
            int i = reader.read();
            if (-1 == i) {
                append(cCharValue, appendable);
                return;
            } else {
                append((char) i, appendable);
                if (i == cCharValue) {
                    append(cCharValue, appendable);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087 A[PHI: r4
      0x0087: PHI (r4v6 int) = (r4v5 int), (r4v7 int) binds: [B:41:0x0078, B:43:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void printWithQuotes(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        CharSequence charSequence2;
        int i;
        boolean z2;
        int length = charSequence.length();
        char[] delimiterCharArray = getDelimiterCharArray();
        int length2 = delimiterCharArray.length;
        char cCharValue = getQuoteCharacter().charValue();
        char escapeChar = isEscapeCharacterSet() ? getEscapeChar() : cCharValue;
        QuoteMode quoteMode = getQuoteMode();
        if (quoteMode == null) {
            quoteMode = QuoteMode.MINIMAL;
        }
        int i2 = AnonymousClass1.$SwitchMap$org$apache$commons$csv$QuoteMode[quoteMode.ordinal()];
        boolean z3 = true;
        int i3 = 0;
        if (i2 == 1 || i2 == 2) {
            charSequence2 = charSequence;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    printWithEscapes(charSequence, appendable);
                    return;
                }
                if (i2 != 5) {
                    throw new IllegalStateException("Unexpected Quote value: " + quoteMode);
                }
                if (length <= 0) {
                    if (z) {
                        charSequence2 = charSequence;
                        i = 0;
                    } else {
                        charSequence2 = charSequence;
                        i = 0;
                        z3 = false;
                    }
                    if (!z3) {
                        appendable.append(charSequence2, 0, length);
                        return;
                    }
                } else {
                    if (charSequence.charAt(0) > '#') {
                        i = 0;
                        while (i < length) {
                            char cCharAt = charSequence.charAt(i);
                            if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == cCharValue || cCharAt == escapeChar) {
                                charSequence2 = charSequence;
                                z2 = true;
                                break;
                            }
                            CSVFormat cSVFormat = this;
                            charSequence2 = charSequence;
                            if (cSVFormat.isDelimiter(cCharAt, charSequence2, i, delimiterCharArray, length2)) {
                                z2 = true;
                                break;
                            } else {
                                i++;
                                this = cSVFormat;
                                charSequence = charSequence2;
                            }
                        }
                        charSequence2 = charSequence;
                        z2 = false;
                        if (!z2) {
                            i = length - 1;
                            if (!isTrimChar(charSequence2.charAt(i))) {
                                z3 = z2;
                            }
                        }
                    }
                    if (!z3) {
                    }
                }
                if (z3) {
                    appendable.append(charSequence2, 0, length);
                    return;
                }
                appendable.append(cCharValue);
                while (i < length) {
                    char cCharAt2 = charSequence2.charAt(i);
                    if (cCharAt2 == cCharValue || cCharAt2 == escapeChar) {
                        appendable.append(charSequence2, i3, i);
                        appendable.append(escapeChar);
                        i3 = i;
                    }
                    i++;
                }
                appendable.append(charSequence2, i3, i);
                appendable.append(cCharValue);
                return;
            }
            charSequence2 = charSequence;
            z3 = true ^ (obj instanceof Number);
        }
        i = 0;
        if (z3) {
        }
    }

    static String[] toStringArray(final Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        Arrays.setAll(strArr, new IntFunction() { // from class: org.apache.commons.csv.CSVFormat$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return Objects.toString(objArr[i], null);
            }
        });
        return strArr;
    }

    static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && isTrimChar(charSequence, i)) {
            i++;
        }
        int i2 = length;
        while (i < i2 && isTrimChar(charSequence, i2 - 1)) {
            i2--;
        }
        return (i > 0 || i2 < length) ? charSequence.subSequence(i, i2) : charSequence;
    }

    private void validate() throws IllegalArgumentException {
        Character ch = this.quoteCharacter;
        if (ch != null && contains(this.delimiter, ch.charValue())) {
            throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
        }
        Character ch2 = this.escapeCharacter;
        if (ch2 != null && contains(this.delimiter, ch2.charValue())) {
            throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
        }
        Character ch3 = this.commentMarker;
        if (ch3 != null && contains(this.delimiter, ch3.charValue())) {
            throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch4 = this.quoteCharacter;
        if (ch4 != null && ch4.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch5 = this.escapeCharacter;
        if (ch5 != null && ch5.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
        }
        if (this.escapeCharacter == null && this.quoteMode == QuoteMode.NONE) {
            throw new IllegalArgumentException("Quote mode set to NONE but no escape character is set");
        }
        if (this.headers == null || this.duplicateHeaderMode == DuplicateHeaderMode.ALLOW_ALL) {
            return;
        }
        HashSet hashSet = new HashSet(this.headers.length);
        boolean z = this.duplicateHeaderMode == DuplicateHeaderMode.ALLOW_EMPTY;
        for (String str : this.headers) {
            boolean zIsBlank = isBlank(str);
            if (!hashSet.add(zIsBlank ? "" : str) && (!zIsBlank || !z)) {
                throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.Builder.setDuplicateHeaderMode().", str, Arrays.toString(this.headers)));
            }
        }
    }

    public static CSVFormat valueOf(String str) {
        return Predefined.valueOf(str).getFormat();
    }

    public Builder builder() {
        return Builder.create(this);
    }

    CSVFormat copy() {
        return builder().get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CSVFormat cSVFormat = (CSVFormat) obj;
        return this.allowMissingColumnNames == cSVFormat.allowMissingColumnNames && this.autoFlush == cSVFormat.autoFlush && Objects.equals(this.commentMarker, cSVFormat.commentMarker) && Objects.equals(this.delimiter, cSVFormat.delimiter) && this.duplicateHeaderMode == cSVFormat.duplicateHeaderMode && Objects.equals(this.escapeCharacter, cSVFormat.escapeCharacter) && Arrays.equals(this.headerComments, cSVFormat.headerComments) && Arrays.equals(this.headers, cSVFormat.headers) && this.ignoreEmptyLines == cSVFormat.ignoreEmptyLines && this.ignoreHeaderCase == cSVFormat.ignoreHeaderCase && this.ignoreSurroundingSpaces == cSVFormat.ignoreSurroundingSpaces && this.lenientEof == cSVFormat.lenientEof && Objects.equals(this.nullString, cSVFormat.nullString) && Objects.equals(this.quoteCharacter, cSVFormat.quoteCharacter) && this.quoteMode == cSVFormat.quoteMode && Objects.equals(this.quotedNullString, cSVFormat.quotedNullString) && Objects.equals(this.recordSeparator, cSVFormat.recordSeparator) && this.skipHeaderRecord == cSVFormat.skipHeaderRecord && this.trailingData == cSVFormat.trailingData && this.trailingDelimiter == cSVFormat.trailingDelimiter && this.trim == cSVFormat.trim;
    }

    public String format(final Object... objArr) {
        return (String) Uncheck.get(new IOSupplier() { // from class: org.apache.commons.csv.CSVFormat$$ExternalSyntheticLambda0
            @Override // org.apache.commons.io.function.IOSupplier
            public final Object get() {
                return this.f$0.m13235lambda$format$1$orgapachecommonscsvCSVFormat(objArr);
            }
        });
    }

    @Deprecated
    public boolean getAllowDuplicateHeaderNames() {
        return this.duplicateHeaderMode == DuplicateHeaderMode.ALLOW_ALL;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    @Deprecated
    public char getDelimiter() {
        return this.delimiter.charAt(0);
    }

    char[] getDelimiterCharArray() {
        return this.delimiter.toCharArray();
    }

    public String getDelimiterString() {
        return this.delimiter;
    }

    public DuplicateHeaderMode getDuplicateHeaderMode() {
        return this.duplicateHeaderMode;
    }

    char getEscapeChar() {
        Character ch = this.escapeCharacter;
        if (ch != null) {
            return ch.charValue();
        }
        return (char) 0;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] strArr = this.headers;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public String[] getHeaderComments() {
        String[] strArr = this.headerComments;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public boolean getLenientEof() {
        return this.lenientEof;
    }

    public long getMaxRows() {
        return this.maxRows;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingData() {
        return this.trailingData;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.headerComments) + 31) * 31) + Arrays.hashCode(this.headers)) * 31) + Objects.hash(Boolean.valueOf(this.allowMissingColumnNames), Boolean.valueOf(this.autoFlush), this.commentMarker, this.delimiter, this.duplicateHeaderMode, this.escapeCharacter, Boolean.valueOf(this.ignoreEmptyLines), Boolean.valueOf(this.ignoreHeaderCase), Boolean.valueOf(this.ignoreSurroundingSpaces), Boolean.valueOf(this.lenientEof), this.nullString, this.quoteCharacter, this.quoteMode, this.quotedNullString, this.recordSeparator, Boolean.valueOf(this.skipHeaderRecord), Boolean.valueOf(this.trailingData), Boolean.valueOf(this.trailingDelimiter), Boolean.valueOf(this.trim));
    }

    public boolean isCommentMarkerSet() {
        return this.commentMarker != null;
    }

    public boolean isEscapeCharacterSet() {
        return this.escapeCharacter != null;
    }

    public boolean isNullStringSet() {
        return this.nullString != null;
    }

    public boolean isQuoteCharacterSet() {
        return this.quoteCharacter != null;
    }

    <T> IOStream<T> limit(IOStream<T> iOStream) {
        return useMaxRows() ? iOStream.limit(getMaxRows()) : iOStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CSVParser parse(Reader reader) throws IOException {
        return ((CSVParser.Builder) CSVParser.builder().setReader(reader)).setFormat(this).get();
    }

    public CSVPrinter print(File file, Charset charset) throws IOException {
        return print(file.toPath(), charset);
    }

    public CSVPrinter print(Appendable appendable) throws IOException {
        return new CSVPrinter(appendable, this);
    }

    public CSVPrinter print(Path path, Charset charset) throws IOException {
        return print(Files.newBufferedWriter(path, charset, new OpenOption[0]));
    }

    public synchronized void print(Object obj, Appendable appendable, boolean z) throws IOException {
        String string;
        if (obj == null) {
            string = this.nullString == null ? "" : QuoteMode.ALL == this.quoteMode ? this.quotedNullString : this.nullString;
        } else if (obj instanceof CharSequence) {
            string = (CharSequence) obj;
        } else if (obj instanceof Reader) {
            print((Reader) obj, appendable, z);
            return;
        } else {
            if (obj instanceof InputStream) {
                print((InputStream) obj, appendable, z);
                return;
            }
            string = obj.toString();
        }
        if (getTrim()) {
            string = trim(string);
        }
        print(obj, string, appendable, z);
    }

    public synchronized void printRecord(Appendable appendable, Object... objArr) throws IOException {
        int i = 0;
        while (i < objArr.length) {
            print(objArr[i], appendable, i == 0);
            i++;
        }
        println(appendable);
    }

    public CSVPrinter printer() throws IOException {
        return new CSVPrinter(System.out, this);
    }

    public synchronized void println(Appendable appendable) throws IOException {
        if (getTrailingDelimiter()) {
            append(getDelimiterString(), appendable);
        }
        String str = this.recordSeparator;
        if (str != null) {
            append(str, appendable);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Delimiter=<");
        sb.append(this.delimiter).append(Typography.greater);
        if (isEscapeCharacterSet()) {
            sb.append(" Escape=<");
            sb.append(this.escapeCharacter).append(Typography.greater);
        }
        if (isQuoteCharacterSet()) {
            sb.append(" QuoteChar=<");
            sb.append(this.quoteCharacter).append(Typography.greater);
        }
        if (this.quoteMode != null) {
            sb.append(" QuoteMode=<");
            sb.append(this.quoteMode).append(Typography.greater);
        }
        if (isCommentMarkerSet()) {
            sb.append(" CommentStart=<");
            sb.append(this.commentMarker).append(Typography.greater);
        }
        if (isNullStringSet()) {
            sb.append(" NullString=<");
            sb.append(this.nullString).append(Typography.greater);
        }
        if (this.recordSeparator != null) {
            sb.append(" RecordSeparator=<");
            sb.append(this.recordSeparator).append(Typography.greater);
        }
        if (getIgnoreEmptyLines()) {
            sb.append(" EmptyLines:ignored");
        }
        if (getIgnoreSurroundingSpaces()) {
            sb.append(" SurroundingSpaces:ignored");
        }
        if (getIgnoreHeaderCase()) {
            sb.append(" IgnoreHeaderCase:ignored");
        }
        sb.append(" SkipHeaderRecord:").append(this.skipHeaderRecord);
        if (this.headerComments != null) {
            sb.append(" HeaderComments:");
            sb.append(Arrays.toString(this.headerComments));
        }
        if (this.headers != null) {
            sb.append(" Header:");
            sb.append(Arrays.toString(this.headers));
        }
        return sb.toString();
    }

    String trim(String str) {
        return getTrim() ? str.trim() : str;
    }

    boolean useMaxRows() {
        return getMaxRows() > 0;
    }

    boolean useRow(long j) {
        return !useMaxRows() || j <= getMaxRows();
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames() {
        return builder().setDuplicateHeaderMode(DuplicateHeaderMode.ALLOW_ALL).get();
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames(boolean z) {
        return builder().setDuplicateHeaderMode(z ? DuplicateHeaderMode.ALLOW_ALL : DuplicateHeaderMode.ALLOW_EMPTY).get();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames() {
        return builder().setAllowMissingColumnNames(true).get();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames(boolean z) {
        return builder().setAllowMissingColumnNames(z).get();
    }

    @Deprecated
    public CSVFormat withAutoFlush(boolean z) {
        return builder().setAutoFlush(z).get();
    }

    @Deprecated
    public CSVFormat withCommentMarker(char c) {
        return builder().setCommentMarker(c).get();
    }

    @Deprecated
    public CSVFormat withCommentMarker(Character ch) {
        return builder().setCommentMarker(ch).get();
    }

    @Deprecated
    public CSVFormat withDelimiter(char c) {
        return builder().setDelimiter(c).get();
    }

    @Deprecated
    public CSVFormat withEscape(char c) {
        return builder().setEscape(c).get();
    }

    @Deprecated
    public CSVFormat withEscape(Character ch) {
        return builder().setEscape(ch).get();
    }

    @Deprecated
    public CSVFormat withFirstRecordAsHeader() {
        return builder().setHeader(new String[0]).setSkipHeaderRecord(true).get();
    }

    @Deprecated
    public CSVFormat withHeader(Class<? extends Enum<?>> cls) {
        return builder().setHeader(cls).get();
    }

    @Deprecated
    public CSVFormat withHeader(ResultSet resultSet) throws SQLException {
        return builder().setHeader(resultSet).get();
    }

    @Deprecated
    public CSVFormat withHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        return builder().setHeader(resultSetMetaData).get();
    }

    @Deprecated
    public CSVFormat withHeader(String... strArr) {
        return builder().setHeader(strArr).get();
    }

    @Deprecated
    public CSVFormat withHeaderComments(Object... objArr) {
        return builder().setHeaderComments(objArr).get();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines() {
        return builder().setIgnoreEmptyLines(true).get();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines(boolean z) {
        return builder().setIgnoreEmptyLines(z).get();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase() {
        return builder().setIgnoreHeaderCase(true).get();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase(boolean z) {
        return builder().setIgnoreHeaderCase(z).get();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces() {
        return builder().setIgnoreSurroundingSpaces(true).get();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces(boolean z) {
        return builder().setIgnoreSurroundingSpaces(z).get();
    }

    @Deprecated
    public CSVFormat withNullString(String str) {
        return builder().setNullString(str).get();
    }

    @Deprecated
    public CSVFormat withQuote(char c) {
        return builder().setQuote(c).get();
    }

    @Deprecated
    public CSVFormat withQuote(Character ch) {
        return builder().setQuote(ch).get();
    }

    @Deprecated
    public CSVFormat withQuoteMode(QuoteMode quoteMode) {
        return builder().setQuoteMode(quoteMode).get();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(char c) {
        return builder().setRecordSeparator(c).get();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(String str) {
        return builder().setRecordSeparator(str).get();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord() {
        return builder().setSkipHeaderRecord(true).get();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord(boolean z) {
        return builder().setSkipHeaderRecord(z).get();
    }

    @Deprecated
    public CSVFormat withSystemRecordSeparator() {
        return builder().setRecordSeparator(System.lineSeparator()).get();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter() {
        return builder().setTrailingDelimiter(true).get();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter(boolean z) {
        return builder().setTrailingDelimiter(z).get();
    }

    @Deprecated
    public CSVFormat withTrim() {
        return builder().setTrim(true).get();
    }

    @Deprecated
    public CSVFormat withTrim(boolean z) {
        return builder().setTrim(z).get();
    }
}
