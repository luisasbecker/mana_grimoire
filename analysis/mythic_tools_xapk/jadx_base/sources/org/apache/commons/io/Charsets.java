package org.apache.commons.io;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes7.dex */
public class Charsets {

    @Deprecated
    public static final Charset ISO_8859_1;
    private static final SortedMap<String, Charset> STANDARD_CHARSET_MAP;

    @Deprecated
    public static final Charset US_ASCII;

    @Deprecated
    public static final Charset UTF_16;

    @Deprecated
    public static final Charset UTF_16BE;

    @Deprecated
    public static final Charset UTF_16LE;

    @Deprecated
    public static final Charset UTF_8;

    static {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
        treeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
        treeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
        treeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
        treeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
        treeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
        STANDARD_CHARSET_MAP = Collections.unmodifiableSortedMap(treeMap);
        ISO_8859_1 = StandardCharsets.ISO_8859_1;
        US_ASCII = StandardCharsets.US_ASCII;
        UTF_16 = StandardCharsets.UTF_16;
        UTF_16BE = StandardCharsets.UTF_16BE;
        UTF_16LE = StandardCharsets.UTF_16LE;
        UTF_8 = StandardCharsets.UTF_8;
    }

    @Deprecated
    public Charsets() {
    }

    public static boolean isAlias(Charset charset, final String str) {
        if (str == null) {
            return false;
        }
        if (charset.name().equalsIgnoreCase(str)) {
            return true;
        }
        Stream<String> stream = charset.aliases().stream();
        Objects.requireNonNull(str);
        return stream.anyMatch(new Predicate() { // from class: org.apache.commons.io.Charsets$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equalsIgnoreCase((String) obj);
            }
        });
    }

    public static boolean isUTF8(Charset charset) {
        return isUTF8Alias(toCharset(charset).name());
    }

    private static boolean isUTF8Alias(String str) {
        return isAlias(StandardCharsets.UTF_8, str);
    }

    public static SortedMap<String, Charset> requiredCharsets() {
        return STANDARD_CHARSET_MAP;
    }

    public static Charset toCharset(String str) throws UnsupportedCharsetException {
        return toCharset(str, Charset.defaultCharset());
    }

    public static Charset toCharset(String str, Charset charset) throws UnsupportedCharsetException {
        return str == null ? charset : Charset.forName(str);
    }

    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(Charset charset, Charset charset2) {
        return charset == null ? charset2 : charset;
    }

    public static Charset toCharsetDefault(String str, Charset charset) {
        try {
            return toCharset(str);
        } catch (RuntimeException unused) {
            return toCharset(charset);
        }
    }
}
