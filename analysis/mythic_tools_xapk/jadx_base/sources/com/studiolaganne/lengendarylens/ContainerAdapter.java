package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0014\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "containers", "", "Lcom/studiolaganne/lengendarylens/ContainerItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/ContainerAdapter$ContainerSelectionListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/ContainerAdapter$ContainerSelectionListener;)V", "selectedPosition", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "updateData", "newContainers", "", "ContainerSelectionListener", "Companion", "ContainerViewHolder", "NewContainerViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContainerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_CONTAINER = 0;
    private static final int VIEW_TYPE_NEW_CONTAINER = 1;
    private List<ContainerItem> containers;
    private final ContainerSelectionListener listener;
    private int selectedPosition;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerAdapter$ContainerSelectionListener;", "", "onContainerSelected", "", "containerId", "", "onNewContainerSelected", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ContainerSelectionListener {
        void onContainerSelected(int containerId);

        void onNewContainerSelected();
    }

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerAdapter$ContainerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "bind", "", "container", "Lcom/studiolaganne/lengendarylens/ContainerItem;", "isSelected", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ContainerViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final RadioButton radioButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContainerViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.containerRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.radioButton = (RadioButton) viewFindViewById;
        }

        public final void bind(ContainerItem container, boolean isSelected) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.radioButton.setText(container.getName());
            this.radioButton.setChecked(isSelected);
        }

        public final RadioButton getRadioButton() {
            return this.radioButton;
        }
    }

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerAdapter$NewContainerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "bind", "", "isSelected", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NewContainerViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final RadioButton radioButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewContainerViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.newContainerRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.radioButton = (RadioButton) viewFindViewById;
        }

        public final void bind(boolean isSelected) {
            this.radioButton.setChecked(isSelected);
        }

        public final RadioButton getRadioButton() {
            return this.radioButton;
        }
    }

    public ContainerAdapter(List<ContainerItem> containers, ContainerSelectionListener listener) {
        Intrinsics.checkNotNullParameter(containers, "containers");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.containers = containers;
        this.listener = listener;
        this.selectedPosition = -1;
    }

    static final void onBindViewHolder$lambda$0(ContainerAdapter containerAdapter, RecyclerView.ViewHolder viewHolder, ContainerItem containerItem, View view) {
        int i = containerAdapter.selectedPosition;
        containerAdapter.selectedPosition = ((ContainerViewHolder) viewHolder).getBindingAdapterPosition();
        containerAdapter.notifyItemChanged(i);
        containerAdapter.notifyItemChanged(containerAdapter.selectedPosition);
        containerAdapter.listener.onContainerSelected(containerItem.getId());
    }

    static final void onBindViewHolder$lambda$1(ContainerAdapter containerAdapter, RecyclerView.ViewHolder viewHolder, View view) {
        int i = containerAdapter.selectedPosition;
        containerAdapter.selectedPosition = ((NewContainerViewHolder) viewHolder).getBindingAdapterPosition();
        containerAdapter.notifyItemChanged(i);
        containerAdapter.notifyItemChanged(containerAdapter.selectedPosition);
        containerAdapter.listener.onNewContainerSelected();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.containers.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position < this.containers.size() ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ContainerViewHolder) {
            final ContainerItem containerItem = this.containers.get(position);
            ContainerViewHolder containerViewHolder = (ContainerViewHolder) holder;
            containerViewHolder.bind(containerItem, position == this.selectedPosition);
            containerViewHolder.getRadioButton().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ContainerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContainerAdapter.onBindViewHolder$lambda$0(this.f$0, holder, containerItem, view);
                }
            });
            return;
        }
        if (holder instanceof NewContainerViewHolder) {
            NewContainerViewHolder newContainerViewHolder = (NewContainerViewHolder) holder;
            newContainerViewHolder.bind(position == this.selectedPosition);
            newContainerViewHolder.getRadioButton().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ContainerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContainerAdapter.onBindViewHolder$lambda$1(this.f$0, holder, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ContainerViewHolder(viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_container_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new NewContainerViewHolder(viewInflate2);
    }

    public final void updateData(List<ContainerItem> newContainers) {
        Intrinsics.checkNotNullParameter(newContainers, "newContainers");
        this.containers.clear();
        this.containers.addAll(newContainers);
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }
}
