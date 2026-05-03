package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.app.Activity;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLaunchIfNeededOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLaunchOptions;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallActivityLauncher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002JJ\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0007JS\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0007¢\u0006\u0002\b#J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u0013H\u0007JH\u0010$\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130&H\u0007JH\u0010$\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0007JQ\u0010$\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0002\b+JD\u0010$\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\tH\u0002J\u000e\u00101\u001a\u00020\u00152\u0006\u0010-\u001a\u000202J#\u00103\u001a\u0004\u0018\u00010\u000b2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u00108R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLauncher;", "", "resultCaller", "Landroidx/activity/result/ActivityResultCaller;", "resultHandler", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResultHandler;", "(Landroidx/activity/result/ActivityResultCaller;Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResultHandler;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityArgs;", "currentNonSerializableArgsKey", "", "Ljava/lang/Integer;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "weakFragment", "Landroidx/fragment/app/Fragment;", "isActivityFinishing", "", "launch", "", "offering", "Lcom/revenuecat/purchases/Offering;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", "shouldDisplayDismissButton", "edgeToEdge", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "offeringIdentifier", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "launchWithOfferingId", "launchIfNeeded", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "requiredEntitlementIdentifier", "paywallDisplayCallback", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallDisplayCallback;", "launchIfNeededWithOfferingId", "launchIfNeededWithOptions", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLaunchIfNeededOptions;", "launchPaywallWithArgs", "args", "launchWithOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLaunchOptions;", "storeNonSerializableArgsIfNeeded", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)Ljava/lang/Integer;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallActivityLauncher {
    public static final int $stable = 8;
    private final ActivityResultLauncher<PaywallActivityArgs> activityResultLauncher;
    private Integer currentNonSerializableArgsKey;
    private final WeakReference<Activity> weakActivity;
    private final WeakReference<Fragment> weakFragment;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityLauncher(ActivityResultCaller resultCaller, final PaywallResultHandler resultHandler) {
        Intrinsics.checkNotNullParameter(resultCaller, "resultCaller");
        Intrinsics.checkNotNullParameter(resultHandler, "resultHandler");
        this.weakActivity = new WeakReference<>(resultCaller instanceof Activity ? (Activity) resultCaller : null);
        this.weakFragment = new WeakReference<>(resultCaller instanceof Fragment ? (Fragment) resultCaller : null);
        this.activityResultLauncher = resultCaller.registerForActivityResult(new PaywallContract(), new PaywallResultHandler() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher$wrappedHandler$1
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(PaywallResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Integer num = this.this$0.currentNonSerializableArgsKey;
                if (num != null) {
                    PaywallActivityLauncher paywallActivityLauncher = this.this$0;
                    PaywallActivityNonSerializableArgsStore.INSTANCE.remove(num.intValue());
                    paywallActivityLauncher.currentNonSerializableArgsKey = null;
                }
                resultHandler.onActivityResult(result);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isActivityFinishing() {
        FragmentActivity activity;
        Activity activity2 = this.weakActivity.get();
        Fragment fragment = this.weakFragment.get();
        if (activity2 == null) {
            if ((fragment != null ? fragment.getActivity() : null) != null) {
            }
        } else if ((activity2 == null || !activity2.isFinishing()) && (fragment == null || (activity = fragment.getActivity()) == null || !activity.isFinishing())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(PaywallActivityLauncher paywallActivityLauncher, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            offering = null;
        }
        if ((i & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        paywallActivityLauncher.launch(offering, parcelizableFontProvider, z, z2, map);
    }

    public static /* synthetic */ void launch$default(PaywallActivityLauncher paywallActivityLauncher, String str, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        paywallActivityLauncher.launch(str, parcelizableFontProvider, z, z2);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            offering = null;
        }
        if ((i & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        paywallActivityLauncher.launchIfNeeded(offering, parcelizableFontProvider, z, z2, (Function1<? super CustomerInfo, Boolean>) function1);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, String str, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, PaywallDisplayCallback paywallDisplayCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            offering = null;
        }
        if ((i & 4) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        if ((i & 16) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i & 32) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeeded(str, offering, parcelizableFontProvider, z, z2, paywallDisplayCallback);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, String str, String str2, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, PaywallDisplayCallback paywallDisplayCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        if ((i & 16) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i & 32) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeeded(str, str2, parcelizableFontProvider, z, z2, paywallDisplayCallback);
    }

    public static /* synthetic */ void launchIfNeededWithOfferingId$default(PaywallActivityLauncher paywallActivityLauncher, String str, String str2, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, PaywallDisplayCallback paywallDisplayCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        if ((i & 32) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i & 64) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeededWithOfferingId(str, str2, presentedOfferingContext, parcelizableFontProvider, z, z2, paywallDisplayCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPaywallWithArgs(PaywallActivityArgs args) {
        if (isActivityFinishing()) {
            Logger.INSTANCE.e("Not displaying paywall because activity/fragment is finishing or has finished.");
        } else {
            this.activityResultLauncher.launch(args);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launchWithOfferingId$default(PaywallActivityLauncher paywallActivityLauncher, String str, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            parcelizableFontProvider = null;
        }
        ParcelizableFontProvider parcelizableFontProvider2 = parcelizableFontProvider;
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            map = MapsKt.emptyMap();
        }
        paywallActivityLauncher.launchWithOfferingId(str, presentedOfferingContext, parcelizableFontProvider2, z3, z4, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer storeNonSerializableArgsIfNeeded(PaywallPurchaseLogic purchaseLogic, PaywallListener listener) {
        if (purchaseLogic == null && listener == null) {
            return null;
        }
        int iStore = PaywallActivityNonSerializableArgsStore.INSTANCE.store(new PaywallActivityNonSerializableArgs(purchaseLogic, listener));
        this.currentNonSerializableArgsKey = Integer.valueOf(iStore);
        return Integer.valueOf(iStore);
    }

    public final void launch() {
        launch$default(this, null, null, false, false, null, 31, null);
    }

    public final void launch(Offering offering) {
        launch$default(this, offering, null, false, false, null, 30, null);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider) {
        launch$default(this, offering, parcelizableFontProvider, false, false, null, 28, null);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z) {
        launch$default(this, offering, parcelizableFontProvider, z, false, null, 24, null);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2) {
        launch$default(this, offering, parcelizableFontProvider, z, z2, null, 16, null);
    }

    public final void launch(Offering offering, ParcelizableFontProvider fontProvider, boolean shouldDisplayDismissButton, boolean edgeToEdge, Map<String, ? extends CustomVariableValue> customVariables) {
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext;
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        ActivityResultLauncher<PaywallActivityArgs> activityResultLauncher = this.activityResultLauncher;
        if (offering != null) {
            String identifier = offering.getIdentifier();
            Package r13 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r13 != null ? r13.getPresentedOfferingContext() : null);
        } else {
            idAndPresentedOfferingContext = null;
        }
        activityResultLauncher.launch(new PaywallActivityArgs((String) null, idAndPresentedOfferingContext, fontProvider, shouldDisplayDismissButton, edgeToEdge, false, (Map) customVariables, (Integer) null, WebmConstants.MkvEbmlElement.BLOCK, (DefaultConstructorMarker) null));
    }

    @Deprecated(message = "Use launch with offering instead", replaceWith = @ReplaceWith(expression = "launch(offering, fontProvider, shouldDisplayDismissButton, edgeToEdge)", imports = {"com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher"}))
    public final /* synthetic */ void launch(String offeringIdentifier, ParcelizableFontProvider fontProvider, boolean shouldDisplayDismissButton, boolean edgeToEdge) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        this.activityResultLauncher.launch(new PaywallActivityArgs((String) null, new OfferingSelection.IdAndPresentedOfferingContext(offeringIdentifier, null), fontProvider, shouldDisplayDismissButton, edgeToEdge, false, (Map) null, (Integer) null, WebmConstants.MkvEbmlElement.AUDIO, (DefaultConstructorMarker) null));
    }

    public final void launchIfNeeded(Offering offering, ParcelizableFontProvider parcelizableFontProvider, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, parcelizableFontProvider, false, false, shouldDisplayBlock, 12, null);
    }

    public final void launchIfNeeded(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, parcelizableFontProvider, z, false, shouldDisplayBlock, 8, null);
    }

    public final void launchIfNeeded(final Offering offering, final ParcelizableFontProvider fontProvider, final boolean shouldDisplayDismissButton, final boolean edgeToEdge, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        HelperFunctionsKt.shouldDisplayPaywall(shouldDisplayBlock, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext;
                if (z) {
                    PaywallActivityLauncher paywallActivityLauncher = PaywallActivityLauncher.this;
                    Offering offering2 = offering;
                    if (offering2 != null) {
                        String identifier = offering2.getIdentifier();
                        Package r2 = (Package) CollectionsKt.firstOrNull((List) offering2.getAvailablePackages());
                        idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r2 != null ? r2.getPresentedOfferingContext() : null);
                    } else {
                        idAndPresentedOfferingContext = null;
                    }
                    paywallActivityLauncher.launchPaywallWithArgs(new PaywallActivityArgs((String) null, idAndPresentedOfferingContext, fontProvider, shouldDisplayDismissButton, edgeToEdge, false, (Map) null, (Integer) null, WebmConstants.MkvEbmlElement.AUDIO, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    public final void launchIfNeeded(Offering offering, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, null, false, false, shouldDisplayBlock, 14, null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, (Offering) null, (ParcelizableFontProvider) null, false, false, (PaywallDisplayCallback) null, 62, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, (ParcelizableFontProvider) null, false, false, (PaywallDisplayCallback) null, 60, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, false, false, (PaywallDisplayCallback) null, 56, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, z, false, (PaywallDisplayCallback) null, 48, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, z, z2, (PaywallDisplayCallback) null, 32, (Object) null);
    }

    public final void launchIfNeeded(final String requiredEntitlementIdentifier, final Offering offering, final ParcelizableFontProvider fontProvider, final boolean shouldDisplayDismissButton, final boolean edgeToEdge, final PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        HelperFunctionsKt.shouldDisplayPaywall(HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier), new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PaywallDisplayCallback paywallDisplayCallback2 = paywallDisplayCallback;
                if (paywallDisplayCallback2 != null) {
                    paywallDisplayCallback2.onPaywallDisplayResult(z);
                }
                if (z) {
                    PaywallActivityLauncher paywallActivityLauncher = this;
                    String str = requiredEntitlementIdentifier;
                    Offering offering2 = offering;
                    OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = null;
                    if (offering2 != null) {
                        String identifier = offering2.getIdentifier();
                        Package r0 = (Package) CollectionsKt.firstOrNull((List) offering2.getAvailablePackages());
                        idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r0 != null ? r0.getPresentedOfferingContext() : null);
                    }
                    paywallActivityLauncher.launchPaywallWithArgs(new PaywallActivityArgs(str, idAndPresentedOfferingContext, fontProvider, shouldDisplayDismissButton, edgeToEdge, false, (Map) null, (Integer) null, WebmConstants.MkvEbmlElement.VIDEO, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    @Deprecated(message = "Use launchIfNeeded with offering instead", replaceWith = @ReplaceWith(expression = "launchIfNeeded(requiredEntitlementIdentifier, offering, fontProvider, shouldDisplayDismissButton, edgeToEdge, paywallDisplayCallback)", imports = {"com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher"}))
    public final /* synthetic */ void launchIfNeeded(final String requiredEntitlementIdentifier, final String offeringIdentifier, final ParcelizableFontProvider fontProvider, final boolean shouldDisplayDismissButton, final boolean edgeToEdge, final PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        HelperFunctionsKt.shouldDisplayPaywall(HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier), new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PaywallDisplayCallback paywallDisplayCallback2 = paywallDisplayCallback;
                if (paywallDisplayCallback2 != null) {
                    paywallDisplayCallback2.onPaywallDisplayResult(z);
                }
                if (z) {
                    this.launchPaywallWithArgs(new PaywallActivityArgs(requiredEntitlementIdentifier, new OfferingSelection.IdAndPresentedOfferingContext(offeringIdentifier, null), fontProvider, shouldDisplayDismissButton, edgeToEdge, false, (Map) null, (Integer) null, WebmConstants.MkvEbmlElement.VIDEO, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    public final void launchIfNeeded(Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, null, null, false, false, shouldDisplayBlock, 15, null);
    }

    @Deprecated(message = "Use launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions) instead for customVariables support", replaceWith = @ReplaceWith(expression = "launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).build())", imports = {}))
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, null, false, false, null, 120, null);
    }

    @Deprecated(message = "Use launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions) instead for customVariables support", replaceWith = @ReplaceWith(expression = "launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).build())", imports = {}))
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, false, false, null, 112, null);
    }

    @Deprecated(message = "Use launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions) instead for customVariables support", replaceWith = @ReplaceWith(expression = "launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).build())", imports = {}))
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z, false, null, 96, null);
    }

    @Deprecated(message = "Use launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions) instead for customVariables support", replaceWith = @ReplaceWith(expression = "launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).build())", imports = {}))
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z, z2, null, 64, null);
    }

    @Deprecated(message = "Use launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions) instead for customVariables support", replaceWith = @ReplaceWith(expression = "launchIfNeededWithOptions(PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).build())", imports = {}))
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider fontProvider, boolean shouldDisplayDismissButton, boolean edgeToEdge, PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOptions(new PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).setFontProvider(fontProvider).setShouldDisplayDismissButton(shouldDisplayDismissButton).setEdgeToEdge(edgeToEdge).setPaywallDisplayCallback(paywallDisplayCallback).build());
    }

    public final void launchIfNeededWithOptions(final PaywallActivityLaunchIfNeededOptions options) {
        Function1<CustomerInfo, Boolean> shouldDisplayBlock$revenuecatui_defaultsBc8Release;
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getRequiredEntitlementIdentifier() != null) {
            shouldDisplayBlock$revenuecatui_defaultsBc8Release = HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(options.getRequiredEntitlementIdentifier());
        } else {
            shouldDisplayBlock$revenuecatui_defaultsBc8Release = options.getShouldDisplayBlock$revenuecatui_defaultsBc8Release();
            Intrinsics.checkNotNull(shouldDisplayBlock$revenuecatui_defaultsBc8Release);
        }
        HelperFunctionsKt.shouldDisplayPaywall(shouldDisplayBlock$revenuecatui_defaultsBc8Release, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeededWithOptions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PaywallDisplayCallback paywallDisplayCallback$revenuecatui_defaultsBc8Release = options.getPaywallDisplayCallback();
                if (paywallDisplayCallback$revenuecatui_defaultsBc8Release != null) {
                    paywallDisplayCallback$revenuecatui_defaultsBc8Release.onPaywallDisplayResult(z);
                }
                if (z) {
                    boolean z2 = false;
                    this.launchPaywallWithArgs(new PaywallActivityArgs(options.getRequiredEntitlementIdentifier(), options.toOfferingSelection$revenuecatui_defaultsBc8Release(), options.getFontProvider(), options.getShouldDisplayDismissButton(), options.getEdgeToEdge(), z2, options.getCustomVariables$revenuecatui_defaultsBc8Release(), this.storeNonSerializableArgsIfNeeded(options.getPurchaseLogic(), options.getListener()), 32, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    @Deprecated(message = "Use launchWithOptions(PaywallActivityLaunchOptions) instead", replaceWith = @ReplaceWith(expression = "launchWithOptions(PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).build())", imports = {}))
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, null, false, false, null, 60, null);
    }

    @Deprecated(message = "Use launchWithOptions(PaywallActivityLaunchOptions) instead", replaceWith = @ReplaceWith(expression = "launchWithOptions(PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).build())", imports = {}))
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, false, false, null, 56, null);
    }

    @Deprecated(message = "Use launchWithOptions(PaywallActivityLaunchOptions) instead", replaceWith = @ReplaceWith(expression = "launchWithOptions(PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).build())", imports = {}))
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z, false, null, 48, null);
    }

    @Deprecated(message = "Use launchWithOptions(PaywallActivityLaunchOptions) instead", replaceWith = @ReplaceWith(expression = "launchWithOptions(PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).build())", imports = {}))
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z, z2, null, 32, null);
    }

    @Deprecated(message = "Use launchWithOptions(PaywallActivityLaunchOptions) instead", replaceWith = @ReplaceWith(expression = "launchWithOptions(PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).build())", imports = {}))
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider fontProvider, boolean shouldDisplayDismissButton, boolean edgeToEdge, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        launchWithOptions(new PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).setFontProvider(fontProvider).setShouldDisplayDismissButton(shouldDisplayDismissButton).setEdgeToEdge(edgeToEdge).setCustomVariables(customVariables).build());
    }

    public final void launchWithOptions(PaywallActivityLaunchOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        String str = null;
        boolean z = false;
        this.activityResultLauncher.launch(new PaywallActivityArgs(str, options.toOfferingSelection$revenuecatui_defaultsBc8Release(), options.getFontProvider(), options.getShouldDisplayDismissButton(), options.getEdgeToEdge(), z, options.getCustomVariables$revenuecatui_defaultsBc8Release(), storeNonSerializableArgsIfNeeded(options.getPurchaseLogic(), options.getListener()), 33, (DefaultConstructorMarker) null));
    }
}
