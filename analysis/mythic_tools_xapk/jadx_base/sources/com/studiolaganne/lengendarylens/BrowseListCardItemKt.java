package com.studiolaganne.lengendarylens;

import com.studiolaganne.lengendarylens.BrowseListCardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseListCardItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00060\u0001¨\u0006\u0007"}, d2 = {"toBrowseListCardItems", "", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem;", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "toBrowseListCardItemsFromGroups", "toBrowseListCardItemsFromCards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseListCardItemKt {
    public static final List<BrowseListCardItem> toBrowseListCardItems(MTCardGroup mTCardGroup) {
        Intrinsics.checkNotNullParameter(mTCardGroup, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BrowseListCardItem.SectionHeader(mTCardGroup.getType(), mTCardGroup.getCount(), mTCardGroup.getTotal_count()));
        List<MTFullCard> cards = mTCardGroup.getCards();
        if (cards != null) {
            int i = 0;
            for (Object obj : cards) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new BrowseListCardItem.Card((MTFullCard) obj, i));
                i = i2;
            }
        }
        return arrayList;
    }

    public static final List<BrowseListCardItem> toBrowseListCardItemsFromCards(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<MTFullCard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new BrowseListCardItem.Card((MTFullCard) obj, i));
            i = i2;
        }
        return arrayList;
    }

    public static final List<BrowseListCardItem> toBrowseListCardItemsFromGroups(List<MTCardGroup> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (MTCardGroup mTCardGroup : list) {
            arrayList.add(new BrowseListCardItem.SectionHeader(mTCardGroup.getType(), mTCardGroup.getCount(), mTCardGroup.getTotal_count()));
            List<MTFullCard> cards = mTCardGroup.getCards();
            if (cards != null) {
                Iterator<T> it = cards.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BrowseListCardItem.Card((MTFullCard) it.next(), i));
                    i++;
                }
            }
        }
        return arrayList;
    }
}
