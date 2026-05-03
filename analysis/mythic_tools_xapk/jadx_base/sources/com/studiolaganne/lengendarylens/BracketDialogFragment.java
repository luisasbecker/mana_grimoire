package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: BracketDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u0001:\u0003CDEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\rH\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J0\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\r2\u0006\u0010,\u001a\u00020$H\u0002J\u001a\u00103\u001a\u00020\r2\u0006\u0010,\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u001a\u00106\u001a\u00020\r2\u0006\u0010,\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00192\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0019H\u0002J&\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020<2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020<0\u00192\u0006\u0010@\u001a\u00020$H\u0002J\u0016\u0010A\u001a\u00020\r2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020:0\u0019H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R7\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "selectedBracket", "", "getSelectedBracket", "()Ljava/lang/Integer;", "setSelectedBracket", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onCloseCallback", "Lkotlin/Function1;", "", "getOnCloseCallback", "()Lkotlin/jvm/functions/Function1;", "setOnCloseCallback", "(Lkotlin/jvm/functions/Function1;)V", "onBracketRecalculated", "Lkotlin/ParameterName;", "name", "newSuggested", "getOnBracketRecalculated", "setOnBracketRecalculated", "bracketLayouts", "", "Landroidx/constraintlayout/widget/ConstraintLayout;", "defaultDrawable", "Landroid/graphics/drawable/Drawable;", "selectedDrawable", "recalcRotationAnimator", "Landroid/animation/ObjectAnimator;", "isRecalcInProgress", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "startBracketRecalc", ViewHierarchyConstants.VIEW_KEY, "iconView", "Landroid/widget/TextView;", "recalcHintLinearLayout", "manualRecalcButtonLayout", "deckId", "updateSelectionUI", "setupAutoBracketSection", "bracket", "Lcom/studiolaganne/lengendarylens/MTBracket;", "setupMetricRowTaps", "m", "Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "resolveCardsByName", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "names", "", "showCardListPopup", Constants.GP_IAP_TITLE, "cardNames", "anchorView", "openCardsInViewer", "cards", "Companion", "SimpleCardNameAdapter", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BracketDialogFragment extends DialogFragment {
    private static final String ARG_BRACKET_JSON = "bracket_json";
    private static final String ARG_DECK_ID = "deck_id";
    private static final int ARG_DECK_ID_NONE = -1;
    private static final String ARG_INITIAL_USER_BRACKET = "initial_user_bracket";
    private static final int ARG_INITIAL_USER_BRACKET_NONE = -1;
    private List<? extends ConstraintLayout> bracketLayouts;
    private Drawable defaultDrawable;
    private boolean isRecalcInProgress;
    private Function1<? super Integer, Unit> onBracketRecalculated;
    private Function1<? super Integer, Unit> onCloseCallback;
    private ObjectAnimator recalcRotationAnimator;
    private Integer selectedBracket;
    private Drawable selectedDrawable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static List<MTFullCard> deckCardList = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: BracketDialogFragment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0013\u001a\u00020\u00002\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u001e\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketDialogFragment$Builder;", "", "<init>", "()V", "bracketInfo", "Lcom/studiolaganne/lengendarylens/MTBracket;", "initialUserBracket", "", "Ljava/lang/Integer;", "deckId", "onCloseCallback", "Lkotlin/Function1;", "", "onBracketRecalculated", "setBracketInfo", "bracket", "setInitialUserBracket", "(Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/BracketDialogFragment$Builder;", "setDeckId", "setOnCloseCallback", "callback", "setOnBracketRecalculated", "build", "Lcom/studiolaganne/lengendarylens/BracketDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private MTBracket bracketInfo;
        private Integer deckId;
        private Integer initialUserBracket;
        private Function1<? super Integer, Unit> onBracketRecalculated;
        private Function1<? super Integer, Unit> onCloseCallback;

        public final BracketDialogFragment build() {
            BracketDialogFragment bracketDialogFragment = new BracketDialogFragment();
            Bundle bundle = new Bundle();
            MTBracket mTBracket = this.bracketInfo;
            if (mTBracket != null) {
                bundle.putString(BracketDialogFragment.ARG_BRACKET_JSON, new Gson().toJson(mTBracket));
            }
            Integer num = this.initialUserBracket;
            int iIntValue = -1;
            if (num != null) {
                bundle.putInt(BracketDialogFragment.ARG_INITIAL_USER_BRACKET, num.intValue());
            } else {
                bundle.putInt(BracketDialogFragment.ARG_INITIAL_USER_BRACKET, -1);
            }
            Integer num2 = this.deckId;
            if (num2 != null) {
                if (num2.intValue() <= 0) {
                    num2 = null;
                }
                if (num2 != null) {
                    iIntValue = num2.intValue();
                }
            }
            bundle.putInt(BracketDialogFragment.ARG_DECK_ID, iIntValue);
            bracketDialogFragment.setArguments(bundle);
            bracketDialogFragment.setOnCloseCallback(this.onCloseCallback);
            bracketDialogFragment.setOnBracketRecalculated(this.onBracketRecalculated);
            return bracketDialogFragment;
        }

        public final Builder setBracketInfo(MTBracket bracket) {
            this.bracketInfo = bracket;
            return this;
        }

        public final Builder setDeckId(Integer deckId) {
            this.deckId = deckId;
            return this;
        }

        public final Builder setInitialUserBracket(Integer bracket) {
            this.initialUserBracket = bracket;
            return this;
        }

        public final Builder setOnBracketRecalculated(Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onBracketRecalculated = callback;
            return this;
        }

        public final Builder setOnCloseCallback(Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onCloseCallback = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: compiled from: BracketDialogFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketDialogFragment$Companion;", "", "<init>", "()V", "ARG_BRACKET_JSON", "", "ARG_INITIAL_USER_BRACKET", "ARG_INITIAL_USER_BRACKET_NONE", "", "ARG_DECK_ID", "ARG_DECK_ID_NONE", "deckCardList", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getDeckCardList", "()Ljava/util/List;", "setDeckCardList", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<MTFullCard> getDeckCardList() {
            return BracketDialogFragment.deckCardList;
        }

        public final void setDeckCardList(List<MTFullCard> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            BracketDialogFragment.deckCardList = list;
        }
    }

    /* JADX INFO: compiled from: BracketDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketDialogFragment$SimpleCardNameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/BracketDialogFragment$SimpleCardNameAdapter$VH;", "names", "", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "VH", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class SimpleCardNameAdapter extends RecyclerView.Adapter<VH> {
        private final List<String> names;

        /* JADX INFO: compiled from: BracketDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketDialogFragment$SimpleCardNameAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cardName", "Landroid/widget/TextView;", "getCardName", "()Landroid/widget/TextView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class VH extends RecyclerView.ViewHolder {
            public static final int $stable = 8;
            private final TextView cardName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VH(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                View viewFindViewById = view.findViewById(R.id.cardName);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.cardName = (TextView) viewFindViewById;
            }

            public final TextView getCardName() {
                return this.cardName;
            }
        }

        public SimpleCardNameAdapter(List<String> names) {
            Intrinsics.checkNotNullParameter(names, "names");
            this.names = names;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.names.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getCardName().setText(this.names.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_card_name_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new VH(viewInflate);
        }
    }

    /* JADX INFO: compiled from: BracketDialogFragment.kt */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"com/studiolaganne/lengendarylens/BracketDialogFragment$setupMetricRowTaps$MetricRow", "", "viewId", "", "titleResId", "count", "cards", "", "Lcom/studiolaganne/lengendarylens/MTBracketMetricsCard;", "<init>", "(IIILjava/util/List;)V", "getViewId", "()I", "getTitleResId", "getCount", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(IIILjava/util/List;)Lcom/studiolaganne/lengendarylens/BracketDialogFragment$setupMetricRowTaps$MetricRow;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MetricRow {
        private final List<MTBracketMetricsCard> cards;
        private final int count;
        private final int titleResId;
        private final int viewId;

        public MetricRow(int i, int i2, int i3, List<MTBracketMetricsCard> list) {
            this.viewId = i;
            this.titleResId = i2;
            this.count = i3;
            this.cards = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MetricRow copy$default(MetricRow metricRow, int i, int i2, int i3, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = metricRow.viewId;
            }
            if ((i4 & 2) != 0) {
                i2 = metricRow.titleResId;
            }
            if ((i4 & 4) != 0) {
                i3 = metricRow.count;
            }
            if ((i4 & 8) != 0) {
                list = metricRow.cards;
            }
            return metricRow.copy(i, i2, i3, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final List<MTBracketMetricsCard> component4() {
            return this.cards;
        }

        public final MetricRow copy(int viewId, int titleResId, int count, List<MTBracketMetricsCard> cards) {
            return new MetricRow(viewId, titleResId, count, cards);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MetricRow)) {
                return false;
            }
            MetricRow metricRow = (MetricRow) other;
            return this.viewId == metricRow.viewId && this.titleResId == metricRow.titleResId && this.count == metricRow.count && Intrinsics.areEqual(this.cards, metricRow.cards);
        }

        public final List<MTBracketMetricsCard> getCards() {
            return this.cards;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.viewId) * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.count)) * 31;
            List<MTBracketMetricsCard> list = this.cards;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "MetricRow(viewId=" + this.viewId + ", titleResId=" + this.titleResId + ", count=" + this.count + ", cards=" + this.cards + ")";
        }
    }

    static final Unit onCreateView$lambda$3(BracketDialogFragment bracketDialogFragment, View view, TextView textView, View view2, View view3, Integer num) {
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(view2);
        Intrinsics.checkNotNull(view3);
        bracketDialogFragment.startBracketRecalc(view, textView, view2, view3, num.intValue());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(BracketDialogFragment bracketDialogFragment, View view, TextView textView, View view2, View view3, Integer num) {
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(view2);
        Intrinsics.checkNotNull(view3);
        bracketDialogFragment.startBracketRecalc(view, textView, view2, view3, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$5$0(BracketDialogFragment bracketDialogFragment, int i, View view) {
        bracketDialogFragment.selectedBracket = Integer.valueOf(i + 1);
        Intrinsics.checkNotNull(view);
        bracketDialogFragment.updateSelectionUI(view);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(BracketDialogFragment bracketDialogFragment, View view) {
        bracketDialogFragment.selectedBracket = null;
        Intrinsics.checkNotNull(view);
        bracketDialogFragment.updateSelectionUI(view);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(BracketDialogFragment bracketDialogFragment) {
        Function1<? super Integer, Unit> function1 = bracketDialogFragment.onCloseCallback;
        if (function1 != null) {
            function1.invoke(bracketDialogFragment.selectedBracket);
        }
        bracketDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(BracketDialogFragment bracketDialogFragment) {
        if (!bracketDialogFragment.getChildFragmentManager().isStateSaved()) {
            new BracketHelpDialogFragment().show(bracketDialogFragment.getChildFragmentManager(), "BracketHelpDialogFragment");
        }
        return Unit.INSTANCE;
    }

    private final void openCardsInViewer(List<MTFullCard> cards) {
        Context context = getContext();
        if (context == null || cards.isEmpty()) {
            return;
        }
        CardDataStore.INSTANCE.setMtCardList(cards);
        Intent intent = new Intent(context, (Class<?>) CardActivity.class);
        intent.putExtra("singleMTCard", new Gson().toJson(CollectionsKt.first((List) cards)));
        intent.putExtra("hasMTCards", true);
        intent.putExtra("currentMTIndex", 0);
        startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MTFullCard> resolveCardsByName(List<String> names) {
        boolean zContains;
        List<String> list = names;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<MTFullCard> list2 = deckCardList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list2) {
            MTFullCard mTFullCard = (MTFullCard) obj;
            String name = mTFullCard.getName();
            if (name == null) {
                name = mTFullCard.getPrinted_name();
            }
            if (name != null) {
                String lowerCase2 = name.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                zContains = lowerCase2 == null ? false : set.contains(lowerCase2);
            }
            if (zContains) {
                arrayList2.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            MTFullCard mTFullCard2 = (MTFullCard) obj2;
            String oracleid = mTFullCard2.getOracleid();
            if (oracleid == null) {
                oracleid = mTFullCard2.getScryfallid();
            }
            if (hashSet.add(oracleid)) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupAutoBracketSection(View view, MTBracket bracket) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.autoBracketLayout);
        if (bracket == null) {
            constraintLayout.setVisibility(8);
            return;
        }
        constraintLayout.setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.bracketValueTextView);
        TextView textView2 = (TextView) view.findViewById(R.id.bracketNameTextView);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.autoBracketIconLayout);
        Integer auto = bracket.getAuto();
        if (auto != null) {
            int iIntValue = auto.intValue();
            textView.setText(String.valueOf(iIntValue));
            textView2.setText(iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? iIntValue != 5 ? getString(R.string.bracket_caps) : getString(R.string.cedh_caps) : getString(R.string.optimized_caps) : getString(R.string.upgraded_caps) : getString(R.string.core_caps) : getString(R.string.exhibition_caps));
            constraintLayout2.setVisibility(0);
        } else {
            textView.setText("?");
            textView2.setText(getString(R.string.bracket_caps));
            constraintLayout2.setVisibility(0);
        }
        MTBracketMetrics metrics = bracket.getMetrics();
        ((TextView) view.findViewById(R.id.gameChangersValue)).setText(String.valueOf(metrics != null ? metrics.getGameChangerCount() : 0));
        ((TextView) view.findViewById(R.id.twoCardCombosValue)).setText(String.valueOf(metrics != null ? metrics.getTwoCardComboCount() : 0));
        ((TextView) view.findViewById(R.id.fastManaValue)).setText(String.valueOf(metrics != null ? metrics.getFastManaCount() : 0));
        ((TextView) view.findViewById(R.id.tutorsValue)).setText(String.valueOf(metrics != null ? metrics.getUniversalTutorCount() : 0));
        ((TextView) view.findViewById(R.id.extraTurnsValue)).setText(String.valueOf(metrics != null ? metrics.getExtraTurnCount() : 0));
        ((TextView) view.findViewById(R.id.massLandDenialValue)).setText(String.valueOf(metrics != null ? metrics.getMassLandDenialCount() : 0));
        setupMetricRowTaps(view, metrics);
    }

    private final void setupMetricRowTaps(View view, MTBracketMetrics m) {
        List<MTBracketMetricsCard> list;
        if (m == null) {
            return;
        }
        for (final MetricRow metricRow : CollectionsKt.listOf((Object[]) new MetricRow[]{new MetricRow(R.id.line1Left, R.string.game_changers, m.getGameChangerCount(), m.getGameChangerCards()), new MetricRow(R.id.line1Right, R.string.two_card_combos, m.getTwoCardComboCount(), m.getTwoCardComboCards()), new MetricRow(R.id.line2Left, R.string.fast_mana, m.getFastManaCount(), m.getFastManaCards()), new MetricRow(R.id.line2Right, R.string.tutors, m.getUniversalTutorCount(), m.getUniversalTutorCards()), new MetricRow(R.id.line3Left, R.string.extra_turns, m.getExtraTurnCount(), m.getExtraTurnCards()), new MetricRow(R.id.line3Right, R.string.mass_land_denial, m.getMassLandDenialCount(), m.getMassLandDenialCards())})) {
            final LinearLayout linearLayout = (LinearLayout) view.findViewById(metricRow.getViewId());
            if (linearLayout != null) {
                final List<MTBracketMetricsCard> cards = metricRow.getCards();
                if (metricRow.getCount() > 0 && (list = cards) != null && !list.isEmpty()) {
                    ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BracketDialogFragment.setupMetricRowTaps$lambda$0(cards, this, metricRow, linearLayout);
                        }
                    });
                }
            }
        }
    }

    static final Unit setupMetricRowTaps$lambda$0(List list, BracketDialogFragment bracketDialogFragment, MetricRow metricRow, LinearLayout linearLayout) {
        List<MTBracketMetricsCard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MTBracketMetricsCard mTBracketMetricsCard : list2) {
            String printed_name = mTBracketMetricsCard.getPrinted_name();
            if (printed_name == null && (printed_name = mTBracketMetricsCard.getName()) == null) {
                printed_name = "?";
            }
            arrayList.add(printed_name);
        }
        String string = bracketDialogFragment.getString(R.string.auto_tag_card_count, bracketDialogFragment.getString(metricRow.getTitleResId()), Integer.valueOf(metricRow.getCount()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        bracketDialogFragment.showCardListPopup(string, arrayList, linearLayout);
        return Unit.INSTANCE;
    }

    private final void showCardListPopup(String title, List<String> cardNames, View anchorView) {
        final List<MTFullCard> listResolveCardsByName = resolveCardsByName(cardNames);
        if (listResolveCardsByName.isEmpty() && cardNames.isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        View viewInflate = getLayoutInflater().inflate(R.layout.auto_tag_card_list_popup, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.popupTagTitle);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.popupCardList);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.popupCloseButton);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.popupViewAllButton);
        textView.setText(title);
        recyclerView.setLayoutManager(new LinearLayoutManager(contextRequireContext));
        List<MTFullCard> list = listResolveCardsByName;
        if (!list.isEmpty()) {
            List<MTFullCard> list2 = listResolveCardsByName;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (MTFullCard mTFullCard : list2) {
                String name = mTFullCard.getName();
                if (name == null && (name = mTFullCard.getPrinted_name()) == null) {
                    name = "?";
                }
                arrayList.add(name);
            }
            cardNames = arrayList;
        }
        recyclerView.setAdapter(new SimpleCardNameAdapter(cardNames));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        float f = displayMetrics.density;
        recyclerView.measure(View.MeasureSpec.makeMeasureSpec((int) (280.0f * f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        recyclerView.getLayoutParams().height = RangesKt.coerceAtMost(recyclerView.getMeasuredHeight(), (i / 2) - ((int) (136.0f * f)));
        final PopupWindow popupWindow = new PopupWindow(viewInflate, (int) (i2 * 0.9f), -2, true);
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(contextRequireContext, android.R.color.transparent));
        popupWindow.setElevation(12.0f);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BracketDialogFragment.showCardListPopup$lambda$1(popupWindow);
            }
        });
        if (list.isEmpty()) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            Intrinsics.checkNotNull(textView2);
            ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BracketDialogFragment.showCardListPopup$lambda$2(popupWindow, this, listResolveCardsByName);
                }
            });
        }
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
        int measuredHeight = viewInflate.getMeasuredHeight();
        int[] iArr = new int[2];
        anchorView.getLocationOnScreen(iArr);
        if (i - (iArr[1] + anchorView.getHeight()) >= iArr[1]) {
            popupWindow.showAsDropDown(anchorView, 0, 8);
        } else {
            popupWindow.showAsDropDown(anchorView, 0, -(measuredHeight + anchorView.getHeight() + 8));
        }
    }

    static final Unit showCardListPopup$lambda$1(PopupWindow popupWindow) {
        popupWindow.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit showCardListPopup$lambda$2(PopupWindow popupWindow, BracketDialogFragment bracketDialogFragment, List list) {
        popupWindow.dismiss();
        bracketDialogFragment.openCardsInViewer(list);
        return Unit.INSTANCE;
    }

    private final void startBracketRecalc(final View view, TextView iconView, final View recalcHintLinearLayout, final View manualRecalcButtonLayout, int deckId) {
        if (this.isRecalcInProgress) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            int id = currentUser.getId();
            this.isRecalcInProgress = true;
            ObjectAnimator objectAnimator = this.recalcRotationAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(iconView, (Property<TextView, Float>) View.ROTATION, 0.0f, 360.0f);
            objectAnimatorOfFloat.setDuration(800L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat.start();
            this.recalcRotationAnimator = objectAnimatorOfFloat;
            MTApiKt.getMtApi().updateDeckBracketSuggestion(id, deckId, true).enqueue(new Callback<MTBracketSuggestionResponse>() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment.startBracketRecalc.2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTBracketSuggestionResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ObjectAnimator objectAnimator2 = BracketDialogFragment.this.recalcRotationAnimator;
                    if (objectAnimator2 != null) {
                        objectAnimator2.cancel();
                    }
                    BracketDialogFragment.this.recalcRotationAnimator = null;
                    BracketDialogFragment.this.isRecalcInProgress = false;
                    Toast.makeText(BracketDialogFragment.this.requireContext(), BracketDialogFragment.this.getString(R.string.bracket_recalc_error), 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTBracketSuggestionResponse> call, Response<MTBracketSuggestionResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    ObjectAnimator objectAnimator2 = BracketDialogFragment.this.recalcRotationAnimator;
                    if (objectAnimator2 != null) {
                        objectAnimator2.cancel();
                    }
                    BracketDialogFragment.this.recalcRotationAnimator = null;
                    BracketDialogFragment.this.isRecalcInProgress = false;
                    if (!response.isSuccessful()) {
                        Toast.makeText(BracketDialogFragment.this.requireContext(), BracketDialogFragment.this.getString(R.string.bracket_recalc_error), 0).show();
                        return;
                    }
                    MTBracketSuggestionResponse mTBracketSuggestionResponseBody = response.body();
                    if (mTBracketSuggestionResponseBody != null) {
                        BracketDialogFragment bracketDialogFragment = BracketDialogFragment.this;
                        View view2 = view;
                        View view3 = recalcHintLinearLayout;
                        View view4 = manualRecalcButtonLayout;
                        bracketDialogFragment.setupAutoBracketSection(view2, new MTBracket(null, Integer.valueOf(mTBracketSuggestionResponseBody.getSuggested()), null, null, mTBracketSuggestionResponseBody.getMetrics(), 13, null));
                        view3.setVisibility(8);
                        view4.setVisibility(0);
                        Function1<Integer, Unit> onBracketRecalculated = bracketDialogFragment.getOnBracketRecalculated();
                        if (onBracketRecalculated != null) {
                            onBracketRecalculated.invoke(Integer.valueOf(mTBracketSuggestionResponseBody.getSuggested()));
                        }
                        Toast.makeText(bracketDialogFragment.requireContext(), bracketDialogFragment.getString(R.string.bracket_recalc_success), 0).show();
                    }
                }
            });
        }
    }

    private final void updateSelectionUI(View view) {
        Drawable drawable;
        Drawable drawable2;
        List<? extends ConstraintLayout> list = this.bracketLayouts;
        if (list == null || (drawable = this.defaultDrawable) == null || (drawable2 = this.selectedDrawable) == null) {
            return;
        }
        int i = 1;
        while (i < 6) {
            ConstraintLayout constraintLayout = list.get(i - 1);
            Integer num = this.selectedBracket;
            constraintLayout.setBackground((num != null && num.intValue() == i) ? drawable2 : drawable);
            i++;
        }
    }

    public final Function1<Integer, Unit> getOnBracketRecalculated() {
        return this.onBracketRecalculated;
    }

    public final Function1<Integer, Unit> getOnCloseCallback() {
        return this.onCloseCallback;
    }

    public final Integer getSelectedBracket() {
        return this.selectedBracket;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0145  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Integer numValueOf;
        final Integer num;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.dialog_bracket, container, false);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_BRACKET_JSON) : null;
        MTBracket mTBracket = string != null ? (MTBracket) new Gson().fromJson(string, MTBracket.class) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            numValueOf = Integer.valueOf(arguments2.getInt(ARG_INITIAL_USER_BRACKET, -1));
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
        }
        this.selectedBracket = numValueOf;
        this.defaultDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.purple_box_with_line);
        this.selectedDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.purple_box_with_line_selected);
        this.bracketLayouts = CollectionsKt.listOf((Object[]) new ConstraintLayout[]{viewInflate.findViewById(R.id.bracket1Layout), viewInflate.findViewById(R.id.bracket2Layout), viewInflate.findViewById(R.id.bracket3Layout), viewInflate.findViewById(R.id.bracket4Layout), viewInflate.findViewById(R.id.bracket5Layout)});
        Intrinsics.checkNotNull(viewInflate);
        updateSelectionUI(viewInflate);
        setupAutoBracketSection(viewInflate, mTBracket);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            Integer numValueOf2 = Integer.valueOf(arguments3.getInt(ARG_DECK_ID, -1));
            num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        }
        final View viewFindViewById = viewInflate.findViewById(R.id.recalcHintLinearLayout);
        final View viewFindViewById2 = viewInflate.findViewById(R.id.manualRecalcButtonLayout);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (num == null) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
        } else if ((currentUser != null ? Integer.valueOf(currentUser.getId()) : null) != null && currentUser.getId() >= 0) {
            if (mTBracket != null ? Intrinsics.areEqual((Object) mTBracket.getNeeds_recalc(), (Object) true) : false) {
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(8);
                final TextView textView = (TextView) viewInflate.findViewById(R.id.recalcTextView);
                final TextView textView2 = (TextView) viewInflate.findViewById(R.id.manualRecalcTextView);
                Intrinsics.checkNotNull(viewFindViewById);
                ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BracketDialogFragment.onCreateView$lambda$3(this.f$0, viewInflate, textView, viewFindViewById, viewFindViewById2, num);
                    }
                });
                Intrinsics.checkNotNull(viewFindViewById2);
                ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BracketDialogFragment.onCreateView$lambda$4(this.f$0, viewInflate, textView2, viewFindViewById, viewFindViewById2, num);
                    }
                });
            } else {
                if ((mTBracket != null ? mTBracket.getAuto() : null) != null) {
                    viewFindViewById.setVisibility(8);
                    viewFindViewById2.setVisibility(0);
                }
                final TextView textView3 = (TextView) viewInflate.findViewById(R.id.recalcTextView);
                final TextView textView22 = (TextView) viewInflate.findViewById(R.id.manualRecalcTextView);
                Intrinsics.checkNotNull(viewFindViewById);
                ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BracketDialogFragment.onCreateView$lambda$3(this.f$0, viewInflate, textView3, viewFindViewById, viewFindViewById2, num);
                    }
                });
                Intrinsics.checkNotNull(viewFindViewById2);
                ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BracketDialogFragment.onCreateView$lambda$4(this.f$0, viewInflate, textView22, viewFindViewById, viewFindViewById2, num);
                    }
                });
            }
        }
        final int i = 0;
        for (Object obj : CollectionsKt.listOf((Object[]) new ConstraintLayout[]{viewInflate.findViewById(R.id.bracket1Layout), viewInflate.findViewById(R.id.bracket2Layout), viewInflate.findViewById(R.id.bracket3Layout), viewInflate.findViewById(R.id.bracket4Layout), viewInflate.findViewById(R.id.bracket5Layout)})) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) obj;
            Intrinsics.checkNotNull(constraintLayout);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BracketDialogFragment.onCreateView$lambda$5$0(this.f$0, i, viewInflate);
                }
            });
            i = i2;
        }
        View viewFindViewById3 = viewInflate.findViewById(R.id.clear_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BracketDialogFragment.onCreateView$lambda$6(this.f$0, viewInflate);
            }
        });
        View viewFindViewById4 = viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BracketDialogFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        View viewFindViewById5 = viewInflate.findViewById(R.id.helpTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById5, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BracketDialogFragment.onCreateView$lambda$8(this.f$0);
            }
        });
        setCancelable(true);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
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
        window.setDimAmount(0.95f);
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.85d));
    }

    public final void setOnBracketRecalculated(Function1<? super Integer, Unit> function1) {
        this.onBracketRecalculated = function1;
    }

    public final void setOnCloseCallback(Function1<? super Integer, Unit> function1) {
        this.onCloseCallback = function1;
    }

    public final void setSelectedBracket(Integer num) {
        this.selectedBracket = num;
    }
}
