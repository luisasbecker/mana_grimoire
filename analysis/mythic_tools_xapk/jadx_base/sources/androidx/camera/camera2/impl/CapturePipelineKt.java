package androidx.camera.camera2.impl;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"CHECK_FLASH_REQUIRED_TIMEOUT_IN_NS", "", "CHECK_3A_TIMEOUT_IN_NS", "CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS", "CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CapturePipelineKt {
    private static final long CHECK_FLASH_REQUIRED_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(1);
    private static final long CHECK_3A_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(1);
    private static final long CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(5);
    private static final long CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(2);
}
