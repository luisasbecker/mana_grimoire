package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CirclesListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CirclesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/CirclesListViewHolder;", "circles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", "clickListener", "Lcom/studiolaganne/lengendarylens/CirclesListClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/CirclesListClickListener;)V", "updateCircles", "", "newCircles", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CirclesListAdapter extends RecyclerView.Adapter<CirclesListViewHolder> {
    public static final int $stable = 8;
    private List<MTCircle> circles;
    private final CirclesListClickListener clickListener;

    public CirclesListAdapter(List<MTCircle> circles, CirclesListClickListener clickListener) {
        Intrinsics.checkNotNullParameter(circles, "circles");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.circles = circles;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(Context context, CirclesListViewHolder circlesListViewHolder, final CirclesListAdapter circlesListAdapter, final MTCircle mTCircle) {
        Intrinsics.checkNotNull(context);
        IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.delete_circle, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CirclesListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CirclesListAdapter.onBindViewHolder$lambda$0$0(this.f$0, mTCircle);
            }
        }, 24, (Object) null).show(circlesListViewHolder.getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(CirclesListAdapter circlesListAdapter, MTCircle mTCircle) {
        circlesListAdapter.clickListener.onCircleDelete(mTCircle);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(CirclesListAdapter circlesListAdapter, MTCircle mTCircle) {
        circlesListAdapter.clickListener.onCircleTap(mTCircle);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.circles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CirclesListViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MTCircle mTCircle = this.circles.get(position);
        final Context context = holder.itemView.getContext();
        TextView circleName = holder.getCircleName();
        String name = mTCircle.getName();
        if (name == null) {
            name = "";
        }
        circleName.setText(name);
        String description = mTCircle.getDescription();
        if (description == null || description.length() == 0) {
            holder.getCircleDescription().setVisibility(8);
        } else {
            holder.getCircleDescription().setVisibility(0);
            holder.getCircleDescription().setText(mTCircle.getDescription());
        }
        holder.getAutoBadge().setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(holder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.CirclesListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CirclesListAdapter.onBindViewHolder$lambda$0(context, holder, this, mTCircle);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(holder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.CirclesListAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CirclesListAdapter.onBindViewHolder$lambda$1(this.f$0, mTCircle);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CirclesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CirclesListViewHolder(viewInflate);
    }

    public final void updateCircles(List<MTCircle> newCircles) {
        Intrinsics.checkNotNullParameter(newCircles, "newCircles");
        this.circles = newCircles;
        notifyDataSetChanged();
    }
}
