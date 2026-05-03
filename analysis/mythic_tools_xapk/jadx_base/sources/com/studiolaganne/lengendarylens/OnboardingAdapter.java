package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnboardingAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnboardingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/OnboardingAdapter$OnboardingViewHolder;", "pages", "", "Lcom/studiolaganne/lengendarylens/MTOnboardingPage;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "dpToPx", "dp", "context", "Landroid/content/Context;", "getItemCount", "OnboardingViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnboardingAdapter extends RecyclerView.Adapter<OnboardingViewHolder> {
    public static final int $stable = 8;
    private final List<MTOnboardingPage> pages;

    /* JADX INFO: compiled from: OnboardingAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnboardingAdapter$OnboardingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnboardingViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ImageView imageView;
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnboardingViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.page_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.imageView = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.page_text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.textView = (TextView) viewFindViewById2;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }

        public final TextView getTextView() {
            return this.textView;
        }
    }

    public OnboardingAdapter(List<MTOnboardingPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.pages = pages;
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.pages.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OnboardingViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MTOnboardingPage mTOnboardingPage = this.pages.get(position);
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(holder.getImageView().getContext()).load(mTOnboardingPage.getUrl());
        Context context = holder.getImageView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        requestBuilderLoad.apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new RoundedCorners(dpToPx(25, context)))).into(holder.getImageView());
        holder.getTextView().setText(mTOnboardingPage.getText());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OnboardingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.onboarding_page, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new OnboardingViewHolder(viewInflate);
    }
}
