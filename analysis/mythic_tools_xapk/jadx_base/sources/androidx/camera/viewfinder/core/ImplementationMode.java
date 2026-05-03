package androidx.camera.viewfinder.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ImplementationMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Landroidx/camera/viewfinder/core/ImplementationMode;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "EXTERNAL", "EMBEDDED", "getId", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImplementationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImplementationMode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int id;
    public static final ImplementationMode EXTERNAL = new ImplementationMode("EXTERNAL", 0, 0);
    public static final ImplementationMode EMBEDDED = new ImplementationMode("EMBEDDED", 1, 1);

    /* JADX INFO: compiled from: ImplementationMode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/viewfinder/core/ImplementationMode$Companion;", "", "<init>", "()V", "fromId", "Landroidx/camera/viewfinder/core/ImplementationMode;", "id", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ImplementationMode fromId(int id) {
            for (ImplementationMode implementationMode : ImplementationMode.values()) {
                if (implementationMode.id == id) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + id);
        }
    }

    private static final /* synthetic */ ImplementationMode[] $values() {
        return new ImplementationMode[]{EXTERNAL, EMBEDDED};
    }

    static {
        ImplementationMode[] implementationModeArr$values = $values();
        $VALUES = implementationModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(implementationModeArr$values);
        INSTANCE = new Companion(null);
    }

    private ImplementationMode(String str, int i, int i2) {
        this.id = i2;
    }

    @JvmStatic
    public static final ImplementationMode fromId(int i) {
        return INSTANCE.fromId(i);
    }

    public static EnumEntries<ImplementationMode> getEntries() {
        return $ENTRIES;
    }

    public static ImplementationMode valueOf(String str) {
        return (ImplementationMode) Enum.valueOf(ImplementationMode.class, str);
    }

    public static ImplementationMode[] values() {
        return (ImplementationMode[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
