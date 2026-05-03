package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GameEventsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameEventsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "events", "", "Lcom/studiolaganne/lengendarylens/MTGameEvent;", "fullGame", "Lcom/studiolaganne/lengendarylens/MTGame;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTGame;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameEventsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_EVENT = 1;
    private final List<MTGameEvent> events;
    private final MTGame fullGame;
    public static final int $stable = 8;

    public GameEventsAdapter(List<MTGameEvent> events, MTGame fullGame) {
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(fullGame, "fullGame");
        this.events = events;
        this.fullGame = fullGame;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.events.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object next;
        String firstname;
        Object next2;
        Object obj;
        String firstname2;
        String firstname3;
        String firstname4;
        String firstname5;
        Intrinsics.checkNotNullParameter(holder, "holder");
        GameEventViewHolder gameEventViewHolder = (GameEventViewHolder) holder;
        gameEventViewHolder.getMainLayout().setVisibility(0);
        gameEventViewHolder.getDotsLayout().setVisibility(8);
        if (position == 0) {
            gameEventViewHolder.getSeparatorLayout().setVisibility(8);
            gameEventViewHolder.getMainEventLayout().setVisibility(0);
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_game_start));
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setVisibility(8);
            gameEventViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(this.fullGame.getStarted_at()));
            return;
        }
        MTGameEvent mTGameEvent = this.events.get(position - 1);
        String str = "";
        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnStart.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue())) {
            gameEventViewHolder.getSeparatorSpacer().setVisibility(8);
            gameEventViewHolder.getSeparatorLayout().setVisibility(0);
            gameEventViewHolder.getMainEventLayout().setVisibility(8);
            int playerid = mTGameEvent.getPlayerid();
            int iAbs = Math.abs(playerid);
            if (iAbs >= GameUtils.INSTANCE.getInstance().getDefaultColors().size()) {
                iAbs = 0;
            }
            int iIntValue = GameUtils.INSTANCE.getInstance().getDefaultColors().get(iAbs).intValue();
            Iterator<T> it = this.fullGame.getPlayers().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((MTGamePlayer) next).getId() == playerid) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTGamePlayer mTGamePlayer = (MTGamePlayer) next;
            if (mTGamePlayer != null && (firstname = mTGamePlayer.getFirstname()) != null) {
                str = firstname;
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnStart.getValue())) {
                gameEventViewHolder.getSeparatorTextStart().setVisibility(0);
                gameEventViewHolder.getSeparatorTextEnd().setVisibility(8);
                gameEventViewHolder.getSeparatorLine().setBackgroundColor(iIntValue);
                int value = mTGameEvent.getValue();
                String string = gameEventViewHolder.itemView.getResources().getString(R.string.turn_start_event);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                gameEventViewHolder.getSeparatorTextStart().setText(StringsKt.replace$default(string, "{1}", String.valueOf(value + 1), false, 4, (Object) null) + " - " + str);
                gameEventViewHolder.getSeparatorTextStart().setTextColor(iIntValue);
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue())) {
                gameEventViewHolder.getSeparatorTextStart().setVisibility(8);
                gameEventViewHolder.getSeparatorTextEnd().setVisibility(0);
                gameEventViewHolder.getSeparatorLine().setBackgroundColor(0);
                String durationSeconds = ServerUtils.INSTANCE.getInstance().formatDurationSeconds(mTGameEvent.getValue());
                String string2 = gameEventViewHolder.itemView.getResources().getString(R.string.turn_end_event);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                gameEventViewHolder.getSeparatorTextEnd().setText(string2 + " - " + durationSeconds);
                gameEventViewHolder.getSeparatorTextEnd().setTextColor(iIntValue);
                return;
            }
            return;
        }
        gameEventViewHolder.getSeparatorLayout().setVisibility(8);
        gameEventViewHolder.getMainEventLayout().setVisibility(0);
        int playerid2 = mTGameEvent.getPlayerid();
        Iterator<T> it2 = this.fullGame.getPlayers().iterator();
        while (true) {
            if (it2.hasNext()) {
                next2 = it2.next();
                if (((MTGamePlayer) next2).getId() == playerid2) {
                    break;
                }
            } else {
                next2 = null;
                break;
            }
        }
        MTGamePlayer mTGamePlayer2 = (MTGamePlayer) next2;
        gameEventViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGameEvent.getDate()));
        if (mTGamePlayer2 == null) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            String type = mTGameEvent.getType();
            if (Intrinsics.areEqual(type, MTEvent.GameDraw.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_game_draw));
                gameEventViewHolder.getValueLabel().setVisibility(8);
            } else if (Intrinsics.areEqual(type, MTEvent.TimerStart.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_timer_start));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() + " min");
            } else if (Intrinsics.areEqual(type, MTEvent.TimerExpire.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_timer_expired));
            } else if (Intrinsics.areEqual(type, MTEvent.FlipCoin.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_coin_flip));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() == 0 ? "Lost" : "Won");
            } else if (Intrinsics.areEqual(type, MTEvent.RollD4.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d4));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.RollD6.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d6));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.RollD8.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d8));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.RollD10.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d10));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.RollD12.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d12));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.RollD20.getValue())) {
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d20));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
            } else if (Intrinsics.areEqual(type, MTEvent.Day.getValue())) {
                gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.sun);
                gameEventViewHolder.getTypeIcon().setVisibility(0);
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_day));
                gameEventViewHolder.getValueLabel().setVisibility(4);
            } else if (Intrinsics.areEqual(type, MTEvent.Night.getValue())) {
                gameEventViewHolder.getTypeIcon().setVisibility(0);
                gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.moon);
                gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_night));
                gameEventViewHolder.getValueLabel().setVisibility(4);
            } else {
                gameEventViewHolder.getMainLayout().setVisibility(8);
            }
            Unit unit = Unit.INSTANCE;
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mTGamePlayer2);
        Integer source_playerid = mTGameEvent.getSource_playerid();
        Iterator<T> it3 = this.fullGame.getPlayers().iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj = null;
                break;
            }
            Object next3 = it3.next();
            int id = ((MTGamePlayer) next3).getId();
            if (source_playerid != null && id == source_playerid.intValue()) {
                obj = next3;
                break;
            }
        }
        MTGamePlayer mTGamePlayer3 = (MTGamePlayer) obj;
        if (mTGamePlayer3 != null) {
            Boolean.valueOf(arrayList.add(mTGamePlayer3));
        }
        gameEventViewHolder.getUsersRecyclerView().setAdapter(new SmallGamePlayerAdapter(arrayList, false, 0));
        gameEventViewHolder.getUsersRecyclerView().setLayoutManager(new LinearLayoutManager(gameEventViewHolder.itemView.getContext(), 0, false));
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context = gameEventViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(18, context));
        int itemDecorationCount = gameEventViewHolder.getUsersRecyclerView().getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            gameEventViewHolder.getUsersRecyclerView().removeItemDecorationAt(0);
        }
        gameEventViewHolder.getUsersRecyclerView().addItemDecoration(overlapDecoration);
        gameEventViewHolder.getUsersRecyclerView().setVisibility(0);
        gameEventViewHolder.getLine1TextView().setText(mTGamePlayer2.getFirstname() + " (@" + mTGamePlayer2.getUsername() + ")");
        gameEventViewHolder.getTypeIcon().setVisibility(8);
        gameEventViewHolder.getValueLabel().setVisibility(8);
        gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
        String type2 = mTGameEvent.getType();
        if (Intrinsics.areEqual(type2, MTEvent.LifeOffset.getValue())) {
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_life_gain));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.winner_green));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_life_loss));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.loser_red));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.CommanderDamage.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.cmd_damage_white);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView = gameEventViewHolder.getLine2TextView();
                String string3 = gameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_plus);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                line2TextView.setText(StringsKt.replace$default(string3, "{1}", (mTGamePlayer3 == null || (firstname5 = mTGamePlayer3.getFirstname()) == null) ? "" : firstname5, false, 4, (Object) null));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView2 = gameEventViewHolder.getLine2TextView();
                String string4 = gameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_minus);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                line2TextView2.setText(StringsKt.replace$default(string4, "{1}", (mTGamePlayer3 == null || (firstname4 = mTGamePlayer3.getFirstname()) == null) ? "" : firstname4, false, 4, (Object) null));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.PartnerDamage.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.cmd_damage_white);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView3 = gameEventViewHolder.getLine2TextView();
                String string5 = gameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_partner_plus);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                line2TextView3.setText(StringsKt.replace$default(string5, "{1}", (mTGamePlayer3 == null || (firstname3 = mTGamePlayer3.getFirstname()) == null) ? "" : firstname3, false, 4, (Object) null));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                TextView line2TextView4 = gameEventViewHolder.getLine2TextView();
                String string6 = gameEventViewHolder.itemView.getResources().getString(R.string.event_cmd_dmg_partner_minus);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                line2TextView4.setText(StringsKt.replace$default(string6, "{1}", (mTGamePlayer3 == null || (firstname2 = mTGamePlayer3.getFirstname()) == null) ? "" : firstname2, false, 4, (Object) null));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.PlayerStart.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_player_start));
        } else if (Intrinsics.areEqual(type2, MTEvent.PlayerToss.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_player_toss));
        } else if (Intrinsics.areEqual(type2, MTEvent.PlayerLose.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_lose));
        } else if (Intrinsics.areEqual(type2, MTEvent.PlayerConcede.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_concede));
        } else if (Intrinsics.areEqual(type2, MTEvent.PlayerWin.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_win));
        } else if (Intrinsics.areEqual(type2, MTEvent.TreacheryRole.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            TextView line2TextView5 = gameEventViewHolder.getLine2TextView();
            String string7 = gameEventViewHolder.itemView.getResources().getString(R.string.event_treachery_role);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context context2 = gameEventViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            line2TextView5.setText(StringsKt.replace$default(string7, "{1}", companion2.localizedTreacheryRoleName(context2, mTGameEvent.getValue()), false, 4, (Object) null));
        } else if (Intrinsics.areEqual(type2, MTEvent.Poison.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.poison_white);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_poison_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_poison_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Energy.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.energy_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_energy_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_energy_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Storm.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.storm_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_storm_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_storm_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Experience.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.experience_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_experience_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_experience_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Tax.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.tax_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_tax_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_tax_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.TaxPartner.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.tax_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_tax_partner_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_tax_partner_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Radiation.getValue())) {
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.radiation_off);
            if (mTGameEvent.getValue() > 0) {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_radiation_plus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText("+" + mTGameEvent.getValue());
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                gameEventViewHolder.getLine2TextView().setVisibility(0);
                gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_radiation_minus));
                gameEventViewHolder.getValueLabel().setVisibility(0);
                gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
                gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            }
        } else if (Intrinsics.areEqual(type2, MTEvent.Monarch.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_monarch));
        } else if (Intrinsics.areEqual(type2, MTEvent.Initiative.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_initiative));
        } else if (Intrinsics.areEqual(type2, MTEvent.CityBlessing.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_city_blessing));
        } else if (Intrinsics.areEqual(type2, MTEvent.TheRing.getValue())) {
            gameEventViewHolder.getLine2TextView().setVisibility(0);
            gameEventViewHolder.getLine2TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_the_ring));
        } else if (Intrinsics.areEqual(type2, MTEvent.GameDraw.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_game_draw));
            gameEventViewHolder.getValueLabel().setVisibility(8);
        } else if (Intrinsics.areEqual(type2, MTEvent.TimerStart.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_timer_start));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() + " min");
        } else if (Intrinsics.areEqual(type2, MTEvent.TimerExpire.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_timer_expired));
        } else if (Intrinsics.areEqual(type2, MTEvent.FlipCoin.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_coin_flip));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(mTGameEvent.getValue() == 0 ? "Lost" : "Won");
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD4.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d4));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD6.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d6));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD8.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d8));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD10.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d10));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD12.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d12));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.RollD20.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(8);
            gameEventViewHolder.getValueLabel().setTextColor(ContextCompat.getColor(gameEventViewHolder.itemView.getContext(), R.color.text_color));
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_d20));
            gameEventViewHolder.getValueLabel().setVisibility(0);
            gameEventViewHolder.getValueLabel().setText(String.valueOf(mTGameEvent.getValue()));
        } else if (Intrinsics.areEqual(type2, MTEvent.Day.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.sun);
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_day));
            gameEventViewHolder.getValueLabel().setVisibility(4);
        } else if (Intrinsics.areEqual(type2, MTEvent.Night.getValue())) {
            gameEventViewHolder.getUsersRecyclerView().setVisibility(8);
            gameEventViewHolder.getLine2TextView().setVisibility(8);
            gameEventViewHolder.getTypeIcon().setVisibility(0);
            gameEventViewHolder.getTypeIcon().setImageResource(R.drawable.moon);
            gameEventViewHolder.getLine1TextView().setText(gameEventViewHolder.itemView.getResources().getString(R.string.event_night));
            gameEventViewHolder.getValueLabel().setVisibility(4);
        } else {
            gameEventViewHolder.getMainLayout().setVisibility(8);
        }
        Unit unit2 = Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_event_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new GameEventViewHolder(viewInflate);
    }
}
