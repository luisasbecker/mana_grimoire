package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MythicUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "users", "", "Lcom/studiolaganne/lengendarylens/MTFriend;", Key.ROTATION, "", "clickListener", "Lcom/studiolaganne/lengendarylens/MythicUserClickListener;", "showQrScan", "", "<init>", "(Ljava/util/List;ILcom/studiolaganne/lengendarylens/MythicUserClickListener;Z)V", "headerCount", "getHeaderCount", "()I", "showEmpty", "getShowEmpty", "()Z", "dpToPx", "context", "Landroid/content/Context;", "dp", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_BACK_BUTTON = 2;
    private static final int VIEW_TYPE_EMPTY = 4;
    private static final int VIEW_TYPE_MT_USER = 1;
    private static final int VIEW_TYPE_QR_SCAN = 3;
    private final MythicUserClickListener clickListener;
    private final int rotation;
    private final boolean showQrScan;
    private final List<MTFriend> users;
    public static final int $stable = 8;

    public MythicUsersAdapter(List<MTFriend> users, int i, MythicUserClickListener clickListener, boolean z) {
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.users = users;
        this.rotation = i;
        this.clickListener = clickListener;
        this.showQrScan = z;
    }

    public /* synthetic */ MythicUsersAdapter(List list, int i, MythicUserClickListener mythicUserClickListener, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, mythicUserClickListener, (i2 & 8) != 0 ? true : z);
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private final int getHeaderCount() {
        return this.showQrScan ? 2 : 1;
    }

    private final boolean getShowEmpty() {
        return this.users.isEmpty() && !this.showQrScan;
    }

    static final Unit onBindViewHolder$lambda$0(MythicBackViewHolder mythicBackViewHolder) {
        mythicBackViewHolder.getClickListener().onBackFromMythicUsersSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(QrScanViewHolder qrScanViewHolder) {
        qrScanViewHolder.getClickListener().onQrScanSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$2(MythicUsersAdapter mythicUsersAdapter, MTFriend mTFriend) {
        mythicUsersAdapter.clickListener.onMythicUserSelected(mTFriend);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.users.size() + getHeaderCount() + (getShowEmpty() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 2;
        }
        if (this.showQrScan && position == 1) {
            return 3;
        }
        return (getShowEmpty() && position == getHeaderCount()) ? 4 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            final MythicBackViewHolder mythicBackViewHolder = (MythicBackViewHolder) holder;
            mythicBackViewHolder.getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(mythicBackViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicUsersAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MythicUsersAdapter.onBindViewHolder$lambda$0(mythicBackViewHolder);
                }
            });
            return;
        }
        if (this.showQrScan && position == 1) {
            final QrScanViewHolder qrScanViewHolder = (QrScanViewHolder) holder;
            qrScanViewHolder.getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(qrScanViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicUsersAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MythicUsersAdapter.onBindViewHolder$lambda$1(qrScanViewHolder);
                }
            });
            return;
        }
        if (getShowEmpty() && position == getHeaderCount()) {
            ((MythicEmptyViewHolder) holder).itemView.setRotation(this.rotation);
            return;
        }
        MythicUserViewHolder mythicUserViewHolder = (MythicUserViewHolder) holder;
        final MTFriend mTFriend = this.users.get(position - getHeaderCount());
        mythicUserViewHolder.getRootLayout().setRotation(this.rotation);
        mythicUserViewHolder.getUserFirstName().setText(mTFriend.getFirstname());
        mythicUserViewHolder.getUserName().setText("@" + mTFriend.getUsername());
        mythicUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        mythicUserViewHolder.getProfileLayout().setClipToOutline(true);
        mythicUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        mythicUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTFriend.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            mythicUserViewHolder.getProfileIcon().setVisibility(4);
            mythicUserViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            mythicUserViewHolder.getProfileIcon().setVisibility(0);
            mythicUserViewHolder.getNoPhotoIcon().setVisibility(4);
            mythicUserViewHolder.getProfileIcon().reset();
            mythicUserViewHolder.getProfileIcon().setAutoLoad(false);
            mythicUserViewHolder.getProfileIcon().loadImage(picture);
        }
        ViewExtensionsKt.setOnClickWithFade(mythicUserViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicUsersAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicUsersAdapter.onBindViewHolder$lambda$2(this.f$0, mTFriend);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_game_user_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new MythicUserViewHolder(viewInflate, this.clickListener);
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_item, parent, false);
            int i = this.rotation;
            if (i == 0 || i == 180) {
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
            return new MythicBackViewHolder(viewInflate2, this.clickListener);
        }
        if (viewType == 3) {
            View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.qr_scan_item, parent, false);
            int i2 = this.rotation;
            if (i2 == 0 || i2 == 180) {
                ViewGroup.LayoutParams layoutParams3 = viewInflate3.getLayoutParams();
                Context context3 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                layoutParams3.height = dpToPx(context3, 130);
                viewInflate3.setLayoutParams(layoutParams3);
            } else {
                ViewGroup.LayoutParams layoutParams4 = viewInflate3.getLayoutParams();
                Context context4 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                layoutParams4.width = dpToPx(context4, 130);
                viewInflate3.setLayoutParams(layoutParams4);
            }
            Intrinsics.checkNotNull(viewInflate3);
            return new QrScanViewHolder(viewInflate3, this.clickListener);
        }
        if (viewType != 4) {
            throw new IllegalArgumentException("Invalid view type");
        }
        Context context5 = parent.getContext();
        Intrinsics.checkNotNull(context5);
        int iDpToPx = dpToPx(context5, 130);
        int iDpToPx2 = dpToPx(context5, 4);
        int iDpToPx3 = dpToPx(context5, 12);
        TextView textView = new TextView(context5);
        textView.setTag("emptyText");
        textView.setText(context5.getString(R.string.shared_decks_empty));
        textView.setTextColor(ContextCompat.getColor(context5, R.color.light_grey));
        textView.setTextSize(2, 12.0f);
        textView.setGravity(17);
        textView.setPadding(iDpToPx3, iDpToPx3, iDpToPx3, iDpToPx3);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(dpToPx(context5, 1), ContextCompat.getColor(context5, R.color.text_color_transparent));
        gradientDrawable.setCornerRadius(dpToPx(context5, 12));
        gradientDrawable.setColor(0);
        FrameLayout frameLayout = new FrameLayout(context5);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.addView(textView);
        RecyclerView.LayoutParams layoutParams5 = new RecyclerView.LayoutParams(iDpToPx, iDpToPx);
        layoutParams5.setMargins(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
        frameLayout.setLayoutParams(layoutParams5);
        return new MythicEmptyViewHolder(frameLayout);
    }
}
