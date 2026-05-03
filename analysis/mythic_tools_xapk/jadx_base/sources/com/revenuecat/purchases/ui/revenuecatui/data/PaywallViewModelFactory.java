package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.material3.ColorScheme;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallViewModelFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "preview", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Landroidx/compose/material3/ColorScheme;ZLkotlin/jvm/functions/Function1;Z)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    public static final int $stable = 8;
    private final ColorScheme colorScheme;
    private final boolean isDarkMode;
    private final PaywallOptions options;
    private final boolean preview;
    private final ResourceProvider resourceProvider;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewModelFactory(ResourceProvider resourceProvider, PaywallOptions options, ColorScheme colorScheme, boolean z, Function1<? super CustomerInfo, Boolean> function1, boolean z2) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.resourceProvider = resourceProvider;
        this.options = options;
        this.colorScheme = colorScheme;
        this.isDarkMode = z;
        this.shouldDisplayBlock = function1;
        this.preview = z2;
    }

    public /* synthetic */ PaywallViewModelFactory(ResourceProvider resourceProvider, PaywallOptions paywallOptions, ColorScheme colorScheme, boolean z, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resourceProvider, paywallOptions, colorScheme, z, function1, (i & 32) != 0 ? false : z2);
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new PaywallViewModelImpl(this.resourceProvider, null, this.options, this.colorScheme, this.isDarkMode, this.shouldDisplayBlock, this.preview, null, 130, null);
    }
}
