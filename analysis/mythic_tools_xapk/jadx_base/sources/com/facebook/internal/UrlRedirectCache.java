package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FileLruCache;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: UrlRedirectCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", ViewHierarchyConstants.TAG_KEY, "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", "uri", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = simpleName + "_Redirect";
    }

    private UrlRedirectCache() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @JvmStatic
    public static final void cacheUriRedirect(Uri fromUri, Uri toUri) {
        ?? r1;
        if (fromUri == null || toUri == null) {
            return;
        }
        ?? OpenPutStream = 0;
        OpenPutStream = 0;
        try {
            try {
                FileLruCache cache = getCache();
                String string = fromUri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "fromUri.toString()");
                OpenPutStream = cache.openPutStream(string, redirectContentTag);
                String string2 = toUri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toUri.toString()");
                byte[] bytes = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                OpenPutStream.write(bytes);
                r1 = OpenPutStream;
            } catch (IOException e) {
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
                r1 = OpenPutStream;
            }
        } finally {
            Utility.closeQuietly((Closeable) OpenPutStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.INSTANCE.log(LoggingBehavior.CACHE, 5, tag, "clearCache failed " + e.getMessage());
        }
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        fileLruCache = urlRedirectFileLruCache;
        if (fileLruCache == null) {
            fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
        }
        urlRedirectFileLruCache = fileLruCache;
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r9) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
    
        r5 = r6;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        com.facebook.internal.Logger.INSTANCE.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00c4: MOVE (r0 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:43:0x00c4 */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Uri getRedirectedUri(Uri uri) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        FileLruCache cache;
        InputStream inputStream;
        boolean z;
        InputStreamReader inputStreamReader3;
        InputStreamReader inputStreamReader4 = null;
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(string);
        try {
            try {
                cache = getCache();
                inputStream = cache.get(string, redirectContentTag);
                inputStreamReader = null;
                z = false;
            } catch (Throwable th) {
                th = th;
                inputStreamReader4 = inputStreamReader2;
            }
        } catch (IOException e) {
            e = e;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            if (inputStream == null) {
                break;
            }
            try {
                inputStreamReader3 = new InputStreamReader(inputStream);
            } catch (IOException e2) {
                e = e2;
            }
            try {
                char[] cArr = new char[128];
                StringBuilder sb = new StringBuilder();
                for (int i = inputStreamReader3.read(cArr, 0, 128); i > 0; i = inputStreamReader3.read(cArr, 0, 128)) {
                    sb.append(cArr, 0, i);
                }
                Utility.closeQuietly(inputStreamReader3);
                String string2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "urlBuilder.toString()");
                if (hashSet.contains(string2)) {
                    break;
                }
                hashSet.add(string2);
                inputStream = cache.get(string2, redirectContentTag);
                string = string2;
                inputStreamReader = inputStreamReader3;
                z = true;
            } catch (IOException e3) {
                e = e3;
                inputStreamReader = inputStreamReader3;
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader4 = inputStreamReader3;
                Utility.closeQuietly(inputStreamReader4);
                throw th;
            }
            Utility.closeQuietly(inputStreamReader);
            return null;
        }
        if (z) {
            Uri uri2 = Uri.parse(string);
            Utility.closeQuietly(inputStreamReader);
            return uri2;
        }
        Utility.closeQuietly(inputStreamReader);
        return null;
    }
}
