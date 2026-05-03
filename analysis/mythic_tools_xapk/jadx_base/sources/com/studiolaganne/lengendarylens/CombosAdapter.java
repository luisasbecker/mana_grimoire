package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import com.studiolaganne.lengendarylens.CombosAdapter;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CombosAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f BS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "combos", "", "Lcom/studiolaganne/lengendarylens/MTCombo;", "clickListener", "Lcom/studiolaganne/lengendarylens/OnComboClickListener;", "deckCardsByOracleId", "", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "showLoadMoreFooter", "", "onLoadMoreClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/OnComboClickListener;Ljava/util/Map;ZLkotlin/jvm/functions/Function0;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "onViewRecycled", "Companion", "LoadMoreViewHolder", "ComboViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CombosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_COMBO = 0;
    private static final int TYPE_LOAD_MORE = 1;
    private final OnComboClickListener clickListener;
    private final List<MTCombo> combos;
    private final Map<String, MTFullCard> deckCardsByOracleId;
    private final Function0<Unit> onLoadMoreClick;
    private final boolean showLoadMoreFooter;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CombosAdapter.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J4\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00172\u001a\u0010-\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0004\u0012\u00020&0.H\u0002J\u0006\u0010/\u001a\u00020&R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombosAdapter$ComboViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/OnComboClickListener;", "deckCardsByOracleId", "", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/OnComboClickListener;Ljava/util/Map;)V", "comboInfoInnerLayout", "comboTitleTextView", "Landroid/widget/TextView;", "resultTags", "Lcom/google/android/flexbox/FlexboxLayout;", "manaCostComboLayout", "Landroid/widget/LinearLayout;", "manaNeededValueTextView", "plusCardsLayout", "plusCardsTextView", "firstCardImageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "secondCardImageView", "cardCountTextView", "strengthColorTextView", "strengthTextView", "firstCardZoneLayout", "firstCardZoneTextView", "secondCardZoneLayout", "secondCardZoneTextView", "dotsLayout", "card1Call", "Lretrofit2/Call;", "Lcom/studiolaganne/lengendarylens/MTFullCardResponse;", "card2Call", "bind", "", "combo", "Lcom/studiolaganne/lengendarylens/MTCombo;", "loadCardImage", "card", "Lcom/studiolaganne/lengendarylens/MTComboCard;", "imageView", "setCall", "Lkotlin/Function1;", "cancelPendingLoads", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ComboViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private Call<MTFullCardResponse> card1Call;
        private Call<MTFullCardResponse> card2Call;
        private final TextView cardCountTextView;
        private final OnComboClickListener clickListener;
        private final View comboInfoInnerLayout;
        private final TextView comboTitleTextView;
        private final Map<String, MTFullCard> deckCardsByOracleId;
        private final View dotsLayout;
        private final LoadingImageView firstCardImageView;
        private final View firstCardZoneLayout;
        private final TextView firstCardZoneTextView;
        private final LinearLayout manaCostComboLayout;
        private final TextView manaNeededValueTextView;
        private final View plusCardsLayout;
        private final TextView plusCardsTextView;
        private final FlexboxLayout resultTags;
        private final LoadingImageView secondCardImageView;
        private final View secondCardZoneLayout;
        private final TextView secondCardZoneTextView;
        private final TextView strengthColorTextView;
        private final TextView strengthTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ComboViewHolder(View itemView, OnComboClickListener onComboClickListener, Map<String, MTFullCard> map) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.clickListener = onComboClickListener;
            this.deckCardsByOracleId = map;
            View viewFindViewById = itemView.findViewById(R.id.comboInfoInnerLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.comboInfoInnerLayout = viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.comboTitleTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.comboTitleTextView = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.resultTags);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.resultTags = (FlexboxLayout) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.manaCostComboLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.manaCostComboLayout = (LinearLayout) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.manaNeededValueTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.manaNeededValueTextView = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.plusCardsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.plusCardsLayout = viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.plusCardsTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.plusCardsTextView = (TextView) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(R.id.firstCardImageView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.firstCardImageView = (LoadingImageView) viewFindViewById8;
            View viewFindViewById9 = itemView.findViewById(R.id.secondCardImageView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.secondCardImageView = (LoadingImageView) viewFindViewById9;
            View viewFindViewById10 = itemView.findViewById(R.id.cardCountTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.cardCountTextView = (TextView) viewFindViewById10;
            View viewFindViewById11 = itemView.findViewById(R.id.strengthColorTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.strengthColorTextView = (TextView) viewFindViewById11;
            View viewFindViewById12 = itemView.findViewById(R.id.strengthTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.strengthTextView = (TextView) viewFindViewById12;
            View viewFindViewById13 = itemView.findViewById(R.id.firstCardZoneLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.firstCardZoneLayout = viewFindViewById13;
            View viewFindViewById14 = itemView.findViewById(R.id.firstCardZoneTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.firstCardZoneTextView = (TextView) viewFindViewById14;
            View viewFindViewById15 = itemView.findViewById(R.id.secondCardZoneLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            this.secondCardZoneLayout = viewFindViewById15;
            View viewFindViewById16 = itemView.findViewById(R.id.secondCardZoneTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            this.secondCardZoneTextView = (TextView) viewFindViewById16;
            View viewFindViewById17 = itemView.findViewById(R.id.dotsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            this.dotsLayout = viewFindViewById17;
        }

        static final Unit bind$lambda$0(ComboViewHolder comboViewHolder, MTCombo mTCombo) {
            OnComboClickListener onComboClickListener = comboViewHolder.clickListener;
            if (onComboClickListener != null) {
                onComboClickListener.onComboClicked(mTCombo);
            }
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$1(final ComboViewHolder comboViewHolder, final MTCombo mTCombo) {
            Context context = comboViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.show_on_commander_spellbook, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CombosAdapter.ComboViewHolder.bind$lambda$1$0(this.f$0, mTCombo);
                }
            }, 30, (Object) null).show(comboViewHolder.dotsLayout);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$1$0(ComboViewHolder comboViewHolder, MTCombo mTCombo) {
            OnComboClickListener onComboClickListener = comboViewHolder.clickListener;
            if (onComboClickListener != null) {
                onComboClickListener.onComboOpenInSpellbook(mTCombo);
            }
            return Unit.INSTANCE;
        }

        static final CharSequence bind$lambda$2(MTComboCard it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getName();
        }

        static final Unit bind$lambda$3(ComboViewHolder comboViewHolder, Call call) {
            comboViewHolder.card1Call = call;
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$6(ComboViewHolder comboViewHolder, Call call) {
            comboViewHolder.card2Call = call;
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[PHI: r7
          0x0049: PHI (r7v18 java.lang.String) = (r7v4 java.lang.String), (r7v7 java.lang.String), (r7v21 java.lang.String) binds: [B:33:0x005f, B:40:0x0075, B:24:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void loadCardImage(MTComboCard card, final LoadingImageView imageView, Function1<? super Call<MTFullCardResponse>, Unit> setCall) {
            MTFullCard mTFullCard;
            MTImageURIs mTImageURIs;
            MTImageURIs mTImageURIs2;
            MTImageURIs mTImageURIs3;
            MTImageURIs mTImageURIs4;
            final Context context = this.itemView.getContext();
            gatherer = null;
            String gatherer = null;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null || !activity.isFinishing()) {
                if (activity == null || !activity.isDestroyed()) {
                    Map<String, MTFullCard> map = this.deckCardsByOracleId;
                    if (map == null || (mTFullCard = map.get(card.getOracleId())) == null) {
                        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
                        Intrinsics.checkNotNull(context);
                        final MTGDBHelper.FirstPrintInfo firstPrintInfo = companion.getInstance(context).getFirstPrintInfo(card.getOracleId(), 0);
                        if (firstPrintInfo == null) {
                            return;
                        }
                        String imageUrl = CardImageCache.INSTANCE.getImageUrl(context, firstPrintInfo.getScryfallId(), 0);
                        if (imageUrl != null) {
                            imageView.loadImage(imageUrl);
                            return;
                        }
                        if (NetworkHelper.INSTANCE.isNetworkAvailable(context)) {
                            PreferencesManager preferencesManager = new PreferencesManager(context);
                            MTApi mtApi = MTApiKt.getMtApi();
                            String setCode = firstPrintInfo.getSetCode();
                            String collectorNumber = firstPrintInfo.getCollectorNumber();
                            MTUser currentUser = preferencesManager.getCurrentUser();
                            Call<MTFullCardResponse> cardWithParameters = mtApi.getCardWithParameters("en", setCode, collectorNumber, currentUser != null ? Integer.valueOf(currentUser.getId()) : null);
                            setCall.invoke(cardWithParameters);
                            final Object tag = this.itemView.getTag();
                            cardWithParameters.enqueue(new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$loadCardImage$2
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                }

                                /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[PHI: r5
                                  0x006d: PHI (r5v15 java.lang.String) = (r5v4 java.lang.String), (r5v7 java.lang.String), (r5v18 java.lang.String) binds: [B:40:0x0083, B:47:0x0099, B:31:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
                                @Override // retrofit2.Callback
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
                                    MTFullCardResponse mTFullCardResponseBody;
                                    MTFullCard card2;
                                    MTImageURIs mTImageURIs5;
                                    MTImageURIs mTImageURIs6;
                                    MTImageURIs mTImageURIs7;
                                    MTImageURIs mTImageURIs8;
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (Intrinsics.areEqual(this.this$0.itemView.getTag(), tag)) {
                                        Context context2 = this.this$0.itemView.getContext();
                                        String gatherer2 = null;
                                        Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
                                        if (activity2 == null || !activity2.isFinishing()) {
                                            if ((activity2 == null || !activity2.isDestroyed()) && response.isSuccessful() && (mTFullCardResponseBody = response.body()) != null && (card2 = mTFullCardResponseBody.getCard()) != null) {
                                                List<MTImageURIs> images = card2.getImages();
                                                if (images == null || (mTImageURIs8 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (gatherer = mTImageURIs8.getNormal()) == null) {
                                                    List<MTImageURIs> images2 = card2.getImages();
                                                    String gatherer3 = (images2 == null || (mTImageURIs7 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null) ? null : mTImageURIs7.getGatherer();
                                                    if (gatherer3 != null) {
                                                        gatherer2 = gatherer3;
                                                    } else {
                                                        List<MTImageURIs> en_images = card2.getEn_images();
                                                        gatherer3 = (en_images == null || (mTImageURIs6 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null) ? null : mTImageURIs6.getNormal();
                                                        if (gatherer3 == null) {
                                                            List<MTImageURIs> en_images2 = card2.getEn_images();
                                                            if (en_images2 != null && (mTImageURIs5 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null) {
                                                                gatherer2 = mTImageURIs5.getGatherer();
                                                            }
                                                        }
                                                    }
                                                }
                                                if (gatherer2 != null) {
                                                    CardImageCache cardImageCache = CardImageCache.INSTANCE;
                                                    Context context3 = context;
                                                    Intrinsics.checkNotNull(context3);
                                                    cardImageCache.saveImageUrl(context3, firstPrintInfo.getScryfallId(), gatherer2, 0);
                                                    imageView.loadImage(gatherer2);
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    List<MTImageURIs> images = mTFullCard.getImages();
                    if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (gatherer = mTImageURIs4.getNormal()) == null) {
                        List<MTImageURIs> images2 = mTFullCard.getImages();
                        String gatherer2 = (images2 == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null) ? null : mTImageURIs3.getGatherer();
                        if (gatherer2 != null) {
                            gatherer = gatherer2;
                        } else {
                            List<MTImageURIs> en_images = mTFullCard.getEn_images();
                            gatherer2 = (en_images == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null) ? null : mTImageURIs2.getNormal();
                            if (gatherer2 == null) {
                                List<MTImageURIs> en_images2 = mTFullCard.getEn_images();
                                if (en_images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null) {
                                    gatherer = mTImageURIs.getGatherer();
                                }
                            }
                        }
                    }
                    if (gatherer != null) {
                        String scryfallid = mTFullCard.getScryfallid();
                        if (scryfallid != null) {
                            CardImageCache cardImageCache = CardImageCache.INSTANCE;
                            Intrinsics.checkNotNull(context);
                            cardImageCache.saveImageUrl(context, scryfallid, gatherer, 0);
                        }
                        imageView.loadImage(gatherer);
                    }
                }
            }
        }

        public final void bind(final MTCombo combo) {
            Intrinsics.checkNotNullParameter(combo, "combo");
            this.itemView.setTag(combo.getId());
            ViewExtensionsKt.setOnClickWithFade(this.comboInfoInnerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CombosAdapter.ComboViewHolder.bind$lambda$0(this.f$0, combo);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(this.dotsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CombosAdapter.ComboViewHolder.bind$lambda$1(this.f$0, combo);
                }
            });
            SpannableString spannableString = new SpannableString(CollectionsKt.joinToString$default(combo.getCards(), " + ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CombosAdapter.ComboViewHolder.bind$lambda$2((MTComboCard) obj);
                }
            }, 30, null));
            int color = ContextCompat.getColor(this.itemView.getContext(), R.color.selected_color_new);
            int length = 0;
            for (MTComboCard mTComboCard : combo.getCards()) {
                int length2 = mTComboCard.getName().length() + length;
                if (!mTComboCard.getInDeck()) {
                    spannableString.setSpan(new ForegroundColorSpan(color), length, length2, 33);
                }
                length = " + ".length() + length2;
            }
            this.comboTitleTextView.setText(spannableString);
            this.cardCountTextView.setText(String.valueOf(combo.getCards().size()));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            if (Intrinsics.areEqual(combo.getBracketTag(), ExifInterface.LONGITUDE_EAST) || Intrinsics.areEqual(combo.getBracketTag(), "C")) {
                this.strengthColorTextView.setVisibility(4);
                this.strengthTextView.setVisibility(4);
            } else {
                TextView textView = this.strengthColorTextView;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                textView.setTextColor(companion.colorForCardCondition(context, companion.conditionCodeForComboBracket(combo.getBracketTag())));
                TextView textView2 = this.strengthTextView;
                Context context2 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                textView2.setTextColor(companion.colorForCardCondition(context2, companion.conditionCodeForComboBracket(combo.getBracketTag())));
                TextView textView3 = this.strengthTextView;
                Context context3 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                textView3.setText(companion.nameForComboBracket(context3, combo.getBracketTag()));
                this.strengthColorTextView.setVisibility(0);
                this.strengthTextView.setVisibility(0);
            }
            this.resultTags.removeAllViews();
            for (MTComboProduces mTComboProduces : combo.getProduces()) {
                View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.combo_result_item, (ViewGroup) this.resultTags, false);
                viewInflate.findViewById(R.id.comboResultInnerLayout).setBackgroundResource(CombosAdapterKt.produceNameToTagDrawable(mTComboProduces.getName()));
                ((TextView) viewInflate.findViewById(R.id.comboResultTextView)).setText(mTComboProduces.getName());
                this.resultTags.addView(viewInflate);
            }
            String manaNeeded = combo.getManaNeeded();
            LinearLayout linearLayout = this.manaCostComboLayout;
            if (manaNeeded != null) {
                linearLayout.setVisibility(0);
                String strReplace$default = StringsKt.replace$default(combo.getManaNeeded(), "}{", "} {", false, 4, (Object) null);
                int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_tiny);
                Context context4 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                this.manaNeededValueTextView.setText(new SymbolToImage(context4).stringToAttributedStringWithSymbols(strReplace$default, dimensionPixelSize, new CharacterStyle[0]));
            } else {
                linearLayout.setVisibility(4);
            }
            int size = combo.getCards().size();
            View view = this.plusCardsLayout;
            if (size > 2) {
                view.setVisibility(0);
                this.plusCardsTextView.setText("+" + (combo.getCards().size() - 2));
            } else {
                view.setVisibility(8);
            }
            this.firstCardImageView.reset();
            this.secondCardImageView.reset();
            Call<MTFullCardResponse> call = this.card1Call;
            if (call != null) {
                call.cancel();
            }
            Call<MTFullCardResponse> call2 = this.card2Call;
            if (call2 != null) {
                call2.cancel();
            }
            this.card1Call = null;
            this.card2Call = null;
            List<MTComboCard> cards = combo.getCards();
            if (cards.isEmpty()) {
                this.firstCardZoneLayout.setVisibility(8);
            } else {
                loadCardImage(cards.get(0), this.firstCardImageView, new Function1() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CombosAdapter.ComboViewHolder.bind$lambda$3(this.f$0, (Call) obj);
                    }
                });
                this.firstCardImageView.setImageColorDimmed(!cards.get(0).getInDeck());
                Character chZoneToIconChar = CombosAdapterKt.zoneToIconChar(cards.get(0).getZone());
                if (chZoneToIconChar != null) {
                    this.firstCardZoneTextView.setText(String.valueOf(chZoneToIconChar.charValue()));
                    this.firstCardZoneLayout.setVisibility(0);
                } else {
                    this.firstCardZoneLayout.setVisibility(8);
                }
            }
            if (cards.size() <= 1) {
                this.secondCardZoneLayout.setVisibility(8);
                return;
            }
            loadCardImage(cards.get(1), this.secondCardImageView, new Function1() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$ComboViewHolder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CombosAdapter.ComboViewHolder.bind$lambda$6(this.f$0, (Call) obj);
                }
            });
            this.secondCardImageView.setImageColorDimmed(!cards.get(1).getInDeck());
            Character chZoneToIconChar2 = CombosAdapterKt.zoneToIconChar(cards.get(1).getZone());
            if (chZoneToIconChar2 == null) {
                this.secondCardZoneLayout.setVisibility(8);
                return;
            }
            this.secondCardZoneTextView.setText(String.valueOf(chZoneToIconChar2.charValue()));
            this.secondCardZoneLayout.setVisibility(0);
        }

        public final void cancelPendingLoads() {
            Call<MTFullCardResponse> call = this.card1Call;
            if (call != null) {
                call.cancel();
            }
            Call<MTFullCardResponse> call2 = this.card2Call;
            if (call2 != null) {
                call2.cancel();
            }
            this.card1Call = null;
            this.card2Call = null;
        }
    }

    /* JADX INFO: compiled from: CombosAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombosAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onLoadMoreClick", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "bind", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final Function0<Unit> onLoadMoreClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadMoreViewHolder(View itemView, Function0<Unit> function0) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.onLoadMoreClick = function0;
        }

        static final void bind$lambda$0(LoadMoreViewHolder loadMoreViewHolder, View view) {
            Function0<Unit> function0 = loadMoreViewHolder.onLoadMoreClick;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void bind() {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CombosAdapter$LoadMoreViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CombosAdapter.LoadMoreViewHolder.bind$lambda$0(this.f$0, view);
                }
            });
        }
    }

    public CombosAdapter(List<MTCombo> combos, OnComboClickListener onComboClickListener, Map<String, MTFullCard> map, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(combos, "combos");
        this.combos = combos;
        this.clickListener = onComboClickListener;
        this.deckCardsByOracleId = map;
        this.showLoadMoreFooter = z;
        this.onLoadMoreClick = function0;
    }

    public /* synthetic */ CombosAdapter(List list, OnComboClickListener onComboClickListener, Map map, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, onComboClickListener, (i & 4) != 0 ? null : map, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : function0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.combos.size() + (this.showLoadMoreFooter ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (this.showLoadMoreFooter && position == this.combos.size()) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ComboViewHolder) {
            ((ComboViewHolder) holder).bind(this.combos.get(position));
        } else if (holder instanceof LoadMoreViewHolder) {
            ((LoadMoreViewHolder) holder).bind();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more_combos_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new LoadMoreViewHolder(viewInflate, this.onLoadMoreClick);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.combo_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new ComboViewHolder(viewInflate2, this.clickListener, this.deckCardsByOracleId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        ComboViewHolder comboViewHolder = holder instanceof ComboViewHolder ? (ComboViewHolder) holder : null;
        if (comboViewHolder != null) {
            comboViewHolder.cancelPendingLoads();
        }
    }
}
