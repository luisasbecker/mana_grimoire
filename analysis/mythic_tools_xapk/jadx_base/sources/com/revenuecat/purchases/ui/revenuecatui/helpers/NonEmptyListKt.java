package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NonEmptyList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0006\u001aH\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00010\b0\u0001H\u0000\u001a \u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"nonEmptyListOf", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "head", "t", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "flatten", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "B", "toNonEmptyListOrNull", "", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class NonEmptyListKt {
    public static final /* synthetic */ Result flatten(NonEmptyList nonEmptyList) {
        Intrinsics.checkNotNullParameter(nonEmptyList, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<A> it = nonEmptyList.iterator();
        while (it.hasNext()) {
            Result result = (Result) it.next();
            if (result instanceof Result.Success) {
                if (arrayList2.isEmpty()) {
                    arrayList.add(((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList2.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = toNonEmptyListOrNull(arrayList2);
        Result.Success error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList);
        if (error instanceof Result.Success) {
            NonEmptyList nonEmptyListOrNull2 = toNonEmptyListOrNull((List) ((Result.Success) error).getValue());
            Intrinsics.checkNotNull(nonEmptyListOrNull2);
            return new Result.Success(nonEmptyListOrNull2);
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ NonEmptyList nonEmptyListOf(Object obj, Object... t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return new NonEmptyList(obj, ArraysKt.toList(t));
    }

    public static final /* synthetic */ NonEmptyList toNonEmptyListOrNull(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return new NonEmptyList(it.next(), CollectionsKt.toList(new NonEmptyListKt$toNonEmptyListOrNull$$inlined$Iterable$1(it)));
        }
        return null;
    }
}
