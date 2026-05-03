package com.vanniktech.emoji.internal;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.search.SearchEmojiResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiSearchDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J%\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/vanniktech/emoji/internal/EmojiViewHolder;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "emojiSearchDialogDelegate", "Lcom/vanniktech/emoji/internal/EmojiSearchDialogDelegate;", "<init>", "(Lcom/vanniktech/emoji/EmojiTheming;Lcom/vanniktech/emoji/internal/EmojiSearchDialogDelegate;)V", "marginStart", "", "Ljava/lang/Integer;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/vanniktech/emoji/search/SearchEmojiResult;", "getItemId", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "update", "new", "(Ljava/util/List;Ljava/lang/Integer;)V", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiAdapter extends RecyclerView.Adapter<EmojiViewHolder> {
    private final EmojiSearchDialogDelegate emojiSearchDialogDelegate;
    private List<SearchEmojiResult> items;
    private Integer marginStart;
    private final EmojiTheming theming;

    public EmojiAdapter(EmojiTheming theming, EmojiSearchDialogDelegate emojiSearchDialogDelegate) {
        Intrinsics.checkNotNullParameter(theming, "theming");
        this.theming = theming;
        this.emojiSearchDialogDelegate = emojiSearchDialogDelegate;
        this.items = CollectionsKt.emptyList();
        setHasStableIds(true);
    }

    static final void onBindViewHolder$lambda$1(EmojiAdapter emojiAdapter, SearchEmojiResult searchEmojiResult, View view) {
        EmojiSearchDialogDelegate emojiSearchDialogDelegate = emojiAdapter.emojiSearchDialogDelegate;
        if (emojiSearchDialogDelegate != null) {
            emojiSearchDialogDelegate.onSearchEmojiClick(searchEmojiResult.emoji);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).emoji.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmojiViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context context = holder.getTextView().getContext();
        final SearchEmojiResult searchEmojiResult = this.items.get(position);
        holder.getTextView().setTextColor(this.theming.textColor);
        holder.getTextView().setText(searchEmojiResult.emoji.getUnicode());
        ViewGroup.LayoutParams layoutParams = holder.getTextView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        Integer num = this.marginStart;
        layoutParams2.setMarginStart(num != null ? num.intValue() : context.getResources().getDimensionPixelSize(R.dimen.emoji_search_spacing));
        String str = searchEmojiResult.shortcode;
        TextView shortCodes = holder.getShortCodes();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.theming.textSecondaryColor), 0, str.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(this.theming.secondaryColor), searchEmojiResult.range.getFirst(), searchEmojiResult.range.getLast() + 1, 0);
        shortCodes.setText(spannableString);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.vanniktech.emoji.internal.EmojiAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiAdapter.onBindViewHolder$lambda$1(this.f$0, searchEmojiResult, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmojiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new EmojiViewHolder(parent);
    }

    public final void update(List<SearchEmojiResult> list, Integer marginStart) {
        Intrinsics.checkNotNullParameter(list, "new");
        ArrayList arrayList = new ArrayList(this.items);
        this.items = list;
        this.marginStart = marginStart;
        DiffUtil.calculateDiff(new DiffUtilHelper(arrayList, this.items, new Function1() { // from class: com.vanniktech.emoji.internal.EmojiAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(((SearchEmojiResult) obj).hashCode());
            }
        })).dispatchUpdatesTo(this);
    }
}
