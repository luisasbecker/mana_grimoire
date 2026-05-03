package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardPickerBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPickerBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/CardPickerCallback;", "initialQuery", "", "language", Constants.GP_IAP_TITLE, "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardPickerBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "CardPickerBottomSheetFragment";
    private CardPickerCallback callback;
    private String initialQuery = "";
    private String language = "en";
    private String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPickerBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/studiolaganne/lengendarylens/CardPickerBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/CardPickerCallback;", Constants.GP_IAP_TITLE, "initialQuery", "language", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CardPickerBottomSheetFragment newInstance$default(Companion companion, CardPickerCallback cardPickerCallback, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                str3 = "en";
            }
            return companion.newInstance(cardPickerCallback, str, str2, str3);
        }

        public final CardPickerBottomSheetFragment newInstance(CardPickerCallback callback, String title, String initialQuery, String language) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(initialQuery, "initialQuery");
            Intrinsics.checkNotNullParameter(language, "language");
            CardPickerBottomSheetFragment cardPickerBottomSheetFragment = new CardPickerBottomSheetFragment();
            cardPickerBottomSheetFragment.callback = callback;
            cardPickerBottomSheetFragment.initialQuery = initialQuery;
            cardPickerBottomSheetFragment.language = language;
            cardPickerBottomSheetFragment.title = title;
            return cardPickerBottomSheetFragment;
        }
    }

    static final Unit onCreateView$lambda$0(CardPickerBottomSheetFragment cardPickerBottomSheetFragment) {
        CardPickerCallback cardPickerCallback = cardPickerBottomSheetFragment.callback;
        if (cardPickerCallback != null) {
            cardPickerCallback.onCardPickerClosed();
        }
        cardPickerBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_card_picker, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.CardPickerBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CardPickerBottomSheetFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("card_picker_opened", null);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View viewFindViewById;
        super.onStart();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null || (viewFindViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setDraggable(true);
        bottomSheetBehaviorFrom.setExpandedOffset(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.titleTextView)).setText(getString(R.string.select_face_card));
        String str = this.title;
        if (str != null) {
            ((TextView) view.findViewById(R.id.titleTextView)).setText(str);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("pickACardMode", true);
        bundle.putBoolean("condense", false);
        bundle.putString(SearchIntents.EXTRA_QUERY, this.initialQuery);
        bundle.putString("lang", this.language);
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(bundle);
        searchFragment.setCardSelectionListener(new CardSelectionListener() { // from class: com.studiolaganne.lengendarylens.CardPickerBottomSheetFragment$onViewCreated$searchFragment$1$1
            @Override // com.studiolaganne.lengendarylens.CardSelectionListener
            public void onCardSelected(MTSimpleCard card, int face) {
                Intrinsics.checkNotNullParameter(card, "card");
                CardPickerCallback cardPickerCallback = this.this$0.callback;
                if (cardPickerCallback != null) {
                    cardPickerCallback.onCardSelected(card, face);
                }
                this.this$0.dismiss();
            }
        });
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
    }
}
