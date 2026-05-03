package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AcceptPlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/AcceptPlaygroupBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "callback", "Lcom/studiolaganne/lengendarylens/AcceptPlaygroupCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "<init>", "(Lcom/studiolaganne/lengendarylens/AcceptPlaygroupCallback;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTPlaygroup;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AcceptPlaygroupBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "AcceptPlaygroupBottomSheetFragment";
    private final AcceptPlaygroupCallback callback;
    private final MTPlaygroup playgroup;
    private final MTUser user;
    public static final int $stable = 8;

    public AcceptPlaygroupBottomSheetFragment(AcceptPlaygroupCallback callback, MTUser user, MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        this.callback = callback;
        this.user = user;
        this.playgroup = playgroup;
    }

    static final Unit onViewCreated$lambda$0(AcceptPlaygroupBottomSheetFragment acceptPlaygroupBottomSheetFragment) {
        acceptPlaygroupBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(AcceptPlaygroupBottomSheetFragment acceptPlaygroupBottomSheetFragment, View view) {
        if (acceptPlaygroupBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = acceptPlaygroupBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext);
        ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
        MTApiKt.getMtApi().acceptPlaygroupInvite(acceptPlaygroupBottomSheetFragment.user.getId(), acceptPlaygroupBottomSheetFragment.playgroup.getId()).enqueue(new AcceptPlaygroupBottomSheetFragment$onViewCreated$2$1(acceptPlaygroupBottomSheetFragment, view));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(AcceptPlaygroupBottomSheetFragment acceptPlaygroupBottomSheetFragment, View view) {
        if (acceptPlaygroupBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = acceptPlaygroupBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext);
        ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
        MTApiKt.getMtApi().leavePlaygroup(acceptPlaygroupBottomSheetFragment.user.getId(), acceptPlaygroupBottomSheetFragment.playgroup.getId()).enqueue(new AcceptPlaygroupBottomSheetFragment$onViewCreated$3$1(acceptPlaygroupBottomSheetFragment, view));
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_accept_playgroup, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.AcceptPlaygroupBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcceptPlaygroupBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        CachedImageView cachedImageView = (CachedImageView) view.findViewById(R.id.profile_icon);
        ImageView imageView = (ImageView) view.findViewById(R.id.no_photo_icon);
        cachedImageView.setOutlineProvider(new CircularOutlineProvider());
        cachedImageView.setClipToOutline(true);
        String picture = this.playgroup.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            cachedImageView.setVisibility(4);
            imageView.setVisibility(0);
        } else {
            cachedImageView.setVisibility(0);
            imageView.setVisibility(4);
            cachedImageView.reset();
            cachedImageView.setAutoLoad(false);
            cachedImageView.loadImage(picture);
        }
        ((TextView) view.findViewById(R.id.playgroupName)).setText(this.playgroup.getName());
        ((TextView) view.findViewById(R.id.playgroupDescription)).setText(this.playgroup.getDescription());
        View viewFindViewById2 = view.findViewById(R.id.acceptButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.AcceptPlaygroupBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcceptPlaygroupBottomSheetFragment.onViewCreated$lambda$1(this.f$0, view);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.declineButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.AcceptPlaygroupBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcceptPlaygroupBottomSheetFragment.onViewCreated$lambda$2(this.f$0, view);
            }
        });
    }
}
