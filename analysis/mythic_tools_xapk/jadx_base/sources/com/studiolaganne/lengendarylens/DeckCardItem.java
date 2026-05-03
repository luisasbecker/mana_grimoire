package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckCardItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardItem;", "", "<init>", "()V", "SectionHeader", "ListCard", "StacksGroup", "VariantCard", "Lcom/studiolaganne/lengendarylens/DeckCardItem$ListCard;", "Lcom/studiolaganne/lengendarylens/DeckCardItem$SectionHeader;", "Lcom/studiolaganne/lengendarylens/DeckCardItem$StacksGroup;", "Lcom/studiolaganne/lengendarylens/DeckCardItem$VariantCard;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DeckCardItem {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: DeckCardItem.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardItem$ListCard;", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "problematic", "", "error", "Lcom/studiolaganne/lengendarylens/MTCardError;", "isColorChoosingCommander", "commanderColorOverride", "", "groupType", "<init>", "(Lcom/studiolaganne/lengendarylens/MTFullCard;ZLcom/studiolaganne/lengendarylens/MTCardError;ZLjava/lang/String;Ljava/lang/String;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "getProblematic", "()Z", "getError", "()Lcom/studiolaganne/lengendarylens/MTCardError;", "getCommanderColorOverride", "()Ljava/lang/String;", "getGroupType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ListCard extends DeckCardItem {
        public static final int $stable = MTFullCard.$stable;
        private final MTFullCard card;
        private final String commanderColorOverride;
        private final MTCardError error;
        private final String groupType;
        private final boolean isColorChoosingCommander;
        private final boolean problematic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListCard(MTFullCard card, boolean z, MTCardError mTCardError, boolean z2, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
            this.problematic = z;
            this.error = mTCardError;
            this.isColorChoosingCommander = z2;
            this.commanderColorOverride = str;
            this.groupType = str2;
        }

        public /* synthetic */ ListCard(MTFullCard mTFullCard, boolean z, MTCardError mTCardError, boolean z2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(mTFullCard, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : mTCardError, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2);
        }

        public static /* synthetic */ ListCard copy$default(ListCard listCard, MTFullCard mTFullCard, boolean z, MTCardError mTCardError, boolean z2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                mTFullCard = listCard.card;
            }
            if ((i & 2) != 0) {
                z = listCard.problematic;
            }
            if ((i & 4) != 0) {
                mTCardError = listCard.error;
            }
            if ((i & 8) != 0) {
                z2 = listCard.isColorChoosingCommander;
            }
            if ((i & 16) != 0) {
                str = listCard.commanderColorOverride;
            }
            if ((i & 32) != 0) {
                str2 = listCard.groupType;
            }
            String str3 = str;
            String str4 = str2;
            return listCard.copy(mTFullCard, z, mTCardError, z2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MTFullCard getCard() {
            return this.card;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getProblematic() {
            return this.problematic;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MTCardError getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsColorChoosingCommander() {
            return this.isColorChoosingCommander;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCommanderColorOverride() {
            return this.commanderColorOverride;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getGroupType() {
            return this.groupType;
        }

        public final ListCard copy(MTFullCard card, boolean problematic, MTCardError error, boolean isColorChoosingCommander, String commanderColorOverride, String groupType) {
            Intrinsics.checkNotNullParameter(card, "card");
            return new ListCard(card, problematic, error, isColorChoosingCommander, commanderColorOverride, groupType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListCard)) {
                return false;
            }
            ListCard listCard = (ListCard) other;
            return Intrinsics.areEqual(this.card, listCard.card) && this.problematic == listCard.problematic && Intrinsics.areEqual(this.error, listCard.error) && this.isColorChoosingCommander == listCard.isColorChoosingCommander && Intrinsics.areEqual(this.commanderColorOverride, listCard.commanderColorOverride) && Intrinsics.areEqual(this.groupType, listCard.groupType);
        }

        public final MTFullCard getCard() {
            return this.card;
        }

        public final String getCommanderColorOverride() {
            return this.commanderColorOverride;
        }

        public final MTCardError getError() {
            return this.error;
        }

        public final String getGroupType() {
            return this.groupType;
        }

        public final boolean getProblematic() {
            return this.problematic;
        }

        public int hashCode() {
            int iHashCode = ((this.card.hashCode() * 31) + Boolean.hashCode(this.problematic)) * 31;
            MTCardError mTCardError = this.error;
            int iHashCode2 = (((iHashCode + (mTCardError == null ? 0 : mTCardError.hashCode())) * 31) + Boolean.hashCode(this.isColorChoosingCommander)) * 31;
            String str = this.commanderColorOverride;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.groupType;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public final boolean isColorChoosingCommander() {
            return this.isColorChoosingCommander;
        }

        public String toString() {
            return "ListCard(card=" + this.card + ", problematic=" + this.problematic + ", error=" + this.error + ", isColorChoosingCommander=" + this.isColorChoosingCommander + ", commanderColorOverride=" + this.commanderColorOverride + ", groupType=" + this.groupType + ")";
        }
    }

    /* JADX INFO: compiled from: DeckCardItem.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardItem$SectionHeader;", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "type", "", "count", "", "totalCount", "isThemeGroup", "", "<init>", "(Ljava/lang/String;IIZ)V", "getType", "()Ljava/lang/String;", "getCount", "()I", "getTotalCount", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SectionHeader extends DeckCardItem {
        public static final int $stable = 0;
        private final int count;
        private final boolean isThemeGroup;
        private final int totalCount;
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeader(String type, int i, int i2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.count = i;
            this.totalCount = i2;
            this.isThemeGroup = z;
        }

        public /* synthetic */ SectionHeader(String str, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, (i3 & 8) != 0 ? false : z);
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = sectionHeader.type;
            }
            if ((i3 & 2) != 0) {
                i = sectionHeader.count;
            }
            if ((i3 & 4) != 0) {
                i2 = sectionHeader.totalCount;
            }
            if ((i3 & 8) != 0) {
                z = sectionHeader.isThemeGroup;
            }
            return sectionHeader.copy(str, i, i2, z);
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

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsThemeGroup() {
            return this.isThemeGroup;
        }

        public final SectionHeader copy(String type, int count, int totalCount, boolean isThemeGroup) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new SectionHeader(type, count, totalCount, isThemeGroup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionHeader)) {
                return false;
            }
            SectionHeader sectionHeader = (SectionHeader) other;
            return Intrinsics.areEqual(this.type, sectionHeader.type) && this.count == sectionHeader.count && this.totalCount == sectionHeader.totalCount && this.isThemeGroup == sectionHeader.isThemeGroup;
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
            return (((((this.type.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.totalCount)) * 31) + Boolean.hashCode(this.isThemeGroup);
        }

        public final boolean isThemeGroup() {
            return this.isThemeGroup;
        }

        public String toString() {
            return "SectionHeader(type=" + this.type + ", count=" + this.count + ", totalCount=" + this.totalCount + ", isThemeGroup=" + this.isThemeGroup + ")";
        }
    }

    /* JADX INFO: compiled from: DeckCardItem.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JQ\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardItem$StacksGroup;", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "problematicCards", "", "errors", "Lcom/studiolaganne/lengendarylens/MTListError;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "groupType", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTDeck;Ljava/lang/String;)V", "getCards", "()Ljava/util/List;", "getProblematicCards", "getErrors", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "getGroupType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StacksGroup extends DeckCardItem {
        public static final int $stable = 8;
        private final List<MTFullCard> cards;
        private final MTDeck deck;
        private final List<MTListError> errors;
        private final String groupType;
        private final List<String> problematicCards;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StacksGroup(List<MTFullCard> cards, List<String> problematicCards, List<MTListError> errors, MTDeck mTDeck, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(cards, "cards");
            Intrinsics.checkNotNullParameter(problematicCards, "problematicCards");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.cards = cards;
            this.problematicCards = problematicCards;
            this.errors = errors;
            this.deck = mTDeck;
            this.groupType = str;
        }

        public /* synthetic */ StacksGroup(List list, List list2, List list3, MTDeck mTDeck, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : mTDeck, (i & 16) != 0 ? null : str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StacksGroup copy$default(StacksGroup stacksGroup, List list, List list2, List list3, MTDeck mTDeck, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = stacksGroup.cards;
            }
            if ((i & 2) != 0) {
                list2 = stacksGroup.problematicCards;
            }
            if ((i & 4) != 0) {
                list3 = stacksGroup.errors;
            }
            if ((i & 8) != 0) {
                mTDeck = stacksGroup.deck;
            }
            if ((i & 16) != 0) {
                str = stacksGroup.groupType;
            }
            String str2 = str;
            List list4 = list3;
            return stacksGroup.copy(list, list2, list4, mTDeck, str2);
        }

        public final List<MTFullCard> component1() {
            return this.cards;
        }

        public final List<String> component2() {
            return this.problematicCards;
        }

        public final List<MTListError> component3() {
            return this.errors;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MTDeck getDeck() {
            return this.deck;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getGroupType() {
            return this.groupType;
        }

        public final StacksGroup copy(List<MTFullCard> cards, List<String> problematicCards, List<MTListError> errors, MTDeck deck, String groupType) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            Intrinsics.checkNotNullParameter(problematicCards, "problematicCards");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new StacksGroup(cards, problematicCards, errors, deck, groupType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StacksGroup)) {
                return false;
            }
            StacksGroup stacksGroup = (StacksGroup) other;
            return Intrinsics.areEqual(this.cards, stacksGroup.cards) && Intrinsics.areEqual(this.problematicCards, stacksGroup.problematicCards) && Intrinsics.areEqual(this.errors, stacksGroup.errors) && Intrinsics.areEqual(this.deck, stacksGroup.deck) && Intrinsics.areEqual(this.groupType, stacksGroup.groupType);
        }

        public final List<MTFullCard> getCards() {
            return this.cards;
        }

        public final MTDeck getDeck() {
            return this.deck;
        }

        public final List<MTListError> getErrors() {
            return this.errors;
        }

        public final String getGroupType() {
            return this.groupType;
        }

        public final List<String> getProblematicCards() {
            return this.problematicCards;
        }

        public int hashCode() {
            int iHashCode = ((((this.cards.hashCode() * 31) + this.problematicCards.hashCode()) * 31) + this.errors.hashCode()) * 31;
            MTDeck mTDeck = this.deck;
            int iHashCode2 = (iHashCode + (mTDeck == null ? 0 : mTDeck.hashCode())) * 31;
            String str = this.groupType;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "StacksGroup(cards=" + this.cards + ", problematicCards=" + this.problematicCards + ", errors=" + this.errors + ", deck=" + this.deck + ", groupType=" + this.groupType + ")";
        }
    }

    /* JADX INFO: compiled from: DeckCardItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardItem$VariantCard;", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "variant", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "parentCard", "groupType", "", "<init>", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Lcom/studiolaganne/lengendarylens/MTFullCard;Ljava/lang/String;)V", "getVariant", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "getParentCard", "getGroupType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VariantCard extends DeckCardItem {
        public static final int $stable = MTFullCard.$stable | MTFullCard.$stable;
        private final String groupType;
        private final MTFullCard parentCard;
        private final MTFullCard variant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VariantCard(MTFullCard variant, MTFullCard parentCard, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(variant, "variant");
            Intrinsics.checkNotNullParameter(parentCard, "parentCard");
            this.variant = variant;
            this.parentCard = parentCard;
            this.groupType = str;
        }

        public /* synthetic */ VariantCard(MTFullCard mTFullCard, MTFullCard mTFullCard2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(mTFullCard, mTFullCard2, (i & 4) != 0 ? null : str);
        }

        public static /* synthetic */ VariantCard copy$default(VariantCard variantCard, MTFullCard mTFullCard, MTFullCard mTFullCard2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                mTFullCard = variantCard.variant;
            }
            if ((i & 2) != 0) {
                mTFullCard2 = variantCard.parentCard;
            }
            if ((i & 4) != 0) {
                str = variantCard.groupType;
            }
            return variantCard.copy(mTFullCard, mTFullCard2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MTFullCard getVariant() {
            return this.variant;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MTFullCard getParentCard() {
            return this.parentCard;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getGroupType() {
            return this.groupType;
        }

        public final VariantCard copy(MTFullCard variant, MTFullCard parentCard, String groupType) {
            Intrinsics.checkNotNullParameter(variant, "variant");
            Intrinsics.checkNotNullParameter(parentCard, "parentCard");
            return new VariantCard(variant, parentCard, groupType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VariantCard)) {
                return false;
            }
            VariantCard variantCard = (VariantCard) other;
            return Intrinsics.areEqual(this.variant, variantCard.variant) && Intrinsics.areEqual(this.parentCard, variantCard.parentCard) && Intrinsics.areEqual(this.groupType, variantCard.groupType);
        }

        public final String getGroupType() {
            return this.groupType;
        }

        public final MTFullCard getParentCard() {
            return this.parentCard;
        }

        public final MTFullCard getVariant() {
            return this.variant;
        }

        public int hashCode() {
            int iHashCode = ((this.variant.hashCode() * 31) + this.parentCard.hashCode()) * 31;
            String str = this.groupType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "VariantCard(variant=" + this.variant + ", parentCard=" + this.parentCard + ", groupType=" + this.groupType + ")";
        }
    }

    private DeckCardItem() {
    }

    public /* synthetic */ DeckCardItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
