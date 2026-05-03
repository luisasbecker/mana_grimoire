package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetSymbolsEmbeddings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/SetEmbedding;", "", "scryfallId", "", OptionalModuleUtils.FACE, "", "embedding", "", "norm", "", "<init>", "(Ljava/lang/String;I[FF)V", "getScryfallId", "()Ljava/lang/String;", "getFace", "()I", "getEmbedding", "()[F", "getNorm", "()F", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SetEmbedding {
    public static final int $stable = 8;
    private final float[] embedding;
    private final int face;
    private final float norm;
    private final String scryfallId;

    public SetEmbedding(String scryfallId, int i, float[] embedding, float f) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(embedding, "embedding");
        this.scryfallId = scryfallId;
        this.face = i;
        this.embedding = embedding;
        this.norm = f;
    }

    public static /* synthetic */ SetEmbedding copy$default(SetEmbedding setEmbedding, String str, int i, float[] fArr, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = setEmbedding.scryfallId;
        }
        if ((i2 & 2) != 0) {
            i = setEmbedding.face;
        }
        if ((i2 & 4) != 0) {
            fArr = setEmbedding.embedding;
        }
        if ((i2 & 8) != 0) {
            f = setEmbedding.norm;
        }
        return setEmbedding.copy(str, i, fArr, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float[] getEmbedding() {
        return this.embedding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getNorm() {
        return this.norm;
    }

    public final SetEmbedding copy(String scryfallId, int face, float[] embedding, float norm) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(embedding, "embedding");
        return new SetEmbedding(scryfallId, face, embedding, norm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetEmbedding)) {
            return false;
        }
        SetEmbedding setEmbedding = (SetEmbedding) other;
        return Intrinsics.areEqual(this.scryfallId, setEmbedding.scryfallId) && this.face == setEmbedding.face && Arrays.equals(this.embedding, setEmbedding.embedding);
    }

    public final float[] getEmbedding() {
        return this.embedding;
    }

    public final int getFace() {
        return this.face;
    }

    public final float getNorm() {
        return this.norm;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public int hashCode() {
        return (((this.scryfallId.hashCode() * 31) + this.face) * 31) + Arrays.hashCode(this.embedding);
    }

    public String toString() {
        return "SetEmbedding(scryfallId=" + this.scryfallId + ", face=" + this.face + ", embedding=" + Arrays.toString(this.embedding) + ", norm=" + this.norm + ")";
    }
}
