package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.databinding.FragmentDraftTableBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DraftTableFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/DraftTableFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "tableStr", "", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentDraftTableBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentDraftTableBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DraftTableFragment extends Fragment {
    private FragmentDraftTableBinding _binding;
    private String tableStr;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: DraftTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/DraftTableFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/DraftTableFragment;", "table", "Lcom/studiolaganne/lengendarylens/DraftTable;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DraftTableFragment newInstance(DraftTable table) {
            Intrinsics.checkNotNullParameter(table, "table");
            DraftTableFragment draftTableFragment = new DraftTableFragment();
            Bundle bundle = new Bundle();
            bundle.putString("table", new Gson().toJson(table));
            draftTableFragment.setArguments(bundle);
            return draftTableFragment;
        }
    }

    @JvmStatic
    public static final DraftTableFragment newInstance(DraftTable draftTable) {
        return INSTANCE.newInstance(draftTable);
    }

    public final FragmentDraftTableBinding getBinding() {
        FragmentDraftTableBinding fragmentDraftTableBinding = this._binding;
        Intrinsics.checkNotNull(fragmentDraftTableBinding);
        return fragmentDraftTableBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.tableStr = arguments.getString("table");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDraftTableBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        DraftTable draftTable;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String str = this.tableStr;
        if (str == null || str.length() <= 0 || (draftTable = (DraftTable) new Gson().fromJson(str, DraftTable.class)) == null) {
            return;
        }
        int size = draftTable.getPlayers().size();
        if (size >= 1) {
            getBinding().textViewNum1.setAlpha(1.0f);
            getBinding().textViewPlayer1.setText(draftTable.getPlayers().get(0).getName());
        } else {
            getBinding().textViewNum1.setAlpha(0.35f);
            getBinding().textViewPlayer1.setText("");
        }
        if (size >= 2) {
            getBinding().textViewNum2.setAlpha(1.0f);
            getBinding().textViewPlayer2.setText(draftTable.getPlayers().get(1).getName());
        } else {
            getBinding().textViewNum2.setAlpha(0.35f);
            getBinding().textViewPlayer2.setText("");
        }
        if (size >= 3) {
            getBinding().textViewNum3.setAlpha(1.0f);
            getBinding().textViewPlayer3.setText(draftTable.getPlayers().get(2).getName());
        } else {
            getBinding().textViewNum3.setAlpha(0.35f);
            getBinding().textViewPlayer3.setText("");
        }
        if (size >= 4) {
            getBinding().textViewNum4.setAlpha(1.0f);
            getBinding().textViewPlayer4.setText(draftTable.getPlayers().get(3).getName());
        } else {
            getBinding().textViewNum4.setAlpha(0.35f);
            getBinding().textViewPlayer4.setText("");
        }
        if (size >= 5) {
            getBinding().textViewNum5.setAlpha(1.0f);
            getBinding().textViewPlayer5.setText(draftTable.getPlayers().get(4).getName());
        } else {
            getBinding().textViewNum5.setAlpha(0.35f);
            getBinding().textViewPlayer5.setText("");
        }
        if (size >= 6) {
            getBinding().textViewNum6.setAlpha(1.0f);
            getBinding().textViewPlayer6.setText(draftTable.getPlayers().get(5).getName());
        } else {
            getBinding().textViewNum6.setAlpha(0.35f);
            getBinding().textViewPlayer6.setText("");
        }
        if (size >= 7) {
            getBinding().textViewNum7.setAlpha(1.0f);
            getBinding().textViewPlayer7.setText(draftTable.getPlayers().get(6).getName());
        } else {
            getBinding().textViewNum7.setAlpha(0.35f);
            getBinding().textViewPlayer7.setText("");
        }
        if (size >= 8) {
            getBinding().textViewNum8.setAlpha(1.0f);
            getBinding().textViewPlayer8.setText(draftTable.getPlayers().get(7).getName());
        } else {
            getBinding().textViewNum8.setAlpha(0.35f);
            getBinding().textViewPlayer8.setText("");
        }
    }
}
