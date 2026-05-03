package com.vanniktech.emoji;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.internal.EmojiImageView;
import com.vanniktech.emoji.internal.EmojiPagerAdapter;
import com.vanniktech.emoji.internal.EmojiPagerDelegate;
import com.vanniktech.emoji.internal.EmojiSearchDialog;
import com.vanniktech.emoji.internal.EmojiSearchDialogDelegate;
import com.vanniktech.emoji.internal.EmojiVariantDelegate;
import com.vanniktech.emoji.internal.EmojiVariantPopup;
import com.vanniktech.emoji.internal.RepeatListener;
import com.vanniktech.emoji.internal.UtilsKt;
import com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.recent.RecentEmoji;
import com.vanniktech.emoji.recent.RecentEmojiManager;
import com.vanniktech.emoji.search.NoSearchEmoji;
import com.vanniktech.emoji.search.SearchEmoji;
import com.vanniktech.emoji.search.SearchEmojiManager;
import com.vanniktech.emoji.variant.VariantEmoji;
import com.vanniktech.emoji.variant.VariantEmojiManager;
import com.vanniktech.ui.AndroidViewKt;
import com.vanniktech.ui.Color;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: EmojiView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007Jb\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0015\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0017H\u0000¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002J*\u0010,\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u001f\u00102\u001a\u00020!2\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0006\u00108\u001a\u00020!J\b\u00109\u001a\u00020!H\u0002R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/vanniktech/emoji/EmojiView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emojiTabs", "", "Landroid/widget/ImageButton;", "[Landroid/widget/ImageButton;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "emojiPagerAdapter", "Lcom/vanniktech/emoji/internal/EmojiPagerAdapter;", "editText", "Landroid/widget/EditText;", "onEmojiClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "onEmojiBackspaceClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiBackspaceClickListener;", "emojiTabLastSelectedIndex", "", "variantPopup", "Lcom/vanniktech/emoji/internal/EmojiVariantPopup;", "recentEmoji", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "searchEmoji", "Lcom/vanniktech/emoji/search/SearchEmoji;", "variantEmoji", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "setUp", "", "rootView", "Landroid/view/View;", "pageTransformer", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "selectPage", FirebaseAnalytics.Param.INDEX, "selectPage$emoji_release", "handleEmojiTabs", "emojisPager", "Landroidx/viewpager/widget/ViewPager;", "inflateButton", "icon", "categoryName", "", "parent", "Landroid/view/ViewGroup;", "handleEmojiClick", "emoji", "Lcom/vanniktech/emoji/Emoji;", "addWhitespace", "", "handleEmojiClick$emoji_release", "tearDown", "dismissVariantPopup", "EmojiTabsClickListener", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiView extends LinearLayout {
    private static final long INITIAL_INTERVAL = TimeUnit.SECONDS.toMillis(1) / 2;
    private static final int NORMAL_INTERVAL = 50;
    private EditText editText;
    private EmojiPagerAdapter emojiPagerAdapter;
    private int emojiTabLastSelectedIndex;
    private ImageButton[] emojiTabs;
    private OnEmojiBackspaceClickListener onEmojiBackspaceClickListener;
    private OnEmojiClickListener onEmojiClickListener;
    private RecentEmoji recentEmoji;
    private SearchEmoji searchEmoji;
    private EmojiTheming theming;
    private VariantEmoji variantEmoji;
    private EmojiVariantPopup variantPopup;

    /* JADX INFO: compiled from: EmojiView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vanniktech/emoji/EmojiView$EmojiTabsClickListener;", "Landroid/view/View$OnClickListener;", "emojisPager", "Landroidx/viewpager/widget/ViewPager;", "position", "", "<init>", "(Landroidx/viewpager/widget/ViewPager;I)V", "onClick", "", "v", "Landroid/view/View;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EmojiTabsClickListener implements View.OnClickListener {
        private final ViewPager emojisPager;
        private final int position;

        public EmojiTabsClickListener(ViewPager emojisPager, int i) {
            Intrinsics.checkNotNullParameter(emojisPager, "emojisPager");
            this.emojisPager = emojisPager;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.emojisPager.setCurrentItem(this.position);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.emojiTabs = new ImageButton[0];
        this.emojiTabLastSelectedIndex = -1;
        LinearLayout.inflate(context, R.layout.emoji_view, this);
        setOrientation(1);
    }

    public /* synthetic */ EmojiView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void dismissVariantPopup() {
        EmojiVariantPopup emojiVariantPopup = this.variantPopup;
        if (emojiVariantPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variantPopup");
            emojiVariantPopup = null;
        }
        emojiVariantPopup.dismiss();
    }

    public static /* synthetic */ void handleEmojiClick$emoji_release$default(EmojiView emojiView, Emoji emoji, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        emojiView.handleEmojiClick$emoji_release(emoji, z);
    }

    private final void handleEmojiTabs(Context context, ViewPager emojisPager) {
        EmojiCategory[] emojiCategoryArrCategories$emoji_release = EmojiManager.INSTANCE.categories$emoji_release();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.emojiViewTab);
        EmojiPagerDelegate emojiPagerDelegate = new EmojiPagerDelegate() { // from class: com.vanniktech.emoji.EmojiView.handleEmojiTabs.1
            @Override // com.vanniktech.emoji.listeners.OnEmojiClickListener
            public void onEmojiClick(Emoji emoji) {
                Intrinsics.checkNotNullParameter(emoji, "emoji");
                EmojiView.handleEmojiClick$emoji_release$default(EmojiView.this, emoji, false, 2, null);
            }

            @Override // com.vanniktech.emoji.internal.OnEmojiLongClickListener
            public void onEmojiLongClick(EmojiImageView view, Emoji emoji, List<? extends Emoji> variants) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(emoji, "emoji");
                Intrinsics.checkNotNullParameter(variants, "variants");
                EmojiVariantPopup emojiVariantPopup = EmojiView.this.variantPopup;
                if (emojiVariantPopup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("variantPopup");
                    emojiVariantPopup = null;
                }
                emojiVariantPopup.show(view, emoji, variants);
            }
        };
        RecentEmoji recentEmoji = this.recentEmoji;
        if (recentEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentEmoji");
            recentEmoji = null;
        }
        VariantEmoji variantEmoji = this.variantEmoji;
        if (variantEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variantEmoji");
            variantEmoji = null;
        }
        EmojiTheming emojiTheming = this.theming;
        if (emojiTheming == null) {
            Intrinsics.throwUninitializedPropertyAccessException("theming");
            emojiTheming = null;
        }
        this.emojiPagerAdapter = new EmojiPagerAdapter(emojiPagerDelegate, recentEmoji, variantEmoji, emojiTheming);
        int i = (this.editText == null && this.onEmojiBackspaceClickListener == null) ? 0 : 1;
        SearchEmoji searchEmoji = this.searchEmoji;
        if (searchEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEmoji");
            searchEmoji = null;
        }
        boolean z = searchEmoji instanceof NoSearchEmoji;
        int i2 = (!z ? 1 : 0) + i;
        EmojiPagerAdapter emojiPagerAdapter = this.emojiPagerAdapter;
        if (emojiPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            emojiPagerAdapter = null;
        }
        int iRecentAdapterItemCount = emojiPagerAdapter.recentAdapterItemCount();
        this.emojiTabs = new ImageButton[emojiCategoryArrCategories$emoji_release.length + iRecentAdapterItemCount + i2];
        EmojiPagerAdapter emojiPagerAdapter2 = this.emojiPagerAdapter;
        if (emojiPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            emojiPagerAdapter2 = null;
        }
        if (emojiPagerAdapter2.hasRecentEmoji()) {
            ImageButton[] imageButtonArr = this.emojiTabs;
            int i3 = R.drawable.emoji_recent;
            String string = context.getString(R.string.emoji_category_recent);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Intrinsics.checkNotNull(linearLayout);
            imageButtonArr[0] = inflateButton(context, i3, string, linearLayout);
        }
        Integer numValueOf = z ? null : Integer.valueOf(this.emojiTabs.length - (i != 0 ? 2 : 1));
        Integer numValueOf2 = i != 0 ? Integer.valueOf(this.emojiTabs.length - 1) : null;
        String string2 = context.getString(R.string.emoji_language_code);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        EmojiAndroidProvider emojiAndroidProviderEmojiDrawableProvider = UtilsKt.emojiDrawableProvider(EmojiManager.INSTANCE);
        int length = emojiCategoryArrCategories$emoji_release.length;
        int i4 = 0;
        while (i4 < length) {
            EmojiCategory emojiCategory = emojiCategoryArrCategories$emoji_release[i4];
            String str = emojiCategory.getCategoryNames().get(string2);
            if (str == null) {
                str = "";
            }
            int icon = emojiAndroidProviderEmojiDrawableProvider.getIcon(emojiCategory);
            Intrinsics.checkNotNull(linearLayout);
            this.emojiTabs[i4 + iRecentAdapterItemCount] = inflateButton(context, icon, str, linearLayout);
            i4++;
            emojiCategoryArrCategories$emoji_release = emojiCategoryArrCategories$emoji_release;
        }
        if (numValueOf != null) {
            ImageButton[] imageButtonArr2 = this.emojiTabs;
            int iIntValue = numValueOf.intValue();
            int i5 = R.drawable.emoji_search;
            String string3 = context.getString(R.string.emoji_search);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            Intrinsics.checkNotNull(linearLayout);
            imageButtonArr2[iIntValue] = inflateButton(context, i5, string3, linearLayout);
            ImageButton imageButton = this.emojiTabs[numValueOf.intValue()];
            Intrinsics.checkNotNull(imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.vanniktech.emoji.EmojiView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmojiView.handleEmojiTabs$lambda$0(this.f$0, view);
                }
            });
        }
        if (numValueOf2 != null) {
            ImageButton[] imageButtonArr3 = this.emojiTabs;
            int iIntValue2 = numValueOf2.intValue();
            int i6 = R.drawable.emoji_backspace;
            String string4 = context.getString(R.string.emoji_backspace);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            Intrinsics.checkNotNull(linearLayout);
            imageButtonArr3[iIntValue2] = inflateButton(context, i6, string4, linearLayout);
            ImageButton imageButton2 = this.emojiTabs[numValueOf2.intValue()];
            if (imageButton2 != null) {
                imageButton2.setOnTouchListener(new RepeatListener(INITIAL_INTERVAL, 50L, new View.OnClickListener() { // from class: com.vanniktech.emoji.EmojiView$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EmojiView.handleEmojiTabs$lambda$1(this.f$0, view);
                    }
                }));
            }
        }
        int length2 = this.emojiTabs.length - i2;
        for (int i7 = 0; i7 < length2; i7++) {
            ImageButton imageButton3 = this.emojiTabs[i7];
            if (imageButton3 != null) {
                imageButton3.setOnClickListener(new EmojiTabsClickListener(emojisPager, i7));
            }
        }
    }

    static final void handleEmojiTabs$lambda$0(final EmojiView emojiView, View view) {
        EditText editText = emojiView.editText;
        if (editText != null) {
            UtilsKt.hideKeyboardAndFocus(editText);
        }
        EmojiSearchDialog.Companion companion = EmojiSearchDialog.INSTANCE;
        Context context = emojiView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        EmojiSearchDialogDelegate emojiSearchDialogDelegate = new EmojiSearchDialogDelegate() { // from class: com.vanniktech.emoji.EmojiView$$ExternalSyntheticLambda2
            @Override // com.vanniktech.emoji.internal.EmojiSearchDialogDelegate
            public final void onSearchEmojiClick(Emoji emoji) {
                EmojiView.handleEmojiTabs$lambda$0$0(this.f$0, emoji);
            }
        };
        SearchEmoji searchEmoji = emojiView.searchEmoji;
        EmojiTheming emojiTheming = null;
        if (searchEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEmoji");
            searchEmoji = null;
        }
        EmojiTheming emojiTheming2 = emojiView.theming;
        if (emojiTheming2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("theming");
        } else {
            emojiTheming = emojiTheming2;
        }
        companion.show(context, emojiSearchDialogDelegate, searchEmoji, emojiTheming);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEmojiTabs$lambda$0$0(EmojiView emojiView, Emoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        emojiView.handleEmojiClick$emoji_release(it, true);
        EditText editText = emojiView.editText;
        if (editText != null) {
            UtilsKt.showKeyboardAndFocus(editText);
        }
        EmojiPagerAdapter emojiPagerAdapter = emojiView.emojiPagerAdapter;
        if (emojiPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            emojiPagerAdapter = null;
        }
        emojiPagerAdapter.invalidateRecentEmojis();
    }

    static final void handleEmojiTabs$lambda$1(EmojiView emojiView, View view) {
        EditText editText = emojiView.editText;
        if (editText != null) {
            EmojiEditTexts.backspace(editText);
        }
        OnEmojiBackspaceClickListener onEmojiBackspaceClickListener = emojiView.onEmojiBackspaceClickListener;
        if (onEmojiBackspaceClickListener != null) {
            onEmojiBackspaceClickListener.onEmojiBackspaceClick();
        }
    }

    private final ImageButton inflateButton(Context context, int icon, String categoryName, ViewGroup parent) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.emoji_view_category, parent, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) viewInflate;
        imageButton.setImageDrawable(AppCompatResources.getDrawable(context, icon));
        EmojiTheming emojiTheming = this.theming;
        if (emojiTheming == null) {
            Intrinsics.throwUninitializedPropertyAccessException("theming");
            emojiTheming = null;
        }
        imageButton.setColorFilter(emojiTheming.primaryColor, PorterDuff.Mode.SRC_IN);
        imageButton.setContentDescription(categoryName);
        parent.addView(imageButton);
        return imageButton;
    }

    public static /* synthetic */ void setUp$default(EmojiView emojiView, View view, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming emojiTheming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer, int i, Object obj) {
        EmojiTheming emojiThemingFrom;
        RecentEmoji recentEmojiManager;
        VariantEmoji variantEmojiManager;
        ViewPager.PageTransformer pageTransformer2;
        EmojiView emojiView2;
        View view2;
        OnEmojiClickListener onEmojiClickListener2;
        OnEmojiBackspaceClickListener onEmojiBackspaceClickListener2;
        EditText editText2;
        if ((i & 16) != 0) {
            EmojiTheming.Companion companion = EmojiTheming.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            emojiThemingFrom = companion.from(context);
        } else {
            emojiThemingFrom = emojiTheming;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        if ((i & 32) != 0) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            recentEmojiManager = new RecentEmojiManager(context2, 0, 2, defaultConstructorMarker);
        } else {
            recentEmojiManager = recentEmoji;
        }
        SearchEmoji searchEmojiManager = (i & 64) != 0 ? new SearchEmojiManager() : searchEmoji;
        if ((i & 128) != 0) {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            variantEmojiManager = new VariantEmojiManager(context3);
        } else {
            variantEmojiManager = variantEmoji;
        }
        if ((i & 256) != 0) {
            pageTransformer2 = null;
            view2 = view;
            onEmojiClickListener2 = onEmojiClickListener;
            onEmojiBackspaceClickListener2 = onEmojiBackspaceClickListener;
            editText2 = editText;
            emojiView2 = emojiView;
        } else {
            pageTransformer2 = pageTransformer;
            emojiView2 = emojiView;
            view2 = view;
            onEmojiClickListener2 = onEmojiClickListener;
            onEmojiBackspaceClickListener2 = onEmojiBackspaceClickListener;
            editText2 = editText;
        }
        emojiView2.setUp(view2, onEmojiClickListener2, onEmojiBackspaceClickListener2, editText2, emojiThemingFrom, recentEmojiManager, searchEmojiManager, variantEmojiManager, pageTransformer2);
    }

    static final void setUp$lambda$0(EmojiView emojiView, EmojiImageView emojiImageView, Emoji emoji) {
        Intrinsics.checkNotNullParameter(emojiImageView, "emojiImageView");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        handleEmojiClick$emoji_release$default(emojiView, emoji, false, 2, null);
        emojiImageView.updateEmoji(emoji);
        emojiView.dismissVariantPopup();
    }

    static final void tearDown$lambda$0(EmojiView emojiView) {
        RecentEmoji recentEmoji = emojiView.recentEmoji;
        VariantEmoji variantEmoji = null;
        if (recentEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentEmoji");
            recentEmoji = null;
        }
        recentEmoji.persist();
        VariantEmoji variantEmoji2 = emojiView.variantEmoji;
        if (variantEmoji2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variantEmoji");
        } else {
            variantEmoji = variantEmoji2;
        }
        variantEmoji.persist();
    }

    public final void handleEmojiClick$emoji_release(Emoji emoji, boolean addWhitespace) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        EditText editText = this.editText;
        if (editText != null) {
            EmojiEditTexts.input(editText, emoji, addWhitespace);
        }
        RecentEmoji recentEmoji = this.recentEmoji;
        VariantEmoji variantEmoji = null;
        if (recentEmoji == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentEmoji");
            recentEmoji = null;
        }
        recentEmoji.addEmoji(emoji);
        VariantEmoji variantEmoji2 = this.variantEmoji;
        if (variantEmoji2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variantEmoji");
        } else {
            variantEmoji = variantEmoji2;
        }
        variantEmoji.addVariant(emoji);
        OnEmojiClickListener onEmojiClickListener = this.onEmojiClickListener;
        if (onEmojiClickListener != null) {
            onEmojiClickListener.onEmojiClick(emoji);
        }
    }

    public final void selectPage$emoji_release(int index) {
        if (this.emojiTabLastSelectedIndex != index) {
            EmojiTheming emojiTheming = null;
            if (index == 0) {
                EmojiPagerAdapter emojiPagerAdapter = this.emojiPagerAdapter;
                if (emojiPagerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
                    emojiPagerAdapter = null;
                }
                emojiPagerAdapter.invalidateRecentEmojis();
            }
            int i = this.emojiTabLastSelectedIndex;
            if (i >= 0) {
                ImageButton[] imageButtonArr = this.emojiTabs;
                if (i < imageButtonArr.length) {
                    ImageButton imageButton = imageButtonArr[i];
                    Intrinsics.checkNotNull(imageButton);
                    imageButton.setSelected(false);
                    ImageButton imageButton2 = this.emojiTabs[this.emojiTabLastSelectedIndex];
                    Intrinsics.checkNotNull(imageButton2);
                    EmojiTheming emojiTheming2 = this.theming;
                    if (emojiTheming2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("theming");
                        emojiTheming2 = null;
                    }
                    imageButton2.setColorFilter(emojiTheming2.primaryColor, PorterDuff.Mode.SRC_IN);
                }
            }
            ImageButton imageButton3 = this.emojiTabs[index];
            if (imageButton3 != null) {
                imageButton3.setSelected(true);
            }
            ImageButton imageButton4 = this.emojiTabs[index];
            if (imageButton4 != null) {
                EmojiTheming emojiTheming3 = this.theming;
                if (emojiTheming3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("theming");
                } else {
                    emojiTheming = emojiTheming3;
                }
                imageButton4.setColorFilter(emojiTheming.secondaryColor, PorterDuff.Mode.SRC_IN);
            }
            this.emojiTabLastSelectedIndex = index;
        }
    }

    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        setUp$default(this, rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, null, null, null, null, null, 496, null);
    }

    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming theming) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(theming, "theming");
        setUp$default(this, rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, theming, null, null, null, null, 480, null);
    }

    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        setUp$default(this, rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, theming, recentEmoji, null, null, null, Videoio.CAP_PROP_XI_WB_KR, null);
    }

    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        setUp$default(this, rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, theming, recentEmoji, searchEmoji, null, null, 384, null);
    }

    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
        setUp$default(this, rootView, onEmojiClickListener, onEmojiBackspaceClickListener, editText, theming, recentEmoji, searchEmoji, variantEmoji, null, 256, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setUp(View rootView, OnEmojiClickListener onEmojiClickListener, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, EditText editText, EmojiTheming theming, RecentEmoji recentEmoji, SearchEmoji searchEmoji, VariantEmoji variantEmoji, ViewPager.PageTransformer pageTransformer) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
        Context context = getContext();
        this.editText = editText;
        this.theming = theming;
        this.recentEmoji = recentEmoji;
        this.searchEmoji = searchEmoji;
        this.variantEmoji = variantEmoji;
        this.onEmojiBackspaceClickListener = onEmojiBackspaceClickListener;
        this.onEmojiClickListener = onEmojiClickListener;
        this.variantPopup = new EmojiVariantPopup(rootView, new EmojiVariantDelegate() { // from class: com.vanniktech.emoji.EmojiView$$ExternalSyntheticLambda0
            @Override // com.vanniktech.emoji.internal.EmojiVariantDelegate
            public final void onEmojiClick(EmojiImageView emojiImageView, Emoji emoji) {
                EmojiView.setUp$lambda$0(this.f$0, emojiImageView, emoji);
            }
        });
        setBackgroundColor(theming.backgroundColor);
        View viewFindViewById = findViewById(R.id.emojiViewPager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewPager viewPager = (ViewPager) viewFindViewById;
        AndroidViewKt.m11354themeViewPagerxAbW3D8(viewPager, Color.m11372constructorimpl(theming.secondaryColor));
        findViewById(R.id.emojiViewDivider).setBackgroundColor(theming.dividerColor);
        int i = 1;
        if (pageTransformer != null) {
            viewPager.setPageTransformer(true, pageTransformer);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.vanniktech.emoji.EmojiView.setUp.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int position) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                EmojiView.this.selectPage$emoji_release(position);
            }
        });
        Intrinsics.checkNotNull(context);
        handleEmojiTabs(context, viewPager);
        EmojiPagerAdapter emojiPagerAdapter = this.emojiPagerAdapter;
        EmojiPagerAdapter emojiPagerAdapter2 = null;
        if (emojiPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            emojiPagerAdapter = null;
        }
        viewPager.setAdapter(emojiPagerAdapter);
        EmojiPagerAdapter emojiPagerAdapter3 = this.emojiPagerAdapter;
        if (emojiPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            emojiPagerAdapter3 = null;
        }
        if (emojiPagerAdapter3.hasRecentEmoji()) {
            EmojiPagerAdapter emojiPagerAdapter4 = this.emojiPagerAdapter;
            if (emojiPagerAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emojiPagerAdapter");
            } else {
                emojiPagerAdapter2 = emojiPagerAdapter4;
            }
            if (emojiPagerAdapter2.numberOfRecentEmojis() > 0) {
            }
        } else {
            i = 0;
        }
        viewPager.setCurrentItem(i);
        selectPage$emoji_release(i);
    }

    public final void tearDown() {
        dismissVariantPopup();
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.vanniktech.emoji.EmojiView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EmojiView.tearDown$lambda$0(this.f$0);
            }
        });
    }
}
