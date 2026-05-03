package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.databinding.FragmentUserStatsBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UserStatsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserStatsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentUserStatsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentUserStatsBinding;", "userId", "", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentStats", "Lcom/studiolaganne/lengendarylens/MTUserStats;", "currentFilterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "currentFormatId", "Ljava/lang/Integer;", "currentSubFormatId", "currentSubFormatName", "", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "updateFilter", "", "filter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateStats", "updateUI", "stats", "setPrivacyShared", MTApiKt.PRIVACY_TYPE_SHARED, "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserStatsFragment extends Fragment {
    private FragmentUserStatsBinding _binding;
    private Integer currentFormatId;
    private MTUserStats currentStats;
    private Integer currentSubFormatId;
    private String currentSubFormatName;
    private MTUser currentUser;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int userId = -1;
    private FilterDefinition currentFilterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
    private List<MTFormat> formatsForFilter = new ArrayList();

    /* JADX INFO: compiled from: UserStatsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserStatsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/UserStatsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserStatsFragment newInstance() {
            UserStatsFragment userStatsFragment = new UserStatsFragment();
            userStatsFragment.setArguments(new Bundle());
            return userStatsFragment;
        }
    }

    @JvmStatic
    public static final UserStatsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    private final void updateStats() {
        MTUser mTUser = this.currentUser;
        if (mTUser != null) {
            getBinding().overlay.setVisibility(0);
            MTApiKt.getMtApi().getUserStats(mTUser.getId(), this.userId, this.currentFormatId, this.currentSubFormatId, this.currentFilterDefinition.getTagId()).enqueue(new Callback<MTUserStatsResponse>() { // from class: com.studiolaganne.lengendarylens.UserStatsFragment$updateStats$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTUserStatsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.getBinding().overlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTUserStatsResponse> call, Response<MTUserStatsResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.this$0.getBinding().overlay.setVisibility(8);
                    if (!response.isSuccessful()) {
                        this.this$0.getBinding().statsContentLayout.setVisibility(8);
                        this.this$0.getBinding().overlay.setVisibility(8);
                        this.this$0.getBinding().privacyMessageText.setVisibility(0);
                    } else {
                        MTUserStatsResponse mTUserStatsResponseBody = response.body();
                        MTUserStats stats = mTUserStatsResponseBody != null ? mTUserStatsResponseBody.getStats() : null;
                        if (stats != null) {
                            this.this$0.updateUI(stats);
                        }
                    }
                }
            });
        }
    }

    public final FragmentUserStatsBinding getBinding() {
        FragmentUserStatsBinding fragmentUserStatsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentUserStatsBinding);
        return fragmentUserStatsBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.userId = arguments.getInt("userId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                this.currentUser = currentUser;
            }
            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            this.formatsForFilter = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext2).getFormats());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentUserStatsBinding.inflate(inflater, container, false);
        updateStats();
        return getBinding().getRoot();
    }

    public final void setPrivacyShared(boolean shared) {
        if (this._binding == null || shared) {
            return;
        }
        getBinding().statsContentLayout.setVisibility(8);
        getBinding().overlay.setVisibility(8);
        getBinding().privacyMessageText.setVisibility(0);
    }

    public final void updateFilter(FilterDefinition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.currentFilterDefinition = filter;
        this.currentFormatId = filter.getFormatId();
        this.currentSubFormatId = filter.getSubformatId();
        this.currentSubFormatName = filter.getSubformatName();
        updateStats();
    }

    public final void updateUI(MTUserStats stats) {
        MTUserStats mTUserStats;
        Object next;
        String name;
        Intrinsics.checkNotNullParameter(stats, "stats");
        this.currentStats = stats;
        if (getContext() == null || this._binding == null || (mTUserStats = this.currentStats) == null) {
            return;
        }
        getBinding().numGamesValueLabel.setText(String.valueOf(mTUserStats.getGames()));
        if (mTUserStats.getGames() == 1 || mTUserStats.getGames() == 0) {
            getBinding().numGamesLabel.setText(getResources().getString(R.string.games_singular));
        } else {
            getBinding().numGamesLabel.setText(getResources().getString(R.string.games_plural));
        }
        getBinding().numWinsValueLabel.setText(String.valueOf(mTUserStats.getWins()));
        if (mTUserStats.getWins() == 1 || mTUserStats.getWins() == 0) {
            getBinding().numWinsLabel.setText(getResources().getString(R.string.wins_singular));
        } else {
            getBinding().numWinsLabel.setText(getResources().getString(R.string.wins_plural));
        }
        getBinding().numLossesValueLabel.setText(String.valueOf(mTUserStats.getLosses()));
        if (mTUserStats.getLosses() == 1 || mTUserStats.getLosses() == 0) {
            getBinding().numLossesLabel.setText(getResources().getString(R.string.losses_singular));
        } else {
            getBinding().numLossesLabel.setText(getResources().getString(R.string.losses_plural));
        }
        if (mTUserStats.getGames() == 0) {
            getBinding().winRateValueText.setText("--");
            getBinding().winRateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        } else {
            try {
                float f = Float.parseFloat(mTUserStats.getRate());
                if (Math.abs(f) <= Float.MAX_VALUE) {
                    getBinding().winRateValueText.setText(MathKt.roundToInt(f) + "%");
                    TextView textView = getBinding().winRateValueText;
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    textView.setTextColor(companion.getWinRateColor(contextRequireContext, f, this.currentFormatId));
                } else {
                    getBinding().winRateValueText.setText("--");
                    getBinding().winRateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                }
            } catch (NumberFormatException unused) {
                getBinding().winRateValueText.setText("--");
                getBinding().winRateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
            }
        }
        if (this.currentFormatId == null) {
            MTFormatStats mostPlayedFormat = mTUserStats.getMostPlayedFormat();
            if (mostPlayedFormat != null) {
                getBinding().mostPlayedFormatLabelText.setVisibility(0);
                getBinding().mostPlayedFormatValueText.setText(mostPlayedFormat.getName());
                getBinding().mostPlayedFormatGamesValueText.setText(String.valueOf(mostPlayedFormat.getGamesPlayed()));
                if (mostPlayedFormat.getGamesPlayed() == 1 || mostPlayedFormat.getGamesPlayed() == 0) {
                    getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_singular));
                } else {
                    getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_plural));
                }
            }
        } else {
            getBinding().mostPlayedFormatLabelText.setVisibility(8);
            Iterator<T> it = this.formatsForFilter.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                int id = ((MTFormat) next).getId();
                Integer num = this.currentFormatId;
                if (num != null && id == num.intValue()) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat == null || (name = mTFormat.getName()) == null) {
                name = "";
            }
            getBinding().mostPlayedFormatValueText.setText(name);
            String str = this.currentSubFormatName;
            if (str != null) {
                getBinding().mostPlayedFormatValueText.setText(str);
            }
            getBinding().mostPlayedFormatGamesValueText.setText(String.valueOf(mTUserStats.getGames()));
            if (mTUserStats.getGames() == 1 || mTUserStats.getGames() == 0) {
                getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_singular));
            } else {
                getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_plural));
            }
        }
        if (mTUserStats.getAverageGameDuration() == 0.0f) {
            getBinding().durationValueText.setText("--");
        } else {
            TextView textView2 = getBinding().durationValueText;
            ServerUtils companion2 = ServerUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            textView2.setText(companion2.formatDuration(contextRequireContext2, (int) mTUserStats.getAverageGameDuration()));
        }
        MTBestDeck bestDeck = mTUserStats.getBestDeck();
        if (bestDeck == null) {
            getBinding().deckWinsLayout.setVisibility(8);
            return;
        }
        getBinding().bestDeckValueText.setText(bestDeck.getName());
        getBinding().deckWinsValueLabel.setText(String.valueOf(bestDeck.getWins()));
        if (bestDeck.getWins() == 1 || bestDeck.getWins() == 0) {
            getBinding().deckWinsLabel.setText(getResources().getString(R.string.wins_singular));
        } else {
            getBinding().deckWinsLabel.setText(getResources().getString(R.string.wins_plural));
        }
    }
}
