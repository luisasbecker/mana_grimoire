package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.CustomDialogFragmentSquare;
import com.studiolaganne.lengendarylens.GameFragment4PlayersType1;
import com.studiolaganne.lengendarylens.TimerLeftFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGame4PlayersType1Binding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: GameFragment4PlayersType1.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\"\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\fH\u0016J\u001a\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010,\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment4PlayersType1;", "Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGame4PlayersType1Binding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGame4PlayersType1Binding;", "callback", "Lcom/studiolaganne/lengendarylens/GameCallback;", "onAttach", "", "context", "Landroid/content/Context;", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "showStartGameButton", "hideStartGameButton", "dayNightToggled", "isOn", "", "planechaseToggled", "archenemyToggled", "updateTeams", "showCountersDialogFor", "teamLifeView", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "counterType", "Lcom/studiolaganne/lengendarylens/CounterType;", "playerIndex", "", "setupTeams", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment4PlayersType1 extends GameFragmentBase {
    private FragmentGame4PlayersType1Binding _binding;
    private GameCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameFragment4PlayersType1.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment4PlayersType1$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameFragment4PlayersType1;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameFragment4PlayersType1 newInstance() {
            return new GameFragment4PlayersType1();
        }
    }

    /* JADX INFO: compiled from: GameFragment4PlayersType1.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CounterType.values().length];
            try {
                iArr[CounterType.Tax.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CounterType.Storm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CounterType.Experience.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CounterType.Radiation.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CounterType.Energy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1, reason: invalid class name */
    /* JADX INFO: compiled from: GameFragment4PlayersType1.kt */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010B\u001a\u00020C2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010D\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010H\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010N\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0007H\u0016J\u0018\u0010P\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010T\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0018\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0018\u0010V\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\rH\u0016J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006^"}, d2 = {"com/studiolaganne/lengendarylens/GameFragment4PlayersType1$setupTeams$1", "Lcom/studiolaganne/lengendarylens/LifeTotalViewCallback;", "lifeTotalChanged", "", "sender", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "newValue", "", "poisonCounterTapped", Key.ROTATION, "commanderDamageTapped", "confirmPlayerDeath", "fromMenu", "", "theRingCoinDropped", "theRingCoinRejected", "cityCoinDropped", "cityCoinRejected", "monarchCoinDropped", "monarchCoinRejected", "initiativeCoinDropped", "initiativeCoinRejected", "commanderDamageClosed", "commanderDamageValueChanged", "commanderDamageRunningTotalChanged", "playerIsKO", "contextStr", "", "undoPlayerDeath", "confirmPlayerWin", "undoPlayerWin", "playerIsWin", "partnersToggled", "playmatSelected", "id", "signalCardScanInProgress", "signalPhotoPickInProgress", "commanderDamagePartnerValueChanged", "commanderDamagePartnerRunningTotalChanged", "editPlayerNameTapped", "currentName", "ownCmdDamageTapped", "orientation", "pickAColor", "leftPicked", "rightPicked", "energyToggled", "stormToggled", "experienceToggled", "taxToggled", "radiationToggled", "poisonToggled", "energyCounterTapped", "stormCounterTapped", "experienceCounterTapped", "taxCounterTapped", "radiationCounterTapped", "playgroupUserSelected", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "previousUserId", "playgroupUserUnselected", "currentUserId", "currentUserSelected", "currentUserUnselected", "mythicUserSelected", "friend", "Lcom/studiolaganne/lengendarylens/MTFriend;", "mythicUserUnselected", "guestUserSelected", "guestUserUnselected", "qrScanSelected", "playgroupDeckSelected", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "userId", "endOfGame", "deckCleared", "lifeTotalChangeCommitted", "delta", "treacheryRoleRevealed", "role", "swipeMenuOpened", "swipeMenuClosed", "createDeckForGuest", "createDeckForMythicUser", "playerIsPlayingFirst", "playingFirst", "confirmPlayerConcede", "confirmPlayerDraw", "playerTapToStartTapped", "pauseTimerToggled", "undoNextTurnTapped", "endTurnTapped", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements LifeTotalViewCallback {
        AnonymousClass1() {
        }

        static final Unit cityCoinDropped$lambda$6(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.cityCoinDropped(lifeTotalView1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit cityCoinDropped$lambda$7(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType1.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType1.cityCoinDropped(lifeTotalView2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit commanderDamageTapped$lambda$2(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeViewTeam1 = gameFragment4PlayersType1.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.setVisibility(8);
            }
            LifeTotalView lifeViewTeam2 = gameFragment4PlayersType1.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.setVisibility(8);
            }
            gameFragment4PlayersType1.getBinding().lifeTotalView1.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView2.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView3.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView4.setVisibility(0);
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.commanderDamageTapped(lifeTotalView1, i);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit commanderDamageTapped$lambda$3(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeViewTeam1 = gameFragment4PlayersType1.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.setVisibility(8);
            }
            LifeTotalView lifeViewTeam2 = gameFragment4PlayersType1.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.setVisibility(8);
            }
            gameFragment4PlayersType1.getBinding().lifeTotalView1.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView2.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView3.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView4.setVisibility(0);
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType1.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType1.commanderDamageTapped(lifeTotalView2, i);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit energyCounterTapped$lambda$12(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Energy, 0);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit energyCounterTapped$lambda$13(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Energy, 3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit experienceCounterTapped$lambda$16(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Experience, 0);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit experienceCounterTapped$lambda$17(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Experience, 3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit initiativeCoinDropped$lambda$10(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.initiativeCoinDropped(lifeTotalView1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit initiativeCoinDropped$lambda$11(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType1.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType1.initiativeCoinDropped(lifeTotalView2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit monarchCoinDropped$lambda$8(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.monarchCoinDropped(lifeTotalView1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit monarchCoinDropped$lambda$9(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType1.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType1.monarchCoinDropped(lifeTotalView2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit poisonCounterTapped$lambda$0(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, boolean z) {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).setPoisonCounters(i);
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setPoisonCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getPoisonCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.checkVitals();
            Context context = gameFragment4PlayersType1.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
            }
            gameFragment4PlayersType1.updateStreamingState$app_release();
            return Unit.INSTANCE;
        }

        static final Unit poisonCounterTapped$lambda$1(GameFragment4PlayersType1 gameFragment4PlayersType1, int i) {
            LifeTotalView lifeViewTeam1;
            int poisonCounters = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters() - i;
            if (poisonCounters != 0) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Poison.getValue(), 0, null, poisonCounters, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                Context context = gameFragment4PlayersType1.getContext();
                if (context != null) {
                    new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
                }
            }
            if (gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters() >= ((gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 5 || gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 6) ? 15 : 10) && (lifeViewTeam1 = gameFragment4PlayersType1.getLifeViewTeam1()) != null) {
                lifeViewTeam1.triggerPlayerDeadQ("", false);
            }
            gameFragment4PlayersType1.updateStreamingState$app_release();
            return Unit.INSTANCE;
        }

        static final Unit radiationCounterTapped$lambda$20(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Radiation, 0);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit radiationCounterTapped$lambda$21(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Radiation, 3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit stormCounterTapped$lambda$14(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Storm, 0);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit stormCounterTapped$lambda$15(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Storm, 3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit taxCounterTapped$lambda$18(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Tax, 0);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit taxCounterTapped$lambda$19(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam1(), CounterType.Tax, 3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit theRingCoinDropped$lambda$4(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.theRingCoinDropped(lifeTotalView1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit theRingCoinDropped$lambda$5(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType1.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType1.theRingCoinDropped(lifeTotalView2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void cityCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_city_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.cityCoinDropped$lambda$6(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.cityCoinDropped$lambda$7(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerCity");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void cityCoinRejected() {
            GameFragment4PlayersType1.this.cityCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageClosed(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamagePartnerRunningTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamagePartnerValueChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageRunningTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageTapped(LifeTotalView sender, final int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_cmd);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_cmd_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.commanderDamageTapped$lambda$2(gameFragment4PlayersType1, rotation, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.commanderDamageTapped$lambda$3(gameFragment4PlayersType12, rotation, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerCMD");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageValueChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerConcede(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.triggerPlayerDeadQ("concede", true);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerDeath(LifeTotalView sender, boolean fromMenu) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.triggerPlayerDeadQ("", fromMenu);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerDraw(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.triggerPlayerDeadQ("draw", true);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.triggerPlayerWinQ();
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void createDeckForGuest(LifeTotalView sender, int userId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void createDeckForMythicUser(LifeTotalView sender, int userId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void currentUserSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void currentUserUnselected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void deckCleared(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void editPlayerNameTapped(LifeTotalView sender, String currentName) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(currentName, "currentName");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void endTurnTapped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.endTurnTapped(lifeTotalView1);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void energyCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_energy_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.energyCounterTapped$lambda$12(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.energyCounterTapped$lambda$13(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerEnergy");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void energyToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.energyToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.energyToggled(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void experienceCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_experience_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.experienceCounterTapped$lambda$16(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.experienceCounterTapped$lambda$17(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void experienceToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.experienceToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.experienceToggled(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void guestUserSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void guestUserUnselected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void initiativeCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_initiative_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.initiativeCoinDropped$lambda$10(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.initiativeCoinDropped$lambda$11(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerInitiative");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void initiativeCoinRejected() {
            GameFragment4PlayersType1.this.initiativeCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void leftPicked(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void lifeTotalChangeCommitted(LifeTotalView sender, int delta) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.lifeTotalChangeCommitted(lifeTotalView1, delta);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.lifeTotalChangeCommitted(lifeTotalView2, delta);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void lifeTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.lifeTotalChanged(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.lifeTotalChanged(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void monarchCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_monarch_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.monarchCoinDropped$lambda$8(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.monarchCoinDropped$lambda$9(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerMonarch");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void monarchCoinRejected() {
            GameFragment4PlayersType1.this.monarchCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void mythicUserSelected(LifeTotalView sender, MTFriend friend, int previousUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(friend, "friend");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void mythicUserUnselected(LifeTotalView sender, int currentUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void ownCmdDamageTapped(LifeTotalView sender, int orientation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void partnersToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void pauseTimerToggled(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.pauseTimerToggled(lifeTotalView1);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void pickAColor(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsKO(LifeTotalView sender, String contextStr) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(contextStr, "contextStr");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.playerIsKO(lifeTotalView1, contextStr);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsPlayingFirst(LifeTotalView sender, boolean playingFirst) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.playerIsPlayingFirst(lifeTotalView1, playingFirst);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.playerIsWin(lifeTotalView1);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerTapToStartTapped(LifeTotalView sender) {
            LifeTotalView lifeTotalView;
            Intrinsics.checkNotNullParameter(sender, "sender");
            int startingPlayerIndex = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getStartingPlayerIndex();
            if (startingPlayerIndex == 0) {
                lifeTotalView = GameFragment4PlayersType1.this.getBinding().lifeTotalView1;
            } else if (startingPlayerIndex == 1) {
                lifeTotalView = GameFragment4PlayersType1.this.getBinding().lifeTotalView4;
            } else if (startingPlayerIndex != 2) {
                GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
                lifeTotalView = startingPlayerIndex != 3 ? gameFragment4PlayersType1.getBinding().lifeTotalView1 : gameFragment4PlayersType1.getBinding().lifeTotalView2;
            } else {
                lifeTotalView = GameFragment4PlayersType1.this.getBinding().lifeTotalView3;
            }
            if (lifeTotalView != null) {
                GameFragment4PlayersType1.this.playerTapToStartTapped(lifeTotalView);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupDeckSelected(LifeTotalView sender, MTDeck deck, int userId, boolean endOfGame) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(deck, "deck");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupUserSelected(LifeTotalView sender, MTUser user, int previousUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(user, "user");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupUserUnselected(LifeTotalView sender, int currentUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playmatSelected(LifeTotalView sender, String id) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(id, "id");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void poisonCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            final int poisonCounters = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters();
            LifeTotalView lifeTotalView = GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam1;
            CounterType counterType = CounterType.Poison;
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            Function2<? super Integer, ? super Boolean, Unit> function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment4PlayersType1.AnonymousClass1.poisonCounterTapped$lambda$0(gameFragment4PlayersType1, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                }
            };
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            lifeTotalView.showCountersDialog(counterType, function2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment4PlayersType1.AnonymousClass1.poisonCounterTapped$lambda$1(gameFragment4PlayersType12, poisonCounters);
                }
            });
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void poisonToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.poisonToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.poisonToggled(lifeTotalView2, newValue);
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.showPoisonCounters(newValue);
            }
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.showPoisonCounters(newValue);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void qrScanSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void radiationCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_radiation_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.radiationCounterTapped$lambda$20(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.radiationCounterTapped$lambda$21(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void radiationToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.radiationToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.radiationToggled(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void rightPicked(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void signalCardScanInProgress(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void signalPhotoPickInProgress(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void stormCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_storm_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.stormCounterTapped$lambda$14(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.stormCounterTapped$lambda$15(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void stormToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.stormToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.stormToggled(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void swipeMenuClosed(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void swipeMenuOpened(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void taxCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_tax_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.taxCounterTapped$lambda$18(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.taxCounterTapped$lambda$19(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void taxToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.taxToggled(lifeTotalView1, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.taxToggled(lifeTotalView2, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void theRingCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_the_ring_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(0).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.theRingCoinDropped$lambda$4(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(3).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$1$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass1.theRingCoinDropped$lambda$5(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(90);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerTheRing");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void theRingCoinRejected() {
            GameFragment4PlayersType1.this.theRingCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void treacheryRoleRevealed(LifeTotalView sender, int role) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoNextTurnTapped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.undoNextTurnTapped(lifeTotalView1);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoPlayerDeath(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.undoPlayerDeath(lifeTotalView1);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.undoPlayerDeath(lifeTotalView2);
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam1.undoKO();
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam2.undoWin();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoPlayerWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView1 = gameFragment4PlayersType1.getBinding().lifeTotalView1;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
            gameFragment4PlayersType1.undoPlayerWin(lifeTotalView1);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView2 = gameFragment4PlayersType12.getBinding().lifeTotalView2;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
            gameFragment4PlayersType12.undoPlayerWin(lifeTotalView2);
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam1.undoWin();
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam2.undoKO();
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2, reason: invalid class name */
    /* JADX INFO: compiled from: GameFragment4PlayersType1.kt */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0018\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010B\u001a\u00020C2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010D\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010H\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010N\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0007H\u0016J\u0018\u0010P\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010T\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0018\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0018\u0010V\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\rH\u0016J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006^"}, d2 = {"com/studiolaganne/lengendarylens/GameFragment4PlayersType1$setupTeams$2", "Lcom/studiolaganne/lengendarylens/LifeTotalViewCallback;", "lifeTotalChanged", "", "sender", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "newValue", "", "poisonCounterTapped", Key.ROTATION, "commanderDamageTapped", "confirmPlayerDeath", "fromMenu", "", "theRingCoinDropped", "theRingCoinRejected", "cityCoinDropped", "cityCoinRejected", "monarchCoinDropped", "monarchCoinRejected", "initiativeCoinDropped", "initiativeCoinRejected", "commanderDamageClosed", "commanderDamageValueChanged", "commanderDamageRunningTotalChanged", "playerIsKO", "contextStr", "", "undoPlayerDeath", "confirmPlayerWin", "undoPlayerWin", "playerIsWin", "partnersToggled", "playmatSelected", "id", "signalCardScanInProgress", "signalPhotoPickInProgress", "commanderDamagePartnerValueChanged", "commanderDamagePartnerRunningTotalChanged", "editPlayerNameTapped", "currentName", "ownCmdDamageTapped", "orientation", "leftPicked", "rightPicked", "pickAColor", "energyToggled", "stormToggled", "experienceToggled", "taxToggled", "radiationToggled", "poisonToggled", "energyCounterTapped", "stormCounterTapped", "experienceCounterTapped", "taxCounterTapped", "radiationCounterTapped", "playgroupUserSelected", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "previousUserId", "playgroupUserUnselected", "currentUserId", "currentUserSelected", "currentUserUnselected", "mythicUserSelected", "friend", "Lcom/studiolaganne/lengendarylens/MTFriend;", "mythicUserUnselected", "guestUserSelected", "guestUserUnselected", "qrScanSelected", "playgroupDeckSelected", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "userId", "endOfGame", "deckCleared", "lifeTotalChangeCommitted", "delta", "treacheryRoleRevealed", "role", "swipeMenuOpened", "swipeMenuClosed", "createDeckForGuest", "createDeckForMythicUser", "playerIsPlayingFirst", "playingFirst", "confirmPlayerConcede", "confirmPlayerDraw", "playerTapToStartTapped", "pauseTimerToggled", "undoNextTurnTapped", "endTurnTapped", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass2 implements LifeTotalViewCallback {
        AnonymousClass2() {
        }

        static final Unit cityCoinDropped$lambda$6(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.cityCoinDropped(lifeTotalView3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit cityCoinDropped$lambda$7(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType1.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType1.cityCoinDropped(lifeTotalView4);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit commanderDamageTapped$lambda$2(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeViewTeam1 = gameFragment4PlayersType1.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.setVisibility(8);
            }
            LifeTotalView lifeViewTeam2 = gameFragment4PlayersType1.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.setVisibility(8);
            }
            gameFragment4PlayersType1.getBinding().lifeTotalView1.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView2.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView3.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView4.setVisibility(0);
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.commanderDamageTapped(lifeTotalView3, i);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit commanderDamageTapped$lambda$3(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeViewTeam1 = gameFragment4PlayersType1.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.setVisibility(8);
            }
            LifeTotalView lifeViewTeam2 = gameFragment4PlayersType1.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.setVisibility(8);
            }
            gameFragment4PlayersType1.getBinding().lifeTotalView1.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView2.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView3.setVisibility(0);
            gameFragment4PlayersType1.getBinding().lifeTotalView4.setVisibility(0);
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType1.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType1.commanderDamageTapped(lifeTotalView4, i);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit energyCounterTapped$lambda$12(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Energy, 2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit energyCounterTapped$lambda$13(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Energy, 1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit experienceCounterTapped$lambda$16(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Experience, 2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit experienceCounterTapped$lambda$17(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Experience, 1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit initiativeCoinDropped$lambda$10(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.initiativeCoinDropped(lifeTotalView3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit initiativeCoinDropped$lambda$11(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType1.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType1.initiativeCoinDropped(lifeTotalView4);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit monarchCoinDropped$lambda$8(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.monarchCoinDropped(lifeTotalView3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit monarchCoinDropped$lambda$9(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType1.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType1.monarchCoinDropped(lifeTotalView4);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit poisonCounterTapped$lambda$0(GameFragment4PlayersType1 gameFragment4PlayersType1, int i, boolean z) {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).setPoisonCounters(i);
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setPoisonCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getPoisonCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.checkVitals();
            Context context = gameFragment4PlayersType1.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
            }
            gameFragment4PlayersType1.updateStreamingState$app_release();
            return Unit.INSTANCE;
        }

        static final Unit poisonCounterTapped$lambda$1(GameFragment4PlayersType1 gameFragment4PlayersType1, int i) {
            LifeTotalView lifeViewTeam2;
            int poisonCounters = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters() - i;
            if (poisonCounters != 0) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Poison.getValue(), 2, null, poisonCounters, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                Context context = gameFragment4PlayersType1.getContext();
                if (context != null) {
                    new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
                }
            }
            if (gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters() >= ((gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 5 || gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 6) ? 15 : 10) && (lifeViewTeam2 = gameFragment4PlayersType1.getLifeViewTeam2()) != null) {
                lifeViewTeam2.triggerPlayerDeadQ("", false);
            }
            gameFragment4PlayersType1.updateStreamingState$app_release();
            return Unit.INSTANCE;
        }

        static final Unit radiationCounterTapped$lambda$20(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Radiation, 2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit radiationCounterTapped$lambda$21(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Radiation, 1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit stormCounterTapped$lambda$14(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Storm, 2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit stormCounterTapped$lambda$15(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Storm, 1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit taxCounterTapped$lambda$18(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Tax, 2);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit taxCounterTapped$lambda$19(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            gameFragment4PlayersType1.showCountersDialogFor(gameFragment4PlayersType1.getLifeViewTeam2(), CounterType.Tax, 1);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit theRingCoinDropped$lambda$4(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.theRingCoinDropped(lifeTotalView3);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit theRingCoinDropped$lambda$5(GameFragment4PlayersType1 gameFragment4PlayersType1, CustomDialogFragmentSquare dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType1.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType1.theRingCoinDropped(lifeTotalView4);
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void cityCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_city_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.cityCoinDropped$lambda$6(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.cityCoinDropped$lambda$7(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerCity");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void cityCoinRejected() {
            GameFragment4PlayersType1.this.cityCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageClosed(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamagePartnerRunningTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamagePartnerValueChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageRunningTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageTapped(LifeTotalView sender, final int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_cmd);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_cmd_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.commanderDamageTapped$lambda$2(gameFragment4PlayersType1, rotation, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.commanderDamageTapped$lambda$3(gameFragment4PlayersType12, rotation, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerCMD");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void commanderDamageValueChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerConcede(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.triggerPlayerDeadQ("concede", true);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerDeath(LifeTotalView sender, boolean fromMenu) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.triggerPlayerDeadQ("", fromMenu);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerDraw(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.triggerPlayerDeadQ("draw", true);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void confirmPlayerWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.triggerPlayerWinQ();
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void createDeckForGuest(LifeTotalView sender, int userId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void createDeckForMythicUser(LifeTotalView sender, int userId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void currentUserSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void currentUserUnselected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void deckCleared(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void editPlayerNameTapped(LifeTotalView sender, String currentName) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(currentName, "currentName");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void endTurnTapped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.endTurnTapped(lifeTotalView3);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void energyCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_energy_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.energyCounterTapped$lambda$12(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.energyCounterTapped$lambda$13(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerEnergy");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void energyToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.energyToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.energyToggled(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void experienceCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_experience_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.experienceCounterTapped$lambda$16(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.experienceCounterTapped$lambda$17(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void experienceToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.experienceToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.experienceToggled(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void guestUserSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void guestUserUnselected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void initiativeCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_initiative_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.initiativeCoinDropped$lambda$10(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.initiativeCoinDropped$lambda$11(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerInitiative");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void initiativeCoinRejected() {
            GameFragment4PlayersType1.this.initiativeCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void leftPicked(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void lifeTotalChangeCommitted(LifeTotalView sender, int delta) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.lifeTotalChangeCommitted(lifeTotalView3, delta);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.lifeTotalChangeCommitted(lifeTotalView4, delta);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void lifeTotalChanged(LifeTotalView sender, int newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.lifeTotalChanged(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.lifeTotalChanged(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void monarchCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_monarch_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.monarchCoinDropped$lambda$8(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.monarchCoinDropped$lambda$9(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerMonarch");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void monarchCoinRejected() {
            GameFragment4PlayersType1.this.monarchCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void mythicUserSelected(LifeTotalView sender, MTFriend friend, int previousUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(friend, "friend");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void mythicUserUnselected(LifeTotalView sender, int currentUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void ownCmdDamageTapped(LifeTotalView sender, int orientation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void partnersToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void pauseTimerToggled(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.pauseTimerToggled(lifeTotalView3);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void pickAColor(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsKO(LifeTotalView sender, String contextStr) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(contextStr, "contextStr");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.playerIsKO(lifeTotalView3, contextStr);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsPlayingFirst(LifeTotalView sender, boolean playingFirst) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.playerIsPlayingFirst(lifeTotalView3, playingFirst);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerIsWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.playerIsWin(lifeTotalView3);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playerTapToStartTapped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            int startingPlayerIndex = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getStartingPlayerIndex();
            LifeTotalView lifeTotalView = startingPlayerIndex != 0 ? startingPlayerIndex != 1 ? startingPlayerIndex != 2 ? startingPlayerIndex != 3 ? null : GameFragment4PlayersType1.this.getBinding().lifeTotalView2 : GameFragment4PlayersType1.this.getBinding().lifeTotalView3 : GameFragment4PlayersType1.this.getBinding().lifeTotalView4 : GameFragment4PlayersType1.this.getBinding().lifeTotalView1;
            if (lifeTotalView != null) {
                GameFragment4PlayersType1.this.playerTapToStartTapped(lifeTotalView);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupDeckSelected(LifeTotalView sender, MTDeck deck, int userId, boolean endOfGame) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(deck, "deck");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupUserSelected(LifeTotalView sender, MTUser user, int previousUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(user, "user");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playgroupUserUnselected(LifeTotalView sender, int currentUserId) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void playmatSelected(LifeTotalView sender, String id) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(id, "id");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void poisonCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            final int poisonCounters = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters();
            LifeTotalView lifeTotalView = GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam2;
            CounterType counterType = CounterType.Poison;
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            Function2<? super Integer, ? super Boolean, Unit> function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment4PlayersType1.AnonymousClass2.poisonCounterTapped$lambda$0(gameFragment4PlayersType1, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                }
            };
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            lifeTotalView.showCountersDialog(counterType, function2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment4PlayersType1.AnonymousClass2.poisonCounterTapped$lambda$1(gameFragment4PlayersType12, poisonCounters);
                }
            });
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void poisonToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.poisonToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.poisonToggled(lifeTotalView4, newValue);
            LifeTotalView lifeViewTeam2 = GameFragment4PlayersType1.this.getLifeViewTeam2();
            if (lifeViewTeam2 != null) {
                lifeViewTeam2.showPoisonCounters(newValue);
            }
            LifeTotalView lifeViewTeam1 = GameFragment4PlayersType1.this.getLifeViewTeam1();
            if (lifeViewTeam1 != null) {
                lifeViewTeam1.showPoisonCounters(newValue);
            }
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void qrScanSelected(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void radiationCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_radiation_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.radiationCounterTapped$lambda$20(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.radiationCounterTapped$lambda$21(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void radiationToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.radiationToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.radiationToggled(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void rightPicked(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void signalCardScanInProgress(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void signalPhotoPickInProgress(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void stormCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_storm_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.stormCounterTapped$lambda$14(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.stormCounterTapped$lambda$15(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void stormToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.stormToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.stormToggled(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void swipeMenuClosed(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void swipeMenuOpened(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void taxCounterTapped(LifeTotalView sender, int rotation) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_storm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_tax_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.taxCounterTapped$lambda$18(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation2 = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.taxCounterTapped$lambda$19(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation2.show(childFragmentManager, "WhichPlayerStorm");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void taxToggled(LifeTotalView sender, boolean newValue) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.taxToggled(lifeTotalView3, newValue);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.taxToggled(lifeTotalView4, newValue);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void theRingCoinDropped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            CustomDialogFragmentSquare.Builder builder = new CustomDialogFragmentSquare.Builder();
            String string = GameFragment4PlayersType1.this.getString(R.string.which_player_energy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragmentSquare.Builder title = builder.setTitle(string);
            String string2 = GameFragment4PlayersType1.this.getString(R.string.which_player_the_ring_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragmentSquare.Builder body = title.setBody(string2);
            String name = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(2).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder positiveButton = body.setPositiveButton(name, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.theRingCoinDropped$lambda$4(gameFragment4PlayersType1, (CustomDialogFragmentSquare) obj);
                }
            });
            String name2 = GameFragment4PlayersType1.this.getSharedViewModel().getGameState().getPlayers().get(1).getName();
            final GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            CustomDialogFragmentSquare.Builder rotation = positiveButton.setNegativeButton(name2, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$setupTeams$2$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.AnonymousClass2.theRingCoinDropped$lambda$5(gameFragment4PlayersType12, (CustomDialogFragmentSquare) obj);
                }
            }).setRotation(270);
            FragmentManager childFragmentManager = GameFragment4PlayersType1.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "WhichPlayerTheRing");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void theRingCoinRejected() {
            GameFragment4PlayersType1.this.theRingCoinRejected();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void treacheryRoleRevealed(LifeTotalView sender, int role) {
            Intrinsics.checkNotNullParameter(sender, "sender");
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoNextTurnTapped(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.undoNextTurnTapped(lifeTotalView3);
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoPlayerDeath(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.undoPlayerDeath(lifeTotalView3);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.undoPlayerDeath(lifeTotalView4);
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam2.undoKO();
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam1.undoWin();
        }

        @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
        public void undoPlayerWin(LifeTotalView sender) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            GameFragment4PlayersType1 gameFragment4PlayersType1 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView3 = gameFragment4PlayersType1.getBinding().lifeTotalView3;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
            gameFragment4PlayersType1.undoPlayerWin(lifeTotalView3);
            GameFragment4PlayersType1 gameFragment4PlayersType12 = GameFragment4PlayersType1.this;
            LifeTotalView lifeTotalView4 = gameFragment4PlayersType12.getBinding().lifeTotalView4;
            Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
            gameFragment4PlayersType12.undoPlayerWin(lifeTotalView4);
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam2.undoWin();
            GameFragment4PlayersType1.this.getBinding().lifeTotalViewTeam1.undoKO();
        }
    }

    @JvmStatic
    public static final GameFragment4PlayersType1 newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(View view) {
    }

    static final Unit onCreateView$lambda$1(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        if (gameFragment4PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment4PlayersType1.showPlanechaseUI();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        if (gameFragment4PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = gameFragment4PlayersType1.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (gameFragment4PlayersType1.getSharedViewModel().getGameState().isDay()) {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().setDay(false);
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Night.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment4PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        } else {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().setDay(true);
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Day.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment4PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        }
        preferencesManager.saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        if (gameFragment4PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment4PlayersType1.getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        Context contextRequireContext = gameFragment4PlayersType1.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
        GameCallback gameCallback = gameFragment4PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.startGamePressed();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        GameCallback gameCallback = gameFragment4PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$6(final GameFragment4PlayersType1 gameFragment4PlayersType1, View view) {
        if (gameFragment4PlayersType1.getContext() == null || gameFragment4PlayersType1._binding == null) {
            return;
        }
        gameFragment4PlayersType1.getBinding().menuButtonBlack.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment4PlayersType1.onCreateView$lambda$6$0(this.f$0);
            }
        });
        gameFragment4PlayersType1.getBinding().menuButtonWhite.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment4PlayersType1.onCreateView$lambda$6$1(this.f$0);
            }
        });
        gameFragment4PlayersType1.getBinding().menuButton.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment4PlayersType1.onCreateView$lambda$6$2(this.f$0);
            }
        });
        gameFragment4PlayersType1.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment4PlayersType1.onCreateView$lambda$6$3(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        gameFragment4PlayersType1.getBinding().menuButtonBlack.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$1(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        gameFragment4PlayersType1.getBinding().menuButtonWhite.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$2(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        gameFragment4PlayersType1.getBinding().menuButton.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$3(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        GameCallback gameCallback = gameFragment4PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$7(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        String str;
        if (gameFragment4PlayersType1.getSharedViewModel().getGameState().getTimerEnabled()) {
            int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameFragment4PlayersType1.getSharedViewModel().getGameState());
            int i = iTimeLeft / 60;
            int i2 = iTimeLeft % 60;
            if (i > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                str = String.format("%dh %02dmin", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                str = String.format("%02d min", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
            TimerLeftFragment.Builder rotation = new TimerLeftFragment.Builder().setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment4PlayersType1.onCreateView$lambda$7$0((TimerLeftFragment) obj);
                }
            }).setText(str).setRotation(270);
            FragmentManager childFragmentManager = gameFragment4PlayersType1.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "TimerLeftFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7$0(TimerLeftFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    static final boolean onCreateView$lambda$8(GameFragment4PlayersType1 gameFragment4PlayersType1, Handler handler, Runnable runnable, View view, MotionEvent motionEvent) {
        if (gameFragment4PlayersType1.getContext() != null) {
            FragmentGame4PlayersType1Binding fragmentGame4PlayersType1Binding = gameFragment4PlayersType1._binding;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            handler.postDelayed(runnable, 500L);
            return true;
        }
        if (action != 1) {
            if (action != 3) {
                return false;
            }
            handler.removeCallbacks(runnable);
            return true;
        }
        handler.removeCallbacks(runnable);
        if (motionEvent.getEventTime() - motionEvent.getDownTime() < 200) {
            view.performClick();
        }
        return true;
    }

    static final void onViewCreated$lambda$1(GameFragment4PlayersType1 gameFragment4PlayersType1) {
        if (gameFragment4PlayersType1._binding == null) {
            return;
        }
        if (gameFragment4PlayersType1.getSharedViewModel().getGameState().isDay()) {
            gameFragment4PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        } else {
            gameFragment4PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        }
        gameFragment4PlayersType1.dayNightToggled(gameFragment4PlayersType1.getSharedViewModel().getGameState().getHasDayNight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCountersDialogFor(LifeTotalView teamLifeView, final CounterType counterType, final int playerIndex) {
        final int taxCount;
        int i = WhenMappings.$EnumSwitchMapping$0[counterType.ordinal()];
        if (i == 1) {
            if (teamLifeView != null) {
                teamLifeView.setTaxCount(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getTaxCount());
            }
            if (teamLifeView != null) {
                teamLifeView.setTaxCountPartner(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getTaxCountPartner());
            }
            taxCount = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getTaxCount();
        } else if (i == 2) {
            if (teamLifeView != null) {
                teamLifeView.setStormCount(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getStormCount());
            }
            taxCount = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getStormCount();
        } else if (i == 3) {
            if (teamLifeView != null) {
                teamLifeView.setExperienceCounters(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getExperienceCount());
            }
            taxCount = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getExperienceCount();
        } else if (i == 4) {
            if (teamLifeView != null) {
                teamLifeView.setRadiationCounters(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getRadiationCount());
            }
            taxCount = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getRadiationCount();
        } else if (i != 5) {
            taxCount = 0;
        } else {
            if (teamLifeView != null) {
                teamLifeView.setEnergyCounters(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getEnergyCounters());
            }
            taxCount = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getEnergyCounters();
        }
        if (teamLifeView != null) {
            teamLifeView.showCountersDialog(counterType, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment4PlayersType1.showCountersDialogFor$lambda$0(counterType, this, playerIndex, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                }
            }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment4PlayersType1.showCountersDialogFor$lambda$1(this.f$0, counterType, playerIndex, taxCount);
                }
            });
        }
    }

    static final Unit showCountersDialogFor$lambda$0(CounterType counterType, GameFragment4PlayersType1 gameFragment4PlayersType1, int i, int i2, boolean z) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[counterType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setStormCount(i2);
                gameFragment4PlayersType1.getLifeViews().get(i).setStormCount(i2);
            } else if (i3 == 3) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setExperienceCount(i2);
                gameFragment4PlayersType1.getLifeViews().get(i).setExperienceCounters(i2);
            } else if (i3 == 4) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setRadiationCount(i2);
                gameFragment4PlayersType1.getLifeViews().get(i).setRadiationCounters(i2);
            } else if (i3 == 5) {
                gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setEnergyCounters(i2);
                gameFragment4PlayersType1.getLifeViews().get(i).setEnergyCounters(i2);
            }
        } else if (z) {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setTaxCountPartner(i2);
            gameFragment4PlayersType1.getLifeViews().get(i).setTaxCountPartner(i2);
        } else {
            gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).setTaxCount(i2);
            gameFragment4PlayersType1.getLifeViews().get(i).setTaxCount(i2);
        }
        Context context = gameFragment4PlayersType1.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
        }
        if (gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragment4PlayersType1.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setEnergyCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getEnergyCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getEnergyCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setStormCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getStormCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getStormCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setTaxCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getTaxCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getTaxCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setTaxCountPartner(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getTaxCountPartner(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getTaxCountPartner()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setExperienceCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getExperienceCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getExperienceCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setRadiationCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getRadiationCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getRadiationCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setEnergyCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getEnergyCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getEnergyCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setStormCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getStormCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getStormCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setTaxCountPartner(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getTaxCountPartner(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getTaxCountPartner()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setExperienceCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getExperienceCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getExperienceCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setRadiationCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getRadiationCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getRadiationCount()));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0357  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit showCountersDialogFor$lambda$1(GameFragment4PlayersType1 gameFragment4PlayersType1, CounterType counterType, int i, int i2) {
        int taxCount;
        MTGameEvent mTGameEvent;
        int i3 = 0;
        if (gameFragment4PlayersType1.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragment4PlayersType1.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setEnergyCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getEnergyCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getEnergyCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setStormCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getStormCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getStormCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setTaxCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getTaxCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getTaxCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setTaxCountPartner(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getTaxCountPartner(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getTaxCountPartner()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setExperienceCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getExperienceCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getExperienceCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam1.setRadiationCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(0).getRadiationCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(3).getRadiationCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setEnergyCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getEnergyCounters(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getEnergyCounters()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setStormCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getStormCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getStormCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setTaxCount(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getTaxCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getTaxCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setTaxCountPartner(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getTaxCountPartner(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getTaxCountPartner()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setExperienceCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getExperienceCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getExperienceCount()));
            gameFragment4PlayersType1.getBinding().lifeTotalViewTeam2.setRadiationCounters(Math.max(gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(1).getRadiationCount(), gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(2).getRadiationCount()));
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[counterType.ordinal()];
        if (i4 == 1) {
            taxCount = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).getTaxCount();
        } else if (i4 == 2) {
            taxCount = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).getStormCount();
        } else if (i4 == 3) {
            taxCount = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).getExperienceCount();
        } else {
            if (i4 != 4) {
                if (i4 == 5) {
                    taxCount = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).getEnergyCounters();
                }
                if (i3 != 0) {
                    int i5 = WhenMappings.$EnumSwitchMapping$0[counterType.ordinal()];
                    if (i5 == 1) {
                        mTGameEvent = new MTGameEvent(null, MTEvent.Tax.getValue(), i, null, i3, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                    } else if (i5 == 2) {
                        mTGameEvent = new MTGameEvent(null, MTEvent.Storm.getValue(), i, null, i3, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                    } else if (i5 == 3) {
                        mTGameEvent = new MTGameEvent(null, MTEvent.Experience.getValue(), i, null, i3, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                    } else if (i5 == 4) {
                        mTGameEvent = new MTGameEvent(null, MTEvent.Radiation.getValue(), i, null, i3, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                    } else if (i5 != 5) {
                        mTGameEvent = null;
                    } else {
                        mTGameEvent = new MTGameEvent(null, MTEvent.Energy.getValue(), i, null, i3, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                    }
                    if (mTGameEvent != null) {
                        gameFragment4PlayersType1.getSharedViewModel().getGameState().getEvents().add(mTGameEvent);
                    }
                    Context context = gameFragment4PlayersType1.getContext();
                    if (context != null) {
                        new PreferencesManager(context).saveCurrentGame(gameFragment4PlayersType1.getSharedViewModel().getGameState());
                    }
                }
                return Unit.INSTANCE;
            }
            taxCount = gameFragment4PlayersType1.getSharedViewModel().getGameState().getPlayers().get(i).getRadiationCount();
        }
        i3 = taxCount - i2;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void archenemyToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (!isOn) {
            getBinding().planechaseBkg.setVisibility(8);
            getBinding().planechaseImageView.setVisibility(8);
        } else {
            getBinding().planechaseImageView.setImageResource(R.drawable.archenemy);
            getBinding().planechaseBkg.setVisibility(0);
            getBinding().planechaseImageView.setVisibility(0);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void dayNightToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (isOn) {
            getBinding().dayNightBkg.setVisibility(0);
            getBinding().dayNightImageView.setVisibility(0);
        } else {
            getBinding().dayNightBkg.setVisibility(8);
            getBinding().dayNightImageView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void gameFinished() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.gameFinished();
    }

    public final FragmentGame4PlayersType1Binding getBinding() {
        FragmentGame4PlayersType1Binding fragmentGame4PlayersType1Binding = this._binding;
        Intrinsics.checkNotNull(fragmentGame4PlayersType1Binding);
        return fragmentGame4PlayersType1Binding;
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void hideStartGameButton() {
        if (this._binding == null) {
            return;
        }
        getBinding().startGameButtonLayout.setVisibility(8);
        showMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void nonSyncableGameFinished() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.nonSyncableGameFinished();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameCallback");
            this.callback = (GameCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0334  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String borderColor;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGame4PlayersType1Binding.inflate(inflater, container, false);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment4PlayersType1.onCreateView$lambda$0(view);
            }
        });
        setLifeViewTeam1(getBinding().lifeTotalViewTeam1);
        setLifeViewTeam2(getBinding().lifeTotalViewTeam2);
        LifeTotalView lifeViewTeam1 = getLifeViewTeam1();
        if (lifeViewTeam1 != null) {
            lifeViewTeam1.setDisableDeckAndAdvanced(true);
        }
        LifeTotalView lifeViewTeam2 = getLifeViewTeam2();
        if (lifeViewTeam2 != null) {
            lifeViewTeam2.setDisableDeckAndAdvanced(true);
        }
        List<LifeTotalView> lifeViews = getLifeViews();
        LifeTotalView lifeTotalView1 = getBinding().lifeTotalView1;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
        lifeViews.add(lifeTotalView1);
        List<LifeTotalView> lifeViews2 = getLifeViews();
        LifeTotalView lifeTotalView4 = getBinding().lifeTotalView4;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
        lifeViews2.add(lifeTotalView4);
        List<LifeTotalView> lifeViews3 = getLifeViews();
        LifeTotalView lifeTotalView3 = getBinding().lifeTotalView3;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
        lifeViews3.add(lifeTotalView3);
        List<LifeTotalView> lifeViews4 = getLifeViews();
        LifeTotalView lifeTotalView2 = getBinding().lifeTotalView2;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
        lifeViews4.add(lifeTotalView2);
        setupLifeViews();
        getBinding().planechaseBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().planechaseBkg.setClipToOutline(true);
        ImageView planechaseImageView = getBinding().planechaseImageView;
        Intrinsics.checkNotNullExpressionValue(planechaseImageView, "planechaseImageView");
        ViewExtensionsKt.setOnClickWithFade(planechaseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment4PlayersType1.onCreateView$lambda$1(this.f$0);
            }
        });
        getBinding().dayNightBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().dayNightBkg.setClipToOutline(true);
        ImageView dayNightImageView = getBinding().dayNightImageView;
        Intrinsics.checkNotNullExpressionValue(dayNightImageView, "dayNightImageView");
        ViewExtensionsKt.setOnClickWithFade(dayNightImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment4PlayersType1.onCreateView$lambda$2(this.f$0);
            }
        });
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        Unit unit = null;
        if (currentSkinDefinition != null && (borderColor = currentSkinDefinition.getBorderColor()) != null) {
            int colorFromHex = SkinManager.INSTANCE.getInstance().getColorFromHex(borderColor);
            if (((int) ((((double) ((colorFromHex >> 16) & 255)) * 0.299d) + (((double) ((colorFromHex >> 8) & 255)) * 0.587d) + (((double) (colorFromHex & 255)) * 0.114d))) < 17) {
                colorFromHex = ContextCompat.getColor(requireContext(), R.color.almost_white);
            }
            Drawable background = getBinding().startGameButtonLayout.getBackground();
            Drawable drawableMutate = background != null ? background.mutate() : null;
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable != null) {
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                gradientDrawable.setStroke(companion2.dpToPx(2, contextRequireContext2), colorFromHex);
                getBinding().startGameButtonLayout.setBackground(gradientDrawable);
            }
        }
        ConstraintLayout startGameButtonLayout = getBinding().startGameButtonLayout;
        Intrinsics.checkNotNullExpressionValue(startGameButtonLayout, "startGameButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(startGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment4PlayersType1.onCreateView$lambda$4(this.f$0);
            }
        });
        TransparentClickImageView customMenuButtonImage = getBinding().customMenuButtonImage;
        Intrinsics.checkNotNullExpressionValue(customMenuButtonImage, "customMenuButtonImage");
        ViewExtensionsKt.setOnClickWithBounceTransparent(customMenuButtonImage, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment4PlayersType1.onCreateView$lambda$5(this.f$0);
            }
        });
        getBinding().overlayView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment4PlayersType1.onCreateView$lambda$6(this.f$0, view);
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment4PlayersType1.onCreateView$lambda$7(this.f$0);
            }
        };
        getBinding().overlayView1.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda13
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameFragment4PlayersType1.onCreateView$lambda$8(this.f$0, handler, runnable, view, motionEvent);
            }
        });
        getBinding().backgroundImage.setVisibility(8);
        SkinManager companion3 = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        SkinDefinition currentSkinDefinition2 = companion3.getCurrentSkinDefinition(contextRequireContext3);
        if (currentSkinDefinition2 != null) {
            Integer extraMargin = currentSkinDefinition2.getExtraMargin();
            if (extraMargin != null) {
                extraMargin.intValue();
                ViewGroup.LayoutParams layoutParams = getBinding().lifeTotalView1.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView1.setLayoutParams(layoutParams2);
                getBinding().lifeTotalView1.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView1.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView1.refreshMargins();
                ViewGroup.LayoutParams layoutParams3 = getBinding().lifeTotalView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView2.setLayoutParams(layoutParams4);
                getBinding().lifeTotalView2.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.refreshMargins();
                ViewGroup.LayoutParams layoutParams5 = getBinding().lifeTotalView3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                layoutParams6.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView3.setLayoutParams(layoutParams6);
                getBinding().lifeTotalView3.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.refreshMargins();
                ViewGroup.LayoutParams layoutParams7 = getBinding().lifeTotalView4.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                layoutParams8.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView4.setLayoutParams(layoutParams8);
                getBinding().lifeTotalView4.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView4.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView4.refreshMargins();
            }
            String backgroundImage = currentSkinDefinition2.getBackgroundImage();
            if (backgroundImage != null) {
                SkinManager companion4 = SkinManager.INSTANCE.getInstance();
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                String currentSkinCode = companion4.getCurrentSkinCode(contextRequireContext4);
                SkinManager companion5 = SkinManager.INSTANCE.getInstance();
                Context contextRequireContext5 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                Bitmap imageFromSkin = companion5.getImageFromSkin(contextRequireContext5, currentSkinCode, backgroundImage);
                if (imageFromSkin != null) {
                    getBinding().backgroundImage.setImageBitmap(TransformationUtils.rotateImage(imageFromSkin, 90));
                }
                getBinding().backgroundImage.setVisibility(0);
                Float backgroundAlpha = currentSkinDefinition2.getBackgroundAlpha();
                if (backgroundAlpha != null) {
                    getBinding().backgroundImage.setAlpha(backgroundAlpha.floatValue());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    getBinding().backgroundImage.setVisibility(8);
                }
            }
        }
        FragmentReadyListener fragmentReadyListener = getFragmentReadyListener();
        if (fragmentReadyListener != null) {
            fragmentReadyListener.onFragmentReady();
        }
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if ((!getSharedViewModel().getGameState().getTimerEnabled() || getSharedViewModel().getGameState().getTimerTotalTime() <= 0) && !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            hideClock();
        } else {
            int value = 0;
            boolean z = (getSharedViewModel().getGameState().getPlaygroupId() == -1 && !getSharedViewModel().getGameState().getGameSyncable()) || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected());
            if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) {
                z = false;
            }
            if (z && getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
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
                if (getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() >= 0 && getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() < getLifeViews().size()) {
                    getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).setIsCurrentPlayerTurn(true, value);
                    int i = (int) j;
                    getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).updateCurrentTurnTime(i);
                    if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                        if (getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() == 0 || getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() == 3) {
                            LifeTotalView lifeViewTeam1 = getLifeViewTeam1();
                            if (lifeViewTeam1 != null) {
                                lifeViewTeam1.setIsCurrentPlayerTurn(true, value);
                            }
                            LifeTotalView lifeViewTeam12 = getLifeViewTeam1();
                            if (lifeViewTeam12 != null) {
                                lifeViewTeam12.updateCurrentTurnTime(i);
                            }
                        } else {
                            LifeTotalView lifeViewTeam2 = getLifeViewTeam2();
                            if (lifeViewTeam2 != null) {
                                lifeViewTeam2.setIsCurrentPlayerTurn(true, value);
                            }
                            LifeTotalView lifeViewTeam22 = getLifeViewTeam2();
                            if (lifeViewTeam22 != null) {
                                lifeViewTeam22.updateCurrentTurnTime(i);
                            }
                        }
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                        if (getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() == 0 || getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() == 1 || getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() == 5) {
                            LifeTotalView lifeViewTeam13 = getLifeViewTeam1();
                            if (lifeViewTeam13 != null) {
                                lifeViewTeam13.setIsCurrentPlayerTurn(true, value);
                            }
                            LifeTotalView lifeViewTeam14 = getLifeViewTeam1();
                            if (lifeViewTeam14 != null) {
                                lifeViewTeam14.updateCurrentTurnTime(i);
                            }
                        } else {
                            LifeTotalView lifeViewTeam23 = getLifeViewTeam2();
                            if (lifeViewTeam23 != null) {
                                lifeViewTeam23.setIsCurrentPlayerTurn(true, value);
                            }
                            LifeTotalView lifeViewTeam24 = getLifeViewTeam2();
                            if (lifeViewTeam24 != null) {
                                lifeViewTeam24.updateCurrentTurnTime(i);
                            }
                        }
                    }
                }
            }
            if (z) {
                showClock();
                Context context = getContext();
                if (context != null && !new PreferencesManager(context).getBoolean(PreferencesManager.AUTO_START_TIMER, true)) {
                    toggleTimerPause();
                }
            } else {
                hideClock();
            }
        }
        View view2 = getView();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment4PlayersType1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment4PlayersType1.onViewCreated$lambda$1(this.f$0);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void planechaseToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (!isOn) {
            getBinding().planechaseBkg.setVisibility(8);
            getBinding().planechaseImageView.setVisibility(8);
        } else {
            getBinding().planechaseImageView.setImageResource(R.drawable.planechase);
            getBinding().planechaseBkg.setVisibility(0);
            getBinding().planechaseImageView.setVisibility(0);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void setupTeams() {
        if (this._binding != null && getSharedViewModel().getGameState().getPlayers().size() == 4) {
            super.setupTeams();
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            getBinding().lifeTotalViewTeam1.setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
            getBinding().lifeTotalViewTeam1.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(0).getLifeTotal());
            getBinding().lifeTotalViewTeam1.setPoisonCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters(), getSharedViewModel().getGameState().getPlayers().get(3).getPoisonCounters()));
            getBinding().lifeTotalViewTeam1.setEnergyCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getEnergyCounters(), getSharedViewModel().getGameState().getPlayers().get(3).getEnergyCounters()));
            getBinding().lifeTotalViewTeam1.setStormCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getStormCount(), getSharedViewModel().getGameState().getPlayers().get(3).getStormCount()));
            getBinding().lifeTotalViewTeam1.setTaxCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getTaxCount(), getSharedViewModel().getGameState().getPlayers().get(3).getTaxCount()));
            getBinding().lifeTotalViewTeam1.setTaxCountPartner(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getTaxCountPartner(), getSharedViewModel().getGameState().getPlayers().get(3).getTaxCountPartner()));
            getBinding().lifeTotalViewTeam1.setExperienceCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getExperienceCount(), getSharedViewModel().getGameState().getPlayers().get(3).getExperienceCount()));
            getBinding().lifeTotalViewTeam1.setRadiationCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getRadiationCount(), getSharedViewModel().getGameState().getPlayers().get(3).getRadiationCount()));
            getBinding().lifeTotalViewTeam1.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(3)));
            getBinding().lifeTotalViewTeam1.showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
            getBinding().lifeTotalViewTeam1.showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
            getBinding().lifeTotalViewTeam1.hasPartners(getSharedViewModel().getGameState().getPlayers().get(0).getHasPartners() || getSharedViewModel().getGameState().getPlayers().get(3).getHasPartners());
            getBinding().lifeTotalViewTeam1.hasEnergy(getSharedViewModel().getGameState().getPlayers().get(0).getEnergyEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getEnergyEnabled());
            getBinding().lifeTotalViewTeam1.hasStorm(getSharedViewModel().getGameState().getPlayers().get(0).getStormEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getStormEnabled());
            getBinding().lifeTotalViewTeam1.hasExperience(getSharedViewModel().getGameState().getPlayers().get(0).getExperienceEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getExperienceEnabled());
            getBinding().lifeTotalViewTeam1.hasTax(getSharedViewModel().getGameState().getPlayers().get(0).getTaxEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getTaxEnabled());
            getBinding().lifeTotalViewTeam1.hasRadiation(getSharedViewModel().getGameState().getPlayers().get(0).getRadiationEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getRadiationEnabled());
            getBinding().lifeTotalViewTeam1.updateCountersLayout();
            if (getSharedViewModel().getGameState().getPlayers().get(0).getMonarch() || getSharedViewModel().getGameState().getPlayers().get(3).getMonarch()) {
                getBinding().lifeTotalViewTeam1.showMonarchCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideMonarchCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getInitiative() || getSharedViewModel().getGameState().getPlayers().get(3).getInitiative()) {
                getBinding().lifeTotalViewTeam1.showInitiativeCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideInitiativeCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getTheRing() || getSharedViewModel().getGameState().getPlayers().get(3).getTheRing()) {
                getBinding().lifeTotalViewTeam1.showTheRingCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideTheRingCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getCityBlessing() || getSharedViewModel().getGameState().getPlayers().get(3).getCityBlessing()) {
                getBinding().lifeTotalViewTeam1.showCityCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideCityCoin();
            }
            getBinding().lifeTotalViewTeam1.refreshSettings();
            getBinding().lifeTotalViewTeam1.setPlainBackgroundColor(companion.getDefaultColors().get(0).intValue());
            Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            player.setName(getSharedViewModel().getGameState().getPlayers().get(0).getName() + " & " + getSharedViewModel().getGameState().getPlayers().get(3).getName());
            player.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(0).getLifeTotal());
            player.setUserId(getSharedViewModel().getGameState().getPlayers().get(0).getUserId());
            player.setLeftBackgroundType(getSharedViewModel().getGameState().getPlayers().get(0).getBackgroundType());
            player.setLeftScryfallId(getSharedViewModel().getGameState().getPlayers().get(0).getScryfallId());
            player.setLeftIsPlaneswalker(getSharedViewModel().getGameState().getPlayers().get(0).isPlaneswalker());
            player.setLeftPhotoUri(getSharedViewModel().getGameState().getPlayers().get(0).getPhotoUri());
            player.setLeftPlaymatId(getSharedViewModel().getGameState().getPlayers().get(0).getPlaymatId());
            player.setLeftBackgroundCardId(getSharedViewModel().getGameState().getPlayers().get(0).getBackgroundCardId());
            player.setBackgroundType(getSharedViewModel().getGameState().getPlayers().get(3).getBackgroundType());
            player.setScryfallId(getSharedViewModel().getGameState().getPlayers().get(3).getScryfallId());
            player.setPlaneswalker(getSharedViewModel().getGameState().getPlayers().get(3).isPlaneswalker());
            player.setPhotoUri(getSharedViewModel().getGameState().getPlayers().get(3).getPhotoUri());
            player.setPlaymatId(getSharedViewModel().getGameState().getPlayers().get(3).getPlaymatId());
            player.setBackgroundCardId(getSharedViewModel().getGameState().getPlayers().get(3).getBackgroundCardId());
            getBinding().lifeTotalViewTeam1.updatePlayer(player);
            getBinding().lifeTotalViewTeam1.checkVitals();
            getBinding().lifeTotalViewTeam1.undoKO();
            getBinding().lifeTotalViewTeam1.undoWin();
            getBinding().lifeTotalViewTeam1.setCallback(new AnonymousClass1());
            getBinding().lifeTotalViewTeam2.setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
            getBinding().lifeTotalViewTeam2.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(1).getLifeTotal());
            getBinding().lifeTotalViewTeam2.setPoisonCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getPoisonCounters(), getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters()));
            getBinding().lifeTotalViewTeam2.setEnergyCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getEnergyCounters(), getSharedViewModel().getGameState().getPlayers().get(2).getEnergyCounters()));
            getBinding().lifeTotalViewTeam2.setStormCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getStormCount(), getSharedViewModel().getGameState().getPlayers().get(2).getStormCount()));
            getBinding().lifeTotalViewTeam2.setTaxCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getTaxCountPartner(), getSharedViewModel().getGameState().getPlayers().get(2).getTaxCountPartner()));
            getBinding().lifeTotalViewTeam2.setExperienceCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getExperienceCount(), getSharedViewModel().getGameState().getPlayers().get(2).getExperienceCount()));
            getBinding().lifeTotalViewTeam2.setRadiationCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getRadiationCount(), getSharedViewModel().getGameState().getPlayers().get(2).getRadiationCount()));
            getBinding().lifeTotalViewTeam2.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(2)));
            getBinding().lifeTotalViewTeam2.showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
            getBinding().lifeTotalViewTeam2.showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
            getBinding().lifeTotalViewTeam2.hasPartners(getSharedViewModel().getGameState().getPlayers().get(1).getHasPartners() || getSharedViewModel().getGameState().getPlayers().get(2).getHasPartners());
            getBinding().lifeTotalViewTeam2.hasEnergy(getSharedViewModel().getGameState().getPlayers().get(1).getEnergyEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getEnergyEnabled());
            getBinding().lifeTotalViewTeam2.hasStorm(getSharedViewModel().getGameState().getPlayers().get(1).getStormEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getStormEnabled());
            getBinding().lifeTotalViewTeam2.hasExperience(getSharedViewModel().getGameState().getPlayers().get(1).getExperienceEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getExperienceEnabled());
            getBinding().lifeTotalViewTeam2.hasTax(getSharedViewModel().getGameState().getPlayers().get(1).getTaxEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getTaxEnabled());
            getBinding().lifeTotalViewTeam2.hasRadiation(getSharedViewModel().getGameState().getPlayers().get(1).getRadiationEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getRadiationEnabled());
            getBinding().lifeTotalViewTeam2.updateCountersLayout();
            if (getSharedViewModel().getGameState().getPlayers().get(1).getMonarch() || getSharedViewModel().getGameState().getPlayers().get(2).getMonarch()) {
                getBinding().lifeTotalViewTeam2.showMonarchCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideMonarchCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getInitiative() || getSharedViewModel().getGameState().getPlayers().get(2).getInitiative()) {
                getBinding().lifeTotalViewTeam2.showInitiativeCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideInitiativeCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getTheRing() || getSharedViewModel().getGameState().getPlayers().get(2).getTheRing()) {
                getBinding().lifeTotalViewTeam2.showTheRingCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideTheRingCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getCityBlessing() || getSharedViewModel().getGameState().getPlayers().get(2).getCityBlessing()) {
                getBinding().lifeTotalViewTeam2.showCityCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideCityCoin();
            }
            getBinding().lifeTotalViewTeam2.refreshSettings();
            getBinding().lifeTotalViewTeam2.setPlainBackgroundColor(companion.getDefaultColors().get(1).intValue());
            Player player2 = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            player2.setName(getSharedViewModel().getGameState().getPlayers().get(2).getName() + " & " + getSharedViewModel().getGameState().getPlayers().get(1).getName());
            player2.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(2).getLifeTotal());
            player2.setUserId(getSharedViewModel().getGameState().getPlayers().get(2).getUserId());
            player2.setLeftBackgroundType(getSharedViewModel().getGameState().getPlayers().get(2).getBackgroundType());
            player2.setLeftScryfallId(getSharedViewModel().getGameState().getPlayers().get(2).getScryfallId());
            player2.setLeftIsPlaneswalker(getSharedViewModel().getGameState().getPlayers().get(2).isPlaneswalker());
            player2.setLeftPhotoUri(getSharedViewModel().getGameState().getPlayers().get(2).getPhotoUri());
            player2.setLeftPlaymatId(getSharedViewModel().getGameState().getPlayers().get(2).getPlaymatId());
            player2.setLeftBackgroundCardId(getSharedViewModel().getGameState().getPlayers().get(2).getBackgroundCardId());
            player2.setBackgroundType(getSharedViewModel().getGameState().getPlayers().get(1).getBackgroundType());
            player2.setScryfallId(getSharedViewModel().getGameState().getPlayers().get(1).getScryfallId());
            player2.setPlaneswalker(getSharedViewModel().getGameState().getPlayers().get(1).isPlaneswalker());
            player2.setPhotoUri(getSharedViewModel().getGameState().getPlayers().get(1).getPhotoUri());
            player2.setPlaymatId(getSharedViewModel().getGameState().getPlayers().get(1).getPlaymatId());
            player2.setBackgroundCardId(getSharedViewModel().getGameState().getPlayers().get(1).getBackgroundCardId());
            getBinding().lifeTotalViewTeam2.updatePlayer(player2);
            getBinding().lifeTotalViewTeam2.checkVitals();
            getBinding().lifeTotalViewTeam2.undoKO();
            getBinding().lifeTotalViewTeam2.undoWin();
            getBinding().lifeTotalViewTeam2.setCallback(new AnonymousClass2());
            getBinding().lifeTotalView1.setVisibility(4);
            getBinding().lifeTotalView2.setVisibility(4);
            getBinding().lifeTotalView3.setVisibility(4);
            getBinding().lifeTotalView4.setVisibility(4);
            getBinding().lifeTotalViewTeam1.setVisibility(0);
            getBinding().lifeTotalViewTeam2.setVisibility(0);
            List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
            if (gameWinners.isEmpty()) {
                return;
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i = 0; i < numberOfPlayers; i++) {
                if (gameWinners.contains(Integer.valueOf(getSharedViewModel().getGameState().getPlayers().get(i).getUserId()))) {
                    if (i == 0 || i == 3) {
                        getBinding().lifeTotalViewTeam1.triggerPlayerWin();
                        getBinding().lifeTotalViewTeam2.triggerPlayerKO();
                        Unit unit = Unit.INSTANCE;
                        return;
                    } else {
                        getBinding().lifeTotalViewTeam2.triggerPlayerWin();
                        getBinding().lifeTotalViewTeam1.triggerPlayerKO();
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                }
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void showStartGameButton() {
        if (this._binding == null) {
            return;
        }
        getBinding().startGameButtonLayout.setVisibility(0);
        hideMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void tutorialComplete() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.tutorialComplete();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void updateTeams() {
        if (this._binding != null && getSharedViewModel().getGameState().getPlayers().size() == 4) {
            super.updateTeams();
            getBinding().lifeTotalViewTeam1.setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
            getBinding().lifeTotalViewTeam1.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(0).getLifeTotal());
            getBinding().lifeTotalViewTeam1.setPoisonCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getPoisonCounters(), getSharedViewModel().getGameState().getPlayers().get(3).getPoisonCounters()));
            getBinding().lifeTotalViewTeam1.setEnergyCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getEnergyCounters(), getSharedViewModel().getGameState().getPlayers().get(3).getEnergyCounters()));
            getBinding().lifeTotalViewTeam1.setStormCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getStormCount(), getSharedViewModel().getGameState().getPlayers().get(3).getStormCount()));
            getBinding().lifeTotalViewTeam1.setTaxCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getTaxCount(), getSharedViewModel().getGameState().getPlayers().get(3).getTaxCount()));
            getBinding().lifeTotalViewTeam1.setTaxCountPartner(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getTaxCountPartner(), getSharedViewModel().getGameState().getPlayers().get(3).getTaxCountPartner()));
            getBinding().lifeTotalViewTeam1.setExperienceCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getExperienceCount(), getSharedViewModel().getGameState().getPlayers().get(3).getExperienceCount()));
            getBinding().lifeTotalViewTeam1.setRadiationCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(0).getRadiationCount(), getSharedViewModel().getGameState().getPlayers().get(3).getRadiationCount()));
            getBinding().lifeTotalViewTeam1.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(3)));
            getBinding().lifeTotalViewTeam1.showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
            getBinding().lifeTotalViewTeam1.showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
            getBinding().lifeTotalViewTeam1.hasPartners(getSharedViewModel().getGameState().getPlayers().get(0).getHasPartners() || getSharedViewModel().getGameState().getPlayers().get(3).getHasPartners());
            getBinding().lifeTotalViewTeam1.hasEnergy(getSharedViewModel().getGameState().getPlayers().get(0).getEnergyEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getEnergyEnabled());
            getBinding().lifeTotalViewTeam1.hasStorm(getSharedViewModel().getGameState().getPlayers().get(0).getStormEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getStormEnabled());
            getBinding().lifeTotalViewTeam1.hasExperience(getSharedViewModel().getGameState().getPlayers().get(0).getExperienceEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getExperienceEnabled());
            getBinding().lifeTotalViewTeam1.hasTax(getSharedViewModel().getGameState().getPlayers().get(0).getTaxEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getTaxEnabled());
            getBinding().lifeTotalViewTeam1.hasRadiation(getSharedViewModel().getGameState().getPlayers().get(0).getRadiationEnabled() || getSharedViewModel().getGameState().getPlayers().get(3).getRadiationEnabled());
            getBinding().lifeTotalViewTeam1.updateCountersLayout();
            if (getSharedViewModel().getGameState().getPlayers().get(0).getMonarch() || getSharedViewModel().getGameState().getPlayers().get(3).getMonarch()) {
                getBinding().lifeTotalViewTeam1.showMonarchCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideMonarchCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getInitiative() || getSharedViewModel().getGameState().getPlayers().get(3).getInitiative()) {
                getBinding().lifeTotalViewTeam1.showInitiativeCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideInitiativeCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getTheRing() || getSharedViewModel().getGameState().getPlayers().get(3).getTheRing()) {
                getBinding().lifeTotalViewTeam1.showTheRingCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideTheRingCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(0).getCityBlessing() || getSharedViewModel().getGameState().getPlayers().get(3).getCityBlessing()) {
                getBinding().lifeTotalViewTeam1.showCityCoin();
            } else {
                getBinding().lifeTotalViewTeam1.hideCityCoin();
            }
            getBinding().lifeTotalViewTeam2.setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
            getBinding().lifeTotalViewTeam2.setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(1).getLifeTotal());
            getBinding().lifeTotalViewTeam2.setPoisonCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getPoisonCounters(), getSharedViewModel().getGameState().getPlayers().get(2).getPoisonCounters()));
            getBinding().lifeTotalViewTeam2.setEnergyCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getEnergyCounters(), getSharedViewModel().getGameState().getPlayers().get(2).getEnergyCounters()));
            getBinding().lifeTotalViewTeam2.setStormCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getStormCount(), getSharedViewModel().getGameState().getPlayers().get(2).getStormCount()));
            getBinding().lifeTotalViewTeam2.setTaxCount(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getTaxCount(), getSharedViewModel().getGameState().getPlayers().get(2).getTaxCount()));
            getBinding().lifeTotalViewTeam2.setTaxCountPartner(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getTaxCountPartner(), getSharedViewModel().getGameState().getPlayers().get(2).getTaxCountPartner()));
            getBinding().lifeTotalViewTeam2.setExperienceCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getExperienceCount(), getSharedViewModel().getGameState().getPlayers().get(2).getExperienceCount()));
            getBinding().lifeTotalViewTeam2.setRadiationCounters(Math.max(getSharedViewModel().getGameState().getPlayers().get(1).getRadiationCount(), getSharedViewModel().getGameState().getPlayers().get(2).getRadiationCount()));
            getBinding().lifeTotalViewTeam2.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(2)));
            getBinding().lifeTotalViewTeam2.showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
            getBinding().lifeTotalViewTeam2.showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
            getBinding().lifeTotalViewTeam2.hasPartners(getSharedViewModel().getGameState().getPlayers().get(1).getHasPartners() || getSharedViewModel().getGameState().getPlayers().get(2).getHasPartners());
            getBinding().lifeTotalViewTeam2.hasEnergy(getSharedViewModel().getGameState().getPlayers().get(1).getEnergyEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getEnergyEnabled());
            getBinding().lifeTotalViewTeam2.hasStorm(getSharedViewModel().getGameState().getPlayers().get(1).getStormEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getStormEnabled());
            getBinding().lifeTotalViewTeam2.hasExperience(getSharedViewModel().getGameState().getPlayers().get(1).getExperienceEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getExperienceEnabled());
            getBinding().lifeTotalViewTeam2.hasTax(getSharedViewModel().getGameState().getPlayers().get(1).getTaxEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getTaxEnabled());
            getBinding().lifeTotalViewTeam2.hasRadiation(getSharedViewModel().getGameState().getPlayers().get(1).getRadiationEnabled() || getSharedViewModel().getGameState().getPlayers().get(2).getRadiationEnabled());
            getBinding().lifeTotalViewTeam2.updateCountersLayout();
            if (getSharedViewModel().getGameState().getPlayers().get(1).getMonarch() || getSharedViewModel().getGameState().getPlayers().get(2).getMonarch()) {
                getBinding().lifeTotalViewTeam2.showMonarchCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideMonarchCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getInitiative() || getSharedViewModel().getGameState().getPlayers().get(2).getInitiative()) {
                getBinding().lifeTotalViewTeam2.showInitiativeCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideInitiativeCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getTheRing() || getSharedViewModel().getGameState().getPlayers().get(2).getTheRing()) {
                getBinding().lifeTotalViewTeam2.showTheRingCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideTheRingCoin();
            }
            if (getSharedViewModel().getGameState().getPlayers().get(1).getCityBlessing() || getSharedViewModel().getGameState().getPlayers().get(2).getCityBlessing()) {
                getBinding().lifeTotalViewTeam2.showCityCoin();
            } else {
                getBinding().lifeTotalViewTeam2.hideCityCoin();
            }
        }
    }
}
