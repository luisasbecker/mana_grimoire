package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: StandingsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/StandingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "standings", "", "Lcom/studiolaganne/lengendarylens/StandingsRow;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "TypeHeaderViewHolder", "TypeRowViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StandingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_ROW = 2;
    private final List<StandingsRow> standings;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: StandingsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/StandingsAdapter$TypeHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypeHeaderViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeHeaderViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void bind() {
        }
    }

    /* JADX INFO: compiled from: StandingsAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/StandingsAdapter$TypeRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "positionLabel", "Landroid/widget/TextView;", "nameLabel", "pointsLabel", "wldLabel", "omwLabel", "gwLabel", "ogwLabel", "bind", "", "position", "", "rowData", "Lcom/studiolaganne/lengendarylens/StandingsRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypeRowViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView gwLabel;
        private final TextView nameLabel;
        private final TextView ogwLabel;
        private final TextView omwLabel;
        private final TextView pointsLabel;
        private final TextView positionLabel;
        private final LinearLayout rootLayout;
        private final TextView wldLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeRowViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.root_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.rootLayout = (LinearLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.position_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.positionLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.player_name_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.nameLabel = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.player_points_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.pointsLabel = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.wld_value);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.wldLabel = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.omw_value);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.omwLabel = (TextView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.gw_value);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.gwLabel = (TextView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.ogw_value);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.ogwLabel = (TextView) viewFindViewById8;
        }

        public final void bind(int position, StandingsRow rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            if (position == 1) {
                this.rootLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.standings_winner));
            } else if (position != 2) {
                LinearLayout linearLayout = this.rootLayout;
                if (position != 3) {
                    linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.darker_blue_2));
                } else {
                    linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.darker_blue));
                }
            } else {
                this.rootLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.standings_second));
            }
            this.positionLabel.setText(String.valueOf(position));
            this.nameLabel.setText(rowData.getPlayer().getName());
            this.pointsLabel.setText(String.valueOf(rowData.getPoints()));
            this.wldLabel.setText(rowData.getWld());
            TextView textView = this.omwLabel;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(rowData.getOmw() * 100.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView.setText(str);
            TextView textView2 = this.gwLabel;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(rowData.getGwForOppoAvg() * 100.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            textView2.setText(str2);
            TextView textView3 = this.ogwLabel;
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String str3 = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(rowData.getOgw() * 100.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            textView3.setText(str3);
        }
    }

    public StandingsAdapter(List<StandingsRow> standings) {
        Intrinsics.checkNotNullParameter(standings, "standings");
        this.standings = standings;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.standings.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof TypeHeaderViewHolder) {
            ((TypeHeaderViewHolder) holder).bind();
        } else if (holder instanceof TypeRowViewHolder) {
            ((TypeRowViewHolder) holder).bind(position, this.standings.get(position - 1));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.standings_header, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new TypeHeaderViewHolder(viewInflate);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.standings_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        return new TypeRowViewHolder(viewInflate2);
    }
}
