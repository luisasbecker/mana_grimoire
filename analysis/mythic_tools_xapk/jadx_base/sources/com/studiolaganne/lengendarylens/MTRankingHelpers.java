package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Color;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsHelpers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fJ\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011J\u0010\u0010-\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\fJ\u000e\u00100\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\fR\u0011\u0010(\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRankingHelpers;", "", "<init>", "()V", "categorizeCard", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "ranking", "Lcom/studiolaganne/lengendarylens/MTCardRanking;", "coreSynergyBadge", "Lcom/studiolaganne/lengendarylens/MTCoreSynergyBadge;", "topSignals", "", "", "signals", "hasProtection", "", "limit", "", "blendContextKey", "deckPowerScore", "(Ljava/lang/Integer;)Ljava/lang/String;", "primaryRoleId", "role", "Lcom/studiolaganne/lengendarylens/MTCardRankingRoleContribution;", "neededRoleLabels", "ctx", "Landroid/content/Context;", "roleLabel", "id", "roleTierLabel", "tier", "categoryAccent", "category", "categoryLabelResId", "categoryDescriptionResId", "subBadgeColor", "badge", "subBadgeLabelResId", "protectionIconGlyph", "reason", "protectionAccent", "getProtectionAccent", "()I", "neutralScoreColor", FirebaseAnalytics.Param.SCORE, "overallLabel", "overallLabelResId", Constants.ScionAnalytics.PARAM_LABEL, "overallLabelColor", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTRankingHelpers {
    public static final int $stable = 0;
    public static final MTRankingHelpers INSTANCE = new MTRankingHelpers();
    private static final int protectionAccent = Color.parseColor("#D4AF5A");

    /* JADX INFO: compiled from: MTCardRankingsHelpers.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MTCardRankingCategory.values().length];
            try {
                iArr[MTCardRankingCategory.PROTECTED_STAPLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MTCardRankingCategory.CORE_SYNERGY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MTCardRankingCategory.SUPPORTING_PIECES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MTCardRankingCategory.OUTLIERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MTCardRankingCategory.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MTCoreSynergyBadge.values().length];
            try {
                iArr2[MTCoreSynergyBadge.THEME.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MTCoreSynergyBadge.ROLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MTCoreSynergyBadge.DECK_FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private MTRankingHelpers() {
    }

    public static /* synthetic */ List topSignals$default(MTRankingHelpers mTRankingHelpers, List list, boolean z, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 2;
        }
        return mTRankingHelpers.topSignals(list, z, i);
    }

    public final String blendContextKey(Integer deckPowerScore) {
        if (deckPowerScore == null) {
            return "balanced";
        }
        int iIntValue = deckPowerScore.intValue();
        return iIntValue >= 65 ? "high_power" : iIntValue <= 35 ? "casual" : "balanced";
    }

    public final MTCardRankingCategory categorizeCard(MTCardRanking ranking) {
        if (ranking == null) {
            return MTCardRankingCategory.OUTLIERS;
        }
        String protectionReason = ranking.getProtectionReason();
        return (protectionReason == null || protectionReason.length() == 0) ? coreSynergyBadge(ranking) != null ? MTCardRankingCategory.CORE_SYNERGY : ranking.getSortPriority() >= 40 ? MTCardRankingCategory.SUPPORTING_PIECES : MTCardRankingCategory.OUTLIERS : MTCardRankingCategory.PROTECTED_STAPLES;
    }

    public final int categoryAccent(MTCardRankingCategory category) {
        String str;
        Intrinsics.checkNotNullParameter(category, "category");
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            str = "#D4AF5A";
        } else if (i == 2) {
            str = "#6C95D0";
        } else if (i == 3) {
            str = "#ED9A57";
        } else if (i == 4) {
            str = "#8B9398";
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "#C7CACA";
        }
        return Color.parseColor(str);
    }

    public final int categoryDescriptionResId(MTCardRankingCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return R.string.eval_cat_desc_protected_staples;
        }
        if (i == 2) {
            return R.string.eval_cat_desc_core_synergy;
        }
        if (i == 3) {
            return R.string.eval_cat_desc_supporting_pieces;
        }
        if (i == 4) {
            return R.string.eval_cat_desc_outliers;
        }
        if (i == 5) {
            return R.string.eval_cat_desc_all;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int categoryLabelResId(MTCardRankingCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return R.string.eval_cat_protected_staples;
        }
        if (i == 2) {
            return R.string.eval_cat_core_synergy;
        }
        if (i == 3) {
            return R.string.eval_cat_supporting_pieces;
        }
        if (i == 4) {
            return R.string.eval_cat_outliers;
        }
        if (i == 5) {
            return R.string.eval_cat_all;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MTCoreSynergyBadge coreSynergyBadge(MTCardRanking ranking) {
        MTCardRankingSignals signals;
        String mode;
        List<MTCardRankingRole> listEmptyList;
        if (ranking == null || (signals = ranking.getSignals()) == null) {
            return null;
        }
        MTCardRankingThemeAlignment themeAlignment = signals.getThemeAlignment();
        MTCardRankingRoleContribution roleContribution = signals.getRoleContribution();
        MTCardRankingSignal deckFit = signals.getDeckFit();
        boolean z = false;
        int score = themeAlignment != null ? themeAlignment.getScore() : 0;
        if (themeAlignment == null || (mode = themeAlignment.getMode()) == null) {
            mode = "";
        }
        int score2 = roleContribution != null ? roleContribution.getScore() : 0;
        int score3 = deckFit != null ? deckFit.getScore() : 0;
        if (roleContribution == null || (listEmptyList = roleContribution.getRoles()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<MTCardRankingRole> list = listEmptyList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (MTCardRankingRole mTCardRankingRole : list) {
                if (Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "caution") || Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "weakness")) {
                    z = true;
                    break;
                }
            }
        }
        if (score >= 65 && Intrinsics.areEqual(mode, "theme")) {
            return MTCoreSynergyBadge.THEME;
        }
        if (score2 >= 60 || z) {
            return MTCoreSynergyBadge.ROLE;
        }
        if (score3 >= 65) {
            return MTCoreSynergyBadge.DECK_FIT;
        }
        return null;
    }

    public final int getProtectionAccent() {
        return protectionAccent;
    }

    public final List<String> neededRoleLabels(Context ctx, MTCardRanking ranking) {
        MTCardRankingSignals signals;
        MTCardRankingRoleContribution roleContribution;
        List<MTCardRankingRole> roles;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (ranking == null || (signals = ranking.getSignals()) == null || (roleContribution = signals.getRoleContribution()) == null || (roles = roleContribution.getRoles()) == null) {
            return CollectionsKt.emptyList();
        }
        if (roles.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : roles) {
            MTCardRankingRole mTCardRankingRole = (MTCardRankingRole) obj;
            if (Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "weakness") || Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "caution")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            roles = arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = roles.iterator();
        while (it.hasNext()) {
            String id = ((MTCardRankingRole) it.next()).getId();
            String str = id;
            String strRoleLabel = (str == null || str.length() == 0) ? null : INSTANCE.roleLabel(ctx, id);
            if (strRoleLabel != null) {
                arrayList3.add(strRoleLabel);
            }
        }
        return arrayList3;
    }

    public final int neutralScoreColor(int score) {
        return Color.parseColor(score >= 75 ? "#B8CCE0" : score >= 55 ? "#8B9DAF" : score >= 35 ? "#7A8A9A" : "#6B7280");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String overallLabel(MTCardRanking ranking) {
        String verdict;
        String overallLabel = ranking != null ? ranking.getOverallLabel() : null;
        String str = overallLabel;
        if (str != null && str.length() != 0) {
            return overallLabel;
        }
        if (ranking == null || (verdict = ranking.getVerdict()) == null) {
            verdict = "";
        }
        switch (verdict.hashCode()) {
            case -1756449148:
                return !verdict.equals("flex_slot") ? "earns_slot" : "worth_reviewing";
            case -1648686834:
                return !verdict.equals("key_piece") ? "earns_slot" : "strong_slot";
            case -1498725064:
                return !verdict.equals("commander") ? "earns_slot" : "strong_slot";
            case -32528442:
                return !verdict.equals("cut_candidate") ? "earns_slot" : "underperforming";
            case 1754384148:
                verdict.equals("solid_include");
                return "earns_slot";
            default:
                return "earns_slot";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int overallLabelColor(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        switch (label.hashCode()) {
            case -1467121895:
                if (label.equals("worth_reviewing")) {
                    return categoryAccent(MTCardRankingCategory.SUPPORTING_PIECES);
                }
                break;
            case 356561574:
                if (label.equals("strong_slot")) {
                    return categoryAccent(MTCardRankingCategory.PROTECTED_STAPLES);
                }
                break;
            case 431422905:
                if (label.equals("underperforming")) {
                    return categoryAccent(MTCardRankingCategory.OUTLIERS);
                }
                break;
            case 1439241250:
                if (label.equals("earns_slot")) {
                    return categoryAccent(MTCardRankingCategory.CORE_SYNERGY);
                }
                break;
        }
        return categoryAccent(MTCardRankingCategory.CORE_SYNERGY);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int overallLabelResId(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        switch (label.hashCode()) {
            case -1467121895:
                if (label.equals("worth_reviewing")) {
                    return R.string.eval_overall_worth_reviewing;
                }
                break;
            case 356561574:
                if (label.equals("strong_slot")) {
                    return R.string.eval_overall_strong_slot;
                }
                break;
            case 431422905:
                if (label.equals("underperforming")) {
                    return R.string.eval_overall_underperforming;
                }
                break;
            case 1439241250:
                if (label.equals("earns_slot")) {
                    return R.string.eval_overall_earns_slot;
                }
                break;
        }
        return R.string.eval_overall_earns_slot;
    }

    public final String primaryRoleId(MTCardRankingRoleContribution role) {
        List<MTCardRankingRole> roles;
        Object obj = null;
        if (role == null || (roles = role.getRoles()) == null || roles.isEmpty()) {
            return null;
        }
        for (Object obj2 : roles) {
            MTCardRankingRole mTCardRankingRole = (MTCardRankingRole) obj2;
            if (Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "weakness") || Intrinsics.areEqual(mTCardRankingRole.getDeckTier(), "caution")) {
                obj = obj2;
                break;
            }
        }
        MTCardRankingRole mTCardRankingRole2 = (MTCardRankingRole) obj;
        if (mTCardRankingRole2 == null) {
            mTCardRankingRole2 = (MTCardRankingRole) CollectionsKt.first((List) roles);
        }
        return mTCardRankingRole2.getId();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String protectionIconGlyph(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        switch (reason.hashCode()) {
            case -1993568464:
                return !reason.equals("mass_land_denial") ? "\uf521" : "\uf05e";
            case -1107213451:
                reason.equals("game_changer");
                return "\uf521";
            case -167127998:
                return !reason.equals("universal_tutor") ? "\uf521" : "\uf002";
            case -34915075:
                return !reason.equals("combo_piece") ? "\uf521" : "\uf0c1";
            case -27082678:
                return !reason.equals("fast_mana") ? "\uf521" : "\uf0e7";
            case 306149980:
                return !reason.equals("popular_for_commander") ? "\uf521" : "\uf0c0";
            case 742486790:
                return !reason.equals("ubiquitous_staple") ? "\uf521" : "\uf5fd";
            case 747876172:
                return !reason.equals("extra_turn") ? "\uf521" : "\uf04e";
            default:
                return "\uf521";
        }
    }

    public final String roleLabel(Context ctx, String id) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String str = id;
        if (str == null || str.length() == 0) {
            return "";
        }
        int identifier = ctx.getResources().getIdentifier("eval_role_" + id, TypedValues.Custom.S_STRING, ctx.getPackageName());
        if (identifier == 0) {
            return id;
        }
        String string = ctx.getString(identifier);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String roleTierLabel(Context ctx, String tier) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String str = tier;
        if (str == null || str.length() == 0) {
            return "";
        }
        int identifier = ctx.getResources().getIdentifier("eval_role_tier_" + tier, TypedValues.Custom.S_STRING, ctx.getPackageName());
        if (identifier == 0) {
            return tier;
        }
        String string = ctx.getString(identifier);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final int subBadgeColor(MTCoreSynergyBadge badge) {
        String str;
        Intrinsics.checkNotNullParameter(badge, "badge");
        int i = WhenMappings.$EnumSwitchMapping$1[badge.ordinal()];
        if (i == 1) {
            str = "#9E7BC9";
        } else if (i == 2) {
            str = "#5B9BD5";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "#5FB7A8";
        }
        return Color.parseColor(str);
    }

    public final int subBadgeLabelResId(MTCoreSynergyBadge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        int i = WhenMappings.$EnumSwitchMapping$1[badge.ordinal()];
        if (i == 1) {
            return R.string.eval_synergy_badge_theme;
        }
        if (i == 2) {
            return R.string.eval_synergy_badge_role;
        }
        if (i == 3) {
            return R.string.eval_synergy_badge_deck_fit;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<String> topSignals(List<String> signals, boolean hasProtection, int limit) {
        Intrinsics.checkNotNullParameter(signals, "signals");
        Set of = SetsKt.setOf((Object[]) new String[]{"matches_theme", "fills_needed_role", "high_theme_alignment"});
        if (hasProtection) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : signals) {
                if (of.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            signals = arrayList;
        }
        return CollectionsKt.take(signals, limit);
    }
}
