package org.apache.commons.codec.language.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.apache.commons.codec.Resources;
import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.codec.language.bm.Languages;

/* JADX INFO: loaded from: classes7.dex */
public class Lang {
    private static final String LANGUAGE_RULES_RN = "/org/apache/commons/codec/language/bm/%s_lang.txt";
    private final Languages languages;
    private final List<LangRule> rules;
    private static final Map<NameType, Lang> LANGS = new EnumMap(NameType.class);
    private static final Pattern PLUS = Pattern.compile("\\+");

    /* JADX INFO: Access modifiers changed from: private */
    static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set<String> languages;
        private final Pattern pattern;

        private LangRule(Pattern pattern, Set<String> set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            LANGS.put(nameType, loadFromResource(String.format(LANGUAGE_RULES_RN, nameType.getName()), Languages.getInstance(nameType)));
        }
    }

    private Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public static Lang instance(NameType nameType) {
        return LANGS.get(nameType);
    }

    static /* synthetic */ void lambda$guessLanguages$0(String str, Set set, LangRule langRule) {
        if (langRule.matches(str)) {
            if (langRule.acceptOnMatch) {
                set.retainAll(langRule.languages);
            } else {
                set.removeAll(langRule.languages);
            }
        }
    }

    public static Lang loadFromResource(String str, Languages languages) {
        ArrayList arrayList = new ArrayList();
        Scanner scanner = new Scanner(Resources.getInputStream(str), ResourceConstants.ENCODING);
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                try {
                    String strNextLine = scanner.nextLine();
                    if (z) {
                        if (strNextLine.endsWith("*/")) {
                            break;
                        }
                    } else if (strNextLine.startsWith("/*")) {
                        z = true;
                    } else {
                        int iIndexOf = strNextLine.indexOf("//");
                        String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                        if (!strTrim.isEmpty()) {
                            String[] strArrSplit = ResourceConstants.SPACES.split(strTrim);
                            if (strArrSplit.length != 3) {
                                throw new IllegalArgumentException("Malformed line '" + strNextLine + "' in language resource '" + str + "'");
                            }
                            arrayList.add(new LangRule(Pattern.compile(strArrSplit[0]), new HashSet(Arrays.asList(PLUS.split(strArrSplit[1]))), strArrSplit[2].equals("true")));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        scanner.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            scanner.close();
            return new Lang(arrayList, languages);
        }
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet languageSetGuessLanguages = guessLanguages(str);
        return languageSetGuessLanguages.isSingleton() ? languageSetGuessLanguages.getAny() : Languages.ANY;
    }

    public Languages.LanguageSet guessLanguages(String str) {
        final String lowerCase = str.toLowerCase(Locale.ENGLISH);
        final HashSet hashSet = new HashSet(this.languages.getLanguages());
        this.rules.forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.Lang$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Lang.lambda$guessLanguages$0(lowerCase, hashSet, (Lang.LangRule) obj);
            }
        });
        Languages.LanguageSet languageSetFrom = Languages.LanguageSet.from(hashSet);
        return languageSetFrom.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : languageSetFrom;
    }
}
