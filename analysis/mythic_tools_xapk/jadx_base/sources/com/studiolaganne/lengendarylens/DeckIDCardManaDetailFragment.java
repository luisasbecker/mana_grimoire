package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.media3.common.C;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.slider.RangeSlider;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.ManabaseRadarChartView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0007\u0018\u0000 R2\u00020\u0001:\u0004RSTUB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J*\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001e\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J.\u0010'\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J>\u0010+\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0002J\u0018\u00100\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u00102\u001a\u00020\u00072\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u00107\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J&\u00109\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0%H\u0002J\u001e\u0010;\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0%H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u000206H\u0002J*\u0010@\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020)2\b\b\u0002\u0010D\u001a\u00020)H\u0002J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u001e\u0010F\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00132\f\u0010G\u001a\b\u0012\u0004\u0012\u0002040%H\u0002J\u0018\u0010H\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010I\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010J\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010K\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010L\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010M\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010N\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010O\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010P\u001a\u00020)2\u0006\u0010?\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u0002042\u0006\u0010?\u001a\u000206H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "response", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "buildRadarChart", "Landroid/widget/LinearLayout;", "mba", "Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;", "buildSubscoreGauges", "buildInsightRows", "bindInsightItem", "itemView", "insight", "Lcom/studiolaganne/lengendarylens/MTIdCardManaInsight;", "onDetails", "Lkotlin/Function0;", "showOpeningHandDialog", "analysis", "Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;", "configureOpeningHandChart", "chart", "Lcom/github/mikephil/charting/charts/BarChart;", "probabilities", "", "Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandProb;", "updateChartHighlighting", "low", "", "high", "updateRangeDisplays", "rangeLabel", "Landroid/widget/TextView;", "rawProbabilityValue", "mulliganProbabilityValue", "showLandDropDialog", "Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;", "showTestDetailDialog", "type", "", "scoreValue", "", "createTestDetailDialog", "Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$DetailDialogParts;", "addInsightMessages", "insights", "addMetricRow", "metrics", "Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$MetricItem;", "scoreColor", "value", "addHorizontalBar", "fraction", "", "barColor", "height", "addSeparator", "addRelatedCards", "cardNames", "showLandCountDetail", "showColorBalanceDetail", "showCommanderCastDetail", "showRampDetail", "showTapLandsDetail", "showPipDensityDetail", "showColorlessLandsDetail", "showFetchTargetsDetail", "dp", "formatPct", "Companion", "LandDropEntry", "DetailDialogParts", "MetricItem", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIDCardManaDetailFragment extends Fragment {
    private static final String ARG_JSON = "response_json";
    private MTDeckIdCardResponse response;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final List<String> HEALTH_TEST_ORDER = CollectionsKt.listOf((Object[]) new String[]{"land_count", "color_balance", "commander_cast", "mana_acceleration", "tap_lands", "pip_density", "colorless_lands", "fetch_targets"});
    private static final Map<String, Integer> SCORE_LABEL_MAP = MapsKt.mapOf(TuplesKt.to("land_count", Integer.valueOf(R.string.score_label_land_count)), TuplesKt.to("color_balance", Integer.valueOf(R.string.score_label_color_balance)), TuplesKt.to("commander_cast", Integer.valueOf(R.string.score_label_commander_cast)), TuplesKt.to("mana_acceleration", Integer.valueOf(R.string.score_label_mana_acceleration)), TuplesKt.to("tap_lands", Integer.valueOf(R.string.score_label_tap_lands)), TuplesKt.to("pip_density", Integer.valueOf(R.string.score_label_pip_density)), TuplesKt.to("colorless_lands", Integer.valueOf(R.string.score_label_colorless_lands)), TuplesKt.to("fetch_targets", Integer.valueOf(R.string.score_label_fetch_targets)), TuplesKt.to("opening_hand", Integer.valueOf(R.string.score_label_opening_hand)), TuplesKt.to("land_drops", Integer.valueOf(R.string.score_label_land_drops)));
    private static final Map<String, Integer> SCORE_SUBTITLE_MAP = MapsKt.mapOf(TuplesKt.to("land_count", Integer.valueOf(R.string.test_detail_land_count_subtitle)), TuplesKt.to("color_balance", Integer.valueOf(R.string.test_detail_color_balance_subtitle)), TuplesKt.to("commander_cast", Integer.valueOf(R.string.test_detail_commander_cast_subtitle)), TuplesKt.to("mana_acceleration", Integer.valueOf(R.string.test_detail_ramp_subtitle)), TuplesKt.to("tap_lands", Integer.valueOf(R.string.test_detail_tap_lands_subtitle)), TuplesKt.to("pip_density", Integer.valueOf(R.string.test_detail_pip_density_subtitle)), TuplesKt.to("colorless_lands", Integer.valueOf(R.string.test_detail_colorless_subtitle)), TuplesKt.to("fetch_targets", Integer.valueOf(R.string.test_detail_fetch_subtitle)));

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J(\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$Companion;", "", "<init>", "()V", "ARG_JSON", "", "HEALTH_TEST_ORDER", "", "SCORE_LABEL_MAP", "", "", "SCORE_SUBTITLE_MAP", "newInstance", "Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment;", "responseJson", "logFactorial", "", "n", "logCombination", "k", "hypergeometricProbability", "N", "K", "cumulativeHypergeometric", "minK", "computeLandDropEntries", "Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$LandDropEntry;", "landCount", "deckSize", "startingLands", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final double cumulativeHypergeometric(int N, int K, int n, int minK) {
            int iMin = Math.min(K, n);
            double dHypergeometricProbability = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (minK <= iMin) {
                while (true) {
                    dHypergeometricProbability += hypergeometricProbability(N, K, n, minK);
                    if (minK == iMin) {
                        break;
                    }
                    minK++;
                }
            }
            return RangesKt.coerceIn(dHypergeometricProbability, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        }

        private final double hypergeometricProbability(int N, int K, int n, int k) {
            int i;
            int i2;
            return (k > K || k > n || (i = n - k) > (i2 = N - K)) ? AudioStats.AUDIO_AMPLITUDE_NONE : Math.exp((logCombination(K, k) + logCombination(i2, i)) - logCombination(N, n));
        }

        private final double logCombination(int n, int k) {
            if (k > n || k < 0) {
                return Double.NEGATIVE_INFINITY;
            }
            return (k == 0 || k == n) ? AudioStats.AUDIO_AMPLITUDE_NONE : (logFactorial(n) - logFactorial(k)) - logFactorial(n - k);
        }

        private final double logFactorial(int n) {
            double dLog = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (n <= 1) {
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            if (n >= 20) {
                double d = n;
                return ((Math.log(d) * d) - d) + (Math.log(d * 6.283185307179586d) * 0.5d);
            }
            Iterator<Integer> it = new IntRange(2, n).iterator();
            while (it.hasNext()) {
                dLog += Math.log(((IntIterator) it).nextInt());
            }
            return dLog;
        }

        public final List<LandDropEntry> computeLandDropEntries(int landCount, int deckSize, int startingLands) {
            int i = deckSize - 7;
            int i2 = landCount - startingLands;
            IntRange intRange = new IntRange(1, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                int i3 = iNextInt - 1;
                int i4 = iNextInt - startingLands;
                arrayList.add(new LandDropEntry(iNextInt, i3, i4 <= 0 ? 1.0d : DeckIDCardManaDetailFragment.INSTANCE.cumulativeHypergeometric(i, i2, i3, i4)));
            }
            return arrayList;
        }

        public final DeckIDCardManaDetailFragment newInstance(String responseJson) {
            Intrinsics.checkNotNullParameter(responseJson, "responseJson");
            DeckIDCardManaDetailFragment deckIDCardManaDetailFragment = new DeckIDCardManaDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DeckIDCardManaDetailFragment.ARG_JSON, responseJson);
            deckIDCardManaDetailFragment.setArguments(bundle);
            return deckIDCardManaDetailFragment;
        }
    }

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$DetailDialogParts;", "", "dialog", "Landroid/app/Dialog;", "contentContainer", "Landroid/widget/LinearLayout;", "metricsContainer", "<init>", "(Landroid/app/Dialog;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;)V", "getDialog", "()Landroid/app/Dialog;", "getContentContainer", "()Landroid/widget/LinearLayout;", "getMetricsContainer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class DetailDialogParts {
        private final LinearLayout contentContainer;
        private final Dialog dialog;
        private final LinearLayout metricsContainer;

        public DetailDialogParts(Dialog dialog, LinearLayout contentContainer, LinearLayout metricsContainer) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(contentContainer, "contentContainer");
            Intrinsics.checkNotNullParameter(metricsContainer, "metricsContainer");
            this.dialog = dialog;
            this.contentContainer = contentContainer;
            this.metricsContainer = metricsContainer;
        }

        public static /* synthetic */ DetailDialogParts copy$default(DetailDialogParts detailDialogParts, Dialog dialog, LinearLayout linearLayout, LinearLayout linearLayout2, int i, Object obj) {
            if ((i & 1) != 0) {
                dialog = detailDialogParts.dialog;
            }
            if ((i & 2) != 0) {
                linearLayout = detailDialogParts.contentContainer;
            }
            if ((i & 4) != 0) {
                linearLayout2 = detailDialogParts.metricsContainer;
            }
            return detailDialogParts.copy(dialog, linearLayout, linearLayout2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Dialog getDialog() {
            return this.dialog;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LinearLayout getContentContainer() {
            return this.contentContainer;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LinearLayout getMetricsContainer() {
            return this.metricsContainer;
        }

        public final DetailDialogParts copy(Dialog dialog, LinearLayout contentContainer, LinearLayout metricsContainer) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(contentContainer, "contentContainer");
            Intrinsics.checkNotNullParameter(metricsContainer, "metricsContainer");
            return new DetailDialogParts(dialog, contentContainer, metricsContainer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailDialogParts)) {
                return false;
            }
            DetailDialogParts detailDialogParts = (DetailDialogParts) other;
            return Intrinsics.areEqual(this.dialog, detailDialogParts.dialog) && Intrinsics.areEqual(this.contentContainer, detailDialogParts.contentContainer) && Intrinsics.areEqual(this.metricsContainer, detailDialogParts.metricsContainer);
        }

        public final LinearLayout getContentContainer() {
            return this.contentContainer;
        }

        public final Dialog getDialog() {
            return this.dialog;
        }

        public final LinearLayout getMetricsContainer() {
            return this.metricsContainer;
        }

        public int hashCode() {
            return (((this.dialog.hashCode() * 31) + this.contentContainer.hashCode()) * 31) + this.metricsContainer.hashCode();
        }

        public String toString() {
            return "DetailDialogParts(dialog=" + this.dialog + ", contentContainer=" + this.contentContainer + ", metricsContainer=" + this.metricsContainer + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$LandDropEntry;", "", "turn", "", "cardsDrawn", "probability", "", "<init>", "(IID)V", "getTurn", "()I", "getCardsDrawn", "getProbability", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LandDropEntry {
        public static final int $stable = 0;
        private final int cardsDrawn;
        private final double probability;
        private final int turn;

        public LandDropEntry(int i, int i2, double d) {
            this.turn = i;
            this.cardsDrawn = i2;
            this.probability = d;
        }

        public static /* synthetic */ LandDropEntry copy$default(LandDropEntry landDropEntry, int i, int i2, double d, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = landDropEntry.turn;
            }
            if ((i3 & 2) != 0) {
                i2 = landDropEntry.cardsDrawn;
            }
            if ((i3 & 4) != 0) {
                d = landDropEntry.probability;
            }
            return landDropEntry.copy(i, i2, d);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTurn() {
            return this.turn;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCardsDrawn() {
            return this.cardsDrawn;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getProbability() {
            return this.probability;
        }

        public final LandDropEntry copy(int turn, int cardsDrawn, double probability) {
            return new LandDropEntry(turn, cardsDrawn, probability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LandDropEntry)) {
                return false;
            }
            LandDropEntry landDropEntry = (LandDropEntry) other;
            return this.turn == landDropEntry.turn && this.cardsDrawn == landDropEntry.cardsDrawn && Double.compare(this.probability, landDropEntry.probability) == 0;
        }

        public final int getCardsDrawn() {
            return this.cardsDrawn;
        }

        public final double getProbability() {
            return this.probability;
        }

        public final int getTurn() {
            return this.turn;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.turn) * 31) + Integer.hashCode(this.cardsDrawn)) * 31) + Double.hashCode(this.probability);
        }

        public String toString() {
            return "LandDropEntry(turn=" + this.turn + ", cardsDrawn=" + this.cardsDrawn + ", probability=" + this.probability + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$MetricItem;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "value", "valueColor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getValue", "getValueColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$MetricItem;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class MetricItem {
        private final String label;
        private final String value;
        private final Integer valueColor;

        public MetricItem(String label, String value, Integer num) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(value, "value");
            this.label = label;
            this.value = value;
            this.valueColor = num;
        }

        public /* synthetic */ MetricItem(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : num);
        }

        public static /* synthetic */ MetricItem copy$default(MetricItem metricItem, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metricItem.label;
            }
            if ((i & 2) != 0) {
                str2 = metricItem.value;
            }
            if ((i & 4) != 0) {
                num = metricItem.valueColor;
            }
            return metricItem.copy(str, str2, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getValueColor() {
            return this.valueColor;
        }

        public final MetricItem copy(String label, String value, Integer valueColor) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(value, "value");
            return new MetricItem(label, value, valueColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MetricItem)) {
                return false;
            }
            MetricItem metricItem = (MetricItem) other;
            return Intrinsics.areEqual(this.label, metricItem.label) && Intrinsics.areEqual(this.value, metricItem.value) && Intrinsics.areEqual(this.valueColor, metricItem.valueColor);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getValue() {
            return this.value;
        }

        public final Integer getValueColor() {
            return this.valueColor;
        }

        public int hashCode() {
            int iHashCode = ((this.label.hashCode() * 31) + this.value.hashCode()) * 31;
            Integer num = this.valueColor;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "MetricItem(label=" + this.label + ", value=" + this.value + ", valueColor=" + this.valueColor + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J,\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"com/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$showRampDetail$CostTier", "", Constants.ScionAnalytics.PARAM_LABEL, "", "count", "", "weight", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getCount", "()I", "getWeight", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/String;)Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$showRampDetail$CostTier;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CostTier {
        private final int count;
        private final String label;
        private final String weight;

        public CostTier(String label, int i, String weight) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(weight, "weight");
            this.label = label;
            this.count = i;
            this.weight = weight;
        }

        public static /* synthetic */ CostTier copy$default(CostTier costTier, String str, int i, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = costTier.label;
            }
            if ((i2 & 2) != 0) {
                i = costTier.count;
            }
            if ((i2 & 4) != 0) {
                str2 = costTier.weight;
            }
            return costTier.copy(str, i, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getWeight() {
            return this.weight;
        }

        public final CostTier copy(String label, int count, String weight) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(weight, "weight");
            return new CostTier(label, count, weight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CostTier)) {
                return false;
            }
            CostTier costTier = (CostTier) other;
            return Intrinsics.areEqual(this.label, costTier.label) && this.count == costTier.count && Intrinsics.areEqual(this.weight, costTier.weight);
        }

        public final int getCount() {
            return this.count;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getWeight() {
            return this.weight;
        }

        public int hashCode() {
            return (((this.label.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + this.weight.hashCode();
        }

        public String toString() {
            return "CostTier(label=" + this.label + ", count=" + this.count + ", weight=" + this.weight + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIDCardManaDetailFragment.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J,\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"com/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$showRampDetail$RampCategory", "", Constants.ScionAnalytics.PARAM_LABEL, "", "count", "", "color", "<init>", "(Ljava/lang/String;II)V", "getLabel", "()Ljava/lang/String;", "getCount", "()I", "getColor", "component1", "component2", "component3", "copy", "(Ljava/lang/String;II)Lcom/studiolaganne/lengendarylens/DeckIDCardManaDetailFragment$showRampDetail$RampCategory;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RampCategory {
        private final int color;
        private final int count;
        private final String label;

        public RampCategory(String label, int i, int i2) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.count = i;
            this.color = i2;
        }

        public static /* synthetic */ RampCategory copy$default(RampCategory rampCategory, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = rampCategory.label;
            }
            if ((i3 & 2) != 0) {
                i = rampCategory.count;
            }
            if ((i3 & 4) != 0) {
                i2 = rampCategory.color;
            }
            return rampCategory.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final RampCategory copy(String label, int count, int color) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new RampCategory(label, count, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RampCategory)) {
                return false;
            }
            RampCategory rampCategory = (RampCategory) other;
            return Intrinsics.areEqual(this.label, rampCategory.label) && this.count == rampCategory.count && this.color == rampCategory.color;
        }

        public final int getColor() {
            return this.color;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getLabel() {
            return this.label;
        }

        public int hashCode() {
            return (((this.label.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "RampCategory(label=" + this.label + ", count=" + this.count + ", color=" + this.color + ")";
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$addHorizontalBar$bar$1] */
    private final void addHorizontalBar(LinearLayout container, final float fraction, final int barColor, int height) {
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ?? r1 = new View(contextRequireContext, barColor, fraction) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$addHorizontalBar$bar$1
            final /* synthetic */ float $fraction;
            private final Paint bgPaint;
            private final Paint fgPaint;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(contextRequireContext);
                this.$fraction = fraction;
                Paint paint = new Paint(1);
                paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                this.bgPaint = paint;
                Paint paint2 = new Paint(1);
                paint2.setColor(barColor);
                this.fgPaint = paint2;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                float f = getResources().getDisplayMetrics().density * 4.0f;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgPaint);
                float width = getWidth() * RangesKt.coerceIn(this.$fraction, 0.0f, 1.0f);
                if (width > 0.0f) {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgPaint);
                }
            }
        };
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
        layoutParams.bottomMargin = dp(4);
        r1.setLayoutParams(layoutParams);
        container.addView((View) r1);
    }

    static /* synthetic */ void addHorizontalBar$default(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, LinearLayout linearLayout, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = deckIDCardManaDetailFragment.dp(10);
        }
        deckIDCardManaDetailFragment.addHorizontalBar(linearLayout, f, i, i2);
    }

    private final void addInsightMessages(LinearLayout container, String type, List<MTIdCardManaInsight> insights) {
        String message;
        String actionable;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : insights) {
            if (Intrinsics.areEqual(((MTIdCardManaInsight) obj).getType(), type)) {
                arrayList.add(obj);
            }
        }
        ArrayList<MTIdCardManaInsight> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "fr");
        SymbolToImage symbolToImage = new SymbolToImage(contextRequireContext);
        int dimensionPixelSize = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
        for (MTIdCardManaInsight mTIdCardManaInsight : arrayList2) {
            if (!zAreEqual || (message = mTIdCardManaInsight.getMessageFr()) == null) {
                message = mTIdCardManaInsight.getMessage();
            }
            String str = message;
            if (str != null && !StringsKt.isBlank(str)) {
                TextView textView = new TextView(contextRequireContext);
                textView.setText(symbolToImage.stringToAttributedStringWithSymbols(message, dimensionPixelSize, new CharacterStyle[0]));
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView.setTextSize(13.0f);
                textView.setTypeface(Typeface.create(C.SANS_SERIF_NAME, 0));
                textView.setPadding(dp(8), dp(6), dp(8), dp(6));
                textView.setBackground(ContextCompat.getDrawable(contextRequireContext, R.drawable.manabase_gauge_background));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = dp(6);
                textView.setLayoutParams(layoutParams);
                container.addView(textView);
                if (!zAreEqual || (actionable = mTIdCardManaInsight.getActionableFr()) == null) {
                    actionable = mTIdCardManaInsight.getActionable();
                }
                String str2 = actionable;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    TextView textView2 = new TextView(contextRequireContext);
                    textView2.setText(symbolToImage.stringToAttributedStringWithSymbols("💡 " + actionable, dimensionPixelSize, new CharacterStyle[0]));
                    textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.warning_amber));
                    textView2.setTextSize(12.0f);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.bottomMargin = dp(8);
                    textView2.setLayoutParams(layoutParams2);
                    container.addView(textView2);
                }
            }
        }
    }

    private final void addMetricRow(LinearLayout container, List<MetricItem> metrics) {
        View viewFindViewById;
        if (metrics.isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        container.setVisibility(0);
        ViewParent parent = container.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null && (viewFindViewById = viewGroup.findViewById(R.id.metricsSeparator)) != null) {
            viewFindViewById.setVisibility(0);
        }
        container.removeAllViews();
        for (MetricItem metricItem : metrics) {
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackground(ContextCompat.getDrawable(contextRequireContext, R.drawable.manabase_gauge_background));
            linearLayout.setPadding(dp(6), dp(8), dp(6), dp(8));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMarginStart(dp(3));
            layoutParams.setMarginEnd(dp(3));
            linearLayout.setLayoutParams(layoutParams);
            TextView textView = new TextView(contextRequireContext);
            textView.setText(metricItem.getLabel());
            textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
            textView.setTextSize(10.0f);
            textView.setGravity(17);
            textView.setMaxLines(1);
            linearLayout.addView(textView);
            TextView textView2 = new TextView(contextRequireContext);
            textView2.setText(metricItem.getValue());
            Integer valueColor = metricItem.getValueColor();
            textView2.setTextColor(valueColor != null ? valueColor.intValue() : ContextCompat.getColor(contextRequireContext, R.color.text_color));
            textView2.setTextSize(16.0f);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setGravity(17);
            linearLayout.addView(textView2);
            container.addView(linearLayout);
        }
    }

    private final void addRelatedCards(LinearLayout container, List<String> cardNames) {
        if (cardNames.isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addSeparator(container);
        TextView textView = new TextView(contextRequireContext);
        textView.setText(getString(R.string.detail_related_cards));
        textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
        textView.setTextSize(10.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLetterSpacing(0.1f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dp(4);
        textView.setLayoutParams(layoutParams);
        container.addView(textView);
        for (String str : cardNames) {
            TextView textView2 = new TextView(contextRequireContext);
            textView2.setText(str);
            textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
            textView2.setTextSize(13.0f);
            container.addView(textView2);
        }
    }

    private final void addSeparator(LinearLayout container) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        View view = new View(contextRequireContext);
        view.setBackgroundColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(1));
        layoutParams.topMargin = dp(6);
        layoutParams.bottomMargin = dp(8);
        view.setLayoutParams(layoutParams);
        container.addView(view);
    }

    private final void bindInsightItem(View itemView, MTIdCardManaInsight insight, final Function0<Unit> onDetails) {
        String message;
        String actionable;
        TextView textView = (TextView) itemView.findViewById(R.id.insightStatusIcon);
        TextView textView2 = (TextView) itemView.findViewById(R.id.insightTitle);
        TextView textView3 = (TextView) itemView.findViewById(R.id.insightMessage);
        TextView textView4 = (TextView) itemView.findViewById(R.id.insightActionable);
        TextView textView5 = (TextView) itemView.findViewById(R.id.insightDetailsButton);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String severity = insight.getSeverity();
        if (Intrinsics.areEqual(severity, "positive")) {
            textView.setText("\uf00c");
            textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.positive_green));
        } else if (Intrinsics.areEqual(severity, "warning")) {
            textView.setText("\uf071");
            textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.warning_amber));
        } else {
            textView.setText("\uf05a");
            textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.info_blue));
        }
        Integer num = SCORE_LABEL_MAP.get(insight.getType());
        String string = num != null ? getString(num.intValue()) : null;
        textView2.setText((string == null && (string = insight.getId()) == null) ? "" : string);
        boolean zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "fr");
        if (!zAreEqual || (message = insight.getMessageFr()) == null) {
            message = insight.getMessage();
        }
        textView3.setText(new SymbolToImage(contextRequireContext).stringToAttributedStringWithSymbols(message != null ? message : "", contextRequireContext.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller), new CharacterStyle[0]));
        if (!zAreEqual || (actionable = insight.getActionableFr()) == null) {
            actionable = insight.getActionable();
        }
        if (actionable != null) {
            textView4.setText(actionable);
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        if (onDetails != null) {
            textView5.setVisibility(0);
            Intrinsics.checkNotNull(textView5);
            ViewExtensionsKt.setOnClickWithFade(textView5, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.bindInsightItem$lambda$1(onDetails);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.bindInsightItem$lambda$2(onDetails);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void bindInsightItem$default(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, View view, MTIdCardManaInsight mTIdCardManaInsight, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        deckIDCardManaDetailFragment.bindInsightItem(view, mTIdCardManaInsight, function0);
    }

    static final Unit bindInsightItem$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit bindInsightItem$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void buildInsightRows(LinearLayout container, final MTIdCardManaBaseAnalysis mba) {
        Object obj;
        Object next;
        List<MTIdCardManaInsight> insights = mba.getInsights();
        Iterator<T> it = insights.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTIdCardManaInsight) next).getType(), "opening_hand")) {
                    break;
                }
            }
        }
        MTIdCardManaInsight mTIdCardManaInsight = (MTIdCardManaInsight) next;
        Iterator<T> it2 = insights.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((MTIdCardManaInsight) next2).getType(), "land_drops")) {
                obj = next2;
                break;
            }
        }
        MTIdCardManaInsight mTIdCardManaInsight2 = (MTIdCardManaInsight) obj;
        final MTIdCardOpeningHandAnalysis openingHandAnalysis = mba.getOpeningHandAnalysis();
        if (mTIdCardManaInsight != null && openingHandAnalysis != null) {
            Function0<Unit> function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.buildInsightRows$lambda$2(this.f$0, openingHandAnalysis);
                }
            };
            View viewInflate = getLayoutInflater().inflate(R.layout.manabase_insight_item, (ViewGroup) container, false);
            Intrinsics.checkNotNull(viewInflate);
            bindInsightItem(viewInflate, mTIdCardManaInsight, function0);
            container.addView(viewInflate);
        } else if (openingHandAnalysis != null) {
            MTIdCardManaInsight mTIdCardManaInsight3 = new MTIdCardManaInsight("opening_hand_fallback", "opening_hand", "positive", getString(R.string.opening_hand_fallback_message), null, null, null, null, null, CollectionsKt.emptyList(), 384, null);
            Function0<Unit> function02 = new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.buildInsightRows$lambda$3(this.f$0, openingHandAnalysis);
                }
            };
            View viewInflate2 = getLayoutInflater().inflate(R.layout.manabase_insight_item, (ViewGroup) container, false);
            Intrinsics.checkNotNull(viewInflate2);
            bindInsightItem(viewInflate2, mTIdCardManaInsight3, function02);
            container.addView(viewInflate2);
        }
        final MTIdCardLandDropAnalysis landDropAnalysis = mba.getLandDropAnalysis();
        if (mTIdCardManaInsight2 != null && landDropAnalysis != null) {
            Function0<Unit> function03 = new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.buildInsightRows$lambda$4(this.f$0, landDropAnalysis, mba);
                }
            };
            View viewInflate3 = getLayoutInflater().inflate(R.layout.manabase_insight_item, (ViewGroup) container, false);
            Intrinsics.checkNotNull(viewInflate3);
            bindInsightItem(viewInflate3, mTIdCardManaInsight2, function03);
            container.addView(viewInflate3);
            return;
        }
        if (landDropAnalysis != null) {
            MTIdCardManaInsight mTIdCardManaInsight4 = new MTIdCardManaInsight("land_drops_fallback", "land_drops", "positive", getString(R.string.land_drops_fallback_message), null, null, null, null, null, CollectionsKt.emptyList(), 384, null);
            Function0<Unit> function04 = new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckIDCardManaDetailFragment.buildInsightRows$lambda$5(this.f$0, landDropAnalysis, mba);
                }
            };
            View viewInflate4 = getLayoutInflater().inflate(R.layout.manabase_insight_item, (ViewGroup) container, false);
            Intrinsics.checkNotNull(viewInflate4);
            bindInsightItem(viewInflate4, mTIdCardManaInsight4, function04);
            container.addView(viewInflate4);
        }
    }

    static final Unit buildInsightRows$lambda$2(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis) {
        deckIDCardManaDetailFragment.showOpeningHandDialog(mTIdCardOpeningHandAnalysis);
        return Unit.INSTANCE;
    }

    static final Unit buildInsightRows$lambda$3(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis) {
        deckIDCardManaDetailFragment.showOpeningHandDialog(mTIdCardOpeningHandAnalysis);
        return Unit.INSTANCE;
    }

    static final Unit buildInsightRows$lambda$4(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis) {
        deckIDCardManaDetailFragment.showLandDropDialog(mTIdCardLandDropAnalysis, mTIdCardManaBaseAnalysis);
        return Unit.INSTANCE;
    }

    static final Unit buildInsightRows$lambda$5(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis) {
        deckIDCardManaDetailFragment.showLandDropDialog(mTIdCardLandDropAnalysis, mTIdCardManaBaseAnalysis);
        return Unit.INSTANCE;
    }

    private final void buildRadarChart(LinearLayout container, final MTIdCardManaBaseAnalysis mba) {
        List<MTIdCardManaSubscore> subscores;
        String type;
        MTIdCardManaHealthScore healthScore = mba.getHealthScore();
        if (healthScore == null || (subscores = healthScore.getSubscores()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : subscores) {
            if (CollectionsKt.contains(HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) obj).getType())) {
                arrayList.add(obj);
            }
        }
        final List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$buildRadarChart$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(CollectionsKt.indexOf((List<? extends String>) DeckIDCardManaDetailFragment.HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) t).getType())), Integer.valueOf(CollectionsKt.indexOf((List<? extends String>) DeckIDCardManaDetailFragment.HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) t2).getType())));
            }
        });
        if (listSortedWith.size() < 3) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Integer score = mba.getScore();
        int iIntValue = score != null ? score.intValue() : 0;
        int iInterpolateScoreColor = ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iIntValue);
        List<MTIdCardManaSubscore> list = listSortedWith;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MTIdCardManaSubscore mTIdCardManaSubscore : list) {
            Double value = mTIdCardManaSubscore.getValue();
            int iCoerceIn = RangesKt.coerceIn(RangesKt.coerceAtLeast(MathKt.roundToInt((value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d), 10), 0, 100);
            Integer num = SCORE_LABEL_MAP.get(mTIdCardManaSubscore.getType());
            if ((num == null || (type = getString(num.intValue())) == null) && (type = mTIdCardManaSubscore.getType()) == null) {
                type = "";
            }
            arrayList2.add(new ManabaseRadarChartView.DataPoint(type, iCoerceIn, ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iCoerceIn)));
        }
        ManabaseRadarChartView manabaseRadarChartView = new ManabaseRadarChartView(contextRequireContext, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dp(0);
        manabaseRadarChartView.setLayoutParams(layoutParams);
        String string = getString(R.string.manabase_health_score_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        manabaseRadarChartView.setData(arrayList2, iIntValue, iInterpolateScoreColor, string);
        manabaseRadarChartView.setOnDataPointSelected(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeckIDCardManaDetailFragment.buildRadarChart$lambda$3$1(listSortedWith, this, mba, ((Integer) obj2).intValue());
            }
        });
        container.addView(manabaseRadarChartView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildRadarChart$lambda$3$1(List list, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis, int i) {
        MTIdCardManaSubscore mTIdCardManaSubscore = (MTIdCardManaSubscore) list.get(i);
        String type = mTIdCardManaSubscore.getType();
        if (type == null) {
            type = "land_count";
        }
        Double value = mTIdCardManaSubscore.getValue();
        deckIDCardManaDetailFragment.showTestDetailDialog(type, value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE, mTIdCardManaBaseAnalysis);
        return Unit.INSTANCE;
    }

    private final void buildSubscoreGauges(LinearLayout container, final MTIdCardManaBaseAnalysis mba) {
        List<MTIdCardManaSubscore> subscores;
        String type;
        MTIdCardManaHealthScore healthScore = mba.getHealthScore();
        if (healthScore == null || (subscores = healthScore.getSubscores()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : subscores) {
            if (CollectionsKt.contains(HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) obj).getType())) {
                arrayList.add(obj);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$buildSubscoreGauges$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(CollectionsKt.indexOf((List<? extends String>) DeckIDCardManaDetailFragment.HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) t).getType())), Integer.valueOf(CollectionsKt.indexOf((List<? extends String>) DeckIDCardManaDetailFragment.HEALTH_TEST_ORDER, ((MTIdCardManaSubscore) t2).getType())));
            }
        });
        if (listSortedWith.isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        for (List<MTIdCardManaSubscore> list : CollectionsKt.chunked(listSortedWith, 4)) {
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = dp(8);
            linearLayout.setLayoutParams(layoutParams);
            for (final MTIdCardManaSubscore mTIdCardManaSubscore : list) {
                Double value = mTIdCardManaSubscore.getValue();
                float fDoubleValue = (float) (value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
                Integer num = SCORE_LABEL_MAP.get(mTIdCardManaSubscore.getType());
                if ((num == null || (type = getString(num.intValue())) == null) && (type = mTIdCardManaSubscore.getType()) == null) {
                    type = "";
                }
                ManabaseScoreGaugeView manabaseScoreGaugeView = new ManabaseScoreGaugeView(contextRequireContext, null, 0, 6, null);
                manabaseScoreGaugeView.configure(fDoubleValue, type);
                manabaseScoreGaugeView.setBackground(ContextCompat.getDrawable(contextRequireContext, R.drawable.manabase_gauge_background));
                manabaseScoreGaugeView.setPadding(dp(4), dp(6), dp(4), dp(6));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                layoutParams2.setMarginStart(dp(4));
                layoutParams2.setMarginEnd(dp(4));
                manabaseScoreGaugeView.setLayoutParams(layoutParams2);
                ManabaseScoreGaugeView manabaseScoreGaugeView2 = manabaseScoreGaugeView;
                ViewExtensionsKt.setOnClickWithFade(manabaseScoreGaugeView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckIDCardManaDetailFragment.buildSubscoreGauges$lambda$4$1(this.f$0, mTIdCardManaSubscore, mba);
                    }
                });
                linearLayout.addView(manabaseScoreGaugeView2);
            }
            int size = 4 - list.size();
            for (int i = 0; i < size; i++) {
                View view = new View(contextRequireContext);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0, 1.0f);
                layoutParams3.setMarginStart(dp(4));
                layoutParams3.setMarginEnd(dp(4));
                view.setLayoutParams(layoutParams3);
                linearLayout.addView(view);
            }
            container.addView(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSubscoreGauges$lambda$4$1(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardManaSubscore mTIdCardManaSubscore, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis) {
        String type = mTIdCardManaSubscore.getType();
        if (type == null) {
            return Unit.INSTANCE;
        }
        Double value = mTIdCardManaSubscore.getValue();
        deckIDCardManaDetailFragment.showTestDetailDialog(type, value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE, mTIdCardManaBaseAnalysis);
        return Unit.INSTANCE;
    }

    private final void configureOpeningHandChart(BarChart chart, List<MTIdCardOpeningHandProb> probabilities) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setTouchEnabled(false);
        chart.setDragEnabled(false);
        chart.setScaleEnabled(false);
        chart.setPinchZoom(false);
        chart.getLegend().setEnabled(false);
        chart.setExtraOffsets(8.0f, 8.0f, 8.0f, 8.0f);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1.0f);
        xAxis.setLabelCount(8);
        xAxis.setValueFormatter(new ValueFormatter() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment.configureOpeningHandChart.1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        xAxis.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        xAxis.setTextSize(12.0f);
        xAxis.setAxisLineColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        xAxis.setAxisLineWidth(1.0f);
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setAxisMaximum(7.5f);
        YAxis axisLeft = chart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setGridColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
        axisLeft.setGridLineWidth(0.5f);
        axisLeft.setDrawAxisLine(true);
        axisLeft.setAxisLineColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        axisLeft.setAxisLineWidth(1.0f);
        axisLeft.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        axisLeft.setTextSize(10.0f);
        axisLeft.setAxisMinimum(0.0f);
        axisLeft.setValueFormatter(new ValueFormatter() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment.configureOpeningHandChart.2
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return ((int) value) + "%";
            }
        });
        chart.getAxisRight().setEnabled(false);
        List<MTIdCardOpeningHandProb> list = probabilities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MTIdCardOpeningHandProb mTIdCardOpeningHandProb : list) {
            Integer landCount = mTIdCardOpeningHandProb.getLandCount();
            float fIntValue = landCount != null ? landCount.intValue() : 0;
            Double probability = mTIdCardOpeningHandProb.getProbability();
            arrayList.add(new BarEntry(fIntValue, (float) ((probability != null ? probability.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d)));
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "");
        barDataSet.setDrawValues(true);
        barDataSet.setValueTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        barDataSet.setValueTextSize(9.0f);
        barDataSet.setValueFormatter(new ValueFormatter() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$configureOpeningHandChart$barDataSet$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                if (value < 1.0f) {
                    return "";
                }
                return ((int) value) + "%";
            }
        });
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.7f);
        chart.setData(barData);
        chart.invalidate();
    }

    private final DetailDialogParts createTestDetailDialog(String type, double scoreValue) {
        String string;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final Dialog dialog = new Dialog(contextRequireContext, android.R.style.Theme.Translucent.NoTitleBar);
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        frameLayout.setBackgroundColor(-1728053248);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        final View viewInflate = getLayoutInflater().inflate(R.layout.popup_manabase_test_detail, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckIDCardManaDetailFragment.createTestDetailDialog$lambda$1(view);
            }
        });
        final int i = (int) (getResources().getDisplayMetrics().heightPixels * 0.8f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (getResources().getDisplayMetrics().widthPixels * 0.9f), -2);
        layoutParams.gravity = 17;
        layoutParams.height = -2;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(viewInflate, layoutParams);
        viewInflate.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DeckIDCardManaDetailFragment.createTestDetailDialog$lambda$3(viewInflate, i);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R.id.popupTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.popupSubtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.popupScoreBadge);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.popupCloseButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.contentContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.metricsContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById6;
        Integer num = SCORE_LABEL_MAP.get(type);
        textView.setText((num == null || (string = getString(num.intValue())) == null) ? type : string);
        Integer num2 = SCORE_SUBTITLE_MAP.get(type);
        if (num2 != null) {
            textView2.setText(getString(num2.intValue()));
            textView2.setVisibility(0);
        }
        int iRoundToInt = MathKt.roundToInt(scoreValue * 100.0d);
        textView3.setText(String.valueOf(iRoundToInt));
        textView3.setTextColor(ManabaseRadarChartView.INSTANCE.interpolateScoreColor(iRoundToInt));
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardManaDetailFragment.createTestDetailDialog$lambda$6(dialog);
            }
        });
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        return new DetailDialogParts(dialog, linearLayout, linearLayout2);
    }

    static final void createTestDetailDialog$lambda$1(View view) {
    }

    static final void createTestDetailDialog$lambda$3(View view, int i) {
        if (view.getHeight() > i) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            view.setLayoutParams(layoutParams2);
        }
    }

    static final Unit createTestDetailDialog$lambda$6(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatPct(double value) {
        int iRoundToInt = MathKt.roundToInt(value);
        if (iRoundToInt != 0 || value <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return iRoundToInt + "%";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(value)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final int scoreColor(double value) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return value >= 0.75d ? ContextCompat.getColor(contextRequireContext, R.color.positive_green) : value >= 0.5d ? ContextCompat.getColor(contextRequireContext, R.color.warning_amber) : ContextCompat.getColor(contextRequireContext, R.color.error_red);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x02f5  */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorBalanceDetail$costBar$1] */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorBalanceDetail$prodBar$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showColorBalanceDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        Object obj;
        String str;
        LinearLayout linearLayout;
        double d;
        int i;
        double d2;
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("color_balance", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "color_balance", mba.getInsights());
        List<MTIdCardColorAnalysisRow> colorAnalysis = mba.getColorAnalysis();
        int i2 = 1;
        int i3 = 0;
        if (!colorAnalysis.isEmpty()) {
            SymbolToImage symbolToImage = new SymbolToImage(contextRequireContext);
            int dimensionPixelSize = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
            for (MTIdCardColorAnalysisRow mTIdCardColorAnalysisRow : colorAnalysis) {
                LinearLayout linearLayout2 = new LinearLayout(contextRequireContext);
                linearLayout2.setOrientation(i3);
                linearLayout2.setGravity(16);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = dp(6);
                linearLayout2.setLayoutParams(layoutParams);
                String colorSymbol = mTIdCardColorAnalysisRow.getColorSymbol();
                if (colorSymbol == null && (colorSymbol = mTIdCardColorAnalysisRow.getColor()) == null) {
                    colorSymbol = "";
                }
                if (colorSymbol.length() == i2) {
                    colorSymbol = "{" + colorSymbol + "}";
                }
                TextView textView = new TextView(contextRequireContext);
                textView.setText(symbolToImage.stringToAttributedStringWithSymbols(colorSymbol, dimensionPixelSize, new CharacterStyle[0]));
                textView.setLayoutParams(new LinearLayout.LayoutParams(dp(24), -2));
                linearLayout2.addView(textView);
                LinearLayout linearLayout3 = new LinearLayout(contextRequireContext);
                linearLayout3.setOrientation(1);
                List<MTIdCardColorAnalysisRow> list = colorAnalysis;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                layoutParams2.setMarginStart(dp(8));
                linearLayout3.setLayoutParams(layoutParams2);
                Double costProportion = mTIdCardColorAnalysisRow.getCostProportion();
                if (costProportion != null) {
                    double dDoubleValue = costProportion.doubleValue();
                    linearLayout = linearLayout2;
                    d = dDoubleValue;
                } else {
                    linearLayout = linearLayout2;
                    d = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                final float f = (float) d;
                Double productionProportion = mTIdCardColorAnalysisRow.getProductionProportion();
                if (productionProportion != null) {
                    double dDoubleValue2 = productionProportion.doubleValue();
                    i = dimensionPixelSize;
                    d2 = dDoubleValue2;
                } else {
                    i = dimensionPixelSize;
                    d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                final float f2 = (float) d2;
                String status = mTIdCardColorAnalysisRow.getStatus();
                final int color = Intrinsics.areEqual(status, "critical") ? ContextCompat.getColor(contextRequireContext, R.color.error_red) : Intrinsics.areEqual(status, "low") ? ContextCompat.getColor(contextRequireContext, R.color.warning_amber) : ContextCompat.getColor(contextRequireContext, R.color.positive_green);
                LinearLayout linearLayout4 = new LinearLayout(contextRequireContext);
                linearLayout4.setOrientation(0);
                linearLayout4.setGravity(16);
                ?? r3 = new View(contextRequireContext, color, f) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorBalanceDetail$costBar$1
                    final /* synthetic */ float $costProp;
                    private final Paint bgP;
                    private final Paint fgP;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext);
                        this.$costProp = f;
                        Paint paint = new Paint(1);
                        paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                        this.bgP = paint;
                        Paint paint2 = new Paint(1);
                        paint2.setColor(color);
                        this.fgP = paint2;
                    }

                    public final Paint getBgP() {
                        return this.bgP;
                    }

                    public final Paint getFgP() {
                        return this.fgP;
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        float f3 = getResources().getDisplayMetrics().density * 3.0f;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f3, f3, this.bgP);
                        float width = getWidth() * RangesKt.coerceIn(this.$costProp, 0.0f, 1.0f);
                        if (width > 0.0f) {
                            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f3, f3, this.fgP);
                        }
                    }
                };
                DetailDialogParts detailDialogParts = detailDialogPartsCreateTestDetailDialog;
                LinearLayout linearLayout5 = linearLayout;
                r3.setLayoutParams(new LinearLayout.LayoutParams(0, dp(8), 1.0f));
                linearLayout4.addView((View) r3);
                TextView textView2 = new TextView(contextRequireContext);
                textView2.setText(MathKt.roundToInt(f * 100.0f) + "%");
                textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView2.setTextSize(10.0f);
                textView2.setGravity(GravityCompat.END);
                textView2.setMinWidth(dp(36));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart(dp(6));
                textView2.setLayoutParams(layoutParams3);
                linearLayout4.addView(textView2);
                linearLayout3.addView(linearLayout4);
                LinearLayout linearLayout6 = new LinearLayout(contextRequireContext);
                linearLayout6.setOrientation(0);
                linearLayout6.setGravity(16);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.topMargin = dp(3);
                linearLayout6.setLayoutParams(layoutParams4);
                ?? r32 = new View(contextRequireContext, color, f2) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorBalanceDetail$prodBar$1
                    final /* synthetic */ float $prodProp;
                    private final Paint bgP;
                    private final Paint fgP;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext);
                        this.$prodProp = f2;
                        Paint paint = new Paint(1);
                        paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                        this.bgP = paint;
                        Paint paint2 = new Paint(1);
                        paint2.setColor(color);
                        paint2.setAlpha(WebmConstants.MkvEbmlElement.BLOCK_GROUP);
                        this.fgP = paint2;
                    }

                    public final Paint getBgP() {
                        return this.bgP;
                    }

                    public final Paint getFgP() {
                        return this.fgP;
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        float f3 = getResources().getDisplayMetrics().density * 3.0f;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f3, f3, this.bgP);
                        float width = getWidth() * RangesKt.coerceIn(this.$prodProp, 0.0f, 1.0f);
                        if (width > 0.0f) {
                            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f3, f3, this.fgP);
                        }
                    }
                };
                r32.setLayoutParams(new LinearLayout.LayoutParams(0, dp(8), 1.0f));
                linearLayout6.addView((View) r32);
                TextView textView3 = new TextView(contextRequireContext);
                textView3.setText(MathKt.roundToInt(f2 * 100.0f) + "%");
                textView3.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                textView3.setTextSize(10.0f);
                textView3.setGravity(GravityCompat.END);
                textView3.setMinWidth(dp(36));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.setMarginStart(dp(6));
                textView3.setLayoutParams(layoutParams5);
                linearLayout6.addView(textView3);
                linearLayout3.addView(linearLayout6);
                linearLayout5.addView(linearLayout3);
                contentContainer.addView(linearLayout5);
                dimensionPixelSize = i;
                colorAnalysis = list;
                detailDialogPartsCreateTestDetailDialog = detailDialogParts;
                symbolToImage = symbolToImage;
                i2 = 1;
                i3 = 0;
            }
        }
        DetailDialogParts detailDialogParts2 = detailDialogPartsCreateTestDetailDialog;
        List<MTIdCardColorAnalysisRow> list2 = colorAnalysis;
        Iterator<T> it = list2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Double imbalance = ((MTIdCardColorAnalysisRow) next).getImbalance();
                double dAbs = Math.abs(imbalance != null ? imbalance.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
                do {
                    Object next2 = it.next();
                    Double imbalance2 = ((MTIdCardColorAnalysisRow) next2).getImbalance();
                    double dAbs2 = Math.abs(imbalance2 != null ? imbalance2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
                    if (Double.compare(dAbs, dAbs2) < 0) {
                        next = next2;
                        dAbs = dAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MTIdCardColorAnalysisRow mTIdCardColorAnalysisRow2 = (MTIdCardColorAnalysisRow) obj;
        if (mTIdCardColorAnalysisRow2 == null) {
            str = "—";
        } else {
            Double imbalance3 = mTIdCardColorAnalysisRow2.getImbalance();
            str = MathKt.roundToInt(Math.abs(imbalance3 != null ? imbalance3.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d) + "%";
            if (str == null) {
            }
        }
        Iterator<T> it2 = list2.iterator();
        double dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it2.hasNext()) {
            Double costPips = ((MTIdCardColorAnalysisRow) it2.next()).getCostPips();
            dDoubleValue3 += costPips != null ? costPips.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int iRoundToInt = MathKt.roundToInt(dDoubleValue3);
        Iterator<T> it3 = list2.iterator();
        double dDoubleValue4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it3.hasNext()) {
            Double productionSources = ((MTIdCardColorAnalysisRow) it3.next()).getProductionSources();
            dDoubleValue4 += productionSources != null ? productionSources.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int iRoundToInt2 = MathKt.roundToInt(dDoubleValue4);
        LinearLayout metricsContainer = detailDialogParts2.getMetricsContainer();
        String string = getString(R.string.metric_worst_color);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.metric_cost);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.metric_production);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) new MetricItem[]{new MetricItem(string, str, Integer.valueOf(scoreColor(scoreValue))), new MetricItem(string2, String.valueOf(iRoundToInt), null, 4, null), new MetricItem(string3, String.valueOf(iRoundToInt2), null, 4, null)}));
        detailDialogParts2.getDialog().show();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorlessLandsDetail$ring$1] */
    private final void showColorlessLandsDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("colorless_lands", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "colorless_lands", mba.getInsights());
        MTIdCardColorlessLandAnalysis colorlessLandAnalysis = mba.getColorlessLandAnalysis();
        if (colorlessLandAnalysis != null) {
            Double colorlessPercent = colorlessLandAnalysis.getColorlessPercent();
            final double dDoubleValue = (colorlessPercent != null ? colorlessPercent.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d;
            Integer colorlessCount = colorlessLandAnalysis.getColorlessCount();
            int iIntValue = colorlessCount != null ? colorlessCount.intValue() : 0;
            Integer totalLands = colorlessLandAnalysis.getTotalLands();
            int iIntValue2 = totalLands != null ? totalLands.intValue() : 0;
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dp(4);
            layoutParams.bottomMargin = dp(8);
            linearLayout.setLayoutParams(layoutParams);
            final int iScoreColor = scoreColor(scoreValue);
            ?? r0 = new View(contextRequireContext, iScoreColor, dDoubleValue, this) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showColorlessLandsDetail$ring$1
                final /* synthetic */ double $pct;
                private final Paint bgP;
                private final Paint fgP;
                private final Paint textP;
                final /* synthetic */ DeckIDCardManaDetailFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(contextRequireContext);
                    this.$pct = dDoubleValue;
                    this.this$0 = this;
                    Paint paint = new Paint(1);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(getResources().getDisplayMetrics().density * 6.0f);
                    paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                    this.bgP = paint;
                    Paint paint2 = new Paint(1);
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setStrokeWidth(getResources().getDisplayMetrics().density * 6.0f);
                    paint2.setColor(iScoreColor);
                    this.fgP = paint2;
                    Paint paint3 = new Paint(1);
                    paint3.setColor(iScoreColor);
                    paint3.setTextSize(getResources().getDisplayMetrics().density * 16.0f);
                    paint3.setTextAlign(Paint.Align.CENTER);
                    paint3.setTypeface(Typeface.DEFAULT_BOLD);
                    this.textP = paint3;
                }

                public final Paint getBgP() {
                    return this.bgP;
                }

                public final Paint getFgP() {
                    return this.fgP;
                }

                public final Paint getTextP() {
                    return this.textP;
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    float f = getResources().getDisplayMetrics().density * 8.0f;
                    RectF rectF = new RectF(f, f, getWidth() - f, getHeight() - f);
                    canvas.drawArc(rectF, 0.0f, 360.0f, false, this.bgP);
                    canvas.drawArc(rectF, -90.0f, (float) ((this.$pct * 360.0d) / 100.0d), false, this.fgP);
                    canvas.drawText(this.this$0.formatPct(this.$pct), getWidth() / 2.0f, (getHeight() / 2.0f) + (this.textP.getTextSize() / 3.0f), this.textP);
                }
            };
            r0.setLayoutParams(new LinearLayout.LayoutParams(dp(80), dp(80)));
            linearLayout.addView((View) r0);
            LinearLayout linearLayout2 = new LinearLayout(contextRequireContext);
            linearLayout2.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.setMarginStart(dp(12));
            linearLayout2.setLayoutParams(layoutParams2);
            List<String> colorlessLandNames = colorlessLandAnalysis.getColorlessLandNames();
            if (!colorlessLandNames.isEmpty()) {
                TextView textView = new TextView(contextRequireContext);
                textView.setText(CollectionsKt.joinToString$default(colorlessLandNames, ", ", null, null, 0, null, null, 62, null));
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView.setTextSize(12.0f);
                linearLayout2.addView(textView);
            }
            linearLayout.addView(linearLayout2);
            contentContainer.addView(linearLayout);
            LinearLayout metricsContainer = detailDialogPartsCreateTestDetailDialog.getMetricsContainer();
            String string = getString(R.string.metric_colorless_count);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.metric_colorless_pct);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) new MetricItem[]{new MetricItem(string, iIntValue + DomExceptionUtils.SEPARATOR + iIntValue2, null, 4, null), new MetricItem(string2, formatPct(dDoubleValue), Integer.valueOf(iScoreColor))}));
        }
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    private final void showCommanderCastDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("commander_cast", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "commander_cast", mba.getInsights());
        MTIdCardCommanderCastAnalysis commanderCastFiltered = mba.getCommanderCastFiltered();
        if (commanderCastFiltered == null) {
            commanderCastFiltered = mba.getCommanderCastAnalysis();
        }
        MTIdCardCommanderCastAnalysis partnerCastFiltered = mba.getPartnerCastFiltered();
        if (partnerCastFiltered == null) {
            partnerCastFiltered = mba.getPartnerCastAnalysis();
        }
        if (commanderCastFiltered != null) {
            showCommanderCastDetail$addCastSection(contextRequireContext, contentContainer, this, commanderCastFiltered);
        }
        if (partnerCastFiltered != null) {
            addSeparator(contentContainer);
            showCommanderCastDetail$addCastSection(contextRequireContext, contentContainer, this, partnerCastFiltered);
        }
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x01d0  */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showCommanderCastDetail$addCastSection$probBar$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void showCommanderCastDetail$addCastSection(final Context context, LinearLayout linearLayout, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis) {
        String upperCase;
        SymbolToImage symbolToImage = new SymbolToImage(context);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = deckIDCardManaDetailFragment.dp(4);
        layoutParams.bottomMargin = deckIDCardManaDetailFragment.dp(6);
        linearLayout2.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        String commanderName = mTIdCardCommanderCastAnalysis.getCommanderName();
        if (commanderName == null) {
            commanderName = "";
        }
        textView.setText(commanderName);
        textView.setTextColor(ContextCompat.getColor(context, R.color.text_color));
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(textView);
        String commanderManaCost = mTIdCardCommanderCastAnalysis.getCommanderManaCost();
        String str = commanderManaCost;
        if (str != null && !StringsKt.isBlank(str)) {
            TextView textView2 = new TextView(context);
            textView2.setText(symbolToImage.stringToAttributedStringWithSymbols(commanderManaCost, dimensionPixelSize, new CharacterStyle[0]));
            linearLayout2.addView(textView2);
        }
        linearLayout.addView(linearLayout2);
        Double onCurveProb = mTIdCardCommanderCastAnalysis.getOnCurveProb();
        final double dDoubleValue = onCurveProb != null ? onCurveProb.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        final int iScoreColor = deckIDCardManaDetailFragment.scoreColor(dDoubleValue);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = deckIDCardManaDetailFragment.dp(8);
        linearLayout3.setLayoutParams(layoutParams2);
        ?? r5 = new View(context, iScoreColor, dDoubleValue) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showCommanderCastDetail$addCastSection$probBar$1
            final /* synthetic */ double $onCurve;
            private final Paint bgP;
            private final Paint fgP;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.$onCurve = dDoubleValue;
                Paint paint = new Paint(1);
                paint.setColor(ContextCompat.getColor(context, R.color.separator_grey));
                this.bgP = paint;
                Paint paint2 = new Paint(1);
                paint2.setColor(iScoreColor);
                this.fgP = paint2;
            }

            public final Paint getBgP() {
                return this.bgP;
            }

            public final Paint getFgP() {
                return this.fgP;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                float f = getResources().getDisplayMetrics().density * 4.0f;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgP);
                float width = getWidth() * RangesKt.coerceIn((float) this.$onCurve, 0.0f, 1.0f);
                if (width > 0.0f) {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgP);
                }
            }
        };
        r5.setLayoutParams(new LinearLayout.LayoutParams(0, deckIDCardManaDetailFragment.dp(12), 1.0f));
        linearLayout3.addView((View) r5);
        TextView textView3 = new TextView(context);
        double d = dDoubleValue * 100.0d;
        textView3.setText(MathKt.roundToInt(d) + "%");
        textView3.setTextColor(iScoreColor);
        textView3.setTextSize(14.0f);
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(deckIDCardManaDetailFragment.dp(8));
        textView3.setLayoutParams(layoutParams3);
        linearLayout3.addView(textView3);
        linearLayout.addView(linearLayout3);
        Double aheadOfCurveProb = mTIdCardCommanderCastAnalysis.getAheadOfCurveProb();
        double dDoubleValue2 = aheadOfCurveProb != null ? aheadOfCurveProb.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        String colorBottleneck = mTIdCardCommanderCastAnalysis.getColorBottleneck();
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = deckIDCardManaDetailFragment.dp(6);
        linearLayout4.setLayoutParams(layoutParams4);
        String string = deckIDCardManaDetailFragment.getString(R.string.metric_on_curve);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showCommanderCastDetail$addCastSection$addInlineMetric(linearLayout4, context, deckIDCardManaDetailFragment, string, MathKt.roundToInt(d) + "%", Integer.valueOf(iScoreColor));
        String string2 = deckIDCardManaDetailFragment.getString(R.string.metric_ahead_of_curve);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        showCommanderCastDetail$addCastSection$addInlineMetric$default(linearLayout4, context, deckIDCardManaDetailFragment, string2, MathKt.roundToInt(dDoubleValue2 * 100.0d) + "%", null, 32, null);
        String string3 = deckIDCardManaDetailFragment.getString(R.string.metric_color_bottleneck);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        if (colorBottleneck != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            upperCase = colorBottleneck.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (upperCase == null) {
                upperCase = "—";
            }
        }
        showCommanderCastDetail$addCastSection$addInlineMetric$default(linearLayout4, context, deckIDCardManaDetailFragment, string3, upperCase, null, 32, null);
        linearLayout.addView(linearLayout4);
        if (mTIdCardCommanderCastAnalysis.getIterations() == null || mTIdCardCommanderCastAnalysis.getIterations().intValue() <= 0) {
            return;
        }
        int i = R.string.detail_simulation_info;
        Integer iterations = mTIdCardCommanderCastAnalysis.getIterations();
        Integer minLandsFilter = mTIdCardCommanderCastAnalysis.getMinLandsFilter();
        Integer numValueOf = Integer.valueOf(minLandsFilter != null ? minLandsFilter.intValue() : 0);
        Integer validIterations = mTIdCardCommanderCastAnalysis.getValidIterations();
        Integer numValueOf2 = Integer.valueOf(validIterations != null ? validIterations.intValue() : 0);
        Integer landCountInDeck = mTIdCardCommanderCastAnalysis.getLandCountInDeck();
        Integer numValueOf3 = Integer.valueOf(landCountInDeck != null ? landCountInDeck.intValue() : 0);
        Integer rampCount = mTIdCardCommanderCastAnalysis.getRampCount();
        String string4 = deckIDCardManaDetailFragment.getString(i, iterations, numValueOf, numValueOf2, numValueOf3, Integer.valueOf(rampCount != null ? rampCount.intValue() : 0));
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        TextView textView4 = new TextView(context);
        textView4.setText(string4);
        textView4.setTextColor(ContextCompat.getColor(context, R.color.text_color_secondary));
        textView4.setTextSize(11.0f);
        textView4.setBackground(ContextCompat.getDrawable(context, R.drawable.manabase_gauge_background));
        textView4.setPadding(deckIDCardManaDetailFragment.dp(8), deckIDCardManaDetailFragment.dp(6), deckIDCardManaDetailFragment.dp(8), deckIDCardManaDetailFragment.dp(6));
        textView4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView4);
        if (mTIdCardCommanderCastAnalysis.getEnablerNames().isEmpty()) {
            return;
        }
        TextView textView5 = new TextView(context);
        textView5.setText(deckIDCardManaDetailFragment.getString(R.string.detail_fast_mana_enablers, CollectionsKt.joinToString$default(mTIdCardCommanderCastAnalysis.getEnablerNames(), " - ", null, null, 0, null, null, 62, null)));
        textView5.setTextColor(ContextCompat.getColor(context, R.color.text_color_secondary));
        textView5.setTextSize(11.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = deckIDCardManaDetailFragment.dp(4);
        textView5.setLayoutParams(layoutParams5);
        linearLayout.addView(textView5);
    }

    private static final void showCommanderCastDetail$addCastSection$addInlineMetric(LinearLayout linearLayout, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, String str, String str2, Integer num) {
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        linearLayout2.setBackground(ContextCompat.getDrawable(context, R.drawable.manabase_gauge_background));
        linearLayout2.setPadding(deckIDCardManaDetailFragment.dp(6), deckIDCardManaDetailFragment.dp(6), deckIDCardManaDetailFragment.dp(6), deckIDCardManaDetailFragment.dp(6));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(deckIDCardManaDetailFragment.dp(2));
        layoutParams.setMarginEnd(deckIDCardManaDetailFragment.dp(2));
        linearLayout2.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(ContextCompat.getColor(context, R.color.text_color_secondary));
        textView.setTextSize(9.0f);
        textView.setGravity(17);
        textView.setMaxLines(1);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(str2);
        textView2.setTextColor(num != null ? num.intValue() : ContextCompat.getColor(context, R.color.text_color));
        textView2.setTextSize(14.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
    }

    static /* synthetic */ void showCommanderCastDetail$addCastSection$addInlineMetric$default(LinearLayout linearLayout, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 32) != 0) {
            num = null;
        }
        showCommanderCastDetail$addCastSection$addInlineMetric(linearLayout, context, deckIDCardManaDetailFragment, str, str2, num);
    }

    private final void showFetchTargetsDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("fetch_targets", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "fetch_targets", mba.getInsights());
        MTIdCardFetchTargetAnalysis fetchTargetAnalysis = mba.getFetchTargetAnalysis();
        if (fetchTargetAnalysis != null) {
            Integer fetchCount = fetchTargetAnalysis.getFetchCount();
            int iIntValue = fetchCount != null ? fetchCount.intValue() : 0;
            Integer fetchableTargetCount = fetchTargetAnalysis.getFetchableTargetCount();
            int iIntValue2 = fetchableTargetCount != null ? fetchableTargetCount.intValue() : 0;
            Integer surplus = fetchTargetAnalysis.getSurplus();
            int iIntValue3 = surplus != null ? surplus.intValue() : iIntValue2 - iIntValue;
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dp(8);
            layoutParams.bottomMargin = dp(8);
            linearLayout.setLayoutParams(layoutParams);
            int color = iIntValue3 >= 0 ? ContextCompat.getColor(contextRequireContext, R.color.positive_green) : ContextCompat.getColor(contextRequireContext, R.color.error_red);
            String strValueOf = iIntValue3 >= 0 ? "+" + iIntValue3 : String.valueOf(iIntValue3);
            linearLayout.addView(showFetchTargetsDetail$makeCircle(contextRequireContext, this, String.valueOf(iIntValue), -1, ContextCompat.getColor(contextRequireContext, R.color.separator_grey)));
            linearLayout.addView(showFetchTargetsDetail$makeDash(contextRequireContext, this));
            linearLayout.addView(showFetchTargetsDetail$makeCircle(contextRequireContext, this, strValueOf, -1, color));
            linearLayout.addView(showFetchTargetsDetail$makeDash(contextRequireContext, this));
            linearLayout.addView(showFetchTargetsDetail$makeCircle(contextRequireContext, this, String.valueOf(iIntValue2), -1, ContextCompat.getColor(contextRequireContext, R.color.separator_grey)));
            contentContainer.addView(linearLayout);
            LinearLayout metricsContainer = detailDialogPartsCreateTestDetailDialog.getMetricsContainer();
            String string = getString(R.string.metric_fetch_lands);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.metric_fetchable_targets);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getString(R.string.metric_target_surplus);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) new MetricItem[]{new MetricItem(string, String.valueOf(iIntValue), null, 4, null), new MetricItem(string2, String.valueOf(iIntValue2), null, 4, null), new MetricItem(string3, strValueOf, Integer.valueOf(color))}));
        }
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    private static final View showFetchTargetsDetail$makeCircle(Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(18.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        textView.setMinWidth(deckIDCardManaDetailFragment.dp(44));
        textView.setMinHeight(deckIDCardManaDetailFragment.dp(44));
        textView.setPadding(deckIDCardManaDetailFragment.dp(8), deckIDCardManaDetailFragment.dp(8), deckIDCardManaDetailFragment.dp(8), deckIDCardManaDetailFragment.dp(8));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        textView.setBackground(gradientDrawable);
        return textView;
    }

    private static final View showFetchTargetsDetail$makeDash(Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment) {
        TextView textView = new TextView(context);
        textView.setText("- -");
        textView.setTextColor(ContextCompat.getColor(context, R.color.text_color_secondary));
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setPadding(deckIDCardManaDetailFragment.dp(4), 0, deckIDCardManaDetailFragment.dp(4), 0);
        return textView;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showLandCountDetail$barView$1] */
    private final void showLandCountDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        MTIdCardLandCountCalculation mTIdCardLandCountCalculation;
        char c;
        int i;
        Integer recommendedMax;
        Integer recommendedMin;
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("land_count", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "land_count", mba.getInsights());
        MTIdCardLandCountCalculation landCountCalculation = mba.getLandCountCalculation();
        Integer landCount = mba.getLandCount();
        final int iIntValue = landCount != null ? landCount.intValue() : 0;
        final int iIntValue2 = (landCountCalculation == null || (recommendedMin = landCountCalculation.getRecommendedMin()) == null) ? 0 : recommendedMin.intValue();
        final int iIntValue3 = (landCountCalculation == null || (recommendedMax = landCountCalculation.getRecommendedMax()) == null) ? 0 : recommendedMax.intValue();
        if (iIntValue3 > 0) {
            int iCoerceAtLeast = RangesKt.coerceAtLeast(iIntValue3 + 5, iIntValue + 3);
            final int iCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(iIntValue2 - 5, iIntValue - 3), 0);
            final float fCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast - iCoerceAtLeast2, 1.0f);
            LinearLayout linearLayout = new LinearLayout(contextRequireContext);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            c = 0;
            layoutParams.topMargin = dp(8);
            layoutParams.bottomMargin = dp(8);
            linearLayout.setLayoutParams(layoutParams);
            ?? r4 = new View(contextRequireContext, iIntValue2, iIntValue, iIntValue3, iCoerceAtLeast2, fCoerceAtLeast) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showLandCountDetail$barView$1
                final /* synthetic */ int $current;
                final /* synthetic */ int $rangeMin;
                final /* synthetic */ int $recMax;
                final /* synthetic */ int $recMin;
                final /* synthetic */ float $span;
                private final Paint bgPaint;
                private final Paint markerPaint;
                private final Paint rangePaint;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(contextRequireContext);
                    this.$recMin = iIntValue2;
                    this.$current = iIntValue;
                    this.$recMax = iIntValue3;
                    this.$rangeMin = iCoerceAtLeast2;
                    this.$span = fCoerceAtLeast;
                    Paint paint = new Paint(1);
                    paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                    this.bgPaint = paint;
                    Paint paint2 = new Paint(1);
                    paint2.setColor(ContextCompat.getColor(contextRequireContext, R.color.positive_green));
                    paint2.setAlpha(80);
                    this.rangePaint = paint2;
                    Paint paint3 = new Paint(1);
                    paint3.setColor((iIntValue2 > iIntValue || iIntValue > iIntValue3) ? ContextCompat.getColor(contextRequireContext, R.color.warning_amber) : ContextCompat.getColor(contextRequireContext, R.color.positive_green));
                    paint3.setStrokeWidth(getResources().getDisplayMetrics().density * 3.0f);
                    this.markerPaint = paint3;
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    float f = getResources().getDisplayMetrics().density * 4.0f;
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgPaint);
                    canvas.drawRoundRect(new RectF(((this.$recMin - this.$rangeMin) / this.$span) * getWidth(), 0.0f, ((this.$recMax - this.$rangeMin) / this.$span) * getWidth(), getHeight()), f, f, this.rangePaint);
                    float width = ((this.$current - this.$rangeMin) / this.$span) * getWidth();
                    canvas.drawLine(width, 0.0f, width, getHeight(), this.markerPaint);
                }
            };
            r4.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(16)));
            linearLayout.addView((View) r4);
            int color = (iIntValue2 > iIntValue || iIntValue > iIntValue3) ? ContextCompat.getColor(contextRequireContext, R.color.warning_amber) : ContextCompat.getColor(contextRequireContext, R.color.positive_green);
            final FrameLayout frameLayout = new FrameLayout(contextRequireContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = dp(2);
            frameLayout.setLayoutParams(layoutParams2);
            final FrameLayout frameLayout2 = new FrameLayout(contextRequireContext);
            mTIdCardLandCountCalculation = landCountCalculation;
            frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            final int i2 = color;
            final int i3 = iIntValue3;
            final int i4 = iIntValue2;
            i = 1;
            iIntValue2 = i4;
            iIntValue3 = i3;
            frameLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DeckIDCardManaDetailFragment.showLandCountDetail$lambda$3(frameLayout, contextRequireContext, iIntValue, iCoerceAtLeast2, fCoerceAtLeast, i4, i3, frameLayout2, i2);
                }
            });
            linearLayout.addView(frameLayout);
            linearLayout.addView(frameLayout2);
            contentContainer.addView(linearLayout);
        } else {
            mTIdCardLandCountCalculation = landCountCalculation;
            c = 0;
            i = 1;
        }
        Double avgManaValue = mTIdCardLandCountCalculation != null ? mTIdCardLandCountCalculation.getAvgManaValue() : null;
        LinearLayout metricsContainer = detailDialogPartsCreateTestDetailDialog.getMetricsContainer();
        MetricItem[] metricItemArr = new MetricItem[3];
        String string = getString(R.string.metric_current_lands);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        metricItemArr[c] = new MetricItem(string, String.valueOf(iIntValue), Integer.valueOf(scoreColor((iIntValue2 > iIntValue || iIntValue > iIntValue3) ? 0.3d : 1.0d)));
        String string2 = getString(R.string.metric_recommended_range);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = "—";
        metricItemArr[i] = new MetricItem(string2, iIntValue2 > 0 ? iIntValue2 + "–" + iIntValue3 : "—", null, 4, null);
        String string3 = getString(R.string.metric_cmc);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        if (avgManaValue != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{avgManaValue}, i));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        metricItemArr[2] = new MetricItem(string3, str, null, 4, null);
        addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) metricItemArr));
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    static final void showLandCountDetail$lambda$3(FrameLayout frameLayout, Context context, int i, int i2, float f, int i3, int i4, FrameLayout frameLayout2, int i5) {
        float fCoerceAtLeast = RangesKt.coerceAtLeast(frameLayout.getWidth(), 1.0f);
        TextView textView = new TextView(context);
        textView.setText(String.valueOf(i));
        textView.setTextColor(i5);
        textView.setTextSize(11.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.measure(0, 0);
        float fCoerceIn = RangesKt.coerceIn((((i - i2) / f) * fCoerceAtLeast) - (textView.getMeasuredWidth() / 2.0f), 0.0f, fCoerceAtLeast - textView.getMeasuredWidth());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) fCoerceIn);
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText(i3 + "  " + i4);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.text_color_secondary));
        textView2.setTextSize(11.0f);
        textView2.measure(0, 0);
        float fCoerceIn2 = RangesKt.coerceIn((((((i3 + i4) / 2.0f) - i2) / f) * fCoerceAtLeast) - (textView2.getMeasuredWidth() / 2.0f), 0.0f, fCoerceAtLeast - textView2.getMeasuredWidth());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart((int) fCoerceIn2);
        Unit unit2 = Unit.INSTANCE;
        frameLayout2.addView(textView2, layoutParams2);
    }

    private final void showLandDropDialog(MTIdCardLandDropAnalysis analysis, MTIdCardManaBaseAnalysis mba) {
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final Dialog dialog = new Dialog(contextRequireContext, android.R.style.Theme.Translucent.NoTitleBar);
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        frameLayout.setBackgroundColor(-1728053248);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        View viewInflate = getLayoutInflater().inflate(R.layout.popup_land_drop_analysis, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckIDCardManaDetailFragment.showLandDropDialog$lambda$1(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (getResources().getDisplayMetrics().widthPixels * 0.9f), -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(viewInflate, layoutParams);
        View viewFindViewById = viewInflate.findViewById(R.id.popupCloseButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        final MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) viewInflate.findViewById(R.id.startingLandsToggle);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.tabLands0);
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.tabLands1);
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.tabLands2);
        MaterialButton materialButton4 = (MaterialButton) viewInflate.findViewById(R.id.tabLands3);
        View viewFindViewById2 = viewInflate.findViewById(R.id.turnListContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.landCountLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.landCountMinus);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.landCountPlus);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        materialButton.setText(ExifInterface.GPS_MEASUREMENT_2D);
        materialButton2.setText(ExifInterface.GPS_MEASUREMENT_3D);
        materialButton3.setText("4");
        materialButton4.setText("5");
        final Ref.IntRef intRef = new Ref.IntRef();
        Integer landCount = analysis.getLandCount();
        intRef.element = (landCount == null && (landCount = mba.getLandCount()) == null) ? 37 : landCount.intValue();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        Integer startingLands = analysis.getStartingLands();
        intRef2.element = startingLands != null ? startingLands.intValue() : 3;
        Integer deckSize = analysis.getDeckSize();
        int iIntValue = (deckSize == null && (deckSize = mba.getDeckSize()) == null) ? 99 : deckSize.intValue();
        textView.setText(String.valueOf(intRef.element));
        final List listListOf = CollectionsKt.listOf((Object[]) new MaterialButton[]{materialButton, materialButton2, materialButton3, materialButton4});
        final int color = ContextCompat.getColor(contextRequireContext, R.color.unselected_color_new);
        final int color2 = ContextCompat.getColor(contextRequireContext, R.color.selected_color_new_variant);
        int i = intRef2.element;
        materialButtonToggleGroup.check(i != 2 ? i != 3 ? i != 4 ? i != 5 ? R.id.tabLands1 : R.id.tabLands3 : R.id.tabLands2 : R.id.tabLands1 : R.id.tabLands0);
        showLandDropDialog$styleTabButtons(listListOf, materialButtonToggleGroup, color, color2);
        final int i2 = iIntValue;
        showLandDropDialog$refreshTurnList(linearLayout, intRef, i2, intRef2, contextRequireContext, this);
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda9
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i3, boolean z) {
                DeckIDCardManaDetailFragment.showLandDropDialog$lambda$6(intRef2, listListOf, materialButtonToggleGroup, color, color2, linearLayout, intRef, i2, contextRequireContext, this, materialButtonToggleGroup2, i3, z);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardManaDetailFragment.showLandDropDialog$lambda$7(intRef, textView, linearLayout, i2, intRef2, contextRequireContext, this);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardManaDetailFragment.showLandDropDialog$lambda$8(intRef, i2, textView, linearLayout, intRef2, contextRequireContext, this);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardManaDetailFragment.showLandDropDialog$lambda$9(dialog);
            }
        });
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        dialog.show();
    }

    static final void showLandDropDialog$lambda$1(View view) {
    }

    static final void showLandDropDialog$lambda$6(Ref.IntRef intRef, List list, MaterialButtonToggleGroup materialButtonToggleGroup, int i, int i2, LinearLayout linearLayout, Ref.IntRef intRef2, int i3, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, MaterialButtonToggleGroup materialButtonToggleGroup2, int i4, boolean z) {
        if (z) {
            intRef.element = i4 == R.id.tabLands0 ? 2 : i4 == R.id.tabLands1 ? 3 : i4 == R.id.tabLands2 ? 4 : i4 == R.id.tabLands3 ? 5 : intRef.element;
            showLandDropDialog$styleTabButtons(list, materialButtonToggleGroup, i, i2);
            showLandDropDialog$refreshTurnList(linearLayout, intRef2, i3, intRef, context, deckIDCardManaDetailFragment);
        }
    }

    static final Unit showLandDropDialog$lambda$7(Ref.IntRef intRef, TextView textView, LinearLayout linearLayout, int i, Ref.IntRef intRef2, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment) {
        if (intRef.element > 1) {
            intRef.element--;
            textView.setText(String.valueOf(intRef.element));
            showLandDropDialog$refreshTurnList(linearLayout, intRef, i, intRef2, context, deckIDCardManaDetailFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit showLandDropDialog$lambda$8(Ref.IntRef intRef, int i, TextView textView, LinearLayout linearLayout, Ref.IntRef intRef2, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment) {
        if (intRef.element < i - 1) {
            intRef.element++;
            textView.setText(String.valueOf(intRef.element));
            showLandDropDialog$refreshTurnList(linearLayout, intRef, i, intRef2, context, deckIDCardManaDetailFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit showLandDropDialog$lambda$9(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private static final void showLandDropDialog$refreshTurnList(LinearLayout linearLayout, Ref.IntRef intRef, int i, Ref.IntRef intRef2, Context context, DeckIDCardManaDetailFragment deckIDCardManaDetailFragment) {
        linearLayout.removeAllViews();
        for (LandDropEntry landDropEntry : INSTANCE.computeLandDropEntries(intRef.element, i, intRef2.element)) {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setPadding(0, 4, 0, 4);
            int probability = (int) (landDropEntry.getProbability() * 100.0d);
            int color = landDropEntry.getProbability() >= 0.85d ? ContextCompat.getColor(context, R.color.positive_green) : landDropEntry.getProbability() >= 0.75d ? ContextCompat.getColor(context, R.color.warning_amber) : ContextCompat.getColor(context, R.color.error_red);
            TextView textView = new TextView(context);
            textView.setText(deckIDCardManaDetailFragment.getString(R.string.land_drop_popup_turn, Integer.valueOf(landDropEntry.getTurn())));
            textView.setTextColor(ContextCompat.getColor(context, R.color.text_color));
            textView.setTextSize(14.0f);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            linearLayout2.addView(textView);
            TextView textView2 = new TextView(context);
            textView2.setText(probability + "%");
            textView2.setTextColor(color);
            textView2.setTextSize(14.0f);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            linearLayout2.addView(textView2);
            linearLayout.addView(linearLayout2);
        }
    }

    private static final void showLandDropDialog$styleTabButtons(List<? extends MaterialButton> list, MaterialButtonToggleGroup materialButtonToggleGroup, int i, int i2) {
        for (MaterialButton materialButton : list) {
            int i3 = 0;
            boolean z = materialButtonToggleGroup.getCheckedButtonId() == materialButton.getId();
            materialButton.setTextColor(z ? -1 : i);
            if (z) {
                i3 = i2;
            }
            materialButton.setBackgroundColor(i3);
        }
    }

    private final void showOpeningHandDialog(MTIdCardOpeningHandAnalysis analysis) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final List<MTIdCardOpeningHandProb> probabilities = analysis.getProbabilities();
        if (probabilities.isEmpty()) {
            return;
        }
        final Dialog dialog = new Dialog(contextRequireContext, android.R.style.Theme.Translucent.NoTitleBar);
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        frameLayout.setBackgroundColor(-1728053248);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        View viewInflate = getLayoutInflater().inflate(R.layout.popup_opening_hand_chart, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckIDCardManaDetailFragment.showOpeningHandDialog$lambda$1(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (getResources().getDisplayMetrics().widthPixels * 0.9f), -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(viewInflate, layoutParams);
        View viewFindViewById = viewInflate.findViewById(R.id.popupCloseButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.openingHandChart);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final BarChart barChart = (BarChart) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.rangeLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        RangeSlider rangeSlider = (RangeSlider) viewInflate.findViewById(R.id.rangeSlider);
        View viewFindViewById4 = viewInflate.findViewById(R.id.rawProbabilityValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.mulliganProbabilityValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById5;
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.recommendedRangeLabel);
        configureOpeningHandChart(barChart, probabilities);
        List<Integer> idealRange = analysis.getIdealRange();
        if (idealRange == null) {
            idealRange = CollectionsKt.listOf((Object[]) new Integer[]{2, 4});
        }
        int iIntValue = (idealRange.size() > 0 ? idealRange.get(0) : 2).intValue();
        int iIntValue2 = (1 < idealRange.size() ? idealRange.get(1) : 4).intValue();
        rangeSlider.setValues(CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(iIntValue), Float.valueOf(iIntValue2)}));
        updateRangeDisplays(probabilities, iIntValue, iIntValue2, textView, textView2, textView3);
        if (textView4 != null) {
            textView4.setText(getString(R.string.recommended_land_range, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)));
        }
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.RangeSlider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(RangeSlider rangeSlider2, float f, boolean z) {
                DeckIDCardManaDetailFragment.showOpeningHandDialog$lambda$5(this.f$0, probabilities, textView, textView2, textView3, barChart, rangeSlider2, f, z);
            }
        });
        updateChartHighlighting(barChart, probabilities, iIntValue, iIntValue2);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckIDCardManaDetailFragment.showOpeningHandDialog$lambda$6(dialog);
            }
        });
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        dialog.show();
    }

    static final void showOpeningHandDialog$lambda$1(View view) {
    }

    static final void showOpeningHandDialog$lambda$5(DeckIDCardManaDetailFragment deckIDCardManaDetailFragment, List list, TextView textView, TextView textView2, TextView textView3, BarChart barChart, RangeSlider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(slider, "slider");
        List<Float> values = slider.getValues();
        Intrinsics.checkNotNullExpressionValue(values, "getValues(...)");
        int iFloatValue = (int) values.get(0).floatValue();
        int iFloatValue2 = (int) values.get(1).floatValue();
        deckIDCardManaDetailFragment.updateRangeDisplays(list, iFloatValue, iFloatValue2, textView, textView2, textView3);
        deckIDCardManaDetailFragment.updateChartHighlighting(barChart, list, iFloatValue, iFloatValue2);
    }

    static final Unit showOpeningHandDialog$lambda$6(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showPipDensityDetail$probBar$1] */
    private final void showPipDensityDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        List<MTIdCardPipFlaggedCard> listEmptyList;
        DetailDialogParts detailDialogParts;
        Object obj;
        Integer pipCount;
        Double castProbability;
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("pip_density", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "pip_density", mba.getInsights());
        MTIdCardPipDensityAnalysis pipDensityAnalysis = mba.getPipDensityAnalysis();
        if (pipDensityAnalysis == null || (listEmptyList = pipDensityAnalysis.getFlaggedCards()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        SymbolToImage symbolToImage = new SymbolToImage(contextRequireContext);
        int dimensionPixelSize = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
        if (listEmptyList.isEmpty()) {
            detailDialogParts = detailDialogPartsCreateTestDetailDialog;
        } else {
            List<MTIdCardPipFlaggedCard> list = listEmptyList;
            for (MTIdCardPipFlaggedCard mTIdCardPipFlaggedCard : CollectionsKt.take(list, 5)) {
                LinearLayout linearLayout = new LinearLayout(contextRequireContext);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = dp(8);
                linearLayout.setLayoutParams(layoutParams);
                LinearLayout linearLayout2 = new LinearLayout(contextRequireContext);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(16);
                TextView textView = new TextView(contextRequireContext);
                String cardName = mTIdCardPipFlaggedCard.getCardName();
                if (cardName == null) {
                    cardName = "";
                }
                textView.setText(cardName);
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView.setTextSize(13.0f);
                DetailDialogParts detailDialogParts2 = detailDialogPartsCreateTestDetailDialog;
                List<MTIdCardPipFlaggedCard> list2 = list;
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                linearLayout2.addView(textView);
                String manaCost = mTIdCardPipFlaggedCard.getManaCost();
                String str = manaCost;
                if (str != null && !StringsKt.isBlank(str)) {
                    TextView textView2 = new TextView(contextRequireContext);
                    textView2.setText(symbolToImage.stringToAttributedStringWithSymbols(manaCost, dimensionPixelSize, new CharacterStyle[0]));
                    linearLayout2.addView(textView2);
                }
                linearLayout.addView(linearLayout2);
                Double castProbability2 = mTIdCardPipFlaggedCard.getCastProbability();
                final double dDoubleValue = castProbability2 != null ? castProbability2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                final int iScoreColor = scoreColor(dDoubleValue);
                LinearLayout linearLayout3 = new LinearLayout(contextRequireContext);
                linearLayout3.setOrientation(0);
                linearLayout3.setGravity(16);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = dp(3);
                linearLayout3.setLayoutParams(layoutParams2);
                ?? r2 = new View(contextRequireContext, iScoreColor, dDoubleValue) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showPipDensityDetail$probBar$1
                    final /* synthetic */ double $castProb;
                    private final Paint bgP;
                    private final Paint fgP;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext);
                        this.$castProb = dDoubleValue;
                        Paint paint = new Paint(1);
                        paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                        this.bgP = paint;
                        Paint paint2 = new Paint(1);
                        paint2.setColor(iScoreColor);
                        this.fgP = paint2;
                    }

                    public final Paint getBgP() {
                        return this.bgP;
                    }

                    public final Paint getFgP() {
                        return this.fgP;
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        float f = getResources().getDisplayMetrics().density * 3.0f;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgP);
                        float width = getWidth() * RangesKt.coerceIn((float) this.$castProb, 0.0f, 1.0f);
                        if (width > 0.0f) {
                            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgP);
                        }
                    }
                };
                r2.setLayoutParams(new LinearLayout.LayoutParams(0, dp(8), 1.0f));
                linearLayout3.addView((View) r2);
                TextView textView3 = new TextView(contextRequireContext);
                textView3.setText(MathKt.roundToInt(dDoubleValue * 100.0d) + "%");
                textView3.setTextColor(iScoreColor);
                textView3.setTextSize(12.0f);
                textView3.setTypeface(Typeface.DEFAULT_BOLD);
                textView3.setMinWidth(dp(36));
                textView3.setGravity(GravityCompat.END);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart(dp(6));
                textView3.setLayoutParams(layoutParams3);
                linearLayout3.addView(textView3);
                linearLayout.addView(linearLayout3);
                contentContainer.addView(linearLayout);
                symbolToImage = symbolToImage;
                detailDialogPartsCreateTestDetailDialog = detailDialogParts2;
                dimensionPixelSize = dimensionPixelSize;
                list = list2;
            }
            detailDialogParts = detailDialogPartsCreateTestDetailDialog;
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    Double castProbability3 = ((MTIdCardPipFlaggedCard) next).getCastProbability();
                    double dDoubleValue2 = castProbability3 != null ? castProbability3.doubleValue() : 1.0d;
                    do {
                        Object next2 = it.next();
                        Double castProbability4 = ((MTIdCardPipFlaggedCard) next2).getCastProbability();
                        double dDoubleValue3 = castProbability4 != null ? castProbability4.doubleValue() : 1.0d;
                        if (Double.compare(dDoubleValue2, dDoubleValue3) > 0) {
                            next = next2;
                            dDoubleValue2 = dDoubleValue3;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            MTIdCardPipFlaggedCard mTIdCardPipFlaggedCard2 = (MTIdCardPipFlaggedCard) obj;
            double dDoubleValue4 = (mTIdCardPipFlaggedCard2 == null || (castProbability = mTIdCardPipFlaggedCard2.getCastProbability()) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : castProbability.doubleValue();
            int iIntValue = (mTIdCardPipFlaggedCard2 == null || (pipCount = mTIdCardPipFlaggedCard2.getPipCount()) == null) ? 0 : pipCount.intValue();
            LinearLayout metricsContainer = detailDialogParts.getMetricsContainer();
            String string = getString(R.string.metric_worst_card);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int iRoundToInt = MathKt.roundToInt(dDoubleValue4 * 100.0d);
            String string2 = getString(R.string.metric_pip_symbols);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) new MetricItem[]{new MetricItem(string, iRoundToInt + "%", Integer.valueOf(scoreColor(dDoubleValue4))), new MetricItem(string2, String.valueOf(iIntValue), null, 4, null)}));
            List<MTIdCardManaInsight> insights = mba.getInsights();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : insights) {
                if (Intrinsics.areEqual(((MTIdCardManaInsight) obj2).getType(), "pip_density")) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((MTIdCardManaInsight) it2.next()).getCardNames());
            }
            addRelatedCards(contentContainer, arrayList2);
        }
        detailDialogParts.getDialog().show();
    }

    /* JADX WARN: Type inference failed for: r8v30, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showRampDetail$bar$1] */
    private final void showRampDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        RampCategory rampCategory;
        int i;
        int i2;
        CostTier costTier;
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("mana_acceleration", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "mana_acceleration", mba.getInsights());
        MTIdCardRampAnalysis rampAnalysis = mba.getRampAnalysis();
        if (rampAnalysis != null) {
            int i3 = 10;
            float fCoerceAtLeast = RangesKt.coerceAtLeast(rampAnalysis.getRecommendedRamp() != null ? r5.intValue() : 10, 1.0f);
            RampCategory[] rampCategoryArr = new RampCategory[4];
            String string = getString(R.string.metric_mana_rocks);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Integer manaRockCount = rampAnalysis.getManaRockCount();
            rampCategoryArr[0] = new RampCategory(string, manaRockCount != null ? manaRockCount.intValue() : 0, ContextCompat.getColor(contextRequireContext, R.color.info_blue));
            String string2 = getString(R.string.metric_mana_dorks);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Integer manaDorkCount = rampAnalysis.getManaDorkCount();
            rampCategoryArr[1] = new RampCategory(string2, manaDorkCount != null ? manaDorkCount.intValue() : 0, ContextCompat.getColor(contextRequireContext, R.color.positive_green));
            String string3 = getString(R.string.metric_land_ramp);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            Integer cheapLandRampCount = rampAnalysis.getCheapLandRampCount();
            rampCategoryArr[2] = new RampCategory(string3, cheapLandRampCount != null ? cheapLandRampCount.intValue() : 0, ContextCompat.getColor(contextRequireContext, R.color.warning_amber));
            Integer costReducerCount = rampAnalysis.getCostReducerCount();
            if ((costReducerCount != null ? costReducerCount.intValue() : 0) > 0) {
                String string4 = getString(R.string.metric_cost_reducers);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                Integer costReducerCount2 = rampAnalysis.getCostReducerCount();
                rampCategory = new RampCategory(string4, costReducerCount2 != null ? costReducerCount2.intValue() : 0, Color.parseColor("#BB86FC"));
            } else {
                rampCategory = null;
            }
            int i4 = 3;
            rampCategoryArr[3] = rampCategory;
            Iterator it = CollectionsKt.listOfNotNull((Object[]) rampCategoryArr).iterator();
            while (true) {
                i = 16;
                i2 = i4;
                if (!it.hasNext()) {
                    break;
                }
                final RampCategory rampCategory2 = (RampCategory) it.next();
                LinearLayout linearLayout = new LinearLayout(contextRequireContext);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = dp(6);
                linearLayout.setLayoutParams(layoutParams);
                TextView textView = new TextView(contextRequireContext);
                textView.setText(rampCategory2.getLabel());
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView.setTextSize(12.0f);
                textView.setMinWidth(dp(70));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMarginEnd(dp(8));
                textView.setLayoutParams(layoutParams2);
                linearLayout.addView(textView);
                final float count = rampCategory2.getCount() / fCoerceAtLeast;
                ?? r8 = new View(contextRequireContext, rampCategory2, count) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showRampDetail$bar$1
                    final /* synthetic */ float $fraction;
                    private final Paint bgP;
                    private final Paint fgP;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext);
                        this.$fraction = count;
                        Paint paint = new Paint(1);
                        paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.separator_grey));
                        this.bgP = paint;
                        Paint paint2 = new Paint(1);
                        paint2.setColor(rampCategory2.getColor());
                        this.fgP = paint2;
                    }

                    public final Paint getBgP() {
                        return this.bgP;
                    }

                    public final Paint getFgP() {
                        return this.fgP;
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        float f = getResources().getDisplayMetrics().density * 3.0f;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.bgP);
                        float width = getWidth() * RangesKt.coerceIn(this.$fraction, 0.0f, 1.0f);
                        if (width > 0.0f) {
                            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.fgP);
                        }
                    }
                };
                r8.setLayoutParams(new LinearLayout.LayoutParams(0, dp(i3), 1.0f));
                linearLayout.addView((View) r8);
                TextView textView2 = new TextView(contextRequireContext);
                textView2.setText(String.valueOf(rampCategory2.getCount()));
                textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
                textView2.setTextSize(12.0f);
                textView2.setTypeface(Typeface.DEFAULT_BOLD);
                textView2.setGravity(GravityCompat.END);
                textView2.setMinWidth(dp(24));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart(dp(6));
                textView2.setLayoutParams(layoutParams3);
                linearLayout.addView(textView2);
                contentContainer.addView(linearLayout);
                i4 = i2;
                i3 = 10;
            }
            int color = ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary);
            LinearLayout linearLayout2 = new LinearLayout(contextRequireContext);
            linearLayout2.setOrientation(1);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = dp(4);
            layoutParams4.setMarginStart(dp(12));
            linearLayout2.setLayoutParams(layoutParams4);
            TextView textView3 = new TextView(contextRequireContext);
            textView3.setText(getString(R.string.ramp_cost_breakdown_title));
            textView3.setTextSize(10.0f);
            textView3.setTextColor(color);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = dp(2);
            textView3.setLayoutParams(layoutParams5);
            linearLayout2.addView(textView3);
            CostTier[] costTierArr = new CostTier[5];
            String string5 = getString(R.string.metric_cheap_ramp);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            Integer cheapRampCount = rampAnalysis.getCheapRampCount();
            costTierArr[0] = new CostTier(string5, cheapRampCount != null ? cheapRampCount.intValue() : 0, "×1.0");
            String string6 = getString(R.string.metric_mid_ramp);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            Integer midRampCount = rampAnalysis.getMidRampCount();
            costTierArr[1] = new CostTier(string6, midRampCount != null ? midRampCount.intValue() : 0, "×0.7");
            String string7 = getString(R.string.metric_high_ramp);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            Integer highRampCount = rampAnalysis.getHighRampCount();
            costTierArr[2] = new CostTier(string7, highRampCount != null ? highRampCount.intValue() : 0, "×0.4");
            String string8 = getString(R.string.metric_rituals);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            Integer ritualCount = rampAnalysis.getRitualCount();
            costTierArr[i2] = new CostTier(string8, ritualCount != null ? ritualCount.intValue() : 0, "×0.5");
            Integer costReducerCount3 = rampAnalysis.getCostReducerCount();
            if ((costReducerCount3 != null ? costReducerCount3.intValue() : 0) > 0) {
                String string9 = getString(R.string.metric_cost_reducers_tier);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                Integer costReducerCount4 = rampAnalysis.getCostReducerCount();
                costTier = new CostTier(string9, costReducerCount4 != null ? costReducerCount4.intValue() : 0, "×0.7");
            } else {
                costTier = null;
            }
            costTierArr[4] = costTier;
            for (CostTier costTier2 : CollectionsKt.listOfNotNull((Object[]) costTierArr)) {
                LinearLayout linearLayout3 = new LinearLayout(contextRequireContext);
                linearLayout3.setOrientation(0);
                linearLayout3.setGravity(i);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams6.bottomMargin = dp(1);
                linearLayout3.setLayoutParams(layoutParams6);
                TextView textView4 = new TextView(contextRequireContext);
                textView4.setText(costTier2.getLabel());
                textView4.setTextSize(11.0f);
                textView4.setTextColor(color);
                textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                linearLayout3.addView(textView4);
                TextView textView5 = new TextView(contextRequireContext);
                textView5.setText(costTier2.getCount() + "  " + costTier2.getWeight());
                textView5.setTextSize(11.0f);
                textView5.setTextColor(color);
                textView5.setGravity(GravityCompat.END);
                linearLayout3.addView(textView5);
                linearLayout2.addView(linearLayout3);
                i = 16;
            }
            contentContainer.addView(linearLayout2);
            Double totalEffectiveRamp = rampAnalysis.getTotalEffectiveRamp();
            double dDoubleValue = totalEffectiveRamp != null ? totalEffectiveRamp.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            Integer recommendedRamp = rampAnalysis.getRecommendedRamp();
            int iIntValue = recommendedRamp != null ? recommendedRamp.intValue() : 0;
            int iScoreColor = scoreColor(dDoubleValue >= ((double) iIntValue) ? 1.0d : 0.3d);
            LinearLayout metricsContainer = detailDialogPartsCreateTestDetailDialog.getMetricsContainer();
            MetricItem[] metricItemArr = new MetricItem[i2];
            String string10 = getString(R.string.metric_mana_rocks);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            Integer manaRockCount2 = rampAnalysis.getManaRockCount();
            metricItemArr[0] = new MetricItem(string10, String.valueOf(manaRockCount2 != null ? manaRockCount2.intValue() : 0), null, 4, null);
            String string11 = getString(R.string.metric_mana_dorks);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            Integer manaDorkCount2 = rampAnalysis.getManaDorkCount();
            metricItemArr[1] = new MetricItem(string11, String.valueOf(manaDorkCount2 != null ? manaDorkCount2.intValue() : 0), null, 4, null);
            String string12 = getString(R.string.metric_total_ramp);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            metricItemArr[2] = new MetricItem(string12, str + DomExceptionUtils.SEPARATOR + iIntValue, Integer.valueOf(iScoreColor));
            addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) metricItemArr));
        }
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showTapLandsDetail$segBar$1] */
    private final void showTapLandsDetail(double scoreValue, MTIdCardManaBaseAnalysis mba) {
        char c;
        DetailDialogParts detailDialogPartsCreateTestDetailDialog = createTestDetailDialog("tap_lands", scoreValue);
        LinearLayout contentContainer = detailDialogPartsCreateTestDetailDialog.getContentContainer();
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        addInsightMessages(contentContainer, "tap_lands", mba.getInsights());
        MTIdCardTapLandAnalysis tapLandAnalysis = mba.getTapLandAnalysis();
        if (tapLandAnalysis != null) {
            final float fCoerceAtLeast = RangesKt.coerceAtLeast(tapLandAnalysis.getTotalLands() != null ? r5.intValue() : 0, 1.0f);
            Integer alwaysTappedCount = tapLandAnalysis.getAlwaysTappedCount();
            final int iIntValue = alwaysTappedCount != null ? alwaysTappedCount.intValue() : 0;
            Integer conditionallyTappedCount = tapLandAnalysis.getConditionallyTappedCount();
            final int iIntValue2 = conditionallyTappedCount != null ? conditionallyTappedCount.intValue() : 0;
            int iCoerceAtLeast = RangesKt.coerceAtLeast((((int) fCoerceAtLeast) - iIntValue) - iIntValue2, 0);
            ?? r10 = new View(contextRequireContext, iIntValue, fCoerceAtLeast, iIntValue2) { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$showTapLandsDetail$segBar$1
                final /* synthetic */ int $always;
                final /* synthetic */ int $conditional;
                final /* synthetic */ float $total;
                private final Paint alwaysP;
                private final Paint condP;
                private final Paint untapP;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(contextRequireContext);
                    this.$always = iIntValue;
                    this.$total = fCoerceAtLeast;
                    this.$conditional = iIntValue2;
                    Paint paint = new Paint(1);
                    paint.setColor(ContextCompat.getColor(contextRequireContext, R.color.error_red));
                    this.alwaysP = paint;
                    Paint paint2 = new Paint(1);
                    paint2.setColor(ContextCompat.getColor(contextRequireContext, R.color.warning_amber));
                    this.condP = paint2;
                    Paint paint3 = new Paint(1);
                    paint3.setColor(ContextCompat.getColor(contextRequireContext, R.color.positive_green));
                    this.untapP = paint3;
                }

                public final Paint getAlwaysP() {
                    return this.alwaysP;
                }

                public final Paint getCondP() {
                    return this.condP;
                }

                public final Paint getUntapP() {
                    return this.untapP;
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    float f = getResources().getDisplayMetrics().density * 4.0f;
                    float width = getWidth() * (this.$always / this.$total);
                    float width2 = getWidth() * (this.$conditional / this.$total);
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f, f, this.untapP);
                    float f2 = width2 + width;
                    if (f2 > 0.0f) {
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f2, getHeight()), f, f, this.condP);
                    }
                    if (width > 0.0f) {
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, getHeight()), f, f, this.alwaysP);
                    }
                }
            };
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(14));
            layoutParams.bottomMargin = dp(8);
            r10.setLayoutParams(layoutParams);
            contentContainer.addView((View) r10);
            List<MTIdCardTapLandEntry> alwaysTappedLands = tapLandAnalysis.getAlwaysTappedLands();
            if (alwaysTappedLands.isEmpty()) {
                c = 0;
            } else {
                TextView textView = new TextView(contextRequireContext);
                int i = R.string.detail_always_tapped_label;
                c = 0;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = alwaysTappedLands.iterator();
                while (it.hasNext()) {
                    String name = ((MTIdCardTapLandEntry) it.next()).getName();
                    if (name != null) {
                        arrayList.add(name);
                    }
                }
                textView.setText(getString(i, CollectionsKt.joinToString$default(arrayList, " - ", null, null, 0, null, null, 62, null)));
                textView.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.warning_amber));
                textView.setTextSize(12.0f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.bottomMargin = dp(4);
                textView.setLayoutParams(layoutParams2);
                contentContainer.addView(textView);
            }
            List<MTIdCardTapLandEntry> conditionallyTappedLands = tapLandAnalysis.getConditionallyTappedLands();
            if (!conditionallyTappedLands.isEmpty()) {
                TextView textView2 = new TextView(contextRequireContext);
                int i2 = R.string.detail_conditional_label;
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = conditionallyTappedLands.iterator();
                while (it2.hasNext()) {
                    String name2 = ((MTIdCardTapLandEntry) it2.next()).getName();
                    if (name2 != null) {
                        arrayList2.add(name2);
                    }
                }
                textView2.setText(getString(i2, CollectionsKt.joinToString$default(arrayList2, " - ", null, null, 0, null, null, 62, null)));
                textView2.setTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_secondary));
                textView2.setTextSize(12.0f);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                contentContainer.addView(textView2);
            }
            LinearLayout metricsContainer = detailDialogPartsCreateTestDetailDialog.getMetricsContainer();
            MetricItem[] metricItemArr = new MetricItem[3];
            String string = getString(R.string.metric_always_tapped);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            metricItemArr[c] = new MetricItem(string, String.valueOf(iIntValue), Integer.valueOf(ContextCompat.getColor(contextRequireContext, R.color.error_red)));
            String string2 = getString(R.string.metric_conditional_tapped);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            metricItemArr[1] = new MetricItem(string2, String.valueOf(iIntValue2), Integer.valueOf(ContextCompat.getColor(contextRequireContext, R.color.warning_amber)));
            String string3 = getString(R.string.metric_untapped);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            metricItemArr[2] = new MetricItem(string3, String.valueOf(iCoerceAtLeast), Integer.valueOf(ContextCompat.getColor(contextRequireContext, R.color.positive_green)));
            addMetricRow(metricsContainer, CollectionsKt.listOf((Object[]) metricItemArr));
        }
        detailDialogPartsCreateTestDetailDialog.getDialog().show();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void showTestDetailDialog(String type, double scoreValue, MTIdCardManaBaseAnalysis mba) {
        switch (type.hashCode()) {
            case -1779111579:
                if (type.equals("colorless_lands")) {
                    showColorlessLandsDetail(scoreValue, mba);
                    break;
                }
                break;
            case -841534976:
                if (type.equals("color_balance")) {
                    showColorBalanceDetail(scoreValue, mba);
                    break;
                }
                break;
            case -275746330:
                if (type.equals("commander_cast")) {
                    showCommanderCastDetail(scoreValue, mba);
                    break;
                }
                break;
            case 490366528:
                if (type.equals("pip_density")) {
                    showPipDensityDetail(scoreValue, mba);
                    break;
                }
                break;
            case 828238267:
                if (type.equals("land_count")) {
                    showLandCountDetail(scoreValue, mba);
                    break;
                }
                break;
            case 1481263180:
                if (type.equals("tap_lands")) {
                    showTapLandsDetail(scoreValue, mba);
                    break;
                }
                break;
            case 1845433469:
                if (type.equals("fetch_targets")) {
                    showFetchTargetsDetail(scoreValue, mba);
                    break;
                }
                break;
            case 1956275064:
                if (type.equals("mana_acceleration")) {
                    showRampDetail(scoreValue, mba);
                    break;
                }
                break;
        }
    }

    private final void updateChartHighlighting(BarChart chart, List<MTIdCardOpeningHandProb> probabilities, int low, int high) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<MTIdCardOpeningHandProb> list = probabilities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MTIdCardOpeningHandProb mTIdCardOpeningHandProb = (MTIdCardOpeningHandProb) it.next();
            Integer landCount = mTIdCardOpeningHandProb.getLandCount();
            float fIntValue = landCount != null ? landCount.intValue() : 0;
            Double probability = mTIdCardOpeningHandProb.getProbability();
            arrayList.add(new BarEntry(fIntValue, (float) ((probability != null ? probability.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 100.0d)));
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "");
        barDataSet.setDrawValues(true);
        barDataSet.setValueTextColor(ContextCompat.getColor(contextRequireContext, R.color.text_color));
        barDataSet.setValueTextSize(9.0f);
        barDataSet.setValueFormatter(new ValueFormatter() { // from class: com.studiolaganne.lengendarylens.DeckIDCardManaDetailFragment$updateChartHighlighting$barDataSet$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                if (value < 1.0f) {
                    return "";
                }
                return ((int) value) + "%";
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            Integer landCount2 = ((MTIdCardOpeningHandProb) it2.next()).getLandCount();
            int iIntValue = landCount2 != null ? landCount2.intValue() : 0;
            arrayList2.add(Integer.valueOf((low > iIntValue || iIntValue > high) ? ContextCompat.getColor(contextRequireContext, R.color.separator_grey) : ContextCompat.getColor(contextRequireContext, R.color.positive_green)));
        }
        barDataSet.setColors(arrayList2);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.7f);
        chart.setData(barData);
        chart.invalidate();
    }

    private final void updateRangeDisplays(List<MTIdCardOpeningHandProb> probabilities, int low, int high, TextView rangeLabel, TextView rawProbabilityValue, TextView mulliganProbabilityValue) {
        rangeLabel.setText(getString(R.string.ideal_range, Integer.valueOf(low), Integer.valueOf(high)));
        ArrayList arrayList = new ArrayList();
        for (Object obj : probabilities) {
            Integer landCount = ((MTIdCardOpeningHandProb) obj).getLandCount();
            int iIntValue = landCount != null ? landCount.intValue() : 0;
            if (low <= iIntValue && iIntValue <= high) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            Double probability = ((MTIdCardOpeningHandProb) it.next()).getProbability();
            dDoubleValue += probability != null ? probability.doubleValue() : 0.0d;
        }
        rawProbabilityValue.setText(((int) (dDoubleValue * 100.0d)) + "%");
        double d = 1.0d - dDoubleValue;
        int i = (int) ((1.0d - (d * d)) * 100.0d);
        mulliganProbabilityValue.setText(i + "%");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        mulliganProbabilityValue.setTextColor(i >= 90 ? ContextCompat.getColor(contextRequireContext, R.color.positive_green) : i >= 70 ? ContextCompat.getColor(contextRequireContext, R.color.warning_amber) : ContextCompat.getColor(contextRequireContext, R.color.error_red));
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
        return inflater.inflate(R.layout.fragment_deck_id_card_mana, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MTIdCardManaBaseAnalysis manaBaseAnalysis;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manaContentLayout);
        MTDeckIdCardResponse mTDeckIdCardResponse = this.response;
        if (mTDeckIdCardResponse == null || (manaBaseAnalysis = mTDeckIdCardResponse.getManaBaseAnalysis()) == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        buildRadarChart(linearLayout, manaBaseAnalysis);
        buildSubscoreGauges(linearLayout, manaBaseAnalysis);
        buildInsightRows(linearLayout, manaBaseAnalysis);
    }
}
