package com.studiolaganne.lengendarylens;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MythicPlusLockedFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusLockedFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "featureName", "", "hasSmartDeck", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusLockedFragment extends Fragment {
    private static final String ARG_FEATURE_NAME = "feature_name";
    private static final String ARG_HAS_SMART_DECK = "has_smart_deck";
    private String featureName = "";
    private boolean hasSmartDeck;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MythicPlusLockedFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusLockedFragment$Companion;", "", "<init>", "()V", "ARG_FEATURE_NAME", "", "ARG_HAS_SMART_DECK", "newInstance", "Lcom/studiolaganne/lengendarylens/MythicPlusLockedFragment;", "featureName", "hasSmartDeck", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MythicPlusLockedFragment newInstance(String featureName, boolean hasSmartDeck) {
            Intrinsics.checkNotNullParameter(featureName, "featureName");
            MythicPlusLockedFragment mythicPlusLockedFragment = new MythicPlusLockedFragment();
            Bundle bundle = new Bundle();
            bundle.putString(MythicPlusLockedFragment.ARG_FEATURE_NAME, featureName);
            bundle.putBoolean(MythicPlusLockedFragment.ARG_HAS_SMART_DECK, hasSmartDeck);
            mythicPlusLockedFragment.setArguments(bundle);
            return mythicPlusLockedFragment;
        }
    }

    static final void onViewCreated$lambda$0(MythicPlusLockedFragment mythicPlusLockedFragment, View view) {
        Fragment parentFragment = mythicPlusLockedFragment.getParentFragment();
        if (parentFragment instanceof MythicPlusBottomSheetFragment) {
            MythicPlusCallback callback = ((MythicPlusBottomSheetFragment) parentFragment).getCallback();
            if (mythicPlusLockedFragment.hasSmartDeck) {
                if (callback != null) {
                    callback.onSubscribeMythicPlus(Intrinsics.areEqual(mythicPlusLockedFragment.featureName, mythicPlusLockedFragment.getString(R.string.mythic_recommendations)) ? "default" : "cardranking");
                }
            } else if (callback != null) {
                callback.onConvertSmartDeck();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_FEATURE_NAME)) == null) {
            string = "";
        }
        this.featureName = string;
        Bundle arguments2 = getArguments();
        this.hasSmartDeck = arguments2 != null ? arguments2.getBoolean(ARG_HAS_SMART_DECK) : false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mythic_plus_locked, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.lockedIcon);
        imageView.setOutlineProvider(new CircularOutlineProvider());
        imageView.setClipToOutline(true);
        TextView textView = (TextView) view.findViewById(R.id.lockedMessage);
        TextView textView2 = (TextView) view.findViewById(R.id.lockedButton);
        String string = getString(R.string.mythic_locked_title, this.featureName);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.hasSmartDeck ? getString(R.string.mythic_locked_subscribe_body) : getString(R.string.mythic_locked_convert_body);
        Intrinsics.checkNotNull(string2);
        textView.setText(string + "\n" + string2);
        if (this.hasSmartDeck) {
            textView2.setText(getString(R.string.smart_deck_convert_subscribe));
            Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.mythic_plus_small);
            int i = (int) (32.0f * getResources().getDisplayMetrics().density);
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i);
            }
            if (drawable != null) {
                drawable.setAlpha(130);
            }
            textView2.setCompoundDrawablesRelative(drawable, null, null, null);
        } else {
            textView2.setText(getString(R.string.smart_deck_convert_free));
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusLockedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MythicPlusLockedFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }
}
