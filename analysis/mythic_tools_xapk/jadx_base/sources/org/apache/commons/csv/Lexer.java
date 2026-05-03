package org.apache.commons.csv;

import java.io.Closeable;
import java.io.IOException;
import org.apache.commons.csv.Token;

/* JADX INFO: loaded from: classes7.dex */
final class Lexer implements Closeable {
    private static final String CR_STRING = Character.toString('\r');
    private static final String LF_STRING = Character.toString('\n');
    private final int commentStart;
    private final char[] delimiter;
    private final char[] delimiterBuf;
    private final int escape;
    private final char[] escapeDelimiterBuf;
    private String firstEol;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreSurroundingSpaces;
    private boolean isLastTokenDelimiter;
    private final boolean lenientEof;
    private final int quoteChar;
    private final ExtendedBufferedReader reader;
    private final boolean trailingData;

    Lexer(CSVFormat cSVFormat, ExtendedBufferedReader extendedBufferedReader) {
        this.reader = extendedBufferedReader;
        this.delimiter = cSVFormat.getDelimiterCharArray();
        this.escape = nullToDisabled(cSVFormat.getEscapeCharacter());
        this.quoteChar = nullToDisabled(cSVFormat.getQuoteCharacter());
        this.commentStart = nullToDisabled(cSVFormat.getCommentMarker());
        this.ignoreSurroundingSpaces = cSVFormat.getIgnoreSurroundingSpaces();
        this.ignoreEmptyLines = cSVFormat.getIgnoreEmptyLines();
        this.lenientEof = cSVFormat.getLenientEof();
        this.trailingData = cSVFormat.getTrailingData();
        this.delimiterBuf = new char[r3.length - 1];
        this.escapeDelimiterBuf = new char[(r3.length * 2) - 1];
    }

    private void appendNextEscapedCharacterToToken(Token token) throws IOException {
        if (isEscapeDelimiter()) {
            token.content.append(this.delimiter);
            return;
        }
        int escape = readEscape();
        if (escape == -1) {
            token.content.append((char) this.escape).append((char) this.reader.getLastChar());
        } else {
            token.content.append((char) escape);
        }
    }

    private boolean isMetaChar(int i) {
        return i == this.escape || i == this.quoteChar || i == this.commentStart;
    }

    private int nullToDisabled(Character ch) {
        if (ch == null) {
            return -2;
        }
        return ch.charValue();
    }

    private Token parseEncapsulatedToken(Token token) throws IOException {
        token.isQuoted = true;
        long currentLineNumber = getCurrentLineNumber();
        while (true) {
            int i = this.reader.read();
            if (isQuoteChar(i)) {
                if (isQuoteChar(this.reader.peek())) {
                    token.content.append((char) this.reader.read());
                } else {
                    while (true) {
                        int i2 = this.reader.read();
                        if (isDelimiter(i2)) {
                            token.type = Token.Type.TOKEN;
                            return token;
                        }
                        if (isEndOfFile(i2)) {
                            token.type = Token.Type.EOF;
                            token.isReady = true;
                            return token;
                        }
                        if (readEndOfLine(i2)) {
                            token.type = Token.Type.EORECORD;
                            return token;
                        }
                        if (this.trailingData) {
                            token.content.append((char) i2);
                        } else if (!Character.isWhitespace((char) i2)) {
                            throw new CSVException("Invalid character between encapsulated token and delimiter at line: %,d, position: %,d", Long.valueOf(getCurrentLineNumber()), Long.valueOf(getCharacterPosition()));
                        }
                    }
                }
            } else if (isEscape(i)) {
                appendNextEscapedCharacterToToken(token);
            } else {
                if (isEndOfFile(i)) {
                    if (!this.lenientEof) {
                        throw new CSVException("(startline %,d) EOF reached before encapsulated token finished", Long.valueOf(currentLineNumber));
                    }
                    token.type = Token.Type.EOF;
                    token.isReady = true;
                    return token;
                }
                token.content.append((char) i);
            }
        }
    }

