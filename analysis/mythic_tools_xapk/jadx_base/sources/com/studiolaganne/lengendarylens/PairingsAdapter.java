package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.PairingsAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PairingsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/PairingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/studiolaganne/lengendarylens/PairingsCallback;", "tournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "pairings", "", "Lcom/studiolaganne/lengendarylens/Pairing;", "<init>", "(Lcom/studiolaganne/lengendarylens/PairingsCallback;Lcom/studiolaganne/lengendarylens/Tournament;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "PairingViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PairingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_PAIRING = 1;
    private final PairingsCallback callback;
    private final List<Pairing> pairings;
    private final Tournament tournament;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PairingsAdapter.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/PairingsAdapter$PairingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userInteractionDisabled", "", "player1Label", "Landroid/widget/TextView;", "player1Score", "player2Label", "player2Score", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroidx/constraintlayout/widget/ConstraintLayout;", "vsLabel", "warning", "Landroid/widget/ImageView;", "saveState", "", "position", "", "tournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "pairing", "Lcom/studiolaganne/lengendarylens/Pairing;", "updateLabels", "checkScores", "bind", "callback", "Lcom/studiolaganne/lengendarylens/PairingsCallback;", "rowData", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PairingViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ConstraintLayout layout;
        private final TextView player1Label;
        private final TextView player1Score;
        private final TextView player2Label;
        private final TextView player2Score;
        private boolean userInteractionDisabled;
        private final TextView vsLabel;
        private final ImageView warning;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PairingViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.player1_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.player1Label = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.player1_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.player1Score = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.player2_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.player2Label = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.player2_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.player2Score = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.root_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.layout = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.vs);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.vsLabel = (TextView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.warning);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.warning = (ImageView) viewFindViewById7;
        }

        static final Unit bind$lambda$2(Tournament tournament, Pairing pairing, PairingViewHolder pairingViewHolder, int i, PairingsCallback pairingsCallback) {
            if (tournament.getMatchType() == MatchType.BO1) {
                if (pairing.getFirstPlayerScore() == 0) {
                    pairing.setFirstPlayerScore(1);
                } else {
                    pairing.setFirstPlayerScore(0);
                }
            }
            if (tournament.getMatchType() == MatchType.BO3) {
                if (pairing.getFirstPlayerScore() == 2) {
                    pairing.setFirstPlayerScore(0);
                } else {
                    pairing.setFirstPlayerScore(pairing.getFirstPlayerScore() + 1);
                }
            }
            pairingViewHolder.checkScores(tournament, pairing);
            pairingViewHolder.updateLabels(tournament, pairing);
            pairingViewHolder.saveState(i, tournament, pairing);
            pairingsCallback.pairingsUpdated();
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$3(Tournament tournament, Pairing pairing, PairingViewHolder pairingViewHolder, int i, PairingsCallback pairingsCallback) {
            if (tournament.getMatchType() == MatchType.BO1) {
                if (pairing.getSecondPlayerScore() == 0) {
                    pairing.setSecondPlayerScore(1);
                } else {
                    pairing.setSecondPlayerScore(0);
                }
            }
            if (tournament.getMatchType() == MatchType.BO3) {
                if (pairing.getSecondPlayerScore() == 2) {
                    pairing.setSecondPlayerScore(0);
                } else {
                    pairing.setSecondPlayerScore(pairing.getSecondPlayerScore() + 1);
                }
            }
            pairingViewHolder.checkScores(tournament, pairing);
            pairingViewHolder.updateLabels(tournament, pairing);
            pairingViewHolder.saveState(i, tournament, pairing);
            pairingsCallback.pairingsUpdated();
            return Unit.INSTANCE;
        }

        static final void bind$lambda$4(View view) {
        }

        static final void bind$lambda$5(View view) {
        }

        private final void checkScores(Tournament tournament, Pairing pairing) {
            if (tournament.getMatchType() == MatchType.BO1) {
                if (pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 1) {
                    this.vsLabel.setVisibility(4);
                    this.warning.setVisibility(0);
                    this.layout.setBackgroundResource(R.drawable.custom_pairing_background_error);
                } else {
                    this.vsLabel.setVisibility(0);
                    this.warning.setVisibility(8);
                    if (pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 0) {
                        this.layout.setBackgroundResource(R.drawable.custom_pairing_background_p1);
                    } else if (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 1) {
                        this.layout.setBackgroundResource(R.drawable.custom_pairing_background_p2);
                    } else {
                        this.layout.setBackgroundResource(R.drawable.custom_pairing_background_default);
                    }
                }
            }
            if (tournament.getMatchType() == MatchType.BO3) {
                if (pairing.getFirstPlayerScore() == 2 && pairing.getSecondPlayerScore() == 2) {
                    this.vsLabel.setVisibility(4);
                    this.warning.setVisibility(0);
                    this.layout.setBackgroundResource(R.drawable.custom_pairing_background_error);
                    return;
                }
                this.vsLabel.setVisibility(0);
                this.warning.setVisibility(8);
                if (pairing.getFirstPlayerScore() == 2 && pairing.getSecondPlayerScore() < 2) {
                    this.layout.setBackgroundResource(R.drawable.custom_pairing_background_p1);
                } else if (pairing.getFirstPlayerScore() >= 2 || pairing.getSecondPlayerScore() != 2) {
                    this.layout.setBackgroundResource(R.drawable.custom_pairing_background_default);
                } else {
                    this.layout.setBackgroundResource(R.drawable.custom_pairing_background_p2);
                }
            }
        }

        private final void saveState(int position, Tournament tournament, Pairing pairing) {
            Context context = this.itemView.getContext();
            if (context != null) {
                PreferencesManager preferencesManager = new PreferencesManager(context);
                tournament.getRounds().get(tournament.getCurrentRound()).getPairings().set(position, pairing);
                preferencesManager.saveCurrentTournament(tournament);
            }
        }

        private final void updateLabels(Tournament tournament, Pairing pairing) {
            this.player1Score.setText(String.valueOf(pairing.getFirstPlayerScore()));
            this.player2Score.setText(String.valueOf(pairing.getSecondPlayerScore()));
        }

        public final void bind(final PairingsCallback callback, final int position, final Tournament tournament, final Pairing rowData) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(tournament, "tournament");
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            this.userInteractionDisabled = false;
            TournamentUtils companion = TournamentUtils.INSTANCE.getInstance();
            TournamentPlayer playerById = companion.getPlayerById(tournament, rowData.getFirstPlayerId());
            TournamentPlayer playerById2 = companion.getPlayerById(tournament, rowData.getSecondPlayerId());
            if (playerById2 == null) {
                if (playerById != null) {
                    this.player1Label.setText(playerById.getName());
                    this.player2Label.setText(this.itemView.getResources().getString(R.string.bye_label));
                    if (tournament.getMatchType() == MatchType.BO1) {
                        this.player1Score.setText("1");
                        this.player2Score.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    if (tournament.getMatchType() == MatchType.BO3) {
                        this.player1Score.setText(ExifInterface.GPS_MEASUREMENT_2D);
                        this.player2Score.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    this.userInteractionDisabled = true;
                    checkScores(tournament, rowData);
                }
            } else if (playerById != null) {
                this.player1Label.setText(playerById.getName());
                this.player2Label.setText(playerById2.getName());
                this.player1Score.setText(String.valueOf(rowData.getFirstPlayerScore()));
                this.player2Score.setText(String.valueOf(rowData.getSecondPlayerScore()));
                checkScores(tournament, rowData);
            }
            boolean z = this.userInteractionDisabled;
            TextView textView = this.player1Score;
            if (z) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PairingsAdapter$PairingViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PairingsAdapter.PairingViewHolder.bind$lambda$4(view);
                    }
                });
                this.player2Score.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PairingsAdapter$PairingViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PairingsAdapter.PairingViewHolder.bind$lambda$5(view);
                    }
                });
            } else {
                ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.PairingsAdapter$PairingViewHolder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PairingsAdapter.PairingViewHolder.bind$lambda$2(tournament, rowData, this, position, callback);
                    }
                });
                ViewExtensionsKt.setOnClickWithFade(this.player2Score, new Function0() { // from class: com.studiolaganne.lengendarylens.PairingsAdapter$PairingViewHolder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PairingsAdapter.PairingViewHolder.bind$lambda$3(tournament, rowData, this, position, callback);
                    }
                });
            }
        }
    }

    public PairingsAdapter(PairingsCallback callback, Tournament tournament, List<Pairing> pairings) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(pairings, "pairings");
        this.callback = callback;
        this.tournament = tournament;
        this.pairings = pairings;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.pairings.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Context contextRequireContext;
        Tournament currentTournament;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.callback;
        Fragment fragment = obj instanceof Fragment ? (Fragment) obj : null;
        if (fragment == null || (contextRequireContext = fragment.requireContext()) == null || (currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament()) == null) {
            return;
        }
        List<Pairing> pairings = currentTournament.getRounds().get(currentTournament.getCurrentRound()).getPairings();
        if (position < pairings.size()) {
            Pairing pairing = pairings.get(position);
            if (holder instanceof PairingViewHolder) {
                ((PairingViewHolder) holder).bind(this.callback, position, this.tournament, pairing);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = layoutInflaterFrom.inflate(R.layout.pairing_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new PairingViewHolder(viewInflate);
    }
}
