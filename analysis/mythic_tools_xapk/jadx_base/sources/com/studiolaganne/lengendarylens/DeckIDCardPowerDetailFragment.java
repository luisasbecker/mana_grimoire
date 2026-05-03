package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.PowerDNAMapView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DeckIDCardPowerDetailFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardPowerDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "addSectionHeader", "Landroid/widget/LinearLayout;", "icon", "", Constants.GP_IAP_TITLE, "buildDNAMap", "pl", "Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;", "buildCardQuality", "buildPowerMetrics", "buildRoundedBlock", "buildScoreBadge", "Landroid/widget/TextView;", FirebaseAnalytics.Param.SCORE, "", "color", "buildScoreBar", "fraction", "", "dp", "value", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIDCardPowerDetailFragment extends Fragment {
    private static final String ARG_JSON = "response_json";
    private MTDeckIdCardResponse response;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final List<String> TIER_ORDER = CollectionsKt.listOf((Object[]) new String[]{"jank", "precon", "bracket4", "cedh"});
    private static final Map<String, Integer> TIER_LABELS = MapsKt.mapOf(TuplesKt.to("jank", Integer.valueOf(R.string.pw_tier_homebrew)), TuplesKt.to("precon", Integer.valueOf(R.string.pw_tier_precon)), TuplesKt.to("bracket4", Integer.valueOf(R.string.pw_tier_optimized)), TuplesKt.to("cedh", Integer.valueOf(R.string.pw_tier_cedh)));
    private static final List<String> METRIC_ORDER = CollectionsKt.listOf((Object[]) new String[]{"avg_cmc", "tutors", "combos", "interaction", "fast_mana"});
    private static final Map<String, Integer> METRIC_LABELS = MapsKt.mapOf(TuplesKt.to("avg_cmc", Integer.valueOf(R.string.pw_metric_avg_cmc)), TuplesKt.to("tutors", Integer.valueOf(R.string.pw_metric_tutors)), TuplesKt.to("combos", Integer.valueOf(R.string.pw_metric_combos)), TuplesKt.to("interaction", Integer.valueOf(R.string.pw_metric_interaction)), TuplesKt.to("fast_mana", Integer.valueOf(R.string.pw_metric_fast_mana)));

    /* JADX INFO: compiled from: DeckIDCardPowerDetailFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardPowerDetailFragment$Companion;", "", "<init>", "()V", "ARG_JSON", "", "newInstance", "Lcom/studiolaganne/lengendarylens/DeckIDCardPowerDetailFragment;", "responseJson", "TIER_ORDER", "", "TIER_LABELS", "", "", "METRIC_ORDER", "METRIC_LABELS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeckIDCardPowerDetailFragment newInstance(String responseJson) {
            Intrinsics.checkNotNullParameter(responseJson, "responseJson");
            DeckIDCardPowerDetailFragment deckIDCardPowerDetailFragment = new DeckIDCardPowerDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DeckIDCardPowerDetailFragment.ARG_JSON, responseJson);
            deckIDCardPowerDetailFragment.setArguments(bundle);
            return deckIDCardPowerDetailFragment;
        }
    }

    private final void addSectionHeader(LinearLayout container, String icon, String title) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int color = ContextCompat.getColor(contextRequireContext, R.color.text_color);
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(dp(8), 0, dp(8), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dp(16);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(contextRequireContext);
        textView.setText(icon);
        textView.setTypeface(ResourcesCompat.getFont(contextRequireContext, R.font.fa6solid));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(color);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginEnd(dp(8));
        textView.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(contextRequireContext);
        textView2.setText(title);
        textView2.setTypeface(ResourcesCompat.getFont(contextRequireContext, R.font.be_vietnam_pro_semibold));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(color);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        container.addView(linearLayout);
    }

    private final void buildCardQuality(LinearLayout container, MTIdCardPowerLevel pl) {
        MTIdCardPowerSignalWeights signalWeights;
        Double cardPower;
        Double cardPower2;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTIdCardPowerSignals signals = pl.getSignals();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        int iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(((signals == null || (cardPower2 = signals.getCardPower()) == null) ? 0.0d : cardPower2.doubleValue()) * 100.0d), 0, 100);
        int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iCoerceIn);
        MTIdCardPowerDetails details = pl.getDetails();
        if (details != null && (signalWeights = details.getSignalWeights()) != null && (cardPower = signalWeights.getCardPower()) != null) {
            dDoubleValue = cardPower.doubleValue();
        }
        int iRoundToInt = MathKt.roundToInt(dDoubleValue * 100.0d);
        LinearLayout linearLayoutBuildRoundedBlock = buildRoundedBlock();
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(buildScoreBadge(iCoerceIn, iInterpolateScoreColor));
        LinearLayout linearLayout2 = new LinearLayout(contextRequireContext);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView = new TextView(contextRequireContext);
        textView.setText(getString(R.string.pw_card_quality));
        textView.setTextSize(16.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.almost_white));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(contextRequireContext);
        textView2.setText(getString(R.string.pw_score_contribution, Integer.valueOf(iRoundToInt)));
        textView2.setTextSize(12.0f);
        textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        linearLayoutBuildRoundedBlock.addView(linearLayout);
        linearLayoutBuildRoundedBlock.addView(buildScoreBar(iCoerceIn / 100.0f, iInterpolateScoreColor));
        MTIdCardPowerDetails details2 = pl.getDetails();
        MTIdCardCardPowerCoverage cardPowerCoverage = details2 != null ? details2.getCardPowerCoverage() : null;
        if (cardPowerCoverage != null) {
            Integer cardsWithWeights = cardPowerCoverage.getCardsWithWeights();
            int iIntValue = cardsWithWeights != null ? cardsWithWeights.intValue() : 0;
            Integer totalCards = cardPowerCoverage.getTotalCards();
            int iIntValue2 = totalCards != null ? totalCards.intValue() : 0;
            Integer coveragePct = cardPowerCoverage.getCoveragePct();
            int iIntValue3 = coveragePct != null ? coveragePct.intValue() : 0;
            LinearLayout linearLayout3 = new LinearLayout(contextRequireContext);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dp(8);
            linearLayout3.setLayoutParams(layoutParams);
            TextView textView3 = new TextView(contextRequireContext);
            textView3.setText("\uf05a");
            textView3.setTypeface(ResourcesCompat.getFont(contextRequireContext, R.font.fa6solid));
            textView3.setTextSize(2, 11.0f);
            textView3.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginEnd(dp(6));
            textView3.setLayoutParams(layoutParams2);
            linearLayout3.addView(textView3);
            TextView textView4 = new TextView(contextRequireContext);
            textView4.setText(getString(R.string.pw_card_coverage, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3)));
            textView4.setTextSize(12.0f);
            textView4.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
            linearLayout3.addView(textView4);
            linearLayoutBuildRoundedBlock.addView(linearLayout3);
        }
        container.addView(linearLayoutBuildRoundedBlock);
    }

    private final void buildDNAMap(LinearLayout container, MTIdCardPowerLevel pl) {
        List<MTIdCardTierAffinity> tierAffinities;
        String tier;
        Object next;
        MTIdCardPowerDetails details = pl.getDetails();
        if (details == null || (tierAffinities = details.getTierAffinities()) == null) {
            return;
        }
        List<String> list = TIER_ORDER;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Iterator<T> it = tierAffinities.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.areEqual(((MTIdCardTierAffinity) next).getTier(), str)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTIdCardTierAffinity mTIdCardTierAffinity = (MTIdCardTierAffinity) next;
            if (mTIdCardTierAffinity != null) {
                arrayList.add(mTIdCardTierAffinity);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() < 2) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Integer score = pl.getScore();
        int iIntValue = score != null ? score.intValue() : 0;
        int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iIntValue);
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        int i = 0;
        for (Object obj : arrayList3) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MTIdCardTierAffinity mTIdCardTierAffinity2 = (MTIdCardTierAffinity) obj;
            Integer num = TIER_LABELS.get(mTIdCardTierAffinity2.getTier());
            if ((num == null || (tier = getString(num.intValue())) == null) && (tier = mTIdCardTierAffinity2.getTier()) == null) {
                tier = "";
            }
            Double similarity = mTIdCardTierAffinity2.getSimilarity();
            double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
            int iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt((similarity != null ? similarity.doubleValue() : 0.0d) * 100.0d), 0, 100);
            Double weight = mTIdCardTierAffinity2.getWeight();
            if (weight != null) {
                dDoubleValue = weight.doubleValue();
            }
            float f = (float) dDoubleValue;
            int[] tier_colors = PowerDNAMapView.INSTANCE.getTIER_COLORS();
            arrayList4.add(new PowerDNAMapView.TierPoint(tier, iCoerceIn, f, (i < 0 || i >= tier_colors.length) ? -3683638 : tier_colors[i]));
            i = i2;
        }
        ArrayList arrayList5 = arrayList4;
        PowerDNAMapView powerDNAMapView = new PowerDNAMapView(contextRequireContext, null, 0, 6, null);
        powerDNAMapView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String string = getString(R.string.pw_dna_hint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        powerDNAMapView.setHintText(string);
        powerDNAMapView.setData(arrayList5, iIntValue, iInterpolateScoreColor);
        powerDNAMapView.setOnTierSelected(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckIDCardPowerDetailFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeckIDCardPowerDetailFragment.buildDNAMap$lambda$2$0(((Integer) obj2).intValue());
            }
        });
        container.addView(powerDNAMapView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildDNAMap$lambda$2$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void buildPowerMetrics(LinearLayout container, MTIdCardPowerLevel pl) {
        List<MTIdCardStructuralMetric> structuralBreakdown;
        String string;
        LinkedHashMap linkedHashMap;
        double dDoubleValue;
        String string2;
        char c;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTIdCardPowerDetails details = pl.getDetails();
        if (details == null || (structuralBreakdown = details.getStructuralBreakdown()) == null || structuralBreakdown.isEmpty()) {
            return;
        }
        List<MTIdCardStructuralMetric> list = structuralBreakdown;
        int i = 10;
        char c2 = 16;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap2.put(((MTIdCardStructuralMetric) obj).getMetric(), obj);
        }
        LinearLayout linearLayoutBuildRoundedBlock = buildRoundedBlock();
        int i2 = 0;
        for (String str : METRIC_ORDER) {
            int i3 = i2 + 1;
            MTIdCardStructuralMetric mTIdCardStructuralMetric = (MTIdCardStructuralMetric) linkedHashMap2.get(str);
            if (mTIdCardStructuralMetric == null) {
                c = c2;
                linkedHashMap = linkedHashMap2;
            } else {
                if (i2 > 0) {
                    View view = new View(contextRequireContext);
                    view.setBackgroundColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(1));
                    layoutParams.topMargin = dp(i);
                    layoutParams.bottomMargin = dp(i);
                    view.setLayoutParams(layoutParams);
                    linearLayoutBuildRoundedBlock.addView(view);
                }
                Double score = mTIdCardStructuralMetric.getScore();
                int iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt((score != null ? score.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d), 0, 100);
                int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iCoerceIn);
                Integer num = METRIC_LABELS.get(str);
                if (num == null || (string = getString(num.intValue())) == null) {
                    string = str;
                }
                Double value = mTIdCardStructuralMetric.getValue();
                if (value != null) {
                    linkedHashMap = linkedHashMap2;
                    dDoubleValue = value.doubleValue();
                } else {
                    linkedHashMap = linkedHashMap2;
                    dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                int i4 = (int) dDoubleValue;
                switch (str.hashCode()) {
                    case -1354825563:
                        string2 = str.equals("combos") ? getString(i4 == 1 ? R.string.pw_val_combo : R.string.pw_val_combos, Integer.valueOf(i4)) : String.valueOf(i4);
                        break;
                    case -862367747:
                        if (str.equals("tutors")) {
                            string2 = getString(i4 == 1 ? R.string.pw_val_tutor : R.string.pw_val_tutors, Integer.valueOf(i4));
                            break;
                        }
                        break;
                    case -630164916:
                        if (str.equals("avg_cmc")) {
                            int i5 = R.string.pw_val_avg_cmc;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            string2 = getString(i5, str2);
                            break;
                        }
                        break;
                    case -27082678:
                        if (str.equals("fast_mana")) {
                            string2 = getString(i4 == 1 ? R.string.pw_val_fast_mana : R.string.pw_val_fast_manas, Integer.valueOf(i4));
                            break;
                        }
                        break;
                    case 1844104722:
                        if (str.equals("interaction")) {
                            string2 = getString(i4 == 1 ? R.string.pw_val_interaction : R.string.pw_val_interactions, Integer.valueOf(i4));
                            break;
                        }
                        break;
                }
                Intrinsics.checkNotNull(string2);
                LinearLayout linearLayout = new LinearLayout(contextRequireContext);
                linearLayout.setOrientation(0);
                c = 16;
                linearLayout.setGravity(16);
                TextView textView = new TextView(contextRequireContext);
                textView.setText(string);
                textView.setTextSize(14.0f);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.almost_white));
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                linearLayout.addView(textView);
                TextView textView2 = new TextView(contextRequireContext);
                textView2.setText(iCoerceIn + "/100");
                textView2.setTextSize(13.0f);
                textView2.setTypeface(Typeface.DEFAULT_BOLD);
                textView2.setTextColor(iInterpolateScoreColor);
                linearLayout.addView(textView2);
                linearLayoutBuildRoundedBlock.addView(linearLayout);
                linearLayoutBuildRoundedBlock.addView(buildScoreBar(iCoerceIn / 100.0f, iInterpolateScoreColor));
                TextView textView3 = new TextView(contextRequireContext);
                textView3.setText(string2);
                textView3.setTextSize(12.0f);
                textView3.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = dp(2);
                textView3.setLayoutParams(layoutParams2);
                linearLayoutBuildRoundedBlock.addView(textView3);
            }
            i2 = i3;
            c2 = c;
            linkedHashMap2 = linkedHashMap;
            i = 10;
        }
        container.addView(linearLayoutBuildRoundedBlock);
    }

    private final LinearLayout buildRoundedBlock() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(14), dp(12), dp(14), dp(14));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dp(8);
        linearLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(contextRequireContext, R.color.manabase_insight_background));
        gradientDrawable.setCornerRadius(dp(12));
        gradientDrawable.setStroke(dp(1), 549964490);
        linearLayout.setBackground(gradientDrawable);
        return linearLayout;
    }

    private final TextView buildScoreBadge(int score, int color) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        TextView textView = new TextView(contextRequireContext);
        textView.setText(score + "/100");
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        textView.setTextColor(color);
        textView.setPadding(dp(10), dp(6), dp(10), dp(6));
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i = color & 16777215;
        gradientDrawable.setColor(855638016 | i);
        gradientDrawable.setCornerRadius(dp(8));
        gradientDrawable.setStroke(dp(1), i | 1291845632);
        textView.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(dp(10));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.studiolaganne.lengendarylens.DeckIDCardPowerDetailFragment$buildScoreBar$1] */
    private final View buildScoreBar(float fraction, int color) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ?? r1 = new View(contextRequireContext, color, RangesKt.coerceIn(fraction, 0.0f, 1.0f)) { // from class: com.studiolaganne.lengendarylens.DeckIDCardPowerDetailFragment.buildScoreBar.1
            final /* synthetic */ float $f;
            private final Paint bgPaint;
            private final Paint fgPaint;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(contextRequireContext);
                this.$f = f;
                Paint paint = new Paint(1);
                paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                this.bgPaint = paint;
                Paint paint2 = new Paint(1);
                paint2.setColor((color & 16777215) | Integer.MIN_VALUE);
                this.fgPaint = paint2;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                float f = getResources().getDisplayMetrics().density * 4.0f;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgPaint);
                float width = getWidth() * this.$f;
                if (width > 0.0f) {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgPaint);
                }
            }
        };
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(8));
        layoutParams.topMargin = dp(6);
        r1.setLayoutParams(layoutParams);
        return (View) r1;
    }

    private final int dp(int value) {
        return (int) TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
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
        return inflater.inflate(R.layout.fragment_deck_id_card_power, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MTIdCardPowerLevel powerLevel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.powerContentLayout);
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        if (mTDeckIdCardResponse == null || (powerLevel = mTDeckIdCardResponse.getPowerLevel()) == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        String string = getString(R.string.deck_dna);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        addSectionHeader(linearLayout, "\uf471", string);
        buildDNAMap(linearLayout, powerLevel);
        String string2 = getString(R.string.pw_card_quality);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        addSectionHeader(linearLayout, "\uf0a3", string2);
        buildCardQuality(linearLayout, powerLevel);
        String string3 = getString(R.string.pw_power_metrics);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        addSectionHeader(linearLayout, "\ue0b7", string3);
        buildPowerMetrics(linearLayout, powerLevel);
    }
}
