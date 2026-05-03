package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.ChoosePlaygroupDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChoosePlaygroupDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R,\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/ChoosePlaygroupDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/studiolaganne/lengendarylens/PlaygroupChooserClickListener;", "<init>", "()V", "playgroupCallback", "Lkotlin/Function2;", "", "", "getPlaygroupCallback", "()Lkotlin/jvm/functions/Function2;", "setPlaygroupCallback", "(Lkotlin/jvm/functions/Function2;)V", "onPlaygroupSelected", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChoosePlaygroupDialogFragment extends DialogFragment implements PlaygroupChooserClickListener {
    public static final int $stable = 8;
    public Function2<? super Integer, ? super ChoosePlaygroupDialogFragment, Unit> playgroupCallback;

    /* JADX INFO: compiled from: ChoosePlaygroupDialogFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/ChoosePlaygroupDialogFragment$Builder;", "", "<init>", "()V", "playgroupCallback", "Lkotlin/Function2;", "", "Lcom/studiolaganne/lengendarylens/ChoosePlaygroupDialogFragment;", "", "setPlaygroupCallback", "callback", "build", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Function2<? super Integer, ? super ChoosePlaygroupDialogFragment, Unit> playgroupCallback = new Function2() { // from class: com.studiolaganne.lengendarylens.ChoosePlaygroupDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ChoosePlaygroupDialogFragment.Builder.playgroupCallback$lambda$0(((Integer) obj).intValue(), (ChoosePlaygroupDialogFragment) obj2);
            }
        };

        static final Unit playgroupCallback$lambda$0(int i, ChoosePlaygroupDialogFragment choosePlaygroupDialogFragment) {
            Intrinsics.checkNotNullParameter(choosePlaygroupDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final ChoosePlaygroupDialogFragment build() {
            ChoosePlaygroupDialogFragment choosePlaygroupDialogFragment = new ChoosePlaygroupDialogFragment();
            Function2<? super Integer, ? super ChoosePlaygroupDialogFragment, Unit> function2 = this.playgroupCallback;
            Intrinsics.checkNotNull(function2);
            choosePlaygroupDialogFragment.setPlaygroupCallback(function2);
            return choosePlaygroupDialogFragment;
        }

        public final Builder setPlaygroupCallback(Function2<? super Integer, ? super ChoosePlaygroupDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.playgroupCallback = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$1(ChoosePlaygroupDialogFragment choosePlaygroupDialogFragment) {
        choosePlaygroupDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    public final Function2<Integer, ChoosePlaygroupDialogFragment, Unit> getPlaygroupCallback() {
        Function2 function2 = this.playgroupCallback;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playgroupCallback");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_choose_playgroup, container, false);
        setCancelable(false);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<MTPlaygroup> currentUserPlaygroups = new PreferencesManager(contextRequireContext).getCurrentUserPlaygroups();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserPlaygroups) {
            if (((MTPlaygroup) obj).getUsers().size() > 1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.playgroupsRecyclerView);
        PlaygroupChooserAdapter playgroupChooserAdapter = new PlaygroupChooserAdapter(arrayList2, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(playgroupChooserAdapter);
        if (arrayList2.isEmpty()) {
            ((TextView) viewInflate.findViewById(R.id.no_playgroups_text)).setVisibility(0);
            ((TextView) viewInflate.findViewById(R.id.no_playgroups_text_2)).setVisibility(0);
        } else {
            ((TextView) viewInflate.findViewById(R.id.no_playgroups_text)).setVisibility(8);
            ((TextView) viewInflate.findViewById(R.id.no_playgroups_text_2)).setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ChoosePlaygroupDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChoosePlaygroupDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupChooserClickListener
    public void onPlaygroupSelected(MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        getPlaygroupCallback().invoke(Integer.valueOf(playgroup.getId()), this);
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

    public final void setPlaygroupCallback(Function2<? super Integer, ? super ChoosePlaygroupDialogFragment, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.playgroupCallback = function2;
    }
}
