package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\t\u001a@\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\bH\u0000¨\u0006\u0010"}, d2 = {"applyIfNotNull", "Landroidx/compose/ui/Modifier;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "value", "value2", "modifier", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "conditional", "condition", "", "Lkotlin/Function1;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierExtensionsKt {
    public static final <T, V> Modifier applyIfNotNull(Modifier modifier, T t, V v, Function3<? super Modifier, ? super T, ? super V, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return (t == null || v == null) ? modifier : modifier.then(modifier2.invoke(Modifier.INSTANCE, t, v));
    }

    public static final <T> Modifier applyIfNotNull(Modifier modifier, T t, Function2<? super Modifier, ? super T, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return t != null ? modifier.then(modifier2.invoke(Modifier.INSTANCE, t)) : modifier;
    }

    public static final Modifier conditional(Modifier modifier, boolean z, Function1<? super Modifier, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return z ? modifier.then(modifier2.invoke(Modifier.INSTANCE)) : modifier;
    }
}
