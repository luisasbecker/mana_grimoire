package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullScreenImageFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/FullScreenImageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FullScreenImageFragment extends Fragment {
    private static final String ARG_IMAGE_URL = "image_url";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FullScreenImageFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/FullScreenImageFragment$Companion;", "", "<init>", "()V", "ARG_IMAGE_URL", "", "newInstance", "Lcom/studiolaganne/lengendarylens/FullScreenImageFragment;", "imageUrl", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FullScreenImageFragment newInstance(String imageUrl) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            FullScreenImageFragment fullScreenImageFragment = new FullScreenImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FullScreenImageFragment.ARG_IMAGE_URL, imageUrl);
            fullScreenImageFragment.setArguments(bundle);
            return fullScreenImageFragment;
        }
    }

    static final void onViewCreated$lambda$1(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_fullscreen_image, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.fullscreenImageView);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.closeButton);
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(ARG_IMAGE_URL)) != null) {
            Glide.with(this).load(string).transform(new RotateTransformation(90.0f)).into(imageView);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FullScreenImageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FullScreenImageFragment.onViewCreated$lambda$1(view2);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FullScreenImageFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FullScreenImageFragment fullScreenImageFragment = this.f$0;
                fullScreenImageFragment.getParentFragmentManager().beginTransaction().remove(fullScreenImageFragment).commit();
            }
        });
    }
}
