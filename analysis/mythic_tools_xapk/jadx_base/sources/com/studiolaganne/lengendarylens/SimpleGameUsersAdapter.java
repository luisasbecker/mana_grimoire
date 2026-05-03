package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SimpleGameUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleGameUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initialUsers", "", "Lcom/studiolaganne/lengendarylens/MTUser;", Key.ROTATION, "", "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleGameUserClickListener;", "<init>", "(Ljava/util/List;ILcom/studiolaganne/lengendarylens/SimpleGameUserClickListener;)V", FirebaseAnalytics.Param.ITEMS, "", "updateUsers", "", "newUsers", "dpToPx", "context", "Landroid/content/Context;", "dp", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleGameUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_BACK_BUTTON = 2;
    private static final int VIEW_TYPE_PLAYGROUP_USER = 1;
    private final SimpleGameUserClickListener clickListener;
    private final List<MTUser> initialUsers;
    private List<MTUser> items;
    private final int rotation;
    public static final int $stable = 8;

    public SimpleGameUsersAdapter(List<MTUser> initialUsers, int i, SimpleGameUserClickListener clickListener) {
        Intrinsics.checkNotNullParameter(initialUsers, "initialUsers");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.initialUsers = initialUsers;
        this.rotation = i;
        this.clickListener = clickListener;
        this.items = CollectionsKt.toMutableList((Collection) initialUsers);
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static final Unit onBindViewHolder$lambda$0(SimpleGameBackViewHolder simpleGameBackViewHolder) {
        simpleGameBackViewHolder.getClickListener().onBackFromUsersSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(SimpleGameUsersAdapter simpleGameUsersAdapter, MTUser mTUser) {
        simpleGameUsersAdapter.clickListener.onUserSelected(mTUser);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            final SimpleGameBackViewHolder simpleGameBackViewHolder = (SimpleGameBackViewHolder) holder;
            simpleGameBackViewHolder.getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(simpleGameBackViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleGameUsersAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SimpleGameUsersAdapter.onBindViewHolder$lambda$0(simpleGameBackViewHolder);
                }
            });
            return;
        }
        SimpleGameUserViewHolder simpleGameUserViewHolder = (SimpleGameUserViewHolder) holder;
        final MTUser mTUser = this.items.get(position);
        simpleGameUserViewHolder.getRootLayout().setRotation(this.rotation);
        simpleGameUserViewHolder.getUserFirstName().setText(mTUser.getFirstname());
        simpleGameUserViewHolder.getUserName().setText("@" + mTUser.getUsername());
        simpleGameUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        simpleGameUserViewHolder.getProfileLayout().setClipToOutline(true);
        simpleGameUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        simpleGameUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            simpleGameUserViewHolder.getProfileIcon().setVisibility(4);
            simpleGameUserViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            simpleGameUserViewHolder.getProfileIcon().setVisibility(0);
            simpleGameUserViewHolder.getNoPhotoIcon().setVisibility(4);
            simpleGameUserViewHolder.getProfileIcon().reset();
            simpleGameUserViewHolder.getProfileIcon().setAutoLoad(false);
            simpleGameUserViewHolder.getProfileIcon().loadImage(picture);
        }
        ViewExtensionsKt.setOnClickWithFade(simpleGameUserViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleGameUsersAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SimpleGameUsersAdapter.onBindViewHolder$lambda$1(this.f$0, mTUser);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_game_user_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SimpleGameUserViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_item, parent, false);
        int i = this.rotation;
        if (i == 0 || i == 180) {
            ViewGroup.LayoutParams layoutParams = viewInflate2.getLayoutParams();
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            layoutParams.height = dpToPx(context, 130);
            viewInflate2.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = viewInflate2.getLayoutParams();
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            layoutParams2.width = dpToPx(context2, 130);
            viewInflate2.setLayoutParams(layoutParams2);
        }
        Intrinsics.checkNotNull(viewInflate2);
        return new SimpleGameBackViewHolder(viewInflate2, this.clickListener);
    }

    public final void updateUsers(List<MTUser> newUsers) {
        Intrinsics.checkNotNullParameter(newUsers, "newUsers");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new UserDiffCallback(CollectionsKt.toList(this.items), newUsers));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.items.clear();
        this.items.addAll(newUsers);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }
}
