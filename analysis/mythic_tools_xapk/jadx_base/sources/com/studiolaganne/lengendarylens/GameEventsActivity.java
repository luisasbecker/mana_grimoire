package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameEventsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameEventsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/studiolaganne/lengendarylens/InGameEventItemListener;", "<init>", "()V", "onEventDelete", "", FirebaseAnalytics.Param.INDEX, "", "onEventRollback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameEventsActivity extends AppCompatActivity implements InGameEventItemListener {
    public static final int $stable = 8;

    static final Unit onCreate$lambda$1(GameEventsActivity gameEventsActivity) {
        gameEventsActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onEventRollback$lambda$0$0(GameEventsActivity gameEventsActivity, GameState gameState, int i, PreferencesManager preferencesManager, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameEventsActivity.isFinishing() || gameEventsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        if (gameState.getEvents().size() <= i) {
            dialog.dismiss();
            return Unit.INSTANCE;
        }
        MTGameEvent mTGameEvent = gameState.getEvents().get(i);
        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.CommanderDamage.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PartnerDamage.getValue())) {
            int i2 = i + 1;
            int size = gameState.getEvents().size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MTGameEvent mTGameEvent2 = gameState.getEvents().get(i2);
                if (Intrinsics.areEqual(mTGameEvent2.getType(), MTEvent.LifeOffset.getValue()) && mTGameEvent2.getPlayerid() == mTGameEvent.getPlayerid() && mTGameEvent2.getValue() == (-mTGameEvent.getValue())) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size2 = gameState.getEvents().size();
        for (int i3 = i + 1; i3 < size2; i3++) {
            MTGameEvent mTGameEvent3 = gameState.getEvents().get(i3);
            if (!Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.PlayerStart.getValue()) && !Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TimerStart.getValue()) && !Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TimerExpire.getValue()) && !Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TreacheryRole.getValue())) {
                if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.PlayerWin.getValue())) {
                    arrayList2.add(Integer.valueOf(mTGameEvent3.getPlayerid()));
                } else if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.PlayerLose.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerConcede.getValue())) {
                    arrayList.add(Integer.valueOf(mTGameEvent3.getPlayerid()));
                }
                arrayList3.add(Integer.valueOf(i3));
            }
        }
        int size3 = arrayList3.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i4 = size3 - 1;
                gameState.getEvents().remove(((Number) arrayList3.get(size3)).intValue());
                if (i4 < 0) {
                    break;
                }
                size3 = i4;
            }
        }
        preferencesManager.saveUndoKOs(arrayList);
        preferencesManager.saveUndoWins(arrayList2);
        preferencesManager.saveCurrentGame(gameState);
        ((RecyclerView) gameEventsActivity.findViewById(R.id.eventsRecyclerView)).setAdapter(new InGameEventsAdapter(gameState, gameEventsActivity));
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onEventRollback$lambda$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_events);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.eventsRecyclerView);
        GameEventsActivity gameEventsActivity = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(gameEventsActivity));
        GameState currentGame = new PreferencesManager(gameEventsActivity).getCurrentGame();
        if (currentGame != null) {
            recyclerView.setAdapter(new InGameEventsAdapter(currentGame, this));
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.GameEventsActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameEventsActivity.onCreate$lambda$1(this.f$0);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    @Override // com.studiolaganne.lengendarylens.InGameEventItemListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEventDelete(int index) {
        PreferencesManager preferencesManager;
        GameState currentGame;
        if (isFinishing() || isDestroyed() || (currentGame = (preferencesManager = new PreferencesManager(this)).getCurrentGame()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        MTGameEvent mTGameEvent = currentGame.getEvents().get(index);
        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.CommanderDamage.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PartnerDamage.getValue())) {
            int i = index + 1;
            int size = currentGame.getEvents().size();
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                MTGameEvent mTGameEvent2 = currentGame.getEvents().get(i);
                if (Intrinsics.areEqual(mTGameEvent2.getType(), MTEvent.LifeOffset.getValue()) && mTGameEvent2.getPlayerid() == mTGameEvent.getPlayerid() && mTGameEvent2.getValue() == (-mTGameEvent.getValue())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                currentGame.getEvents().remove(index);
            } else if (i > index) {
                currentGame.getEvents().remove(i);
                currentGame.getEvents().remove(index);
            } else {
                currentGame.getEvents().remove(index);
                currentGame.getEvents().remove(i);
            }
        } else if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.LifeOffset.getValue())) {
            int value = mTGameEvent.getValue();
            int playerid = mTGameEvent.getPlayerid();
            int i2 = index - 1;
            int iMax = Math.max(0, index - 5);
            if (iMax <= i2) {
                while (true) {
                    MTGameEvent mTGameEvent3 = currentGame.getEvents().get(i2);
                    if ((!Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.CommanderDamage.getValue()) && !Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.PartnerDamage.getValue())) || mTGameEvent3.getPlayerid() != playerid || mTGameEvent3.getValue() != (-value)) {
                        if (i2 == iMax) {
                            break;
                        } else {
                            i2--;
                        }
                    } else {
                        break;
                    }
                }
                i2 = -1;
                if (i2 == -1) {
                    currentGame.getEvents().remove(index);
                    currentGame.getEvents().remove(i2);
                } else {
                    currentGame.getEvents().remove(index);
                }
            } else {
                i2 = -1;
                if (i2 == -1) {
                }
            }
        } else {
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerWin.getValue())) {
                arrayList2.add(Integer.valueOf(mTGameEvent.getPlayerid()));
            } else if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerLose.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerConcede.getValue())) {
                arrayList.add(Integer.valueOf(mTGameEvent.getPlayerid()));
            }
            currentGame.getEvents().remove(index);
        }
        preferencesManager.saveUndoKOs(arrayList);
        preferencesManager.saveUndoWins(arrayList2);
        preferencesManager.saveCurrentGame(currentGame);
        ((RecyclerView) findViewById(R.id.eventsRecyclerView)).setAdapter(new InGameEventsAdapter(currentGame, this));
    }

    @Override // com.studiolaganne.lengendarylens.InGameEventItemListener
    public void onEventRollback(final int index) {
        final PreferencesManager preferencesManager;
        final GameState currentGame;
        if (isFinishing() || isDestroyed() || (currentGame = (preferencesManager = new PreferencesManager(this)).getCurrentGame()) == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.confirm_rollback);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.rollback);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameEventsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameEventsActivity.onEventRollback$lambda$0$0(this.f$0, currentGame, index, preferencesManager, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameEventsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameEventsActivity.onEventRollback$lambda$0$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "CustomDialogFragment");
    }
}
