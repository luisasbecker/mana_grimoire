package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: SimpleMTFullCardListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;", "", "onMTFullCardClick", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SimpleMTFullCardClickListener {

    /* JADX INFO: compiled from: SimpleMTFullCardListAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void onMTFullCardClick$default(SimpleMTFullCardClickListener simpleMTFullCardClickListener, MTFullCard mTFullCard, int i, MTCardContainer mTCardContainer, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMTFullCardClick");
        }
        if ((i2 & 4) != 0) {
            mTCardContainer = null;
        }
        simpleMTFullCardClickListener.onMTFullCardClick(mTFullCard, i, mTCardContainer);
    }

    void onMTFullCardClick(MTFullCard card, int position, MTCardContainer container);
}
