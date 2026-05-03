package com.revenuecat.purchases.utils;

import android.content.Context;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.storage.FileRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingVideoPredownloader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/utils/OfferingVideoPredownloader;", "", "context", "Landroid/content/Context;", "canShowPaywalls", "", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "(Landroid/content/Context;ZLcom/revenuecat/purchases/storage/FileRepository;)V", "shouldPredownload", "downloadVideos", "", "offering", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingVideoPredownloader {
    private final FileRepository fileRepository;
    private final boolean shouldPredownload;

    public OfferingVideoPredownloader(Context context, boolean z, FileRepository fileRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        this.fileRepository = fileRepository;
        this.shouldPredownload = z;
    }

    public /* synthetic */ OfferingVideoPredownloader(Context context, boolean z, DefaultFileRepository defaultFileRepository, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? UtilsKt.getCanUsePaywallUI() : z, (i & 4) != 0 ? new DefaultFileRepository(context) : defaultFileRepository);
    }

    public final void downloadVideos(Offering offering) {
        Offering.PaywallComponents paywallComponents;
        PaywallComponentsData data;
        ComponentsConfig componentsConfig;
        PaywallComponentsConfig base;
        StackComponent stack;
        List<PaywallComponent> listFilter;
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownload || (paywallComponents = offering.getPaywallComponents()) == null || (data = paywallComponents.getData()) == null || (componentsConfig = data.getComponentsConfig()) == null || (base = componentsConfig.getBase()) == null || (stack = base.getStack()) == null || (listFilter = PaywallComponentFilterExtensionKt.filter(stack, new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.utils.OfferingVideoPredownloader.downloadVideos.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PaywallComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof VideoComponent);
            }
        })) == null) {
            return;
        }
        for (PaywallComponent paywallComponent : listFilter) {
            if (paywallComponent instanceof VideoComponent) {
                this.fileRepository.prefetch(OfferingVideoPredownloaderKt.checkedUrls(((VideoComponent) paywallComponent).getSource()));
            }
        }
    }
}
