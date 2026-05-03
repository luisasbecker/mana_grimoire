package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MTEvaluationCardViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010+\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020!H\u0002J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u0018\u00103\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00104\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardClickListener;", "actionListener", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/OnEvaluationCardClickListener;Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;)V", "titleLabel", "Landroid/widget/TextView;", "imageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "scoreBarTrack", "scoreBarFill", "redundantBadge", "removeButton", "dotsMenuButton", "Landroid/widget/ImageView;", "protectionChip", "Landroid/widget/LinearLayout;", "protectionIcon", "protectionLabel", "subBadgeChip", "signalChipsRow", "bind", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "isActed", "", "category", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "onRecycled", "bindProtectionChip", "reason", "", "bindSubBadge", "ranking", "Lcom/studiolaganne/lengendarylens/MTCardRanking;", "bindSignalChips", "hasProtection", "pillBackground", "Landroid/graphics/drawable/GradientDrawable;", "color", "fillAlpha", "", "strokeAlpha", "withAlpha", "alpha", "dp", "v", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTEvaluationCardViewHolder extends RecyclerView.ViewHolder {
    private final OnEvaluationCardActionListener actionListener;
    private final OnEvaluationCardClickListener clickListener;
    private final ImageView dotsMenuButton;
    private final LoadingImageView imageView;
    private final LinearLayout protectionChip;
    private final TextView protectionIcon;
    private final TextView protectionLabel;
    private final TextView redundantBadge;
    private final TextView removeButton;
    private final View scoreBarFill;
    private final View scoreBarTrack;
    private final LinearLayout signalChipsRow;
    private final TextView subBadgeChip;
    private final TextView titleLabel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTEvaluationCardViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardViewHolder$Companion;", "", "<init>", "()V", "scoreBarColor", "", FirebaseAnalytics.Param.SCORE, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String scoreBarColor(int score) {
            return score >= 75 ? "#B8CCE0" : score >= 55 ? "#8B9DAF" : score >= 35 ? "#7A8A9A" : "#6B7280";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MTEvaluationCardViewHolder(View itemView, OnEvaluationCardClickListener clickListener, OnEvaluationCardActionListener actionListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(actionListener, "actionListener");
        this.clickListener = clickListener;
        this.actionListener = actionListener;
        View viewFindViewById = itemView.findViewById(R.id.titleLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById2;
        this.imageView = loadingImageView;
        View viewFindViewById3 = itemView.findViewById(R.id.scoreBarTrack);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.scoreBarTrack = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.scoreBarFill);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.scoreBarFill = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.redundantBadge);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.redundantBadge = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.removeButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.removeButton = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.dotsMenuButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.dotsMenuButton = (ImageView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.protectionChip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.protectionChip = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.protectionIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.protectionIcon = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.protectionLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.protectionLabel = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.subBadgeChip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.subBadgeChip = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.signalChipsRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.signalChipsRow = (LinearLayout) viewFindViewById12;
        loadingImageView.setAutoLoad(false);
        loadingImageView.reset();
    }

    public static /* synthetic */ void bind$default(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, MTFullCard mTFullCard, int i, boolean z, MTCardRankingCategory mTCardRankingCategory, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            mTCardRankingCategory = MTCardRankingCategory.ALL;
        }
        mTEvaluationCardViewHolder.bind(mTFullCard, i, z, mTCardRankingCategory);
    }

    static final void bind$lambda$4(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, int i) {
        int width = (mTEvaluationCardViewHolder.scoreBarTrack.getWidth() * RangesKt.coerceIn(i, 0, 100)) / 100;
        ViewGroup.LayoutParams layoutParams = mTEvaluationCardViewHolder.scoreBarFill.getLayoutParams();
        layoutParams.width = width;
        mTEvaluationCardViewHolder.scoreBarFill.setLayoutParams(layoutParams);
        mTEvaluationCardViewHolder.scoreBarFill.setBackgroundColor(MTRankingHelpers.INSTANCE.neutralScoreColor(i));
    }

    static final Unit bind$lambda$5(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, MTFullCard mTFullCard, int i) {
        mTEvaluationCardViewHolder.clickListener.onEvaluationCardClick(mTFullCard, i);
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$6(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, MTFullCard mTFullCard) {
        mTEvaluationCardViewHolder.actionListener.onRemoveFromDeck(mTFullCard);
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$7(Context context, final MTEvaluationCardViewHolder mTEvaluationCardViewHolder, final MTFullCard mTFullCard) {
        Intrinsics.checkNotNull(context);
        IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.eval_move_to_sideboard, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTEvaluationCardViewHolder.bind$lambda$7$0(this.f$0, mTFullCard);
            }
        }, 30, (Object) null), R.string.eval_move_to_maybeboard, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTEvaluationCardViewHolder.bind$lambda$7$1(this.f$0, mTFullCard);
            }
        }, 30, (Object) null).show(mTEvaluationCardViewHolder.dotsMenuButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$7$0(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, MTFullCard mTFullCard) {
        mTEvaluationCardViewHolder.actionListener.onMoveCard(mTFullCard, "sideboard");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$7$1(MTEvaluationCardViewHolder mTEvaluationCardViewHolder, MTFullCard mTFullCard) {
        mTEvaluationCardViewHolder.actionListener.onMoveCard(mTFullCard, "maybeboard");
        return Unit.INSTANCE;
    }

    private final void bindProtectionChip(String reason) {
        String str = reason;
        if (str == null || str.length() == 0) {
            this.protectionChip.setVisibility(8);
            return;
        }
        Context context = this.itemView.getContext();
        int protectionAccent = MTRankingHelpers.INSTANCE.getProtectionAccent();
        this.protectionChip.setVisibility(0);
        this.protectionChip.setBackground(pillBackground(protectionAccent, 0.14f, 0.35f));
        this.protectionIcon.setText(MTRankingHelpers.INSTANCE.protectionIconGlyph(reason));
        this.protectionIcon.setTextColor(protectionAccent);
        this.protectionIcon.setTypeface(ResourcesCompat.getFont(context, R.font.fa6solid));
        int identifier = context.getResources().getIdentifier("eval_protection_" + reason, TypedValues.Custom.S_STRING, context.getPackageName());
        TextView textView = this.protectionLabel;
        if (identifier != 0) {
            reason = context.getString(identifier);
            Intrinsics.checkNotNullExpressionValue(reason, "getString(...)");
        }
        String upperCase = reason.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        this.protectionLabel.setTextColor(protectionAccent);
    }

    private final void bindSignalChips(MTCardRanking ranking, boolean hasProtection) {
        List<String> listEmptyList;
        Context context = this.itemView.getContext();
        this.signalChipsRow.removeAllViews();
        MTRankingHelpers mTRankingHelpers = MTRankingHelpers.INSTANCE;
        if (ranking == null || (listEmptyList = ranking.getSignalsList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> list = mTRankingHelpers.topSignals(listEmptyList, hasProtection, 2);
        if (list.isEmpty()) {
            this.signalChipsRow.setVisibility(8);
            return;
        }
        boolean z = false;
        for (String str : list) {
            int identifier = context.getResources().getIdentifier("eval_signal_" + str, TypedValues.Custom.S_STRING, context.getPackageName());
            if (identifier != 0) {
                String string = context.getString(identifier);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (Intrinsics.areEqual(str, "fills_needed_role")) {
                    MTRankingHelpers mTRankingHelpers2 = MTRankingHelpers.INSTANCE;
                    Intrinsics.checkNotNull(context);
                    List<String> listNeededRoleLabels = mTRankingHelpers2.neededRoleLabels(context, ranking);
                    if (!listNeededRoleLabels.isEmpty()) {
                        string = string + ": " + CollectionsKt.joinToString$default(listNeededRoleLabels, ", ", null, null, 0, null, null, 62, null);
                    }
                }
                TextView textView = new TextView(context);
                textView.setText(string);
                textView.setTextSize(10.0f);
                textView.setTypeface(ResourcesCompat.getFont(context, R.font.be_vietnam_pro_semibold));
                textView.setTextColor(Color.parseColor("#CCC7CACA"));
                textView.setGravity(16);
                textView.setPadding(dp(8), 0, dp(8), 0);
                z = true;
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(dp(10));
                gradientDrawable.setColor(Color.parseColor("#0DFFFFFF"));
                gradientDrawable.setStroke(dp(1), Color.parseColor("#1AFFFFFF"));
                textView.setBackground(gradientDrawable);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dp(20));
                layoutParams.setMarginEnd(dp(3));
                this.signalChipsRow.addView(textView, layoutParams);
            }
        }
        this.signalChipsRow.setVisibility(z ? 0 : 8);
    }

    private final void bindSubBadge(MTCardRanking ranking, MTCardRankingCategory category) {
        MTCardRankingSignals signals;
        Context context = this.itemView.getContext();
        if (category == MTCardRankingCategory.ALL) {
            category = MTRankingHelpers.INSTANCE.categorizeCard(ranking);
        }
        MTCardRankingRoleContribution roleContribution = null;
        MTCoreSynergyBadge mTCoreSynergyBadgeCoreSynergyBadge = category == MTCardRankingCategory.CORE_SYNERGY ? MTRankingHelpers.INSTANCE.coreSynergyBadge(ranking) : null;
        if (mTCoreSynergyBadgeCoreSynergyBadge == null) {
            this.subBadgeChip.setVisibility(8);
            return;
        }
        int iSubBadgeColor = MTRankingHelpers.INSTANCE.subBadgeColor(mTCoreSynergyBadgeCoreSynergyBadge);
        this.subBadgeChip.setVisibility(0);
        this.subBadgeChip.setBackground(pillBackground(iSubBadgeColor, 0.14f, 0.35f));
        this.subBadgeChip.setTextColor(iSubBadgeColor);
        String string = context.getString(MTRankingHelpers.INSTANCE.subBadgeLabelResId(mTCoreSynergyBadgeCoreSynergyBadge));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (mTCoreSynergyBadgeCoreSynergyBadge == MTCoreSynergyBadge.ROLE) {
            MTRankingHelpers mTRankingHelpers = MTRankingHelpers.INSTANCE;
            if (ranking != null && (signals = ranking.getSignals()) != null) {
                roleContribution = signals.getRoleContribution();
            }
            String strPrimaryRoleId = mTRankingHelpers.primaryRoleId(roleContribution);
            String str = strPrimaryRoleId;
            if (str != null && str.length() != 0) {
                MTRankingHelpers mTRankingHelpers2 = MTRankingHelpers.INSTANCE;
                Intrinsics.checkNotNull(context);
                String strRoleLabel = mTRankingHelpers2.roleLabel(context, strPrimaryRoleId);
                TextView textView = this.subBadgeChip;
                String string2 = context.getString(R.string.eval_fills_role_with_name, strRoleLabel);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String upperCase = string2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView.setText(upperCase);
                return;
            }
        }
        TextView textView2 = this.subBadgeChip;
        String upperCase2 = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        textView2.setText(upperCase2);
    }

    private final int dp(int v) {
        return (int) (v * this.itemView.getResources().getDisplayMetrics().density);
    }

    private final GradientDrawable pillBackground(int color, float fillAlpha, float strokeAlpha) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dp(8));
        gradientDrawable.setColor(withAlpha(color, fillAlpha));
        gradientDrawable.setStroke(dp(1), withAlpha(color, strokeAlpha));
        return gradientDrawable;
    }

    private final int withAlpha(int color, float alpha) {
        return Color.argb((int) (RangesKt.coerceIn(alpha, 0.0f, 1.0f) * 255.0f), Color.red(color), Color.green(color), Color.blue(color));
    }

    public final void bind(final MTFullCard card, final int position, boolean isActed, MTCardRankingCategory category) {
        Unit unit;
        List<MTImageURIs> en_images;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String normal;
        MTImageURIs mTImageURIs3;
        String gatherer2;
        MTCardRankingRedundancy redundancy;
        MTImageURIs mTImageURIs4;
        String normal2;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(category, "category");
        final Context context = this.itemView.getContext();
        TextView textView = this.titleLabel;
        String printed_name = card.getPrinted_name();
        if (printed_name == null) {
            printed_name = card.getName();
        }
        textView.setText(printed_name);
        this.imageView.reset();
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (normal2 = mTImageURIs4.getNormal()) == null) {
            List<MTImageURIs> images2 = card.getImages();
            if (images2 == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null || (gatherer2 = mTImageURIs3.getGatherer()) == null) {
                List<MTImageURIs> en_images2 = card.getEn_images();
                if (en_images2 == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null || (normal = mTImageURIs2.getNormal()) == null) {
                    unit = null;
                } else {
                    this.imageView.loadImage(normal);
                    unit = Unit.INSTANCE;
                }
                if (unit == null && (en_images = card.getEn_images()) != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) != null && (gatherer = mTImageURIs.getGatherer()) != null) {
                    this.imageView.loadImage(gatherer);
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                this.imageView.loadImage(gatherer2);
                Unit unit3 = Unit.INSTANCE;
            }
        } else {
            this.imageView.loadImage(normal2);
            Unit unit4 = Unit.INSTANCE;
        }
        MTCardRanking ranking = card.getRanking();
        final int sortPriority = ranking != null ? ranking.getSortPriority() : 0;
        this.scoreBarTrack.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MTEvaluationCardViewHolder.bind$lambda$4(this.f$0, sortPriority);
            }
        });
        String protectionReason = ranking != null ? ranking.getProtectionReason() : null;
        boolean z = protectionReason == null || protectionReason.length() == 0;
        boolean z2 = !z;
        bindProtectionChip(ranking != null ? ranking.getProtectionReason() : null);
        bindSubBadge(ranking, category);
        bindSignalChips(ranking, z2);
        this.redundantBadge.setVisibility(ranking != null && (redundancy = ranking.getRedundancy()) != null && redundancy.isRedundant() && z ? 0 : 8);
        if (isActed) {
            this.itemView.setAlpha(0.35f);
            this.removeButton.setOnClickListener(null);
            this.dotsMenuButton.setOnClickListener(null);
            this.itemView.setOnClickListener(null);
            return;
        }
        this.itemView.setAlpha(1.0f);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTEvaluationCardViewHolder.bind$lambda$5(this.f$0, card, position);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.removeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTEvaluationCardViewHolder.bind$lambda$6(this.f$0, card);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.dotsMenuButton, new Function0() { // from class: com.studiolaganne.lengendarylens.MTEvaluationCardViewHolder$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTEvaluationCardViewHolder.bind$lambda$7(context, this, card);
            }
        });
    }

    public final void onRecycled() {
        this.imageView.reset();
        this.itemView.setAlpha(1.0f);
    }
}
