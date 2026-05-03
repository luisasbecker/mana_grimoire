package org.commonmark.internal.inline;

import androidx.core.net.MailTo;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes7.dex */
public class AutolinkInlineParser implements InlineContentParser {
    private static final Pattern URI = Pattern.compile("^[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*$");
    private static final Pattern EMAIL = Pattern.compile("^([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)$");

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        scanner.next();
        Position position = scanner.position();
        if (scanner.find(Typography.greater) > 0) {
            SourceLines source = scanner.getSource(position, scanner.position());
            String content = source.getContent();
            scanner.next();
            String str = URI.matcher(content).matches() ? content : EMAIL.matcher(content).matches() ? MailTo.MAILTO_SCHEME + content : null;
            if (str != null) {
                Link link = new Link(str, null);
                Text text = new Text(content);
                text.setSourceSpans(source.getSourceSpans());
                link.appendChild(text);
                return ParsedInline.of(link, scanner.position());
            }
        }
        return ParsedInline.none();
    }
}
