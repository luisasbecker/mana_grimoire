package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InGameEventsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/InGameEventsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/InGameEventItemListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/GameState;Lcom/studiolaganne/lengendarylens/InGameEventItemListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InGameEventsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_EVENT = 1;
    private final GameState gameState;
    private final InGameEventItemListener listener;
    public static final int $stable = 8;

    public InGameEventsAdapter(GameState gameState, InGameEventItemListener listener) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gameState = gameState;
        this.listener = listener;
    }

    static final Unit onBindViewHolder$lambda$0(InGameEventViewHolder inGameEventViewHolder, Ref.BooleanRef booleanRef, final InGameEventsAdapter inGameEventsAdapter, final int i) {
        Context context = inGameEventViewHolder.itemView.getContext();
        Intrinsics.checkNotNull(context);
        IconPopupMenu iconPopupMenu = new IconPopupMenu(context);
        IconPopupMenu.addItem$default(iconPopupMenu, R.string.rollback_event, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.InGameEventsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InGameEventsAdapter.onBindViewHolder$lambda$0$0(this.f$0, i);
            }
        }, 30, (Object) null);
        if (booleanRef.element) {
            iconPopupMenu.addDivider();
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_event, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.InGameEventsAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InGameEventsAdapter.onBindViewHolder$lambda$0$1(this.f$0, i);
                }
            }, 24, (Object) null);
        }
        iconPopupMenu.show(inGameEventViewHolder.getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(InGameEventsAdapter inGameEventsAdapter, int i) {
        inGameEventsAdapter.listener.onEventRollback(i - 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$1(InGameEventsAdapter inGameEventsAdapter, int i) {
        inGameEventsAdapter.listener.onEventDelete(i - 1);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.gameState.getEvents().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int i;
        String name;
        String name2;
        String name3;
        String name4;
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final InGameEventViewHolder inGameEventViewHolder = (InGameEventViewHolder) holder;
        inGameEventViewHolder.getMainLayout().setVisibility(0);
        if (position == 0) {
            inGameEventViewHolder.getSeparatorLayout().setVisibility(8);
            inGameEventViewHolder.getMainEventLayout().setVisibility(0);
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_game_start));
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setVisibility(8);
            if (this.gameState.getStartedAt().length() > 0) {
                inGameEventViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(this.gameState.getStartedAt()));
            }
            inGameEventViewHolder.getDotsLayout().setVisibility(4);
            return;
        }
        MTGameEvent mTGameEvent = this.gameState.getEvents().get(position - 1);
        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnStart.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue())) {
            inGameEventViewHolder.getSeparatorLayout().setVisibility(0);
            inGameEventViewHolder.getMainEventLayout().setVisibility(8);
            int playerid = mTGameEvent.getPlayerid();
            int iIntValue = GameUtils.INSTANCE.getInstance().getDefaultColors().get(playerid).intValue();
            String name5 = this.gameState.getPlayers().get(playerid).getName();
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnStart.getValue())) {
                inGameEventViewHolder.getSeparatorTextStart().setVisibility(0);
                inGameEventViewHolder.getSeparatorTextEnd().setVisibility(8);
                inGameEventViewHolder.getSeparatorLine().setBackgroundColor(iIntValue);
                int value = mTGameEvent.getValue();
                String string = inGameEventViewHolder.itemView.getResources().getString(R.string.turn_start_event);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                inGameEventViewHolder.getSeparatorTextStart().setText(StringsKt.replace$default(string, "{1}", String.valueOf(value + 1), false, 4, (Object) null) + " - " + name5);
                inGameEventViewHolder.getSeparatorTextStart().setTextColor(iIntValue);
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue())) {
                inGameEventViewHolder.getSeparatorTextStart().setVisibility(8);
                inGameEventViewHolder.getSeparatorTextEnd().setVisibility(0);
                inGameEventViewHolder.getSeparatorLine().setBackgroundColor(0);
                String durationSeconds = ServerUtils.INSTANCE.getInstance().formatDurationSeconds(mTGameEvent.getValue());
                String string2 = inGameEventViewHolder.itemView.getResources().getString(R.string.turn_end_event);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                inGameEventViewHolder.getSeparatorTextEnd().setText(string2 + " - " + durationSeconds);
                inGameEventViewHolder.getSeparatorTextEnd().setTextColor(iIntValue);
                return;
            }
            return;
        }
        inGameEventViewHolder.getSeparatorLayout().setVisibility(8);
        inGameEventViewHolder.getMainEventLayout().setVisibility(0);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerStart.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TimerStart.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TimerExpire.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue())) {
            booleanRef.element = false;
        }
        ViewExtensionsKt.setOnClickWithFade(inGameEventViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.InGameEventsAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InGameEventsAdapter.onBindViewHolder$lambda$0(inGameEventViewHolder, booleanRef, this, position);
            }
        });
        int playerid2 = mTGameEvent.getPlayerid();
        inGameEventViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGameEvent.getDate()));
        if (playerid2 == -1) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            String type = mTGameEvent.getType();
            if (Intrinsics.areEqual(type, MTEvent.GameDraw.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_game_draw));
                inGameEventViewHolder.getValueLabel().setVisibility(8);
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.TimerStart.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_timer_start));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() + " min");
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.TimerExpire.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_timer_expired));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.FlipCoin.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_coin_flip));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() == 0 ? "Lost" : "Won");
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD4.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d4));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD6.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d6));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD8.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d8));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD10.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d10));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD12.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d12));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            }
            if (Intrinsics.areEqual(type, MTEvent.RollD20.getValue())) {
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d20));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                return;
            } else {
                if (Intrinsics.areEqual(type, MTEvent.Day.getValue())) {
                    inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.sun);
                    inGameEventViewHolder.getTypeIcon().setVisibility(0);
                    inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_day));
                    inGameEventViewHolder.getValueLabel().setVisibility(4);
                    return;
                }
                if (!Intrinsics.areEqual(type, MTEvent.Night.getValue())) {
                    inGameEventViewHolder.getMainLayout().setVisibility(8);
                    return;
                }
                inGameEventViewHolder.getTypeIcon().setVisibility(0);
                inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.moon);
                inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_night));
                inGameEventViewHolder.getValueLabel().setVisibility(4);
                return;
            }
        }
        Player player = this.gameState.getPlayers().get(playerid2);
        ArrayList<Player> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(player);
        Integer source_playerid = mTGameEvent.getSource_playerid();
        Player player2 = (source_playerid == null || source_playerid.intValue() == -1) ? null : this.gameState.getPlayers().get(source_playerid.intValue());
        if (player2 != null) {
            Boolean.valueOf(arrayList.add(player2));
        }
        Context context = inGameEventViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        List<MTUser> currentUserCache = new PreferencesManager(context).getCurrentUserCache();
        for (Player player3 : arrayList) {
            Iterator<T> it = currentUserCache.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((MTUser) next).getId() == player3.getUserId()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTUser mTUser = (MTUser) next;
            if (mTUser != null) {
                MTGamePlayer mTGamePlayer = new MTGamePlayer(0, null, null, null, null, 0, null, null, null, null, 1023, null);
                mTGamePlayer.setId(mTUser.getId());
                String username = mTUser.getUsername();
                if (username == null) {
                    username = "";
                }
                mTGamePlayer.setUsername(username);
                String picture = mTUser.getPicture();
                if (picture == null) {
                    picture = "";
                }
                mTGamePlayer.setPicture(picture);
                String firstname = mTUser.getFirstname();
                if (firstname == null) {
                    firstname = "";
                }
                mTGamePlayer.setFirstname(firstname);
                arrayList2.add(mTGamePlayer);
            }
        }
        if (arrayList2.isEmpty()) {
            i = 8;
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
        } else {
            inGameEventViewHolder.getUsersRecyclerView().setAdapter(new SmallGamePlayerAdapter(arrayList2, false, 0));
            inGameEventViewHolder.getUsersRecyclerView().setLayoutManager(new LinearLayoutManager(inGameEventViewHolder.itemView.getContext(), 0, false));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context context2 = inGameEventViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(18, context2));
            int itemDecorationCount = inGameEventViewHolder.getUsersRecyclerView().getItemDecorationCount();
            for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                inGameEventViewHolder.getUsersRecyclerView().removeItemDecorationAt(0);
            }
            inGameEventViewHolder.getUsersRecyclerView().addItemDecoration(overlapDecoration);
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(0);
            i = 8;
        }
        inGameEventViewHolder.getLine1TextView().setText(String.valueOf(player.getName()));
        inGameEventViewHolder.getTypeIcon().setVisibility(i);
        inGameEventViewHolder.getValueLabel().setVisibility(i);
        inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
        String type2 = mTGameEvent.getType();
        if (Intrinsics.areEqual(type2, MTEvent.LifeOffset.getValue())) {
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_life_gain));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.winner_green));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_life_loss));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.loser_red));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.CommanderDamage.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.cmd_damage_white);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView = inGameEventViewHolder.getLine2TextView();
                String string3 = inGameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_plus);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                line2TextView.setText(StringsKt.replace$default(string3, "{1}", (player2 == null || (name4 = player2.getName()) == null) ? "" : name4, false, 4, (Object) null));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            TextView line2TextView2 = inGameEventViewHolder.getLine2TextView();
            String string4 = inGameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_minus);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            line2TextView2.setText(StringsKt.replace$default(string4, "{1}", (player2 == null || (name3 = player2.getName()) == null) ? "" : name3, false, 4, (Object) null));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PartnerDamage.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.cmd_damage_white);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView3 = inGameEventViewHolder.getLine2TextView();
                String string5 = inGameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_partner_plus);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                line2TextView3.setText(StringsKt.replace$default(string5, "{1}", (player2 == null || (name2 = player2.getName()) == null) ? "" : name2, false, 4, (Object) null));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            TextView line2TextView4 = inGameEventViewHolder.getLine2TextView();
            String string6 = inGameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_partner_minus);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            line2TextView4.setText(StringsKt.replace$default(string6, "{1}", (player2 == null || (name = player2.getName()) == null) ? "" : name, false, 4, (Object) null));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PlayerStart.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_player_start));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PlayerToss.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_player_toss));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PlayerLose.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_lose));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PlayerConcede.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_concede));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.PlayerWin.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_win));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.TreacheryRole.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            TextView line2TextView5 = inGameEventViewHolder.getLine2TextView();
            String string7 = inGameEventViewHolder.itemView.getResources().getString(R.string.event_treachery_role);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context context3 = inGameEventViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            line2TextView5.setText(StringsKt.replace$default(string7, "{1}", companion2.localizedTreacheryRoleName(context3, mTGameEvent.getValue()), false, 4, (Object) null));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Poison.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.poison_white);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_poison_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_poison_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Energy.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.energy_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_energy_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_energy_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Storm.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.storm_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_storm_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_storm_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Experience.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.experience_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_experience_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_experience_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Tax.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.tax_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_tax_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_tax_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.TaxPartner.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.tax_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_tax_partner_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_tax_partner_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Radiation.getValue())) {
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.radiation_off);
            if (mTGameEvent.getValue() > 0) {
                inGameEventViewHolder.getLine2TextView().setVisibility(0);
                inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_radiation_plus));
                inGameEventViewHolder.getValueLabel().setVisibility(0);
                inGameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
                return;
            }
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_radiation_minus));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Monarch.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_monarch));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Initiative.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_initiative));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.CityBlessing.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_city_blessing));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.TheRing.getValue())) {
            inGameEventViewHolder.getLine2TextView().setVisibility(0);
            inGameEventViewHolder.getLine2TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_the_ring));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.GameDraw.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_game_draw));
            inGameEventViewHolder.getValueLabel().setVisibility(8);
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.TimerStart.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_timer_start));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() + " min");
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.TimerExpire.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_timer_expired));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.FlipCoin.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_coin_flip));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() == 0 ? "Lost" : "Won");
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD4.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d4));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD6.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d6));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD8.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d8));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD10.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d10));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD12.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d12));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.RollD20.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setVisibility(8);
            inGameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(inGameEventViewHolder.itemView.getContext(), R.color.text_color));
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_d20));
            inGameEventViewHolder.getValueLabel().setVisibility(0);
            inGameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            return;
        }
        if (Intrinsics.areEqual(type2, MTEvent.Day.getValue())) {
            inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            inGameEventViewHolder.getLine2TextView().setVisibility(8);
            inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.sun);
            inGameEventViewHolder.getTypeIcon().setVisibility(0);
            inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_day));
            inGameEventViewHolder.getValueLabel().setVisibility(4);
            return;
        }
        if (!Intrinsics.areEqual(type2, MTEvent.Night.getValue())) {
            inGameEventViewHolder.getMainLayout().setVisibility(8);
            return;
        }
        inGameEventViewHolder.getUsersRecyclerView().setVisibility(8);
        inGameEventViewHolder.getLine2TextView().setVisibility(8);
        inGameEventViewHolder.getTypeIcon().setVisibility(0);
        inGameEventViewHolder.getTypeIcon().setImageResource(R.drawable.moon);
        inGameEventViewHolder.getLine1TextView().setText(inGameEventViewHolder.itemView.getResources().getString(R.string.event_night));
        inGameEventViewHolder.getValueLabel().setVisibility(4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_event_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new InGameEventViewHolder(viewInflate);
    }
}
