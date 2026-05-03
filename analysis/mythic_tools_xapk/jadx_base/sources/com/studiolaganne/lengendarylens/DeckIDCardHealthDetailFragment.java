package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.ManabaseRadarChartView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckIDCardHealthDetailFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001eH\u0002J\u001e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "categoryBlockViews", "", "Landroid/view/View;", "selectedBlockIndex", "", "onFindCards", "Lkotlin/Function1;", "", "", "getOnFindCards", "()Lkotlin/jvm/functions/Function1;", "setOnFindCards", "(Lkotlin/jvm/functions/Function1;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "buildContent", "Landroid/widget/LinearLayout;", "buildCategoryBlocks", "categories", "", "Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment$CategoryDetail;", "applyBlockBackground", "selected", "", "selectCategoryBlock", FirebaseAnalytics.Param.INDEX, "dp", "value", "Companion", "CategoryDetail", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIDCardHealthDetailFragment extends Fragment {
    private static final String ARG_JSON = "response_json";
    private Function1<? super String, Unit> onFindCards;
    private MTDeckIdCardResponse response;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Map<String, Integer> TIER_TO_SCORE = MapsKt.mapOf(TuplesKt.to("strength", 100), TuplesKt.to("adequate", 65), TuplesKt.to("caution", 30), TuplesKt.to("weakness", 10));
    private static final Map<String, Integer> INSIGHT_WEIGHTS = MapsKt.mapOf(TuplesKt.to("acceleration", 3), TuplesKt.to("adequate_ramp", 3), TuplesKt.to("light_ramp", 3), TuplesKt.to("slow_development", 3), TuplesKt.to("strong_tutors", 3), TuplesKt.to("adequate_tutors", 3), TuplesKt.to("low_consistency", 3), TuplesKt.to("interaction", 3), TuplesKt.to("adequate_removal", 3), TuplesKt.to("light_removal", 3), TuplesKt.to("low_removal", 3), TuplesKt.to("strong_draw", 3), TuplesKt.to("adequate_draw", 3), TuplesKt.to("commander_draw", 3), TuplesKt.to("light_draw", 3), TuplesKt.to("card_advantage_gap", 3), TuplesKt.to("strong_recursion", 3), TuplesKt.to("adequate_recursion", 3), TuplesKt.to("limited_recursion", 3), TuplesKt.to("no_recursion", 3), TuplesKt.to("closing_power", 3), TuplesKt.to("adequate_closing_power", 3), TuplesKt.to("no_closing_power", 3), TuplesKt.to("strong_counterspells", 2), TuplesKt.to("adequate_counterspells", 2), TuplesKt.to("low_counterspells", 2), TuplesKt.to("strong_board_wipes", 2), TuplesKt.to("adequate_board_wipes", 2), TuplesKt.to("vulnerable_go_wide", 2), TuplesKt.to("strong_board_wipes_offcolor", 2), TuplesKt.to("adequate_board_wipes_offcolor", 2), TuplesKt.to("vulnerable_go_wide_offcolor", 2), TuplesKt.to("strong_protection", 2), TuplesKt.to("adequate_protection", 2), TuplesKt.to("light_protection", 2), TuplesKt.to("exposed_commander", 2), TuplesKt.to("focused_strategy", 2), TuplesKt.to("unfocused", 2), TuplesKt.to("top_heavy_curve", 2), TuplesKt.to("streamlined_curve", 2), TuplesKt.to("commander_dependent", 2), TuplesKt.to("defenseless", 2), TuplesKt.to("no_graveyard_hate", 2), TuplesKt.to("adequate_graveyard_hate", 2), TuplesKt.to("strong_graveyard_hate", 2), TuplesKt.to("competitive_edge", 1), TuplesKt.to("resilience", 1), TuplesKt.to("balance", 1), TuplesKt.to("evasive_threats", 1), TuplesKt.to("land_interaction", 1));
    private static final LinkedHashMap<String, List<String>> DH_CATEGORY_MAP = MapsKt.linkedMapOf(TuplesKt.to("ramp", CollectionsKt.listOf((Object[]) new String[]{"acceleration", "adequate_ramp", "light_ramp", "slow_development"})), TuplesKt.to("card_draw", CollectionsKt.listOf((Object[]) new String[]{"strong_draw", "adequate_draw", "commander_draw", "light_draw", "card_advantage_gap"})), TuplesKt.to("removal", CollectionsKt.listOf((Object[]) new String[]{"interaction", "adequate_removal", "light_removal", "low_removal"})), TuplesKt.to("tutors", CollectionsKt.listOf((Object[]) new String[]{"strong_tutors", "adequate_tutors", "low_consistency"})), TuplesKt.to("protection", CollectionsKt.listOf((Object[]) new String[]{"strong_protection", "adequate_protection", "light_protection", "exposed_commander", "commander_dependent"})), TuplesKt.to("recursion", CollectionsKt.listOf((Object[]) new String[]{"strong_recursion", "adequate_recursion", "limited_recursion", "no_recursion"})), TuplesKt.to("board_wipes", CollectionsKt.listOf((Object[]) new String[]{"strong_board_wipes", "adequate_board_wipes", "vulnerable_go_wide", "strong_board_wipes_offcolor", "adequate_board_wipes_offcolor", "vulnerable_go_wide_offcolor", "defenseless"})), TuplesKt.to("counterspells", CollectionsKt.listOf((Object[]) new String[]{"strong_counterspells", "adequate_counterspells", "low_counterspells"})), TuplesKt.to("closing_power", CollectionsKt.listOf((Object[]) new String[]{"closing_power", "adequate_closing_power", "no_closing_power"})), TuplesKt.to("strategy", CollectionsKt.listOf((Object[]) new String[]{"focused_strategy", "unfocused", "competitive_edge", "resilience", "balance", "top_heavy_curve", "streamlined_curve"})), TuplesKt.to("graveyard_hate", CollectionsKt.listOf((Object[]) new String[]{"no_graveyard_hate", "adequate_graveyard_hate", "strong_graveyard_hate"})));
    private static final Map<String, Integer> DH_CATEGORY_LABELS = MapsKt.mapOf(TuplesKt.to("ramp", Integer.valueOf(R.string.dh_cat_ramp)), TuplesKt.to("card_draw", Integer.valueOf(R.string.dh_cat_card_draw)), TuplesKt.to("removal", Integer.valueOf(R.string.dh_cat_removal)), TuplesKt.to("tutors", Integer.valueOf(R.string.dh_cat_tutors)), TuplesKt.to("protection", Integer.valueOf(R.string.dh_cat_protection)), TuplesKt.to("recursion", Integer.valueOf(R.string.dh_cat_recursion)), TuplesKt.to("board_wipes", Integer.valueOf(R.string.dh_cat_board_wipes)), TuplesKt.to("counterspells", Integer.valueOf(R.string.dh_cat_counterspells)), TuplesKt.to("closing_power", Integer.valueOf(R.string.dh_cat_closing_power)), TuplesKt.to("strategy", Integer.valueOf(R.string.dh_cat_strategy)), TuplesKt.to("graveyard_hate", Integer.valueOf(R.string.dh_cat_graveyard_hate)));
    private static final Map<String, List<String>> DH_AUTOTAG_MAP = MapsKt.mapOf(TuplesKt.to("ramp", CollectionsKt.listOf("ramp")), TuplesKt.to("card_draw", CollectionsKt.listOf("card_draw")), TuplesKt.to("removal", CollectionsKt.listOf((Object[]) new String[]{"spot_removal", "board_wipes"})), TuplesKt.to("tutors", CollectionsKt.listOf("tutor")), TuplesKt.to("protection", CollectionsKt.listOf("protection")), TuplesKt.to("recursion", CollectionsKt.listOf("recursion")), TuplesKt.to("board_wipes", CollectionsKt.listOf("board_wipes")), TuplesKt.to("counterspells", CollectionsKt.listOf("counterspell")), TuplesKt.to("closing_power", CollectionsKt.listOf("finisher")), TuplesKt.to("graveyard_hate", CollectionsKt.listOf("graveyard_hate")));
    private static final Map<String, Pair<Integer, Integer>> DH_RECOMMENDED = MapsKt.mapOf(TuplesKt.to("ramp", new Pair(8, 12)), TuplesKt.to("card_draw", new Pair(8, 12)), TuplesKt.to("removal", new Pair(8, 12)), TuplesKt.to("tutors", new Pair(1, 6)), TuplesKt.to("protection", new Pair(4, 6)), TuplesKt.to("recursion", new Pair(4, 8)), TuplesKt.to("board_wipes", new Pair(1, 5)), TuplesKt.to("counterspells", new Pair(4, 8)), TuplesKt.to("closing_power", new Pair(2, 3)), TuplesKt.to("graveyard_hate", new Pair(1, 4)));
    private static final Map<String, Integer> INSIGHT_LABEL_MAP = MapsKt.mapOf(TuplesKt.to("acceleration", Integer.valueOf(R.string.insight_acceleration)), TuplesKt.to("competitive_edge", Integer.valueOf(R.string.insight_competitive_edge)), TuplesKt.to("resilience", Integer.valueOf(R.string.insight_resilience)), TuplesKt.to("balance", Integer.valueOf(R.string.insight_balance)), TuplesKt.to("interaction", Integer.valueOf(R.string.insight_interaction)), TuplesKt.to("strong_protection", Integer.valueOf(R.string.insight_strong_protection)), TuplesKt.to("strong_recursion", Integer.valueOf(R.string.insight_strong_recursion)), TuplesKt.to("strong_draw", Integer.valueOf(R.string.insight_strong_draw)), TuplesKt.to("strong_board_wipes", Integer.valueOf(R.string.insight_strong_board_wipes)), TuplesKt.to("strong_tutors", Integer.valueOf(R.string.insight_strong_tutors)), TuplesKt.to("strong_counterspells", Integer.valueOf(R.string.insight_strong_counterspells)), TuplesKt.to("strong_graveyard_hate", Integer.valueOf(R.string.insight_strong_graveyard_hate)), TuplesKt.to("focused_strategy", Integer.valueOf(R.string.insight_focused_strategy)), TuplesKt.to("streamlined_curve", Integer.valueOf(R.string.insight_streamlined_curve)), TuplesKt.to("evasive_threats", Integer.valueOf(R.string.insight_evasive_threats)), TuplesKt.to("land_interaction", Integer.valueOf(R.string.insight_land_interaction)), TuplesKt.to("closing_power", Integer.valueOf(R.string.insight_closing_power)), TuplesKt.to("adequate_removal", Integer.valueOf(R.string.insight_adequate_removal)), TuplesKt.to("adequate_protection", Integer.valueOf(R.string.insight_adequate_protection)), TuplesKt.to("adequate_recursion", Integer.valueOf(R.string.insight_adequate_recursion)), TuplesKt.to("adequate_draw", Integer.valueOf(R.string.insight_adequate_draw)), TuplesKt.to("commander_draw", Integer.valueOf(R.string.insight_commander_draw)), TuplesKt.to("adequate_ramp", Integer.valueOf(R.string.insight_adequate_ramp)), TuplesKt.to("adequate_board_wipes", Integer.valueOf(R.string.insight_adequate_board_wipes)), TuplesKt.to("adequate_tutors", Integer.valueOf(R.string.insight_adequate_tutors)), TuplesKt.to("adequate_counterspells", Integer.valueOf(R.string.insight_adequate_counterspells)), TuplesKt.to("adequate_closing_power", Integer.valueOf(R.string.insight_adequate_closing_power)), TuplesKt.to("adequate_graveyard_hate", Integer.valueOf(R.string.insight_adequate_graveyard_hate)), TuplesKt.to("light_ramp", Integer.valueOf(R.string.insight_light_ramp)), TuplesKt.to("light_removal", Integer.valueOf(R.string.insight_light_removal)), TuplesKt.to("light_draw", Integer.valueOf(R.string.insight_light_draw)), TuplesKt.to("light_protection", Integer.valueOf(R.string.insight_light_protection)), TuplesKt.to("unfocused", Integer.valueOf(R.string.insight_unfocused)), TuplesKt.to("low_consistency", Integer.valueOf(R.string.insight_low_consistency)), TuplesKt.to("low_counterspells", Integer.valueOf(R.string.insight_low_counterspells)), TuplesKt.to("no_graveyard_hate", Integer.valueOf(R.string.insight_no_graveyard_hate)), TuplesKt.to("top_heavy_curve", Integer.valueOf(R.string.insight_top_heavy_curve)), TuplesKt.to("commander_dependent", Integer.valueOf(R.string.insight_commander_dependent)), TuplesKt.to("limited_recursion", Integer.valueOf(R.string.insight_limited_recursion)), TuplesKt.to("no_closing_power", Integer.valueOf(R.string.insight_no_closing_power)), TuplesKt.to("no_recursion", Integer.valueOf(R.string.insight_no_recursion)), TuplesKt.to("low_removal", Integer.valueOf(R.string.insight_low_removal)), TuplesKt.to("exposed_commander", Integer.valueOf(R.string.insight_exposed_commander)), TuplesKt.to("card_advantage_gap", Integer.valueOf(R.string.insight_card_advantage_gap)), TuplesKt.to("slow_development", Integer.valueOf(R.string.insight_slow_development)), TuplesKt.to("vulnerable_go_wide", Integer.valueOf(R.string.insight_vulnerable_go_wide)), TuplesKt.to("strong_board_wipes_offcolor", Integer.valueOf(R.string.insight_strong_board_wipes_offcolor)), TuplesKt.to("adequate_board_wipes_offcolor", Integer.valueOf(R.string.insight_adequate_board_wipes_offcolor)), TuplesKt.to("vulnerable_go_wide_offcolor", Integer.valueOf(R.string.insight_vulnerable_go_wide_offcolor)), TuplesKt.to("defenseless", Integer.valueOf(R.string.insight_defenseless)));
    private static final Map<String, Integer> TIER_RANK = MapsKt.mapOf(TuplesKt.to("weakness", 0), TuplesKt.to("caution", 1), TuplesKt.to("adequate", 2), TuplesKt.to("strength", 3));
    private static final Map<String, String> DH_GAP_TAG_MAP = MapsKt.mapOf(TuplesKt.to("ramp", "ramp"), TuplesKt.to("card_draw", "card_draw"), TuplesKt.to("removal", "spot_removal"), TuplesKt.to("tutors", "tutor"), TuplesKt.to("protection", "protection"), TuplesKt.to("recursion", "recursion"), TuplesKt.to("board_wipes", "board_wipes"), TuplesKt.to("counterspells", "counterspell"), TuplesKt.to("closing_power", "finisher"), TuplesKt.to("graveyard_hate", "graveyard_hate"));
    private final List<View> categoryBlockViews = new ArrayList();
    private int selectedBlockIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeckIDCardHealthDetailFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010'\u001a\u00020\u0003HÆ\u0003Jx\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006/"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment$CategoryDetail;", "", "category", "", Constants.ScionAnalytics.PARAM_LABEL, FirebaseAnalytics.Param.SCORE, "", "insights", "", "Lcom/studiolaganne/lengendarylens/MTIdCardDeckInsight;", "cardCount", "cardNames", "recommendedLow", "recommendedHigh", "worstTier", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getLabel", "getScore", "()I", "getInsights", "()Ljava/util/List;", "getCardCount", "getCardNames", "getRecommendedLow", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecommendedHigh", "getWorstTier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment$CategoryDetail;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class CategoryDetail {
        private final int cardCount;
        private final List<String> cardNames;
        private final String category;
        private final List<MTIdCardDeckInsight> insights;
        private final String label;
        private final Integer recommendedHigh;
        private final Integer recommendedLow;
        private final int score;
        private final String worstTier;

        public CategoryDetail(String category, String label, int i, List<MTIdCardDeckInsight> insights, int i2, List<String> cardNames, Integer num, Integer num2, String worstTier) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(insights, "insights");
            Intrinsics.checkNotNullParameter(cardNames, "cardNames");
            Intrinsics.checkNotNullParameter(worstTier, "worstTier");
            this.category = category;
            this.label = label;
            this.score = i;
            this.insights = insights;
            this.cardCount = i2;
            this.cardNames = cardNames;
            this.recommendedLow = num;
            this.recommendedHigh = num2;
            this.worstTier = worstTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CategoryDetail copy$default(CategoryDetail categoryDetail, String str, String str2, int i, List list, int i2, List list2, Integer num, Integer num2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = categoryDetail.category;
            }
            if ((i3 & 2) != 0) {
                str2 = categoryDetail.label;
            }
            if ((i3 & 4) != 0) {
                i = categoryDetail.score;
            }
            if ((i3 & 8) != 0) {
                list = categoryDetail.insights;
            }
            if ((i3 & 16) != 0) {
                i2 = categoryDetail.cardCount;
            }
            if ((i3 & 32) != 0) {
                list2 = categoryDetail.cardNames;
            }
            if ((i3 & 64) != 0) {
                num = categoryDetail.recommendedLow;
            }
            if ((i3 & 128) != 0) {
                num2 = categoryDetail.recommendedHigh;
            }
            if ((i3 & 256) != 0) {
                str3 = categoryDetail.worstTier;
            }
            Integer num3 = num2;
            String str4 = str3;
            List list3 = list2;
            Integer num4 = num;
            int i4 = i2;
            int i5 = i;
            return categoryDetail.copy(str, str2, i5, list, i4, list3, num4, num3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        public final List<MTIdCardDeckInsight> component4() {
            return this.insights;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getCardCount() {
            return this.cardCount;
        }

        public final List<String> component6() {
            return this.cardNames;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getRecommendedLow() {
            return this.recommendedLow;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getRecommendedHigh() {
            return this.recommendedHigh;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getWorstTier() {
            return this.worstTier;
        }

        public final CategoryDetail copy(String category, String label, int score, List<MTIdCardDeckInsight> insights, int cardCount, List<String> cardNames, Integer recommendedLow, Integer recommendedHigh, String worstTier) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(insights, "insights");
            Intrinsics.checkNotNullParameter(cardNames, "cardNames");
            Intrinsics.checkNotNullParameter(worstTier, "worstTier");
            return new CategoryDetail(category, label, score, insights, cardCount, cardNames, recommendedLow, recommendedHigh, worstTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryDetail)) {
                return false;
            }
            CategoryDetail categoryDetail = (CategoryDetail) other;
            return Intrinsics.areEqual(this.category, categoryDetail.category) && Intrinsics.areEqual(this.label, categoryDetail.label) && this.score == categoryDetail.score && Intrinsics.areEqual(this.insights, categoryDetail.insights) && this.cardCount == categoryDetail.cardCount && Intrinsics.areEqual(this.cardNames, categoryDetail.cardNames) && Intrinsics.areEqual(this.recommendedLow, categoryDetail.recommendedLow) && Intrinsics.areEqual(this.recommendedHigh, categoryDetail.recommendedHigh) && Intrinsics.areEqual(this.worstTier, categoryDetail.worstTier);
        }

        public final int getCardCount() {
            return this.cardCount;
        }

        public final List<String> getCardNames() {
            return this.cardNames;
        }

        public final String getCategory() {
            return this.category;
        }

        public final List<MTIdCardDeckInsight> getInsights() {
            return this.insights;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Integer getRecommendedHigh() {
            return this.recommendedHigh;
        }

        public final Integer getRecommendedLow() {
            return this.recommendedLow;
        }

        public final int getScore() {
            return this.score;
        }

        public final String getWorstTier() {
            return this.worstTier;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.category.hashCode() * 31) + this.label.hashCode()) * 31) + Integer.hashCode(this.score)) * 31) + this.insights.hashCode()) * 31) + Integer.hashCode(this.cardCount)) * 31) + this.cardNames.hashCode()) * 31;
            Integer num = this.recommendedLow;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.recommendedHigh;
            return ((iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.worstTier.hashCode();
        }

        public String toString() {
            return "CategoryDetail(category=" + this.category + ", label=" + this.label + ", score=" + this.score + ", insights=" + this.insights + ", cardCount=" + this.cardCount + ", cardNames=" + this.cardNames + ", recommendedLow=" + this.recommendedLow + ", recommendedHigh=" + this.recommendedHigh + ", worstTier=" + this.worstTier + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIDCardHealthDetailFragment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000ej\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00140\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment$Companion;", "", "<init>", "()V", "ARG_JSON", "", "newInstance", "Lcom/studiolaganne/lengendarylens/DeckIDCardHealthDetailFragment;", "responseJson", "TIER_TO_SCORE", "", "", "INSIGHT_WEIGHTS", "DH_CATEGORY_MAP", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "DH_CATEGORY_LABELS", "DH_AUTOTAG_MAP", "DH_RECOMMENDED", "Lkotlin/Pair;", "INSIGHT_LABEL_MAP", "TIER_RANK", "DH_GAP_TAG_MAP", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeckIDCardHealthDetailFragment newInstance(String responseJson) {
            Intrinsics.checkNotNullParameter(responseJson, "responseJson");
            DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragment = new DeckIDCardHealthDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DeckIDCardHealthDetailFragment.ARG_JSON, responseJson);
            deckIDCardHealthDetailFragment.setArguments(bundle);
            return deckIDCardHealthDetailFragment;
        }
    }

    private final void applyBlockBackground(View view, boolean selected) {
        Context context = view.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.manabase_insight_background));
        gradientDrawable.setCornerRadius(dp(12));
        if (selected) {
            gradientDrawable.setStroke(dp(2), ContextCompat.getColor(context, R.color.selected_color_new));
        } else {
            gradientDrawable.setStroke(dp(1), 549964490);
        }
        view.setBackground(gradientDrawable);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03ca  */
    /* JADX WARN: Type inference failed for: r11v34, types: [com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$buildCategoryBlocks$bar$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void buildCategoryBlocks(LinearLayout container, List<CategoryDetail> categories) {
        Typeface font;
        int i;
        int i2;
        String id;
        String rationaleEn;
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "fr");
        this.categoryBlockViews.clear();
        Iterator<CategoryDetail> it = categories.iterator();
        while (it.hasNext()) {
            final CategoryDetail next = it.next();
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(dp(14), dp(12), dp(14), dp(14));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dp(8);
            linearLayout.setLayoutParams(layoutParams);
            LinearLayout linearLayout2 = linearLayout;
            applyBlockBackground(linearLayout2, false);
            LinearLayout linearLayout3 = new LinearLayout(contextRequireContext);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(16);
            int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(next.getScore());
            TextView textView = new TextView(contextRequireContext);
            textView.setText(next.getScore() + "/100");
            textView.setTextSize(13.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setGravity(17);
            textView.setTextColor(iInterpolateScoreColor);
            int i3 = 6;
            textView.setPadding(dp(10), dp(6), dp(10), dp(6));
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i4 = 16777215 & iInterpolateScoreColor;
            gradientDrawable.setColor(855638016 | i4);
            gradientDrawable.setCornerRadius(dp(8));
            gradientDrawable.setStroke(dp(1), i4 | 1291845632);
            textView.setBackground(gradientDrawable);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginEnd(dp(10));
            textView.setLayoutParams(layoutParams2);
            linearLayout3.addView(textView);
            LinearLayout linearLayout4 = new LinearLayout(contextRequireContext);
            linearLayout4.setOrientation(1);
            linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView2 = new TextView(contextRequireContext);
            textView2.setText(next.getLabel());
            textView2.setTextSize(16.0f);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.almost_white));
            Unit unit = Unit.INSTANCE;
            linearLayout4.addView(textView2);
            if (next.getRecommendedLow() != null && next.getRecommendedHigh() != null) {
                int color = next.getCardCount() >= next.getRecommendedLow().intValue() ? ContextCompat.getColor(contextRequireContext, R.color.positive_green) : next.getCardCount() > 0 ? ContextCompat.getColor(contextRequireContext, R.color.selected_color_new) : ContextCompat.getColor(contextRequireContext, R.color.error_red);
                LinearLayout linearLayout5 = new LinearLayout(contextRequireContext);
                linearLayout5.setOrientation(0);
                linearLayout5.setGravity(16);
                TextView textView3 = new TextView(contextRequireContext);
                textView3.setText(getString(R.string.dh_cards_label, Integer.valueOf(next.getCardCount())));
                textView3.setTextSize(13.0f);
                textView3.setTextColor(color);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginEnd(dp(6));
                textView3.setLayoutParams(layoutParams3);
                Unit unit2 = Unit.INSTANCE;
                linearLayout5.addView(textView3);
                TextView textView4 = new TextView(contextRequireContext);
                textView4.setText(getString(R.string.dh_recommended_label, next.getRecommendedLow(), next.getRecommendedHigh()));
                textView4.setTextSize(12.0f);
                textView4.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                Unit unit3 = Unit.INSTANCE;
                linearLayout5.addView(textView4);
                linearLayout4.addView(linearLayout5);
            }
            linearLayout3.addView(linearLayout4);
            linearLayout.addView(linearLayout3);
            if (next.getRecommendedLow() != null && next.getRecommendedHigh() != null) {
                final int color2 = next.getCardCount() >= next.getRecommendedLow().intValue() ? ContextCompat.getColor(contextRequireContext, R.color.positive_green) : next.getCardCount() > 0 ? ContextCompat.getColor(contextRequireContext, R.color.selected_color_new) : ContextCompat.getColor(contextRequireContext, R.color.error_red);
                LinearLayout linearLayout6 = new LinearLayout(contextRequireContext);
                linearLayout6.setOrientation(0);
                linearLayout6.setGravity(16);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.topMargin = dp(10);
                linearLayout6.setLayoutParams(layoutParams4);
                final float fCoerceIn = RangesKt.coerceIn(next.getCardCount() / RangesKt.coerceAtLeast(next.getRecommendedHigh().intValue(), 1), 0.0f, 1.0f);
                ?? r11 = new View(contextRequireContext, color2, fCoerceIn) { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$buildCategoryBlocks$bar$1
                    final /* synthetic */ float $fraction;
                    private final Paint bgPaint;
                    private final Paint fgPaint;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext);
                        this.$fraction = fCoerceIn;
                        Paint paint = new Paint(1);
                        paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                        this.bgPaint = paint;
                        Paint paint2 = new Paint(1);
                        paint2.setColor((color2 & 16777215) | Integer.MIN_VALUE);
                        this.fgPaint = paint2;
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        float f = getResources().getDisplayMetrics().density * 4.0f;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgPaint);
                        float width = getWidth() * this.$fraction;
                        if (width > 0.0f) {
                            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgPaint);
                        }
                    }
                };
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, dp(10), 1.0f);
                layoutParams5.setMarginEnd(dp(8));
                Unit unit4 = Unit.INSTANCE;
                r11.setLayoutParams(layoutParams5);
                linearLayout6.addView((View) r11);
                TextView textView5 = new TextView(contextRequireContext);
                textView5.setText(next.getCardCount() + DomExceptionUtils.SEPARATOR + next.getRecommendedHigh());
                textView5.setTextSize(13.0f);
                textView5.setTypeface(Typeface.DEFAULT_BOLD);
                textView5.setTextColor(color2);
                Unit unit5 = Unit.INSTANCE;
                linearLayout6.addView(textView5);
                linearLayout.addView(linearLayout6);
            }
            if (!next.getInsights().isEmpty()) {
                View view = new View(contextRequireContext);
                view.setBackgroundColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, dp(1));
                layoutParams6.topMargin = dp(10);
                layoutParams6.bottomMargin = dp(8);
                view.setLayoutParams(layoutParams6);
                Unit unit6 = Unit.INSTANCE;
                linearLayout.addView(view);
                Iterator<MTIdCardDeckInsight> it2 = next.getInsights().iterator();
                while (it2.hasNext()) {
                    MTIdCardDeckInsight next2 = it2.next();
                    LinearLayout linearLayout7 = new LinearLayout(contextRequireContext);
                    linearLayout7.setOrientation(0);
                    linearLayout7.setGravity(16);
                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams7.bottomMargin = dp(i3);
                    linearLayout7.setLayoutParams(layoutParams7);
                    String tier = next2.getTier();
                    if (tier != null) {
                        switch (tier.hashCode()) {
                            case -1190549876:
                                i = !tier.equals("adequate") ? R.color.insight_adequate_background : R.color.insight_adequate_background;
                                break;
                            case -736186929:
                                if (tier.equals("weakness")) {
                                    i = R.color.insight_weakness_background;
                                    break;
                                }
                                break;
                            case 557191019:
                                if (tier.equals("caution")) {
                                    i = R.color.insight_caution_background;
                                    break;
                                }
                                break;
                            case 1791316033:
                                if (tier.equals("strength")) {
                                    i = R.color.insight_strength_background;
                                    break;
                                }
                                break;
                        }
                    }
                    String tier2 = next2.getTier();
                    if (tier2 != null) {
                        switch (tier2.hashCode()) {
                            case -1190549876:
                                i2 = !tier2.equals("adequate") ? R.color.insight_adequate_stroke : R.color.insight_adequate_stroke;
                                break;
                            case -736186929:
                                if (tier2.equals("weakness")) {
                                    i2 = R.color.insight_weakness_stroke;
                                    break;
                                }
                                break;
                            case 557191019:
                                if (tier2.equals("caution")) {
                                    i2 = R.color.insight_caution_stroke;
                                    break;
                                }
                                break;
                            case 1791316033:
                                if (tier2.equals("strength")) {
                                    i2 = R.color.insight_strength_stroke;
                                    break;
                                }
                                break;
                        }
                    }
                    Integer num = INSIGHT_LABEL_MAP.get(next2.getId());
                    if ((num == null || (id = getString(num.intValue())) == null) && (id = next2.getId()) == null) {
                        id = "";
                    }
                    TextView textView6 = new TextView(contextRequireContext);
                    textView6.setText(id);
                    textView6.setTextSize(12.0f);
                    textView6.setTypeface(Typeface.DEFAULT_BOLD);
                    textView6.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.almost_white));
                    boolean z = zAreEqual;
                    Iterator<CategoryDetail> it3 = it;
                    Iterator<MTIdCardDeckInsight> it4 = it2;
                    textView6.setPadding(dp(8), dp(4), dp(8), dp(4));
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(ContextCompat.getColor(contextRequireContext, i));
                    gradientDrawable2.setCornerRadius(dp(12));
                    gradientDrawable2.setStroke(dp(1), ContextCompat.getColor(contextRequireContext, i2));
                    textView6.setBackground(gradientDrawable2);
                    LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams8.setMarginEnd(dp(8));
                    textView6.setLayoutParams(layoutParams8);
                    linearLayout7.addView(textView6);
                    if (!z || (rationaleEn = next2.getRationaleFr()) == null) {
                        rationaleEn = next2.getRationaleEn();
                    }
                    String str = rationaleEn;
                    if (str != null && !StringsKt.isBlank(str)) {
                        TextView textView7 = new TextView(contextRequireContext);
                        textView7.setText(str);
                        textView7.setTextSize(13.0f);
                        textView7.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                        textView7.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                        Unit unit7 = Unit.INSTANCE;
                        linearLayout7.addView(textView7);
                    }
                    linearLayout.addView(linearLayout7);
                    zAreEqual = z;
                    it = it3;
                    it2 = it4;
                    i3 = 6;
                }
            }
            boolean z2 = zAreEqual;
            Iterator<CategoryDetail> it5 = it;
            if (!next.getCardNames().isEmpty()) {
                View view2 = new View(contextRequireContext);
                view2.setBackgroundColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, dp(1));
                layoutParams9.topMargin = dp(4);
                layoutParams9.bottomMargin = dp(8);
                view2.setLayoutParams(layoutParams9);
                Unit unit8 = Unit.INSTANCE;
                linearLayout.addView(view2);
                TextView textView8 = new TextView(contextRequireContext);
                textView8.setText(getString(R.string.dh_cards_in_deck_header, next.getLabel()));
                textView8.setTextSize(11.0f);
                textView8.setTypeface(Typeface.DEFAULT_BOLD);
                textView8.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.almost_white));
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams10.bottomMargin = dp(4);
                textView8.setLayoutParams(layoutParams10);
                Unit unit9 = Unit.INSTANCE;
                linearLayout.addView(textView8);
                TextView textView9 = new TextView(contextRequireContext);
                textView9.setText(CollectionsKt.joinToString$default(next.getCardNames(), " - ", null, null, 0, null, null, 62, null));
                textView9.setTextSize(13.0f);
                textView9.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                textView9.setMaxLines(4);
                textView9.setEllipsize(TextUtils.TruncateAt.END);
                Unit unit10 = Unit.INSTANCE;
                linearLayout.addView(textView9);
                TextView textView10 = new TextView(contextRequireContext);
                textView10.setText(getString(R.string.view_all));
                textView10.setTextSize(12.0f);
                textView10.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.link_color));
                textView10.setGravity(GravityCompat.END);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams11.topMargin = dp(4);
                textView10.setLayoutParams(layoutParams11);
                textView10.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        DeckIDCardHealthDetailFragment.buildCategoryBlocks$lambda$19$1(contextRequireContext, this, next, view3);
                    }
                });
                Unit unit11 = Unit.INSTANCE;
                linearLayout.addView(textView10);
            }
            final String str2 = DH_GAP_TAG_MAP.get(next.getCategory());
            if (str2 != null) {
                boolean z3 = Intrinsics.areEqual(next.getWorstTier(), "weakness") || Intrinsics.areEqual(next.getWorstTier(), "caution");
                String lowerCase = next.getLabel().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                try {
                    font = ResourcesCompat.getFont(contextRequireContext, R.font.fa6solid);
                } catch (Exception unused) {
                    font = null;
                }
                if (z3) {
                    LinearLayout linearLayout8 = new LinearLayout(contextRequireContext);
                    linearLayout8.setOrientation(1);
                    linearLayout8.setPadding(dp(12), dp(12), dp(12), dp(12));
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setColor(267229783);
                    gradientDrawable3.setCornerRadius(dp(12));
                    gradientDrawable3.setStroke(dp(1), 653105751);
                    linearLayout8.setBackground(gradientDrawable3);
                    LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams12.topMargin = dp(10);
                    linearLayout8.setLayoutParams(layoutParams12);
                    LinearLayout linearLayout9 = new LinearLayout(contextRequireContext);
                    linearLayout9.setOrientation(0);
                    linearLayout9.setGravity(16);
                    TextView textView11 = new TextView(contextRequireContext);
                    textView11.setText("\uf0eb");
                    textView11.setTypeface(font);
                    textView11.setTextSize(11.0f);
                    textView11.setTextColor(-1712481705);
                    LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams13.setMarginEnd(dp(6));
                    textView11.setLayoutParams(layoutParams13);
                    Unit unit12 = Unit.INSTANCE;
                    linearLayout9.addView(textView11);
                    TextView textView12 = new TextView(contextRequireContext);
                    textView12.setText(getString(R.string.dh_find_cards_looking, lowerCase));
                    textView12.setTextSize(12.0f);
                    textView12.setTypeface(Typeface.DEFAULT_BOLD);
                    textView12.setTextColor(-856843689);
                    Unit unit13 = Unit.INSTANCE;
                    linearLayout9.addView(textView12);
                    linearLayout8.addView(linearLayout9);
                    TextView textView13 = new TextView(contextRequireContext);
                    textView13.setText(getString(R.string.dh_find_cards_desc, lowerCase));
                    textView13.setTextSize(11.0f);
                    textView13.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                    textView13.setAlpha(0.7f);
                    LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams14.topMargin = dp(4);
                    layoutParams14.bottomMargin = dp(8);
                    textView13.setLayoutParams(layoutParams14);
                    Unit unit14 = Unit.INSTANCE;
                    linearLayout8.addView(textView13);
                    LinearLayout linearLayout10 = new LinearLayout(contextRequireContext);
                    linearLayout10.setOrientation(0);
                    linearLayout10.setGravity(16);
                    linearLayout10.setPadding(dp(12), dp(6), dp(12), dp(6));
                    GradientDrawable gradientDrawable4 = new GradientDrawable();
                    gradientDrawable4.setColor(653105751);
                    gradientDrawable4.setCornerRadius(dp(8));
                    gradientDrawable4.setStroke(dp(1), 1089313367);
                    linearLayout10.setBackground(gradientDrawable4);
                    linearLayout10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    linearLayout10.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            DeckIDCardHealthDetailFragment.buildCategoryBlocks$lambda$25$1(this.f$0, str2, view3);
                        }
                    });
                    TextView textView14 = new TextView(contextRequireContext);
                    textView14.setText("\uf002");
                    textView14.setTypeface(font);
                    textView14.setTextSize(10.0f);
                    textView14.setTextColor(-1205673);
                    LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams15.setMarginEnd(dp(6));
                    textView14.setLayoutParams(layoutParams15);
                    Unit unit15 = Unit.INSTANCE;
                    linearLayout10.addView(textView14);
                    TextView textView15 = new TextView(contextRequireContext);
                    textView15.setText(getString(R.string.dh_find_cards));
                    textView15.setTextSize(11.0f);
                    textView15.setTypeface(Typeface.DEFAULT_BOLD);
                    textView15.setTextColor(-1205673);
                    Unit unit16 = Unit.INSTANCE;
                    linearLayout10.addView(textView15);
                    linearLayout8.addView(linearLayout10);
                    linearLayout.addView(linearLayout8);
                } else {
                    TextView textView16 = new TextView(contextRequireContext);
                    textView16.setText(getString(R.string.dh_add_more, lowerCase));
                    textView16.setTextSize(12.0f);
                    textView16.setTypeface(Typeface.DEFAULT_BOLD);
                    textView16.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                    textView16.setAlpha(0.9f);
                    textView16.setPadding(dp(12), dp(6), dp(12), dp(6));
                    GradientDrawable gradientDrawable5 = new GradientDrawable();
                    gradientDrawable5.setColor(0);
                    gradientDrawable5.setCornerRadius(dp(8));
                    gradientDrawable5.setStroke(dp(1), 1090519039);
                    textView16.setBackground(gradientDrawable5);
                    LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams16.topMargin = dp(10);
                    textView16.setLayoutParams(layoutParams16);
                    textView16.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            DeckIDCardHealthDetailFragment.buildCategoryBlocks$lambda$28$2(this.f$0, str2, view3);
                        }
                    });
                    linearLayout.addView(textView16);
                }
            }
            container.addView(linearLayout2);
            this.categoryBlockViews.add(linearLayout);
            zAreEqual = z2;
            it = it5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildCategoryBlocks$lambda$19$1(Context context, DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragment, CategoryDetail categoryDetail, View view) {
        List<MTFullCard> deckCardList = DeckIDCardDetailsBottomSheetFragment.INSTANCE.getDeckCardList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : deckCardList) {
            MTFullCard mTFullCard = (MTFullCard) obj;
            List<String> cardNames = categoryDetail.getCardNames();
            if (!(cardNames instanceof Collection) || !cardNames.isEmpty()) {
                Iterator<T> it = cardNames.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (StringsKt.equals((String) it.next(), mTFullCard.getName(), true)) {
                            arrayList.add(obj);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        CardDataStore.INSTANCE.setMtCardList(arrayList2);
        Intent intent = new Intent(context, (Class<?>) CardActivity.class);
        intent.putExtra("singleMTCard", new Gson().toJson(CollectionsKt.first((List) arrayList2)));
        intent.putExtra("hasMTCards", true);
        intent.putExtra("currentMTIndex", 0);
        deckIDCardHealthDetailFragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildCategoryBlocks$lambda$25$1(DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragment, String str, View view) {
        Function1<? super String, Unit> function1 = deckIDCardHealthDetailFragment.onFindCards;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildCategoryBlocks$lambda$28$2(DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragment, String str, View view) {
        Function1<? super String, Unit> function1 = deckIDCardHealthDetailFragment.onFindCards;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    private final void buildContent(LinearLayout container) {
        List<MTIdCardDeckInsight> insights;
        Map<String, Integer> mapEmptyMap;
        Map<String, List<String>> mapEmptyMap2;
        MTIdCardDeckHealthScore deckHealthScore;
        Integer overall;
        String tier;
        String string;
        MTIdCardThemeAnalysis themeAnalysis;
        MTIdCardThemeAnalysis themeAnalysis2;
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        if (mTDeckIdCardResponse == null || (insights = mTDeckIdCardResponse.getInsights()) == null || insights.isEmpty()) {
            return;
        }
        List<MTIdCardDeckInsight> list = insights;
        int i = 10;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((MTIdCardDeckInsight) obj).getId(), obj);
        }
        MTDeckIdCardResponse mTDeckIdCardResponse2 = this.response;
        if (mTDeckIdCardResponse2 == null || (themeAnalysis2 = mTDeckIdCardResponse2.getThemeAnalysis()) == null || (mapEmptyMap = themeAnalysis2.getAutoTags()) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        MTDeckIdCardResponse mTDeckIdCardResponse3 = this.response;
        if (mTDeckIdCardResponse3 == null || (themeAnalysis = mTDeckIdCardResponse3.getThemeAnalysis()) == null || (mapEmptyMap2 = themeAnalysis.getAutoTagCards()) == null) {
            mapEmptyMap2 = MapsKt.emptyMap();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, List<String>> entry : DH_CATEGORY_MAP.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                MTIdCardDeckInsight mTIdCardDeckInsight = (MTIdCardDeckInsight) linkedHashMap.get((String) it.next());
                if (mTIdCardDeckInsight != null) {
                    arrayList3.add(mTIdCardDeckInsight);
                }
            }
            ArrayList<MTIdCardDeckInsight> arrayList4 = arrayList3;
            if (!arrayList4.isEmpty()) {
                int i2 = 0;
                int iIntValue = 0;
                for (MTIdCardDeckInsight mTIdCardDeckInsight2 : arrayList4) {
                    Integer num = INSIGHT_WEIGHTS.get(mTIdCardDeckInsight2.getId());
                    int iIntValue2 = num != null ? num.intValue() : 1;
                    Integer num2 = TIER_TO_SCORE.get(mTIdCardDeckInsight2.getTier());
                    i2 += iIntValue2;
                    iIntValue += (num2 != null ? num2.intValue() : 50) * iIntValue2;
                }
                int iCoerceAtLeast = i2 > 0 ? RangesKt.coerceAtLeast(MathKt.roundToInt(((double) iIntValue) / ((double) i2)), i) : i;
                Integer num3 = DH_CATEGORY_LABELS.get(key);
                String str = (num3 == null || (string = getString(num3.intValue())) == null) ? key : string;
                List<String> listEmptyList = DH_AUTOTAG_MAP.get(key);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List<String> list2 = listEmptyList;
                Iterator<T> it2 = list2.iterator();
                int iIntValue3 = 0;
                while (it2.hasNext()) {
                    Integer num4 = mapEmptyMap.get((String) it2.next());
                    iIntValue3 += num4 != null ? num4.intValue() : 0;
                }
                ArrayList arrayList5 = new ArrayList();
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    List<String> listEmptyList2 = mapEmptyMap2.get((String) it3.next());
                    if (listEmptyList2 == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    CollectionsKt.addAll(arrayList5, listEmptyList2);
                }
                List listSorted = CollectionsKt.sorted(CollectionsKt.distinct(arrayList5));
                Pair<Integer, Integer> pair = DH_RECOMMENDED.get(key);
                String str2 = "strength";
                for (MTIdCardDeckInsight mTIdCardDeckInsight3 : arrayList4) {
                    Map<String, Integer> map = TIER_RANK;
                    Map<String, Integer> map2 = mapEmptyMap;
                    Integer num5 = map.get(mTIdCardDeckInsight3.getTier());
                    int iIntValue4 = num5 != null ? num5.intValue() : 2;
                    Integer num6 = map.get(str2);
                    if (iIntValue4 < (num6 != null ? num6.intValue() : 2) && (tier = mTIdCardDeckInsight3.getTier()) != null) {
                        str2 = tier;
                    }
                    mapEmptyMap = map2;
                }
                Map<String, Integer> map3 = mapEmptyMap;
                arrayList.add(new CategoryDetail(key, str, iCoerceAtLeast, arrayList4, iIntValue3, listSorted, pair != null ? pair.getFirst() : null, pair != null ? pair.getSecond() : null, str2));
                arrayList2.add(new ManabaseRadarChartView.DataPoint(str, iCoerceAtLeast, ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iCoerceAtLeast)));
                mapEmptyMap = map3;
                i = 10;
            }
        }
        if (arrayList2.size() < 3) {
            return;
        }
        MTDeckIdCardResponse mTDeckIdCardResponse4 = this.response;
        int iIntValue5 = (mTDeckIdCardResponse4 == null || (deckHealthScore = mTDeckIdCardResponse4.getDeckHealthScore()) == null || (overall = deckHealthScore.getOverall()) == null) ? 0 : overall.intValue();
        int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iIntValue5);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ManabaseRadarChartView manabaseRadarChartView = new ManabaseRadarChartView(contextRequireContext, null, 0, 6, null);
        manabaseRadarChartView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String string2 = getString(R.string.deck_health_score_label);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        manabaseRadarChartView.setData(arrayList2, iIntValue5, iInterpolateScoreColor, string2);
        manabaseRadarChartView.setOnDataPointSelected(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeckIDCardHealthDetailFragment.buildContent$lambda$6$0(this.f$0, ((Integer) obj2).intValue());
            }
        });
        container.addView(manabaseRadarChartView);
        buildCategoryBlocks(container, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildContent$lambda$6$0(DeckIDCardHealthDetailFragment deckIDCardHealthDetailFragment, int i) {
        deckIDCardHealthDetailFragment.selectCategoryBlock(i);
        return Unit.INSTANCE;
    }

    private final int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    private final void selectCategoryBlock(int index) {
        if (index < 0 || index >= this.categoryBlockViews.size()) {
            return;
        }
        int i = this.selectedBlockIndex;
        this.selectedBlockIndex = index;
        if (i >= 0 && i < this.categoryBlockViews.size()) {
            applyBlockBackground(this.categoryBlockViews.get(i), false);
        }
        applyBlockBackground(this.categoryBlockViews.get(index), true);
        View view = getView();
        LinearLayout linearLayout = view != null ? (LinearLayout) view.findViewById(R.id.healthContentLayout) : null;
        ViewParent parent = linearLayout != null ? linearLayout.getParent() : null;
        final ScrollView scrollView = parent instanceof ScrollView ? (ScrollView) parent : null;
        final View view2 = this.categoryBlockViews.get(index);
        if (scrollView != null) {
            scrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckIDCardHealthDetailFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    scrollView.smoothScrollTo(0, view2.getTop());
                }
            });
        }
    }

    public final Function1<String, Unit> getOnFindCards() {
        return this.onFindCards;
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
        return inflater.inflate(R.layout.fragment_deck_id_card_health, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.healthContentLayout);
        Intrinsics.checkNotNull(linearLayout);
        buildContent(linearLayout);
    }

    public final void setOnFindCards(Function1<? super String, Unit> function1) {
        this.onFindCards = function1;
    }
}
