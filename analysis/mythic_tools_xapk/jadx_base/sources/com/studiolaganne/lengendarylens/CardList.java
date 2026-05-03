package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardList;", "Landroid/os/Parcelable;", "object", "", "total_cards", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "Lcom/studiolaganne/lengendarylens/Card;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getObject", "()Ljava/lang/String;", "getTotal_cards", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardList implements Parcelable {
    private final List<Card> data;
    private final String object;
    private final int total_cards;
    public static final Parcelable.Creator<CardList> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CardList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardList createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i2);
                for (int i3 = 0; i3 != i2; i3++) {
                    arrayList2.add(Card.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new CardList(string, i, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardList[] newArray(int i) {
            return new CardList[i];
        }
    }

    public CardList() {
        this(null, 0, null, 7, null);
    }

    public CardList(String object, int i, List<Card> list) {
        Intrinsics.checkNotNullParameter(object, "object");
        this.object = object;
        this.total_cards = i;
        this.data = list;
    }

    public /* synthetic */ CardList(String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardList copy$default(CardList cardList, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cardList.object;
        }
        if ((i2 & 2) != 0) {
            i = cardList.total_cards;
        }
        if ((i2 & 4) != 0) {
            list = cardList.data;
        }
        return cardList.copy(str, i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getObject() {
        return this.object;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotal_cards() {
        return this.total_cards;
    }

    public final List<Card> component3() {
        return this.data;
    }

    public final CardList copy(String object, int total_cards, List<Card> data) {
        Intrinsics.checkNotNullParameter(object, "object");
        return new CardList(object, total_cards, data);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardList)) {
            return false;
        }
        CardList cardList = (CardList) other;
        return Intrinsics.areEqual(this.object, cardList.object) && this.total_cards == cardList.total_cards && Intrinsics.areEqual(this.data, cardList.data);
    }

    public final List<Card> getData() {
        return this.data;
    }

    public final String getObject() {
        return this.object;
    }

    public final int getTotal_cards() {
        return this.total_cards;
    }

    public int hashCode() {
        int iHashCode = ((this.object.hashCode() * 31) + Integer.hashCode(this.total_cards)) * 31;
        List<Card> list = this.data;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "CardList(object=" + this.object + ", total_cards=" + this.total_cards + ", data=" + this.data + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.object);
        dest.writeInt(this.total_cards);
        List<Card> list = this.data;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list.size());
        Iterator<Card> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
