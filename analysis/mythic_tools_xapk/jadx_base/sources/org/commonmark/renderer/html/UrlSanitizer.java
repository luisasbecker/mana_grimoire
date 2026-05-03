package org.commonmark.renderer.html;

/* JADX INFO: loaded from: classes7.dex */
public interface UrlSanitizer {
    String sanitizeImageUrl(String str);

    String sanitizeLinkUrl(String str);
}
