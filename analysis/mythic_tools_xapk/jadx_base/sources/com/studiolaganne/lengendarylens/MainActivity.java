package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.credentials.provider.CredentialEntry;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.AnalyticsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ParametersBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.revenuecat.purchases.Purchases;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.BatteryMonitor;
import com.studiolaganne.lengendarylens.ChargingStateReceiver;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DeepLinkRoute;
import com.studiolaganne.lengendarylens.GlossaryDBHelper;
import com.studiolaganne.lengendarylens.GlossaryDBHelperLocalized;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.MainActivity;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.RulesDBHelper;
import com.studiolaganne.lengendarylens.RulesDBHelperLocalized;
import com.studiolaganne.lengendarylens.RulingsDBHelper;
import com.studiolaganne.lengendarylens.SetsDBHelper;
import com.studiolaganne.lengendarylens.SetsDBHelperLocalized;
import io.customer.sdk.CustomerIO;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0092\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0092\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0006\u00101\u001a\u00020*J\u0006\u00102\u001a\u00020*J\b\u00103\u001a\u00020\u000fH\u0002J\u0006\u00104\u001a\u00020*J\u0006\u00105\u001a\u00020*J\u0006\u00106\u001a\u00020*J\b\u00107\u001a\u00020*H\u0014J\b\u00108\u001a\u00020*H\u0014J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020<H\u0014J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\tH\u0002J\u0018\u0010G\u001a\u00020*2\u0006\u0010F\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002J\u0018\u0010I\u001a\u00020*2\u0006\u0010F\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0002J\u0018\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\u001c\u0010P\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010M2\b\u0010R\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020*H\u0002J\u0010\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020*H\u0014J\b\u0010[\u001a\u00020\u000fH\u0002J\b\u0010\\\u001a\u00020\u000fH\u0002J\u0012\u0010]\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010MH\u0015J\u0006\u0010^\u001a\u00020*J\u0006\u0010_\u001a\u00020*J\u000e\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020\u000fJ\u000e\u0010b\u001a\u00020*2\u0006\u0010a\u001a\u00020\u000fJ\b\u0010c\u001a\u00020*H\u0002J\b\u0010d\u001a\u00020*H\u0002J\b\u0010e\u001a\u00020*H\u0002J\b\u0010f\u001a\u00020*H\u0002J\\\u0010g\u001a\u00020*2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020B0i2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020B0i2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020B0i2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020B0i2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020B0i2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020B0iH\u0002J\u0016\u0010o\u001a\u00020*2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020q0iH\u0002J&\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u00020q2\u0006\u0010t\u001a\u00020\t2\u0006\u0010u\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020*2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0iH\u0002J&\u0010z\u001a\u00020*2\u0006\u0010{\u001a\u00020y2\u0006\u0010t\u001a\u00020\t2\u0006\u0010u\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010|J\u0016\u0010}\u001a\u00020*2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0iH\u0002J)\u0010\u0080\u0001\u001a\u00020*2\u0007\u0010\u0081\u0001\u001a\u00020\u007f2\u0006\u0010t\u001a\u00020\t2\u0006\u0010u\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u0082\u0001J\u0017\u0010\u0083\u0001\u001a\u00020*2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0iH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020*2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0002J\t\u0010\u0086\u0001\u001a\u00020*H\u0016J\u0007\u0010\u0087\u0001\u001a\u00020*J\u0007\u0010\u0088\u0001\u001a\u00020*J\u0013\u0010\u008d\u0001\u001a\u00020*2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\t\u0010\u0090\u0001\u001a\u00020*H\u0002J\t\u0010\u0091\u0001\u001a\u00020*H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/MainActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/ChargingStateReceiver$ChargingStateCallback;", "Lcom/studiolaganne/lengendarylens/BatteryMonitor$BatteryLevelListener;", "<init>", "()V", "navView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "currentSelectedTab", "", "chargingReceiver", "Lcom/studiolaganne/lengendarylens/ChargingStateReceiver;", "batteryMonitor", "Lcom/studiolaganne/lengendarylens/BatteryMonitor;", "promptedForBattery25", "", "promptedForBattery10", "isPlugged", "lastBatterPromptNoAnswerTime", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "downloadScope", "Lkotlinx/coroutines/CoroutineScope;", "syncScope", "gameFragment", "Lcom/studiolaganne/lengendarylens/GameFragment;", "scanFragment", "Lcom/studiolaganne/lengendarylens/ScanFragment;", "collectionFragment", "Lcom/studiolaganne/lengendarylens/CollectionFragment;", "homeFragment", "Lcom/studiolaganne/lengendarylens/HomeFragment;", "searchFragment", "Lcom/studiolaganne/lengendarylens/SearchFragment;", "instanceStateSaved", "newGamePlaygroupId", "authStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "authErrorReceiver", "Landroid/content/BroadcastReceiver;", "onBatteryLevelChanged", "", FirebaseAnalytics.Param.LEVEL, "onBatteryCharging", "onBatteryNotCharging", "promptForBatterySaving", "enableBatterySavingChanges", "disableBatterySavingChanges", "resetBatteryPrompts", "checkForLowBattery", "initOpenCV", "goToSearch", "enableBatterySavings", "disableBatterySavings", "onPause", "onResume", "stopAlarmIfTimerExpired", "onNewIntent", "intent", "Landroid/content/Intent;", "handleDeepLink", "uri", "Landroid/net/Uri;", "handleEventQR", "url", "", "handleEmailVerifyCallback", "handleOAuthCallback", "handleUserProfileLink", "userId", "handleUserDeckLink", "deckId", "handleUserListLink", "listId", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "outPersistentState", "Landroid/os/PersistableBundle;", "onRestoreInstanceState", "savedInstanceState", "persistentState", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "checkAndResetBatterySavingMode", "fetchInstallReferrerAndLog", "context", "Landroid/content/Context;", "onDestroy", "isInSignupFlow", "handleSignUpCallbackIfNeeded", "onCreate", "ensureNavigationBarsVisible", "updateSharedCollectionBadge", "setFullscreenMode", "enabled", "setStatusBarFullscreen", "startupChecks", "checkUnSyncedSets", "checkUnSyncedGames", "checkDatabaseUpdates", "handleDatabaseUpdates", "helpersToUpdate", "", "glossaryToUpdate", "rulesToUpdate", "setsToUpdate", "rulingsToUpdate", "scannerToUpdate", "syncGamesSequentially", "games", "Lcom/studiolaganne/lengendarylens/GameState;", "syncGame", "gameState", "current", "total", "(Lcom/studiolaganne/lengendarylens/GameState;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSetsSequentially", "sets", "Lcom/studiolaganne/lengendarylens/GameSet;", "syncSet", "set", "(Lcom/studiolaganne/lengendarylens/GameSet;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadDatabasesSequentially", "helpers", "Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "downloadDatabase", "helper", "(Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAllDownloadsComplete", "updateGlobalProgress", "progress", "onDetachedFromWindow", "userLoggedOut", "userLoggedIn", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "onNavigationItemSelectedListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "setupAuthStateMonitoring", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "showSessionExpiredDialog", "handleAuthFailureSignOut", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainActivity extends BaseActivity implements ChargingStateReceiver.ChargingStateCallback, BatteryMonitor.BatteryLevelListener {
    private static final String TAG = "MythicTools";
    private BroadcastReceiver authErrorReceiver;
    private FirebaseAuth.AuthStateListener authStateListener;
    private BatteryMonitor batteryMonitor;
    private BillingClient billingClient;
    private ChargingStateReceiver chargingReceiver;
    private CollectionFragment collectionFragment;
    private GameFragment gameFragment;
    private HomeFragment homeFragment;
    private boolean instanceStateSaved;
    private boolean isPlugged;
    private long lastBatterPromptNoAnswerTime;
    private BottomNavigationView navView;
    private boolean promptedForBattery10;
    private boolean promptedForBattery25;
    private ScanFragment scanFragment;
    private SearchFragment searchFragment;
    public static final int $stable = 8;
    private int currentSelectedTab = R.id.navigation_home;
    private final CoroutineScope downloadScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final CoroutineScope syncScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private int newGamePlaygroupId = -1;
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda14
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        }
    };
    private final BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda15
        @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
        public final boolean onNavigationItemSelected(MenuItem menuItem) {
            return MainActivity.onNavigationItemSelectedListener$lambda$0(this.f$0, menuItem);
        }
    };

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1", f = "MainActivity.kt", i = {0, 0}, l = {1376}, m = "invokeSuspend", n = {"prefs", "deviceLanguage"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PreferencesManager $prefs;
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: MainActivity.kt */
            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/MainActivity$checkDatabaseUpdates$1$2$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTDBsResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class C02101 implements Callback<MTDBsResponse> {
                final /* synthetic */ MainActivity this$0;

                C02101(MainActivity mainActivity) {
                    this.this$0 = mainActivity;
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<MTDBsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("MTApi", "checkForDBUpdates failed: " + t.getMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDBsResponse> call, Response<MTDBsResponse> response) {
                    MTDBsResponse mTDBsResponseBody;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || (mTDBsResponseBody = response.body()) == null) {
                        return;
                    }
                    final ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    final ArrayList arrayList3 = new ArrayList();
                    final ArrayList arrayList4 = new ArrayList();
                    final ArrayList arrayList5 = new ArrayList();
                    final ArrayList arrayList6 = new ArrayList();
                    if (mTDBsResponseBody.getCards().getEn() != null) {
                        arrayList.add("en");
                    }
                    if (mTDBsResponseBody.getCards().getFr() != null) {
                        arrayList.add("fr");
                    }
                    if (mTDBsResponseBody.getCards().getDe() != null) {
                        arrayList.add("de");
                    }
                    if (mTDBsResponseBody.getCards().getEs() != null) {
                        arrayList.add("es");
                    }
                    if (mTDBsResponseBody.getCards().getIt() != null) {
                        arrayList.add("it");
                    }
                    if (mTDBsResponseBody.getCards().getPt() != null) {
                        arrayList.add("pt");
                    }
                    if (mTDBsResponseBody.getCards().getJa() != null) {
                        arrayList.add("ja");
                    }
                    if (mTDBsResponseBody.getCards().getKo() != null) {
                        arrayList.add("ko");
                    }
                    if (mTDBsResponseBody.getCards().getRu() != null) {
                        arrayList.add("ru");
                    }
                    if (mTDBsResponseBody.getCards().getZht() != null) {
                        arrayList.add("zht");
                    }
                    if (mTDBsResponseBody.getCards().getZhs() != null) {
                        arrayList.add("zhs");
                    }
                    if (mTDBsResponseBody.getGlossary().getEn() != null) {
                        arrayList2.add("en");
                    }
                    if (mTDBsResponseBody.getGlossary().getFr() != null) {
                        arrayList2.add("fr");
                    }
                    if (mTDBsResponseBody.getRules().getEn() != null) {
                        arrayList3.add("en");
                    }
                    if (mTDBsResponseBody.getRules().getFr() != null) {
                        arrayList3.add("fr");
                    }
                    if (mTDBsResponseBody.getSets().getEn() != null) {
                        arrayList4.add("en");
                    }
                    if (mTDBsResponseBody.getSets().getFr() != null) {
                        arrayList4.add("fr");
                    }
                    if (mTDBsResponseBody.getRulings().getFr() != null) {
                        arrayList5.add("fr");
                    }
                    if (mTDBsResponseBody.getModel_card_art().getEn() != null) {
                        arrayList6.add("model_card_art");
                    }
                    if (mTDBsResponseBody.getModel_card_classifier().getEn() != null) {
                        arrayList6.add("model_card_classifier");
                    }
                    if (mTDBsResponseBody.getModel_card_detection().getEn() != null) {
                        arrayList6.add("model_card_detection");
                    }
                    if (mTDBsResponseBody.getModel_plist_detector().getEn() != null) {
                        arrayList6.add("model_plist_detector");
                    }
                    if (mTDBsResponseBody.getModel_set_symbols().getEn() != null) {
                        arrayList6.add("model_set_symbols");
                    }
                    if (mTDBsResponseBody.getEmbeddings_cards().getEn() != null) {
                        arrayList6.add("embeddings_cards");
                    }
                    if (mTDBsResponseBody.getEmbeddings_sets().getEn() != null) {
                        arrayList6.add("embeddings_sets");
                    }
                    final MainActivity mainActivity = this.this$0;
                    mainActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$2$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            mainActivity.handleDatabaseUpdates(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6);
                        }
                    });
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MainActivity mainActivity, PreferencesManager preferencesManager, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
                this.$prefs = preferencesManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$prefs, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MTDBsBody mTDBsBody = new MTDBsBody(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
                Context applicationContext = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper = new GenericDBHelper(applicationContext, "model_card_art", ".onnx");
                if (genericDBHelper.isValid()) {
                    mTDBsBody.getModel_card_art().setEn(Boxing.boxInt(genericDBHelper.getVersion()));
                } else {
                    mTDBsBody.getModel_card_art().setEn(Boxing.boxInt(0));
                }
                Context applicationContext2 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper2 = new GenericDBHelper(applicationContext2, "model_card_classifier", ".onnx");
                if (genericDBHelper2.isValid()) {
                    mTDBsBody.getModel_card_classifier().setEn(Boxing.boxInt(genericDBHelper2.getVersion()));
                } else {
                    mTDBsBody.getModel_card_classifier().setEn(Boxing.boxInt(0));
                }
                Context applicationContext3 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper3 = new GenericDBHelper(applicationContext3, "model_card_detection", ".onnx");
                if (genericDBHelper3.isValid()) {
                    mTDBsBody.getModel_card_detection().setEn(Boxing.boxInt(genericDBHelper3.getVersion()));
                } else {
                    mTDBsBody.getModel_card_detection().setEn(Boxing.boxInt(0));
                }
                Context applicationContext4 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper4 = new GenericDBHelper(applicationContext4, "model_plist_detector", ".onnx");
                if (genericDBHelper4.isValid()) {
                    mTDBsBody.getModel_plist_detector().setEn(Boxing.boxInt(genericDBHelper4.getVersion()));
                } else {
                    mTDBsBody.getModel_plist_detector().setEn(Boxing.boxInt(0));
                }
                Context applicationContext5 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper5 = new GenericDBHelper(applicationContext5, "model_set_symbols", ".onnx");
                if (genericDBHelper5.isValid()) {
                    mTDBsBody.getModel_set_symbols().setEn(Boxing.boxInt(genericDBHelper5.getVersion()));
                } else {
                    mTDBsBody.getModel_set_symbols().setEn(Boxing.boxInt(0));
                }
                Context applicationContext6 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper6 = new GenericDBHelper(applicationContext6, "embeddings_cards", ".meb");
                if (genericDBHelper6.isValid()) {
                    mTDBsBody.getEmbeddings_cards().setEn(Boxing.boxInt(genericDBHelper6.getVersion()));
                } else {
                    mTDBsBody.getEmbeddings_cards().setEn(Boxing.boxInt(0));
                }
                Context applicationContext7 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext7, "getApplicationContext(...)");
                GenericDBHelper genericDBHelper7 = new GenericDBHelper(applicationContext7, "embeddings_sets", ".meb");
                if (genericDBHelper7.isValid()) {
                    mTDBsBody.getEmbeddings_sets().setEn(Boxing.boxInt(genericDBHelper7.getVersion()));
                } else {
                    mTDBsBody.getEmbeddings_sets().setEn(Boxing.boxInt(0));
                }
                MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
                Context applicationContext8 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext8, "getApplicationContext(...)");
                MTGDBHelper companion2 = companion.getInstance(applicationContext8);
                if (companion2.isValid()) {
                    mTDBsBody.getCards().setEn(Boxing.boxInt(companion2.getVersion()));
                } else {
                    mTDBsBody.getCards().setEn(Boxing.boxInt(0));
                }
                Iterator<String> it = this.$prefs.getEnabledLanguages().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!Intrinsics.areEqual(next, "en")) {
                        MTGDBHelperLocalized.Companion companion3 = MTGDBHelperLocalized.INSTANCE;
                        Context applicationContext9 = this.this$0.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext9, "getApplicationContext(...)");
                        MTGDBHelperLocalized companion4 = companion3.getInstance(applicationContext9, next);
                        int version = companion4.isValid() ? companion4.getVersion() : 0;
                        int iHashCode = next.hashCode();
                        Iterator<String> it2 = it;
                        if (iHashCode != 3201) {
                            if (iHashCode != 3246) {
                                if (iHashCode != 3276) {
                                    if (iHashCode != 3371) {
                                        if (iHashCode != 3383) {
                                            if (iHashCode != 3428) {
                                                if (iHashCode != 3588) {
                                                    if (iHashCode != 3651) {
                                                        switch (iHashCode) {
                                                            case 120581:
                                                                if (next.equals("zhs")) {
                                                                    mTDBsBody.getCards().setZhs(Boxing.boxInt(version));
                                                                }
                                                                break;
                                                            case 120582:
                                                                if (next.equals("zht")) {
                                                                    mTDBsBody.getCards().setZht(Boxing.boxInt(version));
                                                                }
                                                                break;
                                                        }
                                                    } else if (next.equals("ru")) {
                                                        mTDBsBody.getCards().setRu(Boxing.boxInt(version));
                                                    }
                                                } else if (next.equals("pt")) {
                                                    mTDBsBody.getCards().setPt(Boxing.boxInt(version));
                                                }
                                            } else if (next.equals("ko")) {
                                                mTDBsBody.getCards().setKo(Boxing.boxInt(version));
                                            }
                                        } else if (next.equals("ja")) {
                                            mTDBsBody.getCards().setJa(Boxing.boxInt(version));
                                        }
                                    } else if (next.equals("it")) {
                                        mTDBsBody.getCards().setIt(Boxing.boxInt(version));
                                    }
                                } else if (next.equals("fr")) {
                                    mTDBsBody.getCards().setFr(Boxing.boxInt(version));
                                }
                            } else if (next.equals("es")) {
                                mTDBsBody.getCards().setEs(Boxing.boxInt(version));
                            }
                        } else if (next.equals("de")) {
                            mTDBsBody.getCards().setDe(Boxing.boxInt(version));
                        }
                        it = it2;
                    }
                }
                Iterator<String> it3 = this.$prefs.getSupportedLanguages().iterator();
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    if (!Intrinsics.areEqual(next2, "en")) {
                        MTGDBHelperLocalized.Companion companion5 = MTGDBHelperLocalized.INSTANCE;
                        Iterator<String> it4 = it3;
                        Context applicationContext10 = this.this$0.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext10, "getApplicationContext(...)");
                        MTGDBHelperLocalized companion6 = companion5.getInstance(applicationContext10, next2);
                        if (companion6.isValid()) {
                            int version2 = companion6.getVersion();
                            int iHashCode2 = next2.hashCode();
                            if (iHashCode2 != 3201) {
                                if (iHashCode2 != 3246) {
                                    if (iHashCode2 != 3276) {
                                        if (iHashCode2 != 3371) {
                                            if (iHashCode2 != 3383) {
                                                if (iHashCode2 != 3428) {
                                                    if (iHashCode2 != 3588) {
                                                        if (iHashCode2 != 3651) {
                                                            switch (iHashCode2) {
                                                                case 120581:
                                                                    if (next2.equals("zhs")) {
                                                                        mTDBsBody.getCards().setZhs(Boxing.boxInt(version2));
                                                                    }
                                                                    break;
                                                                case 120582:
                                                                    if (next2.equals("zht")) {
                                                                        mTDBsBody.getCards().setZht(Boxing.boxInt(version2));
                                                                    }
                                                                    break;
                                                            }
                                                        } else if (next2.equals("ru")) {
                                                            mTDBsBody.getCards().setRu(Boxing.boxInt(version2));
                                                        }
                                                    } else if (next2.equals("pt")) {
                                                        mTDBsBody.getCards().setPt(Boxing.boxInt(version2));
                                                    }
                                                } else if (next2.equals("ko")) {
                                                    mTDBsBody.getCards().setKo(Boxing.boxInt(version2));
                                                }
                                            } else if (next2.equals("ja")) {
                                                mTDBsBody.getCards().setJa(Boxing.boxInt(version2));
                                            }
                                        } else if (next2.equals("it")) {
                                            mTDBsBody.getCards().setIt(Boxing.boxInt(version2));
                                        }
                                    } else if (next2.equals("fr")) {
                                        mTDBsBody.getCards().setFr(Boxing.boxInt(version2));
                                    }
                                } else if (next2.equals("es")) {
                                    mTDBsBody.getCards().setEs(Boxing.boxInt(version2));
                                }
                            } else if (next2.equals("de")) {
                                mTDBsBody.getCards().setDe(Boxing.boxInt(version2));
                            }
                        }
                        it3 = it4;
                    }
                }
                GlossaryDBHelper.Companion companion7 = GlossaryDBHelper.INSTANCE;
                Context applicationContext11 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext11, "getApplicationContext(...)");
                GlossaryDBHelper companion8 = companion7.getInstance(applicationContext11);
                if (companion8.isValid()) {
                    mTDBsBody.getGlossary().setEn(Boxing.boxInt(companion8.getVersion()));
                }
                GlossaryDBHelperLocalized.Companion companion9 = GlossaryDBHelperLocalized.INSTANCE;
                Context applicationContext12 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext12, "getApplicationContext(...)");
                GlossaryDBHelperLocalized companion10 = companion9.getInstance(applicationContext12, "fr");
                if (companion10.isValid()) {
                    mTDBsBody.getGlossary().setFr(Boxing.boxInt(companion10.getVersion()));
                }
                RulesDBHelper.Companion companion11 = RulesDBHelper.INSTANCE;
                Context applicationContext13 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext13, "getApplicationContext(...)");
                RulesDBHelper companion12 = companion11.getInstance(applicationContext13);
                if (companion12.isValid()) {
                    mTDBsBody.getRules().setEn(Boxing.boxInt(companion12.getVersion()));
                }
                RulesDBHelperLocalized.Companion companion13 = RulesDBHelperLocalized.INSTANCE;
                Context applicationContext14 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext14, "getApplicationContext(...)");
                RulesDBHelperLocalized companion14 = companion13.getInstance(applicationContext14, "fr");
                if (companion14.isValid()) {
                    mTDBsBody.getRules().setFr(Boxing.boxInt(companion14.getVersion()));
                }
                RulingsDBHelper.Companion companion15 = RulingsDBHelper.INSTANCE;
                Context applicationContext15 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext15, "getApplicationContext(...)");
                RulingsDBHelper companion16 = companion15.getInstance(applicationContext15, "fr");
                if (companion16.isValid()) {
                    mTDBsBody.getRulings().setFr(Boxing.boxInt(companion16.getVersion()));
                }
                SetsDBHelper.Companion companion17 = SetsDBHelper.INSTANCE;
                Context applicationContext16 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext16, "getApplicationContext(...)");
                SetsDBHelper companion18 = companion17.getInstance(applicationContext16);
                if (companion18.isValid()) {
                    mTDBsBody.getSets().setEn(Boxing.boxInt(companion18.getVersion()));
                }
                SetsDBHelperLocalized.Companion companion19 = SetsDBHelperLocalized.INSTANCE;
                Context applicationContext17 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext17, "getApplicationContext(...)");
                SetsDBHelperLocalized companion20 = companion19.getInstance(applicationContext17, "fr");
                if (companion20.isValid()) {
                    mTDBsBody.getSets().setFr(Boxing.boxInt(companion20.getVersion()));
                }
                MTApiKt.getMtApi().checkForDBUpdates(mTDBsBody).enqueue(new C02101(this.this$0));
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        static final void invokeSuspend$lambda$0(final MainActivity mainActivity, PreferencesManager preferencesManager, final String str) {
            if (mainActivity.instanceStateSaved || mainActivity.isFinishing() || mainActivity.isDestroyed()) {
                return;
            }
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = mainActivity.getString(R.string.db_download_prompt_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = mainActivity.getString(R.string.db_download_prompt_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(StringsKt.replace$default(string2, "{1}", preferencesManager.getNameForLanguage(str), false, 4, (Object) null));
            String string3 = mainActivity.getString(R.string.download);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.AnonymousClass1.invokeSuspend$lambda$0$0(mainActivity, str, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = mainActivity.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainActivity.AnonymousClass1.invokeSuspend$lambda$0$1(mainActivity, (CustomDialogFragment) obj);
                }
            }).setPositiveButtonRed();
            FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButtonRed.show(supportFragmentManager, "CustomDialogFragment");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(MainActivity mainActivity, String str, boolean z, CustomDialogFragment customDialogFragment) {
            if (mainActivity.isDestroyed() || mainActivity.isFinishing()) {
                return Unit.INSTANCE;
            }
            Breadcrumbs.INSTANCE.leaveBreadcrumb("prompt_db_download_start");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainActivity);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("prompt_db_download_start", null);
            customDialogFragment.dismiss();
            MTGDBHelperLocalized.Companion companion = MTGDBHelperLocalized.INSTANCE;
            Context applicationContext = mainActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            MTGDBHelperLocalized companion2 = companion.getInstance(applicationContext, str);
            ((ConstraintLayout) mainActivity.findViewById(R.id.downloading_layout)).setVisibility(0);
            mainActivity.downloadDatabasesSequentially(CollectionsKt.listOf(companion2));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$1(MainActivity mainActivity, CustomDialogFragment customDialogFragment) {
            if (mainActivity.isDestroyed() || mainActivity.isFinishing()) {
                return Unit.INSTANCE;
            }
            customDialogFragment.dismiss();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new AnonymousClass1(continuation);
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
                final PreferencesManager preferencesManager = new PreferencesManager(MainActivity.this);
                final String deviceLanguage = preferencesManager.getDeviceLanguage();
                if (!Intrinsics.areEqual(deviceLanguage, "en") && !Intrinsics.areEqual(deviceLanguage, "fr")) {
                    MTGDBHelperLocalized.Companion companion = MTGDBHelperLocalized.INSTANCE;
                    Context applicationContext = MainActivity.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    if (!companion.getInstance(applicationContext, deviceLanguage).isValid()) {
                        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_download_prompt_msg");
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(MainActivity.this);
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                        firebaseAnalytics.logEvent("db_download_prompt_msg", null);
                        Handler handler = new Handler(Looper.getMainLooper());
                        final MainActivity mainActivity = MainActivity.this;
                        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$checkDatabaseUpdates$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                MainActivity.AnonymousClass1.invokeSuspend$lambda$0(mainActivity, preferencesManager, deviceLanguage);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deviceLanguage);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(MainActivity.this, preferencesManager, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$checkUnSyncedGames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$checkUnSyncedGames$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12091(Continuation<? super C12091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C12091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<GameState> unSyncedGames = new PreferencesManager(MainActivity.this).getUnSyncedGames();
            if (!unSyncedGames.isEmpty()) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("unsynced_games_send");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(MainActivity.this);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("unsynced_games_send", null);
                MainActivity.this.syncGamesSequentially(unSyncedGames);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$checkUnSyncedSets$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$checkUnSyncedSets$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12101(Continuation<? super C12101> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C12101(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<GameSet> unSyncedSets = new PreferencesManager(MainActivity.this).getUnSyncedSets();
            if (!unSyncedSets.isEmpty()) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("unsynced_sets_send");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(MainActivity.this);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("unsynced_sets_send", null);
                MainActivity.this.syncSetsSequentially(unSyncedSets);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$downloadDatabasesSequentially$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$downloadDatabasesSequentially$1", f = "MainActivity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {2017}, m = "invokeSuspend", n = {"$this$launch", "currentDb", "$this$forEach$iv", "element$iv", "helper", "deferred", "totalDbs", "$i$f$forEach", "$i$a$-forEach-MainActivity$downloadDatabasesSequentially$1$1"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class C12111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<UpdatableMTGHelper> $helpers;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12111(List<? extends UpdatableMTGHelper> list, MainActivity mainActivity, Continuation<? super C12111> continuation) {
            super(2, continuation);
            this.$helpers = list;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12111 c12111 = new C12111(this.$helpers, this.this$0, continuation);
            c12111.L$0 = obj;
            return c12111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00e1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00b3 -> B:15:0x00b6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Ref.IntRef intRef;
            Iterable iterable;
            MainActivity mainActivity;
            Iterator it;
            int i2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                int size = this.$helpers.size();
                Ref.IntRef intRef2 = new Ref.IntRef();
                List<UpdatableMTGHelper> list = this.$helpers;
                i = size;
                intRef = intRef2;
                iterable = list;
                mainActivity = this.this$0;
                it = list.iterator();
                i2 = 0;
                if (it.hasNext()) {
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                int i4 = this.I$0;
                UpdatableMTGHelper updatableMTGHelper = (UpdatableMTGHelper) this.L$6;
                it = (Iterator) this.L$4;
                MainActivity mainActivity2 = (MainActivity) this.L$3;
                Iterable iterable2 = (Iterable) this.L$2;
                Ref.IntRef intRef3 = (Ref.IntRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                i = i4;
                iterable = iterable2;
                intRef = intRef3;
                mainActivity = mainActivity2;
                intRef.element++;
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainActivity);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                Bundle bundle = new Bundle();
                bundle.putString("language_code", updatableMTGHelper.getLocale());
                Breadcrumbs.INSTANCE.leaveBreadcrumb("update_db");
                firebaseAnalytics.logEvent("update_db", bundle);
                if (it.hasNext()) {
                    Object next = it.next();
                    UpdatableMTGHelper updatableMTGHelper2 = (UpdatableMTGHelper) next;
                    Iterator it2 = it;
                    int i5 = i2;
                    Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new MainActivity$downloadDatabasesSequentially$1$1$deferred$1(mainActivity, updatableMTGHelper2, intRef, i, null), 2, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = intRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$3 = mainActivity;
                    this.L$4 = it2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$6 = updatableMTGHelper2;
                    this.L$7 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                    this.I$0 = i;
                    this.I$1 = i5;
                    this.I$2 = 0;
                    this.label = 1;
                    if (deferredAsync$default.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                    updatableMTGHelper = updatableMTGHelper2;
                    i2 = i5;
                    intRef.element++;
                    FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(mainActivity);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("language_code", updatableMTGHelper.getLocale());
                    Breadcrumbs.INSTANCE.leaveBreadcrumb("update_db");
                    firebaseAnalytics2.logEvent("update_db", bundle2);
                    if (it.hasNext()) {
                        this.this$0.onAllDownloadsComplete(this.$helpers);
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$onAllDownloadsComplete$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$onAllDownloadsComplete$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CardSetsManager.INSTANCE.loadCardSets();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$onAllDownloadsComplete$4, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$onAllDownloadsComplete$4", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GlossaryManager.INSTANCE.loadGlossaries();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$setupAuthStateMonitoring$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/studiolaganne/lengendarylens/MainActivity$setupAuthStateMonitoring$2", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12152 extends BroadcastReceiver {
        C12152() {
        }

        static final void onReceive$lambda$0(MainActivity mainActivity) {
            if (mainActivity.isFinishing() || mainActivity.isDestroyed()) {
                return;
            }
            mainActivity.showSessionExpiredDialog();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            Log.d(MainActivity.TAG, "Received auth error broadcast: code=" + intent.getIntExtra("error_code", -1) + ", message=" + intent.getStringExtra("error_message"));
            final MainActivity mainActivity = MainActivity.this;
            mainActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$setupAuthStateMonitoring$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.C12152.onReceive$lambda$0(mainActivity);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$startupChecks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/MainActivity$startupChecks$1", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12161 implements BillingClientStateListener {
        C12161() {
        }

        static final void onBillingSetupFinished$lambda$0(MainActivity mainActivity, BillingResult p0, List p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            if (p0.getResponseCode() == 0) {
                Iterator it = p1.iterator();
                while (it.hasNext()) {
                    Purchase purchase = (Purchase) it.next();
                    if (purchase.getProducts().contains(PreferencesManager.SOLRING_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "SolRing theme already purchased - restoring");
                        PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
                        preferencesManager.addThemePurchased(PreferencesManager.SOLRING_THEME);
                        Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                        String purchaseToken = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
                        Log.d("Billing", "SolRing theme already purchased - token = " + purchaseToken);
                        if (!mutableMap.containsKey(PreferencesManager.SOLRING_THEME)) {
                            mutableMap.put(PreferencesManager.SOLRING_THEME, purchaseToken);
                        }
                        preferencesManager.saveAllThemeTokens(mutableMap);
                        preferencesManager.syncThemePurchase(PreferencesManager.SOLRING_THEME);
                    }
                    if (purchase.getProducts().contains(PreferencesManager.XMAS_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "XMAS_THEME theme already purchased - restoring");
                        PreferencesManager preferencesManager2 = new PreferencesManager(mainActivity);
                        preferencesManager2.addThemePurchased(PreferencesManager.XMAS_THEME);
                        Map<String, String> mutableMap2 = MapsKt.toMutableMap(preferencesManager2.getAllThemeTokens());
                        String purchaseToken2 = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken2, "getPurchaseToken(...)");
                        Log.d("Billing", "XMAS_THEME theme already purchased - token = " + purchaseToken2);
                        if (!mutableMap2.containsKey(PreferencesManager.XMAS_THEME)) {
                            mutableMap2.put(PreferencesManager.XMAS_THEME, purchaseToken2);
                        }
                        preferencesManager2.saveAllThemeTokens(mutableMap2);
                        preferencesManager2.syncThemePurchase(PreferencesManager.XMAS_THEME);
                    }
                    if (purchase.getProducts().contains(PreferencesManager.LOVE_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "LOVE_THEME theme already purchased - restoring");
                        PreferencesManager preferencesManager3 = new PreferencesManager(mainActivity);
                        preferencesManager3.addThemePurchased(PreferencesManager.LOVE_THEME);
                        Map<String, String> mutableMap3 = MapsKt.toMutableMap(preferencesManager3.getAllThemeTokens());
                        String purchaseToken3 = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken3, "getPurchaseToken(...)");
                        Log.d("Billing", "LOVE_THEME theme already purchased - token = " + purchaseToken3);
                        if (!mutableMap3.containsKey(PreferencesManager.LOVE_THEME)) {
                            mutableMap3.put(PreferencesManager.LOVE_THEME, purchaseToken3);
                        }
                        preferencesManager3.saveAllThemeTokens(mutableMap3);
                        preferencesManager3.syncThemePurchase(PreferencesManager.LOVE_THEME);
                    }
                    if (purchase.getProducts().contains(PreferencesManager.BURN_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "BURN_THEME theme already purchased - restoring");
                        PreferencesManager preferencesManager4 = new PreferencesManager(mainActivity);
                        preferencesManager4.addThemePurchased(PreferencesManager.BURN_THEME);
                        Map<String, String> mutableMap4 = MapsKt.toMutableMap(preferencesManager4.getAllThemeTokens());
                        String purchaseToken4 = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken4, "getPurchaseToken(...)");
                        Log.d("Billing", "BURN_THEME theme already purchased - token = " + purchaseToken4);
                        if (!mutableMap4.containsKey(PreferencesManager.BURN_THEME)) {
                            mutableMap4.put(PreferencesManager.BURN_THEME, purchaseToken4);
                        }
                        preferencesManager4.saveAllThemeTokens(mutableMap4);
                        preferencesManager4.syncThemePurchase(PreferencesManager.BURN_THEME);
                    }
                    if (purchase.getProducts().contains(PreferencesManager.AF_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "AF_THEME theme already purchased - restoring");
                        PreferencesManager preferencesManager5 = new PreferencesManager(mainActivity);
                        preferencesManager5.addThemePurchased(PreferencesManager.AF_THEME);
                        Map<String, String> mutableMap5 = MapsKt.toMutableMap(preferencesManager5.getAllThemeTokens());
                        String purchaseToken5 = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken5, "getPurchaseToken(...)");
                        Log.d("Billing", "AF_THEME theme already purchased - token = " + purchaseToken5);
                        if (!mutableMap5.containsKey(PreferencesManager.AF_THEME)) {
                            mutableMap5.put(PreferencesManager.AF_THEME, purchaseToken5);
                        }
                        preferencesManager5.saveAllThemeTokens(mutableMap5);
                        preferencesManager5.syncThemePurchase(PreferencesManager.AF_THEME);
                    }
                    if (purchase.getProducts().contains(PreferencesManager.LUPO_THEME) && purchase.getPurchaseState() == 1) {
                        Log.d("Billing", "LUPO_THEME theme already purchased - restoring");
                        PreferencesManager preferencesManager6 = new PreferencesManager(mainActivity);
                        preferencesManager6.addThemePurchased(PreferencesManager.LUPO_THEME);
                        Map<String, String> mutableMap6 = MapsKt.toMutableMap(preferencesManager6.getAllThemeTokens());
                        String purchaseToken6 = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken6, "getPurchaseToken(...)");
                        Log.d("Billing", "LUPO_THEME theme already purchased - token = " + purchaseToken6);
                        if (!mutableMap6.containsKey(PreferencesManager.LUPO_THEME)) {
                            mutableMap6.put(PreferencesManager.LUPO_THEME, purchaseToken6);
                        }
                        preferencesManager6.saveAllThemeTokens(mutableMap6);
                        preferencesManager6.syncThemePurchase(PreferencesManager.LUPO_THEME);
                    }
                }
                Toast.makeText(mainActivity, mainActivity.getResources().getString(R.string.restore_purchases_ok), 0).show();
            }
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            if (billingResult.getResponseCode() == 0) {
                BillingClient billingClient = MainActivity.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                QueryPurchasesParams queryPurchasesParamsBuild = QueryPurchasesParams.newBuilder().setProductType("inapp").build();
                final MainActivity mainActivity = MainActivity.this;
                billingClient.queryPurchasesAsync(queryPurchasesParamsBuild, new PurchasesResponseListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$startupChecks$1$$ExternalSyntheticLambda0
                    @Override // com.android.billingclient.api.PurchasesResponseListener
                    public final void onQueryPurchasesResponse(BillingResult billingResult2, List list) {
                        MainActivity.C12161.onBillingSetupFinished$lambda$0(mainActivity, billingResult2, list);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$syncGamesSequentially$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$syncGamesSequentially$1", f = "MainActivity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1854}, m = "invokeSuspend", n = {"$this$launch", "currentGame", "$this$forEach$iv", "element$iv", "game", "deferred", "totalGames", "$i$f$forEach", "$i$a$-forEach-MainActivity$syncGamesSequentially$1$1"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class C12171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<GameState> $games;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12171(List<GameState> list, MainActivity mainActivity, Continuation<? super C12171> continuation) {
            super(2, continuation);
            this.$games = list;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12171 c12171 = new C12171(this.$games, this.this$0, continuation);
            c12171.L$0 = obj;
            return c12171;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00b9 -> B:15:0x00bb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Ref.IntRef intRef;
            Iterable iterable;
            MainActivity mainActivity;
            Iterator it;
            int i2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                int size = this.$games.size();
                Ref.IntRef intRef2 = new Ref.IntRef();
                List<GameState> list = this.$games;
                i = size;
                intRef = intRef2;
                iterable = list;
                mainActivity = this.this$0;
                it = list.iterator();
                i2 = 0;
                if (it.hasNext()) {
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                int i4 = this.I$0;
                it = (Iterator) this.L$4;
                MainActivity mainActivity2 = (MainActivity) this.L$3;
                Iterable iterable2 = (Iterable) this.L$2;
                Ref.IntRef intRef3 = (Ref.IntRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                i = i4;
                mainActivity = mainActivity2;
                iterable = iterable2;
                intRef = intRef3;
                intRef.element++;
                if (it.hasNext()) {
                    Object next = it.next();
                    GameState gameState = (GameState) next;
                    int i5 = i2;
                    Iterator it2 = it;
                    Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new MainActivity$syncGamesSequentially$1$1$deferred$1(mainActivity, gameState, intRef, i, null), 2, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = intRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$3 = mainActivity;
                    this.L$4 = it2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(gameState);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                    this.I$0 = i;
                    this.I$1 = i5;
                    this.I$2 = 0;
                    this.label = 1;
                    if (deferredAsync$default.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                    i2 = i5;
                    intRef.element++;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MainActivity$syncSetsSequentially$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$syncSetsSequentially$1", f = "MainActivity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1929}, m = "invokeSuspend", n = {"$this$launch", "currentSet", "$this$forEach$iv", "element$iv", "set", "deferred", "totalSets", "$i$f$forEach", "$i$a$-forEach-MainActivity$syncSetsSequentially$1$1"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class C12181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<GameSet> $sets;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12181(List<GameSet> list, MainActivity mainActivity, Continuation<? super C12181> continuation) {
            super(2, continuation);
            this.$sets = list;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12181 c12181 = new C12181(this.$sets, this.this$0, continuation);
            c12181.L$0 = obj;
            return c12181;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00b9 -> B:15:0x00bb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Ref.IntRef intRef;
            Iterable iterable;
            MainActivity mainActivity;
            Iterator it;
            int i2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                int size = this.$sets.size();
                Ref.IntRef intRef2 = new Ref.IntRef();
                List<GameSet> list = this.$sets;
                i = size;
                intRef = intRef2;
                iterable = list;
                mainActivity = this.this$0;
                it = list.iterator();
                i2 = 0;
                if (it.hasNext()) {
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                int i4 = this.I$0;
                it = (Iterator) this.L$4;
                MainActivity mainActivity2 = (MainActivity) this.L$3;
                Iterable iterable2 = (Iterable) this.L$2;
                Ref.IntRef intRef3 = (Ref.IntRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                i = i4;
                mainActivity = mainActivity2;
                iterable = iterable2;
                intRef = intRef3;
                intRef.element++;
                if (it.hasNext()) {
                    Object next = it.next();
                    GameSet gameSet = (GameSet) next;
                    int i5 = i2;
                    Iterator it2 = it;
                    Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new MainActivity$syncSetsSequentially$1$1$deferred$1(mainActivity, gameSet, intRef, i, null), 2, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = intRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$3 = mainActivity;
                    this.L$4 = it2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(gameSet);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                    this.I$0 = i;
                    this.I$1 = i5;
                    this.I$2 = 0;
                    this.label = 1;
                    if (deferredAsync$default.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                    i2 = i5;
                    intRef.element++;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    private final void checkAndResetBatterySavingMode() {
        Intent intentRegisterReceiver = registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0 || (intExtra / intExtra2) * 100.0f < 50.0f) {
            return;
        }
        new PreferencesManager(this).setBatterySavingMode(false);
        disableBatterySavingChanges();
    }

    private final void checkDatabaseUpdates() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void checkUnSyncedGames() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C12091(null), 3, null);
    }

    private final void checkUnSyncedSets() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C12101(null), 3, null);
    }

    private final void disableBatterySavingChanges() {
        GameFragment gameFragment;
        getWindow().setWindowAnimations(android.R.style.Animation.Activity);
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().getAttributes().preferredRefreshRate = 0.0f;
        }
        if (new PreferencesManager(this).getCurrentGame() == null || (gameFragment = this.gameFragment) == null) {
            return;
        }
        gameFragment.disableBatterySaving();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadDatabase(final UpdatableMTGHelper updatableMTGHelper, final int i, final int i2, Continuation<? super Unit> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        updatableMTGHelper.downloadDBFile(new Function1<Integer, Unit>() { // from class: com.studiolaganne.lengendarylens.MainActivity$downloadDatabase$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                this.updateGlobalProgress(((i * 100) + i3) / i2);
            }
        }, new Function0<Unit>() { // from class: com.studiolaganne.lengendarylens.MainActivity$downloadDatabase$2$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (updatableMTGHelper.isValid()) {
                    new PreferencesManager(this).setLanguageEnabled(updatableMTGHelper.getLocale(), true);
                }
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
            }
        }, new Function1<String, Unit>() { // from class: com.studiolaganne.lengendarylens.MainActivity$downloadDatabase$2$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String err) {
                Intrinsics.checkNotNullParameter(err, "err");
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadDatabasesSequentially(List<? extends UpdatableMTGHelper> helpers) {
        BuildersKt__Builders_commonKt.launch$default(this.downloadScope, null, null, new C12111(helpers, this, null), 3, null);
    }

    private final void enableBatterySavingChanges() {
        GameFragment gameFragment;
        getWindow().setWindowAnimations(0);
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = getDisplay();
            Display.Mode mode = null;
            Display.Mode[] supportedModes = display != null ? display.getSupportedModes() : null;
            if (supportedModes != null && supportedModes.length != 0) {
                mode = supportedModes[0];
                int lastIndex = ArraysKt.getLastIndex(supportedModes);
                if (lastIndex != 0) {
                    float refreshRate = mode.getRefreshRate();
                    int i = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Display.Mode mode2 = supportedModes[i];
                            float refreshRate2 = mode2.getRefreshRate();
                            if (Float.compare(refreshRate, refreshRate2) > 0) {
                                mode = mode2;
                                refreshRate = refreshRate2;
                            }
                            if (i == lastIndex) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
            if (mode != null) {
                getWindow().getAttributes().preferredRefreshRate = mode.getRefreshRate();
            }
        }
        if (new PreferencesManager(this).getCurrentGame() == null || (gameFragment = this.gameFragment) == null) {
            return;
        }
        gameFragment.enableBatterySaving();
    }

    private final void fetchInstallReferrerAndLog(final Context context) {
        final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
        installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.studiolaganne.lengendarylens.MainActivity.fetchInstallReferrerAndLog.1
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
                Log.d("Referrer", "Referrer service disconnected");
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int responseCode) {
                InstallReferrerClient installReferrerClient;
                try {
                    if (responseCode != 0) {
                        if (responseCode == 1) {
                            Log.d("Referrer", "Install Referrer service unavailable");
                            return;
                        } else {
                            if (responseCode != 2) {
                                return;
                            }
                            Log.d("Referrer", "Install Referrer not supported");
                            return;
                        }
                    }
                    String installReferrer = installReferrerClientBuild.getInstallReferrer().getInstallReferrer();
                    Log.d("Referrer", "Referrer URL: " + installReferrer);
                    Uri uri = Uri.parse("https://dummy.com?" + installReferrer);
                    String queryParameter = uri.getQueryParameter("utm_source");
                    String str = "unknown";
                    if (queryParameter == null) {
                        queryParameter = "unknown";
                    }
                    String queryParameter2 = uri.getQueryParameter("utm_medium");
                    if (queryParameter2 == null) {
                        queryParameter2 = "unknown";
                    }
                    String queryParameter3 = uri.getQueryParameter("utm_campaign");
                    if (queryParameter3 != null) {
                        str = queryParameter3;
                    }
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                    Bundle bundle = new Bundle();
                    bundle.putString("utm_source", queryParameter);
                    bundle.putString("utm_medium", queryParameter2);
                    bundle.putString("utm_campaign", str);
                    firebaseAnalytics.logEvent("install_referrer_event", bundle);
                } catch (Exception e) {
                    Log.e("Referrer", "Error getting install referrer", e);
                } finally {
                    installReferrerClientBuild.endConnection();
                }
            }
        });
    }

    private final void handleAuthFailureSignOut() {
        MainActivity mainActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
        FirebaseTokenManager.INSTANCE.stopTokenAutoRefresh();
        FirebaseAuth.AuthStateListener authStateListener = this.authStateListener;
        if (authStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);
        }
        BottomNavigationView bottomNavigationView = null;
        try {
            FirebaseAuth.getInstance().signOut();
            CustomerIO.INSTANCE.instance().clearIdentify();
            Purchases.logOut$default(Purchases.INSTANCE.getSharedInstance(), null, 1, null);
        } catch (Exception e) {
            Log.e(TAG, "Error signing out from Firebase", e);
        }
        preferencesManager.clearCurrentUser();
        preferencesManager.clearAllUsersDecks();
        preferencesManager.clearUnSyncedGames();
        preferencesManager.clearUnSyncedSets();
        preferencesManager.clearCurrentUserFavorites();
        preferencesManager.clearRecentCardsNew();
        preferencesManager.clearCurrentUserTags();
        FirebaseAnalytics.getInstance(mainActivity).setUserProperty("is_logged_in", CredentialEntry.FALSE_STRING);
        BottomNavigationView bottomNavigationView2 = this.navView;
        if (bottomNavigationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
        } else {
            bottomNavigationView = bottomNavigationView2;
        }
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        HomeFragment homeFragment = this.homeFragment;
        if (homeFragment != null) {
            homeFragment.showSignedOutState();
        }
        AuthErrorHandler.INSTANCE.resetDialogState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v20, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v26, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v31, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v27, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v36, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, java.lang.String] */
    public final void handleDatabaseUpdates(final List<String> helpersToUpdate, final List<String> glossaryToUpdate, final List<String> rulesToUpdate, final List<String> setsToUpdate, final List<String> rulingsToUpdate, final List<String> scannerToUpdate) {
        if ((helpersToUpdate.isEmpty() && glossaryToUpdate.isEmpty() && rulesToUpdate.isEmpty() && setsToUpdate.isEmpty() && rulingsToUpdate.isEmpty() && scannerToUpdate.isEmpty()) || isDestroyed() || isFinishing() || this.instanceStateSaved) {
            return;
        }
        MainActivity mainActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_updates_msg");
        final FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("db_updates_msg", null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        for (String str : helpersToUpdate) {
            if (((CharSequence) objectRef.element).length() > 0) {
                objectRef.element += ", ";
            }
            Object obj = objectRef.element;
            String string = getString(R.string.cards_db_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            objectRef.element = obj + StringsKt.replace$default(string, "{1}", preferencesManager.getNameForLanguage(str), false, 4, (Object) null);
        }
        if (!rulesToUpdate.isEmpty()) {
            for (String str2 : rulesToUpdate) {
                if (((CharSequence) objectRef.element).length() > 0) {
                    objectRef.element += ", ";
                }
                Object obj2 = objectRef.element;
                String string2 = getString(R.string.rules_db_name);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                objectRef.element = obj2 + StringsKt.replace$default(string2, "{1}", preferencesManager.getNameForLanguage(str2), false, 4, (Object) null);
            }
        }
        if (!glossaryToUpdate.isEmpty()) {
            for (String str3 : glossaryToUpdate) {
                if (((CharSequence) objectRef.element).length() > 0) {
                    objectRef.element += ", ";
                }
                Object obj3 = objectRef.element;
                String string3 = getString(R.string.glossary_db_name);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                objectRef.element = obj3 + StringsKt.replace$default(string3, "{1}", preferencesManager.getNameForLanguage(str3), false, 4, (Object) null);
            }
        }
        if (!setsToUpdate.isEmpty()) {
            for (String str4 : setsToUpdate) {
                if (((CharSequence) objectRef.element).length() > 0) {
                    objectRef.element += ", ";
                }
                Object obj4 = objectRef.element;
                String string4 = getString(R.string.sets_db_name);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                objectRef.element = obj4 + StringsKt.replace$default(string4, "{1}", preferencesManager.getNameForLanguage(str4), false, 4, (Object) null);
            }
        }
        if (!rulingsToUpdate.isEmpty()) {
            for (String str5 : rulingsToUpdate) {
                if (((CharSequence) objectRef.element).length() > 0) {
                    objectRef.element += ", ";
                }
                Object obj5 = objectRef.element;
                String string5 = getString(R.string.rulings_db_name);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                objectRef.element = obj5 + StringsKt.replace$default(string5, "{1}", preferencesManager.getNameForLanguage(str5), false, 4, (Object) null);
            }
        }
        if (!scannerToUpdate.isEmpty()) {
            if (((CharSequence) objectRef.element).length() > 0) {
                objectRef.element += ", ";
            }
            objectRef.element = objectRef.element + getString(R.string.scanner_files);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.handleDatabaseUpdates$lambda$0(this.f$0, objectRef, firebaseAnalytics, scannerToUpdate, helpersToUpdate, glossaryToUpdate, rulesToUpdate, setsToUpdate, rulingsToUpdate);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final void handleDatabaseUpdates$lambda$0(final MainActivity mainActivity, Ref.ObjectRef objectRef, final FirebaseAnalytics firebaseAnalytics, final List list, final List list2, final List list3, final List list4, final List list5, final List list6) {
        if (mainActivity.instanceStateSaved || mainActivity.isFinishing() || mainActivity.isDestroyed()) {
            return;
        }
        String string = mainActivity.getString(R.string.db_update_needed_body);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strReplace$default = StringsKt.replace$default(string, "{1}", (String) objectRef.element, false, 4, (Object) null);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string2 = mainActivity.getString(R.string.db_update_needed);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(strReplace$default);
        String string3 = mainActivity.getString(R.string.download);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.handleDatabaseUpdates$lambda$0$0(this.f$0, firebaseAnalytics, list, list2, list3, list4, list5, list6, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = mainActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.handleDatabaseUpdates$lambda$0$1(this.f$0, (CustomDialogFragment) obj);
            }
        }).setPositiveButtonRed();
        FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        positiveButtonRed.show(supportFragmentManager, "CustomDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Unit handleDatabaseUpdates$lambda$0$0(MainActivity mainActivity, FirebaseAnalytics firebaseAnalytics, List list, List list2, List list3, List list4, List list5, List list6, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (mainActivity.isDestroyed() || mainActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_updates_start");
        firebaseAnalytics.logEvent("db_updates_start", null);
        dialog.dismiss();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            switch (str.hashCode()) {
                case 291963572:
                    if (str.equals("embeddings_sets")) {
                        Context applicationContext = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext, "embeddings_sets", ".meb"));
                    }
                    break;
                case 446038368:
                    if (str.equals("embeddings_cards")) {
                        Context applicationContext2 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext2, "embeddings_cards", ".meb"));
                    }
                    break;
                case 703351194:
                    if (str.equals("model_card_classifier")) {
                        Context applicationContext3 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext3, "model_card_classifier", ".onnx"));
                    }
                    break;
                case 1523530669:
                    if (str.equals("model_plist_detector")) {
                        Context applicationContext4 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext4, "model_plist_detector", ".onnx"));
                    }
                    break;
                case 1774571786:
                    if (str.equals("model_card_art")) {
                        Context applicationContext5 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext5, "model_card_art", ".onnx"));
                    }
                    break;
                case 1851327208:
                    if (str.equals("model_set_symbols")) {
                        Context applicationContext6 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext6, "model_set_symbols", ".onnx"));
                    }
                    break;
                case 1908688876:
                    if (str.equals("model_card_detection")) {
                        Context applicationContext7 = mainActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext7, "getApplicationContext(...)");
                        arrayList.add(new GenericDBHelper(applicationContext7, "model_card_detection", ".onnx"));
                    }
                    break;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (Intrinsics.areEqual(str2, "en")) {
                arrayList.add(MTGDBHelper.INSTANCE.getInstance(mainActivity));
            } else {
                arrayList.add(MTGDBHelperLocalized.INSTANCE.getInstance(mainActivity, str2));
            }
        }
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            if (Intrinsics.areEqual(str3, "en")) {
                arrayList.add(GlossaryDBHelper.INSTANCE.getInstance(mainActivity));
            } else {
                arrayList.add(GlossaryDBHelperLocalized.INSTANCE.getInstance(mainActivity, str3));
            }
        }
        Iterator it4 = list4.iterator();
        while (it4.hasNext()) {
            String str4 = (String) it4.next();
            if (Intrinsics.areEqual(str4, "en")) {
                arrayList.add(RulesDBHelper.INSTANCE.getInstance(mainActivity));
            } else {
                arrayList.add(RulesDBHelperLocalized.INSTANCE.getInstance(mainActivity, str4));
            }
        }
        Iterator it5 = list5.iterator();
        while (it5.hasNext()) {
            String str5 = (String) it5.next();
            if (Intrinsics.areEqual(str5, "en")) {
                arrayList.add(SetsDBHelper.INSTANCE.getInstance(mainActivity));
            } else {
                arrayList.add(SetsDBHelperLocalized.INSTANCE.getInstance(mainActivity, str5));
            }
        }
        Iterator it6 = list6.iterator();
        while (it6.hasNext()) {
            arrayList.add(RulingsDBHelper.INSTANCE.getInstance(mainActivity, (String) it6.next()));
        }
        ((ConstraintLayout) mainActivity.findViewById(R.id.downloading_layout)).setVisibility(0);
        mainActivity.downloadDatabasesSequentially(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDatabaseUpdates$lambda$0$1(MainActivity mainActivity, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (mainActivity.isDestroyed() || mainActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void handleDeepLink(Uri uri) {
        Log.d(TAG, "handleDeepLink - Received URI: " + uri);
        DeepLinkRoute deepLinkRoute = DeepLinkRouter.INSTANCE.parse(uri);
        if (deepLinkRoute instanceof DeepLinkRoute.OAuthCallback) {
            handleOAuthCallback(uri);
            return;
        }
        if (deepLinkRoute instanceof DeepLinkRoute.EmailVerify) {
            handleEmailVerifyCallback(uri);
            return;
        }
        if (deepLinkRoute instanceof DeepLinkRoute.EventQR) {
            handleEventQR(((DeepLinkRoute.EventQR) deepLinkRoute).getUrl());
            return;
        }
        if (deepLinkRoute instanceof DeepLinkRoute.UserProfile) {
            handleUserProfileLink(((DeepLinkRoute.UserProfile) deepLinkRoute).getUserId());
            return;
        }
        if (deepLinkRoute instanceof DeepLinkRoute.UserDeck) {
            DeepLinkRoute.UserDeck userDeck = (DeepLinkRoute.UserDeck) deepLinkRoute;
            handleUserDeckLink(userDeck.getUserId(), userDeck.getDeckId());
        } else if (deepLinkRoute instanceof DeepLinkRoute.UserList) {
            DeepLinkRoute.UserList userList = (DeepLinkRoute.UserList) deepLinkRoute;
            handleUserListLink(userList.getUserId(), userList.getListId());
        } else {
            if (!(deepLinkRoute instanceof DeepLinkRoute.Unknown)) {
                throw new NoWhenBranchMatchedException();
            }
            Log.w(TAG, "Unrecognized deep link: " + uri);
        }
    }

    private final void handleEmailVerifyCallback(Uri uri) {
        Log.d("EmailVerify", "Received URI: " + uri);
        BottomNavigationView bottomNavigationView = null;
        if (this.currentSelectedTab != R.id.navigation_home) {
            BottomNavigationView bottomNavigationView2 = this.navView;
            if (bottomNavigationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navView");
                bottomNavigationView2 = null;
            }
            bottomNavigationView2.setSelectedItemId(R.id.navigation_home);
        }
        BottomNavigationView bottomNavigationView3 = this.navView;
        if (bottomNavigationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
        } else {
            bottomNavigationView = bottomNavigationView3;
        }
        bottomNavigationView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.handleEmailVerifyCallback$lambda$0(this.f$0);
            }
        });
    }

    static final void handleEmailVerifyCallback$lambda$0(final MainActivity mainActivity) {
        Task<GetTokenResult> idToken;
        FragmentManager childFragmentManager;
        Fragment fragmentFindFragmentByTag = mainActivity.getSupportFragmentManager().findFragmentByTag("home");
        final HomeFragment homeFragment = fragmentFindFragmentByTag instanceof HomeFragment ? (HomeFragment) fragmentFindFragmentByTag : null;
        Fragment fragmentFindFragmentByTag2 = (homeFragment == null || (childFragmentManager = homeFragment.getChildFragmentManager()) == null) ? null : childFragmentManager.findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag2 instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag2 : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.onEmailVerified();
            return;
        }
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseAuth, "getInstance(...)");
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (idToken = currentUser.getIdToken(true)) == null) {
            return;
        }
        idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MainActivity.handleEmailVerifyCallback$lambda$0$0(this.f$0, homeFragment, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEmailVerifyCallback$lambda$0$0(MainActivity mainActivity, HomeFragment homeFragment, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (!tokenTask.isSuccessful()) {
            if (homeFragment != null) {
                homeFragment.onSignInFailure("Failed to retrieve Firebase ID token.");
                return;
            }
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            if (homeFragment != null) {
                homeFragment.onSignInFailure("No Firebase token received.");
                return;
            }
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        if (homeFragment != null) {
            homeFragment.onSignInSuccess(token, null, null);
        }
    }

    private final void handleEventQR(final String url) {
        Log.d(TAG, "Received event code callback: " + url);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.handleEventQR$lambda$0(this.f$0, url);
            }
        }, 1000L);
    }

    static final void handleEventQR$lambda$0(MainActivity mainActivity, String str) {
        Fragment fragmentFindFragmentByTag = mainActivity.getSupportFragmentManager().findFragmentByTag("home");
        HomeFragment homeFragment = fragmentFindFragmentByTag instanceof HomeFragment ? (HomeFragment) fragmentFindFragmentByTag : null;
        if (homeFragment != null) {
            homeFragment.handleQREventURL(str);
        }
    }

    private final void handleOAuthCallback(Uri uri) {
        Log.d("OAuth", "Received URI: " + uri);
        Log.d("OAuth", "Scheme: " + uri.getScheme());
        Log.d("OAuth", "Host: " + uri.getHost());
        Log.d("OAuth", "Path: " + uri.getPath());
        Log.d("OAuth", "Query params: " + uri.getQuery());
        final String queryParameter = uri.getQueryParameter("code");
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        String str = path;
        final String string = "discord";
        BottomNavigationView bottomNavigationView = null;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "discord", false, 2, (Object) null)) {
            string = "twitch";
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "twitch", false, 2, (Object) null)) {
                string = new PreferencesManager(this).getString("current_oauth_provider", "");
            }
        }
        if (queryParameter == null || string.length() <= 0) {
            String queryParameter2 = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            Log.e("OAuth", "Error: " + queryParameter2);
            Toast.makeText(this, "Authentication error: " + queryParameter2, 1).show();
            return;
        }
        if (this.currentSelectedTab != R.id.navigation_home) {
            BottomNavigationView bottomNavigationView2 = this.navView;
            if (bottomNavigationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navView");
                bottomNavigationView2 = null;
            }
            bottomNavigationView2.setSelectedItemId(R.id.navigation_home);
        }
        BottomNavigationView bottomNavigationView3 = this.navView;
        if (bottomNavigationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
        } else {
            bottomNavigationView = bottomNavigationView3;
        }
        bottomNavigationView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.handleOAuthCallback$lambda$0(this.f$0, queryParameter, string);
            }
        });
        new PreferencesManager(this).setString("current_oauth_provider", "");
    }

    static final void handleOAuthCallback$lambda$0(MainActivity mainActivity, String str, String str2) {
        FragmentManager childFragmentManager;
        Fragment fragmentFindFragmentByTag = mainActivity.getSupportFragmentManager().findFragmentByTag("home");
        HomeFragment homeFragment = fragmentFindFragmentByTag instanceof HomeFragment ? (HomeFragment) fragmentFindFragmentByTag : null;
        Fragment fragmentFindFragmentByTag2 = (homeFragment == null || (childFragmentManager = homeFragment.getChildFragmentManager()) == null) ? null : childFragmentManager.findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag2 instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag2 : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.onOAuthCodeReceived(str, str2);
            return;
        }
        MainActivity mainActivity2 = mainActivity;
        PreferencesManager preferencesManager = new PreferencesManager(mainActivity2);
        preferencesManager.setString("pending_oauth_code", str);
        preferencesManager.setString("pending_oauth_provider", str2);
        Toast.makeText(mainActivity2, "Authentication successful! Please return to sign in.", 1).show();
    }

    private final boolean handleSignUpCallbackIfNeeded() {
        Uri data;
        Intent intent = getIntent();
        if (intent == null || (data = intent.getData()) == null || !DeepLinkRouter.INSTANCE.isAuthCallback(data)) {
            return false;
        }
        Log.d(TAG, "Received authentication callback: " + data);
        if (isInSignupFlow()) {
            Log.d(TAG, "Forwarding auth callback to SignUpActivity");
            Intent intent2 = new Intent(this, (Class<?>) SignUpActivity.class);
            intent2.setData(data);
            intent2.setAction("android.intent.action.VIEW");
            intent2.addFlags(603979776);
            startActivity(intent2);
            return true;
        }
        return false;
    }

    private final void handleUserDeckLink(int userId, int deckId) {
        MainActivity mainActivity = this;
        MTUser currentUser = new PreferencesManager(mainActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(mainActivity, getString(R.string.deep_link_login_required), 0).show();
            return;
        }
        Intent intent = new Intent(mainActivity, (Class<?>) DeckDetailsActivity.class);
        intent.putExtra("deckId", deckId);
        if (userId != currentUser.getId()) {
            intent.putExtra("otherUserId", userId);
        }
        startActivity(intent);
    }

    private final void handleUserListLink(int userId, int listId) {
        MainActivity mainActivity = this;
        MTUser currentUser = new PreferencesManager(mainActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(mainActivity, getString(R.string.deep_link_login_required), 0).show();
        } else {
            GenericFragmentActivityKt.launchBrowseListFragment$default(mainActivity, listId, null, userId != currentUser.getId() ? Integer.valueOf(userId) : null, 4, null);
        }
    }

    private final void handleUserProfileLink(int userId) {
        MainActivity mainActivity = this;
        final MTUser currentUser = new PreferencesManager(mainActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(mainActivity, getString(R.string.deep_link_login_required), 0).show();
        } else {
            MTApiKt.getMtApi().getUserById(currentUser.getId(), userId).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.MainActivity.handleUserProfileLink.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTUserResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e(MainActivity.TAG, "Failed to fetch user profile for deep link", t);
                    MainActivity mainActivity2 = MainActivity.this;
                    Toast.makeText(mainActivity2, mainActivity2.getString(R.string.deep_link_error), 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    MTUserResponse mTUserResponseBody = response.body();
                    MTUser user = mTUserResponseBody != null ? mTUserResponseBody.getUser() : null;
                    if (user == null) {
                        MainActivity mainActivity2 = MainActivity.this;
                        Toast.makeText(mainActivity2, mainActivity2.getString(R.string.deep_link_user_not_found), 0).show();
                        return;
                    }
                    boolean z = user.getId() == currentUser.getId();
                    Fragment fragmentFindFragmentByTag = MainActivity.this.getSupportFragmentManager().findFragmentByTag("home");
                    ProfileCallback profileCallback = fragmentFindFragmentByTag instanceof HomeFragment ? (HomeFragment) fragmentFindFragmentByTag : null;
                    if (profileCallback == null) {
                        profileCallback = new ProfileCallback() { // from class: com.studiolaganne.lengendarylens.MainActivity$handleUserProfileLink$1$onResponse$callback$1
                            @Override // com.studiolaganne.lengendarylens.ProfileCallback
                            public void onProfileClose() {
                            }

                            @Override // com.studiolaganne.lengendarylens.ProfileCallback
                            public void onProfileLogout() {
                            }

                            @Override // com.studiolaganne.lengendarylens.ProfileCallback
                            public void onProfilePictureUpdated() {
                            }
                        };
                    }
                    ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, profileCallback, user, Boolean.valueOf(!z), null, 8, null).show(MainActivity.this.getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.firebase.analytics.ParametersBuilder] */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.google.firebase.analytics.ParametersBuilder] */
    private final boolean initOpenCV() {
        boolean zHasNext;
        ?? r1 = "unknown";
        ?? r2 = TAG;
        ?? r3 = 100;
        r3 = 100;
        ?? r32 = 100;
        boolean z = false;
        try {
            try {
                String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, Build.MANUFACTURER), TuplesKt.to(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL), TuplesKt.to(AndroidContextPlugin.DEVICE_KEY, Build.DEVICE), TuplesKt.to("android_version", Build.VERSION.RELEASE), TuplesKt.to("api_level", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to("supported_abis", ArraysKt.joinToString$default(SUPPORTED_ABIS, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
                Log.d(TAG, "Initializing OpenCV via initLocal()...");
                if (OpenCVLoader.initLocal()) {
                    Log.d(TAG, "OpenCV initLocal() succeeded");
                    try {
                        new Mat().release();
                        Log.d(TAG, "OpenCV JNI test passed");
                        CombinedAnalyzer.INSTANCE.setOpenCVAvailable(true);
                        z = true;
                        r1 = r1;
                        r2 = r2;
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "OpenCV JNI test failed after initLocal()", e);
                        CombinedAnalyzer.INSTANCE.setOpenCVAvailable(false);
                        FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                        ?? parametersBuilder = new ParametersBuilder();
                        String message = e.getMessage();
                        ?? r12 = r1;
                        if (message != null) {
                            String strTake = StringsKt.take(message, 100);
                            r12 = strTake == null ? r1 : strTake;
                        }
                        parametersBuilder.param("error", r12);
                        parametersBuilder.param("load_method", "initLocal");
                        Iterator it = mapMapOf.entrySet().iterator();
                        while (true) {
                            zHasNext = it.hasNext();
                            if (!zHasNext) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            Intrinsics.checkNotNull(str2);
                            parametersBuilder.param(str, str2);
                            r32 = str;
                        }
                        analytics.logEvent("opencv_jni_test_failed", parametersBuilder.getZza());
                        r1 = zHasNext;
                        r2 = analytics;
                        r3 = r32;
                    }
                } else {
                    Log.e(TAG, "OpenCV initLocal() returned false");
                    CombinedAnalyzer.INSTANCE.setOpenCVAvailable(false);
                    FirebaseAnalytics analytics2 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                    String str3 = "opencv_load_failed";
                    ParametersBuilder parametersBuilder2 = new ParametersBuilder();
                    parametersBuilder2.param("load_method", "initLocal_false");
                    Iterator it2 = mapMapOf.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        String str4 = (String) entry2.getKey();
                        String str5 = (String) entry2.getValue();
                        Intrinsics.checkNotNull(str5);
                        parametersBuilder2.param(str4, str5);
                    }
                    Bundle zza = parametersBuilder2.getZza();
                    analytics2.logEvent("opencv_load_failed", zza);
                    r1 = str3;
                    r2 = zza;
                    r3 = it2;
                }
            } catch (Exception e2) {
                Log.e(r2, "Unexpected error during OpenCV initialization", e2);
                CombinedAnalyzer.INSTANCE.setOpenCVAvailable(z);
                FirebaseAnalytics analytics3 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                ?? parametersBuilder3 = new ParametersBuilder();
                String simpleName = e2.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                parametersBuilder3.param(NativeProtocol.BRIDGE_ARG_ERROR_TYPE, simpleName);
                String message2 = e2.getMessage();
                ?? r13 = r1;
                if (message2 != null) {
                    String strTake2 = StringsKt.take(message2, (int) r3);
                    r13 = strTake2 == null ? r1 : strTake2;
                }
                parametersBuilder3.param("error_message", r13);
                analytics3.logEvent("opencv_init_unexpected_error", parametersBuilder3.getZza());
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        } catch (Exception unused) {
        }
        return z;
    }

    private final boolean isInSignupFlow() {
        return new PreferencesManager(this).getBoolean(PreferencesManager.SIGN_UP_ACTIVE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAllDownloadsComplete(List<? extends UpdatableMTGHelper> helpers) {
        ((ConstraintLayout) findViewById(R.id.downloading_layout)).setVisibility(8);
        List<? extends UpdatableMTGHelper> list = helpers;
        boolean z = list instanceof Collection;
        if (!z || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((UpdatableMTGHelper) it.next()).getDbType(), "sets")) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(null), 3, null);
                    break;
                }
            }
        }
        if (z && list.isEmpty()) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(((UpdatableMTGHelper) it2.next()).getDbType(), "glossary")) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass4(null), 3, null);
                return;
            }
        }
    }

    static final void onBatteryCharging$lambda$0(PreferencesManager preferencesManager, MainActivity mainActivity) {
        preferencesManager.setBatterySavingMode(false);
        mainActivity.disableBatterySavingChanges();
        Toast.makeText(mainActivity, mainActivity.getString(R.string.battery_charging), 1).show();
    }

    static final boolean onCreate$lambda$3(View view, MotionEvent motionEvent) {
        return motionEvent.getY() > ((float) Resources.getSystem().getDisplayMetrics().heightPixels) * 0.1f;
    }

    static final boolean onNavigationItemSelectedListener$lambda$0(final MainActivity mainActivity, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FragmentTransaction fragmentTransactionBeginTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        GameFragment gameFragment = mainActivity.gameFragment;
        if (gameFragment != null) {
            fragmentTransactionBeginTransaction.hide(gameFragment);
        }
        ScanFragment scanFragment = mainActivity.scanFragment;
        if (scanFragment != null) {
            fragmentTransactionBeginTransaction.hide(scanFragment);
        }
        CollectionFragment collectionFragment = mainActivity.collectionFragment;
        if (collectionFragment != null) {
            fragmentTransactionBeginTransaction.hide(collectionFragment);
        }
        HomeFragment homeFragment = mainActivity.homeFragment;
        if (homeFragment != null) {
            fragmentTransactionBeginTransaction.hide(homeFragment);
        }
        SearchFragment searchFragment = mainActivity.searchFragment;
        if (searchFragment != null) {
            fragmentTransactionBeginTransaction.hide(searchFragment);
        }
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_game) {
            GameFragment gameFragment2 = mainActivity.gameFragment;
            if (gameFragment2 == null) {
                mainActivity.gameFragment = new GameFragment();
                int i = R.id.fragment_container;
                GameFragment gameFragment3 = mainActivity.gameFragment;
                Intrinsics.checkNotNull(gameFragment3);
                fragmentTransactionBeginTransaction.add(i, gameFragment3, "game");
            } else {
                Intrinsics.checkNotNull(gameFragment2);
                fragmentTransactionBeginTransaction.show(gameFragment2);
            }
            final GameFragment gameFragment4 = mainActivity.gameFragment;
            if (gameFragment4 != null && mainActivity.newGamePlaygroupId != -1) {
                BottomNavigationView bottomNavigationView = mainActivity.navView;
                if (bottomNavigationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navView");
                    bottomNavigationView = null;
                }
                bottomNavigationView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.onNavigationItemSelectedListener$lambda$0$5$0(gameFragment4, mainActivity);
                    }
                });
            }
        } else if (itemId == R.id.navigation_scan) {
            mainActivity.ensureNavigationBarsVisible();
            ScanFragment scanFragment2 = mainActivity.scanFragment;
            if (scanFragment2 == null) {
                mainActivity.scanFragment = ScanFragment.INSTANCE.newInstance(false, true);
                int i2 = R.id.fragment_container;
                ScanFragment scanFragment3 = mainActivity.scanFragment;
                Intrinsics.checkNotNull(scanFragment3);
                fragmentTransactionBeginTransaction.add(i2, scanFragment3, "scan");
            } else {
                Intrinsics.checkNotNull(scanFragment2);
                fragmentTransactionBeginTransaction.show(scanFragment2);
            }
        } else if (itemId == R.id.navigation_collection) {
            mainActivity.ensureNavigationBarsVisible();
            CollectionFragment collectionFragment2 = mainActivity.collectionFragment;
            if (collectionFragment2 == null) {
                mainActivity.collectionFragment = new CollectionFragment();
                int i3 = R.id.fragment_container;
                CollectionFragment collectionFragment3 = mainActivity.collectionFragment;
                Intrinsics.checkNotNull(collectionFragment3);
                fragmentTransactionBeginTransaction.add(i3, collectionFragment3, "events");
            } else {
                Intrinsics.checkNotNull(collectionFragment2);
                fragmentTransactionBeginTransaction.show(collectionFragment2);
            }
        } else if (itemId == R.id.navigation_home) {
            mainActivity.ensureNavigationBarsVisible();
            HomeFragment homeFragment2 = mainActivity.homeFragment;
            if (homeFragment2 == null) {
                mainActivity.homeFragment = new HomeFragment();
                int i4 = R.id.fragment_container;
                HomeFragment homeFragment3 = mainActivity.homeFragment;
                Intrinsics.checkNotNull(homeFragment3);
                fragmentTransactionBeginTransaction.add(i4, homeFragment3, "home");
            } else {
                Intrinsics.checkNotNull(homeFragment2);
                fragmentTransactionBeginTransaction.show(homeFragment2);
            }
        } else if (itemId == R.id.navigation_search) {
            mainActivity.ensureNavigationBarsVisible();
            SearchFragment searchFragment2 = mainActivity.searchFragment;
            if (searchFragment2 == null) {
                mainActivity.searchFragment = new SearchFragment();
                int i5 = R.id.fragment_container;
                SearchFragment searchFragment3 = mainActivity.searchFragment;
                Intrinsics.checkNotNull(searchFragment3);
                fragmentTransactionBeginTransaction.add(i5, searchFragment3, FirebaseAnalytics.Event.SEARCH);
            } else {
                Intrinsics.checkNotNull(searchFragment2);
                fragmentTransactionBeginTransaction.show(searchFragment2);
            }
        }
        mainActivity.currentSelectedTab = item.getItemId();
        fragmentTransactionBeginTransaction.commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNavigationItemSelectedListener$lambda$0$5$0(GameFragment gameFragment, MainActivity mainActivity) {
        gameFragment.setupNewGameFromPlaygroup(mainActivity.newGamePlaygroupId);
        mainActivity.newGamePlaygroupId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void promptForBatterySaving(int level) {
        if (isFinishing() || isDestroyed() || this.instanceStateSaved) {
            return;
        }
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        if (preferencesManager.getBoolean(PreferencesManager.ENABLE_BATTERY_SAVING_PROMPTS, true) && System.currentTimeMillis() - this.lastBatterPromptNoAnswerTime >= 1800000) {
            String string = getString(R.string.battery_saving_body_50);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (level <= 25) {
                string = getString(R.string.battery_saving_body_25);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            if (level <= 10) {
                string = getString(R.string.battery_saving_body_10);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            if (preferencesManager.getCurrentGame() != null && this.currentSelectedTab == R.id.navigation_game && getSupportFragmentManager().findFragmentByTag("CustomBatteryDialogFragment") == null) {
                if (level <= 10) {
                    this.promptedForBattery10 = true;
                } else if (level <= 25) {
                    this.promptedForBattery25 = true;
                }
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string2 = getString(R.string.battery_saving_title);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(string);
                String string3 = getString(R.string.battery_saving_yes);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButtonRed = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainActivity.promptForBatterySaving$lambda$0(preferencesManager, this, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                }).setPositiveButtonRed();
                String string4 = getString(R.string.battery_saving_no);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomDialogFragment.Builder negativeButton = positiveButtonRed.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivity.promptForBatterySaving$lambda$1(this.f$0, (CustomDialogFragment) obj);
                    }
                });
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                negativeButton.show(supportFragmentManager, "CustomBatteryDialogFragment");
            }
        }
    }

    static final Unit promptForBatterySaving$lambda$0(PreferencesManager preferencesManager, MainActivity mainActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        preferencesManager.setBatterySavingMode(true);
        mainActivity.enableBatterySavingChanges();
        Toast.makeText(mainActivity, mainActivity.getString(R.string.reducing_effect), 1).show();
        return Unit.INSTANCE;
    }

    static final Unit promptForBatterySaving$lambda$1(MainActivity mainActivity, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        mainActivity.lastBatterPromptNoAnswerTime = System.currentTimeMillis();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupAuthStateMonitoring(final PreferencesManager prefs) {
        this.authStateListener = new FirebaseAuth.AuthStateListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda10
            @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
            public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                MainActivity.setupAuthStateMonitoring$lambda$0(prefs, this, firebaseAuth);
            }
        };
        if (prefs.hasValidUser()) {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseAuth.AuthStateListener authStateListener = this.authStateListener;
            Intrinsics.checkNotNull(authStateListener);
            firebaseAuth.addAuthStateListener(authStateListener);
        }
        this.authErrorReceiver = new C12152();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        BroadcastReceiver broadcastReceiver = this.authErrorReceiver;
        Intrinsics.checkNotNull(broadcastReceiver);
        localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter(AuthErrorHandler.ACTION_AUTH_ERROR));
    }

    static final void setupAuthStateMonitoring$lambda$0(PreferencesManager preferencesManager, final MainActivity mainActivity, FirebaseAuth auth) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        FirebaseUser currentUser = auth.getCurrentUser();
        if (preferencesManager.hasValidUser() && currentUser == null) {
            Log.w(TAG, "Auth state mismatch detected: App has user but Firebase currentUser is null");
            mainActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.setupAuthStateMonitoring$lambda$0$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAuthStateMonitoring$lambda$0$0(MainActivity mainActivity) {
        if (mainActivity.isFinishing() || mainActivity.isDestroyed()) {
            return;
        }
        mainActivity.showSessionExpiredDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSessionExpiredDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        AuthErrorHandler.INSTANCE.showSessionExpiredDialog(this, supportFragmentManager, new Function0() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.showSessionExpiredDialog$lambda$0(this.f$0);
            }
        });
    }

    static final Unit showSessionExpiredDialog$lambda$0(MainActivity mainActivity) {
        mainActivity.handleAuthFailureSignOut();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startupChecks() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        checkUnSyncedGames();
        checkUnSyncedSets();
        checkDatabaseUpdates();
        BillingClient billingClientBuild = BillingClient.newBuilder(this).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClientBuild = null;
        }
        billingClientBuild.startConnection(new C12161());
    }

    private final void stopAlarmIfTimerExpired() {
        MainActivity mainActivity = this;
        Tournament currentTournament = new PreferencesManager(mainActivity).getCurrentTournament();
        if (currentTournament != null && currentTournament.getCurrentTimeLeft() == 0 && currentTournament.getCurrentTimerActive()) {
            Intent intent = new Intent(mainActivity, (Class<?>) TimerService.class);
            intent.setAction(TimerService.ACTION_STOP_ALARM);
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object syncGame(final GameState gameState, int i, int i2, Continuation<? super Unit> continuation) throws Throwable {
        MTUser currentUser;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        if (isDestroyed() || isFinishing()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        } else {
            MainActivity mainActivity = this;
            final PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
            if (preferencesManager.hasValidUser() && (currentUser = preferencesManager.getCurrentUser()) != null) {
                MTCreateGame mTCreateGameCreateMTGameForUpload = GameUtils.INSTANCE.getInstance().createMTGameForUpload(gameState, currentUser.getId());
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainActivity);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("save_game_delayed", null);
                MTApiKt.getMtApi().createGame(currentUser.getId(), mTCreateGameCreateMTGameForUpload).enqueue(new Callback<MTCreateGameResponse>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncGame$2$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCreateGameResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Continuation<Unit> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCreateGameResponse> call, Response<MTCreateGameResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            List mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedGames());
                            final GameState gameState2 = gameState;
                            CollectionsKt.removeAll(mutableList, (Function1) new Function1<GameState, Boolean>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncGame$2$1$1$onResponse$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(GameState it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return Boolean.valueOf(it.getPlaygroupId() == gameState2.getPlaygroupId() && Intrinsics.areEqual(it.getEndedAt(), gameState2.getEndedAt()));
                                }
                            });
                            preferencesManager.saveUnSyncedGames(CollectionsKt.toList(mutableList));
                        } else if (response.code() >= 500) {
                            List mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedGames());
                            final GameState gameState3 = gameState;
                            CollectionsKt.removeAll(mutableList2, (Function1) new Function1<GameState, Boolean>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncGame$2$1$1$onResponse$2
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(GameState it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return Boolean.valueOf(it.getPlaygroupId() == gameState3.getPlaygroupId() && Intrinsics.areEqual(it.getEndedAt(), gameState3.getEndedAt()));
                                }
                            });
                            preferencesManager.saveUnSyncedGames(CollectionsKt.toList(mutableList2));
                        }
                        Continuation<Unit> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
                    }
                });
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncGamesSequentially(List<GameState> games) {
        BuildersKt__Builders_commonKt.launch$default(this.syncScope, null, null, new C12171(games, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object syncSet(final GameSet gameSet, int i, int i2, Continuation<? super Unit> continuation) throws Throwable {
        MTUser currentUser;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        if (isDestroyed() || isFinishing()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        } else {
            MainActivity mainActivity = this;
            final PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
            if (preferencesManager.hasValidUser() && (currentUser = preferencesManager.getCurrentUser()) != null) {
                MTCreateSet mTCreateSet = new MTCreateSet(0, null, 3, null);
                mTCreateSet.setBestof(gameSet.getBestOf());
                Iterator<GameState> it = gameSet.getFinishedGames().iterator();
                while (it.hasNext()) {
                    mTCreateSet.getGames().add(GameUtils.INSTANCE.getInstance().createMTGameForUpload(it.next(), currentUser.getId()));
                }
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainActivity);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("save_set_delayed", null);
                MTApiKt.getMtApi().createSet(currentUser.getId(), mTCreateSet).enqueue(new Callback<MTCreateSetResponse>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncSet$2$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCreateSetResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Continuation<Unit> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCreateSetResponse> call, Response<MTCreateSetResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            if (!gameSet.getFinishedGames().isEmpty()) {
                                List mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedSets());
                                final GameSet gameSet2 = gameSet;
                                CollectionsKt.removeAll(mutableList, (Function1) new Function1<GameSet, Boolean>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncSet$2$1$1$onResponse$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(GameSet it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        return Boolean.valueOf(!it2.getFinishedGames().isEmpty() && ((GameState) CollectionsKt.first((List) it2.getFinishedGames())).getPlaygroupId() == ((GameState) CollectionsKt.first((List) gameSet2.getFinishedGames())).getPlaygroupId() && Intrinsics.areEqual(((GameState) CollectionsKt.first((List) it2.getFinishedGames())).getEndedAt(), ((GameState) CollectionsKt.first((List) gameSet2.getFinishedGames())).getEndedAt()));
                                    }
                                });
                                preferencesManager.saveUnSyncedSets(CollectionsKt.toList(mutableList));
                            }
                        } else if (response.code() >= 500 && !gameSet.getFinishedGames().isEmpty()) {
                            List mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedSets());
                            final GameSet gameSet3 = gameSet;
                            CollectionsKt.removeAll(mutableList2, (Function1) new Function1<GameSet, Boolean>() { // from class: com.studiolaganne.lengendarylens.MainActivity$syncSet$2$1$1$onResponse$2
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(GameSet it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    return Boolean.valueOf(!it2.getFinishedGames().isEmpty() && ((GameState) CollectionsKt.first((List) it2.getFinishedGames())).getPlaygroupId() == ((GameState) CollectionsKt.first((List) gameSet3.getFinishedGames())).getPlaygroupId() && Intrinsics.areEqual(((GameState) CollectionsKt.first((List) it2.getFinishedGames())).getEndedAt(), ((GameState) CollectionsKt.first((List) gameSet3.getFinishedGames())).getEndedAt()));
                                }
                            });
                            preferencesManager.saveUnSyncedSets(CollectionsKt.toList(mutableList2));
                        }
                        Continuation<Unit> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
                    }
                });
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncSetsSequentially(List<GameSet> sets) {
        BuildersKt__Builders_commonKt.launch$default(this.syncScope, null, null, new C12181(sets, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGlobalProgress(int progress) {
        ((ProgressBar) findViewById(R.id.progressBar)).setProgress(progress);
    }

    public final void checkForLowBattery() {
        if (isFinishing() || isDestroyed() || this.isPlugged || new PreferencesManager(this).isBatterySavingMode()) {
            return;
        }
        Intent intentRegisterReceiver = registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        final int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0 || (intExtra / intExtra2) * 100.0f > 25.0f) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.promptForBatterySaving(intExtra);
            }
        });
    }

    public final void disableBatterySavings() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MainActivity mainActivity = this;
        new PreferencesManager(mainActivity).setBatterySavingMode(false);
        disableBatterySavingChanges();
        Toast.makeText(mainActivity, getString(R.string.battery_savings_disabled), 1).show();
    }

    public final void enableBatterySavings() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MainActivity mainActivity = this;
        new PreferencesManager(mainActivity).setBatterySavingMode(true);
        enableBatterySavingChanges();
        Toast.makeText(mainActivity, getString(R.string.battery_savings_enabled), 1).show();
    }

    public final void ensureNavigationBarsVisible() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        View viewFindViewById = findViewById(R.id.bottom_spacer);
        bottomNavigationView.setVisibility(0);
        viewFindViewById.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.systemBars());
            }
            getWindow().setStatusBarColor(0);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
            getWindow().setStatusBarColor(0);
        }
        updateSharedCollectionBadge();
    }

    public final void goToSearch() {
        BottomNavigationView bottomNavigationView = this.navView;
        if (bottomNavigationView == null) {
            return;
        }
        if (bottomNavigationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
            bottomNavigationView = null;
        }
        bottomNavigationView.setSelectedItemId(R.id.navigation_search);
    }

    @Override // com.studiolaganne.lengendarylens.ChargingStateReceiver.ChargingStateCallback
    public void onBatteryCharging() {
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        this.isPlugged = true;
        if (preferencesManager.isBatterySavingMode()) {
            runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.onBatteryCharging$lambda$0(preferencesManager, this);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.BatteryMonitor.BatteryLevelListener
    public void onBatteryLevelChanged(int level) {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        if (this.isPlugged || preferencesManager.isBatterySavingMode()) {
            return;
        }
        if (level <= 10 && !this.promptedForBattery10) {
            runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.promptForBatterySaving(10);
                }
            });
        } else {
            if (level > 25 || this.promptedForBattery25) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.promptForBatterySaving(25);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.ChargingStateReceiver.ChargingStateCallback
    public void onBatteryNotCharging() {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        this.isPlugged = false;
        if (preferencesManager.isBatterySavingMode()) {
            return;
        }
        Intent intentRegisterReceiver = registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        final int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0 || (intExtra / intExtra2) * 100.0f > 25.0f) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.promptForBatterySaving(intExtra);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle savedInstanceState) {
        String string;
        Uri data;
        super.onCreate(savedInstanceState);
        if (handleSignUpCallbackIfNeeded()) {
            finish();
            return;
        }
        Log.d("MainActivity", "onCreate called");
        MainActivity mainActivity = this;
        EmbeddingsLoader.INSTANCE.startBackgroundLoading(mainActivity);
        PreferencesManager preferencesManager = new PreferencesManager(mainActivity);
        boolean z = preferencesManager.getBoolean(PreferencesManager.ONBOARDING_DONE, false);
        boolean zHasValidUser = preferencesManager.hasValidUser();
        if (!z && !zHasValidUser) {
            preferencesManager.setBoolean(PreferencesManager.ONBOARDING_DONE, true);
            startActivity(new Intent(mainActivity, (Class<?>) OnboardingActivity.class));
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (data = intent.getData()) != null) {
            handleDeepLink(data);
        }
        preferencesManager.setBoolean(PreferencesManager.SIGN_UP_ACTIVE, false);
        FirebaseApp.initializeApp(mainActivity);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Intrinsics.checkNotNull(defaultUncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(defaultUncaughtExceptionHandler));
        if (preferencesManager.getAllThemeTokens().containsValue("restored_from_account")) {
            preferencesManager.clearAllThemeTokens();
            preferencesManager.clearAllThemesPurchased();
            preferencesManager.setString(PreferencesManager.CREATOR_CODE, "default");
        }
        preferencesManager.getPreferredCurrency();
        if (preferencesManager.isFirstRun()) {
            fetchInstallReferrerAndLog(mainActivity);
            preferencesManager.setFirstRun(false);
        } else {
            preferencesManager.setSecondRun(true);
        }
        if (preferencesManager.isFirstRunV2()) {
            Iterator<String> it = preferencesManager.getSupportedLanguages().iterator();
            while (it.hasNext()) {
                preferencesManager.setLanguageEnabled(it.next(), true);
            }
            preferencesManager.setFirstRunV2(false);
        }
        this.chargingReceiver = new ChargingStateReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ChargingStateReceiver chargingStateReceiver = this.chargingReceiver;
        BottomNavigationView bottomNavigationView = null;
        if (chargingStateReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chargingReceiver");
            chargingStateReceiver = null;
        }
        registerReceiver(chargingStateReceiver, intentFilter);
        BatteryMonitor batteryMonitor = new BatteryMonitor(mainActivity, this);
        this.batteryMonitor = batteryMonitor;
        batteryMonitor.startMonitoring();
        ChargingStateReceiver chargingStateReceiver2 = this.chargingReceiver;
        if (chargingStateReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chargingReceiver");
            chargingStateReceiver2 = null;
        }
        this.isPlugged = chargingStateReceiver2.isDeviceCharging(mainActivity);
        checkAndResetBatterySavingMode();
        setupAuthStateMonitoring(preferencesManager);
        initOpenCV();
        setContentView(R.layout.activity_main);
        ensureNavigationBarsVisible();
        HomeFragment homeFragment = new HomeFragment();
        this.homeFragment = homeFragment;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(R.id.fragment_container, homeFragment, "home");
        fragmentTransactionBeginTransaction.commit();
        View viewFindViewById = findViewById(R.id.bottom_navigation);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) viewFindViewById;
        this.navView = bottomNavigationView2;
        if (bottomNavigationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
            bottomNavigationView2 = null;
        }
        bottomNavigationView2.setOnNavigationItemSelectedListener(this.onNavigationItemSelectedListener);
        BottomNavigationView bottomNavigationView3 = this.navView;
        if (bottomNavigationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
            bottomNavigationView3 = null;
        }
        bottomNavigationView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MainActivity.onCreate$lambda$3(view, motionEvent);
            }
        });
        BottomNavigationView bottomNavigationView4 = this.navView;
        if (bottomNavigationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
            bottomNavigationView4 = null;
        }
        bottomNavigationView4.setSelectedItemId(R.id.navigation_home);
        this.currentSelectedTab = R.id.navigation_home;
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.MainActivity.onCreate.4
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                int i = MainActivity.this.currentSelectedTab;
                int i2 = R.id.navigation_scan;
                MainActivity mainActivity2 = MainActivity.this;
                if (i == i2) {
                    mainActivity2.finish();
                    return;
                }
                Fragment fragmentFindFragmentById = mainActivity2.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (fragmentFindFragmentById == null || fragmentFindFragmentById.getChildFragmentManager().getBackStackEntryCount() <= 0) {
                    MainActivity.this.finish();
                } else {
                    fragmentFindFragmentById.getChildFragmentManager().popBackStack();
                }
            }
        });
        BottomNavigationView bottomNavigationView5 = this.navView;
        if (bottomNavigationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
        } else {
            bottomNavigationView = bottomNavigationView5;
        }
        bottomNavigationView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.MainActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startupChecks();
            }
        }, 1000L);
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString("type")) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : extras.keySet()) {
            linkedHashMap.put(str, extras.get(str));
        }
        String json = new Gson().toJson(linkedHashMap);
        if (Intrinsics.areEqual(string, PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
            preferencesManager.setBoolean(PreferencesManager.UPDATE_MESSAGES, true);
        }
        switch (string.hashCode()) {
            case -1814490512:
                if (string.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_INVITE)) {
                    preferencesManager.setInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, preferencesManager.getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0) + 1);
                }
                break;
            case -1208568283:
                if (string.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_REJECTED)) {
                }
                break;
            case -517166289:
                if (string.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED)) {
                }
                break;
            case 610173073:
                if (string.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_INVITE)) {
                }
                break;
            case 1020862470:
                if (string.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_REJECTED)) {
                }
                break;
            case 1548370254:
                if (string.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_ACCEPTED)) {
                }
                break;
        }
        Intrinsics.checkNotNull(json);
        preferencesManager.setString(PreferencesManager.INTENT_TO_PROCESS, json);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChargingStateReceiver chargingStateReceiver = this.chargingReceiver;
        BatteryMonitor batteryMonitor = null;
        if (chargingStateReceiver != null) {
            if (chargingStateReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chargingReceiver");
                chargingStateReceiver = null;
            }
            unregisterReceiver(chargingStateReceiver);
        }
        BatteryMonitor batteryMonitor2 = this.batteryMonitor;
        if (batteryMonitor2 != null) {
            if (batteryMonitor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("batteryMonitor");
            } else {
                batteryMonitor = batteryMonitor2;
            }
            batteryMonitor.stopMonitoring();
        }
        FirebaseAuth.AuthStateListener authStateListener = this.authStateListener;
        if (authStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);
        }
        BroadcastReceiver broadcastReceiver = this.authErrorReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        EmbeddingsLoader.INSTANCE.cancelLoading();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("CustomDialogFragment");
        DialogFragment dialogFragment = fragmentFindFragmentByTag instanceof DialogFragment ? (DialogFragment) fragmentFindFragmentByTag : null;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (this.navView == null) {
            return;
        }
        Log.d("MainActivity", "onNewIntent called");
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.VIEW") && intent.getData() != null) {
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            handleDeepLink(data);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.newGamePlaygroupId = extras.getInt("newGamePlaygroupId");
            BottomNavigationView bottomNavigationView = this.navView;
            if (bottomNavigationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navView");
                bottomNavigationView = null;
            }
            bottomNavigationView.setSelectedItemId(R.id.navigation_game);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.instanceStateSaved = true;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        this.instanceStateSaved = false;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.instanceStateSaved = false;
        stopAlarmIfTimerExpired();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (bottomNavigationView != null && bottomNavigationView.getSelectedItemId() != R.id.navigation_game) {
            ensureNavigationBarsVisible();
        }
        updateSharedCollectionBadge();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        this.instanceStateSaved = true;
    }

    public final void resetBatteryPrompts() {
        this.promptedForBattery10 = false;
        this.promptedForBattery25 = false;
        new PreferencesManager(this).setBatterySavingMode(false);
        disableBatterySavingChanges();
    }

    public final void setFullscreenMode(boolean enabled) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        View viewFindViewById = findViewById(R.id.bottom_spacer);
        if (bottomNavigationView.getSelectedItemId() != R.id.navigation_game) {
            return;
        }
        if (enabled) {
            bottomNavigationView.setVisibility(8);
            viewFindViewById.setVisibility(0);
        } else {
            bottomNavigationView.setVisibility(0);
            viewFindViewById.setVisibility(4);
        }
    }

    public final void setStatusBarFullscreen(boolean enabled) {
        if (((BottomNavigationView) findViewById(R.id.bottom_navigation)).getSelectedItemId() != R.id.navigation_game) {
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            if (enabled) {
                getWindow().getDecorView().setSystemUiVisibility(4102);
                getWindow().setStatusBarColor(-16777216);
                return;
            } else {
                getWindow().getDecorView().setSystemUiVisibility(0);
                getWindow().setStatusBarColor(0);
                return;
            }
        }
        WindowInsetsController insetsController = getWindow().getInsetsController();
        if (!enabled) {
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.systemBars());
            }
            getWindow().setStatusBarColor(0);
        } else {
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.systemBars());
            }
            if (insetsController != null) {
                insetsController.setSystemBarsBehavior(2);
            }
            getWindow().setStatusBarColor(-16777216);
        }
    }

    public final void updateSharedCollectionBadge() {
        if (this.navView == null) {
            return;
        }
        MainActivity mainActivity = this;
        int i = new PreferencesManager(mainActivity).getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0);
        BottomNavigationView bottomNavigationView = this.navView;
        if (i <= 0) {
            if (bottomNavigationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navView");
                bottomNavigationView = null;
            }
            bottomNavigationView.removeBadge(R.id.navigation_collection);
            return;
        }
        if (bottomNavigationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navView");
            bottomNavigationView = null;
        }
        BadgeDrawable orCreateBadge = bottomNavigationView.getOrCreateBadge(R.id.navigation_collection);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.draw_orange));
        orCreateBadge.setVisible(true);
    }

    public final void userLoggedIn() {
        FirebaseAuth.AuthStateListener authStateListener = this.authStateListener;
        if (authStateListener != null) {
            FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
        }
        FirebaseTokenManager.INSTANCE.startTokenAutoRefresh(this);
        GameFragment gameFragment = this.gameFragment;
        if (gameFragment != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.remove(gameFragment);
            fragmentTransactionBeginTransaction.commit();
            this.gameFragment = null;
        }
    }

    public final void userLoggedOut() {
        FirebaseTokenManager.INSTANCE.stopTokenAutoRefresh();
        FirebaseAuth.AuthStateListener authStateListener = this.authStateListener;
        if (authStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);
        }
        GameFragment gameFragment = this.gameFragment;
        if (gameFragment != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.remove(gameFragment);
            fragmentTransactionBeginTransaction.commit();
            this.gameFragment = null;
        }
    }
}
