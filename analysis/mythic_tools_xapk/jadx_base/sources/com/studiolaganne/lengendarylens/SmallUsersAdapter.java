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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/SmallUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "users", "", "Lcom/studiolaganne/lengendarylens/MTUser;", "showMore", "", "addedUsers", "", "<init>", "(Ljava/util/List;ZI)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmallUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_MORE = 2;
    private static final int VIEW_TYPE_USER = 1;
    private final int addedUsers;
    private final boolean showMore;
    private final List<MTUser> users;
    public static final int $stable = 8;

    public SmallUsersAdapter(List<MTUser> users, boolean z, int i) {
        Intrinsics.checkNotNullParameter(users, "users");
        this.users = users;
        this.showMore = z;
        this.addedUsers = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.users.size() + (this.showMore ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (this.showMore && position == this.users.size()) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.showMore && position == this.users.size()) {
            ((SmallUserShowMoreViewHolder) holder).getLabel().setText("+" + this.addedUsers);
            return;
        }
        SmallUserViewHolder smallUserViewHolder = (SmallUserViewHolder) holder;
        MTUser mTUser = this.users.get(position);
        smallUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        smallUserViewHolder.getProfileLayout().setClipToOutline(true);
        smallUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        smallUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            smallUserViewHolder.getProfileIcon().setVisibility(4);
            smallUserViewHolder.getNoPhotoIcon().setVisibility(0);
            return;
        }
        smallUserViewHolder.getProfileIcon().setVisibility(0);
        smallUserViewHolder.getNoPhotoIcon().setVisibility(4);
        smallUserViewHolder.getProfileIcon().reset();
        smallUserViewHolder.getProfileIcon().setAutoLoad(false);
        smallUserViewHolder.getProfileIcon().loadImage(picture);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_user_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SmallUserViewHolder(viewInflate);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_user_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new SmallUserShowMoreViewHolder(viewInflate2);
    }
}
