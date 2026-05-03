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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/Rules;", "Landroid/os/Parcelable;", "object", "", "has_more", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "Lcom/studiolaganne/lengendarylens/Ruling;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getObject", "()Ljava/lang/String;", "getHas_more", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/Rules;", "describeContents", "", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Rules implements Parcelable {
    private final List<Ruling> data;
    private final Boolean has_more;
    private final String object;
    public static final Parcelable.Creator<Rules> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Rules> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Rules createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList arrayList = null;
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(Ruling.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new Rules(string, boolValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Rules[] newArray(int i) {
            return new Rules[i];
        }
    }

    public Rules() {
        this(null, null, null, 7, null);
    }

    public Rules(String str, Boolean bool, List<Ruling> list) {
        this.object = str;
        this.has_more = bool;
        this.data = list;
    }

    public /* synthetic */ Rules(String str, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Rules copy$default(Rules rules, String str, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rules.object;
        }
        if ((i & 2) != 0) {
            bool = rules.has_more;
        }
        if ((i & 4) != 0) {
            list = rules.data;
        }
        return rules.copy(str, bool, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getObject() {
        return this.object;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final List<Ruling> component3() {
        return this.data;
    }

    public final Rules copy(String object, Boolean has_more, List<Ruling> data) {
        return new Rules(object, has_more, data);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rules)) {
            return false;
        }
        Rules rules = (Rules) other;
        return Intrinsics.areEqual(this.object, rules.object) && Intrinsics.areEqual(this.has_more, rules.has_more) && Intrinsics.areEqual(this.data, rules.data);
    }

    public final List<Ruling> getData() {
        return this.data;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final String getObject() {
        return this.object;
    }

    public int hashCode() {
        String str = this.object;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.has_more;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        List<Ruling> list = this.data;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Rules(object=" + this.object + ", has_more=" + this.has_more + ", data=" + this.data + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.object);
        Boolean bool = this.has_more;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<Ruling> list = this.data;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list.size());
        Iterator<Ruling> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
