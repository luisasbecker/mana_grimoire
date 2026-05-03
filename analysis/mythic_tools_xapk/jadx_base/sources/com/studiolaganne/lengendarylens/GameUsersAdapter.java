package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GameUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "users", "", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentUser", "clickListener", "Lcom/studiolaganne/lengendarylens/GameUserClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/GameUserClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_PLAYGROUP_USER = 1;
    private final GameUserClickListener clickListener;
    private final MTUser currentUser;
    private final List<MTUser> users;
    public static final int $stable = 8;

    public GameUsersAdapter(List<MTUser> users, MTUser currentUser, GameUserClickListener clickListener) {
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(currentUser, "currentUser");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.users = users;
        this.currentUser = currentUser;
        this.clickListener = clickListener;
    }

    static final void onBindViewHolder$lambda$0(MTUser mTUser, GameUserViewHolder gameUserViewHolder, GameUsersAdapter gameUsersAdapter, View view) {
        if (Intrinsics.areEqual(mTUser.getStatus(), "pending")) {
            gameUserViewHolder.getCheckBox().setChecked(false);
            Toast.makeText(gameUserViewHolder.getCheckBox().getContext(), gameUserViewHolder.itemView.getResources().getString(R.string.no_game_pending_user), 1).show();
            return;
        }
        List<MTUser> list = gameUsersAdapter.users;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MTUser) obj).getFcm()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() < 8 || !gameUserViewHolder.getCheckBox().isChecked()) {
            gameUsersAdapter.clickListener.onUserSelectionChanged(mTUser, gameUserViewHolder.getCheckBox().isChecked());
        } else {
            gameUserViewHolder.getCheckBox().setChecked(false);
            Toast.makeText(gameUserViewHolder.getCheckBox().getContext(), gameUserViewHolder.itemView.getResources().getString(R.string.max_players_selected), 1).show();
        }
    }

    static final void onBindViewHolder$lambda$1(MTUser mTUser, GameUserViewHolder gameUserViewHolder, GameUsersAdapter gameUsersAdapter, View view) {
        if (Intrinsics.areEqual(mTUser.getStatus(), "pending")) {
            gameUserViewHolder.getCheckBox().setChecked(false);
            Toast.makeText(gameUserViewHolder.getCheckBox().getContext(), gameUserViewHolder.itemView.getResources().getString(R.string.no_game_pending_user), 1).show();
            return;
        }
        List<MTUser> list = gameUsersAdapter.users;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MTUser) obj).getFcm()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() < 8 || gameUserViewHolder.getCheckBox().isChecked()) {
            gameUserViewHolder.getCheckBox().setChecked(!gameUserViewHolder.getCheckBox().isChecked());
            gameUsersAdapter.clickListener.onUserSelectionChanged(mTUser, gameUserViewHolder.getCheckBox().isChecked());
        } else {
            gameUserViewHolder.getCheckBox().setChecked(false);
            Toast.makeText(gameUserViewHolder.getCheckBox().getContext(), gameUserViewHolder.itemView.getResources().getString(R.string.max_players_selected), 1).show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.users.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GameUserViewHolder gameUserViewHolder = (GameUserViewHolder) holder;
        final MTUser mTUser = this.users.get(position);
        gameUserViewHolder.getUserFirstName().setText(mTUser.getFirstname());
        gameUserViewHolder.getUserName().setText("@" + mTUser.getUsername());
        gameUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        gameUserViewHolder.getProfileLayout().setClipToOutline(true);
        gameUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        gameUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            gameUserViewHolder.getProfileIcon().setVisibility(4);
            gameUserViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            gameUserViewHolder.getProfileIcon().setVisibility(0);
            gameUserViewHolder.getNoPhotoIcon().setVisibility(4);
            gameUserViewHolder.getProfileIcon().reset();
            gameUserViewHolder.getProfileIcon().setAutoLoad(false);
            gameUserViewHolder.getProfileIcon().loadImage(picture);
        }
        if (mTUser.getId() == this.currentUser.getId()) {
            gameUserViewHolder.getYouLabel().setVisibility(0);
        } else {
            gameUserViewHolder.getYouLabel().setVisibility(8);
        }
        gameUserViewHolder.getCheckBox().setChecked(mTUser.getFcm());
        gameUserViewHolder.getCheckBox().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameUsersAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameUsersAdapter.onBindViewHolder$lambda$0(mTUser, gameUserViewHolder, this, view);
            }
        });
        gameUserViewHolder.getRootLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameUsersAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameUsersAdapter.onBindViewHolder$lambda$1(mTUser, gameUserViewHolder, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_user_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new GameUserViewHolder(viewInflate, this.clickListener);
    }
}