    private Token parseSimpleToken(Token token, int i) throws IOException {
        while (true) {
            if (readEndOfLine(i)) {
                token.type = Token.Type.EORECORD;
                break;
            }
            if (isEndOfFile(i)) {
                token.type = Token.Type.EOF;
                token.isReady = true;
                break;
            }
            if (isDelimiter(i)) {
                token.type = Token.Type.TOKEN;
                break;
            }
            if (isEscape(i)) {
                appendNextEscapedCharacterToToken(token);
            } else {
                token.content.append((char) i);
            }
            i = this.reader.read();
        }
        if (this.ignoreSurroundingSpaces) {
            trimTrailingSpaces(token.content);
        }
        return token;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    long getBytesRead() {
        return this.reader.getBytesRead();
    }

    long getCharacterPosition() {
        return this.reader.getPosition();
    }

    long getCurrentLineNumber() {
        return this.reader.getLineNumber();
    }

    String getFirstEol() {
        return this.firstEol;
    }

    boolean isClosed() {
        return this.reader.isClosed();
    }

    boolean isCommentStart(int i) {
        return i == this.commentStart;
    }

    boolean isDelimiter(int i) throws IOException {
        char c;
        this.isLastTokenDelimiter = false;
        char[] cArr = this.delimiter;
        if (i != cArr[0]) {
            return false;
        }
        if (cArr.length == 1) {
            this.isLastTokenDelimiter = true;
            return true;
        }
        this.reader.peek(this.delimiterBuf);
        int i2 = 0;
        do {
            char[] cArr2 = this.delimiterBuf;
            if (i2 >= cArr2.length) {
                boolean z = this.reader.read(cArr2, 0, cArr2.length) != -1;
                this.isLastTokenDelimiter = z;
                return z;
            }
            c = cArr2[i2];
            i2++;
        } while (c == this.delimiter[i2]);
        return false;
    }

    boolean isEndOfFile(int i) {
        return i == -1;
    }

    boolean isEscape(int i) {
        return i == this.escape;
    }

    boolean isEscapeDelimiter() throws IOException {
        this.reader.peek(this.escapeDelimiterBuf);
        if (this.escapeDelimiterBuf[0] != this.delimiter[0]) {
            return false;
        }
        int i = 1;
        while (true) {
            char[] cArr = this.delimiter;
            if (i >= cArr.length) {
                ExtendedBufferedReader extendedBufferedReader = this.reader;
                char[] cArr2 = this.escapeDelimiterBuf;
                return extendedBufferedReader.read(cArr2, 0, cArr2.length) != -1;
            }
            char[] cArr3 = this.escapeDelimiterBuf;
            int i2 = i * 2;
            if (cArr3[i2] != cArr[i] || cArr3[i2 - 1] != this.escape) {
                break;
            }
            i++;
        }
        return false;
    }

    boolean isQuoteChar(int i) {
        return i == this.quoteChar;
    }

    boolean isStartOfLine(int i) {
        return i == 10 || i == 13 || i == -2;
    }

    Token nextToken(Token token) throws IOException {
        int lastChar = this.reader.getLastChar();
        int i = this.reader.read();
        boolean endOfLine = readEndOfLine(i);
        if (this.ignoreEmptyLines) {
            while (endOfLine && isStartOfLine(lastChar)) {
                int i2 = this.reader.read();
                endOfLine = readEndOfLine(i2);
                if (isEndOfFile(i2)) {
                    token.type = Token.Type.EOF;
                    return token;
                }
                int i3 = i;
                i = i2;
                lastChar = i3;
            }
        }
        if (isEndOfFile(lastChar) || (!this.isLastTokenDelimiter && isEndOfFile(i))) {
            token.type = Token.Type.EOF;
            return token;
        }
        if (isStartOfLine(lastChar) && isCommentStart(i)) {
            String line = this.reader.readLine();
            if (line == null) {
                token.type = Token.Type.EOF;
                return token;
            }
            token.content.append(line.trim());
            token.type = Token.Type.COMMENT;
            return token;
        }
        while (token.type == Token.Type.INVALID) {
            if (this.ignoreSurroundingSpaces) {
                while (Character.isWhitespace((char) i) && !isDelimiter(i) && !endOfLine) {
                    i = this.reader.read();
                    endOfLine = readEndOfLine(i);
                }
            }
            if (isDelimiter(i)) {
                token.type = Token.Type.TOKEN;
            } else if (endOfLine) {
                token.type = Token.Type.EORECORD;
            } else if (isQuoteChar(i)) {
                parseEncapsulatedToken(token);
            } else if (isEndOfFile(i)) {
                token.type = Token.Type.EOF;
                token.isReady = true;
            } else {
                parseSimpleToken(token, i);
            }
        }
        return token;
    }

    boolean readEndOfLine(int i) throws IOException {
        if (i == 13 && this.reader.peek() == 10) {
            i = this.reader.read();
            if (this.firstEol == null) {
                this.firstEol = "\r\n";
            }
        }
        if (this.firstEol == null) {
            if (i == 10) {
                this.firstEol = LF_STRING;
            } else if (i == 13) {
                this.firstEol = CR_STRING;
            }
        }
        return i == 10 || i == 13;
    }

    int readEscape() throws IOException {
        int i = this.reader.read();
        if (i == -1) {
            throw new CSVException("EOF while processing escape sequence", new Object[0]);
        }
        if (i == 98) {
            return 8;
        }
        if (i == 102) {
            return 12;
        }
        if (i == 110) {
            return 10;
        }
        if (i == 114) {
            return 13;
        }
        if (i == 116) {
            return 9;
        }
        if (i != 12 && i != 13) {
            switch (i) {
                default:
                    if (!isMetaChar(i)) {
                        return -1;
                    }
                case 8:
                case 9:
                case 10:
                    return i;
            }
        }
        return i;
    }

    void trimTrailingSpaces(StringBuilder sb) {
        int length = sb.length();
        while (length > 0 && Character.isWhitespace(sb.charAt(length - 1))) {
            length--;
        }
        if (length != sb.length()) {
            sb.setLength(length);
        }
    }
}
