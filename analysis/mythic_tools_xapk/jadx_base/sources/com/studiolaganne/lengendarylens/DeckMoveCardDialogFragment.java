package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.studiolaganne.lengendarylens.DeckListDestinationAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckMoveCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentLists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "currentListId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/DeckMoveCardDialogListener;", "applyToQty", "mode", "Lcom/studiolaganne/lengendarylens/DeckCardDialogMode;", "cardCount", "deckListDestinationAdapter", "Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter;", "selectedListId", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckMoveCardDialogFragment extends DialogFragment {
    public static final String TAG = "DeckMoveCardDialogFragment";
    private MTFullCard card;
    private int cardCount;
    private MTDeckLists currentLists;
    private DeckListDestinationAdapter deckListDestinationAdapter;
    private DeckMoveCardDialogListener listener;
    public static final int $stable = 8;
    private int currentListId = -1;
    private int applyToQty = 1;
    private DeckCardDialogMode mode = DeckCardDialogMode.MOVE;
    private int selectedListId = -1;

    /* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckMoveCardDialogFragment$Builder;", "", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentLists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "currentListId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/DeckMoveCardDialogListener;", "mode", "Lcom/studiolaganne/lengendarylens/DeckCardDialogMode;", "cardCount", "setCard", "setCurrentLists", "setCurrentListId", InAppPurchaseConstants.METHOD_SET_LISTENER, "setMode", "setCardCount", "build", "Lcom/studiolaganne/lengendarylens/DeckMoveCardDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private MTFullCard card;
        private int cardCount;
        private MTDeckLists currentLists;
        private DeckMoveCardDialogListener listener;
        private int currentListId = -1;
        private DeckCardDialogMode mode = DeckCardDialogMode.MOVE;

        public final DeckMoveCardDialogFragment build() {
            DeckMoveCardDialogFragment deckMoveCardDialogFragment = new DeckMoveCardDialogFragment();
            deckMoveCardDialogFragment.card = this.card;
            deckMoveCardDialogFragment.currentLists = this.currentLists;
            deckMoveCardDialogFragment.currentListId = this.currentListId;
            deckMoveCardDialogFragment.listener = this.listener;
            deckMoveCardDialogFragment.mode = this.mode;
            deckMoveCardDialogFragment.cardCount = this.cardCount;
            return deckMoveCardDialogFragment;
        }

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
            return this;
        }

        public final Builder setCardCount(int cardCount) {
            this.cardCount = cardCount;
            return this;
        }

        public final Builder setCurrentListId(int currentListId) {
            this.currentListId = currentListId;
            return this;
        }

        public final Builder setCurrentLists(MTDeckLists currentLists) {
            Intrinsics.checkNotNullParameter(currentLists, "currentLists");
            this.currentLists = currentLists;
            return this;
        }

        public final Builder setListener(DeckMoveCardDialogListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder setMode(DeckCardDialogMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeckCardDialogMode.values().length];
            try {
                iArr[DeckCardDialogMode.MOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckCardDialogMode.BULK_MOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckCardDialogMode.ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit onCreateView$lambda$2(DeckMoveCardDialogFragment deckMoveCardDialogFragment, TextView textView) {
        int i = deckMoveCardDialogFragment.applyToQty;
        if (i > 1) {
            int i2 = i - 1;
            deckMoveCardDialogFragment.applyToQty = i2;
            textView.setText(String.valueOf(i2));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b A[PHI: r0
      0x000b: PHI (r0v7 java.lang.Integer) = (r0v3 java.lang.Integer), (r0v9 java.lang.Integer) binds: [B:11:0x001a, B:5:0x0009] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit onCreateView$lambda$3(DeckMoveCardDialogFragment deckMoveCardDialogFragment, TextView textView) {
        int iIntValue;
        MTFullCard mTFullCard = deckMoveCardDialogFragment.card;
        if (mTFullCard == null || (quantity = mTFullCard.getVariant_quantity()) == null) {
            MTFullCard mTFullCard2 = deckMoveCardDialogFragment.card;
            Integer quantity = mTFullCard2 != null ? mTFullCard2.getQuantity() : null;
            iIntValue = quantity != null ? quantity.intValue() : 1;
        }
        int i = deckMoveCardDialogFragment.applyToQty;
        if (i < iIntValue) {
            int i2 = i + 1;
            deckMoveCardDialogFragment.applyToQty = i2;
            textView.setText(String.valueOf(i2));
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(DeckMoveCardDialogFragment deckMoveCardDialogFragment) {
        deckMoveCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(DeckMoveCardDialogFragment deckMoveCardDialogFragment) {
        if (deckMoveCardDialogFragment.selectedListId != -1) {
            int i = deckMoveCardDialogFragment.mode == DeckCardDialogMode.ADD ? deckMoveCardDialogFragment.cardCount : deckMoveCardDialogFragment.applyToQty;
            DeckMoveCardDialogListener deckMoveCardDialogListener = deckMoveCardDialogFragment.listener;
            if (deckMoveCardDialogListener != null) {
                deckMoveCardDialogListener.onMoveCardToDeckList(deckMoveCardDialogFragment.selectedListId, i);
            }
            deckMoveCardDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0161 A[PHI: r11
      0x0161: PHI (r11v27 java.lang.Integer) = (r11v13 java.lang.Integer), (r11v29 java.lang.Integer) binds: [B:49:0x0170, B:43:0x015f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int iIntValue;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.deck_move_card_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.dialogTitleTextView);
        View viewFindViewById = viewInflate.findViewById(R.id.applyLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1) {
            MTFullCard mTFullCard = this.card;
            if (mTFullCard != null) {
                String string = getString(R.string.move_card_to_deck);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String name = mTFullCard.getName();
                if (name == null) {
                    name = "";
                }
                textView.setText(StringsKt.replace$default(string, "{1}", name, false, 4, (Object) null));
                Integer variant_quantity = mTFullCard.getVariant_quantity();
                int iIntValue2 = (variant_quantity == null && (variant_quantity = mTFullCard.getQuantity()) == null) ? 1 : variant_quantity.intValue();
                this.applyToQty = iIntValue2;
                if (iIntValue2 > 1) {
                    linearLayout.setVisibility(0);
                }
            } else {
                String string2 = getString(R.string.move_card_to_deck);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                textView.setText(StringsKt.replace$default(string2, "{1}", "", false, 4, (Object) null));
                this.applyToQty = 1;
            }
        } else if (i == 2) {
            String string3 = this.cardCount == 1 ? getString(R.string.one_card) : getString(R.string.cards_count_simple, Integer.valueOf(this.cardCount));
            Intrinsics.checkNotNull(string3);
            String string4 = getString(R.string.move_card_to_deck);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            textView.setText(StringsKt.replace$default(string4, "{1}", string3, false, 4, (Object) null));
            linearLayout.setVisibility(8);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            String string5 = this.cardCount == 1 ? getString(R.string.one_card) : getString(R.string.cards_count_simple, Integer.valueOf(this.cardCount));
            Intrinsics.checkNotNull(string5);
            textView.setText(getString(R.string.add_cards_to_deck, string5));
            linearLayout.setVisibility(8);
        }
        View viewFindViewById2 = viewInflate.findViewById(R.id.applyValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.minusApplyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.plusApplyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.applyFooter);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        MTFullCard mTFullCard2 = this.card;
        if (mTFullCard2 == null || (quantity = mTFullCard2.getVariant_quantity()) == null) {
            MTFullCard mTFullCard3 = this.card;
            Integer quantity = mTFullCard3 != null ? mTFullCard3.getQuantity() : null;
            iIntValue = quantity != null ? quantity.intValue() : 1;
        }
        textView2.setText(String.valueOf(iIntValue));
        ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckMoveCardDialogFragment.onCreateView$lambda$2(this.f$0, textView2);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckMoveCardDialogFragment.onCreateView$lambda$3(this.f$0, textView2);
            }
        });
        View viewFindViewById6 = viewInflate.findViewById(R.id.deckListsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById6;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ArrayList arrayList = new ArrayList();
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists != null) {
            boolean z = this.mode == DeckCardDialogMode.MOVE || this.mode == DeckCardDialogMode.BULK_MOVE;
            MTCardContainer main = mTDeckLists.getMain();
            if (main != null && (!z || main.getId() != this.currentListId)) {
                int id = main.getId();
                String string6 = getString(R.string.main_deck);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                Integer count = main.getCount();
                arrayList.add(new DeckListItem(id, string6, count != null ? count.intValue() : 0, R.drawable.cards_grey));
            }
            MTCardContainer sideboard = mTDeckLists.getSideboard();
            if (sideboard != null && (!z || sideboard.getId() != this.currentListId)) {
                int id2 = sideboard.getId();
                String string7 = getString(R.string.sideboard);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                Integer count2 = sideboard.getCount();
                arrayList.add(new DeckListItem(id2, string7, count2 != null ? count2.intValue() : 0, R.drawable.ic_by_code));
            }
            MTCardContainer maybeboard = mTDeckLists.getMaybeboard();
            if (maybeboard != null && (!z || maybeboard.getId() != this.currentListId)) {
                int id3 = maybeboard.getId();
                String string8 = getString(R.string.maybeboard);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                Integer count3 = maybeboard.getCount();
                arrayList.add(new DeckListItem(id3, string8, count3 != null ? count3.intValue() : 0, R.drawable.ic_help));
            }
        }
        DeckListDestinationAdapter deckListDestinationAdapter = new DeckListDestinationAdapter(arrayList, new DeckListDestinationAdapter.DeckListSelectionListener() { // from class: com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment.onCreateView.6
            @Override // com.studiolaganne.lengendarylens.DeckListDestinationAdapter.DeckListSelectionListener
            public void onDeckListSelected(int listId) {
                DeckMoveCardDialogFragment.this.selectedListId = listId;
                View viewFindViewById7 = viewInflate.findViewById(R.id.moveButtonText);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
                ((TextView) viewFindViewById7).setTextColor(ContextCompat.getColor(DeckMoveCardDialogFragment.this.requireContext(), R.color.almost_white));
            }
        });
        this.deckListDestinationAdapter = deckListDestinationAdapter;
        recyclerView.setAdapter(deckListDestinationAdapter);
        View viewFindViewById7 = viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        View viewFindViewById8 = viewInflate.findViewById(R.id.moveButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        View viewFindViewById9 = viewInflate.findViewById(R.id.moveButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        TextView textView5 = (TextView) viewFindViewById9;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i2 == 1 || i2 == 2) {
            textView5.setText(getString(R.string.move));
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            textView5.setText(getString(R.string.add));
        }
        textView5.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckMoveCardDialogFragment.onCreateView$lambda$5(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById8, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckMoveCardDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
