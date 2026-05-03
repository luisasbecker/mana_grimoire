package io.customer.sdk.core.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"enumValueOfOrNull", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", "(Ljava/lang/String;)Ljava/lang/Enum;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EnumUtilKt {
    public static final /* synthetic */ <T extends Enum<T>> T enumValueOfOrNull(String name) {
        Object objM11445constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
            objM11445constructorimpl = Result.m11445constructorimpl(Enum.valueOf(null, name));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (T) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }
}
