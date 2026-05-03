package com.studiolaganne.lengendarylens;

import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.net.HttpHeaders;
import com.google.mlkit.vision.objects.defaults.PredefinedCategory;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"J\"\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"H\u0002¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchDataUtils;", "", "<init>", "()V", "getKeywords", "", "", "processKeyword", "keyword", "lang", "getLayoutTypes", "", "transformLayout", "theValue", "transformRarity", "translateTag", ViewHierarchyConstants.TAG_KEY, "transformTypeLineShortcut", "standardizeManaCost", "input", "getOtherColors", "colors", "mapColorValueToIndividualColors", "value", "parseSearchQuery", "Lcom/studiolaganne/lengendarylens/SearchElement;", SearchIntents.EXTRA_QUERY, "tokenize", "parseCondition", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "token", "searchElementToSql", "element", "folding", "", "conditionToSql", "condition", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchDataUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SearchDataUtils instance;

    /* JADX INFO: compiled from: SearchData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchDataUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/SearchDataUtils;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized SearchDataUtils getInstance() {
            SearchDataUtils searchDataUtils;
            if (SearchDataUtils.instance == null) {
                SearchDataUtils.instance = new SearchDataUtils(null);
            }
            searchDataUtils = SearchDataUtils.instance;
            Intrinsics.checkNotNull(searchDataUtils);
            return searchDataUtils;
        }
    }

    /* JADX INFO: compiled from: SearchData.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Operator.values().length];
            try {
                iArr[Operator.CONTAINS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Operator.NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Operator.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Operator.LESS_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Operator.LESS_THAN_OR_EQUAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SearchKeyword.values().length];
            try {
                iArr2[SearchKeyword.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SearchKeyword.ORACLE_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SearchKeyword.TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SearchKeyword.MANA_COST.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SearchKeyword.RARITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SearchKeyword.COLOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SearchKeyword.IDENTITY.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[SearchKeyword.OTAG.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[SearchKeyword.GAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[SearchKeyword.BANNED.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SearchKeyword.RESTRICTED.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[SearchKeyword.LEGAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[SearchKeyword.PRICE.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[SearchKeyword.LANGUAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[SearchKeyword.IS.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[SearchKeyword.ALTERED.ordinal()] = 16;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[SearchKeyword.MISPRINT.ordinal()] = 17;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[SearchKeyword.SIGNED.ordinal()] = 18;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[SearchKeyword.PROXY.ordinal()] = 19;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private SearchDataUtils() {
    }

    public /* synthetic */ SearchDataUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String conditionToSql(SearchCondition condition, String lang, boolean folding) throws IOException {
        final String str;
        String str2;
        int i = 0;
        String str3 = "(";
        int i2 = 1;
        switch (WhenMappings.$EnumSwitchMapping$1[condition.getKeyword().ordinal()]) {
            case 1:
                if (!folding) {
                    return "title:" + condition.getValue();
                }
                String value = condition.getValue();
                Locale localeForLanguageTag = Locale.forLanguageTag(lang);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                return "folded_title:" + UtilsKt.removeDiacritics(value, localeForLanguageTag);
            case 2:
                return "oracle_text:" + condition.getValue();
            case 3:
                return "type_line:" + transformTypeLineShortcut(condition.getValue(), lang);
            case 4:
                str = condition.getInclude() ? "" : "NOT ";
                String strStandardizeManaCost = standardizeManaCost(condition.getValue());
                int i3 = WhenMappings.$EnumSwitchMapping$0[condition.getOperator().ordinal()];
                String str4 = i3 != 1 ? i3 != 2 ? "'" + strStandardizeManaCost + "'" : strStandardizeManaCost : "'%" + strStandardizeManaCost + "%'";
                int i4 = WhenMappings.$EnumSwitchMapping$0[condition.getOperator().ordinal()];
                if (i4 == 1) {
                    return str + "mana_cost LIKE " + str4;
                }
                if (i4 == 2) {
                    return str + "mana_cost NOT LIKE '%" + str4 + "%'";
                }
                if (i4 == 3) {
                    return str + "mana_cost = " + str4;
                }
                if (i4 == 4) {
                    String str5 = strStandardizeManaCost;
                    if (!new Regex("\\{\\d+\\}").containsMatchIn(str5)) {
                        return str + "(mana_cost LIKE '%" + strStandardizeManaCost + "%' AND mana_cost != '" + strStandardizeManaCost + "')";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = str5.length();
                    while (i < length) {
                        char cCharAt = str5.charAt(i);
                        if (Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        }
                        i++;
                    }
                    int i5 = Integer.parseInt(sb.toString());
                    while (i2 < 10) {
                        str3 = str3 + "mana_cost LIKE '%" + StringsKt.replace$default(strStandardizeManaCost, String.valueOf(i5), String.valueOf(i5 + i2), false, 4, (Object) null) + "%' OR ";
                        i2++;
                    }
                    return str + (str3 + str + "(mana_cost LIKE '%" + strStandardizeManaCost + "%' AND mana_cost != '" + strStandardizeManaCost + "'))");
                }
                if (i4 != 5) {
                    return str + "mana_cost LIKE " + str4;
                }
                String str6 = strStandardizeManaCost;
                if (!new Regex("\\{\\d+\\}").containsMatchIn(str6)) {
                    return str + "(mana_cost LIKE '%" + strStandardizeManaCost + "%')";
                }
                StringBuilder sb2 = new StringBuilder();
                int length2 = str6.length();
                while (i < length2) {
                    char cCharAt2 = str6.charAt(i);
                    if (Character.isDigit(cCharAt2)) {
                        sb2.append(cCharAt2);
                    }
                    i++;
                }
                int i6 = Integer.parseInt(sb2.toString());
                while (i2 < 10) {
                    str3 = str3 + "mana_cost LIKE '%" + StringsKt.replace$default(strStandardizeManaCost, String.valueOf(i6), String.valueOf(i6 + i2), false, 4, (Object) null) + "%' OR ";
                    i2++;
                }
                return str + (str3 + str + "mana_cost LIKE '%" + strStandardizeManaCost + "%')");
            case 5:
                str = condition.getInclude() ? "" : "NOT ";
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("rare", "r"), TuplesKt.to("mythic", "m"), TuplesKt.to("uncommon", "u"), TuplesKt.to("common", "c"), TuplesKt.to("special", "s"), TuplesKt.to("bonus", "b"), TuplesKt.to("spécial", "s"), TuplesKt.to("mythique", "m"), TuplesKt.to("unco", "u"), TuplesKt.to("commune", "c"));
                String lowerCase = condition.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = (String) mapMapOf.get(lowerCase);
                if (lowerCase2 == null) {
                    lowerCase2 = condition.getValue().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                }
                switch (WhenMappings.$EnumSwitchMapping$0[condition.getOperator().ordinal()]) {
                    case 1:
                        return str + "rarity = '" + lowerCase2 + "'";
                    case 2:
                        return str + "rarity != '" + lowerCase2 + "'";
                    case 3:
                        return str + "rarity = '" + lowerCase2 + "'";
                    case 4:
                        int iHashCode = lowerCase2.hashCode();
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 109) {
                                    if (iHashCode != 117) {
                                        if (iHashCode != 114) {
                                            if (iHashCode == 115 && lowerCase2.equals("s")) {
                                                return str.concat("rarity = 'null'");
                                            }
                                        } else if (lowerCase2.equals("r")) {
                                            return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's')");
                                        }
                                    } else if (lowerCase2.equals("u")) {
                                        return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's' OR rarity = 'r')");
                                    }
                                } else if (lowerCase2.equals("m")) {
                                    return str.concat("(rarity = 'b' OR rarity = 's')");
                                }
                            } else if (lowerCase2.equals("c")) {
                                return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's' OR rarity = 'r' OR rarity = 'u')");
                            }
                        } else if (lowerCase2.equals("b")) {
                            return str.concat("rarity = 'null'");
                        }
                        return str.concat("rarity = ''");
                    case 5:
                        int iHashCode2 = lowerCase2.hashCode();
                        if (iHashCode2 != 98) {
                            if (iHashCode2 != 99) {
                                if (iHashCode2 != 109) {
                                    if (iHashCode2 != 117) {
                                        if (iHashCode2 != 114) {
                                            if (iHashCode2 == 115 && lowerCase2.equals("s")) {
                                                return str.concat("rarity = 's'");
                                            }
                                        } else if (lowerCase2.equals("r")) {
                                            return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's' OR rarity = 'r')");
                                        }
                                    } else if (lowerCase2.equals("u")) {
                                        return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's' OR rarity = 'r' OR rarity = 'u')");
                                    }
                                } else if (lowerCase2.equals("m")) {
                                    return str.concat("(rarity = 'm' OR rarity = 'b' OR rarity = 's')");
                                }
                            } else if (lowerCase2.equals("c")) {
                                return str.concat("rarity != ''");
                            }
                        } else if (lowerCase2.equals("b")) {
                            return str.concat("rarity = 'b'");
                        }
                        return str.concat("rarity = ''");
                    case 6:
                        int iHashCode3 = lowerCase2.hashCode();
                        if (iHashCode3 != 98) {
                            if (iHashCode3 != 109) {
                                if (iHashCode3 != 117) {
                                    if (iHashCode3 != 114) {
                                        if (iHashCode3 == 115 && lowerCase2.equals("s")) {
                                            return str.concat("rarity != 's'");
                                        }
                                    } else if (lowerCase2.equals("r")) {
                                        return str.concat("(rarity = 'u' OR rarity = 'c')");
                                    }
                                } else if (lowerCase2.equals("u")) {
                                    return str.concat("rarity = 'c'");
                                }
                            } else if (lowerCase2.equals("m")) {
                                return str.concat("(rarity = 'r' OR rarity = 'u' OR rarity = 'c')");
                            }
                        } else if (lowerCase2.equals("b")) {
                            return str.concat("rarity != 'b'");
                        }
                        return str.concat("rarity = ''");
                    case 7:
                        int iHashCode4 = lowerCase2.hashCode();
                        if (iHashCode4 != 98) {
                            if (iHashCode4 != 99) {
                                if (iHashCode4 != 109) {
                                    if (iHashCode4 != 117) {
                                        if (iHashCode4 != 114) {
                                            if (iHashCode4 == 115 && lowerCase2.equals("s")) {
                                                return str.concat("rarity != ''");
                                            }
                                        } else if (lowerCase2.equals("r")) {
                                            return str.concat("(rarity = 'r' OR rarity = 'u' OR rarity = 'c')");
                                        }
                                    } else if (lowerCase2.equals("u")) {
                                        return str.concat("(rarity = 'u' OR rarity = 'c')");
                                    }
                                } else if (lowerCase2.equals("m")) {
                                    return str.concat("(rarity = 'm' OR rarity = 'r' OR rarity = 'u' OR rarity = 'c')");
                                }
                            } else if (lowerCase2.equals("c")) {
                                return str.concat("rarity = 'c'");
                            }
                        } else if (lowerCase2.equals("b")) {
                            return str.concat("rarity != ''");
                        }
                        return str.concat("rarity = ''");
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 6:
            case 7:
                str = condition.getInclude() ? "" : "NOT ";
                final String str7 = condition.getKeyword() == SearchKeyword.COLOR ? "colors" : "identity";
                Operator operator = condition.getOperator();
                if (condition.getKeyword() == SearchKeyword.IDENTITY && operator == Operator.CONTAINS) {
                    operator = Operator.LESS_THAN_OR_EQUAL;
                }
                List<String> listMapColorValueToIndividualColors = mapColorValueToIndividualColors(condition.getValue());
                switch (WhenMappings.$EnumSwitchMapping$0[operator.ordinal()]) {
                    case 1:
                        return listMapColorValueToIndividualColors.contains("M") ? str + "(" + str7 + " != '' AND " + str7 + " LIKE '%|%')" : listMapColorValueToIndividualColors.isEmpty() ? str + str7 + " = ''" : CollectionsKt.joinToString$default(listMapColorValueToIndividualColors, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchDataUtils.conditionToSql$lambda$2(str, str7, (String) obj);
                            }
                        }, 30, null);
                    case 2:
                        return CollectionsKt.joinToString$default(listMapColorValueToIndividualColors, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchDataUtils.conditionToSql$lambda$6(str, str7, (String) obj);
                            }
                        }, 30, null);
                    case 3:
                        if (listMapColorValueToIndividualColors.isEmpty()) {
                            return str + str7 + " = ''";
                        }
                        if (listMapColorValueToIndividualColors.contains("M")) {
                            return str + "(" + str7 + " != '' AND " + str7 + " LIKE '%|%')";
                        }
                        if (listMapColorValueToIndividualColors.isEmpty()) {
                            return str + str7 + " = ''";
                        }
                        if (listMapColorValueToIndividualColors.size() <= 1) {
                            return str + str7 + " = '" + CollectionsKt.first((List) listMapColorValueToIndividualColors) + "'";
                        }
                        String strJoinToString$default = CollectionsKt.joinToString$default(listMapColorValueToIndividualColors, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchDataUtils.conditionToSql$lambda$3(str, str7, (String) obj);
                            }
                        }, 30, null);
                        List listListOf = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", "R", GameUtils.CONDITION_GOOD});
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : listListOf) {
                            if (!listMapColorValueToIndividualColors.contains(((String) obj).toString())) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        return arrayList2.isEmpty() ? str + strJoinToString$default : str + "(" + strJoinToString$default + " AND " + CollectionsKt.joinToString$default(arrayList2, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return SearchDataUtils.conditionToSql$lambda$5(str, str7, (String) obj2);
                            }
                        }, 30, null) + ")";
                    case 4:
                        if (listMapColorValueToIndividualColors.isEmpty()) {
                            return str + str7 + " != ''";
                        }
                        if (listMapColorValueToIndividualColors.contains("M")) {
                            return str + str7 + " LIKE '%|%'";
                        }
                        String strJoinToString$default2 = CollectionsKt.joinToString$default(listMapColorValueToIndividualColors, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return SearchDataUtils.conditionToSql$lambda$10(str7, (String) obj2);
                            }
                        }, 30, null);
                        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", "R", GameUtils.CONDITION_GOOD});
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj2 : listListOf2) {
                            if (!listMapColorValueToIndividualColors.contains(((String) obj2).toString())) {
                                arrayList3.add(obj2);
                            }
                        }
                        return str + "((" + strJoinToString$default2 + ") AND (" + CollectionsKt.joinToString$default(arrayList3, " OR ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SearchDataUtils.conditionToSql$lambda$12(str7, (String) obj3);
                            }
                        }, 30, null) + "))";
                    case 5:
                        return listMapColorValueToIndividualColors.isEmpty() ? str + str7 + " != 'NULL'" : listMapColorValueToIndividualColors.contains("M") ? str + str7 + " LIKE '%|%'" : str + CollectionsKt.joinToString$default(listMapColorValueToIndividualColors, " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SearchDataUtils.conditionToSql$lambda$13(str7, (String) obj3);
                            }
                        }, 30, null);
                    case 6:
                        if (listMapColorValueToIndividualColors.isEmpty()) {
                            return str + str7 + " = ''";
                        }
                        if (listMapColorValueToIndividualColors.contains("M")) {
                            return str + str7 + " NOT LIKE '%|%'";
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(str7.concat(" = ''"));
                        if (listMapColorValueToIndividualColors.size() > 1) {
                            Iterator<T> it = listMapColorValueToIndividualColors.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(str7 + " LIKE '%" + ((String) it.next()) + "%' AND " + str7 + " NOT LIKE '%|%'");
                            }
                        }
                        return str + "(" + CollectionsKt.joinToString$default(arrayList4, " OR ", null, null, 0, null, null, 62, null) + ")";
                    case 7:
                        if (listMapColorValueToIndividualColors.isEmpty()) {
                            return str + str7 + " = ''";
                        }
                        if (listMapColorValueToIndividualColors.contains("M")) {
                            return str + str7 + " != 'NULL'";
                        }
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(str7.concat(" = ''"));
                        Iterator<T> it2 = listMapColorValueToIndividualColors.iterator();
                        while (it2.hasNext()) {
                            arrayList5.add(str7 + " = '" + ((String) it2.next()) + "'");
                        }
                        if (listMapColorValueToIndividualColors.size() > 1) {
                            arrayList5.add("(" + CollectionsKt.joinToString$default(getOtherColors(listMapColorValueToIndividualColors), " AND ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return SearchDataUtils.conditionToSql$lambda$9(str7, (String) obj3);
                                }
                            }, 30, null) + ")");
                        }
                        return str + "(" + CollectionsKt.joinToString$default(arrayList5, " OR ", null, null, 0, null, null, 62, null) + ")";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return "";
            default:
                String keyword = condition.getKeyword().getKeyword();
                if (Intrinsics.areEqual(keyword, "set")) {
                    keyword = "`set`";
                }
                if (Intrinsics.areEqual(keyword, "manavalue")) {
                    keyword = "cmc";
                }
                if (Intrinsics.areEqual(keyword, "keyword")) {
                    keyword = "keywords";
                }
                if (Intrinsics.areEqual(keyword, "mana")) {
                    keyword = "mana_cost";
                }
                if (Intrinsics.areEqual(keyword, "power")) {
                    keyword = "int_field_1";
                }
                if (Intrinsics.areEqual(keyword, "toughness")) {
                    keyword = "int_field_2";
                }
                if (Intrinsics.areEqual(keyword, "loyalty")) {
                    keyword = "int_field_1";
                }
                if (Intrinsics.areEqual(keyword, "defense")) {
                    keyword = "int_field_1";
                }
                String str8 = WhenMappings.$EnumSwitchMapping$0[condition.getOperator().ordinal()] == 1 ? "'%" + condition.getValue() + "%'" : "'" + condition.getValue() + "'";
                switch (WhenMappings.$EnumSwitchMapping$0[condition.getOperator().ordinal()]) {
                    case 1:
                        str2 = "LIKE";
                        break;
                    case 2:
                        str2 = "!=";
                        break;
                    case 3:
                        str2 = "=";
                        break;
                    case 4:
                        str2 = ">";
                        break;
                    case 5:
                        str2 = ">=";
                        break;
                    case 6:
                        str2 = "<";
                        break;
                    case 7:
                        str2 = "<=";
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return (condition.getInclude() ? "" : "NOT ") + keyword + " " + str2 + " " + str8;
        }
    }

    static /* synthetic */ String conditionToSql$default(SearchDataUtils searchDataUtils, SearchCondition searchCondition, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return searchDataUtils.conditionToSql(searchCondition, str, z);
    }

    static final CharSequence conditionToSql$lambda$10(String str, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + " LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$12(String str, String additionalColor) {
        Intrinsics.checkNotNullParameter(additionalColor, "additionalColor");
        return str + " LIKE '%" + additionalColor + "%'";
    }

    static final CharSequence conditionToSql$lambda$13(String str, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + " LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$2(String str, String str2, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + str2 + " LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$3(String str, String str2, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + str2 + " LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$5(String str, String str2, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + str2 + " NOT LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$6(String str, String str2, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + str2 + " NOT LIKE '%" + color + "%'";
    }

    static final CharSequence conditionToSql$lambda$9(String str, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return str + " NOT LIKE '%" + color + "%'";
    }

    private final SearchCondition parseCondition(String token) {
        String strSubstring;
        String value;
        boolean zStartsWith$default = StringsKt.startsWith$default(token, "-", false, 2, (Object) null);
        if (zStartsWith$default) {
            strSubstring = token.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = token;
        }
        String str = strSubstring;
        kotlin.text.MatchResult matchResultFind$default = Regex.find$default(new Regex("[:><=!]+"), str, 0, 2, null);
        if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
            value = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{value}, false, 2, 2, (Object) null);
        if (listSplit$default.size() == 2) {
            String string = StringsKt.trim((CharSequence) listSplit$default.get(0)).toString();
            String strRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString(), (CharSequence) "\"");
            SearchKeyword searchKeywordFromString = SearchKeyword.INSTANCE.fromString(string);
            if (searchKeywordFromString == null) {
                searchKeywordFromString = SearchKeyword.NAME;
            }
            SearchKeyword searchKeyword = searchKeywordFromString;
            Operator operatorFromString = Operator.INSTANCE.fromString(value);
            if (operatorFromString != null) {
                return new SearchCondition(!zStartsWith$default, searchKeyword, operatorFromString, strRemoveSurrounding, token);
            }
        }
        return new SearchCondition(true, SearchKeyword.NAME, Operator.CONTAINS, StringsKt.replace$default(token, "\"", "", false, 4, (Object) null), token);
    }

    public static /* synthetic */ String searchElementToSql$default(SearchDataUtils searchDataUtils, SearchElement searchElement, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return searchDataUtils.searchElementToSql(searchElement, str, z);
    }

    static final CharSequence searchElementToSql$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.replace$default(it, "'", "''", false, 4, (Object) null) + ProxyConfig.MATCH_ALL_SCHEMES;
    }

    static final String standardizeManaCost$lambda$0(kotlin.text.MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        String value = matchResult.getValue();
        String str = value;
        if (str.length() == 0) {
            return "";
        }
        if (StringsKt.startsWith$default(value, "{", false, 2, (Object) null)) {
            return value;
        }
        if (!Intrinsics.areEqual(value, "X")) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return "{" + value + "}";
                }
            }
        }
        return "{" + value + "}";
    }

    static final Comparable standardizeManaCost$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(Intrinsics.areEqual(StringsKt.trim(it, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ), "X") ? 0 : 1);
    }

    static final Comparable standardizeManaCost$lambda$3(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim(it, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ));
        return intOrNull != null ? intOrNull : (Comparable) 0;
    }

    private final List<String> tokenize(String query) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        String str = query;
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                boolean z2 = !z;
                if (z) {
                    sb.append(cCharAt);
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    arrayList.add(string);
                    StringsKt.clear(sb);
                } else {
                    sb.append(cCharAt);
                }
                z = z2;
            } else if (!CharsKt.isWhitespace(cCharAt) || z) {
                sb.append(cCharAt);
            } else {
                if (sb.length() > 0) {
                    String string2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    arrayList.add(string2);
                    StringsKt.clear(sb);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        if (sb.length() > 0) {
            String string3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            arrayList.add(string3);
        }
        return arrayList;
    }

    public final Map<String, String> getKeywords() {
        return MapsKt.mapOf(TuplesKt.to("A Thousand Souls Die Every Day", "Mille âmes meurent chaque jour"), TuplesKt.to("Aberrant Tinkering", "Bricolage aberrant"), TuplesKt.to("Adamant", "Inflexible"), TuplesKt.to("Adapt", "Adapter"), TuplesKt.to("Addendum", "Addenda"), TuplesKt.to("Advanced Species", "Espèce évoluée"), TuplesKt.to("Aegis of the Emperor", "Égide de l'Empereur"), TuplesKt.to("Affinity", "Affinité"), TuplesKt.to("Affirmative", "Affirmatif"), TuplesKt.to("Afflict", "Affliction"), TuplesKt.to("Afterlife", "Au-delà"), TuplesKt.to("Aftermath", "Répercussion"), TuplesKt.to("Alliance", "Alliance"), TuplesKt.to("Allons-y!", "Allons-y!"), TuplesKt.to("Allure of Slaanesh", "Appas de Slaanesh"), TuplesKt.to("Amass", "Amasser"), TuplesKt.to("Amplify", "Amplification"), TuplesKt.to("Animate Chains", "Chaînes animées"), TuplesKt.to("Annihilator", "Annihilateur"), TuplesKt.to("Arcane Life-support", "Système de survie arcanique"), TuplesKt.to("Architect of Deception", "Architecte de la tromperie"), TuplesKt.to("Armour of Shrieking Souls", "Armure des Âmes Hurlantes"), TuplesKt.to("Ascend", "Ascension"), TuplesKt.to("Assemble", "Assembler"), TuplesKt.to("Assist", "Assist"), TuplesKt.to("Atomic Transmutation", "Transmutation atomique"), TuplesKt.to("Augment", "Améliorer"), TuplesKt.to("Aura Swap", "Échange d'Aura"), TuplesKt.to("Avoidance", "Dérobade"), TuplesKt.to("Awaken", "Éveil"), TuplesKt.to("Backup", "Main-forte"), TuplesKt.to("Bad Wolf", "Grand méchant loup"), TuplesKt.to("Banding", "Regroupement"), TuplesKt.to("Bargain", "Négociation"), TuplesKt.to("Basic landcycling", "Recyclage de terrain de base"), TuplesKt.to("Battalion", "Bataillon"), TuplesKt.to("Battle Cannon", "Obusier"), TuplesKt.to("Battle Cry", "Cri de guerre"), TuplesKt.to("Bear Witness", "Témoignage"), TuplesKt.to("Benediction of the Omnissiah", "Bénédiction de l'Omnimessie"), TuplesKt.to("Berzerker", "Berzerker"), TuplesKt.to("Bestow", "Grâce"), TuplesKt.to("Bigby's Hand", "Main de Bigby"), TuplesKt.to("Bio-Plasmic Scream", "Hurlement bioplasmique"), TuplesKt.to("Bio-plasmic Barrage", "Barrage bioplasmique"), TuplesKt.to("Blade of Magnus", "Lame de Magnus"), TuplesKt.to("Blitz", "Blitz"), TuplesKt.to("Blood Chalice", "Calice de sang"), TuplesKt.to("Blood Drain", "Absorption de sang"), TuplesKt.to("Bloodrush", "Coup de sang"), TuplesKt.to("Bloodthirst", "Soif de sang"), TuplesKt.to("Boast", "Vantardise"), TuplesKt.to("Body Thief", "Vol de corps"), TuplesKt.to("Body-print", "Impression corporelle"), TuplesKt.to("Bolster", "Renforcement"), TuplesKt.to("Brand-new Sky", "Votre rêve se réalise"), TuplesKt.to("Brave Heart", "Haut les cœurs"), TuplesKt.to("Bribe the Guards", "Soudoyez les gardes"), TuplesKt.to("Bring it Down!", "Abattez-le !"), TuplesKt.to("Brood Telepathy", "Télépathie du couvain"), TuplesKt.to("Bushido", "Bushido"), TuplesKt.to("Buy Information", "Piochez une carte"), TuplesKt.to("Buyback", "Rappel"), TuplesKt.to("Byzantium Radiation", "Radiation du Byzantium"), TuplesKt.to("Caan", "Caan"), TuplesKt.to("Call for Aid", "Vous appelez à l'aide"), TuplesKt.to("Cascade", "Cascade"), TuplesKt.to("Casualty", "Victime"), TuplesKt.to("Celebration", "Célébration"), TuplesKt.to("Ceremorphosis", "Cérémorphose"), TuplesKt.to("Chainsword", "Épée tronçonneuse"), TuplesKt.to("Champion", "Appui"), TuplesKt.to("Changeling", "Changelin"), TuplesKt.to("Channel", "Transfert"), TuplesKt.to("Chapter Master", "Maître de chapitre"), TuplesKt.to("Children of the Cult", "Enfants du culte"), TuplesKt.to("Choose a background", "Choisissez un passé"), TuplesKt.to("Chroma", "Chromatique"), TuplesKt.to("Cipher", "Cryptage"), TuplesKt.to("Clash", "Confronter"), TuplesKt.to("Cleave", "Tranchage"), TuplesKt.to("Cloak", "Voiler"), TuplesKt.to("Cohort", "Cohorte"), TuplesKt.to("Collect evidence", "Rassembler des preuves"), TuplesKt.to("Command Protocols", "Protocoles de commandement"), TuplesKt.to("Command Section", "Section de commandement"), TuplesKt.to("Commander ninjutsu", "Ninjutsu de commandant"), TuplesKt.to("Companion", "Compagnon"), TuplesKt.to("Compleated", "Parachevé "), TuplesKt.to("Concealed Position", "Positions cachées"), TuplesKt.to("Confounding Clouds", "Nuages déroutants"), TuplesKt.to("Conjure", "Conjurer"), TuplesKt.to("Conjure Elemental", "Invocation d'élémentaire"), TuplesKt.to("Connive", "Conniver"), TuplesKt.to("Conspire", "Conspiration"), TuplesKt.to("Constellation", "Constellation"), TuplesKt.to("Consume Anomaly", "Consumer l'anomalie"), TuplesKt.to("Converge", "Convergence"), TuplesKt.to("Convert", "Convertir"), TuplesKt.to("Convoke", "Convocation"), TuplesKt.to("Corrupted", "Corrompu"), TuplesKt.to("Coruscating Flames", "Flammes scintillantes"), TuplesKt.to("Council's dilemma", "Dilemme du conseil"), TuplesKt.to("Coven", "Congrégation"), TuplesKt.to("Craft", "Façonner"), TuplesKt.to("Crew", "Pilotage"), TuplesKt.to("Crown of Madness", "Couronne du dément"), TuplesKt.to("Crushing Teeth", "Crocs broyeurs"), TuplesKt.to("Cumulative upkeep", "Entretien cumulatif"), TuplesKt.to("Curse of the Walking Pox", "Malédiction de la vérole ambulante"), TuplesKt.to("Cycling", "Recyclage"), TuplesKt.to("Daemon Sword", "Épée-démon"), TuplesKt.to("Dash", "Précipitation"), TuplesKt.to("Daybound", "Diurne"), TuplesKt.to("Deal with the Black Guardian", "Marché avec le Gardien Noir"), TuplesKt.to("Death Frenzy", "Frénésie de mort"), TuplesKt.to("Death Ray", "Rayon de mort"), TuplesKt.to("Deathtouch", "Contact mortel"), TuplesKt.to("Decayed", "Décomposition"), TuplesKt.to("Defender", "Défenseur"), TuplesKt.to("Delirium", "Délire"), TuplesKt.to("Delve", "Fouille"), TuplesKt.to("Demonstrate", "Démonstration"), TuplesKt.to("Descend", "Descente"), TuplesKt.to("Desertwalk", "Traversée des déserts"), TuplesKt.to("Detain", "Détenir"), TuplesKt.to("Dethrone", "Détrônement"), TuplesKt.to("Devastating Charge", "Charge dévastatrice"), TuplesKt.to("Devoid", "Carence"), TuplesKt.to("Devour", "Dévorement"), TuplesKt.to("Devour Intellect", "Dévorer l'intelligence"), TuplesKt.to("Devourer of Souls", "Régénération infernale"), TuplesKt.to("Devouring Monster", "Monstre vorace"), TuplesKt.to("Discover", "Découvrir"), TuplesKt.to("Disguise", "Déguisement"), TuplesKt.to("Disintegration Ray", "Rayon de désintégration"), TuplesKt.to("Disturb", "Perturbation"), TuplesKt.to("Doctor's companion", "Compagnon du Docteur"), TuplesKt.to("Domain", "Domaine"), TuplesKt.to("Double agenda", "Intention double"), TuplesKt.to("Double strike", "Double initiative"), TuplesKt.to("Drain Life", "Drain de vie"), TuplesKt.to("Dredge", "Dragage"), TuplesKt.to("Dynastic Advisor", "Conseiller dynastique"), TuplesKt.to("Dynastic Codes", "Codes dynastiques"), TuplesKt.to("Dynastic Command Node", "Relais de commandement dynastique"), TuplesKt.to("Echo", "Écho"), TuplesKt.to("Echo of the First Murder", "Écho du premier meurtre"), TuplesKt.to("Elite Troops", "Troupes d'élite"), TuplesKt.to("Embalm", "Embaumement"), TuplesKt.to("Emerge", "Émergence"), TuplesKt.to("Eminence", "Éminence"), TuplesKt.to("Enchant", "Enchanter"), TuplesKt.to("Encore", "Encore"), TuplesKt.to("Endless Swarm", "Essaim infini"), TuplesKt.to("Endurant", "Endurant"), TuplesKt.to("Enlist", "Enrôlement"), TuplesKt.to("Enmitic Exterminator", "Exterminateur d'hostiles"), TuplesKt.to("Enrage", "Rage"), TuplesKt.to("Enthralling Performance", "Enthralling Performance"), TuplesKt.to("Entwine", "Union"), TuplesKt.to("Epic", "Épique"), TuplesKt.to("Equip", "Équipement"), TuplesKt.to("Escalate", "Intensification"), TuplesKt.to("Escape", "Échappée"), TuplesKt.to("Eternalize", "Éternalisation"), TuplesKt.to("Eternity Gate", "Portail d'Éternité"), TuplesKt.to("Everypony's Invited", "Everypony's Invited"), TuplesKt.to("Evoke", "Évocation"), TuplesKt.to("Evolve", "Évolution"), TuplesKt.to("Exalted", "Exaltation"), TuplesKt.to("Executioner Round", "Balle Executioner"), TuplesKt.to("Exert", "Surmener"), TuplesKt.to("Exile Cannon", "Canon d'exil"), TuplesKt.to("Exploit", "Exploitation"), TuplesKt.to("Explore", "Explorer"), TuplesKt.to("Exterminate!", "Exterminer"), TuplesKt.to("Extort", "Extorsion"), TuplesKt.to("Fabricate", "Fabrication"), TuplesKt.to("Fabricator Claw Array", "Panoplie de pinces"), TuplesKt.to("Fading", "Évanescence"), TuplesKt.to("Fallen Warrior", "Guerrier défunt"), TuplesKt.to("Family Gathering", "Family Gathering"), TuplesKt.to("Family gathering", "Assemblée familiale"), TuplesKt.to("Fast Healing", "Guérison rapide"), TuplesKt.to("Fateful hour", "Heure fatidique"), TuplesKt.to("Fateseal", "Destin"), TuplesKt.to("Fathomless descent", "Descente insondable"), TuplesKt.to("Fear", "Peur"), TuplesKt.to("Feed", "Nourrir"), TuplesKt.to("Feeder Mandibles", "Mandibules"), TuplesKt.to("Ferocious", "Férocité"), TuplesKt.to("Field Reprogramming", "Reprogrammation de terrain"), TuplesKt.to("Fight", "Se battre"), TuplesKt.to("Fire of Tzeentch", "Feu de Tzeentch"), TuplesKt.to("First strike", "Initiative"), TuplesKt.to("Flanking", "Débordement"), TuplesKt.to(ExifInterface.TAG_FLASH, ExifInterface.TAG_FLASH), TuplesKt.to("Flashback", "Flashback"), TuplesKt.to("Flavor", "Flavor"), TuplesKt.to("Flesh Flayer", "Dépeceur de chair"), TuplesKt.to("Flesh Hooks", "Crochets de chair"), TuplesKt.to("Flying", "Vol"), TuplesKt.to(PredefinedCategory.FOOD, "Nourriture"), TuplesKt.to("For Mirrodin!", "Pour Mirrodin !"), TuplesKt.to("Forecast", "Prévision"), TuplesKt.to("Forestcycling", "Recyclage de forêt"), TuplesKt.to("Forestwalk", "Traversée des forêts"), TuplesKt.to("Foretell", "Prédiction"), TuplesKt.to("Formidable", "Redoutable"), TuplesKt.to("Fortify", "Fortification"), TuplesKt.to("Frenzied Metabolism", "Métabolisme frénétique"), TuplesKt.to("Frenzied Rampage", "Carnage frénétique"), TuplesKt.to("Frenzy", "Frenzy"), TuplesKt.to("Friends", "Faux amis"), TuplesKt.to("Friends forever", "Friends forever"), TuplesKt.to("Fuse", "Fusion"), TuplesKt.to("Gather Your Courage", "Vous rassemblez votre courage"), TuplesKt.to("Gathered Swarm", "Nuée spirituelle"), TuplesKt.to("Gatling Blaster", "Éclateur Gatling"), TuplesKt.to("Genestealer's Kiss", "Baiser du Genestealer"), TuplesKt.to("Genomic Enhancement", "Amélioration génomique"), TuplesKt.to("Gift of Chaos", "Don du Chaos"), TuplesKt.to("Glory of Battle", "Gloire de la bataille"), TuplesKt.to("Goad", "Inciter"), TuplesKt.to("Graft", "Greffe"), TuplesKt.to("Grand Strategist", "Grand stratège"), TuplesKt.to("Grandeur", "Majesté"), TuplesKt.to("Grav-cannon", "Canon à gravitons"), TuplesKt.to("Gravestorm", "Déluge de cimetière"), TuplesKt.to("Grenades!", "Grenades !"), TuplesKt.to("Guardian Protocols", "Protocoles d'escorte"), TuplesKt.to("Gust of Wind", "Saute de vent"), TuplesKt.to("Harbinger of Despair", "Émissaire du désespoir"), TuplesKt.to("Haste", "Célérité"), TuplesKt.to("Haunt", "Hantise"), TuplesKt.to("Healing Tears", "Larmes guérisseuses"), TuplesKt.to("Heavy Power Hammer", "Marteau énergétique lourd"), TuplesKt.to("Heavy Rock Cutter", "Cisaille lourde"), TuplesKt.to("Hellbent", "Acharnement"), TuplesKt.to("Hero's Reward", "Hero's Reward"), TuplesKt.to("Heroic", "Héroïque"), TuplesKt.to("Hexproof", "Défense talismanique"), TuplesKt.to("Hexproof from", "Défense talismanique contre"), TuplesKt.to("Hidden agenda", "Intention cachée"), TuplesKt.to("Hideaway", "Cachette"), TuplesKt.to("Hire a Mercenary", "Engager un mercenaire"), TuplesKt.to("History", "Histoire"), TuplesKt.to("History Teacher", "Professeur d'histoire"), TuplesKt.to("Hive Mind", "Esprit de ruche"), TuplesKt.to("Homunculus Servant", "Servant homoncule"), TuplesKt.to("Horrific Symbiosis", "Symbiose horrible"), TuplesKt.to("Horsemanship", "Équitation"), TuplesKt.to("How Civil of You", "Très aimable à vous"), TuplesKt.to("Hunt for Heresy", "Chasse à l'hérésie"), TuplesKt.to("Hyperfrag Round", "Balle Hyperfrag"), TuplesKt.to("Hyperphase Threshers", "Fauchons d'hyperphase"), TuplesKt.to("Hypertoxic Miasma", "Miasmes hypertoxiques"), TuplesKt.to("I. AM. TALKING!", "JE. VOUS. PARLE !"), TuplesKt.to("Impossible Girl", "Fille impossible"), TuplesKt.to("Imprint", "Empreinte"), TuplesKt.to("Improvise", "Improvisation"), TuplesKt.to("Incubate", "Incuber"), TuplesKt.to("Indestructible", "Indestructible"), TuplesKt.to("Infect", "Infection"), TuplesKt.to("Infesting Spores", "Infestation de spores"), TuplesKt.to("Ingest", "Ingestion"), TuplesKt.to("Inquisition Agents", "Agents de l'Inquisition"), TuplesKt.to("Inspired", "Inspiration"), TuplesKt.to("Intimidate", "Intimidation"), TuplesKt.to("Into the TARDIS", "Dans le TARDIS"), TuplesKt.to("Invasion Beams", "Faisceaux d'invasion"), TuplesKt.to("Investigate", "Enquêter"), TuplesKt.to("Islandcycling", "Recyclage d'île"), TuplesKt.to("Islandwalk", "Traversée des îles"), TuplesKt.to("Jast", "Jast"), TuplesKt.to("Join forces", "Union des forces"), TuplesKt.to("Jolly Gutpipes", "Cornepanse entraînante"), TuplesKt.to("Jump-start", "Relancer"), TuplesKt.to("Keen Sight", "Vue aiguisée"), TuplesKt.to("Kicker", "Kick"), TuplesKt.to("Kinfall", "Kinfall"), TuplesKt.to("Kinship", "Parenté"), TuplesKt.to("Landcycling", "Recyclage de terrain"), TuplesKt.to("Landfall", "Toucheterre"), TuplesKt.to("Landship", "Landship"), TuplesKt.to("Landwalk", "Traversée de terrain"), TuplesKt.to("Leading from the Front", "Officier de ligne"), TuplesKt.to("Learn", "Apprendre"), TuplesKt.to("Legacy", "Legacy"), TuplesKt.to("Legendary landwalk", "Traversée des terrains légendaires"), TuplesKt.to("Level Up", "Montée de niveau"), TuplesKt.to("Lieutenant", "Lieutenant"), TuplesKt.to("Lifelink", "Lien de vie"), TuplesKt.to("Living metal", "Métal vivant"), TuplesKt.to("Living weapon", "Arme vivante"), TuplesKt.to("Locus of Slaanesh", "Privilège de Slaanesh"), TuplesKt.to("Look to the Stars", "Observer les étoiles"), TuplesKt.to("Lord of Chaos", "Seigneur du Chaos"), TuplesKt.to("Lord of Torment", "Seigneur du Tourment"), TuplesKt.to("Lord of the Pyrrhian Legions", "Seigneur des Légions de Pyrrhia"), TuplesKt.to("Loud Ruckus", "Vacarme"), TuplesKt.to("Low Gravity", "Faible gravité"), TuplesKt.to("Lure the Unwary", "Attirer les imprudents"), TuplesKt.to("Madness", "Folie"), TuplesKt.to("Magecraft", "Sorcellerie"), TuplesKt.to("Make Them Pay", "Les faire payer"), TuplesKt.to("Mama's Coming", "Maman arrive"), TuplesKt.to("Manifest", "Manifester"), TuplesKt.to("Mantle of Inspiration", "Manteau d'inspiration"), TuplesKt.to("Mark of Chaos Ascendant", "Marque du Chaos ascendant"), TuplesKt.to("Martyrdom", "Martyre"), TuplesKt.to("Master Tactician", "Maître tacticien"), TuplesKt.to("Master of Machines", "Maître des machines"), TuplesKt.to("Matter Absorption", "Absorption de matière"), TuplesKt.to("Medicus Ministorum", "Medicus Ministorum"), TuplesKt.to("Meet in Reverse", "Rencontre à rebours"), TuplesKt.to("Megamorph", "Mégamue"), TuplesKt.to("Meld", "Assimiler en"), TuplesKt.to("Melee", "Mêlée"), TuplesKt.to("Menace", "Menace"), TuplesKt.to("Mentor", "Mentor"), TuplesKt.to("Metalcraft", "Art des métaux"), TuplesKt.to("Midnight Entity", "Entité de Minuit"), TuplesKt.to("Mill", "Meuler"), TuplesKt.to("Miracle", "Miracle"), TuplesKt.to("Modular", "Modularité"), TuplesKt.to("Mold Earth", "Façonnage de la terre"), TuplesKt.to("Mold Harvest", "Récolte de moisissure"), TuplesKt.to("Monstrosity", "Monstruosité"), TuplesKt.to("Morbid", "Morbidité"), TuplesKt.to("More Than Meets the Eye", "Plus fort que les apparences"), TuplesKt.to("Morph", "Mue"), TuplesKt.to("Mountaincycling", "Recyclage de montagne"), TuplesKt.to("Mountainwalk", "Traversée des montagnes"), TuplesKt.to("Multi-threat Eliminator", "Éliminateur de menaces multiples"), TuplesKt.to("Multikicker", "Multikick"), TuplesKt.to("Mutate", "Mutation"), TuplesKt.to("My Will Be Done", "Que ma volonté s'accomplisse"), TuplesKt.to("Myriad", "Myriade"), TuplesKt.to("Natural Recovery", "Ressourcement"), TuplesKt.to("Natural Shelter", "Abri naturel"), TuplesKt.to("Negative", "Négatif"), TuplesKt.to("Neurotraumal Rod", "Bâton neurotraumatique"), TuplesKt.to("Nightbound", "Nocturne"), TuplesKt.to("Ninjutsu", "Ninjutsu"), TuplesKt.to("Nitro-9", "Nitro-9"), TuplesKt.to("Nonbasic landwalk", "Traversée des terrains non-base"), TuplesKt.to("Offering", "Offrande"), TuplesKt.to("Open an Attraction", "Ouvrir une attraction"), TuplesKt.to("Outlast", "Résilience"), TuplesKt.to("Overload", "Surcharge"), TuplesKt.to("Pack tactics", "Tactique de meute"), TuplesKt.to("Paradox", "Paradoxe"), TuplesKt.to("Parallel Universe", "Univers parallèle"), TuplesKt.to("Parley", "Pourparler"), TuplesKt.to("Partner", "Partenariat"), TuplesKt.to("Partner with", "Partenariat avec"), TuplesKt.to("Peaceful Coexistence", "Coexistence pacifique"), TuplesKt.to("Persist", "Persistance"), TuplesKt.to("Phaeron", "Phaëron"), TuplesKt.to("Phalanx Commander", "Commandant de phalanges"), TuplesKt.to("Phasing", "Déphasage"), TuplesKt.to("Pheromone Trail", "Traînée de phéromones"), TuplesKt.to("Plainscycling", "Recyclage de plaine"), TuplesKt.to("Plainswalk", "Traversée des plaines"), TuplesKt.to("Plasma Incinerator", "Incinérateur à plasma"), TuplesKt.to("Polymorphine", "Polymorphine"), TuplesKt.to("Populate", "Peupler"), TuplesKt.to("Praesidium Protectiva", "Praesidium Protectiva"), TuplesKt.to("Praise Him", "Gloire à lui"), TuplesKt.to("Pray for Protection", "Vous psalmodiez une prière de protection"), TuplesKt.to("Primarch of the Death Guard", "Primarque de la Death Guard"), TuplesKt.to("Prince of Chaos", "Prince du Chaos"), TuplesKt.to("Prismatic Gallery", "Galerie prismatique"), TuplesKt.to("Probing Telepathy", "Pénétration télépathique"), TuplesKt.to("Proclamator Hailer", "Déclamateur"), TuplesKt.to("Project Image", "Projection d'image"), TuplesKt.to("Proliferate", "Proliférer"), TuplesKt.to("Protection", "Protection"), TuplesKt.to("Protection Fighting Style", "Style de combat protection"), TuplesKt.to("Protector", ""), TuplesKt.to("Prototype", "Prototype"), TuplesKt.to("Provoke", "Provocation"), TuplesKt.to("Prowess", "Prouesse"), TuplesKt.to("Prowl", "Incursion"), TuplesKt.to("Psychic Abomination", "Abomination psychique"), TuplesKt.to("Psychic Blades", "Lames psychiques"), TuplesKt.to("Psychic Defense", "Défense psychique"), TuplesKt.to("Psychic Stimulus", "Stimulus psychique"), TuplesKt.to("Radiance", "Irradiance"), TuplesKt.to("Raid", "Saccage"), TuplesKt.to("Rally", "Ralliement"), TuplesKt.to("Rampage", "Sauvagerie"), TuplesKt.to("Rapacious Hunger", "Faim dévorante"), TuplesKt.to("Rapid Regeneration", "Régénération rapide"), TuplesKt.to("Rapid-fire Battle Cannon", "Obusier à tir rapide"), TuplesKt.to("Ravenous", "Voracité"), TuplesKt.to("Reach", "Portée"), TuplesKt.to("Read Ahead", "Lecture rapide"), TuplesKt.to("Rebound", "Rebond"), TuplesKt.to("Reconfigure", "Reconfiguration"), TuplesKt.to("Recover", "Recouvrement"), TuplesKt.to("Red-Eye", "Œil-rouge"), TuplesKt.to("Reinforce", "Renfort"), TuplesKt.to("Relentless March", "Progression implacable"), TuplesKt.to("Renown", "Réputation"), TuplesKt.to("Repair Barge", "Console de réparation"), TuplesKt.to("Replicate", "Duplication"), TuplesKt.to("Retrace", "Pistage"), TuplesKt.to("Reverberating Summons", "Invocations réverbérantes"), TuplesKt.to("Revolt", "Révolte"), TuplesKt.to("Riot", "Émeute"), TuplesKt.to("Ripple", "Remous"), TuplesKt.to("Rites of Banishment", "Rites de bannissement"), TuplesKt.to("Rogue Trader", "Libre-marchand"), TuplesKt.to("Role token", "Jeton de rôle"), TuplesKt.to("Roll to Visit Your Attractions", "Lancer un dé pour visiter vos attractions"), TuplesKt.to("Rosarius", "Rosarius"), TuplesKt.to("Rot Fly", "Mouche à peste"), TuplesKt.to("Ruinous Ascension", "Ascension destructrice"), TuplesKt.to("Run and Hide", "Vous fuyez vous cacher"), TuplesKt.to("Sanctified Rules of Combat", "Règles de combat sanctifiées"), TuplesKt.to("Scavenge", "Récupération"), TuplesKt.to("Scavenge the Dead", "Recyclage des morts"), TuplesKt.to("Science Teacher", "Professeur de sciences"), TuplesKt.to("Scorching Ray", "Rayon ardent"), TuplesKt.to("Scry", "Regard"), TuplesKt.to("Sec", "Sec"), TuplesKt.to("Secret council", "Conseil secret"), TuplesKt.to("Secrets of the Soul", "Secrets de l'âme"), TuplesKt.to("Sell Contraband", "Vendre de la contrebande"), TuplesKt.to("Shadow", "Distorsion"), TuplesKt.to("Share Intelligence", "Partage d'information"), TuplesKt.to("Shieldwall", "Mur de boucliers"), TuplesKt.to("Shrieking Gargoyles", "Gargouilles hurlantes"), TuplesKt.to("Shroud", "Linceul"), TuplesKt.to("Sigil of Corruption", "Symbole de Corruption"), TuplesKt.to("Sixty-Six Seconds", "Soixante-six secondes"), TuplesKt.to("Skilled Outrider", "Éclaireur accompli"), TuplesKt.to("Skulk", "Furtivité"), TuplesKt.to("Skyswarm", "Essaim volant"), TuplesKt.to("Sleight of Hand", "Escamotage"), TuplesKt.to("Slivercycling", "Recyclage de slivoïde"), TuplesKt.to("Song of the Ood", "Chant des Oods"), TuplesKt.to("Sonic Blaster", "Éclateur sonique"), TuplesKt.to("Sonic Booster", "Amplificateur sonique"), TuplesKt.to("Sonic Rainboom", "Sonic Rainboom"), TuplesKt.to("Sorcerous Elixir", "Elixir sorcier"), TuplesKt.to("Sorcerous Inspiration", "Sorcellerie inspirante"), TuplesKt.to("Soulbond", "Association d'âmes"), TuplesKt.to("Soulshift", "Transmigration"), TuplesKt.to("Spear of the Void Dragon", "Lance du Dragon du Néant"), TuplesKt.to("Spectacle", "Spectacle"), TuplesKt.to("Spell mastery", "Maîtrise de sort"), TuplesKt.to("Spiked Retribution", "Représailles pointues"), TuplesKt.to("Spiritual Leader", "Chef spirituel"), TuplesKt.to("Splice", "Imprégnation"), TuplesKt.to("Split second", "Fraction de seconde"), TuplesKt.to("Spoilers", "Spoilers"), TuplesKt.to("Spore Chimney", "Cheminée à spores"), TuplesKt.to("Squad", "Escouade"), TuplesKt.to("Stall for Time", "Vous gagnez du temps"), TuplesKt.to("Still Point in Time", "Point immobile dans le temps"), TuplesKt.to("Storm", "Déluge"), TuplesKt.to("Stowage", "Transport"), TuplesKt.to("Strategic Coordinator", "Coordinateur stratégique"), TuplesKt.to("Strike a Deal", "Vous faites un marché"), TuplesKt.to("Strive", "Obstination"), TuplesKt.to("Subterranean Assault", "Assaut souterrain"), TuplesKt.to("Summary Execution", "Exécution sommaire"), TuplesKt.to("Sunburst", "Solarisation"), TuplesKt.to("Support", "Soutenir"), TuplesKt.to("Suppressing Fire", "Tir de suppression"), TuplesKt.to("Surge", "Déferlement"), TuplesKt.to("Surveil", "Surveiller"), TuplesKt.to("Suspect", "Suspecter"), TuplesKt.to("Suspend", "Suspension"), TuplesKt.to("Suspended Animation", "Animation suspendue"), TuplesKt.to("Swampcycling", "Recyclage de marais"), TuplesKt.to("Swampwalk", "Traversée des marais"), TuplesKt.to("Sweep", "Balayage"), TuplesKt.to("Symphony of Pain", "Symphonie de souffrance"), TuplesKt.to("Synapse Creature", "Créature synapse"), TuplesKt.to("Synaptic Disintegrator", "Désintégrateur synaptique"), TuplesKt.to("Targeting Relay", "Relais de visée"), TuplesKt.to("Team TARDIS", "Équipe du TARDIS"), TuplesKt.to("Teamwork", "Teamwork"), TuplesKt.to("Temporal Foresight", "Prévision temporelle"), TuplesKt.to("Tempting offer", "Offre tentante"), TuplesKt.to("Terror from the Deep", "Terreur des profondeurs"), TuplesKt.to("Thay", "Thay"), TuplesKt.to("The Betrayer", "Le Félon"), TuplesKt.to("The Last Centurion", "Le dernier centurion"), TuplesKt.to("The Most Important Punch in History", "Le coup de poing le plus important de l'Histoire"), TuplesKt.to("The Seven-fold Chant", "Le Septuple Chant"), TuplesKt.to("The Will of the Hive Mind", "Volonté de l'Esprit-ruche"), TuplesKt.to("Threaten the Merchant", "Menacez le marchand"), TuplesKt.to("Three Autostubs", "Trois armes automatiques"), TuplesKt.to("Threshold", "Seuil"), TuplesKt.to("Time Lord's Prerogative", "Prérogative de Time Lord"), TuplesKt.to("Time Travel", "Voyagez dans le temps"), TuplesKt.to("Timey-Wimey", "Méli-mélo spatio-temporel"), TuplesKt.to("Titanic", "Titanesque"), TuplesKt.to("Totem armor", "Armure totémique"), TuplesKt.to("Toxic", "Toxique"), TuplesKt.to("Toxic Spores", "Spores toxiques"), TuplesKt.to("Training", "Entraînement"), TuplesKt.to("Trample", "Piétinement"), TuplesKt.to("Transdimensional Scout", "Éclaireur transdimensionnel"), TuplesKt.to("Transfigure", "Transfiguration"), TuplesKt.to("Transform", "Transformer"), TuplesKt.to("Translocation Protocols", "Protocoles de translocalisation"), TuplesKt.to("Transmute", "Transmutation"), TuplesKt.to("Treasure", "Trésor"), TuplesKt.to("Tribute", "Tribut"), TuplesKt.to("Typecycling", "Recyclage de Type"), TuplesKt.to("Ultima Founding", "Fondation Ultima"), TuplesKt.to("Ultimate Sacrifice", "Ultime sacrifice"), TuplesKt.to("Undaunted", "Témérité"), TuplesKt.to("Underdog", "Underdog"), TuplesKt.to("Undergrowth", "Maquis"), TuplesKt.to("Undying", "Survivance"), TuplesKt.to("Unearth", "Exhumation"), TuplesKt.to("Unearthly Power", "Puissance surnaturelle"), TuplesKt.to("Unleash", "Emportement"), TuplesKt.to("Unquestionable Wisdom", "Sagesse incontestable"), TuplesKt.to("Vanguard Species", "Espèce avant-garde"), TuplesKt.to("Vanishing", "Disparition"), TuplesKt.to("Veil of Time", "Voile du temps"), TuplesKt.to("Venture into the dungeon", "Aventurez-vous dans le donjon"), TuplesKt.to("Vicious Mockery", "Moquerie cruelle"), TuplesKt.to("Vigilance", "Vigilance"), TuplesKt.to("Void Shields", "Boucliers Void"), TuplesKt.to("Ward", "Parade"), TuplesKt.to("Warp Blast", "Décharge Warp"), TuplesKt.to("Warp Vortex", "Vortex warp"), TuplesKt.to("Water Always Wins", "L'eau triomphe toujours"), TuplesKt.to("Weird Insight", "Intuition mystérieuse"), TuplesKt.to("Will of the council", "Volonté du conseil"), TuplesKt.to("Wind Walk", "Vent divin"), TuplesKt.to("Wither", "Flétrissure"), TuplesKt.to("Wizardcycling", "Recyclage de sorcier"), TuplesKt.to("Woman Who Walked the Earth", "La femme qui voyagea à travers le monde"), TuplesKt.to("Wraith Form", "Enveloppe spectrale"), TuplesKt.to("Xenos Cunning", "Ruse Xénos"));
    }

    public final List<String> getLayoutTypes() {
        return CollectionsKt.listOf((Object[]) new String[]{"adventure", "augment", "case", "class", "double_faced_token", "emblem", "flip", DiagnosticsTracker.HOST_KEY, "leveler", "meld", "modal_dfc", "normal", "planar", "prototype", "reversible_card", "saga", "scheme", "split", "token", "transform", "vanguard"});
    }

    public final List<String> getOtherColors(List<String> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        ArrayList arrayList = new ArrayList();
        if (!colors.contains(ExifInterface.LONGITUDE_WEST)) {
            arrayList.add(ExifInterface.LONGITUDE_WEST);
        }
        if (!colors.contains("U")) {
            arrayList.add("U");
        }
        if (!colors.contains("B")) {
            arrayList.add("B");
        }
        if (!colors.contains("R")) {
            arrayList.add("R");
        }
        if (!colors.contains(GameUtils.CONDITION_GOOD)) {
            arrayList.add(GameUtils.CONDITION_GOOD);
        }
        return arrayList;
    }

    public final List<String> mapColorValueToIndividualColors(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("azorius", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U"})), TuplesKt.to("dimir", CollectionsKt.listOf((Object[]) new String[]{"U", "B"})), TuplesKt.to("rakdos", CollectionsKt.listOf((Object[]) new String[]{"B", "R"})), TuplesKt.to("gruul", CollectionsKt.listOf((Object[]) new String[]{"R", GameUtils.CONDITION_GOOD})), TuplesKt.to("selesnya", CollectionsKt.listOf((Object[]) new String[]{GameUtils.CONDITION_GOOD, ExifInterface.LONGITUDE_WEST})), TuplesKt.to("orzhov", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "B"})), TuplesKt.to("izzet", CollectionsKt.listOf((Object[]) new String[]{"U", "R"})), TuplesKt.to("golgari", CollectionsKt.listOf((Object[]) new String[]{"B", GameUtils.CONDITION_GOOD})), TuplesKt.to("boros", CollectionsKt.listOf((Object[]) new String[]{"R", ExifInterface.LONGITUDE_WEST})), TuplesKt.to("simic", CollectionsKt.listOf((Object[]) new String[]{"U", GameUtils.CONDITION_GOOD})));
        int i = 2;
        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("bant", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", GameUtils.CONDITION_GOOD})), TuplesKt.to("esper", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B"})), TuplesKt.to("grixis", CollectionsKt.listOf((Object[]) new String[]{"U", "B", "R"})), TuplesKt.to("jund", CollectionsKt.listOf((Object[]) new String[]{"B", "R", GameUtils.CONDITION_GOOD})), TuplesKt.to("naya", CollectionsKt.listOf((Object[]) new String[]{"R", GameUtils.CONDITION_GOOD, ExifInterface.LONGITUDE_WEST})), TuplesKt.to("abzan", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "B", GameUtils.CONDITION_GOOD})), TuplesKt.to("jeskai", CollectionsKt.listOf((Object[]) new String[]{"U", "R", ExifInterface.LONGITUDE_WEST})), TuplesKt.to("sultai", CollectionsKt.listOf((Object[]) new String[]{"B", GameUtils.CONDITION_GOOD, "U"})), TuplesKt.to("mardu", CollectionsKt.listOf((Object[]) new String[]{"R", ExifInterface.LONGITUDE_WEST, "B"})), TuplesKt.to("temur", CollectionsKt.listOf((Object[]) new String[]{GameUtils.CONDITION_GOOD, "U", "R"})));
        Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("glint", CollectionsKt.listOf((Object[]) new String[]{"U", "B", "R", GameUtils.CONDITION_GOOD})), TuplesKt.to("dune", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "B", "R", GameUtils.CONDITION_GOOD})), TuplesKt.to("ink", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "R", GameUtils.CONDITION_GOOD})), TuplesKt.to("witch", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", GameUtils.CONDITION_GOOD})), TuplesKt.to("yore", CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", "R"})));
        Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to("white", ExifInterface.LONGITUDE_WEST), TuplesKt.to("blue", "U"), TuplesKt.to(PreferencesManager.BACKGROUND_BLACK, "B"), TuplesKt.to("red", "R"), TuplesKt.to("green", GameUtils.CONDITION_GOOD), TuplesKt.to("c", ""), TuplesKt.to("colorless", ""), TuplesKt.to("m", "M"), TuplesKt.to("multicolor", "M"));
        String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = (List) mapMapOf.get(lowerCase);
        if (list != null) {
            return list;
        }
        List<String> list2 = (List) mapMapOf2.get(lowerCase);
        if (list2 != null) {
            return list2;
        }
        List<String> list3 = (List) mapMapOf3.get(lowerCase);
        if (list3 != null) {
            return list3;
        }
        String str = (String) mapMapOf4.get(lowerCase);
        if (str != null) {
            String str2 = str;
            if (str2.length() <= 0) {
                return CollectionsKt.emptyList();
            }
            List<Character> list4 = StringsKt.toList(str2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Character) it.next()).charValue()));
            }
            return arrayList;
        }
        String str3 = lowerCase;
        int i2 = 0;
        while (i2 < str3.length()) {
            int i3 = i;
            if (!StringsKt.contains$default((CharSequence) "wubrg", str3.charAt(i2), false, i3, (Object) null)) {
                return CollectionsKt.emptyList();
            }
            i2++;
            i = i3;
        }
        ArrayList arrayList2 = new ArrayList(str3.length());
        for (int i4 = 0; i4 < str3.length(); i4++) {
            String strValueOf = String.valueOf(str3.charAt(i4));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            arrayList2.add(upperCase);
        }
        return arrayList2;
    }

    public final SearchElement parseSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        List<String> list = tokenize(query);
        SearchGroup searchGroup = new SearchGroup(null, 1, null);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SearchCondition condition = parseCondition((String) it.next());
            if (condition != null) {
                searchGroup.getElements().add(condition);
            }
        }
        return searchGroup;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String processKeyword(String keyword, String lang) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Intrinsics.areEqual(lang, "en")) {
            String lowerCase = keyword.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "plotted")) {
                return "Plot";
            }
            if (Intrinsics.areEqual(lowerCase, "saddled")) {
                return "Saddle";
            }
        }
        if (Intrinsics.areEqual(lang, "fr")) {
            String lowerCase2 = keyword.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            switch (lowerCase2.hashCode()) {
                case -1999549151:
                    if (lowerCase2.equals("transformez")) {
                        return "Transformer";
                    }
                    break;
                case -1928898489:
                    if (lowerCase2.equals("explorez")) {
                        return "Expolorer";
                    }
                    break;
                case -1661941268:
                    if (lowerCase2.equals("suspectez")) {
                        return "Suspecter";
                    }
                    break;
                case -1609021253:
                    if (lowerCase2.equals("surmenez")) {
                        return "Surmener";
                    }
                    break;
                case -1603174593:
                    if (lowerCase2.equals("commettre un crime")) {
                        return "Crime";
                    }
                    break;
                case -1402633705:
                    if (lowerCase2.equals("complotez")) {
                        return "Complot";
                    }
                    break;
                case -1289365429:
                    if (lowerCase2.equals("exilez")) {
                        return "Exiler";
                    }
                    break;
                case -1150508201:
                    if (lowerCase2.equals("adaptez")) {
                        return "Adapter";
                    }
                    break;
                case -1077521628:
                    if (lowerCase2.equals("meulez")) {
                        return "Meuler";
                    }
                    break;
                case -892757430:
                    if (lowerCase2.equals("amassez")) {
                        return "Ammasser";
                    }
                    break;
                case -810981551:
                    if (lowerCase2.equals("voilez")) {
                        return "Voiler";
                    }
                    break;
                case -688018305:
                    if (lowerCase2.equals("surveillez")) {
                        return "Surveiller";
                    }
                    break;
                case -675762991:
                    if (lowerCase2.equals("peuplez")) {
                        return "Peupler";
                    }
                    break;
                case -599435449:
                    if (lowerCase2.equals("comploté")) {
                        return "Complot";
                    }
                    break;
                case -554620910:
                    if (lowerCase2.equals("relancez")) {
                        return "Relancer";
                    }
                    break;
                case -74171942:
                    if (lowerCase2.equals("proliférez")) {
                        return "Proliférer";
                    }
                    break;
                case 109321175:
                    if (lowerCase2.equals("sellé")) {
                        return "Seller";
                    }
                    break;
                case 144211945:
                    if (lowerCase2.equals("verrouillez")) {
                        return "verrouiller";
                    }
                    break;
                case 200056382:
                    if (lowerCase2.equals("manifestez l'effroi")) {
                        return "Manifester l'effroi";
                    }
                    break;
                case 263521803:
                    if (lowerCase2.equals("contemplez")) {
                        return "contempler";
                    }
                    break;
                case 614330379:
                    if (lowerCase2.equals("régénéré")) {
                        return "Régénérer";
                    }
                    break;
                case 624468482:
                    if (lowerCase2.equals("mobilisez")) {
                        return "mobiliser";
                    }
                    break;
                case 880184772:
                    if (lowerCase2.equals("déverrouillez")) {
                        return "déverrouiller";
                    }
                    break;
                case 942323953:
                    if (lowerCase2.equals("détruisez")) {
                        return "Détruire";
                    }
                    break;
                case 976644900:
                    if (lowerCase2.equals("manifestez")) {
                        return "Manifester";
                    }
                    break;
                case 1097346268:
                    if (lowerCase2.equals("confrontez")) {
                        return "Confronter";
                    }
                    break;
                case 1309244648:
                    if (lowerCase2.equals("assemblez")) {
                        return "Assembler";
                    }
                    break;
                case 1864368595:
                    if (lowerCase2.equals("régénérez")) {
                        return "Régénérer";
                    }
                    break;
                case 1942483966:
                    if (lowerCase2.equals("incitez")) {
                        return "Inciter";
                    }
                    break;
                case 1942824160:
                    if (lowerCase2.equals("incubez")) {
                        return "Incuber";
                    }
                    break;
                case 2033419912:
                    if (lowerCase2.equals("mobilisation")) {
                        return "mobiliser";
                    }
                    break;
            }
        }
        return keyword;
    }

    public final String searchElementToSql(SearchElement element, String lang, boolean folding) throws IOException {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(lang, "lang");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (element instanceof SearchGroup) {
            for (SearchElement searchElement : ((SearchGroup) element).getElements()) {
                if (searchElement instanceof SearchCondition) {
                    SearchCondition searchCondition = (SearchCondition) searchElement;
                    String strConditionToSql = conditionToSql(searchCondition, lang, folding);
                    if (!CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.NAME, SearchKeyword.ORACLE_TEXT, SearchKeyword.TYPE}).contains(searchCondition.getKeyword())) {
                        arrayList3.add(strConditionToSql);
                    } else if (searchCondition.getInclude()) {
                        arrayList.add(strConditionToSql);
                    } else {
                        arrayList2.add(strConditionToSql);
                    }
                }
            }
        }
        String strJoinToString$default = "";
        String str = !arrayList.isEmpty() ? "f.cards_fts MATCH '" + CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchDataUtils.searchElementToSql$lambda$0((String) obj);
            }
        }, 30, null) + "'" : "";
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                arrayList5.add("NOT EXISTS (\n    SELECT 1 FROM cards_fts AS exclude_fts\n    WHERE exclude_fts.docid = f.docid\n    AND exclude_fts.cards_fts MATCH '" + StringsKt.replace$default((String) it.next(), "'", "''", false, 4, (Object) null) + "*')");
            }
            strJoinToString$default = CollectionsKt.joinToString$default(arrayList5, " AND ", null, null, 0, null, null, 62, null);
        }
        return str.length() == 0 ? strJoinToString$default.length() > 0 ? CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) CollectionsKt.listOfNotNull(strJoinToString$default), (Iterable) arrayList3), " AND ", null, null, 0, null, null, 62, null) : CollectionsKt.joinToString$default(arrayList3, " AND ", null, null, 0, null, null, 62, null) : strJoinToString$default.length() > 0 ? CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) CollectionsKt.listOfNotNull((Object[]) new String[]{str, strJoinToString$default}), (Iterable) arrayList3), " AND ", null, null, 0, null, null, 62, null) : CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) CollectionsKt.listOfNotNull(str), (Iterable) arrayList3), " AND ", null, null, 0, null, null, 62, null);
    }

    public final String standardizeManaCost(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Regex regex = new Regex("\\{[^}]+\\}|\\d+|.");
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, 1), TuplesKt.to("U", 2), TuplesKt.to("B", 3), TuplesKt.to("R", 4), TuplesKt.to(GameUtils.CONDITION_GOOD, 5), TuplesKt.to(GameUtils.CONDITION_POOR, 6));
        String upperCase = input.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        List list = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(regex, upperCase, 0, 2, null), new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchDataUtils.standardizeManaCost$lambda$0((kotlin.text.MatchResult) obj);
            }
        }));
        if (list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            String strTrim = StringsKt.trim((String) obj, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ);
            if (!Intrinsics.areEqual(strTrim, "X")) {
                String str = strTrim;
                for (int i = 0; i < str.length(); i++) {
                    if (!Character.isDigit(str.charAt(i))) {
                        arrayList2.add(obj);
                        break;
                    }
                }
            }
            arrayList.add(obj);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) CollectionsKt.sortedWith((List) pair.component1(), ComparisonsKt.compareBy(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SearchDataUtils.standardizeManaCost$lambda$2((String) obj2);
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SearchDataUtils.standardizeManaCost$lambda$3((String) obj2);
            }
        })), (Iterable) CollectionsKt.sortedWith((List) pair.component2(), new Comparator() { // from class: com.studiolaganne.lengendarylens.SearchDataUtils$standardizeManaCost$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Integer num = (Integer) mapMapOf.get(StringsKt.trim((String) t, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ));
                Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 7);
                Integer num2 = (Integer) mapMapOf.get(StringsKt.trim((String) t2, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ));
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : 7));
            }
        })), "", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String transformLayout(String theValue, String lang) {
        Intrinsics.checkNotNullParameter(theValue, "theValue");
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Intrinsics.areEqual(lang, "en")) {
            switch (theValue.hashCode()) {
                case -2124836977:
                    return !theValue.equals("modal_dfc") ? theValue : "Double-Faced Modal";
                case -1365355166:
                    return !theValue.equals("vanguard") ? theValue : "Vanguard";
                case -1299732710:
                    return !theValue.equals("emblem") ? theValue : "Emblem";
                case -1146166182:
                    return !theValue.equals("reversible_card") ? theValue : "Reversible Card";
                case -1039745817:
                    return !theValue.equals("normal") ? theValue : "Normal";
                case -985763558:
                    return !theValue.equals("planar") ? theValue : "Planar";
                case -907987547:
                    return !theValue.equals("scheme") ? theValue : "Scheme";
                case -694094064:
                    return !theValue.equals("adventure") ? theValue : "Adventure";
                case -658375023:
                    return !theValue.equals("augment") ? theValue : "Augment";
                case -598792926:
                    return !theValue.equals("prototype") ? theValue : "Prototype";
                case 3046192:
                    return !theValue.equals("case") ? theValue : "Case";
                case 3145837:
                    return !theValue.equals("flip") ? theValue : "Flip Card";
                case 3208616:
                    return !theValue.equals(DiagnosticsTracker.HOST_KEY) ? theValue : HttpHeaders.HOST;
                case 3347728:
                    return !theValue.equals("meld") ? theValue : "Meld";
                case 3522472:
                    return !theValue.equals("saga") ? theValue : "Saga";
                case 69785393:
                    return !theValue.equals("leveler") ? theValue : "Leveler";
                case 94742904:
                    return !theValue.equals("class") ? theValue : "Class";
                case 106865139:
                    return !theValue.equals("double_faced_token") ? theValue : "Double-Faced Token";
                case 109648666:
                    return !theValue.equals("split") ? theValue : "Split Card";
                case 110541305:
                    return !theValue.equals("token") ? theValue : "Token";
                case 1052666732:
                    return !theValue.equals("transform") ? theValue : "Double-Faced Transform";
                default:
                    return theValue;
            }
        }
        if (!Intrinsics.areEqual(lang, "fr")) {
            return theValue;
        }
        switch (theValue.hashCode()) {
            case -2124836977:
                return !theValue.equals("modal_dfc") ? theValue : "Carte à Double Face Modale";
            case -1365355166:
                return !theValue.equals("vanguard") ? theValue : "Vanguard";
            case -1299732710:
                return !theValue.equals("emblem") ? theValue : "Emblème";
            case -1146166182:
                return !theValue.equals("reversible_card") ? theValue : "Carte Réversible";
            case -1039745817:
                return !theValue.equals("normal") ? theValue : "Normale";
            case -985763558:
                return !theValue.equals("planar") ? theValue : "Plan";
            case -907987547:
                return !theValue.equals("scheme") ? theValue : "Machination";
            case -694094064:
                return !theValue.equals("adventure") ? theValue : "Aventure";
            case -658375023:
                return !theValue.equals("augment") ? theValue : "Augment";
            case -598792926:
                return !theValue.equals("prototype") ? theValue : "Prototype";
            case 3046192:
                return !theValue.equals("case") ? theValue : "Affaire";
            case 3145837:
                return !theValue.equals("flip") ? theValue : "Carte à Inversion";
            case 3208616:
                return !theValue.equals(DiagnosticsTracker.HOST_KEY) ? theValue : "Hôte";
            case 3347728:
                return !theValue.equals("meld") ? theValue : "Fusion";
            case 3522472:
                return !theValue.equals("saga") ? theValue : "Saga";
            case 69785393:
                return !theValue.equals("leveler") ? theValue : "Monteur de Niveau";
            case 94742904:
                return !theValue.equals("class") ? theValue : "Classe";
            case 106865139:
                return !theValue.equals("double_faced_token") ? theValue : "Jeton Double Face";
            case 109648666:
                return !theValue.equals("split") ? theValue : "Carte Double";
            case 110541305:
                return !theValue.equals("token") ? theValue : "Jeton";
            case 1052666732:
                return !theValue.equals("transform") ? theValue : "Carte à Double Face Transformable";
            default:
                return theValue;
        }
    }

    public final String transformRarity(String theValue, String lang) {
        Intrinsics.checkNotNullParameter(theValue, "theValue");
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Intrinsics.areEqual(lang, "fr")) {
            int iHashCode = theValue.hashCode();
            if (iHashCode != 98) {
                if (iHashCode != 99) {
                    if (iHashCode != 109) {
                        if (iHashCode != 117) {
                            if (iHashCode != 114) {
                                if (iHashCode == 115 && theValue.equals("s")) {
                                    return "Spéciale";
                                }
                            } else if (theValue.equals("r")) {
                                return "Rare";
                            }
                        } else if (theValue.equals("u")) {
                            return "Unco";
                        }
                    } else if (theValue.equals("m")) {
                        return "Mythique";
                    }
                } else if (theValue.equals("c")) {
                    return "Commune";
                }
            } else if (theValue.equals("b")) {
                return "Bonus";
            }
        } else {
            int iHashCode2 = theValue.hashCode();
            if (iHashCode2 != 98) {
                if (iHashCode2 != 99) {
                    if (iHashCode2 != 109) {
                        if (iHashCode2 != 117) {
                            if (iHashCode2 != 114) {
                                if (iHashCode2 == 115 && theValue.equals("s")) {
                                    return "Special";
                                }
                            } else if (theValue.equals("r")) {
                                return "Rare";
                            }
                        } else if (theValue.equals("u")) {
                            return "Uncommon";
                        }
                    } else if (theValue.equals("m")) {
                        return "Mythic";
                    }
                } else if (theValue.equals("c")) {
                    return "Common";
                }
            } else if (theValue.equals("b")) {
                return "Bonus";
            }
        }
        return theValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String transformTypeLineShortcut(String theValue, String lang) {
        Intrinsics.checkNotNullParameter(theValue, "theValue");
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Intrinsics.areEqual(lang, "fr")) {
            int iHashCode = theValue.hashCode();
            if (iHashCode != 105) {
                if (iHashCode != 108) {
                    if (iHashCode != 112) {
                        if (iHashCode != 118) {
                            if (iHashCode != 3240) {
                                if (iHashCode != 3580) {
                                    if (iHashCode != 3664) {
                                        if (iHashCode != 3710) {
                                            if (iHashCode != 115) {
                                                if (iHashCode != 116) {
                                                    switch (iHashCode) {
                                                        case 97:
                                                            if (theValue.equals("a")) {
                                                                return "artefact";
                                                            }
                                                            break;
                                                        case 98:
                                                            if (theValue.equals("b")) {
                                                                return "bataille";
                                                            }
                                                            break;
                                                        case 99:
                                                            if (theValue.equals("c")) {
                                                                return "créature";
                                                            }
                                                            break;
                                                        case 100:
                                                            if (theValue.equals("d")) {
                                                                return "donjon";
                                                            }
                                                            break;
                                                        case 101:
                                                            if (theValue.equals("e")) {
                                                                return "enchantement";
                                                            }
                                                            break;
                                                    }
                                                } else if (theValue.equals("t")) {
                                                    return "jeton";
                                                }
                                            } else if (theValue.equals("s")) {
                                                return "rituel";
                                            }
                                        } else if (theValue.equals("tr")) {
                                            return "tribal";
                                        }
                                    } else if (theValue.equals("sc")) {
                                        return "machination";
                                    }
                                } else if (theValue.equals("pl")) {
                                    return "plan";
                                }
                            } else if (theValue.equals(UserDataStore.EMAIL)) {
                                return "emblème";
                            }
                        } else if (theValue.equals("v")) {
                            return "vanguard";
                        }
                    } else if (theValue.equals("p")) {
                        return "planeswalker";
                    }
                } else if (theValue.equals("l")) {
                    return "terrain";
                }
            } else if (theValue.equals("i")) {
                return "éphémère";
            }
        } else {
            int iHashCode2 = theValue.hashCode();
            if (iHashCode2 != 105) {
                if (iHashCode2 != 108) {
                    if (iHashCode2 != 112) {
                        if (iHashCode2 != 118) {
                            if (iHashCode2 != 3240) {
                                if (iHashCode2 != 3580) {
                                    if (iHashCode2 != 3664) {
                                        if (iHashCode2 != 3710) {
                                            if (iHashCode2 != 115) {
                                                if (iHashCode2 != 116) {
                                                    switch (iHashCode2) {
                                                        case 97:
                                                            if (theValue.equals("a")) {
                                                                return "artifact";
                                                            }
                                                            break;
                                                        case 98:
                                                            if (theValue.equals("b")) {
                                                                return "battle";
                                                            }
                                                            break;
                                                        case 99:
                                                            if (theValue.equals("c")) {
                                                                return "creature";
                                                            }
                                                            break;
                                                        case 100:
                                                            if (theValue.equals("d")) {
                                                                return "dungeon";
                                                            }
                                                            break;
                                                        case 101:
                                                            if (theValue.equals("e")) {
                                                                return "enchantment";
                                                            }
                                                            break;
                                                    }
                                                } else if (theValue.equals("t")) {
                                                    return "token";
                                                }
                                            } else if (theValue.equals("s")) {
                                                return "sorcery";
                                            }
                                        } else if (theValue.equals("tr")) {
                                            return "tribal";
                                        }
                                    } else if (theValue.equals("sc")) {
                                        return "scheme";
                                    }
                                } else if (theValue.equals("pl")) {
                                    return "plane";
                                }
                            } else if (theValue.equals(UserDataStore.EMAIL)) {
                                return "emblem";
                            }
                        } else if (theValue.equals("v")) {
                            return "vanguard";
                        }
                    } else if (theValue.equals("p")) {
                        return "planeswalker";
                    }
                } else if (theValue.equals("l")) {
                    return "land";
                }
            } else if (theValue.equals("i")) {
                return "instant";
            }
        }
        return theValue;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String translateTag(String tag, String lang) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Intrinsics.areEqual(lang, "en")) {
            return tag;
        }
        if (Intrinsics.areEqual(lang, "fr")) {
            switch (tag.hashCode()) {
                case -2081562821:
                    return !tag.equals("legendary") ? tag : "légendaire";
                case -2025091905:
                    return !tag.equals("sorcery") ? tag : "rituel";
                case -1396158280:
                    return !tag.equals("battle") ? tag : "bataille";
                case -1365355166:
                    return !tag.equals("vanguard") ? tag : "vanguard";
                case -1332194002:
                    return !tag.equals("background") ? tag : "passé";
                case -1326477025:
                    return !tag.equals("doctor") ? tag : "docteur";
                case -1299732710:
                    return !tag.equals("emblem") ? tag : "emblème";
                case -1228798510:
                    return !tag.equals("artifact") ? tag : "artefact";
                case -982749432:
                    return !tag.equals("poison") ? tag : "poison";
                case -907987547:
                    return !tag.equals("scheme") ? tag : "machination";
                case -865479038:
                    return !tag.equals("tribal") ? tag : "tribal";
                case 3314155:
                    return !tag.equals("land") ? tag : "terrain";
                case 3535235:
                    return !tag.equals("snow") ? tag : "neigeux";
                case 55374989:
                    return !tag.equals("planeswalker") ? tag : "planeswalker";
                case 93508654:
                    return !tag.equals("basic") ? tag : "base";
                case 106748508:
                    return !tag.equals("plane") ? tag : "plan";
                case 110541305:
                    return !tag.equals("token") ? tag : "jeton";
                case 222399799:
                    return !tag.equals("enchantment") ? tag : "enchantement";
                case 342069036:
                    return !tag.equals("vehicle") ? tag : "véhicule";
                case 508241114:
                    return !tag.equals("spacecraft") ? tag : "vaisseau";
                case 515923895:
                    return !tag.equals("doctor's companion") ? tag : "compagnon du docteur";
                case 957830652:
                    return !tag.equals("counter") ? tag : "marqueur";
                case 1820433471:
                    return tag.equals("creature") ? "créature" : tag;
                case 1957570017:
                    return !tag.equals("instant") ? tag : "Éphémère";
                case 2010421946:
                    return !tag.equals("dungeon") ? tag : "donjon";
                default:
                    return tag;
            }
        }
        if (Intrinsics.areEqual(lang, "es")) {
            switch (tag.hashCode()) {
                case -2081562821:
                    return !tag.equals("legendary") ? tag : "legendario";
                case -2025091905:
                    return !tag.equals("sorcery") ? tag : "conjuro";
                case -1396158280:
                    return !tag.equals("battle") ? tag : "batalla";
                case -1365355166:
                    return !tag.equals("vanguard") ? tag : "vanguard";
                case -1299732710:
                    return !tag.equals("emblem") ? tag : "emblem";
                case -1228798510:
                    return !tag.equals("artifact") ? tag : "artefacto";
                case -982749432:
                    return !tag.equals("poison") ? tag : "veneno";
                case -907987547:
                    return !tag.equals("scheme") ? tag : "scheme";
                case -865479038:
                    return !tag.equals("tribal") ? tag : "tribal";
                case 3314155:
                    return !tag.equals("land") ? tag : "tierra";
                case 3535235:
                    return !tag.equals("snow") ? tag : "nevada";
                case 55374989:
                    return !tag.equals("planeswalker") ? tag : "planeswalker";
                case 93508654:
                    return !tag.equals("basic") ? tag : "básica";
                case 106748508:
                    return !tag.equals("plane") ? tag : "plano";
                case 110541305:
                    return !tag.equals("token") ? tag : "ficha";
                case 222399799:
                    return !tag.equals("enchantment") ? tag : "encantamiento";
                case 957830652:
                    return !tag.equals("counter") ? tag : "contador";
                case 1820433471:
                    return tag.equals("creature") ? "criatura" : tag;
                case 1957570017:
                    return !tag.equals("instant") ? tag : "instantáneo";
                case 2010421946:
                    return !tag.equals("dungeon") ? tag : "mazmorra";
                default:
                    return tag;
            }
        }
        if (Intrinsics.areEqual(lang, "de")) {
            switch (tag.hashCode()) {
                case -2081562821:
                    return !tag.equals("legendary") ? tag : "legendäre";
                case -2025091905:
                    return !tag.equals("sorcery") ? tag : "hexerei";
                case -1396158280:
                    return !tag.equals("battle") ? tag : "schlacht";
                case -1365355166:
                    return !tag.equals("vanguard") ? tag : "vanguard";
                case -1299732710:
                    return !tag.equals("emblem") ? tag : "emblem";
                case -1228798510:
                    return !tag.equals("artifact") ? tag : "artefakt";
                case -982749432:
                    return !tag.equals("poison") ? tag : "gift";
                case -907987547:
                    return !tag.equals("scheme") ? tag : "machination";
                case -865479038:
                    return !tag.equals("tribal") ? tag : "tribal";
                case 3314155:
                    return !tag.equals("land") ? tag : "land";
                case 3535235:
                    return !tag.equals("snow") ? tag : "verschneites";
                case 55374989:
                    return !tag.equals("planeswalker") ? tag : "planeswalker";
                case 93508654:
                    return !tag.equals("basic") ? tag : "standard";
                case 106748508:
                    return !tag.equals("plane") ? tag : "welt";
                case 110541305:
                    return !tag.equals("token") ? tag : "speilstein";
                case 222399799:
                    return !tag.equals("enchantment") ? tag : "verzauberung";
                case 957830652:
                    return !tag.equals("counter") ? tag : "marken";
                case 1820433471:
                    return tag.equals("creature") ? "kreatur" : tag;
                case 1957570017:
                    return !tag.equals("instant") ? tag : "spontanzauber";
                case 2010421946:
                    return !tag.equals("dungeon") ? tag : "gewölbe";
                default:
                    return tag;
            }
        }
        if (Intrinsics.areEqual(lang, "it")) {
            switch (tag.hashCode()) {
                case -2081562821:
                    return !tag.equals("legendary") ? tag : "leggendaria";
                case -2025091905:
                    return !tag.equals("sorcery") ? tag : "stregoneria";
                case -1396158280:
                    return !tag.equals("battle") ? tag : "battaglia";
                case -1365355166:
                    return !tag.equals("vanguard") ? tag : "vanguard";
                case -1299732710:
                    return !tag.equals("emblem") ? tag : "emblema";
                case -1228798510:
                    return !tag.equals("artifact") ? tag : "artefatto";
                case -982749432:
                    return !tag.equals("poison") ? tag : "veleno";
                case -907987547:
                    return !tag.equals("scheme") ? tag : "scheme";
                case -865479038:
                    return !tag.equals("tribal") ? tag : "tribal";
                case 3314155:
                    return !tag.equals("land") ? tag : "terra";
                case 3535235:
                    return !tag.equals("snow") ? tag : "neve";
                case 55374989:
                    return !tag.equals("planeswalker") ? tag : "planeswalker";
                case 93508654:
                    return !tag.equals("basic") ? tag : "base";
                case 106748508:
                    return !tag.equals("plane") ? tag : "plano";
                case 110541305:
                    return !tag.equals("token") ? tag : "pedina";
                case 222399799:
                    return !tag.equals("enchantment") ? tag : "incantesimo";
                case 957830652:
                    return !tag.equals("counter") ? tag : "segnalin";
                case 1820433471:
                    return tag.equals("creature") ? "creatura" : tag;
                case 1957570017:
                    return !tag.equals("instant") ? tag : "istantaneo";
                case 2010421946:
                    return !tag.equals("dungeon") ? tag : "dungeon";
                default:
                    return tag;
            }
        }
        if (!Intrinsics.areEqual(lang, "pt")) {
            return tag;
        }
        switch (tag.hashCode()) {
            case -2081562821:
                return !tag.equals("legendary") ? tag : "lendária";
            case -2025091905:
                return !tag.equals("sorcery") ? tag : "feitiço";
            case -1396158280:
                return !tag.equals("battle") ? tag : "batalha";
            case -1365355166:
                return !tag.equals("vanguard") ? tag : "vanguard";
            case -1299732710:
                return !tag.equals("emblem") ? tag : "emblema";
            case -1228798510:
                return !tag.equals("artifact") ? tag : "artefato";
            case -982749432:
                return !tag.equals("poison") ? tag : "veneno";
            case -907987547:
                return !tag.equals("scheme") ? tag : "scheme";
            case -865479038:
                return !tag.equals("tribal") ? tag : "tribal";
            case 3314155:
                return !tag.equals("land") ? tag : "terreno";
            case 3535235:
                return !tag.equals("snow") ? tag : "neve";
            case 55374989:
                return !tag.equals("planeswalker") ? tag : "planeswalker";
            case 93508654:
                return !tag.equals("basic") ? tag : "básico";
            case 106748508:
                return !tag.equals("plane") ? tag : "plano";
            case 110541305:
                return !tag.equals("token") ? tag : "pedina";
            case 222399799:
                return !tag.equals("enchantment") ? tag : "encantamento";
            case 957830652:
                return !tag.equals("counter") ? tag : "marcador";
            case 1820433471:
                return tag.equals("creature") ? "criatura" : tag;
            case 1957570017:
                return !tag.equals("instant") ? tag : "instantânea";
            case 2010421946:
                return !tag.equals("dungeon") ? tag : "masmorra";
            default:
                return tag;
        }
    }
}
