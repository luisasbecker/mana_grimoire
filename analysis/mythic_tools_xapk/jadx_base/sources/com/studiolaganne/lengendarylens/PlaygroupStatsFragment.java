package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentPlaygroupStatsBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupStatsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0002J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000eJ\u0006\u0010/\u001a\u00020\u001dJ\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupStatsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupStatsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupStatsBinding;", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentPlaygroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "filterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "currentFormatId", "", "Ljava/lang/Integer;", "currentSubFormatId", "currentSubFormatName", "", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "parentActivity", "Lcom/studiolaganne/lengendarylens/PlaygroupDetailsActivity;", "currentProfileSheet", "Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "", "adjustRecyclerViewHeight", "updateFilter", "filter", "updateStats", "updateUI", "playgroup", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupStatsFragment extends Fragment {
    private FragmentPlaygroupStatsBinding _binding;
    private Integer currentFormatId;
    private MTPlaygroup currentPlaygroup;
    private ProfileBottomSheetFragment currentProfileSheet;
    private Integer currentSubFormatId;
    private String currentSubFormatName;
    private MTUser currentUser;
    private FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private PlaygroupDetailsActivity parentActivity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PlaygroupStatsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupStatsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/PlaygroupStatsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PlaygroupStatsFragment newInstance() {
            PlaygroupStatsFragment playgroupStatsFragment = new PlaygroupStatsFragment();
            playgroupStatsFragment.setArguments(new Bundle());
            return playgroupStatsFragment;
        }
    }

    private final void adjustRecyclerViewHeight() {
        if (getContext() == null) {
            return;
        }
        RecyclerView statsUsersRecyclerView = getBinding().statsUsersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(statsUsersRecyclerView, "statsUsersRecyclerView");
        RecyclerView.Adapter adapter = statsUsersRecyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int measuredHeight = 0;
        for (int i = 0; i < itemCount; i++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(statsUsersRecyclerView, adapter.getItemViewType(i));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i);
            viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(statsUsersRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
        }
        int itemCount2 = adapter.getItemCount();
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iDpToPx = measuredHeight + (itemCount2 * companion.dpToPx(8, contextRequireContext));
        ViewGroup.LayoutParams layoutParams = statsUsersRecyclerView.getLayoutParams();
        layoutParams.height = iDpToPx;
        statsUsersRecyclerView.setLayoutParams(layoutParams);
    }

    @JvmStatic
    public static final PlaygroupStatsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$3$0(MTUser mTUser, final PlaygroupStatsFragment playgroupStatsFragment) {
        ProfileBottomSheetFragment profileBottomSheetFragmentNewInstance$default = ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, new ProfileCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupStatsFragment$updateUI$1$3$1$bottomSheet$1
            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfileClose() {
                ProfileBottomSheetFragment profileBottomSheetFragment = this.this$0.currentProfileSheet;
                if (profileBottomSheetFragment != null) {
                    profileBottomSheetFragment.dismiss();
                }
                this.this$0.currentProfileSheet = null;
            }

            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfileLogout() {
            }

            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfilePictureUpdated() {
            }
        }, mTUser, true, null, 8, null);
        playgroupStatsFragment.currentProfileSheet = profileBottomSheetFragmentNewInstance$default;
        PlaygroupDetailsActivity playgroupDetailsActivity = playgroupStatsFragment.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        profileBottomSheetFragmentNewInstance$default.show(playgroupDetailsActivity.getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    public final FragmentPlaygroupStatsBinding getBinding() {
        FragmentPlaygroupStatsBinding fragmentPlaygroupStatsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentPlaygroupStatsBinding);
        return fragmentPlaygroupStatsBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
            this.parentActivity = (PlaygroupDetailsActivity) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object next;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("playgroupId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                List<MTPlaygroup> currentUserPlaygroups = preferencesManager.getCurrentUserPlaygroups();
                this.currentUser = currentUser;
                Iterator<T> it = currentUserPlaygroups.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTPlaygroup) next).getId() == i) {
                            break;
                        }
                    }
                }
                this.currentPlaygroup = (MTPlaygroup) next;
            }
            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            this.formatsForFilter = companion.getInstance(contextRequireContext2).getFormats();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPlaygroupStatsBinding.inflate(inflater, container, false);
        getBinding().profileLayout.setOutlineProvider(new CircularOutlineProvider());
        getBinding().profileLayout.setClipToOutline(true);
        getBinding().profileIcon.setOutlineProvider(new CircularOutlineProvider());
        getBinding().profileIcon.setClipToOutline(true);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup != null) {
            updateUI(mTPlaygroup);
        } else {
            updateStats();
        }
    }

    public final void updateFilter(FilterDefinition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.filterDefinition = filter;
        this.currentFormatId = filter.getFormatId();
        this.currentSubFormatId = filter.getSubformatId();
        this.currentSubFormatName = filter.getSubformatName();
        if (this.currentPlaygroup != null) {
            updateStats();
        }
    }

    public final void updateStats() {
        MTPlaygroup mTPlaygroup;
        MTUser mTUser = this.currentUser;
        if (mTUser == null || (mTPlaygroup = this.currentPlaygroup) == null) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        MTApiKt.getMtApi().getPlaygroupById(mTUser.getId(), mTPlaygroup.getId(), this.currentFormatId, this.currentSubFormatId, this.filterDefinition.getTagId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupStatsFragment$updateStats$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                this.this$0.getBinding().overlay.setVisibility(8);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                this.this$0.getBinding().overlay.setVisibility(8);
                if (response.isSuccessful()) {
                    MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                    MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                    if (playgroup != null) {
                        this.this$0.updateUI(playgroup);
                    }
                }
            }
        });
    }

    public final void updateUI(MTPlaygroup playgroup) {
        MTPlaygroupStats stats;
        Object next;
        String name;
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        if (playgroup.getStats() == null) {
            return;
        }
        this.currentPlaygroup = playgroup;
        if (getContext() == null || this._binding == null || (stats = playgroup.getStats()) == null) {
            return;
        }
        getBinding().gamesValueText.setText(String.valueOf(stats.getGames()));
        if (stats.getGames() == 1 || stats.getGames() == 0) {
            getBinding().gamesLabelText.setText(getResources().getString(R.string.games_singular));
        } else {
            getBinding().gamesLabelText.setText(getResources().getString(R.string.games_plural));
        }
        if (this.currentFormatId == null) {
            MTFormatStats mostPlayedFormat = stats.getMostPlayedFormat();
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
            getBinding().mostPlayedFormatGamesValueText.setText(String.valueOf(stats.getGames()));
            if (stats.getGames() == 1 || stats.getGames() == 0) {
                getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_singular));
            } else {
                getBinding().mostPlayedFormatGamesLabelText.setText(getResources().getString(R.string.games_plural));
            }
        }
        if (stats.getAverageGameDuration() == 0.0f) {
            getBinding().durationValueText.setText("--");
        } else {
            TextView textView = getBinding().durationValueText;
            ServerUtils companion = ServerUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            textView.setText(companion.formatDuration(contextRequireContext, (int) stats.getAverageGameDuration()));
        }
        final MTUser bestWinRateUser = stats.getBestWinRateUser();
        if (bestWinRateUser != null) {
            String picture = bestWinRateUser.getPicture();
            String str2 = picture;
            if (str2 == null || str2.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                getBinding().noPhotoIcon.setVisibility(0);
            } else {
                getBinding().profileIcon.setVisibility(0);
                getBinding().profileIcon.setAutoLoad(false);
                getBinding().profileIcon.reset();
                getBinding().profileIcon.loadImage(picture);
            }
            ConstraintLayout profileLayout = getBinding().profileLayout;
            Intrinsics.checkNotNullExpressionValue(profileLayout, "profileLayout");
            ViewExtensionsKt.setOnClickWithFade(profileLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupStatsFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupStatsFragment.updateUI$lambda$0$3$0(bestWinRateUser, this);
                }
            });
            getBinding().bestUserFirstnameValueText.setText(bestWinRateUser.getFirstname());
            getBinding().bestUserUsernameValueText.setText("@" + bestWinRateUser.getUsername());
            MTStats stats2 = bestWinRateUser.getStats();
            if (stats2 == null || stats2.getGames() == 0) {
                getBinding().bestUserWinrateValueText.setText("--");
                getBinding().bestUserWinrateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
            } else {
                try {
                    float f = Float.parseFloat(stats2.getRate());
                    if (Math.abs(f) <= Float.MAX_VALUE) {
                        getBinding().bestUserWinrateValueText.setText(MathKt.roundToInt(f) + "%");
                        TextView textView2 = getBinding().bestUserWinrateValueText;
                        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                        Context contextRequireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        textView2.setTextColor(companion2.getWinRateColor(contextRequireContext2, f, this.currentFormatId));
                    } else {
                        getBinding().bestUserWinrateValueText.setText("--");
                        getBinding().bestUserWinrateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                    }
                } catch (NumberFormatException unused) {
                    getBinding().bestUserWinrateValueText.setText("--");
                    getBinding().bestUserWinrateValueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                }
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setItemPrefetchEnabled(false);
        getBinding().statsUsersRecyclerView.setLayoutManager(linearLayoutManager);
        getBinding().statsUsersRecyclerView.setNestedScrollingEnabled(false);
        getBinding().statsUsersRecyclerView.setAdapter(new PlaygroupStatsUsersAdapter(playgroup.getUsers(), this.currentFormatId));
        adjustRecyclerViewHeight();
    }
}
