package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListColorPickerDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\nH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "colorsList", "", "", "colorPickerListener", "Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorPickerListener;", "setColorPickerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "ColorPickerListener", "ColorAdapter", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListColorPickerDialogFragment extends DialogFragment {
    private ColorPickerListener colorPickerListener;
    private final List<String> colorsList = CollectionsKt.listOf((Object[]) new String[]{"#1e40af", "#3b82f6", "#60a5fa", "#93c5fd", "#dbeafe", "#166534", "#22c55e", "#4ade80", "#86efac", "#dcfce7", "#a16207", "#eab308", "#facc15", "#fde047", "#fef9c3", "#7c3aed", "#a855f7", "#c084fc", "#d8b4fe", "#f3e8ff", "#dc2626", "#ef4444", "#f87171", "#fca5a5", "#fecaca", "#374151", "#6b7280", "#9ca3af", "#d1d5db", "#f3f4f6", "#ea580c", "#f97316", "#fb923c", "#fdba74", "#fed7aa", "#000000", "#ffffff"});

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ListColorPickerDialogFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0015B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u000e\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorAdapter$ColorViewHolder;", "Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment;", "colors", "", "", "onColorSelected", "Lkotlin/Function1;", "", "<init>", "(Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ColorViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
        private final List<String> colors;
        private final Function1<String, Unit> onColorSelected;
        final /* synthetic */ ListColorPickerDialogFragment this$0;

        /* JADX INFO: compiled from: ListColorPickerDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorAdapter;Landroid/view/View;)V", "colorCircle", "bind", "", "colorHex", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class ColorViewHolder extends RecyclerView.ViewHolder {
            private final View colorCircle;
            final /* synthetic */ ColorAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ColorViewHolder(ColorAdapter colorAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = colorAdapter;
                View viewFindViewById = itemView.findViewById(R.id.colorCircle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.colorCircle = viewFindViewById;
            }

            public final void bind(final String colorHex) {
                Intrinsics.checkNotNullParameter(colorHex, "colorHex");
                if (colorHex.length() == 0) {
                    return;
                }
                Drawable background = this.colorCircle.getBackground();
                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                ((GradientDrawable) background).setColor(Color.parseColor(colorHex));
                View view = this.itemView;
                final ColorAdapter colorAdapter = this.this$0;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ListColorPickerDialogFragment$ColorAdapter$ColorViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        colorAdapter.onColorSelected.invoke(colorHex);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ColorAdapter(ListColorPickerDialogFragment listColorPickerDialogFragment, List<String> colors, Function1<? super String, Unit> onColorSelected) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(onColorSelected, "onColorSelected");
            this.this$0 = listColorPickerDialogFragment;
            this.colors = colors;
            this.onColorSelected = onColorSelected;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.colors.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ColorViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.bind(this.colors.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ColorViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: compiled from: ListColorPickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$ColorPickerListener;", "", "onColorSelected", "", "colorHex", "", "onColorCleared", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ColorPickerListener {
        void onColorCleared();

        void onColorSelected(String colorHex);
    }

    /* JADX INFO: compiled from: ListColorPickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/ListColorPickerDialogFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ListColorPickerDialogFragment newInstance() {
            return new ListColorPickerDialogFragment();
        }
    }

    static final Unit onCreateView$lambda$0(ListColorPickerDialogFragment listColorPickerDialogFragment, String colorHex) {
        Intrinsics.checkNotNullParameter(colorHex, "colorHex");
        ColorPickerListener colorPickerListener = listColorPickerDialogFragment.colorPickerListener;
        if (colorPickerListener != null) {
            colorPickerListener.onColorSelected(colorHex);
        }
        listColorPickerDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(ListColorPickerDialogFragment listColorPickerDialogFragment) {
        ColorPickerListener colorPickerListener = listColorPickerDialogFragment.colorPickerListener;
        if (colorPickerListener != null) {
            colorPickerListener.onColorCleared();
        }
        listColorPickerDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.list_color_picker_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.colorRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        recyclerView.setAdapter(new ColorAdapter(this, this.colorsList, new Function1() { // from class: com.studiolaganne.lengendarylens.ListColorPickerDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListColorPickerDialogFragment.onCreateView$lambda$0(this.f$0, (String) obj);
            }
        }));
        View viewFindViewById = viewInflate.findViewById(R.id.noColorButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.ListColorPickerDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ListColorPickerDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.85d), -2);
    }

    public final void setColorPickerListener(ColorPickerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.colorPickerListener = listener;
    }
}
