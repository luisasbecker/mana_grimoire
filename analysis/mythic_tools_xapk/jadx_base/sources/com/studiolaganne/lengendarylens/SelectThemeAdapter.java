package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.SelectThemeAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SelectThemeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectThemeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "currentCode", "", "clickListener", "Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int EXACT_SIZE_THRESHOLD = 4;
    private static final float MAX_VISIBLE_ROWS = 4.5f;
    private static final int VIEW_TYPE_DEFAULT = 0;
    private static final int VIEW_TYPE_THEME = 1;
    private final SelectThemeListClickListener clickListener;
    private final String currentCode;
    private final List<MTTheme> themes;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SelectThemeAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectThemeAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_THEME", "MAX_VISIBLE_ROWS", "", "EXACT_SIZE_THRESHOLD", "constrainRecyclerViewHeight", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/studiolaganne/lengendarylens/SelectThemeAdapter;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static final void constrainRecyclerViewHeight$lambda$0(SelectThemeAdapter selectThemeAdapter, RecyclerView recyclerView) {
            int itemCount = selectThemeAdapter.getItemCount();
            if (itemCount == 0) {
                return;
            }
            DisplayMetrics displayMetrics = recyclerView.getContext().getResources().getDisplayMetrics();
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
            int i = 0;
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            RecyclerView recyclerView2 = recyclerView;
            View viewInflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.select_theme_default_item, (ViewGroup) recyclerView2, false);
            viewInflate.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredHeight = viewInflate.getMeasuredHeight();
            View viewInflate2 = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.select_theme_item, (ViewGroup) recyclerView2, false);
            viewInflate2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredHeight2 = viewInflate2.getMeasuredHeight();
            if (itemCount > 4) {
                i = (int) (measuredHeight + (measuredHeight2 * 3.5f));
            } else if (itemCount != 0) {
                i = measuredHeight + ((itemCount - 1) * measuredHeight2);
            }
            int iMin = Math.min(i, (displayMetrics.heightPixels * 3) / 4);
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            layoutParams.height = iMin;
            recyclerView.setLayoutParams(layoutParams);
        }

        public final void constrainRecyclerViewHeight(final RecyclerView recyclerView, final SelectThemeAdapter adapter) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SelectThemeAdapter$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SelectThemeAdapter.Companion.constrainRecyclerViewHeight$lambda$0(adapter, recyclerView);
                }
            });
        }
    }

    public SelectThemeAdapter(List<MTTheme> themes, String currentCode, SelectThemeListClickListener clickListener) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(currentCode, "currentCode");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.themes = themes;
        this.currentCode = currentCode;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(SelectThemeAdapter selectThemeAdapter) {
        selectThemeAdapter.clickListener.onDefaultTapped();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(SelectThemeAdapter selectThemeAdapter, MTTheme mTTheme) {
        selectThemeAdapter.clickListener.onThemeTapped(mTTheme);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$0(SelectThemeViewHolder selectThemeViewHolder, String str) {
        selectThemeViewHolder.getThemeImage().loadImage(str);
    }

    static final Unit onBindViewHolder$lambda$5(boolean z, SelectThemeAdapter selectThemeAdapter, MTTheme mTTheme) {
        if (z) {
            selectThemeAdapter.clickListener.onThemeTapped(mTTheme);
            return Unit.INSTANCE;
        }
        selectThemeAdapter.clickListener.onBuyTapped(mTTheme);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.themes.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            SelectThemeDefaultViewHolder selectThemeDefaultViewHolder = (SelectThemeDefaultViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(selectThemeDefaultViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SelectThemeAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SelectThemeAdapter.onBindViewHolder$lambda$0(this.f$0);
                }
            });
            if (this.currentCode.length() == 0 || Intrinsics.areEqual(this.currentCode, "default")) {
                selectThemeDefaultViewHolder.getCheckmark().setVisibility(0);
                selectThemeDefaultViewHolder.getInnerLayout().setBackgroundResource(R.drawable.selected_theme);
                return;
            } else {
                selectThemeDefaultViewHolder.getCheckmark().setVisibility(8);
                selectThemeDefaultViewHolder.getInnerLayout().setBackgroundResource(R.drawable.unselected_theme);
                return;
            }
        }
        final SelectThemeViewHolder selectThemeViewHolder = (SelectThemeViewHolder) holder;
        final MTTheme mTTheme = this.themes.get(position - 1);
        ViewExtensionsKt.setOnClickWithFade(selectThemeViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SelectThemeAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SelectThemeAdapter.onBindViewHolder$lambda$1(this.f$0, mTTheme);
            }
        });
        selectThemeViewHolder.getThemeTitle().setText(mTTheme.getTitle());
        if (Intrinsics.areEqual(mTTheme.getGoogleproductid(), this.currentCode)) {
            selectThemeViewHolder.getCheckmark().setVisibility(0);
            selectThemeViewHolder.getInnerLayout().setBackgroundResource(R.drawable.selected_theme);
        } else {
            selectThemeViewHolder.getCheckmark().setVisibility(8);
            selectThemeViewHolder.getInnerLayout().setBackgroundResource(R.drawable.unselected_theme);
        }
        selectThemeViewHolder.getThemeImage().setAutoLoad(false);
        selectThemeViewHolder.getThemeImage().clearBackground();
        selectThemeViewHolder.getThemeImage().reset();
        final String bannerurl = mTTheme.getBannerurl();
        if (bannerurl != null) {
            selectThemeViewHolder.getThemeImage().post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SelectThemeAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SelectThemeAdapter.onBindViewHolder$lambda$2$0(selectThemeViewHolder, bannerurl);
                }
            });
        }
        Context context = selectThemeViewHolder.getRootLayout().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final boolean zContains = new PreferencesManager(context).getThemesPurchased().contains(mTTheme.getGoogleproductid());
        if (StringsKt.startsWith$default(mTTheme.getGoogleproductid(), "free_", false, 2, (Object) null)) {
            if (zContains) {
                selectThemeViewHolder.getPriceTextView().setText(selectThemeViewHolder.getRootLayout().getContext().getString(R.string.obtained));
                selectThemeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background_grey);
            } else {
                selectThemeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background);
                selectThemeViewHolder.getPriceTextView().setText(selectThemeViewHolder.getRootLayout().getContext().getString(R.string.obtain));
            }
        } else if (zContains) {
            selectThemeViewHolder.getPriceTextView().setText(selectThemeViewHolder.getRootLayout().getContext().getString(R.string.purchased));
            selectThemeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background_grey);
        } else {
            selectThemeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background);
            String price = mTTheme.getPrice();
            if (price == null || price.length() <= 0) {
                selectThemeViewHolder.getPriceTextView().setText("--,-");
            } else {
                selectThemeViewHolder.getPriceTextView().setText(price.toString());
            }
        }
        ViewExtensionsKt.setOnClickWithFade(selectThemeViewHolder.getBuyButtonLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SelectThemeAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SelectThemeAdapter.onBindViewHolder$lambda$5(zContains, this, mTTheme);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_theme_default_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SelectThemeDefaultViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_theme_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new SelectThemeViewHolder(viewInflate2, this.clickListener);
    }
}
