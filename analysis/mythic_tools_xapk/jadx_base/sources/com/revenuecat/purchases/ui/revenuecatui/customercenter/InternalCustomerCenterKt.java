package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.muxer.WebmConstants;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.composables.ErrorDialogKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterErrorViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.ArrowBackKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.CloseKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: InternalCustomerCenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a)\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\r\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u000e\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a;\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001aF\u0010\u001b\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b H\u0003¢\u0006\u0002\u0010!\u001a3\u0010\"\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0002\u0010%\u001a;\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0001¢\u0006\u0002\u0010,\u001a3\u0010&\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020-2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0002\u0010.\u001a)\u0010/\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0002\u0010\u000b\u001a\u0015\u00100\u001a\u0002012\u0006\u0010\u0006\u001a\u00020-H\u0003¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u0002042\u0006\u0010\u0006\u001a\u00020-H\u0003¢\u0006\u0002\u00105\u001a5\u00106\u001a\u00020*2\u0006\u00107\u001a\u0002082\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010;\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<²\u0006\n\u0010\u0006\u001a\u00020-X\u008a\u0084\u0002²\u0006\u0016\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u008a\u0084\u0002²\u0006\n\u0010>\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010@\u001a\u00020AX\u008a\u0084\u0002"}, d2 = {"previewConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "CustomerCenterErrorPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "CustomerCenterLoaded", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;", "onAction", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CustomerCenterLoadedPreview", "CustomerCenterLoadingPreview", "CustomerCenterMultiplePurchasesPreview", "CustomerCenterNavHost", "currentDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "customerCenterState", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CustomerCenterNavigationIcon", "navigationButtonType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CustomerCenterNoActiveScreenPreview", "CustomerCenterScaffold", "scaffoldConfig", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterScaffoldConfig;", "mainContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterScaffoldConfig;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "CustomerCenterTopBar", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterScaffoldConfig;Landroidx/compose/material3/TopAppBarScrollBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "InternalCustomerCenter", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;", "onDismiss", "(Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "MainScreenContent", "createColorScheme", "Landroidx/compose/material3/ColorScheme;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "createScaffoldState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/ScaffoldConfigData;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/ScaffoldConfigData;", "getCustomerCenterViewModel", "isDarkMode", "", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(ZLcom/revenuecat/purchases/customercenter/CustomerCenterListener;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;", "revenuecatui_defaultsBc8Release", "latestOnAction", "latestMessage", "", "contentAlpha", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class InternalCustomerCenterKt {
    private static final CustomerCenterConfigData previewConfigData = new CustomerCenterConfigData(MapsKt.mapOf(TuplesKt.to(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT, new CustomerCenterConfigData.Screen(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT, "Manage Subscription", "Manage subscription subtitle", CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("path-id-1", "Subscription", CustomerCenterConfigData.HelpPath.PathType.CANCEL, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, WebmConstants.MkvEbmlElement.BLOCK_GROUP, (DefaultConstructorMarker) null)), (CustomerCenterConfigData.ScreenOffering) null, 16, (DefaultConstructorMarker) null)), TuplesKt.to(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE, new CustomerCenterConfigData.Screen(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE, "No subscriptions found", "We can try checking your account for any previous purchases", CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("9q9719171o", "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, (DefaultConstructorMarker) null)), (CustomerCenterConfigData.ScreenOffering) null, 16, (DefaultConstructorMarker) null))), new CustomerCenterConfigData.Appearance((CustomerCenterConfigData.Appearance.ColorInformation) null, (CustomerCenterConfigData.Appearance.ColorInformation) null, 3, (DefaultConstructorMarker) null), new CustomerCenterConfigData.Localization("en_US", MapsKt.mapOf(TuplesKt.to("cancel", "Cancel"), TuplesKt.to(FirebaseAnalytics.Param.SUBSCRIPTION, "Subscription"))), new CustomerCenterConfigData.Support("test@revenuecat.com", (Boolean) null, (Boolean) null, new CustomerCenterConfigData.Support.SupportTickets(false, (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) null, (CustomerCenterConfigData.Support.SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null), 6, (DefaultConstructorMarker) null), (String) null, 16, (DefaultConstructorMarker) null);

    public static final void CustomerCenterErrorPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-117134989);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterErrorPreview)691@26885L235:InternalCustomerCenter.kt#5a5ul8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117134989, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterErrorPreview (InternalCustomerCenter.kt:690)");
            }
            InternalCustomerCenter(new CustomerCenterState.Error(new PurchasesError(PurchasesErrorCode.UnknownBackendError, null, 2, null)), PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(10.0f)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterErrorPreview.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                    invoke2(customerCenterAction);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterErrorPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InternalCustomerCenterKt.CustomerCenterErrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterLoaded(CustomerCenterState.Success success, Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i) {
        int i2;
        SnackbarHostState snackbarHostState;
        final CustomerCenterState.Success success2;
        BoxScopeInstance boxScopeInstance;
        final Function1<? super CustomerCenterAction, Unit> function12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1615276070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterLoaded)P(1)411@16555L32,413@16615L41,414@16682L202,420@16945L214,420@16890L269,428@17241L171,434@17418L809:InternalCustomerCenter.kt#5a5ul8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(success) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            success2 = success;
            function12 = function1;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1615276070, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoaded (InternalCustomerCenter.kt:410)");
            }
            composerStartRestartGroup.startReplaceGroup(526827882);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i3 >> 3) & 14);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(success.getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SENT), composerStartRestartGroup, 0);
            Boolean boolValueOf = Boolean.valueOf(success.getShowSupportTicketSuccessSnackbar());
            composerStartRestartGroup.startReplaceGroup(526840544);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(success) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            InternalCustomerCenterKt$CustomerCenterLoaded$1$1 internalCustomerCenterKt$CustomerCenterLoaded$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || internalCustomerCenterKt$CustomerCenterLoaded$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarHostState = snackbarHostState2;
                internalCustomerCenterKt$CustomerCenterLoaded$1$1RememberedValue = new InternalCustomerCenterKt$CustomerCenterLoaded$1$1(success, snackbarHostState2, stateRememberUpdatedState2, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(internalCustomerCenterKt$CustomerCenterLoaded$1$1RememberedValue);
            } else {
                snackbarHostState = snackbarHostState2;
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) internalCustomerCenterKt$CustomerCenterLoaded$1$1RememberedValue, composerStartRestartGroup, 0);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(success.isRefreshing() ? 0.5f : 1.0f, AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, "refreshAlpha", null, composerStartRestartGroup, 3120, 20);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1007762984, "C438@17566L24,435@17467L340,454@18043L178:InternalCustomerCenter.kt#5a5ul8");
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(-244583743);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterLoaded$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setAlpha(InternalCustomerCenterKt.CustomerCenterLoaded$lambda$16(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxSize$default2, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 44801414, "C440@17616L181:InternalCustomerCenter.kt#5a5ul8");
            CustomerCenterNavHost(success.getCurrentDestination(), success, function1, null, composerStartRestartGroup, (i3 << 3) & PointerIconCompat.TYPE_TEXT, 8);
            success2 = success;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(-244573442);
            ComposerKt.sourceInformation(composerStartRestartGroup, "449@17922L101");
            if (success2.isRefreshing()) {
                boxScopeInstance = boxScopeInstance2;
                ProgressIndicatorKt.m3947CircularProgressIndicatorLxG7B9w(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0L, 0.0f, 0L, 0, composerStartRestartGroup, 0, 30);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                boxScopeInstance = boxScopeInstance2;
            }
            composerStartRestartGroup.endReplaceGroup();
            function12 = function1;
            SnackbarHostKt.SnackbarHost(snackbarHostState, PaddingKt.m2037padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), Dp.m9114constructorimpl(16.0f)), null, composerStartRestartGroup, 6, 4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoaded.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    InternalCustomerCenterKt.CustomerCenterLoaded(success2, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<CustomerCenterAction, Unit> CustomerCenterLoaded$lambda$13(State<? extends Function1<? super CustomerCenterAction, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CustomerCenterLoaded$lambda$14(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CustomerCenterLoaded$lambda$16(State<Float> state) {
        return state.getValue().floatValue();
    }

    public static final void CustomerCenterLoadedPreview(Composer composer, final int i) {
        List<CustomerCenterConfigData.HelpPath> listEmptyList;
        ArrayList arrayListEmptyList;
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerStartRestartGroup = composer.startRestartGroup(899134290);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterLoadedPreview)703@27194L636:InternalCustomerCenter.kt#5a5ul8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(899134290, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoadedPreview (InternalCustomerCenter.kt:702)");
            }
            CustomerCenterConfigData customerCenterConfigData = previewConfigData;
            List listListOf = CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing());
            CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
            if (managementScreen == null || (listEmptyList = managementScreen.getPaths()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<CustomerCenterConfigData.HelpPath> list = listEmptyList;
            CustomerCenterConfigData.Screen managementScreen2 = customerCenterConfigData.getManagementScreen();
            if (managementScreen2 == null || (paths = managementScreen2.getPaths()) == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : paths) {
                    if (((CustomerCenterConfigData.HelpPath) obj).getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                        arrayList.add(obj);
                    }
                }
                arrayListEmptyList = arrayList;
            }
            InternalCustomerCenter(new CustomerCenterState.Success(customerCenterConfigData, listListOf, list, arrayListEmptyList, null, null, null, null, null, false, false, 2032, null), PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(10.0f)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadedPreview.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                    invoke2(customerCenterAction);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadedPreview.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InternalCustomerCenterKt.CustomerCenterLoadedPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void CustomerCenterLoadingPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(626880743);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterLoadingPreview)679@26631L181:InternalCustomerCenter.kt#5a5ul8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626880743, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoadingPreview (InternalCustomerCenter.kt:678)");
            }
            InternalCustomerCenter(CustomerCenterState.Loading.INSTANCE, PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(10.0f)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadingPreview.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                    invoke2(customerCenterAction);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, composerStartRestartGroup, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadingPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InternalCustomerCenterKt.CustomerCenterLoadingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void CustomerCenterMultiplePurchasesPreview(Composer composer, final int i) {
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        List<CustomerCenterConfigData.HelpPath> paths;
        List<CustomerCenterConfigData.HelpPath> paths2;
        Composer composerStartRestartGroup = composer.startRestartGroup(348505677);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterMultiplePurchasesPreview)722@27915L946:InternalCustomerCenter.kt#5a5ul8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(348505677, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterMultiplePurchasesPreview (InternalCustomerCenter.kt:721)");
            }
            CustomerCenterConfigData customerCenterConfigData = previewConfigData;
            List listListOf = CollectionsKt.listOf((Object[]) new PurchaseInformation[]{CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationYearlyExpiring()});
            CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
            if (managementScreen == null || (paths2 = managementScreen.getPaths()) == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : paths2) {
                    CustomerCenterConfigData.HelpPath helpPath = (CustomerCenterConfigData.HelpPath) obj;
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE || helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL) {
                        arrayList.add(obj);
                    }
                }
                arrayListEmptyList = arrayList;
            }
            List list = arrayListEmptyList;
            CustomerCenterConfigData.Screen managementScreen2 = previewConfigData.getManagementScreen();
            if (managementScreen2 == null || (paths = managementScreen2.getPaths()) == null) {
                arrayListEmptyList2 = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : paths) {
                    if (((CustomerCenterConfigData.HelpPath) obj2).getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                        arrayList2.add(obj2);
                    }
                }
                arrayListEmptyList2 = arrayList2;
            }
            InternalCustomerCenter(new CustomerCenterState.Success(customerCenterConfigData, listListOf, list, arrayListEmptyList2, null, null, null, null, null, false, false, 2032, null), PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(10.0f)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                    invoke2(customerCenterAction);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CustomerCenterNavHost(final CustomerCenterDestination customerCenterDestination, final CustomerCenterState.Success success, final Function1<? super CustomerCenterAction, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Modifier modifier2;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composer2;
        final Modifier modifier3;
        Function0 function0;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1951868238);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterNavHost)P(!2,3)473@18580L232,482@18890L2264,471@18496L2658,540@21469L55,541@21550L49,537@21272L568:InternalCustomerCenter.kt#5a5ul8");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            obj = customerCenterDestination;
        } else if ((i & 6) == 0) {
            obj = customerCenterDestination;
            i3 = (composerStartRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = customerCenterDestination;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(success) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1951868238, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavHost (InternalCustomerCenter.kt:470)");
                }
                composerStartRestartGroup.startReplaceGroup(1852369294);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(success);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<AnimatedContentTransitionScope<CustomerCenterDestination>, ContentTransform>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final ContentTransform invoke(AnimatedContentTransitionScope<CustomerCenterDestination> AnimatedContent) {
                            Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                            return CustomerCenterAnimations.INSTANCE.getTransitionForNavigation(AnimatedContent.getInitialState(), AnimatedContent.getTargetState(), success.getNavigationState());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                boolean z = true;
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = companion;
                AnimatedContentKt.AnimatedContent(obj, modifier4, (Function1) objRememberedValue, null, "CustomerCenterScreens", null, ComposableLambdaKt.rememberComposableLambda(1269377464, true, new Function4<AnimatedContentScope, CustomerCenterDestination, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavHost.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, CustomerCenterDestination customerCenterDestination2, Composer composer3, Integer num) {
                        invoke(animatedContentScope, customerCenterDestination2, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope AnimatedContent, final CustomerCenterDestination destination, Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        ComposerKt.sourceInformation(composer3, "C:InternalCustomerCenter.kt#5a5ul8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1269377464, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavHost.<anonymous> (InternalCustomerCenter.kt:483)");
                        }
                        if (destination instanceof CustomerCenterDestination.Main) {
                            composer3.startReplaceGroup(1775650687);
                            ComposerKt.sourceInformation(composer3, "485@19003L126");
                            InternalCustomerCenterKt.MainScreenContent(success, function1, composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.FeedbackSurvey) {
                            composer3.startReplaceGroup(1775865145);
                            ComposerKt.sourceInformation(composer3, "492@19222L36");
                            FeedbackSurveyViewKt.FeedbackSurveyView(((CustomerCenterDestination.FeedbackSurvey) destination).getData(), composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.PromotionalOffer) {
                            composer3.startReplaceGroup(1776013542);
                            ComposerKt.sourceInformation(composer3, "500@19653L145,503@19832L133,496@19353L631");
                            PromotionalOfferData data = ((CustomerCenterDestination.PromotionalOffer) destination).getData();
                            CustomerCenterConfigData.Appearance appearance = success.getCustomerCenterConfigData().getAppearance();
                            CustomerCenterConfigData.Localization localization = success.getCustomerCenterConfigData().getLocalization();
                            composer3.startReplaceGroup(750037078);
                            ComposerKt.sourceInformation(composer3, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                            boolean zChanged = composer3.changed(function1);
                            final Function1<CustomerCenterAction, Unit> function12 = function1;
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = (Function1) new Function1<SubscriptionOption, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SubscriptionOption subscriptionOption) {
                                        invoke2(subscriptionOption);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SubscriptionOption subscriptionOption) {
                                        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
                                        function12.invoke(new CustomerCenterAction.PurchasePromotionalOffer(subscriptionOption));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            Function1 function13 = (Function1) objRememberedValue2;
                            composer3.endReplaceGroup();
                            composer3.startReplaceGroup(750042794);
                            ComposerKt.sourceInformation(composer3, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(function1) | ((((i5 & 112) ^ 48) > 32 && composer3.changed(destination)) || (i5 & 48) == 32);
                            final Function1<CustomerCenterAction, Unit> function14 = function1;
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$2$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function14.invoke(new CustomerCenterAction.DismissPromotionalOffer(((CustomerCenterDestination.PromotionalOffer) destination).getData().getOriginalPath()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            composer3.endReplaceGroup();
                            PromotionalOfferScreenKt.PromotionalOfferScreen(data, appearance, localization, function13, (Function0) objRememberedValue3, null, composer3, 0, 32);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.SelectedPurchaseDetail) {
                            composer3.startReplaceGroup(1776733331);
                            ComposerKt.sourceInformation(composer3, "510@20085L426");
                            SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(success.getCustomerCenterConfigData().getSupport().getEmail(), success.getCustomerCenterConfigData().getLocalization(), ((CustomerCenterDestination.SelectedPurchaseDetail) destination).getPurchaseInformation(), success.getDetailScreenPaths(), null, function1, composer3, 0, 16);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.VirtualCurrencyBalances) {
                            composer3.startReplaceGroup(1777251093);
                            ComposerKt.sourceInformation(composer3, "520@20613L232");
                            VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreen(success.getCustomerCenterConfigData().getAppearance(), success.getCustomerCenterConfigData().getLocalization(), null, null, composer3, 0, 12);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.CreateSupportTicket) {
                            composer3.startReplaceGroup(1777576872);
                            ComposerKt.sourceInformation(composer3, "527@20943L181");
                            CreateSupportTicketViewKt.CreateSupportTicketView(((CustomerCenterDestination.CreateSupportTicket) destination).getData(), success.getCustomerCenterConfigData().getLocalization(), null, null, null, composer3, 0, 28);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(1777791485);
                            composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 1597440 | ((i3 >> 6) & 112), 40);
                if (success.getRestorePurchasesState() != null) {
                    RestorePurchasesState restorePurchasesState = success.getRestorePurchasesState();
                    CustomerCenterConfigData.Localization localization = success.getCustomerCenterConfigData().getLocalization();
                    composer2.startReplaceGroup(1852461565);
                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                    int i5 = i3 & 896;
                    boolean z2 = i5 == 256;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(CustomerCenterAction.DismissRestoreDialog.INSTANCE);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function02 = (Function0) objRememberedValue2;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(1852464151);
                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                    boolean z3 = i5 == 256;
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(CustomerCenterAction.PerformRestore.INSTANCE);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function03 = (Function0) objRememberedValue3;
                    composer2.endReplaceGroup();
                    final String email = success.getCustomerCenterConfigData().getSupport().getEmail();
                    composer2.startReplaceGroup(1852468783);
                    ComposerKt.sourceInformation(composer2, "*543@21723L92");
                    if (email == null) {
                        function0 = null;
                    } else {
                        composer2.startReplaceGroup(750103265);
                        ComposerKt.sourceInformation(composer2, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        if (i5 != 256) {
                            z = false;
                        }
                        boolean zChanged = z | composer2.changed(email);
                        Object objRememberedValue4 = composer2.rememberedValue();
                        if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$5$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(new CustomerCenterAction.ContactSupport(email));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        function0 = (Function0) objRememberedValue4;
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                    RestorePurchasesDialogKt.RestorePurchasesDialog(restorePurchasesState, localization, function02, function03, function0, composer2, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavHost.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        InternalCustomerCenterKt.CustomerCenterNavHost(customerCenterDestination, success, function1, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.startReplaceGroup(1852369294);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(success);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = (Function1) new Function1<AnimatedContentTransitionScope<CustomerCenterDestination>, ContentTransform>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<CustomerCenterDestination> AnimatedContent) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        return CustomerCenterAnimations.INSTANCE.getTransitionForNavigation(AnimatedContent.getInitialState(), AnimatedContent.getTargetState(), success.getNavigationState());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
                boolean z4 = true;
                composer2 = composerStartRestartGroup;
                Modifier modifier42 = companion;
                AnimatedContentKt.AnimatedContent(obj, modifier42, (Function1) objRememberedValue, null, "CustomerCenterScreens", null, ComposableLambdaKt.rememberComposableLambda(1269377464, true, new Function4<AnimatedContentScope, CustomerCenterDestination, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavHost.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, CustomerCenterDestination customerCenterDestination2, Composer composer3, Integer num) {
                        invoke(animatedContentScope, customerCenterDestination2, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope AnimatedContent, final CustomerCenterDestination destination, Composer composer3, int i52) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        ComposerKt.sourceInformation(composer3, "C:InternalCustomerCenter.kt#5a5ul8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1269377464, i52, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavHost.<anonymous> (InternalCustomerCenter.kt:483)");
                        }
                        if (destination instanceof CustomerCenterDestination.Main) {
                            composer3.startReplaceGroup(1775650687);
                            ComposerKt.sourceInformation(composer3, "485@19003L126");
                            InternalCustomerCenterKt.MainScreenContent(success, function1, composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.FeedbackSurvey) {
                            composer3.startReplaceGroup(1775865145);
                            ComposerKt.sourceInformation(composer3, "492@19222L36");
                            FeedbackSurveyViewKt.FeedbackSurveyView(((CustomerCenterDestination.FeedbackSurvey) destination).getData(), composer3, 0);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.PromotionalOffer) {
                            composer3.startReplaceGroup(1776013542);
                            ComposerKt.sourceInformation(composer3, "500@19653L145,503@19832L133,496@19353L631");
                            PromotionalOfferData data = ((CustomerCenterDestination.PromotionalOffer) destination).getData();
                            CustomerCenterConfigData.Appearance appearance = success.getCustomerCenterConfigData().getAppearance();
                            CustomerCenterConfigData.Localization localization2 = success.getCustomerCenterConfigData().getLocalization();
                            composer3.startReplaceGroup(750037078);
                            ComposerKt.sourceInformation(composer3, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(function1);
                            final Function1<? super CustomerCenterAction, Unit> function12 = function1;
                            Object objRememberedValue22 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue22 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue22 = (Function1) new Function1<SubscriptionOption, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SubscriptionOption subscriptionOption) {
                                        invoke2(subscriptionOption);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SubscriptionOption subscriptionOption) {
                                        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
                                        function12.invoke(new CustomerCenterAction.PurchasePromotionalOffer(subscriptionOption));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue22);
                            }
                            Function1 function13 = (Function1) objRememberedValue22;
                            composer3.endReplaceGroup();
                            composer3.startReplaceGroup(750042794);
                            ComposerKt.sourceInformation(composer3, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                            boolean zChanged22 = composer3.changed(function1) | ((((i52 & 112) ^ 48) > 32 && composer3.changed(destination)) || (i52 & 48) == 32);
                            final Function1<? super CustomerCenterAction, Unit> function14 = function1;
                            Object objRememberedValue32 = composer3.rememberedValue();
                            if (zChanged22 || objRememberedValue32 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue32 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavHost$2$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function14.invoke(new CustomerCenterAction.DismissPromotionalOffer(((CustomerCenterDestination.PromotionalOffer) destination).getData().getOriginalPath()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue32);
                            }
                            composer3.endReplaceGroup();
                            PromotionalOfferScreenKt.PromotionalOfferScreen(data, appearance, localization2, function13, (Function0) objRememberedValue32, null, composer3, 0, 32);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.SelectedPurchaseDetail) {
                            composer3.startReplaceGroup(1776733331);
                            ComposerKt.sourceInformation(composer3, "510@20085L426");
                            SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(success.getCustomerCenterConfigData().getSupport().getEmail(), success.getCustomerCenterConfigData().getLocalization(), ((CustomerCenterDestination.SelectedPurchaseDetail) destination).getPurchaseInformation(), success.getDetailScreenPaths(), null, function1, composer3, 0, 16);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.VirtualCurrencyBalances) {
                            composer3.startReplaceGroup(1777251093);
                            ComposerKt.sourceInformation(composer3, "520@20613L232");
                            VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreen(success.getCustomerCenterConfigData().getAppearance(), success.getCustomerCenterConfigData().getLocalization(), null, null, composer3, 0, 12);
                            composer3.endReplaceGroup();
                        } else if (destination instanceof CustomerCenterDestination.CreateSupportTicket) {
                            composer3.startReplaceGroup(1777576872);
                            ComposerKt.sourceInformation(composer3, "527@20943L181");
                            CreateSupportTicketViewKt.CreateSupportTicketView(((CustomerCenterDestination.CreateSupportTicket) destination).getData(), success.getCustomerCenterConfigData().getLocalization(), null, null, null, composer3, 0, 28);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(1777791485);
                            composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 1597440 | ((i3 >> 6) & 112), 40);
                if (success.getRestorePurchasesState() != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterNavigationIcon(final CustomerCenterState.NavigationButtonType navigationButtonType, final Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-501948109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterNavigationIcon)393@16027L70,395@16099L288,393@16006L381:InternalCustomerCenter.kt#5a5ul8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(navigationButtonType) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-501948109, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavigationIcon (InternalCustomerCenter.kt:392)");
            }
            composerStartRestartGroup.startReplaceGroup(1087660344);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavigationIcon$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function1.invoke(CustomerCenterAction.NavigationButtonPressed.INSTANCE);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-1324873520, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavigationIcon.2

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavigationIcon$2$WhenMappings */
                /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[CustomerCenterState.NavigationButtonType.values().length];
                        try {
                            iArr[CustomerCenterState.NavigationButtonType.BACK.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[CustomerCenterState.NavigationButtonType.CLOSE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ImageVector arrowBack;
                    ComposerKt.sourceInformation(composer2, "C396@16109L272:InternalCustomerCenter.kt#5a5ul8");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1324873520, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavigationIcon.<anonymous> (InternalCustomerCenter.kt:396)");
                    }
                    int i4 = WhenMappings.$EnumSwitchMapping$0[navigationButtonType.ordinal()];
                    if (i4 == 1) {
                        arrowBack = ArrowBackKt.getArrowBack();
                    } else {
                        if (i4 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrowBack = CloseKt.getClose();
                    }
                    IconKt.m3736Iconww6aTOc(arrowBack, (String) null, (Modifier) null, 0L, composer2, 48, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavigationIcon.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    InternalCustomerCenterKt.CustomerCenterNavigationIcon(navigationButtonType, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void CustomerCenterNoActiveScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(595047360);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterNoActiveScreenPreview)662@26187L369:InternalCustomerCenter.kt#5a5ul8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(595047360, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNoActiveScreenPreview (InternalCustomerCenter.kt:661)");
            }
            InternalCustomerCenter(new CustomerCenterState.Success(previewConfigData, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, null, null, null, null, false, false, 2032, null), PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(10.0f)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                    invoke2(customerCenterAction);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CustomerCenterScaffold(final Function1<? super CustomerCenterAction, Unit> function1, final CustomerCenterScaffoldConfig customerCenterScaffoldConfig, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-132697204);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterScaffold)P(2,3,1)325@13853L194,332@14055L307,323@13722L640:InternalCustomerCenter.kt#5a5ul8");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(customerCenterScaffoldConfig) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-132697204, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffold (InternalCustomerCenter.kt:316)");
                }
                composerStartRestartGroup.startReplaceGroup(-377111390);
                ComposerKt.sourceInformation(composerStartRestartGroup, "318@13650L34");
                final TopAppBarScrollBehavior topAppBarScrollBehaviorExitUntilCollapsedScrollBehavior = (customerCenterScaffoldConfig.getTitle() == null && customerCenterScaffoldConfig.getShouldUseLargeTopBar()) ? TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(null, null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 15) : null;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier5 = modifier4;
                ScaffoldKt.m3981ScaffoldTvnljyQ(ModifierExtensionsKt.applyIfNotNull(modifier4, topAppBarScrollBehaviorExitUntilCollapsedScrollBehavior, new Function2<Modifier, TopAppBarScrollBehavior, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.1
                    @Override // kotlin.jvm.functions.Function2
                    public final Modifier invoke(Modifier applyIfNotNull, TopAppBarScrollBehavior it) {
                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return NestedScrollModifierKt.nestedScroll$default(applyIfNotNull, it.getNestedScrollConnection(), null, 2, null);
                    }
                }), ComposableLambdaKt.rememberComposableLambda(422219848, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C326@13867L170:InternalCustomerCenter.kt#5a5ul8");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(422219848, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffold.<anonymous> (InternalCustomerCenter.kt:326)");
                        }
                        InternalCustomerCenterKt.CustomerCenterTopBar(customerCenterScaffoldConfig, topAppBarScrollBehaviorExitUntilCollapsedScrollBehavior, function1, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-50242659, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                        invoke(paddingValues, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PaddingValues paddingValues, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                        ComposerKt.sourceInformation(composer2, "C333@14082L274:InternalCustomerCenter.kt#5a5ul8");
                        if ((i5 & 6) == 0) {
                            i5 |= composer2.changed(paddingValues) ? 4 : 2;
                        }
                        if ((i5 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-50242659, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffold.<anonymous> (InternalCustomerCenter.kt:333)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, centerHorizontally, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1951094333, "C340@14333L13:InternalCustomerCenter.kt#5a5ul8");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        InternalCustomerCenterKt.CustomerCenterScaffold(function1, customerCenterScaffoldConfig, modifier3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i3 & 1171) == 1170) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.startReplaceGroup(-377111390);
            ComposerKt.sourceInformation(composerStartRestartGroup, "318@13650L34");
            if (customerCenterScaffoldConfig.getTitle() == null) {
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier52 = modifier4;
                ScaffoldKt.m3981ScaffoldTvnljyQ(ModifierExtensionsKt.applyIfNotNull(modifier4, topAppBarScrollBehaviorExitUntilCollapsedScrollBehavior, new Function2<Modifier, TopAppBarScrollBehavior, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.1
                    @Override // kotlin.jvm.functions.Function2
                    public final Modifier invoke(Modifier applyIfNotNull, TopAppBarScrollBehavior it) {
                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return NestedScrollModifierKt.nestedScroll$default(applyIfNotNull, it.getNestedScrollConnection(), null, 2, null);
                    }
                }), ComposableLambdaKt.rememberComposableLambda(422219848, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C326@13867L170:InternalCustomerCenter.kt#5a5ul8");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(422219848, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffold.<anonymous> (InternalCustomerCenter.kt:326)");
                        }
                        InternalCustomerCenterKt.CustomerCenterTopBar(customerCenterScaffoldConfig, topAppBarScrollBehaviorExitUntilCollapsedScrollBehavior, function1, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-50242659, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                        invoke(paddingValues, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PaddingValues paddingValues, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                        ComposerKt.sourceInformation(composer2, "C333@14082L274:InternalCustomerCenter.kt#5a5ul8");
                        if ((i5 & 6) == 0) {
                            i5 |= composer2.changed(paddingValues) ? 4 : 2;
                        }
                        if ((i5 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-50242659, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffold.<anonymous> (InternalCustomerCenter.kt:333)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, centerHorizontally, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1951094333, "C340@14333L13:InternalCustomerCenter.kt#5a5ul8");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier52;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterTopBar(final CustomerCenterScaffoldConfig customerCenterScaffoldConfig, TopAppBarScrollBehavior topAppBarScrollBehavior, final Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i) {
        int i2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Composer composerStartRestartGroup = composer.startRestartGroup(317175815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterTopBar)P(1,2)353@14689L11,354@14760L11,355@14826L11,356@14903L11,352@14633L301:InternalCustomerCenter.kt#5a5ul8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(customerCenterScaffoldConfig) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(topAppBarScrollBehavior) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(317175815, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar (InternalCustomerCenter.kt:351)");
            }
            TopAppBarColors topAppBarColorsM4504topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m4504topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 16);
            if (customerCenterScaffoldConfig.getShouldUseLargeTopBar()) {
                composerStartRestartGroup.startReplaceGroup(1321464226);
                ComposerKt.sourceInformation(composerStartRestartGroup, "360@15026L77,363@15134L200,359@14990L429");
                AppBarKt.m3302LargeTopAppBaroKE7A98(ComposableLambdaKt.rememberComposableLambda(391648475, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C*361@15072L15:InternalCustomerCenter.kt#5a5ul8");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(391648475, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:361)");
                        }
                        String title = customerCenterScaffoldConfig.getTitle();
                        if (title != null) {
                            TextKt.m4286Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131070);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(389814109, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C364@15152L168:InternalCustomerCenter.kt#5a5ul8");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(389814109, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:364)");
                        }
                        InternalCustomerCenterKt.CustomerCenterNavigationIcon(customerCenterScaffoldConfig.getNavigationButtonType(), function1, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, 0.0f, 0.0f, null, topAppBarColorsM4504topAppBarColorszjMxDiM, topAppBarScrollBehavior, composerStartRestartGroup, ((i2 << 21) & 234881024) | 390, Imgproc.COLOR_YUV2BGRA_YVYU);
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                composerStartRestartGroup.startReplaceGroup(1321910068);
                ComposerKt.sourceInformation(composerStartRestartGroup, "374@15472L77,377@15580L200,373@15441L379");
                AppBarKt.m3306TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1110666087, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C*375@15518L15:InternalCustomerCenter.kt#5a5ul8");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1110666087, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:375)");
                        }
                        String title = customerCenterScaffoldConfig.getTitle();
                        if (title != null) {
                            TextKt.m4286Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131070);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(237000485, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C378@15598L168:InternalCustomerCenter.kt#5a5ul8");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(237000485, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:378)");
                        }
                        InternalCustomerCenterKt.CustomerCenterNavigationIcon(customerCenterScaffoldConfig.getNavigationButtonType(), function1, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), null, 0.0f, null, topAppBarColorsM4504topAppBarColorszjMxDiM, null, composerStartRestartGroup, 390, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    InternalCustomerCenterKt.CustomerCenterTopBar(customerCenterScaffoldConfig, topAppBarScrollBehavior2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fa  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void InternalCustomerCenter(Modifier modifier, CustomerCenterListener customerCenterListener, CustomerCenterViewModel customerCenterViewModel, final Function0 onDismiss, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        CustomerCenterListener customerCenterListener2;
        int i4;
        Modifier.Companion companion;
        Continuation continuation;
        int i5;
        final CustomerCenterViewModel customerCenterViewModel2;
        CustomerCenterListener customerCenterListener3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Object objRememberedValue;
        int i11;
        Object objRememberedValue2;
        CustomerCenterListener customerCenterListener4;
        int i12;
        int i13;
        Object objRememberedValue3;
        int i14;
        Object objRememberedValue4;
        LifecycleOwner lifecycleOwner;
        Activity activity;
        int i15;
        Object objRememberedValue5;
        int i16;
        int i17;
        Object objRememberedValue6;
        PurchasesError value;
        int i18;
        int i19;
        Object objRememberedValue7;
        final Modifier modifier3;
        final CustomerCenterViewModel customerCenterViewModel3;
        final CustomerCenterListener customerCenterListener5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i20;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(220814959);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InternalCustomerCenter)P(1!1,3)94@5258L11,95@5287L21,97@5350L60,97@5314L96,101@5445L29,102@5500L24,103@5556L7,105@5623L114,105@5569L168,111@5764L51,111@5743L72,121@6417L7,123@6503L676,123@6470L709,144@7197L71,144@7185L83,158@7517L2181,155@7441L2264:InternalCustomerCenter.kt#5a5ul8");
        int i21 = i2 & 1;
        if (i21 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i22 = i2 & 2;
        if (i22 == 0) {
            if ((i & 48) == 0) {
                customerCenterListener2 = customerCenterListener;
                i3 |= composerStartRestartGroup.changedInstance(customerCenterListener2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i20 = 128;
                    i3 |= i20;
                } else {
                    if ((i & 512) == 0 ? composerStartRestartGroup.changed(customerCenterViewModel) : composerStartRestartGroup.changedInstance(customerCenterViewModel)) {
                        i20 = 256;
                    }
                    i3 |= i20;
                }
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@5132L21,88@5083L106");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i21 == 0 ? Modifier.INSTANCE : modifier2;
                    CustomerCenterListener customerCenterListener6 = i22 == 0 ? null : customerCenterListener2;
                    if ((i2 & 4) == 0) {
                        i5 = 0;
                        CustomerCenterViewModel customerCenterViewModel4 = getCustomerCenterViewModel(DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0), customerCenterListener6, null, null, composerStartRestartGroup, i4 & 112, 12);
                        continuation = null;
                        customerCenterListener3 = customerCenterListener6;
                        i6 = i4 & (-897);
                        customerCenterViewModel2 = customerCenterViewModel4;
                    } else {
                        continuation = null;
                        i5 = 0;
                        customerCenterViewModel2 = customerCenterViewModel;
                        customerCenterListener3 = customerCenterListener6;
                        i6 = i4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    companion = modifier2;
                    continuation = null;
                    i5 = 0;
                    i6 = i4;
                    customerCenterViewModel2 = customerCenterViewModel;
                    customerCenterListener3 = customerCenterListener2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(220814959, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter (InternalCustomerCenter.kt:93)");
                }
                ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, i5);
                Boolean boolValueOf = Boolean.valueOf(zIsSystemInDarkTheme);
                composerStartRestartGroup.startReplaceGroup(392046750);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                i7 = (i6 & 896) ^ 384;
                if (i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) {
                    i8 = 1;
                    if ((i6 & 384) != 256) {
                        i9 = i5;
                    }
                    i10 = i9 | (composerStartRestartGroup.changed(colorScheme) ? 1 : 0) | (composerStartRestartGroup.changed(zIsSystemInDarkTheme) ? 1 : 0);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (i10 != 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$1$1(customerCenterViewModel2, colorScheme, zIsSystemInDarkTheme, continuation);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(colorScheme, boolValueOf, (Function2) objRememberedValue, composerStartRestartGroup, i5);
                    i11 = i6;
                    State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(customerCenterViewModel2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Context context = (Context) objConsume;
                    Boolean boolValueOf2 = Boolean.valueOf(!(InternalCustomerCenter$lambda$1(stateCollectAsStateWithLifecycle) instanceof CustomerCenterState.Success));
                    composerStartRestartGroup.startReplaceGroup(392055540);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                    if (i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) {
                        customerCenterListener4 = customerCenterListener3;
                        if ((i11 & 384) != 256) {
                            i12 = 0;
                        }
                        i13 = i12 | (zChanged ? 1 : 0);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (i13 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$2$1(customerCenterViewModel2, stateCollectAsStateWithLifecycle, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
                        Unit unit = Unit.INSTANCE;
                        composerStartRestartGroup.startReplaceGroup(392059989);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        i14 = ((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (i14 != 0 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$3$1(customerCenterViewModel2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, 6);
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume2;
                        activity = ContextExtensionsKt.getActivity(context);
                        composerStartRestartGroup.startReplaceGroup(392084262);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        i15 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (composerStartRestartGroup.changedInstance(activity) ? 1 : 0) | (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 1 : 0);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (i15 != 0 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new InternalCustomerCenterKt$InternalCustomerCenter$4$1(lifecycleOwner, customerCenterViewModel2, activity);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceGroup(392105865);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        i16 = i11 & 7168;
                        i17 = (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (i16 == 2048 ? i8 : 0);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (i17 != 0 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    customerCenterViewModel2.onNavigationButtonPressed(context, onDismiss);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i23 = i8;
                        BackHandlerKt.BackHandler(false, (Function0) objRememberedValue6, composerStartRestartGroup, 0, i23);
                        value = customerCenterViewModel2.getActionError().getValue();
                        composerStartRestartGroup.startReplaceGroup(392109318);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*150@7359L27,149@7317L112");
                        if (value != null) {
                            i18 = 0;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1614414492);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                            int i24 = ((i7 <= 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i23;
                            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (i24 != 0 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = (KFunction) new InternalCustomerCenterKt$InternalCustomerCenter$6$1$1(customerCenterViewModel2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i18 = 0;
                            ErrorDialogKt.ErrorDialog((Function0) ((KFunction) objRememberedValue8), value.getMessage(), composerStartRestartGroup, 0);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CustomerCenterState customerCenterStateInternalCustomerCenter$lambda$1 = InternalCustomerCenter$lambda$1(stateCollectAsStateWithLifecycle);
                        composerStartRestartGroup.startReplaceGroup(392118215);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        int i25 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? i18 : i23) | (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
                        if (i16 == 2048) {
                            i18 = i23;
                        }
                        i19 = i25 | i18;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (i19 != 0 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = (Function1) new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1

                                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$1", f = "InternalCustomerCenter.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ CustomerCenterViewModel $viewModel;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(CustomerCenterViewModel customerCenterViewModel, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$viewModel = customerCenterViewModel;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$viewModel, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$viewModel.restorePurchases(this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$2, reason: invalid class name */
                                /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$2", f = "InternalCustomerCenter.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
                                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ CustomerCenterViewModel $viewModel;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass2(CustomerCenterViewModel customerCenterViewModel, Continuation<? super AnonymousClass2> continuation) {
                                        super(2, continuation);
                                        this.$viewModel = customerCenterViewModel;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass2(this.$viewModel, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$viewModel.dismissRestoreDialog(this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$3, reason: invalid class name */
                                /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$3", f = "InternalCustomerCenter.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
                                static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ CustomerCenterAction $action;
                                    final /* synthetic */ Activity $activity;
                                    final /* synthetic */ CustomerCenterViewModel $viewModel;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass3(CustomerCenterViewModel customerCenterViewModel, CustomerCenterAction customerCenterAction, Activity activity, Continuation<? super AnonymousClass3> continuation) {
                                        super(2, continuation);
                                        this.$viewModel = customerCenterViewModel;
                                        this.$action = customerCenterAction;
                                        this.$activity = activity;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass3(this.$viewModel, this.$action, this.$activity, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$viewModel.onAcceptedPromotionalOffer(((CustomerCenterAction.PurchasePromotionalOffer) this.$action).getSubscriptionOption(), this.$activity, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                                    invoke2(customerCenterAction);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(CustomerCenterAction action) {
                                    Intrinsics.checkNotNullParameter(action, "action");
                                    if (action instanceof CustomerCenterAction.PathButtonPressed) {
                                        CustomerCenterAction.PathButtonPressed pathButtonPressed = (CustomerCenterAction.PathButtonPressed) action;
                                        customerCenterViewModel2.pathButtonPressed(context, pathButtonPressed.getPath(), pathButtonPressed.getPurchaseInformation());
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.PerformRestore) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(customerCenterViewModel2, null), 3, null);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.DismissRestoreDialog) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(customerCenterViewModel2, null), 3, null);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.ContactSupport) {
                                        customerCenterViewModel2.contactSupport(context, ((CustomerCenterAction.ContactSupport) action).getEmail());
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.OpenURL) {
                                        CustomerCenterViewModel.DefaultImpls.openURL$default(customerCenterViewModel2, context, ((CustomerCenterAction.OpenURL) action).getUrl(), null, 4, null);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.NavigationButtonPressed) {
                                        customerCenterViewModel2.onNavigationButtonPressed(context, onDismiss);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.DismissPromotionalOffer) {
                                        customerCenterViewModel2.dismissPromotionalOffer(context, ((CustomerCenterAction.DismissPromotionalOffer) action).getOriginalPath());
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.PurchasePromotionalOffer) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(customerCenterViewModel2, action, ContextExtensionsKt.getActivity(context), null), 3, null);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.CustomActionSelected) {
                                        customerCenterViewModel2.onCustomActionSelected(((CustomerCenterAction.CustomActionSelected) action).getCustomActionData());
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.SelectPurchase) {
                                        customerCenterViewModel2.selectPurchase(((CustomerCenterAction.SelectPurchase) action).getPurchase());
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.ShowPaywall) {
                                        customerCenterViewModel2.showPaywall(context);
                                        return;
                                    }
                                    if (action instanceof CustomerCenterAction.ShowVirtualCurrencyBalances) {
                                        customerCenterViewModel2.showVirtualCurrencyBalances();
                                    } else if (action instanceof CustomerCenterAction.ShowSupportTicketCreation) {
                                        customerCenterViewModel2.showCreateSupportTicket();
                                    } else if (action instanceof CustomerCenterAction.DismissSupportTicketSuccessSnackbar) {
                                        customerCenterViewModel2.dismissSupportTicketSuccessSnackbar();
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier4 = companion;
                        InternalCustomerCenter(customerCenterStateInternalCustomerCenter$lambda$1, modifier4, (Function1) objRememberedValue7, composerStartRestartGroup, (i11 << 3) & 112, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        customerCenterViewModel3 = customerCenterViewModel2;
                        customerCenterListener5 = customerCenterListener4;
                    } else {
                        customerCenterListener4 = customerCenterListener3;
                    }
                    i12 = i8;
                    i13 = i12 | (zChanged ? 1 : 0);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (i13 != 0) {
                        objRememberedValue3 = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$2$1(customerCenterViewModel2, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
                        Unit unit3 = Unit.INSTANCE;
                        composerStartRestartGroup.startReplaceGroup(392059989);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                        if (i7 > 256) {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (i14 != 0) {
                                objRememberedValue4 = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$3$1(customerCenterViewModel2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                composerStartRestartGroup.endReplaceGroup();
                                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, 6);
                                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume22 = composerStartRestartGroup.consume(localLifecycleOwner2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                lifecycleOwner = (LifecycleOwner) objConsume22;
                                activity = ContextExtensionsKt.getActivity(context);
                                composerStartRestartGroup.startReplaceGroup(392084262);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                                if (i7 > 256) {
                                    i15 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (composerStartRestartGroup.changedInstance(activity) ? 1 : 0) | (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 1 : 0);
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (i15 != 0) {
                                        objRememberedValue5 = (Function1) new InternalCustomerCenterKt$InternalCustomerCenter$4$1(lifecycleOwner, customerCenterViewModel2, activity);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        composerStartRestartGroup.endReplaceGroup();
                                        EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.startReplaceGroup(392105865);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                                        if (i7 > 256) {
                                            i16 = i11 & 7168;
                                            i17 = (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (i16 == 2048 ? i8 : 0);
                                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                            if (i17 != 0) {
                                                objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$5$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        customerCenterViewModel2.onNavigationButtonPressed(context, onDismiss);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                composerStartRestartGroup.endReplaceGroup();
                                                int i232 = i8;
                                                BackHandlerKt.BackHandler(false, (Function0) objRememberedValue6, composerStartRestartGroup, 0, i232);
                                                value = customerCenterViewModel2.getActionError().getValue();
                                                composerStartRestartGroup.startReplaceGroup(392109318);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "*150@7359L27,149@7317L112");
                                                if (value != null) {
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                CustomerCenterState customerCenterStateInternalCustomerCenter$lambda$12 = InternalCustomerCenter$lambda$1(stateCollectAsStateWithLifecycle);
                                                composerStartRestartGroup.startReplaceGroup(392118215);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                                                if (i7 > 256) {
                                                    int i252 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? i18 : i232) | (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
                                                    if (i16 == 2048) {
                                                    }
                                                    i19 = i252 | i18;
                                                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                                    if (i19 != 0) {
                                                        objRememberedValue7 = (Function1) new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1

                                                            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$1, reason: invalid class name */
                                                            /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                            @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$1", f = "InternalCustomerCenter.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
                                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ CustomerCenterViewModel $viewModel;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                AnonymousClass1(CustomerCenterViewModel customerCenterViewModel, Continuation<? super AnonymousClass1> continuation) {
                                                                    super(2, continuation);
                                                                    this.$viewModel = customerCenterViewModel;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new AnonymousClass1(this.$viewModel, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object obj) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i = this.label;
                                                                    if (i == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        this.label = 1;
                                                                        if (this.$viewModel.restorePurchases(this) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                    } else {
                                                                        if (i != 1) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                        ResultKt.throwOnFailure(obj);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }

                                                            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$2, reason: invalid class name */
                                                            /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                            @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$2", f = "InternalCustomerCenter.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
                                                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ CustomerCenterViewModel $viewModel;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                AnonymousClass2(CustomerCenterViewModel customerCenterViewModel, Continuation<? super AnonymousClass2> continuation) {
                                                                    super(2, continuation);
                                                                    this.$viewModel = customerCenterViewModel;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new AnonymousClass2(this.$viewModel, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object obj) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i = this.label;
                                                                    if (i == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        this.label = 1;
                                                                        if (this.$viewModel.dismissRestoreDialog(this) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                    } else {
                                                                        if (i != 1) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                        ResultKt.throwOnFailure(obj);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }

                                                            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$3, reason: invalid class name */
                                                            /* JADX INFO: compiled from: InternalCustomerCenter.kt */
                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                            @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$7$1$3", f = "InternalCustomerCenter.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
                                                            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ CustomerCenterAction $action;
                                                                final /* synthetic */ Activity $activity;
                                                                final /* synthetic */ CustomerCenterViewModel $viewModel;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                AnonymousClass3(CustomerCenterViewModel customerCenterViewModel, CustomerCenterAction customerCenterAction, Activity activity, Continuation<? super AnonymousClass3> continuation) {
                                                                    super(2, continuation);
                                                                    this.$viewModel = customerCenterViewModel;
                                                                    this.$action = customerCenterAction;
                                                                    this.$activity = activity;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new AnonymousClass3(this.$viewModel, this.$action, this.$activity, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object obj) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i = this.label;
                                                                    if (i == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        this.label = 1;
                                                                        if (this.$viewModel.onAcceptedPromotionalOffer(((CustomerCenterAction.PurchasePromotionalOffer) this.$action).getSubscriptionOption(), this.$activity, this) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                    } else {
                                                                        if (i != 1) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                        ResultKt.throwOnFailure(obj);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                                                                invoke2(customerCenterAction);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(CustomerCenterAction action) {
                                                                Intrinsics.checkNotNullParameter(action, "action");
                                                                if (action instanceof CustomerCenterAction.PathButtonPressed) {
                                                                    CustomerCenterAction.PathButtonPressed pathButtonPressed = (CustomerCenterAction.PathButtonPressed) action;
                                                                    customerCenterViewModel2.pathButtonPressed(context, pathButtonPressed.getPath(), pathButtonPressed.getPurchaseInformation());
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.PerformRestore) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(customerCenterViewModel2, null), 3, null);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.DismissRestoreDialog) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(customerCenterViewModel2, null), 3, null);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.ContactSupport) {
                                                                    customerCenterViewModel2.contactSupport(context, ((CustomerCenterAction.ContactSupport) action).getEmail());
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.OpenURL) {
                                                                    CustomerCenterViewModel.DefaultImpls.openURL$default(customerCenterViewModel2, context, ((CustomerCenterAction.OpenURL) action).getUrl(), null, 4, null);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.NavigationButtonPressed) {
                                                                    customerCenterViewModel2.onNavigationButtonPressed(context, onDismiss);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.DismissPromotionalOffer) {
                                                                    customerCenterViewModel2.dismissPromotionalOffer(context, ((CustomerCenterAction.DismissPromotionalOffer) action).getOriginalPath());
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.PurchasePromotionalOffer) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(customerCenterViewModel2, action, ContextExtensionsKt.getActivity(context), null), 3, null);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.CustomActionSelected) {
                                                                    customerCenterViewModel2.onCustomActionSelected(((CustomerCenterAction.CustomActionSelected) action).getCustomActionData());
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.SelectPurchase) {
                                                                    customerCenterViewModel2.selectPurchase(((CustomerCenterAction.SelectPurchase) action).getPurchase());
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.ShowPaywall) {
                                                                    customerCenterViewModel2.showPaywall(context);
                                                                    return;
                                                                }
                                                                if (action instanceof CustomerCenterAction.ShowVirtualCurrencyBalances) {
                                                                    customerCenterViewModel2.showVirtualCurrencyBalances();
                                                                } else if (action instanceof CustomerCenterAction.ShowSupportTicketCreation) {
                                                                    customerCenterViewModel2.showCreateSupportTicket();
                                                                } else if (action instanceof CustomerCenterAction.DismissSupportTicketSuccessSnackbar) {
                                                                    customerCenterViewModel2.dismissSupportTicketSuccessSnackbar();
                                                                }
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                        Modifier modifier42 = companion;
                                                        InternalCustomerCenter(customerCenterStateInternalCustomerCenter$lambda$12, modifier42, (Function1) objRememberedValue7, composerStartRestartGroup, (i11 << 3) & 112, 0);
                                                        composerStartRestartGroup = composerStartRestartGroup;
                                                        if (ComposerKt.isTraceInProgress()) {
                                                        }
                                                        modifier3 = modifier42;
                                                        customerCenterViewModel3 = customerCenterViewModel2;
                                                        customerCenterListener5 = customerCenterListener4;
                                                    }
                                                } else {
                                                    int i2522 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? i18 : i232) | (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
                                                    if (i16 == 2048) {
                                                    }
                                                    i19 = i2522 | i18;
                                                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                                    if (i19 != 0) {
                                                    }
                                                }
                                            }
                                        } else {
                                            i16 = i11 & 7168;
                                            i17 = (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (i16 == 2048 ? i8 : 0);
                                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                            if (i17 != 0) {
                                            }
                                        }
                                    }
                                } else {
                                    i15 = (((i7 > 256 || !composerStartRestartGroup.changedInstance(customerCenterViewModel2)) && (i11 & 384) != 256) ? 0 : i8) | (composerStartRestartGroup.changedInstance(activity) ? 1 : 0) | (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 1 : 0);
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (i15 != 0) {
                                    }
                                }
                            }
                        } else {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (i14 != 0) {
                            }
                        }
                    }
                } else {
                    i8 = 1;
                }
                i9 = i8;
                i10 = i9 | (composerStartRestartGroup.changed(colorScheme) ? 1 : 0) | (composerStartRestartGroup.changed(zIsSystemInDarkTheme) ? 1 : 0);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (i10 != 0) {
                    objRememberedValue = (Function2) new InternalCustomerCenterKt$InternalCustomerCenter$1$1(customerCenterViewModel2, colorScheme, zIsSystemInDarkTheme, continuation);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(colorScheme, boolValueOf, (Function2) objRememberedValue, composerStartRestartGroup, i5);
                    i11 = i6;
                    State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(customerCenterViewModel2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContext2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Context context2 = (Context) objConsume3;
                    Boolean boolValueOf22 = Boolean.valueOf(!(InternalCustomerCenter$lambda$1(stateCollectAsStateWithLifecycle2) instanceof CustomerCenterState.Success));
                    composerStartRestartGroup.startReplaceGroup(392055540);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle2);
                    if (i7 > 256) {
                        customerCenterListener4 = customerCenterListener3;
                        if ((i11 & 384) != 256) {
                            i12 = i8;
                        }
                        i13 = i12 | (zChanged2 ? 1 : 0);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (i13 != 0) {
                        }
                    }
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                customerCenterListener5 = customerCenterListener2;
                customerCenterViewModel3 = customerCenterViewModel;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i26) {
                        InternalCustomerCenterKt.InternalCustomerCenter(modifier3, customerCenterListener5, customerCenterViewModel3, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        customerCenterListener2 = customerCenterListener;
        if ((i & 384) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        i4 = i3;
        if ((i4 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "89@5132L21,88@5083L106");
            if ((i & 1) != 0) {
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if ((i2 & 4) == 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ColorScheme colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                boolean zIsSystemInDarkTheme2 = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, i5);
                Boolean boolValueOf3 = Boolean.valueOf(zIsSystemInDarkTheme2);
                composerStartRestartGroup.startReplaceGroup(392046750);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                i7 = (i6 & 896) ^ 384;
                if (i7 > 256) {
                    i8 = 1;
                    if ((i6 & 384) != 256) {
                        i9 = i8;
                    }
                    i10 = i9 | (composerStartRestartGroup.changed(colorScheme2) ? 1 : 0) | (composerStartRestartGroup.changed(zIsSystemInDarkTheme2) ? 1 : 0);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (i10 != 0) {
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InternalCustomerCenter(final CustomerCenterState customerCenterState, Modifier modifier, final Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Function1<? super CustomerCenterAction, Unit> function12;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-456940664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InternalCustomerCenter)P(2)211@9896L24,212@9983L26,216@10071L991,214@10015L1047:InternalCustomerCenter.kt#5a5ul8");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(customerCenterState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                if ((i & 384) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-456940664, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter (InternalCustomerCenter.kt:210)");
                    }
                    int i5 = i3 & 14;
                    ColorScheme colorSchemeCreateColorScheme = createColorScheme(customerCenterState, composerStartRestartGroup, i5);
                    ScaffoldConfigData scaffoldConfigDataCreateScaffoldState = createScaffoldState(customerCenterState, composerStartRestartGroup, i5);
                    final String title = scaffoldConfigDataCreateScaffoldState.getTitle();
                    final CustomerCenterState.NavigationButtonType navigationButtonType = scaffoldConfigDataCreateScaffoldState.getNavigationButtonType();
                    final boolean shouldUseLargeTopBar = scaffoldConfigDataCreateScaffoldState.getShouldUseLargeTopBar();
                    final Modifier modifier4 = companion;
                    MaterialThemeKt.MaterialTheme(colorSchemeCreateColorScheme, null, null, ComposableLambdaKt.rememberComposableLambda(252597340, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C219@10179L11,226@10474L582,217@10081L975:InternalCustomerCenter.kt#5a5ul8");
                            if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(252597340, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter.<anonymous> (InternalCustomerCenter.kt:217)");
                            }
                            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                            CustomerCenterScaffoldConfig customerCenterScaffoldConfig = new CustomerCenterScaffoldConfig(title, shouldUseLargeTopBar, navigationButtonType);
                            Function1<CustomerCenterAction, Unit> function13 = function12;
                            final CustomerCenterState customerCenterState2 = customerCenterState;
                            final Function1<CustomerCenterAction, Unit> function14 = function12;
                            InternalCustomerCenterKt.CustomerCenterScaffold(function13, customerCenterScaffoldConfig, modifierM1483backgroundbw27NRU$default, ComposableLambdaKt.rememberComposableLambda(-98702717, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.9.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i7) {
                                    ComposerKt.sourceInformation(composer3, "C:InternalCustomerCenter.kt#5a5ul8");
                                    if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-98702717, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter.<anonymous>.<anonymous> (InternalCustomerCenter.kt:227)");
                                    }
                                    CustomerCenterState customerCenterState3 = customerCenterState2;
                                    if (customerCenterState3 instanceof CustomerCenterState.NotLoaded) {
                                        composer3.startReplaceGroup(1633707983);
                                        composer3.endReplaceGroup();
                                    } else if (customerCenterState3 instanceof CustomerCenterState.Loading) {
                                        composer3.startReplaceGroup(1633779903);
                                        ComposerKt.sourceInformation(composer3, "232@10648L27");
                                        CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer3, 0);
                                        composer3.endReplaceGroup();
                                    } else if (customerCenterState3 instanceof CustomerCenterState.Error) {
                                        composer3.startReplaceGroup(1633896060);
                                        ComposerKt.sourceInformation(composer3, "236@10765L30");
                                        CustomerCenterErrorViewKt.CustomerCenterErrorView((CustomerCenterState.Error) customerCenterState2, composer3, 0);
                                        composer3.endReplaceGroup();
                                    } else if (customerCenterState3 instanceof CustomerCenterState.Success) {
                                        composer3.startReplaceGroup(1634020091);
                                        ComposerKt.sourceInformation(composer3, "240@10887L127");
                                        InternalCustomerCenterKt.CustomerCenterLoaded((CustomerCenterState.Success) customerCenterState2, function14, composer3, 0);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(1634194466);
                                        composer3.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 3072, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            InternalCustomerCenterKt.InternalCustomerCenter(customerCenterState, modifier3, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            function12 = function1;
            if ((i3 & 147) == 146) {
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i52 = i3 & 14;
                ColorScheme colorSchemeCreateColorScheme2 = createColorScheme(customerCenterState, composerStartRestartGroup, i52);
                ScaffoldConfigData scaffoldConfigDataCreateScaffoldState2 = createScaffoldState(customerCenterState, composerStartRestartGroup, i52);
                final String title2 = scaffoldConfigDataCreateScaffoldState2.getTitle();
                final CustomerCenterState.NavigationButtonType navigationButtonType2 = scaffoldConfigDataCreateScaffoldState2.getNavigationButtonType();
                final boolean shouldUseLargeTopBar2 = scaffoldConfigDataCreateScaffoldState2.getShouldUseLargeTopBar();
                final Modifier modifier42 = companion;
                MaterialThemeKt.MaterialTheme(colorSchemeCreateColorScheme2, null, null, ComposableLambdaKt.rememberComposableLambda(252597340, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ComposerKt.sourceInformation(composer2, "C219@10179L11,226@10474L582,217@10081L975:InternalCustomerCenter.kt#5a5ul8");
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(252597340, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter.<anonymous> (InternalCustomerCenter.kt:217)");
                        }
                        Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(modifier42, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                        CustomerCenterScaffoldConfig customerCenterScaffoldConfig = new CustomerCenterScaffoldConfig(title2, shouldUseLargeTopBar2, navigationButtonType2);
                        Function1<CustomerCenterAction, Unit> function13 = function12;
                        final CustomerCenterState customerCenterState2 = customerCenterState;
                        final Function1<? super CustomerCenterAction, Unit> function14 = function12;
                        InternalCustomerCenterKt.CustomerCenterScaffold(function13, customerCenterScaffoldConfig, modifierM1483backgroundbw27NRU$default, ComposableLambdaKt.rememberComposableLambda(-98702717, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter.9.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C:InternalCustomerCenter.kt#5a5ul8");
                                if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-98702717, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenter.<anonymous>.<anonymous> (InternalCustomerCenter.kt:227)");
                                }
                                CustomerCenterState customerCenterState3 = customerCenterState2;
                                if (customerCenterState3 instanceof CustomerCenterState.NotLoaded) {
                                    composer3.startReplaceGroup(1633707983);
                                    composer3.endReplaceGroup();
                                } else if (customerCenterState3 instanceof CustomerCenterState.Loading) {
                                    composer3.startReplaceGroup(1633779903);
                                    ComposerKt.sourceInformation(composer3, "232@10648L27");
                                    CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer3, 0);
                                    composer3.endReplaceGroup();
                                } else if (customerCenterState3 instanceof CustomerCenterState.Error) {
                                    composer3.startReplaceGroup(1633896060);
                                    ComposerKt.sourceInformation(composer3, "236@10765L30");
                                    CustomerCenterErrorViewKt.CustomerCenterErrorView((CustomerCenterState.Error) customerCenterState2, composer3, 0);
                                    composer3.endReplaceGroup();
                                } else if (customerCenterState3 instanceof CustomerCenterState.Success) {
                                    composer3.startReplaceGroup(1634020091);
                                    ComposerKt.sourceInformation(composer3, "240@10887L127");
                                    InternalCustomerCenterKt.CustomerCenterLoaded((CustomerCenterState.Success) customerCenterState2, function14, composer3, 0);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(1634194466);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 3072, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 4) != 0) {
        }
        function12 = function1;
        if ((i3 & 147) == 146) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomerCenterState InternalCustomerCenter$lambda$1(State<? extends CustomerCenterState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainScreenContent(final CustomerCenterState.Success success, Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Function1<? super CustomerCenterAction, Unit> function12 = function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-622947142);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainScreenContent)P(1):InternalCustomerCenter.kt#5a5ul8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(success) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-622947142, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.MainScreenContent (InternalCustomerCenter.kt:555)");
            }
            CustomerCenterConfigData customerCenterConfigData = success.getCustomerCenterConfigData();
            if (success.getPurchases().isEmpty()) {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(388207578);
                ComposerKt.sourceInformation(composer2, "*581@23146L482");
                CustomerCenterConfigData.Screen noActiveScreen = customerCenterConfigData.getNoActiveScreen();
                if (noActiveScreen == null) {
                    function12 = function1;
                } else {
                    function12 = function1;
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(noActiveScreen, customerCenterConfigData.getSupport().getEmail(), customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), success.getNoActiveScreenOffering(), success.getVirtualCurrencies(), function12, composer2, (i2 << 18) & 29360128, 0);
                    composer2 = composer2;
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(387234953);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*566@22585L261,559@22161L782");
                if (customerCenterConfigData.getManagementScreen() == null) {
                    composer2 = composerStartRestartGroup;
                } else {
                    List mainScreenPaths = success.getMainScreenPaths();
                    String email = customerCenterConfigData.getSupport().getEmail();
                    VirtualCurrencies virtualCurrencies = success.getVirtualCurrencies();
                    CustomerCenterConfigData.Appearance appearance = customerCenterConfigData.getAppearance();
                    CustomerCenterConfigData.Localization localization = customerCenterConfigData.getLocalization();
                    CustomerCenterConfigData.Support.SupportTickets supportTickets = customerCenterConfigData.getSupport().getSupportTickets();
                    composerStartRestartGroup.startReplaceGroup(684114534);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalCustomerCenter.kt#9igjgp");
                    boolean zChangedInstance = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(success);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$MainScreenContent$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                                invoke2(purchaseInformation);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchaseInformation purchase) {
                                Intrinsics.checkNotNullParameter(purchase, "purchase");
                                if (success.getPurchases().size() > 1) {
                                    function12.invoke(new CustomerCenterAction.SelectPurchase(purchase));
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(mainScreenPaths, email, virtualCurrencies, appearance, localization, supportTickets, (Function1) objRememberedValue, function12, null, success.getPurchases(), composer2, (i2 << 18) & 29360128, 256);
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                function12 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.MainScreenContent.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    InternalCustomerCenterKt.MainScreenContent(success, function12, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final ColorScheme createColorScheme(CustomerCenterState customerCenterState, Composer composer, int i) {
        composer.startReplaceGroup(352157510);
        ComposerKt.sourceInformation(composer, "C(createColorScheme)252@11168L21,253@11230L11,255@11254L857:InternalCustomerCenter.kt#5a5ul8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(352157510, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.createColorScheme (InternalCustomerCenter.kt:251)");
        }
        boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composer, 0);
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable);
        composer.startReplaceGroup(636383891);
        ComposerKt.sourceInformation(composer, "CC(remember):InternalCustomerCenter.kt#9igjgp");
        boolean zChanged = composer.changed(zIsSystemInDarkTheme) | ((((i & 14) ^ 6) > 4 && composer.changed(customerCenterState)) || (i & 6) == 4) | composer.changed(colorScheme);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (customerCenterState instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
                CustomerCenterConfigData.Appearance appearance = success.getCustomerCenterConfigData().getAppearance();
                Color colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$createColorScheme$1$accentColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getAccentColor();
                    }
                });
                Color colorForTheme2 = success.getCurrentDestination() instanceof CustomerCenterDestination.PromotionalOffer ? CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$createColorScheme$1$backgroundColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getBackgroundColor();
                    }
                }) : null;
                colorScheme = ColorScheme.m3423copyCXl9yA$default(colorScheme, colorForTheme != null ? colorForTheme.m6335unboximpl() : colorScheme.getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, colorForTheme2 != null ? colorForTheme2.m6335unboximpl() : colorScheme.getBackground(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -8194, 15, null);
            }
            composer.updateRememberedValue(colorScheme);
            objRememberedValue = colorScheme;
        }
        ColorScheme colorScheme2 = (ColorScheme) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return colorScheme2;
    }

    private static final ScaffoldConfigData createScaffoldState(CustomerCenterState customerCenterState, Composer composer, int i) {
        composer.startReplaceGroup(953700373);
        ComposerKt.sourceInformation(composer, "C(createScaffoldState)285@12397L661:InternalCustomerCenter.kt#5a5ul8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(953700373, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.createScaffoldState (InternalCustomerCenter.kt:284)");
        }
        composer.startReplaceGroup(2044243650);
        ComposerKt.sourceInformation(composer, "CC(remember):InternalCustomerCenter.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(customerCenterState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (customerCenterState instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
                String title = success.getNavigationState().getCurrentDestination().getTitle();
                objRememberedValue = new ScaffoldConfigData(title, customerCenterState.getNavigationButtonType(), (success.getCurrentDestination() instanceof CustomerCenterDestination.Main) && title != null);
            } else {
                objRememberedValue = new ScaffoldConfigData(null, CustomerCenterState.NavigationButtonType.CLOSE, false);
            }
            composer.updateRememberedValue(objRememberedValue);
        }
        ScaffoldConfigData scaffoldConfigData = (ScaffoldConfigData) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return scaffoldConfigData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final CustomerCenterViewModel getCustomerCenterViewModel(boolean z, CustomerCenterListener customerCenterListener, PurchasesType purchasesType, CustomerCenterViewModel customerCenterViewModel, Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceGroup(1278114306);
        ComposerKt.sourceInformation(composer, "C(getCustomerCenterViewModel)606@24130L11,603@23991L238:InternalCustomerCenter.kt#5a5ul8");
        Purchases purchases = null;
        Object[] objArr = 0;
        if ((i2 & 2) != 0) {
            customerCenterListener = null;
        }
        if ((i2 & 4) != 0) {
            purchasesType = new PurchasesImpl(purchases, 1, objArr == true ? 1 : 0);
        }
        if ((i2 & 8) != 0) {
            CustomerCenterViewModelFactory customerCenterViewModelFactory = new CustomerCenterViewModelFactory(purchasesType, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable), z, customerCenterListener);
            composer.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            composer2 = composer;
            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CustomerCenterViewModelImpl.class), current, (String) null, customerCenterViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 0, 0);
            composer2.endReplaceableGroup();
            customerCenterViewModel = (CustomerCenterViewModel) viewModel;
        } else {
            composer2 = composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1278114306, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.getCustomerCenterViewModel (InternalCustomerCenter.kt:611)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return customerCenterViewModel;
    }
}
