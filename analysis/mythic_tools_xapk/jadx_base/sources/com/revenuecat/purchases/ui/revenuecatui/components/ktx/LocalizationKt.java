package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.caverock.androidsvg.SVGParser;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: Localization.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\b\u001a\u0004\u0018\u00010\n*\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000f\u001a:\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aX\u0010\u001b\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001a\u001a:\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010\u001a\u001aX\u0010!\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001a\u001a\u0016\u0010#\u001a\u00020$*\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\f\u0010#\u001a\u00020$*\u00020\u0005H\u0000\u001a\f\u0010'\u001a\u00020\u0005*\u00020$H\u0000\u001a\u0016\u0010'\u001a\u00020\u0005*\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0011\u0010*\u001a\u00020\n*\u00020$H\u0000¢\u0006\u0002\u0010+\u001a\u0011\u0010*\u001a\u00020\n*\u00020\u0005H\u0000¢\u0006\u0002\u0010,\u001a:\u0010-\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u0010\u001a\u001aX\u00101\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020.0\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001a\u001a\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007*$\b\u0000\u00106\"\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"scriptByRegion", "", "", "fallbackLanguages", "", "Ljava/util/Locale;", "getFallbackLanguages", "(Ljava/util/Locale;)Ljava/util/List;", "getBestMatch", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "localeId", "getBestMatch-64pKzr8", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "", "(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/String;", MimeTypes.BASE_TYPE_IMAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ktx/LocalizationDictionary;", SubscriberAttributeKt.JSON_NAME_KEY, "image-7v81vok", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "imageForAllLocales", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "imageForAllLocales-7v81vok", TypedValues.Custom.S_STRING, "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "string-7v81vok", "stringForAllLocales", "stringForAllLocales-7v81vok", "toComposeLocale", "Landroidx/compose/ui/text/intl/Locale;", "toComposeLocale-_KYeFs0", "(Ljava/lang/String;)Landroidx/compose/ui/text/intl/Locale;", "toJavaLocale", "toJavaLocale-_KYeFs0", "(Ljava/lang/String;)Ljava/util/Locale;", "toLocaleId", "(Landroidx/compose/ui/text/intl/Locale;)Ljava/lang/String;", "(Ljava/util/Locale;)Ljava/lang/String;", "video", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "video-7v81vok", "videoForAllLocales", "videoForAllLocales-7v81vok", "withFallbackLanguages", "withFallbackLanguages-_KYeFs0", "(Ljava/lang/String;)Ljava/util/List;", "LocalizationDictionary", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocalizationKt {
    private static final Map<String, String> scriptByRegion = MapsKt.mapOf(TuplesKt.to("CN", "Hans"), TuplesKt.to("SG", "Hans"), TuplesKt.to("MY", "Hans"), TuplesKt.to("TW", "Hant"), TuplesKt.to("HK", "Hant"), TuplesKt.to("MO", "Hant"));

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ Object m10483getBestMatch64pKzr8(Map getBestMatch, String localeId) {
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        String strM10484getBestMatch64pKzr8 = m10484getBestMatch64pKzr8(getBestMatch.keySet(), localeId);
        if (strM10484getBestMatch64pKzr8 != null) {
            return getBestMatch.get(LocaleId.m10392boximpl(strM10484getBestMatch64pKzr8));
        }
        return null;
    }

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ String m10484getBestMatch64pKzr8(Set getBestMatch, String localeId) {
        LocaleId localeIdM10392boximpl;
        Object next;
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        if (getBestMatch.contains(LocaleId.m10392boximpl(localeId))) {
            return localeId;
        }
        Iterator<T> it = m10493withFallbackLanguages_KYeFs0(localeId).iterator();
        while (true) {
            if (!it.hasNext()) {
                localeIdM10392boximpl = null;
                break;
            }
            Locale locale = (Locale) it.next();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String it2 = locale.getScript();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it2 == null) {
                it2 = scriptByRegion.get(country);
            }
            Intrinsics.checkNotNullExpressionValue(language, "language");
            String strM10393constructorimpl = LocaleId.m10393constructorimpl(language);
            String strM10393constructorimpl2 = it2 != null ? LocaleId.m10393constructorimpl(language + '_' + it2) : null;
            String strM10393constructorimpl3 = it2 != null ? LocaleId.m10393constructorimpl(language + '_' + it2 + '_' + country) : null;
            String localeId2 = toLocaleId(locale);
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(LocaleId.m10392boximpl(localeId2));
            if (strM10393constructorimpl3 != null) {
                listCreateListBuilder.add(LocaleId.m10392boximpl(strM10393constructorimpl3));
            }
            if (strM10393constructorimpl2 != null) {
                listCreateListBuilder.add(LocaleId.m10392boximpl(strM10393constructorimpl2));
            }
            listCreateListBuilder.add(LocaleId.m10392boximpl(strM10393constructorimpl));
            Iterator it3 = CollectionsKt.build(listCreateListBuilder).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                if (getBestMatch.contains(LocaleId.m10392boximpl(((LocaleId) next).m10398unboximpl()))) {
                    break;
                }
            }
            LocaleId localeId3 = (LocaleId) next;
            String strM10398unboximpl = localeId3 != null ? localeId3.m10398unboximpl() : null;
            if (strM10398unboximpl == null) {
                Set set = getBestMatch;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator it4 = set.iterator();
                while (it4.hasNext()) {
                    arrayList.add(m10490toJavaLocale_KYeFs0(((LocaleId) it4.next()).m10398unboximpl()));
                }
                ArrayList arrayList2 = arrayList;
                Iterator it5 = arrayList2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it5.next();
                    Locale locale2 = (Locale) next2;
                    if (Intrinsics.areEqual(locale2.getLanguage(), language) && Intrinsics.areEqual(locale2.getScript(), it2)) {
                        break;
                    }
                }
                Locale locale3 = (Locale) next2;
                if (locale3 != null) {
                    strM10398unboximpl = toLocaleId(locale3);
                } else {
                    Iterator it6 = arrayList2.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it6.next();
                        if (Intrinsics.areEqual(((Locale) next3).getLanguage(), language)) {
                            break;
                        }
                    }
                    Locale locale4 = (Locale) next3;
                    strM10398unboximpl = locale4 != null ? toLocaleId(locale4) : null;
                }
            }
            localeIdM10392boximpl = strM10398unboximpl != null ? LocaleId.m10392boximpl(strM10398unboximpl) : null;
            if (localeIdM10392boximpl != null) {
                break;
            }
        }
        if (localeIdM10392boximpl != null) {
            return localeIdM10392boximpl.m10398unboximpl();
        }
        return null;
    }

    private static final List<Locale> getFallbackLanguages(Locale locale) {
        String language = locale.getLanguage();
        if (!Intrinsics.areEqual(language, "nb") && !Intrinsics.areEqual(language, "nn")) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf(new Locale(SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO, locale.getCountry(), locale.getVariant()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: image-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10485image7v81vok(NonEmptyMap image, String key) {
        Intrinsics.checkNotNullParameter(image, "$this$image");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = image.get(LocalizationKey.m10428boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeImageUrls themeImageUrlsM10407unboximpl = obj instanceof LocalizationData.Image ? ((LocalizationData.Image) obj).m10407unboximpl() : null;
        return themeImageUrlsM10407unboximpl != null ? new Result.Success(themeImageUrlsM10407unboximpl) : new Result.Error(new PaywallValidationError.MissingImageLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: imageForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10486imageForAllLocales7v81vok(NonEmptyMap imageForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(imageForAllLocales, "$this$imageForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = imageForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM10398unboximpl = ((LocaleId) entry.getKey()).m10398unboximpl();
            Result.Error errorM10485image7v81vok = m10485image7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM10485image7v81vok instanceof Result.Success)) {
                if (!(errorM10485image7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorM10485image7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingImageLocalization(key, strM10398unboximpl, null), new PaywallValidationError.MissingImageLocalization[0]));
            }
            linkedHashMap.put(key2, errorM10485image7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(imageForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, imageForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeImageUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (ThemeImageUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: string-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10487string7v81vok(NonEmptyMap string, String key) {
        Intrinsics.checkNotNullParameter(string, "$this$string");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = string.get(LocalizationKey.m10428boximpl(key));
        String str = null;
        Object[] objArr = 0;
        String strM10416unboximpl = obj instanceof LocalizationData.Text ? ((LocalizationData.Text) obj).m10416unboximpl() : null;
        return strM10416unboximpl != null ? new Result.Success(strM10416unboximpl) : new Result.Error(new PaywallValidationError.MissingStringLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: stringForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10488stringForAllLocales7v81vok(NonEmptyMap stringForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(stringForAllLocales, "$this$stringForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = stringForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM10398unboximpl = ((LocaleId) entry.getKey()).m10398unboximpl();
            Result.Error errorM10487string7v81vok = m10487string7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM10487string7v81vok instanceof Result.Success)) {
                if (!(errorM10487string7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorM10487string7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingStringLocalization(key, strM10398unboximpl, null), new PaywallValidationError.MissingStringLocalization[0]));
            }
            linkedHashMap.put(key2, errorM10487string7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(stringForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, stringForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((String) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (String) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    public static final /* synthetic */ androidx.compose.ui.text.intl.Locale toComposeLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return new androidx.compose.ui.text.intl.Locale(languageTag);
    }

    /* JADX INFO: renamed from: toComposeLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ androidx.compose.ui.text.intl.Locale m10489toComposeLocale_KYeFs0(String toComposeLocale) {
        Intrinsics.checkNotNullParameter(toComposeLocale, "$this$toComposeLocale");
        return new androidx.compose.ui.text.intl.Locale(StringsKt.replace$default(toComposeLocale, '_', Soundex.SILENT_MARKER, false, 4, (Object) null));
    }

    public static final /* synthetic */ Locale toJavaLocale(androidx.compose.ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(locale.toLanguageTag());
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(toLanguageTag())");
        return localeForLanguageTag;
    }

    /* JADX INFO: renamed from: toJavaLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ Locale m10490toJavaLocale_KYeFs0(String toJavaLocale) {
        Intrinsics.checkNotNullParameter(toJavaLocale, "$this$toJavaLocale");
        Locale localeForLanguageTag = Locale.forLanguageTag(StringsKt.replace$default(toJavaLocale, '_', Soundex.SILENT_MARKER, false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(value.replace('_', '-'))");
        return localeForLanguageTag;
    }

    public static final /* synthetic */ String toLocaleId(androidx.compose.ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return LocaleId.m10393constructorimpl(StringsKt.replace$default(locale.toLanguageTag(), Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
    }

    public static final /* synthetic */ String toLocaleId(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return LocaleId.m10393constructorimpl(StringsKt.replace$default(languageTag, Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: video-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10491video7v81vok(NonEmptyMap video, String key) {
        Intrinsics.checkNotNullParameter(video, "$this$video");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = video.get(LocalizationKey.m10428boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeVideoUrls themeVideoUrlsM10425unboximpl = obj instanceof LocalizationData.Video ? ((LocalizationData.Video) obj).m10425unboximpl() : null;
        return themeVideoUrlsM10425unboximpl != null ? new Result.Success(themeVideoUrlsM10425unboximpl) : new Result.Error(new PaywallValidationError.MissingVideoLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: videoForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m10492videoForAllLocales7v81vok(NonEmptyMap videoForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(videoForAllLocales, "$this$videoForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = videoForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM10398unboximpl = ((LocaleId) entry.getKey()).m10398unboximpl();
            Result.Error errorM10491video7v81vok = m10491video7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM10491video7v81vok instanceof Result.Success)) {
                if (!(errorM10491video7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorM10491video7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingVideoLocalization(key, strM10398unboximpl, null), new PaywallValidationError.MissingVideoLocalization[0]));
            }
            linkedHashMap.put(key2, errorM10491video7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(videoForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, videoForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeVideoUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (ThemeVideoUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    /* JADX INFO: renamed from: withFallbackLanguages-_KYeFs0, reason: not valid java name */
    private static final List<Locale> m10493withFallbackLanguages_KYeFs0(String str) {
        Locale localeM10490toJavaLocale_KYeFs0 = m10490toJavaLocale_KYeFs0(str);
        List<Locale> fallbackLanguages = getFallbackLanguages(localeM10490toJavaLocale_KYeFs0);
        if (fallbackLanguages.isEmpty()) {
            return CollectionsKt.listOf(localeM10490toJavaLocale_KYeFs0);
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(localeM10490toJavaLocale_KYeFs0);
        listCreateListBuilder.addAll(fallbackLanguages);
        return CollectionsKt.build(listCreateListBuilder);
    }
}
