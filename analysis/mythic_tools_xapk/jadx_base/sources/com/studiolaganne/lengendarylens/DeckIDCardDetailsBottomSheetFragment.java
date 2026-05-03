package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckIDCardDetailsBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardDetailsBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "selectedTab", "", "gGlobal", "Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView;", "gPower", "gMana", "gHealth", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "setupGauges", "selectTab", "tab", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIDCardDetailsBottomSheetFragment extends TransparentBottomSheet {
    private static final String ARG_INITIAL_TAB = "initial_tab";
    private static final String ARG_RESPONSE_JSON = "response_json";
    public static final int TAB_GLOBAL = 0;
    public static final int TAB_HEALTH = 3;
    public static final int TAB_MANA = 2;
    public static final int TAB_POWER = 1;
    public static final String TAG = "DeckIDCardDetailsBottomSheet";
    private static Function1<? super String, Unit> onFindCards;
    private DeckIdCardArcGaugeView gGlobal;
    private DeckIdCardArcGaugeView gHealth;
    private DeckIdCardArcGaugeView gMana;
    private DeckIdCardArcGaugeView gPower;
    private MTDeckIdCardResponse response;
    private int selectedTab;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static List<MTFullCard> deckCardList = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: DeckIDCardDetailsBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardDetailsBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_RESPONSE_JSON", "ARG_INITIAL_TAB", "TAB_GLOBAL", "", "TAB_POWER", "TAB_MANA", "TAB_HEALTH", "deckCardList", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getDeckCardList", "()Ljava/util/List;", "setDeckCardList", "(Ljava/util/List;)V", "onFindCards", "Lkotlin/Function1;", "", "getOnFindCards", "()Lkotlin/jvm/functions/Function1;", "setOnFindCards", "(Lkotlin/jvm/functions/Function1;)V", "newInstance", "Lcom/studiolaganne/lengendarylens/DeckIDCardDetailsBottomSheetFragment;", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "initialTab", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<MTFullCard> getDeckCardList() {
            return DeckIDCardDetailsBottomSheetFragment.deckCardList;
        }

        public final Function1<String, Unit> getOnFindCards() {
            return DeckIDCardDetailsBottomSheetFragment.onFindCards;
        }

        public final DeckIDCardDetailsBottomSheetFragment newInstance(MTDeckIdCardResponse response, int initialTab) {
            Intrinsics.checkNotNullParameter(response, "response");
            DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment = new DeckIDCardDetailsBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DeckIDCardDetailsBottomSheetFragment.ARG_RESPONSE_JSON, new Gson().toJson(response));
            bundle.putInt(DeckIDCardDetailsBottomSheetFragment.ARG_INITIAL_TAB, initialTab);
            deckIDCardDetailsBottomSheetFragment.setArguments(bundle);
            return deckIDCardDetailsBottomSheetFragment;
        }

        public final void setDeckCardList(List<MTFullCard> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            DeckIDCardDetailsBottomSheetFragment.deckCardList = list;
        }

        public final void setOnFindCards(Function1<? super String, Unit> function1) {
            DeckIDCardDetailsBottomSheetFragment.onFindCards = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$0(Dialog dialog, DialogInterface dialogInterface) {
        View viewFindViewById = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        FrameLayout frameLayout = viewFindViewById instanceof FrameLayout ? (FrameLayout) viewFindViewById : null;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(android.R.color.transparent);
            frameLayout.getLayoutParams().height = -1;
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setPeekHeight(frameLayout.getHeight());
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setDraggable(false);
        }
    }

    static final Unit onViewCreated$lambda$1(DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment) {
        deckIDCardDetailsBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment) {
        deckIDCardDetailsBottomSheetFragment.selectTab(0);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment) {
        deckIDCardDetailsBottomSheetFragment.selectTab(1);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment) {
        deckIDCardDetailsBottomSheetFragment.selectTab(2);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment) {
        deckIDCardDetailsBottomSheetFragment.selectTab(3);
        return Unit.INSTANCE;
    }

    private final void selectTab(int tab) {
        String string;
        DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragmentNewInstance;
        this.selectedTab = tab;
        int i = 0;
        for (Object obj : CollectionsKt.listOf((Object[]) new DeckIdCardArcGaugeView[]{this.gGlobal, this.gPower, this.gMana, this.gHealth})) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DeckIdCardArcGaugeView deckIdCardArcGaugeView = (DeckIdCardArcGaugeView) obj;
            if (deckIdCardArcGaugeView != null) {
                deckIdCardArcGaugeView.setBackgroundResource(i == tab ? R.drawable.gauge_box_with_line_accent : android.R.color.transparent);
            }
            i = i2;
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_RESPONSE_JSON)) == null) {
            return;
        }
        if (tab == 0) {
            deckIDCardGlobalDetailFragmentNewInstance = DeckIDCardGlobalDetailFragment.INSTANCE.newInstance(string);
        } else if (tab == 1) {
            deckIDCardGlobalDetailFragmentNewInstance = DeckIDCardPowerDetailFragment.INSTANCE.newInstance(string);
        } else if (tab == 2) {
            deckIDCardGlobalDetailFragmentNewInstance = DeckIDCardManaDetailFragment.INSTANCE.newInstance(string);
        } else {
            if (tab != 3) {
                return;
            }
            DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragmentNewInstance = DeckIDCardHealthDetailFragment.INSTANCE.newInstance(string);
            deckIDCardHealthDetailFragmentNewInstance.setOnFindCards(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DeckIDCardDetailsBottomSheetFragment.selectTab$lambda$1$0((String) obj2);
                }
            });
            deckIDCardGlobalDetailFragmentNewInstance = deckIDCardHealthDetailFragmentNewInstance;
        }
        getChildFragmentManager().beginTransaction().replace(R.id.detailFragmentContainer, deckIDCardGlobalDetailFragmentNewInstance).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectTab$lambda$1$0(String fillGap) {
        Intrinsics.checkNotNullParameter(fillGap, "fillGap");
        Function1<? super String, Unit> function1 = onFindCards;
        if (function1 != null) {
            function1.invoke(fillGap);
        }
        return Unit.INSTANCE;
    }

    private final void setupGauges() {
        Integer overall;
        Integer score;
        Integer score2;
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        if (mTDeckIdCardResponse == null) {
            return;
        }
        Integer globalScore = mTDeckIdCardResponse.getGlobalScore();
        int iIntValue = 0;
        int iIntValue2 = globalScore != null ? globalScore.intValue() : 0;
        MTIdCardPowerLevel powerLevel = mTDeckIdCardResponse.getPowerLevel();
        int iIntValue3 = (powerLevel == null || (score2 = powerLevel.getScore()) == null) ? 0 : score2.intValue();
        MTIdCardManaBaseAnalysis manaBaseAnalysis = mTDeckIdCardResponse.getManaBaseAnalysis();
        int iIntValue4 = (manaBaseAnalysis == null || (score = manaBaseAnalysis.getScore()) == null) ? 0 : score.intValue();
        MTIdCardDeckHealthScore deckHealthScore = mTDeckIdCardResponse.getDeckHealthScore();
        if (deckHealthScore != null && (overall = deckHealthScore.getOverall()) != null) {
            iIntValue = overall.intValue();
        }
        int iArgb = Color.argb(15, 255, 255, 255);
        DeckIdCardArcGaugeView deckIdCardArcGaugeView = this.gGlobal;
        if (deckIdCardArcGaugeView != null) {
            deckIdCardArcGaugeView.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
            deckIdCardArcGaugeView.setTrackColor(iArgb);
            String string = getString(R.string.deck_id_card_score_global);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            deckIdCardArcGaugeView.setGaugeLabel(string);
            deckIdCardArcGaugeView.setFillColor(DeckIdCardScoreColors.MYTHIC_BLUE);
            deckIdCardArcGaugeView.setScorePercentImmediate(iIntValue2);
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView2 = this.gPower;
        if (deckIdCardArcGaugeView2 != null) {
            deckIdCardArcGaugeView2.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
            deckIdCardArcGaugeView2.setTrackColor(iArgb);
            String string2 = getString(R.string.deck_id_card_score_power);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            deckIdCardArcGaugeView2.setGaugeLabel(string2);
            deckIdCardArcGaugeView2.setFillColor(DeckIdCardScoreColors.INSTANCE.powerLevelColor(iIntValue3));
            deckIdCardArcGaugeView2.setScorePercentImmediate(iIntValue3);
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView3 = this.gMana;
        if (deckIdCardArcGaugeView3 != null) {
            deckIdCardArcGaugeView3.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
            deckIdCardArcGaugeView3.setTrackColor(iArgb);
            String string3 = getString(R.string.deck_id_card_score_mana);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            deckIdCardArcGaugeView3.setGaugeLabel(string3);
            deckIdCardArcGaugeView3.setFillColor(DeckIdCardScoreColors.INSTANCE.healthBandColor(iIntValue4));
            deckIdCardArcGaugeView3.setScorePercentImmediate(iIntValue4);
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView4 = this.gHealth;
        if (deckIdCardArcGaugeView4 != null) {
            deckIdCardArcGaugeView4.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
            deckIdCardArcGaugeView4.setTrackColor(iArgb);
            String string4 = getString(R.string.deck_id_card_score_health);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            deckIdCardArcGaugeView4.setGaugeLabel(string4);
            DeckIdCardScoreColors deckIdCardScoreColors = DeckIdCardScoreColors.INSTANCE;
            MTIdCardDeckHealthScore deckHealthScore2 = mTDeckIdCardResponse.getDeckHealthScore();
            Integer apiColor = deckIdCardScoreColors.parseApiColor(deckHealthScore2 != null ? deckHealthScore2.getColor() : null);
            deckIdCardArcGaugeView4.setFillColor(apiColor != null ? apiColor.intValue() : DeckIdCardScoreColors.INSTANCE.healthBandColor(iIntValue));
            deckIdCardArcGaugeView4.setScorePercentImmediate(iIntValue);
        }
    }

    @Override // com.studiolaganne.lengendarylens.TransparentBottomSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeckIDCardDetailsBottomSheetFragment.onCreateDialog$lambda$0$0(dialogOnCreateDialog, dialogInterface);
            }
        });
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.8f);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_deck_id_card_details, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.response = (arguments == null || (string = arguments.getString(ARG_RESPONSE_JSON)) == null) ? null : (MTDeckIdCardResponse) new Gson().fromJson(string, MTDeckIdCardResponse.class);
        Bundle arguments2 = getArguments();
        this.selectedTab = arguments2 != null ? arguments2.getInt(ARG_INITIAL_TAB, 0) : 0;
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardDetailsBottomSheetFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        this.gGlobal = (DeckIdCardArcGaugeView) view.findViewById(R.id.sheetGaugeGlobal);
        this.gPower = (DeckIdCardArcGaugeView) view.findViewById(R.id.sheetGaugePower);
        this.gMana = (DeckIdCardArcGaugeView) view.findViewById(R.id.sheetGaugeMana);
        this.gHealth = (DeckIdCardArcGaugeView) view.findViewById(R.id.sheetGaugeHealth);
        setupGauges();
        DeckIdCardArcGaugeView deckIdCardArcGaugeView = this.gGlobal;
        if (deckIdCardArcGaugeView != null) {
            ViewExtensionsKt.setOnClickWithBounce(deckIdCardArcGaugeView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardDetailsBottomSheetFragment.onViewCreated$lambda$2(this.f$0);
                }
            });
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView2 = this.gPower;
        if (deckIdCardArcGaugeView2 != null) {
            ViewExtensionsKt.setOnClickWithBounce(deckIdCardArcGaugeView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardDetailsBottomSheetFragment.onViewCreated$lambda$3(this.f$0);
                }
            });
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView3 = this.gMana;
        if (deckIdCardArcGaugeView3 != null) {
            ViewExtensionsKt.setOnClickWithBounce(deckIdCardArcGaugeView3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardDetailsBottomSheetFragment.onViewCreated$lambda$4(this.f$0);
                }
            });
        }
        DeckIdCardArcGaugeView deckIdCardArcGaugeView4 = this.gHealth;
        if (deckIdCardArcGaugeView4 != null) {
            ViewExtensionsKt.setOnClickWithBounce(deckIdCardArcGaugeView4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardDetailsBottomSheetFragment.onViewCreated$lambda$5(this.f$0);
                }
            });
        }
        selectTab(this.selectedTab);
    }
}
