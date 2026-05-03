package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImportConfirmationDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000bH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportConfirmationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "containers", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "selectedContainers", "", "onConfirm", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", ViewHierarchyConstants.VIEW_KEY, "addSectionHeader", "parent", "Landroid/widget/LinearLayout;", "text", "", "addContainerCheckbox", "updateImportButtonText", "button", "Lcom/google/android/material/button/MaterialButton;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImportConfirmationDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> onCancel;
    private Function1<? super List<MTCardContainer>, Unit> onConfirm;
    private List<MTCardContainer> containers = CollectionsKt.emptyList();
    private final Set<MTCardContainer> selectedContainers = new LinkedHashSet();

    /* JADX INFO: compiled from: ImportConfirmationDialogFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ \u0010\n\u001a\u00020\u00002\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportConfirmationDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/ImportConfirmationDialogFragment;", "setContainers", "containers", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setOnConfirm", "callback", "Lkotlin/Function1;", "", "setOnCancel", "Lkotlin/Function0;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final ImportConfirmationDialogFragment dialogFragment = new ImportConfirmationDialogFragment();

        public final Builder setContainers(List<MTCardContainer> containers) {
            Intrinsics.checkNotNullParameter(containers, "containers");
            this.dialogFragment.containers = containers;
            return this;
        }

        public final Builder setOnCancel(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onCancel = callback;
            return this;
        }

        public final Builder setOnConfirm(Function1<? super List<MTCardContainer>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onConfirm = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    private final void addContainerCheckbox(LinearLayout parent, final MTCardContainer container) {
        int iIntValue;
        List<MTFullCard> cards = container.getCards();
        if (cards != null) {
            Iterator<T> it = cards.iterator();
            iIntValue = 0;
            while (it.hasNext()) {
                Integer quantity = ((MTFullCard) it.next()).getQuantity();
                iIntValue += quantity != null ? quantity.intValue() : 1;
            }
        } else {
            iIntValue = 0;
        }
        String str = container.getName() + ": " + iIntValue + " " + getString(iIntValue == 1 ? R.string.card : R.string.cards);
        CheckBox checkBox = new CheckBox(requireContext());
        checkBox.setText(str);
        checkBox.setChecked(true);
        checkBox.setPadding(32, 8, 0, 8);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ImportConfirmationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ImportConfirmationDialogFragment.addContainerCheckbox$lambda$1$0(this.f$0, container, compoundButton, z);
            }
        });
        parent.addView(checkBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addContainerCheckbox$lambda$1$0(ImportConfirmationDialogFragment importConfirmationDialogFragment, MTCardContainer mTCardContainer, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            importConfirmationDialogFragment.selectedContainers.add(mTCardContainer);
        } else {
            importConfirmationDialogFragment.selectedContainers.remove(mTCardContainer);
        }
        View view = importConfirmationDialogFragment.getView();
        importConfirmationDialogFragment.updateImportButtonText(view != null ? (MaterialButton) view.findViewById(R.id.positive_button) : null);
    }

    private final void addSectionHeader(LinearLayout parent, String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setTextSize(16.0f);
        textView.setTypeface(null, 1);
        textView.setPadding(0, 16, 0, 8);
        parent.addView(textView);
    }

    private final void setupViews(View view) {
        int i;
        List<MTFullCard> cards;
        Object next;
        int iIntValue;
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.summary);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.containers_layout);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.negative_button);
        textView.setText(getString(R.string.import_confirmation_title));
        Iterator<T> it = this.containers.iterator();
        int iIntValue2 = 0;
        int i2 = 0;
        while (it.hasNext()) {
            List<MTFullCard> cards2 = ((MTCardContainer) it.next()).getCards();
            if (cards2 != null) {
                Iterator<T> it2 = cards2.iterator();
                iIntValue = 0;
                while (it2.hasNext()) {
                    Integer quantity = ((MTFullCard) it2.next()).getQuantity();
                    iIntValue += quantity != null ? quantity.intValue() : 1;
                }
            } else {
                iIntValue = 0;
            }
            i2 += iIntValue;
        }
        List<MTCardContainer> list = this.containers;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (MTCardContainer mTCardContainer : list) {
                if (mTCardContainer.getId() != 4 || (mTCardContainer.getId() == 4 && (cards = mTCardContainer.getCards()) != null && (!cards.isEmpty()))) {
                    i++;
                    if (i < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        textView2.setText(getString(R.string.import_confirmation_summary, Integer.valueOf(i2), Integer.valueOf(i)));
        List<MTCardContainer> list2 = this.containers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            MTCardContainer mTCardContainer2 = (MTCardContainer) obj;
            Integer type = mTCardContainer2.getType();
            if (type != null && type.intValue() == 2 && mTCardContainer2.getId() != 4) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<MTCardContainer> list3 = this.containers;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list3) {
            Integer type2 = ((MTCardContainer) obj2).getType();
            if (type2 != null && type2.intValue() == 1) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        List<MTCardContainer> list4 = this.containers;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list4) {
            Integer type3 = ((MTCardContainer) obj3).getType();
            if (type3 != null && type3.intValue() == 0) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = arrayList5;
        Iterator<T> it3 = this.containers.iterator();
        while (true) {
            if (it3.hasNext()) {
                next = it3.next();
                if (((MTCardContainer) next).getId() == 4) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTCardContainer mTCardContainer3 = (MTCardContainer) next;
        this.selectedContainers.addAll(this.containers);
        if (!arrayList2.isEmpty()) {
            Intrinsics.checkNotNull(linearLayout);
            addSectionHeader(linearLayout, "📦 " + getString(R.string.boxes_header));
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                addContainerCheckbox(linearLayout, (MTCardContainer) it4.next());
            }
        }
        if (!arrayList4.isEmpty()) {
            Intrinsics.checkNotNull(linearLayout);
            addSectionHeader(linearLayout, "📒 " + getString(R.string.binders_header));
            Iterator it5 = arrayList4.iterator();
            while (it5.hasNext()) {
                addContainerCheckbox(linearLayout, (MTCardContainer) it5.next());
            }
        }
        if (!arrayList6.isEmpty()) {
            Intrinsics.checkNotNull(linearLayout);
            addSectionHeader(linearLayout, "📝 " + getString(R.string.lists_header));
            Iterator it6 = arrayList6.iterator();
            while (it6.hasNext()) {
                addContainerCheckbox(linearLayout, (MTCardContainer) it6.next());
            }
        }
        if (mTCardContainer3 != null) {
            List<MTFullCard> cards3 = mTCardContainer3.getCards();
            if (cards3 != null) {
                Iterator<T> it7 = cards3.iterator();
                while (it7.hasNext()) {
                    Integer quantity2 = ((MTFullCard) it7.next()).getQuantity();
                    iIntValue2 += quantity2 != null ? quantity2.intValue() : 1;
                }
            }
            if (iIntValue2 > 0) {
                Intrinsics.checkNotNull(linearLayout);
                addSectionHeader(linearLayout, "🗃️ " + getString(R.string.bulk_header));
                addContainerCheckbox(linearLayout, mTCardContainer3);
            }
        }
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportConfirmationDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportConfirmationDialogFragment.setupViews$lambda$10(this.f$0);
            }
        });
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportConfirmationDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportConfirmationDialogFragment.setupViews$lambda$11(this.f$0);
            }
        });
        updateImportButtonText(materialButton);
    }

    static final Unit setupViews$lambda$10(ImportConfirmationDialogFragment importConfirmationDialogFragment) {
        Function1<? super List<MTCardContainer>, Unit> function1 = importConfirmationDialogFragment.onConfirm;
        if (function1 != null) {
            function1.invoke(CollectionsKt.toList(importConfirmationDialogFragment.selectedContainers));
        }
        importConfirmationDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupViews$lambda$11(ImportConfirmationDialogFragment importConfirmationDialogFragment) {
        Function0<Unit> function0 = importConfirmationDialogFragment.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
        importConfirmationDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void updateImportButtonText(MaterialButton button) {
        int iIntValue;
        if (button != null) {
            int size = this.selectedContainers.size();
            int size2 = this.containers.size();
            Iterator<T> it = this.selectedContainers.iterator();
            int i = 0;
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
                if (cards != null) {
                    Iterator<T> it2 = cards.iterator();
                    iIntValue = 0;
                    while (it2.hasNext()) {
                        Integer quantity = ((MTFullCard) it2.next()).getQuantity();
                        iIntValue += quantity != null ? quantity.intValue() : 1;
                    }
                } else {
                    iIntValue = 0;
                }
                i += iIntValue;
            }
            boolean z = size > 0;
            button.setEnabled(z);
            button.setAlpha(z ? 1.0f : 0.4f);
            String string = (size != size2 && z) ? getString(R.string.import_action_button) + " (" + i + " " + getString(R.string.cards) + ")" : getString(R.string.import_action_button);
            button.setText(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_import_confirmation, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Intrinsics.checkNotNull(viewInflate);
        setupViews(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ScrollView scrollView;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        }
        View view = getView();
        if (view == null || (scrollView = (ScrollView) view.findViewById(R.id.scroll_view)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.4d);
        } else {
            layoutParams = null;
        }
        scrollView.setLayoutParams(layoutParams);
    }
}
