package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aJ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006\u001a!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0080\b\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0014\"\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001a\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001d\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020 8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010!\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020#8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010$\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020&8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010'\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020)8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010*\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020,8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010-\"\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"TwoWayConverter", "Landroidx/compose/animation/core/TwoWayConverter;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "lerp", "", "start", "stop", "fraction", "VectorConverter", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlin/Float$Companion;", "getVectorConverter", "(Lkotlin/jvm/internal/FloatCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "FloatToVector", "IntToVector", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "DpToVector", "DpOffsetToVector", "SizeToVector", "OffsetToVector", "IntOffsetToVector", "IntSizeToVector", "RectToVector", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VectorConvertersKt {
    private static final TwoWayConverter<Float, AnimationVector1D> FloatToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.FloatToVector$lambda$0(((Float) obj).floatValue());
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Float.valueOf(((AnimationVector1D) obj).getValue());
        }
    });
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.IntToVector$lambda$0(((Integer) obj).intValue());
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Integer.valueOf(VectorConvertersKt.IntToVector$lambda$1((AnimationVector1D) obj));
        }
    });
    private static final TwoWayConverter<Dp, AnimationVector1D> DpToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.DpToVector$lambda$0((Dp) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Dp.m9112boximpl(Dp.m9114constructorimpl(((AnimationVector1D) obj).getValue()));
        }
    });
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.DpOffsetToVector$lambda$0((DpOffset) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.DpOffsetToVector$lambda$1((AnimationVector2D) obj);
        }
    });
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.SizeToVector$lambda$0((Size) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.SizeToVector$lambda$1((AnimationVector2D) obj);
        }
    });
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.OffsetToVector$lambda$0((Offset) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.OffsetToVector$lambda$1((AnimationVector2D) obj);
        }
    });
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.IntOffsetToVector$lambda$0((IntOffset) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            AnimationVector2D animationVector2D = (AnimationVector2D) obj;
            return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl((((long) Math.round(animationVector2D.getV1())) << 32) | (((long) Math.round(animationVector2D.getV2())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        }
    });
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.IntSizeToVector$lambda$0((IntSize) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.IntSizeToVector$lambda$1((AnimationVector2D) obj);
        }
    });
    private static final TwoWayConverter<Rect, AnimationVector4D> RectToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.RectToVector$lambda$0((Rect) obj);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return VectorConvertersKt.RectToVector$lambda$1((AnimationVector4D) obj);
        }
    });

    static final AnimationVector2D DpOffsetToVector$lambda$0(DpOffset dpOffset) {
        return new AnimationVector2D(DpOffset.m9175getXD9Ej5fM(dpOffset.m9183unboximpl()), DpOffset.m9177getYD9Ej5fM(dpOffset.m9183unboximpl()));
    }

    static final DpOffset DpOffsetToVector$lambda$1(AnimationVector2D animationVector2D) {
        float fM9114constructorimpl = Dp.m9114constructorimpl(animationVector2D.getV1());
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(animationVector2D.getV2());
        return DpOffset.m9169boximpl(DpOffset.m9170constructorimpl((((long) Float.floatToRawIntBits(fM9114constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM9114constructorimpl2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    static final AnimationVector1D DpToVector$lambda$0(Dp dp) {
        return new AnimationVector1D(dp.m9128unboximpl());
    }

    static final AnimationVector1D FloatToVector$lambda$0(float f) {
        return new AnimationVector1D(f);
    }

    static final AnimationVector2D IntOffsetToVector$lambda$0(IntOffset intOffset) {
        return new AnimationVector2D(IntOffset.m9242getXimpl(intOffset.m9251unboximpl()), IntOffset.m9243getYimpl(intOffset.m9251unboximpl()));
    }

    static final AnimationVector2D IntSizeToVector$lambda$0(IntSize intSize) {
        return new AnimationVector2D((int) (intSize.m9289unboximpl() >> 32), (int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    static final IntSize IntSizeToVector$lambda$1(AnimationVector2D animationVector2D) {
        int iRound = Math.round(animationVector2D.getV1());
        if (iRound < 0) {
            iRound = 0;
        }
        int iRound2 = Math.round(animationVector2D.getV2());
        return IntSize.m9277boximpl(IntSize.m9280constructorimpl((((long) (iRound2 >= 0 ? iRound2 : 0)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iRound) << 32)));
    }

    static final AnimationVector1D IntToVector$lambda$0(int i) {
        return new AnimationVector1D(i);
    }

    static final int IntToVector$lambda$1(AnimationVector1D animationVector1D) {
        return (int) animationVector1D.getValue();
    }

    static final AnimationVector2D OffsetToVector$lambda$0(Offset offset) {
        return new AnimationVector2D(Float.intBitsToFloat((int) (offset.m6090unboximpl() >> 32)), Float.intBitsToFloat((int) (offset.m6090unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    static final Offset OffsetToVector$lambda$1(AnimationVector2D animationVector2D) {
        float v1 = animationVector2D.getV1();
        float v2 = animationVector2D.getV2();
        return Offset.m6069boximpl(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(v1)) << 32) | (((long) Float.floatToRawIntBits(v2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    static final AnimationVector4D RectToVector$lambda$0(Rect rect) {
        return new AnimationVector4D(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }

    static final Rect RectToVector$lambda$1(AnimationVector4D animationVector4D) {
        return new Rect(animationVector4D.getV1(), animationVector4D.getV2(), animationVector4D.getV3(), animationVector4D.getV4());
    }

    static final AnimationVector2D SizeToVector$lambda$0(Size size) {
        return new AnimationVector2D(Float.intBitsToFloat((int) (size.m6154unboximpl() >> 32)), Float.intBitsToFloat((int) (size.m6154unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    static final Size SizeToVector$lambda$1(AnimationVector2D animationVector2D) {
        float v1 = animationVector2D.getV1();
        float v2 = animationVector2D.getV2();
        return Size.m6137boximpl(Size.m6140constructorimpl((((long) Float.floatToRawIntBits(v1)) << 32) | (((long) Float.floatToRawIntBits(v2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    public static final <T, V extends AnimationVector> TwoWayConverter<T, V> TwoWayConverter(Function1<? super T, ? extends V> function1, Function1<? super V, ? extends T> function12) {
        return new TwoWayConverterImpl(function1, function12);
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(Offset.Companion companion) {
        return OffsetToVector;
    }

    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(Rect.Companion companion) {
        return RectToVector;
    }

    public static final TwoWayConverter<Size, AnimationVector2D> getVectorConverter(Size.Companion companion) {
        return SizeToVector;
    }

    public static final TwoWayConverter<Dp, AnimationVector1D> getVectorConverter(Dp.Companion companion) {
        return DpToVector;
    }

    public static final TwoWayConverter<DpOffset, AnimationVector2D> getVectorConverter(DpOffset.Companion companion) {
        return DpOffsetToVector;
    }

    public static final TwoWayConverter<IntOffset, AnimationVector2D> getVectorConverter(IntOffset.Companion companion) {
        return IntOffsetToVector;
    }

    public static final TwoWayConverter<IntSize, AnimationVector2D> getVectorConverter(IntSize.Companion companion) {
        return IntSizeToVector;
    }

    public static final TwoWayConverter<Float, AnimationVector1D> getVectorConverter(FloatCompanionObject floatCompanionObject) {
        return FloatToVector;
    }

    public static final TwoWayConverter<Integer, AnimationVector1D> getVectorConverter(IntCompanionObject intCompanionObject) {
        return IntToVector;
    }

    public static final float lerp(float f, float f2, float f3) {
        return (f * (1.0f - f3)) + (f2 * f3);
    }
}
