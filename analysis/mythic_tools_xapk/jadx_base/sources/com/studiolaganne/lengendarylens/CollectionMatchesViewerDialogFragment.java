package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionMatchesViewerDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionMatchesViewerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "matches", "Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionMatchesViewerDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private MTFullCard card;
    private MTCardCollectionMatches matches;

    /* JADX INFO: compiled from: CollectionMatchesViewerDialogFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionMatchesViewerDialogFragment$Builder;", "", "<init>", "()V", "fragment", "Lcom/studiolaganne/lengendarylens/CollectionMatchesViewerDialogFragment;", "setCard", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CollectionMatchesViewerDialogFragment fragment = new CollectionMatchesViewerDialogFragment();

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.fragment.card = card;
            CollectionMatchesViewerDialogFragment collectionMatchesViewerDialogFragment = this.fragment;
            MTCardCollectionStatus collection = card.getCollection();
            collectionMatchesViewerDialogFragment.matches = collection != null ? collection.getMatches() : null;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.fragment, manager, tag);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_collection_matches_viewer, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MTFullCard mTFullCard = this.card;
        if (mTFullCard == null) {
            dismiss();
            return;
        }
        MTCardCollectionMatches mTCardCollectionMatches = this.matches;
        if (mTCardCollectionMatches == null) {
            dismiss();
            return;
        }
        ((ImageView) view.findViewById(R.id.closeImage)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CollectionMatchesViewerDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.dismiss();
            }
        });
        ((MaterialButton) view.findViewById(R.id.closeButton)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CollectionMatchesViewerDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.dismiss();
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.cardNameTextView);
        String printed_name = mTFullCard.getPrinted_name();
        textView.setText((printed_name == null && (printed_name = mTFullCard.getName()) == null) ? "" : printed_name);
        TextView textView2 = (TextView) view.findViewById(R.id.setCodeTextView);
        String set_code = mTFullCard.getSet_code();
        if (set_code != null) {
            String upperCase = set_code.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str = upperCase != null ? upperCase : "";
        }
        textView2.setText(str);
        TextView textView3 = (TextView) view.findViewById(R.id.collectorNumberTextView);
        String collector_number = mTFullCard.getCollector_number();
        if (collector_number == null) {
            collector_number = "---";
        }
        textView3.setText(ColorKt.HEX_PREFIX + collector_number);
        List<MTCollectionCardMatch> exact = mTCardCollectionMatches.getExact();
        if (exact == null) {
            exact = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = exact.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MTCardMatch card = ((MTCollectionCardMatch) it.next()).getCard();
            Integer list_card_id = card != null ? card.getList_card_id() : null;
            if (list_card_id != null) {
                arrayList.add(list_card_id);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<MTCollectionCardMatch> all = mTCardCollectionMatches.getAll();
        if (all == null) {
            all = CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : all) {
            MTCardMatch card2 = ((MTCollectionCardMatch) obj).getCard();
            Integer list_card_id2 = card2 != null ? card2.getList_card_id() : null;
            if (list_card_id2 == null || !set.contains(list_card_id2)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List listPlus = CollectionsKt.plus((Collection) exact, (Iterable) arrayList3);
        int size = exact.size();
        ArrayList arrayList4 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList4.add(true);
        }
        ArrayList arrayList5 = arrayList4;
        int size2 = arrayList3.size();
        ArrayList arrayList6 = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList6.add(false);
        }
        List listPlus2 = CollectionsKt.plus((Collection) arrayList5, (Iterable) arrayList6);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.matchesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        recyclerView.setAdapter(new ReadOnlyCardMatchAdapter(listPlus, listPlus2));
    }
}
