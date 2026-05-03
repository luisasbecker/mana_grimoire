package com.revenuecat.purchases.utils;

import android.net.Uri;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingImagePreDownloader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u0012H\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "", "shouldPredownloadImages", "", "coilImageDownloader", "Lcom/revenuecat/purchases/utils/CoilImageDownloader;", "(ZLcom/revenuecat/purchases/utils/CoilImageDownloader;)V", "downloadV1Images", "", "offering", "Lcom/revenuecat/purchases/Offering;", "downloadV2Images", "findImageUrisToDownload", "", "Landroid/net/Uri;", "paywallComponents", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "preDownloadOfferingImages", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingImagePreDownloader {
    private final CoilImageDownloader coilImageDownloader;
    private final boolean shouldPredownloadImages;

    public OfferingImagePreDownloader(boolean z, CoilImageDownloader coilImageDownloader) {
        Intrinsics.checkNotNullParameter(coilImageDownloader, "coilImageDownloader");
        this.shouldPredownloadImages = z;
        this.coilImageDownloader = coilImageDownloader;
    }

    public /* synthetic */ OfferingImagePreDownloader(boolean z, CoilImageDownloader coilImageDownloader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UtilsKt.getCanUsePaywallUI() : z, coilImageDownloader);
    }

    private final void downloadV1Images(Offering offering) {
        PaywallData paywall = offering.getPaywall();
        if (paywall != null) {
            List<String> all$purchases_defaultsBc8Release = paywall.getConfig().getImages().getAll$purchases_defaultsBc8Release();
            ArrayList<Uri> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all$purchases_defaultsBc8Release, 10));
            Iterator<T> it = all$purchases_defaultsBc8Release.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path((String) it.next()).build());
            }
            for (Uri it2 : arrayList) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V1 image: " + it2);
                }
                CoilImageDownloader coilImageDownloader = this.coilImageDownloader;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                coilImageDownloader.downloadImage(it2);
            }
        }
    }

    private final void downloadV2Images(Offering offering) {
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents != null) {
            for (Uri uri : findImageUrisToDownload(paywallComponents)) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V2 image: " + uri);
                }
                this.coilImageDownloader.downloadImage(uri);
            }
        }
    }

    private final Set<Uri> findImageUrisToDownload(Offering.PaywallComponents paywallComponents) {
        StackComponent stack;
        PaywallComponentsConfig base = paywallComponents.getData().getComponentsConfig().getBase();
        Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(base.getStack());
        StickyFooterComponent stickyFooter = base.getStickyFooter();
        Set<Uri> setFindImageUrisToDownload2 = (stickyFooter == null || (stack = stickyFooter.getStack()) == null) ? null : findImageUrisToDownload(stack);
        if (setFindImageUrisToDownload2 == null) {
            setFindImageUrisToDownload2 = SetsKt.emptySet();
        }
        return SetsKt.plus(SetsKt.plus((Set) setFindImageUrisToDownload, (Iterable) setFindImageUrisToDownload2), (Iterable) findImageUrisToDownload(base.getBackground()));
    }

    private final Set<Uri> findImageUrisToDownload(StackComponent stackComponent) {
        Set<Uri> setEmptySet;
        List<PaywallComponent> listFilter = PaywallComponentFilterExtensionKt.filter(stackComponent, new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.utils.OfferingImagePreDownloader.findImageUrisToDownload.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PaywallComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof StackComponent) || (it instanceof IconComponent) || (it instanceof CarouselComponent) || (it instanceof TabsComponent) || (it instanceof ImageComponent) || (it instanceof CountdownComponent));
            }
        });
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (PaywallComponent paywallComponent : listFilter) {
            if (paywallComponent instanceof StackComponent) {
                StackComponent stackComponent2 = (StackComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(stackComponent2.getBackground());
                List overrides = stackComponent2.getOverrides();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Iterator it = overrides.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet2, findImageUrisToDownload(((PartialStackComponent) ((ComponentOverride) it.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload, (Iterable) linkedHashSet2);
            } else if (paywallComponent instanceof IconComponent) {
                IconComponent iconComponent = (IconComponent) paywallComponent;
                setEmptySet = SetsKt.setOf(Uri.parse(iconComponent.getBaseUrl()).buildUpon().path(iconComponent.getFormats().getWebp()).build());
            } else if (paywallComponent instanceof CarouselComponent) {
                CarouselComponent carouselComponent = (CarouselComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload2 = findImageUrisToDownload(carouselComponent.getBackground());
                List overrides2 = carouselComponent.getOverrides();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                Iterator it2 = overrides2.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet3, findImageUrisToDownload(((PartialCarouselComponent) ((ComponentOverride) it2.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload2, (Iterable) linkedHashSet3);
            } else if (paywallComponent instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload3 = findImageUrisToDownload(tabsComponent.getBackground());
                List overrides3 = tabsComponent.getOverrides();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                Iterator it3 = overrides3.iterator();
                while (it3.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet4, findImageUrisToDownload(((PartialTabsComponent) ((ComponentOverride) it3.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload3, (Iterable) linkedHashSet4);
            } else if (paywallComponent instanceof ImageComponent) {
                ImageComponent imageComponent = (ImageComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload4 = findImageUrisToDownload(imageComponent.getSource());
                List overrides4 = imageComponent.getOverrides();
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                Iterator it4 = overrides4.iterator();
                while (it4.hasNext()) {
                    ThemeImageUrls source = ((PartialImageComponent) ((ComponentOverride) it4.next()).getProperties()).getSource();
                    Set<Uri> setFindImageUrisToDownload5 = source != null ? findImageUrisToDownload(source) : null;
                    if (setFindImageUrisToDownload5 == null) {
                        setFindImageUrisToDownload5 = SetsKt.emptySet();
                    }
                    CollectionsKt.addAll(linkedHashSet5, setFindImageUrisToDownload5);
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload4, (Iterable) linkedHashSet5);
            } else if (paywallComponent instanceof VideoComponent) {
                ThemeImageUrls fallbackSource = ((VideoComponent) paywallComponent).getFallbackSource();
                setEmptySet = fallbackSource != null ? findImageUrisToDownload(fallbackSource) : null;
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
            } else if (paywallComponent instanceof CountdownComponent) {
                CountdownComponent countdownComponent = (CountdownComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload6 = findImageUrisToDownload(countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                Set<Uri> setFindImageUrisToDownload7 = endStack != null ? findImageUrisToDownload(endStack) : null;
                if (setFindImageUrisToDownload7 == null) {
                    setFindImageUrisToDownload7 = SetsKt.emptySet();
                }
                Set setPlus = SetsKt.plus((Set) setFindImageUrisToDownload6, (Iterable) setFindImageUrisToDownload7);
                StackComponent fallback = countdownComponent.getFallback();
                Set<Uri> setFindImageUrisToDownload8 = fallback != null ? findImageUrisToDownload(fallback) : null;
                if (setFindImageUrisToDownload8 == null) {
                    setFindImageUrisToDownload8 = SetsKt.emptySet();
                }
                setEmptySet = SetsKt.plus(setPlus, (Iterable) setFindImageUrisToDownload8);
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            CollectionsKt.addAll(linkedHashSet, setEmptySet);
        }
        return linkedHashSet;
    }

    private final Set<Uri> findImageUrisToDownload(Background background) {
        URL webpLowRes;
        String string;
        URL webpLowRes2;
        String string2;
        Uri uri = null;
        if (background instanceof Background.Image) {
            Uri[] uriArr = new Uri[2];
            Background.Image image = (Background.Image) background;
            uriArr[0] = Uri.parse(image.getValue().getLight().getWebpLowRes().toString());
            ImageUrls dark = image.getValue().getDark();
            if (dark != null && (webpLowRes2 = dark.getWebpLowRes()) != null && (string2 = webpLowRes2.toString()) != null) {
                uri = Uri.parse(string2);
            }
            uriArr[1] = uri;
            return SetsKt.setOfNotNull((Object[]) uriArr);
        }
        if (!(background instanceof Background.Video)) {
            if ((background instanceof Background.Color ? true : background instanceof Background.Unknown) || background == null) {
                return SetsKt.emptySet();
            }
            throw new NoWhenBranchMatchedException();
        }
        Uri[] uriArr2 = new Uri[2];
        Background.Video video = (Background.Video) background;
        uriArr2[0] = Uri.parse(video.getFallbackImage().getLight().getWebpLowRes().toString());
        ImageUrls dark2 = video.getFallbackImage().getDark();
        if (dark2 != null && (webpLowRes = dark2.getWebpLowRes()) != null && (string = webpLowRes.toString()) != null) {
            uri = Uri.parse(string);
        }
        uriArr2[1] = uri;
        return SetsKt.setOfNotNull((Object[]) uriArr2);
    }

    private final Set<Uri> findImageUrisToDownload(ThemeImageUrls themeImageUrls) {
        URL webpLowRes;
        String string;
        Uri[] uriArr = new Uri[2];
        uriArr[0] = Uri.parse(themeImageUrls.getLight().getWebpLowRes().toString());
        ImageUrls dark = themeImageUrls.getDark();
        uriArr[1] = (dark == null || (webpLowRes = dark.getWebpLowRes()) == null || (string = webpLowRes.toString()) == null) ? null : Uri.parse(string);
        return SetsKt.setOfNotNull((Object[]) uriArr);
    }

    public final void preDownloadOfferingImages(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownloadImages) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "OfferingImagePreDownloader won't pre-download images");
                return;
            }
            return;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "OfferingImagePreDownloader: starting image download");
        }
        downloadV1Images(offering);
        downloadV2Images(offering);
    }
}
