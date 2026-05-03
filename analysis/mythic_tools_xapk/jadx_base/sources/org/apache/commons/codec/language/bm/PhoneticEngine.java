package org.apache.commons.codec.language.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: loaded from: classes7.dex */
public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES;
    private static final Pattern QUOTE;
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    /* JADX INFO: renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$org$apache$commons$codec$language$bm$NameType = iArr;
            try {
                iArr[NameType.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        /* synthetic */ PhonemeBuilder(Set set, AnonymousClass1 anonymousClass1) {
            this((Set<Rule.Phoneme>) set);
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.phonemes = linkedHashSet;
            linkedHashSet.add(phoneme);
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme("", languageSet));
        }

        public void append(final CharSequence charSequence) {
            this.phonemes.forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Rule.Phoneme) obj).append(charSequence);
                }
            });
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(Math.min(this.phonemes.size() * phonemeExpr.size(), i));
            loop0: for (Rule.Phoneme phoneme : this.phonemes) {
                for (Rule.Phoneme phoneme2 : phonemeExpr.getPhonemes()) {
                    Languages.LanguageSet languageSetRestrictTo = phoneme.getLanguages().restrictTo(phoneme2.getLanguages());
                    if (!languageSetRestrictTo.isEmpty()) {
                        Rule.Phoneme phoneme3 = new Rule.Phoneme(phoneme, phoneme2, languageSetRestrictTo);
                        if (linkedHashSet.size() < i) {
                            linkedHashSet.add(phoneme3);
                            if (linkedHashSet.size() >= i) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            return (String) this.phonemes.stream().map(new Function() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Rule.Phoneme) obj).getPhonemeText();
                }
            }).collect(Collectors.joining("|"));
        }
    }

    private static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private final int maxPhonemes;
        private final PhonemeBuilder phonemeBuilder;

        RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder, int i, int i2) {
            Objects.requireNonNull(map, "finalRules");
            this.finalRules = map;
            this.phonemeBuilder = phonemeBuilder;
            this.input = charSequence;
            this.i = i;
            this.maxPhonemes = i2;
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i;
            this.found = false;
            Map<String, List<Rule>> map = this.finalRules;
            CharSequence charSequence = this.input;
            int i2 = this.i;
            List<Rule> list = map.get(charSequence.subSequence(i2, i2 + 1));
            if (list != null) {
                Iterator<Rule> it = list.iterator();
                i = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Rule next = it.next();
                    int length = next.getPattern().length();
                    if (next.patternAndContextMatches(this.input, this.i)) {
                        this.phonemeBuilder.apply(next.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i = length;
                        break;
                    }
                    i = length;
                }
            } else {
                i = 1;
            }
            this.i += this.found ? i : 1;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        QUOTE = Pattern.compile("'");
        enumMap.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", "de", "van", "von"))));
        enumMap.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"))));
        enumMap.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"))));
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z) {
        this(nameType, ruleType, z, 20);
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z, int i) {
        if (ruleType == RuleType.RULES) {
            throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
        }
        this.nameType = nameType;
        this.ruleType = ruleType;
        this.concat = z;
        this.lang = Lang.instance(nameType);
        this.maxPhonemes = i;
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, final Map<String, List<Rule>> map) {
        Objects.requireNonNull(map, "finalRules");
        if (map.isEmpty()) {
            return phonemeBuilder;
        }
        final TreeMap treeMap = new TreeMap(Rule.Phoneme.COMPARATOR);
        phonemeBuilder.getPhonemes().forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m13233xf7464fbc(map, treeMap, (Rule.Phoneme) obj);
            }
        });
        return new PhonemeBuilder(treeMap.keySet(), null);
    }

    private static String join(List<String> list, String str) {
        return (String) list.stream().collect(Collectors.joining(str));
    }

    static /* synthetic */ void lambda$applyFinalRules$0(Map map, Rule.Phoneme phoneme) {
        if (!map.containsKey(phoneme)) {
            map.put(phoneme, phoneme);
        } else {
            Rule.Phoneme phonemeMergeWithLanguage = ((Rule.Phoneme) map.remove(phoneme)).mergeWithLanguage(phoneme.getLanguages());
            map.put(phonemeMergeWithLanguage, phonemeMergeWithLanguage);
        }
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        Map<String, List<Rule>> instanceMap = Rule.getInstanceMap(this.nameType, RuleType.RULES, languageSet);
        Map<String, List<Rule>> instanceMap2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
        Map<String, List<Rule>> instanceMap3 = Rule.getInstanceMap(this.nameType, this.ruleType, languageSet);
        String strTrim = str.toLowerCase(Locale.ENGLISH).replace(Soundex.SILENT_MARKER, ' ').trim();
        if (this.nameType == NameType.GENERIC) {
            if (strTrim.startsWith("d'")) {
                String strSubstring = strTrim.substring(2);
                return "(" + encode(strSubstring) + ")-(" + encode("d" + strSubstring) + ")";
            }
            for (String str2 : NAME_PREFIXES.get(this.nameType)) {
                if (strTrim.startsWith(str2 + " ")) {
                    String strSubstring2 = strTrim.substring(str2.length() + 1);
                    return "(" + encode(strSubstring2) + ")-(" + encode(str2 + strSubstring2) + ")";
                }
            }
        }
        List listAsList = Arrays.asList(ResourceConstants.SPACES.split(strTrim));
        final ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$codec$language$bm$NameType[this.nameType.ordinal()];
        if (i == 1) {
            listAsList.forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList.add(PhoneticEngine.QUOTE.split((String) obj, -1)[r1.length - 1]);
                }
            });
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i == 2) {
            arrayList.addAll(listAsList);
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else {
            if (i != 3) {
                throw new IllegalStateException("Unreachable case: " + this.nameType);
            }
            arrayList.addAll(listAsList);
        }
        if (this.concat) {
            strTrim = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            strTrim = (String) listAsList.iterator().next();
        } else if (!arrayList.isEmpty()) {
            final StringBuilder sb = new StringBuilder();
            arrayList.forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m13234xb393c13f(sb, (String) obj);
                }
            });
            return sb.substring(1);
        }
        String str3 = strTrim;
        PhonemeBuilder phonemeBuilderEmpty = PhonemeBuilder.empty(languageSet);
        int i2 = 0;
        while (i2 < str3.length()) {
            RulesApplication rulesApplicationInvoke = new RulesApplication(instanceMap, str3, phonemeBuilderEmpty, i2, this.maxPhonemes).invoke();
            i2 = rulesApplicationInvoke.getI();
            phonemeBuilderEmpty = rulesApplicationInvoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(phonemeBuilderEmpty, instanceMap2), instanceMap3).makeString();
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }

    /* JADX INFO: renamed from: lambda$applyFinalRules$1$org-apache-commons-codec-language-bm-PhoneticEngine, reason: not valid java name */
    /* synthetic */ void m13233xf7464fbc(Map map, final Map map2, Rule.Phoneme phoneme) {
        PhonemeBuilder phonemeBuilderEmpty = PhonemeBuilder.empty(phoneme.getLanguages());
        CharSequence phonemeText = phoneme.getPhonemeText();
        int i = 0;
        PhonemeBuilder phonemeBuilder = phonemeBuilderEmpty;
        while (i < phonemeText.length()) {
            Map map3 = map;
            RulesApplication rulesApplicationInvoke = new RulesApplication(map3, phonemeText, phonemeBuilder, i, this.maxPhonemes).invoke();
            boolean zIsFound = rulesApplicationInvoke.isFound();
            phonemeBuilder = rulesApplicationInvoke.getPhonemeBuilder();
            if (!zIsFound) {
                phonemeBuilder.append(phonemeText.subSequence(i, i + 1));
            }
            i = rulesApplicationInvoke.getI();
            map = map3;
        }
        phonemeBuilder.getPhonemes().forEach(new Consumer() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PhoneticEngine.lambda$applyFinalRules$0(map2, (Rule.Phoneme) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$encode$3$org-apache-commons-codec-language-bm-PhoneticEngine, reason: not valid java name */
    /* synthetic */ void m13234xb393c13f(StringBuilder sb, String str) {
        sb.append("-").append(encode(str));
    }
}
