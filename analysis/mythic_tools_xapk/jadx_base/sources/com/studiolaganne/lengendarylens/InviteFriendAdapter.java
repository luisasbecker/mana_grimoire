package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\r\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/InviteFriendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/SelectableFriendViewHolder;", "allFriends", "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "onSelectionChanged", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "filteredFriends", "selectedFriendId", "Ljava/lang/Integer;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getSelectedFriendId", "()Ljava/lang/Integer;", "filter", SearchIntents.EXTRA_QUERY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InviteFriendAdapter extends RecyclerView.Adapter<SelectableFriendViewHolder> {
    public static final int $stable = 8;
    private final List<MTFriend> allFriends;
    private List<MTFriend> filteredFriends;
    private final Function1<Integer, Unit> onSelectionChanged;
    private Integer selectedFriendId;

    /* JADX WARN: Multi-variable type inference failed */
    public InviteFriendAdapter(List<MTFriend> allFriends, Function1<? super Integer, Unit> onSelectionChanged) {
        Intrinsics.checkNotNullParameter(allFriends, "allFriends");
        Intrinsics.checkNotNullParameter(onSelectionChanged, "onSelectionChanged");
        this.allFriends = allFriends;
        this.onSelectionChanged = onSelectionChanged;
        this.filteredFriends = allFriends;
    }

    static final void onBindViewHolder$lambda$0(InviteFriendAdapter inviteFriendAdapter, MTFriend mTFriend, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            inviteFriendAdapter.selectedFriendId = Integer.valueOf(mTFriend.getId());
            inviteFriendAdapter.onSelectionChanged.invoke(Integer.valueOf(mTFriend.getId()));
            inviteFriendAdapter.notifyDataSetChanged();
            return;
        }
        Integer num = inviteFriendAdapter.selectedFriendId;
        int id = mTFriend.getId();
        if (num != null && num.intValue() == id) {
            inviteFriendAdapter.selectedFriendId = null;
            inviteFriendAdapter.onSelectionChanged.invoke(null);
        }
    }

    static final void onBindViewHolder$lambda$1(InviteFriendAdapter inviteFriendAdapter, MTFriend mTFriend, View view) {
        Integer num = inviteFriendAdapter.selectedFriendId;
        int id = mTFriend.getId();
        if (num != null && num.intValue() == id) {
            inviteFriendAdapter.selectedFriendId = null;
            inviteFriendAdapter.onSelectionChanged.invoke(null);
        } else {
            inviteFriendAdapter.selectedFriendId = Integer.valueOf(mTFriend.getId());
            inviteFriendAdapter.onSelectionChanged.invoke(Integer.valueOf(mTFriend.getId()));
        }
        inviteFriendAdapter.notifyDataSetChanged();
    }

    public final void filter(String query) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt.isBlank(query)) {
            arrayList = this.allFriends;
        } else {
            String lowerCase = query.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<MTFriend> list = this.allFriends;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                MTFriend mTFriend = (MTFriend) obj;
                String lowerCase2 = mTFriend.getFirstname().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                String str = lowerCase;
                if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null)) {
                    String lowerCase3 = mTFriend.getUsername().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str, false, 2, (Object) null)) {
                    }
                }
                arrayList2.add(obj);
            }
            arrayList = arrayList2;
        }
        this.filteredFriends = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filteredFriends.size();
    }

    public final Integer getSelectedFriendId() {
        return this.selectedFriendId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelectableFriendViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MTFriend mTFriend = this.filteredFriends.get(position);
        holder.getUserFirstName().setText(mTFriend.getFirstname());
        holder.getUserName().setText("@" + mTFriend.getUsername());
        holder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        holder.getProfileLayout().setClipToOutline(true);
        String picture = mTFriend.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            holder.getProfileIcon().setVisibility(4);
            holder.getNoPhotoIcon().setVisibility(0);
        } else {
            holder.getProfileIcon().setVisibility(0);
            holder.getNoPhotoIcon().setVisibility(4);
            holder.getProfileIcon().reset();
            holder.getProfileIcon().setAutoLoad(false);
            holder.getProfileIcon().loadImage(picture);
        }
        holder.getCheckBox().setOnCheckedChangeListener(null);
        CheckBox checkBox = holder.getCheckBox();
        Integer num = this.selectedFriendId;
        checkBox.setChecked(num != null && num.intValue() == mTFriend.getId());
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.InviteFriendAdapter$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                InviteFriendAdapter.onBindViewHolder$lambda$0(this.f$0, mTFriend, compoundButton, z);
            }
        });
        holder.getRootLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.InviteFriendAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteFriendAdapter.onBindViewHolder$lambda$1(this.f$0, mTFriend, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectableFriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_friend_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new SelectableFriendViewHolder(viewInflate);
    }
}
