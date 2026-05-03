package com.vanniktech.emoji.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiVariantPopup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ6\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiVariantPopup;", "", "rootView", "Landroid/view/View;", "delegate", "Lcom/vanniktech/emoji/internal/EmojiVariantDelegate;", "<init>", "(Landroid/view/View;Lcom/vanniktech/emoji/internal/EmojiVariantDelegate;)V", "popupWindow", "Landroid/widget/PopupWindow;", "show", "", "clickedImage", "Lcom/vanniktech/emoji/internal/EmojiImageView;", "emoji", "Lcom/vanniktech/emoji/Emoji;", "variants", "", "dismiss", "initView", "context", "Landroid/content/Context;", "width", "", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiVariantPopup {
    private static final int MARGIN = 2;
    private final EmojiVariantDelegate delegate;
    private PopupWindow popupWindow;
    private final View rootView;

    public EmojiVariantPopup(View rootView, EmojiVariantDelegate emojiVariantDelegate) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        this.delegate = emojiVariantDelegate;
    }

    private final View initView(Context context, Emoji emoji, List<? extends Emoji> variants, int width, final EmojiImageView clickedImage) {
        View viewInflate = View.inflate(context, R.layout.emoji_popup_window_skin, null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.emojiPopupWindowSkinPopupContainer);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        for (final Emoji emoji2 : CollectionsKt.plus((Collection) CollectionsKt.listOf(emoji), (Iterable) variants)) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.emoji_adapter_item_emoji, (ViewGroup) linearLayout, false);
            Intrinsics.checkNotNull(viewInflate2, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) viewInflate2;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int iDpToPx$emoji_release = Utils.INSTANCE.dpToPx$emoji_release(context, 2.0f);
            marginLayoutParams.width = width;
            marginLayoutParams.setMargins(iDpToPx$emoji_release, iDpToPx$emoji_release, iDpToPx$emoji_release, iDpToPx$emoji_release);
            imageView.setImageDrawable(UtilsKt.emojiDrawableProvider(EmojiManager.INSTANCE).getDrawable(emoji2, context));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.vanniktech.emoji.internal.EmojiVariantPopup$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmojiVariantPopup.initView$lambda$0(this.f$0, clickedImage, emoji2, view);
                }
            });
            linearLayout.addView(imageView);
        }
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    static final void initView$lambda$0(EmojiVariantPopup emojiVariantPopup, EmojiImageView emojiImageView, Emoji emoji, View view) {
        EmojiVariantDelegate emojiVariantDelegate = emojiVariantPopup.delegate;
        if (emojiVariantDelegate != null) {
            emojiVariantDelegate.onEmojiClick(emojiImageView, emoji);
        }
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.popupWindow = null;
    }

    public final void show(EmojiImageView clickedImage, Emoji emoji, List<? extends Emoji> variants) {
        Intrinsics.checkNotNullParameter(clickedImage, "clickedImage");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(variants, "variants");
        dismiss();
        Context context = clickedImage.getContext();
        Intrinsics.checkNotNull(context);
        View viewInitView = initView(context, emoji, variants, clickedImage.getWidth(), clickedImage);
        viewInitView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Point pointLocationOnScreen$emoji_release = Utils.INSTANCE.locationOnScreen$emoji_release(clickedImage);
        Point point = new Point((pointLocationOnScreen$emoji_release.x - (viewInitView.getMeasuredWidth() / 2)) + (clickedImage.getWidth() / 2), pointLocationOnScreen$emoji_release.y - viewInitView.getMeasuredHeight());
        PopupWindow popupWindow = new PopupWindow(viewInitView, -2, -2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        popupWindow.showAtLocation(this.rootView, 0, point.x, point.y);
        Utils.INSTANCE.fixPopupLocation$emoji_release(popupWindow, point);
        this.popupWindow = popupWindow;
        clickedImage.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
