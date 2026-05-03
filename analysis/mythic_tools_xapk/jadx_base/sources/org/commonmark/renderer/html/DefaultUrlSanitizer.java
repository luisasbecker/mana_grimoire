package org.commonmark.renderer.html;

import androidx.webkit.ProxyConfig;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultUrlSanitizer implements UrlSanitizer {
    private Set<String> protocols;

    public DefaultUrlSanitizer() {
        this(Arrays.asList(ProxyConfig.MATCH_HTTP, ProxyConfig.MATCH_HTTPS, "mailto"));
    }

    public DefaultUrlSanitizer(Collection<String> collection) {
        this.protocols = new HashSet(collection);
    }

    private boolean isHtmlSpace(int i) {
        return i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    private String stripHtmlSpaces(String str) {
        int length = str.length();
        while (length > 0 && isHtmlSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && isHtmlSpace(str.charAt(i))) {
            i++;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String sanitizeImageUrl(String str) {
        return sanitizeLinkUrl(str);
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String sanitizeLinkUrl(String str) {
        String strStripHtmlSpaces = stripHtmlSpaces(str);
        int length = strStripHtmlSpaces.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = strStripHtmlSpaces.charAt(i);
            if (cCharAt == '#' || cCharAt == '/') {
                break;
            }
            if (cCharAt == ':') {
                if (!this.protocols.contains(strStripHtmlSpaces.substring(0, i).toLowerCase())) {
                    return "";
                }
            } else {
                if (cCharAt == '?') {
                    break;
                }
                i++;
            }
        }
        return strStripHtmlSpaces;
    }
}
