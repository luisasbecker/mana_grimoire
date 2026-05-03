package com.vanniktech.emoji.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.search.SearchEmojiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiSearchPopup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiSearchPopup;", "", "rootView", "Landroid/view/View;", "editText", "Landroid/widget/EditText;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "<init>", "(Landroid/view/View;Landroid/widget/EditText;Lcom/vanniktech/emoji/EmojiTheming;)V", "popupWindow", "Landroid/widget/PopupWindow;", "show", "", "emojis", "", "Lcom/vanniktech/emoji/search/SearchEmojiResult;", "delegate", "Lcom/vanniktech/emoji/internal/EmojiSearchDelegate;", "show$emoji_release", "dismiss", "dismiss$emoji_release", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiSearchPopup {
    private final EditText editText;
    private PopupWindow popupWindow;
    private final View rootView;
    private final EmojiTheming theming;

    public EmojiSearchPopup(View rootView, EditText editText, EmojiTheming theming) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        this.rootView = rootView;
        this.editText = editText;
        this.theming = theming;
    }

    static final void show$lambda$0(EmojiSearchDelegate emojiSearchDelegate, EmojiSearchPopup emojiSearchPopup, Emoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (emojiSearchDelegate != null) {
            emojiSearchDelegate.onEmojiClicked(it);
        }
        emojiSearchPopup.dismiss$emoji_release();
    }

    public final void dismiss$emoji_release() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.popupWindow = null;
    }

    public final void show$emoji_release(List<SearchEmojiResult> emojis, final EmojiSearchDelegate delegate) {
        Intrinsics.checkNotNullParameter(emojis, "emojis");
        if (emojis.isEmpty()) {
            dismiss$emoji_release();
            return;
        }
        Context context = this.editText.getContext();
        View viewInflate = View.inflate(context, R.layout.emoji_popup_search, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.vanniktech.emoji.internal.MaxHeightSearchRecyclerView");
        MaxHeightSearchRecyclerView maxHeightSearchRecyclerView = (MaxHeightSearchRecyclerView) viewInflate;
        maxHeightSearchRecyclerView.tint(this.theming);
        EmojiAdapter emojiAdapter = new EmojiAdapter(this.theming, new EmojiSearchDialogDelegate() { // from class: com.vanniktech.emoji.internal.EmojiSearchPopup$$ExternalSyntheticLambda0
            @Override // com.vanniktech.emoji.internal.EmojiSearchDialogDelegate
            public final void onSearchEmojiClick(Emoji emoji) {
                EmojiSearchPopup.show$lambda$0(delegate, this, emoji);
            }
        });
        maxHeightSearchRecyclerView.setAdapter(emojiAdapter);
        Point pointLocationOnScreen$emoji_release = Utils.INSTANCE.locationOnScreen$emoji_release(this.editText);
        emojiAdapter.update(emojis, Integer.valueOf(pointLocationOnScreen$emoji_release.x));
        Resources resources = context.getResources();
        maxHeightSearchRecyclerView.measure(View.MeasureSpec.makeMeasureSpec(this.rootView.getWidth(), 1073741824), 0);
        int measuredHeight = maxHeightSearchRecyclerView.getMeasuredHeight();
        Point point = new Point((int) this.rootView.getX(), pointLocationOnScreen$emoji_release.y - measuredHeight);
        PopupWindow popupWindow = new PopupWindow(maxHeightSearchRecyclerView, -1, measuredHeight);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(resources, (Bitmap) null));
        popupWindow.showAtLocation(this.rootView, 0, point.x, point.y);
        Utils.INSTANCE.fixPopupLocation$emoji_release(popupWindow, point);
        this.popupWindow = popupWindow;
    }
}
