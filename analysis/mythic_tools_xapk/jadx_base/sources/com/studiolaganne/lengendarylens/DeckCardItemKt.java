package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.studiolaganne.lengendarylens.DeckCardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckCardItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u001a\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n\u001a\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\n\u001a\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\n¨\u0006\u0016"}, d2 = {"toDeckCardItems", "", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "displayMode", "Lcom/studiolaganne/lengendarylens/DeckDisplayMode;", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "expandedCards", "", "", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "isThemeMode", "getCardTypeNameString", "context", "Landroid/content/Context;", "cardType", "shouldTintIconForCardType", "getCardTypeIconResource", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeckCardItemKt {

    /* JADX INFO: compiled from: DeckCardItem.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeckDisplayMode.values().length];
            try {
                iArr[DeckDisplayMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckDisplayMode.ONE_COLUMN_STACKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckDisplayMode.TWO_COLUMN_STACKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0137, code lost:
    
        if (r1.equals("instant") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0141, code lost:
    
        if (r1.equals("creature") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x014b, code lost:
    
        if (r1.equals("planeswalkers") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0162, code lost:
    
        if (r1.equals("commanders") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x016c, code lost:
    
        if (r1.equals("creatures") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0172, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_creature;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0179, code lost:
    
        if (r1.equals("artifacts") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0183, code lost:
    
        if (r1.equals("instants") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0189, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_instant;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0190, code lost:
    
        if (r1.equals("enchantment") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01a8, code lost:
    
        if (r1.equals("lands") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01cc, code lost:
    
        if (r1.equals("planeswalker") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01d2, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_planeswalker;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01e6, code lost:
    
        if (r1.equals("land") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01ec, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_land;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x020d, code lost:
    
        if (r1.equals("battles") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0225, code lost:
    
        if (r1.equals("sorceries") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x022f, code lost:
    
        if (r1.equals("companions") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0246, code lost:
    
        if (r1.equals("artifact") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x024b, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_artifact;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x026a, code lost:
    
        if (r1.equals("battle") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x026f, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_battle;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0276, code lost:
    
        if (r1.equals("companion") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x027b, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.set_iko;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0282, code lost:
    
        if (r1.equals("commander") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0287, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_commander;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x028e, code lost:
    
        if (r1.equals("enchantments") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0293, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_enchantment;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x02a6, code lost:
    
        if (r1.equals("sorcery") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x02ad, code lost:
    
        return com.studiolaganne.lengendarylens.R.drawable.type_sorcery;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getCardTypeIconResource(String cardType) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        String lowerCase = cardType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        switch (iHashCode) {
            case -2025091905:
                break;
            case -2008465223:
                if (lowerCase.equals("special")) {
                    return R.drawable.rarity_special;
                }
                return R.drawable.type_unknown;
            case -1695540708:
                break;
            case -1498725064:
                break;
            case -1412832500:
                break;
            case -1396158280:
                break;
            case -1356975356:
                if (lowerCase.equals("cmc_20")) {
                    return R.drawable.symbol_20;
                }
                return R.drawable.type_unknown;
            case -1354814997:
                if (lowerCase.equals("common")) {
                    return R.drawable.rarity_common;
                }
                return R.drawable.type_unknown;
            case -1228798510:
                break;
            case -1059084742:
                if (lowerCase.equals("mythic")) {
                    return R.drawable.rarity_mythic;
                }
                return R.drawable.type_unknown;
            case -848134425:
                break;
            case -493147747:
                break;
            case -468311612:
                if (lowerCase.equals("uncommon")) {
                    return R.drawable.rarity_uncommon;
                }
                return R.drawable.type_unknown;
            case -331233605:
                break;
            case 112785:
                if (lowerCase.equals("red")) {
                    return R.drawable.symbol_r;
                }
                return R.drawable.type_unknown;
            case 3027034:
                if (lowerCase.equals("blue")) {
                    return R.drawable.symbol_u;
                }
                return R.drawable.type_unknown;
            case 3314155:
                break;
            case 3493026:
                if (lowerCase.equals("rare")) {
                    return R.drawable.rarity_rare;
                }
                return R.drawable.type_unknown;
            case 55374989:
                break;
            case 93818879:
                if (lowerCase.equals(PreferencesManager.BACKGROUND_BLACK)) {
                    return R.drawable.symbol_b;
                }
                return R.drawable.type_unknown;
            case 98619139:
                if (lowerCase.equals("green")) {
                    return R.drawable.symbol_g;
                }
                return R.drawable.type_unknown;
            case 102738920:
                break;
            case 113101865:
                if (lowerCase.equals("white")) {
                    return R.drawable.symbol_w;
                }
                return R.drawable.type_unknown;
            case 222399799:
                break;
            case 555128498:
                break;
            case 561951969:
                break;
            case 598862868:
                break;
            case 784163387:
                break;
            case 1253160394:
                if (lowerCase.equals("multicolor")) {
                    return R.drawable.symbol_wu;
                }
                return R.drawable.type_unknown;
            case 1716624774:
                break;
            case 1820433471:
                break;
            case 1957570017:
                break;
            case 1981638524:
                if (lowerCase.equals("colorless")) {
                    return R.drawable.symbol_c;
                }
                return R.drawable.type_unknown;
            default:
                switch (iHashCode) {
                    case -1356975387:
                        if (lowerCase.equals("cmc_10")) {
                            return R.drawable.symbol_10;
                        }
                        break;
                    case -1356975386:
                        if (lowerCase.equals("cmc_11")) {
                            return R.drawable.symbol_11;
                        }
                        break;
                    case -1356975385:
                        if (lowerCase.equals("cmc_12")) {
                            return R.drawable.symbol_12;
                        }
                        break;
                    case -1356975384:
                        if (lowerCase.equals("cmc_13")) {
                            return R.drawable.symbol_13;
                        }
                        break;
                    case -1356975383:
                        if (lowerCase.equals("cmc_14")) {
                            return R.drawable.symbol_14;
                        }
                        break;
                    case -1356975382:
                        if (lowerCase.equals("cmc_15")) {
                            return R.drawable.symbol_15;
                        }
                        break;
                    case -1356975381:
                        if (lowerCase.equals("cmc_16")) {
                            return R.drawable.symbol_16;
                        }
                        break;
                    case -1356975380:
                        if (lowerCase.equals("cmc_17")) {
                            return R.drawable.symbol_17;
                        }
                        break;
                    case -1356975379:
                        if (lowerCase.equals("cmc_18")) {
                            return R.drawable.symbol_18;
                        }
                        break;
                    case -1356975378:
                        if (lowerCase.equals("cmc_19")) {
                            return R.drawable.symbol_19;
                        }
                        break;
                    default:
                        switch (iHashCode) {
                            case 94773930:
                                if (lowerCase.equals("cmc_0")) {
                                    return R.drawable.symbol_0;
                                }
                                break;
                            case 94773931:
                                if (lowerCase.equals("cmc_1")) {
                                    return R.drawable.symbol_1;
                                }
                                break;
                            case 94773932:
                                if (lowerCase.equals("cmc_2")) {
                                    return R.drawable.symbol_2;
                                }
                                break;
                            case 94773933:
                                if (lowerCase.equals("cmc_3")) {
                                    return R.drawable.symbol_3;
                                }
                                break;
                            case 94773934:
                                if (lowerCase.equals("cmc_4")) {
                                    return R.drawable.symbol_4;
                                }
                                break;
                            case 94773935:
                                if (lowerCase.equals("cmc_5")) {
                                    return R.drawable.symbol_5;
                                }
                                break;
                            case 94773936:
                                if (lowerCase.equals("cmc_6")) {
                                    return R.drawable.symbol_6;
                                }
                                break;
                            case 94773937:
                                if (lowerCase.equals("cmc_7")) {
                                    return R.drawable.symbol_7;
                                }
                                break;
                            case 94773938:
                                if (lowerCase.equals("cmc_8")) {
                                    return R.drawable.symbol_8;
                                }
                                break;
                            case 94773939:
                                if (lowerCase.equals("cmc_9")) {
                                    return R.drawable.symbol_9;
                                }
                                break;
                        }
                        break;
                }
                return R.drawable.type_unknown;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01bd, code lost:
    
        if (r0.equals("dungeon") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01db, code lost:
    
        if (r0.equals("instant") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e5, code lost:
    
        if (r0.equals("schemes") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01ef, code lost:
    
        if (r0.equals("creature") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01f9, code lost:
    
        if (r0.equals("planeswalkers") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0217, code lost:
    
        if (r0.equals("commanders") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0222, code lost:
    
        if (r0.equals("vanguards") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x022c, code lost:
    
        if (r0.equals("creatures") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0230, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_creature);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0239, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0240, code lost:
    
        if (r0.equals("artifacts") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x024a, code lost:
    
        if (r0.equals("instants") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x024e, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_instant);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0257, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x025e, code lost:
    
        if (r0.equals("enchantment") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0268, code lost:
    
        if (r0.equals("conspiracies") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0287, code lost:
    
        if (r0.equals("plane") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0291, code lost:
    
        if (r0.equals("lands") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02c3, code lost:
    
        if (r0.equals("planeswalker") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02c7, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_planeswalker);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02d0, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02eb, code lost:
    
        if (r0.equals("land") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x02ef, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_land);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02f8, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0327, code lost:
    
        if (r0.equals("conspiracy") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x032b, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_conspiracy);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0334, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x033b, code lost:
    
        if (r0.equals("battles") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x035a, code lost:
    
        if (r0.equals("sorceries") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0378, code lost:
    
        if (r0.equals("companions") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0382, code lost:
    
        if (r0.equals("scheme") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0386, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_scheme);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x038f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0396, code lost:
    
        if (r0.equals("planes") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x039a, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_plane);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x03a3, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x03be, code lost:
    
        if (r0.equals("artifact") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x03c2, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_artifact);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03cb, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03d2, code lost:
    
        if (r0.equals("phenomena") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0405, code lost:
    
        if (r0.equals("vanguard") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0409, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_vanguard);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0412, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0419, code lost:
    
        if (r0.equals("battle") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x041d, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_battle);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0426, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x042d, code lost:
    
        if (r0.equals("companion") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0431, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_companion);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x043a, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0441, code lost:
    
        if (r0.equals("commander") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0444, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_commander);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x044d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0454, code lost:
    
        if (r0.equals("enchantments") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0457, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_enchantment);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0460, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0467, code lost:
    
        if (r0.equals("phenomenon") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x046a, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_phenomenon);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0473, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x048d, code lost:
    
        if (r0.equals("sorcery") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0490, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_sorcery);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0499, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x04a0, code lost:
    
        if (r0.equals("dungeons") == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0545, code lost:
    
        r5 = r5.getString(com.studiolaganne.lengendarylens.R.string.type_dungeon);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x054e, code lost:
    
        return r5;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0536 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getCardTypeNameString(Context context, String cardType) {
        List<CardSet> cardSets;
        String deviceLanguage;
        Iterator<T> it;
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        String lowerCase = cardType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        switch (iHashCode) {
            case -2101428999:
                break;
            case -2025091905:
                break;
            case -2008465223:
                if (lowerCase.equals("special")) {
                    String string = context.getString(R.string.special);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                    String script = Locale.getDefault().getScript();
                    deviceLanguage = Intrinsics.areEqual(script, "Hans") ? "zhs" : Intrinsics.areEqual(script, "Hant") ? "zht" : "zh";
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en") && !Intrinsics.areEqual(deviceLanguage, "fr")) {
                    deviceLanguage = "en";
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr") && !CardSetsManager.INSTANCE.getFrCardSets().isEmpty()) {
                    cardSets = CardSetsManager.INSTANCE.getFrCardSets();
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        String lowerCase2 = ((CardSet) next).getCode().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        String lowerCase3 = cardType.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase2, lowerCase3)) {
                        }
                    } else {
                        next = null;
                    }
                }
                CardSet cardSet = (CardSet) next;
                return cardSet != null ? cardSet.getName() : StringsKt.capitalize(cardType);
            case -1773387001:
                break;
            case -1695540708:
                break;
            case -1498725064:
                break;
            case -1412832500:
                break;
            case -1396158280:
                break;
            case -1365355166:
                break;
            case -1356975356:
                if (lowerCase.equals("cmc_20")) {
                    String string2 = context.getString(R.string.cmc_20);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                    deviceLanguage = "en";
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                    cardSets = CardSetsManager.INSTANCE.getFrCardSets();
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet2 = (CardSet) next;
                if (cardSet2 != null) {
                }
                break;
            case -1354814997:
                if (lowerCase.equals("common")) {
                    String string3 = context.getString(R.string.common);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return string3;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet22 = (CardSet) next;
                if (cardSet22 != null) {
                }
                break;
            case -1304132039:
                break;
            case -1228798510:
                break;
            case -1059084742:
                if (lowerCase.equals("mythic")) {
                    String string4 = context.getString(R.string.mythic);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    return string4;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet222 = (CardSet) next;
                if (cardSet222 != null) {
                }
                break;
            case -985763433:
                break;
            case -907987547:
                break;
            case -848134425:
                break;
            case -710613891:
                if (lowerCase.equals("kindred")) {
                    String string5 = context.getString(R.string.type_kindred);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet2222 = (CardSet) next;
                if (cardSet2222 != null) {
                }
                break;
            case -493147747:
                break;
            case -468311612:
                if (lowerCase.equals("uncommon")) {
                    String string6 = context.getString(R.string.uncommon);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet22222 = (CardSet) next;
                if (cardSet22222 != null) {
                }
                break;
            case -331233605:
                break;
            case -312706353:
                break;
            case 112785:
                if (lowerCase.equals("red")) {
                    String string7 = context.getString(R.string.color_red);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet222222 = (CardSet) next;
                if (cardSet222222 != null) {
                }
                break;
            case 3027034:
                if (lowerCase.equals("blue")) {
                    String string8 = context.getString(R.string.color_blue);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return string8;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet2222222 = (CardSet) next;
                if (cardSet2222222 != null) {
                }
                break;
            case 3314155:
                break;
            case 3493026:
                if (lowerCase.equals("rare")) {
                    String string9 = context.getString(R.string.rare);
                    Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                    return string9;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet22222222 = (CardSet) next;
                if (cardSet22222222 != null) {
                }
                break;
            case 55374989:
                break;
            case 93818879:
                if (lowerCase.equals(PreferencesManager.BACKGROUND_BLACK)) {
                    String string10 = context.getString(R.string.color_black);
                    Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                    return string10;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet222222222 = (CardSet) next;
                if (cardSet222222222 != null) {
                }
                break;
            case 98619139:
                if (lowerCase.equals("green")) {
                    String string11 = context.getString(R.string.color_green);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return string11;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet2222222222 = (CardSet) next;
                if (cardSet2222222222 != null) {
                }
                break;
            case 102738920:
                break;
            case 106748508:
                break;
            case 113101865:
                if (lowerCase.equals("white")) {
                    String string12 = context.getString(R.string.color_white);
                    Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                    return string12;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet22222222222 = (CardSet) next;
                if (cardSet22222222222 != null) {
                }
                break;
            case 136893357:
                break;
            case 222399799:
                break;
            case 555128498:
                break;
            case 561951969:
                break;
            case 598862868:
                break;
            case 623662929:
                break;
            case 784163387:
                break;
            case 1253160394:
                if (lowerCase.equals("multicolor")) {
                    String string13 = context.getString(R.string.color_multicolor);
                    Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                    return string13;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet222222222222 = (CardSet) next;
                if (cardSet222222222222 != null) {
                }
                break;
            case 1716624774:
                break;
            case 1820433471:
                break;
            case 1917157230:
                break;
            case 1957570017:
                break;
            case 1981638524:
                if (lowerCase.equals("colorless")) {
                    String string14 = context.getString(R.string.color_colorless);
                    Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                    return string14;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet2222222222222 = (CardSet) next;
                if (cardSet2222222222222 != null) {
                }
                break;
            case 2010421946:
                break;
            default:
                switch (iHashCode) {
                    case -1356975387:
                        if (lowerCase.equals("cmc_10")) {
                            String string15 = context.getString(R.string.cmc_10);
                            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                            return string15;
                        }
                        break;
                    case -1356975386:
                        if (lowerCase.equals("cmc_11")) {
                            String string16 = context.getString(R.string.cmc_11);
                            Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                            return string16;
                        }
                        break;
                    case -1356975385:
                        if (lowerCase.equals("cmc_12")) {
                            String string17 = context.getString(R.string.cmc_12);
                            Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                            return string17;
                        }
                        break;
                    case -1356975384:
                        if (lowerCase.equals("cmc_13")) {
                            String string18 = context.getString(R.string.cmc_13);
                            Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                            return string18;
                        }
                        break;
                    case -1356975383:
                        if (lowerCase.equals("cmc_14")) {
                            String string19 = context.getString(R.string.cmc_14);
                            Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                            return string19;
                        }
                        break;
                    case -1356975382:
                        if (lowerCase.equals("cmc_15")) {
                            String string20 = context.getString(R.string.cmc_15);
                            Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
                            return string20;
                        }
                        break;
                    case -1356975381:
                        if (lowerCase.equals("cmc_16")) {
                            String string21 = context.getString(R.string.cmc_16);
                            Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
                            return string21;
                        }
                        break;
                    case -1356975380:
                        if (lowerCase.equals("cmc_17")) {
                            String string22 = context.getString(R.string.cmc_17);
                            Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                            return string22;
                        }
                        break;
                    case -1356975379:
                        if (lowerCase.equals("cmc_18")) {
                            String string23 = context.getString(R.string.cmc_18);
                            Intrinsics.checkNotNullExpressionValue(string23, "getString(...)");
                            return string23;
                        }
                        break;
                    case -1356975378:
                        if (lowerCase.equals("cmc_19")) {
                            String string24 = context.getString(R.string.cmc_19);
                            Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
                            return string24;
                        }
                        break;
                    default:
                        switch (iHashCode) {
                            case 94773930:
                                if (lowerCase.equals("cmc_0")) {
                                    String string25 = context.getString(R.string.cmc_0);
                                    Intrinsics.checkNotNullExpressionValue(string25, "getString(...)");
                                    return string25;
                                }
                                break;
                            case 94773931:
                                if (lowerCase.equals("cmc_1")) {
                                    String string26 = context.getString(R.string.cmc_1);
                                    Intrinsics.checkNotNullExpressionValue(string26, "getString(...)");
                                    return string26;
                                }
                                break;
                            case 94773932:
                                if (lowerCase.equals("cmc_2")) {
                                    String string27 = context.getString(R.string.cmc_2);
                                    Intrinsics.checkNotNullExpressionValue(string27, "getString(...)");
                                    return string27;
                                }
                                break;
                            case 94773933:
                                if (lowerCase.equals("cmc_3")) {
                                    String string28 = context.getString(R.string.cmc_3);
                                    Intrinsics.checkNotNullExpressionValue(string28, "getString(...)");
                                    return string28;
                                }
                                break;
                            case 94773934:
                                if (lowerCase.equals("cmc_4")) {
                                    String string29 = context.getString(R.string.cmc_4);
                                    Intrinsics.checkNotNullExpressionValue(string29, "getString(...)");
                                    return string29;
                                }
                                break;
                            case 94773935:
                                if (lowerCase.equals("cmc_5")) {
                                    String string30 = context.getString(R.string.cmc_5);
                                    Intrinsics.checkNotNullExpressionValue(string30, "getString(...)");
                                    return string30;
                                }
                                break;
                            case 94773936:
                                if (lowerCase.equals("cmc_6")) {
                                    String string31 = context.getString(R.string.cmc_6);
                                    Intrinsics.checkNotNullExpressionValue(string31, "getString(...)");
                                    return string31;
                                }
                                break;
                            case 94773937:
                                if (lowerCase.equals("cmc_7")) {
                                    String string32 = context.getString(R.string.cmc_7);
                                    Intrinsics.checkNotNullExpressionValue(string32, "getString(...)");
                                    return string32;
                                }
                                break;
                            case 94773938:
                                if (lowerCase.equals("cmc_8")) {
                                    String string33 = context.getString(R.string.cmc_8);
                                    Intrinsics.checkNotNullExpressionValue(string33, "getString(...)");
                                    return string33;
                                }
                                break;
                            case 94773939:
                                if (lowerCase.equals("cmc_9")) {
                                    String string34 = context.getString(R.string.cmc_9);
                                    Intrinsics.checkNotNullExpressionValue(string34, "getString(...)");
                                    return string34;
                                }
                                break;
                        }
                        break;
                }
                cardSets = CardSetsManager.INSTANCE.getCardSets();
                deviceLanguage = new PreferencesManager(context).getDeviceLanguage();
                if (Intrinsics.areEqual(deviceLanguage, "zh")) {
                }
                if (!Intrinsics.areEqual(deviceLanguage, "en")) {
                }
                if (Intrinsics.areEqual(deviceLanguage, "fr")) {
                }
                it = cardSets.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                CardSet cardSet22222222222222 = (CardSet) next;
                if (cardSet22222222222222 != null) {
                }
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean shouldTintIconForCardType(String cardType) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        String lowerCase = cardType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -2025091905:
                if (!lowerCase.equals("sorcery")) {
                }
                break;
            case -1695540708:
                if (!lowerCase.equals("enchantments")) {
                }
                break;
            case -1498725064:
                if (!lowerCase.equals("commander")) {
                }
                break;
            case -1412832500:
                if (!lowerCase.equals("companion")) {
                }
                break;
            case -1396158280:
                if (!lowerCase.equals("battle")) {
                }
                break;
            case -1228798510:
                if (!lowerCase.equals("artifact")) {
                }
                break;
            case -848134425:
                if (!lowerCase.equals("companions")) {
                }
                break;
            case -493147747:
                if (!lowerCase.equals("sorceries")) {
                }
                break;
            case -331233605:
                if (!lowerCase.equals("battles")) {
                }
                break;
            case 3314155:
                if (!lowerCase.equals("land")) {
                }
                break;
            case 55374989:
                if (!lowerCase.equals("planeswalker")) {
                }
                break;
            case 102738920:
                if (!lowerCase.equals("lands")) {
                }
                break;
            case 222399799:
                if (!lowerCase.equals("enchantment")) {
                }
                break;
            case 555128498:
                if (!lowerCase.equals("instants")) {
                }
                break;
            case 561951969:
                if (!lowerCase.equals("artifacts")) {
                }
                break;
            case 598862868:
                if (!lowerCase.equals("creatures")) {
                }
                break;
            case 784163387:
                if (!lowerCase.equals("commanders")) {
                }
                break;
            case 1716624774:
                if (!lowerCase.equals("planeswalkers")) {
                }
                break;
            case 1820433471:
                if (!lowerCase.equals("creature")) {
                }
                break;
            case 1957570017:
                if (!lowerCase.equals("instant")) {
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<DeckCardItem> toDeckCardItems(MTCardGroup mTCardGroup, DeckDisplayMode displayMode, MTCardContainer mTCardContainer, Map<String, Boolean> expandedCards, MTDeck mTDeck, boolean z) {
        List<MTListError> listEmptyList;
        boolean z2;
        MTCardError mTCardError;
        boolean z3;
        boolean z4;
        String cardid;
        MTCardError mTCardError2;
        Object next;
        List<MTListError> listEmptyList2;
        Intrinsics.checkNotNullParameter(mTCardGroup, "<this>");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(expandedCards, "expandedCards");
        ArrayList arrayList = new ArrayList();
        boolean z5 = StringsKt.equals(mTCardGroup.getType(), "commander", true) || StringsKt.equals(mTCardGroup.getType(), "commanders", true);
        arrayList.add(new DeckCardItem.SectionHeader(mTCardGroup.getType(), mTCardGroup.getCount(), mTCardGroup.getTotal_count(), z));
        List<MTFullCard> cards = mTCardGroup.getCards();
        if (cards != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[displayMode.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                List listEmptyList3 = CollectionsKt.emptyList();
                if (mTCardContainer == null || (listEmptyList2 = mTCardContainer.getErrors()) == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                arrayList.add(new DeckCardItem.StacksGroup(cards, listEmptyList3, listEmptyList2, z5 ? mTDeck : null, z ? mTCardGroup.getType() : null));
                return arrayList;
            }
            for (MTFullCard mTFullCard : cards) {
                if (mTCardContainer == null || (listEmptyList = mTCardContainer.getErrors()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Iterator<MTListError> it = listEmptyList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        mTCardError = null;
                        break;
                    }
                    MTListError next2 = it.next();
                    List<String> problematic_cards = next2.getProblematic_cards();
                    if (problematic_cards != null ? CollectionsKt.contains(problematic_cards, mTFullCard.getCardid()) : false) {
                        List<MTCardError> cards2 = next2.getCards();
                        if (cards2 != null) {
                            Iterator<T> it2 = cards2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                if (Intrinsics.areEqual(((MTCardError) next).getCardid(), mTFullCard.getCardid())) {
                                    break;
                                }
                            }
                            mTCardError2 = (MTCardError) next;
                        } else {
                            mTCardError2 = null;
                        }
                        z2 = true;
                        mTCardError = mTCardError2;
                    }
                }
                if (z5) {
                    String oracleid = mTFullCard.getOracleid();
                    if (oracleid != null && GameUtilsKt.getColorChoosingCommanders().contains(oracleid)) {
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                arrayList.add(new DeckCardItem.ListCard(mTFullCard, z2, mTCardError, z3, toDeckCardItems$colorOverrideForCard(z5, mTDeck, mTFullCard), z ? mTCardGroup.getType() : null));
                if (mTFullCard.getVariants() != null) {
                    List<MTFullCard> variants = mTFullCard.getVariants();
                    Intrinsics.checkNotNull(variants);
                    if (variants.isEmpty()) {
                        if (mTFullCard.getVariant_quantity() != null) {
                            Integer variant_quantity = mTFullCard.getVariant_quantity();
                            Intrinsics.checkNotNull(variant_quantity);
                            z4 = variant_quantity.intValue() > 0;
                        }
                    }
                }
                Integer list_card_id = mTFullCard.getList_card_id();
                if ((list_card_id == null || (cardid = String.valueOf(list_card_id.intValue())) == null) && (cardid = mTFullCard.getCardid()) == null) {
                    cardid = "";
                }
                boolean zAreEqual = Intrinsics.areEqual((Object) expandedCards.get(cardid), (Object) true);
                if (z4 && zAreEqual) {
                    String type = z ? mTCardGroup.getType() : null;
                    Integer variant_quantity2 = mTFullCard.getVariant_quantity();
                    if (variant_quantity2 != null && variant_quantity2.intValue() > 0) {
                        arrayList.add(new DeckCardItem.VariantCard(mTFullCard, mTFullCard, type));
                    }
                    List<MTFullCard> variants2 = mTFullCard.getVariants();
                    if (variants2 != null) {
                        Iterator<T> it3 = variants2.iterator();
                        while (it3.hasNext()) {
                            arrayList.add(new DeckCardItem.VariantCard((MTFullCard) it3.next(), mTFullCard, type));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static final String toDeckCardItems$colorOverrideForCard(boolean z, MTDeck mTDeck, MTFullCard mTFullCard) {
        if (z && mTDeck != null) {
            Integer flag = mTFullCard.getFlag();
            if (flag != null && flag.intValue() == 1) {
                return mTDeck.getCommander_color_override();
            }
            Integer flag2 = mTFullCard.getFlag();
            if (flag2 != null && flag2.intValue() == 2) {
                return mTDeck.getPartner_color_override();
            }
        }
        return null;
    }

    public static /* synthetic */ List toDeckCardItems$default(MTCardGroup mTCardGroup, DeckDisplayMode deckDisplayMode, MTCardContainer mTCardContainer, Map map, MTDeck mTDeck, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            mTDeck = null;
        }
        MTDeck mTDeck2 = mTDeck;
        if ((i & 16) != 0) {
            z = false;
        }
        return toDeckCardItems(mTCardGroup, deckDisplayMode, mTCardContainer, map2, mTDeck2, z);
    }
}
