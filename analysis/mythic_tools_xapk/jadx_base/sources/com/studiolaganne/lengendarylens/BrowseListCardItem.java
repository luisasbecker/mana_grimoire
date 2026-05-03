package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseListCardItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseListCardItem;", "", "<init>", "()V", "SectionHeader", "Card", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem$Card;", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem$SectionHeader;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BrowseListCardItem {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: BrowseListCardItem.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseListCardItem$Card;", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem;", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "<init>", "(Lcom/studiolaganne/lengendarylens/MTFullCard;I)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Card extends BrowseListCardItem {
        public static final int $stable = 8;
        private final MTFullCard card;
        private final int position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Card(MTFullCard card, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
            this.position = i;
        }

        public static /* synthetic */ Card copy$default(Card card, MTFullCard mTFullCard, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mTFullCard = card.card;
            }
            if ((i2 & 2) != 0) {
                i = card.position;
            }
            return card.copy(mTFullCard, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MTFullCard getCard() {
            return this.card;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public final Card copy(MTFullCard card, int position) {
            Intrinsics.checkNotNullParameter(card, "card");
            return new Card(card, position);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Card)) {
                return false;
            }
            Card card = (Card) other;
            return Intrinsics.areEqual(this.card, card.card) && this.position == card.position;
        }

        public final MTFullCard getCard() {
            return this.card;
        }

        public final int getPosition() {
            return this.position;
        }

        public int hashCode() {
            return (this.card.hashCode() * 31) + Integer.hashCode(this.position);
        }

        public String toString() {
            return "Card(card=" + this.card + ", position=" + this.position + ")";
        }
    }

    /* JADX INFO: compiled from: BrowseListCardItem.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseListCardItem$SectionHeader;", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem;", "type", "", "count", "", "totalCount", "<init>", "(Ljava/lang/String;II)V", "getType", "()Ljava/lang/String;", "getCount", "()I", "getTotalCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SectionHeader extends BrowseListCardItem {
        public static final int $stable = 0;
        private final int count;
        private final int totalCount;
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeader(String type, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.count = i;
            this.totalCount = i2;
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = sectionHeader.type;
            }
            if ((i3 & 2) != 0) {
                i = sectionHeader.count;
            }
            if ((i3 & 4) != 0) {
                i2 = sectionHeader.totalCount;
            }
            return sectionHeader.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalCount() {
            return this.totalCount;
        }

        public final SectionHeader copy(String type, int count, int totalCount) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new SectionHeader(type, count, totalCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionHeader)) {
                return false;
            }
            SectionHeader sectionHeader = (SectionHeader) other;
            return Intrinsics.areEqual(this.type, sectionHeader.type) && this.count == sectionHeader.count && this.totalCount == sectionHeader.totalCount;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getTotalCount() {
            return this.totalCount;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.totalCount);
        }

        public String toString() {
            return "SectionHeader(type=" + this.type + ", count=" + this.count + ", totalCount=" + this.totalCount + ")";
        }
    }

    private BrowseListCardItem() {
    }

    public /* synthetic */ BrowseListCardItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
