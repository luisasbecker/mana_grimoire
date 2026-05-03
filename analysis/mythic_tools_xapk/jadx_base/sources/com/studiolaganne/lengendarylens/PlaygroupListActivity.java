package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaygroupListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupListActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/PlaygroupListClickListener;", "Lcom/studiolaganne/lengendarylens/CreatePlaygroupCallback;", "Lcom/studiolaganne/lengendarylens/AcceptPlaygroupCallback;", "<init>", "()V", "playgroups", "", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "onPlaygroupAccepted", "", "onPlaygroupDeclined", "onPlaygroupCreated", "onPlaygroupPending", "playgroup", "onPlaygroupSelected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupListActivity extends BaseActivity implements PlaygroupListClickListener, CreatePlaygroupCallback, AcceptPlaygroupCallback {
    public static final int $stable = 8;
    private List<MTPlaygroup> playgroups = CollectionsKt.emptyList();

    static final Unit onCreate$lambda$1(PlaygroupListActivity playgroupListActivity) {
        playgroupListActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$2(PlaygroupListActivity playgroupListActivity, MTUser mTUser) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_playgroup_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(playgroupListActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_playgroup_click", null);
        if (mTUser != null) {
            new CreatePlaygroupBottomSheetFragment(playgroupListActivity, mTUser).show(playgroupListActivity.getSupportFragmentManager(), CreatePlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgroup_list);
        PlaygroupListActivity playgroupListActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(playgroupListActivity);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            this.playgroups = preferencesManager.getCurrentUserPlaygroups();
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupListActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupListActivity.onCreate$lambda$1(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.plusIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupListActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupListActivity.onCreate$lambda$2(this.f$0, currentUser);
            }
        });
        View viewFindViewById3 = findViewById(R.id.playgroupsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        recyclerView.setLayoutManager(new LinearLayoutManager(playgroupListActivity));
        recyclerView.setAdapter(new PlaygroupListAdapter(this.playgroups, this));
    }

    @Override // com.studiolaganne.lengendarylens.AcceptPlaygroupCallback
    public void onPlaygroupAccepted(List<MTPlaygroup> playgroups) {
        if (playgroups != null) {
            new PreferencesManager(this).saveCurrentUserPlaygroups(playgroups);
            this.playgroups = playgroups;
            View viewFindViewById = findViewById(R.id.playgroupsRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((RecyclerView) viewFindViewById).setAdapter(new PlaygroupListAdapter(playgroups, this));
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreatePlaygroupCallback
    public void onPlaygroupCreated(List<MTPlaygroup> playgroups) {
        if (playgroups == null || playgroups.isEmpty()) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.saveCurrentUserPlaygroups(playgroups);
        preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
        this.playgroups = playgroups;
        View viewFindViewById = findViewById(R.id.playgroupsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((RecyclerView) viewFindViewById).setAdapter(new PlaygroupListAdapter(playgroups, this));
    }

    @Override // com.studiolaganne.lengendarylens.AcceptPlaygroupCallback
    public void onPlaygroupDeclined(List<MTPlaygroup> playgroups) {
        if (playgroups != null) {
            new PreferencesManager(this).saveCurrentUserPlaygroups(playgroups);
            this.playgroups = playgroups;
            View viewFindViewById = findViewById(R.id.playgroupsRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((RecyclerView) viewFindViewById).setAdapter(new PlaygroupListAdapter(playgroups, this));
        }
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupListClickListener
    public void onPlaygroupPending(MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser != null) {
            new AcceptPlaygroupBottomSheetFragment(this, currentUser, playgroup).show(getSupportFragmentManager(), AcceptPlaygroupBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupListClickListener
    public void onPlaygroupSelected(MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        Intent intent = new Intent(this, (Class<?>) PlaygroupDetailsActivity.class);
        intent.putExtra("playgroupId", playgroup.getId());
        startActivity(intent);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        List<MTPlaygroup> currentUserPlaygroups;
        super.onResume();
        PreferencesManager preferencesManager = new PreferencesManager(this);
        if (!preferencesManager.hasValidUser() || preferencesManager.getCurrentUser() == null || !preferencesManager.getBoolean(PreferencesManager.NEED_USER_RELOAD, false) || (currentUserPlaygroups = preferencesManager.getCurrentUserPlaygroups()) == null) {
            return;
        }
        this.playgroups = currentUserPlaygroups;
        View viewFindViewById = findViewById(R.id.playgroupsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((RecyclerView) viewFindViewById).setAdapter(new PlaygroupListAdapter(currentUserPlaygroups, this));
    }
}
