package androidx.compose.foundation.pager;

import android.os.Trace;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PagerMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\"\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002\u001a\u0017\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0003H\u0082\b\"\u000e\u0010&\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"rememberPagerMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "cacheWindowLogic", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visiblePagesList", "", "Landroidx/compose/foundation/pager/PageInfo;", "DebugEnabled", "debugLog", "generateMsg", "", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasurePolicyKt {
    private static final boolean DebugEnabled = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(LazyLayoutMeasureScope lazyLayoutMeasureScope, CacheWindowLogic cacheWindowLogic, List<? extends PageInfo> list) {
        Trace.beginSection("compose:pager:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                int index = ((PageInfo) CollectionsKt.first((List) list)).getIndex();
                int index2 = ((PageInfo) CollectionsKt.last((List) list)).getIndex();
                for (int prefetchWindowStartLine = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine < index; prefetchWindowStartLine++) {
                    lazyLayoutMeasureScope.compose(prefetchWindowStartLine);
                }
                int i = index2 + 1;
                int prefetchWindowEndLine = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine) {
                    while (true) {
                        lazyLayoutMeasureScope.compose(i);
                        if (i == prefetchWindowEndLine) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0145 A[PHI: r3
      0x0145: PHI (r3v22 int) = (r3v20 int), (r3v23 int) binds: [B:102:0x0143, B:98:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[PHI: r4
      0x00a1: PHI (r4v25 androidx.compose.ui.Alignment$Horizontal) = (r4v23 androidx.compose.ui.Alignment$Horizontal), (r4v26 androidx.compose.ui.Alignment$Horizontal) binds: [B:44:0x009f, B:40:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd A[PHI: r9
      0x00bd: PHI (r9v13 androidx.compose.ui.Alignment$Vertical) = (r9v10 androidx.compose.ui.Alignment$Vertical), (r9v14 androidx.compose.ui.Alignment$Vertical) binds: [B:54:0x00bb, B:50:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9 A[PHI: r12
      0x00d9: PHI (r12v11 float) = (r12v9 float), (r12v12 float) binds: [B:64:0x00d7, B:60:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5 A[PHI: r13
      0x00f5: PHI (r13v11 androidx.compose.foundation.pager.PageSize) = (r13v9 androidx.compose.foundation.pager.PageSize), (r13v12 androidx.compose.foundation.pager.PageSize) binds: [B:74:0x00f3, B:70:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010f A[PHI: r14
      0x010f: PHI (r14v11 androidx.compose.foundation.gestures.snapping.SnapPosition) = 
      (r14v8 androidx.compose.foundation.gestures.snapping.SnapPosition)
      (r14v12 androidx.compose.foundation.gestures.snapping.SnapPosition)
     binds: [B:84:0x010d, B:80:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0133  */
    /* JADX INFO: renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyLayoutMeasurePolicy m2298rememberPagerMeasurePolicy8u0NR3k(Function0<PagerLazyLayoutItemProvider> function0, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, int i, float f, PageSize pageSize, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, CoroutineScope coroutineScope, Function0<Integer> function02, Composer composer, int i2, int i3) {
        Alignment.Horizontal horizontal2;
        boolean z2;
        Alignment.Vertical vertical2;
        boolean z3;
        float f2;
        boolean z4;
        PageSize pageSize2;
        boolean z5;
        SnapPosition snapPosition2;
        boolean z6;
        int i4;
        boolean z7;
        boolean zChanged;
        PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1294131537, "C(rememberPagerMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,orientation,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,horizontalAlignment,verticalAlignment,snapPosition,coroutineScope,pageCount)61@2523L7806:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1294131537, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:61)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1880131949, "CC(remember):PagerMeasurePolicy.kt#9igjgp");
        boolean z8 = ((((i2 & 112) ^ 48) > 32 && composer.changed(pagerState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(orientation.ordinal())) || (i2 & 24576) == 16384);
        if (((234881024 & i2) ^ 100663296) > 67108864) {
            horizontal2 = horizontal;
            if (composer.changed(horizontal2)) {
                z2 = true;
            }
            boolean z9 = z8 | z2;
            if (((1879048192 & i2) ^ 805306368) <= 536870912) {
                vertical2 = vertical;
                if (composer.changed(vertical2)) {
                    z3 = true;
                }
                boolean z10 = z9 | z3;
                if (((3670016 & i2) ^ 1572864) > 1048576) {
                    f2 = f;
                    if (composer.changed(f2)) {
                        z4 = true;
                    }
                    boolean z11 = z10 | z4;
                    if (((29360128 & i2) ^ 12582912) <= 8388608) {
                        pageSize2 = pageSize;
                        if (composer.changed(pageSize2)) {
                            z5 = true;
                        }
                        boolean z12 = z11 | z5;
                        if (((i3 & 14) ^ 6) > 4) {
                            snapPosition2 = snapPosition;
                            if (composer.changed(snapPosition2)) {
                                z6 = true;
                            }
                            boolean z13 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z12 | z6;
                            if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
                                i4 = i;
                                if (composer.changed(i4)) {
                                    z7 = true;
                                }
                                zChanged = z13 | z7 | composer.changed(coroutineScope);
                                pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                                if (zChanged || pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f2, pageSize2, function0, function02, vertical2, horizontal2, i4, snapPosition2, coroutineScope);
                                    composer.updateRememberedValue(pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue);
                                }
                                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                return lazyLayoutMeasurePolicy;
                            }
                            i4 = i;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
                                z7 = false;
                            }
                            zChanged = z13 | z7 | composer.changed(coroutineScope);
                            pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                            if (zChanged) {
                                pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f2, pageSize2, function0, function02, vertical2, horizontal2, i4, snapPosition2, coroutineScope);
                                composer.updateRememberedValue(pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue);
                            }
                            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            return lazyLayoutMeasurePolicy2;
                        }
                        snapPosition2 = snapPosition;
                        if ((i3 & 6) != 4) {
                            z6 = false;
                        }
                        boolean z132 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z12 | z6;
                        if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
                        }
                        zChanged = z132 | z7 | composer.changed(coroutineScope);
                        pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                        if (zChanged) {
                        }
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return lazyLayoutMeasurePolicy22;
                    }
                    pageSize2 = pageSize;
                    if ((12582912 & i2) == 8388608) {
                        z5 = false;
                    }
                    boolean z122 = z11 | z5;
                    if (((i3 & 14) ^ 6) > 4) {
                    }
                    if ((i3 & 6) != 4) {
                    }
                    boolean z1322 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z122 | z6;
                    if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
                    }
                    zChanged = z1322 | z7 | composer.changed(coroutineScope);
                    pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                    if (zChanged) {
                    }
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return lazyLayoutMeasurePolicy222;
                }
                f2 = f;
                if ((1572864 & i2) != 1048576) {
                    z4 = false;
                }
                boolean z112 = z10 | z4;
                if (((29360128 & i2) ^ 12582912) <= 8388608) {
                }
                if ((12582912 & i2) == 8388608) {
                }
                boolean z1222 = z112 | z5;
                if (((i3 & 14) ^ 6) > 4) {
                }
                if ((i3 & 6) != 4) {
                }
                boolean z13222 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z1222 | z6;
                if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
                }
                zChanged = z13222 | z7 | composer.changed(coroutineScope);
                pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                if (zChanged) {
                }
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2222 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return lazyLayoutMeasurePolicy2222;
            }
            vertical2 = vertical;
            if ((805306368 & i2) == 536870912) {
                z3 = false;
            }
            boolean z102 = z9 | z3;
            if (((3670016 & i2) ^ 1572864) > 1048576) {
            }
            if ((1572864 & i2) != 1048576) {
            }
            boolean z1122 = z102 | z4;
            if (((29360128 & i2) ^ 12582912) <= 8388608) {
            }
            if ((12582912 & i2) == 8388608) {
            }
            boolean z12222 = z1122 | z5;
            if (((i3 & 14) ^ 6) > 4) {
            }
            if ((i3 & 6) != 4) {
            }
            boolean z132222 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z12222 | z6;
            if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
            }
            zChanged = z132222 | z7 | composer.changed(coroutineScope);
            pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
            if (zChanged) {
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22222 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy22222;
        }
        horizontal2 = horizontal;
        if ((100663296 & i2) != 67108864) {
            z2 = false;
        }
        boolean z92 = z8 | z2;
        if (((1879048192 & i2) ^ 805306368) <= 536870912) {
        }
        if ((805306368 & i2) == 536870912) {
        }
        boolean z1022 = z92 | z3;
        if (((3670016 & i2) ^ 1572864) > 1048576) {
        }
        if ((1572864 & i2) != 1048576) {
        }
        boolean z11222 = z1022 | z4;
        if (((29360128 & i2) ^ 12582912) <= 8388608) {
        }
        if ((12582912 & i2) == 8388608) {
        }
        boolean z122222 = z11222 | z5;
        if (((i3 & 14) ^ 6) > 4) {
        }
        if ((i3 & 6) != 4) {
        }
        boolean z1322222 = ((((i3 & 896) ^ 384) <= 256 && composer.changed(function02)) || (i3 & 384) == 256) | z122222 | z6;
        if (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) {
        }
        zChanged = z1322222 | z7 | composer.changed(coroutineScope);
        pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
        if (zChanged) {
        }
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222222 = (LazyLayoutMeasurePolicy) pagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy222222;
    }
}
