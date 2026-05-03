package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001aë\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b'\u0010(\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b)\u0010*\u001aë\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b.\u0010/\u001aß\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b0\u00101\u001aL\u00102\u001a\u00020\u000b*\u00020\u001e2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bH\u0000\u001a,\u0010;\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0017\u0010?\u001a\u00020\u00012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0082\b¨\u0006C"}, d2 = {"HorizontalPager", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0128  */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX INFO: renamed from: HorizontalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2291HorizontalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        float f2;
        int i11;
        Alignment.Vertical centerVertically;
        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer composer2;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final ?? r10;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapPosition snapPosition2;
        final float f3;
        final Modifier modifier3;
        final Alignment.Vertical vertical2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PagerState pagerState2;
        int i22;
        int i23;
        int i24;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        int i25;
        Function1<? super Integer, ? extends Object> function13;
        NestedScrollConnection nestedScrollConnection3;
        int i26;
        PaddingValues paddingValues3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z4;
        int i27;
        float f4;
        int i28;
        ?? r3;
        SnapPosition snapPosition3;
        Modifier modifier4;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Composer composerStartRestartGroup = composer.startRestartGroup(1860873769);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)131@7501L707:Pager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i29 = i4 & 2;
        if (i29 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i7 = i4 & 8;
                int i30 = 1024;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(pageSize) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            centerVertically = vertical;
                        } else {
                            centerVertically = vertical;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(centerVertically) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                                int i31 = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior) ? 8388608 : 4194304;
                                i5 |= i31;
                            } else {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                            }
                            i5 |= i31;
                        } else {
                            targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            i17 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i18 = i16;
                        }
                        int i32 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                            i20 = i32;
                            if ((i3 & 384) == 0) {
                                i20 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            if ((i3 & 3072) == 0) {
                                if ((i4 & 8192) == 0 && composerStartRestartGroup.changed(overscrollEffect)) {
                                    i30 = 2048;
                                }
                                i20 |= i30;
                            }
                            if ((i3 & 24576) == 0) {
                                i20 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
                            }
                            i21 = i20;
                            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                r10 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                snapPosition2 = snapPosition;
                                f3 = f2;
                                modifier3 = modifier2;
                                vertical2 = centerVertically;
                                targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                overscrollEffect2 = overscrollEffect;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "121@7026L28,126@7250L57,128@7404L26");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i29 != 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
                                    PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    int i33 = i8 != 0 ? 0 : i9;
                                    float fM9114constructorimpl = i10 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                    if (i11 != 0) {
                                        centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    }
                                    if ((i4 & 128) != 0) {
                                        PagerDefaults pagerDefaults = PagerDefaults.INSTANCE;
                                        int i34 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        i23 = i19;
                                        i24 = i21;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i22 = 0;
                                        targetedFlingBehaviorFlingBehavior = pagerDefaults.flingBehavior(pagerState2, null, null, null, 0.0f, composerStartRestartGroup, i34, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i22 = 0;
                                        i23 = i19;
                                        i24 = i21;
                                    }
                                    boolean z5 = i12 == 0 ? z : true;
                                    ?? r0 = i14 != 0 ? i22 : z2;
                                    Function1<? super Integer, ? extends Object> function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal, composerStartRestartGroup, (i15 & 14) | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL);
                                        i25 = i24 & (-113);
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                        i25 = i24;
                                    }
                                    SnapPosition.Start start = i23 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                    if ((i4 & 8192) != 0) {
                                        SnapPosition snapPosition4 = start;
                                        overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, i22);
                                        i26 = i25 & (-7169);
                                        targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                        snapPosition3 = snapPosition4;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        composer2 = composerStartRestartGroup;
                                        paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                        pageSize3 = pageSize4;
                                        z4 = z5;
                                        i27 = i33;
                                        f4 = fM9114constructorimpl;
                                        i28 = i15;
                                        r3 = r0;
                                        modifier4 = modifier5;
                                    } else {
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        i26 = i25;
                                        composer2 = composerStartRestartGroup;
                                        paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                        targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                        pageSize3 = pageSize4;
                                        z4 = z5;
                                        i27 = i33;
                                        f4 = fM9114constructorimpl;
                                        i28 = i15;
                                        r3 = r0;
                                        snapPosition3 = start;
                                        modifier4 = modifier5;
                                        overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i21 &= -113;
                                    }
                                    if ((i4 & 8192) != 0) {
                                        i21 &= -7169;
                                    }
                                    pageSize3 = pageSize;
                                    r3 = z2;
                                    function13 = function1;
                                    nestedScrollConnection3 = nestedScrollConnection;
                                    i26 = i21;
                                    composer2 = composerStartRestartGroup;
                                    f4 = f2;
                                    modifier4 = modifier2;
                                    i28 = i15;
                                    paddingValues3 = paddingValues;
                                    z4 = z;
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    i27 = i9;
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    snapPosition3 = snapPosition;
                                }
                                composer2.endDefaults();
                                Modifier modifier6 = modifier4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1860873769, i28, i26, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:130)");
                                }
                                int i35 = i26;
                                int i36 = i28 >> 6;
                                int i37 = i28 << 12;
                                int i38 = ((i28 >> 3) & 14) | 24576 | ((i28 << 3) & 112) | (i28 & 896) | ((i28 >> 18) & 7168) | (i36 & 458752) | (i36 & 3670016) | ((i35 << 12) & 29360128) | (i37 & 234881024) | (i37 & 1879048192);
                                int i39 = ((i28 >> 9) & 14) | 3072 | (i35 & 112);
                                int i40 = i35 << 6;
                                LazyLayoutPagerKt.m2286PagereLwUrMk(modifier6, pagerState, paddingValues3, r3, Orientation.Horizontal, targetedFlingBehavior3, z4, overscrollEffectRememberOverscrollEffect, i27, f4, pageSize3, nestedScrollConnection3, function13, Alignment.INSTANCE.getCenterHorizontally(), centerVertically, snapPosition3, function4, composer2, i38, i39 | (i40 & 896) | (i36 & 57344) | ((i35 << 9) & 458752) | (i40 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                int i41 = i27;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                i9 = i41;
                                float f5 = f4;
                                z3 = z4;
                                f3 = f5;
                                Alignment.Vertical vertical3 = centerVertically;
                                overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                                vertical2 = vertical3;
                                Function1<? super Integer, ? extends Object> function15 = function13;
                                nestedScrollConnection2 = nestedScrollConnection3;
                                function12 = function15;
                                pageSize2 = pageSize3;
                                snapPosition2 = snapPosition3;
                                r10 = r3;
                                paddingValues2 = paddingValues3;
                                modifier3 = modifier6;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PagerKt.HorizontalPager__8jOkeI$lambda$0(pagerState, modifier3, paddingValues2, pageSize2, i9, f3, vertical2, targetedFlingBehavior2, z3, r10, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i20 = i32 | 384;
                        if ((i3 & 3072) == 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i21 = i20;
                        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i322 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i21 = i20;
                    if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i3222 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i21 = i20;
                if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            int i302 = 1024;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i32222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i21 = i20;
            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3022 = 1024;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i322222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i21 = i20;
        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0124  */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2292HorizontalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        final float f2;
        int i11;
        Alignment.Vertical centerVertically;
        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final ?? r10;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier3;
        final Alignment.Vertical vertical2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final SnapPosition snapPosition2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i22;
        PagerState pagerState2;
        int i23;
        Composer composer2;
        int i24;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        SnapPosition snapPosition3;
        ?? r9;
        Function1 function13;
        NestedScrollConnection nestedScrollConnection3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z4;
        float f3;
        PaddingValues paddingValues3;
        int i25;
        ?? r92;
        Composer composerStartRestartGroup = composer.startRestartGroup(1163833967);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)185@9669L26,171@9116L621:Pager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i26 = i4 & 2;
        if (i26 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(pageSize) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            centerVertically = vertical;
                        } else {
                            centerVertically = vertical;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(centerVertically) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                                int i27 = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior) ? 8388608 : 4194304;
                                i5 |= i27;
                            } else {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                            }
                            i5 |= i27;
                        } else {
                            targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            i17 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i18 = i16;
                        }
                        int i28 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                            i20 = i28;
                            if ((i3 & 384) == 0) {
                                i20 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            if ((i3 & 3072) == 0) {
                                i20 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            }
                            i21 = i20;
                            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                r10 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                modifier3 = modifier2;
                                vertical2 = centerVertically;
                                targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                snapPosition2 = snapPosition;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "162@8711L28,167@8935L57");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    modifier4 = i26 != 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
                                    PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    i22 = i8 != 0 ? 0 : i9;
                                    float fM9114constructorimpl = i10 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                    if (i11 != 0) {
                                        centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    }
                                    if ((i4 & 128) != 0) {
                                        PagerDefaults pagerDefaults = PagerDefaults.INSTANCE;
                                        int i29 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i21;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i23 = 0;
                                        targetedFlingBehaviorFlingBehavior = pagerDefaults.flingBehavior(pagerState2, null, null, null, 0.0f, composer2, i29, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i23 = 0;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i21;
                                    }
                                    boolean z5 = i12 == 0 ? z : true;
                                    ?? r0 = i14 != 0 ? i23 : z2;
                                    Function1 function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal, composer2, (i15 & 14) | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL);
                                        i24 &= -113;
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                    }
                                    if (i19 != 0) {
                                        r9 = r0;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        snapPosition3 = SnapPosition.Start.INSTANCE;
                                    } else {
                                        snapPosition3 = snapPosition;
                                        r9 = r0;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                    }
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    pageSize3 = pageSize4;
                                    z4 = z5;
                                    f3 = fM9114constructorimpl;
                                    paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                    i25 = i15;
                                    r92 = r9;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i21 &= -113;
                                    }
                                    pagerState2 = pagerState;
                                    z4 = z;
                                    r92 = z2;
                                    function13 = function1;
                                    nestedScrollConnection3 = nestedScrollConnection;
                                    snapPosition3 = snapPosition;
                                    i23 = 0;
                                    i22 = i9;
                                    f3 = f2;
                                    modifier4 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    composer2 = composerStartRestartGroup;
                                    i25 = i15;
                                    pageSize3 = pageSize;
                                    i24 = i21;
                                    paddingValues3 = paddingValues;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1163833967, i25, i24, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:170)");
                                    i23 = 0;
                                }
                                OverscrollEffect overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composer2, i23);
                                int i30 = i25 & 2147483646;
                                int i31 = (i24 & 1022) | ((i24 << 3) & 57344);
                                PagerState pagerState3 = pagerState2;
                                composerStartRestartGroup = composer2;
                                Alignment.Vertical vertical3 = centerVertically;
                                Modifier modifier5 = modifier4;
                                int i32 = i22;
                                m2291HorizontalPager8jOkeI(pagerState3, modifier5, paddingValues3, pageSize3, i32, f3, vertical3, targetedFlingBehavior3, z4, r92, function13, nestedScrollConnection3, snapPosition3, overscrollEffectRememberOverscrollEffect, function4, composerStartRestartGroup, i30, i31, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                snapPosition2 = snapPosition3;
                                nestedScrollConnection2 = nestedScrollConnection3;
                                function12 = function13;
                                r10 = r92;
                                z3 = z4;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                vertical2 = vertical3;
                                f2 = f3;
                                i9 = i32;
                                pageSize2 = pageSize3;
                                paddingValues2 = paddingValues3;
                                modifier3 = modifier5;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PagerKt.HorizontalPager_oI3XNZo$lambda$0(pagerState, modifier3, paddingValues2, pageSize2, i9, f2, vertical2, targetedFlingBehavior2, z3, r10, function12, nestedScrollConnection2, snapPosition2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i20 = i28 | 384;
                        if ((i3 & 3072) == 0) {
                        }
                        i21 = i20;
                        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i282 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    i21 = i20;
                    if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i2822 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                i21 = i20;
                if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i28222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            i21 = i20;
            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
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
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i282222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        i21 = i20;
        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit HorizontalPager__8jOkeI$lambda$0(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m2291HorizontalPager8jOkeI(pagerState, modifier, paddingValues, pageSize, i, f, vertical, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, overscrollEffect, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalPager_oI3XNZo$lambda$0(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m2292HorizontalPageroI3XNZo(pagerState, modifier, paddingValues, pageSize, i, f, vertical, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0128  */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX INFO: renamed from: VerticalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2293VerticalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        float f2;
        int i11;
        Alignment.Horizontal centerHorizontally;
        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer composer2;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final ?? r10;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapPosition snapPosition2;
        final float f3;
        final Modifier modifier3;
        final Alignment.Horizontal horizontal2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PagerState pagerState2;
        int i22;
        int i23;
        int i24;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        int i25;
        Function1<? super Integer, ? extends Object> function13;
        NestedScrollConnection nestedScrollConnection3;
        int i26;
        PaddingValues paddingValues3;
        Alignment.Horizontal horizontal3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z4;
        int i27;
        float f4;
        int i28;
        ?? r3;
        SnapPosition snapPosition3;
        Modifier modifier4;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1590376023);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)261@14430L705:Pager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i29 = i4 & 2;
        if (i29 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i7 = i4 & 8;
                int i30 = 1024;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(pageSize) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            centerHorizontally = horizontal;
                        } else {
                            centerHorizontally = horizontal;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(centerHorizontally) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                                int i31 = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior) ? 8388608 : 4194304;
                                i5 |= i31;
                            } else {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                            }
                            i5 |= i31;
                        } else {
                            targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            i17 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i18 = i16;
                        }
                        int i32 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                            i20 = i32;
                            if ((i3 & 384) == 0) {
                                i20 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            if ((i3 & 3072) == 0) {
                                if ((i4 & 8192) == 0 && composerStartRestartGroup.changed(overscrollEffect)) {
                                    i30 = 2048;
                                }
                                i20 |= i30;
                            }
                            if ((i3 & 24576) == 0) {
                                i20 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
                            }
                            i21 = i20;
                            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                r10 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                snapPosition2 = snapPosition;
                                f3 = f2;
                                modifier3 = modifier2;
                                horizontal2 = centerHorizontally;
                                targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                overscrollEffect2 = overscrollEffect;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "251@13957L28,256@14181L55,258@14333L26");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i29 != 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
                                    PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    int i33 = i8 != 0 ? 0 : i9;
                                    float fM9114constructorimpl = i10 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                    if (i11 != 0) {
                                        centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    }
                                    if ((i4 & 128) != 0) {
                                        PagerDefaults pagerDefaults = PagerDefaults.INSTANCE;
                                        int i34 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        i23 = i19;
                                        i24 = i21;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i22 = 0;
                                        targetedFlingBehaviorFlingBehavior = pagerDefaults.flingBehavior(pagerState2, null, null, null, 0.0f, composerStartRestartGroup, i34, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i22 = 0;
                                        i23 = i19;
                                        i24 = i21;
                                    }
                                    boolean z5 = i12 == 0 ? z : true;
                                    ?? r0 = i14 != 0 ? i22 : z2;
                                    Function1<? super Integer, ? extends Object> function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical, composerStartRestartGroup, (i15 & 14) | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL);
                                        i25 = i24 & (-113);
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                        i25 = i24;
                                    }
                                    SnapPosition.Start start = i23 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                    if ((i4 & 8192) != 0) {
                                        SnapPosition snapPosition4 = start;
                                        overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, i22);
                                        i26 = i25 & (-7169);
                                        targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                        snapPosition3 = snapPosition4;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        composer2 = composerStartRestartGroup;
                                        paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                        horizontal3 = centerHorizontally;
                                        pageSize3 = pageSize4;
                                        z4 = z5;
                                        i27 = i33;
                                        f4 = fM9114constructorimpl;
                                        i28 = i15;
                                        r3 = r0;
                                        modifier4 = modifier5;
                                    } else {
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        i26 = i25;
                                        composer2 = composerStartRestartGroup;
                                        paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                        horizontal3 = centerHorizontally;
                                        targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                        pageSize3 = pageSize4;
                                        z4 = z5;
                                        i27 = i33;
                                        f4 = fM9114constructorimpl;
                                        i28 = i15;
                                        r3 = r0;
                                        snapPosition3 = start;
                                        modifier4 = modifier5;
                                        overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i21 &= -113;
                                    }
                                    if ((i4 & 8192) != 0) {
                                        i21 &= -7169;
                                    }
                                    pageSize3 = pageSize;
                                    r3 = z2;
                                    function13 = function1;
                                    nestedScrollConnection3 = nestedScrollConnection;
                                    i26 = i21;
                                    composer2 = composerStartRestartGroup;
                                    f4 = f2;
                                    modifier4 = modifier2;
                                    horizontal3 = centerHorizontally;
                                    i28 = i15;
                                    paddingValues3 = paddingValues;
                                    z4 = z;
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    i27 = i9;
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    snapPosition3 = snapPosition;
                                }
                                composer2.endDefaults();
                                Modifier modifier6 = modifier4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1590376023, i28, i26, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:260)");
                                }
                                int i35 = i26;
                                int i36 = i28 >> 6;
                                int i37 = ((i28 >> 3) & 14) | 24576 | ((i28 << 3) & 112) | (i28 & 896) | ((i28 >> 18) & 7168) | (i36 & 458752) | (i36 & 3670016) | ((i35 << 12) & 29360128);
                                int i38 = i28 << 12;
                                int i39 = i37 | (i38 & 234881024) | (i38 & 1879048192);
                                int i40 = i28 >> 9;
                                int i41 = i35 << 6;
                                PaddingValues paddingValues4 = paddingValues3;
                                LazyLayoutPagerKt.m2286PagereLwUrMk(modifier6, pagerState, paddingValues4, r3, Orientation.Vertical, targetedFlingBehavior3, z4, overscrollEffectRememberOverscrollEffect, i27, f4, pageSize3, nestedScrollConnection3, function13, horizontal3, Alignment.INSTANCE.getCenterVertically(), snapPosition3, function4, composer2, i39, (i40 & 7168) | (i41 & 896) | (i40 & 14) | 24576 | (i35 & 112) | ((i35 << 9) & 458752) | (i41 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                int i42 = i27;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                i9 = i42;
                                float f5 = f4;
                                z3 = z4;
                                f3 = f5;
                                Function1<? super Integer, ? extends Object> function15 = function13;
                                nestedScrollConnection2 = nestedScrollConnection3;
                                function12 = function15;
                                overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                                pageSize2 = pageSize3;
                                horizontal2 = horizontal3;
                                snapPosition2 = snapPosition3;
                                r10 = r3;
                                paddingValues2 = paddingValues4;
                                modifier3 = modifier6;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PagerKt.VerticalPager__8jOkeI$lambda$0(pagerState, modifier3, paddingValues2, pageSize2, i9, f3, horizontal2, targetedFlingBehavior2, z3, r10, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i20 = i32 | 384;
                        if ((i3 & 3072) == 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i21 = i20;
                        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i322 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i21 = i20;
                    if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i3222 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i21 = i20;
                if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            int i302 = 1024;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i32222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i21 = i20;
            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3022 = 1024;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i322222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i21 = i20;
        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 9363) != 9362, i15 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0124  */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2294VerticalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        final int i9;
        int i10;
        final float f2;
        int i11;
        Alignment.Horizontal centerHorizontally;
        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        final PaddingValues paddingValues2;
        final PageSize pageSize2;
        final boolean z3;
        final ?? r10;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier3;
        final Alignment.Horizontal horizontal2;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final SnapPosition snapPosition2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i22;
        PagerState pagerState2;
        int i23;
        Composer composer2;
        int i24;
        NestedScrollConnection nestedScrollConnectionPageNestedScrollConnection;
        SnapPosition snapPosition3;
        ?? r9;
        Function1 function13;
        NestedScrollConnection nestedScrollConnection3;
        TargetedFlingBehavior targetedFlingBehavior3;
        PageSize pageSize3;
        boolean z4;
        float f3;
        PaddingValues paddingValues3;
        int i25;
        ?? r92;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1474550033);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)315@16600L26,301@16045L623:Pager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i26 = i4 & 2;
        if (i26 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(pageSize) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                            centerHorizontally = horizontal;
                        } else {
                            centerHorizontally = horizontal;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(centerHorizontally) ? 1048576 : 524288;
                            }
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & 128) == 0) {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                                int i27 = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior) ? 8388608 : 4194304;
                                i5 |= i27;
                            } else {
                                targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                            }
                            i5 |= i27;
                        } else {
                            targetedFlingBehaviorFlingBehavior = targetedFlingBehavior;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            i17 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changedInstance(nestedScrollConnection)) ? 32 : 16;
                        } else {
                            i18 = i16;
                        }
                        int i28 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                            i20 = i28;
                            if ((i3 & 384) == 0) {
                                i20 |= composerStartRestartGroup.changed(snapPosition) ? 256 : 128;
                            }
                            if ((i3 & 3072) == 0) {
                                i20 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                            }
                            i21 = i20;
                            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                pageSize2 = pageSize;
                                z3 = z;
                                r10 = z2;
                                function12 = function1;
                                nestedScrollConnection2 = nestedScrollConnection;
                                modifier3 = modifier2;
                                horizontal2 = centerHorizontally;
                                targetedFlingBehavior2 = targetedFlingBehaviorFlingBehavior;
                                snapPosition2 = snapPosition;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "292@15642L28,297@15866L55");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    modifier4 = i26 != 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM2030PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues;
                                    PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    i22 = i8 != 0 ? 0 : i9;
                                    float fM9114constructorimpl = i10 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                    if (i11 != 0) {
                                        centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    }
                                    if ((i4 & 128) != 0) {
                                        PagerDefaults pagerDefaults = PagerDefaults.INSTANCE;
                                        int i29 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i21;
                                        pagerState2 = pagerState;
                                        i15 &= -29360129;
                                        i23 = 0;
                                        targetedFlingBehaviorFlingBehavior = pagerDefaults.flingBehavior(pagerState2, null, null, null, 0.0f, composer2, i29, 30);
                                    } else {
                                        pagerState2 = pagerState;
                                        i23 = 0;
                                        composer2 = composerStartRestartGroup;
                                        i24 = i21;
                                    }
                                    boolean z5 = i12 == 0 ? z : true;
                                    ?? r0 = i14 != 0 ? i23 : z2;
                                    Function1 function14 = i18 != 0 ? null : function1;
                                    if ((i4 & 2048) != 0) {
                                        nestedScrollConnectionPageNestedScrollConnection = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical, composer2, (i15 & 14) | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL);
                                        i24 &= -113;
                                    } else {
                                        nestedScrollConnectionPageNestedScrollConnection = nestedScrollConnection;
                                    }
                                    if (i19 != 0) {
                                        r9 = r0;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                        snapPosition3 = SnapPosition.Start.INSTANCE;
                                    } else {
                                        snapPosition3 = snapPosition;
                                        r9 = r0;
                                        function13 = function14;
                                        nestedScrollConnection3 = nestedScrollConnectionPageNestedScrollConnection;
                                    }
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    pageSize3 = pageSize4;
                                    z4 = z5;
                                    f3 = fM9114constructorimpl;
                                    paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                                    i25 = i15;
                                    r92 = r9;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 128) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i21 &= -113;
                                    }
                                    pagerState2 = pagerState;
                                    z4 = z;
                                    r92 = z2;
                                    function13 = function1;
                                    nestedScrollConnection3 = nestedScrollConnection;
                                    snapPosition3 = snapPosition;
                                    i23 = 0;
                                    i22 = i9;
                                    f3 = f2;
                                    modifier4 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehaviorFlingBehavior;
                                    composer2 = composerStartRestartGroup;
                                    i25 = i15;
                                    pageSize3 = pageSize;
                                    i24 = i21;
                                    paddingValues3 = paddingValues;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1474550033, i25, i24, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:300)");
                                    i23 = 0;
                                }
                                OverscrollEffect overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composer2, i23);
                                int i30 = i25 & 2147483646;
                                int i31 = (i24 & 1022) | ((i24 << 3) & 57344);
                                PagerState pagerState3 = pagerState2;
                                composerStartRestartGroup = composer2;
                                Alignment.Horizontal horizontal3 = centerHorizontally;
                                Modifier modifier5 = modifier4;
                                int i32 = i22;
                                m2293VerticalPager8jOkeI(pagerState3, modifier5, paddingValues3, pageSize3, i32, f3, horizontal3, targetedFlingBehavior3, z4, r92, function13, nestedScrollConnection3, snapPosition3, overscrollEffectRememberOverscrollEffect, function4, composerStartRestartGroup, i30, i31, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                snapPosition2 = snapPosition3;
                                nestedScrollConnection2 = nestedScrollConnection3;
                                function12 = function13;
                                r10 = r92;
                                z3 = z4;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                horizontal2 = horizontal3;
                                f2 = f3;
                                i9 = i32;
                                pageSize2 = pageSize3;
                                paddingValues2 = paddingValues3;
                                modifier3 = modifier5;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PagerKt.VerticalPager_oI3XNZo$lambda$0(pagerState, modifier3, paddingValues2, pageSize2, i9, f2, horizontal2, targetedFlingBehavior2, z3, r10, function12, nestedScrollConnection2, snapPosition2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i20 = i28 | 384;
                        if ((i3 & 3072) == 0) {
                        }
                        i21 = i20;
                        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i282 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    i21 = i20;
                    if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i2822 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                i21 = i20;
                if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i28222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            i21 = i20;
            if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
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
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i282222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        i21 = i20;
        if (composerStartRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i21 & 1171) != 1170, i15 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit VerticalPager__8jOkeI$lambda$0(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m2293VerticalPager8jOkeI(pagerState, modifier, paddingValues, pageSize, i, f, horizontal, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, overscrollEffect, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit VerticalPager_oI3XNZo$lambda$0(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m2294VerticalPageroI3XNZo(pagerState, modifier, paddingValues, pageSize, i, f, horizontal, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7) {
        return MathKt.roundToInt(snapPosition.position(i, i2, i4, i5, i6, i7) - (f * (i2 + i3)));
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z, final CoroutineScope coroutineScope, boolean z2) {
        return z2 ? modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PagerKt.pagerSemantics$lambda$0(z, pagerState, coroutineScope, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null)) : modifier.then(Modifier.INSTANCE);
    }

    static final Unit pagerSemantics$lambda$0(boolean z, final PagerState pagerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (z) {
            SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                }
            }, 1, null);
            SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState, coroutineScope));
                }
            }, 1, null);
        } else {
            SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                }
            }, 1, null);
            SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }
}
