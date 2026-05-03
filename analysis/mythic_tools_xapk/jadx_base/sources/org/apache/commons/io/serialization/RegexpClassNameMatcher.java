package org.apache.commons.io.serialization;

import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
final class RegexpClassNameMatcher implements ClassNameMatcher {
    private final Pattern pattern;

    RegexpClassNameMatcher(String str) {
        this(Pattern.compile(str));
    }

    RegexpClassNameMatcher(Pattern pattern) {
        this.pattern = (Pattern) Objects.requireNonNull(pattern, "pattern");
    }

    @Override // org.apache.commons.io.serialization.ClassNameMatcher
    public boolean matches(String str) {
        return this.pattern.matcher(str).matches();
    }
}
