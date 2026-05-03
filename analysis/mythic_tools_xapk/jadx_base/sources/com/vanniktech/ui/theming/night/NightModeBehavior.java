package com.vanniktech.ui.theming.night;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NightModeBehavior.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/vanniktech/ui/theming/night/NightModeBehavior;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO", "YES", "FOLLOW_SYSTEM", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NightModeBehavior {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NightModeBehavior[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final NightModeBehavior NO = new NightModeBehavior("NO", 0, 1);
    public static final NightModeBehavior YES = new NightModeBehavior("YES", 1, 2);
    public static final NightModeBehavior FOLLOW_SYSTEM = new NightModeBehavior("FOLLOW_SYSTEM", 2, -1);

    /* JADX INFO: compiled from: NightModeBehavior.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/vanniktech/ui/theming/night/NightModeBehavior$Companion;", "", "<init>", "()V", "list", "", "Lcom/vanniktech/ui/theming/night/NightModeBehavior;", "fromOrNull", "value", "", "(Ljava/lang/Integer;)Lcom/vanniktech/ui/theming/night/NightModeBehavior;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NightModeBehavior fromOrNull(Integer value) {
            for (NightModeBehavior nightModeBehavior : NightModeBehavior.values()) {
                int value2 = nightModeBehavior.getValue();
                if (value != null && value2 == value.intValue()) {
                    return nightModeBehavior;
                }
            }
            return null;
        }

        public final List<NightModeBehavior> list() {
            return ArraysKt.toList(NightModeBehavior.values());
        }
    }

    private static final /* synthetic */ NightModeBehavior[] $values() {
        return new NightModeBehavior[]{NO, YES, FOLLOW_SYSTEM};
    }

    static {
        NightModeBehavior[] nightModeBehaviorArr$values = $values();
        $VALUES = nightModeBehaviorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(nightModeBehaviorArr$values);
        INSTANCE = new Companion(null);
    }

    private NightModeBehavior(String str, int i, int i2) {
        this.value = i2;
    }

    public static EnumEntries<NightModeBehavior> getEntries() {
        return $ENTRIES;
    }

    public static NightModeBehavior valueOf(String str) {
        return (NightModeBehavior) Enum.valueOf(NightModeBehavior.class, str);
    }

    public static NightModeBehavior[] values() {
        return (NightModeBehavior[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
