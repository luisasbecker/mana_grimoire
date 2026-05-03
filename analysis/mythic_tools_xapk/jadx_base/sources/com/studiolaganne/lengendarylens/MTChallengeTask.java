package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTChallengeTask;", "", "id", "", "name", "description", "localization", "", "Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", "completed", "", "completed_at", "validated", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getLocalization", "()Ljava/util/List;", "getCompleted", "()Z", "getCompleted_at", "getValidated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTChallengeTask {
    public static final int $stable = 8;
    private final boolean completed;
    private final String completed_at;
    private final String description;
    private final String id;
    private final List<MTEntryLocalization> localization;
    private final String name;
    private final boolean validated;

    public MTChallengeTask(String id, String name, String str, List<MTEntryLocalization> localization, boolean z, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        this.id = id;
        this.name = name;
        this.description = str;
        this.localization = localization;
        this.completed = z;
        this.completed_at = str2;
        this.validated = z2;
    }

    public /* synthetic */ MTChallengeTask(String str, String str2, String str3, List list, boolean z, String str4, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, list, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTChallengeTask copy$default(MTChallengeTask mTChallengeTask, String str, String str2, String str3, List list, boolean z, String str4, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTChallengeTask.id;
        }
        if ((i & 2) != 0) {
            str2 = mTChallengeTask.name;
        }
        if ((i & 4) != 0) {
            str3 = mTChallengeTask.description;
        }
        if ((i & 8) != 0) {
            list = mTChallengeTask.localization;
        }
        if ((i & 16) != 0) {
            z = mTChallengeTask.completed;
        }
        if ((i & 32) != 0) {
            str4 = mTChallengeTask.completed_at;
        }
        if ((i & 64) != 0) {
            z2 = mTChallengeTask.validated;
        }
        String str5 = str4;
        boolean z3 = z2;
        boolean z4 = z;
        String str6 = str3;
        return mTChallengeTask.copy(str, str2, str6, list, z4, str5, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<MTEntryLocalization> component4() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCompleted_at() {
        return this.completed_at;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getValidated() {
        return this.validated;
    }

    public final MTChallengeTask copy(String id, String name, String description, List<MTEntryLocalization> localization, boolean completed, String completed_at, boolean validated) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        return new MTChallengeTask(id, name, description, localization, completed, completed_at, validated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTChallengeTask)) {
            return false;
        }
        MTChallengeTask mTChallengeTask = (MTChallengeTask) other;
        return Intrinsics.areEqual(this.id, mTChallengeTask.id) && Intrinsics.areEqual(this.name, mTChallengeTask.name) && Intrinsics.areEqual(this.description, mTChallengeTask.description) && Intrinsics.areEqual(this.localization, mTChallengeTask.localization) && this.completed == mTChallengeTask.completed && Intrinsics.areEqual(this.completed_at, mTChallengeTask.completed_at) && this.validated == mTChallengeTask.validated;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final String getCompleted_at() {
        return this.completed_at;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final List<MTEntryLocalization> getLocalization() {
        return this.localization;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getValidated() {
        return this.validated;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.localization.hashCode()) * 31) + Boolean.hashCode(this.completed)) * 31;
        String str2 = this.completed_at;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.validated);
    }

    public String toString() {
        return "MTChallengeTask(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", localization=" + this.localization + ", completed=" + this.completed + ", completed_at=" + this.completed_at + ", validated=" + this.validated + ")";
    }
}
