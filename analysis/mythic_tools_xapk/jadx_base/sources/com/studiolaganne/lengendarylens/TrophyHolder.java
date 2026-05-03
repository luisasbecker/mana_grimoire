package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrophiesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/TrophyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/TrophiesClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/studiolaganne/lengendarylens/TrophiesClickListener;Landroid/view/View;)V", "trophyNameLabel", "Landroid/widget/TextView;", "trophyImage", "Landroid/widget/ImageView;", "bind", "", "trophy", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TrophyHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TrophiesClickListener listener;
    private final ImageView trophyImage;
    private final TextView trophyNameLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrophyHolder(TrophiesClickListener listener, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener;
        View viewFindViewById = itemView.findViewById(R.id.trophyNameLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.trophyNameLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.trophyImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.trophyImage = (ImageView) viewFindViewById2;
    }

    static final Unit bind$lambda$3(TrophyHolder trophyHolder, MTTrophy mTTrophy) {
        trophyHolder.listener.onTrophyClick(mTTrophy);
        return Unit.INSTANCE;
    }

    public final void bind(final MTTrophy trophy) {
        MTTrophyLocalization localization;
        MTTrophyData fr;
        Intrinsics.checkNotNullParameter(trophy, "trophy");
        this.trophyNameLabel.setText(trophy.getName());
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (Intrinsics.areEqual(new PreferencesManager(context).getDeviceLanguage(), "fr") && (localization = trophy.getLocalization()) != null && (fr = localization.getFr()) != null) {
            this.trophyNameLabel.setText(fr.getName());
        }
        String image_url = trophy.getImage_url();
        if (image_url == null || image_url.length() <= 0) {
            this.trophyImage.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.medal_outline));
        } else {
            Intrinsics.checkNotNull(Glide.with(this.itemView.getContext()).load(image_url).placeholder(R.drawable.medal_outline).into(this.trophyImage));
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.TrophyHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrophyHolder.bind$lambda$3(this.f$0, trophy);
            }
        });
    }
}
