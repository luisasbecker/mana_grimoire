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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CreatePlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/CreatePlaygroupBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "callback", "Lcom/studiolaganne/lengendarylens/CreatePlaygroupCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "<init>", "(Lcom/studiolaganne/lengendarylens/CreatePlaygroupCallback;Lcom/studiolaganne/lengendarylens/MTUser;)V", "playgroupName", "", "getPlaygroupName", "()Ljava/lang/String;", "setPlaygroupName", "(Ljava/lang/String;)V", "playgroupDescription", "getPlaygroupDescription", "setPlaygroupDescription", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "updateSubmitButtonState", "submitButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "submitText", "Landroid/widget/TextView;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreatePlaygroupBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "CreatePlaygroupBottomSheetFragment";
    private final CreatePlaygroupCallback callback;
    private String playgroupDescription;
    private String playgroupName;
    private final MTUser user;
    public static final int $stable = 8;

    public CreatePlaygroupBottomSheetFragment(CreatePlaygroupCallback callback, MTUser user) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(user, "user");
        this.callback = callback;
        this.user = user;
        this.playgroupName = "";
        this.playgroupDescription = "";
    }

    static final Unit onViewCreated$lambda$0(CreatePlaygroupBottomSheetFragment createPlaygroupBottomSheetFragment) {
        createPlaygroupBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(CreatePlaygroupBottomSheetFragment createPlaygroupBottomSheetFragment, View view) {
        if (createPlaygroupBottomSheetFragment.getContext() != null && createPlaygroupBottomSheetFragment.playgroupName.length() != 0) {
            Context contextRequireContext = createPlaygroupBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new PreferencesManager(contextRequireContext);
            ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
            MTApiKt.getMtApi().createPlaygroup(createPlaygroupBottomSheetFragment.user.getId(), new MTCreatePlaygroup(createPlaygroupBottomSheetFragment.playgroupName, createPlaygroupBottomSheetFragment.playgroupDescription)).enqueue(new CreatePlaygroupBottomSheetFragment$onViewCreated$4$1(createPlaygroupBottomSheetFragment, view));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitButtonState(ConstraintLayout submitButton, TextView submitText) {
        submitButton.setEnabled(this.playgroupName.length() > 0);
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
        return inflater.inflate(R.layout.bottom_sheet_playgroup, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.playgroupName);
        TextView textView2 = (TextView) view.findViewById(R.id.playgroupDescription);
        View viewFindViewById = view.findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.createButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById2;
        updateSubmitButtonState(constraintLayout, textView3);
        textView.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreatePlaygroupBottomSheetFragment.onViewCreated.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreatePlaygroupBottomSheetFragment.this.setPlaygroupName(StringsKt.trim((CharSequence) String.valueOf(s)).toString());
                CreatePlaygroupBottomSheetFragment.this.updateSubmitButtonState(constraintLayout, textView3);
            }
        });
        textView2.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreatePlaygroupBottomSheetFragment.onViewCreated.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreatePlaygroupBottomSheetFragment.this.setPlaygroupDescription(StringsKt.trim((CharSequence) String.valueOf(s)).toString());
                CreatePlaygroupBottomSheetFragment.this.updateSubmitButtonState(constraintLayout, textView3);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.CreatePlaygroupBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreatePlaygroupBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById4 = view.findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.CreatePlaygroupBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreatePlaygroupBottomSheetFragment.onViewCreated$lambda$1(this.f$0, view);
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
