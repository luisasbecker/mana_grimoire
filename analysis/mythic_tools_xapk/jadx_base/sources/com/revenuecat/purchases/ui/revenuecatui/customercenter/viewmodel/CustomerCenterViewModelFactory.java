package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import androidx.compose.material3.ColorScheme;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterViewModelFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Landroidx/compose/material3/ColorScheme;ZLcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    public static final int $stable = 8;
    private final ColorScheme colorScheme;
    private final boolean isDarkMode;
    private final CustomerCenterListener listener;
    private final PurchasesType purchases;

    public CustomerCenterViewModelFactory(PurchasesType purchases, ColorScheme colorScheme, boolean z, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.purchases = purchases;
        this.colorScheme = colorScheme;
        this.isDarkMode = z;
        this.listener = customerCenterListener;
    }

    public /* synthetic */ CustomerCenterViewModelFactory(PurchasesType purchasesType, ColorScheme colorScheme, boolean z, CustomerCenterListener customerCenterListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesType, colorScheme, z, (i & 8) != 0 ? null : customerCenterListener);
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new CustomerCenterViewModelImpl(this.purchases, null, null, this.colorScheme, this.isDarkMode, this.listener, 6, null);
    }
}
