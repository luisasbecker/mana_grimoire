package org.commonmark.internal.inline;

import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.FilenameUtils;
import org.commonmark.internal.util.AsciiMatcher;
import org.commonmark.node.HtmlInline;

/* JADX INFO: loaded from: classes7.dex */
public class HtmlInlineParser implements InlineContentParser {
    private static final AsciiMatcher asciiLetter;
    private static final AsciiMatcher attributeContinue;
    private static final AsciiMatcher attributeStart;
    private static final AsciiMatcher attributeValueEnd;
    private static final AsciiMatcher tagNameContinue;
    private static final AsciiMatcher tagNameStart;

    static {
        AsciiMatcher asciiMatcherBuild = AsciiMatcher.builder().range('A', 'Z').range('a', 'z').build();
        asciiLetter = asciiMatcherBuild;
        tagNameStart = asciiMatcherBuild;
        tagNameContinue = asciiMatcherBuild.newBuilder().range('0', '9').c(Soundex.SILENT_MARKER).build();
        AsciiMatcher asciiMatcherBuild2 = asciiMatcherBuild.newBuilder().c('_').c(AbstractJsonLexerKt.COLON).build();
        attributeStart = asciiMatcherBuild2;
        attributeContinue = asciiMatcherBuild2.newBuilder().range('0', '9').c(FilenameUtils.EXTENSION_SEPARATOR).c(Soundex.SILENT_MARKER).build();
        attributeValueEnd = AsciiMatcher.builder().c(' ').c('\t').c('\n').c((char) 11).c('\f').c('\r').c('\"').c('\'').c('=').c(Typography.less).c(Typography.greater).c('`').build();
    }

    private static ParsedInline htmlInline(Position position, Scanner scanner) {
        String content = scanner.getSource(position, scanner.position()).getContent();
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.setLiteral(content);
        return ParsedInline.of(htmlInline, scanner.position());
    }

    private static boolean tryCdata(Scanner scanner) {
        scanner.next();
        if (!scanner.next("CDATA[")) {
            return false;
        }
        while (scanner.find(AbstractJsonLexerKt.END_LIST) >= 0) {
            if (scanner.next("]]>")) {
                return true;
            }
            scanner.next();
        }
        return false;
    }

    private static boolean tryClosingTag(Scanner scanner) {
        scanner.next();
        if (scanner.match(tagNameStart) < 1) {
            return false;
        }
        scanner.match(tagNameContinue);
        scanner.whitespace();
        return scanner.next(Typography.greater);
    }

    private static boolean tryComment(Scanner scanner) {
        scanner.next();
        if (scanner.next(Soundex.SILENT_MARKER) && !scanner.next(Typography.greater) && !scanner.next("->")) {
            while (scanner.find(Soundex.SILENT_MARKER) >= 0) {
                if (scanner.next("--")) {
                    return scanner.next(Typography.greater);
                }
                scanner.next();
            }
        }
        return false;
    }

    private static boolean tryDeclaration(Scanner scanner) {
        scanner.match(asciiLetter);
        if (scanner.whitespace() <= 0 || scanner.find(Typography.greater) < 0) {
            return false;
        }
        scanner.next();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r4.whitespace() < 1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r4.next('=') == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        r4.whitespace();
        r0 = r4.peek();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r0 != '\'') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r4.find('\'') >= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r0 != '\"') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r4.find('\"') >= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r4.find(org.commonmark.internal.inline.HtmlInlineParser.attributeValueEnd) > 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r4.whitespace() < 1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r4.next(org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        return r4.next(kotlin.text.Typography.greater);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0013, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        if (r4.whitespace() >= 1) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r4.match(org.commonmark.internal.inline.HtmlInlineParser.attributeStart) < 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r4.match(org.commonmark.internal.inline.HtmlInlineParser.attributeContinue);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:4:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean tryOpenTag(Scanner scanner) {
        scanner.next();
        scanner.match(tagNameContinue);
    }

    private static boolean tryProcessingInstruction(Scanner scanner) {
        scanner.next();
        while (scanner.find('?') > 0) {
            scanner.next();
            if (scanner.next(Typography.greater)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        Position position = scanner.position();
        scanner.next();
        char cPeek = scanner.peek();
        if (tagNameStart.matches(cPeek)) {
            if (tryOpenTag(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '/') {
            if (tryClosingTag(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '?') {
            if (tryProcessingInstruction(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '!') {
            scanner.next();
            char cPeek2 = scanner.peek();
            if (cPeek2 == '-') {
                if (tryComment(scanner)) {
                    return htmlInline(position, scanner);
                }
            } else if (cPeek2 == '[') {
                if (tryCdata(scanner)) {
                    return htmlInline(position, scanner);
                }
            } else if (asciiLetter.matches(cPeek2) && tryDeclaration(scanner)) {
                return htmlInline(position, scanner);
            }
        }
        return ParsedInline.none();
    }
}
