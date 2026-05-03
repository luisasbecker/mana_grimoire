package androidx.compose.material3.adaptive;

import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Posture.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00110\u00012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0082\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005\"\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\"\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005\"\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0016"}, d2 = {"separatingVerticalHingeBounds", "", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/material3/adaptive/Posture;", "getSeparatingVerticalHingeBounds", "(Landroidx/compose/material3/adaptive/Posture;)Ljava/util/List;", "occludingVerticalHingeBounds", "getOccludingVerticalHingeBounds", "allVerticalHingeBounds", "getAllVerticalHingeBounds", "separatingHorizontalHingeBounds", "getSeparatingHorizontalHingeBounds", "occludingHorizontalHingeBounds", "getOccludingHorizontalHingeBounds", "allHorizontalHingeBounds", "getAllHorizontalHingeBounds", "getBounds", "Landroidx/compose/material3/adaptive/HingeInfo;", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "adaptive"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PostureKt {
    public static final List<Rect> getAllHorizontalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = !hingeInfo.getIsVertical() ? hingeInfo.getBounds() : null;
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    public static final List<Rect> getAllVerticalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = hingeInfo.getIsVertical() ? hingeInfo.getBounds() : null;
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    private static final List<Rect> getBounds(List<HingeInfo> list, Function1<? super HingeInfo, Boolean> function1) {
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : list) {
            Rect bounds = function1.invoke(hingeInfo).booleanValue() ? hingeInfo.getBounds() : null;
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    public static final List<Rect> getOccludingHorizontalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = (hingeInfo.getIsVertical() || !hingeInfo.getIsOccluding()) ? null : hingeInfo.getBounds();
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    public static final List<Rect> getOccludingVerticalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = (hingeInfo.getIsVertical() && hingeInfo.getIsOccluding()) ? hingeInfo.getBounds() : null;
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    public static final List<Rect> getSeparatingHorizontalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = (hingeInfo.getIsVertical() || !hingeInfo.getIsSeparating()) ? null : hingeInfo.getBounds();
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }

    public static final List<Rect> getSeparatingVerticalHingeBounds(Posture posture) {
        List<HingeInfo> hingeList = posture.getHingeList();
        ArrayList arrayList = new ArrayList();
        for (HingeInfo hingeInfo : hingeList) {
            Rect bounds = (hingeInfo.getIsVertical() && hingeInfo.getIsSeparating()) ? hingeInfo.getBounds() : null;
            if (bounds != null) {
                arrayList.add(bounds);
            }
        }
        return arrayList;
    }
}
