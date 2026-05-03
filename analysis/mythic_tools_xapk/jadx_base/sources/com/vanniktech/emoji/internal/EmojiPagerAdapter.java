package com.vanniktech.emoji.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vanniktech.emoji.EmojiCategory;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.recent.NoRecentEmoji;
import com.vanniktech.emoji.recent.RecentEmoji;
import com.vanniktech.emoji.variant.VariantEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiPagerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "delegate", "Lcom/vanniktech/emoji/internal/EmojiPagerDelegate;", "recentEmoji", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "variantManager", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "<init>", "(Lcom/vanniktech/emoji/internal/EmojiPagerDelegate;Lcom/vanniktech/emoji/recent/RecentEmoji;Lcom/vanniktech/emoji/variant/VariantEmoji;Lcom/vanniktech/emoji/EmojiTheming;)V", "recentEmojiGridView", "Lcom/vanniktech/emoji/internal/RecentEmojiGridView;", "hasRecentEmoji", "", "recentAdapterItemCount", "", "getCount", "instantiateItem", "", "pager", "Landroid/view/ViewGroup;", "position", "destroyItem", "", ViewHierarchyConstants.VIEW_KEY, "isViewFromObject", "Landroid/view/View;", "object", "numberOfRecentEmojis", "invalidateRecentEmojis", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiPagerAdapter extends PagerAdapter {
    private static final int RECENT_POSITION = 0;
    private final EmojiPagerDelegate delegate;
    private final RecentEmoji recentEmoji;
    private RecentEmojiGridView recentEmojiGridView;
    private final EmojiTheming theming;
    private final VariantEmoji variantManager;

    public EmojiPagerAdapter(EmojiPagerDelegate delegate, RecentEmoji recentEmoji, VariantEmoji variantManager, EmojiTheming theming) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(variantManager, "variantManager");
        Intrinsics.checkNotNullParameter(theming, "theming");
        this.delegate = delegate;
        this.recentEmoji = recentEmoji;
        this.variantManager = variantManager;
        this.theming = theming;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup pager, int position, Object view) {
        Intrinsics.checkNotNullParameter(pager, "pager");
        Intrinsics.checkNotNullParameter(view, "view");
        pager.removeView((View) view);
        if (hasRecentEmoji() && position == 0) {
            this.recentEmojiGridView = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return EmojiManager.INSTANCE.categories$emoji_release().length + recentAdapterItemCount();
    }

    public final boolean hasRecentEmoji() {
        return !(this.recentEmoji instanceof NoRecentEmoji);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup pager, int position) {
        CategoryGridView categoryGridViewInit;
        Intrinsics.checkNotNullParameter(pager, "pager");
        if (hasRecentEmoji() && position == 0) {
            Context context = pager.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            RecentEmojiGridView recentEmojiGridView = new RecentEmojiGridView(context, null, 2, null);
            EmojiPagerDelegate emojiPagerDelegate = this.delegate;
            RecentEmojiGridView recentEmojiGridViewInit = recentEmojiGridView.init(emojiPagerDelegate, emojiPagerDelegate, this.theming, this.recentEmoji);
            this.recentEmojiGridView = recentEmojiGridViewInit;
            categoryGridViewInit = recentEmojiGridViewInit;
        } else {
            EmojiCategory emojiCategory = EmojiManager.INSTANCE.categories$emoji_release()[position - recentAdapterItemCount()];
            Context context2 = pager.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            CategoryGridView categoryGridView = new CategoryGridView(context2, null, 2, null);
            EmojiPagerDelegate emojiPagerDelegate2 = this.delegate;
            categoryGridViewInit = categoryGridView.init(emojiPagerDelegate2, emojiPagerDelegate2, this.theming, emojiCategory, this.variantManager);
        }
        pager.addView(categoryGridViewInit);
        return categoryGridViewInit;
    }

    public final void invalidateRecentEmojis() {
        RecentEmojiGridView recentEmojiGridView = this.recentEmojiGridView;
        if (recentEmojiGridView != null) {
            recentEmojiGridView.invalidateEmojis();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return view == object;
    }

    public final int numberOfRecentEmojis() {
        return this.recentEmoji.getRecentEmojis().size();
    }

    public final int recentAdapterItemCount() {
        return hasRecentEmoji() ? 1 : 0;
    }
}
