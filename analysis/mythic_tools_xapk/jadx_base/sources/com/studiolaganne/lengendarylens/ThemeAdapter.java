package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ThemeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ThemeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "clickListener", "Lcom/studiolaganne/lengendarylens/ThemeListClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/ThemeListClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_THEME = 1;
    private final ThemeListClickListener clickListener;
    private final List<MTTheme> themes;
    public static final int $stable = 8;

    public ThemeAdapter(List<MTTheme> themes, ThemeListClickListener clickListener) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.themes = themes;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(ThemeAdapter themeAdapter, MTTheme mTTheme) {
        themeAdapter.clickListener.onThemeTapped(mTTheme);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$4(Ref.BooleanRef booleanRef, ThemeAdapter themeAdapter, MTTheme mTTheme, boolean z, boolean z2) {
        if (booleanRef.element) {
            themeAdapter.clickListener.onThemeUpdate(mTTheme);
            return Unit.INSTANCE;
        }
        if (z) {
            if (z2) {
                themeAdapter.clickListener.onThemeAlreadyBought(mTTheme, true);
                return Unit.INSTANCE;
            }
            themeAdapter.clickListener.onBuyTapped(mTTheme);
            return Unit.INSTANCE;
        }
        if (z2) {
            themeAdapter.clickListener.onThemeAlreadyBought(mTTheme, false);
            return Unit.INSTANCE;
        }
        themeAdapter.clickListener.onBuyTapped(mTTheme);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.themes.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ThemeViewHolder themeViewHolder = (ThemeViewHolder) holder;
        final MTTheme mTTheme = this.themes.get(position);
        ViewExtensionsKt.setOnClickWithFade(themeViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.ThemeAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThemeAdapter.onBindViewHolder$lambda$0(this.f$0, mTTheme);
            }
        });
        themeViewHolder.getThemeTitle().setText(mTTheme.getTitle());
        themeViewHolder.getThemeCatchphraase().setText(mTTheme.getCatchphrase());
        themeViewHolder.getPriceTextView().setText("--,-");
        themeViewHolder.getThemeImage().clearBackground();
        String bannerurl = mTTheme.getBannerurl();
        if (bannerurl != null) {
            themeViewHolder.getThemeImage().reset();
            themeViewHolder.getThemeImage().loadImage(bannerurl);
        }
        Context context = themeViewHolder.getRootLayout().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        final boolean zContains = preferencesManager.getThemesPurchased().contains(mTTheme.getGoogleproductid());
        final boolean zStartsWith$default = StringsKt.startsWith$default(mTTheme.getGoogleproductid(), "free_", false, 2, (Object) null);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (zContains) {
            Map<String, Integer> allThemeVersions = preferencesManager.getAllThemeVersions();
            if (allThemeVersions.containsKey(mTTheme.getGoogleproductid())) {
                Integer num = allThemeVersions.get(mTTheme.getGoogleproductid());
                Intrinsics.checkNotNull(num);
                iIntValue = num.intValue();
            } else {
                iIntValue = 1000;
            }
            if (iIntValue < mTTheme.getVersion()) {
                booleanRef.element = true;
            }
        }
        if (booleanRef.element) {
            themeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background_blue);
            themeViewHolder.getPriceTextView().setText(themeViewHolder.getRootLayout().getContext().getString(R.string.update));
        } else if (zStartsWith$default) {
            if (zContains) {
                themeViewHolder.getPriceTextView().setText(themeViewHolder.getRootLayout().getContext().getString(R.string.obtained));
                themeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background_grey);
            } else {
                themeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background);
                themeViewHolder.getPriceTextView().setText(themeViewHolder.getRootLayout().getContext().getString(R.string.obtain));
            }
        } else if (zContains) {
            themeViewHolder.getPriceTextView().setText(themeViewHolder.getRootLayout().getContext().getString(R.string.purchased));
            themeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background_grey);
        } else {
            themeViewHolder.getBuyButtonLayout().setBackgroundResource(R.drawable.custom_button_background);
            String price = mTTheme.getPrice();
            if (price == null || price.length() <= 0) {
                themeViewHolder.getPriceTextView().setText("--,-");
            } else {
                themeViewHolder.getPriceTextView().setText(price.toString());
            }
        }
        ViewExtensionsKt.setOnClickWithFade(themeViewHolder.getBuyButtonLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.ThemeAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThemeAdapter.onBindViewHolder$lambda$4(booleanRef, this, mTTheme, zStartsWith$default, zContains);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ThemeViewHolder(viewInflate, this.clickListener);
    }
}
