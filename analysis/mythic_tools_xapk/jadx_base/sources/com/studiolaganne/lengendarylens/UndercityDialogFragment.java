package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InitiativeDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\nH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J \u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J \u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\rH\u0003J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\nH\u0003J\u0010\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020\nH\u0002J\u0010\u00105\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/studiolaganne/lengendarylens/UndercityDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "currentPlayerIndex", "", "onDismissCallback", "Lkotlin/Function1;", "", "playerTokenViews", "", "Landroid/view/View;", "targetRoomId", "roomProgression", "", "", "roomOverlayIds", "roomBoxOverlayIds", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "handleAutoAdvancement", "setupPlayerTokens", "createPlayerToken", "playerIndex", "player", "Lcom/studiolaganne/lengendarylens/Player;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dpToPx", "dp", "context", "Landroid/content/Context;", "positionTokenInRoom", "tokenView", "roomId", "setupTokenDrag", "startDrag", "setupDragAndDrop", "showAvailableRooms", "currentRoom", "hideAllRoomOverlays", "enableCloseButton", "dismissWithResult", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UndercityDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private int currentPlayerIndex;
    private GameState gameState;
    private Function1<? super Integer, Unit> onDismissCallback;
    private final Map<Integer, View> playerTokenViews = new LinkedHashMap();
    private int targetRoomId = -1;
    private final Map<Integer, List<Integer>> roomProgression = MapsKt.mapOf(TuplesKt.to(1, CollectionsKt.listOf((Object[]) new Integer[]{2, 3})), TuplesKt.to(2, CollectionsKt.listOf((Object[]) new Integer[]{4, 5})), TuplesKt.to(3, CollectionsKt.listOf((Object[]) new Integer[]{5, 6})), TuplesKt.to(4, CollectionsKt.listOf(7)), TuplesKt.to(5, CollectionsKt.listOf((Object[]) new Integer[]{7, 8})), TuplesKt.to(6, CollectionsKt.listOf(8)), TuplesKt.to(7, CollectionsKt.listOf(9)), TuplesKt.to(8, CollectionsKt.listOf(9)), TuplesKt.to(9, CollectionsKt.listOf(1)));
    private final Map<Integer, Integer> roomOverlayIds = MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.id.room1Overlay)), TuplesKt.to(2, Integer.valueOf(R.id.room2Overlay)), TuplesKt.to(3, Integer.valueOf(R.id.room3Overlay)), TuplesKt.to(4, Integer.valueOf(R.id.room4Overlay)), TuplesKt.to(5, Integer.valueOf(R.id.room5Overlay)), TuplesKt.to(6, Integer.valueOf(R.id.room6Overlay)), TuplesKt.to(7, Integer.valueOf(R.id.room7Overlay)), TuplesKt.to(8, Integer.valueOf(R.id.room8Overlay)), TuplesKt.to(9, Integer.valueOf(R.id.room9Overlay)));
    private final Map<Integer, Integer> roomBoxOverlayIds = MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.id.room1Box)), TuplesKt.to(2, Integer.valueOf(R.id.room2Box)), TuplesKt.to(3, Integer.valueOf(R.id.room3Box)), TuplesKt.to(4, Integer.valueOf(R.id.room4Box)), TuplesKt.to(5, Integer.valueOf(R.id.room5Box)), TuplesKt.to(6, Integer.valueOf(R.id.room6Box)), TuplesKt.to(7, Integer.valueOf(R.id.room7Box)), TuplesKt.to(8, Integer.valueOf(R.id.room8Box)), TuplesKt.to(9, Integer.valueOf(R.id.room9Box)));

    /* JADX INFO: compiled from: InitiativeDialogFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/UndercityDialogFragment$Builder;", "", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "currentPlayerIndex", "", "onDismissCallback", "Lkotlin/Function1;", "", "setState", "setCurrentPlayerIndex", FirebaseAnalytics.Param.INDEX, "setOnDismissCallback", "callback", "build", "Lcom/studiolaganne/lengendarylens/UndercityDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int currentPlayerIndex;
        private GameState gameState = new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0, 0, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0, 0, false, false, 0, 0, 0, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);
        private Function1<? super Integer, Unit> onDismissCallback;

        public final UndercityDialogFragment build() {
            UndercityDialogFragment undercityDialogFragment = new UndercityDialogFragment();
            undercityDialogFragment.gameState = this.gameState;
            undercityDialogFragment.currentPlayerIndex = this.currentPlayerIndex;
            undercityDialogFragment.onDismissCallback = this.onDismissCallback;
            return undercityDialogFragment;
        }

        public final Builder setCurrentPlayerIndex(int index) {
            this.currentPlayerIndex = index;
            return this;
        }

        public final Builder setOnDismissCallback(Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismissCallback = callback;
            return this;
        }

        public final Builder setState(GameState gameState) {
            Intrinsics.checkNotNullParameter(gameState, "gameState");
            this.gameState = gameState;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    private final void createPlayerToken(final int playerIndex, Player player, ConstraintLayout rootLayout) {
        Object next;
        String picture;
        if (getContext() == null) {
            return;
        }
        final View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.initiative_user_token, (ViewGroup) rootLayout, false);
        viewInflate.setAlpha(playerIndex == this.currentPlayerIndex ? 1.0f : 0.333f);
        viewInflate.setElevation(playerIndex + 15.0f);
        if (playerIndex == this.currentPlayerIndex) {
            viewInflate.setElevation(50.0f);
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.profileImageView);
        CircleView circleView = (CircleView) viewInflate.findViewById(R.id.plainCircleView);
        TextView textView = (TextView) viewInflate.findViewById(R.id.playerNameLabel);
        if (player.getUserId() >= 0) {
            if (imageView != null) {
                imageView.setOutlineProvider(new CircularOutlineProvider());
            }
            if (imageView != null) {
                imageView.setClipToOutline(true);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Iterator it = CollectionsKt.toMutableList((Collection) new PreferencesManager(contextRequireContext).getCurrentUserCache()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((MTUser) next).getId() == player.getUserId()) {
                        break;
                    }
                }
            }
            MTUser mTUser = (MTUser) next;
            if (mTUser != null && (picture = mTUser.getPicture()) != null) {
                Glide.with(this).load(picture).into(imageView);
            }
            if (circleView != null) {
                circleView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (circleView != null) {
                circleView.setVisibility(0);
            }
            if (circleView != null) {
                circleView.setColor(GameUtils.INSTANCE.getInstance().getDefaultColors().get(playerIndex).intValue());
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                String upperCase = StringsKt.take(player.getName(), 1).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String strValueOf = String.valueOf(StringsKt.last(player.getName()));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase2 = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                textView.setText(upperCase + upperCase2);
            }
        }
        if (playerIndex == this.currentPlayerIndex && player.getUndercityRoomId() != -1) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            Intrinsics.checkNotNull(viewInflate);
            setupTokenDrag(contextRequireContext2, viewInflate);
        }
        rootLayout.addView(viewInflate);
        this.playerTokenViews.put(Integer.valueOf(playerIndex), viewInflate);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = player.getUndercityRoomId();
        if (intRef.element == -1 && playerIndex == this.currentPlayerIndex) {
            intRef.element = 1;
        }
        viewInflate.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                UndercityDialogFragment.createPlayerToken$lambda$2(this.f$0, viewInflate, intRef, playerIndex);
            }
        });
    }

    static final void createPlayerToken$lambda$2(UndercityDialogFragment undercityDialogFragment, View view, Ref.IntRef intRef, int i) {
        Intrinsics.checkNotNull(view);
        undercityDialogFragment.positionTokenInRoom(view, intRef.element, i);
    }

    private final void dismissWithResult() {
        Function1<? super Integer, Unit> function1 = this.onDismissCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.targetRoomId));
        }
        dismiss();
    }

    private final int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private final void enableCloseButton() {
        ImageView imageView;
        TextView textView;
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(R.id.closeLabel)) != null) {
            textView.setVisibility(0);
        }
        View view2 = getView();
        if (view2 != null && (imageView = (ImageView) view2.findViewById(R.id.closeImage)) != null) {
            imageView.setAlpha(1.0f);
            imageView.setEnabled(true);
            ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UndercityDialogFragment.enableCloseButton$lambda$1$0(this.f$0);
                }
            });
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.1f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.start();
        }
        View view3 = getView();
        ConstraintLayout constraintLayout = view3 != null ? (ConstraintLayout) view3.findViewById(R.id.cancelButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enableCloseButton$lambda$1$0(UndercityDialogFragment undercityDialogFragment) {
        undercityDialogFragment.dismissWithResult();
        return Unit.INSTANCE;
    }

    private final void handleAutoAdvancement() {
        GameState gameState = this.gameState;
        if (gameState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameState");
            gameState = null;
        }
        Player player = gameState.getPlayers().get(this.currentPlayerIndex);
        if (player.getUndercityRoomId() != -1) {
            showAvailableRooms(player.getUndercityRoomId());
        } else {
            this.targetRoomId = 1;
            enableCloseButton();
        }
    }

    private final void hideAllRoomOverlays() {
        TextView textView;
        View viewFindViewById;
        Iterator<T> it = this.roomOverlayIds.values().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            View view = getView();
            if (view != null && (viewFindViewById = view.findViewById(iIntValue)) != null) {
                viewFindViewById.setVisibility(8);
            }
        }
        View view2 = getView();
        if (view2 == null || (textView = (TextView) view2.findViewById(R.id.dragHelpTextView)) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    static final void onStart$lambda$1(UndercityDialogFragment undercityDialogFragment) {
        undercityDialogFragment.setupPlayerTokens();
        undercityDialogFragment.setupDragAndDrop();
        undercityDialogFragment.handleAutoAdvancement();
    }

    static final void onViewCreated$lambda$0(View view) {
    }

    static final Unit onViewCreated$lambda$2(UndercityDialogFragment undercityDialogFragment) {
        undercityDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void positionTokenInRoom(View tokenView, int roomId, int playerIndex) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        if (getContext() == null) {
            return;
        }
        if (roomId == -1) {
            tokenView.setVisibility(8);
            return;
        }
        Integer num = this.roomOverlayIds.get(Integer.valueOf(roomId));
        if (num != null) {
            int iIntValue = num.intValue();
            View view = getView();
            if (view == null || (viewFindViewById = view.findViewById(iIntValue)) == null) {
                return;
            }
            if (playerIndex == this.currentPlayerIndex) {
                Integer num2 = this.roomBoxOverlayIds.get(Integer.valueOf(roomId));
                if (num2 == null) {
                    return;
                }
                int iIntValue2 = num2.intValue();
                Iterator<Integer> it = this.roomBoxOverlayIds.values().iterator();
                while (it.hasNext()) {
                    int iIntValue3 = it.next().intValue();
                    if (iIntValue3 == iIntValue2) {
                        View view2 = getView();
                        if (view2 != null && (viewFindViewById2 = view2.findViewById(iIntValue3)) != null) {
                            viewFindViewById2.setVisibility(0);
                        }
                    } else {
                        View view3 = getView();
                        if (view3 != null && (viewFindViewById3 = view3.findViewById(iIntValue3)) != null) {
                            viewFindViewById3.setVisibility(8);
                        }
                    }
                }
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int iDpToPx = playerIndex * dpToPx(12, contextRequireContext);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            int iDpToPx2 = iDpToPx - dpToPx(28, contextRequireContext2);
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            int i = -dpToPx(38, contextRequireContext3);
            layoutParams.leftToLeft = 0;
            layoutParams.topToTop = 0;
            layoutParams.setMargins(viewFindViewById.getLeft() + iDpToPx2, viewFindViewById.getTop() + i, 0, 0);
            tokenView.setLayoutParams(layoutParams);
        }
    }

    private final void setupDragAndDrop() {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.cardLayout)) == null) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : this.roomOverlayIds.entrySet()) {
            final int iIntValue = entry.getKey().intValue();
            View viewFindViewById = constraintLayout.findViewById(entry.getValue().intValue());
            if (viewFindViewById != null) {
                viewFindViewById.setOnDragListener(new View.OnDragListener() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnDragListener
                    public final boolean onDrag(View view2, DragEvent dragEvent) {
                        return UndercityDialogFragment.setupDragAndDrop$lambda$0$0(this.f$0, iIntValue, view2, dragEvent);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDragAndDrop$lambda$0$0(UndercityDialogFragment undercityDialogFragment, int i, View view, DragEvent dragEvent) {
        View view2;
        int action = dragEvent.getAction();
        GameState gameState = null;
        if (action == 1) {
            GameState gameState2 = undercityDialogFragment.gameState;
            if (gameState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameState");
            } else {
                gameState = gameState2;
            }
            List<Integer> listEmptyList = undercityDialogFragment.roomProgression.get(Integer.valueOf(gameState.getPlayers().get(undercityDialogFragment.currentPlayerIndex).getUndercityRoomId()));
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.contains(Integer.valueOf(i))) {
                Intrinsics.checkNotNull(view);
                view.setVisibility(0);
                view.setBackgroundResource(R.drawable.room_box_overlay);
            }
            return true;
        }
        if (action == 3) {
            GameState gameState3 = undercityDialogFragment.gameState;
            if (gameState3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameState");
            } else {
                gameState = gameState3;
            }
            List<Integer> listEmptyList2 = undercityDialogFragment.roomProgression.get(Integer.valueOf(gameState.getPlayers().get(undercityDialogFragment.currentPlayerIndex).getUndercityRoomId()));
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            if (!listEmptyList2.contains(Integer.valueOf(i))) {
                return false;
            }
            undercityDialogFragment.targetRoomId = i;
            View view3 = undercityDialogFragment.playerTokenViews.get(Integer.valueOf(undercityDialogFragment.currentPlayerIndex));
            if (view3 != null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view3, "alpha", 0.3f, 1.0f);
                objectAnimatorOfFloat.setDuration(200L);
                objectAnimatorOfFloat.start();
                undercityDialogFragment.positionTokenInRoom(view3, i, undercityDialogFragment.currentPlayerIndex);
                view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        return UndercityDialogFragment.setupDragAndDrop$lambda$0$0$0$1(view4, motionEvent);
                    }
                });
            }
            undercityDialogFragment.hideAllRoomOverlays();
            undercityDialogFragment.enableCloseButton();
            return true;
        }
        if (action == 4) {
            GameState gameState4 = undercityDialogFragment.gameState;
            if (gameState4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameState");
            } else {
                gameState = gameState4;
            }
            List<Integer> listEmptyList3 = undercityDialogFragment.roomProgression.get(Integer.valueOf(gameState.getPlayers().get(undercityDialogFragment.currentPlayerIndex).getUndercityRoomId()));
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            if (listEmptyList3.contains(Integer.valueOf(i))) {
                view.setBackgroundResource(R.drawable.room_box_overlay);
            } else {
                Intrinsics.checkNotNull(view);
                view.setVisibility(8);
            }
            if (!dragEvent.getResult() && (view2 = undercityDialogFragment.playerTokenViews.get(Integer.valueOf(undercityDialogFragment.currentPlayerIndex))) != null) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, "alpha", 0.3f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.start();
            }
            return true;
        }
        if (action == 5) {
            GameState gameState5 = undercityDialogFragment.gameState;
            if (gameState5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameState");
            } else {
                gameState = gameState5;
            }
            List<Integer> listEmptyList4 = undercityDialogFragment.roomProgression.get(Integer.valueOf(gameState.getPlayers().get(undercityDialogFragment.currentPlayerIndex).getUndercityRoomId()));
            if (listEmptyList4 == null) {
                listEmptyList4 = CollectionsKt.emptyList();
            }
            if (!listEmptyList4.contains(Integer.valueOf(i))) {
                return false;
            }
            view.setBackgroundResource(R.drawable.room_box_overlay_highlight);
            return true;
        }
        if (action != 6) {
            return false;
        }
        GameState gameState6 = undercityDialogFragment.gameState;
        if (gameState6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameState");
        } else {
            gameState = gameState6;
        }
        List<Integer> listEmptyList5 = undercityDialogFragment.roomProgression.get(Integer.valueOf(gameState.getPlayers().get(undercityDialogFragment.currentPlayerIndex).getUndercityRoomId()));
        if (listEmptyList5 == null) {
            listEmptyList5 = CollectionsKt.emptyList();
        }
        if (listEmptyList5.contains(Integer.valueOf(i))) {
            view.setBackgroundResource(R.drawable.room_box_overlay);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDragAndDrop$lambda$0$0$0$1(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void setupPlayerTokens() {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.cardLayout)) == null) {
            return;
        }
        Iterator<T> it = this.playerTokenViews.values().iterator();
        while (it.hasNext()) {
            constraintLayout.removeView((View) it.next());
        }
        this.playerTokenViews.clear();
        GameState gameState = this.gameState;
        if (gameState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameState");
            gameState = null;
        }
        int i = 0;
        for (Object obj : gameState.getPlayers()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createPlayerToken(i, (Player) obj, constraintLayout);
            i = i2;
        }
    }

    private final void setupTokenDrag(Context context, final View tokenView) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = ViewConfiguration.get(context).getScaledTouchSlop();
        tokenView.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return UndercityDialogFragment.setupTokenDrag$lambda$0(floatRef, floatRef2, booleanRef, intRef, this, tokenView, view, motionEvent);
            }
        });
    }

    static final boolean setupTokenDrag$lambda$0(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.BooleanRef booleanRef, Ref.IntRef intRef, UndercityDialogFragment undercityDialogFragment, View view, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getRawX();
            floatRef2.element = motionEvent.getRawY();
            booleanRef.element = true;
            return true;
        }
        if (action == 1) {
            return Math.abs(motionEvent.getRawX() - floatRef.element) <= ((float) intRef.element) || Math.abs(motionEvent.getRawY() - floatRef2.element) <= ((float) intRef.element);
        }
        if (action != 2 || !booleanRef.element) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float fAbs = Math.abs(rawX - floatRef.element);
        float fAbs2 = Math.abs(rawY - floatRef2.element);
        if (fAbs > intRef.element || fAbs2 > intRef.element) {
            booleanRef.element = false;
            undercityDialogFragment.startDrag(view);
        }
        return true;
    }

    private final void showAvailableRooms(int currentRoom) {
        List<Integer> list = this.roomProgression.get(Integer.valueOf(currentRoom));
        if (list == null) {
            return;
        }
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.dragHelpTextView) : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Integer num = this.roomOverlayIds.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (num != null) {
                int iIntValue = num.intValue();
                View view2 = getView();
                View viewFindViewById = view2 != null ? view2.findViewById(iIntValue) : null;
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                }
                if (viewFindViewById != null) {
                    viewFindViewById.setBackgroundResource(R.drawable.room_box_overlay);
                }
            }
        }
    }

    private final void startDrag(final View view) {
        view.startDragAndDrop(ClipData.newPlainText("playerToken", String.valueOf(this.currentPlayerIndex)), new View.DragShadowBuilder(view) { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$startDrag$shadowBuilder$1
            final /* synthetic */ View $view;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(view);
                this.$view = view;
            }

            @Override // android.view.View.DragShadowBuilder
            public void onDrawShadow(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                canvas.scale(1.5f, 1.5f);
                this.$view.draw(canvas);
            }

            @Override // android.view.View.DragShadowBuilder
            public void onProvideShadowMetrics(Point size, Point touch) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(touch, "touch");
                size.set((int) (this.$view.getWidth() * 1.5f), (int) (this.$view.getHeight() * 1.5f));
                touch.set(size.x / 2, size.y / 2);
            }
        }, view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_initiative, container, false);
        setCancelable(false);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.playerTokenViews.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View view;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
            window.setFlags(1024, 1024);
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        if (this.gameState == null || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                UndercityDialogFragment.onStart$lambda$1(this.f$0);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.closeImage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UndercityDialogFragment.onViewCreated$lambda$0(view2);
            }
        });
        if (imageView != null) {
            imageView.setAlpha(0.3f);
        }
        if (imageView != null) {
            imageView.setEnabled(false);
        }
        TextView textView = (TextView) view.findViewById(R.id.closeLabel);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cancelButtonLayout);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (constraintLayout != null) {
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.UndercityDialogFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UndercityDialogFragment.onViewCreated$lambda$2(this.f$0);
                }
            });
        }
    }
}
