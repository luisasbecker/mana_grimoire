package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatchCollectionStatusDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010/\u001a\u00020,H\u0016J&\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020,H\u0002J\b\u0010:\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020,H\u0002J\b\u0010<\u001a\u00020,H\u0002J\b\u0010=\u001a\u00020,H\u0002J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0002J2\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020\u00052\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020,0*H\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0010\u0010K\u001a\u00020,2\u0006\u0010J\u001a\u00020\u000bH\u0002J\b\u0010L\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020,H\u0002J\b\u0010O\u001a\u00020,H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "rootView", "Landroid/view/View;", "instructionsText2", "Landroid/widget/TextView;", "sameActionLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "applyToAllRadioButton", "Landroid/widget/RadioButton;", "collectionBasedActionLayout", "grabFromCollectionRadioButton", "applyToAllHeader", "addToCollectionLayout", "addToCollectionRadioButton", "makeAProxyLayout", "makeAProxyRadioButton", "forCardsIOwnHeader", "cardsIOwnActionLayout", "Landroid/widget/LinearLayout;", "cardsIOwnActionTextView", "forCardsIDontOwnHeader", "cardsIDontOwnActionLayout", "cardsIDontOwnActionTextView", "backImage", "Landroid/widget/ImageView;", "cancelButton", "Lcom/google/android/material/button/MaterialButton;", "saveButton", "initialChoice", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusInitialChoice;", "sameAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusSameAction;", "ownAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusOwnAction;", "dontOwnAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDontOwnAction;", "isUpdatingRadioButtons", "", "onResultListener", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogResult;", "", "actionPopupWindow", "Landroid/widget/PopupWindow;", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "initializeViews", "setupInitialState", "setupInitialChoiceListeners", "setupSameActionListeners", "setupCollectionBasedActionListeners", "showOwnActionPopupMenu", "showDontOwnActionPopupMenu", "showActionPopupWindow", "anchorView", FirebaseAnalytics.Param.ITEMS, "", "", "onItemSelected", "", "showSecondStepForSameAction", "showSecondStepForCollectionBased", "uncheckOtherInitialRadioButton", "selectedButton", "uncheckOtherSameActionRadioButton", "updateSaveButtonState", "setupButtons", "resetToInitialState", "onDestroyView", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchCollectionStatusDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private PopupWindow actionPopupWindow;
    private ConstraintLayout addToCollectionLayout;
    private RadioButton addToCollectionRadioButton;
    private TextView applyToAllHeader;
    private RadioButton applyToAllRadioButton;
    private ImageView backImage;
    private MaterialButton cancelButton;
    private LinearLayout cardsIDontOwnActionLayout;
    private TextView cardsIDontOwnActionTextView;
    private LinearLayout cardsIOwnActionLayout;
    private TextView cardsIOwnActionTextView;
    private ConstraintLayout collectionBasedActionLayout;
    private BatchCollectionStatusDontOwnAction dontOwnAction;
    private TextView forCardsIDontOwnHeader;
    private TextView forCardsIOwnHeader;
    private RadioButton grabFromCollectionRadioButton;
    private BatchCollectionStatusInitialChoice initialChoice;
    private TextView instructionsText2;
    private boolean isUpdatingRadioButtons;
    private ConstraintLayout makeAProxyLayout;
    private RadioButton makeAProxyRadioButton;
    private Function1<? super BatchCollectionStatusDialogResult, Unit> onResultListener;
    private BatchCollectionStatusOwnAction ownAction;
    private View rootView;
    private BatchCollectionStatusSameAction sameAction;
    private ConstraintLayout sameActionLayout;
    private MaterialButton saveButton;

    /* JADX INFO: compiled from: BatchCollectionStatusDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogFragment;", "setOnResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogResult;", "", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final BatchCollectionStatusDialogFragment dialogFragment = new BatchCollectionStatusDialogFragment();

        public final Builder setOnResultListener(Function1<? super BatchCollectionStatusDialogResult, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogFragment.onResultListener = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    /* JADX INFO: compiled from: BatchCollectionStatusDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BatchCollectionStatusInitialChoice.values().length];
            try {
                iArr[BatchCollectionStatusInitialChoice.SAME_ACTION_FOR_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BatchCollectionStatusInitialChoice.COLLECTION_BASED_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void initializeViews() {
        View view = this.rootView;
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.instructionsText2);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.instructionsText2 = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.backImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.backImage = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.cancelButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cancelButton = (MaterialButton) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.saveButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.saveButton = (MaterialButton) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.sameActionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.sameActionLayout = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.applyToAllRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.applyToAllRadioButton = (RadioButton) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.collectionBasedActionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.collectionBasedActionLayout = (ConstraintLayout) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.grabFromCollectionRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.grabFromCollectionRadioButton = (RadioButton) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.applyToAllHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.applyToAllHeader = (TextView) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.addToCollectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.addToCollectionLayout = (ConstraintLayout) viewFindViewById10;
            View viewFindViewById11 = view.findViewById(R.id.addToCollectionRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.addToCollectionRadioButton = (RadioButton) viewFindViewById11;
            View viewFindViewById12 = view.findViewById(R.id.makeAProxyLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.makeAProxyLayout = (ConstraintLayout) viewFindViewById12;
            View viewFindViewById13 = view.findViewById(R.id.makeAProxyRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.makeAProxyRadioButton = (RadioButton) viewFindViewById13;
            View viewFindViewById14 = view.findViewById(R.id.forCardsIOwnHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.forCardsIOwnHeader = (TextView) viewFindViewById14;
            View viewFindViewById15 = view.findViewById(R.id.cardsIOwnActionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            this.cardsIOwnActionLayout = (LinearLayout) viewFindViewById15;
            View viewFindViewById16 = view.findViewById(R.id.cardsIOwnActionTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            this.cardsIOwnActionTextView = (TextView) viewFindViewById16;
            View viewFindViewById17 = view.findViewById(R.id.forCardsIDontOwnHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            this.forCardsIDontOwnHeader = (TextView) viewFindViewById17;
            View viewFindViewById18 = view.findViewById(R.id.cardsIDontOwnActionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
            this.cardsIDontOwnActionLayout = (LinearLayout) viewFindViewById18;
            View viewFindViewById19 = view.findViewById(R.id.cardsIDontOwnActionTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
            this.cardsIDontOwnActionTextView = (TextView) viewFindViewById19;
        }
    }

    private final void resetToInitialState() {
        this.initialChoice = null;
        this.sameAction = null;
        this.ownAction = null;
        this.dontOwnAction = null;
        setupInitialState();
        updateSaveButtonState();
    }

    private final void setupButtons() {
        MaterialButton materialButton = this.cancelButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            materialButton = null;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupButtons$lambda$0(this.f$0);
            }
        });
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupButtons$lambda$1(this.f$0);
            }
        });
        MaterialButton materialButton3 = this.saveButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton2 = materialButton3;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupButtons$lambda$2(this.f$0);
            }
        });
    }

    static final Unit setupButtons$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        batchCollectionStatusDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$1(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        batchCollectionStatusDialogFragment.resetToInitialState();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$2(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        MaterialButton materialButton = batchCollectionStatusDialogFragment.saveButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        if (!materialButton.isEnabled()) {
            return Unit.INSTANCE;
        }
        BatchCollectionStatusInitialChoice batchCollectionStatusInitialChoice = batchCollectionStatusDialogFragment.initialChoice;
        Intrinsics.checkNotNull(batchCollectionStatusInitialChoice);
        BatchCollectionStatusDialogResult batchCollectionStatusDialogResult = new BatchCollectionStatusDialogResult(batchCollectionStatusInitialChoice, batchCollectionStatusDialogFragment.sameAction, batchCollectionStatusDialogFragment.ownAction, batchCollectionStatusDialogFragment.dontOwnAction);
        Function1<? super BatchCollectionStatusDialogResult, Unit> function1 = batchCollectionStatusDialogFragment.onResultListener;
        if (function1 != null) {
            function1.invoke(batchCollectionStatusDialogResult);
        }
        batchCollectionStatusDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupCollectionBasedActionListeners() {
        LinearLayout linearLayout = this.cardsIOwnActionLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionLayout");
            linearLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupCollectionBasedActionListeners$lambda$0(this.f$0);
            }
        });
        LinearLayout linearLayout3 = this.cardsIDontOwnActionLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionLayout");
        } else {
            linearLayout2 = linearLayout3;
        }
        ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupCollectionBasedActionListeners$lambda$1(this.f$0);
            }
        });
    }

    static final Unit setupCollectionBasedActionListeners$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        batchCollectionStatusDialogFragment.showOwnActionPopupMenu();
        return Unit.INSTANCE;
    }

    static final Unit setupCollectionBasedActionListeners$lambda$1(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        batchCollectionStatusDialogFragment.showDontOwnActionPopupMenu();
        return Unit.INSTANCE;
    }

    private final void setupInitialChoiceListeners() {
        RadioButton radioButton = this.applyToAllRadioButton;
        ConstraintLayout constraintLayout = null;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllRadioButton");
            radioButton = null;
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BatchCollectionStatusDialogFragment.setupInitialChoiceListeners$lambda$0(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout2 = this.sameActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameActionLayout");
            constraintLayout2 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupInitialChoiceListeners$lambda$1(this.f$0);
            }
        });
        RadioButton radioButton2 = this.grabFromCollectionRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton2 = null;
        }
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BatchCollectionStatusDialogFragment.setupInitialChoiceListeners$lambda$2(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout3 = this.collectionBasedActionLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionBasedActionLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupInitialChoiceListeners$lambda$3(this.f$0);
            }
        });
    }

    static final void setupInitialChoiceListeners$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || batchCollectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = batchCollectionStatusDialogFragment.applyToAllRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllRadioButton");
            radioButton = null;
        }
        batchCollectionStatusDialogFragment.uncheckOtherInitialRadioButton(radioButton);
        batchCollectionStatusDialogFragment.initialChoice = BatchCollectionStatusInitialChoice.SAME_ACTION_FOR_ALL;
        batchCollectionStatusDialogFragment.showSecondStepForSameAction();
        batchCollectionStatusDialogFragment.updateSaveButtonState();
    }

    static final Unit setupInitialChoiceListeners$lambda$1(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        RadioButton radioButton = batchCollectionStatusDialogFragment.applyToAllRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
        return Unit.INSTANCE;
    }

    static final void setupInitialChoiceListeners$lambda$2(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || batchCollectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = batchCollectionStatusDialogFragment.grabFromCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton = null;
        }
        batchCollectionStatusDialogFragment.uncheckOtherInitialRadioButton(radioButton);
        batchCollectionStatusDialogFragment.initialChoice = BatchCollectionStatusInitialChoice.COLLECTION_BASED_ACTION;
        batchCollectionStatusDialogFragment.showSecondStepForCollectionBased();
        batchCollectionStatusDialogFragment.updateSaveButtonState();
    }

    static final Unit setupInitialChoiceListeners$lambda$3(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        RadioButton radioButton = batchCollectionStatusDialogFragment.grabFromCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
        return Unit.INSTANCE;
    }

    private final void setupInitialState() {
        MaterialButton materialButton = this.saveButton;
        TextView textView = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        materialButton.setText(getString(R.string.next_no_caps));
        MaterialButton materialButton2 = this.saveButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton2 = null;
        }
        materialButton2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        MaterialButton materialButton3 = this.saveButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton3 = null;
        }
        materialButton3.setEnabled(false);
        TextView textView2 = this.instructionsText2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructionsText2");
            textView2 = null;
        }
        textView2.setVisibility(0);
        ConstraintLayout constraintLayout = this.sameActionLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameActionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = this.collectionBasedActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionBasedActionLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(0);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(8);
        TextView textView3 = this.applyToAllHeader;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllHeader");
            textView3 = null;
        }
        textView3.setVisibility(8);
        ConstraintLayout constraintLayout3 = this.addToCollectionLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout3 = null;
        }
        constraintLayout3.setVisibility(8);
        ConstraintLayout constraintLayout4 = this.makeAProxyLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setVisibility(8);
        TextView textView4 = this.forCardsIOwnHeader;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forCardsIOwnHeader");
            textView4 = null;
        }
        textView4.setVisibility(8);
        LinearLayout linearLayout = this.cardsIOwnActionLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView5 = this.forCardsIDontOwnHeader;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forCardsIDontOwnHeader");
            textView5 = null;
        }
        textView5.setVisibility(8);
        LinearLayout linearLayout2 = this.cardsIDontOwnActionLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        RadioButton radioButton = this.applyToAllRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(false);
        RadioButton radioButton2 = this.grabFromCollectionRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton2 = null;
        }
        radioButton2.setChecked(false);
        RadioButton radioButton3 = this.addToCollectionRadioButton;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton3 = null;
        }
        radioButton3.setChecked(false);
        RadioButton radioButton4 = this.makeAProxyRadioButton;
        if (radioButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton4 = null;
        }
        radioButton4.setChecked(false);
        TextView textView6 = this.cardsIOwnActionTextView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
            textView6 = null;
        }
        textView6.setText(getString(R.string.action_select));
        TextView textView7 = this.cardsIOwnActionTextView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
            textView7 = null;
        }
        textView7.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
        TextView textView8 = this.cardsIDontOwnActionTextView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
            textView8 = null;
        }
        textView8.setText(getString(R.string.action_select));
        TextView textView9 = this.cardsIDontOwnActionTextView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
        } else {
            textView = textView9;
        }
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
    }

    private final void setupSameActionListeners() {
        RadioButton radioButton = this.addToCollectionRadioButton;
        ConstraintLayout constraintLayout = null;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BatchCollectionStatusDialogFragment.setupSameActionListeners$lambda$0(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout2 = this.addToCollectionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout2 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupSameActionListeners$lambda$1(this.f$0);
            }
        });
        RadioButton radioButton2 = this.makeAProxyRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton2 = null;
        }
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BatchCollectionStatusDialogFragment.setupSameActionListeners$lambda$2(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout3 = this.makeAProxyLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BatchCollectionStatusDialogFragment.setupSameActionListeners$lambda$3(this.f$0);
            }
        });
    }

    static final void setupSameActionListeners$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || batchCollectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = batchCollectionStatusDialogFragment.addToCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        batchCollectionStatusDialogFragment.uncheckOtherSameActionRadioButton(radioButton);
        batchCollectionStatusDialogFragment.sameAction = BatchCollectionStatusSameAction.ADD_TO_COLLECTION;
        batchCollectionStatusDialogFragment.updateSaveButtonState();
    }

    static final Unit setupSameActionListeners$lambda$1(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        RadioButton radioButton = batchCollectionStatusDialogFragment.addToCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
        return Unit.INSTANCE;
    }

    static final void setupSameActionListeners$lambda$2(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || batchCollectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = batchCollectionStatusDialogFragment.makeAProxyRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton = null;
        }
        batchCollectionStatusDialogFragment.uncheckOtherSameActionRadioButton(radioButton);
        batchCollectionStatusDialogFragment.sameAction = BatchCollectionStatusSameAction.MAKE_PROXY;
        batchCollectionStatusDialogFragment.updateSaveButtonState();
    }

    static final Unit setupSameActionListeners$lambda$3(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment) {
        RadioButton radioButton = batchCollectionStatusDialogFragment.makeAProxyRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
        return Unit.INSTANCE;
    }

    private final void showActionPopupWindow(View anchorView, List<String> items, final Function1<? super Integer, Unit> onItemSelected) {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.popup_action_menu, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.action_list);
        listView.setAdapter((ListAdapter) new ArrayAdapter(requireContext(), R.layout.popup_menu_item_multiline, android.R.id.text1, items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                BatchCollectionStatusDialogFragment.showActionPopupWindow$lambda$0(onItemSelected, this, adapterView, view, i, j);
            }
        });
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        this.actionPopupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow2 = this.actionPopupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setOutsideTouchable(true);
        }
        PopupWindow popupWindow3 = this.actionPopupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setFocusable(true);
        }
        PopupWindow popupWindow4 = this.actionPopupWindow;
        if (popupWindow4 != null) {
            popupWindow4.showAsDropDown(anchorView, 0, 0);
        }
    }

    static final void showActionPopupWindow$lambda$0(Function1 function1, BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, AdapterView adapterView, View view, int i, long j) {
        function1.invoke(Integer.valueOf(i));
        PopupWindow popupWindow = batchCollectionStatusDialogFragment.actionPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        batchCollectionStatusDialogFragment.actionPopupWindow = null;
    }

    private final void showDontOwnActionPopupMenu() {
        final List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.batch_action_add_to_collection), getString(R.string.batch_action_mark_proxy), getString(R.string.batch_action_do_nothing_dont_own)});
        LinearLayout linearLayout = this.cardsIDontOwnActionLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionLayout");
            linearLayout = null;
        }
        showActionPopupWindow(linearLayout, listListOf, new Function1() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatchCollectionStatusDialogFragment.showDontOwnActionPopupMenu$lambda$0(this.f$0, listListOf, ((Integer) obj).intValue());
            }
        });
    }

    static final Unit showDontOwnActionPopupMenu$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, List list, int i) {
        TextView textView = null;
        if (i == 0) {
            batchCollectionStatusDialogFragment.dontOwnAction = BatchCollectionStatusDontOwnAction.ADD_TO_COLLECTION;
            TextView textView2 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
                textView2 = null;
            }
            textView2.setText((CharSequence) list.get(0));
            TextView textView3 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
            } else {
                textView = textView3;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        } else if (i == 1) {
            batchCollectionStatusDialogFragment.dontOwnAction = BatchCollectionStatusDontOwnAction.MARK_PROXY;
            TextView textView4 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
                textView4 = null;
            }
            textView4.setText((CharSequence) list.get(1));
            TextView textView5 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
            } else {
                textView = textView5;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        } else if (i == 2) {
            batchCollectionStatusDialogFragment.dontOwnAction = BatchCollectionStatusDontOwnAction.DO_NOTHING;
            TextView textView6 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
                textView6 = null;
            }
            textView6.setText((CharSequence) list.get(2));
            TextView textView7 = batchCollectionStatusDialogFragment.cardsIDontOwnActionTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionTextView");
            } else {
                textView = textView7;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        }
        batchCollectionStatusDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    private final void showOwnActionPopupMenu() {
        final List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.batch_action_grab_exact_match), getString(R.string.batch_action_grab_partial_match), getString(R.string.batch_action_do_nothing_own)});
        LinearLayout linearLayout = this.cardsIOwnActionLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionLayout");
            linearLayout = null;
        }
        showActionPopupWindow(linearLayout, listListOf, new Function1() { // from class: com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatchCollectionStatusDialogFragment.showOwnActionPopupMenu$lambda$0(this.f$0, listListOf, ((Integer) obj).intValue());
            }
        });
    }

    static final Unit showOwnActionPopupMenu$lambda$0(BatchCollectionStatusDialogFragment batchCollectionStatusDialogFragment, List list, int i) {
        TextView textView = null;
        if (i == 0) {
            batchCollectionStatusDialogFragment.ownAction = BatchCollectionStatusOwnAction.GRAB_EXACT_MATCH;
            TextView textView2 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
                textView2 = null;
            }
            textView2.setText((CharSequence) list.get(0));
            TextView textView3 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
            } else {
                textView = textView3;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        } else if (i == 1) {
            batchCollectionStatusDialogFragment.ownAction = BatchCollectionStatusOwnAction.GRAB_PARTIAL_MATCH;
            TextView textView4 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
                textView4 = null;
            }
            textView4.setText((CharSequence) list.get(1));
            TextView textView5 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
            } else {
                textView = textView5;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        } else if (i == 2) {
            batchCollectionStatusDialogFragment.ownAction = BatchCollectionStatusOwnAction.DO_NOTHING;
            TextView textView6 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
                textView6 = null;
            }
            textView6.setText((CharSequence) list.get(2));
            TextView textView7 = batchCollectionStatusDialogFragment.cardsIOwnActionTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionTextView");
            } else {
                textView = textView7;
            }
            textView.setTextColor(ContextCompat.getColor(batchCollectionStatusDialogFragment.requireContext(), R.color.almost_white));
        }
        batchCollectionStatusDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    private final void showSecondStepForCollectionBased() {
        TextView textView = this.instructionsText2;
        MaterialButton materialButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructionsText2");
            textView = null;
        }
        textView.setVisibility(8);
        ConstraintLayout constraintLayout = this.sameActionLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameActionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.collectionBasedActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionBasedActionLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(8);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(0);
        TextView textView2 = this.forCardsIOwnHeader;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forCardsIOwnHeader");
            textView2 = null;
        }
        textView2.setVisibility(0);
        LinearLayout linearLayout = this.cardsIOwnActionLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIOwnActionLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView3 = this.forCardsIDontOwnHeader;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forCardsIDontOwnHeader");
            textView3 = null;
        }
        textView3.setVisibility(0);
        LinearLayout linearLayout2 = this.cardsIDontOwnActionLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsIDontOwnActionLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        MaterialButton materialButton2 = this.saveButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton = materialButton2;
        }
        materialButton.setText(getString(R.string.apply));
    }

    private final void showSecondStepForSameAction() {
        TextView textView = this.instructionsText2;
        MaterialButton materialButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructionsText2");
            textView = null;
        }
        textView.setVisibility(8);
        ConstraintLayout constraintLayout = this.sameActionLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameActionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.collectionBasedActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionBasedActionLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(8);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(0);
        TextView textView2 = this.applyToAllHeader;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyToAllHeader");
            textView2 = null;
        }
        textView2.setVisibility(0);
        ConstraintLayout constraintLayout3 = this.addToCollectionLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout3 = null;
        }
        constraintLayout3.setVisibility(0);
        ConstraintLayout constraintLayout4 = this.makeAProxyLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setVisibility(0);
        MaterialButton materialButton2 = this.saveButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton = materialButton2;
        }
        materialButton.setText(getString(R.string.apply));
    }

    private final void uncheckOtherInitialRadioButton(RadioButton selectedButton) {
        this.isUpdatingRadioButtons = true;
        try {
            RadioButton[] radioButtonArr = new RadioButton[2];
            RadioButton radioButton = this.applyToAllRadioButton;
            RadioButton radioButton2 = null;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applyToAllRadioButton");
                radioButton = null;
            }
            radioButtonArr[0] = radioButton;
            RadioButton radioButton3 = this.grabFromCollectionRadioButton;
            if (radioButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            } else {
                radioButton2 = radioButton3;
            }
            radioButtonArr[1] = radioButton2;
            List listListOf = CollectionsKt.listOf((Object[]) radioButtonArr);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                RadioButton radioButton4 = (RadioButton) obj;
                if (!Intrinsics.areEqual(radioButton4, selectedButton) && radioButton4.isChecked()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((RadioButton) it.next()).setChecked(false);
            }
        } finally {
            this.isUpdatingRadioButtons = false;
        }
    }

    private final void uncheckOtherSameActionRadioButton(RadioButton selectedButton) {
        this.isUpdatingRadioButtons = true;
        try {
            RadioButton[] radioButtonArr = new RadioButton[2];
            RadioButton radioButton = this.addToCollectionRadioButton;
            RadioButton radioButton2 = null;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
                radioButton = null;
            }
            radioButtonArr[0] = radioButton;
            RadioButton radioButton3 = this.makeAProxyRadioButton;
            if (radioButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            } else {
                radioButton2 = radioButton3;
            }
            radioButtonArr[1] = radioButton2;
            List listListOf = CollectionsKt.listOf((Object[]) radioButtonArr);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                RadioButton radioButton4 = (RadioButton) obj;
                if (!Intrinsics.areEqual(radioButton4, selectedButton) && radioButton4.isChecked()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((RadioButton) it.next()).setChecked(false);
            }
        } finally {
            this.isUpdatingRadioButtons = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSaveButtonState() {
        BatchCollectionStatusInitialChoice batchCollectionStatusInitialChoice = this.initialChoice;
        int i = batchCollectionStatusInitialChoice == null ? -1 : WhenMappings.$EnumSwitchMapping$0[batchCollectionStatusInitialChoice.ordinal()];
        boolean z = false;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.ownAction != null && this.dontOwnAction != null) {
                    z = true;
                }
            } else if (this.sameAction != null) {
            }
        }
        MaterialButton materialButton = this.saveButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        materialButton.setEnabled(z);
        int color = z ? ContextCompat.getColor(requireContext(), R.color.almost_white) : ContextCompat.getColor(requireContext(), R.color.text_color);
        MaterialButton materialButton3 = this.saveButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton2 = materialButton3;
        }
        materialButton2.setTextColor(color);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_batch_collection_status, container, false);
        this.rootView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.rootView = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.85d));
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initializeViews();
        setupInitialState();
        setupInitialChoiceListeners();
        setupSameActionListeners();
        setupCollectionBasedActionListeners();
        setupButtons();
    }
}
