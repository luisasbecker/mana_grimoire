package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.SetsAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SetsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/SetsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "sets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "handler", "Lcom/studiolaganne/lengendarylens/SetClickHandler;", "language", "", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/SetClickHandler;Ljava/lang/String;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "TypeSetViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_SET = 1;
    private final SetClickHandler handler;
    private final String language;
    private final List<CardSet> sets;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SetsAdapter.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SetsAdapter$TypeSetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "setImage", "Landroid/widget/ImageView;", "nameLabel", "Landroid/widget/TextView;", "cardCountLabel", "releasedAtLabel", "loadSvgImage", "", "context", "Landroid/content/Context;", "url", "", "imageView", "bind", "position", "", "set", "Lcom/studiolaganne/lengendarylens/CardSet;", "handler", "Lcom/studiolaganne/lengendarylens/SetClickHandler;", "language", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypeSetViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView cardCountLabel;
        private final TextView nameLabel;
        private final TextView releasedAtLabel;
        private final ImageView setImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeSetViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.set_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.setImage = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.set_name_text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.nameLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.card_count_text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cardCountLabel = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.released_at_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.releasedAtLabel = (TextView) viewFindViewById4;
        }

        static final Unit bind$lambda$0(SetClickHandler setClickHandler, CardSet cardSet) {
            setClickHandler.setClicked(cardSet.getCode());
            return Unit.INSTANCE;
        }

        public final void bind(int position, final CardSet set, final SetClickHandler handler, String language) {
            Intrinsics.checkNotNullParameter(set, "set");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(language, "language");
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.SetsAdapter$TypeSetViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SetsAdapter.TypeSetViewHolder.bind$lambda$0(handler, set);
                }
            });
            this.setImage.setImageResource(R.drawable.cards_icon);
            int identifier = this.itemView.getResources().getIdentifier("set_" + set.getCode(), "drawable", this.setImage.getContext().getPackageName());
            if (identifier != 0) {
                this.setImage.setImageResource(identifier);
            } else {
                String icon_svg_uri = set.getIcon_svg_uri();
                Context context = this.setImage.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                loadSvgImage(context, icon_svg_uri, this.setImage);
            }
            this.nameLabel.setText(set.getName());
            String string = this.itemView.getResources().getString(R.string.cards_count);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strReplace$default = StringsKt.replace$default(string, "{1}", String.valueOf(set.getCard_count()), false, 4, (Object) null);
            if (set.getCard_count() == 1) {
                strReplace$default = this.itemView.getResources().getString(R.string.one_card_count);
                Intrinsics.checkNotNullExpressionValue(strReplace$default, "getString(...)");
            }
            this.cardCountLabel.setText(strReplace$default);
            this.releasedAtLabel.setText(set.getReleased_at());
        }

        public final void loadSvgImage(Context context, String url, ImageView imageView) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
        }
    }

    public SetsAdapter(List<CardSet> sets, SetClickHandler handler, String language) {
        Intrinsics.checkNotNullParameter(sets, "sets");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(language, "language");
        this.sets = sets;
        this.handler = handler;
        this.language = language;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sets.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof TypeSetViewHolder) {
            ((TypeSetViewHolder) holder).bind(position, this.sets.get(position), this.handler, this.language);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = layoutInflaterFrom.inflate(R.layout.set_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new TypeSetViewHolder(viewInflate);
    }
}
