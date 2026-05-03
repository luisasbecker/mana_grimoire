package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CardEvaluationDetailHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\rH\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0006H\u0002JK\u0010*\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u00101J\"\u00102\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020/H\u0002J\u0018\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u000209H\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardEvaluationDetailHelper;", "", "<init>", "()V", "SIGNAL_TOOLTIPS", "", "", "Lkotlin/Pair;", "show", "", "activity", "Landroid/app/Activity;", "deckId", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "populateEvaluationContent", "container", "Landroid/widget/LinearLayout;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/studiolaganne/lengendarylens/MTCardExplainResponse;", "dialog", "Landroid/app/Dialog;", "buildProtectionChipRow", "Landroid/view/View;", "reason", "buildRoleList", "roles", "", "Lcom/studiolaganne/lengendarylens/MTCardRankingRole;", "roleTierColor", "tier", "withAlpha", "color", "alpha", "", "addSignalBar", "signalKey", Constants.ScionAnalytics.PARAM_LABEL, FirebaseAnalytics.Param.SCORE, "showSignalTooltip", "text", "buildStatBox", "primaryText", "secondaryText", "barValue", "isAlert", "", "factorsText", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;)Landroid/widget/LinearLayout;", "buildRedundancyFactorsText", "redundancy", "Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "isFr", "dpToPx", "dp", "res", "Landroid/content/res/Resources;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardEvaluationDetailHelper {
    public static final CardEvaluationDetailHelper INSTANCE = new CardEvaluationDetailHelper();
    private static final Map<String, Pair<String, String>> SIGNAL_TOOLTIPS = MapsKt.mapOf(TuplesKt.to("deckFit", new Pair("Measures how often this card appears alongside the other cards in your deck across thousands of decklists. A high score means decks like yours typically include this card.", "Mesure la fréquence à laquelle cette carte apparaît aux côtés des autres cartes de votre deck dans des milliers de listes. Un score élevé signifie que les decks similaires au vôtre incluent généralement cette carte.")), TuplesKt.to("themeAlignment", new Pair("Measures how closely this card aligns with the themes detected in your deck. Utility cards (ramp, removal, draw) are scored differently since they support any strategy.", "Mesure à quel point cette carte s'aligne avec les thèmes détectés dans votre deck. Les cartes utilitaires (rampe, removal, pioche) sont évaluées différemment car elles soutiennent toute stratégie.")), TuplesKt.to("roleContribution", new Pair("Evaluates the structural roles this card fills (ramp, removal, draw, etc.) and how much your deck needs them. Cards filling a role your deck is lacking score higher.", "Évalue les rôles structurels que cette carte remplit (rampe, removal, pioche, etc.) et à quel point votre deck en a besoin. Les cartes remplissant un rôle manquant obtiennent un score plus élevé.")), TuplesKt.to("cardPower", new Pair("Platform-wide card power derived from how over-represented this card is in high-power Commander decks. Positive means it shows up more in top lists than baseline.", "Puissance de la carte, dérivée de sa sur-représentation dans les decks Commander haut power. Positif signifie qu'elle apparaît plus souvent dans le top que la moyenne.")));
    public static final int $stable = 8;

    private CardEvaluationDetailHelper() {
    }

    private final void addSignalBar(final Activity activity, LinearLayout container, String signalKey, String label, final int score) {
        Typeface font;
        String first;
        Resources resources = activity.getResources();
        Activity activity2 = activity;
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        Intrinsics.checkNotNull(resources);
        linearLayout.setPadding(0, 0, 0, cardEvaluationDetailHelper.dpToPx(4, resources));
        TextView textView = new TextView(activity2);
        textView.setText(label);
        textView.setTextSize(14.0f);
        textView.setTextColor(-859321654);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(activity2);
        textView2.setText("\uf05a");
        try {
            font = resources.getFont(R.font.fa6solid);
        } catch (Exception unused) {
            font = Typeface.DEFAULT;
        }
        textView2.setTypeface(font);
        textView2.setTextSize(16.0f);
        textView2.setTextColor(-1597519158);
        textView2.setPadding(INSTANCE.dpToPx(6, resources), 0, 0, 0);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(new View(activity2), new LinearLayout.LayoutParams(0, 0, 1.0f));
        TextView textView3 = new TextView(activity2);
        textView3.setText(String.valueOf(score));
        textView3.setTextSize(13.0f);
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextColor(-1);
        linearLayout.addView(textView3, new LinearLayout.LayoutParams(-2, -2));
        container.addView(linearLayout);
        boolean zAreEqual = Intrinsics.areEqual(new PreferencesManager(activity2).getDeviceLanguage(), "fr");
        Pair<String, String> pair = SIGNAL_TOOLTIPS.get(signalKey);
        final String str = null;
        if (zAreEqual) {
            if (pair != null) {
                first = pair.getSecond();
                str = first;
            }
        } else if (pair != null) {
            first = pair.getFirst();
            str = first;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardEvaluationDetailHelper.addSignalBar$lambda$4(activity, str, view);
            }
        });
        final FrameLayout frameLayout = new FrameLayout(activity2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(r4.dpToPx(4, resources));
        gradientDrawable.setColor(268435455);
        frameLayout.setBackground(gradientDrawable);
        container.addView(frameLayout, new LinearLayout.LayoutParams(-1, dpToPx(8, resources)));
        int iNeutralScoreColor = MTRankingHelpers.INSTANCE.neutralScoreColor(score);
        final View view = new View(activity2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(r4.dpToPx(4, resources));
        gradientDrawable2.setColor(iNeutralScoreColor);
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(0, -1));
        frameLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FrameLayout frameLayout2 = frameLayout;
                int i = score;
                view.setLayoutParams(new FrameLayout.LayoutParams((int) ((frameLayout2.getWidth() * RangesKt.coerceIn(i, 0, 100)) / 100.0f), -1));
            }
        });
    }

    static final void addSignalBar$lambda$4(Activity activity, String str, View view) {
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        if (str == null) {
            str = "";
        }
        cardEvaluationDetailHelper.showSignalTooltip(activity, str);
    }

    private final View buildProtectionChipRow(Activity activity, String reason) {
        Resources resources = activity.getResources();
        int protectionAccent = MTRankingHelpers.INSTANCE.getProtectionAccent();
        Activity activity2 = activity;
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(activity2);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        Intrinsics.checkNotNull(resources);
        gradientDrawable.setCornerRadius(cardEvaluationDetailHelper.dpToPx(12, resources));
        gradientDrawable.setColor(cardEvaluationDetailHelper.withAlpha(protectionAccent, 0.12f));
        gradientDrawable.setStroke(cardEvaluationDetailHelper.dpToPx(1, resources), cardEvaluationDetailHelper.withAlpha(protectionAccent, 0.4f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setPadding(cardEvaluationDetailHelper.dpToPx(8, resources), cardEvaluationDetailHelper.dpToPx(4, resources), cardEvaluationDetailHelper.dpToPx(10, resources), cardEvaluationDetailHelper.dpToPx(4, resources));
        TextView textView = new TextView(activity2);
        textView.setText(MTRankingHelpers.INSTANCE.protectionIconGlyph(reason));
        Typeface font = ResourcesCompat.getFont(activity2, R.font.fa6solid);
        if (font == null) {
            font = Typeface.DEFAULT;
        }
        textView.setTypeface(font);
        textView.setTextSize(12.0f);
        textView.setTextColor(protectionAccent);
        linearLayout2.addView(textView);
        int identifier = activity.getResources().getIdentifier("eval_protection_" + reason, TypedValues.Custom.S_STRING, activity.getPackageName());
        TextView textView2 = new TextView(activity2);
        textView2.setText(identifier != 0 ? activity.getString(identifier) : reason);
        Typeface font2 = ResourcesCompat.getFont(activity2, R.font.be_vietnam_pro_semibold);
        if (font2 == null) {
            font2 = Typeface.DEFAULT_BOLD;
        }
        textView2.setTypeface(font2);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(protectionAccent);
        textView2.setPadding(cardEvaluationDetailHelper.dpToPx(6, resources), 0, 0, 0);
        linearLayout2.addView(textView2);
        LinearLayout linearLayout3 = new LinearLayout(activity2);
        linearLayout3.setOrientation(0);
        linearLayout3.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(linearLayout3);
        int identifier2 = activity.getResources().getIdentifier("eval_protection_explain_" + reason, TypedValues.Custom.S_STRING, activity.getPackageName());
        if (identifier2 != 0) {
            TextView textView3 = new TextView(activity2);
            textView3.setText(activity.getString(identifier2));
            textView3.setTextSize(11.0f);
            textView3.setTextColor(-1933063478);
            textView3.setPadding(0, cardEvaluationDetailHelper.dpToPx(6, resources), 0, 0);
            linearLayout.addView(textView3);
        }
        return linearLayout;
    }

    private final String buildRedundancyFactorsText(Activity activity, MTCardRankingRedundancy redundancy, boolean isFr) {
        String str;
        List<MTCardRankingRedundancyFactor> factors = redundancy.getFactors();
        if (factors.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MTCardRankingRedundancyFactor mTCardRankingRedundancyFactor : factors) {
            if (!Intrinsics.areEqual(mTCardRankingRedundancyFactor.getType(), "role_excess") || mTCardRankingRedundancyFactor.getId() == null) {
                str = null;
            } else {
                String strRoleLabel = MTRankingHelpers.INSTANCE.roleLabel(activity, mTCardRankingRedundancyFactor.getId());
                str = isFr ? mTCardRankingRedundancyFactor.getCount() + " cartes " + strRoleLabel + " (min : " + mTCardRankingRedundancyFactor.getThreshold() + ")" : mTCardRankingRedundancyFactor.getCount() + " " + strRoleLabel + " cards (min: " + mTCardRankingRedundancyFactor.getThreshold() + ")";
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
    }

    private final View buildRoleList(Activity activity, List<MTCardRankingRole> roles) {
        Resources resources = activity.getResources();
        Activity activity2 = activity;
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(activity2);
        String string = activity.getString(R.string.eval_signal_role_contribution);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(11.0f);
        textView.setTextColor(-1714959670);
        textView.setLetterSpacing(0.08f);
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        Intrinsics.checkNotNull(resources);
        int i = 2;
        int i2 = 0;
        textView.setPadding(0, 0, 0, cardEvaluationDetailHelper.dpToPx(2, resources));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(activity2);
        textView2.setText(activity.getString(R.string.eval_role_coverage_subtitle));
        textView2.setTextSize(10.0f);
        textView2.setTextColor(-1714959670);
        textView2.setPadding(0, 0, 0, cardEvaluationDetailHelper.dpToPx(6, resources));
        linearLayout.addView(textView2);
        for (MTCardRankingRole mTCardRankingRole : roles) {
            LinearLayout linearLayout2 = new LinearLayout(activity2);
            linearLayout2.setOrientation(i2);
            linearLayout2.setGravity(16);
            CardEvaluationDetailHelper cardEvaluationDetailHelper2 = INSTANCE;
            linearLayout2.setPadding(i2, cardEvaluationDetailHelper2.dpToPx(i, resources), i2, cardEvaluationDetailHelper2.dpToPx(i, resources));
            int iRoleTierColor = roleTierColor(mTCardRankingRole.getDeckTier());
            View view = new View(activity2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(cardEvaluationDetailHelper2.dpToPx(3, resources));
            gradientDrawable.setColor(iRoleTierColor);
            view.setBackground(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cardEvaluationDetailHelper2.dpToPx(6, resources), cardEvaluationDetailHelper2.dpToPx(6, resources));
            layoutParams.setMarginEnd(cardEvaluationDetailHelper2.dpToPx(8, resources));
            view.setLayoutParams(layoutParams);
            linearLayout2.addView(view);
            TextView textView3 = new TextView(activity2);
            String strRoleLabel = MTRankingHelpers.INSTANCE.roleLabel(activity2, mTCardRankingRole.getId());
            String string2 = activity.getString(R.string.eval_role_in_deck, new Object[]{Integer.valueOf(mTCardRankingRole.getDeckCount())});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            textView3.setText(strRoleLabel + " " + string2);
            textView3.setTextSize(12.0f);
            textView3.setTextColor(-641217846);
            linearLayout2.addView(textView3);
            linearLayout2.addView(new View(activity2), new LinearLayout.LayoutParams(0, 1, 1.0f));
            TextView textView4 = new TextView(activity2);
            textView4.setText(MTRankingHelpers.INSTANCE.roleTierLabel(activity2, mTCardRankingRole.getDeckTier()));
            textView4.setTextSize(11.0f);
            textView4.setTextColor(iRoleTierColor);
            linearLayout2.addView(textView4);
            linearLayout.addView(linearLayout2);
            i2 = 0;
            i = 2;
        }
        return linearLayout;
    }

    private final LinearLayout buildStatBox(Activity activity, String label, String primaryText, String secondaryText, final Integer barValue, boolean isAlert, String factorsText) {
        Resources resources = activity.getResources();
        int color = Color.parseColor("#E85858");
        int iArgb = isAlert ? Color.argb(38, 232, 88, 88) : 449301194;
        int iArgb2 = isAlert ? Color.argb(15, 232, 88, 88) : 100663295;
        Activity activity2 = activity;
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        Intrinsics.checkNotNull(resources);
        gradientDrawable.setCornerRadius(cardEvaluationDetailHelper.dpToPx(8, resources));
        gradientDrawable.setStroke(cardEvaluationDetailHelper.dpToPx(1, resources), iArgb);
        gradientDrawable.setColor(iArgb2);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(cardEvaluationDetailHelper.dpToPx(10, resources), cardEvaluationDetailHelper.dpToPx(8, resources), cardEvaluationDetailHelper.dpToPx(10, resources), cardEvaluationDetailHelper.dpToPx(8, resources));
        TextView textView = new TextView(activity2);
        textView.setText(label);
        textView.setTextSize(11.0f);
        textView.setTextColor(isAlert ? Color.argb(204, 232, 88, 88) : -1714959670);
        textView.setPadding(0, 0, 0, cardEvaluationDetailHelper.dpToPx(4, resources));
        linearLayout.addView(textView);
        if (barValue != null) {
            LinearLayout linearLayout2 = new LinearLayout(activity2);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            TextView textView2 = new TextView(activity2);
            textView2.setText(barValue + "/100");
            textView2.setTextSize(12.0f);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setTextColor(isAlert ? color : -2134390070);
            linearLayout2.addView(textView2);
            linearLayout.addView(linearLayout2);
            final FrameLayout frameLayout = new FrameLayout(activity2);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(cardEvaluationDetailHelper.dpToPx(3, resources));
            gradientDrawable2.setColor(268435455);
            frameLayout.setBackground(gradientDrawable2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper.dpToPx(6, resources));
            layoutParams.topMargin = cardEvaluationDetailHelper.dpToPx(4, resources);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(frameLayout, layoutParams);
            final View view = new View(activity2);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius(cardEvaluationDetailHelper.dpToPx(3, resources));
            if (!isAlert) {
                color = 1304939210;
            }
            gradientDrawable3.setColor(color);
            view.setBackground(gradientDrawable3);
            frameLayout.addView(view, new FrameLayout.LayoutParams(0, -1));
            frameLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CardEvaluationDetailHelper.buildStatBox$lambda$0$6(view, frameLayout, barValue);
                }
            });
        } else {
            LinearLayout linearLayout3 = new LinearLayout(activity2);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(80);
            TextView textView3 = new TextView(activity2);
            textView3.setText(primaryText);
            textView3.setTextSize(18.0f);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            textView3.setTextColor(-1);
            linearLayout3.addView(textView3);
            if (secondaryText != null) {
                TextView textView4 = new TextView(activity2);
                textView4.setText(" " + secondaryText);
                textView4.setTextSize(10.0f);
                textView4.setTextColor(-1714959670);
                textView4.setPadding(cardEvaluationDetailHelper.dpToPx(3, resources), 0, 0, cardEvaluationDetailHelper.dpToPx(2, resources));
                linearLayout3.addView(textView4);
            }
            linearLayout.addView(linearLayout3);
        }
        if (factorsText != null) {
            TextView textView5 = new TextView(activity2);
            textView5.setText(factorsText);
            textView5.setTextSize(10.0f);
            textView5.setTextColor(-1597519158);
            textView5.setPadding(0, cardEvaluationDetailHelper.dpToPx(4, resources), 0, 0);
            linearLayout.addView(textView5);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildStatBox$lambda$0$6(View view, FrameLayout frameLayout, Integer num) {
        view.setLayoutParams(new FrameLayout.LayoutParams((int) ((frameLayout.getWidth() * RangesKt.coerceIn(num.intValue(), 0, 100)) / 100.0f), -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dpToPx(int dp, Resources res) {
        return (int) (dp * res.getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x036f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void populateEvaluationContent(Activity activity, LinearLayout container, MTCardExplainResponse data, Dialog dialog) {
        int i;
        CardEvaluationDetailHelper cardEvaluationDetailHelper;
        LinearLayout linearLayout;
        String str;
        boolean z;
        LinearLayout linearLayout2;
        CardEvaluationDetailHelper cardEvaluationDetailHelper2;
        char c;
        boolean z2;
        float f;
        int i2;
        String str2;
        CardEvaluationDetailHelper cardEvaluationDetailHelper3;
        List<MTCardRankingRole> listEmptyList;
        String label;
        int i3;
        String strTrimEnd;
        Resources resources = activity.getResources();
        Activity activity2 = activity;
        boolean zAreEqual = Intrinsics.areEqual(new PreferencesManager(activity2).getDeviceLanguage(), "fr");
        String protectionReason = data.getProtectionReason();
        String str3 = (protectionReason == null || protectionReason.length() <= 0) ? null : protectionReason;
        if (str3 != null) {
            container.addView(buildProtectionChipRow(activity, str3));
            View view = new View(activity2);
            CardEvaluationDetailHelper cardEvaluationDetailHelper4 = INSTANCE;
            Intrinsics.checkNotNull(resources);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper4.dpToPx(10, resources)));
            container.addView(view);
        }
        Double popularityPct = data.getPopularityPct();
        if (popularityPct != null) {
            double dDoubleValue = popularityPct.doubleValue();
            String popularityTier = data.getPopularityTier();
            if (popularityTier != null) {
                i3 = 0;
                int identifier = activity.getResources().getIdentifier("eval_popularity_tier_" + popularityTier, TypedValues.Custom.S_STRING, activity.getPackageName());
                if (identifier != 0) {
                    popularityTier = activity.getString(identifier);
                }
                if (popularityTier == null) {
                }
                if (dDoubleValue % 1.0d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    strTrimEnd = String.format("%.0f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(strTrimEnd, "format(...)");
                } else {
                    String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    char[] cArr = new char[1];
                    cArr[i3] = '0';
                    strTrimEnd = StringsKt.trimEnd(str4, cArr);
                }
                TextView textView = new TextView(activity2);
                textView.setText(activity.getString(R.string.eval_popularity_line, new Object[]{strTrimEnd, popularityTier}));
                textView.setTextSize(12.0f);
                textView.setTextColor(-1496855862);
                CardEvaluationDetailHelper cardEvaluationDetailHelper5 = INSTANCE;
                Intrinsics.checkNotNull(resources);
                i = i3;
                textView.setPadding(i, i, i, cardEvaluationDetailHelper5.dpToPx(12, resources));
                container.addView(textView);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } else {
                i3 = 0;
            }
            popularityTier = activity.getString(R.string.eval_popularity_tier_fringe);
            Intrinsics.checkNotNullExpressionValue(popularityTier, "getString(...)");
            if (dDoubleValue % 1.0d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            }
            TextView textView2 = new TextView(activity2);
            textView2.setText(activity.getString(R.string.eval_popularity_line, new Object[]{strTrimEnd, popularityTier}));
            textView2.setTextSize(12.0f);
            textView2.setTextColor(-1496855862);
            CardEvaluationDetailHelper cardEvaluationDetailHelper52 = INSTANCE;
            Intrinsics.checkNotNull(resources);
            i = i3;
            textView2.setPadding(i, i, i, cardEvaluationDetailHelper52.dpToPx(12, resources));
            container.addView(textView2);
            Unit unit3 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        } else {
            i = 0;
        }
        MTCardRankingSignals signals = data.getSignals();
        if (signals != null) {
            String string = activity.getString(R.string.eval_signal_deck_fit);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            MTCardRankingSignal deckFit = signals.getDeckFit();
            int i4 = i;
            str = "getString(...)";
            addSignalBar(activity, container, "deckFit", string, deckFit != null ? deckFit.getScore() : i);
            MTCardRankingSignal deckFit2 = signals.getDeckFit();
            if (deckFit2 != null && (label = deckFit2.getLabel()) != null) {
                String string2 = Intrinsics.areEqual(label, "high") ? activity.getString(R.string.eval_deck_fit_high) : Intrinsics.areEqual(label, "moderate") ? activity.getString(R.string.eval_deck_fit_moderate) : activity.getString(R.string.eval_deck_fit_low);
                Intrinsics.checkNotNull(string2);
                TextView textView3 = new TextView(activity2);
                textView3.setText(string2);
                textView3.setTextSize(12.0f);
                textView3.setTextColor(-1429746998);
                CardEvaluationDetailHelper cardEvaluationDetailHelper6 = INSTANCE;
                Intrinsics.checkNotNull(resources);
                textView3.setPadding(i4, cardEvaluationDetailHelper6.dpToPx(6, resources), i4, cardEvaluationDetailHelper6.dpToPx(8, resources));
                container.addView(textView3);
                Unit unit4 = Unit.INSTANCE;
                Unit unit5 = Unit.INSTANCE;
            }
            MTCardRankingThemeAlignment themeAlignment = signals.getThemeAlignment();
            if (themeAlignment != null && !Intrinsics.areEqual(themeAlignment.getMode(), "commander")) {
                String string3 = activity.getString(R.string.eval_signal_theme_alignment);
                Intrinsics.checkNotNullExpressionValue(string3, str);
                addSignalBar(activity, container, "themeAlignment", string3, themeAlignment.getScore());
                String string4 = Intrinsics.areEqual(themeAlignment.getMode(), "semantic_fallback") ? activity.getString(R.string.eval_theme_mode_fallback) : themeAlignment.isUtilityCard() ? activity.getString(R.string.eval_utility_note) : null;
                if (string4 != null) {
                    TextView textView4 = new TextView(activity2);
                    textView4.setText(string4);
                    textView4.setTextSize(11.0f);
                    textView4.setTextColor(-2134390070);
                    CardEvaluationDetailHelper cardEvaluationDetailHelper7 = INSTANCE;
                    Intrinsics.checkNotNull(resources);
                    textView4.setPadding(0, cardEvaluationDetailHelper7.dpToPx(6, resources), 0, cardEvaluationDetailHelper7.dpToPx(8, resources));
                    container.addView(textView4);
                } else {
                    View view2 = new View(activity2);
                    CardEvaluationDetailHelper cardEvaluationDetailHelper8 = INSTANCE;
                    Intrinsics.checkNotNull(resources);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper8.dpToPx(8, resources)));
                    container.addView(view2);
                }
            } else if (signals.getCommanderAlignment() != null) {
                MTCardRankingCommanderAlignment commanderAlignment = signals.getCommanderAlignment();
                String string5 = activity.getString(R.string.eval_signal_commander_alignment);
                Intrinsics.checkNotNullExpressionValue(string5, str);
                addSignalBar(activity, container, "themeAlignment", string5, commanderAlignment.getScore());
                if (commanderAlignment.isUtilityCard()) {
                    TextView textView5 = new TextView(activity2);
                    textView5.setText(activity.getString(R.string.eval_utility_note));
                    textView5.setTextSize(11.0f);
                    textView5.setTextColor(-2134390070);
                    CardEvaluationDetailHelper cardEvaluationDetailHelper9 = INSTANCE;
                    Intrinsics.checkNotNull(resources);
                    textView5.setPadding(0, cardEvaluationDetailHelper9.dpToPx(6, resources), 0, cardEvaluationDetailHelper9.dpToPx(8, resources));
                    container.addView(textView5);
                } else {
                    View view3 = new View(activity2);
                    CardEvaluationDetailHelper cardEvaluationDetailHelper10 = INSTANCE;
                    Intrinsics.checkNotNull(resources);
                    view3.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper10.dpToPx(8, resources)));
                    container.addView(view3);
                }
            }
            String string6 = activity.getString(R.string.eval_signal_role_contribution);
            Intrinsics.checkNotNullExpressionValue(string6, str);
            MTCardRankingRoleContribution roleContribution = signals.getRoleContribution();
            addSignalBar(activity, container, "roleContribution", string6, roleContribution != null ? roleContribution.getScore() : 0);
            cardEvaluationDetailHelper = this;
            View view4 = new View(activity2);
            CardEvaluationDetailHelper cardEvaluationDetailHelper11 = INSTANCE;
            Intrinsics.checkNotNull(resources);
            view4.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper11.dpToPx(8, resources)));
            container.addView(view4);
            MTCardRankingCardPower cardPower = signals.getCardPower();
            if (cardPower != null) {
                String string7 = activity.getString(R.string.eval_signal_card_power);
                Intrinsics.checkNotNullExpressionValue(string7, str);
                int score = cardPower.getScore();
                cardEvaluationDetailHelper3 = cardEvaluationDetailHelper11;
                cardEvaluationDetailHelper3.addSignalBar(activity, container, "cardPower", string7, score);
                linearLayout = container;
                View view5 = new View(activity2);
                view5.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper3.dpToPx(12, resources)));
                linearLayout.addView(view5);
                Unit unit6 = Unit.INSTANCE;
                Unit unit7 = Unit.INSTANCE;
            } else {
                linearLayout = container;
                cardEvaluationDetailHelper3 = cardEvaluationDetailHelper11;
            }
            MTCardRankingRoleContribution roleContribution2 = signals.getRoleContribution();
            if (roleContribution2 == null || (listEmptyList = roleContribution2.getRoles()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                linearLayout.addView(cardEvaluationDetailHelper.buildRoleList(activity, listEmptyList));
                View view6 = new View(activity2);
                view6.setLayoutParams(new LinearLayout.LayoutParams(-1, cardEvaluationDetailHelper3.dpToPx(12, resources)));
                linearLayout.addView(view6);
            }
        } else {
            cardEvaluationDetailHelper = this;
            linearLayout = container;
            str = "getString(...)";
        }
        if (str3 != null) {
            z = false;
        } else {
            MTCardRankingRedundancy redundancy = data.getRedundancy();
            if ((redundancy != null ? redundancy.getScore() : 0) > 0) {
                z = true;
            }
        }
        boolean z3 = data.getInclusionRate() != null;
        boolean z4 = data.getCmcSlot() != null;
        if (z || z3 || z4) {
            LinearLayout linearLayout3 = new LinearLayout(activity2);
            linearLayout3.setOrientation(0);
            CardEvaluationDetailHelper cardEvaluationDetailHelper12 = INSTANCE;
            Intrinsics.checkNotNull(resources);
            linearLayout3.setPadding(0, 0, 0, cardEvaluationDetailHelper12.dpToPx(12, resources));
            if (z) {
                MTCardRankingRedundancy redundancy2 = data.getRedundancy();
                Intrinsics.checkNotNull(redundancy2);
                String string8 = activity.getString(R.string.eval_redundancy);
                Intrinsics.checkNotNullExpressionValue(string8, str);
                String str5 = redundancy2.getScore() + "/100";
                Integer numValueOf = Integer.valueOf(redundancy2.getScore());
                boolean zIsRedundant = redundancy2.isRedundant();
                String strBuildRedundancyFactorsText = cardEvaluationDetailHelper.buildRedundancyFactorsText(activity, redundancy2, zAreEqual);
                cardEvaluationDetailHelper2 = cardEvaluationDetailHelper12;
                i2 = -2;
                CardEvaluationDetailHelper cardEvaluationDetailHelper13 = cardEvaluationDetailHelper;
                linearLayout2 = linearLayout3;
                z2 = zAreEqual;
                f = 1.0f;
                LinearLayout linearLayoutBuildStatBox = cardEvaluationDetailHelper13.buildStatBox(activity, string8, str5, null, numValueOf, zIsRedundant, strBuildRedundancyFactorsText);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                c = 4;
                layoutParams.setMarginEnd(cardEvaluationDetailHelper2.dpToPx(4, resources));
                Unit unit8 = Unit.INSTANCE;
                linearLayout2.addView(linearLayoutBuildStatBox, layoutParams);
            } else {
                linearLayout2 = linearLayout3;
                cardEvaluationDetailHelper2 = cardEvaluationDetailHelper12;
                c = 4;
                z2 = zAreEqual;
                f = 1.0f;
                i2 = -2;
            }
            if (z3) {
                String string9 = activity.getString(R.string.eval_of_commander_decks);
                Intrinsics.checkNotNullExpressionValue(string9, str);
                Integer totalCommanderDecks = data.getTotalCommanderDecks();
                String str6 = totalCommanderDecks != null ? totalCommanderDecks.intValue() + " " + activity.getString(R.string.eval_decks_sampled) : null;
                String string10 = activity.getString(R.string.eval_popularity);
                Intrinsics.checkNotNullExpressionValue(string10, str);
                str2 = " ";
                LinearLayout linearLayoutBuildStatBox2 = buildStatBox(activity, string10, ((int) data.getInclusionRate().doubleValue()) + "%", string9, null, false, str6);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, i2, f);
                c = 4;
                layoutParams2.setMarginStart(z ? cardEvaluationDetailHelper2.dpToPx(4, resources) : 0);
                layoutParams2.setMarginEnd(z4 ? cardEvaluationDetailHelper2.dpToPx(4, resources) : 0);
                Unit unit9 = Unit.INSTANCE;
                linearLayout2.addView(linearLayoutBuildStatBox2, layoutParams2);
            } else {
                str2 = " ";
            }
            if (z4) {
                MTCardRankingCmcSlot cmcSlot = data.getCmcSlot();
                Intrinsics.checkNotNull(cmcSlot);
                String strValueOf = cmcSlot.getCmc() >= 7 ? "7+" : String.valueOf(cmcSlot.getCmc());
                String string11 = activity.getString(R.string.eval_mana_cost);
                Intrinsics.checkNotNullExpressionValue(string11, str);
                LinearLayout linearLayoutBuildStatBox3 = buildStatBox(activity, string11, strValueOf, "CMC", null, false, cmcSlot.getCount() + str2 + activity.getString(R.string.eval_cards_at_cost));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, i2, f);
                layoutParams3.setMarginStart(cardEvaluationDetailHelper2.dpToPx(4, resources));
                Unit unit10 = Unit.INSTANCE;
                linearLayout2.addView(linearLayoutBuildStatBox3, layoutParams3);
            }
            linearLayout.addView(linearLayout2);
        } else {
            z2 = zAreEqual;
            f = 1.0f;
        }
        String rationale_fr = z2 ? data.getRationale_fr() : data.getRationale_en();
        if (rationale_fr == null || StringsKt.isBlank(rationale_fr)) {
            return;
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) rationale_fr, new String[]{"\n"}, false, 0, 6, (Object) null), "\n\n", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CardEvaluationDetailHelper.populateEvaluationContent$lambda$16((String) obj);
            }
        }, 30, null);
        LinearLayout linearLayout4 = new LinearLayout(activity2);
        linearLayout4.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        CardEvaluationDetailHelper cardEvaluationDetailHelper14 = INSTANCE;
        Intrinsics.checkNotNull(resources);
        gradientDrawable.setCornerRadius(cardEvaluationDetailHelper14.dpToPx(8, resources));
        gradientDrawable.setStroke(cardEvaluationDetailHelper14.dpToPx(1, resources), 449301194);
        gradientDrawable.setColor(150994943);
        linearLayout4.setBackground(gradientDrawable);
        linearLayout4.setPadding(cardEvaluationDetailHelper14.dpToPx(12, resources), cardEvaluationDetailHelper14.dpToPx(10, resources), cardEvaluationDetailHelper14.dpToPx(12, resources), cardEvaluationDetailHelper14.dpToPx(12, resources));
        TextView textView6 = new TextView(activity2);
        String string12 = activity.getString(R.string.eval_analysis);
        Intrinsics.checkNotNullExpressionValue(string12, str);
        String upperCase = string12.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView6.setText(upperCase);
        textView6.setTextSize(11.0f);
        textView6.setTypeface(Typeface.DEFAULT_BOLD);
        textView6.setTextColor(-1714959670);
        textView6.setLetterSpacing(0.08f);
        textView6.setPadding(0, 0, 0, cardEvaluationDetailHelper14.dpToPx(6, resources));
        linearLayout4.addView(textView6);
        TextView textView7 = new TextView(activity2);
        textView7.setText(strJoinToString$default);
        textView7.setTextSize(13.0f);
        textView7.setTextColor(-859321654);
        textView7.setLineSpacing(cardEvaluationDetailHelper14.dpToPx(3, resources), f);
        linearLayout4.addView(textView7);
        linearLayout.addView(linearLayout4);
    }

    static final CharSequence populateEvaluationContent$lambda$16(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final int roleTierColor(String tier) {
        if (tier != null) {
            switch (tier.hashCode()) {
                case -1190549876:
                    if (tier.equals("adequate")) {
                        return Color.parseColor("#8B9DAF");
                    }
                    break;
                case -736186929:
                    if (tier.equals("weakness")) {
                        return Color.parseColor("#E85858");
                    }
                    break;
                case 557191019:
                    if (tier.equals("caution")) {
                        return Color.parseColor("#ED9A57");
                    }
                    break;
                case 1791316033:
                    if (tier.equals("strength")) {
                        return Color.parseColor("#5FB7A8");
                    }
                    break;
            }
        }
        return Color.parseColor("#6B7280");
    }

    static final void show$lambda$1(View view) {
    }

    static final void show$lambda$3(View view, int i) {
        if (view.getHeight() > i) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            view.setLayoutParams(layoutParams2);
        }
    }

    static final Unit show$lambda$4(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showSignalTooltip(Activity activity, String text) {
        Resources resources = activity.getResources();
        Activity activity2 = activity;
        final Dialog dialog = new Dialog(activity2, android.R.style.Theme.Translucent.NoTitleBar);
        FrameLayout frameLayout = new FrameLayout(activity2);
        frameLayout.setBackgroundColor(1711276032);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView textView = new TextView(activity2);
        textView.setText(text);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1278752054);
        CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
        Intrinsics.checkNotNull(resources);
        textView.setLineSpacing(cardEvaluationDetailHelper.dpToPx(2, resources), 1.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(cardEvaluationDetailHelper.dpToPx(10, resources));
        gradientDrawable.setStroke(cardEvaluationDetailHelper.dpToPx(1, resources), Color.parseColor("#ED9A57"));
        gradientDrawable.setColor(-16777216);
        textView.setBackground(gradientDrawable);
        textView.setPadding(cardEvaluationDetailHelper.dpToPx(14, resources), cardEvaluationDetailHelper.dpToPx(12, resources), cardEvaluationDetailHelper.dpToPx(14, resources), cardEvaluationDetailHelper.dpToPx(12, resources));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardEvaluationDetailHelper.showSignalTooltip$lambda$2(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (resources.getDisplayMetrics().widthPixels * 0.8f), -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(textView, layoutParams);
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        dialog.show();
    }

    static final void showSignalTooltip$lambda$2(View view) {
    }

    private final int withAlpha(int color, float alpha) {
        return Color.argb((int) (RangesKt.coerceIn(alpha, 0.0f, 1.0f) * 255.0f), Color.red(color), Color.green(color), Color.blue(color));
    }

    public final void show(final Activity activity, int deckId, MTFullCard card) {
        String oracleid;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(card, "card");
        if (deckId > 0 && (oracleid = card.getOracleid()) != null) {
            Activity activity2 = activity;
            final Dialog dialog = new Dialog(activity2, android.R.style.Theme.Translucent.NoTitleBar);
            FrameLayout frameLayout = new FrameLayout(activity2);
            frameLayout.setBackgroundColor(-1728053248);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            final View viewInflate = LayoutInflater.from(activity2).inflate(R.layout.popup_card_evaluation_detail, (ViewGroup) null);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CardEvaluationDetailHelper.show$lambda$1(view);
                }
            });
            final Resources resources = activity.getResources();
            final int i = (int) (resources.getDisplayMetrics().heightPixels * 0.85f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (resources.getDisplayMetrics().widthPixels * 0.95f), -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(viewInflate, layoutParams);
            viewInflate.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    CardEvaluationDetailHelper.show$lambda$3(viewInflate, i);
                }
            });
            View viewFindViewById = viewInflate.findViewById(R.id.popupVerdictBadge);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            final TextView textView = (TextView) viewFindViewById;
            View viewFindViewById2 = viewInflate.findViewById(R.id.popupTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView2 = (TextView) viewFindViewById2;
            View viewFindViewById3 = viewInflate.findViewById(R.id.popupCloseButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            ImageView imageView = (ImageView) viewFindViewById3;
            View viewFindViewById4 = viewInflate.findViewById(R.id.contentContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            final LinearLayout linearLayout = (LinearLayout) viewFindViewById4;
            String name = card.getName();
            if (name == null) {
                name = "";
            }
            textView2.setText(name);
            ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardEvaluationDetailHelper.show$lambda$4(dialog);
                }
            });
            dialog.setContentView(frameLayout);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
            }
            TextView textView3 = new TextView(activity2);
            textView3.setText(activity.getString(R.string.eval_loading));
            textView3.setTextColor(-1714959670);
            textView3.setTextSize(13.0f);
            textView3.setGravity(17);
            CardEvaluationDetailHelper cardEvaluationDetailHelper = INSTANCE;
            Intrinsics.checkNotNull(resources);
            textView3.setPadding(0, cardEvaluationDetailHelper.dpToPx(24, resources), 0, cardEvaluationDetailHelper.dpToPx(24, resources));
            linearLayout.addView(textView3);
            dialog.show();
            MTUser currentUser = new PreferencesManager(activity2).getCurrentUser();
            MTApiKt.getMtApi().explainCard(deckId, oracleid, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new Callback<MTCardExplainResponse>() { // from class: com.studiolaganne.lengendarylens.CardEvaluationDetailHelper.show.5
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardExplainResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (activity.isFinishing()) {
                        return;
                    }
                    linearLayout.removeAllViews();
                    LinearLayout linearLayout2 = linearLayout;
                    TextView textView4 = new TextView(activity);
                    Activity activity3 = activity;
                    Resources resources2 = resources;
                    textView4.setText(activity3.getString(R.string.mythic_coming_soon));
                    textView4.setTextColor(-1714959670);
                    textView4.setTextSize(13.0f);
                    textView4.setGravity(17);
                    CardEvaluationDetailHelper cardEvaluationDetailHelper2 = CardEvaluationDetailHelper.INSTANCE;
                    Intrinsics.checkNotNull(resources2);
                    textView4.setPadding(0, cardEvaluationDetailHelper2.dpToPx(24, resources2), 0, CardEvaluationDetailHelper.INSTANCE.dpToPx(24, resources2));
                    linearLayout2.addView(textView4);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardExplainResponse> call, Response<MTCardExplainResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (activity.isFinishing()) {
                        return;
                    }
                    linearLayout.removeAllViews();
                    MTCardExplainResponse mTCardExplainResponseBody = response.body();
                    if (!response.isSuccessful() || mTCardExplainResponseBody == null) {
                        LinearLayout linearLayout2 = linearLayout;
                        TextView textView4 = new TextView(activity);
                        Activity activity3 = activity;
                        Resources resources2 = resources;
                        textView4.setText(activity3.getString(R.string.mythic_coming_soon));
                        textView4.setTextColor(-1714959670);
                        textView4.setTextSize(13.0f);
                        textView4.setGravity(17);
                        CardEvaluationDetailHelper cardEvaluationDetailHelper2 = CardEvaluationDetailHelper.INSTANCE;
                        Intrinsics.checkNotNull(resources2);
                        textView4.setPadding(0, cardEvaluationDetailHelper2.dpToPx(24, resources2), 0, CardEvaluationDetailHelper.INSTANCE.dpToPx(24, resources2));
                        linearLayout2.addView(textView4);
                        return;
                    }
                    String strOverallLabel = MTRankingHelpers.INSTANCE.overallLabel(new MTCardRanking(false, 0, mTCardExplainResponseBody.getVerdict(), mTCardExplainResponseBody.getOverallLabel(), null, null, null, null, null, null, null, null, null, null, null, null, 65523, null));
                    int iOverallLabelColor = MTRankingHelpers.INSTANCE.overallLabelColor(strOverallLabel);
                    textView.setText(activity.getString(MTRankingHelpers.INSTANCE.overallLabelResId(strOverallLabel)));
                    textView.setTextColor(iOverallLabelColor);
                    TextView textView5 = textView;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    Resources resources3 = resources;
                    CardEvaluationDetailHelper cardEvaluationDetailHelper3 = CardEvaluationDetailHelper.INSTANCE;
                    Intrinsics.checkNotNull(resources3);
                    gradientDrawable.setCornerRadius(cardEvaluationDetailHelper3.dpToPx(8, resources3));
                    gradientDrawable.setStroke(CardEvaluationDetailHelper.INSTANCE.dpToPx(1, resources3), Color.argb(77, Color.red(iOverallLabelColor), Color.green(iOverallLabelColor), Color.blue(iOverallLabelColor)));
                    gradientDrawable.setColor(Color.argb(38, Color.red(iOverallLabelColor), Color.green(iOverallLabelColor), Color.blue(iOverallLabelColor)));
                    textView5.setBackground(gradientDrawable);
                    textView.setVisibility(0);
                    CardEvaluationDetailHelper.INSTANCE.populateEvaluationContent(activity, linearLayout, mTCardExplainResponseBody, dialog);
                }
            });
        }
    }
}
