package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionRestoreDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010!\u001a\u00020\u0011H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\n\u0010.\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\b\u00101\u001a\u00020\u0011H\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "rootView", "Landroid/view/View;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentCardIndex", "", "results", "", "Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogResult;", "onResultListener", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MultiCardCollectionRestoreDialogResult;", "", "currentCardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "cardName", "Landroid/widget/TextView;", "setCodeTextView", "collectorNumberTextView", "progressHeader", "restoreToCollectionLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "restoreToCollectionRadioButton", "Landroid/widget/RadioButton;", "cancelButton", "Lcom/google/android/material/button/MaterialButton;", "previousButton", "saveButton", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "initializeViews", "setupProgressHeader", "setupCardInfo", "getCurrentCard", "setupButtons", "saveCurrentChoice", "goToNextCard", "goToPreviousCard", "updateButtonStates", "updateSaveButtonState", "onDestroyView", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionRestoreDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private MaterialButton cancelButton;
    private TextView cardName;
    private TextView collectorNumberTextView;
    private LoadingImageView currentCardImage;
    private int currentCardIndex;
    private Function1<? super MultiCardCollectionRestoreDialogResult, Unit> onResultListener;
    private MaterialButton previousButton;
    private TextView progressHeader;
    private ConstraintLayout restoreToCollectionLayout;
    private RadioButton restoreToCollectionRadioButton;
    private View rootView;
    private MaterialButton saveButton;
    private TextView setCodeTextView;
    private List<MTFullCard> cards = CollectionsKt.emptyList();
    private List<CollectionRestoreDialogResult> results = new ArrayList();

    /* JADX INFO: compiled from: CollectionRestoreDialogFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogFragment;", "setCard", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "setCards", "cards", "", "setOnResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MultiCardCollectionRestoreDialogResult;", "", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CollectionRestoreDialogFragment dialogFragment = new CollectionRestoreDialogFragment();

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.dialogFragment.cards = CollectionsKt.listOf(card);
            this.dialogFragment.currentCardIndex = 0;
            return this;
        }

        public final Builder setCards(List<MTFullCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.cards = cards;
            this.dialogFragment.currentCardIndex = 0;
            return this;
        }

        public final Builder setOnResultListener(Function1<? super MultiCardCollectionRestoreDialogResult, Unit> listener) {
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

    private final MTFullCard getCurrentCard() {
        if (this.currentCardIndex < this.cards.size()) {
            return this.cards.get(this.currentCardIndex);
        }
        return null;
    }

    private final void goToNextCard() {
        saveCurrentChoice();
        int i = this.currentCardIndex + 1;
        this.currentCardIndex = i;
        if (i < this.results.size()) {
            this.results.get(this.currentCardIndex);
        }
        setupProgressHeader();
        setupCardInfo();
        setupButtons();
        updateButtonStates();
    }

    private final void goToPreviousCard() {
        saveCurrentChoice();
        this.currentCardIndex--;
        setupProgressHeader();
        setupCardInfo();
        setupButtons();
        updateButtonStates();
    }

    private final void initializeViews() {
        View view = this.rootView;
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.currentCardImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.currentCardImage = (LoadingImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.cardName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.cardName = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.setCodeTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.setCodeTextView = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.collectorNumberTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.collectorNumberTextView = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.progressHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.progressHeader = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.restoreToCollectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.restoreToCollectionLayout = (ConstraintLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.restoreToCollectionRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.restoreToCollectionRadioButton = (RadioButton) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.cancelButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.cancelButton = (MaterialButton) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.previousButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.previousButton = (MaterialButton) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.saveButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.saveButton = (MaterialButton) viewFindViewById10;
        }
    }

    private final void saveCurrentChoice() {
        MTFullCard currentCard = getCurrentCard();
        if (currentCard != null) {
            RadioButton radioButton = this.restoreToCollectionRadioButton;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionRadioButton");
                radioButton = null;
            }
            CollectionRestoreDialogResult collectionRestoreDialogResult = new CollectionRestoreDialogResult(radioButton.isChecked(), currentCard.getList_card_id());
            int i = this.currentCardIndex;
            int size = this.results.size();
            List<CollectionRestoreDialogResult> list = this.results;
            if (i < size) {
                list.set(this.currentCardIndex, collectionRestoreDialogResult);
            } else {
                list.add(collectionRestoreDialogResult);
            }
        }
    }

    private final void setupButtons() {
        MaterialButton materialButton = null;
        CollectionRestoreDialogResult collectionRestoreDialogResult = this.currentCardIndex < this.results.size() ? this.results.get(this.currentCardIndex) : null;
        boolean shouldRestore = collectionRestoreDialogResult != null ? collectionRestoreDialogResult.getShouldRestore() : false;
        RadioButton radioButton = this.restoreToCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(shouldRestore);
        RadioButton radioButton2 = this.restoreToCollectionRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionRadioButton");
            radioButton2 = null;
        }
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CollectionRestoreDialogFragment.setupButtons$lambda$0(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout = this.restoreToCollectionLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionLayout");
            constraintLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRestoreDialogFragment.setupButtons$lambda$1(this.f$0);
            }
        });
        MaterialButton materialButton2 = this.cancelButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            materialButton2 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRestoreDialogFragment.setupButtons$lambda$2(this.f$0);
            }
        });
        MaterialButton materialButton3 = this.previousButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousButton");
            materialButton3 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton3, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRestoreDialogFragment.setupButtons$lambda$3(this.f$0);
            }
        });
        MaterialButton materialButton4 = this.saveButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton = materialButton4;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRestoreDialogFragment.setupButtons$lambda$4(this.f$0);
            }
        });
    }

    static final void setupButtons$lambda$0(CollectionRestoreDialogFragment collectionRestoreDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        collectionRestoreDialogFragment.updateSaveButtonState();
    }

    static final Unit setupButtons$lambda$1(CollectionRestoreDialogFragment collectionRestoreDialogFragment) {
        RadioButton radioButton = collectionRestoreDialogFragment.restoreToCollectionRadioButton;
        RadioButton radioButton2 = null;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionRadioButton");
            radioButton = null;
        }
        boolean z = !radioButton.isChecked();
        RadioButton radioButton3 = collectionRestoreDialogFragment.restoreToCollectionRadioButton;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restoreToCollectionRadioButton");
        } else {
            radioButton2 = radioButton3;
        }
        radioButton2.setChecked(z);
        collectionRestoreDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$2(CollectionRestoreDialogFragment collectionRestoreDialogFragment) {
        collectionRestoreDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$3(CollectionRestoreDialogFragment collectionRestoreDialogFragment) {
        collectionRestoreDialogFragment.goToPreviousCard();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$4(CollectionRestoreDialogFragment collectionRestoreDialogFragment) {
        collectionRestoreDialogFragment.saveCurrentChoice();
        if (collectionRestoreDialogFragment.currentCardIndex < collectionRestoreDialogFragment.cards.size() - 1) {
            collectionRestoreDialogFragment.goToNextCard();
        } else {
            Function1<? super MultiCardCollectionRestoreDialogResult, Unit> function1 = collectionRestoreDialogFragment.onResultListener;
            if (function1 != null) {
                function1.invoke(new MultiCardCollectionRestoreDialogResult(collectionRestoreDialogFragment.results));
            }
            collectionRestoreDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupCardInfo() {
        String str;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String normal;
        MTImageURIs mTImageURIs3;
        String gatherer2;
        MTImageURIs mTImageURIs4;
        String normal2;
        MTFullCard currentCard = getCurrentCard();
        if (currentCard != null) {
            TextView textView = this.cardName;
            LoadingImageView loadingImageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardName");
                textView = null;
            }
            String printed_name = currentCard.getPrinted_name();
            textView.setText((printed_name == null && (printed_name = currentCard.getName()) == null) ? "" : printed_name);
            TextView textView2 = this.setCodeTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setCodeTextView");
                textView2 = null;
            }
            String set_code = currentCard.getSet_code();
            if (set_code != null) {
                String upperCase = set_code.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                str = upperCase != null ? upperCase : "";
            }
            textView2.setText(str);
            TextView textView3 = this.collectorNumberTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectorNumberTextView");
                textView3 = null;
            }
            String collector_number = currentCard.getCollector_number();
            if (collector_number == null) {
                collector_number = "---";
            }
            textView3.setText(ColorKt.HEX_PREFIX + collector_number);
            LoadingImageView loadingImageView2 = this.currentCardImage;
            if (loadingImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                loadingImageView2 = null;
            }
            loadingImageView2.setAutoLoad(false);
            LoadingImageView loadingImageView3 = this.currentCardImage;
            if (loadingImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                loadingImageView3 = null;
            }
            loadingImageView3.reset();
            List<MTImageURIs> images = currentCard.getImages();
            if (images != null && (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) != null && (normal2 = mTImageURIs4.getNormal()) != null) {
                LoadingImageView loadingImageView4 = this.currentCardImage;
                if (loadingImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView4;
                }
                loadingImageView.loadImage(normal2);
                return;
            }
            List<MTImageURIs> images2 = currentCard.getImages();
            if (images2 != null && (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer2 = mTImageURIs3.getGatherer()) != null) {
                LoadingImageView loadingImageView5 = this.currentCardImage;
                if (loadingImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView5;
                }
                loadingImageView.loadImage(gatherer2);
                return;
            }
            List<MTImageURIs> en_images = currentCard.getEn_images();
            if (en_images != null && (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) != null && (normal = mTImageURIs2.getNormal()) != null) {
                LoadingImageView loadingImageView6 = this.currentCardImage;
                if (loadingImageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView6;
                }
                loadingImageView.loadImage(normal);
                return;
            }
            List<MTImageURIs> en_images2 = currentCard.getEn_images();
            if (en_images2 == null || (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null || (gatherer = mTImageURIs.getGatherer()) == null) {
                return;
            }
            LoadingImageView loadingImageView7 = this.currentCardImage;
            if (loadingImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
            } else {
                loadingImageView = loadingImageView7;
            }
            loadingImageView.loadImage(gatherer);
        }
    }

    private final void setupProgressHeader() {
        int size = this.cards.size();
        TextView textView = this.progressHeader;
        TextView textView2 = null;
        if (size <= 1) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
                textView = null;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.progressHeader;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
        } else {
            textView2 = textView3;
        }
        textView2.setText(getString(R.string.card_progress, Integer.valueOf(this.currentCardIndex + 1), Integer.valueOf(this.cards.size())));
    }

    private final void updateButtonStates() {
        boolean z = this.currentCardIndex >= this.cards.size() - 1;
        MaterialButton materialButton = this.saveButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        materialButton.setText(z ? getString(R.string.save) : getString(R.string.next));
        MaterialButton materialButton3 = this.saveButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton3 = null;
        }
        materialButton3.setEnabled(true);
        int color = ContextCompat.getColor(requireContext(), R.color.almost_white);
        MaterialButton materialButton4 = this.saveButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton4 = null;
        }
        materialButton4.setTextColor(color);
        MaterialButton materialButton5 = this.previousButton;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousButton");
        } else {
            materialButton2 = materialButton5;
        }
        materialButton2.setVisibility(this.currentCardIndex <= 0 ? 8 : 0);
    }

    private final void updateSaveButtonState() {
        updateButtonStates();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_collection_restore, container, false);
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
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initializeViews();
        setupProgressHeader();
        setupCardInfo();
        setupButtons();
        updateButtonStates();
    }
}
