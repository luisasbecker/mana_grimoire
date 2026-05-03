package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SwipePlaymatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipePlaymatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", Key.ROTATION, "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/SwipePlaymatAdapter$SwipeItemData;", "selectedItemId", "", "clickListener", "Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;", "<init>", "(ILjava/util/List;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;)V", "dpToPx", "context", "Landroid/content/Context;", "dp", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "SwipeItemData", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SwipePlaymatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_BACK = 1;
    public static final int VIEW_TYPE_GALLERY = 4;
    public static final int VIEW_TYPE_PLAIN_COLOR = 5;
    public static final int VIEW_TYPE_PLAYMAT = 2;
    public static final int VIEW_TYPE_SCAN = 0;
    private final SwipePlaymatClickListener clickListener;
    private List<SwipeItemData> items;
    private int rotation;
    private String selectedItemId;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SwipePlaymatAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipePlaymatAdapter$SwipeItemData;", "", "itemType", "", "itemName", "", "itemId", "itemUrl", "locked", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getItemType", "()I", "setItemType", "(I)V", "getItemName", "()Ljava/lang/String;", "setItemName", "(Ljava/lang/String;)V", "getItemId", "setItemId", "getItemUrl", "setItemUrl", "getLocked", "()Z", "setLocked", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SwipeItemData {
        public static final int $stable = 8;
        private String itemId;
        private String itemName;
        private int itemType;
        private String itemUrl;
        private boolean locked;

        public SwipeItemData() {
            this(0, null, null, null, false, 31, null);
        }

        public SwipeItemData(int i, String itemName, String itemId, String itemUrl, boolean z) {
            Intrinsics.checkNotNullParameter(itemName, "itemName");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(itemUrl, "itemUrl");
            this.itemType = i;
            this.itemName = itemName;
            this.itemId = itemId;
            this.itemUrl = itemUrl;
            this.locked = z;
        }

        public /* synthetic */ SwipeItemData(int i, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? false : z);
        }

        public static /* synthetic */ SwipeItemData copy$default(SwipeItemData swipeItemData, int i, String str, String str2, String str3, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = swipeItemData.itemType;
            }
            if ((i2 & 2) != 0) {
                str = swipeItemData.itemName;
            }
            if ((i2 & 4) != 0) {
                str2 = swipeItemData.itemId;
            }
            if ((i2 & 8) != 0) {
                str3 = swipeItemData.itemUrl;
            }
            if ((i2 & 16) != 0) {
                z = swipeItemData.locked;
            }
            boolean z2 = z;
            String str4 = str2;
            return swipeItemData.copy(i, str, str4, str3, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getItemType() {
            return this.itemType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getItemName() {
            return this.itemName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getItemUrl() {
            return this.itemUrl;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getLocked() {
            return this.locked;
        }

        public final SwipeItemData copy(int itemType, String itemName, String itemId, String itemUrl, boolean locked) {
            Intrinsics.checkNotNullParameter(itemName, "itemName");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(itemUrl, "itemUrl");
            return new SwipeItemData(itemType, itemName, itemId, itemUrl, locked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SwipeItemData)) {
                return false;
            }
            SwipeItemData swipeItemData = (SwipeItemData) other;
            return this.itemType == swipeItemData.itemType && Intrinsics.areEqual(this.itemName, swipeItemData.itemName) && Intrinsics.areEqual(this.itemId, swipeItemData.itemId) && Intrinsics.areEqual(this.itemUrl, swipeItemData.itemUrl) && this.locked == swipeItemData.locked;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getItemName() {
            return this.itemName;
        }

        public final int getItemType() {
            return this.itemType;
        }

        public final String getItemUrl() {
            return this.itemUrl;
        }

        public final boolean getLocked() {
            return this.locked;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.itemType) * 31) + this.itemName.hashCode()) * 31) + this.itemId.hashCode()) * 31) + this.itemUrl.hashCode()) * 31) + Boolean.hashCode(this.locked);
        }

        public final void setItemId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.itemId = str;
        }

        public final void setItemName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.itemName = str;
        }

        public final void setItemType(int i) {
            this.itemType = i;
        }

        public final void setItemUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.itemUrl = str;
        }

        public final void setLocked(boolean z) {
            this.locked = z;
        }

        public String toString() {
            return "SwipeItemData(itemType=" + this.itemType + ", itemName=" + this.itemName + ", itemId=" + this.itemId + ", itemUrl=" + this.itemUrl + ", locked=" + this.locked + ")";
        }
    }

    public SwipePlaymatAdapter(int i, List<SwipeItemData> items, String selectedItemId, SwipePlaymatClickListener clickListener) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(selectedItemId, "selectedItemId");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.rotation = i;
        this.items = items;
        this.selectedItemId = selectedItemId;
        this.clickListener = clickListener;
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static final Unit onBindViewHolder$lambda$0(BackViewHolder backViewHolder) {
        backViewHolder.getClickListener().onBackTapped();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(ScanCardViewHolder scanCardViewHolder) {
        scanCardViewHolder.getClickListener().onCardScanTapped();
        return Unit.INSTANCE;
    }

    static final void onBindViewHolder$lambda$2(SwipePlaymatAdapter swipePlaymatAdapter, View view) {
        int i = swipePlaymatAdapter.rotation;
        if (i == 90 || i == 270) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = width;
            view.setLayoutParams(layoutParams);
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = height;
        view.setLayoutParams(layoutParams2);
    }

    static final Unit onBindViewHolder$lambda$3(GalleryViewHolder galleryViewHolder) {
        galleryViewHolder.getClickListener().onGalleryTapped();
        return Unit.INSTANCE;
    }

    static final void onBindViewHolder$lambda$4(SwipePlaymatAdapter swipePlaymatAdapter, View view) {
        int i = swipePlaymatAdapter.rotation;
        if (i == 90 || i == 270) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = width;
            view.setLayoutParams(layoutParams);
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = height;
        view.setLayoutParams(layoutParams2);
    }

    static final Unit onBindViewHolder$lambda$5(PlainColorViewHolder plainColorViewHolder) {
        plainColorViewHolder.getClickListener().onPlainColorTapped();
        return Unit.INSTANCE;
    }

    static final void onBindViewHolder$lambda$6(SwipePlaymatAdapter swipePlaymatAdapter, View view) {
        int i = swipePlaymatAdapter.rotation;
        if (i == 90 || i == 270) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = width;
            view.setLayoutParams(layoutParams);
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = height;
        view.setLayoutParams(layoutParams2);
    }

    static final Unit onBindViewHolder$lambda$8(SwipePlaymatViewHolder swipePlaymatViewHolder, SwipeItemData swipeItemData) {
        swipePlaymatViewHolder.getClickListener().onPlaymatSelected(swipeItemData.getItemId());
        return Unit.INSTANCE;
    }

    static final void onBindViewHolder$lambda$9(SwipePlaymatAdapter swipePlaymatAdapter, View view) {
        int i = swipePlaymatAdapter.rotation;
        if (i == 90 || i == 270) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = width;
            view.setLayoutParams(layoutParams);
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = height;
        view.setLayoutParams(layoutParams2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            final ScanCardViewHolder scanCardViewHolder = (ScanCardViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(scanCardViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipePlaymatAdapter.onBindViewHolder$lambda$1(scanCardViewHolder);
                }
            });
            final View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            itemView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SwipePlaymatAdapter.onBindViewHolder$lambda$2(this.f$0, itemView);
                }
            });
            return;
        }
        if (itemViewType == 1) {
            final BackViewHolder backViewHolder = (BackViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(backViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipePlaymatAdapter.onBindViewHolder$lambda$0(backViewHolder);
                }
            });
            return;
        }
        if (itemViewType != 2) {
            if (itemViewType == 4) {
                final GalleryViewHolder galleryViewHolder = (GalleryViewHolder) holder;
                ViewExtensionsKt.setOnClickWithFade(galleryViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SwipePlaymatAdapter.onBindViewHolder$lambda$3(galleryViewHolder);
                    }
                });
                final View itemView2 = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                itemView2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwipePlaymatAdapter.onBindViewHolder$lambda$4(this.f$0, itemView2);
                    }
                });
                return;
            }
            if (itemViewType != 5) {
                return;
            }
            final PlainColorViewHolder plainColorViewHolder = (PlainColorViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(plainColorViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipePlaymatAdapter.onBindViewHolder$lambda$5(plainColorViewHolder);
                }
            });
            final View itemView3 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
            itemView3.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    SwipePlaymatAdapter.onBindViewHolder$lambda$6(this.f$0, itemView3);
                }
            });
            return;
        }
        final SwipePlaymatViewHolder swipePlaymatViewHolder = (SwipePlaymatViewHolder) holder;
        final SwipeItemData swipeItemData = this.items.get(position);
        swipePlaymatViewHolder.getPlaymatName().setText(swipeItemData.getItemName());
        if (StringsKt.contains$default((CharSequence) swipeItemData.getItemId(), (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
            List listSplit$default = StringsKt.split$default((CharSequence) swipeItemData.getItemId(), new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
            String str = (String) listSplit$default.get(0);
            String str2 = (String) listSplit$default.get(1);
            SkinManager companion = SkinManager.INSTANCE.getInstance();
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Bitmap imageFromSkin = companion.getImageFromSkin(context, str, str2);
            if (imageFromSkin != null) {
                swipePlaymatViewHolder.getPlaymatImage().setImageBitmap(imageFromSkin);
            }
        } else {
            int identifier = holder.itemView.getContext().getResources().getIdentifier(swipeItemData.getItemId(), "drawable", holder.itemView.getContext().getPackageName());
            if (identifier != 0) {
                swipePlaymatViewHolder.getPlaymatImage().setImageResource(identifier);
            }
        }
        if (!swipeItemData.getLocked()) {
            swipePlaymatViewHolder.getLockImage().setVisibility(8);
        }
        if (Intrinsics.areEqual(swipeItemData.getItemId(), this.selectedItemId)) {
            swipePlaymatViewHolder.getCardView().setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.lighter_blue));
            swipePlaymatViewHolder.getCardView().setStrokeWidth(6);
        } else {
            swipePlaymatViewHolder.getCardView().setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.darker_blue));
            swipePlaymatViewHolder.getCardView().setStrokeWidth(3);
        }
        ViewExtensionsKt.setOnClickWithFade(swipePlaymatViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipePlaymatAdapter.onBindViewHolder$lambda$8(swipePlaymatViewHolder, swipeItemData);
            }
        });
        final View itemView4 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView4, "itemView");
        itemView4.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipePlaymatAdapter$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                SwipePlaymatAdapter.onBindViewHolder$lambda$9(this.f$0, itemView4);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            int i = this.rotation;
            View viewInflate = (i == 0 || (i != 90 && (i == 180 || i != 270))) ? LayoutInflater.from(parent.getContext()).inflate(R.layout.scan_card_item, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.scan_card_item_rotated, parent, false);
            viewInflate.setRotation(this.rotation);
            Intrinsics.checkNotNull(viewInflate);
            return new ScanCardViewHolder(viewInflate, this.clickListener);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_item, parent, false);
            viewInflate2.setRotation(this.rotation);
            int i2 = this.rotation;
            if (i2 == 0 || i2 == 180) {
                ViewGroup.LayoutParams layoutParams = viewInflate2.getLayoutParams();
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                layoutParams.height = dpToPx(context, 130);
                viewInflate2.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = viewInflate2.getLayoutParams();
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                layoutParams2.width = dpToPx(context2, 130);
                viewInflate2.setLayoutParams(layoutParams2);
            }
            Intrinsics.checkNotNull(viewInflate2);
            return new BackViewHolder(viewInflate2, this.clickListener);
        }
        if (viewType == 2) {
            int i3 = this.rotation;
            View viewInflate3 = (i3 == 0 || (i3 != 90 && (i3 == 180 || i3 != 270))) ? LayoutInflater.from(parent.getContext()).inflate(R.layout.square_playmat_item, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.square_playmat_item_rotated, parent, false);
            viewInflate3.setRotation(this.rotation);
            Intrinsics.checkNotNull(viewInflate3);
            return new SwipePlaymatViewHolder(viewInflate3, this.clickListener);
        }
        if (viewType == 4) {
            int i4 = this.rotation;
            View viewInflate4 = (i4 == 0 || (i4 != 90 && (i4 == 180 || i4 != 270))) ? LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item_rotated, parent, false);
            viewInflate4.setRotation(this.rotation);
            Intrinsics.checkNotNull(viewInflate4);
            return new GalleryViewHolder(viewInflate4, this.clickListener);
        }
        if (viewType != 5) {
            throw new IllegalArgumentException("Invalid view type");
        }
        int i5 = this.rotation;
        View viewInflate5 = (i5 == 0 || (i5 != 90 && (i5 == 180 || i5 != 270))) ? LayoutInflater.from(parent.getContext()).inflate(R.layout.plain_color_item, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.plain_color_item_rotated, parent, false);
        viewInflate5.setRotation(this.rotation);
        Intrinsics.checkNotNull(viewInflate5);
        return new PlainColorViewHolder(viewInflate5, this.clickListener);
    }
}
