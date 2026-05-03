package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditPlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/EditPlaygroupBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "callback", "Lcom/studiolaganne/lengendarylens/EditPlaygroupCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "<init>", "(Lcom/studiolaganne/lengendarylens/EditPlaygroupCallback;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTPlaygroup;)V", "playgroupName", "", "getPlaygroupName", "()Ljava/lang/String;", "setPlaygroupName", "(Ljava/lang/String;)V", "playgroupDescription", "getPlaygroupDescription", "setPlaygroupDescription", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "updateSubmitButtonState", "submitButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "submitText", "Landroid/widget/TextView;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditPlaygroupBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "EditPlaygroupBottomSheetFragment";
    private final EditPlaygroupCallback callback;
    private final MTPlaygroup playgroup;
    private String playgroupDescription;
    private String playgroupName;
    private final MTUser user;
    public static final int $stable = 8;

    public EditPlaygroupBottomSheetFragment(EditPlaygroupCallback callback, MTUser user, MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        this.callback = callback;
        this.user = user;
        this.playgroup = playgroup;
        this.playgroupName = "";
        this.playgroupDescription = "";
    }

    static final Unit onViewCreated$lambda$0(EditPlaygroupBottomSheetFragment editPlaygroupBottomSheetFragment) {
        editPlaygroupBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(EditPlaygroupBottomSheetFragment editPlaygroupBottomSheetFragment, View view) {
        if (editPlaygroupBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        if (editPlaygroupBottomSheetFragment.playgroupName.length() == 0 || editPlaygroupBottomSheetFragment.playgroupDescription.length() == 0) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = editPlaygroupBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
        MTApiKt.getMtApi().editPlaygroup(editPlaygroupBottomSheetFragment.user.getId(), editPlaygroupBottomSheetFragment.playgroup.getId(), new MTCreatePlaygroup(editPlaygroupBottomSheetFragment.playgroupName, editPlaygroupBottomSheetFragment.playgroupDescription)).enqueue(new EditPlaygroupBottomSheetFragment$onViewCreated$4$1(editPlaygroupBottomSheetFragment, preferencesManager, view));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitButtonState(ConstraintLayout submitButton, TextView submitText) {
        submitButton.setEnabled(this.playgroupName.length() > 0 && this.playgroupDescription.length() > 0);
        if (submitButton.isEnabled()) {
            submitButton.setAlpha(1.0f);
            submitText.setAlpha(1.0f);
        } else {
            submitButton.setAlpha(0.5f);
            submitText.setAlpha(0.5f);
        }
    }

    public final String getPlaygroupDescription() {
        return this.playgroupDescription;
    }

    public final String getPlaygroupName() {
        return this.playgroupName;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_edit_playgroup, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.playgroupName);
        TextView textView2 = (TextView) view.findViewById(R.id.playgroupDescription);
        View viewFindViewById = view.findViewById(R.id.editButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.editButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById2;
        this.playgroupName = this.playgroup.getName();
        this.playgroupDescription = this.playgroup.getDescription();
        textView.setText(this.playgroupName);
        textView2.setText(this.playgroupDescription);
        updateSubmitButtonState(constraintLayout, textView3);
        textView.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.EditPlaygroupBottomSheetFragment.onViewCreated.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditPlaygroupBottomSheetFragment.this.setPlaygroupName(String.valueOf(s));
                EditPlaygroupBottomSheetFragment.this.updateSubmitButtonState(constraintLayout, textView3);
            }
        });
        textView2.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.EditPlaygroupBottomSheetFragment.onViewCreated.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditPlaygroupBottomSheetFragment.this.setPlaygroupDescription(String.valueOf(s));
                EditPlaygroupBottomSheetFragment.this.updateSubmitButtonState(constraintLayout, textView3);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.EditPlaygroupBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditPlaygroupBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById4 = view.findViewById(R.id.editButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.EditPlaygroupBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditPlaygroupBottomSheetFragment.onViewCreated$lambda$1(this.f$0, view);
            }
        });
    }

    public final void setPlaygroupDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playgroupDescription = str;
    }

    public final void setPlaygroupName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playgroupName = str;
    }
}
