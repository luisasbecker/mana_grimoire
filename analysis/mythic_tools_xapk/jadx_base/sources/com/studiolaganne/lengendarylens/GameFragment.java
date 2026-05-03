package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.revenuecat.purchases.common.Constants;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.DiceDialogFragment;
import com.studiolaganne.lengendarylens.GameFragment;
import com.studiolaganne.lengendarylens.GameLayoutFragment;
import com.studiolaganne.lengendarylens.GameOptionsFragment;
import com.studiolaganne.lengendarylens.GamePlayersFragment;
import com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment;
import com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment;
import com.studiolaganne.lengendarylens.GameStartingLifeFragment;
import com.studiolaganne.lengendarylens.NewGameFragment;
import com.studiolaganne.lengendarylens.PlayerSelectFragment;
import com.studiolaganne.lengendarylens.StreamingConverter;
import com.studiolaganne.lengendarylens.StreamingManager;
import com.studiolaganne.lengendarylens.TimerHintFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentFullGameBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: GameFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 «\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0006©\u0001ª\u0001«\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u0002062\u0006\u0010D\u001a\u000206H\u0016J\u0016\u0010E\u001a\u00020<2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002060GH\u0016J\u0010\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020JH\u0016J\u001e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020J0GH\u0016J\u0010\u0010O\u001a\u00020<2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010P\u001a\u00020<2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010Q\u001a\u00020<2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010R\u001a\u00020<H\u0016J\b\u0010S\u001a\u00020<H\u0016J\b\u0010T\u001a\u00020<H\u0016J\b\u0010U\u001a\u00020<H\u0016J\u0010\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u000206H\u0016J\b\u0010[\u001a\u00020<H\u0016J\u0010\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u00020<H\u0016J\b\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020`H\u0002J\b\u0010b\u001a\u00020<H\u0016J\b\u0010c\u001a\u00020<H\u0016J\u0010\u0010d\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u000206H\u0016J\u0010\u0010j\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010k\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010l\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010m\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010n\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010o\u001a\u00020<2\u0006\u0010e\u001a\u000206H\u0016J\u0010\u0010p\u001a\u00020<2\u0006\u0010e\u001a\u000206H\u0016J\u0010\u0010q\u001a\u00020<2\u0006\u0010e\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020<H\u0002J\b\u0010t\u001a\u00020<H\u0016J\b\u0010u\u001a\u00020<H\u0017J\b\u0010v\u001a\u00020<H\u0002J$\u0010w\u001a\u00020<2\u0006\u0010x\u001a\u00020\u00152\b\b\u0002\u0010y\u001a\u00020\u00152\b\b\u0002\u0010z\u001a\u00020\u0015H\u0002J\b\u0010{\u001a\u00020<H\u0002J&\u0010|\u001a\u00020<2\b\b\u0002\u0010}\u001a\u00020\u00152\b\b\u0002\u0010~\u001a\u00020\u00152\b\b\u0002\u0010\u007f\u001a\u00020\u0015H\u0002J\t\u0010\u0080\u0001\u001a\u00020<H\u0002J\t\u0010\u0081\u0001\u001a\u00020<H\u0002J\t\u0010\u0082\u0001\u001a\u00020<H\u0016J\t\u0010\u0083\u0001\u001a\u00020<H\u0016J\t\u0010\u0084\u0001\u001a\u00020<H\u0016J\t\u0010\u0085\u0001\u001a\u00020<H\u0016J\t\u0010\u0086\u0001\u001a\u00020<H\u0016J\t\u0010\u0087\u0001\u001a\u00020<H\u0016J\t\u0010\u0088\u0001\u001a\u00020<H\u0002J\u0010\u0010\u0089\u0001\u001a\u00020<2\u0007\u0010\u008a\u0001\u001a\u000206J\t\u0010\u008b\u0001\u001a\u00020<H\u0002J\u0014\u0010\u008c\u0001\u001a\u00020<2\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u008e\u0001\u001a\u00020<H\u0002J\t\u0010\u008f\u0001\u001a\u00020<H\u0016J\t\u0010\u0090\u0001\u001a\u00020<H\u0016J\u0015\u0010\u0091\u0001\u001a\u00020<2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\t\u0010\u0094\u0001\u001a\u00020<H\u0016J.\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\t\u0010\u009b\u0001\u001a\u00020<H\u0016J\u001f\u0010\u009c\u0001\u001a\u00020<2\b\u0010\u009d\u0001\u001a\u00030\u0096\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J\u0012\u0010\u009e\u0001\u001a\u00020<2\u0007\u0010\u009f\u0001\u001a\u00020\u0015H\u0016J\t\u0010 \u0001\u001a\u00020<H\u0002J\t\u0010¡\u0001\u001a\u00020<H\u0002J\t\u0010¢\u0001\u001a\u00020<H\u0002J\t\u0010£\u0001\u001a\u00020<H\u0002J\u0007\u0010¤\u0001\u001a\u00020<J\u0007\u0010¥\u0001\u001a\u00020<J\u0013\u0010¦\u0001\u001a\u00020\u00152\b\u0010§\u0001\u001a\u00030¨\u0001H\u0017R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¬\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment$LifeSetupCallback;", "Lcom/studiolaganne/lengendarylens/GamePlayersFragment$PlayersSetupCallback;", "Lcom/studiolaganne/lengendarylens/GameLayoutFragment$LayoutSetupCallback;", "Lcom/studiolaganne/lengendarylens/GameOptionsFragment$OptionsSetupCallback;", "Lcom/studiolaganne/lengendarylens/NewGameFragment$NewGameCallback;", "Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment$PlaygroupUsersSetupCallback;", "Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment$PlaygroupFormatSetupCallback;", "Lcom/studiolaganne/lengendarylens/GameCallback;", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionStateListener;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "isViewDestroyed", "", "isTutorial", "isVisible", "gameFromPlaygroup", "getGameFromPlaygroup", "()Z", "setGameFromPlaygroup", "(Z)V", "gameSyncable", "getGameSyncable", "setGameSyncable", "fullscreen", "getFullscreen", "setFullscreen", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentFullGameBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentFullGameBinding;", "adapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "newGameFragment", "Lcom/studiolaganne/lengendarylens/NewGameFragment;", "currentGameFragment", "Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "tutorialButtonDisabled", "dragging", "downRawX", "", "downRawY", "moveThreshold", "", "streamingManager", "Lcom/studiolaganne/lengendarylens/StreamingManager;", "initialStreamingDone", "gamePlayerResultsMode", "onStreamingConnectionStateChanged", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionState;", "onStreamingError", "error", "", "formatSelected", "formatId", "subformatId", "playersSelectedFromPlaygroup", "userIds", "", "onGameClicked", "game", "Lcom/studiolaganne/lengendarylens/MTGame;", "onSetClicked", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "onDeleteGameClicked", "onUnpublishGameClicked", "onPublishGameClicked", "onLoadMoreGamesClicked", "onGameItemExpanded", "newQuickGame", "newGameFromScratch", "newGameFromFavorite", "setup", "Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "newGameFromPlaygroup", "id", "gameForceUpload", "showAnimatedGameLabel", "gameNumber", "nonSyncableGameFinished", "getSingleGameHolder", "Lcom/studiolaganne/lengendarylens/GameItemHolder;", "getSetGameHolder", "gameFinished", "tutorialComplete", "batterySavingModeChanged", "value", "turnTimersEnabledValueChanged", "timerEnabledValueChanged", "timerValueChanged", "minutes", "commanderDamageValueChanged", "poisonCountersValueChanged", "planechaseValueChanged", "archenemyValueChanged", "dayNightValueChanged", "startingLifeSelected", "playersSelected", "layoutSelected", "Lcom/studiolaganne/lengendarylens/LayoutType;", "showLeaderRevealDialog", "startGamePressed", "menuPressed", "saveCurrentQuickGame", "syncCurrentGame", "restart", "forceUpload", "playAgain", "onExitButtonPressed", "restartCurrentGame", "skipTimerAndToss", "restartMatch", "deckSelection", "deleteCurrentGame", "closeMenu", "initiativeCoinDragged", "theRingCoinDragged", "monarchCoinDragged", "cityCoinDragged", "gameEventsEdited", "diceTapped", "incrementNumGames", "setupNewGameFromPlaygroup", "playgroupId", "gameReady", "runPlayerToss", "gameStart", "hideSystemUI", "onResume", "onPause", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onHiddenChanged", "hidden", "fadeIn", "setupForTutorial", "startTutorial", "setupPlainNewGame", "enableBatterySaving", "disableBatterySaving", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "QuestionPagerAdapter", "LayoutPagerAdapter", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment extends Fragment implements GameStartingLifeFragment.LifeSetupCallback, GamePlayersFragment.PlayersSetupCallback, GameLayoutFragment.LayoutSetupCallback, GameOptionsFragment.OptionsSetupCallback, NewGameFragment.NewGameCallback, GamePlaygroupUsersFragment.PlaygroupUsersSetupCallback, GamePlaygroupFormatFragment.PlaygroupFormatSetupCallback, GameCallback, GamesClickListener, StreamingManager.ConnectionStateListener {
    private static final String TAG = "GameActivity";
    private FragmentFullGameBinding _binding;
    private FragmentStateAdapter adapter;
    private GameFragmentBase currentGameFragment;
    private float downRawX;
    private float downRawY;
    private boolean dragging;
    private boolean fullscreen;
    private boolean gameFromPlaygroup;
    private boolean gamePlayerResultsMode;
    private boolean gameSyncable;
    private boolean initialStreamingDone;
    private boolean isTutorial;
    private boolean isViewDestroyed;
    private NewGameFragment newGameFragment;
    private PreferencesManager prefs;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;
    private boolean tutorialButtonDisabled;
    public static final int $stable = 8;
    private boolean isVisible = true;
    private int moveThreshold = 50;
    private final StreamingManager streamingManager = StreamingManager.INSTANCE.getInstance();

    /* JADX INFO: compiled from: GameFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment$LayoutPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "<init>", "(Lcom/studiolaganne/lengendarylens/GameFragment;)V", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class LayoutPagerAdapter extends FragmentStateAdapter {
        public LayoutPagerAdapter() {
            super(GameFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return GameLayoutFragment.INSTANCE.newInstance();
            }
            throw new IllegalArgumentException("Invalid position " + position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: GameFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment$QuestionPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "<init>", "(Lcom/studiolaganne/lengendarylens/GameFragment;)V", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class QuestionPagerAdapter extends FragmentStateAdapter {
        public QuestionPagerAdapter() {
            super(GameFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (GameFragment.this.getGameFromPlaygroup()) {
                if (position == 0) {
                    return GamePlaygroupUsersFragment.INSTANCE.newInstance();
                }
                if (position == 1) {
                    return GamePlaygroupFormatFragment.INSTANCE.newInstance();
                }
                if (position == 2) {
                    return GameLayoutFragment.INSTANCE.newInstance();
                }
                throw new IllegalArgumentException("Invalid position " + position);
            }
            if (GameFragment.this.getGameSyncable()) {
                if (position == 0) {
                    return GamePlaygroupFormatFragment.INSTANCE.newInstance();
                }
                if (position == 1) {
                    return GamePlayersFragment.INSTANCE.newInstance();
                }
                if (position == 2) {
                    return GameLayoutFragment.INSTANCE.newInstance();
                }
                throw new IllegalArgumentException("Invalid position " + position);
            }
            if (position == 0) {
                return GamePlaygroupFormatFragment.INSTANCE.newInstance();
            }
            if (position == 1) {
                return GamePlayersFragment.INSTANCE.newInstance();
            }
            if (position == 2) {
                return GameLayoutFragment.INSTANCE.newInstance();
            }
            throw new IllegalArgumentException("Invalid position " + position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 3;
        }
    }

    /* JADX INFO: compiled from: GameFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutType.values().length];
            try {
                iArr[LayoutType.TYPE_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutType.TYPE_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameFragment$closeMenu$2, reason: invalid class name */
    /* JADX INFO: compiled from: GameFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/studiolaganne/lengendarylens/GameFragment$closeMenu$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationStart", "", "animation", "Landroid/view/animation/Animation;", "onAnimationEnd", "onAnimationRepeat", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass2 implements Animation.AnimationListener {
        final /* synthetic */ ConstraintLayout $menuOverlay;
        final /* synthetic */ GameFragment this$0;

        AnonymousClass2(ConstraintLayout constraintLayout, GameFragment gameFragment) {
            this.$menuOverlay = constraintLayout;
            this.this$0 = gameFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onAnimationEnd$lambda$0$0(TimerHintFragment it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.dismiss();
            return Unit.INSTANCE;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Context context;
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.$menuOverlay.setVisibility(4);
            if (!this.this$0.getSharedViewModel().getGameState().getTimerEnabled() || (context = this.this$0.getContext()) == null) {
                return;
            }
            GameFragment gameFragment = this.this$0;
            PreferencesManager preferencesManager = new PreferencesManager(context);
            boolean z = preferencesManager.getBoolean(PreferencesManager.ALWAYS_SHOW_TIMER, true);
            if (preferencesManager.getBoolean(PreferencesManager.TIMER_HINT_SHOWN, false) || z) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.TIMER_HINT_SHOWN, true);
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
            TimerHintFragment.Builder positiveButton = new TimerHintFragment.Builder().setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$closeMenu$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.AnonymousClass2.onAnimationEnd$lambda$0$0((TimerHintFragment) obj);
                }
            });
            FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "TimerHintFragment");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public GameFragment() {
        final GameFragment gameFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gameFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GameFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gameFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GameFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gameFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GameFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gameFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeMenu() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda51
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.closeMenu$lambda$0$0(this.f$0);
                }
            }, 1000L);
        }
        ConstraintLayout menuOverlay = getBinding().menuOverlay;
        Intrinsics.checkNotNullExpressionValue(menuOverlay, "menuOverlay");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_out);
        animationLoadAnimation.setDuration(200L);
        animationLoadAnimation.setAnimationListener(new AnonymousClass2(menuOverlay, this));
        menuOverlay.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeMenu$lambda$0$0(GameFragment gameFragment) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return;
        }
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.ENABLE_FULLSCREEN_MODE, true)) {
            FragmentActivity activity = gameFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if ((mainActivity != null && ((BottomNavigationView) mainActivity.findViewById(R.id.bottom_navigation)).getSelectedItemId() != R.id.navigation_game) || gameFragment.currentGameFragment == null || gameFragment.fullscreen) {
                return;
            }
            gameFragment.fullscreen = true;
            FragmentActivity activity2 = gameFragment.getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.setFullscreenMode(true);
            }
            FragmentActivity activity3 = gameFragment.getActivity();
            MainActivity mainActivity3 = activity3 instanceof MainActivity ? (MainActivity) activity3 : null;
            if (mainActivity3 != null) {
                mainActivity3.setStatusBarFullscreen(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteCurrentGame() {
        View view;
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        this.gamePlayerResultsMode = false;
        Breadcrumbs.INSTANCE.leaveBreadcrumb("erase_game");
        final FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("erase_game", null);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.clearCurrentGame();
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        preferencesManager2.clearGameSelectedDecks();
        setupPlainNewGame();
        GameUtils.INSTANCE.getInstance().setPlanarDeck(CollectionsKt.emptyList());
        PreferencesManager preferencesManager3 = this.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        preferencesManager3.clearCurrentSet();
        PreferencesManager preferencesManager4 = this.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager4 = null;
        }
        preferencesManager4.clearAllUsersDecks();
        GameUtils.INSTANCE.getInstance().getDecorsUsed().clear();
        GameUtils.INSTANCE.getInstance().getKosUsed().clear();
        PreferencesManager preferencesManager5 = this.prefs;
        if (preferencesManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager5 = null;
        }
        int i = preferencesManager5.getInt(PreferencesManager.NUM_GAMES, 0);
        PreferencesManager preferencesManager6 = this.prefs;
        if (preferencesManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager6 = null;
        }
        if (!preferencesManager6.getBoolean(PreferencesManager.GAME_RATING_PROMPT_SHOWN, false) && i >= 1 && (view = getView()) != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.deleteCurrentGame$lambda$0(this.f$0, firebaseAnalytics);
                }
            }, 1000L);
        }
        if (this.currentGameFragment != null) {
            this.fullscreen = false;
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.setFullscreenMode(false);
            }
            FragmentActivity activity2 = getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.setStatusBarFullscreen(false);
            }
            FragmentActivity activity3 = getActivity();
            MainActivity mainActivity3 = activity3 instanceof MainActivity ? (MainActivity) activity3 : null;
            if (mainActivity3 != null) {
                mainActivity3.resetBatteryPrompts();
            }
        }
        PreferencesManager preferencesManager7 = this.prefs;
        if (preferencesManager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager7 = null;
        }
        if (preferencesManager7.hasValidUser()) {
            GameFragmentBase gameFragmentBase = this.currentGameFragment;
            if (gameFragmentBase != null) {
                FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                fragmentTransactionBeginTransaction.remove(gameFragmentBase).commit();
            }
            this.currentGameFragment = null;
            NewGameFragment newGameFragmentNewInstance = NewGameFragment.INSTANCE.newInstance();
            this.newGameFragment = newGameFragmentNewInstance;
            if (newGameFragmentNewInstance != null) {
                FragmentTransaction fragmentTransactionBeginTransaction2 = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, newGameFragmentNewInstance);
                fragmentTransactionBeginTransaction2.commit();
            }
            getBinding().fragmentContainer.setVisibility(0);
            getBinding().toolbar.setVisibility(8);
            getBinding().viewPager.setVisibility(8);
            return;
        }
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setVisibility(0);
        getBinding().viewPager.setCurrentItem(0);
        FragmentActivity activity4 = getActivity();
        if (activity4 instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity4;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(0, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setTitle(getString(R.string.title_playgroup_format));
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setDisplayHomeAsUpEnabled(false);
            }
        }
        getBinding().viewPager.setVisibility(0);
        fragmentContainer.setVisibility(8);
        GameFragmentBase gameFragmentBase2 = this.currentGameFragment;
        if (gameFragmentBase2 != null) {
            FragmentTransaction fragmentTransactionBeginTransaction3 = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction3, "beginTransaction(...)");
            fragmentTransactionBeginTransaction3.remove(gameFragmentBase2).commit();
        }
        this.currentGameFragment = null;
    }

    static final void deleteCurrentGame$lambda$0(GameFragment gameFragment, FirebaseAnalytics firebaseAnalytics) {
        final FragmentActivity activity;
        Context context = gameFragment.getContext();
        if (context == null || (activity = gameFragment.getActivity()) == null) {
            return;
        }
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_RATING_PROMPT_SHOWN, true);
        firebaseAnalytics.logEvent("rating_prompt_delete_game", null);
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda23
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GameFragment.deleteCurrentGame$lambda$0$0$0$0(reviewManagerCreate, activity, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteCurrentGame$lambda$0$0$0$0(ReviewManager reviewManager, FragmentActivity fragmentActivity, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccessful()) {
            reviewManager.launchReviewFlow(fragmentActivity, (ReviewInfo) it.getResult());
        }
    }

    static final Unit diceTapped$lambda$0(GameFragment gameFragment) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("random_player_tossed");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("random_player_tossed", null);
        gameFragment.runPlayerToss(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fadeIn() {
        View view = getView();
        if (view != null) {
            getBinding().fadeInOverlay.setVisibility(0);
            getBinding().fadeInOverlay.setAlpha(1.0f);
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.fadeIn$lambda$0$0(this.f$0);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fadeIn$lambda$0$0(final GameFragment gameFragment) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gameFragment.getBinding().fadeInOverlay, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$fadeIn$1$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getBinding().fadeInOverlay.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gameFinished$lambda$0$5$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef) {
        gameFragmentBase.getLifeViews().get(intRef.element).triggerPlayerStartQ();
    }

    static final Unit gameFinished$lambda$10(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.saveCurrentQuickGame();
        gameFragment.deleteCurrentGame();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$11(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$5(GameFragment gameFragment, ConstraintLayout constraintLayout) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        syncCurrentGame$default(gameFragment, false, false, false, 6, null);
        constraintLayout.setVisibility(8);
        if (gameFragment.currentGameFragment != null) {
            gameFragment.fullscreen = false;
            FragmentActivity activity = gameFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.setFullscreenMode(false);
            }
            FragmentActivity activity2 = gameFragment.getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.setStatusBarFullscreen(false);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$6(GameFragment gameFragment, ConstraintLayout constraintLayout) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.syncCurrentGame(true, false, true);
        constraintLayout.setVisibility(8);
        if (gameFragment.currentGameFragment != null) {
            gameFragment.fullscreen = false;
            FragmentActivity activity = gameFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.setFullscreenMode(false);
            }
            FragmentActivity activity2 = gameFragment.getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.setStatusBarFullscreen(false);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$7(GameFragment gameFragment) {
        gameFragment.onExitButtonPressed();
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$8(final GameFragment gameFragment, ConstraintLayout constraintLayout, Ref.BooleanRef booleanRef, GameSet gameSet, PreferencesManager preferencesManager) {
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.exitGamePlayerSummaryMode();
        }
        constraintLayout.setVisibility(8);
        View view = gameFragment.getView();
        ConstraintLayout constraintLayout2 = view != null ? (ConstraintLayout) view.findViewById(R.id.startGameButtonLayout) : null;
        View view2 = gameFragment.getView();
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.startGameButtonText) : null;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
            if (textView != null) {
                textView.setText(gameFragment.getString(R.string.done));
            }
            ViewExtensionsKt.setOnClickWithBounce(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.gameFinished$lambda$8$1$0(this.f$0);
                }
            });
        }
        if (booleanRef.element) {
            if (gameSet != null) {
                gameSet.getFinishedGames().remove(gameSet.getFinishedGames().size() - 1);
                preferencesManager.saveCurrentSet(gameSet);
                int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, gameSet);
                int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, gameSet);
                GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
                if (gameFragmentBase2 != null) {
                    gameFragmentBase2.showBestOfScore(playerScore, playerScore2);
                }
            }
            gameFragment.getSharedViewModel().getGameState().setGameClosed(false);
            preferencesManager.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameFinished$lambda$8$1$0(GameFragment gameFragment) {
        gameFragment.gameFinished();
        return Unit.INSTANCE;
    }

    static final Unit gameFinished$lambda$9(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.saveCurrentQuickGame();
        restartCurrentGame$default(gameFragment, false, true, false, 4, null);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameForceUpload$lambda$0$2(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameForceUpload$lambda$0$3(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        if (gameFragment.getSharedViewModel().getGameState().getEndedAt().length() == 0) {
            gameFragment.getSharedViewModel().getGameState().setEndedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        }
        int i = 0;
        if (gameFragment.getSharedViewModel().getGameState().getTimerPaused()) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - gameFragment.getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
            GameState gameState = gameFragment.getSharedViewModel().getGameState();
            gameState.setPauseTime(gameState.getPauseTime() + iCurrentTimeMillis);
            gameFragment.getSharedViewModel().getGameState().setTimerPaused(false);
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            if (gameFragmentBase != null) {
                gameFragmentBase.toggleTimerPause();
            }
        }
        if (!gameFragment.getSharedViewModel().getGameState().getGameClosed()) {
            PreferencesManager preferencesManager = gameFragment.prefs;
            if (preferencesManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager = null;
            }
            GameSet currentSet = preferencesManager.getCurrentSet();
            if (currentSet != null) {
                if (GameUtils.INSTANCE.getInstance().getGameWinners(gameFragment.getSharedViewModel().getGameState()).isEmpty()) {
                    Iterator<T> it = gameFragment.getSharedViewModel().getGameState().getPlayers().iterator();
                    while (it.hasNext()) {
                        it.next();
                        gameFragment.getSharedViewModel().getGameState().getPlayers().get(i).setResultid(3);
                        i++;
                    }
                    gameFragment.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.GameDraw.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                }
                GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
                if (gameFragmentBase2 != null) {
                    gameFragmentBase2.closeCurrentTurn();
                }
                currentSet.getFinishedGames().add(gameFragment.getSharedViewModel().getGameState());
                Context context = gameFragment.getContext();
                if (context != null) {
                    new PreferencesManager(context).saveCurrentSet(currentSet);
                }
            }
        }
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
        syncCurrentGame$default(gameFragment, false, false, false, 6, null);
        gameFragment.closeMenu();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gameReady() {
        GameFragment1PlayerType2 gameFragment1PlayerType2NewInstance;
        boolean z;
        if (getContext() == null) {
            return;
        }
        if (getSharedViewModel().getGameState().getPlayers().isEmpty()) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            preferencesManager.clearCurrentGame();
            preferencesManager.clearGameSelectedDecks();
            newGameFromScratch();
            return;
        }
        if (getSharedViewModel().getGameState().getStartedAt().length() == 0 && !getSharedViewModel().getGameState().getGameSyncable()) {
            getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        }
        PreferencesManager preferencesManager2 = this.prefs;
        PreferencesManager preferencesManager3 = null;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        preferencesManager2.saveCurrentGame(getSharedViewModel().getGameState());
        if (getSharedViewModel().getGameState().getStreamingEnabled()) {
            PreferencesManager preferencesManager4 = this.prefs;
            if (preferencesManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager4 = null;
            }
            if (preferencesManager4.hasValidUser()) {
                if (getSharedViewModel().getGameState().getStreamingToken().length() == 0) {
                    MTApiKt.getMtApi().getStreamingToken().enqueue(new Callback<MTStreamingTokenResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment.gameReady.1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTStreamingTokenResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTStreamingTokenResponse> call, Response<MTStreamingTokenResponse> response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (GameFragment.this.getContext() == null || GameFragment.this._binding == null || !response.isSuccessful()) {
                                return;
                            }
                            MTStreamingTokenResponse mTStreamingTokenResponseBody = response.body();
                            String streamingToken = mTStreamingTokenResponseBody != null ? mTStreamingTokenResponseBody.getStreamingToken() : null;
                            if (streamingToken != null) {
                                GameFragment gameFragment = GameFragment.this;
                                gameFragment.getSharedViewModel().getGameState().setStreamingToken(streamingToken);
                                PreferencesManager preferencesManager5 = gameFragment.prefs;
                                if (preferencesManager5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                                    preferencesManager5 = null;
                                }
                                preferencesManager5.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
                                Log.d("MTApi", "Received streaming token: " + streamingToken);
                                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                                String uid = currentUser != null ? currentUser.getUid() : null;
                                gameFragment.initialStreamingDone = false;
                                if (streamingToken.length() <= 0 || uid == null) {
                                    return;
                                }
                                gameFragment.streamingManager.disconnect();
                                gameFragment.streamingManager.connect(streamingToken, uid);
                            }
                        }
                    });
                } else {
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = currentUser != null ? currentUser.getUid() : null;
                    this.initialStreamingDone = false;
                    if (getSharedViewModel().getGameState().getStreamingToken().length() > 0 && uid != null) {
                        this.streamingManager.disconnect();
                        this.streamingManager.connect(getSharedViewModel().getGameState().getStreamingToken(), uid);
                    }
                }
            }
        }
        switch (getSharedViewModel().getGameState().getNumberOfPlayers()) {
            case 1:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment1PlayerType2.INSTANCE.newInstance() : GameFragment1PlayerType1.INSTANCE.newInstance();
                break;
            case 2:
                int i = WhenMappings.$EnumSwitchMapping$0[getSharedViewModel().getGameState().getLayoutType().ordinal()];
                if (i == 1) {
                    gameFragment1PlayerType2NewInstance = GameFragment2PlayersType1.INSTANCE.newInstance();
                } else if (i == 2) {
                    gameFragment1PlayerType2NewInstance = GameFragment2PlayersType2.INSTANCE.newInstance();
                } else {
                    gameFragment1PlayerType2NewInstance = GameFragment2PlayersType3.INSTANCE.newInstance();
                }
                break;
            case 3:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment3PlayersType2.INSTANCE.newInstance() : GameFragment3PlayersType1.INSTANCE.newInstance();
                break;
            case 4:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment4PlayersType2.INSTANCE.newInstance() : GameFragment4PlayersType1.INSTANCE.newInstance();
                break;
            case 5:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment5PlayersType2.INSTANCE.newInstance() : GameFragment5PlayersType1.INSTANCE.newInstance();
                break;
            case 6:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment6PlayersType2.INSTANCE.newInstance() : GameFragment6PlayersType1.INSTANCE.newInstance();
                break;
            case 7:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment7PlayersType2.INSTANCE.newInstance() : GameFragment7PlayersType1.INSTANCE.newInstance();
                break;
            case 8:
                gameFragment1PlayerType2NewInstance = getSharedViewModel().getGameState().getLayoutType() != LayoutType.TYPE_1 ? GameFragment8PlayersType2.INSTANCE.newInstance() : GameFragment8PlayersType1.INSTANCE.newInstance();
                break;
            default:
                gameFragment1PlayerType2NewInstance = null;
                break;
        }
        if (gameFragment1PlayerType2NewInstance == null || getContext() == null) {
            return;
        }
        this.currentGameFragment = gameFragment1PlayerType2NewInstance;
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        toolbar.setVisibility(8);
        getBinding().viewPager.setVisibility(8);
        fragmentContainer.setVisibility(0);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, gameFragment1PlayerType2NewInstance);
        fragmentTransactionBeginTransaction.commit();
        if (getSharedViewModel().getGameState().getPlaygroupId() != -1) {
            if (getSharedViewModel().getGameState().getUsersSeated()) {
                z = false;
            } else {
                gameFragment1PlayerType2NewInstance.showMenu();
                gameFragment1PlayerType2NewInstance.showMenuAsClose();
                z = true;
            }
            if (!getSharedViewModel().getGameState().getDecksSelected()) {
                z = true;
            }
        } else {
            PreferencesManager preferencesManager5 = this.prefs;
            if (preferencesManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager5 = null;
            }
            if (preferencesManager5.hasValidUser() && getSharedViewModel().getGameState().getGameSyncable()) {
                z = !getSharedViewModel().getGameState().getUsersSeated();
                if (!getSharedViewModel().getGameState().getDecksSelected()) {
                    z = true;
                }
                GameFragmentBase gameFragmentBase = this.currentGameFragment;
                if (gameFragmentBase != null) {
                    gameFragmentBase.showStartGameButton();
                }
            } else {
                z = false;
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 3 && !GameUtils.INSTANCE.getInstance().isLeaderRevealed(getSharedViewModel().getGameState())) {
            if ((getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected()) || !getSharedViewModel().getGameState().getGameSyncable()) {
                getBinding().viewPager.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragment.gameReady$lambda$0$0(this.f$0);
                    }
                }, 500L);
            }
            z = true;
        }
        boolean z2 = getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed();
        if (getSharedViewModel().getGameState().getTimerEnabled() && !z && getSharedViewModel().getGameState().getTimerStartTime() == 0 && !z2) {
            getSharedViewModel().getGameState().setTimerStartTime(System.currentTimeMillis());
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerStart.getValue(), 0, null, getSharedViewModel().getGameState().getTimerTotalTime(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            PreferencesManager preferencesManager6 = this.prefs;
            if (preferencesManager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager6 = null;
            }
            preferencesManager6.saveCurrentGame(getSharedViewModel().getGameState());
            gameFragment1PlayerType2NewInstance.showClock();
            gameFragment1PlayerType2NewInstance.updateClock();
            PreferencesManager preferencesManager7 = this.prefs;
            if (preferencesManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager7 = null;
            }
            if (!preferencesManager7.getBoolean(PreferencesManager.AUTO_START_TIMER, true)) {
                gameFragment1PlayerType2NewInstance.toggleTimerPause();
            }
        }
        onHiddenChanged(false);
        PreferencesManager preferencesManager8 = this.prefs;
        if (preferencesManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager8 = null;
        }
        if (!preferencesManager8.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true) || z) {
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.checkForLowBattery();
            }
        } else if (!getSharedViewModel().getGameState().getTossAlreadyDone() && getSharedViewModel().getGameState().getNumberOfPlayers() > 1) {
            getBinding().viewPager.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.gameReady$lambda$0$1(this.f$0);
                }
            }, 1000L);
        }
        PreferencesManager preferencesManager9 = this.prefs;
        if (preferencesManager9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager3 = preferencesManager9;
        }
        if (!preferencesManager3.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true) && getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) {
            getBinding().viewPager.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.gameReady$lambda$0$2(this.f$0);
                }
            }, 1500L);
        }
        fadeIn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gameReady$lambda$0$0(GameFragment gameFragment) {
        if (gameFragment.getContext() == null) {
            return;
        }
        gameFragment.showLeaderRevealDialog();
        gameFragment.getSharedViewModel().getGameState().setTossAlreadyDone(true);
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gameReady$lambda$0$1(final GameFragment gameFragment) {
        if (gameFragment.getContext() == null) {
            return;
        }
        gameFragment.getSharedViewModel().getGameState().setTossAlreadyDone(true);
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
        if (gameFragment.isAdded() && !gameFragment.isRemoving() && !gameFragment.getChildFragmentManager().isStateSaved()) {
            int i = (gameFragment.getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_3 || gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) ? 90 : 270;
            SkinManager companion = SkinManager.INSTANCE.getInstance();
            Context contextRequireContext = gameFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
            PlayerSelectFragment.Builder onDismissListener = new PlayerSelectFragment.Builder().setPlayerTossSkin(currentSkinDefinition != null ? currentSkinDefinition.getCustomPlayerToss() : null).setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.gameReady$lambda$0$1$1(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setNegativeButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.gameReady$lambda$0$1$2(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setOnDismissListener(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.gameReady$lambda$0$1$3(this.f$0, ((Boolean) obj).booleanValue());
                }
            });
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            PlayerSelectFragment.Builder rotation = onDismissListener.setFragmentView(gameFragmentBase != null ? gameFragmentBase.getView() : null).setRotation(i);
            FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "PlayerSelectFragment");
        }
        GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
        if (gameFragmentBase2 == null || gameFragment.getContext() == null) {
            return;
        }
        gameFragmentBase2.runPlayerTossIntroLoop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameReady$lambda$0$1$1(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        runPlayerToss$default(gameFragment, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameReady$lambda$0$1$2(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
            gameFragmentBase.playerTossSkipped();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameReady$lambda$0$1$3(final GameFragment gameFragment, boolean z) {
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
            if (z) {
                gameFragmentBase.playerTossSkipped();
            }
            View view = gameFragmentBase.getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragment.gameReady$lambda$0$1$3$0$0(this.f$0);
                    }
                }, 10000L);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gameReady$lambda$0$1$3$0$0(GameFragment gameFragment) {
        FragmentActivity activity = gameFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.checkForLowBattery();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gameReady$lambda$0$2(GameFragment gameFragment) {
        int numberOfPlayers = gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            if (gameFragmentBase != null && i < gameFragmentBase.getLifeViews().size()) {
                gameFragmentBase.getLifeViews().get(i).triggerPlayerStartQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentFullGameBinding getBinding() {
        FragmentFullGameBinding fragmentFullGameBinding = this._binding;
        Intrinsics.checkNotNull(fragmentFullGameBinding);
        return fragmentFullGameBinding;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GameItemHolder getSetGameHolder() {
        MTGamePlaygroup mTGamePlaygroup;
        MTGameFormat mTGameFormat;
        MTGameSubformat mTGameSubformat;
        MTUser mTUser;
        String picture;
        String str;
        Object next;
        Object next2;
        Object next3;
        MTSubformat mTSubformat;
        Object next4;
        Object next5;
        Object next6;
        if (getContext() == null) {
            return new GameItemHolder(0, null, null, 0, null, null, false, 127, null);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        GameSet currentSet = preferencesManager.getCurrentSet();
        if (currentSet == null) {
            return new GameItemHolder(0, null, null, 0, null, null, false, 127, null);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (GameState gameState : currentSet.getFinishedGames()) {
            int i2 = i + 1;
            MTGame mTGame = new MTGame(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
            MTSet mTSet = new MTSet(currentSet.getBestOf(), i, currentSet.getFinishedGames().size(), null, null, 24, null);
            ArrayList arrayList2 = new ArrayList();
            int i3 = -1;
            if (gameState.getPlaygroupId() != -1) {
                Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it.next();
                    if (((MTPlaygroup) next6).getId() == gameState.getPlaygroupId()) {
                        break;
                    }
                }
                MTPlaygroup mTPlaygroup = (MTPlaygroup) next6;
                mTGamePlaygroup = mTPlaygroup != null ? new MTGamePlaygroup(mTPlaygroup.getId(), mTPlaygroup.getName(), mTPlaygroup.getPicture()) : null;
            }
            if (gameState.getFormatId() != -1) {
                DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                Iterator<T> it2 = companion.getInstance(contextRequireContext2).getFormats().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it2.next();
                    if (((MTFormat) next5).getId() == gameState.getFormatId()) {
                        break;
                    }
                }
                MTFormat mTFormat = (MTFormat) next5;
                mTGameFormat = mTFormat != null ? new MTGameFormat(mTFormat.getId(), mTFormat.getName()) : null;
            }
            if (gameState.getSubformatId() != -1) {
                DecksDBHelper.Companion companion2 = DecksDBHelper.INSTANCE;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                Iterator<T> it3 = companion2.getInstance(contextRequireContext3).getFormats().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (((MTFormat) next3).getId() == gameState.getFormatId()) {
                        break;
                    }
                }
                MTFormat mTFormat2 = (MTFormat) next3;
                if (mTFormat2 == null) {
                    mTGameSubformat = null;
                } else {
                    List<MTSubformat> subformats = mTFormat2.getSubformats();
                    if (subformats != null) {
                        Iterator<T> it4 = subformats.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                next4 = null;
                                break;
                            }
                            next4 = it4.next();
                            if (((MTSubformat) next4).getId() == gameState.getSubformatId()) {
                                break;
                            }
                        }
                        mTSubformat = (MTSubformat) next4;
                    } else {
                        mTSubformat = null;
                    }
                    if (mTSubformat != null) {
                        mTGameSubformat = new MTGameSubformat(mTSubformat.getId(), mTSubformat.getName());
                    }
                }
            }
            List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(gameState);
            int i4 = 0;
            for (Player player : gameState.getPlayers()) {
                int i5 = i4 + 1;
                PreferencesManager preferencesManager2 = preferencesManager;
                if (gameState.getPlaygroupId() != i3) {
                    Iterator it5 = preferencesManager2.getCurrentUserPlaygroups().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it5.next();
                        Iterator it6 = it5;
                        if (((MTPlaygroup) next).getId() == gameState.getPlaygroupId()) {
                            break;
                        }
                        it5 = it6;
                    }
                    MTPlaygroup mTPlaygroup2 = (MTPlaygroup) next;
                    if (mTPlaygroup2 != null) {
                        Iterator it7 = mTPlaygroup2.getUsers().iterator();
                        while (true) {
                            if (!it7.hasNext()) {
                                mTUser = currentUser;
                                next2 = null;
                                break;
                            }
                            next2 = it7.next();
                            Iterator it8 = it7;
                            mTUser = currentUser;
                            if (((MTUser) next2).getId() == player.getUserId()) {
                                break;
                            }
                            it7 = it8;
                            currentUser = mTUser;
                        }
                        MTUser mTUser2 = (MTUser) next2;
                        if (mTUser2 == null || (picture = mTUser2.getPicture()) == null) {
                        }
                    } else {
                        mTUser = currentUser;
                    }
                    picture = "";
                }
                if (mTUser == null || player.getUserId() != mTUser.getId()) {
                    str = picture;
                } else {
                    String picture2 = mTUser.getPicture();
                    str = picture2 != null ? picture2 : "";
                }
                arrayList2.add(new MTGamePlayer(player.getUserId(), player.getName(), "", str, null, i4, Integer.valueOf(gameWinners.contains(Integer.valueOf(player.getUserId())) ? 1 : (player.getResultid() == 3 || player.getResultid() == 2) ? player.getResultid() : 0), 0, Integer.valueOf(player.getStartingLifeTotal()), null, 512, null));
                i4 = i5;
                preferencesManager = preferencesManager2;
                currentUser = mTUser;
                i3 = -1;
            }
            PreferencesManager preferencesManager3 = preferencesManager;
            MTUser mTUser3 = currentUser;
            mTGame.setSet(mTSet);
            mTGame.setPlaygroup(mTGamePlaygroup);
            mTGame.setFormat(mTGameFormat);
            mTGame.setCreated_by(preferencesManager3.getCurrentUser());
            mTGame.setStarted_at(gameState.getStartedAt());
            if (mTGame.getStarted_at().length() == 0) {
                mTGame.setStarted_at(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            }
            mTGame.setEnded_at(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            mTGame.setPlayers(arrayList2);
            mTGame.setSubformat(mTGameSubformat);
            arrayList.add(mTGame);
            i = i2;
            preferencesManager = preferencesManager3;
            currentUser = mTUser3;
        }
        GameItemHolder gameItemHolder = new GameItemHolder(0, null, null, 0, null, null, false, 127, null);
        gameItemHolder.setBestof(currentSet.getBestOf());
        gameItemHolder.setSubgames(arrayList);
        gameItemHolder.setGame(null);
        gameItemHolder.setType(4);
        return gameItemHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GameItemHolder getSingleGameHolder() {
        MTGamePlaygroup mTGamePlaygroup;
        MTGameFormat mTGameFormat;
        MTGameSubformat mTGameSubformat;
        String picture;
        int i;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
        if (getContext() == null) {
            return new GameItemHolder(0, null, null, 0, null, null, false, 127, null);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        MTGame mTGame = new MTGame(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        if (getSharedViewModel().getGameState().getPlaygroupId() != -1) {
            Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next6 = null;
                    break;
                }
                next6 = it.next();
                if (((MTPlaygroup) next6).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                    break;
                }
            }
            MTPlaygroup mTPlaygroup = (MTPlaygroup) next6;
            mTGamePlaygroup = mTPlaygroup != null ? new MTGamePlaygroup(mTPlaygroup.getId(), mTPlaygroup.getName(), mTPlaygroup.getPicture()) : null;
        }
        if (getSharedViewModel().getGameState().getFormatId() != -1) {
            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            Iterator<T> it2 = companion.getInstance(contextRequireContext2).getFormats().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next5 = null;
                    break;
                }
                next5 = it2.next();
                if (((MTFormat) next5).getId() == getSharedViewModel().getGameState().getFormatId()) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next5;
            mTGameFormat = mTFormat != null ? new MTGameFormat(mTFormat.getId(), mTFormat.getName()) : null;
        }
        if (getSharedViewModel().getGameState().getSubformatId() != -1) {
            DecksDBHelper.Companion companion2 = DecksDBHelper.INSTANCE;
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            Iterator<T> it3 = companion2.getInstance(contextRequireContext3).getSubformats(getSharedViewModel().getGameState().getFormatId()).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next4 = null;
                    break;
                }
                next4 = it3.next();
                if (((MTSubformat) next4).getId() == getSharedViewModel().getGameState().getSubformatId()) {
                    break;
                }
            }
            MTSubformat mTSubformat = (MTSubformat) next4;
            mTGameSubformat = mTSubformat != null ? new MTGameSubformat(mTSubformat.getId(), mTSubformat.getName()) : null;
        }
        List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
        Iterator<T> it4 = getSharedViewModel().getGameState().getPlayers().iterator();
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (!it4.hasNext()) {
                break;
            }
            int i5 = i3 + 1;
            Player player = (Player) it4.next();
            if (getSharedViewModel().getGameState().getPlaygroupId() != i2) {
                Iterator<T> it5 = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it5.next();
                    if (((MTPlaygroup) next2).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                        break;
                    }
                }
                MTPlaygroup mTPlaygroup2 = (MTPlaygroup) next2;
                if (mTPlaygroup2 != null) {
                    Iterator<T> it6 = mTPlaygroup2.getUsers().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it6.next();
                        if (((MTUser) next3).getId() == player.getUserId()) {
                            break;
                        }
                    }
                    MTUser mTUser = (MTUser) next3;
                    if (mTUser == null || (picture = mTUser.getPicture()) == null) {
                        picture = "";
                    }
                }
            }
            String str = (currentUser != null && player.getUserId() == currentUser.getId() && (picture = currentUser.getPicture()) == null) ? "" : picture;
            int resultid = gameWinners.contains(Integer.valueOf(player.getUserId())) ? 1 : (player.getResultid() == 3 || player.getResultid() == 2) ? player.getResultid() : 0;
            if (getSharedViewModel().getGameState().getSubformatId() == 3) {
                Iterator<T> it7 = getSharedViewModel().getGameState().getEvents().iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it7.next();
                    MTGameEvent mTGameEvent = (MTGameEvent) next;
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i3) {
                        break;
                    }
                }
                MTGameEvent mTGameEvent2 = (MTGameEvent) next;
                if (mTGameEvent2 != null) {
                    int value = mTGameEvent2.getValue();
                    if (value == 0 || value == 1) {
                        i = 1;
                    } else if (value == 2) {
                        i = 2;
                    } else if (value == 3) {
                        i = 3;
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                        i = (i3 == 0 || i3 == 3) ? 1 : 2;
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                        if (i3 != 0 && i3 != 1 && i3 != 5) {
                            i4 = 2;
                        }
                        i = i4;
                    }
                    arrayList.add(new MTGamePlayer(player.getUserId(), player.getName(), "", str, null, i3, Integer.valueOf(resultid), Integer.valueOf(i), Integer.valueOf(player.getStartingLifeTotal()), null, 512, null));
                    i3 = i5;
                    i2 = -1;
                }
            }
            i = 0;
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
            }
            arrayList.add(new MTGamePlayer(player.getUserId(), player.getName(), "", str, null, i3, Integer.valueOf(resultid), Integer.valueOf(i), Integer.valueOf(player.getStartingLifeTotal()), null, 512, null));
            i3 = i5;
            i2 = -1;
        }
        mTGame.setSet(null);
        mTGame.setPlaygroup(mTGamePlaygroup);
        mTGame.setFormat(mTGameFormat);
        mTGame.setCreated_by(preferencesManager.getCurrentUser());
        mTGame.setStarted_at(getSharedViewModel().getGameState().getStartedAt());
        if (mTGame.getStarted_at().length() == 0) {
            mTGame.setStarted_at(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        }
        mTGame.setEnded_at(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        mTGame.setPlayers(arrayList);
        mTGame.setSubformat(mTGameSubformat);
        GameItemHolder gameItemHolder = new GameItemHolder(0, null, null, 0, null, null, false, 127, null);
        gameItemHolder.setGame(mTGame);
        gameItemHolder.setType(1);
        return gameItemHolder;
    }

    private final void hideSystemUI() {
        if (getActivity() == null || requireActivity().getWindow() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            requireActivity().getWindow().getDecorView().setSystemUiVisibility(4102);
            return;
        }
        WindowInsetsController insetsController = requireActivity().getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            insetsController.setSystemBarsBehavior(2);
        }
    }

    private final void incrementNumGames() {
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        int i = preferencesManager.getInt(PreferencesManager.NUM_GAMES, 0) + 1;
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        preferencesManager2.setInt(PreferencesManager.NUM_GAMES, i);
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        if (i == 1) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("first_game");
            firebaseAnalytics.logEvent("first_game", null);
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_game");
        firebaseAnalytics.logEvent("new_game", null);
    }

    static final Unit menuPressed$lambda$1(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.deleteCurrentGame();
        gameFragment.closeMenu();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit menuPressed$lambda$2(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void menuPressed$lambda$3(View view) {
    }

    static final Unit menuPressed$lambda$4(final GameFragment gameFragment, PreferencesManager preferencesManager, MTUser mTUser) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        String string = gameFragment.getResources().getString(R.string.restart_body);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        GameSet currentSet = preferencesManager.getCurrentSet();
        if (currentSet != null) {
            string = gameFragment.getResources().getString(R.string.restart_body_set);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        if ((gameFragment.getSharedViewModel().getGameState().getPlaygroupId() != -1 || mTUser != null) && gameFragment.getSharedViewModel().getGameState().getGameSyncable() && !gameFragment.getSharedViewModel().getGameState().getGameSynced()) {
            if (currentSet != null) {
                string = gameFragment.getResources().getString(R.string.restart_body_synced_set);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } else {
                string = gameFragment.getResources().getString(R.string.restart_body_synced);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string2 = gameFragment.getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(string);
        String string3 = gameFragment.getString(R.string.yes_restart);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragment.menuPressed$lambda$4$3(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = gameFragment.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment.menuPressed$lambda$4$4((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuPressed$lambda$4$3(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        gameFragment.closeMenu();
        gameFragment.saveCurrentQuickGame();
        restartCurrentGame$default(gameFragment, false, true, false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuPressed$lambda$4$4(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit menuPressed$lambda$5(GameFragment gameFragment) {
        gameFragment.onExitButtonPressed();
        return Unit.INSTANCE;
    }

    static final Unit menuPressed$lambda$6(GameFragment gameFragment) {
        gameFragment.closeMenu();
        return Unit.INSTANCE;
    }

    static final void menuPressed$lambda$7(View view) {
    }

    static final Unit menuPressed$lambda$8(GameFragment gameFragment, PreferencesManager preferencesManager, ConstraintLayout constraintLayout, TextView textView) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("android_review_from_game_menu", null);
        String packageName = gameFragment.requireContext().getPackageName();
        try {
            gameFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            gameFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_MENU_RATING_BANNER_DISMISSED, true);
        constraintLayout.setVisibility(4);
        textView.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit menuPressed$lambda$9(GameFragment gameFragment, PreferencesManager preferencesManager, ConstraintLayout constraintLayout, TextView textView) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_MENU_RATING_BANNER_DISMISSED, true);
        constraintLayout.setVisibility(4);
        textView.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void onExitButtonPressed() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if ((getSharedViewModel().getGameState().getPlaygroupId() == -1 && currentUser == null) || !getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getGameSynced()) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.are_you_sure_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.yes_delete);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda60
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment.onExitButtonPressed$lambda$6(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            }).setPositiveButtonRed();
            String string4 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButtonRed.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.onExitButtonPressed$lambda$7((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "CustomDialogFragment");
            return;
        }
        if (GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState()).isEmpty()) {
            String string5 = getString(R.string.game_unfinished_title);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String string6 = getString(R.string.game_unfinished_body);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            if (preferencesManager.getCurrentSet() != null) {
                string5 = getString(R.string.match_unfinished_title);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                string6 = getString(R.string.match_unfinished_body);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            }
            CustomDialogFragment.Builder body2 = new CustomDialogFragment.Builder().setTitle(string5).setBody(string6);
            String string7 = getString(R.string.discard);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomDialogFragment.Builder destructiveButton = body2.setDestructiveButton(string7, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.onExitButtonPressed$lambda$4(this.f$0, (CustomDialogFragment) obj);
                }
            });
            String string8 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            CustomDialogFragment.Builder positiveButton = destructiveButton.setPositiveButton(string8, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment.onExitButtonPressed$lambda$5(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager2, "CustomDialogFragment");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string9 = getString(R.string.game_unsynced_title);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string9);
        String string10 = getString(R.string.game_unsynced_body);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        CustomDialogFragment.Builder body3 = title2.setBody(string10);
        String string11 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed2 = body3.setNegativeButton(string11, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment.onExitButtonPressed$lambda$0(this.f$0, (CustomDialogFragment) obj);
            }
        }).setPositiveButtonRed();
        String string12 = getString(R.string.sync_now);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string12, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragment.onExitButtonPressed$lambda$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string13 = getString(R.string.discard);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        CustomDialogFragment.Builder destructiveButton2 = positiveButton2.setDestructiveButton(string13, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment.onExitButtonPressed$lambda$2(this.f$0, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager3 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
        destructiveButton2.show(childFragmentManager3, "CustomDialogFragment");
    }

    static final Unit onExitButtonPressed$lambda$0(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.closeMenu();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$1(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        syncCurrentGame$default(gameFragment, false, false, false, 6, null);
        gameFragment.closeMenu();
        gameFragment.getBinding().gameOverOverlay.setVisibility(8);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$2(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameFragment.deleteCurrentGame();
        gameFragment.closeMenu();
        gameFragment.getBinding().gameOverOverlay.setVisibility(8);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$4(GameFragment gameFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameFragment.deleteCurrentGame();
        gameFragment.closeMenu();
        gameFragment.getBinding().gameOverOverlay.setVisibility(8);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$5(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$6(GameFragment gameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment.saveCurrentQuickGame();
        gameFragment.deleteCurrentGame();
        gameFragment.closeMenu();
        gameFragment.getBinding().gameOverOverlay.setVisibility(8);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onExitButtonPressed$lambda$7(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHiddenChanged$lambda$1$0(GameFragment gameFragment, ConstraintLayout constraintLayout) {
        if (gameFragment.getContext() == null || gameFragment.currentGameFragment == null) {
            return;
        }
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.ENABLE_FULLSCREEN_MODE, true)) {
            FragmentActivity activity = gameFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity == null || ((BottomNavigationView) mainActivity.findViewById(R.id.bottom_navigation)).getSelectedItemId() == R.id.navigation_game) {
                if (!gameFragment.getSharedViewModel().getGameState().getGameSyncable() || gameFragment.getSharedViewModel().getGameState().getUsersSeated()) {
                    if ((gameFragment.getSharedViewModel().getGameState().getGameSyncable() && !gameFragment.getSharedViewModel().getGameState().getDecksSelected()) || constraintLayout.getVisibility() == 0 || gameFragment.fullscreen) {
                        return;
                    }
                    gameFragment.fullscreen = true;
                    FragmentActivity activity2 = gameFragment.getActivity();
                    MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
                    if (mainActivity2 != null) {
                        mainActivity2.setFullscreenMode(true);
                    }
                    FragmentActivity activity3 = gameFragment.getActivity();
                    MainActivity mainActivity3 = activity3 instanceof MainActivity ? (MainActivity) activity3 : null;
                    if (mainActivity3 != null) {
                        mainActivity3.setStatusBarFullscreen(true);
                    }
                }
            }
        }
    }

    static final void onStreamingConnectionStateChanged$lambda$0(GameFragment gameFragment) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return;
        }
        GameState gameState = gameFragment.getSharedViewModel().getGameState();
        StreamingConverter.Companion companion = StreamingConverter.INSTANCE;
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        gameFragment.streamingManager.sendGameUpdate(companion.convertToStreamingData(contextRequireContext, gameState));
    }

    static final void onViewCreated$lambda$0(View view) {
    }

    static final boolean onViewCreated$lambda$1(GameFragment gameFragment, CardView cardView, View view) {
        gameFragment.getBinding().leaderSelectLayout.setVisibility(4);
        cardView.startDragAndDrop(ClipData.newPlainText("", ""), new View.DragShadowBuilder(cardView), cardView, 0);
        return false;
    }

    static final boolean onViewCreated$lambda$2(GameFragment gameFragment, CardView cardView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            gameFragment.downRawX = motionEvent.getRawX();
            gameFragment.downRawY = motionEvent.getRawY();
            gameFragment.dragging = true;
            return true;
        }
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - gameFragment.downRawX);
            float fAbs2 = Math.abs(rawY - gameFragment.downRawY);
            int i = gameFragment.moveThreshold;
            if (fAbs > i && fAbs2 > i) {
                return false;
            }
            Toast.makeText(gameFragment.requireContext(), gameFragment.getResources().getString(R.string.drag_to_player), 0).show();
            return true;
        }
        if (action != 2 || !gameFragment.dragging) {
            return false;
        }
        gameFragment.moveThreshold = ViewConfiguration.get(gameFragment.requireContext()).getScaledTouchSlop();
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        float fAbs3 = Math.abs(rawX2 - gameFragment.downRawX);
        float fAbs4 = Math.abs(rawY2 - gameFragment.downRawY);
        int i2 = gameFragment.moveThreshold;
        if (fAbs3 > i2 || fAbs4 > i2) {
            gameFragment.dragging = false;
            gameFragment.getBinding().leaderSelectLayout.setVisibility(4);
            cardView.startDragAndDrop(ClipData.newPlainText("", ""), new View.DragShadowBuilder(cardView), cardView, 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartCurrentGame(final boolean skipTimerAndToss, boolean restartMatch, final boolean deckSelection) {
        boolean z;
        int bestOf;
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.gamePlayerResultsMode = false;
        GameUtils.INSTANCE.getInstance().getDecorsUsed().clear();
        GameUtils.INSTANCE.getInstance().getKosUsed().clear();
        Breadcrumbs.INSTANCE.leaveBreadcrumb("restart_game");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        PreferencesManager preferencesManager = null;
        firebaseAnalytics.logEvent("restart_game", null);
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            int size = getSharedViewModel().getGameState().getPlayers().size();
            for (int i = 0; i < size; i++) {
                getSharedViewModel().getGameState().getPlayers().get(i).setKO(false);
                getSharedViewModel().getGameState().getPlayers().get(i).setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(i).getStartingLifeTotal());
                getSharedViewModel().getGameState().getPlayers().get(i).setPoisonCounters(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setEnergyCounters(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setStormCount(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setTaxCount(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setTaxCountPartner(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setExperienceCount(0);
                getSharedViewModel().getGameState().getPlayers().get(i).setRadiationCount(0);
                Player player = getSharedViewModel().getGameState().getPlayers().get(i);
                int size2 = getSharedViewModel().getGameState().getPlayers().size();
                ArrayList arrayList = new ArrayList(size2);
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList.add(0);
                }
                player.setCommanderDamageList(arrayList);
                Player player2 = getSharedViewModel().getGameState().getPlayers().get(i);
                int size3 = getSharedViewModel().getGameState().getPlayers().size();
                ArrayList arrayList2 = new ArrayList(size3);
                for (int i3 = 0; i3 < size3; i3++) {
                    arrayList2.add(0);
                }
                player2.setCommanderDamageListPartner(arrayList2);
                getSharedViewModel().getGameState().getPlayers().get(i).setMonarch(false);
                getSharedViewModel().getGameState().getPlayers().get(i).setInitiative(false);
                getSharedViewModel().getGameState().getPlayers().get(i).setCityBlessing(false);
                getSharedViewModel().getGameState().getPlayers().get(i).setTheRing(false);
                getSharedViewModel().getGameState().getPlayers().get(i).setTheRingLevel(-1);
                getSharedViewModel().getGameState().getPlayers().get(i).setUndercityRoomId(-1);
                getSharedViewModel().getGameState().getPlayers().get(i).setResultid(-1);
            }
            if (!skipTimerAndToss) {
                getSharedViewModel().getGameState().setTimerStartTime(0L);
                if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    getSharedViewModel().getGameState().setTurnTimerPromptDismissed(false);
                }
            }
            getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            getSharedViewModel().getGameState().setEndedAt("");
            getSharedViewModel().getGameState().setPauseTime(0);
            if (getSharedViewModel().getGameState().getTimerPaused()) {
                GameFragmentBase gameFragmentBase2 = this.currentGameFragment;
                if (gameFragmentBase2 != null) {
                    gameFragmentBase2.toggleTimerPause();
                }
                getSharedViewModel().getGameState().setTimerPaused(false);
                getSharedViewModel().getGameState().setTimerPausedAt(0L);
            }
            getSharedViewModel().getGameState().setEvents(new ArrayList());
            getSharedViewModel().getGameState().setPlanechaseSeed(0);
            if (getSharedViewModel().getGameState().getSubformatId() == 1 || getSharedViewModel().getGameState().getHasPlanechase()) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                getSharedViewModel().getGameState().setPlanechaseSeed(companion.rebuildPlanarDeck(contextRequireContext, getSharedViewModel().getGameState()));
            }
            getSharedViewModel().getGameState().setArchenemySeed(0);
            if (getSharedViewModel().getGameState().getSubformatId() == 7 || getSharedViewModel().getGameState().getHasArchenemy()) {
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                getSharedViewModel().getGameState().setArchenemySeed(companion2.rebuildSchemeDeck(contextRequireContext2, getSharedViewModel().getGameState()));
            }
            GameFragmentBase gameFragmentBase3 = this.currentGameFragment;
            if (gameFragmentBase3 != null) {
                gameFragmentBase3.updateLifeHistory();
                gameFragmentBase3.showLifeHistory();
            }
            if (getSharedViewModel().getGameState().getTimerEnabled() && !skipTimerAndToss) {
                getSharedViewModel().getGameState().setTimerStartTime(System.currentTimeMillis());
                gameFragmentBase.updateClock();
                if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    gameFragmentBase.showTurnCounterUI(0);
                }
            }
            getSharedViewModel().getGameState().setTossAlreadyDone(false);
            if (skipTimerAndToss) {
                getSharedViewModel().getGameState().setTossAlreadyDone(true);
            }
            PreferencesManager preferencesManager2 = this.prefs;
            if (preferencesManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager2 = null;
            }
            preferencesManager2.saveCurrentGame(getSharedViewModel().getGameState());
            gameFragmentBase.resetGame();
            if (restartMatch) {
                PreferencesManager preferencesManager3 = this.prefs;
                if (preferencesManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager3 = null;
                }
                GameSet currentSet = preferencesManager3.getCurrentSet();
                if (currentSet != null) {
                    bestOf = currentSet.getBestOf();
                    z = true;
                } else {
                    z = false;
                    bestOf = 1;
                }
                PreferencesManager preferencesManager4 = this.prefs;
                if (preferencesManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager4 = null;
                }
                preferencesManager4.clearCurrentSet();
                if (z) {
                    GameSet gameSet = new GameSet(null, 0, null, 7, null);
                    gameSet.setBestOf(bestOf);
                    PreferencesManager preferencesManager5 = this.prefs;
                    if (preferencesManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    } else {
                        preferencesManager = preferencesManager5;
                    }
                    preferencesManager.saveCurrentSet(gameSet);
                    GameFragmentBase gameFragmentBase4 = this.currentGameFragment;
                    if (gameFragmentBase4 != null) {
                        gameFragmentBase4.showBestOfScore(0, 0);
                    }
                }
            }
            if (deckSelection) {
                getSharedViewModel().getGameState().setUsersSeated(true);
                getSharedViewModel().getGameState().setDecksSelected(false);
                gameFragmentBase.triggerDeckSelection();
            }
        }
        final View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.restartCurrentGame$lambda$1$0(this.f$0, deckSelection, skipTimerAndToss, view);
                }
            }, 350L);
        }
        GameFragmentBase gameFragmentBase5 = this.currentGameFragment;
        if (gameFragmentBase5 != null) {
            if (getSharedViewModel().getGameState().getSubformatId() == 5 || getSharedViewModel().getGameState().getSubformatId() == 6) {
                gameFragmentBase5.setupTeams();
                GameFragmentBase gameFragmentBase6 = this.currentGameFragment;
                if (gameFragmentBase6 != null) {
                    LifeTotalView lifeViewTeam1 = gameFragmentBase6.getLifeViewTeam1();
                    if (lifeViewTeam1 != null) {
                        lifeViewTeam1.hideMonarchCoin();
                    }
                    LifeTotalView lifeViewTeam2 = gameFragmentBase6.getLifeViewTeam2();
                    if (lifeViewTeam2 != null) {
                        lifeViewTeam2.hideMonarchCoin();
                    }
                    LifeTotalView lifeViewTeam12 = gameFragmentBase6.getLifeViewTeam1();
                    if (lifeViewTeam12 != null) {
                        lifeViewTeam12.hideInitiativeCoin();
                    }
                    LifeTotalView lifeViewTeam22 = gameFragmentBase6.getLifeViewTeam2();
                    if (lifeViewTeam22 != null) {
                        lifeViewTeam22.hideInitiativeCoin();
                    }
                    LifeTotalView lifeViewTeam13 = gameFragmentBase6.getLifeViewTeam1();
                    if (lifeViewTeam13 != null) {
                        lifeViewTeam13.hideCityCoin();
                    }
                    LifeTotalView lifeViewTeam23 = gameFragmentBase6.getLifeViewTeam2();
                    if (lifeViewTeam23 != null) {
                        lifeViewTeam23.hideCityCoin();
                    }
                    if (deckSelection) {
                        LifeTotalView lifeViewTeam14 = gameFragmentBase6.getLifeViewTeam1();
                        if (lifeViewTeam14 != null) {
                            lifeViewTeam14.setVisibility(8);
                        }
                        LifeTotalView lifeViewTeam24 = gameFragmentBase6.getLifeViewTeam2();
                        if (lifeViewTeam24 != null) {
                            lifeViewTeam24.setVisibility(8);
                        }
                        int size4 = getSharedViewModel().getGameState().getPlayers().size();
                        for (int i4 = 0; i4 < size4; i4++) {
                            gameFragmentBase6.getLifeViews().get(i4).setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void restartCurrentGame$default(GameFragment gameFragment, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        gameFragment.restartCurrentGame(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartCurrentGame$lambda$1$0(final GameFragment gameFragment, boolean z, boolean z2, View view) {
        if (gameFragment.getContext() == null || gameFragment._binding == null || gameFragment.getChildFragmentManager().isStateSaved()) {
            return;
        }
        if (gameFragment.getSharedViewModel().getGameState().getStreamingEnabled()) {
            gameFragment.initialStreamingDone = false;
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            if (gameFragmentBase != null) {
                gameFragmentBase.updateStreamingState$app_release();
            }
        }
        PreferencesManager preferencesManager = gameFragment.prefs;
        PreferencesManager preferencesManager2 = null;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        boolean z3 = preferencesManager.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true);
        if (gameFragment.getSharedViewModel().getGameState().getSubformatId() == 3 && !z) {
            if (!GameUtils.INSTANCE.getInstance().isLeaderRevealed(gameFragment.getSharedViewModel().getGameState())) {
                gameFragment.showLeaderRevealDialog();
            }
            GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
            if (gameFragmentBase2 != null) {
                gameFragmentBase2.showTreacheryUnknownRoles();
                return;
            }
            return;
        }
        if (z2) {
            z3 = false;
        }
        if (z3 && !z && !gameFragment.getSharedViewModel().getGameState().getTossAlreadyDone() && gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers() > 1) {
            gameFragment.getSharedViewModel().getGameState().setTossAlreadyDone(true);
            PreferencesManager preferencesManager3 = gameFragment.prefs;
            if (preferencesManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager3 = null;
            }
            preferencesManager3.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
            int i = (gameFragment.getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_3 || gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) ? 90 : 270;
            SkinManager companion = SkinManager.INSTANCE.getInstance();
            Context contextRequireContext = gameFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
            PlayerSelectFragment.Builder rotation = new PlayerSelectFragment.Builder().setPlayerTossSkin(currentSkinDefinition != null ? currentSkinDefinition.getCustomPlayerToss() : null).setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.restartCurrentGame$lambda$1$0$2(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setNegativeButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.restartCurrentGame$lambda$1$0$3(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setOnDismissListener(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.restartCurrentGame$lambda$1$0$4(this.f$0, ((Boolean) obj).booleanValue());
                }
            }).setRotation(i);
            GameFragmentBase gameFragmentBase3 = gameFragment.currentGameFragment;
            PlayerSelectFragment.Builder fragmentView = rotation.setFragmentView(gameFragmentBase3 != null ? gameFragmentBase3.getView() : null);
            FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            fragmentView.show(childFragmentManager, "PlayerSelectFragment");
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.restartCurrentGame$lambda$1$0$5(this.f$0);
                }
            }, 250L);
        }
        PreferencesManager preferencesManager4 = gameFragment.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager2 = preferencesManager4;
        }
        if (preferencesManager2.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true) || !gameFragment.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            return;
        }
        int numberOfPlayers = gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i2 = 0; i2 < numberOfPlayers; i2++) {
            GameFragmentBase gameFragmentBase4 = gameFragment.currentGameFragment;
            if (gameFragmentBase4 != null) {
                gameFragmentBase4.getLifeViews().get(i2).triggerPlayerStartQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restartCurrentGame$lambda$1$0$2(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        runPlayerToss$default(gameFragment, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restartCurrentGame$lambda$1$0$3(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restartCurrentGame$lambda$1$0$4(final GameFragment gameFragment, boolean z) {
        if (gameFragment.getContext() == null || gameFragment._binding == null) {
            return Unit.INSTANCE;
        }
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
            if (z) {
                gameFragmentBase.playerTossSkipped();
            }
            View view = gameFragmentBase.getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda53
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragment.restartCurrentGame$lambda$1$0$4$0$0(this.f$0);
                    }
                }, 10000L);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartCurrentGame$lambda$1$0$4$0$0(GameFragment gameFragment) {
        FragmentActivity activity = gameFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.checkForLowBattery();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartCurrentGame$lambda$1$0$5(GameFragment gameFragment) {
        GameFragmentBase gameFragmentBase;
        if (gameFragment.getContext() == null || gameFragment._binding == null || (gameFragmentBase = gameFragment.currentGameFragment) == null) {
            return;
        }
        gameFragmentBase.runPlayerTossIntroLoop();
    }

    private final void runPlayerToss(boolean gameStart) {
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.runPlayerToss(gameStart);
        }
    }

    static /* synthetic */ void runPlayerToss$default(GameFragment gameFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        gameFragment.runPlayerToss(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void saveCurrentQuickGame() {
        int durationSeconds;
        boolean z;
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getPlaygroupId() != -1) {
            return;
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        int id = currentUser != null ? currentUser.getId() : -1;
        GameSet currentSet = preferencesManager.getCurrentSet();
        if (currentSet != null) {
            if (currentSet.getFinishedGames().isEmpty()) {
                return;
            }
            int size = currentSet.getFinishedGames().size();
            int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet);
            int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet);
            if (currentSet.getBestOf() == 3) {
                if (size < 3 && playerScore < 2 && playerScore2 < 2) {
                    return;
                }
            } else {
                if (currentSet.getBestOf() < 5) {
                    return;
                }
                if (size < 5 && playerScore < 3 && playerScore2 < 3) {
                    return;
                }
            }
            MTCreateSet mTCreateSet = new MTCreateSet(0, null, 3, null);
            mTCreateSet.setBestof(currentSet.getBestOf());
            Iterator<GameState> it = currentSet.getFinishedGames().iterator();
            while (it.hasNext()) {
                mTCreateSet.getGames().add(GameUtils.INSTANCE.getInstance().createMTGameForUpload(it.next(), id));
            }
            if (id == -1) {
                MTApiKt.getMtApi().createSetUnlogged(mTCreateSet).enqueue(new Callback<MTCreateSetResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment$saveCurrentQuickGame$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCreateSetResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCreateSetResponse> call, Response<MTCreateSetResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                    }
                });
                return;
            } else {
                MTApiKt.getMtApi().createSet(id, mTCreateSet).enqueue(new Callback<MTCreateSetResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment$saveCurrentQuickGame$1$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCreateSetResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCreateSetResponse> call, Response<MTCreateSetResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                    }
                });
                return;
            }
        }
        if (GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState()).isEmpty()) {
            List<MTGameEvent> events = getSharedViewModel().getGameState().getEvents();
            if ((events instanceof Collection) && events.isEmpty()) {
                z = false;
                if (!z) {
                }
            } else {
                Iterator<T> it2 = events.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((MTGameEvent) it2.next()).getType(), MTEvent.GameDraw.getValue())) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    return;
                }
            }
        }
        MTCreateGame mTCreateGameCreateMTGameForUpload = GameUtils.INSTANCE.getInstance().createMTGameForUpload(getSharedViewModel().getGameState(), id);
        if (mTCreateGameCreateMTGameForUpload.getStarted_at().length() <= 0) {
            durationSeconds = 300;
        } else {
            if (mTCreateGameCreateMTGameForUpload.getEnded_at().length() > 0) {
                ServerUtils companion = ServerUtils.INSTANCE.getInstance();
                String started_at = mTCreateGameCreateMTGameForUpload.getStarted_at();
                String ended_at = mTCreateGameCreateMTGameForUpload.getEnded_at();
                Integer pausetime = mTCreateGameCreateMTGameForUpload.getPausetime();
                durationSeconds = companion.getDurationSeconds(started_at, ended_at, pausetime != null ? pausetime.intValue() : 0);
            }
        }
        if (durationSeconds <= 60 || getSharedViewModel().getGameState().getEvents().size() < 5) {
            return;
        }
        if (id == -1) {
            MTApiKt.getMtApi().createGameUnlogged(mTCreateGameCreateMTGameForUpload).enqueue(new Callback<MTCreateGameResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment$saveCurrentQuickGame$2$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCreateGameResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCreateGameResponse> call, Response<MTCreateGameResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                }
            });
        } else {
            MTApiKt.getMtApi().createGame(id, mTCreateGameCreateMTGameForUpload).enqueue(new Callback<MTCreateGameResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment$saveCurrentQuickGame$2$3
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCreateGameResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCreateGameResponse> call, Response<MTCreateGameResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                }
            });
        }
    }

    private final void setupForTutorial() {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("setup_tutorial");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("setup_tutorial", null);
        View view = getView();
        final ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.tutorial_overlay) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        TextView textView = constraintLayout != null ? (TextView) constraintLayout.findViewById(R.id.skip_text) : null;
        if (textView != null) {
            ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.setupForTutorial$lambda$0(this.f$0, constraintLayout);
                }
            });
        }
        MaterialButton materialButton = constraintLayout != null ? (MaterialButton) constraintLayout.findViewById(R.id.lets_go_button) : null;
        if (materialButton != null) {
            ViewExtensionsKt.setOnClickWithBounce(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.setupForTutorial$lambda$1(this.f$0, constraintLayout);
                }
            });
        }
    }

    static final Unit setupForTutorial$lambda$0(GameFragment gameFragment, final ConstraintLayout constraintLayout) {
        if (gameFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment.isTutorial = false;
        Breadcrumbs.INSTANCE.leaveBreadcrumb("tutorial_skipped");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("tutorial_skipped", null);
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_TUTORIAL_SHOWN, true);
        PreferencesManager preferencesManager2 = gameFragment.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager2, null, 1, null);
        PreferencesManager preferencesManager3 = gameFragment.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        preferencesManager3.clearCurrentGame();
        PreferencesManager preferencesManager4 = gameFragment.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager4 = null;
        }
        preferencesManager4.clearGameSelectedDecks();
        gameFragment.setupPlainNewGame();
        gameFragment.getSharedViewModel().getGameState().setGameSyncable(false);
        gameFragment.fullscreen = false;
        FragmentActivity activity = gameFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.setFullscreenMode(false);
        }
        FragmentActivity activity2 = gameFragment.getActivity();
        MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
        if (mainActivity2 != null) {
            mainActivity2.setStatusBarFullscreen(false);
        }
        PreferencesManager preferencesManager5 = gameFragment.prefs;
        if (preferencesManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager5 = null;
        }
        if (preferencesManager5.hasValidUser()) {
            PreferencesManager preferencesManager6 = gameFragment.prefs;
            if (preferencesManager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager6 = null;
            }
            preferencesManager6.clearAllUsersDecks();
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            if (gameFragmentBase != null) {
                FragmentTransaction fragmentTransactionBeginTransaction = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                fragmentTransactionBeginTransaction.remove(gameFragmentBase).commit();
            }
            gameFragment.currentGameFragment = null;
            NewGameFragment newGameFragmentNewInstance = NewGameFragment.INSTANCE.newInstance();
            gameFragment.newGameFragment = newGameFragmentNewInstance;
            if (newGameFragmentNewInstance != null) {
                FragmentTransaction fragmentTransactionBeginTransaction2 = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, newGameFragmentNewInstance);
                fragmentTransactionBeginTransaction2.commit();
            }
            gameFragment.getBinding().fragmentContainer.setVisibility(0);
            gameFragment.getBinding().toolbar.setVisibility(8);
            gameFragment.getBinding().viewPager.setVisibility(8);
        } else {
            FragmentContainerView fragmentContainer = gameFragment.getBinding().fragmentContainer;
            Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
            Toolbar toolbar = gameFragment.getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setVisibility(0);
            gameFragment.getBinding().viewPager.setCurrentItem(0);
            FragmentActivity activity3 = gameFragment.getActivity();
            if (activity3 instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity3;
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayOptions(0, 2);
                }
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setTitle(gameFragment.getString(R.string.title_playgroup_format));
                }
                ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setDisplayHomeAsUpEnabled(false);
                }
            }
            gameFragment.getBinding().viewPager.setVisibility(0);
            fragmentContainer.setVisibility(8);
            GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
            if (gameFragmentBase2 != null) {
                FragmentTransaction fragmentTransactionBeginTransaction3 = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction3, "beginTransaction(...)");
                fragmentTransactionBeginTransaction3.remove(gameFragmentBase2).commit();
            }
            gameFragment.currentGameFragment = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(450L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$setupForTutorial$1$4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        objectAnimatorOfFloat.start();
        return Unit.INSTANCE;
    }

    static final Unit setupForTutorial$lambda$1(final GameFragment gameFragment, final ConstraintLayout constraintLayout) {
        if (gameFragment.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragment.tutorialButtonDisabled = true;
        gameFragment.getBinding().fadeInOverlay.setVisibility(0);
        gameFragment.getBinding().fadeInOverlay.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gameFragment.getBinding().fadeInOverlay, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.start();
        View view = gameFragment.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.setupForTutorial$lambda$1$0(constraintLayout, gameFragment);
                }
            }, 750L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupForTutorial$lambda$1$0(ConstraintLayout constraintLayout, final GameFragment gameFragment) {
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.startTutorialAnimations();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gameFragment.getBinding().fadeInOverlay, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$setupForTutorial$2$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getBinding().fadeInOverlay.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        objectAnimatorOfFloat.start();
    }

    private final void setupPlainNewGame() {
        this.gamePlayerResultsMode = false;
        getSharedViewModel().setGameState(new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0L, 0L, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0L, 0, false, false, 0, 0, 0L, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null));
        getSharedViewModel().getGameState().setTossAlreadyDone(false);
        getSharedViewModel().getFormatId().setValue(-1);
        getSharedViewModel().getSubFormatId().setValue(-1);
        getSharedViewModel().getPlaygroupId().setValue(-1);
        getSharedViewModel().getLifeTotal().setValue(-1);
        getSharedViewModel().getNumberOfPlayers().setValue(0);
        getSharedViewModel().getGameState().setTimerStartTime(0L);
        getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        PreferencesManager preferencesManager = this.prefs;
        PreferencesManager preferencesManager2 = null;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        if (preferencesManager.getBoolean(PreferencesManager.ENABLE_POISON_COUNTERS_BY_DEFAULT, false)) {
            getSharedViewModel().getGameState().setHasPoisonCounters(true);
        }
        PreferencesManager preferencesManager3 = this.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager2 = preferencesManager3;
        }
        preferencesManager2.clearCurrentUserCache();
    }

    private final void showAnimatedGameLabel(int gameNumber) {
        View view;
        if (getContext() == null || this._binding == null || (view = getView()) == null) {
            return;
        }
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.overlay_container);
        if (getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_1) {
            final TextView textView = new TextView(requireContext());
            String string = textView.getResources().getString(R.string.game_label);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(gameNumber), false, 4, (Object) null));
            textView.setTextSize(32.0f);
            textView.setTextColor(Color.parseColor("#FFCDCDCD"));
            textView.setGravity(17);
            textView.setTypeface(textView.getResources().getFont(R.font.be_vietnam_pro_semibold));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setRotation(-3.0f);
            textView.setAlpha(0.0f);
            frameLayout.addView(textView);
            final View view2 = new View(requireContext());
            view2.setBackgroundColor(Color.parseColor("#FF000000"));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, companion.dpToPx(80, contextRequireContext));
            layoutParams2.gravity = 17;
            view2.setLayoutParams(layoutParams2);
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
            view2.setTranslationY(companion2.dpToPx(8, r11));
            view2.setTranslationX(-5000.0f);
            view2.setRotation(-3.0f);
            frameLayout.addView(view2, 0);
            final View view3 = new View(requireContext());
            view3.setBackgroundColor(Color.parseColor("#FFCDCDCD"));
            GameUtils companion3 = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, companion3.dpToPx(90, contextRequireContext2));
            layoutParams3.gravity = 17;
            view3.setLayoutParams(layoutParams3);
            GameUtils companion4 = GameUtils.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
            view3.setTranslationY(companion4.dpToPx(8, r9));
            view3.setTranslationX(5000.0f);
            view3.setRotation(-3.0f);
            frameLayout.addView(view3, 0);
            final View view4 = new View(requireContext());
            view4.setBackgroundColor(Color.parseColor("#88000000"));
            view4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            view4.setAlpha(0.0f);
            frameLayout.addView(view4, 0);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view4, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(250L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat2.setDuration(250L);
            objectAnimatorOfFloat2.setStartDelay(500L);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view3, "translationX", 5000.0f, 0.0f);
            objectAnimatorOfFloat3.setDuration(250L);
            objectAnimatorOfFloat3.setStartDelay(250L);
            objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationX", -5000.0f, 0.0f);
            objectAnimatorOfFloat4.setDuration(250L);
            objectAnimatorOfFloat4.setStartDelay(250L);
            objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(textView, "translationY", 0.0f, -200.0f);
            objectAnimatorOfFloat5.setDuration(200L);
            objectAnimatorOfFloat5.setStartDelay(800L);
            objectAnimatorOfFloat5.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(textView, "translationY", -200.0f, 5000.0f);
            objectAnimatorOfFloat6.setDuration(350L);
            objectAnimatorOfFloat6.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, -200.0f);
            objectAnimatorOfFloat7.setDuration(250L);
            objectAnimatorOfFloat7.setStartDelay(800L);
            objectAnimatorOfFloat7.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view2, "translationY", -200.0f, 5000.0f);
            objectAnimatorOfFloat8.setDuration(350L);
            objectAnimatorOfFloat8.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(view3, "translationY", 0.0f, -200.0f);
            objectAnimatorOfFloat9.setDuration(250L);
            objectAnimatorOfFloat9.setStartDelay(800L);
            objectAnimatorOfFloat9.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(view3, "translationY", -200.0f, 5000.0f);
            objectAnimatorOfFloat10.setDuration(350L);
            objectAnimatorOfFloat10.setInterpolator(new AccelerateInterpolator());
            AnimatorSet animatorSet2 = new AnimatorSet();
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat9);
            Unit unit = Unit.INSTANCE;
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.playTogether(objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat10);
            Unit unit2 = Unit.INSTANCE;
            animatorSet2.playSequentially(animatorSet3, animatorSet4);
            AnimatorSet animatorSet5 = new AnimatorSet();
            animatorSet5.playSequentially(animatorSet, animatorSet2);
            animatorSet5.start();
            animatorSet5.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$showAnimatedGameLabel$1$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    frameLayout.removeView(textView);
                    frameLayout.removeView(view2);
                    frameLayout.removeView(view3);
                    ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(view4, "alpha", 1.0f, 0.0f);
                    final FrameLayout frameLayout2 = frameLayout;
                    final View view5 = view4;
                    objectAnimatorOfFloat11.setDuration(150L);
                    objectAnimatorOfFloat11.setInterpolator(new AccelerateInterpolator());
                    objectAnimatorOfFloat11.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$showAnimatedGameLabel$1$1$1$onAnimationEnd$1$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator p02) {
                            Intrinsics.checkNotNullParameter(p02, "p0");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator p02) {
                            Intrinsics.checkNotNullParameter(p02, "p0");
                            frameLayout2.removeView(view5);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator p02) {
                            Intrinsics.checkNotNullParameter(p02, "p0");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator p02) {
                            Intrinsics.checkNotNullParameter(p02, "p0");
                        }
                    });
                    objectAnimatorOfFloat11.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }
            });
            return;
        }
        final TextView textView2 = new TextView(requireContext());
        String string2 = textView2.getResources().getString(R.string.game_label);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        textView2.setText(StringsKt.replace$default(string2, "{1}", String.valueOf(gameNumber), false, 4, (Object) null));
        textView2.setTextSize(32.0f);
        textView2.setTextColor(Color.parseColor("#FFCDCDCD"));
        textView2.setGravity(17);
        textView2.setTypeface(textView2.getResources().getFont(R.font.be_vietnam_pro_semibold));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        textView2.setLayoutParams(layoutParams4);
        textView2.setRotation(87.0f);
        textView2.setAlpha(0.0f);
        frameLayout.addView(textView2);
        final View view5 = new View(requireContext());
        view5.setBackgroundColor(Color.parseColor("#FF000000"));
        GameUtils companion5 = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(companion5.dpToPx(80, contextRequireContext3), -1);
        layoutParams5.gravity = 17;
        view5.setLayoutParams(layoutParams5);
        GameUtils companion6 = GameUtils.INSTANCE.getInstance();
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        view5.setTranslationX(-companion6.dpToPx(8, r12));
        view5.setTranslationY(-5000.0f);
        view5.setRotation(-3.0f);
        frameLayout.addView(view5, 0);
        final View view6 = new View(requireContext());
        view6.setBackgroundColor(Color.parseColor("#FFCDCDCD"));
        GameUtils companion7 = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(companion7.dpToPx(90, contextRequireContext4), -1);
        layoutParams6.gravity = 17;
        view6.setLayoutParams(layoutParams6);
        GameUtils companion8 = GameUtils.INSTANCE.getInstance();
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        view6.setTranslationX(-companion8.dpToPx(8, r9));
        view6.setTranslationY(5000.0f);
        view6.setRotation(-3.0f);
        frameLayout.addView(view6, 0);
        final View view7 = new View(requireContext());
        view7.setBackgroundColor(Color.parseColor("#88000000"));
        view7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view7.setAlpha(0.0f);
        frameLayout.addView(view7, 0);
        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(view7, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat11.setDuration(250L);
        objectAnimatorOfFloat11.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(textView2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat12.setDuration(250L);
        objectAnimatorOfFloat12.setStartDelay(500L);
        objectAnimatorOfFloat12.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat13 = ObjectAnimator.ofFloat(view6, "translationY", 5000.0f, 0.0f);
        objectAnimatorOfFloat13.setDuration(250L);
        objectAnimatorOfFloat13.setStartDelay(250L);
        objectAnimatorOfFloat13.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat14 = ObjectAnimator.ofFloat(view5, "translationY", -5000.0f, 0.0f);
        objectAnimatorOfFloat14.setDuration(250L);
        objectAnimatorOfFloat14.setStartDelay(250L);
        objectAnimatorOfFloat14.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playTogether(objectAnimatorOfFloat11, objectAnimatorOfFloat12, objectAnimatorOfFloat13, objectAnimatorOfFloat14);
        ObjectAnimator objectAnimatorOfFloat15 = ObjectAnimator.ofFloat(textView2, "translationX", 0.0f, 200.0f);
        objectAnimatorOfFloat15.setDuration(200L);
        objectAnimatorOfFloat15.setStartDelay(800L);
        objectAnimatorOfFloat15.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat16 = ObjectAnimator.ofFloat(textView2, "translationX", 200.0f, -5000.0f);
        objectAnimatorOfFloat16.setDuration(350L);
        objectAnimatorOfFloat16.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat17 = ObjectAnimator.ofFloat(view5, "translationX", 0.0f, 200.0f);
        objectAnimatorOfFloat17.setDuration(250L);
        objectAnimatorOfFloat17.setStartDelay(800L);
        objectAnimatorOfFloat17.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat18 = ObjectAnimator.ofFloat(view5, "translationX", 200.0f, -5000.0f);
        objectAnimatorOfFloat18.setDuration(350L);
        objectAnimatorOfFloat18.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat19 = ObjectAnimator.ofFloat(view6, "translationX", 0.0f, 200.0f);
        objectAnimatorOfFloat19.setDuration(250L);
        objectAnimatorOfFloat19.setStartDelay(800L);
        objectAnimatorOfFloat19.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat20 = ObjectAnimator.ofFloat(view6, "translationX", 200.0f, -5000.0f);
        objectAnimatorOfFloat20.setDuration(350L);
        objectAnimatorOfFloat20.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet7 = new AnimatorSet();
        AnimatorSet animatorSet8 = new AnimatorSet();
        animatorSet8.playTogether(objectAnimatorOfFloat15, objectAnimatorOfFloat17, objectAnimatorOfFloat19);
        Unit unit3 = Unit.INSTANCE;
        AnimatorSet animatorSet9 = new AnimatorSet();
        animatorSet9.playTogether(objectAnimatorOfFloat16, objectAnimatorOfFloat18, objectAnimatorOfFloat20);
        Unit unit4 = Unit.INSTANCE;
        animatorSet7.playSequentially(animatorSet8, animatorSet9);
        AnimatorSet animatorSet10 = new AnimatorSet();
        animatorSet10.playSequentially(animatorSet6, animatorSet7);
        animatorSet10.start();
        animatorSet10.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$showAnimatedGameLabel$1$2$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                frameLayout.removeView(textView2);
                frameLayout.removeView(view5);
                frameLayout.removeView(view6);
                ObjectAnimator objectAnimatorOfFloat21 = ObjectAnimator.ofFloat(view7, "alpha", 1.0f, 0.0f);
                final FrameLayout frameLayout2 = frameLayout;
                final View view8 = view7;
                objectAnimatorOfFloat21.setDuration(150L);
                objectAnimatorOfFloat21.setInterpolator(new AccelerateInterpolator());
                objectAnimatorOfFloat21.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$showAnimatedGameLabel$1$2$1$onAnimationEnd$1$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator p02) {
                        Intrinsics.checkNotNullParameter(p02, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator p02) {
                        Intrinsics.checkNotNullParameter(p02, "p0");
                        frameLayout2.removeView(view8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator p02) {
                        Intrinsics.checkNotNullParameter(p02, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator p02) {
                        Intrinsics.checkNotNullParameter(p02, "p0");
                    }
                });
                objectAnimatorOfFloat21.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }
        });
    }

    private final void showLeaderRevealDialog() {
        if (getContext() == null) {
            return;
        }
        ConstraintLayout leaderSelectLayout = getBinding().leaderSelectLayout;
        Intrinsics.checkNotNullExpressionValue(leaderSelectLayout, "leaderSelectLayout");
        leaderSelectLayout.setVisibility(0);
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.showTreacheryUnknownRoles();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGamePressed$lambda$0$0$0(GameFragment gameFragment) {
        if (gameFragment.getContext() == null || gameFragment.currentGameFragment == null) {
            return;
        }
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.ENABLE_FULLSCREEN_MODE, true)) {
            FragmentActivity activity = gameFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity == null || ((BottomNavigationView) mainActivity.findViewById(R.id.bottom_navigation)).getSelectedItemId() == R.id.navigation_game) {
                if (!gameFragment.getSharedViewModel().getGameState().getGameSyncable() || gameFragment.getSharedViewModel().getGameState().getUsersSeated()) {
                    if ((!gameFragment.getSharedViewModel().getGameState().getGameSyncable() || gameFragment.getSharedViewModel().getGameState().getDecksSelected()) && !gameFragment.fullscreen) {
                        gameFragment.fullscreen = true;
                        FragmentActivity activity2 = gameFragment.getActivity();
                        MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
                        if (mainActivity2 != null) {
                            mainActivity2.setFullscreenMode(true);
                        }
                        FragmentActivity activity3 = gameFragment.getActivity();
                        MainActivity mainActivity3 = activity3 instanceof MainActivity ? (MainActivity) activity3 : null;
                        if (mainActivity3 != null) {
                            mainActivity3.setStatusBarFullscreen(true);
                        }
                    }
                }
            }
        }
    }

    static final void startGamePressed$lambda$6(final GameFragment gameFragment) {
        if (gameFragment.getContext() == null) {
            return;
        }
        gameFragment.getSharedViewModel().getGameState().setTossAlreadyDone(true);
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
        if (gameFragment.isAdded() && !gameFragment.isRemoving() && !gameFragment.getChildFragmentManager().isStateSaved()) {
            int i = (gameFragment.getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_3 || gameFragment.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) ? 90 : 270;
            SkinManager companion = SkinManager.INSTANCE.getInstance();
            Context contextRequireContext = gameFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
            PlayerSelectFragment.Builder onDismissListener = new PlayerSelectFragment.Builder().setPlayerTossSkin(currentSkinDefinition != null ? currentSkinDefinition.getCustomPlayerToss() : null).setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.startGamePressed$lambda$6$1(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setNegativeButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.startGamePressed$lambda$6$2(this.f$0, (PlayerSelectFragment) obj);
                }
            }).setOnDismissListener(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.startGamePressed$lambda$6$3(this.f$0, ((Boolean) obj).booleanValue());
                }
            });
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            PlayerSelectFragment.Builder rotation = onDismissListener.setFragmentView(gameFragmentBase != null ? gameFragmentBase.getView() : null).setRotation(i);
            FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "PlayerSelectFragment");
        }
        GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
        if (gameFragmentBase2 == null || gameFragment.getContext() == null) {
            return;
        }
        gameFragmentBase2.runPlayerTossIntroLoop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startGamePressed$lambda$6$1(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        runPlayerToss$default(gameFragment, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startGamePressed$lambda$6$2(GameFragment gameFragment, PlayerSelectFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startGamePressed$lambda$6$3(final GameFragment gameFragment, boolean z) {
        GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.stopPlayerTossIntroLoop();
            if (z) {
                gameFragmentBase.playerTossSkipped();
            }
            View view = gameFragmentBase.getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragment.startGamePressed$lambda$6$3$0$0(this.f$0);
                    }
                }, 10000L);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGamePressed$lambda$6$3$0$0(GameFragment gameFragment) {
        FragmentActivity activity = gameFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.checkForLowBattery();
        }
    }

    private final void startTutorial() {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("start_tutorial");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        PreferencesManager preferencesManager = null;
        firebaseAnalytics.logEvent("start_tutorial", null);
        getSharedViewModel().setGameState(new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0L, 0L, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0L, 0, false, false, 0, 0, 0L, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null));
        getSharedViewModel().getGameState().setNumberOfPlayers(4);
        getSharedViewModel().getGameState().setStartingLifeTotal(40);
        int i = 0;
        while (i < 4) {
            Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            i++;
            player.setName(getResources().getString(R.string.player) + " " + i);
            ArrayList arrayList = new ArrayList(4);
            for (int i2 = 0; i2 < 4; i2++) {
                arrayList.add(0);
            }
            player.setCommanderDamageList(arrayList);
            ArrayList arrayList2 = new ArrayList(4);
            for (int i3 = 0; i3 < 4; i3++) {
                arrayList2.add(0);
            }
            player.setCommanderDamageListPartner(arrayList2);
            getSharedViewModel().getGameState().getPlayers().add(player);
        }
        getSharedViewModel().getGameState().setHasCommanderDamage(true);
        getSharedViewModel().getGameState().setLayoutType(LayoutType.TYPE_2);
        getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        GameFragment4PlayersType2 gameFragment4PlayersType2NewInstance = GameFragment4PlayersType2.INSTANCE.newInstance();
        gameFragment4PlayersType2NewInstance.setTutorialMode(true);
        this.currentGameFragment = gameFragment4PlayersType2NewInstance;
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager = preferencesManager2;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        toolbar.setVisibility(8);
        getBinding().viewPager.setVisibility(8);
        fragmentContainer.setVisibility(0);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, gameFragment4PlayersType2NewInstance);
        fragmentTransactionBeginTransaction.commit();
    }

    private final void syncCurrentGame(final boolean restart, boolean forceUpload, boolean playAgain) {
        MTUser currentUser;
        int durationSeconds;
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!preferencesManager.hasValidUser() || (currentUser = preferencesManager.getCurrentUser()) == null) {
            return;
        }
        GameSet currentSet = preferencesManager.getCurrentSet();
        if (currentSet != null) {
            if (!currentSet.getFinishedGames().isEmpty()) {
                MTCreateSet mTCreateSet = new MTCreateSet(0, null, 3, null);
                mTCreateSet.setBestof(currentSet.getBestOf());
                Iterator<GameState> it = currentSet.getFinishedGames().iterator();
                while (it.hasNext()) {
                    mTCreateSet.getGames().add(GameUtils.INSTANCE.getInstance().createMTGameForUpload(it.next(), currentUser.getId()));
                }
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("save_set", null);
                getBinding().loadingOverlay.setVisibility(0);
                MTApiKt.getMtApi().createSet(currentUser.getId(), mTCreateSet).enqueue(new GameFragment$syncCurrentGame$1$1$2(this, preferencesManager, restart, playAgain));
                return;
            }
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("error_save_set_empty", null);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.server_error_body_game);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment.syncCurrentGame$lambda$0$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            return;
        }
        MTCreateGame mTCreateGameCreateMTGameForUpload = GameUtils.INSTANCE.getInstance().createMTGameForUpload(getSharedViewModel().getGameState(), currentUser.getId());
        Log.d("SyncCurrentGame", "About to save game: " + mTCreateGameCreateMTGameForUpload);
        Log.d("SyncCurrentGame", "--> players: " + mTCreateGameCreateMTGameForUpload.getPlayers());
        if (mTCreateGameCreateMTGameForUpload.getStarted_at().length() <= 0 || mTCreateGameCreateMTGameForUpload.getEnded_at().length() <= 0) {
            durationSeconds = 300;
        } else {
            ServerUtils companion = ServerUtils.INSTANCE.getInstance();
            String started_at = mTCreateGameCreateMTGameForUpload.getStarted_at();
            String ended_at = mTCreateGameCreateMTGameForUpload.getEnded_at();
            Integer pausetime = mTCreateGameCreateMTGameForUpload.getPausetime();
            durationSeconds = companion.getDurationSeconds(started_at, ended_at, pausetime != null ? pausetime.intValue() : 0);
        }
        if (forceUpload || durationSeconds > 60 || mTCreateGameCreateMTGameForUpload.getEvents().size() > 5) {
            FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
            firebaseAnalytics3.logEvent("save_game", null);
            getBinding().loadingOverlay.setVisibility(0);
            MTApiKt.getMtApi().createGame(currentUser.getId(), mTCreateGameCreateMTGameForUpload).enqueue(new GameFragment$syncCurrentGame$1$2$3(this, preferencesManager, restart, this, playAgain));
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = getString(R.string.game_too_short_title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = getString(R.string.game_too_short_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title2.setBody(string5).setPositiveButtonRed();
        String string6 = getString(R.string.upload_anyway);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragment.syncCurrentGame$lambda$0$1$0(this.f$0, restart, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string7 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton2.setNegativeButton(string7, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment.syncCurrentGame$lambda$0$1$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager2, "mtapi_error_dialog");
    }

    static /* synthetic */ void syncCurrentGame$default(GameFragment gameFragment, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        gameFragment.syncCurrentGame(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncCurrentGame$lambda$0$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncCurrentGame$lambda$0$1$0(GameFragment gameFragment, boolean z, boolean z2, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        syncCurrentGame$default(gameFragment, z, true, false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncCurrentGame$lambda$0$1$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final boolean turnTimersEnabledValueChanged$lambda$6(MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) || Intrinsics.areEqual(it.getType(), MTEvent.TurnEnd.getValue());
    }

    static final void tutorialComplete$lambda$0(final ConstraintLayout constraintLayout, final GameFragment gameFragment) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        MaterialButton materialButton = constraintLayout != null ? (MaterialButton) constraintLayout.findViewById(R.id.lets_go_button) : null;
        if (materialButton != null) {
            materialButton.setText(gameFragment.getResources().getString(R.string.lets_go_new_game));
        }
        if (materialButton != null) {
            ViewExtensionsKt.setOnClickWithBounce(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.tutorialComplete$lambda$0$0(this.f$0, constraintLayout);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tutorialComplete$lambda$0$0(GameFragment gameFragment, final ConstraintLayout constraintLayout) {
        if (gameFragment.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragment.tutorialButtonDisabled = true;
        if (gameFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        PreferencesManager preferencesManager = gameFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.clearCurrentGame();
        PreferencesManager preferencesManager2 = gameFragment.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        preferencesManager2.clearGameSelectedDecks();
        gameFragment.setupPlainNewGame();
        gameFragment.getSharedViewModel().getGameState().setGameSyncable(false);
        PreferencesManager preferencesManager3 = gameFragment.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        if (preferencesManager3.hasValidUser()) {
            PreferencesManager preferencesManager4 = gameFragment.prefs;
            if (preferencesManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager4 = null;
            }
            preferencesManager4.clearAllUsersDecks();
            GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
            if (gameFragmentBase != null) {
                FragmentTransaction fragmentTransactionBeginTransaction = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                fragmentTransactionBeginTransaction.remove(gameFragmentBase).commit();
            }
            gameFragment.currentGameFragment = null;
            NewGameFragment newGameFragmentNewInstance = NewGameFragment.INSTANCE.newInstance();
            gameFragment.newGameFragment = newGameFragmentNewInstance;
            if (newGameFragmentNewInstance != null) {
                FragmentTransaction fragmentTransactionBeginTransaction2 = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, newGameFragmentNewInstance);
                fragmentTransactionBeginTransaction2.commit();
            }
            gameFragment.getBinding().fragmentContainer.setVisibility(0);
            gameFragment.getBinding().toolbar.setVisibility(8);
            gameFragment.getBinding().viewPager.setVisibility(8);
        } else {
            FragmentContainerView fragmentContainer = gameFragment.getBinding().fragmentContainer;
            Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
            Toolbar toolbar = gameFragment.getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setVisibility(0);
            gameFragment.getBinding().viewPager.setCurrentItem(0);
            FragmentActivity activity = gameFragment.getActivity();
            if (activity instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayOptions(0, 2);
                }
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setTitle(gameFragment.getString(R.string.title_playgroup_format));
                }
                ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setDisplayHomeAsUpEnabled(false);
                }
            }
            gameFragment.getBinding().viewPager.setVisibility(0);
            fragmentContainer.setVisibility(8);
            GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
            if (gameFragmentBase2 != null) {
                FragmentTransaction fragmentTransactionBeginTransaction3 = gameFragment.getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction3, "beginTransaction(...)");
                fragmentTransactionBeginTransaction3.remove(gameFragmentBase2).commit();
            }
            gameFragment.currentGameFragment = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(450L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$tutorialComplete$1$1$4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        objectAnimatorOfFloat.start();
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void archenemyValueChanged(boolean value) {
        if (getContext() == null) {
            return;
        }
        getSharedViewModel().getGameState().setHasArchenemy(value);
        if (getSharedViewModel().getGameState().getHasArchenemy()) {
            getSharedViewModel().getGameState().setHasPlanechase(false);
        }
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enableArchenemy(value);
        }
        if (value) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            getSharedViewModel().getGameState().setArchenemySeed(companion.ensureSchemeDeck(contextRequireContext, getSharedViewModel().getGameState()));
        }
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void batterySavingModeChanged(boolean value) {
        MainActivity mainActivity;
        if (value) {
            FragmentActivity activity = getActivity();
            mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.enableBatterySavings();
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        mainActivity = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
        if (mainActivity != null) {
            mainActivity.disableBatterySavings();
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void cityCoinDragged() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("city_coin_dragged");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("city_coin_dragged", null);
        closeMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void commanderDamageValueChanged(boolean value) {
        getSharedViewModel().getGameState().setHasCommanderDamage(value);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enableCommanderDamage(value);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void dayNightValueChanged(boolean value) {
        List<MTGameEvent> events = getSharedViewModel().getGameState().getEvents();
        boolean z = false;
        if (!(events instanceof Collection) || !events.isEmpty()) {
            Iterator<T> it = events.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((MTGameEvent) it.next()).getType(), MTEvent.Day.getValue())) {
                    z = true;
                    break;
                }
            }
        }
        if (value && !z) {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Day.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
        getSharedViewModel().getGameState().setHasDayNight(value);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enableDayNight(value);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void diceTapped() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("dice_tapped");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("dice_tapped", null);
        closeMenu();
        new DiceDialogFragment.Builder().setOnTossListener(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment.diceTapped$lambda$0(this.f$0);
            }
        }).build().show(getChildFragmentManager(), "DiceDialogFragment");
    }

    public final void disableBatterySaving() {
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.disableBatterySaving();
        }
    }

    public final void enableBatterySaving() {
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enableBatterySaving();
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment.PlaygroupFormatSetupCallback
    public void formatSelected(int formatId, int subformatId) {
        PreferencesManager preferencesManager;
        Object next;
        ActionBar supportActionBar;
        int iIntValue;
        if (getContext() == null || this._binding == null) {
            return;
        }
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Iterator<T> it = companion.getInstance(contextRequireContext).getFormats().iterator();
        while (true) {
            preferencesManager = null;
            if (it.hasNext()) {
                next = it.next();
                if (((MTFormat) next).getId() == formatId) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat != null) {
            int lifetotal = mTFormat.getLifetotal();
            Integer value = getSharedViewModel().getLifeTotal().getValue();
            if (value != null && (iIntValue = value.intValue()) != -1) {
                lifetotal = iIntValue;
            }
            getSharedViewModel().getGameState().setFormatId(mTFormat.getId());
            getSharedViewModel().getGameState().setSubformatId(subformatId);
            getSharedViewModel().getGameState().setStartingLifeTotal(lifetotal);
            getSharedViewModel().getGameState().setHasCommanderDamage(mTFormat.getCommanderdamages() > 0);
            for (Player player : getSharedViewModel().getGameState().getPlayers()) {
                player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            }
            FragmentActivity activity = getActivity();
            if (activity instanceof AppCompatActivity) {
                if (this.gameFromPlaygroup) {
                    ActionBar supportActionBar2 = ((AppCompatActivity) activity).getSupportActionBar();
                    if (supportActionBar2 != null) {
                        supportActionBar2.setTitle(getString(R.string.title_layout));
                    }
                } else if (this.gameSyncable && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                    supportActionBar.setTitle(getString(R.string.title_players));
                }
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setDisplayOptions(2, 2);
                }
                ActionBar supportActionBar4 = appCompatActivity.getSupportActionBar();
                if (supportActionBar4 != null) {
                    supportActionBar4.setDisplayHomeAsUpEnabled(true);
                }
            }
            if (subformatId != 5 && subformatId != 6) {
                ViewPager2 viewPager2 = getBinding().viewPager;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                if (!this.gameFromPlaygroup && mTFormat.getPlayersmin() == 2 && mTFormat.getPlayersmax() == 2) {
                    getSharedViewModel().getNumberOfPlayers().setValue(2);
                    playersSelected(2);
                    PreferencesManager preferencesManager2 = this.prefs;
                    if (preferencesManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    } else {
                        preferencesManager = preferencesManager2;
                    }
                    preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    return;
                }
                return;
            }
            if (subformatId == 5) {
                getSharedViewModel().getNumberOfPlayers().setValue(4);
                if (!this.gameFromPlaygroup) {
                    playersSelected(4);
                }
            } else if (subformatId == 6) {
                getSharedViewModel().getNumberOfPlayers().setValue(6);
                if (!this.gameFromPlaygroup) {
                    playersSelected(6);
                }
            }
            getSharedViewModel().getGameState().setLayoutType(LayoutType.TYPE_1);
            getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(getSharedViewModel().getGameState().getStartingLifeTotal()));
            getSharedViewModel().getNumberOfPlayers().setValue(Integer.valueOf(getSharedViewModel().getGameState().getNumberOfPlayers()));
            getSharedViewModel().getLayoutType().setValue(getSharedViewModel().getGameState().getLayoutType());
            incrementNumGames();
            getBinding().fadeInOverlay.setVisibility(0);
            getBinding().fadeInOverlay.setAlpha(0.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getBinding().fadeInOverlay, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(250L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$formatSelected$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.gameReady();
                    this.this$0.fadeIn();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
            objectAnimatorOfFloat.start();
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void gameEventsEdited() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GameState currentGame = new PreferencesManager(contextRequireContext).getCurrentGame();
        if (currentGame != null) {
            getSharedViewModel().setGameState(currentGame);
        }
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.gameEventsEdited();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x050e A[PHI: r20 r21 r22
      0x050e: PHI (r20v4 com.studiolaganne.lengendarylens.MTUser) = (r20v2 com.studiolaganne.lengendarylens.MTUser), (r20v8 com.studiolaganne.lengendarylens.MTUser) binds: [B:178:0x04fd, B:166:0x04c8] A[DONT_GENERATE, DONT_INLINE]
      0x050e: PHI (r21v3 com.studiolaganne.lengendarylens.MTUser) = (r21v2 com.studiolaganne.lengendarylens.MTUser), (r21v5 com.studiolaganne.lengendarylens.MTUser) binds: [B:178:0x04fd, B:166:0x04c8] A[DONT_GENERATE, DONT_INLINE]
      0x050e: PHI (r22v2 com.studiolaganne.lengendarylens.MTCreateGame) = (r22v1 com.studiolaganne.lengendarylens.MTCreateGame), (r22v4 com.studiolaganne.lengendarylens.MTCreateGame) binds: [B:178:0x04fd, B:166:0x04c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0150 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015a  */
    @Override // com.studiolaganne.lengendarylens.GameCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gameFinished() {
        final GameSet currentSet;
        final ConstraintLayout constraintLayout;
        MTCreateGame mTCreateGame;
        MTUser mTUser;
        Object obj;
        MTUser mTUser2;
        MTUser mTUser3;
        List<MTUser> users;
        Object next;
        PreferencesManager preferencesManager;
        MTDeck mTDeck;
        Object obj2;
        MTDeck mTDeck2;
        Object next2;
        GameSet currentSet2;
        byte b;
        Object obj3;
        Iterator<T> it;
        final GameFragment gameFragment = this;
        if (gameFragment.getContext() == null) {
            return;
        }
        if (gameFragment.getChildFragmentManager().isStateSaved()) {
            Log.w("GameFragment", "State already saved, cannot show dialog.");
            return;
        }
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager2.getCurrentUser();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (gameFragment.getSharedViewModel().getGameState().getPlayers().size() == 2 && (currentSet2 = preferencesManager2.getCurrentSet()) != null) {
            int size = currentSet2.getFinishedGames().size();
            int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet2);
            int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet2);
            boolean z = currentSet2.getBestOf() != 3 ? !(currentSet2.getBestOf() < 5 || size != 5) : size >= 3;
            boolean z2 = z;
            if (z) {
                b = -1;
            } else {
                Player player = gameFragment.getSharedViewModel().getGameState().getPlayers().get(0);
                Player player2 = gameFragment.getSharedViewModel().getGameState().getPlayers().get(1);
                List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(gameFragment.getSharedViewModel().getGameState());
                boolean z3 = gameWinners instanceof Collection;
                if (!z3 || !gameWinners.isEmpty()) {
                    Iterator<T> it2 = gameWinners.iterator();
                    while (it2.hasNext()) {
                        if (((Number) it2.next()).intValue() == player.getUserId()) {
                            playerScore++;
                            gameFragment.getSharedViewModel().getGameState().getPlayers().get(0).setResultid(1);
                            b = 0;
                            break;
                        }
                    }
                    if (z3 || !gameWinners.isEmpty()) {
                        it = gameWinners.iterator();
                        while (it.hasNext()) {
                            if (((Number) it.next()).intValue() == player2.getUserId()) {
                                playerScore2++;
                                gameFragment.getSharedViewModel().getGameState().getPlayers().get(1).setResultid(1);
                                b = 1;
                                break;
                            }
                        }
                        b = -1;
                        size++;
                        if (currentSet2.getBestOf() != 3 ? !(currentSet2.getBestOf() != 5 || (size < 5 && playerScore != 3 && playerScore2 != 3)) : !(size < 3 && playerScore != 2 && playerScore2 != 2)) {
                            z2 = true;
                        }
                    } else {
                        b = -1;
                        size++;
                        if (currentSet2.getBestOf() != 3) {
                        }
                    }
                } else if (z3) {
                    it = gameWinners.iterator();
                    while (it.hasNext()) {
                    }
                    b = -1;
                    size++;
                    if (currentSet2.getBestOf() != 3) {
                    }
                }
            }
            if (!z2) {
                if (gameFragment.getContext() == null) {
                    return;
                }
                gameFragment.getSharedViewModel().getGameState().setEndedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                if (gameFragment.getSharedViewModel().getGameState().getTimerPaused()) {
                    int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - gameFragment.getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
                    GameState gameState = gameFragment.getSharedViewModel().getGameState();
                    gameState.setPauseTime(gameState.getPauseTime() + iCurrentTimeMillis);
                    gameFragment.getSharedViewModel().getGameState().setTimerPaused(false);
                    GameFragmentBase gameFragmentBase = gameFragment.currentGameFragment;
                    if (gameFragmentBase != null) {
                        gameFragmentBase.toggleTimerPause();
                        Unit unit = Unit.INSTANCE;
                    }
                }
                currentSet2.getFinishedGames().add(gameFragment.getSharedViewModel().getGameState());
                preferencesManager2.saveCurrentSet(currentSet2);
                GameFragmentBase gameFragmentBase2 = gameFragment.currentGameFragment;
                if (gameFragmentBase2 != null) {
                    gameFragmentBase2.showBestOfScore(playerScore, playerScore2);
                    Unit unit2 = Unit.INSTANCE;
                    Unit unit3 = Unit.INSTANCE;
                }
                boolean z4 = preferencesManager2.getBoolean(PreferencesManager.DISABLE_WIN_LOSE_ANIMATIONS, false);
                if (gameFragment.getSharedViewModel().getGameState().getGameSyncable() || gameFragment.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    final Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = -1;
                    if (b != -1) {
                        if (b == 0) {
                            intRef.element = 1;
                        } else {
                            intRef.element = 0;
                        }
                        Unit unit4 = Unit.INSTANCE;
                    } else {
                        Iterator<T> it3 = gameFragment.getSharedViewModel().getGameState().getEvents().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            Object next3 = it3.next();
                            if (Intrinsics.areEqual(((MTGameEvent) next3).getType(), MTEvent.PlayerStart.getValue())) {
                                obj3 = next3;
                                break;
                            }
                        }
                        MTGameEvent mTGameEvent = (MTGameEvent) obj3;
                        if (mTGameEvent != null) {
                            intRef.element = mTGameEvent.getPlayerid();
                            Unit unit5 = Unit.INSTANCE;
                            Unit unit6 = Unit.INSTANCE;
                        }
                    }
                    if (intRef.element != -1) {
                        long j = z4 ? 500L : 2500L;
                        final GameFragmentBase gameFragmentBase3 = gameFragment.currentGameFragment;
                        if (gameFragmentBase3 != null) {
                            Boolean.valueOf(gameFragmentBase3.getLifeViews().get(intRef.element).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda26
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GameFragment.gameFinished$lambda$0$5$0(gameFragmentBase3, intRef);
                                }
                            }, j));
                        }
                    }
                }
                if (!z4) {
                    gameFragment.showAnimatedGameLabel(size + 1);
                }
                restartCurrentGame$default(gameFragment, true, false, false, 4, null);
                return;
            }
            booleanRef.element = true;
            gameFragment.getSharedViewModel().getGameState().setEndedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            if (gameFragment.getSharedViewModel().getGameState().getTimerPaused()) {
                int iCurrentTimeMillis2 = (int) ((System.currentTimeMillis() - gameFragment.getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
                GameState gameState2 = gameFragment.getSharedViewModel().getGameState();
                gameState2.setPauseTime(gameState2.getPauseTime() + iCurrentTimeMillis2);
                gameFragment.getSharedViewModel().getGameState().setTimerPaused(false);
                GameFragmentBase gameFragmentBase4 = gameFragment.currentGameFragment;
                if (gameFragmentBase4 != null) {
                    gameFragmentBase4.toggleTimerPause();
                    Unit unit7 = Unit.INSTANCE;
                }
            }
            currentSet2.getFinishedGames().add(gameFragment.getSharedViewModel().getGameState());
            preferencesManager2.saveCurrentSet(currentSet2);
            GameFragmentBase gameFragmentBase5 = gameFragment.currentGameFragment;
            if (gameFragmentBase5 != null) {
                gameFragmentBase5.showBestOfScore(playerScore, playerScore2);
                Unit unit8 = Unit.INSTANCE;
            }
        }
        if ((gameFragment.getSharedViewModel().getGameState().getPlaygroupId() == -1 && currentUser == null) || !gameFragment.getSharedViewModel().getGameState().getGameSyncable() || gameFragment.getSharedViewModel().getGameState().getGameSynced()) {
            String string = gameFragment.getString(R.string.game_finished_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = gameFragment.getString(R.string.game_finished_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (booleanRef.element) {
                string = gameFragment.getString(R.string.match_finished_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = gameFragment.getString(R.string.match_finished_body);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            }
            CustomDialogFragment.Builder body = new CustomDialogFragment.Builder().setTitle(string).setBody(string2);
            String string3 = gameFragment.getString(R.string.restart_game);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = body.setNegativeButton(string3, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return GameFragment.gameFinished$lambda$9(this.f$0, (CustomDialogFragment) obj4);
                }
            }).setPositiveButtonRed();
            String string4 = gameFragment.getString(R.string.discard);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string4, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return GameFragment.gameFinished$lambda$10(this.f$0, ((Boolean) obj4).booleanValue(), (CustomDialogFragment) obj5);
                }
            });
            String string5 = gameFragment.getString(R.string.not_yet);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            CustomDialogFragment.Builder destructiveButton = positiveButton.setDestructiveButton(string5, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return GameFragment.gameFinished$lambda$11(this.f$0, (CustomDialogFragment) obj4);
                }
            });
            FragmentManager childFragmentManager = gameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Boolean.valueOf(destructiveButton.show(childFragmentManager, "CustomDialogFragment"));
            return;
        }
        List<Integer> gameWinners2 = GameUtils.INSTANCE.getInstance().getGameWinners(gameFragment.getSharedViewModel().getGameState());
        ConstraintLayout gameOverOverlay = gameFragment.getBinding().gameOverOverlay;
        Intrinsics.checkNotNullExpressionValue(gameOverOverlay, "gameOverOverlay");
        if (!gameWinners2.isEmpty() || booleanRef.element) {
            gameFragment.getSharedViewModel().getGameState().setGameClosed(true);
            preferencesManager2.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
            ArrayList arrayList = new ArrayList();
            currentSet = preferencesManager2.getCurrentSet();
            if (currentSet == null) {
                arrayList.add(gameFragment.getSetGameHolder());
            } else {
                arrayList.add(gameFragment.getSingleGameHolder());
            }
            gameFragment.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(arrayList, false, gameFragment, true));
            gameFragment.getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(gameFragment.getContext()));
            if (currentSet != null) {
                MTCreateGame mTCreateGameCreateMTGameForUpload = GameUtils.INSTANCE.getInstance().createMTGameForUpload(gameFragment.getSharedViewModel().getGameState(), currentUser != null ? currentUser.getId() : -1);
                MTPlaygroup value = gameFragment.getSharedViewModel().getPlaygroup().getValue();
                Map<Integer, List<MTDeck>> allUsersDecks = preferencesManager2.getAllUsersDecks();
                List<MTDeck> currentUserDecks = preferencesManager2.getCurrentUserDecks();
                Map<Integer, MTDeck> gameSelectedDecks = preferencesManager2.getGameSelectedDecks();
                List<MTUser> currentUserCache = preferencesManager2.getCurrentUserCache();
                DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                Context contextRequireContext2 = gameFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                List<MTFormat> formats = companion.getInstance(contextRequireContext2).getFormats();
                List<Player> players = gameFragment.getSharedViewModel().getGameState().getPlayers();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(players, 10));
                Iterator it4 = players.iterator();
                int i = 0;
                while (it4.hasNext()) {
                    Object next4 = it4.next();
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterator it5 = it4;
                    Player player3 = (Player) next4;
                    if (player3.getUserId() <= 0) {
                        mTCreateGame = mTCreateGameCreateMTGameForUpload;
                        mTUser = currentUser;
                    } else {
                        if (value == null || (users = value.getUsers()) == null) {
                            mTCreateGame = mTCreateGameCreateMTGameForUpload;
                            mTUser = currentUser;
                        } else {
                            Iterator<T> it6 = users.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    mTCreateGame = mTCreateGameCreateMTGameForUpload;
                                    mTUser = currentUser;
                                    next = null;
                                    break;
                                } else {
                                    next = it6.next();
                                    mTCreateGame = mTCreateGameCreateMTGameForUpload;
                                    mTUser = currentUser;
                                    if (((MTUser) next).getId() == player3.getUserId()) {
                                        break;
                                    }
                                    currentUser = mTUser;
                                    mTCreateGameCreateMTGameForUpload = mTCreateGame;
                                }
                            }
                            mTUser2 = (MTUser) next;
                            if (mTUser2 != null) {
                                mTUser3 = mTUser2;
                            }
                            if (player3.getDeckId() > 0) {
                                List<MTDeck> list = allUsersDecks.get(Integer.valueOf(player3.getUserId()));
                                if (list != null) {
                                    Iterator it7 = list.iterator();
                                    while (true) {
                                        if (!it7.hasNext()) {
                                            preferencesManager = preferencesManager2;
                                            next2 = null;
                                            break;
                                        }
                                        next2 = it7.next();
                                        Iterator it8 = it7;
                                        preferencesManager = preferencesManager2;
                                        if (((MTDeck) next2).getId() == player3.getDeckId()) {
                                            break;
                                        }
                                        preferencesManager2 = preferencesManager;
                                        it7 = it8;
                                    }
                                    mTDeck2 = (MTDeck) next2;
                                    if (mTDeck2 == null) {
                                    }
                                    mTDeck = mTDeck2;
                                } else {
                                    preferencesManager = preferencesManager2;
                                }
                                Iterator it9 = currentUserDecks.iterator();
                                while (true) {
                                    if (!it9.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    Object next5 = it9.next();
                                    Iterator it10 = it9;
                                    if (((MTDeck) next5).getId() == player3.getDeckId()) {
                                        obj2 = next5;
                                        break;
                                    }
                                    it9 = it10;
                                }
                                mTDeck2 = (MTDeck) obj2;
                                if (mTDeck2 == null) {
                                    mTDeck2 = gameSelectedDecks.get(Integer.valueOf(player3.getDeckId()));
                                }
                                mTDeck = mTDeck2;
                            } else {
                                preferencesManager = preferencesManager2;
                                mTDeck = null;
                            }
                            MTCreateGamePlayer mTCreateGamePlayer = (MTCreateGamePlayer) CollectionsKt.getOrNull(mTCreateGame.getPlayers(), i);
                            arrayList2.add(new PlayerResultItem(player3, mTUser3, mTDeck, mTCreateGamePlayer != null ? mTCreateGamePlayer.getResultid() : 0));
                            i = i2;
                            it4 = it5;
                            preferencesManager2 = preferencesManager;
                            currentUser = mTUser;
                            mTCreateGameCreateMTGameForUpload = mTCreateGame;
                        }
                        Iterator it11 = currentUserCache.iterator();
                        while (true) {
                            if (!it11.hasNext()) {
                                obj = null;
                                break;
                            }
                            Object next6 = it11.next();
                            Iterator it12 = it11;
                            if (((MTUser) next6).getId() == player3.getUserId()) {
                                obj = next6;
                                break;
                            }
                            it11 = it12;
                        }
                        mTUser2 = (MTUser) obj;
                        if (mTUser2 == null) {
                            if (mTUser != null && player3.getUserId() == mTUser.getId()) {
                                mTUser3 = mTUser;
                            }
                        }
                        if (player3.getDeckId() > 0) {
                        }
                        MTCreateGamePlayer mTCreateGamePlayer2 = (MTCreateGamePlayer) CollectionsKt.getOrNull(mTCreateGame.getPlayers(), i);
                        arrayList2.add(new PlayerResultItem(player3, mTUser3, mTDeck, mTCreateGamePlayer2 != null ? mTCreateGamePlayer2.getResultid() : 0));
                        i = i2;
                        it4 = it5;
                        preferencesManager2 = preferencesManager;
                        currentUser = mTUser;
                        mTCreateGameCreateMTGameForUpload = mTCreateGame;
                    }
                    mTUser3 = null;
                    if (player3.getDeckId() > 0) {
                    }
                    MTCreateGamePlayer mTCreateGamePlayer22 = (MTCreateGamePlayer) CollectionsKt.getOrNull(mTCreateGame.getPlayers(), i);
                    arrayList2.add(new PlayerResultItem(player3, mTUser3, mTDeck, mTCreateGamePlayer22 != null ? mTCreateGamePlayer22.getResultid() : 0));
                    i = i2;
                    it4 = it5;
                    preferencesManager2 = preferencesManager;
                    currentUser = mTUser;
                    mTCreateGameCreateMTGameForUpload = mTCreateGame;
                }
                ArrayList arrayList3 = arrayList2;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                constraintLayout = gameOverOverlay;
                gameFragment = this;
                gameFragment.getBinding().playerResultsRecyclerView.setAdapter(new PlayerResultsAdapter(arrayList3, formats, contextRequireContext3, new GameFragment$gameFinished$playerResultsAdapter$1(constraintLayout, this, currentUser, preferencesManager2, arrayList3)));
                gameFragment.getBinding().playerResultsRecyclerView.setLayoutManager(new GridLayoutManager(gameFragment.requireContext(), 2));
                gameFragment.getBinding().playerResultsRecyclerView.setVisibility(0);
            } else {
                constraintLayout = gameOverOverlay;
                gameFragment.getBinding().playerResultsRecyclerView.setVisibility(8);
            }
            ConstraintLayout saveGameButtonLayout = gameFragment.getBinding().saveGameButtonLayout;
            Intrinsics.checkNotNullExpressionValue(saveGameButtonLayout, "saveGameButtonLayout");
            ViewExtensionsKt.setOnClickWithFade(saveGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.gameFinished$lambda$5(this.f$0, constraintLayout);
                }
            });
            ConstraintLayout saveAndRestartButtonLayout = gameFragment.getBinding().saveAndRestartButtonLayout;
            Intrinsics.checkNotNullExpressionValue(saveAndRestartButtonLayout, "saveAndRestartButtonLayout");
            ViewExtensionsKt.setOnClickWithFade(saveAndRestartButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.gameFinished$lambda$6(this.f$0, constraintLayout);
                }
            });
            TextView deleteGameOver = gameFragment.getBinding().deleteGameOver;
            Intrinsics.checkNotNullExpressionValue(deleteGameOver, "deleteGameOver");
            ViewExtensionsKt.setOnClickWithFade(deleteGameOver, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.gameFinished$lambda$7(this.f$0);
                }
            });
            TextView closeGameOver = gameFragment.getBinding().closeGameOver;
            Intrinsics.checkNotNullExpressionValue(closeGameOver, "closeGameOver");
            TextView textView = closeGameOver;
            final ConstraintLayout constraintLayout2 = constraintLayout;
            final PreferencesManager preferencesManager3 = preferencesManager2;
            ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.gameFinished$lambda$8(this.f$0, constraintLayout2, booleanRef, currentSet, preferencesManager3);
                }
            });
            constraintLayout2.setVisibility(0);
            constraintLayout2.setTranslationY(getView() == null ? r0.getHeight() : constraintLayout2.getHeight());
            constraintLayout2.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
        } else {
            List<MTGameEvent> events = gameFragment.getSharedViewModel().getGameState().getEvents();
            if (!(events instanceof Collection) || !events.isEmpty()) {
                Iterator<T> it13 = events.iterator();
                while (it13.hasNext()) {
                    if (Intrinsics.areEqual(((MTGameEvent) it13.next()).getType(), MTEvent.GameDraw.getValue())) {
                        gameFragment.getSharedViewModel().getGameState().setGameClosed(true);
                        preferencesManager2.saveCurrentGame(gameFragment.getSharedViewModel().getGameState());
                        ArrayList arrayList4 = new ArrayList();
                        currentSet = preferencesManager2.getCurrentSet();
                        if (currentSet == null) {
                        }
                        gameFragment.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(arrayList4, false, gameFragment, true));
                        gameFragment.getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(gameFragment.getContext()));
                        if (currentSet != null) {
                        }
                        ConstraintLayout saveGameButtonLayout2 = gameFragment.getBinding().saveGameButtonLayout;
                        Intrinsics.checkNotNullExpressionValue(saveGameButtonLayout2, "saveGameButtonLayout");
                        ViewExtensionsKt.setOnClickWithFade(saveGameButtonLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameFragment.gameFinished$lambda$5(this.f$0, constraintLayout);
                            }
                        });
                        ConstraintLayout saveAndRestartButtonLayout2 = gameFragment.getBinding().saveAndRestartButtonLayout;
                        Intrinsics.checkNotNullExpressionValue(saveAndRestartButtonLayout2, "saveAndRestartButtonLayout");
                        ViewExtensionsKt.setOnClickWithFade(saveAndRestartButtonLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameFragment.gameFinished$lambda$6(this.f$0, constraintLayout);
                            }
                        });
                        TextView deleteGameOver2 = gameFragment.getBinding().deleteGameOver;
                        Intrinsics.checkNotNullExpressionValue(deleteGameOver2, "deleteGameOver");
                        ViewExtensionsKt.setOnClickWithFade(deleteGameOver2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameFragment.gameFinished$lambda$7(this.f$0);
                            }
                        });
                        TextView closeGameOver2 = gameFragment.getBinding().closeGameOver;
                        Intrinsics.checkNotNullExpressionValue(closeGameOver2, "closeGameOver");
                        TextView textView2 = closeGameOver2;
                        final ConstraintLayout constraintLayout22 = constraintLayout;
                        final PreferencesManager preferencesManager32 = preferencesManager2;
                        ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameFragment.gameFinished$lambda$8(this.f$0, constraintLayout22, booleanRef, currentSet, preferencesManager32);
                            }
                        });
                        constraintLayout22.setVisibility(0);
                        constraintLayout22.setTranslationY(getView() == null ? r0.getHeight() : constraintLayout22.getHeight());
                        constraintLayout22.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
                    }
                }
            }
        }
        Unit unit9 = Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116 A[EDGE_INSN: B:39:0x0116->B:37:0x0116 BREAK  A[LOOP:0: B:32:0x00e9->B:41:?], SYNTHETIC] */
    @Override // com.studiolaganne.lengendarylens.GameCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gameForceUpload() {
        Iterator<T> it;
        if (getContext() == null || this._binding == null || getSharedViewModel().getGameState().getPlayers().size() != 2) {
            return;
        }
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        GameSet currentSet = preferencesManager.getCurrentSet();
        if (currentSet != null) {
            int size = currentSet.getFinishedGames().size();
            Player player = getSharedViewModel().getGameState().getPlayers().get(0);
            Player player2 = getSharedViewModel().getGameState().getPlayers().get(1);
            int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet);
            int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet);
            if (!getSharedViewModel().getGameState().getGameClosed()) {
                List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
                boolean z = gameWinners instanceof Collection;
                if (!z || !gameWinners.isEmpty()) {
                    Iterator<T> it2 = gameWinners.iterator();
                    while (it2.hasNext()) {
                        if (((Number) it2.next()).intValue() == player.getUserId()) {
                            playerScore++;
                            getSharedViewModel().getGameState().getPlayers().get(0).setResultid(1);
                            break;
                        }
                    }
                    if (z || !gameWinners.isEmpty()) {
                        it = gameWinners.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (((Number) it.next()).intValue() == player2.getUserId()) {
                                playerScore2++;
                                getSharedViewModel().getGameState().getPlayers().get(1).setResultid(1);
                                break;
                            }
                        }
                    }
                } else if (z) {
                    it = gameWinners.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                        }
                    }
                }
            }
            String string = getResources().getString(R.string.force_upload_body);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "{1}", String.valueOf(playerScore), false, 4, (Object) null), "{2}", String.valueOf(playerScore2), false, 4, (Object) null), "{3}", String.valueOf(size), false, 4, (Object) null);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string2 = getString(R.string.force_upload_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(strReplace$default);
            String string3 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = body.setNegativeButton(string3, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.gameForceUpload$lambda$0$2(this.f$0, (CustomDialogFragment) obj);
                }
            }).setPositiveButtonRed();
            String string4 = getString(R.string.yes_sync);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string4, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment.gameForceUpload$lambda$0$3(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "CustomDialogFragment");
        }
    }

    public final boolean getFullscreen() {
        return this.fullscreen;
    }

    public final boolean getGameFromPlaygroup() {
        return this.gameFromPlaygroup;
    }

    public final boolean getGameSyncable() {
        return this.gameSyncable;
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void initiativeCoinDragged() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("initiative_coin_dragged");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("initiative_coin_dragged", null);
        closeMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameLayoutFragment.LayoutSetupCallback
    public void layoutSelected(LayoutType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getSharedViewModel().getGameState().setLayoutType(value);
        getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(getSharedViewModel().getGameState().getStartingLifeTotal()));
        getSharedViewModel().getNumberOfPlayers().setValue(Integer.valueOf(getSharedViewModel().getGameState().getNumberOfPlayers()));
        getSharedViewModel().getLayoutType().setValue(getSharedViewModel().getGameState().getLayoutType());
        incrementNumGames();
        getBinding().fadeInOverlay.setVisibility(0);
        getBinding().fadeInOverlay.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getBinding().fadeInOverlay, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragment.layoutSelected.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GameFragment.this.gameReady();
                GameFragment.this.fadeIn();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        objectAnimatorOfFloat.start();
    }

    @Override // com.studiolaganne.lengendarylens.GameCallback
    public void menuPressed() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (this.currentGameFragment != null) {
            this.fullscreen = false;
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.setFullscreenMode(false);
            }
            FragmentActivity activity2 = getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.setStatusBarFullscreen(false);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if ((getSharedViewModel().getGameState().getPlaygroupId() != -1 || currentUser != null) && getSharedViewModel().getGameState().getGameSyncable() && (!getSharedViewModel().getGameState().getUsersSeated() || !getSharedViewModel().getGameState().getDecksSelected())) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.game_unseated_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.game_not_ready_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.delete);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment.menuPressed$lambda$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            }).setPositiveButtonRed();
            String string4 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButtonRed.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment.menuPressed$lambda$2((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "CustomDialogFragment");
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("game_menu_open");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("game_menu_open", null);
        ConstraintLayout menuOverlay = getBinding().menuOverlay;
        Intrinsics.checkNotNullExpressionValue(menuOverlay, "menuOverlay");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in);
        animationLoadAnimation.setDuration(300L);
        menuOverlay.setVisibility(0);
        menuOverlay.startAnimation(animationLoadAnimation);
        menuOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment.menuPressed$lambda$3(view);
            }
        });
        GameOptionsFragment gameOptionsFragmentNewInstance = GameOptionsFragment.INSTANCE.newInstance();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.replace(R.id.menu_fragment_container, gameOptionsFragmentNewInstance);
        fragmentTransactionBeginTransaction.commit();
        MaterialButton restartButton = getBinding().restartButton;
        Intrinsics.checkNotNullExpressionValue(restartButton, "restartButton");
        ViewExtensionsKt.setOnClickWithBounce(restartButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment.menuPressed$lambda$4(this.f$0, preferencesManager, currentUser);
            }
        });
        MaterialButton exitButton = getBinding().exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        ViewExtensionsKt.setOnClickWithBounce(exitButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda64
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment.menuPressed$lambda$5(this.f$0);
            }
        });
        TextView closeButton = getBinding().closeButton;
        Intrinsics.checkNotNullExpressionValue(closeButton, "closeButton");
        ViewExtensionsKt.setOnClickWithBounce(closeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda65
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment.menuPressed$lambda$6(this.f$0);
            }
        });
        final ConstraintLayout reviewLayout = getBinding().reviewLayout;
        Intrinsics.checkNotNullExpressionValue(reviewLayout, "reviewLayout");
        final TextView closeReviewButton = getBinding().closeReviewButton;
        Intrinsics.checkNotNullExpressionValue(closeReviewButton, "closeReviewButton");
        if (preferencesManager.getBoolean(PreferencesManager.GAME_MENU_RATING_BANNER_DISMISSED, false)) {
            reviewLayout.setVisibility(4);
            closeReviewButton.setVisibility(8);
            reviewLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda66
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameFragment.menuPressed$lambda$7(view);
                }
            });
        } else {
            reviewLayout.setVisibility(0);
            closeReviewButton.setVisibility(0);
            ViewExtensionsKt.setOnClickWithFade(reviewLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.menuPressed$lambda$8(this.f$0, preferencesManager, reviewLayout, closeReviewButton);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(closeReviewButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment.menuPressed$lambda$9(this.f$0, preferencesManager, reviewLayout, closeReviewButton);
                }
            });
        }
        TextView closeText = getBinding().closeText;
        Intrinsics.checkNotNullExpressionValue(closeText, "closeText");
        closeText.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.closeMenu();
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void monarchCoinDragged() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("monarch_coin_dragged");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("monarch_coin_dragged", null);
        closeMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0310  */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.viewpager2.widget.ViewPager2] */
    /* JADX WARN: Type inference failed for: r3v25, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.studiolaganne.lengendarylens.NewGameFragment.NewGameCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void newGameFromFavorite(MTFavoriteSetup setup) {
        boolean z;
        boolean z2;
        boolean z3;
        MTUser currentUser;
        Object next;
        Object next2;
        int i;
        Object next3;
        Intrinsics.checkNotNullParameter(setup, "setup");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser2 = preferencesManager.getCurrentUser();
        getSharedViewModel().setGameState(new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0L, 0L, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0L, 0, false, false, 0, 0, 0L, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null));
        List<MTFavoritePlayer> players = setup.getPlayers();
        int i2 = 1;
        if ((players instanceof Collection) && players.isEmpty()) {
            z = false;
        } else {
            Iterator it = players.iterator();
            while (it.hasNext()) {
                if (((MTFavoritePlayer) it.next()) != null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        getSharedViewModel().getGameState().setNumberOfPlayers(setup.getPlayers().size());
        getSharedViewModel().getNumberOfPlayers().setValue(Integer.valueOf(setup.getPlayers().size()));
        MTGamePlaygroup playgroup = setup.getPlaygroup();
        if (playgroup != null) {
            z2 = playgroup.getId() >= 0;
            getSharedViewModel().getGameState().setPlaygroupId(playgroup.getId());
            Unit unit = Unit.INSTANCE;
        } else {
            getSharedViewModel().getGameState().setPlaygroupId(-1);
            Unit unit2 = Unit.INSTANCE;
            z2 = false;
        }
        if (!z2) {
            z3 = false;
            int size = setup.getPlayers().size();
            if (preferencesManager.hasValidUser() && (currentUser = preferencesManager.getCurrentUser()) != null) {
                List<MTUser> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserCache());
                mutableList.add(currentUser);
                preferencesManager.saveCurrentUserCache(mutableList);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            int i3 = 0;
            while (i3 < size) {
                Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                int i4 = i3 + 1;
                player.setName(getResources().getString(R.string.player) + " " + i4);
                ArrayList arrayList = new ArrayList(size);
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList.add(0);
                }
                player.setCommanderDamageList(arrayList);
                ArrayList arrayList2 = new ArrayList(size);
                for (int i6 = 0; i6 < size; i6++) {
                    arrayList2.add(0);
                }
                player.setCommanderDamageListPartner(arrayList2);
                player.setUserId(-(i3 + 10));
                getSharedViewModel().getGameState().getPlayers().add(player);
                i3 = i4;
            }
            Unit unit5 = Unit.INSTANCE;
        } else if (setup.getPlaygroup() != null) {
            Iterator it2 = preferencesManager.getCurrentUserPlaygroups().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                MTPlaygroup mTPlaygroup = (MTPlaygroup) next2;
                MTGamePlaygroup playgroup2 = setup.getPlaygroup();
                if (playgroup2 != null && mTPlaygroup.getId() == playgroup2.getId()) {
                    break;
                }
            }
            MTPlaygroup mTPlaygroup2 = (MTPlaygroup) next2;
            if (mTPlaygroup2 != null) {
                getSharedViewModel().getPlaygroupId().setValue(Integer.valueOf(mTPlaygroup2.getId()));
                getSharedViewModel().getPlaygroup().setValue(mTPlaygroup2);
                ArrayList arrayList3 = new ArrayList();
                getSharedViewModel().getGameState().getPlayers().clear();
                int i7 = 0;
                for (MTFavoritePlayer mTFavoritePlayer : setup.getPlayers()) {
                    i7 += i2;
                    if (mTFavoritePlayer != null) {
                        Player player2 = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                        player2.setUserId(mTFavoritePlayer.getId());
                        arrayList3.add(Integer.valueOf(mTFavoritePlayer.getId()));
                        Iterator it3 = mTPlaygroup2.getUsers().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                next3 = it3.next();
                                i = 0;
                                if (((MTUser) next3).getId() == mTFavoritePlayer.getId()) {
                                    break;
                                }
                            } else {
                                i = 0;
                                next3 = null;
                                break;
                            }
                        }
                        MTUser mTUser = (MTUser) next3;
                        if (mTUser != null) {
                            String firstname = mTUser.getFirstname();
                            if (firstname == null) {
                                firstname = getResources().getString(R.string.player) + " " + i7;
                            }
                            player2.setName(firstname);
                            Unit unit6 = Unit.INSTANCE;
                            Unit unit7 = Unit.INSTANCE;
                        }
                        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                        ArrayList arrayList4 = new ArrayList(numberOfPlayers);
                        for (int i8 = i; i8 < numberOfPlayers; i8++) {
                            arrayList4.add(Integer.valueOf(i));
                        }
                        player2.setCommanderDamageList(arrayList4);
                        int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                        ArrayList arrayList5 = new ArrayList(numberOfPlayers2);
                        for (int i9 = i; i9 < numberOfPlayers2; i9++) {
                            arrayList5.add(Integer.valueOf(i));
                        }
                        player2.setCommanderDamageListPartner(arrayList5);
                        getSharedViewModel().getGameState().getPlayers().add(player2);
                    }
                    i2 = 1;
                }
                z3 = false;
                getSharedViewModel().getPlaygroupUsers().setValue(CollectionsKt.toList(arrayList3));
                MTApiKt.getMtApi().getPlaygroupDecks(currentUser2 != null ? currentUser2.getId() : -1, mTPlaygroup2.getId()).enqueue(new Callback<MTDecksByUserResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragment$newGameFromFavorite$3$1$4
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTDecksByUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTDecksByUserResponse> call, Response<MTDecksByUserResponse> response) throws IOException {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.getContext() == null || this.this$0._binding == null) {
                            return;
                        }
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        if (responseBodyErrorBody != null) {
                            responseBodyErrorBody.string();
                        }
                        if (!response.isSuccessful() || this.this$0.getContext() == null) {
                            return;
                        }
                        MTDecksByUserResponse mTDecksByUserResponseBody = response.body();
                        Map<String, List<MTDeck>> decksByUser = mTDecksByUserResponseBody != null ? mTDecksByUserResponseBody.getDecksByUser() : null;
                        if (decksByUser != null) {
                            GameFragment gameFragment = this.this$0;
                            PreferencesManager preferencesManager2 = preferencesManager;
                            gameFragment.getSharedViewModel().getDecks().setValue(decksByUser);
                            Map<Integer, ? extends List<MTDeck>> mutableMap = MapsKt.toMutableMap(preferencesManager2.getAllUsersDecks());
                            for (String str : decksByUser.keySet()) {
                                List<MTDeck> list = decksByUser.get(str);
                                int i10 = Integer.parseInt(str);
                                if (list != null) {
                                    mutableMap.put(Integer.valueOf(i10), list);
                                }
                            }
                            preferencesManager2.saveAllUsersDecks(mutableMap);
                        }
                    }
                });
                Unit unit8 = Unit.INSTANCE;
                Unit unit9 = Unit.INSTANCE;
            } else {
                z3 = false;
            }
        }
        MTGameFormat format = setup.getFormat();
        if (format == null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("new_game_fav_setup_error_no_format", null);
            return;
        }
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        Iterator it4 = companion.getInstance(contextRequireContext2).getFormats().iterator();
        while (true) {
            if (it4.hasNext()) {
                next = it4.next();
                if (((MTFormat) next).getId() == format.getId() ? true : z3) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat == null) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("new_game_fav_setup_error_no_format", null);
            return;
        }
        int lifetotal = mTFormat.getLifetotal();
        getSharedViewModel().getGameState().setFormatId(mTFormat.getId());
        GameState gameState = getSharedViewModel().getGameState();
        MTGameSubformat subformat = setup.getSubformat();
        gameState.setSubformatId(subformat != null ? subformat.getId() : -1);
        getSharedViewModel().getGameState().setStartingLifeTotal(lifetotal);
        getSharedViewModel().getGameState().setHasCommanderDamage(mTFormat.getCommanderdamages() > 0 ? true : z3);
        getSharedViewModel().getFormatId().setValue(Integer.valueOf(mTFormat.getId()));
        getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(lifetotal));
        for (Player player3 : getSharedViewModel().getGameState().getPlayers()) {
            player3.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player3.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
        }
        int i10 = Integer.parseInt(preferencesManager.getString(PreferencesManager.DEFAULT_TIMER_TIME, "90"));
        getSharedViewModel().getGameState().setTimerTotalTime(mTFormat.getTimelimit() > 0 ? mTFormat.getTimelimit() : i10);
        if (Intrinsics.areEqual(mTFormat.getScryfallid(), "commander")) {
            getSharedViewModel().getGameState().setTimerTotalTime(i10);
        }
        getSharedViewModel().getGameState().setTimerEnabled(preferencesManager.getBoolean(PreferencesManager.ENABLE_TIMER_BY_DEFAULT, true));
        Integer bestOf = setup.getBestOf();
        if (bestOf != null) {
            int iIntValue = bestOf.intValue();
            if (iIntValue > 0) {
                GameSet gameSet = new GameSet(null, 0, null, 7, null);
                gameSet.setBestOf(iIntValue);
                preferencesManager.saveCurrentSet(gameSet);
            } else {
                preferencesManager.clearCurrentSet();
            }
            Unit unit10 = Unit.INSTANCE;
        } else {
            preferencesManager.clearCurrentSet();
            Unit unit11 = Unit.INSTANCE;
        }
        Unit unit12 = Unit.INSTANCE;
        Unit unit13 = Unit.INSTANCE;
        this.gameFromPlaygroup = setup.getPlaygroup() == null ? z3 : true;
        this.gameSyncable = z;
        getSharedViewModel().getGameState().setGameSyncable(z);
        this.adapter = new LayoutPagerAdapter();
        ViewPager2 viewPager2 = getBinding().viewPager;
        FragmentStateAdapter fragmentStateAdapter = this.adapter;
        if (fragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fragmentStateAdapter = null;
        }
        viewPager2.setAdapter(fragmentStateAdapter);
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        boolean z4 = z3;
        toolbar.setVisibility(z4 ? 1 : 0);
        getBinding().viewPager.setCurrentItem(z4 ? 1 : 0, z4);
        FragmentActivity activity = getActivity();
        ?? r3 = z4;
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(z4 ? 1 : 0, 2);
                Unit unit14 = Unit.INSTANCE;
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setTitle(getString(R.string.title_layout));
                Unit unit15 = Unit.INSTANCE;
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            r3 = 0;
            r3 = 0;
            if (supportActionBar3 != null) {
                supportActionBar3.setDisplayHomeAsUpEnabled(false);
                Unit unit16 = Unit.INSTANCE;
            }
        }
        getBinding().viewPager.setVisibility(r3);
        fragmentContainer.setVisibility(8);
        NewGameFragment newGameFragment = this.newGameFragment;
        if (newGameFragment != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            Integer.valueOf(fragmentTransactionBeginTransaction.remove(newGameFragment).commit());
        }
        FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
        firebaseAnalytics3.logEvent("new_game_fav_setup", null);
        this.newGameFragment = null;
    }

    @Override // com.studiolaganne.lengendarylens.NewGameFragment.NewGameCallback
    public void newGameFromPlaygroup(int id) {
        Object next;
        if (getContext() == null || this._binding == null) {
            return;
        }
        getSharedViewModel().getFormatId().setValue(-1);
        getSharedViewModel().getSubFormatId().setValue(-1);
        getSharedViewModel().getLifeTotal().setValue(-1);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("new_game_playgroup", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.hasValidUser()) {
            preferencesManager.clearAllUsersDecks();
            if (preferencesManager.getCurrentUser() != null) {
                Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTPlaygroup) next).getId() == id) {
                            break;
                        }
                    }
                }
                if (((MTPlaygroup) next) != null) {
                    getSharedViewModel().setGameState(new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0L, 0L, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0L, 0, false, false, 0, 0, 0L, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null));
                    getSharedViewModel().getGameState().getPlayers().clear();
                    getSharedViewModel().getGameState().setPlaygroupId(id);
                    getSharedViewModel().getGameState().setTossAlreadyDone(false);
                    getSharedViewModel().getGameState().setFirstSetupDone(false);
                    getSharedViewModel().getGameState().setUsersSeated(false);
                    getSharedViewModel().getGameState().setDecksSelected(false);
                    getSharedViewModel().getGameState().setGameSyncable(true);
                    getSharedViewModel().getGameState().setGameStartTime(0L);
                    getSharedViewModel().getGameState().setTimerStartTime(0L);
                    if (preferencesManager.getBoolean(PreferencesManager.ENABLE_POISON_COUNTERS_BY_DEFAULT, false)) {
                        getSharedViewModel().getGameState().setHasPoisonCounters(true);
                    }
                    this.gameFromPlaygroup = true;
                    this.gameSyncable = true;
                    getSharedViewModel().getPlaygroupId().setValue(Integer.valueOf(id));
                    this.adapter = new QuestionPagerAdapter();
                    ViewPager2 viewPager2 = getBinding().viewPager;
                    FragmentStateAdapter fragmentStateAdapter = this.adapter;
                    if (fragmentStateAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        fragmentStateAdapter = null;
                    }
                    viewPager2.setAdapter(fragmentStateAdapter);
                    FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
                    Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
                    Toolbar toolbar = getBinding().toolbar;
                    Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
                    toolbar.setVisibility(0);
                    getBinding().viewPager.setCurrentItem(0, false);
                    FragmentActivity activity = getActivity();
                    if (activity instanceof AppCompatActivity) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                        if (supportActionBar != null) {
                            supportActionBar.setDisplayOptions(0, 2);
                        }
                        ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar2 != null) {
                            supportActionBar2.setTitle(getString(R.string.title_playgroup_users));
                        }
                        ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar3 != null) {
                            supportActionBar3.setDisplayHomeAsUpEnabled(true);
                        }
                    }
                    getBinding().viewPager.setVisibility(0);
                    fragmentContainer.setVisibility(8);
                    NewGameFragment newGameFragment = this.newGameFragment;
                    if (newGameFragment != null) {
                        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                        fragmentTransactionBeginTransaction.remove(newGameFragment).commit();
                    }
                    this.newGameFragment = null;
                }
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.NewGameFragment.NewGameCallback
    public void newGameFromScratch() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("new_game_scratch", null);
        setupPlainNewGame();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.gameFromPlaygroup = false;
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        if (preferencesManager.hasValidUser()) {
            this.gameSyncable = true;
            getSharedViewModel().getGameState().setGameSyncable(true);
            preferencesManager.clearAllUsersDecks();
            this.adapter = new QuestionPagerAdapter();
            ViewPager2 viewPager2 = getBinding().viewPager;
            FragmentStateAdapter fragmentStateAdapter = this.adapter;
            if (fragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                fragmentStateAdapter = null;
            }
            viewPager2.setAdapter(fragmentStateAdapter);
            toolbar.setVisibility(0);
            getBinding().viewPager.setCurrentItem(0, false);
            FragmentActivity activity = getActivity();
            if (activity instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(getString(R.string.title_playgroup_format));
                }
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setDisplayHomeAsUpEnabled(true);
                }
            }
        } else {
            this.gameSyncable = false;
            getSharedViewModel().getGameState().setGameSyncable(false);
            this.adapter = new QuestionPagerAdapter();
            ViewPager2 viewPager22 = getBinding().viewPager;
            FragmentStateAdapter fragmentStateAdapter2 = this.adapter;
            if (fragmentStateAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                fragmentStateAdapter2 = null;
            }
            viewPager22.setAdapter(fragmentStateAdapter2);
            toolbar.setVisibility(0);
            getBinding().viewPager.setCurrentItem(0, false);
            FragmentActivity activity2 = getActivity();
            if (activity2 instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity2 = (AppCompatActivity) activity2;
                ActionBar supportActionBar3 = appCompatActivity2.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setTitle(getString(R.string.title_playgroup_format));
                }
                ActionBar supportActionBar4 = appCompatActivity2.getSupportActionBar();
                if (supportActionBar4 != null) {
                    supportActionBar4.setDisplayHomeAsUpEnabled(true);
                }
            }
        }
        getBinding().viewPager.setVisibility(0);
        fragmentContainer.setVisibility(8);
        NewGameFragment newGameFragment = this.newGameFragment;
        if (newGameFragment != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.remove(newGameFragment).commit();
        }
        this.newGameFragment = null;
    }

    @Override // com.studiolaganne.lengendarylens.NewGameFragment.NewGameCallback
    public void newQuickGame() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("new_game_quick", null);
        setupPlainNewGame();
        getSharedViewModel().getGameState().setGameSyncable(false);
        getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        this.gameFromPlaygroup = false;
        this.gameSyncable = false;
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        this.adapter = new QuestionPagerAdapter();
        ViewPager2 viewPager2 = getBinding().viewPager;
        FragmentStateAdapter fragmentStateAdapter = this.adapter;
        if (fragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fragmentStateAdapter = null;
        }
        viewPager2.setAdapter(fragmentStateAdapter);
        toolbar.setVisibility(0);
        getBinding().viewPager.setCurrentItem(0, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle(getString(R.string.title_playgroup_format));
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
        }
        getBinding().viewPager.setVisibility(0);
        fragmentContainer.setVisibility(8);
        NewGameFragment newGameFragment = this.newGameFragment;
        if (newGameFragment != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.remove(newGameFragment).commit();
        }
        this.newGameFragment = null;
    }

    @Override // com.studiolaganne.lengendarylens.GameCallback
    public void nonSyncableGameFinished() {
        gameFinished();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.streamingManager.addConnectionListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFullGameBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onDeleteGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.streamingManager.removeConnectionListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewDestroyed = true;
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameItemExpanded() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        View view;
        GameFragmentBase gameFragmentBase;
        super.onHiddenChanged(hidden);
        this.isVisible = !hidden;
        if (hidden || this.isTutorial || this.currentGameFragment == null) {
            return;
        }
        if ((getSharedViewModel().getGameState().getTimerEnabled() && getSharedViewModel().getGameState().getTimerTotalTime() > 0) || getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            int value = 0;
            boolean z = getSharedViewModel().getGameState().getGameSyncable() && !(getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected());
            if ((!getSharedViewModel().getGameState().getTurnTimerEnabled() || getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) && !z && (gameFragmentBase = this.currentGameFragment) != null) {
                gameFragmentBase.showClock();
                gameFragmentBase.updateClock();
                if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    gameFragmentBase.showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                    long currentTurnStartTime = getSharedViewModel().getGameState().getCurrentTurnStartTime();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int currentTurnPauseTime = getSharedViewModel().getGameState().getCurrentTurnPauseTime();
                    if (getSharedViewModel().getGameState().getTimerPaused()) {
                        currentTurnPauseTime += (int) ((System.currentTimeMillis() - getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
                    }
                    long j = ((jCurrentTimeMillis - currentTurnStartTime) / 1000) - ((long) currentTurnPauseTime);
                    for (MTGameEvent mTGameEvent : getSharedViewModel().getGameState().getEvents()) {
                        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent.getPlayerid() == getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()) {
                            value += mTGameEvent.getValue();
                        }
                    }
                    if (getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() >= 0 && getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() < gameFragmentBase.getLifeViews().size()) {
                        gameFragmentBase.getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).setIsCurrentPlayerTurn(true, value);
                        gameFragmentBase.getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).updateCurrentTurnTime((int) j);
                    }
                }
            }
        }
        fadeIn();
        final ConstraintLayout menuOverlay = getBinding().menuOverlay;
        Intrinsics.checkNotNullExpressionValue(menuOverlay, "menuOverlay");
        if (menuOverlay.getVisibility() == 0 || (view = getView()) == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment.onHiddenChanged$lambda$1$0(this.f$0, menuOverlay);
            }
        }, 1000L);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onLoadMoreGamesClicked() {
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x013e  */
    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onOptionsItemSelected(MenuItem item) {
        ActionBar supportActionBar;
        ActionBar supportActionBar2;
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        PreferencesManager preferencesManager = null;
        if (this.gameFromPlaygroup) {
            if (getBinding().viewPager.getCurrentItem() > 0) {
                getBinding().viewPager.setCurrentItem(r8.getCurrentItem() - 1);
                FragmentActivity activity = getActivity();
                if (activity instanceof AppCompatActivity) {
                    int currentItem = getBinding().viewPager.getCurrentItem();
                    if (currentItem == 0) {
                        ActionBar supportActionBar3 = ((AppCompatActivity) activity).getSupportActionBar();
                        if (supportActionBar3 != null) {
                            supportActionBar3.setTitle(getString(R.string.title_playgroup_users));
                        }
                    } else if (currentItem == 1) {
                        ActionBar supportActionBar4 = ((AppCompatActivity) activity).getSupportActionBar();
                        if (supportActionBar4 != null) {
                            supportActionBar4.setTitle(getString(R.string.title_playgroup_format));
                        }
                    } else if (currentItem == 2 && (supportActionBar2 = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                        supportActionBar2.setTitle(getString(R.string.title_layout));
                    }
                }
            } else if (getBinding().viewPager.getVisibility() == 0) {
                PreferencesManager preferencesManager2 = this.prefs;
                if (preferencesManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                } else {
                    preferencesManager = preferencesManager2;
                }
                if (preferencesManager.hasValidUser()) {
                    getBinding().viewPager.setVisibility(8);
                    getBinding().toolbar.setVisibility(8);
                    getBinding().fragmentContainer.setVisibility(0);
                    NewGameFragment newGameFragmentNewInstance = NewGameFragment.INSTANCE.newInstance();
                    this.newGameFragment = newGameFragmentNewInstance;
                    if (newGameFragmentNewInstance != null) {
                        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, newGameFragmentNewInstance);
                        fragmentTransactionBeginTransaction.commit();
                    }
                }
            }
        } else if (getBinding().viewPager.getCurrentItem() > 0) {
            getBinding().viewPager.setCurrentItem(r8.getCurrentItem() - 1);
            FragmentActivity activity2 = getActivity();
            if (activity2 instanceof AppCompatActivity) {
                if (getBinding().viewPager.getCurrentItem() == 0) {
                    if (getBinding().viewPager.getVisibility() != 0) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) activity2;
                        ActionBar supportActionBar5 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar5 != null) {
                            supportActionBar5.setDisplayOptions(0, 2);
                        }
                        ActionBar supportActionBar6 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar6 != null) {
                            supportActionBar6.setDisplayHomeAsUpEnabled(false);
                        }
                    } else {
                        PreferencesManager preferencesManager3 = this.prefs;
                        if (preferencesManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        } else {
                            preferencesManager = preferencesManager3;
                        }
                        if (preferencesManager.hasValidUser()) {
                            ActionBar supportActionBar7 = ((AppCompatActivity) activity2).getSupportActionBar();
                            if (supportActionBar7 != null) {
                                supportActionBar7.setDisplayHomeAsUpEnabled(true);
                            }
                        }
                    }
                }
                int currentItem2 = getBinding().viewPager.getCurrentItem();
                if (currentItem2 == 0) {
                    ActionBar supportActionBar8 = ((AppCompatActivity) activity2).getSupportActionBar();
                    if (supportActionBar8 != null) {
                        supportActionBar8.setTitle(getString(R.string.title_playgroup_format));
                    }
                } else if (currentItem2 == 1) {
                    ActionBar supportActionBar9 = ((AppCompatActivity) activity2).getSupportActionBar();
                    if (supportActionBar9 != null) {
                        supportActionBar9.setTitle(getString(R.string.title_players));
                    }
                } else if (currentItem2 == 2 && (supportActionBar = ((AppCompatActivity) activity2).getSupportActionBar()) != null) {
                    supportActionBar.setTitle(getString(R.string.title_layout));
                }
            }
        } else if (getBinding().viewPager.getVisibility() == 0) {
            PreferencesManager preferencesManager4 = this.prefs;
            if (preferencesManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
            } else {
                preferencesManager = preferencesManager4;
            }
            if (preferencesManager.hasValidUser()) {
                getBinding().viewPager.setVisibility(8);
                getBinding().toolbar.setVisibility(8);
                getBinding().fragmentContainer.setVisibility(0);
                NewGameFragment newGameFragmentNewInstance2 = NewGameFragment.INSTANCE.newInstance();
                this.newGameFragment = newGameFragmentNewInstance2;
                if (newGameFragmentNewInstance2 != null) {
                    FragmentTransaction fragmentTransactionBeginTransaction2 = getChildFragmentManager().beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                    fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, newGameFragmentNewInstance2);
                    fragmentTransactionBeginTransaction2.commit();
                }
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        requireActivity().getWindow().clearFlags(128);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onPublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireActivity().getWindow().addFlags(128);
        if (this.currentGameFragment == null || getContext() == null || this._binding == null) {
            return;
        }
        if (getSharedViewModel().getGameState().getStreamingEnabled()) {
            String streamingToken = getSharedViewModel().getGameState().getStreamingToken();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            if (new PreferencesManager(contextRequireContext).getCurrentUser() != null && streamingToken.length() > 0) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if ((currentUser != null ? currentUser.getUid() : null) != null) {
                    this.streamingManager.setCurrentToken(streamingToken);
                    StreamingManager streamingManager = this.streamingManager;
                    FirebaseUser currentUser2 = FirebaseAuth.getInstance().getCurrentUser();
                    streamingManager.setCurrentUid(currentUser2 != null ? currentUser2.getUid() : null);
                    this.streamingManager.reconnect();
                }
            }
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext2).getBoolean(PreferencesManager.ENABLE_FULLSCREEN_MODE, true)) {
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity == null || ((BottomNavigationView) mainActivity.findViewById(R.id.bottom_navigation)).getSelectedItemId() == R.id.navigation_game) {
                if (!getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getUsersSeated()) {
                    if ((getSharedViewModel().getGameState().getGameSyncable() && !getSharedViewModel().getGameState().getDecksSelected()) || getBinding().menuOverlay.getVisibility() == 0 || this.fullscreen) {
                        return;
                    }
                    this.fullscreen = true;
                    FragmentActivity activity2 = getActivity();
                    MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
                    if (mainActivity2 != null) {
                        mainActivity2.setFullscreenMode(true);
                    }
                    FragmentActivity activity3 = getActivity();
                    MainActivity mainActivity3 = activity3 instanceof MainActivity ? (MainActivity) activity3 : null;
                    if (mainActivity3 != null) {
                        mainActivity3.setStatusBarFullscreen(true);
                    }
                    FragmentActivity activity4 = getActivity();
                    MainActivity mainActivity4 = activity4 instanceof MainActivity ? (MainActivity) activity4 : null;
                    if (mainActivity4 != null) {
                        mainActivity4.checkForLowBattery();
                    }
                }
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onSetClicked(MTSet set, List<MTGame> subgames) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(subgames, "subgames");
    }

    @Override // com.studiolaganne.lengendarylens.StreamingManager.ConnectionStateListener
    public void onStreamingConnectionStateChanged(StreamingManager.ConnectionState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (getContext() == null) {
            return;
        }
        if (state == StreamingManager.ConnectionState.CONNECTED) {
            Log.d("Streaming", "Sending initial game update...");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.onStreamingConnectionStateChanged$lambda$0(this.f$0);
                }
            }, 1000L);
        }
        if (state == StreamingManager.ConnectionState.DISCONNECTED && getSharedViewModel().getGameState().getStreamingEnabled() && !getSharedViewModel().getGameState().getGameClosed()) {
            Log.d("Streaming", "Disconnected, attempting to reconnect...");
            this.streamingManager.reconnect();
        }
        if (state == StreamingManager.ConnectionState.ERROR && getSharedViewModel().getGameState().getStreamingEnabled() && !getSharedViewModel().getGameState().getGameClosed()) {
            Log.d("Streaming", "Errored, attempting to reconnect...");
            this.streamingManager.reconnect();
        }
    }

    @Override // com.studiolaganne.lengendarylens.StreamingManager.ConnectionStateListener
    public void onStreamingError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.d("Streaming", "Error received : " + error);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onUnpublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.transparent));
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.isTutorial = false;
        ((ConstraintLayout) view.findViewById(R.id.leader_select_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameFragment.onViewCreated$lambda$0(view2);
            }
        });
        final CardView cardView = (CardView) view.findViewById(R.id.leader_badge);
        this.moveThreshold = ViewConfiguration.get(requireContext()).getScaledTouchSlop();
        cardView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda47
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return GameFragment.onViewCreated$lambda$1(this.f$0, cardView, view2);
            }
        });
        cardView.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda48
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return GameFragment.onViewCreated$lambda$2(this.f$0, cardView, view2, motionEvent);
            }
        });
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.GameFragment$onViewCreated$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                ActionBar supportActionBar;
                ActionBar supportActionBar2;
                if (this.this$0.getActivity() == null) {
                    return;
                }
                boolean gameFromPlaygroup = this.this$0.getGameFromPlaygroup();
                GameFragment gameFragment = this.this$0;
                if (gameFromPlaygroup) {
                    if (gameFragment.getBinding().viewPager.getCurrentItem() <= 0 || !this.this$0.isVisible) {
                        if (this.this$0.getBinding().viewPager.getVisibility() != 0) {
                            setEnabled(false);
                            this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                            setEnabled(true);
                            return;
                        }
                        this.this$0.getBinding().viewPager.setVisibility(8);
                        this.this$0.getBinding().toolbar.setVisibility(8);
                        this.this$0.getBinding().fragmentContainer.setVisibility(0);
                        this.this$0.newGameFragment = NewGameFragment.INSTANCE.newInstance();
                        NewGameFragment newGameFragment = this.this$0.newGameFragment;
                        if (newGameFragment != null) {
                            FragmentTransaction fragmentTransactionBeginTransaction = this.this$0.getChildFragmentManager().beginTransaction();
                            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                            fragmentTransactionBeginTransaction.replace(R.id.fragment_container, newGameFragment);
                            fragmentTransactionBeginTransaction.commit();
                            return;
                        }
                        return;
                    }
                    this.this$0.getBinding().viewPager.setCurrentItem(r0.getCurrentItem() - 1);
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity instanceof AppCompatActivity) {
                        int currentItem = this.this$0.getBinding().viewPager.getCurrentItem();
                        if (currentItem == 0) {
                            ActionBar supportActionBar3 = ((AppCompatActivity) activity).getSupportActionBar();
                            if (supportActionBar3 != null) {
                                supportActionBar3.setTitle(this.this$0.getString(R.string.title_playgroup_users));
                                return;
                            }
                            return;
                        }
                        if (currentItem != 1) {
                            if (currentItem == 2 && (supportActionBar2 = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                                supportActionBar2.setTitle(this.this$0.getString(R.string.title_layout));
                                return;
                            }
                            return;
                        }
                        ActionBar supportActionBar4 = ((AppCompatActivity) activity).getSupportActionBar();
                        if (supportActionBar4 != null) {
                            supportActionBar4.setTitle(this.this$0.getString(R.string.title_playgroup_format));
                            return;
                        }
                        return;
                    }
                    return;
                }
                int currentItem2 = gameFragment.getBinding().viewPager.getCurrentItem();
                PreferencesManager preferencesManager = null;
                if (currentItem2 <= 0 || !this.this$0.isVisible) {
                    if (this.this$0.getBinding().viewPager.getVisibility() == 0) {
                        PreferencesManager preferencesManager2 = this.this$0.prefs;
                        if (preferencesManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        } else {
                            preferencesManager = preferencesManager2;
                        }
                        if (preferencesManager.hasValidUser()) {
                            this.this$0.getBinding().viewPager.setVisibility(8);
                            this.this$0.getBinding().toolbar.setVisibility(8);
                            this.this$0.getBinding().fragmentContainer.setVisibility(0);
                            this.this$0.newGameFragment = NewGameFragment.INSTANCE.newInstance();
                            NewGameFragment newGameFragment2 = this.this$0.newGameFragment;
                            if (newGameFragment2 != null) {
                                FragmentTransaction fragmentTransactionBeginTransaction2 = this.this$0.getChildFragmentManager().beginTransaction();
                                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                                fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, newGameFragment2);
                                fragmentTransactionBeginTransaction2.commit();
                                return;
                            }
                            return;
                        }
                    }
                    setEnabled(false);
                    this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                    setEnabled(true);
                    return;
                }
                this.this$0.getBinding().viewPager.setCurrentItem(r0.getCurrentItem() - 1);
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 instanceof AppCompatActivity) {
                    if (this.this$0.getBinding().viewPager.getCurrentItem() == 0) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) activity2;
                        ActionBar supportActionBar5 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar5 != null) {
                            supportActionBar5.setDisplayOptions(0, 2);
                        }
                        ActionBar supportActionBar6 = appCompatActivity.getSupportActionBar();
                        if (supportActionBar6 != null) {
                            supportActionBar6.setDisplayHomeAsUpEnabled(false);
                        }
                        PreferencesManager preferencesManager3 = this.this$0.prefs;
                        if (preferencesManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        } else {
                            preferencesManager = preferencesManager3;
                        }
                        if (preferencesManager.hasValidUser()) {
                            ActionBar supportActionBar7 = appCompatActivity.getSupportActionBar();
                            if (supportActionBar7 != null) {
                                supportActionBar7.setDisplayOptions(2, 0);
                            }
                            ActionBar supportActionBar8 = appCompatActivity.getSupportActionBar();
                            if (supportActionBar8 != null) {
                                supportActionBar8.setDisplayHomeAsUpEnabled(true);
                            }
                        }
                    }
                    int currentItem3 = this.this$0.getBinding().viewPager.getCurrentItem();
                    if (currentItem3 == 0) {
                        ActionBar supportActionBar9 = ((AppCompatActivity) activity2).getSupportActionBar();
                        if (supportActionBar9 != null) {
                            supportActionBar9.setTitle(this.this$0.getString(R.string.title_playgroup_format));
                            return;
                        }
                        return;
                    }
                    if (currentItem3 != 1) {
                        if (currentItem3 == 2 && (supportActionBar = ((AppCompatActivity) activity2).getSupportActionBar()) != null) {
                            supportActionBar.setTitle(this.this$0.getString(R.string.title_layout));
                            return;
                        }
                        return;
                    }
                    ActionBar supportActionBar10 = ((AppCompatActivity) activity2).getSupportActionBar();
                    if (supportActionBar10 != null) {
                        supportActionBar10.setTitle(this.this$0.getString(R.string.title_players));
                    }
                }
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            appCompatActivity.setSupportActionBar(getBinding().toolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle(getString(R.string.title_playgroup_format));
            }
        }
        this.adapter = new QuestionPagerAdapter();
        ViewPager2 viewPager2 = getBinding().viewPager;
        FragmentStateAdapter fragmentStateAdapter = this.adapter;
        PreferencesManager preferencesManager = null;
        if (fragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fragmentStateAdapter = null;
        }
        viewPager2.setAdapter(fragmentStateAdapter);
        getBinding().viewPager.setUserInputEnabled(false);
        getBinding().viewPager.setPageTransformer(new FadePageTransformer());
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext);
        this.prefs = preferencesManager2;
        if (!preferencesManager2.getBoolean(PreferencesManager.GAME_TUTORIAL_SHOWN, false)) {
            this.isTutorial = true;
            startTutorial();
            setupForTutorial();
            fadeIn();
            return;
        }
        PreferencesManager preferencesManager3 = this.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        boolean zHasGame = preferencesManager3.hasGame();
        PreferencesManager preferencesManager4 = this.prefs;
        if (zHasGame) {
            if (preferencesManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
            } else {
                preferencesManager = preferencesManager4;
            }
            GameState currentGame = preferencesManager.getCurrentGame();
            if (currentGame != null) {
                getSharedViewModel().setGameState(currentGame);
                gameReady();
                return;
            }
            return;
        }
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager4 = null;
        }
        if (!preferencesManager4.hasValidUser()) {
            setupPlainNewGame();
            getSharedViewModel().getGameState().setGameSyncable(false);
            return;
        }
        PreferencesManager preferencesManager5 = this.prefs;
        if (preferencesManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager = preferencesManager5;
        }
        preferencesManager.clearAllUsersDecks();
        NewGameFragment newGameFragmentNewInstance = NewGameFragment.INSTANCE.newInstance();
        this.newGameFragment = newGameFragmentNewInstance;
        if (newGameFragmentNewInstance != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.replace(R.id.fragment_container, newGameFragmentNewInstance);
            fragmentTransactionBeginTransaction.commit();
        }
        getBinding().fragmentContainer.setVisibility(0);
        getBinding().toolbar.setVisibility(8);
        getBinding().viewPager.setVisibility(8);
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void planechaseValueChanged(boolean value) {
        if (getContext() == null) {
            return;
        }
        getSharedViewModel().getGameState().setHasPlanechase(value);
        if (getSharedViewModel().getGameState().getHasPlanechase()) {
            getSharedViewModel().getGameState().setHasArchenemy(false);
        }
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enablePlanechase(value);
        }
        if (value) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            getSharedViewModel().getGameState().setPlanechaseSeed(companion.ensurePlanarDeck(contextRequireContext, getSharedViewModel().getGameState()));
        }
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
    }

    @Override // com.studiolaganne.lengendarylens.GamePlayersFragment.PlayersSetupCallback
    public void playersSelected(int value) {
        ActionBar supportActionBar;
        MTUser currentUser;
        if (getContext() == null) {
            return;
        }
        getSharedViewModel().getGameState().setNumberOfPlayers(value);
        getSharedViewModel().getGameState().getPlayers().clear();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.hasValidUser() && getSharedViewModel().getGameState().getGameSyncable() && (currentUser = preferencesManager.getCurrentUser()) != null) {
            List<MTUser> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserCache());
            mutableList.add(currentUser);
            preferencesManager.saveCurrentUserCache(mutableList);
        }
        int i = 0;
        while (i < value) {
            Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            int i2 = i + 1;
            player.setName(getResources().getString(R.string.player) + " " + i2);
            ArrayList arrayList = new ArrayList(value);
            for (int i3 = 0; i3 < value; i3++) {
                arrayList.add(0);
            }
            player.setCommanderDamageList(arrayList);
            ArrayList arrayList2 = new ArrayList(value);
            for (int i4 = 0; i4 < value; i4++) {
                arrayList2.add(0);
            }
            player.setCommanderDamageListPartner(arrayList2);
            player.setUserId(-(i + 10));
            getSharedViewModel().getGameState().getPlayers().add(player);
            i = i2;
        }
        switch (value) {
            case 1:
                ViewPager2 viewPager2 = getBinding().viewPager;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                break;
            case 2:
                ViewPager2 viewPager22 = getBinding().viewPager;
                viewPager22.setCurrentItem(viewPager22.getCurrentItem() + 1);
                break;
            case 3:
                ViewPager2 viewPager23 = getBinding().viewPager;
                viewPager23.setCurrentItem(viewPager23.getCurrentItem() + 1);
                break;
            case 4:
                ViewPager2 viewPager24 = getBinding().viewPager;
                viewPager24.setCurrentItem(viewPager24.getCurrentItem() + 1);
                break;
            case 5:
                ViewPager2 viewPager25 = getBinding().viewPager;
                viewPager25.setCurrentItem(viewPager25.getCurrentItem() + 1);
                break;
            case 6:
                ViewPager2 viewPager26 = getBinding().viewPager;
                viewPager26.setCurrentItem(viewPager26.getCurrentItem() + 1);
                break;
            case 7:
                ViewPager2 viewPager27 = getBinding().viewPager;
                viewPager27.setCurrentItem(viewPager27.getCurrentItem() + 1);
                break;
            case 8:
                ViewPager2 viewPager28 = getBinding().viewPager;
                viewPager28.setCurrentItem(viewPager28.getCurrentItem() + 1);
                break;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof AppCompatActivity) || (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(getString(R.string.title_layout));
    }

    @Override // com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment.PlaygroupUsersSetupCallback
    public void playersSelectedFromPlaygroup(List<Integer> userIds) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!preferencesManager.hasValidUser() || preferencesManager.getCurrentUser() == null) {
            return;
        }
        Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((MTPlaygroup) next).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTPlaygroup mTPlaygroup = (MTPlaygroup) next;
        if (mTPlaygroup != null) {
            getSharedViewModel().getGameState().setNumberOfPlayers(Integer.min(userIds.size(), 8));
            getSharedViewModel().getGameState().getPlayers().clear();
            Iterator<T> it2 = userIds.iterator();
            int i = 0;
            while (it2.hasNext()) {
                i++;
                int iIntValue = ((Number) it2.next()).intValue();
                Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                player.setUserId(iIntValue);
                Iterator<T> it3 = mTPlaygroup.getUsers().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        next2 = it3.next();
                        if (((MTUser) next2).getId() == iIntValue) {
                            break;
                        }
                    } else {
                        next2 = null;
                        break;
                    }
                }
                MTUser mTUser = (MTUser) next2;
                if (mTUser != null) {
                    String firstname = mTUser.getFirstname();
                    if (firstname == null) {
                        firstname = getResources().getString(R.string.player) + " " + i;
                    }
                    player.setName(firstname);
                }
                int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                ArrayList arrayList = new ArrayList(numberOfPlayers);
                for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                    arrayList.add(0);
                }
                player.setCommanderDamageList(arrayList);
                int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                ArrayList arrayList2 = new ArrayList(numberOfPlayers2);
                for (int i3 = 0; i3 < numberOfPlayers2; i3++) {
                    arrayList2.add(0);
                }
                player.setCommanderDamageListPartner(arrayList2);
                getSharedViewModel().getGameState().getPlayers().add(player);
            }
            FragmentActivity activity = getActivity();
            if (activity instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(getString(R.string.title_playgroup_format));
                }
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setDisplayOptions(2, 2);
                }
                ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setDisplayHomeAsUpEnabled(true);
                }
            }
            ViewPager2 viewPager2 = getBinding().viewPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void poisonCountersValueChanged(boolean value) {
        getSharedViewModel().getGameState().setHasPoisonCounters(value);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enablePoisonCounters(value);
        }
    }

    public final void setFullscreen(boolean z) {
        this.fullscreen = z;
    }

    public final void setGameFromPlaygroup(boolean z) {
        this.gameFromPlaygroup = z;
    }

    public final void setGameSyncable(boolean z) {
        this.gameSyncable = z;
    }

    public final void setupNewGameFromPlaygroup(int playgroupId) {
        if (getContext() == null) {
            return;
        }
        this.gamePlayerResultsMode = false;
        newGameFromPlaygroup(playgroupId);
    }

    @Override // com.studiolaganne.lengendarylens.GameCallback
    public void startGamePressed() {
        PreferencesManager preferencesManager;
        GameFragmentBase gameFragmentBase;
        Map<String, List<MTDeck>> value;
        String str;
        int i;
        int i2;
        int i3;
        Object next;
        GameFragmentBase gameFragmentBase2;
        if (getContext() == null || this._binding == null || this.gamePlayerResultsMode) {
            return;
        }
        GameFragmentBase gameFragmentBase3 = this.currentGameFragment;
        if (gameFragmentBase3 != null) {
            gameFragmentBase3.applySeatingAndDecks();
            gameFragmentBase3.hideMenuAsClose();
            gameFragmentBase3.hideStartGameButton();
            gameFragmentBase3.showMenu();
            Iterator<LifeTotalView> it = gameFragmentBase3.getLifeViews().iterator();
            while (it.hasNext()) {
                it.next().hideUsersAndDecks();
            }
            if (getSharedViewModel().getGameState().getHasPlanechase()) {
                gameFragmentBase3.enablePlanechase(true);
            }
            if (getSharedViewModel().getGameState().getHasArchenemy()) {
                gameFragmentBase3.enableArchenemy(true);
            }
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragment.startGamePressed$lambda$0$0$0(this.f$0);
                    }
                }, 1000L);
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 5 || getSharedViewModel().getGameState().getSubformatId() == 6) {
                gameFragmentBase3.setupTeams();
            }
        }
        PreferencesManager preferencesManager2 = this.prefs;
        String str2 = "prefs";
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        GameSet currentSet = preferencesManager2.getCurrentSet();
        int i4 = 2;
        boolean z = false;
        if (currentSet != null && getSharedViewModel().getGameState().getPlayers().size() == 2) {
            int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet);
            int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet);
            GameFragmentBase gameFragmentBase4 = this.currentGameFragment;
            if (gameFragmentBase4 != null) {
                gameFragmentBase4.showBestOfScore(playerScore, playerScore2);
            }
        }
        boolean z2 = getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed();
        if (getSharedViewModel().getGameState().getTimerEnabled() && !z2) {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerStart.getValue(), 0, null, getSharedViewModel().getGameState().getTimerTotalTime(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            if (getSharedViewModel().getGameState().getTimerStartTime() == 0) {
                getSharedViewModel().getGameState().setTimerStartTime(System.currentTimeMillis());
            }
            GameFragmentBase gameFragmentBase5 = this.currentGameFragment;
            if (gameFragmentBase5 != null) {
                gameFragmentBase5.showClock();
                gameFragmentBase5.updateClock();
                PreferencesManager preferencesManager3 = this.prefs;
                if (preferencesManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager3 = null;
                }
                if (!preferencesManager3.getBoolean(PreferencesManager.AUTO_START_TIMER, true)) {
                    gameFragmentBase5.toggleTimerPause();
                }
            }
        }
        PreferencesManager preferencesManager4 = this.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager4 = null;
        }
        if (preferencesManager4.getBoolean(PreferencesManager.ENABLE_COMMANDER_TAX_BY_DEFAULT, false)) {
            int formatId = getSharedViewModel().getGameState().getFormatId();
            Context context = getContext();
            if (context != null) {
                Iterator<T> it2 = DecksDBHelper.INSTANCE.getInstance(context).getFormats().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (((MTFormat) next).getId() == formatId) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                MTFormat mTFormat = (MTFormat) next;
                if (mTFormat != null && mTFormat.getHascommander() && (gameFragmentBase2 = this.currentGameFragment) != null) {
                    gameFragmentBase2.enableCommanderTaxGlobally();
                }
            }
        }
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        int i5 = 0;
        boolean z3 = false;
        while (i5 < numberOfPlayers) {
            Player player = getSharedViewModel().getGameState().getPlayers().get(i5);
            if (player.getDeckId() != -1 && (value = getSharedViewModel().getDecks().getValue()) != null) {
                Iterator<T> it3 = value.keySet().iterator();
                while (it3.hasNext()) {
                    List<MTDeck> list = value.get((String) it3.next());
                    if (list != null) {
                        for (MTDeck mTDeck : list) {
                            if (mTDeck.getId() == player.getDeckId()) {
                                String commander = mTDeck.getCommander();
                                int i6 = numberOfPlayers;
                                if (commander != null) {
                                    String str3 = commander;
                                    str = str2;
                                    i = i5;
                                    if (StringsKt.contains$default((CharSequence) str3, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, i4, (Object) null)) {
                                        List listSplit$default = StringsKt.split$default((CharSequence) str3, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                                        commander = (String) listSplit$default.get(0);
                                        i3 = Integer.parseInt((String) listSplit$default.get(1));
                                    } else {
                                        i3 = 0;
                                    }
                                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                                    Context contextRequireContext = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                                    CardRecord cardLocal = companion.getCardLocal(contextRequireContext, commander, i3);
                                    if (cardLocal != null) {
                                        String strTranslateTag = SearchDataUtils.INSTANCE.getInstance().translateTag("poison", cardLocal.getLang());
                                        String strTranslateTag2 = SearchDataUtils.INSTANCE.getInstance().translateTag("counter", cardLocal.getLang());
                                        String lowerCase = cardLocal.getOracle_text().toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) strTranslateTag, false, 2, (Object) null)) {
                                            String lowerCase2 = cardLocal.getOracle_text().toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) strTranslateTag2, false, 2, (Object) null)) {
                                                z3 = true;
                                            }
                                        }
                                    }
                                } else {
                                    str = str2;
                                    i = i5;
                                }
                                String partner = mTDeck.getPartner();
                                if (partner != null) {
                                    String str4 = partner;
                                    if (StringsKt.contains$default((CharSequence) str4, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                                        List listSplit$default2 = StringsKt.split$default((CharSequence) str4, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                                        String str5 = (String) listSplit$default2.get(0);
                                        i2 = Integer.parseInt((String) listSplit$default2.get(1));
                                        partner = str5;
                                    } else {
                                        i2 = 0;
                                    }
                                    GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                                    Context contextRequireContext2 = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                                    CardRecord cardLocal2 = companion2.getCardLocal(contextRequireContext2, partner, i2);
                                    if (cardLocal2 != null) {
                                        String strTranslateTag3 = SearchDataUtils.INSTANCE.getInstance().translateTag("poison", cardLocal2.getLang());
                                        String strTranslateTag4 = SearchDataUtils.INSTANCE.getInstance().translateTag("counter", cardLocal2.getLang());
                                        i4 = 2;
                                        if (StringsKt.contains$default((CharSequence) cardLocal2.getOracle_text(), (CharSequence) strTranslateTag3, false, 2, (Object) null) && StringsKt.contains$default((CharSequence) cardLocal2.getOracle_text(), (CharSequence) strTranslateTag4, false, 2, (Object) null)) {
                                            z3 = true;
                                        }
                                    } else {
                                        i4 = 2;
                                    }
                                    numberOfPlayers = i6;
                                    str2 = str;
                                    i5 = i;
                                } else {
                                    numberOfPlayers = i6;
                                    str2 = str;
                                    i5 = i;
                                    i4 = 2;
                                }
                            }
                        }
                    }
                    numberOfPlayers = numberOfPlayers;
                    str2 = str2;
                    i5 = i5;
                }
            }
            i5++;
            numberOfPlayers = numberOfPlayers;
            str2 = str2;
        }
        String str6 = str2;
        if (z3) {
            getSharedViewModel().getGameState().setHasPoisonCounters(true);
            GameFragmentBase gameFragmentBase6 = this.currentGameFragment;
            if (gameFragmentBase6 != null) {
                gameFragmentBase6.enablePoisonCounters(true);
            }
        }
        PreferencesManager preferencesManager5 = this.prefs;
        if (preferencesManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str6);
            preferencesManager5 = null;
        }
        preferencesManager5.saveCurrentGame(getSharedViewModel().getGameState());
        PreferencesManager preferencesManager6 = this.prefs;
        if (preferencesManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str6);
            preferencesManager6 = null;
        }
        boolean z4 = preferencesManager6.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true);
        if (getSharedViewModel().getGameState().getSubformatId() != 3) {
            z = z4;
        } else if (!GameUtils.INSTANCE.getInstance().isLeaderRevealed(getSharedViewModel().getGameState())) {
            showLeaderRevealDialog();
            getSharedViewModel().getGameState().setTossAlreadyDone(true);
            PreferencesManager preferencesManager7 = this.prefs;
            if (preferencesManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str6);
                preferencesManager7 = null;
            }
            preferencesManager7.saveCurrentGame(getSharedViewModel().getGameState());
        }
        if (z && !getSharedViewModel().getGameState().getTossAlreadyDone() && getSharedViewModel().getGameState().getNumberOfPlayers() > 1) {
            getBinding().viewPager.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.startGamePressed$lambda$6(this.f$0);
                }
            }, 250L);
        }
        PreferencesManager preferencesManager8 = this.prefs;
        if (preferencesManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str6);
            preferencesManager = null;
        } else {
            preferencesManager = preferencesManager8;
        }
        if (preferencesManager.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true) || (gameFragmentBase = this.currentGameFragment) == null) {
            return;
        }
        gameFragmentBase.playerTossSkipped();
    }

    @Override // com.studiolaganne.lengendarylens.GameStartingLifeFragment.LifeSetupCallback
    public void startingLifeSelected(int value) {
        getSharedViewModel().getGameState().setStartingLifeTotal(value);
        ViewPager2 viewPager2 = getBinding().viewPager;
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle(getString(R.string.title_players));
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void theRingCoinDragged() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("the_ring_coin_dragged");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("the_ring_coin_dragged", null);
        closeMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void timerEnabledValueChanged(boolean value) {
        GameFragmentBase gameFragmentBase;
        getSharedViewModel().getGameState().setTimerEnabled(value);
        if (getSharedViewModel().getGameState().getTimerEnabled() && getSharedViewModel().getGameState().getTimerStartTime() == 0) {
            getSharedViewModel().getGameState().setTimerStartTime(System.currentTimeMillis());
            if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed() && (gameFragmentBase = this.currentGameFragment) != null) {
                gameFragmentBase.dismissTurnTimerPromptManually();
            }
            List<MTGameEvent> events = getSharedViewModel().getGameState().getEvents();
            if ((events instanceof Collection) && events.isEmpty()) {
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerStart.getValue(), 0, null, getSharedViewModel().getGameState().getTimerTotalTime(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            } else {
                Iterator<T> it = events.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((MTGameEvent) it.next()).getType(), MTEvent.TimerStart.getValue())) {
                        break;
                    }
                }
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerStart.getValue(), 0, null, getSharedViewModel().getGameState().getTimerTotalTime(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            }
        }
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        GameFragmentBase gameFragmentBase2 = this.currentGameFragment;
        if (gameFragmentBase2 != null) {
            if (!value && !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                gameFragmentBase2.hideClock();
            } else {
                gameFragmentBase2.showClock();
                gameFragmentBase2.updateClock();
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void timerValueChanged(int minutes) {
        getSharedViewModel().getGameState().setTimerTotalTime(minutes);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        GameFragmentBase gameFragmentBase = this.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.updateClock();
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback
    public void turnTimersEnabledValueChanged(boolean value) {
        GameFragmentBase gameFragmentBase;
        getSharedViewModel().getGameState().setTurnTimerEnabled(value);
        PreferencesManager preferencesManager = null;
        int i = 0;
        if (value) {
            if (getSharedViewModel().getGameState().getTossAlreadyDone()) {
                int startingPlayerIndex = getSharedViewModel().getGameState().getStartingPlayerIndex();
                GameFragmentBase gameFragmentBase2 = this.currentGameFragment;
                if (startingPlayerIndex == -1) {
                    if (gameFragmentBase2 != null) {
                        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                        while (i < numberOfPlayers) {
                            gameFragmentBase2.getLifeViews().get(i).triggerPlayerStartQ();
                            i++;
                        }
                    }
                } else if (gameFragmentBase2 != null) {
                    gameFragmentBase2.getLifeViews().get(getSharedViewModel().getGameState().getStartingPlayerIndex()).showFirstTurnPrompt();
                }
            } else {
                PreferencesManager preferencesManager2 = this.prefs;
                if (preferencesManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager2 = null;
                }
                if (preferencesManager2.getBoolean(PreferencesManager.ENABLE_PLAYER_TOSS, true)) {
                    runPlayerToss(true);
                } else {
                    GameFragmentBase gameFragmentBase3 = this.currentGameFragment;
                    if (gameFragmentBase3 != null) {
                        int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                        while (i < numberOfPlayers2) {
                            gameFragmentBase3.getLifeViews().get(i).triggerPlayerStartQ();
                            i++;
                        }
                    }
                }
            }
            PreferencesManager preferencesManager3 = this.prefs;
            if (preferencesManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
            } else {
                preferencesManager = preferencesManager3;
            }
            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
            return;
        }
        if (getSharedViewModel().getGameState().getTimerPaused() && (gameFragmentBase = this.currentGameFragment) != null) {
            gameFragmentBase.toggleTimerPause();
        }
        boolean timerEnabled = getSharedViewModel().getGameState().getTimerEnabled();
        GameFragmentBase gameFragmentBase4 = this.currentGameFragment;
        if (timerEnabled) {
            if (gameFragmentBase4 != null) {
                gameFragmentBase4.updateClock();
                gameFragmentBase4.hideTurnCounterUI();
            }
        } else if (gameFragmentBase4 != null) {
            gameFragmentBase4.hideClock();
            gameFragmentBase4.hideTurnCounterUI();
        }
        CollectionsKt.removeAll((List) getSharedViewModel().getGameState().getEvents(), new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GameFragment.turnTimersEnabledValueChanged$lambda$6((MTGameEvent) obj));
            }
        });
        GameFragmentBase gameFragmentBase5 = this.currentGameFragment;
        if (gameFragmentBase5 != null) {
            for (LifeTotalView lifeTotalView : gameFragmentBase5.getLifeViews()) {
                lifeTotalView.setIsCurrentPlayerTurn(false, 0);
                lifeTotalView.hidePlayerTurnUI();
                lifeTotalView.hidePauseUI();
                lifeTotalView.hideUndoNextTurnUI();
                lifeTotalView.hideFirstTurnPrompt();
            }
        }
        PreferencesManager preferencesManager4 = this.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager = preferencesManager4;
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
    }

    @Override // com.studiolaganne.lengendarylens.GameCallback
    public void tutorialComplete() {
        if (getContext() == null) {
            return;
        }
        this.tutorialButtonDisabled = false;
        this.isTutorial = false;
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_TUTORIAL_SHOWN, true);
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager2, null, 1, null);
        View view = getView();
        final ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.tutorial_overlay) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (constraintLayout != null) {
            constraintLayout.setAlpha(0.0f);
        }
        TextView textView = constraintLayout != null ? (TextView) constraintLayout.findViewById(R.id.tutorial_text) : null;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.ready_for_new_game));
        }
        if (constraintLayout != null) {
            constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment.tutorialComplete$lambda$0(constraintLayout, this);
                }
            }, 500L);
        }
    }
}
