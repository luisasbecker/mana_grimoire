package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CircleMemberAdapters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectablePlaygroupsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/SelectablePlaygroupViewHolder;", "allPlaygroups", "", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "<init>", "(Ljava/util/List;)V", "filteredPlaygroups", "selectedIds", "", "", "getSelectedIds", "()Ljava/util/Set;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "filter", SearchIntents.EXTRA_QUERY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectablePlaygroupsAdapter extends RecyclerView.Adapter<SelectablePlaygroupViewHolder> {
    public static final int $stable = 8;
    private final List<MTPlaygroup> allPlaygroups;
    private List<MTPlaygroup> filteredPlaygroups;
    private final Set<Integer> selectedIds;

    public SelectablePlaygroupsAdapter(List<MTPlaygroup> allPlaygroups) {
        Intrinsics.checkNotNullParameter(allPlaygroups, "allPlaygroups");
        this.allPlaygroups = allPlaygroups;
        this.filteredPlaygroups = allPlaygroups;
        this.selectedIds = new LinkedHashSet();
    }

    static final void onBindViewHolder$lambda$0(SelectablePlaygroupsAdapter selectablePlaygroupsAdapter, MTPlaygroup mTPlaygroup, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        Set<Integer> set = selectablePlaygroupsAdapter.selectedIds;
        Integer numValueOf = Integer.valueOf(mTPlaygroup.getId());
        if (z) {
            set.add(numValueOf);
        } else {
            set.remove(numValueOf);
        }
    }

    public final void filter(String query) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt.isBlank(query)) {
            arrayList = this.allPlaygroups;
        } else {
            String lowerCase = query.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<MTPlaygroup> list = this.allPlaygroups;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                MTPlaygroup mTPlaygroup = (MTPlaygroup) obj;
                String lowerCase2 = mTPlaygroup.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                String str = lowerCase;
                if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null)) {
                    String lowerCase3 = mTPlaygroup.getDescription().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str, false, 2, (Object) null)) {
                    }
                }
                arrayList2.add(obj);
            }
            arrayList = arrayList2;
        }
        this.filteredPlaygroups = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filteredPlaygroups.size();
    }

    public final List<Integer> getSelectedIds() {
        return CollectionsKt.toList(this.selectedIds);
    }

    /* JADX INFO: renamed from: getSelectedIds, reason: collision with other method in class */
    public final Set<Integer> m11241getSelectedIds() {
        return this.selectedIds;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final SelectablePlaygroupViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MTPlaygroup mTPlaygroup = this.filteredPlaygroups.get(position);
        holder.getPlaygroupName().setText(mTPlaygroup.getName());
        holder.getPlaygroupDescription().setText(mTPlaygroup.getDescription());
        holder.getPlaygroupDescription().setVisibility(!StringsKt.isBlank(mTPlaygroup.getDescription()) ? 0 : 8);
        holder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        holder.getProfileLayout().setClipToOutline(true);
        String picture = mTPlaygroup.getPicture();
        if (picture.length() <= 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
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
        holder.getCheckBox().setChecked(this.selectedIds.contains(Integer.valueOf(mTPlaygroup.getId())));
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.SelectablePlaygroupsAdapter$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SelectablePlaygroupsAdapter.onBindViewHolder$lambda$0(this.f$0, mTPlaygroup, compoundButton, z);
            }
        });
        holder.getRootLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SelectablePlaygroupsAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                holder.getCheckBox().setChecked(!r0.getCheckBox().isChecked());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectablePlaygroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_playgroup_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new SelectablePlaygroupViewHolder(viewInflate);
    }
}
