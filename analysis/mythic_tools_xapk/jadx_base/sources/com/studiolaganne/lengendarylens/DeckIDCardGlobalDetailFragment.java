package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J&\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00192\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0016\u0010,\u001a\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "deckCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getDeckCards", "()Ljava/util/List;", "resolveCardsByName", "names", "", "isFrench", "", "excludedThemeIds", "", "setupThemesUI", "root", "getLocalizedThemeName", "theme", "Lcom/studiolaganne/lengendarylens/MTIdCardTheme;", "fr", "setupInsightsUI", "showInsightTooltip", "anchorView", "rationale", "setupAutoTagsUI", "showCardListPopup", Constants.GP_IAP_TITLE, "cardNames", "openCardsInViewer", "cards", "Companion", "SimpleCardNameAdapter", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIDCardGlobalDetailFragment extends Fragment {
    private static final String ARG_JSON = "response_json";
    private final Set<String> excludedThemeIds = SetsKt.setOf((Object[]) new String[]{"cheerios", "ramp", "cedh", "goodstuff", "toolbox", "control", "midrange", "aggro", "birthing_pod", "self_damage", "amass"});
    private MTDeckIdCardResponse response;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Map<String, Companion.InsightUiDef> INSIGHT_UI = MapsKt.mapOf(TuplesKt.to("acceleration", new Companion.InsightUiDef(R.string.insight_acceleration, "\uf135")), TuplesKt.to("competitive_edge", new Companion.InsightUiDef(R.string.insight_competitive_edge, "\uf3a5")), TuplesKt.to("resilience", new Companion.InsightUiDef(R.string.insight_resilience, "\uf0ad")), TuplesKt.to("balance", new Companion.InsightUiDef(R.string.insight_balance, "\uf24e")), TuplesKt.to("interaction", new Companion.InsightUiDef(R.string.insight_interaction, "\uf05b")), TuplesKt.to("strong_protection", new Companion.InsightUiDef(R.string.insight_strong_protection, "\uf521")), TuplesKt.to("strong_recursion", new Companion.InsightUiDef(R.string.insight_strong_recursion, "\uf01e")), TuplesKt.to("strong_draw", new Companion.InsightUiDef(R.string.insight_strong_draw, "\uf256")), TuplesKt.to("strong_board_wipes", new Companion.InsightUiDef(R.string.insight_strong_board_wipes, "\uf0c0")), TuplesKt.to("strong_tutors", new Companion.InsightUiDef(R.string.insight_strong_tutors, "\uf002")), TuplesKt.to("strong_counterspells", new Companion.InsightUiDef(R.string.insight_strong_counterspells, "\uf05e")), TuplesKt.to("strong_graveyard_hate", new Companion.InsightUiDef(R.string.insight_strong_graveyard_hate, "\uf2dc")), TuplesKt.to("focused_strategy", new Companion.InsightUiDef(R.string.insight_focused_strategy, "\uf140")), TuplesKt.to("streamlined_curve", new Companion.InsightUiDef(R.string.insight_streamlined_curve, "\uf201")), TuplesKt.to("evasive_threats", new Companion.InsightUiDef(R.string.insight_evasive_threats, "\uf5b0")), TuplesKt.to("land_interaction", new Companion.InsightUiDef(R.string.insight_land_interaction, "\uf6e2")), TuplesKt.to("closing_power", new Companion.InsightUiDef(R.string.insight_closing_power, "\uf091")), TuplesKt.to("adequate_ramp", new Companion.InsightUiDef(R.string.insight_adequate_ramp, "\uf135")), TuplesKt.to("adequate_removal", new Companion.InsightUiDef(R.string.insight_adequate_removal, "\uf05b")), TuplesKt.to("adequate_protection", new Companion.InsightUiDef(R.string.insight_adequate_protection, "\uf521")), TuplesKt.to("adequate_recursion", new Companion.InsightUiDef(R.string.insight_adequate_recursion, "\uf01e")), TuplesKt.to("adequate_draw", new Companion.InsightUiDef(R.string.insight_adequate_draw, "\uf256")), TuplesKt.to("commander_draw", new Companion.InsightUiDef(R.string.insight_commander_draw, "\uf256")), TuplesKt.to("adequate_board_wipes", new Companion.InsightUiDef(R.string.insight_adequate_board_wipes, "\uf0c0")), TuplesKt.to("adequate_tutors", new Companion.InsightUiDef(R.string.insight_adequate_tutors, "\uf002")), TuplesKt.to("adequate_counterspells", new Companion.InsightUiDef(R.string.insight_adequate_counterspells, "\uf05e")), TuplesKt.to("adequate_closing_power", new Companion.InsightUiDef(R.string.insight_adequate_closing_power, "\uf091")), TuplesKt.to("adequate_graveyard_hate", new Companion.InsightUiDef(R.string.insight_adequate_graveyard_hate, "\uf2dc")), TuplesKt.to("light_ramp", new Companion.InsightUiDef(R.string.insight_light_ramp, "\uf135")), TuplesKt.to("light_removal", new Companion.InsightUiDef(R.string.insight_light_removal, "\uf05b")), TuplesKt.to("light_draw", new Companion.InsightUiDef(R.string.insight_light_draw, "\uf256")), TuplesKt.to("light_protection", new Companion.InsightUiDef(R.string.insight_light_protection, "\uf521")), TuplesKt.to("unfocused", new Companion.InsightUiDef(R.string.insight_unfocused, "\uf140")), TuplesKt.to("low_consistency", new Companion.InsightUiDef(R.string.insight_low_consistency, "\uf002")), TuplesKt.to("low_counterspells", new Companion.InsightUiDef(R.string.insight_low_counterspells, "\uf05e")), TuplesKt.to("no_graveyard_hate", new Companion.InsightUiDef(R.string.insight_no_graveyard_hate, "\uf2dc")), TuplesKt.to("top_heavy_curve", new Companion.InsightUiDef(R.string.insight_top_heavy_curve, "\uf201")), TuplesKt.to("commander_dependent", new Companion.InsightUiDef(R.string.insight_commander_dependent, "\uf6a1")), TuplesKt.to("limited_recursion", new Companion.InsightUiDef(R.string.insight_limited_recursion, "\uf01e")), TuplesKt.to("no_closing_power", new Companion.InsightUiDef(R.string.insight_no_closing_power, "\uf091")), TuplesKt.to("no_recursion", new Companion.InsightUiDef(R.string.insight_no_recursion, "\uf01e")), TuplesKt.to("slow_development", new Companion.InsightUiDef(R.string.insight_slow_development, "\uf017")), TuplesKt.to("low_removal", new Companion.InsightUiDef(R.string.insight_low_removal, "\uf05b")), TuplesKt.to("exposed_commander", new Companion.InsightUiDef(R.string.insight_exposed_commander, "\uf521")), TuplesKt.to("card_advantage_gap", new Companion.InsightUiDef(R.string.insight_card_advantage_gap, "\uf256")), TuplesKt.to("unbalanced_strategy", new Companion.InsightUiDef(R.string.insight_unbalanced_strategy, "\uf24e")), TuplesKt.to("vulnerable_go_wide", new Companion.InsightUiDef(R.string.insight_vulnerable_go_wide, "\uf0c0")), TuplesKt.to("defenseless", new Companion.InsightUiDef(R.string.insight_defenseless, "\uf132")));
    private static final Map<String, Integer> TIER_ORDER = MapsKt.mapOf(TuplesKt.to("strength", 0), TuplesKt.to("adequate", 1), TuplesKt.to("caution", 2), TuplesKt.to("weakness", 3));
    private static final Map<String, Companion.AutoTagUiDef> AUTO_TAG_UI = MapsKt.mapOf(TuplesKt.to("ramp", new Companion.AutoTagUiDef(R.string.auto_tag_ramp, R.color.auto_tag_ramp_color)), TuplesKt.to("card_draw", new Companion.AutoTagUiDef(R.string.auto_tag_card_draw, R.color.auto_tag_card_draw_color)), TuplesKt.to("spot_removal", new Companion.AutoTagUiDef(R.string.auto_tag_spot_removal, R.color.auto_tag_spot_removal_color)), TuplesKt.to("board_wipes", new Companion.AutoTagUiDef(R.string.auto_tag_board_wipes, R.color.auto_tag_board_wipes_color)), TuplesKt.to("protection", new Companion.AutoTagUiDef(R.string.auto_tag_protection, R.color.auto_tag_protection_color)), TuplesKt.to("recursion", new Companion.AutoTagUiDef(R.string.auto_tag_recursion, R.color.auto_tag_recursion_color)), TuplesKt.to("tutor", new Companion.AutoTagUiDef(R.string.auto_tag_tutor, R.color.auto_tag_tutor_color)), TuplesKt.to("counterspell", new Companion.AutoTagUiDef(R.string.auto_tag_counterspell, R.color.auto_tag_counterspell_color)), TuplesKt.to("graveyard_hate", new Companion.AutoTagUiDef(R.string.auto_tag_graveyard_hate, R.color.auto_tag_graveyard_hate_color)), TuplesKt.to("finisher", new Companion.AutoTagUiDef(R.string.auto_tag_finisher, R.color.auto_tag_finisher_color)));

    /* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$Companion;", "", "<init>", "()V", "ARG_JSON", "", "newInstance", "Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment;", "responseJson", "INSIGHT_UI", "", "Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$Companion$InsightUiDef;", "TIER_ORDER", "", "tierBackground", "tier", "AUTO_TAG_UI", "Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$Companion$AutoTagUiDef;", "InsightUiDef", "AutoTagUiDef", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$Companion$AutoTagUiDef;", "", "labelResId", "", "colorResId", "<init>", "(II)V", "getLabelResId", "()I", "getColorResId", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AutoTagUiDef {
            public static final int $stable = 0;
            private final int colorResId;
            private final int labelResId;

            public AutoTagUiDef(int i, int i2) {
                this.labelResId = i;
                this.colorResId = i2;
            }

            public static /* synthetic */ AutoTagUiDef copy$default(AutoTagUiDef autoTagUiDef, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = autoTagUiDef.labelResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = autoTagUiDef.colorResId;
                }
                return autoTagUiDef.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getLabelResId() {
                return this.labelResId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getColorResId() {
                return this.colorResId;
            }

            public final AutoTagUiDef copy(int labelResId, int colorResId) {
                return new AutoTagUiDef(labelResId, colorResId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AutoTagUiDef)) {
                    return false;
                }
                AutoTagUiDef autoTagUiDef = (AutoTagUiDef) other;
                return this.labelResId == autoTagUiDef.labelResId && this.colorResId == autoTagUiDef.colorResId;
            }

            public final int getColorResId() {
                return this.colorResId;
            }

            public final int getLabelResId() {
                return this.labelResId;
            }

            public int hashCode() {
                return (Integer.hashCode(this.labelResId) * 31) + Integer.hashCode(this.colorResId);
            }

            public String toString() {
                return "AutoTagUiDef(labelResId=" + this.labelResId + ", colorResId=" + this.colorResId + ")";
            }
        }

        /* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$Companion$InsightUiDef;", "", "labelResId", "", "icon", "", "<init>", "(ILjava/lang/String;)V", "getLabelResId", "()I", "getIcon", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InsightUiDef {
            public static final int $stable = 0;
            private final String icon;
            private final int labelResId;

            public InsightUiDef(int i, String icon) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.labelResId = i;
                this.icon = icon;
            }

            public static /* synthetic */ InsightUiDef copy$default(InsightUiDef insightUiDef, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = insightUiDef.labelResId;
                }
                if ((i2 & 2) != 0) {
                    str = insightUiDef.icon;
                }
                return insightUiDef.copy(i, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getLabelResId() {
                return this.labelResId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getIcon() {
                return this.icon;
            }

            public final InsightUiDef copy(int labelResId, String icon) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new InsightUiDef(labelResId, icon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InsightUiDef)) {
                    return false;
                }
                InsightUiDef insightUiDef = (InsightUiDef) other;
                return this.labelResId == insightUiDef.labelResId && Intrinsics.areEqual(this.icon, insightUiDef.icon);
            }

            public final String getIcon() {
                return this.icon;
            }

            public final int getLabelResId() {
                return this.labelResId;
            }

            public int hashCode() {
                return (Integer.hashCode(this.labelResId) * 31) + this.icon.hashCode();
            }

            public String toString() {
                return "InsightUiDef(labelResId=" + this.labelResId + ", icon=" + this.icon + ")";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final int tierBackground(String tier) {
            if (tier != null) {
                switch (tier.hashCode()) {
                    case -1190549876:
                        if (tier.equals("adequate")) {
                            return R.drawable.insight_capsule_adequate;
                        }
                        break;
                    case -736186929:
                        if (tier.equals("weakness")) {
                            return R.drawable.insight_capsule_weakness;
                        }
                        break;
                    case 557191019:
                        if (tier.equals("caution")) {
                            return R.drawable.insight_capsule_caution;
                        }
                        break;
                    case 1791316033:
                        if (tier.equals("strength")) {
                            return R.drawable.insight_capsule_strength;
                        }
                        break;
                }
            }
            return R.drawable.insight_capsule_adequate;
        }

        public final DeckIDCardGlobalDetailFragment newInstance(String responseJson) {
            Intrinsics.checkNotNullParameter(responseJson, "responseJson");
            DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment = new DeckIDCardGlobalDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DeckIDCardGlobalDetailFragment.ARG_JSON, responseJson);
            deckIDCardGlobalDetailFragment.setArguments(bundle);
            return deckIDCardGlobalDetailFragment;
        }
    }

    /* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$SimpleCardNameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$SimpleCardNameAdapter$VH;", "names", "", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "VH", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class SimpleCardNameAdapter extends RecyclerView.Adapter<VH> {
        private final List<String> names;

        /* JADX INFO: compiled from: DeckIDCardGlobalDetailFragment.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardGlobalDetailFragment$SimpleCardNameAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cardName", "Landroid/widget/TextView;", "getCardName", "()Landroid/widget/TextView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    private final List<MTFullCard> getDeckCards() {
        return DeckIDCardDetailsBottomSheetFragment.INSTANCE.getDeckCardList();
    }

    private final String getLocalizedThemeName(MTIdCardTheme theme, boolean fr) {
        if (fr) {
            String themeNameFr = theme.getThemeNameFr();
            String str = themeNameFr;
            if (str != null && !StringsKt.isBlank(str)) {
                return themeNameFr;
            }
            String themeId = theme.getThemeId();
            if (themeId != null) {
                MTDeckTheme mTDeckTheme = TagsAndThemesManager.INSTANCE.getThemesById().get(themeId);
                String themeNameFr2 = mTDeckTheme != null ? mTDeckTheme.getThemeNameFr() : null;
                String str2 = themeNameFr2;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    return themeNameFr2;
                }
            }
        }
        String themeName = theme.getThemeName();
        if (themeName != null) {
            return themeName;
        }
        String themeId2 = theme.getThemeId();
        return themeId2 == null ? "" : themeId2;
    }

    private final boolean isFrench() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr");
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
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
        List<MTFullCard> deckCards = getDeckCards();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : deckCards) {
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

    private final void setupAutoTagsUI(View root) {
        List<String> listEmptyList;
        MTIdCardThemeAnalysis themeAnalysis;
        MTIdCardThemeAnalysis themeAnalysis2;
        final DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment = this;
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.autoTagsSection);
        LinearLayout linearLayout2 = (LinearLayout) root.findViewById(R.id.autoTagsBarLayout);
        linearLayout2.removeAllViews();
        MTDeckIdCardResponse mTDeckIdCardResponse = deckIDCardGlobalDetailFragment.response;
        Map<String, List<String>> autoTagCards = null;
        Map<String, Integer> autoTags = (mTDeckIdCardResponse == null || (themeAnalysis2 = mTDeckIdCardResponse.getThemeAnalysis()) == null) ? null : themeAnalysis2.getAutoTags();
        MTDeckIdCardResponse mTDeckIdCardResponse2 = deckIDCardGlobalDetailFragment.response;
        if (mTDeckIdCardResponse2 != null && (themeAnalysis = mTDeckIdCardResponse2.getThemeAnalysis()) != null) {
            autoTagCards = themeAnalysis.getAutoTagCards();
        }
        Map<String, List<String>> map = autoTagCards;
        if (autoTags == null || autoTags.isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        Set<Map.Entry<String, Integer>> setEntrySet = autoTags.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((Number) ((Map.Entry) obj).getValue()).intValue() > 0) {
                arrayList.add(obj);
            }
        }
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$setupAutoTagsUI$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Map.Entry) t2).getValue(), (Integer) ((Map.Entry) t).getValue());
            }
        });
        if (listSortedWith.isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        boolean z = false;
        linearLayout.setVisibility(0);
        Context contextRequireContext = deckIDCardGlobalDetailFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LayoutInflater layoutInflater = deckIDCardGlobalDetailFragment.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((Number) ((Map.Entry) CollectionsKt.first(listSortedWith)).getValue()).intValue(), 1);
        for (Map.Entry entry : listSortedWith) {
            String str = (String) entry.getKey();
            final int iIntValue = ((Number) entry.getValue()).intValue();
            final Companion.AutoTagUiDef autoTagUiDef = AUTO_TAG_UI.get(str);
            if (autoTagUiDef != null) {
                View viewInflate = layoutInflater.inflate(R.layout.auto_tag_bar_item, linearLayout2, z);
                final LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.autoTagBarRoot);
                TextView textView = (TextView) viewInflate.findViewById(R.id.autoTagLabel);
                final View viewFindViewById = viewInflate.findViewById(R.id.autoTagBarFill);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.autoTagCount);
                textView.setText(deckIDCardGlobalDetailFragment.getString(autoTagUiDef.getLabelResId()));
                textView2.setText(String.valueOf(iIntValue));
                viewFindViewById.setBackgroundTintList(ColorStateList.valueOf((ContextCompat.getColor(contextRequireContext, autoTagUiDef.getColorResId()) & 16777215) | 1711276032));
                final float f = iIntValue / iCoerceAtLeast;
                viewFindViewById.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeckIDCardGlobalDetailFragment.setupAutoTagsUI$lambda$2$0(viewFindViewById, f);
                    }
                });
                if (map == null || (listEmptyList = map.get(str)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                final List<String> list = listEmptyList;
                Intrinsics.checkNotNull(linearLayout3);
                ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckIDCardGlobalDetailFragment.setupAutoTagsUI$lambda$2$1(this.f$0, autoTagUiDef, iIntValue, list, linearLayout3);
                    }
                });
                linearLayout2.addView(viewInflate);
            }
            z = false;
            deckIDCardGlobalDetailFragment = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAutoTagsUI$lambda$2$0(View view, float f) {
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        view.getLayoutParams().width = RangesKt.coerceAtLeast((int) (((View) parent).getWidth() * f), 1);
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAutoTagsUI$lambda$2$1(DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, Companion.AutoTagUiDef autoTagUiDef, int i, List list, LinearLayout linearLayout) {
        String string = deckIDCardGlobalDetailFragment.getString(R.string.auto_tag_card_count, deckIDCardGlobalDetailFragment.getString(autoTagUiDef.getLabelResId()), Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Intrinsics.checkNotNull(linearLayout);
        deckIDCardGlobalDetailFragment.showCardListPopup(string, list, linearLayout);
        return Unit.INSTANCE;
    }

    private final void setupInsightsUI(View root) {
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.insightsSection);
        FlexboxLayout flexboxLayout = (FlexboxLayout) root.findViewById(R.id.insightsFlexboxLayout);
        flexboxLayout.removeAllViews();
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        List<MTIdCardDeckInsight> insights = mTDeckIdCardResponse != null ? mTDeckIdCardResponse.getInsights() : null;
        List<MTIdCardDeckInsight> list = insights;
        if (list == null || list.isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        final boolean zIsFrench = isFrench();
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        for (final MTIdCardDeckInsight mTIdCardDeckInsight : CollectionsKt.sortedWith(insights, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$setupInsightsUI$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Integer num = (Integer) DeckIDCardGlobalDetailFragment.TIER_ORDER.get(((MTIdCardDeckInsight) t).getTier());
                Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 99);
                Integer num2 = (Integer) DeckIDCardGlobalDetailFragment.TIER_ORDER.get(((MTIdCardDeckInsight) t2).getTier());
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : 99));
            }
        })) {
            String id = mTIdCardDeckInsight.getId();
            if (id != null) {
                Companion.InsightUiDef insightUiDef = INSIGHT_UI.get(StringsKt.removeSuffix(id, (CharSequence) "_offcolor"));
                if (insightUiDef != null) {
                    View viewInflate = layoutInflater.inflate(R.layout.insight_item, (ViewGroup) flexboxLayout, false);
                    Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                    final LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                    TextView textView = (TextView) linearLayout2.findViewById(R.id.insightIcon);
                    TextView textView2 = (TextView) linearLayout2.findViewById(R.id.insightLabel);
                    textView.setText(insightUiDef.getIcon());
                    textView2.setText(getString(insightUiDef.getLabelResId()));
                    linearLayout2.setBackgroundResource(INSTANCE.tierBackground(mTIdCardDeckInsight.getTier()));
                    LinearLayout linearLayout3 = linearLayout2;
                    ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckIDCardGlobalDetailFragment.setupInsightsUI$lambda$1$0(zIsFrench, mTIdCardDeckInsight, this, linearLayout2);
                        }
                    });
                    flexboxLayout.addView(linearLayout3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupInsightsUI$lambda$1$0(boolean z, MTIdCardDeckInsight mTIdCardDeckInsight, DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, LinearLayout linearLayout) {
        String rationaleEn;
        if (z) {
            rationaleEn = mTIdCardDeckInsight.getRationaleFr();
            if (rationaleEn == null && (rationaleEn = mTIdCardDeckInsight.getRationaleEn()) == null) {
                rationaleEn = mTIdCardDeckInsight.getRationale();
            }
        } else {
            rationaleEn = mTIdCardDeckInsight.getRationaleEn();
            if (rationaleEn == null) {
                rationaleEn = mTIdCardDeckInsight.getRationale();
            }
        }
        String str = rationaleEn;
        if (str != null && !StringsKt.isBlank(str)) {
            deckIDCardGlobalDetailFragment.showInsightTooltip(linearLayout, rationaleEn);
        }
        return Unit.INSTANCE;
    }

    private final void setupThemesUI(View root) {
        MTIdCardThemeAnalysis themeAnalysis;
        Iterator it;
        Iterator it2;
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.themesSection);
        FlexboxLayout flexboxLayout = (FlexboxLayout) root.findViewById(R.id.themesFlexboxLayout);
        flexboxLayout.removeAllViews();
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        if (mTDeckIdCardResponse == null || (themeAnalysis = mTDeckIdCardResponse.getThemeAnalysis()) == null) {
            linearLayout.setVisibility(8);
            return;
        }
        List<MTIdCardTheme> themes = themeAnalysis.getThemes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : themes) {
            if (!CollectionsKt.contains(this.excludedThemeIds, ((MTIdCardTheme) obj).getThemeId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<MTIdCardTribalTheme> tribalThemes = themeAnalysis.getTribalThemes();
        List<MTIdCardKeywordTheme> keywordThemes = themeAnalysis.getKeywordThemes();
        if (arrayList2.isEmpty() && tribalThemes.isEmpty() && keywordThemes.isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        boolean z = false;
        linearLayout.setVisibility(0);
        boolean zIsFrench = isFrench();
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        int i = 0;
        for (Object obj2 : CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$setupThemesUI$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Double score = ((MTIdCardTheme) t2).getScore();
                double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                Double dValueOf = Double.valueOf(score != null ? score.doubleValue() : 0.0d);
                Double score2 = ((MTIdCardTheme) t).getScore();
                if (score2 != null) {
                    dDoubleValue = score2.doubleValue();
                }
                return ComparisonsKt.compareValues(dValueOf, Double.valueOf(dDoubleValue));
            }
        })) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final MTIdCardTheme mTIdCardTheme = (MTIdCardTheme) obj2;
            boolean z2 = (Intrinsics.areEqual(mTIdCardTheme.getClassification(), "Major") || (mTIdCardTheme.getClassification() == null && i < 5)) ? true : z;
            View viewInflate = layoutInflater.inflate(R.layout.theme_capsule_item, flexboxLayout, z);
            final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.themeCapsuleRoot);
            TextView textView = (TextView) viewInflate.findViewById(R.id.themeLabel);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.themeCount);
            final String localizedThemeName = getLocalizedThemeName(mTIdCardTheme, zIsFrench);
            textView.setText(localizedThemeName);
            textView2.setText(String.valueOf(mTIdCardTheme.getCards().size()));
            constraintLayout.setBackgroundResource(z2 ? R.drawable.theme_capsule_major_background : R.drawable.theme_capsule_secondary_background);
            Intrinsics.checkNotNull(constraintLayout);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardGlobalDetailFragment.setupThemesUI$lambda$3$0(this.f$0, localizedThemeName, mTIdCardTheme, constraintLayout);
                }
            });
            flexboxLayout.addView(viewInflate);
            i = i2;
            z = false;
        }
        Iterator it3 = tribalThemes.iterator();
        while (true) {
            final String str = "";
            if (!it3.hasNext()) {
                break;
            }
            final MTIdCardTribalTheme mTIdCardTribalTheme = (MTIdCardTribalTheme) it3.next();
            View viewInflate2 = layoutInflater.inflate(R.layout.theme_capsule_item, (ViewGroup) flexboxLayout, false);
            final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate2.findViewById(R.id.themeCapsuleRoot);
            TextView textView3 = (TextView) viewInflate2.findViewById(R.id.themeLabel);
            TextView textView4 = (TextView) viewInflate2.findViewById(R.id.themeCount);
            String creatureType = mTIdCardTribalTheme.getCreatureType();
            if (creatureType != null) {
                if (creatureType.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    it2 = it3;
                    String strValueOf = String.valueOf(creatureType.charAt(0));
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase);
                    String strSubstring = creatureType.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    creatureType = sbAppend.append(strSubstring).toString();
                } else {
                    it2 = it3;
                }
                if (creatureType != null) {
                    str = creatureType;
                }
            } else {
                it2 = it3;
            }
            textView3.setText(getString(R.string.tribal_theme_prefix, str));
            textView4.setText(String.valueOf(mTIdCardTribalTheme.getCards().size()));
            constraintLayout2.setBackgroundResource(R.drawable.theme_capsule_tribal_background);
            Intrinsics.checkNotNull(constraintLayout2);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardGlobalDetailFragment.setupThemesUI$lambda$4$1(this.f$0, str, mTIdCardTribalTheme, constraintLayout2);
                }
            });
            flexboxLayout.addView(viewInflate2);
            it3 = it2;
        }
        Iterator it4 = keywordThemes.iterator();
        while (it4.hasNext()) {
            final MTIdCardKeywordTheme mTIdCardKeywordTheme = (MTIdCardKeywordTheme) it4.next();
            View viewInflate3 = layoutInflater.inflate(R.layout.theme_capsule_item, (ViewGroup) flexboxLayout, false);
            final ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate3.findViewById(R.id.themeCapsuleRoot);
            TextView textView5 = (TextView) viewInflate3.findViewById(R.id.themeLabel);
            TextView textView6 = (TextView) viewInflate3.findViewById(R.id.themeCount);
            final String keyword = mTIdCardKeywordTheme.getKeyword();
            if (keyword != null) {
                if (keyword.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    String strValueOf2 = String.valueOf(keyword.charAt(0));
                    Intrinsics.checkNotNull(strValueOf2, "null cannot be cast to non-null type java.lang.String");
                    it = it4;
                    String upperCase2 = strValueOf2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    StringBuilder sbAppend2 = sb2.append((Object) upperCase2);
                    String strSubstring2 = keyword.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    keyword = sbAppend2.append(strSubstring2).toString();
                } else {
                    it = it4;
                }
                if (keyword == null) {
                }
                textView5.setText(getString(R.string.keyword_theme_prefix, keyword));
                textView6.setText(String.valueOf(mTIdCardKeywordTheme.getCards().size()));
                constraintLayout3.setBackgroundResource(R.drawable.theme_capsule_keyword_background);
                Intrinsics.checkNotNull(constraintLayout3);
                ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckIDCardGlobalDetailFragment.setupThemesUI$lambda$5$1(this.f$0, keyword, mTIdCardKeywordTheme, constraintLayout3);
                    }
                });
                flexboxLayout.addView(viewInflate3);
                it4 = it;
            } else {
                it = it4;
            }
            keyword = "";
            textView5.setText(getString(R.string.keyword_theme_prefix, keyword));
            textView6.setText(String.valueOf(mTIdCardKeywordTheme.getCards().size()));
            constraintLayout3.setBackgroundResource(R.drawable.theme_capsule_keyword_background);
            Intrinsics.checkNotNull(constraintLayout3);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardGlobalDetailFragment.setupThemesUI$lambda$5$1(this.f$0, keyword, mTIdCardKeywordTheme, constraintLayout3);
                }
            });
            flexboxLayout.addView(viewInflate3);
            it4 = it;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThemesUI$lambda$3$0(DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, String str, MTIdCardTheme mTIdCardTheme, ConstraintLayout constraintLayout) {
        List<String> cards = mTIdCardTheme.getCards();
        Intrinsics.checkNotNull(constraintLayout);
        deckIDCardGlobalDetailFragment.showCardListPopup(str, cards, constraintLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThemesUI$lambda$4$1(DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, String str, MTIdCardTribalTheme mTIdCardTribalTheme, ConstraintLayout constraintLayout) {
        String string = deckIDCardGlobalDetailFragment.getString(R.string.tribal_theme_prefix, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        List<String> cards = mTIdCardTribalTheme.getCards();
        Intrinsics.checkNotNull(constraintLayout);
        deckIDCardGlobalDetailFragment.showCardListPopup(string, cards, constraintLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThemesUI$lambda$5$1(DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, String str, MTIdCardKeywordTheme mTIdCardKeywordTheme, ConstraintLayout constraintLayout) {
        String string = deckIDCardGlobalDetailFragment.getString(R.string.keyword_theme_prefix, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        List<String> cards = mTIdCardKeywordTheme.getCards();
        Intrinsics.checkNotNull(constraintLayout);
        deckIDCardGlobalDetailFragment.showCardListPopup(string, cards, constraintLayout);
        return Unit.INSTANCE;
    }

    private final void showCardListPopup(String title, List<String> cardNames, View anchorView) {
        SimpleCardNameAdapter simpleCardNameAdapter;
        List<MTFullCard> listResolveCardsByName = resolveCardsByName(cardNames);
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
        final List<MTFullCard> listEmptyList = !listResolveCardsByName.isEmpty() ? listResolveCardsByName : CollectionsKt.emptyList();
        if (!listResolveCardsByName.isEmpty()) {
            cardNames = CollectionsKt.emptyList();
        }
        List<MTFullCard> list = listEmptyList;
        if (list.isEmpty()) {
            simpleCardNameAdapter = new SimpleCardNameAdapter(cardNames);
        } else {
            List<MTFullCard> list2 = listEmptyList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (MTFullCard mTFullCard : list2) {
                String name = mTFullCard.getName();
                if (name == null && (name = mTFullCard.getPrinted_name()) == null) {
                    name = "?";
                }
                arrayList.add(name);
            }
            simpleCardNameAdapter = new SimpleCardNameAdapter(arrayList);
        }
        recyclerView.setAdapter(simpleCardNameAdapter);
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
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardGlobalDetailFragment.showCardListPopup$lambda$1(popupWindow);
            }
        });
        if (list.isEmpty()) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            Intrinsics.checkNotNull(textView2);
            ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardGlobalDetailFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardGlobalDetailFragment.showCardListPopup$lambda$2(popupWindow, this, listEmptyList);
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

    static final Unit showCardListPopup$lambda$2(PopupWindow popupWindow, DeckIDCardGlobalDetailFragment deckIDCardGlobalDetailFragment, List list) {
        popupWindow.dismiss();
        deckIDCardGlobalDetailFragment.openCardsInViewer(list);
        return Unit.INSTANCE;
    }

    private final void showInsightTooltip(View anchorView, String rationale) {
        View viewInflate = getLayoutInflater().inflate(R.layout.popup_simple_text, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.popupText)).setText(rationale);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        popupWindow.setElevation(10.0f);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(anchorView, 0, 8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.response = (arguments == null || (string = arguments.getString(ARG_JSON)) == null) ? null : (MTDeckIdCardResponse) new Gson().fromJson(string, MTDeckIdCardResponse.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_deck_id_card_global, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupThemesUI(view);
        setupInsightsUI(view);
        setupAutoTagsUI(view);
    }
}
