package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.errors.PackageConfigurationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PackageConfigurationFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jm\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J]\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJY\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u00050\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJB\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000b0\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002JO\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020$0\u00050\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u0004\u0018\u00010(2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J#\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u0010-JZ\u0010.\u001a\b\u0012\u0004\u0012\u00020!0\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u00101\u001a\u0002022\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J2\u00105\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H806\"\u0004\b\u0000\u00107\"\u0004\b\u0001\u00108*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u0001H806H\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationFactory;", "", "()V", "createPackageConfiguration", "Lkotlin/Result;", "Lkotlin/Pair;", "Ljava/util/Locale;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "availablePackages", "", "Lcom/revenuecat/purchases/Package;", "packageIdsInConfig", "", "default", "configurationType", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;", "paywallData", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "storefrontCountryCode", "createPackageConfiguration-bMdYcbs", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;Lcom/revenuecat/purchases/paywalls/PaywallData;Ljava/lang/String;)Ljava/lang/Object;", "makeMultiTierPackageConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiTier;", "makeMultiTierPackageConfiguration-yxL6bBk", "(Lcom/revenuecat/purchases/paywalls/PaywallData;Ljava/util/List;Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Ljava/lang/String;)Ljava/lang/Object;", "makeMultiplePackageConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Multiple;", "filteredRCPackages", "makeMultiplePackageConfiguration-yxL6bBk", "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/paywalls/PaywallData;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "makePackageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "packages", "makeSinglePackageConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Single;", "makeSinglePackageConfiguration-BWLJW6A", "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/paywalls/PaywallData;Ljava/lang/String;)Ljava/lang/Object;", "mostExpensivePricePerMonth", "Lcom/revenuecat/purchases/models/Price;", "productDiscount", "", "pricePerMonth", "mostExpensive", "(Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Price;)Ljava/lang/Double;", "reprocessPackagesForTiers", "from", "filter", "localization", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", AndroidContextPlugin.LOCALE_KEY, "zeroDecimalPlaceCountries", "filterNotNullValues", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PackageConfigurationFactory {
    public static final int $stable = 0;
    public static final PackageConfigurationFactory INSTANCE = new PackageConfigurationFactory();

    /* JADX INFO: compiled from: PackageConfigurationFactory.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageConfigurationType.values().length];
            try {
                iArr[PackageConfigurationType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageConfigurationType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageConfigurationType.MULTITIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PackageConfigurationFactory() {
    }

    private final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01e4  */
    /* JADX INFO: renamed from: makeMultiTierPackageConfiguration-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object m10752makeMultiTierPackageConfigurationyxL6bBk(PaywallData paywallData, List<String> packageIdsInConfig, List<Package> availablePackages, VariableDataProvider variableDataProvider, String storefrontCountryCode) {
        TemplateConfiguration.TierInfo tierInfo;
        Pair pair;
        List<PaywallData.Configuration.Tier> tiers = paywallData.getConfig().getTiers();
        if (tiers == null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(new PackageConfigurationError("No tier found for " + packageIdsInConfig)));
        }
        Pair<Locale, Map<String, PaywallData.LocalizedConfiguration>> tieredLocalizedConfiguration = paywallData.getTieredLocalizedConfiguration();
        Locale localeComponent1 = tieredLocalizedConfiguration.component1();
        Map<String, PaywallData.LocalizedConfiguration> mapComponent2 = tieredLocalizedConfiguration.component2();
        List<PaywallData.Configuration.Tier> list = tiers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        Iterator<T> it = list.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                Map mapFilterNotNullValues = filterNotNullValues(linkedHashMap);
                if (mapFilterNotNullValues.isEmpty()) {
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m11445constructorimpl(ResultKt.createFailure(new PackageConfigurationError("None of the tiers have any available products.")));
                }
                Set<Map.Entry> setEntrySet = mapFilterNotNullValues.entrySet();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
                for (Map.Entry entry : setEntrySet) {
                    PaywallData.Configuration.Tier tier = (PaywallData.Configuration.Tier) entry.getKey();
                    TemplateConfiguration.PackageConfiguration.MultiPackage multiPackage = (TemplateConfiguration.PackageConfiguration.MultiPackage) entry.getValue();
                    String tierName = multiPackage.getDefault().getLocalization().getTierName();
                    if (tierName == null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        return Result.m11445constructorimpl(ResultKt.createFailure(new PackageConfigurationError("No localized tier name found for " + tier.getId())));
                    }
                    arrayList.add(new TemplateConfiguration.TierInfo(tierName, tier.getId(), multiPackage.getDefault(), multiPackage.getAll()));
                }
                ArrayList arrayList2 = arrayList;
                String defaultTier = paywallData.getConfig().getDefaultTier();
                if (defaultTier != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (Intrinsics.areEqual(((TemplateConfiguration.TierInfo) next).getId(), defaultTier)) {
                            obj = next;
                            break;
                        }
                    }
                    tierInfo = (TemplateConfiguration.TierInfo) obj;
                    if (tierInfo == null) {
                        tierInfo = (TemplateConfiguration.TierInfo) CollectionsKt.first((List) arrayList2);
                    }
                }
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m11445constructorimpl(TuplesKt.to(localeComponent1, new TemplateConfiguration.PackageConfiguration.MultiTier(tierInfo, arrayList2)));
            }
            PaywallData.Configuration.Tier tier2 = (PaywallData.Configuration.Tier) it.next();
            PaywallData.LocalizedConfiguration localizedConfiguration = mapComponent2.get(tier2.getId());
            if (localizedConfiguration == null) {
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m11445constructorimpl(ResultKt.createFailure(new PackageConfigurationError("No localization found for " + tier2.getId())));
            }
            String tierName2 = localizedConfiguration.getTierName();
            if (tierName2 == null) {
                tierName2 = "";
            }
            String str = tierName2;
            List<TemplateConfiguration.PackageInfo> listReprocessPackagesForTiers = INSTANCE.reprocessPackagesForTiers(availablePackages, tier2.getPackageIds(), localizedConfiguration, variableDataProvider, localeComponent1, storefrontCountryCode, paywallData.getZeroDecimalPlaceCountries());
            TemplateConfiguration.PackageInfo packageInfo = (TemplateConfiguration.PackageInfo) CollectionsKt.firstOrNull((List) listReprocessPackagesForTiers);
            if (packageInfo == null) {
                Logger.INSTANCE.e("Tier " + str + " has no available products and will be removed from the paywall.");
                pair = TuplesKt.to(tier2, null);
            } else {
                Iterator<T> it3 = listReprocessPackagesForTiers.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    if (Intrinsics.areEqual(((TemplateConfiguration.PackageInfo) next2).getRcPackage().getIdentifier(), tier2.getDefaultPackageId())) {
                        obj = next2;
                        break;
                    }
                }
                TemplateConfiguration.PackageInfo packageInfo2 = (TemplateConfiguration.PackageInfo) obj;
                if (packageInfo2 == null) {
                    packageInfo2 = packageInfo;
                }
                pair = TuplesKt.to(tier2, new TemplateConfiguration.PackageConfiguration.MultiPackage(packageInfo, packageInfo2, listReprocessPackagesForTiers));
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX INFO: renamed from: makeMultiplePackageConfiguration-yxL6bBk, reason: not valid java name */
    private final Object m10753makeMultiplePackageConfigurationyxL6bBk(List<Package> filteredRCPackages, VariableDataProvider variableDataProvider, PaywallData paywallData, String str, String storefrontCountryCode) {
        Object next;
        Pair<Locale, List<TemplateConfiguration.PackageInfo>> pairMakePackageInfo = makePackageInfo(filteredRCPackages, variableDataProvider, paywallData, storefrontCountryCode);
        Locale localeComponent1 = pairMakePackageInfo.component1();
        List<TemplateConfiguration.PackageInfo> listComponent2 = pairMakePackageInfo.component2();
        TemplateConfiguration.PackageInfo packageInfo = (TemplateConfiguration.PackageInfo) CollectionsKt.first((List) listComponent2);
        Iterator<T> it = listComponent2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((TemplateConfiguration.PackageInfo) next).getRcPackage().getIdentifier(), str)) {
                break;
            }
        }
        TemplateConfiguration.PackageInfo packageInfo2 = (TemplateConfiguration.PackageInfo) next;
        if (packageInfo2 == null) {
            packageInfo2 = packageInfo;
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m11445constructorimpl(TuplesKt.to(localeComponent1, new TemplateConfiguration.PackageConfiguration.Multiple(new TemplateConfiguration.PackageConfiguration.MultiPackage(packageInfo, packageInfo2, listComponent2))));
    }

    private final Pair<Locale, List<TemplateConfiguration.PackageInfo>> makePackageInfo(List<Package> packages, VariableDataProvider variableDataProvider, PaywallData paywallData, String storefrontCountryCode) {
        Price priceMostExpensivePricePerMonth = mostExpensivePricePerMonth(packages);
        Pair<Locale, PaywallData.LocalizedConfiguration> localizedConfiguration = paywallData.getLocalizedConfiguration();
        Locale localeComponent1 = localizedConfiguration.component1();
        PaywallData.LocalizedConfiguration localizedConfigurationComponent2 = localizedConfiguration.component2();
        List<Package> list = packages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Package r6 : list) {
            Double dProductDiscount = INSTANCE.productDiscount(StoreProduct.pricePerMonth$default(r6.getProduct(), null, 1, null), priceMostExpensivePricePerMonth);
            boolean zContains = storefrontCountryCode != null ? paywallData.getZeroDecimalPlaceCountries().contains(storefrontCountryCode) : false;
            ProcessedLocalizedConfiguration.Companion companion = ProcessedLocalizedConfiguration.INSTANCE;
            VariableProcessor.PackageContext packageContext = new VariableProcessor.PackageContext(dProductDiscount, zContains);
            VariableDataProvider variableDataProvider2 = variableDataProvider;
            arrayList.add(new TemplateConfiguration.PackageInfo(r6, companion.create(variableDataProvider2, packageContext, localizedConfigurationComponent2, r6, localeComponent1), dProductDiscount));
            variableDataProvider = variableDataProvider2;
        }
        return TuplesKt.to(localeComponent1, arrayList);
    }

    /* JADX INFO: renamed from: makeSinglePackageConfiguration-BWLJW6A, reason: not valid java name */
    private final Object m10754makeSinglePackageConfigurationBWLJW6A(List<Package> filteredRCPackages, VariableDataProvider variableDataProvider, PaywallData paywallData, String storefrontCountryCode) {
        Pair<Locale, List<TemplateConfiguration.PackageInfo>> pairMakePackageInfo = makePackageInfo(filteredRCPackages, variableDataProvider, paywallData, storefrontCountryCode);
        Locale localeComponent1 = pairMakePackageInfo.component1();
        TemplateConfiguration.PackageInfo packageInfo = (TemplateConfiguration.PackageInfo) CollectionsKt.first((List) pairMakePackageInfo.component2());
        Result.Companion companion = Result.INSTANCE;
        return Result.m11445constructorimpl(TuplesKt.to(localeComponent1, new TemplateConfiguration.PackageConfiguration.Single(packageInfo)));
    }

    private final Price mostExpensivePricePerMonth(List<Package> packages) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packages.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                break;
            }
            Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(((Package) it.next()).getProduct(), null, 1, null);
            if (pricePricePerMonth$default != null) {
                arrayList.add(pricePricePerMonth$default);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long amountMicros = ((Price) next).getAmountMicros();
                do {
                    Object next2 = it2.next();
                    long amountMicros2 = ((Price) next2).getAmountMicros();
                    if (amountMicros < amountMicros2) {
                        next = next2;
                        amountMicros = amountMicros2;
                    }
                } while (it2.hasNext());
            }
        }
        return (Price) next;
    }

    private final Double productDiscount(Price pricePerMonth, Price mostExpensive) {
        if (pricePerMonth == null) {
            return null;
        }
        long amountMicros = pricePerMonth.getAmountMicros();
        if (mostExpensive == null) {
            return null;
        }
        long amountMicros2 = mostExpensive.getAmountMicros();
        if (amountMicros >= amountMicros2) {
            return null;
        }
        return Double.valueOf((amountMicros2 - amountMicros) / amountMicros2);
    }

    private final List<TemplateConfiguration.PackageInfo> reprocessPackagesForTiers(List<Package> from, List<String> filter, PaywallData.LocalizedConfiguration localization, VariableDataProvider variableDataProvider, Locale locale, String storefrontCountryCode, List<String> zeroDecimalPlaceCountries) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = filter.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            Iterator<T> it2 = from.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((Package) next).getIdentifier(), str)) {
                    obj = next;
                    break;
                }
            }
            Package r4 = (Package) obj;
            if (r4 != null) {
                arrayList.add(r4);
            }
        }
        ArrayList<Package> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList3.add((Package) it3.next());
        }
        Price priceMostExpensivePricePerMonth = mostExpensivePricePerMonth(arrayList3);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Package r9 : arrayList2) {
            Double dProductDiscount = INSTANCE.productDiscount(StoreProduct.pricePerMonth$default(r9.getProduct(), null, 1, null), priceMostExpensivePricePerMonth);
            arrayList4.add(new TemplateConfiguration.PackageInfo(r9, ProcessedLocalizedConfiguration.INSTANCE.create(variableDataProvider, new VariableProcessor.PackageContext(dProductDiscount, storefrontCountryCode != null ? zeroDecimalPlaceCountries.contains(storefrontCountryCode) : false), localization, r9, locale), dProductDiscount));
        }
        return arrayList4;
    }

    /* JADX INFO: renamed from: createPackageConfiguration-bMdYcbs, reason: not valid java name */
    public final Object m10755createPackageConfigurationbMdYcbs(VariableDataProvider variableDataProvider, List<Package> availablePackages, List<String> packageIdsInConfig, String str, PackageConfigurationType configurationType, PaywallData paywallData, String storefrontCountryCode) {
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        Intrinsics.checkNotNullParameter(packageIdsInConfig, "packageIdsInConfig");
        Intrinsics.checkNotNullParameter(configurationType, "configurationType");
        Intrinsics.checkNotNullParameter(paywallData, "paywallData");
        List<Package> list = availablePackages;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((Package) obj).getIdentifier(), obj);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : packageIdsInConfig) {
            Package r4 = (Package) linkedHashMap.get(str2);
            if (r4 == null) {
                Logger.INSTANCE.d("Package with id " + str2 + " not found. Ignoring.");
            }
            if (r4 != null) {
                arrayList.add(r4);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            arrayList2 = availablePackages;
        }
        if (arrayList2.isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(new PackageConfigurationError("No packages found for ids " + packageIdsInConfig)));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[configurationType.ordinal()];
        if (i == 1) {
            return m10754makeSinglePackageConfigurationBWLJW6A(arrayList2, variableDataProvider, paywallData, storefrontCountryCode);
        }
        if (i == 2) {
            return m10753makeMultiplePackageConfigurationyxL6bBk(arrayList2, variableDataProvider, paywallData, str, storefrontCountryCode);
        }
        if (i == 3) {
            return m10752makeMultiTierPackageConfigurationyxL6bBk(paywallData, packageIdsInConfig, availablePackages, variableDataProvider, storefrontCountryCode);
        }
        throw new NoWhenBranchMatchedException();
    }
}
