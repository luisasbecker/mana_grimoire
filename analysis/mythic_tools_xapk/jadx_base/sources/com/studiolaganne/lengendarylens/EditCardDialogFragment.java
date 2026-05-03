package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: EditCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001CB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000fH\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u000208H\u0002J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010B\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000Rv\u0010\f\u001aj\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010$\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010%\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010&\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010'\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/studiolaganne/lengendarylens/EditCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/studiolaganne/lengendarylens/LanguageClickListener;", "Lcom/studiolaganne/lengendarylens/ConditionClickListener;", "Lcom/studiolaganne/lengendarylens/FinishClickListener;", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onDimissListener", "Lkotlin/Function0;", "", "onEditClicked", "Lkotlin/Function12;", "", "", "", "", "allPrintsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "addMode", "deckMode", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "selectedListId", "Ljava/lang/Integer;", "showPurchasePrice", "newQuantity", "applyToQty", "newLanguage", "newFinish", "newCondition", "newCard", "newAltered", "Ljava/lang/Boolean;", "newSigned", "newMisprint", "newProxy", "newPurchasePrice", "Ljava/lang/Double;", "popupWindow", "Landroid/widget/PopupWindow;", "conditionPopupWindow", "finishPopupWindow", "onFinishClick", "finish", "onConditionClick", "condition", "onLanguageClick", "language", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupDeckListSelection", ViewHierarchyConstants.VIEW_KEY, "updateCardDetails", "updatePrint", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditCardDialogFragment extends DialogFragment implements LanguageClickListener, ConditionClickListener, FinishClickListener {
    public static final int $stable = 8;
    private boolean addMode;
    private ActivityResultLauncher<Intent> allPrintsLauncher;
    private Integer applyToQty;
    private MTFullCard card;
    private PopupWindow conditionPopupWindow;
    private MTDeck deck;
    private boolean deckMode;
    private PopupWindow finishPopupWindow;
    private Boolean newAltered;
    private MTFullCard newCard;
    private String newCondition;
    private String newFinish;
    private String newLanguage;
    private Boolean newMisprint;
    private Boolean newProxy;
    private Double newPurchasePrice;
    private Integer newQuantity;
    private Boolean newSigned;
    private Function0<Unit> onDimissListener;
    private Function12<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super MTFullCard, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Integer, ? super Double, Unit> onEditClicked;
    private PopupWindow popupWindow;
    private Integer selectedListId;
    private boolean showPurchasePrice;

    /* JADX INFO: compiled from: EditCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u00002\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016Jt\u0010\u001f\u001a\u00020\u00002l\u0010\u001e\u001ah\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010J\u0014\u0010 \u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\"\u001a\u00020#J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000Rv\u0010\u000f\u001aj\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/EditCardDialogFragment$Builder;", "", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "addMode", "", "deckMode", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "allPrintsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "showPurchasePrice", "onEditClicked", "Lkotlin/Function12;", "", "", "", "", "onDimissListener", "Lkotlin/Function0;", "setShowPurchasePrice", "show", "setCard", "setAddMode", "setDeckMode", "setDeck", "setOnDismissListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnEditClickedListener", "setAllPrintsLauncher", "launcher", "build", "Lcom/studiolaganne/lengendarylens/EditCardDialogFragment;", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean addMode;
        private ActivityResultLauncher<Intent> allPrintsLauncher;
        private MTFullCard card;
        private MTDeck deck;
        private boolean deckMode;
        private Function0<Unit> onDimissListener;
        private Function12<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super MTFullCard, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Integer, ? super Double, Unit> onEditClicked;
        private boolean showPurchasePrice;

        public final EditCardDialogFragment build() {
            EditCardDialogFragment editCardDialogFragment = new EditCardDialogFragment();
            editCardDialogFragment.card = this.card;
            editCardDialogFragment.addMode = this.addMode;
            editCardDialogFragment.deckMode = this.deckMode;
            editCardDialogFragment.deck = this.deck;
            editCardDialogFragment.showPurchasePrice = this.showPurchasePrice;
            editCardDialogFragment.onEditClicked = this.onEditClicked;
            editCardDialogFragment.onDimissListener = this.onDimissListener;
            editCardDialogFragment.allPrintsLauncher = this.allPrintsLauncher;
            return editCardDialogFragment;
        }

        public final Builder setAddMode(boolean addMode) {
            this.addMode = addMode;
            return this;
        }

        public final Builder setAllPrintsLauncher(ActivityResultLauncher<Intent> launcher) {
            Intrinsics.checkNotNullParameter(launcher, "launcher");
            this.allPrintsLauncher = launcher;
            return this;
        }

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
            return this;
        }

        public final Builder setDeck(MTDeck deck) {
            Intrinsics.checkNotNullParameter(deck, "deck");
            this.deck = deck;
            return this;
        }

        public final Builder setDeckMode(boolean deckMode) {
            this.deckMode = deckMode;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> listener) {
            this.onDimissListener = listener;
            return this;
        }

        public final Builder setOnEditClickedListener(Function12<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super MTFullCard, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Integer, ? super Double, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onEditClicked = listener;
            return this;
        }

        public final Builder setShowPurchasePrice(boolean show) {
            this.showPurchasePrice = show;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(EditCardDialogFragment editCardDialogFragment) {
        editCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(final EditCardDialogFragment editCardDialogFragment) {
        Integer num = editCardDialogFragment.newQuantity;
        if (num == null || num.intValue() != 0) {
            Function12<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super MTFullCard, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Integer, ? super Double, Unit> function12 = editCardDialogFragment.onEditClicked;
            if (function12 != null) {
                function12.invoke(editCardDialogFragment.newQuantity, editCardDialogFragment.applyToQty, editCardDialogFragment.newLanguage, editCardDialogFragment.newFinish, editCardDialogFragment.newCondition, editCardDialogFragment.newCard, editCardDialogFragment.newAltered, editCardDialogFragment.newSigned, editCardDialogFragment.newMisprint, editCardDialogFragment.newProxy, editCardDialogFragment.selectedListId, editCardDialogFragment.newPurchasePrice);
            }
            editCardDialogFragment.dismiss();
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = editCardDialogFragment.getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = editCardDialogFragment.getResources().getString(R.string.zero_quantity_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = editCardDialogFragment.getResources().getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EditCardDialogFragment.onCreateView$lambda$1$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = editCardDialogFragment.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditCardDialogFragment.onCreateView$lambda$1$0$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager parentFragmentManager = editCardDialogFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        negativeButton.show(parentFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$0$0(EditCardDialogFragment editCardDialogFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Function12<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super MTFullCard, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Integer, ? super Double, Unit> function12 = editCardDialogFragment.onEditClicked;
        if (function12 != null) {
            function12.invoke(editCardDialogFragment.newQuantity, editCardDialogFragment.applyToQty, editCardDialogFragment.newLanguage, editCardDialogFragment.newFinish, editCardDialogFragment.newCondition, editCardDialogFragment.newCard, editCardDialogFragment.newAltered, editCardDialogFragment.newSigned, editCardDialogFragment.newMisprint, editCardDialogFragment.newProxy, editCardDialogFragment.selectedListId, editCardDialogFragment.newPurchasePrice);
        }
        editCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(EditCardDialogFragment editCardDialogFragment, MTFullCard mTFullCard, PreferencesManager preferencesManager, EditText editText) {
        MTFullCard mTFullCard2 = editCardDialogFragment.newCard;
        MTFullCard mTFullCard3 = mTFullCard2 == null ? mTFullCard : mTFullCard2;
        String finish = editCardDialogFragment.newFinish;
        if (finish == null) {
            finish = mTFullCard.getFinish();
        }
        double cardPrice = GameUtils.INSTANCE.getInstance().getCardPrice(MTFullCard.copy$default(mTFullCard3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, finish, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, -1, 127, null), preferencesManager.getPreferredMarket());
        editText.setText(GameUtils.INSTANCE.getInstance().formatPriceAmountOnly(cardPrice, preferencesManager.getPreferredCurrency()));
        editCardDialogFragment.newPurchasePrice = Double.valueOf(cardPrice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$21(EditCardDialogFragment editCardDialogFragment, LinearLayout linearLayout) {
        PopupWindow popupWindow = editCardDialogFragment.popupWindow;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(linearLayout);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$22(PopupWindow popupWindow, LinearLayout linearLayout) {
        popupWindow.showAsDropDown(linearLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$23(MTFullCard mTFullCard, EditCardDialogFragment editCardDialogFragment, PopupWindow popupWindow, LinearLayout linearLayout) {
        List<String> finishes = mTFullCard.getFinishes();
        if (finishes == null || finishes.size() != 1) {
            popupWindow.showAsDropDown(linearLayout);
            return Unit.INSTANCE;
        }
        Toast.makeText(editCardDialogFragment.requireContext(), editCardDialogFragment.getResources().getString(R.string.no_other_finish), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$24(EditCardDialogFragment editCardDialogFragment, MTFullCard mTFullCard) {
        Intent intent = new Intent(editCardDialogFragment.requireContext(), (Class<?>) AllPrintsActivity.class);
        intent.putExtra("currentMTCardId", mTFullCard.getCardid());
        intent.putExtra("currentFace", 0);
        ActivityResultLauncher<Intent> activityResultLauncher = editCardDialogFragment.allPrintsLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$25(EditCardDialogFragment editCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        editCardDialogFragment.newAltered = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$26(EditCardDialogFragment editCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        editCardDialogFragment.newSigned = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$27(EditCardDialogFragment editCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        editCardDialogFragment.newMisprint = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$28(EditCardDialogFragment editCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        editCardDialogFragment.newProxy = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$3(EditCardDialogFragment editCardDialogFragment, MTFullCard mTFullCard, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        if (editCardDialogFragment.newQuantity == null) {
            int variant_quantity = mTFullCard.getVariant_quantity();
            if (variant_quantity == null && (variant_quantity = mTFullCard.getQuantity()) == null) {
                variant_quantity = 1;
            }
            editCardDialogFragment.newQuantity = variant_quantity;
        }
        Integer num = editCardDialogFragment.newQuantity;
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue > 0) {
                editCardDialogFragment.newQuantity = Integer.valueOf(iIntValue - 1);
            }
            textView.setText(String.valueOf(editCardDialogFragment.newQuantity));
            Integer num2 = editCardDialogFragment.newQuantity;
            if (num2 != null && num2.intValue() == 0) {
                textView2.setVisibility(8);
                linearLayout.setVisibility(8);
                editCardDialogFragment.applyToQty = null;
            } else {
                Integer num3 = editCardDialogFragment.newQuantity;
                if (num3 != null && num3.intValue() == 1) {
                    linearLayout.setVisibility(8);
                    editCardDialogFragment.applyToQty = null;
                } else {
                    Integer num4 = editCardDialogFragment.newQuantity;
                    editCardDialogFragment.applyToQty = num4;
                    textView3.setText(String.valueOf(num4));
                    textView4.setText(editCardDialogFragment.getResources().getString(R.string.cards_plural));
                }
                textView2.setVisibility(0);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$4(EditCardDialogFragment editCardDialogFragment, MTFullCard mTFullCard, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (editCardDialogFragment.newQuantity == null) {
            int variant_quantity = mTFullCard.getVariant_quantity();
            if (variant_quantity == null && (variant_quantity = mTFullCard.getQuantity()) == null) {
                variant_quantity = 1;
            }
            editCardDialogFragment.newQuantity = variant_quantity;
        }
        Integer num = editCardDialogFragment.newQuantity;
        if (num != null) {
            int iIntValue = num.intValue() + 1;
            editCardDialogFragment.newQuantity = Integer.valueOf(iIntValue);
            if (iIntValue >= 2) {
                if (!editCardDialogFragment.addMode) {
                    linearLayout.setVisibility(0);
                }
                Integer num2 = editCardDialogFragment.newQuantity;
                editCardDialogFragment.applyToQty = num2;
                textView.setText(String.valueOf(num2));
                textView2.setText(editCardDialogFragment.getResources().getString(R.string.cards_plural));
            }
            textView3.setText(String.valueOf(editCardDialogFragment.newQuantity));
            textView4.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$5(EditCardDialogFragment editCardDialogFragment, TextView textView, TextView textView2) {
        Integer num = editCardDialogFragment.applyToQty;
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue > 1) {
                editCardDialogFragment.applyToQty = Integer.valueOf(iIntValue - 1);
            }
            textView.setText(String.valueOf(editCardDialogFragment.applyToQty));
            Integer num2 = editCardDialogFragment.applyToQty;
            if (num2 != null && num2.intValue() == 1) {
                textView2.setText(editCardDialogFragment.getResources().getString(R.string.cards_singular));
            } else {
                textView2.setText(editCardDialogFragment.getResources().getString(R.string.cards_plural));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$6(EditCardDialogFragment editCardDialogFragment, MTFullCard mTFullCard, TextView textView, TextView textView2) {
        int iIntValue;
        Integer num = editCardDialogFragment.applyToQty;
        if (num != null) {
            int iIntValue2 = num.intValue();
            Integer variant_quantity = editCardDialogFragment.newQuantity;
            if (variant_quantity == null && (variant_quantity = mTFullCard.getVariant_quantity()) == null) {
                Integer quantity = mTFullCard.getQuantity();
                iIntValue = quantity != null ? quantity.intValue() : 1;
            } else {
                iIntValue = variant_quantity.intValue();
            }
            if (iIntValue2 < iIntValue) {
                Integer numValueOf = Integer.valueOf(iIntValue2 + 1);
                editCardDialogFragment.applyToQty = numValueOf;
                textView.setText(String.valueOf(numValueOf));
                Integer num2 = editCardDialogFragment.applyToQty;
                if (num2 != null && num2.intValue() == 1) {
                    textView2.setText(editCardDialogFragment.getResources().getString(R.string.cards_singular));
                } else {
                    textView2.setText(editCardDialogFragment.getResources().getString(R.string.cards_plural));
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0$0(EditCardDialogFragment editCardDialogFragment, Window window, int i) {
        int i2 = (int) (((double) editCardDialogFragment.getResources().getDisplayMetrics().heightPixels) * 0.9d);
        if (window.getDecorView().getHeight() > i2) {
            window.setLayout(i, i2);
        }
    }

    private final void setupDeckListSelection(View view) {
        MTDeck mTDeck;
        MTDeck mTDeck2;
        MTDeck mTDeck3;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.deckListSelectionLayout);
        final RadioButton radioButton = (RadioButton) view.findViewById(R.id.mainDeckRadioButton);
        final RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.maybeboardRadioButton);
        final RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.sideboardRadioButton);
        linearLayout.setVisibility(0);
        MTDeck mTDeck4 = this.deck;
        boolean z = (mTDeck4 != null ? mTDeck4.getListid() : null) != null;
        MTDeck mTDeck5 = this.deck;
        boolean z2 = (mTDeck5 != null ? mTDeck5.getMaybeboardlistid() : null) != null;
        MTDeck mTDeck6 = this.deck;
        boolean z3 = (mTDeck6 != null ? mTDeck6.getSideboardlistid() : null) != null;
        if (!z) {
            radioButton.setVisibility(8);
        }
        if (!z2) {
            radioButton2.setVisibility(8);
        }
        if (!z3) {
            radioButton3.setVisibility(8);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String lastDeckListSelection = preferencesManager.getLastDeckListSelection();
        RadioButton[] radioButtonArr = new RadioButton[3];
        radioButtonArr[0] = z ? radioButton : null;
        radioButtonArr[1] = z2 ? radioButton2 : null;
        radioButtonArr[2] = z3 ? radioButton3 : null;
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) radioButtonArr);
        int iHashCode = lastDeckListSelection.hashCode();
        if (iHashCode != -1845833745) {
            if (iHashCode != 3343801) {
                if (iHashCode == 1018594174 && lastDeckListSelection.equals("maybeboard")) {
                    if (z2) {
                        radioButton2.setChecked(true);
                        MTDeck mTDeck7 = this.deck;
                        this.selectedListId = mTDeck7 != null ? mTDeck7.getMaybeboardlistid() : null;
                    } else if (z) {
                        radioButton.setChecked(true);
                        MTDeck mTDeck8 = this.deck;
                        this.selectedListId = mTDeck8 != null ? mTDeck8.getListid() : null;
                    } else {
                        RadioButton radioButton4 = (RadioButton) CollectionsKt.firstOrNull(listListOfNotNull);
                        if (radioButton4 != null) {
                            radioButton4.setChecked(true);
                        }
                        if (z) {
                            MTDeck mTDeck9 = this.deck;
                            if (mTDeck9 != null) {
                                sideboardlistid = mTDeck9.getListid();
                            }
                        } else if (z2) {
                            MTDeck mTDeck10 = this.deck;
                            if (mTDeck10 != null) {
                                sideboardlistid = mTDeck10.getMaybeboardlistid();
                            }
                        } else if (z3 && (mTDeck3 = this.deck) != null) {
                            sideboardlistid = mTDeck3.getSideboardlistid();
                        }
                        this.selectedListId = sideboardlistid;
                    }
                }
            } else if (lastDeckListSelection.equals("main")) {
                if (z) {
                    radioButton.setChecked(true);
                    MTDeck mTDeck11 = this.deck;
                    this.selectedListId = mTDeck11 != null ? mTDeck11.getListid() : null;
                } else {
                    RadioButton radioButton5 = (RadioButton) CollectionsKt.firstOrNull(listListOfNotNull);
                    if (radioButton5 != null) {
                        radioButton5.setChecked(true);
                    }
                    if (z) {
                        MTDeck mTDeck12 = this.deck;
                        if (mTDeck12 != null) {
                            sideboardlistid = mTDeck12.getListid();
                        }
                    } else if (z2) {
                        MTDeck mTDeck13 = this.deck;
                        if (mTDeck13 != null) {
                            sideboardlistid = mTDeck13.getMaybeboardlistid();
                        }
                    } else if (z3 && (mTDeck2 = this.deck) != null) {
                        sideboardlistid = mTDeck2.getSideboardlistid();
                    }
                    this.selectedListId = sideboardlistid;
                }
            }
        } else if (lastDeckListSelection.equals("sideboard")) {
            if (z3) {
                radioButton3.setChecked(true);
                MTDeck mTDeck14 = this.deck;
                this.selectedListId = mTDeck14 != null ? mTDeck14.getSideboardlistid() : null;
            } else if (z) {
                radioButton.setChecked(true);
                MTDeck mTDeck15 = this.deck;
                this.selectedListId = mTDeck15 != null ? mTDeck15.getListid() : null;
            } else {
                RadioButton radioButton6 = (RadioButton) CollectionsKt.firstOrNull(listListOfNotNull);
                if (radioButton6 != null) {
                    radioButton6.setChecked(true);
                }
                if (z) {
                    MTDeck mTDeck16 = this.deck;
                    if (mTDeck16 != null) {
                        sideboardlistid = mTDeck16.getListid();
                    }
                } else if (z2) {
                    MTDeck mTDeck17 = this.deck;
                    if (mTDeck17 != null) {
                        sideboardlistid = mTDeck17.getMaybeboardlistid();
                    }
                } else if (z3 && (mTDeck = this.deck) != null) {
                    sideboardlistid = mTDeck.getSideboardlistid();
                }
                this.selectedListId = sideboardlistid;
            }
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                EditCardDialogFragment.setupDeckListSelection$lambda$3(radioButton2, radioButton3, this, preferencesManager, compoundButton, z4);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda11
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                EditCardDialogFragment.setupDeckListSelection$lambda$4(radioButton, radioButton3, this, preferencesManager, compoundButton, z4);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                EditCardDialogFragment.setupDeckListSelection$lambda$5(radioButton2, radioButton, this, preferencesManager, compoundButton, z4);
            }
        });
    }

    static final void setupDeckListSelection$lambda$3(RadioButton radioButton, RadioButton radioButton2, EditCardDialogFragment editCardDialogFragment, PreferencesManager preferencesManager, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            MTDeck mTDeck = editCardDialogFragment.deck;
            editCardDialogFragment.selectedListId = mTDeck != null ? mTDeck.getListid() : null;
            preferencesManager.setLastDeckListSelection("main");
        }
    }

    static final void setupDeckListSelection$lambda$4(RadioButton radioButton, RadioButton radioButton2, EditCardDialogFragment editCardDialogFragment, PreferencesManager preferencesManager, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            MTDeck mTDeck = editCardDialogFragment.deck;
            editCardDialogFragment.selectedListId = mTDeck != null ? mTDeck.getMaybeboardlistid() : null;
            preferencesManager.setLastDeckListSelection("maybeboard");
        }
    }

    static final void setupDeckListSelection$lambda$5(RadioButton radioButton, RadioButton radioButton2, EditCardDialogFragment editCardDialogFragment, PreferencesManager preferencesManager, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            MTDeck mTDeck = editCardDialogFragment.deck;
            editCardDialogFragment.selectedListId = mTDeck != null ? mTDeck.getSideboardlistid() : null;
            preferencesManager.setLastDeckListSelection("sideboard");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateCardDetails(final MTFullCard card) {
        String upperCase;
        boolean z;
        Object next;
        String lowerCase;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String gatherer2;
        MTImageURIs mTImageURIs3;
        String normal;
        Unit unit;
        Editable text;
        String string;
        View contentView;
        MTImageURIs mTImageURIs4;
        String normal2;
        Unit unit2;
        Context context;
        View view = getView();
        String string2 = null;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.editCardTitle) : null;
        View view2 = getView();
        LoadingImageView loadingImageView = view2 != null ? (LoadingImageView) view2.findViewById(R.id.cardImage) : null;
        View view3 = getView();
        if (view3 != null) {
        }
        View view4 = getView();
        if (view4 != null) {
        }
        View view5 = getView();
        if (view5 != null) {
        }
        View view6 = getView();
        if (view6 != null) {
        }
        View view7 = getView();
        if (view7 != null) {
        }
        View view8 = getView();
        if (view8 != null) {
        }
        View view9 = getView();
        if (view9 != null) {
        }
        View view10 = getView();
        ImageView imageView = view10 != null ? (ImageView) view10.findViewById(R.id.set_image) : null;
        View view11 = getView();
        TextView textView2 = view11 != null ? (TextView) view11.findViewById(R.id.selectedSetNameTextView) : null;
        View view12 = getView();
        TextView textView3 = view12 != null ? (TextView) view12.findViewById(R.id.selectedSetCodeTextView) : null;
        View view13 = getView();
        TextView textView4 = view13 != null ? (TextView) view13.findViewById(R.id.selectedCollectorNumberTextView) : null;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (textView != null) {
            String printed_name = card.getPrinted_name();
            if (printed_name == null) {
                printed_name = card.getName();
            }
            textView.setText(printed_name);
            Unit unit3 = Unit.INSTANCE;
        }
        if (textView4 != null) {
            String collector_number = card.getCollector_number();
            if (collector_number == null) {
                collector_number = "---";
            }
            textView4.setText(ColorKt.HEX_PREFIX + collector_number);
            Unit unit4 = Unit.INSTANCE;
        }
        String set_code = card.getSet_code();
        if (set_code != null) {
            upperCase = set_code.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (upperCase == null) {
                upperCase = "...";
            }
        }
        if (textView3 != null) {
            textView3.setText(upperCase);
            Unit unit5 = Unit.INSTANCE;
        }
        List<CardSet> cardSets = CardSetsManager.INSTANCE.getCardSets();
        if (Intrinsics.areEqual(preferencesManager.getDeviceLanguage(), "fr")) {
            cardSets = CardSetsManager.INSTANCE.getFrCardSets();
        }
        Iterator<T> it = cardSets.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (StringsKt.equals(((CardSet) next).getCode(), upperCase, true)) {
                    break;
                }
            }
        }
        CardSet cardSet = (CardSet) next;
        if (cardSet != null) {
            if (textView2 != null) {
                textView2.setText(cardSet.getName());
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
        } else {
            if (textView2 != null) {
                textView2.setText(getResources().getString(R.string.unknown_set));
                Unit unit8 = Unit.INSTANCE;
            }
            Unit unit9 = Unit.INSTANCE;
        }
        Resources resources = getResources();
        String set_code2 = card.getSet_code();
        if (set_code2 == null) {
            set_code2 = "dpa";
        }
        int identifier = resources.getIdentifier("set_" + set_code2, "drawable", (imageView == null || (context = imageView.getContext()) == null) ? null : context.getPackageName());
        if (identifier != 0) {
            if (imageView != null) {
                imageView.setImageResource(identifier);
                Unit unit10 = Unit.INSTANCE;
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
            Unit unit11 = Unit.INSTANCE;
        }
        String rarity = card.getRarity();
        if (rarity != null) {
            lowerCase = rarity.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
                lowerCase = "common";
            }
        }
        switch (lowerCase.hashCode()) {
            case -1354814997:
                if (lowerCase.equals("common")) {
                    if (imageView != null) {
                        imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.almost_white));
                        Unit unit12 = Unit.INSTANCE;
                    }
                } else if (imageView != null) {
                    imageView.clearColorFilter();
                    Unit unit13 = Unit.INSTANCE;
                }
                break;
            case -1059084742:
                if (lowerCase.equals("mythic")) {
                    if (imageView != null) {
                        imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.mythic));
                        Unit unit14 = Unit.INSTANCE;
                    }
                    break;
                }
                break;
            case -468311612:
                if (lowerCase.equals("uncommon")) {
                    if (imageView != null) {
                        imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.uncommon));
                        Unit unit15 = Unit.INSTANCE;
                    }
                    break;
                }
                break;
            case 3493026:
                if (lowerCase.equals("rare")) {
                    if (imageView != null) {
                        imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.rare));
                        Unit unit16 = Unit.INSTANCE;
                    }
                    break;
                }
                break;
        }
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (normal2 = mTImageURIs4.getNormal()) == null) {
            List<MTImageURIs> images2 = card.getImages();
            if (images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer = mTImageURIs.getGatherer()) != null && loadingImageView != null) {
                loadingImageView.loadImage(gatherer);
                Unit unit17 = Unit.INSTANCE;
            }
        } else {
            if (loadingImageView != null) {
                loadingImageView.loadImage(normal2);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
            }
        }
        List<MTImageURIs> images3 = card.getImages();
        if (images3 == null || images3.isEmpty()) {
            List<MTImageURIs> en_images = card.getEn_images();
            if (en_images == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null || (normal = mTImageURIs3.getNormal()) == null) {
                List<MTImageURIs> en_images2 = card.getEn_images();
                if (en_images2 != null && (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null && (gatherer2 = mTImageURIs2.getGatherer()) != null && loadingImageView != null) {
                    loadingImageView.loadImage(gatherer2);
                    Unit unit18 = Unit.INSTANCE;
                }
            } else {
                if (loadingImageView != null) {
                    loadingImageView.loadImage(normal);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                }
            }
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.language_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        ArrayList arrayList = new ArrayList();
        List<String> available_lang = card.getAvailable_lang();
        if (available_lang == null) {
            available_lang = CollectionsKt.listOf("en");
        }
        for (String str : available_lang) {
            arrayList.add(new LanguageRow(str, preferencesManager.getNameForLanguage(str)));
        }
        recyclerView.setAdapter(new LanguageAdapter(arrayList, this));
        this.popupWindow = popupWindow;
        View view14 = getView();
        final LinearLayout linearLayout = view14 != null ? (LinearLayout) view14.findViewById(R.id.finishSelectionLayout) : null;
        if (linearLayout != null) {
            ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditCardDialogFragment.updateCardDetails$lambda$7(card, this, linearLayout);
                }
            });
            Unit unit19 = Unit.INSTANCE;
        }
        String lang = this.newLanguage;
        if (lang == null) {
            MTFullCard mTFullCard = this.card;
            lang = mTFullCard != null ? mTFullCard.getLang() : null;
            if (lang == null) {
                lang = "en";
            }
        }
        String finish = this.newFinish;
        if (finish == null) {
            MTFullCard mTFullCard2 = this.card;
            finish = mTFullCard2 != null ? mTFullCard2.getFinish() : null;
        }
        List<String> available_lang2 = card.getAvailable_lang();
        if (available_lang2 != null) {
            if (!available_lang2.contains(lang)) {
                String str2 = (String) CollectionsKt.firstOrNull((List) available_lang2);
                onLanguageClick(str2 != null ? str2 : "en");
            }
            Unit unit20 = Unit.INSTANCE;
            Unit unit21 = Unit.INSTANCE;
        }
        List<String> finishes = card.getFinishes();
        if (finishes != null) {
            if (!CollectionsKt.contains(finishes, finish)) {
                this.newFinish = (String) CollectionsKt.firstOrNull((List) finishes);
                Dialog dialog = getDialog();
                TextView textView5 = dialog != null ? (TextView) dialog.findViewById(R.id.selectedFinishTextView) : null;
                Dialog dialog2 = getDialog();
                ImageView imageView2 = dialog2 != null ? (ImageView) dialog2.findViewById(R.id.foil_image) : null;
                Dialog dialog3 = getDialog();
                ImageView imageView3 = dialog3 != null ? (ImageView) dialog3.findViewById(R.id.foilEffectImage) : null;
                String str3 = this.newFinish;
                if (str3 != null) {
                    String lowerCase2 = str3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase2, "foil")) {
                        if (textView5 != null) {
                            textView5.setText(getResources().getString(R.string.foil));
                            Unit unit22 = Unit.INSTANCE;
                        }
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                            Unit unit23 = Unit.INSTANCE;
                        }
                        if (imageView3 != null) {
                            imageView3.setVisibility(0);
                            Unit unit24 = Unit.INSTANCE;
                        }
                    } else {
                        String lowerCase3 = str3.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase3, "etched")) {
                            if (textView5 != null) {
                                textView5.setText(getResources().getString(R.string.etched));
                                Unit unit25 = Unit.INSTANCE;
                            }
                            if (imageView2 != null) {
                                imageView2.setVisibility(0);
                                Unit unit26 = Unit.INSTANCE;
                            }
                            if (imageView3 != null) {
                                imageView3.setVisibility(0);
                                Unit unit27 = Unit.INSTANCE;
                            }
                        } else {
                            if (textView5 != null) {
                                textView5.setText(getResources().getString(R.string.non_foil));
                                Unit unit28 = Unit.INSTANCE;
                            }
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                                Unit unit29 = Unit.INSTANCE;
                            }
                            if (imageView3 != null) {
                                imageView3.setVisibility(8);
                                Unit unit30 = Unit.INSTANCE;
                            }
                        }
                    }
                    Unit unit31 = Unit.INSTANCE;
                    Unit unit32 = Unit.INSTANCE;
                }
            }
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
        PopupWindow popupWindow2 = this.finishPopupWindow;
        RecyclerView recyclerView2 = (popupWindow2 == null || (contentView = popupWindow2.getContentView()) == null) ? null : (RecyclerView) contentView.findViewById(R.id.language_recycler_view);
        ArrayList arrayList2 = new ArrayList();
        List<String> finishes2 = card.getFinishes();
        if (finishes2 != null ? finishes2.contains("nonfoil") : false) {
            String string3 = getResources().getString(R.string.non_foil);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            arrayList2.add(string3);
        }
        List<String> finishes3 = card.getFinishes();
        if (finishes3 != null ? finishes3.contains("foil") : false) {
            String string4 = getResources().getString(R.string.foil);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList2.add(string4);
        }
        List<String> finishes4 = card.getFinishes();
        if (finishes4 != null ? finishes4.contains("etched") : false) {
            String string5 = getResources().getString(R.string.etched);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            arrayList2.add(string5);
        }
        FinishAdapter finishAdapter = new FinishAdapter(arrayList2, this);
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(finishAdapter);
            Unit unit35 = Unit.INSTANCE;
        }
        if (this.showPurchasePrice) {
            View view15 = getView();
            EditText editText = view15 != null ? (EditText) view15.findViewById(R.id.purchasePriceEditText) : null;
            if (editText != null && (text = editText.getText()) != null && (string = text.toString()) != null) {
                string2 = StringsKt.trim((CharSequence) string).toString();
            }
            String str4 = string2;
            if (str4 != null && str4.length() != 0) {
                z = false;
            }
            if (z) {
                String preferredMarket = preferencesManager.getPreferredMarket();
                String preferredCurrency = preferencesManager.getPreferredCurrency();
                double cardPrice = GameUtils.INSTANCE.getInstance().getCardPrice(card, preferredMarket);
                if (editText != null) {
                    editText.setHint(GameUtils.INSTANCE.getInstance().formatPriceAmountOnly(cardPrice, preferredCurrency));
                    Unit unit36 = Unit.INSTANCE;
                    Unit unit37 = Unit.INSTANCE;
                }
            }
        }
    }

    static final Unit updateCardDetails$lambda$7(MTFullCard mTFullCard, EditCardDialogFragment editCardDialogFragment, LinearLayout linearLayout) {
        List<String> finishes = mTFullCard.getFinishes();
        if (finishes != null && finishes.size() == 1) {
            Toast.makeText(editCardDialogFragment.requireContext(), editCardDialogFragment.getResources().getString(R.string.no_other_finish), 0).show();
            return Unit.INSTANCE;
        }
        PopupWindow popupWindow = editCardDialogFragment.finishPopupWindow;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(linearLayout);
        }
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.ConditionClickListener
    public void onConditionClick(String condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        if (getContext() == null) {
            return;
        }
        PopupWindow popupWindow = this.conditionPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.newCondition = condition;
        Dialog dialog = getDialog();
        TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.selectedConditionTextView) : null;
        Dialog dialog2 = getDialog();
        TextView textView2 = dialog2 != null ? (TextView) dialog2.findViewById(R.id.conditionTextView) : null;
        if (textView != null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String upperCase = condition.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            textView.setText(companion.nameForCardCondition(contextRequireContext, upperCase));
        }
        if (textView2 != null) {
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            String upperCase2 = condition.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            textView2.setTextColor(companion2.colorForCardCondition(contextRequireContext2, upperCase2));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:101:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0424  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        TextView textView;
        TextView textView2;
        String str;
        String lowerCase;
        TextView textView3;
        int i;
        Object next;
        ImageView imageView;
        boolean z;
        CheckBox checkBox;
        CheckBox checkBox2;
        String str2;
        LoadingImageView loadingImageView;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String gatherer2;
        MTImageURIs mTImageURIs3;
        String normal;
        MTImageURIs mTImageURIs4;
        String normal2;
        int i2;
        Window window;
        final EditCardDialogFragment editCardDialogFragment = this;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.edit_card_dialog, container, false);
        Dialog dialog = editCardDialogFragment.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            Unit unit = Unit.INSTANCE;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditCardDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.editButtonLayout);
        if (editCardDialogFragment.addMode) {
            ((TextView) viewInflate.findViewById(R.id.editButtonText)).setText(editCardDialogFragment.getResources().getString(R.string.add));
        }
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditCardDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        final MTFullCard mTFullCard = editCardDialogFragment.card;
        if (mTFullCard != null) {
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.editCardTitle);
            View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            LoadingImageView loadingImageView2 = (LoadingImageView) viewFindViewById;
            View viewFindViewById2 = viewInflate.findViewById(R.id.foilEffectImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ImageView imageView2 = (ImageView) viewFindViewById2;
            View viewFindViewById3 = viewInflate.findViewById(R.id.minusQtyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            final TextView textView5 = (TextView) viewFindViewById3;
            View viewFindViewById4 = viewInflate.findViewById(R.id.qtyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            final TextView textView6 = (TextView) viewFindViewById4;
            View viewFindViewById5 = viewInflate.findViewById(R.id.plusQtyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            TextView textView7 = (TextView) viewFindViewById5;
            View viewFindViewById6 = viewInflate.findViewById(R.id.flag_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ImageView imageView3 = (ImageView) viewFindViewById6;
            View viewFindViewById7 = viewInflate.findViewById(R.id.selectedLanguageTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            TextView textView8 = (TextView) viewFindViewById7;
            View viewFindViewById8 = viewInflate.findViewById(R.id.conditionTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            TextView textView9 = (TextView) viewFindViewById8;
            View viewFindViewById9 = viewInflate.findViewById(R.id.selectedConditionTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            TextView textView10 = (TextView) viewFindViewById9;
            View viewFindViewById10 = viewInflate.findViewById(R.id.foil_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            ImageView imageView4 = (ImageView) viewFindViewById10;
            View viewFindViewById11 = viewInflate.findViewById(R.id.selectedFinishTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            TextView textView11 = (TextView) viewFindViewById11;
            View viewFindViewById12 = viewInflate.findViewById(R.id.set_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            ImageView imageView5 = (ImageView) viewFindViewById12;
            View viewFindViewById13 = viewInflate.findViewById(R.id.selectedSetNameTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            TextView textView12 = (TextView) viewFindViewById13;
            View viewFindViewById14 = viewInflate.findViewById(R.id.selectedSetCodeTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            TextView textView13 = (TextView) viewFindViewById14;
            View viewFindViewById15 = viewInflate.findViewById(R.id.selectedCollectorNumberTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            TextView textView14 = (TextView) viewFindViewById15;
            View viewFindViewById16 = viewInflate.findViewById(R.id.alteredCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            CheckBox checkBox3 = (CheckBox) viewFindViewById16;
            View viewFindViewById17 = viewInflate.findViewById(R.id.misprintCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            CheckBox checkBox4 = (CheckBox) viewFindViewById17;
            View viewFindViewById18 = viewInflate.findViewById(R.id.signedCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
            CheckBox checkBox5 = (CheckBox) viewFindViewById18;
            View viewFindViewById19 = viewInflate.findViewById(R.id.proxyCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
            CheckBox checkBox6 = (CheckBox) viewFindViewById19;
            View viewFindViewById20 = viewInflate.findViewById(R.id.languageSelectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
            final LinearLayout linearLayout = (LinearLayout) viewFindViewById20;
            View viewFindViewById21 = viewInflate.findViewById(R.id.conditionSelectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
            final LinearLayout linearLayout2 = (LinearLayout) viewFindViewById21;
            View viewFindViewById22 = viewInflate.findViewById(R.id.finishSelectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
            final LinearLayout linearLayout3 = (LinearLayout) viewFindViewById22;
            View viewFindViewById23 = viewInflate.findViewById(R.id.setSelectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
            LinearLayout linearLayout4 = (LinearLayout) viewFindViewById23;
            View viewFindViewById24 = viewInflate.findViewById(R.id.applyLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
            final LinearLayout linearLayout5 = (LinearLayout) viewFindViewById24;
            View viewFindViewById25 = viewInflate.findViewById(R.id.applyValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
            TextView textView15 = (TextView) viewFindViewById25;
            View viewFindViewById26 = viewInflate.findViewById(R.id.minusApplyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
            TextView textView16 = (TextView) viewFindViewById26;
            View viewFindViewById27 = viewInflate.findViewById(R.id.plusApplyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
            TextView textView17 = (TextView) viewFindViewById27;
            View viewFindViewById28 = viewInflate.findViewById(R.id.applyFooter);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
            final TextView textView18 = (TextView) viewFindViewById28;
            View viewFindViewById29 = viewInflate.findViewById(R.id.purchasePriceHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
            TextView textView19 = (TextView) viewFindViewById29;
            View viewFindViewById30 = viewInflate.findViewById(R.id.purchasePriceEditText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById30, "findViewById(...)");
            final EditText editText = (EditText) viewFindViewById30;
            View viewFindViewById31 = viewInflate.findViewById(R.id.purchasePriceSetter);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById31, "findViewById(...)");
            TextView textView20 = (TextView) viewFindViewById31;
            view = viewInflate;
            if (editCardDialogFragment.showPurchasePrice) {
                textView19.setVisibility(0);
                editText.setVisibility(0);
                textView20.setVisibility(0);
                Context contextRequireContext = editCardDialogFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                String preferredMarket = preferencesManager.getPreferredMarket();
                String preferredCurrency = preferencesManager.getPreferredCurrency();
                textView2 = textView8;
                MTFullCard mTFullCard2 = editCardDialogFragment.newCard;
                if (mTFullCard2 == null) {
                    mTFullCard2 = mTFullCard;
                }
                str = "requireContext(...)";
                Map<String, Double> purchase = mTFullCard2.getPurchase();
                textView = textView15;
                if (purchase != null) {
                    String upperCase = preferredCurrency.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    Double purchase_price = purchase.get(upperCase);
                    if (purchase_price == null) {
                        purchase_price = mTFullCard2.getPurchase_price();
                    }
                    if (purchase_price != null) {
                        editText.setText(GameUtils.INSTANCE.getInstance().formatPriceAmountOnly(purchase_price.doubleValue(), preferredCurrency));
                        editText.setHint("");
                        editCardDialogFragment.newPurchasePrice = purchase_price;
                    } else {
                        editText.setText("");
                        editText.setHint(GameUtils.INSTANCE.getInstance().formatPriceAmountOnly(GameUtils.INSTANCE.getInstance().getCardPrice(mTFullCard2, preferredMarket), preferredCurrency));
                    }
                    ViewExtensionsKt.setOnClickWithFade(textView20, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditCardDialogFragment.onCreateView$lambda$2$0(this.f$0, mTFullCard, preferencesManager, editText);
                        }
                    });
                    editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$onCreateView$3$2
                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            String string;
                            String string2;
                            String string3;
                            Double doubleOrNull = null;
                            if (s != null && (string3 = s.toString()) != null && string3.length() == 0) {
                                this.this$0.newPurchasePrice = null;
                                return;
                            }
                            EditCardDialogFragment editCardDialogFragment2 = this.this$0;
                            if (s != null && (string = s.toString()) != null && (string2 = StringsKt.trim((CharSequence) string).toString()) != null) {
                                doubleOrNull = StringsKt.toDoubleOrNull(string2);
                            }
                            editCardDialogFragment2.newPurchasePrice = doubleOrNull;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }
                    });
                }
            } else {
                textView = textView15;
                textView2 = textView8;
                str = "requireContext(...)";
                textView19.setVisibility(8);
                editText.setVisibility(8);
                textView20.setVisibility(8);
            }
            String printed_name = mTFullCard.getPrinted_name();
            if (printed_name == null) {
                printed_name = mTFullCard.getName();
            }
            textView4.setText(printed_name);
            loadingImageView2.setAutoLoad(false);
            String set_code = mTFullCard.getSet_code();
            if (set_code != null) {
                lowerCase = set_code.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            loadingImageView2.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
            loadingImageView2.reset();
            textView6.setText("1");
            textView5.setVisibility(8);
            Integer variant_quantity = mTFullCard.getVariant_quantity();
            if (variant_quantity != null) {
                int iIntValue = variant_quantity.intValue();
                if (iIntValue > 1) {
                    if (editCardDialogFragment.addMode) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        linearLayout5.setVisibility(0);
                    }
                    textView3 = textView;
                    textView3.setText(String.valueOf(iIntValue));
                    textView6.setVisibility(i2);
                    textView6.setText(String.valueOf(iIntValue));
                } else {
                    textView3 = textView;
                    i2 = 0;
                }
                if (iIntValue > 0) {
                    textView5.setVisibility(i2);
                } else {
                    textView5.setVisibility(8);
                }
                Unit unit2 = Unit.INSTANCE;
                Unit unit3 = Unit.INSTANCE;
            } else {
                textView3 = textView;
                Integer quantity = mTFullCard.getQuantity();
                if (quantity != null) {
                    int iIntValue2 = quantity.intValue();
                    if (iIntValue2 > 1) {
                        if (editCardDialogFragment.addMode) {
                            i = 0;
                        } else {
                            i = 0;
                            linearLayout5.setVisibility(0);
                        }
                        textView3.setText(String.valueOf(iIntValue2));
                        textView6.setVisibility(i);
                        textView6.setText(String.valueOf(iIntValue2));
                    } else {
                        i = 0;
                    }
                    if (iIntValue2 > 0) {
                        textView5.setVisibility(i);
                    } else {
                        textView5.setVisibility(8);
                    }
                    Unit unit4 = Unit.INSTANCE;
                    Unit unit5 = Unit.INSTANCE;
                }
            }
            int variant_quantity2 = mTFullCard.getVariant_quantity();
            if (variant_quantity2 == null && (variant_quantity2 = mTFullCard.getQuantity()) == null) {
                variant_quantity2 = 1;
            }
            editCardDialogFragment.applyToQty = variant_quantity2;
            final TextView textView21 = textView3;
            ViewExtensionsKt.setOnClickWithFade(textView5, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditCardDialogFragment.onCreateView$lambda$2$3(this.f$0, mTFullCard, textView6, textView5, linearLayout5, textView21, textView18);
                }
            });
            editCardDialogFragment = this;
            ViewExtensionsKt.setOnClickWithFade(textView7, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditCardDialogFragment.onCreateView$lambda$2$4(this.f$0, mTFullCard, linearLayout5, textView21, textView18, textView6, textView5);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(textView16, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditCardDialogFragment.onCreateView$lambda$2$5(this.f$0, textView21, textView18);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(textView17, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditCardDialogFragment.onCreateView$lambda$2$6(this.f$0, mTFullCard, textView21, textView18);
                }
            });
            Context contextRequireContext2 = editCardDialogFragment.requireContext();
            String str3 = str;
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, str3);
            PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext2);
            String collector_number = mTFullCard.getCollector_number();
            if (collector_number == null) {
                collector_number = "---";
            }
            textView14.setText(ColorKt.HEX_PREFIX + collector_number);
            String set_code2 = mTFullCard.getSet_code();
            if (set_code2 != null) {
                String upperCase2 = set_code2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                if (upperCase2 == null) {
                    upperCase2 = "...";
                }
                textView13.setText(upperCase2);
                List<CardSet> cardSets = CardSetsManager.INSTANCE.getCardSets();
                if (Intrinsics.areEqual(preferencesManager2.getDeviceLanguage(), "fr")) {
                    cardSets = CardSetsManager.INSTANCE.getFrCardSets();
                }
                Iterator<T> it = cardSets.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (StringsKt.equals(((CardSet) next).getCode(), upperCase2, true)) {
                        break;
                    }
                }
                CardSet cardSet = (CardSet) next;
                if (cardSet != null) {
                    textView12.setText(cardSet.getName());
                    Unit unit6 = Unit.INSTANCE;
                } else {
                    textView12.setText(editCardDialogFragment.getResources().getString(R.string.unknown_set));
                    Unit unit7 = Unit.INSTANCE;
                }
                Resources resources = editCardDialogFragment.getResources();
                String set_code3 = mTFullCard.getSet_code();
                if (set_code3 == null) {
                    set_code3 = "dpa";
                }
                int identifier = resources.getIdentifier("set_" + set_code3, "drawable", imageView5.getContext().getPackageName());
                if (identifier != 0) {
                    imageView = imageView5;
                    imageView.setImageResource(identifier);
                } else {
                    imageView = imageView5;
                    imageView.setVisibility(8);
                }
                String rarity = mTFullCard.getRarity();
                if (rarity != null) {
                    String lowerCase2 = rarity.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (lowerCase2 == null) {
                        lowerCase2 = "common";
                    }
                    switch (lowerCase2.hashCode()) {
                        case -1354814997:
                            if (lowerCase2.equals("common")) {
                                imageView.setColorFilter(ContextCompat.getColor(editCardDialogFragment.requireContext(), R.color.almost_white));
                                Unit unit8 = Unit.INSTANCE;
                            } else {
                                imageView.clearColorFilter();
                                Unit unit9 = Unit.INSTANCE;
                            }
                            break;
                        case -1059084742:
                            if (lowerCase2.equals("mythic")) {
                                imageView.setColorFilter(ContextCompat.getColor(editCardDialogFragment.requireContext(), R.color.mythic));
                                Unit unit10 = Unit.INSTANCE;
                                break;
                            }
                            break;
                        case -468311612:
                            if (lowerCase2.equals("uncommon")) {
                                imageView.setColorFilter(ContextCompat.getColor(editCardDialogFragment.requireContext(), R.color.uncommon));
                                Unit unit11 = Unit.INSTANCE;
                                break;
                            }
                            break;
                        case 3493026:
                            if (lowerCase2.equals("rare")) {
                                imageView.setColorFilter(ContextCompat.getColor(editCardDialogFragment.requireContext(), R.color.rare));
                                Unit unit12 = Unit.INSTANCE;
                                break;
                            }
                            break;
                    }
                    TextView textView22 = textView2;
                    textView22.setText(preferencesManager2.getNameForLanguage("en"));
                    String lang = mTFullCard.getLang();
                    if (lang.length() > 0) {
                        imageView3.setVisibility(0);
                        textView22.setText(preferencesManager2.getNameForLanguage(lang));
                        Resources resources2 = editCardDialogFragment.getResources();
                        String lowerCase3 = lang.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        int identifier2 = resources2.getIdentifier("flag_" + lowerCase3, "drawable", imageView3.getContext().getPackageName());
                        if (identifier2 == 0) {
                            identifier2 = editCardDialogFragment.getResources().getIdentifier("flag_default", "drawable", imageView3.getContext().getPackageName());
                        }
                        imageView3.setImageResource(identifier2);
                    } else {
                        imageView3.setVisibility(8);
                    }
                    Boolean altered = mTFullCard.getAltered();
                    if (altered != null) {
                        z = true;
                        if (altered.booleanValue()) {
                            checkBox3.setChecked(true);
                        }
                        Unit unit13 = Unit.INSTANCE;
                        Unit unit14 = Unit.INSTANCE;
                    } else {
                        z = true;
                    }
                    Boolean signed = mTFullCard.getSigned();
                    if (signed != null) {
                        if (signed.booleanValue()) {
                            checkBox5.setChecked(z);
                        }
                        Unit unit15 = Unit.INSTANCE;
                        Unit unit16 = Unit.INSTANCE;
                    }
                    Boolean missprint = mTFullCard.getMissprint();
                    if (missprint != null) {
                        if (missprint.booleanValue()) {
                            checkBox = checkBox4;
                            checkBox.setChecked(z);
                        } else {
                            checkBox = checkBox4;
                        }
                        Unit unit17 = Unit.INSTANCE;
                        Unit unit18 = Unit.INSTANCE;
                    } else {
                        checkBox = checkBox4;
                    }
                    Boolean proxy = mTFullCard.getProxy();
                    if (proxy != null) {
                        if (proxy.booleanValue()) {
                            checkBox2 = checkBox6;
                            checkBox2.setChecked(z);
                        } else {
                            checkBox2 = checkBox6;
                        }
                        Unit unit19 = Unit.INSTANCE;
                        Unit unit20 = Unit.INSTANCE;
                    } else {
                        checkBox2 = checkBox6;
                    }
                    textView9.setVisibility(0);
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext3 = editCardDialogFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, str3);
                    String condition = mTFullCard.getCondition();
                    if (condition != null) {
                        String upperCase3 = condition.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                        if (upperCase3 == null) {
                            upperCase3 = GameUtils.CONDITION_NEAR_MINT;
                        }
                        textView10.setText(companion.nameForCardCondition(contextRequireContext3, upperCase3));
                        String condition2 = mTFullCard.getCondition();
                        if (condition2 != null) {
                            if (condition2.length() > 0) {
                                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                                Context contextRequireContext4 = editCardDialogFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, str3);
                                str2 = GameUtils.CONDITION_NEAR_MINT;
                                String upperCase4 = condition2.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                                textView10.setText(companion2.nameForCardCondition(contextRequireContext4, upperCase4));
                                GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                                Context contextRequireContext5 = editCardDialogFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, str3);
                                String upperCase5 = condition2.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
                                textView9.setTextColor(companion3.colorForCardCondition(contextRequireContext5, upperCase5));
                            } else {
                                str2 = GameUtils.CONDITION_NEAR_MINT;
                            }
                            Unit unit21 = Unit.INSTANCE;
                            Unit unit22 = Unit.INSTANCE;
                        } else {
                            str2 = GameUtils.CONDITION_NEAR_MINT;
                        }
                        imageView4.setVisibility(8);
                        imageView2.setVisibility(8);
                        textView11.setText(editCardDialogFragment.getResources().getString(R.string.non_foil));
                        String finish = mTFullCard.getFinish();
                        if (finish != null) {
                            editCardDialogFragment.newFinish = finish;
                            String lowerCase4 = finish.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                            if (Intrinsics.areEqual(lowerCase4, "foil")) {
                                textView11.setText(editCardDialogFragment.getResources().getString(R.string.foil));
                                imageView4.setVisibility(0);
                                imageView2.setVisibility(0);
                            } else {
                                String lowerCase5 = finish.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                                if (Intrinsics.areEqual(lowerCase5, "etched")) {
                                    textView11.setText(editCardDialogFragment.getResources().getString(R.string.etched));
                                    imageView4.setVisibility(0);
                                    imageView2.setVisibility(0);
                                } else {
                                    textView11.setText(editCardDialogFragment.getResources().getString(R.string.non_foil));
                                    imageView4.setVisibility(8);
                                    imageView2.setVisibility(8);
                                }
                            }
                            Unit unit23 = Unit.INSTANCE;
                            Unit unit24 = Unit.INSTANCE;
                        } else {
                            List<String> finishes = mTFullCard.getFinishes();
                            if (finishes != null) {
                                if (finishes.size() == 1) {
                                    String lowerCase6 = ((String) CollectionsKt.first((List) finishes)).toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                                    if (Intrinsics.areEqual(lowerCase6, "foil")) {
                                        textView11.setText(editCardDialogFragment.getResources().getString(R.string.foil));
                                        imageView4.setVisibility(0);
                                        imageView2.setVisibility(0);
                                        editCardDialogFragment.newFinish = "foil";
                                    } else {
                                        String lowerCase7 = ((String) CollectionsKt.first((List) finishes)).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                                        if (Intrinsics.areEqual(lowerCase7, "etched")) {
                                            textView11.setText(editCardDialogFragment.getResources().getString(R.string.etched));
                                            imageView4.setVisibility(0);
                                            imageView2.setVisibility(0);
                                            editCardDialogFragment.newFinish = "etched";
                                        } else {
                                            textView11.setText(editCardDialogFragment.getResources().getString(R.string.non_foil));
                                            imageView4.setVisibility(8);
                                            imageView2.setVisibility(8);
                                            editCardDialogFragment.newFinish = "nonfoil";
                                        }
                                    }
                                }
                                Unit unit25 = Unit.INSTANCE;
                                Unit unit26 = Unit.INSTANCE;
                            }
                        }
                        List<MTImageURIs> images = mTFullCard.getImages();
                        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (normal2 = mTImageURIs4.getNormal()) == null) {
                            loadingImageView = loadingImageView2;
                            List<MTImageURIs> images2 = mTFullCard.getImages();
                            if (images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer = mTImageURIs.getGatherer()) != null) {
                                loadingImageView.loadImage(gatherer);
                                Unit unit27 = Unit.INSTANCE;
                                Unit unit28 = Unit.INSTANCE;
                            }
                        } else {
                            loadingImageView = loadingImageView2;
                            loadingImageView.loadImage(normal2);
                            Unit unit29 = Unit.INSTANCE;
                            Unit unit30 = Unit.INSTANCE;
                        }
                        List<MTImageURIs> images3 = mTFullCard.getImages();
                        if (images3 == null || images3.isEmpty()) {
                            List<MTImageURIs> en_images = mTFullCard.getEn_images();
                            if (en_images == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null || (normal = mTImageURIs3.getNormal()) == null) {
                                List<MTImageURIs> en_images2 = mTFullCard.getEn_images();
                                if (en_images2 != null && (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null && (gatherer2 = mTImageURIs2.getGatherer()) != null) {
                                    loadingImageView.loadImage(gatherer2);
                                    Unit unit31 = Unit.INSTANCE;
                                    Unit unit32 = Unit.INSTANCE;
                                }
                            } else {
                                loadingImageView.loadImage(normal);
                                Unit unit33 = Unit.INSTANCE;
                                Unit unit34 = Unit.INSTANCE;
                            }
                        }
                        View viewInflate2 = editCardDialogFragment.getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
                        RecyclerView recyclerView = (RecyclerView) viewInflate2.findViewById(R.id.language_recycler_view);
                        recyclerView.setLayoutManager(new LinearLayoutManager(editCardDialogFragment.requireContext()));
                        PopupWindow popupWindow = new PopupWindow(viewInflate2, -2, -2);
                        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                        popupWindow.setOutsideTouchable(true);
                        ArrayList arrayList = new ArrayList();
                        List<String> available_lang = mTFullCard.getAvailable_lang();
                        if (available_lang == null) {
                            available_lang = CollectionsKt.listOf("en");
                        }
                        for (String str4 : available_lang) {
                            arrayList.add(new LanguageRow(str4, preferencesManager2.getNameForLanguage(str4)));
                            preferencesManager2 = preferencesManager2;
                        }
                        recyclerView.setAdapter(new LanguageAdapter(arrayList, editCardDialogFragment));
                        editCardDialogFragment.popupWindow = popupWindow;
                        ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditCardDialogFragment.onCreateView$lambda$2$21(this.f$0, linearLayout);
                            }
                        });
                        View viewInflate3 = editCardDialogFragment.getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
                        RecyclerView recyclerView2 = (RecyclerView) viewInflate3.findViewById(R.id.language_recycler_view);
                        recyclerView2.setLayoutManager(new LinearLayoutManager(editCardDialogFragment.requireContext()));
                        final PopupWindow popupWindow2 = new PopupWindow(viewInflate3, -2, -2);
                        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
                        popupWindow2.setOutsideTouchable(true);
                        recyclerView2.setAdapter(new ConditionAdapter(CollectionsKt.mutableListOf("M", str2, GameUtils.CONDITION_EXCELENT, GameUtils.CONDITION_GOOD, GameUtils.CONDITION_LIGHT_PLAYED, GameUtils.CONDITION_PLAYED, GameUtils.CONDITION_POOR), editCardDialogFragment));
                        editCardDialogFragment.conditionPopupWindow = popupWindow2;
                        ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditCardDialogFragment.onCreateView$lambda$2$22(popupWindow2, linearLayout2);
                            }
                        });
                        View viewInflate4 = editCardDialogFragment.getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
                        RecyclerView recyclerView3 = (RecyclerView) viewInflate4.findViewById(R.id.language_recycler_view);
                        recyclerView3.setLayoutManager(new LinearLayoutManager(editCardDialogFragment.requireContext()));
                        final PopupWindow popupWindow3 = new PopupWindow(viewInflate4, -2, -2);
                        popupWindow3.setBackgroundDrawable(new ColorDrawable(0));
                        popupWindow3.setOutsideTouchable(true);
                        ArrayList arrayList2 = new ArrayList();
                        List<String> finishes2 = mTFullCard.getFinishes();
                        if (finishes2 != null ? finishes2.contains("nonfoil") : false) {
                            String string = editCardDialogFragment.getResources().getString(R.string.non_foil);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            arrayList2.add(string);
                        }
                        List<String> finishes3 = mTFullCard.getFinishes();
                        if (finishes3 != null ? finishes3.contains("foil") : false) {
                            String string2 = editCardDialogFragment.getResources().getString(R.string.foil);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            arrayList2.add(string2);
                        }
                        List<String> finishes4 = mTFullCard.getFinishes();
                        if (finishes4 != null ? finishes4.contains("etched") : false) {
                            String string3 = editCardDialogFragment.getResources().getString(R.string.etched);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            arrayList2.add(string3);
                        }
                        recyclerView3.setAdapter(new FinishAdapter(arrayList2, editCardDialogFragment));
                        editCardDialogFragment.finishPopupWindow = popupWindow3;
                        ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditCardDialogFragment.onCreateView$lambda$2$23(mTFullCard, editCardDialogFragment, popupWindow3, linearLayout3);
                            }
                        });
                        ViewExtensionsKt.setOnClickWithFade(linearLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditCardDialogFragment.onCreateView$lambda$2$24(this.f$0, mTFullCard);
                            }
                        });
                        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda18
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                                EditCardDialogFragment.onCreateView$lambda$2$25(this.f$0, compoundButton, z2);
                            }
                        });
                        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda19
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                                EditCardDialogFragment.onCreateView$lambda$2$26(this.f$0, compoundButton, z2);
                            }
                        });
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda20
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                                EditCardDialogFragment.onCreateView$lambda$2$27(this.f$0, compoundButton, z2);
                            }
                        });
                        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda21
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                                EditCardDialogFragment.onCreateView$lambda$2$28(this.f$0, compoundButton, z2);
                            }
                        });
                        Unit unit35 = Unit.INSTANCE;
                        Unit unit36 = Unit.INSTANCE;
                    }
                }
            }
        } else {
            view = viewInflate;
        }
        if (!editCardDialogFragment.deckMode || editCardDialogFragment.deck == null) {
            return view;
        }
        Intrinsics.checkNotNull(view);
        View view2 = view;
        editCardDialogFragment.setupDeckListSelection(view2);
        return view2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDimissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.studiolaganne.lengendarylens.FinishClickListener
    public void onFinishClick(String finish) {
        MTFullCard mTFullCardCopy$default;
        Editable text;
        String string;
        Intrinsics.checkNotNullParameter(finish, "finish");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        PopupWindow popupWindow = this.finishPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (Intrinsics.areEqual(finish, getResources().getString(R.string.foil))) {
            this.newFinish = "foil";
        } else if (Intrinsics.areEqual(finish, getResources().getString(R.string.etched))) {
            this.newFinish = "etched";
        } else {
            this.newFinish = "nonfoil";
        }
        Dialog dialog = getDialog();
        String string2 = null;
        TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.selectedFinishTextView) : null;
        Dialog dialog2 = getDialog();
        ImageView imageView = dialog2 != null ? (ImageView) dialog2.findViewById(R.id.foil_image) : null;
        Dialog dialog3 = getDialog();
        ImageView imageView2 = dialog3 != null ? (ImageView) dialog3.findViewById(R.id.foilEffectImage) : null;
        String str = this.newFinish;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "foil")) {
                if (textView != null) {
                    textView.setText(getResources().getString(R.string.foil));
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            } else {
                String lowerCase2 = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase2, "etched")) {
                    if (textView != null) {
                        textView.setText(getResources().getString(R.string.etched));
                    }
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                } else {
                    if (textView != null) {
                        textView.setText(getResources().getString(R.string.non_foil));
                    }
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                }
            }
        }
        if (this.showPurchasePrice) {
            View view = getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.purchasePriceEditText) : null;
            if (editText != null && (text = editText.getText()) != null && (string = text.toString()) != null) {
                string2 = StringsKt.trim((CharSequence) string).toString();
            }
            String str2 = string2;
            if (str2 == null || str2.length() == 0) {
                String preferredMarket = preferencesManager.getPreferredMarket();
                String preferredCurrency = preferencesManager.getPreferredCurrency();
                MTFullCard mTFullCard = this.newCard;
                if (mTFullCard == null) {
                    mTFullCard = this.card;
                }
                MTFullCard mTFullCard2 = mTFullCard;
                if (mTFullCard2 == null || (mTFullCardCopy$default = MTFullCard.copy$default(mTFullCard2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.newFinish, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, -1, 127, null)) == null) {
                    return;
                }
                double cardPrice = GameUtils.INSTANCE.getInstance().getCardPrice(mTFullCardCopy$default, preferredMarket);
                if (editText != null) {
                    editText.setHint(GameUtils.INSTANCE.getInstance().formatPriceAmountOnly(cardPrice, preferredCurrency));
                }
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LanguageClickListener
    public void onLanguageClick(final String language) {
        Context context;
        Context context2;
        Intrinsics.checkNotNullParameter(language, "language");
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        MTFullCard mTFullCard = this.card;
        String packageName = null;
        if (Intrinsics.areEqual(mTFullCard != null ? mTFullCard.getLang() : null, language) || Intrinsics.areEqual(this.newLanguage, language)) {
            return;
        }
        this.newLanguage = language;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTFullCard mTFullCard2 = this.card;
        MTFullCard mTFullCard3 = this.newCard;
        if (mTFullCard3 != null) {
            mTFullCard2 = mTFullCard3;
        }
        if (mTFullCard2 != null) {
            MTApi mtApi = MTApiKt.getMtApi();
            String set_code = mTFullCard2.getSet_code();
            if (set_code == null) {
                set_code = "";
            }
            String collector_number = mTFullCard2.getCollector_number();
            String str = collector_number != null ? collector_number : "";
            MTUser currentUser = preferencesManager.getCurrentUser();
            mtApi.getCardWithParameters(language, set_code, str, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$onLanguageClick$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    Log.e("EditCardDialogFragment", "Failed to fetch card details for language " + language, t);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    MTFullCardResponse mTFullCardResponseBody = response.body();
                    MTFullCard card = mTFullCardResponseBody != null ? mTFullCardResponseBody.getCard() : null;
                    if (card != null) {
                        EditCardDialogFragment editCardDialogFragment = this.this$0;
                        editCardDialogFragment.newCard = card;
                        editCardDialogFragment.updateCardDetails(card);
                    }
                }
            });
        }
        Dialog dialog = getDialog();
        TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.selectedLanguageTextView) : null;
        Dialog dialog2 = getDialog();
        ImageView imageView = dialog2 != null ? (ImageView) dialog2.findViewById(R.id.flag_image) : null;
        if (textView != null) {
            textView.setText(preferencesManager.getNameForLanguage(language));
        }
        Resources resources = getResources();
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int identifier = resources.getIdentifier("flag_" + lowerCase, "drawable", (imageView == null || (context2 = imageView.getContext()) == null) ? null : context2.getPackageName());
        if (identifier == 0) {
            Resources resources2 = getResources();
            if (imageView != null && (context = imageView.getContext()) != null) {
                packageName = context.getPackageName();
            }
            identifier = resources2.getIdentifier("flag_default", "drawable", packageName);
        }
        if (imageView != null) {
            imageView.setImageResource(identifier);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        final Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        final int iMin = Math.min((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), (int) (480.0f * getResources().getDisplayMetrics().density));
        window.setLayout(iMin, -2);
        window.setDimAmount(0.9f);
        window.getDecorView().post(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditCardDialogFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                EditCardDialogFragment.onStart$lambda$0$0(this.f$0, window, iMin);
            }
        });
    }

    public final void updatePrint(MTFullCard newCard) {
        Intrinsics.checkNotNullParameter(newCard, "newCard");
        if (getContext() == null) {
            return;
        }
        this.newCard = newCard;
        updateCardDetails(newCard);
    }
}
