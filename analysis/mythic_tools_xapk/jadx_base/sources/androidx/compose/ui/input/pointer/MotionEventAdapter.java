package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ#\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000¢\u0006\u0002\b!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010'\u001a\u00020(*\u00020\u00192\u0006\u0010$\u001a\u00020\u0014H\u0002J\u0017\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010/\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui$annotations", "getMotionEventToComposePointerIdMap$ui", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousIndirectPointerEventData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "previousToolType", "", "previousSource", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui", "convertToIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "convertToIndirectPointerEvent-k92h6UU$ui", "endStream", "", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", FirebaseAnalytics.Param.INDEX, "pressed", "IndirectPointerEventData", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private final LongSparseArray<IndirectPointerEventData> previousIndirectPointerEventData = new LongSparseArray<>(0, 1, null);
    private int previousToolType = -1;
    private int previousSource = -1;

    /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005\u0088\u0001\u0002¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "", "packedValue", "", "constructor-impl", "(J)J", "uptime", "position", "Landroidx/compose/ui/geometry/Offset;", "down", "", "(JJZ)J", "getPackedValue", "()J", "getDown-impl", "(J)Z", "getUptime-impl", "getPosition-F1C5BW0", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    private static final class IndirectPointerEventData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long packedValue;

        /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData$Companion;", "", "<init>", "()V", "packShorts", "", "val1", "", "val2", "unpackShort1", "value", "unpackShort2", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int packShorts(short val1, short val2) {
                return (val1 << 16) | (65535 & val2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort1(int value) {
                return (short) (value >>> 16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort2(int value) {
                return (short) (65535 & value);
            }
        }

        private /* synthetic */ IndirectPointerEventData(long j) {
            this.packedValue = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IndirectPointerEventData m7558boximpl(long j) {
            return new IndirectPointerEventData(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m7559constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m7560constructorimpl(long j, long j2, boolean z) {
            return m7559constructorimpl(((j & SieveCacheKt.NodeLinkMask) << 1) | (z ? 1L : 0L) | (((long) INSTANCE.packShorts((short) Float.intBitsToFloat((int) (j2 >> 32)), (short) Float.intBitsToFloat((int) (j2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) << 32));
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7561equalsimpl(long j, Object obj) {
            return (obj instanceof IndirectPointerEventData) && j == ((IndirectPointerEventData) obj).m7568unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7562equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: getDown-impl, reason: not valid java name */
        public static final boolean m7563getDownimpl(long j) {
            return (j & 1) != 0;
        }

        /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
        public static final long m7564getPositionF1C5BW0(long j) {
            int i = (int) (j >>> 32);
            Companion companion = INSTANCE;
            float fUnpackShort1 = companion.unpackShort1(i);
            return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(companion.unpackShort2(i))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fUnpackShort1) << 32));
        }

        /* JADX INFO: renamed from: getUptime-impl, reason: not valid java name */
        public static final long m7565getUptimeimpl(long j) {
            return (j >> 1) & SieveCacheKt.NodeLinkMask;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7566hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7567toStringimpl(long j) {
            return "IndirectPointerEventData(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m7561equalsimpl(this.packedValue, obj);
        }

        public final long getPackedValue() {
            return this.packedValue;
        }

        public int hashCode() {
            return m7566hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m7567toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m7568unboximpl() {
            return this.packedValue;
        }
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui$default, reason: not valid java name */
    public static /* synthetic */ AndroidIndirectPointerEvent m7555convertToIndirectPointerEventk92h6UU$ui$default(MotionEventAdapter motionEventAdapter, MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, int i, Object obj) {
        if ((i & 2) != 0) {
            indirectPointerEventPrimaryDirectionalMotionAxis = null;
        }
        return motionEventAdapter.m7557convertToIndirectPointerEventk92h6UU$ui(motionEvent, indirectPointerEventPrimaryDirectionalMotionAxis);
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        long jMo7719screenToLocalMKHz9U;
        long jM7569toRawOffsetdBAh8RU;
        int i;
        long jM7556getComposePointerId_I2yYro = m7556getComposePointerId_I2yYro(motionEvent.getPointerId(index));
        float pressure = motionEvent.getPressure(index);
        float x = motionEvent.getX(index);
        float y = motionEvent.getY(index);
        long jFloatToRawIntBits = Float.floatToRawIntBits(x);
        long jFloatToRawIntBits2 = Float.floatToRawIntBits(y);
        char c = ' ';
        long j = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        long jM6072constructorimpl = Offset.m6072constructorimpl((jFloatToRawIntBits2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (jFloatToRawIntBits << 32));
        long jM6074copydBAh8RU$default = Offset.m6074copydBAh8RU$default(jM6072constructorimpl, 0.0f, 0.0f, 3, null);
        if (index == 0) {
            jM7569toRawOffsetdBAh8RU = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawY())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(motionEvent.getRawX())) << 32));
            jMo7719screenToLocalMKHz9U = positionCalculator.mo7719screenToLocalMKHz9U(jM7569toRawOffsetdBAh8RU);
        } else if (Build.VERSION.SDK_INT >= 29) {
            jM7569toRawOffsetdBAh8RU = MotionEventHelper.INSTANCE.m7569toRawOffsetdBAh8RU(motionEvent, index);
            jMo7719screenToLocalMKHz9U = positionCalculator.mo7719screenToLocalMKHz9U(jM7569toRawOffsetdBAh8RU);
        } else {
            long jMo7718localToScreenMKHz9U = positionCalculator.mo7718localToScreenMKHz9U(jM6072constructorimpl);
            jMo7719screenToLocalMKHz9U = jM6072constructorimpl;
            jM7569toRawOffsetdBAh8RU = jMo7718localToScreenMKHz9U;
        }
        int toolType = motionEvent.getToolType(index);
        int iM7717getUnknownT8wyACA = toolType != 0 ? toolType != 1 ? toolType != 2 ? toolType != 3 ? toolType != 4 ? PointerType.INSTANCE.m7717getUnknownT8wyACA() : PointerType.INSTANCE.m7713getEraserT8wyACA() : PointerType.INSTANCE.m7714getMouseT8wyACA() : PointerType.INSTANCE.m7715getStylusT8wyACA() : PointerType.INSTANCE.m7716getTouchT8wyACA() : PointerType.INSTANCE.m7717getUnknownT8wyACA();
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        int historySize = motionEvent.getHistorySize();
        int i2 = 0;
        while (i2 < historySize) {
            float historicalX = motionEvent.getHistoricalX(index, i2);
            float historicalY = motionEvent.getHistoricalY(index, i2);
            char c2 = c;
            long j2 = j;
            if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) >= 2139095040) {
                i = i2;
            } else {
                long jM6072constructorimpl2 = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(historicalX)) << c2) | (((long) Float.floatToRawIntBits(historicalY)) & j2));
                i = i2;
                arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i), jM6072constructorimpl2, jM6072constructorimpl2, null));
            }
            i2 = i + 1;
            c = c2;
            j = j2;
        }
        return new PointerInputEventData(jM7556getComposePointerId_I2yYro, motionEvent.getEventTime(), jM7569toRawOffsetdBAh8RU, jMo7719screenToLocalMKHz9U, pressed, pressure, iM7717getUnknownT8wyACA, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList, motionEvent.getActionMasked() == 8 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f)) & j) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c)) : Offset.INSTANCE.m6096getZeroF1C5BW0(), jM6074copydBAh8RU$default, null);
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m7556getComposePointerId_I2yYro(int motionEventPointerId) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            long j = this.nextId;
            this.nextId = 1 + j;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, j);
            jValueAt = j;
        }
        return PointerId.m7618constructorimpl(jValueAt);
    }

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui$annotations() {
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AndroidIndirectPointerEvent m7557convertToIndirectPointerEventk92h6UU$ui(MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride) {
        int i;
        MotionEventAdapter motionEventAdapter = this;
        int actionMasked = motionEvent.getActionMasked();
        clearOnDeviceChange(motionEvent);
        if (actionMasked == 3) {
            motionEventAdapter.motionEventToComposePointerIdMap.clear();
            motionEventAdapter.activeHoverIds.clear();
            return null;
        }
        addFreshIds(motionEvent);
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        boolean z = actionMasked == 0 || actionMasked == 2 || actionMasked == 5;
        int pointerCount = motionEvent.getPointerCount();
        ArrayList arrayList = new ArrayList(pointerCount);
        int i2 = 0;
        while (i2 < pointerCount) {
            long jM7556getComposePointerId_I2yYro = motionEventAdapter.m7556getComposePointerId_I2yYro(motionEvent.getPointerId(i2));
            long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getY(i2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(motionEvent.getX(i2))) << 32));
            boolean z2 = i2 != actionIndex;
            IndirectPointerEventData indirectPointerEventData = motionEventAdapter.previousIndirectPointerEventData.get(jM7556getComposePointerId_I2yYro);
            if (i2 == actionIndex) {
                motionEventAdapter.previousIndirectPointerEventData.remove(jM7556getComposePointerId_I2yYro);
            } else {
                if (z) {
                    i = actionMasked;
                    motionEventAdapter.previousIndirectPointerEventData.put(jM7556getComposePointerId_I2yYro, IndirectPointerEventData.m7558boximpl(IndirectPointerEventData.m7560constructorimpl(motionEvent.getEventTime(), jM6072constructorimpl, true)));
                }
                arrayList.add(new IndirectPointerInputChange(jM7556getComposePointerId_I2yYro, motionEvent.getEventTime(), jM6072constructorimpl, z2, motionEvent.getPressure(i2), indirectPointerEventData == null ? IndirectPointerEventData.m7565getUptimeimpl(indirectPointerEventData.m7568unboximpl()) : motionEvent.getEventTime(), indirectPointerEventData == null ? IndirectPointerEventData.m7564getPositionF1C5BW0(indirectPointerEventData.m7568unboximpl()) : jM6072constructorimpl, indirectPointerEventData == null ? IndirectPointerEventData.m7563getDownimpl(indirectPointerEventData.m7568unboximpl()) : false, null));
                i2++;
                motionEventAdapter = this;
                actionMasked = i;
            }
            i = actionMasked;
            arrayList.add(new IndirectPointerInputChange(jM7556getComposePointerId_I2yYro, motionEvent.getEventTime(), jM6072constructorimpl, z2, motionEvent.getPressure(i2), indirectPointerEventData == null ? IndirectPointerEventData.m7565getUptimeimpl(indirectPointerEventData.m7568unboximpl()) : motionEvent.getEventTime(), indirectPointerEventData == null ? IndirectPointerEventData.m7564getPositionF1C5BW0(indirectPointerEventData.m7568unboximpl()) : jM6072constructorimpl, indirectPointerEventData == null ? IndirectPointerEventData.m7563getDownimpl(indirectPointerEventData.m7568unboximpl()) : false, null));
            i2++;
            motionEventAdapter = this;
            actionMasked = i;
        }
        int i3 = actionMasked;
        ArrayList arrayList2 = arrayList;
        removeStaleIds(motionEvent);
        return new AndroidIndirectPointerEvent(arrayList2, AndroidIndirectPointerEvent_androidKt.convertActionToIndirectPointerEventType(i3), primaryDirectionalMotionAxisOverride != null ? primaryDirectionalMotionAxisOverride.getValue() : AndroidIndirectPointerEvent_androidKt.indirectPrimaryDirectionalScrollAxis(motionEvent), motionEvent, null);
    }

    public final PointerInputEvent convertToPointerInputEvent$ui(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, (z || i == actionIndex || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    /* JADX INFO: renamed from: getMotionEventToComposePointerIdMap$ui, reason: from getter */
    public final SparseLongArray getMotionEventToComposePointerIdMap() {
        return this.motionEventToComposePointerIdMap;
    }
}
