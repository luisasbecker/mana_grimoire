package com.revenuecat.purchases.paywalls;

import android.content.Context;
import androidx.media3.common.C;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: OfferingFontPreDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/OfferingFontPreDownloader;", "", "context", "Landroid/content/Context;", "fontLoader", "Lcom/revenuecat/purchases/paywalls/FontLoader;", "(Landroid/content/Context;Lcom/revenuecat/purchases/paywalls/FontLoader;)V", "assetsFontsDir", "", "genericFonts", "", "isBundled", "", "info", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "preDownloadOfferingFontsIfNeeded", "", "offerings", "Lcom/revenuecat/purchases/Offerings;", "getAssetFontPath", "name", "getResourceIdentifier", "", "type", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingFontPreDownloader {
    private final String assetsFontsDir;
    private final Context context;
    private final FontLoader fontLoader;
    private final Set<String> genericFonts;

    public OfferingFontPreDownloader(Context context, FontLoader fontLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontLoader, "fontLoader");
        this.context = context;
        this.fontLoader = fontLoader;
        this.assetsFontsDir = "fonts";
        this.genericFonts = SetsKt.setOf((Object[]) new String[]{C.SANS_SERIF_NAME, C.SERIF_NAME, "monospace"});
    }

    private final String getAssetFontPath(Context context, String str) throws IOException {
        String str2;
        int i = 0;
        if (!StringsKt.endsWith$default(str, ".ttf", false, 2, (Object) null)) {
            str = str + ".ttf";
        }
        String[] list = context.getResources().getAssets().list(this.assetsFontsDir);
        if (list != null) {
            int length = list.length;
            while (true) {
                if (i >= length) {
                    str2 = null;
                    break;
                }
                str2 = list[i];
                if (Intrinsics.areEqual(str2, str)) {
                    break;
                }
                i++;
            }
            if (str2 != null) {
                return this.assetsFontsDir + IOUtils.DIR_SEPARATOR_UNIX + str2;
            }
        }
        return null;
    }

    private final int getResourceIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    private final boolean isBundled(UiConfig.AppConfig.FontsConfig.FontInfo.Name info) {
        if (info.getValue().length() == 0) {
            return false;
        }
        return (!this.genericFonts.contains(info.getValue()) && getResourceIdentifier(this.context, info.getValue(), "font") == 0 && getAssetFontPath(this.context, info.getValue()) == null) ? false : true;
    }

    public final void preDownloadOfferingFontsIfNeeded(Offerings offerings) {
        List listEmptyList;
        UiConfig uiConfig;
        UiConfig.AppConfig app;
        Map fonts;
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Iterator<T> it = offerings.getAll().values().iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                break;
            }
            Offering.PaywallComponents paywallComponents = ((Offering) it.next()).getPaywallComponents();
            if (paywallComponents != null && (uiConfig = paywallComponents.getUiConfig()) != null && (app = uiConfig.getApp()) != null && (fonts = app.getFonts()) != null) {
                listEmptyList = fonts.values();
            }
        } while (listEmptyList == null);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Collection collection = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(((UiConfig.AppConfig.FontsConfig) it2.next()).getAndroid());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj2;
            if ((DownloadableFontInfoKt.toDownloadableFontInfo(name) instanceof Result.Success) && !isBundled(name)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name2 = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj3;
            try {
                new URL(name2.getUrl());
                arrayList4.add(obj3);
            } catch (MalformedURLException e) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Malformed URL for font: " + name2.getValue() + ". Skipping download.", e);
            }
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            this.fontLoader.getCachedFontFamilyOrStartDownload((UiConfig.AppConfig.FontsConfig.FontInfo.Name) it3.next());
        }
    }
}
