package io.customer.tracking.migration.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: QueueTaskType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/customer/tracking/migration/type/QueueTaskType;", "", "<init>", "(Ljava/lang/String;I)V", "IdentifyProfile", "TrackEvent", "RegisterDeviceToken", "DeletePushToken", "TrackPushMetric", "TrackDeliveryEvent", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueTaskType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QueueTaskType[] $VALUES;
    public static final QueueTaskType IdentifyProfile = new QueueTaskType("IdentifyProfile", 0);
    public static final QueueTaskType TrackEvent = new QueueTaskType("TrackEvent", 1);
    public static final QueueTaskType RegisterDeviceToken = new QueueTaskType("RegisterDeviceToken", 2);
    public static final QueueTaskType DeletePushToken = new QueueTaskType("DeletePushToken", 3);
    public static final QueueTaskType TrackPushMetric = new QueueTaskType("TrackPushMetric", 4);
    public static final QueueTaskType TrackDeliveryEvent = new QueueTaskType("TrackDeliveryEvent", 5);

    private static final /* synthetic */ QueueTaskType[] $values() {
        return new QueueTaskType[]{IdentifyProfile, TrackEvent, RegisterDeviceToken, DeletePushToken, TrackPushMetric, TrackDeliveryEvent};
    }

    static {
        QueueTaskType[] queueTaskTypeArr$values = $values();
        $VALUES = queueTaskTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(queueTaskTypeArr$values);
    }

    private QueueTaskType(String str, int i) {
    }

    public static EnumEntries<QueueTaskType> getEntries() {
        return $ENTRIES;
    }

    public static QueueTaskType valueOf(String str) {
        return (QueueTaskType) Enum.valueOf(QueueTaskType.class, str);
    }

    public static QueueTaskType[] values() {
        return (QueueTaskType[]) $VALUES.clone();
    }
}
