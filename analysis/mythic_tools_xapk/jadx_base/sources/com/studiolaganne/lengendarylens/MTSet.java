package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSet;", "", "id", "", "game", "outOf", "tags", "", "Lcom/studiolaganne/lengendarylens/MTTag;", "note", "", "<init>", "(IIILjava/util/List;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getGame", "setGame", "getOutOf", "setOutOf", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getNote", "()Ljava/lang/String;", "setNote", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSet {
    public static final int $stable = 8;
    private int game;
    private int id;
    private String note;
    private int outOf;
    private List<MTTag> tags;

    public MTSet() {
        this(0, 0, 0, null, null, 31, null);
    }

    public MTSet(int i, int i2, int i3, List<MTTag> list, String str) {
        this.id = i;
        this.game = i2;
        this.outOf = i3;
        this.tags = list;
        this.note = str;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTSet(int r2, int r3, int r4, java.util.List r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L5
            r2 = -1
        L5:
            r8 = r7 & 2
            if (r8 == 0) goto La
            r3 = 0
        La:
            r8 = r7 & 4
            if (r8 == 0) goto Lf
            r4 = 3
        Lf:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L15
            r5 = r0
        L15:
            r7 = r7 & 16
            if (r7 == 0) goto L20
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L26
        L20:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L26:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTSet.<init>(int, int, int, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSet copy$default(MTSet mTSet, int i, int i2, int i3, List list, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mTSet.id;
        }
        if ((i4 & 2) != 0) {
            i2 = mTSet.game;
        }
        if ((i4 & 4) != 0) {
            i3 = mTSet.outOf;
        }
        if ((i4 & 8) != 0) {
            list = mTSet.tags;
        }
        if ((i4 & 16) != 0) {
            str = mTSet.note;
        }
        String str2 = str;
        int i5 = i3;
        return mTSet.copy(i, i2, i5, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGame() {
        return this.game;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getOutOf() {
        return this.outOf;
    }

    public final List<MTTag> component4() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final MTSet copy(int id, int game, int outOf, List<MTTag> tags, String note) {
        return new MTSet(id, game, outOf, tags, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSet)) {
            return false;
        }
        MTSet mTSet = (MTSet) other;
        return this.id == mTSet.id && this.game == mTSet.game && this.outOf == mTSet.outOf && Intrinsics.areEqual(this.tags, mTSet.tags) && Intrinsics.areEqual(this.note, mTSet.note);
    }

    public final int getGame() {
        return this.game;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public final int getOutOf() {
        return this.outOf;
    }

    public final List<MTTag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.game)) * 31) + Integer.hashCode(this.outOf)) * 31;
        List<MTTag> list = this.tags;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.note;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setGame(int i) {
        this.game = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setNote(String str) {
        this.note = str;
    }

    public final void setOutOf(int i) {
        this.outOf = i;
    }

    public final void setTags(List<MTTag> list) {
        this.tags = list;
    }

    public String toString() {
        return "MTSet(id=" + this.id + ", game=" + this.game + ", outOf=" + this.outOf + ", tags=" + this.tags + ", note=" + this.note + ")";
    }
}
