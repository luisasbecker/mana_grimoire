package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListItem;", "", "id", "", "name", "", "cardCount", "icon", "<init>", "(ILjava/lang/String;II)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getCardCount", "getIcon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeckListItem {
    public static final int $stable = 0;
    private final int cardCount;
    private final int icon;
    private final int id;
    private final String name;

    public DeckListItem(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.cardCount = i2;
        this.icon = i3;
    }

    public static /* synthetic */ DeckListItem copy$default(DeckListItem deckListItem, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = deckListItem.id;
        }
        if ((i4 & 2) != 0) {
            str = deckListItem.name;
        }
        if ((i4 & 4) != 0) {
            i2 = deckListItem.cardCount;
        }
        if ((i4 & 8) != 0) {
            i3 = deckListItem.icon;
        }
        return deckListItem.copy(i, str, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCardCount() {
        return this.cardCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    public final DeckListItem copy(int id, String name, int cardCount, int icon) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DeckListItem(id, name, cardCount, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckListItem)) {
            return false;
        }
        DeckListItem deckListItem = (DeckListItem) other;
        return this.id == deckListItem.id && Intrinsics.areEqual(this.name, deckListItem.name) && this.cardCount == deckListItem.cardCount && this.icon == deckListItem.icon;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.cardCount)) * 31) + Integer.hashCode(this.icon);
    }

    public String toString() {
        return "DeckListItem(id=" + this.id + ", name=" + this.name + ", cardCount=" + this.cardCount + ", icon=" + this.icon + ")";
    }
}
