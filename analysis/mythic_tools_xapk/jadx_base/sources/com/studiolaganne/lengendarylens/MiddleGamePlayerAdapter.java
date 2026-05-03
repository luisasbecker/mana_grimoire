package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SmallUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/MiddleGamePlayerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "users", "", "Lcom/studiolaganne/lengendarylens/MTGamePlayer;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MiddleGamePlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_USER = 1;
    private final List<MTGamePlayer> users;
    public static final int $stable = 8;

    public MiddleGamePlayerAdapter(List<MTGamePlayer> users) {
        Intrinsics.checkNotNullParameter(users, "users");
        this.users = users;
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
        MiddleGamePlayerViewHolder middleGamePlayerViewHolder = (MiddleGamePlayerViewHolder) holder;
        MTGamePlayer mTGamePlayer = this.users.get(position);
        middleGamePlayerViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        middleGamePlayerViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTGamePlayer.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            middleGamePlayerViewHolder.getProfileIcon().setVisibility(4);
            middleGamePlayerViewHolder.getNoPhotoIcon().setVisibility(0);
            return;
        }
        middleGamePlayerViewHolder.getProfileIcon().setVisibility(0);
        middleGamePlayerViewHolder.getNoPhotoIcon().setVisibility(4);
        middleGamePlayerViewHolder.getProfileIcon().reset();
        middleGamePlayerViewHolder.getProfileIcon().setAutoLoad(false);
        middleGamePlayerViewHolder.getProfileIcon().loadImage(picture);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mid_user_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new MiddleGamePlayerViewHolder(viewInflate);
    }
}
