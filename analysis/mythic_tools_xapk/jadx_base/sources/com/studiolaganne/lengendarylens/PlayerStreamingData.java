package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerStreamingData;", "", "name", "", "life", "", "commander", "Lcom/studiolaganne/lengendarylens/CommanderData;", "partner", "poisonCounter", "timer", "results", "", "commanderDamage", "", "<init>", "(Ljava/lang/String;ILcom/studiolaganne/lengendarylens/CommanderData;Lcom/studiolaganne/lengendarylens/CommanderData;IILjava/util/List;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getLife", "()I", "getCommander", "()Lcom/studiolaganne/lengendarylens/CommanderData;", "getPartner", "getPoisonCounter", "getTimer", "getResults", "()Ljava/util/List;", "getCommanderDamage", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PlayerStreamingData {
    public static final int $stable = 8;

    @SerializedName("commander")
    private final CommanderData commander;

    @SerializedName("commander_damage")
    private final Map<String, Integer> commanderDamage;

    @SerializedName("life")
    private final int life;

    @SerializedName("name")
    private final String name;

    @SerializedName("partner")
    private final CommanderData partner;

    @SerializedName("poison_counter")
    private final int poisonCounter;

    @SerializedName("results")
    private final List<Integer> results;

    @SerializedName("timer")
    private final int timer;

    public PlayerStreamingData(String name, int i, CommanderData commanderData, CommanderData commanderData2, int i2, int i3, List<Integer> results, Map<String, Integer> commanderDamage) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(results, "results");
        Intrinsics.checkNotNullParameter(commanderDamage, "commanderDamage");
        this.name = name;
        this.life = i;
        this.commander = commanderData;
        this.partner = commanderData2;
        this.poisonCounter = i2;
        this.timer = i3;
        this.results = results;
        this.commanderDamage = commanderDamage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerStreamingData copy$default(PlayerStreamingData playerStreamingData, String str, int i, CommanderData commanderData, CommanderData commanderData2, int i2, int i3, List list, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = playerStreamingData.name;
        }
        if ((i4 & 2) != 0) {
            i = playerStreamingData.life;
        }
        if ((i4 & 4) != 0) {
            commanderData = playerStreamingData.commander;
        }
        if ((i4 & 8) != 0) {
            commanderData2 = playerStreamingData.partner;
        }
        if ((i4 & 16) != 0) {
            i2 = playerStreamingData.poisonCounter;
        }
        if ((i4 & 32) != 0) {
            i3 = playerStreamingData.timer;
        }
        if ((i4 & 64) != 0) {
            list = playerStreamingData.results;
        }
        if ((i4 & 128) != 0) {
            map = playerStreamingData.commanderDamage;
        }
        List list2 = list;
        Map map2 = map;
        int i5 = i2;
        int i6 = i3;
        return playerStreamingData.copy(str, i, commanderData, commanderData2, i5, i6, list2, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLife() {
        return this.life;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CommanderData getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CommanderData getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPoisonCounter() {
        return this.poisonCounter;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTimer() {
        return this.timer;
    }

    public final List<Integer> component7() {
        return this.results;
    }

    public final Map<String, Integer> component8() {
        return this.commanderDamage;
    }

    public final PlayerStreamingData copy(String name, int life, CommanderData commander, CommanderData partner, int poisonCounter, int timer, List<Integer> results, Map<String, Integer> commanderDamage) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(results, "results");
        Intrinsics.checkNotNullParameter(commanderDamage, "commanderDamage");
        return new PlayerStreamingData(name, life, commander, partner, poisonCounter, timer, results, commanderDamage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerStreamingData)) {
            return false;
        }
        PlayerStreamingData playerStreamingData = (PlayerStreamingData) other;
        return Intrinsics.areEqual(this.name, playerStreamingData.name) && this.life == playerStreamingData.life && Intrinsics.areEqual(this.commander, playerStreamingData.commander) && Intrinsics.areEqual(this.partner, playerStreamingData.partner) && this.poisonCounter == playerStreamingData.poisonCounter && this.timer == playerStreamingData.timer && Intrinsics.areEqual(this.results, playerStreamingData.results) && Intrinsics.areEqual(this.commanderDamage, playerStreamingData.commanderDamage);
    }

    public final CommanderData getCommander() {
        return this.commander;
    }

    public final Map<String, Integer> getCommanderDamage() {
        return this.commanderDamage;
    }

    public final int getLife() {
        return this.life;
    }

    public final String getName() {
        return this.name;
    }

    public final CommanderData getPartner() {
        return this.partner;
    }

    public final int getPoisonCounter() {
        return this.poisonCounter;
    }

    public final List<Integer> getResults() {
        return this.results;
    }

    public final int getTimer() {
        return this.timer;
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + Integer.hashCode(this.life)) * 31;
        CommanderData commanderData = this.commander;
        int iHashCode2 = (iHashCode + (commanderData == null ? 0 : commanderData.hashCode())) * 31;
        CommanderData commanderData2 = this.partner;
        return ((((((((iHashCode2 + (commanderData2 != null ? commanderData2.hashCode() : 0)) * 31) + Integer.hashCode(this.poisonCounter)) * 31) + Integer.hashCode(this.timer)) * 31) + this.results.hashCode()) * 31) + this.commanderDamage.hashCode();
    }

    public String toString() {
        return "PlayerStreamingData(name=" + this.name + ", life=" + this.life + ", commander=" + this.commander + ", partner=" + this.partner + ", poisonCounter=" + this.poisonCounter + ", timer=" + this.timer + ", results=" + this.results + ", commanderDamage=" + this.commanderDamage + ")";
    }
}
