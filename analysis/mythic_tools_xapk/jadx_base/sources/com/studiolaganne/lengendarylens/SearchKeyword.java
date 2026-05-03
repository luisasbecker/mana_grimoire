package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.window.reflection.WindowExtensionsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0081\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchKeyword;", "", "keyword", "", "shortForm", "shortFormAlt", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "getShortForm", "getShortFormAlt", "NAME", "MANA_COST", "MANA_VALUE", "COLOR", "IDENTITY", CredentialProviderBaseController.TYPE_TAG, "ORACLE_TEXT", "SET", "RARITY", "POWER", "TOUGHNESS", "LOYALTY", "DEFENSE", "NUMBER", "OTAG", "IS", "GAME", "LEGAL", "BANNED", "RESTRICTED", "LAYOUT", "PRICE", "LANGUAGE", "KEYWORD", "ALTERED", "MISPRINT", "SIGNED", "PROXY", "IN_DECK", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchKeyword {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchKeyword[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String keyword;
    private final String shortForm;
    private final String shortFormAlt;
    public static final SearchKeyword NAME = new SearchKeyword("NAME", 0, "name", "n", "n");
    public static final SearchKeyword MANA_COST = new SearchKeyword("MANA_COST", 1, "mana", "m", "m");
    public static final SearchKeyword MANA_VALUE = new SearchKeyword("MANA_VALUE", 2, "manavalue", "mv", "cmc");
    public static final SearchKeyword COLOR = new SearchKeyword("COLOR", 3, "color", "c", "c");
    public static final SearchKeyword IDENTITY = new SearchKeyword("IDENTITY", 4, "identity", "id", "ci");
    public static final SearchKeyword TYPE = new SearchKeyword(CredentialProviderBaseController.TYPE_TAG, 5, "type", "t", "t");
    public static final SearchKeyword ORACLE_TEXT = new SearchKeyword("ORACLE_TEXT", 6, "oracle", "o", "o");
    public static final SearchKeyword SET = new SearchKeyword("SET", 7, "set", "s", "s");
    public static final SearchKeyword RARITY = new SearchKeyword("RARITY", 8, "rarity", "r", "r");
    public static final SearchKeyword POWER = new SearchKeyword("POWER", 9, "power", "pow", "pow");
    public static final SearchKeyword TOUGHNESS = new SearchKeyword("TOUGHNESS", 10, "toughness", "tou", "tou");
    public static final SearchKeyword LOYALTY = new SearchKeyword("LOYALTY", 11, "loyalty", "loy", "loy");
    public static final SearchKeyword DEFENSE = new SearchKeyword("DEFENSE", 12, "defense", "def", "def");
    public static final SearchKeyword NUMBER = new SearchKeyword("NUMBER", 13, "number", "cn", "cn");
    public static final SearchKeyword OTAG = new SearchKeyword("OTAG", 14, "oracletag", "otag", "function");
    public static final SearchKeyword IS = new SearchKeyword("IS", 15, "is", "is", "is");
    public static final SearchKeyword GAME = new SearchKeyword("GAME", 16, "game", "game", "game");
    public static final SearchKeyword LEGAL = new SearchKeyword("LEGAL", 17, "legal", "legal", "legal");
    public static final SearchKeyword BANNED = new SearchKeyword("BANNED", 18, "banned", "banned", "banned");
    public static final SearchKeyword RESTRICTED = new SearchKeyword("RESTRICTED", 19, "restricted", "restricted", "restricted");
    public static final SearchKeyword LAYOUT = new SearchKeyword("LAYOUT", 20, WindowExtensionsConstants.LAYOUT_PACKAGE, "l", "l");
    public static final SearchKeyword PRICE = new SearchKeyword("PRICE", 21, FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.PRICE);
    public static final SearchKeyword LANGUAGE = new SearchKeyword("LANGUAGE", 22, "language", "lang", "lang");
    public static final SearchKeyword KEYWORD = new SearchKeyword("KEYWORD", 23, "keyword", "keyword", "kw");
    public static final SearchKeyword ALTERED = new SearchKeyword("ALTERED", 24, "altered", "altered", "altered");
    public static final SearchKeyword MISPRINT = new SearchKeyword("MISPRINT", 25, "misprint", "misprint", "missprint");
    public static final SearchKeyword SIGNED = new SearchKeyword("SIGNED", 26, "signed", "signed", "signed");
    public static final SearchKeyword PROXY = new SearchKeyword("PROXY", 27, "proxy", "proxy", "proxy");
    public static final SearchKeyword IN_DECK = new SearchKeyword("IN_DECK", 28, "in_deck", "in_deck", "indeck");

    /* JADX INFO: compiled from: SearchData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchKeyword$Companion;", "", "<init>", "()V", "fromString", "Lcom/studiolaganne/lengendarylens/SearchKeyword;", "value", "", "keywordDisplayName", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: SearchData.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SearchKeyword.values().length];
                try {
                    iArr[SearchKeyword.NAME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SearchKeyword.COLOR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SearchKeyword.MANA_COST.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SearchKeyword.MANA_VALUE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SearchKeyword.IDENTITY.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[SearchKeyword.TYPE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[SearchKeyword.ORACLE_TEXT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[SearchKeyword.SET.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[SearchKeyword.RARITY.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[SearchKeyword.POWER.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[SearchKeyword.TOUGHNESS.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[SearchKeyword.LOYALTY.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[SearchKeyword.DEFENSE.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[SearchKeyword.NUMBER.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[SearchKeyword.LAYOUT.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[SearchKeyword.KEYWORD.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[SearchKeyword.OTAG.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[SearchKeyword.IS.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr[SearchKeyword.GAME.ordinal()] = 19;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr[SearchKeyword.BANNED.ordinal()] = 20;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr[SearchKeyword.LEGAL.ordinal()] = 21;
                } catch (NoSuchFieldError unused21) {
                }
                try {
                    iArr[SearchKeyword.RESTRICTED.ordinal()] = 22;
                } catch (NoSuchFieldError unused22) {
                }
                try {
                    iArr[SearchKeyword.PRICE.ordinal()] = 23;
                } catch (NoSuchFieldError unused23) {
                }
                try {
                    iArr[SearchKeyword.LANGUAGE.ordinal()] = 24;
                } catch (NoSuchFieldError unused24) {
                }
                try {
                    iArr[SearchKeyword.ALTERED.ordinal()] = 25;
                } catch (NoSuchFieldError unused25) {
                }
                try {
                    iArr[SearchKeyword.MISPRINT.ordinal()] = 26;
                } catch (NoSuchFieldError unused26) {
                }
                try {
                    iArr[SearchKeyword.SIGNED.ordinal()] = 27;
                } catch (NoSuchFieldError unused27) {
                }
                try {
                    iArr[SearchKeyword.PROXY.ordinal()] = 28;
                } catch (NoSuchFieldError unused28) {
                }
                try {
                    iArr[SearchKeyword.IN_DECK.ordinal()] = 29;
                } catch (NoSuchFieldError unused29) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchKeyword fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (SearchKeyword searchKeyword : SearchKeyword.values()) {
                if (Intrinsics.areEqual(searchKeyword.getKeyword(), value) || Intrinsics.areEqual(searchKeyword.getShortForm(), value) || Intrinsics.areEqual(searchKeyword.getShortFormAlt(), value)) {
                    return searchKeyword;
                }
            }
            return null;
        }

        public final String keywordDisplayName(SearchKeyword value, Context context) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(context, "context");
            switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                case 1:
                    String string = context.getResources().getString(R.string.filter_name);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                case 2:
                    String string2 = context.getResources().getString(R.string.filter_color);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                case 3:
                    String string3 = context.getResources().getString(R.string.filter_mana);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return string3;
                case 4:
                    String string4 = context.getResources().getString(R.string.filter_manavalue);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    return string4;
                case 5:
                    String string5 = context.getResources().getString(R.string.filter_identity);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                case 6:
                    String string6 = context.getResources().getString(R.string.filter_type);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                case 7:
                    String string7 = context.getResources().getString(R.string.filter_oracle);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                case 8:
                    String string8 = context.getResources().getString(R.string.filter_set);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return string8;
                case 9:
                    String string9 = context.getResources().getString(R.string.filter_rarity);
                    Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                    return string9;
                case 10:
                    String string10 = context.getResources().getString(R.string.filter_power);
                    Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                    return string10;
                case 11:
                    String string11 = context.getResources().getString(R.string.filter_toughness);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return string11;
                case 12:
                    String string12 = context.getResources().getString(R.string.filter_loyalty);
                    Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                    return string12;
                case 13:
                    String string13 = context.getResources().getString(R.string.filter_defense);
                    Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                    return string13;
                case 14:
                    String string14 = context.getResources().getString(R.string.filter_number);
                    Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                    return string14;
                case 15:
                    String string15 = context.getResources().getString(R.string.filter_layout);
                    Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                    return string15;
                case 16:
                    String string16 = context.getResources().getString(R.string.filter_keyword);
                    Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                    return string16;
                case 17:
                    String string17 = context.getResources().getString(R.string.filter_otag);
                    Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                    return string17;
                case 18:
                    String string18 = context.getResources().getString(R.string.filter_is);
                    Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                    return string18;
                case 19:
                    String string19 = context.getResources().getString(R.string.filter_game);
                    Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                    return string19;
                case 20:
                    String string20 = context.getResources().getString(R.string.filter_banned);
                    Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
                    return string20;
                case 21:
                    String string21 = context.getResources().getString(R.string.filter_legal);
                    Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
                    return string21;
                case 22:
                    String string22 = context.getResources().getString(R.string.filter_restricted);
                    Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                    return string22;
                case 23:
                    String string23 = context.getResources().getString(R.string.filter_price);
                    Intrinsics.checkNotNullExpressionValue(string23, "getString(...)");
                    return string23;
                case 24:
                    String string24 = context.getResources().getString(R.string.filter_language);
                    Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
                    return string24;
                case 25:
                    String string25 = context.getResources().getString(R.string.filter_altered);
                    Intrinsics.checkNotNullExpressionValue(string25, "getString(...)");
                    return string25;
                case 26:
                    String string26 = context.getResources().getString(R.string.filter_misprint);
                    Intrinsics.checkNotNullExpressionValue(string26, "getString(...)");
                    return string26;
                case 27:
                    String string27 = context.getResources().getString(R.string.filter_signed);
                    Intrinsics.checkNotNullExpressionValue(string27, "getString(...)");
                    return string27;
                case 28:
                    String string28 = context.getResources().getString(R.string.filter_proxy);
                    Intrinsics.checkNotNullExpressionValue(string28, "getString(...)");
                    return string28;
                case 29:
                    String string29 = context.getResources().getString(R.string.filter_in_deck);
                    Intrinsics.checkNotNullExpressionValue(string29, "getString(...)");
                    return string29;
                default:
                    return "";
            }
        }
    }

    private static final /* synthetic */ SearchKeyword[] $values() {
        return new SearchKeyword[]{NAME, MANA_COST, MANA_VALUE, COLOR, IDENTITY, TYPE, ORACLE_TEXT, SET, RARITY, POWER, TOUGHNESS, LOYALTY, DEFENSE, NUMBER, OTAG, IS, GAME, LEGAL, BANNED, RESTRICTED, LAYOUT, PRICE, LANGUAGE, KEYWORD, ALTERED, MISPRINT, SIGNED, PROXY, IN_DECK};
    }

    static {
        SearchKeyword[] searchKeywordArr$values = $values();
        $VALUES = searchKeywordArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(searchKeywordArr$values);
        INSTANCE = new Companion(null);
    }

    private SearchKeyword(String str, int i, String str2, String str3, String str4) {
        this.keyword = str2;
        this.shortForm = str3;
        this.shortFormAlt = str4;
    }

    public static EnumEntries<SearchKeyword> getEntries() {
        return $ENTRIES;
    }

    public static SearchKeyword valueOf(String str) {
        return (SearchKeyword) Enum.valueOf(SearchKeyword.class, str);
    }

    public static SearchKeyword[] values() {
        return (SearchKeyword[]) $VALUES.clone();
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final String getShortForm() {
        return this.shortForm;
    }

    public final String getShortFormAlt() {
        return this.shortFormAlt;
    }
}
