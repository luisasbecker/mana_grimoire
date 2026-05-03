package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001a\u001a\u008a\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001d\u001a~\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u00109\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010=\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2 = {"LazyVerticalGrid", "", "columns", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyHorizontalGrid", "rows", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass10 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(it)613@27741L22:LazyGridDsl.kt#7791vq");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179065086, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:613)");
            }
            this.$itemContent.invoke(lazyGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass2 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            this.$key = function1;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$key.invoke((T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, List<? extends T> list) {
            this.$span = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m2157boximpl(m2166invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m2166invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass4 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            this.$contentType = function1;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke((T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass5 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117249557, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
            }
            this.$itemContent.invoke(lazyGridItemScope, (T) this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass7 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> function1, T[] tArr) {
            this.$key = function1;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$key.invoke(this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass8 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, T[] tArr) {
            this.$span = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m2157boximpl(m2167invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m2167invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass9 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function1<? super T, ? extends Object> function1, T[] tArr) {
            this.$contentType = function1;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C036910 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C036910(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(it)650@29683L26:LazyGridDsl.kt#7791vq");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(49283819, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:650)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03702 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C03702(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            this.$key = function2;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03713 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C03713(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, List<? extends T> list) {
            this.$span = function3;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m2157boximpl(m2168invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m2168invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03724 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C03724(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            this.$contentType = function2;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03735 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C03735(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(it)576@25926L26:LazyGridDsl.kt#7791vq");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1942245546, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03757 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C03757(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            this.$key = function2;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03768 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C03768(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, T[] tArr) {
            this.$span = function3;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m2157boximpl(m2169invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m2169invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C03779 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C03779(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            this.$contentType = function2;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        LazyGridState lazyGridState2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Arrangement.Vertical vertical2;
        int i9;
        int i10;
        Composer composer2;
        final Arrangement.Horizontal horizontal2;
        final boolean z4;
        final Modifier modifier3;
        final LazyGridState lazyGridState3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Vertical vertical3;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LazyGridState lazyGridStateRememberLazyGridState;
        Arrangement.Horizontal start;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Modifier modifier4;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues4;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior4;
        boolean z6;
        boolean z7;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(635941664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)170@7824L48,169@7798L505:LazyGridDsl.kt#7791vq");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    int i13 = composerStartRestartGroup.changed(lazyGridState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i4 |= i13;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(horizontal)) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 != 0) {
                        if ((i & 1572864) == 0) {
                            i8 = 196608;
                            vertical2 = vertical;
                            i4 |= composerStartRestartGroup.changed(vertical2) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(overscrollEffect)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "158@7268L23,164@7625L15,166@7723L26");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i3 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState2;
                                }
                                PaddingValues paddingValuesM2030PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 32) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    start = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                    i4 &= -458753;
                                } else {
                                    start = horizontal;
                                }
                                top = i7 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z8 = i9 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier4 = companion;
                                    overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0);
                                } else {
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    modifier4 = companion;
                                }
                                lazyGridState4 = lazyGridStateRememberLazyGridState;
                                paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                horizontal3 = start;
                                flingBehavior4 = flingBehavior3;
                                z6 = z3;
                                z7 = z8;
                                i11 = 635941664;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                horizontal3 = horizontal;
                                flingBehavior4 = flingBehavior;
                                z7 = z2;
                                overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                lazyGridState4 = lazyGridState2;
                                paddingValues4 = paddingValues2;
                                z6 = z3;
                                top = vertical2;
                                i11 = 635941664;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i11, i4, i10, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
                            }
                            int i14 = i4 >> 15;
                            int i15 = i4 >> 3;
                            composer2 = composerStartRestartGroup;
                            Arrangement.Vertical vertical4 = top;
                            LazyGridKt.LazyGrid(modifier4, lazyGridState4, rememberRowHeightSums(gridCells, top, composerStartRestartGroup, (i4 & 14) | (i14 & 112)), paddingValues4, z6, false, flingBehavior4, z7, overscrollEffectRememberOverscrollEffect, vertical4, horizontal3, function1, composer2, (i15 & 234881024) | (i15 & 14) | i8 | (i15 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i15) | (29360128 & i15) | ((i4 << 9) & 1879048192), (i14 & 14) | ((i10 << 3) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            lazyGridState3 = lazyGridState4;
                            paddingValues3 = paddingValues4;
                            z5 = z6;
                            flingBehavior2 = flingBehavior4;
                            z4 = z7;
                            overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                            vertical3 = vertical4;
                            horizontal2 = horizontal3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal2 = horizontal;
                            z4 = z2;
                            modifier3 = modifier2;
                            lazyGridState3 = lazyGridState2;
                            paddingValues3 = paddingValues2;
                            z5 = z3;
                            vertical3 = vertical2;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LazyGridDslKt.LazyHorizontalGrid$lambda$0(gridCells, modifier3, lazyGridState3, paddingValues3, z5, horizontal2, vertical3, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    i8 = 196608;
                    vertical2 = vertical;
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                }
                i8 = 196608;
                vertical2 = vertical;
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            i8 = 196608;
            vertical2 = vertical;
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        i8 = 196608;
        vertical2 = vertical;
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyGridState lazyGridStateRememberLazyGridState;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Horizontal horizontal2;
        int i6;
        Arrangement.Vertical vertical2;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyGridState lazyGridState3;
        PaddingValues paddingValues4;
        Arrangement.Horizontal horizontal4;
        Arrangement.Vertical vertical4;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,content)210@9358L26,200@8966L452:LazyGridDsl.kt#7791vq");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                    int i11 = composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState) ? 256 : 128;
                    i3 |= i11;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                i3 |= i11;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            horizontal2 = horizontal;
                            int i12 = composerStartRestartGroup.changed(horizontal2) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            horizontal2 = horizontal;
                        }
                        i3 |= i12;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else {
                        if ((1572864 & i) == 0) {
                            vertical2 = vertical;
                            i3 |= composerStartRestartGroup.changed(vertical2) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i7 = i2 & 256;
                        if (i7 == 0) {
                            if ((i & 100663296) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                flingBehavior2 = flingBehavior;
                                lazyGridState2 = lazyGridStateRememberLazyGridState;
                                paddingValues3 = paddingValues2;
                                z4 = z3;
                                horizontal3 = horizontal2;
                                vertical3 = vertical2;
                                z5 = z2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "190@8506L23,196@8863L15");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                        i3 &= -897;
                                    }
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        start = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                        i3 &= -458753;
                                    } else {
                                        start = horizontal2;
                                    }
                                    Arrangement.Vertical top = i6 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                                    if ((i2 & 128) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    if (i8 != 0) {
                                        modifier3 = companion;
                                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                                        paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                        vertical4 = top;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        i9 = 2123608858;
                                        horizontal4 = start;
                                    } else {
                                        z6 = z2;
                                        modifier3 = companion;
                                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                                        paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                        horizontal4 = start;
                                        vertical4 = top;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        i9 = 2123608858;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    modifier3 = modifier;
                                    flingBehavior4 = flingBehavior;
                                    z6 = z2;
                                    paddingValues4 = paddingValues2;
                                    z7 = z3;
                                    horizontal4 = horizontal2;
                                    vertical4 = vertical2;
                                    i9 = 2123608858;
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
                                }
                                composer2 = composerStartRestartGroup;
                                LazyHorizontalGrid(gridCells, modifier3, lazyGridState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyGridState2 = lazyGridState3;
                                paddingValues3 = paddingValues4;
                                z4 = z7;
                                horizontal3 = horizontal4;
                                vertical3 = vertical4;
                                flingBehavior2 = flingBehavior4;
                                z5 = z6;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return LazyGridDslKt.LazyHorizontalGrid$lambda$1(gridCells, modifier2, lazyGridState2, paddingValues3, z4, horizontal3, vertical3, flingBehavior2, z5, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i8 = i7;
                        if ((i & 805306368) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    vertical2 = vertical;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    if ((i & 805306368) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                vertical2 = vertical;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i & 805306368) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            vertical2 = vertical;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i & 805306368) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        vertical2 = vertical;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i & 805306368) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit LazyHorizontalGrid$lambda$0(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyHorizontalGrid(gridCells, modifier, lazyGridState, paddingValues, z, horizontal, vertical, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit LazyHorizontalGrid$lambda$1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyHorizontalGrid(gridCells, modifier, lazyGridState, paddingValues, z, horizontal, vertical, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        LazyGridState lazyGridState2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Arrangement.Horizontal horizontal2;
        int i9;
        int i10;
        Composer composer2;
        final Arrangement.Vertical vertical2;
        final boolean z4;
        final Modifier modifier3;
        final LazyGridState lazyGridState3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Horizontal horizontal3;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LazyGridState lazyGridStateRememberLazyGridState;
        Arrangement.Vertical top;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Modifier modifier4;
        LazyGridState lazyGridState4;
        PaddingValues paddingValues4;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior4;
        boolean z6;
        boolean z7;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2072102870);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)81@3849L55,80@3823L511:LazyGridDsl.kt#7791vq");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    int i13 = composerStartRestartGroup.changed(lazyGridState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i4 |= i13;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(vertical)) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 != 0) {
                        if ((i & 1572864) == 0) {
                            i8 = 196608;
                            horizontal2 = horizontal;
                            i4 |= composerStartRestartGroup.changed(horizontal2) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(overscrollEffect)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "69@3290L23,75@3650L15,77@3748L26");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i3 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState2;
                                }
                                PaddingValues paddingValuesM2030PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 32) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    top = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                    i4 &= -458753;
                                } else {
                                    top = vertical;
                                }
                                start = i7 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z8 = i9 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier4 = companion;
                                    overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0);
                                } else {
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    modifier4 = companion;
                                }
                                lazyGridState4 = lazyGridStateRememberLazyGridState;
                                paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                vertical3 = top;
                                flingBehavior4 = flingBehavior3;
                                z6 = z3;
                                z7 = z8;
                                i11 = -2072102870;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                vertical3 = vertical;
                                flingBehavior4 = flingBehavior;
                                z7 = z2;
                                overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                lazyGridState4 = lazyGridState2;
                                paddingValues4 = paddingValues2;
                                z6 = z3;
                                start = horizontal2;
                                i11 = -2072102870;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i11, i4, i10, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
                            }
                            int i14 = i4 >> 3;
                            composer2 = composerStartRestartGroup;
                            Arrangement.Horizontal horizontal4 = start;
                            LazyGridKt.LazyGrid(modifier4, lazyGridState4, rememberColumnWidthSums(gridCells, start, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112)), paddingValues4, z6, true, flingBehavior4, z7, overscrollEffectRememberOverscrollEffect, vertical3, horizontal4, function1, composer2, (i14 & 234881024) | (i14 & 14) | i8 | (i14 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i14) | (29360128 & i14) | ((i4 << 12) & 1879048192), ((i4 >> 18) & 14) | ((i10 << 3) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            lazyGridState3 = lazyGridState4;
                            paddingValues3 = paddingValues4;
                            z5 = z6;
                            flingBehavior2 = flingBehavior4;
                            z4 = z7;
                            overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                            vertical2 = vertical3;
                            horizontal3 = horizontal4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical2 = vertical;
                            z4 = z2;
                            modifier3 = modifier2;
                            lazyGridState3 = lazyGridState2;
                            paddingValues3 = paddingValues2;
                            z5 = z3;
                            horizontal3 = horizontal2;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LazyGridDslKt.LazyVerticalGrid$lambda$0(gridCells, modifier3, lazyGridState3, paddingValues3, z5, vertical2, horizontal3, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    i8 = 196608;
                    horizontal2 = horizontal;
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                }
                i8 = 196608;
                horizontal2 = horizontal;
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            i8 = 196608;
            horizontal2 = horizontal;
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        i8 = 196608;
        horizontal2 = horizontal;
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyGridState lazyGridStateRememberLazyGridState;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i6;
        Arrangement.Horizontal horizontal2;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyGridState lazyGridState3;
        PaddingValues paddingValues4;
        Arrangement.Vertical vertical4;
        Arrangement.Horizontal horizontal4;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,content)121@5397L26,111@5001L456:LazyGridDsl.kt#7791vq");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                    int i11 = composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState) ? 256 : 128;
                    i3 |= i11;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                i3 |= i11;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            int i12 = composerStartRestartGroup.changed(vertical2) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            vertical2 = vertical;
                        }
                        i3 |= i12;
                    } else {
                        vertical2 = vertical;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else {
                        if ((1572864 & i) == 0) {
                            horizontal2 = horizontal;
                            i3 |= composerStartRestartGroup.changed(horizontal2) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i7 = i2 & 256;
                        if (i7 == 0) {
                            if ((i & 100663296) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                flingBehavior2 = flingBehavior;
                                lazyGridState2 = lazyGridStateRememberLazyGridState;
                                paddingValues3 = paddingValues2;
                                z4 = z3;
                                vertical3 = vertical2;
                                horizontal3 = horizontal2;
                                z5 = z2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "101@4538L23,107@4898L15");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                        i3 &= -897;
                                    }
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        top = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                        i3 &= -458753;
                                    } else {
                                        top = vertical2;
                                    }
                                    Arrangement.Horizontal start = i6 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                                    if ((i2 & 128) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    if (i8 != 0) {
                                        modifier3 = companion;
                                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                                        paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                        horizontal4 = start;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        i9 = 1485410512;
                                        vertical4 = top;
                                    } else {
                                        z6 = z2;
                                        modifier3 = companion;
                                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                                        paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                                        vertical4 = top;
                                        horizontal4 = start;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        i9 = 1485410512;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    modifier3 = modifier;
                                    flingBehavior4 = flingBehavior;
                                    z6 = z2;
                                    paddingValues4 = paddingValues2;
                                    z7 = z3;
                                    vertical4 = vertical2;
                                    horizontal4 = horizontal2;
                                    i9 = 1485410512;
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
                                }
                                composer2 = composerStartRestartGroup;
                                LazyVerticalGrid(gridCells, modifier3, lazyGridState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyGridState2 = lazyGridState3;
                                paddingValues3 = paddingValues4;
                                z4 = z7;
                                vertical3 = vertical4;
                                horizontal3 = horizontal4;
                                flingBehavior2 = flingBehavior4;
                                z5 = z6;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return LazyGridDslKt.LazyVerticalGrid$lambda$1(gridCells, modifier2, lazyGridState2, paddingValues3, z4, vertical3, horizontal3, flingBehavior2, z5, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i8 = i7;
                        if ((i & 805306368) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    horizontal2 = horizontal;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    if ((i & 805306368) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                horizontal2 = horizontal;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i & 805306368) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            horizontal2 = horizontal;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i & 805306368) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        horizontal2 = horizontal;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i & 805306368) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit LazyVerticalGrid$lambda$0(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyVerticalGrid(gridCells, modifier, lazyGridState, paddingValues, z, vertical, horizontal, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit LazyVerticalGrid$lambda$1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyVerticalGrid(gridCells, modifier, lazyGridState, paddingValues, z, vertical, horizontal, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(list.size(), function1 != null ? new AnonymousClass2(function1, list) : null, function2 != null ? new AnonymousClass3(function2, list) : null, new AnonymousClass4(function12, list), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(tArr.length, function1 != null ? new AnonymousClass7(function1, tArr) : null, function2 != null ? new AnonymousClass8(function2, tArr) : null, new AnonymousClass9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(function4, tArr)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        lazyGridScope.items(list.size(), function1 != null ? new AnonymousClass2(function1, list) : null, function2 != null ? new AnonymousClass3(function2, list) : null, new AnonymousClass4(function12, list), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        lazyGridScope.items(objArr.length, function1 != null ? new AnonymousClass7(function1, objArr) : null, function2 != null ? new AnonymousClass8(function2, objArr) : null, new AnonymousClass9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(function4, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(list.size(), function2 != null ? new C03702(function2, list) : null, function3 != null ? new C03713(function3, list) : null, new C03724(function22, list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C03735(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(tArr.length, function2 != null ? new C03757(function2, tArr) : null, function3 != null ? new C03768(function3, tArr) : null, new C03779(function22, tArr), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C036910(function5, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
        }
        lazyGridScope.items(list.size(), function2 != null ? new C03702(function2, list) : null, function3 != null ? new C03713(function3, list) : null, new C03724(function22, list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C03735(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
        }
        lazyGridScope.items(objArr.length, function2 != null ? new C03757(function2, objArr) : null, function3 != null ? new C03768(function3, objArr) : null, new C03779(function22, objArr), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C036910(function5, objArr)));
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -76500289, "C(rememberColumnWidthSums)N(columns,horizontalArrangement)221@9599L849:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-76500289, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -502329264, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32);
        GridSlotCache gridSlotCacheRememberedValue = composer.rememberedValue();
        if (z || gridSlotCacheRememberedValue == Composer.INSTANCE.getEmpty()) {
            gridSlotCacheRememberedValue = new GridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyGridDslKt.rememberColumnWidthSums$lambda$0$0(gridCells, horizontal, (Density) obj, (Constraints) obj2);
                }
            });
            composer.updateRememberedValue(gridSlotCacheRememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) gridSlotCacheRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridSlots rememberColumnWidthSums$lambda$0$0(GridCells gridCells, Arrangement.Horizontal horizontal, Density density, Constraints constraints) {
        if (!(Constraints.m9067getMaxWidthimpl(constraints.getValue()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
        }
        int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(constraints.getValue());
        int[] intArray = CollectionsKt.toIntArray(gridCells.calculateCrossAxisCellSizes(density, iM9067getMaxWidthimpl, density.mo1618roundToPx0680j_4(horizontal.getSpacing())));
        int[] iArr = new int[intArray.length];
        horizontal.arrange(density, iM9067getMaxWidthimpl, intArray, LayoutDirection.Ltr, iArr);
        return new LazyGridSlots(intArray, iArr);
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -150818144, "C(rememberRowHeightSums)N(rows,verticalArrangement)245@10605L772:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-150818144, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:245)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1092655396, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32);
        GridSlotCache gridSlotCacheRememberedValue = composer.rememberedValue();
        if (z || gridSlotCacheRememberedValue == Composer.INSTANCE.getEmpty()) {
            gridSlotCacheRememberedValue = new GridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyGridDslKt.rememberRowHeightSums$lambda$0$0(gridCells, vertical, (Density) obj, (Constraints) obj2);
                }
            });
            composer.updateRememberedValue(gridSlotCacheRememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) gridSlotCacheRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridSlots rememberRowHeightSums$lambda$0$0(GridCells gridCells, Arrangement.Vertical vertical, Density density, Constraints constraints) {
        if (!(Constraints.m9066getMaxHeightimpl(constraints.getValue()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
        }
        int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(constraints.getValue());
        int[] intArray = CollectionsKt.toIntArray(gridCells.calculateCrossAxisCellSizes(density, iM9066getMaxHeightimpl, density.mo1618roundToPx0680j_4(vertical.getSpacing())));
        int[] iArr = new int[intArray.length];
        vertical.arrange(density, iM9066getMaxHeightimpl, intArray, iArr);
        return new LazyGridSlots(intArray, iArr);
    }
}
