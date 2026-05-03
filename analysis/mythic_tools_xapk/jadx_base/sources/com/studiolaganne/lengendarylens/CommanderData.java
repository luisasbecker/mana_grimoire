package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/CommanderData;", "", "name", "", "scryfallId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getScryfallId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommanderData {
    public static final int $stable = 0;

    @SerializedName("name")
    private final String name;

    @SerializedName("scryfallid")
    private final String scryfallId;

    public CommanderData(String name, String scryfallId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        this.name = name;
        this.scryfallId = scryfallId;
    }

    public static /* synthetic */ CommanderData copy$default(CommanderData commanderData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commanderData.name;
        }
        if ((i & 2) != 0) {
            str2 = commanderData.scryfallId;
        }
        return commanderData.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final CommanderData copy(String name, String scryfallId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        return new CommanderData(name, scryfallId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommanderData)) {
            return false;
        }
        CommanderData commanderData = (CommanderData) other;
        return Intrinsics.areEqual(this.name, commanderData.name) && Intrinsics.areEqual(this.scryfallId, commanderData.scryfallId);
    }

    public final String getName() {
        return this.name;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.scryfallId.hashCode();
    }

    public String toString() {
        return "CommanderData(name=" + this.name + ", scryfallId=" + this.scryfallId + ")";
    }
}
