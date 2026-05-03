package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/CounterDefinition;", "", "name", "", "type", "Lcom/studiolaganne/lengendarylens/CounterType;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/CounterType;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/studiolaganne/lengendarylens/CounterType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CounterDefinition {
    public static final int $stable = 0;
    private final String name;
    private final CounterType type;

    public CounterDefinition(String name, CounterType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
    }

    public static /* synthetic */ CounterDefinition copy$default(CounterDefinition counterDefinition, String str, CounterType counterType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = counterDefinition.name;
        }
        if ((i & 2) != 0) {
            counterType = counterDefinition.type;
        }
        return counterDefinition.copy(str, counterType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CounterType getType() {
        return this.type;
    }

    public final CounterDefinition copy(String name, CounterType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new CounterDefinition(name, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounterDefinition)) {
            return false;
        }
        CounterDefinition counterDefinition = (CounterDefinition) other;
        return Intrinsics.areEqual(this.name, counterDefinition.name) && this.type == counterDefinition.type;
    }

    public final String getName() {
        return this.name;
    }

    public final CounterType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "CounterDefinition(name=" + this.name + ", type=" + this.type + ")";
    }
}
