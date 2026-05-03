package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.RulesAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RulesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001d\u001e\u001f BQ\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "symbolToImage", "Lcom/studiolaganne/lengendarylens/SymbolToImage;", "entries", "", "Lcom/studiolaganne/lengendarylens/RuleObject;", "sections", "Lcom/studiolaganne/lengendarylens/RuleSection;", "rules", "Lcom/studiolaganne/lengendarylens/RuleParagraph;", "glossary", "Lcom/studiolaganne/lengendarylens/GlossaryEntry;", "callback", "Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;", "<init>", "(Lcom/studiolaganne/lengendarylens/SymbolToImage;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "Type1ViewHolder", "Type2ViewHolder", "Type3ViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_GLOSSARY = 3;
    public static final int TYPE_RULE = 2;
    public static final int TYPE_SECTION = 1;
    private final RuleParagraphCallback callback;
    private final List<RuleObject> entries;
    private final List<GlossaryEntry> glossary;
    private final List<RuleParagraph> rules;
    private final List<RuleSection> sections;
    private final SymbolToImage symbolToImage;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: RulesAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulesAdapter$Type1ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", Constants.GP_IAP_TITLE, "Landroid/widget/TextView;", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/RuleSection;", "callback", "Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type1ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type1ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.title_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
        }

        public final void bind(RuleSection rowData, RuleParagraphCallback callback) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.title.setText(rowData.getNumber() + ". " + rowData.getTitle());
        }
    }

    /* JADX INFO: compiled from: RulesAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulesAdapter$Type2ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "spacerLabel", "Landroid/widget/TextView;", "sectionLabel", "ruleLabel", "selected", "", "bind", "", "symbolToImage", "Lcom/studiolaganne/lengendarylens/SymbolToImage;", "rowData", "Lcom/studiolaganne/lengendarylens/RuleParagraph;", "callback", "Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type2ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView ruleLabel;
        private final TextView sectionLabel;
        private boolean selected;
        private final TextView spacerLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type2ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.offset_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.spacerLabel = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.section_number_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.sectionLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.paragraph_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.ruleLabel = (TextView) viewFindViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$0$0(RuleParagraphCallback ruleParagraphCallback, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ruleParagraphCallback.linkClicked(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final boolean bind$lambda$0$1(Type2ViewHolder type2ViewHolder, RuleParagraphCallback ruleParagraphCallback, RuleParagraph ruleParagraph, View view, MotionEvent motionEvent) {
            boolean z;
            if (!(view instanceof TextView)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (motionEvent.getAction() == 1) {
                TextView textView = (TextView) view;
                int offsetForHorizontal = textView.getLayout().getOffsetForHorizontal(textView.getLayout().getLineForVertical((((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY()), (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX());
                CharSequence text = textView.getText();
                SpannedString spannedString = text instanceof SpannedString ? (SpannedString) text : null;
                if (spannedString != null) {
                    Object[] spans = spannedString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spans;
                    if (clickableSpanArr.length == 0) {
                        z = false;
                    } else {
                        ((ClickableSpan) ArraysKt.first(clickableSpanArr)).onClick(view);
                        z = true;
                    }
                    CharSequence text2 = textView.getText();
                    SpannableString spannableString = text2 instanceof SpannableString ? (SpannableString) text2 : null;
                    if (spannableString != null) {
                        Object[] spans2 = spannableString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
                        ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spans2;
                        if (!(clickableSpanArr2.length == 0)) {
                            ((ClickableSpan) ArraysKt.first(clickableSpanArr2)).onClick(view);
                            z = false;
                        }
                    }
                    if (!z) {
                        if (type2ViewHolder.selected) {
                            type2ViewHolder.sectionLabel.setBackgroundColor(type2ViewHolder.itemView.getContext().getColor(android.R.color.transparent));
                            type2ViewHolder.ruleLabel.setBackgroundColor(type2ViewHolder.itemView.getContext().getColor(android.R.color.transparent));
                            type2ViewHolder.selected = false;
                            ruleParagraphCallback.selectionRemoved(ruleParagraph.getSectionNumber());
                        } else {
                            type2ViewHolder.sectionLabel.setBackgroundColor(ContextCompat.getColor(type2ViewHolder.itemView.getContext(), R.color.darker_blue));
                            type2ViewHolder.ruleLabel.setBackgroundColor(ContextCompat.getColor(type2ViewHolder.itemView.getContext(), R.color.darker_blue));
                            type2ViewHolder.selected = true;
                            ruleParagraphCallback.selectionAdded(ruleParagraph.getSectionNumber());
                        }
                    }
                    textView.performClick();
                }
            }
            return true;
        }

        public final void bind(SymbolToImage symbolToImage, final RuleParagraph rowData, final RuleParagraphCallback callback) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            boolean zMatches = new Regex(".*[a-z]$").matches(rowData.getSectionNumber());
            boolean zEndsWith$default = StringsKt.endsWith$default(rowData.getSectionNumber(), ".", false, 2, (Object) null);
            TextView textView = this.spacerLabel;
            if (zMatches) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            this.sectionLabel.setText(rowData.getSectionNumber());
            if (symbolToImage != null) {
                int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_smaller);
                String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(rowData.getRulesText(), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null), "Example: ", "\n\nExample: ", false, 4, (Object) null), "Exemple : ", "\n\nExemple : ", false, 4, (Object) null);
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this.ruleLabel.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(strReplace$default, dimensionPixelSize, context, new Function1() { // from class: com.studiolaganne.lengendarylens.RulesAdapter$Type2ViewHolder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RulesAdapter.Type2ViewHolder.bind$lambda$0$0(callback, (String) obj);
                    }
                }, new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.almost_white))));
                if (Build.VERSION.SDK_INT >= 29) {
                    this.ruleLabel.setJustificationMode(1);
                }
                this.ruleLabel.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.RulesAdapter$Type2ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return RulesAdapter.Type2ViewHolder.bind$lambda$0$1(this.f$0, callback, rowData, view, motionEvent);
                    }
                });
            } else {
                this.ruleLabel.setText(rowData.getRulesText());
            }
            TextView textView2 = this.ruleLabel;
            if (zEndsWith$default) {
                textView2.setTypeface(null, 1);
            } else {
                textView2.setTypeface(null, 0);
            }
        }
    }

    /* JADX INFO: compiled from: RulesAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulesAdapter$Type3ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "spacerLabel", "Landroid/widget/TextView;", "sectionLabel", "ruleLabel", "selected", "", "bind", "", "symbolToImage", "Lcom/studiolaganne/lengendarylens/SymbolToImage;", "rowData", "Lcom/studiolaganne/lengendarylens/GlossaryEntry;", "callback", "Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type3ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView ruleLabel;
        private final TextView sectionLabel;
        private boolean selected;
        private final TextView spacerLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type3ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.offset_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.spacerLabel = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.section_number_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.sectionLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.paragraph_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.ruleLabel = (TextView) viewFindViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$0$0(RuleParagraphCallback ruleParagraphCallback, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ruleParagraphCallback.linkClicked(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final boolean bind$lambda$0$1(Type3ViewHolder type3ViewHolder, RuleParagraphCallback ruleParagraphCallback, GlossaryEntry glossaryEntry, View view, MotionEvent motionEvent) {
            boolean z;
            if (!(view instanceof TextView)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (motionEvent.getAction() == 1) {
                TextView textView = (TextView) view;
                int offsetForHorizontal = textView.getLayout().getOffsetForHorizontal(textView.getLayout().getLineForVertical((((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY()), (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX());
                CharSequence text = textView.getText();
                SpannedString spannedString = text instanceof SpannedString ? (SpannedString) text : null;
                if (spannedString != null) {
                    Object[] spans = spannedString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spans;
                    if (clickableSpanArr.length == 0) {
                        z = false;
                    } else {
                        ((ClickableSpan) ArraysKt.first(clickableSpanArr)).onClick(view);
                        z = true;
                    }
                    CharSequence text2 = textView.getText();
                    SpannableString spannableString = text2 instanceof SpannableString ? (SpannableString) text2 : null;
                    if (spannableString != null) {
                        Object[] spans2 = spannableString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
                        ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spans2;
                        if (!(clickableSpanArr2.length == 0)) {
                            ((ClickableSpan) ArraysKt.first(clickableSpanArr2)).onClick(view);
                            z = false;
                        }
                    }
                    if (!z) {
                        if (type3ViewHolder.selected) {
                            type3ViewHolder.sectionLabel.setBackgroundColor(type3ViewHolder.itemView.getContext().getColor(android.R.color.transparent));
                            type3ViewHolder.ruleLabel.setBackgroundColor(type3ViewHolder.itemView.getContext().getColor(android.R.color.transparent));
                            type3ViewHolder.selected = false;
                            ruleParagraphCallback.selectionRemoved("g_" + glossaryEntry.getKey());
                        } else {
                            type3ViewHolder.sectionLabel.setBackgroundColor(ContextCompat.getColor(type3ViewHolder.itemView.getContext(), R.color.darker_blue));
                            type3ViewHolder.ruleLabel.setBackgroundColor(ContextCompat.getColor(type3ViewHolder.itemView.getContext(), R.color.darker_blue));
                            type3ViewHolder.selected = true;
                            ruleParagraphCallback.selectionAdded("g_" + glossaryEntry.getKey());
                        }
                    }
                    textView.performClick();
                }
            }
            return true;
        }

        public final void bind(SymbolToImage symbolToImage, final GlossaryEntry rowData, final RuleParagraphCallback callback) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.spacerLabel.setVisibility(8);
            this.sectionLabel.setText(rowData.getKey());
            this.sectionLabel.setTypeface(null, 1);
            if (symbolToImage == null) {
                this.ruleLabel.setText(rowData.getValue());
                return;
            }
            int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_smaller);
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(rowData.getValue(), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null), "Example: ", "\n\nExample: ", false, 4, (Object) null), "Exemple : ", "\n\nExemple : ", false, 4, (Object) null);
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.ruleLabel.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(strReplace$default, dimensionPixelSize, context, new Function1() { // from class: com.studiolaganne.lengendarylens.RulesAdapter$Type3ViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RulesAdapter.Type3ViewHolder.bind$lambda$0$0(callback, (String) obj);
                }
            }, new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.almost_white))));
            if (Build.VERSION.SDK_INT >= 29) {
                this.ruleLabel.setJustificationMode(1);
            }
            this.ruleLabel.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.RulesAdapter$Type3ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return RulesAdapter.Type3ViewHolder.bind$lambda$0$1(this.f$0, callback, rowData, view, motionEvent);
                }
            });
        }
    }

    public RulesAdapter(SymbolToImage symbolToImage, List<RuleObject> entries, List<RuleSection> sections, List<RuleParagraph> rules, List<GlossaryEntry> glossary, RuleParagraphCallback callback) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(glossary, "glossary");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.symbolToImage = symbolToImage;
        this.entries = entries;
        this.sections = sections;
        this.rules = rules;
        this.glossary = glossary;
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.entries.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.entries.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < 0 || position >= this.entries.size()) {
            return;
        }
        RuleObject ruleObject = this.entries.get(position);
        if (ruleObject.getOriginalIndex() < 0) {
            return;
        }
        if (holder instanceof Type1ViewHolder) {
            ((Type1ViewHolder) holder).bind(this.sections.get(ruleObject.getOriginalIndex()), this.callback);
        } else if (holder instanceof Type2ViewHolder) {
            ((Type2ViewHolder) holder).bind(this.symbolToImage, this.rules.get(ruleObject.getOriginalIndex()), this.callback);
        } else if (holder instanceof Type3ViewHolder) {
            ((Type3ViewHolder) holder).bind(this.symbolToImage, this.glossary.get(ruleObject.getOriginalIndex()), this.callback);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.rule_section, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new Type1ViewHolder(viewInflate);
        }
        if (viewType == 2) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.rule_paragraph, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
            return new Type2ViewHolder(viewInflate2);
        }
        if (viewType != 3) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.rule_paragraph, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
        return new Type3ViewHolder(viewInflate3);
    }
}
