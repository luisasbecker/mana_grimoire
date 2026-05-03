package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerDetailsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerDetailsItemHolder;", "", "type", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "separator", "", "<init>", "(ILcom/studiolaganne/lengendarylens/MTCardContainer;Ljava/lang/String;)V", "getType", "()I", "getContainer", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setContainer", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getSeparator", "()Ljava/lang/String;", "setSeparator", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardContainerDetailsItemHolder {
    public static final int $stable = 8;
    private MTCardContainer container;
    private String separator;
    private final int type;

    public CardContainerDetailsItemHolder() {
        this(0, null, null, 7, null);
    }

    public CardContainerDetailsItemHolder(int i, MTCardContainer mTCardContainer, String str) {
        this.type = i;
        this.container = mTCardContainer;
        this.separator = str;
    }

    public /* synthetic */ CardContainerDetailsItemHolder(int i, MTCardContainer mTCardContainer, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : mTCardContainer, (i2 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ CardContainerDetailsItemHolder copy$default(CardContainerDetailsItemHolder cardContainerDetailsItemHolder, int i, MTCardContainer mTCardContainer, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cardContainerDetailsItemHolder.type;
        }
        if ((i2 & 2) != 0) {
            mTCardContainer = cardContainerDetailsItemHolder.container;
        }
        if ((i2 & 4) != 0) {
            str = cardContainerDetailsItemHolder.separator;
        }
        return cardContainerDetailsItemHolder.copy(i, mTCardContainer, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCardContainer getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeparator() {
        return this.separator;
    }

    public final CardContainerDetailsItemHolder copy(int type, MTCardContainer container, String separator) {
        return new CardContainerDetailsItemHolder(type, container, separator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardContainerDetailsItemHolder)) {
            return false;
        }
        CardContainerDetailsItemHolder cardContainerDetailsItemHolder = (CardContainerDetailsItemHolder) other;
        return this.type == cardContainerDetailsItemHolder.type && Intrinsics.areEqual(this.container, cardContainerDetailsItemHolder.container) && Intrinsics.areEqual(this.separator, cardContainerDetailsItemHolder.separator);
    }

    public final MTCardContainer getContainer() {
        return this.container;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        MTCardContainer mTCardContainer = this.container;
        int iHashCode2 = (iHashCode + (mTCardContainer == null ? 0 : mTCardContainer.hashCode())) * 31;
        String str = this.separator;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setContainer(MTCardContainer mTCardContainer) {
        this.container = mTCardContainer;
    }

    public final void setSeparator(String str) {
        this.separator = str;
    }

    public String toString() {
        return "CardContainerDetailsItemHolder(type=" + this.type + ", container=" + this.container + ", separator=" + this.separator + ")";
    }
}
