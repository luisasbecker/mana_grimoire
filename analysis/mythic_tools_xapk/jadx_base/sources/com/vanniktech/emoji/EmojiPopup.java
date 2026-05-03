package com.vanniktech.emoji;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.vanniktech.emoji.internal.EmojiResultReceiver;
import com.vanniktech.emoji.internal.Utils;
import com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.listeners.OnEmojiPopupDismissListener;
import com.vanniktech.emoji.listeners.OnEmojiPopupShownListener;
import com.vanniktech.emoji.listeners.OnSoftKeyboardCloseListener;
import com.vanniktech.emoji.listeners.OnSoftKeyboardOpenListener;
import com.vanniktech.emoji.recent.RecentEmoji;
import com.vanniktech.emoji.search.SearchEmoji;
import com.vanniktech.emoji.variant.VariantEmoji;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiPopup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 L2\u00020\u0001:\u0003JKLB©\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\r\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u00020:H\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0011H\u0000¢\u0006\u0002\b@J\r\u0010A\u001a\u00020:H\u0000¢\u0006\u0002\bBJ\u0006\u0010C\u001a\u00020:J\u0006\u0010D\u001a\u00020:J\b\u0010E\u001a\u00020:H\u0002J\u0006\u0010H\u001a\u00020:J\b\u0010I\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u0002008F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006M"}, d2 = {"Lcom/vanniktech/emoji/EmojiPopup;", "", "rootView", "Landroid/view/View;", "editText", "Landroid/widget/EditText;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "recentEmoji", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "searchEmoji", "Lcom/vanniktech/emoji/search/SearchEmoji;", "variantEmoji", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "pageTransformer", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "keyboardAnimationStyle", "", "popupWindowHeight", "onEmojiPopupShownListener", "Lcom/vanniktech/emoji/listeners/OnEmojiPopupShownListener;", "onSoftKeyboardCloseListener", "Lcom/vanniktech/emoji/listeners/OnSoftKeyboardCloseListener;", "onSoftKeyboardOpenListener", "Lcom/vanniktech/emoji/listeners/OnSoftKeyboardOpenListener;", "onEmojiBackspaceClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiBackspaceClickListener;", "onEmojiClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "onEmojiPopupDismissListener", "Lcom/vanniktech/emoji/listeners/OnEmojiPopupDismissListener;", "<init>", "(Landroid/view/View;Landroid/widget/EditText;Lcom/vanniktech/emoji/EmojiTheming;Lcom/vanniktech/emoji/recent/RecentEmoji;Lcom/vanniktech/emoji/search/SearchEmoji;Lcom/vanniktech/emoji/variant/VariantEmoji;Landroidx/viewpager/widget/ViewPager$PageTransformer;IILcom/vanniktech/emoji/listeners/OnEmojiPopupShownListener;Lcom/vanniktech/emoji/listeners/OnSoftKeyboardCloseListener;Lcom/vanniktech/emoji/listeners/OnSoftKeyboardOpenListener;Lcom/vanniktech/emoji/listeners/OnEmojiBackspaceClickListener;Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;Lcom/vanniktech/emoji/listeners/OnEmojiPopupDismissListener;)V", "getTheming$emoji_release", "()Lcom/vanniktech/emoji/EmojiTheming;", "getSearchEmoji$emoji_release", "()Lcom/vanniktech/emoji/search/SearchEmoji;", "getRootView$emoji_release", "()Landroid/view/View;", "context", "Landroid/app/Activity;", "getContext$emoji_release", "()Landroid/app/Activity;", "emojiView", "Lcom/vanniktech/emoji/EmojiView;", "popupWindow", "Landroid/widget/PopupWindow;", "isPendingOpen", "", "isKeyboardOpen", "globalKeyboardHeight", "delay", "originalImeOptions", "emojiResultReceiver", "Lcom/vanniktech/emoji/internal/EmojiResultReceiver;", "onDismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "start", "", "start$emoji_release", "stop", "stop$emoji_release", "updateKeyboardStateOpened", "keyboardHeight", "updateKeyboardStateOpened$emoji_release", "updateKeyboardStateClosed", "updateKeyboardStateClosed$emoji_release", "toggle", "show", "showAtBottomPending", "isShowing", "()Z", "dismiss", "showAtBottom", "EmojiPopUpOnAttachStateChangeListener", "EmojiPopUpOnApplyWindowInsetsListener", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiPopup {
    private static final int APPLY_WINDOW_INSETS_DURATION = 250;
    private static final Companion Companion = new Companion(null);
    private static final int MIN_KEYBOARD_HEIGHT = 50;
    private final Activity context;
    private int delay;
    private final EditText editText;
    private final EmojiResultReceiver emojiResultReceiver;
    private final EmojiView emojiView;
    private int globalKeyboardHeight;
    private boolean isKeyboardOpen;
    private boolean isPendingOpen;
    private final PopupWindow.OnDismissListener onDismissListener;
    private final OnEmojiPopupDismissListener onEmojiPopupDismissListener;
    private final OnEmojiPopupShownListener onEmojiPopupShownListener;
    private final OnSoftKeyboardCloseListener onSoftKeyboardCloseListener;
    private final OnSoftKeyboardOpenListener onSoftKeyboardOpenListener;
    private int originalImeOptions;
    private final PopupWindow popupWindow;
    private int popupWindowHeight;
    private final View rootView;
    private final SearchEmoji searchEmoji;
    private final EmojiTheming theming;

    /* JADX INFO: compiled from: EmojiPopup.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vanniktech/emoji/EmojiPopup$Companion;", "", "<init>", "()V", "MIN_KEYBOARD_HEIGHT", "", "APPLY_WINDOW_INSETS_DURATION", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EmojiPopup.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/vanniktech/emoji/EmojiPopup$EmojiPopUpOnApplyWindowInsetsListener;", "Landroid/view/View$OnApplyWindowInsetsListener;", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "<init>", "(Lcom/vanniktech/emoji/EmojiPopup;)V", "Ljava/lang/ref/WeakReference;", "previousOffset", "", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "v", "Landroid/view/View;", "insets", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EmojiPopUpOnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
        private final WeakReference<EmojiPopup> emojiPopup;
        private int previousOffset;

        public EmojiPopUpOnApplyWindowInsetsListener(EmojiPopup emojiPopup) {
            Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
            this.emojiPopup = new WeakReference<>(emojiPopup);
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            EmojiPopup emojiPopup = this.emojiPopup.get();
            if (emojiPopup == null) {
                return insets;
            }
            int systemWindowInsetBottom = Build.VERSION.SDK_INT >= 30 ? insets.getInsets(WindowInsets.Type.ime()).bottom : insets.getSystemWindowInsetBottom();
            int stableInsetBottom = (Build.VERSION.SDK_INT >= 30 ? insets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars()).bottom : insets.getStableInsetBottom()) + (Build.VERSION.SDK_INT >= 30 ? insets.getInsets(WindowInsets.Type.systemGestures()).bottom : 0);
            if (systemWindowInsetBottom >= stableInsetBottom) {
                systemWindowInsetBottom -= stableInsetBottom;
            }
            if (systemWindowInsetBottom != this.previousOffset || systemWindowInsetBottom == 0) {
                this.previousOffset = systemWindowInsetBottom;
                if (systemWindowInsetBottom > Utils.INSTANCE.dpToPx$emoji_release(emojiPopup.getContext(), 50.0f)) {
                    emojiPopup.updateKeyboardStateOpened$emoji_release(systemWindowInsetBottom);
                } else {
                    emojiPopup.updateKeyboardStateClosed$emoji_release();
                }
            }
            WindowInsets windowInsetsOnApplyWindowInsets = emojiPopup.getContext().getWindow().getDecorView().onApplyWindowInsets(insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX INFO: compiled from: EmojiPopup.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vanniktech/emoji/EmojiPopup$EmojiPopUpOnAttachStateChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "emojiPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "<init>", "(Lcom/vanniktech/emoji/EmojiPopup;)V", "Ljava/lang/ref/WeakReference;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EmojiPopUpOnAttachStateChangeListener implements View.OnAttachStateChangeListener {
        private final WeakReference<EmojiPopup> emojiPopup;

        public EmojiPopUpOnAttachStateChangeListener(EmojiPopup emojiPopup) {
            Intrinsics.checkNotNullParameter(emojiPopup, "emojiPopup");
            this.emojiPopup = new WeakReference<>(emojiPopup);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            EmojiPopup emojiPopup = this.emojiPopup.get();
            if (emojiPopup != null) {
                emojiPopup.start$emoji_release();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            EmojiPopup emojiPopup = this.emojiPopup.get();
            if (emojiPopup != null) {
                emojiPopup.stop$emoji_release();
            }
            this.emojiPopup.clear();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText) {
        this(rootView, editText, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 32764, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming) {
        this(rootView, editText, theming, null, null, null, null, 0, 0, null, null, null, null, null, null, 32760, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji) {
        this(rootView, editText, theming, recentEmoji, null, null, null, 0, 0, null, null, null, null, null, null, 32752, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, null, null, 0, 0, null, null, null, null, null, null, 32736, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, null, 0, 0, null, null, null, null, null, null, 32704, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, 0, 0, null, null, null, null, null, null, 32640, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, 0, null, null, null, null, null, null, 32512, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, null, null, null, null, null, null, 32256, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, onEmojiPopupShownListener, null, null, null, null, null, 31744, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener, OnSoftKeyboardCloseListener onSoftKeyboardCloseListener) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, onEmojiPopupShownListener, onSoftKeyboardCloseListener, null, null, null, null, 30720, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener, OnSoftKeyboardCloseListener onSoftKeyboardCloseListener, OnSoftKeyboardOpenListener onSoftKeyboardOpenListener) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, onEmojiPopupShownListener, onSoftKeyboardCloseListener, onSoftKeyboardOpenListener, null, null, null, 28672, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener, OnSoftKeyboardCloseListener onSoftKeyboardCloseListener, OnSoftKeyboardOpenListener onSoftKeyboardOpenListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, onEmojiPopupShownListener, onSoftKeyboardCloseListener, onSoftKeyboardOpenListener, onEmojiBackspaceClickListener, null, null, 24576, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener, OnSoftKeyboardCloseListener onSoftKeyboardCloseListener, OnSoftKeyboardOpenListener onSoftKeyboardOpenListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, OnEmojiClickListener onEmojiClickListener) {
        this(rootView, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer, i, i2, onEmojiPopupShownListener, onSoftKeyboardCloseListener, onSoftKeyboardOpenListener, onEmojiBackspaceClickListener, onEmojiClickListener, null, 16384, null);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiPopup(View rootView, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, int i2, OnEmojiPopupShownListener onEmojiPopupShownListener, OnSoftKeyboardCloseListener onSoftKeyboardCloseListener, OnSoftKeyboardOpenListener onSoftKeyboardOpenListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, OnEmojiClickListener onEmojiClickListener, OnEmojiPopupDismissListener onEmojiPopupDismissListener) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
        this.editText = editText;
        this.theming = theming;
        this.searchEmoji = searchEmoji;
        this.popupWindowHeight = i2;
        this.onEmojiPopupShownListener = onEmojiPopupShownListener;
        this.onSoftKeyboardCloseListener = onSoftKeyboardCloseListener;
        this.onSoftKeyboardOpenListener = onSoftKeyboardOpenListener;
        this.onEmojiPopupDismissListener = onEmojiPopupDismissListener;
        View rootView2 = rootView.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView2, "getRootView(...)");
        this.rootView = rootView2;
        Utils utils = Utils.INSTANCE;
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Activity activityAsActivity$emoji_release = utils.asActivity$emoji_release(context);
        this.context = activityAsActivity$emoji_release;
        EmojiView emojiView = new EmojiView(activityAsActivity$emoji_release, null, 2, 0 == true ? 1 : 0);
        this.emojiView = emojiView;
        PopupWindow popupWindow = new PopupWindow(activityAsActivity$emoji_release);
        this.popupWindow = popupWindow;
        this.originalImeOptions = -1;
        this.emojiResultReceiver = new EmojiResultReceiver(new Handler(Looper.getMainLooper()));
        PopupWindow.OnDismissListener onDismissListener = new PopupWindow.OnDismissListener() { // from class: com.vanniktech.emoji.EmojiPopup$$ExternalSyntheticLambda0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                EmojiPopup.onDismissListener$lambda$0(this.f$0);
            }
        };
        this.onDismissListener = onDismissListener;
        EmojiManager.INSTANCE.verifyInstalled$emoji_release();
        emojiView.setUp(rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, theming, recentEmoji, searchEmoji, variantEmoji, pageTransformer);
        popupWindow.setContentView(emojiView);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(activityAsActivity$emoji_release.getResources(), (Bitmap) null));
        popupWindow.setOnDismissListener(onDismissListener);
        if (i != 0) {
            popupWindow.setAnimationStyle(i);
        }
        if (rootView.getParent() != null) {
            start$emoji_release();
        }
        rootView.addOnAttachStateChangeListener(new EmojiPopUpOnAttachStateChangeListener(this));
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ EmojiPopup(android.view.View r20, android.widget.EditText r21, com.vanniktech.emoji.EmojiTheming r22, com.vanniktech.emoji.recent.RecentEmoji r23, com.vanniktech.emoji.search.SearchEmoji r24, com.vanniktech.emoji.variant.VariantEmoji r25, androidx.viewpager.widget.ViewPager.PageTransformer r26, int r27, int r28, com.vanniktech.emoji.listeners.OnEmojiPopupShownListener r29, com.vanniktech.emoji.listeners.OnSoftKeyboardCloseListener r30, com.vanniktech.emoji.listeners.OnSoftKeyboardOpenListener r31, com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener r32, com.vanniktech.emoji.listeners.OnEmojiClickListener r33, com.vanniktech.emoji.listeners.OnEmojiPopupDismissListener r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 4
            java.lang.String r2 = "getContext(...)"
            if (r1 == 0) goto L17
            com.vanniktech.emoji.EmojiTheming$Companion r1 = com.vanniktech.emoji.EmojiTheming.INSTANCE
            android.content.Context r3 = r20.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            com.vanniktech.emoji.EmojiTheming r1 = r1.from(r3)
            r6 = r1
            goto L19
        L17:
            r6 = r22
        L19:
            r1 = r0 & 8
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L30
            com.vanniktech.emoji.recent.RecentEmojiManager r1 = new com.vanniktech.emoji.recent.RecentEmojiManager
            android.content.Context r5 = r20.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r7 = 2
            r1.<init>(r5, r3, r7, r4)
            com.vanniktech.emoji.recent.RecentEmoji r1 = (com.vanniktech.emoji.recent.RecentEmoji) r1
            r7 = r1
            goto L32
        L30:
            r7 = r23
        L32:
            r1 = r0 & 16
            if (r1 == 0) goto L3f
            com.vanniktech.emoji.search.SearchEmojiManager r1 = new com.vanniktech.emoji.search.SearchEmojiManager
            r1.<init>()
            com.vanniktech.emoji.search.SearchEmoji r1 = (com.vanniktech.emoji.search.SearchEmoji) r1
            r8 = r1
            goto L41
        L3f:
            r8 = r24
        L41:
            r1 = r0 & 32
            if (r1 == 0) goto L55
            com.vanniktech.emoji.variant.VariantEmojiManager r1 = new com.vanniktech.emoji.variant.VariantEmojiManager
            android.content.Context r5 = r20.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r1.<init>(r5)
            com.vanniktech.emoji.variant.VariantEmoji r1 = (com.vanniktech.emoji.variant.VariantEmoji) r1
            r9 = r1
            goto L57
        L55:
            r9 = r25
        L57:
            r1 = r0 & 64
            if (r1 == 0) goto L5d
            r10 = r4
            goto L5f
        L5d:
            r10 = r26
        L5f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L65
            r11 = r3
            goto L67
        L65:
            r11 = r27
        L67:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L6d
            r12 = r3
            goto L6f
        L6d:
            r12 = r28
        L6f:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L75
            r13 = r4
            goto L77
        L75:
            r13 = r29
        L77:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L7d
            r14 = r4
            goto L7f
        L7d:
            r14 = r30
        L7f:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L85
            r15 = r4
            goto L87
        L85:
            r15 = r31
        L87:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L8e
            r16 = r4
            goto L90
        L8e:
            r16 = r32
        L90:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L97
            r17 = r4
            goto L99
        L97:
            r17 = r33
        L99:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto La6
            r18 = r4
            r3 = r19
            r5 = r21
            r4 = r20
            goto Lae
        La6:
            r18 = r34
            r3 = r19
            r4 = r20
            r5 = r21
        Lae:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vanniktech.emoji.EmojiPopup.<init>(android.view.View, android.widget.EditText, com.vanniktech.emoji.EmojiTheming, com.vanniktech.emoji.recent.RecentEmoji, com.vanniktech.emoji.search.SearchEmoji, com.vanniktech.emoji.variant.VariantEmoji, androidx.viewpager.widget.ViewPager$PageTransformer, int, int, com.vanniktech.emoji.listeners.OnEmojiPopupShownListener, com.vanniktech.emoji.listeners.OnSoftKeyboardCloseListener, com.vanniktech.emoji.listeners.OnSoftKeyboardOpenListener, com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener, com.vanniktech.emoji.listeners.OnEmojiClickListener, com.vanniktech.emoji.listeners.OnEmojiPopupDismissListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    static final void onDismissListener$lambda$0(EmojiPopup emojiPopup) {
        OnEmojiPopupDismissListener onEmojiPopupDismissListener = emojiPopup.onEmojiPopupDismissListener;
        if (onEmojiPopupDismissListener != null) {
            onEmojiPopupDismissListener.onEmojiPopupDismiss();
        }
    }

    private final void showAtBottom() {
        this.isPendingOpen = false;
        this.editText.postDelayed(new Runnable() { // from class: com.vanniktech.emoji.EmojiPopup$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EmojiPopup emojiPopup = this.f$0;
                emojiPopup.popupWindow.showAtLocation(emojiPopup.rootView, 0, 0, Utils.INSTANCE.getProperHeight$emoji_release(emojiPopup.context) + emojiPopup.popupWindowHeight);
            }
        }, this.delay);
        OnEmojiPopupShownListener onEmojiPopupShownListener = this.onEmojiPopupShownListener;
        if (onEmojiPopupShownListener != null) {
            onEmojiPopupShownListener.onEmojiPopupShown();
        }
    }

    private final void showAtBottomPending() {
        this.isPendingOpen = true;
        Object systemService = this.context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (Utils.INSTANCE.shouldOverrideRegularCondition$emoji_release(this.context, this.editText)) {
            EditText editText = this.editText;
            editText.setImeOptions(editText.getImeOptions() | 268435456);
            inputMethodManager.restartInput(this.editText);
        }
        this.emojiResultReceiver.setReceiver(new EmojiResultReceiver.Receiver() { // from class: com.vanniktech.emoji.EmojiPopup$$ExternalSyntheticLambda2
            @Override // com.vanniktech.emoji.internal.EmojiResultReceiver.Receiver
            public final void onReceiveResult(int i, Bundle bundle) {
                EmojiPopup.showAtBottomPending$lambda$0(this.f$0, i, bundle);
            }
        });
        inputMethodManager.showSoftInput(this.editText, 0, this.emojiResultReceiver);
    }

    static final void showAtBottomPending$lambda$0(EmojiPopup emojiPopup, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            emojiPopup.showAtBottom();
        }
    }

    public final void dismiss() {
        this.popupWindow.dismiss();
        this.emojiView.tearDown();
        this.emojiResultReceiver.setReceiver(null);
        int i = this.originalImeOptions;
        if (i != -1) {
            this.editText.setImeOptions(i);
            Object systemService = this.context.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).restartInput(this.editText);
            AutofillManager autofillManager = (AutofillManager) this.context.getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.cancel();
            }
        }
    }

    /* JADX INFO: renamed from: getContext$emoji_release, reason: from getter */
    public final Activity getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: getRootView$emoji_release, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: renamed from: getSearchEmoji$emoji_release, reason: from getter */
    public final SearchEmoji getSearchEmoji() {
        return this.searchEmoji;
    }

    /* JADX INFO: renamed from: getTheming$emoji_release, reason: from getter */
    public final EmojiTheming getTheming() {
        return this.theming;
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    public final void show() {
        if (Utils.INSTANCE.shouldOverrideRegularCondition$emoji_release(this.context, this.editText) && this.originalImeOptions == -1) {
            this.originalImeOptions = this.editText.getImeOptions();
        }
        this.editText.setFocusableInTouchMode(true);
        this.editText.requestFocus();
        showAtBottomPending();
    }

    public final void start$emoji_release() {
        this.context.getWindow().getDecorView().setOnApplyWindowInsetsListener(new EmojiPopUpOnApplyWindowInsetsListener(this));
    }

    public final void stop$emoji_release() {
        dismiss();
        this.context.getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
        this.popupWindow.setOnDismissListener(null);
    }

    public final void toggle() {
        if (this.popupWindow.isShowing()) {
            dismiss();
            return;
        }
        start$emoji_release();
        ViewCompat.requestApplyInsets(this.context.getWindow().getDecorView());
        show();
    }

    public final void updateKeyboardStateClosed$emoji_release() {
        this.isKeyboardOpen = false;
        OnSoftKeyboardCloseListener onSoftKeyboardCloseListener = this.onSoftKeyboardCloseListener;
        if (onSoftKeyboardCloseListener != null) {
            onSoftKeyboardCloseListener.onKeyboardClose();
        }
        if (isShowing()) {
            dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateKeyboardStateOpened$emoji_release(int keyboardHeight) {
        int i;
        if (this.popupWindowHeight > 0) {
            int height = this.popupWindow.getHeight();
            int i2 = this.popupWindowHeight;
            if (height != i2) {
                this.popupWindow.setHeight(i2);
            } else if (this.popupWindowHeight == 0 && this.popupWindow.getHeight() != keyboardHeight) {
                this.popupWindow.setHeight(keyboardHeight);
            }
        }
        if (this.globalKeyboardHeight != keyboardHeight) {
            this.globalKeyboardHeight = keyboardHeight;
            i = 250;
        } else {
            i = 0;
        }
        this.delay = i;
        int properWidth$emoji_release = Utils.INSTANCE.getProperWidth$emoji_release(this.context);
        if (this.popupWindow.getWidth() != properWidth$emoji_release) {
            this.popupWindow.setWidth(properWidth$emoji_release);
        }
        if (!this.isKeyboardOpen) {
            this.isKeyboardOpen = true;
            OnSoftKeyboardOpenListener onSoftKeyboardOpenListener = this.onSoftKeyboardOpenListener;
            if (onSoftKeyboardOpenListener != null) {
                onSoftKeyboardOpenListener.onKeyboardOpen(keyboardHeight);
            }
        }
        if (this.isPendingOpen) {
            showAtBottom();
        }
    }
}
