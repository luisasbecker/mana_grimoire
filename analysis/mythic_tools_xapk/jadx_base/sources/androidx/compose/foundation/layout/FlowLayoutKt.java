package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u001a2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a=\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010*\u001aT\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0082\b\u001a\u0091\u0001\u00103\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0083\b\u001a[\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0002¢\u0006\u0002\u0010<\u001a\u0096\u0001\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001aY\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010M\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002\u001a\u001c\u0010P\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u00104\u001a\u00020\u000bH\u0000\u001a\u001c\u0010S\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u0010/\u001a\u00020\u000bH\u0000\u001a9\u0010Z\u001a\u000207*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020[2\u0014\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001aQ\u0010`\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W\"\u0014\u0010X\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010W¨\u0006i"}, d2 = {"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", FirebaseAnalytics.Param.ITEMS, "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(Alignment.INSTANCE.getStart());

    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        int i7;
        Alignment.Horizontal start;
        int i8;
        int i9;
        int i10;
        int i11;
        final Modifier modifier2;
        final Arrangement.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        Composer composer2;
        final int i12;
        final int i13;
        final FlowColumnOverflow flowColumnOverflow2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        Arrangement.Horizontal start2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1944405121);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)214@9466L53,216@9552L234,225@9840L294,231@10139L75:FlowLayout.kt#2w3rfo");
        int i15 = i4 & 1;
        if (i15 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i16 = i4 & 2;
        if (i16 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                vertical2 = vertical;
                i5 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(horizontal) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        start = horizontal2;
                        i5 |= composerStartRestartGroup.changed(start) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 != 0) {
                        if ((i3 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(flowColumnOverflow) ? 1048576 : 524288;
                        }
                        if ((i3 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            Modifier.Companion companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Vertical top = i16 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                            if (i6 != 0) {
                                start2 = Arrangement.INSTANCE.getStart();
                                i14 = i7;
                            } else {
                                i14 = i7;
                                start2 = horizontal;
                            }
                            if (i14 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            }
                            int i17 = i8 != 0 ? Integer.MAX_VALUE : i9;
                            int i18 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            FlowColumnOverflow clip = i11 != 0 ? FlowColumnOverflow.INSTANCE.getClip() : flowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                            int i19 = 3670016 & i5;
                            boolean z = i19 == 1048576;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            MultiContentMeasurePolicy multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i17, i18, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & 65534);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                            boolean z2 = (i19 == 1048576) | ((29360128 & i5) == 8388608) | ((i5 & 458752) == 131072);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }));
                                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Modifier modifier3 = companion;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                horizontal3 = start2;
                                i12 = i17;
                                i13 = i18;
                                modifier2 = modifier3;
                                composer2 = composerStartRestartGroup;
                                flowColumnOverflow2 = clip;
                                vertical3 = top;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            horizontal3 = horizontal;
                            vertical3 = vertical2;
                            composer2 = composerStartRestartGroup;
                            i12 = i9;
                            i13 = i2;
                            flowColumnOverflow2 = flowColumnOverflow;
                        }
                        final Alignment.Horizontal horizontal4 = start;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i12, i13, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 24576;
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    final Alignment.Horizontal horizontal42 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                start = horizontal2;
                i8 = i4 & 16;
                if (i8 != 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                final Alignment.Horizontal horizontal422 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            start = horizontal2;
            i8 = i4 & 16;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            final Alignment.Horizontal horizontal4222 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        vertical2 = vertical;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        start = horizontal2;
        i8 = i4 & 16;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        final Alignment.Horizontal horizontal42222 = start;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Alignment.Horizontal horizontal3;
        final Modifier modifier3;
        final Arrangement.Vertical vertical3;
        final int i12;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        Arrangement.Vertical top;
        int i14;
        Alignment.Horizontal start;
        Composer composerStartRestartGroup = composer.startRestartGroup(1371845627);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,content)271@11939L226:FlowLayout.kt#2w3rfo");
        int i15 = i4 & 1;
        if (i15 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        int i16 = i4 & 2;
        if (i16 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                vertical2 = vertical;
                i5 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(horizontal) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(horizontal2) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i3 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 == 0) {
                            if ((196608 & i3) == 0) {
                                i11 = i2;
                                i5 |= composerStartRestartGroup.changed(i11) ? 131072 : 65536;
                            }
                            if ((i3 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                horizontal3 = horizontal2;
                                modifier3 = modifier2;
                                vertical3 = vertical2;
                                i12 = i11;
                                horizontal4 = horizontal;
                            } else {
                                Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i16 != 0) {
                                    top = Arrangement.INSTANCE.getTop();
                                    i13 = i7;
                                } else {
                                    i13 = i7;
                                    top = vertical2;
                                }
                                Arrangement.Horizontal start2 = i6 != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
                                if (i13 != 0) {
                                    start = Alignment.INSTANCE.getStart();
                                    i14 = i8;
                                } else {
                                    i14 = i8;
                                    start = horizontal2;
                                }
                                if (i14 != 0) {
                                    i9 = Integer.MAX_VALUE;
                                }
                                int i17 = i10 != 0 ? Integer.MAX_VALUE : i11;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                                }
                                composer2 = composerStartRestartGroup;
                                FlowColumn(modifier4, top, start2, start, i9, i17, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                vertical3 = top;
                                horizontal4 = start2;
                                horizontal3 = start;
                                i12 = i17;
                            }
                            final int i18 = i9;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i18, i12, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i11 = i2;
                        if ((i3 & 1572864) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        final int i182 = i9;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 == 0) {
                    }
                    i11 = i2;
                    if ((i3 & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    final int i1822 = i9;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 == 0) {
                }
                i11 = i2;
                if ((i3 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                final int i18222 = i9;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 == 0) {
            }
            i11 = i2;
            if ((i3 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            final int i182222 = i9;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        vertical2 = vertical;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 == 0) {
        }
        i11 = i2;
        if ((i3 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        final int i1822222 = i9;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C227@10017L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1720407857, i, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:227)");
            }
            function3.invoke(FlowColumnScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit FlowColumn$lambda$2(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, flowColumnOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    static final Unit FlowColumn$lambda$3(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        int i7;
        Alignment.Vertical top;
        int i8;
        int i9;
        int i10;
        int i11;
        final Modifier modifier2;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        Composer composer2;
        final int i12;
        final int i13;
        final FlowRowOverflow flowRowOverflow2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        Arrangement.Vertical top2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1956591841);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)100@4511L53,102@4597L226,111@4877L291,118@5174L75:FlowLayout.kt#2w3rfo");
        int i15 = i4 & 1;
        if (i15 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i16 = i4 & 2;
        if (i16 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                horizontal2 = horizontal;
                i5 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(vertical) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        top = vertical2;
                        i5 |= composerStartRestartGroup.changed(top) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 != 0) {
                        if ((i3 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(flowRowOverflow) ? 1048576 : 524288;
                        }
                        if ((i3 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            Modifier.Companion companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Horizontal start = i16 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                            if (i6 != 0) {
                                top2 = Arrangement.INSTANCE.getTop();
                                i14 = i7;
                            } else {
                                i14 = i7;
                                top2 = vertical;
                            }
                            if (i14 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            }
                            int i17 = i8 != 0 ? Integer.MAX_VALUE : i9;
                            int i18 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            FlowRowOverflow clip = i11 != 0 ? FlowRowOverflow.INSTANCE.getClip() : flowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                            int i19 = 3670016 & i5;
                            boolean z = i19 == 1048576;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            MultiContentMeasurePolicy multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i17, i18, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & 65534);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                            boolean z2 = (i19 == 1048576) | ((29360128 & i5) == 8388608) | ((i5 & 458752) == 131072);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }));
                                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Modifier modifier3 = companion;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                vertical3 = top2;
                                i12 = i17;
                                i13 = i18;
                                modifier2 = modifier3;
                                composer2 = composerStartRestartGroup;
                                flowRowOverflow2 = clip;
                                horizontal3 = start;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            vertical3 = vertical;
                            horizontal3 = horizontal2;
                            composer2 = composerStartRestartGroup;
                            i12 = i9;
                            i13 = i2;
                            flowRowOverflow2 = flowRowOverflow;
                        }
                        final Alignment.Vertical vertical4 = top;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i12, i13, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 24576;
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    final Alignment.Vertical vertical42 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                top = vertical2;
                i8 = i4 & 16;
                if (i8 != 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                final Alignment.Vertical vertical422 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            top = vertical2;
            i8 = i4 & 16;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            final Alignment.Vertical vertical4222 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        horizontal2 = horizontal;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        top = vertical2;
        i8 = i4 & 16;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        final Alignment.Vertical vertical42222 = top;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Alignment.Vertical vertical3;
        final Modifier modifier3;
        final Arrangement.Horizontal horizontal3;
        final int i12;
        final Arrangement.Vertical vertical4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        Arrangement.Horizontal start;
        int i14;
        Alignment.Vertical top;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1303174015);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,content)162@7315L215:FlowLayout.kt#2w3rfo");
        int i15 = i4 & 1;
        if (i15 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        int i16 = i4 & 2;
        if (i16 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                horizontal2 = horizontal;
                i5 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(vertical) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(vertical2) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i3 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 == 0) {
                            if ((196608 & i3) == 0) {
                                i11 = i2;
                                i5 |= composerStartRestartGroup.changed(i11) ? 131072 : 65536;
                            }
                            if ((i3 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                vertical3 = vertical2;
                                modifier3 = modifier2;
                                horizontal3 = horizontal2;
                                i12 = i11;
                                vertical4 = vertical;
                            } else {
                                Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i16 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                    i13 = i7;
                                } else {
                                    i13 = i7;
                                    start = horizontal2;
                                }
                                Arrangement.Vertical top2 = i6 != 0 ? Arrangement.INSTANCE.getTop() : vertical;
                                if (i13 != 0) {
                                    top = Alignment.INSTANCE.getTop();
                                    i14 = i8;
                                } else {
                                    i14 = i8;
                                    top = vertical2;
                                }
                                if (i14 != 0) {
                                    i9 = Integer.MAX_VALUE;
                                }
                                int i17 = i10 != 0 ? Integer.MAX_VALUE : i11;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                                }
                                composer2 = composerStartRestartGroup;
                                FlowRow(modifier4, start, top2, top, i9, i17, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                horizontal3 = start;
                                vertical4 = top2;
                                vertical3 = top;
                                i12 = i17;
                            }
                            final int i18 = i9;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i18, i12, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i11 = i2;
                        if ((i3 & 1572864) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        final int i182 = i9;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 == 0) {
                    }
                    i11 = i2;
                    if ((i3 & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    final int i1822 = i9;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 == 0) {
                }
                i11 = i2;
                if ((i3 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                final int i18222 = i9;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 == 0) {
            }
            i11 = i2;
            if ((i3 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            final int i182222 = i9;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        horizontal2 = horizontal;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 == 0) {
        }
        i11 = i2;
        if ((i3 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        final int i1822222 = i9;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5051L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1192950673, i, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:113)");
            }
            function3.invoke(FlowRowScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit FlowRow$lambda$2(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, flowRowOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    static final Unit FlowRow$lambda$3(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m1957breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f, float f2, long j, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i3;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        MutableIntObjectMap mutableIntObjectMap;
        int i4;
        int i5;
        MeasureScope measureScope2;
        int[] iArr;
        FlowLineMeasurePolicy flowLineMeasurePolicy2;
        int[] iArr2;
        long j2;
        int i6;
        int i7;
        int i8;
        MutableIntObjectMap mutableIntObjectMap2;
        IntIntPair intIntPairM1240boximpl;
        int i9;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i10;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        int i11;
        boolean z;
        int i12;
        int i13;
        FlowLayoutData flowLayoutData;
        MeasureScope measureScope3 = measureScope;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(j);
        int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
        int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(j);
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope3.mo1624toPx0680j_4(f));
        int iCeil2 = (int) Math.ceil(measureScope3.mo1624toPx0680j_4(f2));
        long jM2004constructorimpl = OrientationIndependentConstraints.m2004constructorimpl(0, iM9067getMaxWidthimpl, 0, iM9066getMaxHeightimpl);
        long jM2019toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m2019toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m2008copyyUG9Ft0$default(jM2004constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope3.mo1621toDpu2uoSUM(iM9067getMaxWidthimpl), measureScope3.mo1621toDpu2uoSUM(iM9066getMaxHeightimpl), null) : null;
        Measurable measurableSafeNext = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
        IntIntPair intIntPairM1240boximpl2 = measurableSafeNext != null ? IntIntPair.m1240boximpl(m1958measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy, jM2019toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.breakDownItems_di9J0FM$lambda$0$0(objectRef, (Placeable) obj);
            }
        })) : null;
        Integer numValueOf = intIntPairM1240boximpl2 != null ? Integer.valueOf(IntIntPair.m1247getFirstimpl(intIntPairM1240boximpl2.getPackedValue())) : null;
        Integer numValueOf2 = intIntPairM1240boximpl2 != null ? Integer.valueOf(IntIntPair.m1248getSecondimpl(intIntPairM1240boximpl2.getPackedValue())) : null;
        Integer numValueOf3 = numValueOf;
        Measurable measurable = measurableSafeNext;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j, i2, iCeil, iCeil2, null);
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1954getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(it2.hasNext(), 0, IntIntPair.m1243constructorimpl(iM9067getMaxWidthimpl, iM9066getMaxHeightimpl), intIntPairM1240boximpl2, 0, 0, 0, false, false);
        if (wrapInfoM1954getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1954getWrapInfoOpUlnko, intIntPairM1240boximpl2 != null, -1, 0, iM9067getMaxWidthimpl, 0);
            i3 = iM9067getMaxWidthimpl;
        } else {
            i3 = iM9067getMaxWidthimpl;
            wrapEllipsisInfo = null;
        }
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i14 = i3;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoM1954getWrapInfoOpUlnko;
        int iMax = iM9069getMinWidthimpl;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z2 = false;
        int i18 = 0;
        int i19 = 0;
        MutableIntSet mutableIntSet = mutableIntSetMutableIntSetOf;
        int i20 = iM9066getMaxHeightimpl;
        Measurable measurableSafeNext2 = measurable;
        int i21 = 0;
        while (!wrapInfo.getIsLastItemInContainer() && measurableSafeNext2 != null) {
            Intrinsics.checkNotNull(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            Intrinsics.checkNotNull(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i22 = i3;
            int i23 = i17 + iIntValue;
            int iMax2 = Math.max(i16, numValueOf2.intValue());
            int i24 = i14 - iIntValue;
            int i25 = i15 + 1;
            int i26 = iMax;
            flowLayoutOverflowState.setItemShown$foundation_layout(i25);
            arrayList.add(measurableSafeNext2);
            mutableIntObjectMapMutableIntObjectMapOf.set(i15, objectRef.element);
            Object parentData = measurableSafeNext2.getParentData();
            RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) != null) {
                z2 = true;
            }
            int i27 = i25 - i21;
            boolean z3 = i27 < i;
            if (flowLineInfo != null) {
                if (z3) {
                    i8 = i27;
                    i11 = i18;
                } else {
                    i8 = i27;
                    i11 = i18 + 1;
                }
                int i28 = z3 ? i8 : 0;
                if (z3) {
                    int i29 = i24 - iCeil;
                    z = z3;
                    i12 = i29 < 0 ? 0 : i29;
                } else {
                    z = z3;
                    i12 = i22;
                }
                float f3 = measureScope3.mo1621toDpu2uoSUM(i12);
                if (z) {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i13 = i20;
                } else {
                    int i30 = (i20 - iMax2) - iCeil2;
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i13 = i30 < 0 ? 0 : i30;
                }
                flowLineInfo.m1970update4j6BHR0$foundation_layout(i11, i28, f3, measureScope3.mo1621toDpu2uoSUM(i13));
                Unit unit = Unit.INSTANCE;
            } else {
                i8 = i27;
                mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
            }
            measurableSafeNext2 = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
            objectRef.element = null;
            IntIntPair intIntPairM1240boximpl3 = measurableSafeNext2 != null ? IntIntPair.m1240boximpl(m1958measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy, jM2019toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowLayoutKt.breakDownItems_di9J0FM$lambda$2$0(objectRef, (Placeable) obj);
                }
            })) : null;
            Integer numValueOf4 = intIntPairM1240boximpl3 != null ? Integer.valueOf(IntIntPair.m1247getFirstimpl(intIntPairM1240boximpl3.getPackedValue()) + iCeil) : null;
            numValueOf2 = intIntPairM1240boximpl3 != null ? Integer.valueOf(IntIntPair.m1248getSecondimpl(intIntPairM1240boximpl3.getPackedValue())) : null;
            boolean zHasNext = it2.hasNext();
            int i31 = i18;
            long jM1243constructorimpl = IntIntPair.m1243constructorimpl(i24, i20);
            if (intIntPairM1240boximpl3 == null) {
                intIntPairM1240boximpl = null;
            } else {
                Intrinsics.checkNotNull(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                Intrinsics.checkNotNull(numValueOf2);
                intIntPairM1240boximpl = IntIntPair.m1240boximpl(IntIntPair.m1243constructorimpl(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1954getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(zHasNext, i8, jM1243constructorimpl, intIntPairM1240boximpl, i31, i19, iMax2, false, false);
            if (wrapInfoM1954getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int iMin = Math.min(Math.max(i26, i23), i22);
                int i32 = i19 + iMax2;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1954getWrapInfoOpUlnko2, intIntPairM1240boximpl3 != null, i31, i32, i24, i8);
                mutableIntList2 = mutableIntList6;
                mutableIntList2.add(iMax2);
                MutableIntSet mutableIntSet2 = mutableIntSet;
                if (z2) {
                    mutableIntSet2.plusAssign(i31);
                }
                int i33 = (iM9066getMaxHeightimpl - i32) - iCeil2;
                mutableIntSet = mutableIntSet2;
                mutableIntList = mutableIntList5;
                mutableIntList.add(i25);
                i18 = i31 + 1;
                i19 = i32 + iCeil2;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                i22 = i22;
                i21 = i25;
                i23 = 0;
                z2 = false;
                i9 = 0;
                i10 = iMin;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                i20 = i33;
                i14 = i22;
            } else {
                i9 = iMax2;
                mutableIntList = mutableIntList5;
                mutableIntList2 = mutableIntList6;
                numValueOf3 = numValueOf4;
                i14 = i24;
                i18 = i31;
                i10 = i26;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            mutableIntList5 = mutableIntList;
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            mutableIntSet = mutableIntSet;
            iMax = i10;
            i15 = i25;
            mutableIntObjectMapMutableIntObjectMapOf = mutableIntObjectMap2;
            wrapInfo = wrapInfoM1954getWrapInfoOpUlnko2;
            it2 = it;
            mutableIntList4 = mutableIntList2;
            i17 = i23;
            i3 = i22;
            i16 = i9;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapMutableIntObjectMapOf;
        MutableIntList mutableIntList7 = mutableIntList4;
        MutableIntList mutableIntList8 = mutableIntList5;
        MutableIntSet mutableIntSet3 = mutableIntSet;
        if (wrapEllipsisInfo3 != null) {
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            MutableIntList mutableIntList9 = mutableIntList8;
            int i34 = mutableIntList9._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int i35 = mutableIntList9._size - 1;
                mutableIntList7.set(i34, Math.max(mutableIntList7.get(i34), IntIntPair.m1248getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList8.set(i35, mutableIntList8.last() + 1);
                Unit unit2 = Unit.INSTANCE;
            } else {
                mutableIntList7.add(IntIntPair.m1248getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                Boolean.valueOf(mutableIntList8.add(mutableIntList8.last() + 1));
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size = arrayList.size();
        ?? r4 = new Placeable[size];
        for (int i36 = 0; i36 < size; i36++) {
            r4[i36] = mutableIntObjectMap.get(i36);
        }
        MutableIntList mutableIntList10 = mutableIntList8;
        int[] iArr3 = new int[mutableIntList10._size];
        int[] iArr4 = new int[mutableIntList10._size];
        int[] iArr5 = mutableIntList10.content;
        int i37 = mutableIntList10._size;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        ?? r42 = r4;
        while (i39 < i37) {
            int i41 = iArr5[i39];
            int iM9066getMaxHeightimpl2 = mutableIntList7.get(i39);
            if (!mutableIntSet3.contains(i39)) {
                iM9066getMaxHeightimpl2 = Constraints.m9066getMaxHeightimpl(jM2004constructorimpl) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Constraints.m9066getMaxHeightimpl(jM2004constructorimpl) - i40;
            }
            int i42 = i37;
            MutableIntSet mutableIntSet4 = mutableIntSet3;
            int[] iArr6 = iArr3;
            ?? r8 = r42;
            MutableIntList mutableIntList11 = mutableIntList7;
            MeasureResult measureResultMeasure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, iMax, Constraints.m9068getMinHeightimpl(jM2004constructorimpl), Constraints.m9067getMaxWidthimpl(jM2004constructorimpl), iM9066getMaxHeightimpl2, iCeil, measureScope3, arrayList, r8, i38, i41, iArr6, i39);
            if (flowLineMeasurePolicy.isHorizontal()) {
                i6 = measureResultMeasure.getWidth();
                i7 = measureResultMeasure.getHeight();
            } else {
                i6 = measureResultMeasure.getHeight();
                i7 = measureResultMeasure.getWidth();
            }
            iArr4[i39] = i7;
            i40 += i7;
            iMax = Math.max(iMax, i6);
            mutableVector.add(measureResultMeasure);
            i39++;
            r42 = r8;
            i38 = i41;
            iArr3 = iArr6;
            i37 = i42;
            mutableIntSet3 = mutableIntSet4;
            mutableIntList7 = mutableIntList11;
            measureScope3 = measureScope;
        }
        int[] iArr7 = iArr3;
        if (mutableVector.getSize() == 0) {
            i4 = 0;
            i5 = 0;
            measureScope2 = measureScope;
            j2 = j;
            iArr = iArr7;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr2 = iArr4;
        } else {
            i4 = iMax;
            i5 = i40;
            measureScope2 = measureScope;
            iArr = iArr7;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr2 = iArr4;
            j2 = j;
        }
        return m1959placeHelperBmaY500(measureScope2, j2, i4, i5, iArr2, mutableVector, flowLineMeasurePolicy2, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$0$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$2$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2013098357, "C(columnMeasurementHelper)N(verticalArrangement,horizontalArrangement,maxItemsInMainAxis)501@19939L850:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1852231075, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1981measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -308635847, "C(columnMeasurementMultiContentHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState)529@21138L715:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-308635847, i3, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -246294460, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.changed(horizontal2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        return z ? intrinsicMeasurable.minIntrinsicHeight(i) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i6;
        if (list.isEmpty()) {
            return IntIntPair.m1243constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m2004constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int iIntValue = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue)).intValue() : 0;
        int i7 = 0;
        int iMax = 0;
        if (flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m1243constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m1240boximpl(IntIntPair.m1243constructorimpl(iIntValue2, iIntValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM1962ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m1962ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m1243constructorimpl(intIntPairM1962ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m1248getSecondimpl(intIntPairM1962ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i8 = i;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = iMax;
            if (i9 >= size) {
                i6 = i10;
                break;
            }
            int i14 = i8 - iIntValue2;
            int i15 = i9 + 1;
            iMax = Math.max(i13, iIntValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i15);
            int iIntValue3 = intrinsicMeasurable2 != null ? function32.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(i)).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(iIntValue3)).intValue() + i2 : 0;
            int i16 = i15 - i11;
            i6 = i15;
            int i17 = i12;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1954getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(i9 + 2 < list.size(), i16, IntIntPair.m1243constructorimpl(i14, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m1240boximpl(IntIntPair.m1243constructorimpl(iIntValue4, iIntValue3)), i17, i7, iMax, false, false);
            if (wrapInfoM1954getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM1248getSecondimpl = i7 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1954getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i17, iM1248getSecondimpl, i14, i16);
                iIntValue4 -= i2;
                i12 = i17 + 1;
                if (wrapInfoM1954getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM1248getSecondimpl += IntIntPair.m1248getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i7 = iM1248getSecondimpl;
                } else {
                    i8 = i;
                    i11 = i6;
                    i7 = iM1248getSecondimpl;
                    iMax = 0;
                }
            } else {
                i8 = i14;
                i12 = i17;
            }
            iIntValue2 = iIntValue4;
            iIntValue = iIntValue3;
            i9 = i6;
            i10 = i9;
        }
        return IntIntPair.m1243constructorimpl(i7 - i3, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return IntIntPair.m1243constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m2004constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int i6 = intrinsicMeasurable != null ? iArr2[0] : 0;
        int i7 = intrinsicMeasurable != null ? iArr[0] : 0;
        int i8 = 0;
        if (flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m1243constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m1240boximpl(IntIntPair.m1243constructorimpl(i7, i6)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM1962ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m1962ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m1243constructorimpl(intIntPairM1962ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m1248getSecondimpl(intIntPairM1962ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i9 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            int i15 = i9 - i7;
            int i16 = i10 + 1;
            int iMax = Math.max(i14, i6);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i16);
            int i17 = intrinsicMeasurable2 != null ? iArr2[i16] : 0;
            int i18 = intrinsicMeasurable2 != null ? iArr[i16] + i2 : 0;
            int i19 = i16 - i12;
            int i20 = i13;
            int i21 = i17;
            int i22 = i18;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1954getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1954getWrapInfoOpUlnko(i10 + 2 < list.size(), i19, IntIntPair.m1243constructorimpl(i15, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m1240boximpl(IntIntPair.m1243constructorimpl(i18, i17)), i20, i8, iMax, false, false);
            if (wrapInfoM1954getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM1248getSecondimpl = i8 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1954getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i20, iM1248getSecondimpl, i15, i19);
                int i23 = i22 - i2;
                i13 = i20 + 1;
                if (wrapInfoM1954getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM1248getSecondimpl += IntIntPair.m1248getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i8 = iM1248getSecondimpl;
                    i11 = i16;
                } else {
                    i14 = 0;
                    i8 = iM1248getSecondimpl;
                    i7 = i23;
                    i12 = i16;
                    i9 = i;
                }
            } else {
                i9 = i15;
                i13 = i20;
                i14 = iMax;
                i7 = i22;
            }
            i10 = i16;
            i11 = i10;
            i6 = i21;
        }
        return IntIntPair.m1243constructorimpl(i8 - i3, i11);
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        return z ? intrinsicMeasurable.minIntrinsicWidth(i) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int iIntValue = function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i7 = i4 + 1;
            if (i7 - i5 == i3 || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iIntValue) - i2);
                i6 = 0;
                i5 = i4;
            } else {
                i6 += iIntValue;
            }
            i4 = i7;
        }
        return iMax;
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m1958measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j, Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        Measurable measurable2 = measurable;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable2)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable2);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
                function1.invoke(placeableMo7769measureBRTryo0);
                return IntIntPair.m1243constructorimpl(flowLineMeasurePolicy.mainAxisSize(placeableMo7769measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(placeableMo7769measureBRTryo0));
            }
        }
        int iMainAxisMin = mainAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m1243constructorimpl(iMainAxisMin, crossAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), iMainAxisMin));
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int i6 = i4;
        int i7 = i5;
        if (list2.isEmpty()) {
            return 0;
        }
        int size = list2.size();
        int[] iArr = new int[size];
        int size2 = list2.size();
        int[] iArr2 = new int[size2];
        int size3 = list2.size();
        for (int i8 = 0; i8 < size3; i8++) {
            IntrinsicMeasurable intrinsicMeasurable = list2.get(i8);
            int iIntValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(i)).intValue();
            iArr[i8] = iIntValue;
            iArr2[i8] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(iIntValue)).intValue();
        }
        int i9 = Integer.MAX_VALUE;
        if (i7 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
            i9 = i6 * i7;
        }
        int i10 = 1;
        int iMin = Math.min(i9 - (((i9 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i9 < list2.size() || i7 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout() || flowLayoutOverflowState.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list2.size());
        int iSum = ArraysKt.sum(iArr) + ((list2.size() - 1) * i2);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int iM1247getFirstimpl = iArr2[0];
        int lastIndex = ArraysKt.getLastIndex(iArr2);
        if (1 <= lastIndex) {
            int i11 = 1;
            while (true) {
                int i12 = iArr2[i11];
                if (iM1247getFirstimpl < i12) {
                    iM1247getFirstimpl = i12;
                }
                if (i11 == lastIndex) {
                    break;
                }
                i11++;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i13 = iArr[0];
        int lastIndex2 = ArraysKt.getLastIndex(iArr);
        if (1 <= lastIndex2) {
            while (true) {
                int i14 = iArr[i10];
                if (i13 < i14) {
                    i13 = i14;
                }
                if (i10 == lastIndex2) {
                    break;
                }
                i10++;
            }
        }
        int i15 = i13;
        int i16 = iSum;
        while (i15 <= i16 && iM1247getFirstimpl != i) {
            int i17 = (i15 + i16) / 2;
            long jIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i17, i2, i3, i6, i7, flowLayoutOverflowState);
            iM1247getFirstimpl = IntIntPair.m1247getFirstimpl(jIntrinsicCrossAxisSize);
            int iM1248getSecondimpl = IntIntPair.m1248getSecondimpl(jIntrinsicCrossAxisSize);
            if (iM1247getFirstimpl > i || iM1248getSecondimpl < iMin) {
                i15 = i17 + 1;
                if (i15 > i16) {
                    return i15;
                }
            } else {
                if (iM1247getFirstimpl >= i) {
                    return i17;
                }
                i16 = i17 - 1;
            }
            list2 = list;
            i6 = i4;
            i7 = i5;
            iSum = i17;
        }
        return iSum;
    }

    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m1959placeHelperBmaY500(MeasureScope measureScope, long j, int i, int i2, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int iM9066getMaxHeightimpl;
        int i3;
        int i4;
        boolean zIsHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (zIsHorizontal) {
            int i5 = i2 + (measureScope.mo1618roundToPx0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(j);
            iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(j);
            if (i5 < iM9068getMinHeightimpl) {
                i5 = iM9068getMinHeightimpl;
            }
            if (i5 <= iM9066getMaxHeightimpl) {
                iM9066getMaxHeightimpl = i5;
            }
            verticalArrangement.arrange(measureScope, iM9066getMaxHeightimpl, iArr, iArr2);
        } else {
            int i6 = i2 + (measureScope.mo1618roundToPx0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM9068getMinHeightimpl2 = Constraints.m9068getMinHeightimpl(j);
            int iM9066getMaxHeightimpl2 = Constraints.m9066getMaxHeightimpl(j);
            if (i6 < iM9068getMinHeightimpl2) {
                i6 = iM9068getMinHeightimpl2;
            }
            int i7 = i6 > iM9066getMaxHeightimpl2 ? iM9066getMaxHeightimpl2 : i6;
            horizontalArrangement.arrange(measureScope, i7, iArr, measureScope.getLayoutDirection(), iArr2);
            iM9066getMaxHeightimpl = i7;
        }
        int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
        int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(j);
        if (i < iM9069getMinWidthimpl) {
            i = iM9069getMinWidthimpl;
        }
        if (i <= iM9067getMaxWidthimpl) {
            iM9067getMaxWidthimpl = i;
        }
        if (zIsHorizontal) {
            i4 = iM9067getMaxWidthimpl;
            i3 = iM9066getMaxHeightimpl;
        } else {
            i3 = iM9067getMaxWidthimpl;
            i4 = iM9066getMaxHeightimpl;
        }
        return MeasureScope.layout$default(measureScope, i4, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.placeHelper_BmaY500$lambda$2(mutableVector, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeHelper_BmaY500$lambda$2(MutableVector mutableVector, Placeable.PlacementScope placementScope) {
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            ((MeasureResult) objArr[i]).placeChildren();
        }
        return Unit.INSTANCE;
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1479255111, "C(rowMeasurementHelper)N(horizontalArrangement,verticalArrangement,maxItemsInMainAxis)440@17697L893:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -70006556, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1981measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2010142641, "C(rowMeasurementMultiContentHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState)471@18969L708:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2010142641, i3, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 988216051, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.changed(vertical2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (!(it instanceof ContextualFlowItemIterator)) {
                return it.next();
            }
            Intrinsics.checkNotNull(flowLineInfo);
            return ((ContextualFlowItemIterator) it).getNext$foundation_layout(flowLineInfo);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
