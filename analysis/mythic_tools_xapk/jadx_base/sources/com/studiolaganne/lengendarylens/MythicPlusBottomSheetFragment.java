package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment;
import com.studiolaganne.lengendarylens.MythicPlusLockedFragment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002MNB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u0004\u0018\u00010\nJ\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010-\u001a\u00020.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0006\u00107\u001a\u00020.J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0016\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<J\b\u0010>\u001a\u00020.H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u0013H\u0002J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\u000e\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020<J\u000e\u0010E\u001a\u00020.2\u0006\u0010D\u001a\u00020<J\u001e\u0010F\u001a\u00020.2\u0006\u0010D\u001a\u00020<2\u0006\u0010G\u001a\u00020<2\u0006\u0010;\u001a\u00020<J\u000e\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020<J\u000e\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020<J\u0016\u0010L\u001a\u00020.2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "isManuallyHidden", "", "()Z", "setManuallyHidden", "(Z)V", "callback", "Lcom/studiolaganne/lengendarylens/MythicPlusCallback;", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "isSmartDeck", "hasSmartDeck", "currentTab", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment$Tab;", "tabSearchLayout", "Landroid/widget/LinearLayout;", "tabSearchIcon", "Landroid/widget/TextView;", "tabSearchLabel", "tabRecsLayout", "tabRecsIcon", "tabRecsLabel", "tabEvalLayout", "tabEvalIcon", "tabEvalLabel", "toastLabel", "searchFragment", "Lcom/studiolaganne/lengendarylens/MythicPlusSearchFragment;", "recommendationsFragment", "Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment;", "evaluationsFragment", "Lcom/studiolaganne/lengendarylens/MythicPlusEvaluationsFragment;", "lockedFragment", "Lcom/studiolaganne/lengendarylens/MythicPlusLockedFragment;", "getCallback", "getDeckId", "getMainListId", "getSideboardListId", "getMaybeboardListId", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "hide", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showAddedToast", "cardName", "", "listType", "setupTabs", "selectTab", "tab", "collapseTabLabels", "expandTabLabels", "markCardAsAdded", "oracleId", "markCardAsActed", "openSearchForSimilar", "mode", "openSearchForGap", "fillGap", "showToast", "message", "updateSmartDeckState", "Tab", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "MythicPlusBottomSheetFragment";
    private MythicPlusCallback callback;
    private MythicPlusEvaluationsFragment evaluationsFragment;
    private boolean hasSmartDeck;
    private boolean isManuallyHidden;
    private MythicPlusLockedFragment lockedFragment;
    private MythicPlusRecommendationsFragment recommendationsFragment;
    private MythicPlusSearchFragment searchFragment;
    private TextView tabEvalIcon;
    private TextView tabEvalLabel;
    private LinearLayout tabEvalLayout;
    private TextView tabRecsIcon;
    private TextView tabRecsLabel;
    private LinearLayout tabRecsLayout;
    private TextView tabSearchIcon;
    private TextView tabSearchLabel;
    private LinearLayout tabSearchLayout;
    private TextView toastLabel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int deckId = -1;
    private int mainListId = -1;
    private int sideboardListId = -1;
    private int maybeboardListId = -1;
    private boolean isSmartDeck = true;
    private Tab currentTab = Tab.RECOMMENDATIONS;

    /* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "isSmartDeck", "", "hasSmartDeck", "callback", "Lcom/studiolaganne/lengendarylens/MythicPlusCallback;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MythicPlusBottomSheetFragment newInstance$default(Companion companion, int i, int i2, int i3, int i4, boolean z, boolean z2, MythicPlusCallback mythicPlusCallback, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                i2 = -1;
            }
            if ((i5 & 4) != 0) {
                i3 = -1;
            }
            if ((i5 & 8) != 0) {
                i4 = -1;
            }
            if ((i5 & 16) != 0) {
                z = true;
            }
            if ((i5 & 32) != 0) {
                z2 = false;
            }
            return companion.newInstance(i, i2, i3, i4, z, z2, mythicPlusCallback);
        }

        public final MythicPlusBottomSheetFragment newInstance(int deckId, int mainListId, int sideboardListId, int maybeboardListId, boolean isSmartDeck, boolean hasSmartDeck, MythicPlusCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = new MythicPlusBottomSheetFragment();
            mythicPlusBottomSheetFragment.deckId = deckId;
            mythicPlusBottomSheetFragment.mainListId = mainListId;
            mythicPlusBottomSheetFragment.sideboardListId = sideboardListId;
            mythicPlusBottomSheetFragment.maybeboardListId = maybeboardListId;
            mythicPlusBottomSheetFragment.isSmartDeck = isSmartDeck;
            mythicPlusBottomSheetFragment.hasSmartDeck = hasSmartDeck;
            mythicPlusBottomSheetFragment.callback = callback;
            return mythicPlusBottomSheetFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment$Tab;", "", "<init>", "(Ljava/lang/String;I)V", ViewHierarchyConstants.SEARCH, "RECOMMENDATIONS", "EVALUATION", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Tab {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Tab[] $VALUES;
        public static final Tab SEARCH = new Tab(ViewHierarchyConstants.SEARCH, 0);
        public static final Tab RECOMMENDATIONS = new Tab("RECOMMENDATIONS", 1);
        public static final Tab EVALUATION = new Tab("EVALUATION", 2);

        private static final /* synthetic */ Tab[] $values() {
            return new Tab[]{SEARCH, RECOMMENDATIONS, EVALUATION};
        }

        static {
            Tab[] tabArr$values = $values();
            $VALUES = tabArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(tabArr$values);
        }

        private Tab(String str, int i) {
        }

        public static EnumEntries<Tab> getEntries() {
            return $ENTRIES;
        }

        public static Tab valueOf(String str) {
            return (Tab) Enum.valueOf(Tab.class, str);
        }

        public static Tab[] values() {
            return (Tab[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Tab.values().length];
            try {
                iArr[Tab.SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Tab.RECOMMENDATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Tab.EVALUATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit onViewCreated$lambda$0(MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment) {
        MythicPlusCallback mythicPlusCallback = mythicPlusBottomSheetFragment.callback;
        if (mythicPlusCallback != null) {
            mythicPlusCallback.onMythicPlusClosed();
        }
        mythicPlusBottomSheetFragment.isManuallyHidden = true;
        Dialog dialog = mythicPlusBottomSheetFragment.getDialog();
        if (dialog != null) {
            dialog.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectTab(Tab tab) {
        MythicPlusSearchFragment mythicPlusSearchFragmentNewInstance;
        this.currentTab = tab;
        int color = ContextCompat.getColor(requireContext(), R.color.selected_color_new);
        Pair[] pairArr = new Pair[3];
        LinearLayout linearLayout = this.tabSearchLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchLayout");
            linearLayout = null;
        }
        TextView textView2 = this.tabSearchIcon;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchIcon");
            textView2 = null;
        }
        TextView textView3 = this.tabSearchLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchLabel");
            textView3 = null;
        }
        pairArr[0] = TuplesKt.to(new Triple(linearLayout, textView2, textView3), Boolean.valueOf(tab == Tab.SEARCH));
        LinearLayout linearLayout2 = this.tabRecsLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsLayout");
            linearLayout2 = null;
        }
        TextView textView4 = this.tabRecsIcon;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsIcon");
            textView4 = null;
        }
        TextView textView5 = this.tabRecsLabel;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsLabel");
            textView5 = null;
        }
        pairArr[1] = TuplesKt.to(new Triple(linearLayout2, textView4, textView5), Boolean.valueOf(tab == Tab.RECOMMENDATIONS));
        LinearLayout linearLayout3 = this.tabEvalLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalLayout");
            linearLayout3 = null;
        }
        TextView textView6 = this.tabEvalIcon;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalIcon");
            textView6 = null;
        }
        TextView textView7 = this.tabEvalLabel;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalLabel");
        } else {
            textView = textView7;
        }
        pairArr[2] = TuplesKt.to(new Triple(linearLayout3, textView6, textView), Boolean.valueOf(tab == Tab.EVALUATION));
        for (Pair pair : CollectionsKt.listOf((Object[]) pairArr)) {
            Triple triple = (Triple) pair.component1();
            boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
            LinearLayout linearLayout4 = (LinearLayout) triple.component1();
            TextView textView8 = (TextView) triple.component2();
            TextView textView9 = (TextView) triple.component3();
            int i = zBooleanValue ? color : -5592406;
            textView8.setTextColor(i);
            textView9.setTextColor(i);
            linearLayout4.setBackgroundResource(zBooleanValue ? R.drawable.background_box_selected_with_line_small : 0);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[tab.ordinal()];
        if (i2 == 1) {
            if (this.searchFragment == null) {
                this.searchFragment = MythicPlusSearchFragment.INSTANCE.newInstance(this.deckId, this.mainListId, this.sideboardListId, this.maybeboardListId);
            }
            MythicPlusSearchFragment mythicPlusSearchFragment = this.searchFragment;
            Intrinsics.checkNotNull(mythicPlusSearchFragment);
            mythicPlusSearchFragmentNewInstance = mythicPlusSearchFragment;
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.isSmartDeck) {
                if (this.evaluationsFragment == null) {
                    this.evaluationsFragment = MythicPlusEvaluationsFragment.INSTANCE.newInstance(this.deckId, this.mainListId, this.sideboardListId, this.maybeboardListId);
                }
                MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment = this.evaluationsFragment;
                Intrinsics.checkNotNull(mythicPlusEvaluationsFragment);
                mythicPlusSearchFragmentNewInstance = mythicPlusEvaluationsFragment;
            } else {
                MythicPlusLockedFragment.Companion companion = MythicPlusLockedFragment.INSTANCE;
                String string = getString(R.string.mythic_evaluation);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                mythicPlusSearchFragmentNewInstance = companion.newInstance(string, this.hasSmartDeck);
            }
        } else if (this.isSmartDeck) {
            if (this.recommendationsFragment == null) {
                this.recommendationsFragment = MythicPlusRecommendationsFragment.INSTANCE.newInstance(this.deckId, this.mainListId, this.sideboardListId, this.maybeboardListId);
            }
            MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment = this.recommendationsFragment;
            Intrinsics.checkNotNull(mythicPlusRecommendationsFragment);
            mythicPlusSearchFragmentNewInstance = mythicPlusRecommendationsFragment;
        } else {
            MythicPlusLockedFragment.Companion companion2 = MythicPlusLockedFragment.INSTANCE;
            String string2 = getString(R.string.mythic_recommendations);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            mythicPlusSearchFragmentNewInstance = companion2.newInstance(string2, this.hasSmartDeck);
        }
        getChildFragmentManager().beginTransaction().replace(R.id.fragmentContainer, mythicPlusSearchFragmentNewInstance).commit();
    }

    private final void setupTabs() {
        TextView textView = this.tabSearchIcon;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchIcon");
            textView = null;
        }
        textView.setText("\uf002");
        TextView textView2 = this.tabSearchLabel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchLabel");
            textView2 = null;
        }
        textView2.setText(getString(R.string.mythic_search));
        LinearLayout linearLayout2 = this.tabSearchLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabSearchLayout");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.selectTab(MythicPlusBottomSheetFragment.Tab.SEARCH);
            }
        });
        TextView textView3 = this.tabRecsIcon;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsIcon");
            textView3 = null;
        }
        textView3.setText("\uf0d0");
        TextView textView4 = this.tabRecsLabel;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsLabel");
            textView4 = null;
        }
        textView4.setText(getString(R.string.mythic_recommendations));
        LinearLayout linearLayout3 = this.tabRecsLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecsLayout");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.selectTab(MythicPlusBottomSheetFragment.Tab.RECOMMENDATIONS);
            }
        });
        TextView textView5 = this.tabEvalIcon;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalIcon");
            textView5 = null;
        }
        textView5.setText("\ue561");
        TextView textView6 = this.tabEvalLabel;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalLabel");
            textView6 = null;
        }
        textView6.setText(getString(R.string.mythic_evaluation));
        LinearLayout linearLayout4 = this.tabEvalLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabEvalLayout");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.selectTab(MythicPlusBottomSheetFragment.Tab.EVALUATION);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddedToast$lambda$0$0(final MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment) {
        if (mythicPlusBottomSheetFragment.isAdded()) {
            TextView textView = mythicPlusBottomSheetFragment.toastLabel;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView = null;
            }
            textView.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MythicPlusBottomSheetFragment.showAddedToast$lambda$0$0$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddedToast$lambda$0$0$0(MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment) {
        TextView textView = mythicPlusBottomSheetFragment.toastLabel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$0$0(final MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment) {
        if (mythicPlusBottomSheetFragment.isAdded()) {
            TextView textView = mythicPlusBottomSheetFragment.toastLabel;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView = null;
            }
            textView.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MythicPlusBottomSheetFragment.showToast$lambda$0$0$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$0$0$0(MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment) {
        TextView textView = mythicPlusBottomSheetFragment.toastLabel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
            textView = null;
        }
        textView.setVisibility(8);
    }

    public final void collapseTabLabels() {
        if (isAdded()) {
            TextView[] textViewArr = new TextView[3];
            TextView textView = this.tabSearchLabel;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabSearchLabel");
                textView = null;
            }
            textViewArr[0] = textView;
            TextView textView3 = this.tabRecsLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRecsLabel");
                textView3 = null;
            }
            textViewArr[1] = textView3;
            TextView textView4 = this.tabEvalLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabEvalLabel");
            } else {
                textView2 = textView4;
            }
            textViewArr[2] = textView2;
            Iterator it = CollectionsKt.listOf((Object[]) textViewArr).iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setVisibility(8);
            }
        }
    }

    public final void expandTabLabels() {
        if (isAdded()) {
            TextView[] textViewArr = new TextView[3];
            TextView textView = this.tabSearchLabel;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabSearchLabel");
                textView = null;
            }
            textViewArr[0] = textView;
            TextView textView3 = this.tabRecsLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRecsLabel");
                textView3 = null;
            }
            textViewArr[1] = textView3;
            TextView textView4 = this.tabEvalLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabEvalLabel");
            } else {
                textView2 = textView4;
            }
            textViewArr[2] = textView2;
            Iterator it = CollectionsKt.listOf((Object[]) textViewArr).iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setVisibility(0);
            }
        }
    }

    public final MythicPlusCallback getCallback() {
        return this.callback;
    }

    public final int getDeckId() {
        return this.deckId;
    }

    public final int getMainListId() {
        return this.mainListId;
    }

    public final int getMaybeboardListId() {
        return this.maybeboardListId;
    }

    public final int getSideboardListId() {
        return this.sideboardListId;
    }

    public final void hide() {
        this.isManuallyHidden = true;
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.hide();
        }
    }

    /* JADX INFO: renamed from: isManuallyHidden, reason: from getter */
    public final boolean getIsManuallyHidden() {
        return this.isManuallyHidden;
    }

    /* JADX INFO: renamed from: isSmartDeck, reason: from getter */
    public final boolean getIsSmartDeck() {
        return this.isSmartDeck;
    }

    public final void markCardAsActed(String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment = this.evaluationsFragment;
        if (mythicPlusEvaluationsFragment != null) {
            mythicPlusEvaluationsFragment.markCardAsActed(oracleId);
        }
    }

    public final void markCardAsAdded(String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment = this.recommendationsFragment;
        if (mythicPlusRecommendationsFragment != null) {
            mythicPlusRecommendationsFragment.markCardAsAdded(oracleId);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mythic_plus, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null) {
            return;
        }
        View viewFindViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setDraggable(false);
            bottomSheetBehaviorFrom.setExpandedOffset(0);
        }
        if (this.isManuallyHidden) {
            bottomSheetDialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevronDown);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = view.findViewById(R.id.tabSearch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tabSearchLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tabSearchIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.tabSearchIcon = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tabSearchLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.tabSearchLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.tabRecommendations);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.tabRecsLayout = (LinearLayout) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.tabRecsIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.tabRecsIcon = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.tabRecsLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.tabRecsLabel = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.tabEvaluation);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.tabEvalLayout = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.tabEvalIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.tabEvalIcon = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.tabEvalLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.tabEvalLabel = (TextView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.toastLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.toastLabel = (TextView) viewFindViewById11;
        setupTabs();
        selectTab(this.isSmartDeck ? Tab.RECOMMENDATIONS : Tab.SEARCH);
    }

    public final void openSearchForGap(String fillGap) {
        Intrinsics.checkNotNullParameter(fillGap, "fillGap");
        selectTab(Tab.SEARCH);
        getChildFragmentManager().executePendingTransactions();
        MythicPlusSearchFragment mythicPlusSearchFragment = this.searchFragment;
        if (mythicPlusSearchFragment != null) {
            mythicPlusSearchFragment.openSearchWithGap(fillGap);
        }
    }

    public final void openSearchForSimilar(String oracleId, String mode, String cardName) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        selectTab(Tab.SEARCH);
        getChildFragmentManager().executePendingTransactions();
        MythicPlusSearchFragment mythicPlusSearchFragment = this.searchFragment;
        if (mythicPlusSearchFragment != null) {
            mythicPlusSearchFragment.openSearchWithSimilar(oracleId, mode, cardName);
        }
    }

    public final void setManuallyHidden(boolean z) {
        this.isManuallyHidden = z;
    }

    public final void showAddedToast(String cardName, String listType) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(listType, "listType");
        if (isAdded()) {
            String string = Intrinsics.areEqual(listType, "maybeboard") ? getString(R.string.mythic_added_to_maybeboard, cardName) : Intrinsics.areEqual(listType, "sideboard") ? getString(R.string.mythic_added_to_sideboard, cardName) : getString(R.string.mythic_added_to_deck, cardName);
            Intrinsics.checkNotNull(string);
            TextView textView = this.toastLabel;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView = null;
            }
            textView.setText(string);
            TextView textView3 = this.toastLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView3 = null;
            }
            textView3.setAlpha(0.0f);
            TextView textView4 = this.toastLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = this.toastLabel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
            } else {
                textView2 = textView5;
            }
            textView2.animate().alpha(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            MythicPlusBottomSheetFragment.showAddedToast$lambda$0$0(mythicPlusBottomSheetFragment);
                        }
                    }, 2000L);
                }
            }).start();
        }
    }

    public final void showToast(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAdded()) {
            TextView textView = this.toastLabel;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView = null;
            }
            textView.setText(message);
            TextView textView3 = this.toastLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView3 = null;
            }
            textView3.setAlpha(0.0f);
            TextView textView4 = this.toastLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = this.toastLabel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toastLabel");
            } else {
                textView2 = textView5;
            }
            textView2.animate().alpha(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            MythicPlusBottomSheetFragment.showToast$lambda$0$0(this.f$0);
                        }
                    }, 2000L);
                }
            }).start();
        }
    }

    public final void updateSmartDeckState(boolean isSmartDeck, boolean hasSmartDeck) {
        this.isSmartDeck = isSmartDeck;
        this.hasSmartDeck = hasSmartDeck;
        if (isAdded()) {
            this.lockedFragment = null;
            selectTab(this.currentTab);
        }
    }
}
