package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.Constants;
import com.studiolaganne.lengendarylens.Operator;
import com.studiolaganne.lengendarylens.SearchKeyword;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lang", "", "filterListener", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/OnFilterClickListener;Landroid/view/View;)V", "excludeImage", "Landroid/widget/ImageView;", "keywordLabel", "Landroid/widget/TextView;", "operatorLabel", "valueLabel", "deleteButton", "bind", "", "element", "Lcom/studiolaganne/lengendarylens/SearchElement;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final View deleteButton;
    private final ImageView excludeImage;
    private final OnFilterClickListener filterListener;
    private final TextView keywordLabel;
    private final String lang;
    private final TextView operatorLabel;
    private final TextView valueLabel;

    /* JADX INFO: compiled from: FilterListAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operator.values().length];
            try {
                iArr[Operator.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Operator.GREATER_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Operator.LESS_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Operator.LESS_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Operator.CONTAINS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Operator.NOT_EQUAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterViewHolder(String lang, OnFilterClickListener filterListener, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(filterListener, "filterListener");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.lang = lang;
        this.filterListener = filterListener;
        View viewFindViewById = itemView.findViewById(R.id.excludeImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.excludeImage = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.keywordTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.keywordLabel = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.operatorTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.operatorLabel = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.valueTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.valueLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.closeImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.deleteButton = viewFindViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$1(FilterViewHolder filterViewHolder, SearchCondition searchCondition, View view) {
        filterViewHolder.filterListener.onFilterClick(searchCondition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$0$2(FilterViewHolder filterViewHolder, SearchCondition searchCondition) {
        filterViewHolder.filterListener.onFilterDelete(searchCondition);
        return Unit.INSTANCE;
    }

    public final void bind(SearchElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        final SearchCondition searchCondition = element instanceof SearchCondition ? (SearchCondition) element : null;
        if (searchCondition != null) {
            boolean include = searchCondition.getInclude();
            ImageView imageView = this.excludeImage;
            if (include) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            TextView textView = this.keywordLabel;
            SearchKeyword.Companion companion = SearchKeyword.INSTANCE;
            SearchKeyword keyword = searchCondition.getKeyword();
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(companion.keywordDisplayName(keyword, context));
            TextView textView2 = this.operatorLabel;
            Operator.Companion companion2 = Operator.INSTANCE;
            Operator operator = searchCondition.getOperator();
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            String lowerCase = companion2.operatorDisplayName(operator, context2).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            textView2.setText(lowerCase);
            switch (WhenMappings.$EnumSwitchMapping$0[searchCondition.getOperator().ordinal()]) {
                case 1:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_green));
                    break;
                case 2:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_orange));
                    break;
                case 3:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_orange));
                    break;
                case 4:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_orange));
                    break;
                case 5:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_orange));
                    break;
                case 6:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_blue));
                    break;
                case 7:
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_red));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.valueLabel.setText(searchCondition.getValue());
            if (searchCondition.getKeyword() == SearchKeyword.TYPE) {
                String strTransformTypeLineShortcut = SearchDataUtils.INSTANCE.getInstance().transformTypeLineShortcut(searchCondition.getValue(), this.lang);
                if (!Intrinsics.areEqual(strTransformTypeLineShortcut, searchCondition.getValue())) {
                    this.operatorLabel.setText(this.itemView.getResources().getString(R.string.op_is));
                    this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.custom_green_background));
                }
                this.valueLabel.setText(strTransformTypeLineShortcut);
            }
            if (searchCondition.getKeyword() == SearchKeyword.COLOR || searchCondition.getKeyword() == SearchKeyword.IDENTITY) {
                TextView textView3 = this.valueLabel;
                String upperCase = searchCondition.getValue().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView3.setText(upperCase);
            }
            if (searchCondition.getKeyword() == SearchKeyword.MANA_COST) {
                String strStandardizeManaCost = SearchDataUtils.INSTANCE.getInstance().standardizeManaCost(searchCondition.getValue());
                Context context3 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                this.valueLabel.setText(new SymbolToImage(context3).stringToAttributedStringWithSymbols(strStandardizeManaCost, this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller), new CharacterStyle[0]));
            }
            if (searchCondition.getKeyword() == SearchKeyword.RARITY) {
                this.valueLabel.setText(SearchDataUtils.INSTANCE.getInstance().transformRarity(searchCondition.getValue(), this.lang));
            }
            if (searchCondition.getKeyword() == SearchKeyword.IS || searchCondition.getKeyword() == SearchKeyword.LEGAL || searchCondition.getKeyword() == SearchKeyword.BANNED) {
                this.operatorLabel.setText(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                this.operatorLabel.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.tag_green));
                TextView textView4 = this.valueLabel;
                String value = searchCondition.getValue();
                if (value.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String strValueOf = String.valueOf(value.charAt(0));
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase2 = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase2);
                    String strSubstring = value.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    value = sbAppend.append(strSubstring).toString();
                }
                textView4.setText(value);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FilterViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FilterViewHolder.bind$lambda$0$1(this.f$0, searchCondition, view);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(this.deleteButton, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterViewHolder.bind$lambda$0$2(this.f$0, searchCondition);
                }
            });
        }
    }
}
