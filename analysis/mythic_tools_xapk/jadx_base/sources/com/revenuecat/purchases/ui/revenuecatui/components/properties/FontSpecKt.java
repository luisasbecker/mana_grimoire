package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.AndroidFontKt;
import androidx.compose.ui.text.font.DeviceFontFamilyName;
import androidx.compose.ui.text.font.DeviceFontFamilyNameFontKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.compose.ui.text.googlefonts.GoogleFontKt;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFont;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FontSpec.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a<\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fH\u0002\u001a,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\f*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0013\u001a\u00020\bH\u0000\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a6\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00180\u0017*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0000\u001a&\u0010\u001d\u001a\u00020\u001e*\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020\"*\u00020&H\u0002¢\u0006\u0002\u0010'\u001a6\u0010(\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010\"0*0)*\b\u0012\u0004\u0012\u00020\u00050)2\u0006\u0010\u0013\u001a\u00020\bH\u0002\u001a\u001c\u0010,\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00050)2\u0006\u0010\u0013\u001a\u00020\bH\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u000e*\b\u0012\u0004\u0012\u00020\u00050)2\u0006\u0010\u0013\u001a\u00020\bH\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"GoogleFontsProvider", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "getGenericFontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "determineFontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "fontsConfig", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig;", "resourceFontFamilies", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Resource;", "assetFontFamilies", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Asset;", "determineFontSpecs", "Lcom/revenuecat/purchases/FontAlias;", "resourceProvider", "getDownloadedFontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Downloaded;", "getFontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "alias", "getFontSpec-pDyximM", "(Ljava/util/Map;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "recoverFromFontAliasError", "resolve", "Landroidx/compose/ui/text/font/FontFamily;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "resolve-RetOiIg", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/FontFamily;", "toComposeFontStyle", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "(Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;)I", "toFontResourceIdAndData", "", "Lkotlin/Triple;", "", "toFontSpecAsset", "toFontSpecResource", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class FontSpecKt {
    private static final GoogleFont.Provider GoogleFontsProvider = new GoogleFont.Provider("com.google.android.gms.fonts", "com.google.android.gms", R.array.com_google_android_gms_fonts_certs);

    /* JADX INFO: compiled from: FontSpec.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontStyle.values().length];
            try {
                iArr[FontStyle.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontStyle.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final FontSpec determineFontSpec(ResourceProvider resourceProvider, UiConfig.AppConfig.FontsConfig fontsConfig, Map<String, FontSpec.Resource> map, Map<String, FontSpec.Asset> map2) {
        FontSpec fontSpec;
        UiConfig.AppConfig.FontsConfig.FontInfo android2 = fontsConfig.getAndroid();
        if (android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts) {
            return new FontSpec.Google(((UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts) android2).getValue());
        }
        if (!(android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name)) {
            throw new NoWhenBranchMatchedException();
        }
        UiConfig.AppConfig.FontsConfig.FontInfo.Name name = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) android2;
        FontSpec.Generic genericFontSpec = getGenericFontSpec(name);
        if (genericFontSpec != null) {
            return genericFontSpec;
        }
        if (name.getFamily() != null) {
            FontSpec.Resource resource = map.get(name.getFamily());
            if (resource == null) {
                resource = map2.get(name.getFamily());
            }
            fontSpec = resource;
        } else {
            fontSpec = null;
        }
        if (fontSpec != null) {
            return fontSpec;
        }
        FontSpec.Downloaded downloadedFontSpec = getDownloadedFontSpec(resourceProvider, name);
        if (downloadedFontSpec != null) {
            return downloadedFontSpec;
        }
        FontSpec.System system = new FontSpec.System(name.getValue());
        Logger.INSTANCE.d("Could not find a font resource named `" + name.getValue() + "`. Assuming it's an OEM system font. If it isn't, make sure the font exists in the `res/font` folder. See for more info: https://developer.android.com/develop/ui/views/text-and-emoji/fonts-in-xml");
        return system;
    }

    public static final /* synthetic */ Map determineFontSpecs(Map map, ResourceProvider resourceProvider) {
        String family;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Set set = CollectionsKt.toSet(map.values());
        ArrayList<Pair> arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (true) {
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            UiConfig.AppConfig.FontsConfig.FontInfo android2 = ((UiConfig.AppConfig.FontsConfig) it.next()).getAndroid();
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name = android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name ? (UiConfig.AppConfig.FontsConfig.FontInfo.Name) android2 : null;
            if (name != null && (family = name.getFamily()) != null) {
                pair = TuplesKt.to(family, name);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair2 : arrayList) {
            String str = (String) pair2.component1();
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(str, obj);
            }
            ((List) obj).add((UiConfig.AppConfig.FontsConfig.FontInfo.Name) pair2.component2());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            FontSpec.Resource fontSpecResource = toFontSpecResource((List) entry.getValue(), resourceProvider);
            Pair pair3 = fontSpecResource != null ? TuplesKt.to(str2, fontSpecResource) : null;
            if (pair3 != null) {
                arrayList2.add(pair3);
            }
        }
        ArrayList<Pair> arrayList3 = arrayList2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList3, 10)), 16));
        for (Pair pair4 : arrayList3) {
            linkedHashMap2.put((String) pair4.getFirst(), (FontSpec.Resource) pair4.getSecond());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!linkedHashMap2.containsKey(entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str3 = (String) entry3.getKey();
            FontSpec.Asset fontSpecAsset = toFontSpecAsset((List) entry3.getValue(), resourceProvider);
            Pair pair5 = fontSpecAsset != null ? TuplesKt.to(str3, fontSpecAsset) : null;
            if (pair5 != null) {
                arrayList4.add(pair5);
            }
        }
        ArrayList<Pair> arrayList5 = arrayList4;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList5, 10)), 16));
        for (Pair pair6 : arrayList5) {
            linkedHashMap4.put((String) pair6.getFirst(), (FontSpec.Asset) pair6.getSecond());
        }
        Set set2 = CollectionsKt.toSet(map.values());
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
        for (Object obj2 : set2) {
            linkedHashMap5.put(obj2, determineFontSpec(resourceProvider, (UiConfig.AppConfig.FontsConfig) obj2, linkedHashMap2, linkedHashMap4));
        }
        LinkedHashMap linkedHashMap6 = linkedHashMap5;
        LinkedHashMap linkedHashMap7 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry4 : map.entrySet()) {
            linkedHashMap7.put(entry4.getKey(), (FontSpec) MapsKt.getValue(linkedHashMap6, (UiConfig.AppConfig.FontsConfig) entry4.getValue()));
        }
        return linkedHashMap7;
    }

    private static final FontSpec.Downloaded getDownloadedFontSpec(ResourceProvider resourceProvider, UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        DownloadedFontFamily cachedFontFamilyOrStartDownload = resourceProvider.getCachedFontFamilyOrStartDownload(name);
        if (cachedFontFamilyOrStartDownload != null) {
            return new FontSpec.Downloaded(cachedFontFamilyOrStartDownload);
        }
        return null;
    }

    /* JADX INFO: renamed from: getFontSpec-pDyximM, reason: not valid java name */
    public static final /* synthetic */ Result m10543getFontSpecpDyximM(Map getFontSpec, String alias) {
        Intrinsics.checkNotNullParameter(getFontSpec, "$this$getFontSpec");
        Intrinsics.checkNotNullParameter(alias, "alias");
        FontSpec fontSpec = (FontSpec) getFontSpec.get(FontAlias.m10270boximpl(alias));
        return fontSpec != null ? new Result.Success(fontSpec) : new Result.Error(new PaywallValidationError.MissingFontAlias(alias, null));
    }

    private static final FontSpec.Generic getGenericFontSpec(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        String value = name.getValue();
        if (Intrinsics.areEqual(value, FontFamily.INSTANCE.getSansSerif().getName())) {
            return FontSpec.Generic.SansSerif.INSTANCE;
        }
        if (Intrinsics.areEqual(value, FontFamily.INSTANCE.getSerif().getName())) {
            return FontSpec.Generic.Serif.INSTANCE;
        }
        if (Intrinsics.areEqual(value, FontFamily.INSTANCE.getMonospace().getName())) {
            return FontSpec.Generic.Monospace.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ Result recoverFromFontAliasError(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallValidationError paywallValidationError = (PaywallValidationError) ((Result.Error) result).getValue();
        boolean z = paywallValidationError instanceof PaywallValidationError.MissingFontAlias;
        if (z && StringsKt.isBlank(((PaywallValidationError.MissingFontAlias) paywallValidationError).m10822getAliasBejUyPs())) {
            return new Result.Success(null);
        }
        if (!z) {
            return new Result.Error(paywallValidationError);
        }
        Logger.INSTANCE.w("Font named '" + ((Object) FontAlias.m10275toStringimpl(((PaywallValidationError.MissingFontAlias) paywallValidationError).m10822getAliasBejUyPs())) + "' was not found in the font config. Try re-adding it in the Paywall editor.");
        return new Result.Success(null);
    }

    /* JADX INFO: renamed from: resolve-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ FontFamily m10544resolveRetOiIg(FontSpec resolve, FontWeight weight, int i) {
        GenericFontFamily monospace;
        Intrinsics.checkNotNullParameter(resolve, "$this$resolve");
        Intrinsics.checkNotNullParameter(weight, "weight");
        if (resolve instanceof FontSpec.Resource) {
            return ((FontSpec.Resource) resolve).getFontFamily();
        }
        if (resolve instanceof FontSpec.Asset) {
            return ((FontSpec.Asset) resolve).getFontFamily();
        }
        if (resolve instanceof FontSpec.Google) {
            return FontFamilyKt.FontFamily(GoogleFontKt.m8720FontwCLgNak(new GoogleFont(((FontSpec.Google) resolve).getName(), false, 2, null), GoogleFontsProvider, weight, i));
        }
        if (resolve instanceof FontSpec.Generic) {
            if (Intrinsics.areEqual(resolve, FontSpec.Generic.SansSerif.INSTANCE)) {
                monospace = FontFamily.INSTANCE.getSansSerif();
            } else if (Intrinsics.areEqual(resolve, FontSpec.Generic.Serif.INSTANCE)) {
                monospace = FontFamily.INSTANCE.getSerif();
            } else {
                if (!Intrinsics.areEqual(resolve, FontSpec.Generic.Monospace.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                monospace = FontFamily.INSTANCE.getMonospace();
            }
            return monospace;
        }
        if (!(resolve instanceof FontSpec.Downloaded)) {
            if (resolve instanceof FontSpec.System) {
                return FontFamilyKt.FontFamily(DeviceFontFamilyNameFontKt.m8639Fontvxs03AY$default(DeviceFontFamilyName.m8632constructorimpl(((FontSpec.System) resolve).getName()), weight, i, null, 8, null));
            }
            throw new NoWhenBranchMatchedException();
        }
        List<DownloadedFont> fonts = ((FontSpec.Downloaded) resolve).getDownloadedFontFamily().getFonts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fonts, 10));
        for (DownloadedFont downloadedFont : fonts) {
            arrayList.add(AndroidFontKt.m8617FontEj4NQ78$default(new File(downloadedFont.getFile().getPath()), new FontWeight(downloadedFont.getWeight()), toComposeFontStyle(downloadedFont.getStyle()), (FontVariation.Settings) null, 8, (Object) null));
        }
        return FontFamilyKt.FontFamily(arrayList);
    }

    private static final int toComposeFontStyle(FontStyle fontStyle) {
        int i = WhenMappings.$EnumSwitchMapping$0[fontStyle.ordinal()];
        if (i == 1) {
            return androidx.compose.ui.text.font.FontStyle.INSTANCE.m8675getNormal_LCdwA();
        }
        if (i == 2) {
            return androidx.compose.ui.text.font.FontStyle.INSTANCE.m8674getItalic_LCdwA();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> toFontResourceIdAndData(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (UiConfig.AppConfig.FontsConfig.FontInfo.Name name : list) {
            if (!linkedHashSet.contains(name.getValue())) {
                Integer numValueOf = Integer.valueOf(resourceProvider.getResourceIdentifier(name.getValue(), "font"));
                if (numValueOf.intValue() == 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    Integer num = numValueOf;
                    num.intValue();
                    linkedHashSet.add(name.getValue());
                    Integer numValueOf2 = Integer.valueOf(num.intValue());
                    Integer weight = name.getWeight();
                    FontStyle style = name.getStyle();
                    triple = new Triple(numValueOf2, weight, style != null ? androidx.compose.ui.text.font.FontStyle.m8665boximpl(toComposeFontStyle(style)) : null);
                }
            }
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        return arrayList;
    }

    private static final FontSpec.Asset toFontSpecAsset(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        Font fontM8619FontMuC2MFs$default;
        List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((UiConfig.AppConfig.FontsConfig.FontInfo.Name) it.next()).getValue());
        }
        Map<String, String> assetFontPaths = resourceProvider.getAssetFontPaths(arrayList);
        AssetManager assetManager = resourceProvider.getMockAssetManager();
        if (assetFontPaths == null || assetManager == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (UiConfig.AppConfig.FontsConfig.FontInfo.Name name : list2) {
            String str = assetFontPaths.get(name.getValue());
            if (str == null) {
                fontM8619FontMuC2MFs$default = null;
            } else {
                Integer weight = name.getWeight();
                FontWeight fontWeight = weight != null ? new FontWeight(weight.intValue()) : FontWeight.INSTANCE.getNormal();
                FontStyle style = name.getStyle();
                fontM8619FontMuC2MFs$default = AndroidFontKt.m8619FontMuC2MFs$default(str, assetManager, fontWeight, style != null ? toComposeFontStyle(style) : androidx.compose.ui.text.font.FontStyle.INSTANCE.m8675getNormal_LCdwA(), null, 16, null);
            }
            if (fontM8619FontMuC2MFs$default != null) {
                arrayList2.add(fontM8619FontMuC2MFs$default);
            }
        }
        return new FontSpec.Asset(FontFamilyKt.FontFamily(arrayList2));
    }

    private static final FontSpec.Resource toFontSpecResource(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        FontFamily xmlFontFamily;
        List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> fontResourceIdAndData = toFontResourceIdAndData(list, resourceProvider);
        if (fontResourceIdAndData.isEmpty()) {
            return null;
        }
        if (fontResourceIdAndData.size() == 1 && (xmlFontFamily = resourceProvider.getXmlFontFamily(((Number) ((Triple) CollectionsKt.first((List) fontResourceIdAndData)).getFirst()).intValue())) != null) {
            return new FontSpec.Resource(xmlFontFamily);
        }
        List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> list2 = fontResourceIdAndData;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            int iIntValue = ((Number) triple.getFirst()).intValue();
            Integer num = (Integer) triple.getSecond();
            FontWeight fontWeight = num != null ? new FontWeight(num.intValue()) : FontWeight.INSTANCE.getNormal();
            androidx.compose.ui.text.font.FontStyle fontStyle = (androidx.compose.ui.text.font.FontStyle) triple.getThird();
            arrayList.add(FontKt.m8649FontYpTlLL0$default(iIntValue, fontWeight, fontStyle != null ? fontStyle.m8671unboximpl() : androidx.compose.ui.text.font.FontStyle.INSTANCE.m8675getNormal_LCdwA(), 0, 8, null));
        }
        return new FontSpec.Resource(FontFamilyKt.FontFamily(arrayList));
    }
}
