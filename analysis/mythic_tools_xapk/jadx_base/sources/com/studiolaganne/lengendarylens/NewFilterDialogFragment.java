package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewFilterDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewFilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/NewFilterDialogListener;", "showIntFields", "", "showPriceField", "disableSets", "disableLayout", "disableKeywords", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewFilterDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean disableKeywords;
    private boolean disableLayout;
    private boolean disableSets;
    private NewFilterDialogListener listener;
    private boolean showIntFields;
    private boolean showPriceField;

    /* JADX INFO: compiled from: NewFilterDialogFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewFilterDialogFragment$Builder;", "", "<init>", "()V", "showIntFields", "", "showPriceField", "disableSets", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/NewFilterDialogListener;", "disableLayouts", "disableKeywords", InAppPurchaseConstants.METHOD_SET_LISTENER, "setShowIntFields", "setShowPriceField", "setDisableSets", "setDisableLayouts", "setDisableKeywords", "build", "Lcom/studiolaganne/lengendarylens/NewFilterDialogFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean disableKeywords;
        private boolean disableLayouts;
        private boolean disableSets;
        private NewFilterDialogListener listener;
        private boolean showIntFields;
        private boolean showPriceField;

        public final NewFilterDialogFragment build() {
            NewFilterDialogFragment newFilterDialogFragment = new NewFilterDialogFragment();
            newFilterDialogFragment.showIntFields = this.showIntFields;
            newFilterDialogFragment.showPriceField = this.showPriceField;
            newFilterDialogFragment.disableSets = this.disableSets;
            newFilterDialogFragment.disableKeywords = this.disableKeywords;
            newFilterDialogFragment.disableLayout = this.disableLayouts;
            newFilterDialogFragment.listener = this.listener;
            return newFilterDialogFragment;
        }

        public final Builder setDisableKeywords(boolean disableKeywords) {
            this.disableKeywords = disableKeywords;
            return this;
        }

        public final Builder setDisableLayouts(boolean disableLayouts) {
            this.disableLayouts = disableLayouts;
            return this;
        }

        public final Builder setDisableSets(boolean disableSets) {
            this.disableSets = disableSets;
            return this;
        }

        public final Builder setListener(NewFilterDialogListener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder setShowIntFields(boolean showIntFields) {
            this.showIntFields = showIntFields;
            return this;
        }

        public final Builder setShowPriceField(boolean showPriceField) {
            this.showPriceField = showPriceField;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.new_filter_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.filtersRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        List list = ArraysKt.toList(SearchKeyword.values());
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SearchKeyword searchKeyword = (SearchKeyword) obj;
            if (searchKeyword != SearchKeyword.OTAG && searchKeyword != SearchKeyword.IS && searchKeyword != SearchKeyword.GAME && searchKeyword != SearchKeyword.BANNED && searchKeyword != SearchKeyword.RESTRICTED && searchKeyword != SearchKeyword.LEGAL && searchKeyword != SearchKeyword.IN_DECK) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!this.showIntFields) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                SearchKeyword searchKeyword2 = (SearchKeyword) obj2;
                if (searchKeyword2 != SearchKeyword.POWER && searchKeyword2 != SearchKeyword.TOUGHNESS && searchKeyword2 != SearchKeyword.LOYALTY && searchKeyword2 != SearchKeyword.DEFENSE) {
                    arrayList3.add(obj2);
                }
            }
            arrayList2 = arrayList3;
        }
        if (!this.showPriceField) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : arrayList2) {
                if (((SearchKeyword) obj3) != SearchKeyword.PRICE) {
                    arrayList4.add(obj3);
                }
            }
            arrayList2 = arrayList4;
        }
        if (this.disableLayout) {
            ArrayList arrayList5 = new ArrayList();
            for (Object obj4 : arrayList2) {
                if (((SearchKeyword) obj4) != SearchKeyword.LAYOUT) {
                    arrayList5.add(obj4);
                }
            }
            arrayList2 = arrayList5;
        }
        if (this.disableKeywords) {
            ArrayList arrayList6 = new ArrayList();
            for (Object obj5 : arrayList2) {
                if (((SearchKeyword) obj5) != SearchKeyword.KEYWORD) {
                    arrayList6.add(obj5);
                }
            }
            arrayList2 = arrayList6;
        }
        if (this.disableSets) {
            ArrayList arrayList7 = new ArrayList();
            for (Object obj6 : arrayList2) {
                if (((SearchKeyword) obj6) != SearchKeyword.SET) {
                    arrayList7.add(obj6);
                }
            }
            arrayList2 = arrayList7;
        }
        recyclerView.setAdapter(new NewFilterAdapter(arrayList2, this.listener));
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
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.85d), -2);
    }
}
