package com.studiolaganne.lengendarylens;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.common.Constants;
import com.vanniktech.ui.ColorKt;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckListTxtParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\f\u001a\u00020\u0007J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListTxtParser;", "", "<init>", "()V", "parseLine", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "line", "", "currentSection", "Lcom/studiolaganne/lengendarylens/CardSection;", "parseText", "Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "text", "parseInputStream", "inputStream", "Ljava/io/InputStream;", "parseTextLegacy", "", "parseInputStreamLegacy", "isSectionHeader", "", "detectSectionHeader", "determineSectionFromBrackets", "bracketTags", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckListTxtParser {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex CARD_PATTERN_PARENS = new Regex("^(\\d+)(?:x)?\\s+(.+?)(?:\\s+\\(([A-Za-z0-9]+)\\)(?:\\s+(\\S+))?)?(?:\\s+([*FE]+|[FE][*]*|[*]*[FE]))?(?:\\s+\\[([^\\]]+)\\])?\\s*$", RegexOption.IGNORE_CASE);
    private static final Regex CARD_PATTERN_BRACKETS = new Regex("^(\\d+)(?:x)?\\s+(.+?)\\s+\\[([A-Za-z0-9]+)\\]\\s+(\\S+)(?:\\s+([*FE]+|[FE][*]*|[*]*[FE]))?\\s*$", RegexOption.IGNORE_CASE);
    private static final Map<String, String> SET_CODE_REMAPS = MapsKt.mapOf(TuplesKt.to("LIST", "PLST"));
    private static final Map<String, CardSection> SECTION_HEADERS = MapsKt.mapOf(TuplesKt.to("commander", CardSection.MAIN_DECK), TuplesKt.to("mainboard", CardSection.MAIN_DECK), TuplesKt.to("main", CardSection.MAIN_DECK), TuplesKt.to("sideboard", CardSection.SIDEBOARD), TuplesKt.to("maybeboard", CardSection.MAYBEBOARD), TuplesKt.to("maybe", CardSection.MAYBEBOARD));

    /* JADX INFO: compiled from: DeckListTxtParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListTxtParser$Companion;", "", "<init>", "()V", "CARD_PATTERN_PARENS", "Lkotlin/text/Regex;", "CARD_PATTERN_BRACKETS", "SET_CODE_REMAPS", "", "", "SECTION_HEADERS", "Lcom/studiolaganne/lengendarylens/CardSection;", "remapSetCode", "setCode", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String remapSetCode(String setCode) {
            if (setCode == null) {
                return null;
            }
            String upperCase = setCode.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String str = (String) DeckListTxtParser.SET_CODE_REMAPS.get(upperCase);
            return str == null ? upperCase : str;
        }
    }

    /* JADX INFO: compiled from: DeckListTxtParser.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardSection.values().length];
            try {
                iArr[CardSection.MAIN_DECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardSection.SIDEBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardSection.MAYBEBOARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final CardSection detectSectionHeader(String line) {
        String lowerCase = line.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return SECTION_HEADERS.get(StringsKt.removeSuffix(StringsKt.trim((CharSequence) lowerCase).toString(), (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
    }

    private final CardSection determineSectionFromBrackets(String bracketTags) {
        String str = bracketTags;
        if (str != null && !StringsKt.isBlank(str)) {
            String lowerCase = bracketTags.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str2 = lowerCase;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "maybeboard", false, 2, (Object) null)) {
                return CardSection.MAYBEBOARD;
            }
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "sideboard", false, 2, (Object) null)) {
                return CardSection.SIDEBOARD;
            }
        }
        return null;
    }

    private final boolean isSectionHeader(String line) {
        return detectSectionHeader(line) != null;
    }

    public static /* synthetic */ ParsedCard parseLine$default(DeckListTxtParser deckListTxtParser, String str, CardSection cardSection, int i, Object obj) {
        if ((i & 2) != 0) {
            cardSection = CardSection.MAIN_DECK;
        }
        return deckListTxtParser.parseLine(str, cardSection);
    }

    public final ParsedDeckList parseInputStream(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return parseText(text);
        } finally {
        }
    }

    public final List<ParsedCard> parseInputStreamLegacy(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return parseInputStream(inputStream).getMainDeckCards();
    }

    public final ParsedCard parseLine(String line, CardSection currentSection) {
        Intrinsics.checkNotNullParameter(line, "line");
        Intrinsics.checkNotNullParameter(currentSection, "currentSection");
        String string = StringsKt.trim((CharSequence) line).toString();
        String str = string;
        String str2 = null;
        if (str.length() != 0) {
            if (StringsKt.startsWith$default(string, ColorKt.HEX_PREFIX, false, 2, (Object) null) || StringsKt.startsWith$default(string, "//", false, 2, (Object) null) || isSectionHeader(string)) {
                return null;
            }
            kotlin.text.MatchResult matchResultFind$default = Regex.find$default(CARD_PATTERN_BRACKETS, str, 0, 2, null);
            if (matchResultFind$default != null) {
                List<String> groupValues = matchResultFind$default.getGroupValues();
                Integer intOrNull = StringsKt.toIntOrNull(groupValues.get(1));
                if (intOrNull != null) {
                    int iIntValue = intOrNull.intValue();
                    String string2 = StringsKt.trim((CharSequence) groupValues.get(2)).toString();
                    Companion companion = INSTANCE;
                    String str3 = groupValues.get(3);
                    if (!Boolean.valueOf(str3.length() > 0).booleanValue()) {
                        str3 = null;
                    }
                    String strRemapSetCode = companion.remapSetCode(str3);
                    String str4 = groupValues.get(4);
                    if (str4.length() <= 0) {
                        str4 = null;
                    }
                    String str5 = str4;
                    String str6 = groupValues.get(5);
                    if (str6.length() <= 0) {
                        str6 = null;
                    }
                    String str7 = str6;
                    if (str7 != null) {
                        String str8 = str7;
                        if (StringsKt.contains((CharSequence) str8, (CharSequence) ExifInterface.LONGITUDE_EAST, true)) {
                            str2 = "etched";
                        } else if (StringsKt.contains((CharSequence) str8, (CharSequence) "F", true)) {
                            str2 = "foil";
                        }
                    }
                    return new ParsedCard(iIntValue, string2, strRemapSetCode, str5, str2, null, currentSection, 32, null);
                }
            }
            kotlin.text.MatchResult matchResultFind$default2 = Regex.find$default(CARD_PATTERN_PARENS, str, 0, 2, null);
            if (matchResultFind$default2 == null) {
                return null;
            }
            List<String> groupValues2 = matchResultFind$default2.getGroupValues();
            Integer intOrNull2 = StringsKt.toIntOrNull(groupValues2.get(1));
            if (intOrNull2 != null) {
                int iIntValue2 = intOrNull2.intValue();
                String string3 = StringsKt.trim((CharSequence) groupValues2.get(2)).toString();
                Companion companion2 = INSTANCE;
                String str9 = groupValues2.get(3);
                if (str9.length() <= 0) {
                    str9 = null;
                }
                String strRemapSetCode2 = companion2.remapSetCode(str9);
                String str10 = groupValues2.get(4);
                if (str10.length() <= 0) {
                    str10 = null;
                }
                String str11 = str10;
                String str12 = groupValues2.get(5);
                if (str12.length() <= 0) {
                    str12 = null;
                }
                String str13 = str12;
                String str14 = groupValues2.get(6);
                if (str14.length() <= 0) {
                    str14 = null;
                }
                String str15 = str14;
                if (str13 != null) {
                    String str16 = str13;
                    if (StringsKt.contains((CharSequence) str16, (CharSequence) ExifInterface.LONGITUDE_EAST, true)) {
                        str2 = "etched";
                    } else if (StringsKt.contains((CharSequence) str16, (CharSequence) "F", true)) {
                        str2 = "foil";
                    }
                }
                String str17 = str2;
                CardSection cardSectionDetermineSectionFromBrackets = determineSectionFromBrackets(str15);
                return new ParsedCard(iIntValue2, string3, strRemapSetCode2, str11, str17, null, cardSectionDetermineSectionFromBrackets == null ? currentSection : cardSectionDetermineSectionFromBrackets, 32, null);
            }
        }
        return null;
    }

    public final ParsedDeckList parseText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        CardSection cardSection = CardSection.MAIN_DECK;
        for (String str : StringsKt.lines(text)) {
            String string = StringsKt.trim((CharSequence) str).toString();
            if (string.length() != 0) {
                CardSection cardSectionDetectSectionHeader = detectSectionHeader(string);
                if (cardSectionDetectSectionHeader != null) {
                    cardSection = cardSectionDetectSectionHeader;
                } else {
                    ParsedCard line = parseLine(str, cardSection);
                    if (line != null) {
                        int i = WhenMappings.$EnumSwitchMapping$0[line.getSection().ordinal()];
                        if (i == 1) {
                            arrayList.add(line);
                        } else if (i == 2) {
                            arrayList2.add(line);
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            arrayList3.add(line);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return new ParsedDeckList(arrayList, arrayList2, arrayList3);
    }

    public final List<ParsedCard> parseTextLegacy(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return parseText(text).getMainDeckCards();
    }
}
